package Drivers;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import java.util.Vector;


import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import polyglot.ast.New;
import polyglot.frontend.VisitorPass;

import Drivers.Setup;
import soot.Body;
import soot.BodyTransformer;
import soot.EntryPoints;
import soot.G;
import soot.Local;
import soot.LongType;
import soot.Modifier;
import soot.Pack;
import soot.PackManager;
import soot.PatchingChain;
import soot.PhaseOptions;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Transform;
import soot.Trap;
import soot.Unit;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.Stmt;
import soot.jimple.StringConstant;
import soot.jimple.ThrowStmt;
import soot.jimple.internal.JReturnStmt;
import soot.jimple.internal.JReturnVoidStmt;
import soot.jimple.internal.RValueBox;
import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;
import soot.options.Options;
import soot.tagkit.Host;
import soot.tagkit.LineNumberTag;
import soot.tagkit.SourceLineNumberTag;
import soot.tagkit.SourceLnPosTag;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.TrapUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.util.Chain;

public class LineNoTester {
	protected static final String injectedMethodName = "sayHello";
	public static RecursiveVisitor rv = null;
	 public static Visitor solidVisitor = null; 
	 


	public static String syncKeyWord = "entermonitor";
	public static BufferedWriter bWriter = null;

	public static void main(String[] args) throws IOException {
		
//String secondClass = "EDU.oswego.cs.dl.util.concurrent.PooledExecutor";
//String secondMethod = "execute";
		//	String argsOfToyW = "-f J -pp -cp . org.apache.commons.logging.LogFactory"; // java.lang.Math
		//  org.exolab.jms.messagemgr.ContextHelper
		// rebind
		String secondClass = "org.w3c.util.CachedThread";//"Drivers.LineNoTester";
		String secondMethod = "waitForRunner";
	//	String secondClass = "org.exolab.jms.net.connector.ManagedConnectionHandle";//"Drivers.LineNoTester";
	//	String secondMethod = "incActiveConnections";
		//Body bbbBody= search4MethodBodyInClass(secondMethod,secondClass);
///home/lpxz/eclipse/workspace/pecan/pecan-transformer/tmp/runtime
	    String argsOfToyW2 = "-f J -pp -cp .:/home/lpxz/eclipse/workspace/pecan/pecan-monitor/pengSootOutput " + secondClass; // java.lang.Math
	 //   String argsOfToyW2 = "-app -f J -pp -cp /home/lpxz/eclipse/workspace/pecan/pecan-monitor/sootOutput " + secondClass; // java.lang.Math
	//	String argsOfToyW = "-f J -pp -cp .:/home/lpxz/jrmc-1.6.0/jre/lib/jsse.jar:/home/lpxz/eclipse/workspace/pecan/pecan-transformer/tmp/runtime " + secondClass; // java.lang.Math
	//	String argsOfToyW = "-f J -pp -cp .:/home/lpxz/jrmc-1.6.0/jre/lib/jsse.jar:/home/lpxz/eclipse/workspace/openjms/bin " + secondClass; // java.lang.Math
		
		String interString = argsOfToyW2;
		String[] finalArgs = interString.split(" ");
        soot.Main.v().processCmdLine(finalArgs);
		Options.v().set_keep_line_number(true);	  
	   
		
		List excludesList= new ArrayList();
		excludesList.add("jrockit.");
		excludesList.add("com.bea.jrockit");
		excludesList.add("sun.");
		Options.v().set_exclude(excludesList);
		PhaseOptions.v().setPhaseOption("jb", "use-original-names:false");
	
		
//	    SootClass secondclass = Scene.v().loadClassAndSupport(secondClass);
//	   
//	    secondclass.setApplicationClass();
	   
	
		SootClass chocalate  =Scene.v().loadClassAndSupport("Drivers.Chocalate");
	  
	    SootClass secondclass = Scene.v().loadClassAndSupport(secondClass);
	    secondclass.setApplicationClass();
	   
	    
	    Scene.v().loadNecessaryClasses();
//	    SootMethod smMethod =secondclass.getMethod("void main(java.lang.String[])");
//	    System.out.println(smMethod.hashCode());
	    List<SootMethod> sms = secondclass.getMethods();
	    List<SootMethod> hit = new ArrayList<SootMethod>();
	    for(SootMethod sm : sms)
	    {
	    	if(sm.getName().equals(secondMethod))
	    	{
	    		hit.add(sm);
	    	}
	    }

	    for(SootMethod sm:hit)
	    {
	    
	    	System.err.println(sm.getSubSignature());
	    	sm.retrieveActiveBody(); 		    	
	    	
	    	if(sm.hasActiveBody())
	    	{
	    		Body bb = sm.getActiveBody();
	    		PatchingChain<Unit> units = bb.getUnits();
	    		
	    	    Iterator<Unit> it =bb.getUnits().iterator();
	    	    System.err.println(bb.toString());
	    	    while (it.hasNext()) {
					Unit unit = (Unit) it.next();
					int lineNO = getLineNum(unit);
					System.out.println(unit + " :" + lineNO);
					if(unit instanceof ThrowStmt)
					{
						boolean decision = dominatedByRet( sm,  units,
								 (ThrowStmt)unit);
						System.out.println("dominated:" + decision);
						
					}
				}		        
	    	}
	    	
	    	//==============
//	    	PackManager.v().runPacks();//1
//			PackManager.v().writeOutput();
		    G.reset();	
	       
	    }    
	}
	 private static boolean dominatedByRet(SootMethod sm, Chain units,
				ThrowStmt throwStmt) {
	    	if(sm.getDeclaringClass().toString().contains("EDU.oswego.cs.dl.util.concurrent.PooledExecutor") &&
	    			sm.getName().contains("run"))
	    	{
	    		System.out.println();
	    	}
	    	// TrapUnitGraph suits you!
	    	TrapUnitGraph ug = new TrapUnitGraph(sm.getActiveBody());
	    //	 Utils.drawDirectedGraphNBody(ug, sm.getActiveBody(), "lpxz");
	    	HashSet<Unit> visited  = new  HashSet<Unit>();
	    	Stack<Unit> stack = new  Stack<Unit>();
	    	stack.push(throwStmt);
	    	visited.add(throwStmt);
	    	while(stack.size()!=0)
	    	{
	    		Unit  top = stack.pop();
	    		List<Unit> childrenChain =ug.getSuccsOf(top);
	    		
	    		for(Unit child : childrenChain)
	    		{
	    			if(!visited.contains(child))
	    			{
	    				visited.add(child);
	    				stack.push(child); 
	    				 if(child instanceof ReturnStmt || child instanceof ReturnVoidStmt
	    						 || child instanceof ThrowStmt)
	    		    	 { 
	    		    		 System.err.println(sm.getDeclaringClass().getName() + " " + sm.getName() + " this one is dominated by ret..");
	    		    		 
	    		    		 return true;
	    		    	 
	    		    	 }
	    			}
	    			else {
						// visited node...
					}
	    		}
	    	}

			return false;
		}

