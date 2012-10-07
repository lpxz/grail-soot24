package AVfix.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.jgrapht.graph.DirectedPseudograph;

import soot.Body;
import soot.SootMethod;
import soot.jimple.Stmt;

import edu.hkust.clap.organize.CSMethod;
import edu.hkust.clap.organize.CSMethodPair;
import edu.hkust.clap.organize.SaveLoad;
import edu.hkust.clap.organize.SootAgent;

import AVdetect.edge.abstractclass.CausalEdge;
import AVdetect.eventnode.abstractclass.CriticalEvent;
import AVdetect.manager.MemoryManager;
import AVdetect.manager.ThreadManager;
import AVfix.edge.CallEdge;
import AVfix.edge.LocalEdge;
import AVfix.edge.ReturnEdge;
import AVfix.edge.abstractclass.ControlEdge;
import AVfix.manager.AVfixUtil;
import AVfix.manager.MethodManager;
import AVfix.node.CommonLocalStatement;
import AVfix.node.EntryStatement;
import AVfix.node.ExitStatement;
import AVfix.node.InvokeBeginStatement;
import AVfix.node.InvokeEndStatement;
import AVfix.node.abstractclass.Statement;

public class CSGraph {
	public DirectedPseudograph<Statement, ControlEdge> coreG = null;

	public CSGraph() {
		coreG = new DirectedPseudograph<Statement, ControlEdge>(
				ControlEdge.class);
		
	}
	public static void main(String[] args) {		
        CSGraph csGraph = new CSGraph();
		Object object = SaveLoad.load(SaveLoad.default_filename);
		List list  =(List)object;
		for(Object elem : list)
		{
			CSMethodPair pair = (CSMethodPair)elem;
			CSMethod o1 = pair.getO1();
			CSMethod o2 = pair.getO2();
			o1.printIt();
			csGraph.expandCSCG(o1);
			
			
			o1.printIt();
			csGraph.expandCSCG(o2);			
		}
	}
	

	private  void expandCSCG(CSMethod o1) {
		List<StackTraceElement> stes =o1.getStes();		
		List<StackTraceElement> ctxtStack = new ArrayList<StackTraceElement>();
		Statement invokeNodeInParent= null;
		for(int i=0; i<= stes.size()-1; i++)
		{
			StackTraceElement cur = stes.get(i);
			if(i>=1) // 0 does not have the parent!
			{
				// get the invoke site node
				// CSGraphGen.u2n available now, do not put it after the following "EntryStatement entry =loadOrCreate4Method(cur,ctxtStack);"
				
				String className = cur.getClassName();
				String mName = cur.getMethodName();
				String filename = cur.getFileName();
				int eleLineNO = cur.getLineNumber();
				StackTraceElement secondLast = ctxtStack.get(ctxtStack.size() -1);
				String secondClass = secondLast.getClassName();
				String secondMethod = secondLast.getMethodName();
				Stmt hitCS = AVfixUtil.search4CallSiteStmt(secondClass, secondMethod, className, mName, filename,eleLineNO);	
				invokeNodeInParent =CSGraphGen.u2n.get(hitCS);				
			}
		
			EntryStatement entry =loadOrCreate4Method(cur,ctxtStack);	// this would reset u2n!!
			ExitStatement exit =CSGraphGen.entry2exit.get(entry);
			if(i>=1)
			{
				if(invokeNodeInParent==null) throw new RuntimeException();
				CSGraphGen.remoteIssues(this, (CommonLocalStatement)invokeNodeInParent, entry, exit);				
			}
			ctxtStack.add(cur);// always updating
		}		
	}
	

	// we use the entrystatement to represent the ctxt statement
	private EntryStatement loadOrCreate4Method(StackTraceElement cur, List<StackTraceElement> ctxtStack) {
		String methodName = AVfixUtil.getFullMethodName(cur);
		EntryStatement entryStatement = MethodManager.search4EntryStatement(methodName, ctxtStack);
		if(entryStatement!=null)
		{
			
			return entryStatement;
		}
		else {
			EntryStatement newOne = CSGraphGen.formCSMethodLocally(cur, this, ctxtStack);
			MethodManager.register4EntryMethod(methodName, newOne);			
			return newOne;			
		}		
		
		// remember to update the ctxtstack
	}
	
	

}