	private static Stmt locateLocalThreadIdStmt(Chain units ) {
		//the format of the existing added one:
		//$r0 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>() :-1
    	//l3 = virtualinvoke $r0.<java.lang.Thread: long getId()>() :-1
    	
		Iterator it =units.iterator();
		while (it.hasNext()) {
			Stmt unit = (Stmt) it.next();
			if(unit.containsInvokeExpr()&& unit.toString().contains("<java.lang.Thread: java.lang.Thread currentThread()>"))
			{	// find possible
				Stmt nextOne =(Stmt) units.getSuccOf(unit);
				if(nextOne.containsInvokeExpr() && nextOne.toString().contains("<java.lang.Thread: long getId()>"))
				{
					// got it
					if(nextOne instanceof AssignStmt)
					{
						Local tid = (Local)((AssignStmt) nextOne).getLeftOp();
						if(tid.getType() instanceof LongType)
						{
							return nextOne;
						}
						else {
							throw new RuntimeException("how can you fail at this place, even" + tid.getType());
						}
					}
				}
					

			}
		}
		
		return null;
	}
	private static int getLineNum(Host h) {
        if (h.hasTag("LineNumberTag")) {
            return ((LineNumberTag) h.getTag("LineNumberTag")).getLineNumber();
        }
        if (h.hasTag("SourceLineNumberTag")) {
            return ((SourceLineNumberTag) h.getTag("SourceLineNumberTag")).getLineNumber();
        }
        if (h.hasTag("SourceLnPosTag")) {
            return ((SourceLnPosTag) h.getTag("SourceLnPosTag")).startLn();
        }
        return -1;
    }
	



	private static SootClass loadClass(String name, boolean main) {
		SootClass c = Scene.v().loadClassAndSupport(name);
		c.setApplicationClass();
		if (main)
			Scene.v().setMainClass(c);
		return c;
	}


	
	public static Body search4MethodBodyInClass(String mName, String className) {
        String argsOfToyW = "-f J -pp -cp .:/home/lpxz/jrmc-1.6.0/jre/lib/jsse.jar " + className; // java.lang.Math
		String interString = argsOfToyW;
		String[] finalArgs = interString.split(" ");
        soot.Main.v().processCmdLine(finalArgs);
        Options.v().set_keep_line_number(true);
        
		List excludesList= new ArrayList();
		excludesList.add("jrockit.");
		excludesList.add("com.bea.jrockit");
		excludesList.add("sun.");
		Options.v().set_exclude(excludesList);
	
		
		Scene.v().loadNecessaryClasses();
	    SootClass secondclass = Scene.v().loadClassAndSupport(className);
	    List<SootMethod> sms = secondclass.getMethods();
	    List<SootMethod> hit = new ArrayList<SootMethod>();
	    for(SootMethod sm : sms)
	    {
	    	if(sm.getName().equals(mName))
	    	{
	    		hit.add(sm);
	    	}
	    }
		

	    if(hit.size() ==1)
	    {	    	
	    	SootMethod hitM = hit.get(0);
	    	if(!hitM.hasActiveBody())
	    	{
	    		try {
	    			hitM.retrieveActiveBody();
				} catch (Exception e) {
					System.out.println(hitM.getDeclaringClass().getName() + " " + hitM.getName());
				}
	    		
	    	}
	    	G.reset();
	    	return hitM.getActiveBody();
	    }
	    else {
	    	G.reset();
			return null;
		}
	}
	

}
