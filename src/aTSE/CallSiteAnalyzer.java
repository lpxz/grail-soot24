package aTSE;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import aTSE.AHG.AHGBuildAnalyzer;
import aTSE.AHG.AHGTraverse;
import aTSE.codeRegion.Criteria;
import aTSE.codeRegion.InterP;
import aTSE.codeRegion.IntraP;

import polyglot.ast.New;
import polyglot.frontend.VisitorPass;

import Drivers.Setup;
import Drivers.Utils;
import soot.Body;
import soot.BodyTransformer;
import soot.EntryPoints;
import soot.G;
import soot.Local;
import soot.Modifier;
import soot.Pack;
import soot.PackManager;
import soot.PatchingChain;
import soot.PhaseOptions;
import soot.PointsToSet;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Transform;
import soot.Unit;
import soot.Value;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.internal.RValueBox;
import soot.jimple.paddle.PaddleContextSensitiveCallGraph;

import soot.jimple.toolkits.pointer.CodeBlockRWSet;
import soot.jimple.toolkits.pointer.RWSet;
import soot.jimple.toolkits.thread.mhp.MhpTransformer;
import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;
import soot.options.Options;
import soot.toolkits.graph.BlockGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.MHGPostDominatorsFinder;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.ZonedBlockGraph;
import soot.toolkits.graph.pdg.EnhancedUnitGraph;
import soot.toolkits.graph.pdg.MHGDominatorTree;
import soot.toolkits.graph.pdg.RegionAnalysis;
import soot.util.Chain;


//new MHGDominatorTree(new MHGPostDominatorsFinder(m_blockCFG));

public class CallSiteAnalyzer {
	
	protected static final boolean DRAW = true;
	protected static final String APIName = "serializeIt";
	public static Map<DirectedGraph, Set>  g2loops = new HashMap<DirectedGraph, Set>();

	

	

	
	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link LockProducer
        String argsOfToy2 = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin Toy2";// soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfToyW = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin ToyBlocks"; // java.lang.Math
		String argsOfJimpleHelloWorld = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfpaddleJar = "-f J -pp -cp /home/lpxz/eclipse/workspace/soot24/paddlePublic/ -process-dir /home/lpxz/eclipse/workspace/soot24/paddlePublic/"; // java.lang.Math
		// do not use the jar directly,
		// unzip it to a folder, and parse the folder like above.
		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar
		String argsOfBayes = "-f J -pp -cp /home/lpxz/eclipse/workspace/sablecc/bin --app org.sablecc.sablecc.SableCC"; // java.lang.Math

		String interString = argsOfBayes;
		String[] finalArgs = interString.split(" ");

		soot.Main.v().processCmdLine(finalArgs);
		
	
		
		List excludesList= new ArrayList();
		excludesList.add("jrockit.");
		excludesList.add("com.bea.jrockit");
		excludesList.add("sun.");
		Options.v().set_exclude(excludesList);
		PhaseOptions.v().setPhaseOption("jb", "use-original-names:true");// does work
		PhaseOptions.v().setPhaseOption("jb.ulp", "enabled:false");//important 
		Setup.setupPatchOptions();
		Scene.v().loadNecessaryClasses();
		
		
		// Setup.setPhaseOptionsForPaddleWork();
		Setup.setPhaseOptionsForSparkWork();	
		 
		//Pack jtp = PackManager.v().getPack("jtp");
		//addgetRegionPackToJtp(jtp);
		Pack wjtp = PackManager.v().getPack("wjtp");
		 addVisitorToWjtp(wjtp);

		PackManager.v().runPacks();// 1
		PackManager.v().writeOutput();
		G.reset();
	}



	private static void addVisitorToWjtp(Pack wjtp) {
wjtp.add(new Transform("wjtp.callchain", new SceneTransformer() {
			
			@Override
			protected void internalTransform(String phaseName, Map options) {
			     
				CSParser.main("/home/lpxz/eclipse/workspace/soot24/src/aTSE/callsitespec1");
				List rawchainList = CSParser.list;
				List  interchainList =raw2Inter(rawchainList);
				List  sootchainList = getSootFromInter(interchainList);
				List<CallSite> chain = (List<CallSite>)  sootchainList.get(0);
				List<CallSite> chain2 = (List<CallSite>)  sootchainList.get(1);
				
			
				Set postSet = post(chain);
				Set preSet = pre(chain2);
				Set betweenSet = between(chain, chain2);
				
				CodeBlockRWSet cwset  = code2dataWRITE(betweenSet);
				Local l = retrieveVar(chain);//
			
				AHGBuildAnalyzer.toBuildG = new DirectedPseudograph<PointsToSet, DefaultEdge>(DefaultEdge.class);			
				AHGBuildAnalyzer.ahgconstruct_root(l);
				
				AHGTraverse.ahgvisit_root(cwset,AHGBuildAnalyzer.toBuildG , AHGBuildAnalyzer.gRootP2S);// please go inside and set the proper analysis
				// generate the graph!
				//NOTE the retrieveVar method is not tested!!!			
				
			}

			private Local retrieveVar(List<CallSite> chain) {
				CallSite cs = chain.get(chain.size()-1);
				Unit rep= cs.rep;
				SootMethod sm  = cs.sm;
				PatchingChain<Unit> units  = sm.getActiveBody().getUnits();
				Iterator<Unit> it = units.iterator(rep);
				while (it.hasNext()) {
					Unit unit = (Unit) it.next();
					Stmt stmt   = (Stmt ) unit ;
					if(stmt.containsInvokeExpr())
					{
						InvokeExpr ie = stmt.getInvokeExpr();
						if(ie.getMethod().getName().contains(APIName))// persistence API-specific
						{
					          Value arg = ie.getArg(0);
					          return (Local ) arg;
					          
						}
					}
					
					
				}
				
				
				return null;
			}




		}));
		
	}



	protected static CodeBlockRWSet code2dataREAD(Set postSet) {
	return 	Code2Data.code2dataREAD(postSet);
		
	}
	
	protected static CodeBlockRWSet code2dataWRITE(Set postSet) {
		return 	Code2Data.code2dataWRITE(postSet);
			
		}



	protected static Set between(List<CallSite> chain1, List<CallSite> chain2) {
	     List<CallSite> common = new  ArrayList<CallSite>();
	     int i=0;
	     while(i< chain1.size()) 
	     {
	    	 CallSite tmp1 =chain1.get(i);
	         CallSite tmp2 = chain2.get(i);
	         if(equiv(tmp1, tmp2))
	         {
	        	 common.add(tmp1);
	         }
	         else {
				break; // no need to continue;
			}
	         i++;
	         
	     }
	     
	     // just at i, the two are different

		 Set toret = new HashSet();
		 toret.addAll(IntraP.betweenSites(chain1.get(i), chain2.get(i)));
		 int  next = i+1; int lastIndex1 = chain1.size() -1;
		 int lastIndex2= chain2.size()-1;
	     List<CallSite> subchain1 = chain1.subList((next>lastIndex1)?lastIndex1:next , chain1.size() -1);//from i+1
	     List<CallSite>  subchain2 = chain2.subList((next>lastIndex2)?lastIndex2:next, lastIndex2); // from i+1
		 toret.addAll(post(subchain1));
		 toret.addAll(pre(subchain2));		 
		 toret = InterP.closure(toret);
		 return toret;
		 	 
	     
	}





	private static boolean equiv(CallSite tmp1, CallSite tmp2) {
		boolean b1 = tmp1.classname.equals(tmp2.classname);
		boolean b2 = tmp1.methodname.equals(tmp2.methodname);
		boolean b3 = (tmp1.lineNO==tmp2.lineNO);
		return b1 && b2 && b3;
	}




	protected static Set pre(List<CallSite> chain) {
        Set set = new HashSet();
        for(CallSite cs :chain)
        {
       	 Set precs =IntraP.pre(cs);
       	 set.addAll(precs);
        }
        return set;
	}





	protected static Set post(List<CallSite> chain) {
         Set set = new HashSet();
         for(CallSite cs :chain)
         {
        	 Set postcs =IntraP.post(cs);
        	 set.addAll(postcs);
         }
         return set;
		   
	}







	protected static List getSootFromInter(List interchainList) {
		// well-formed
		
	    for(Object o1: interchainList)
	    {
	    	if(o1 instanceof List)
	    	{
	    		List  interchain = (List)o1;
	    	
	    		for(Object o2:interchain)// inside the chain is a site
	    		{
	    			if(!(o2 instanceof CallSite)) System.err.println("invalid callsite");
	    			 CallSite cs = (CallSite)o2;
	    			 fixSootIssue(cs );
	    			    			
	    		}
	    	}
	    }
		
		return interchainList;
	}




	
	private static void fixSootIssue(CallSite cs) {
		 String classname = cs.classname;
		 String methodname = cs.methodname;
		 int  lineNO = cs.lineNO;
		
		 SootClass sc  =Scene.v().getSootClass(classname);
		 cs.sc=sc;
		 List<SootMethod> ms  =sc.getMethods();
		 for(SootMethod sm :ms)
		 {
			 if(!sm.getName().equals(methodname)) continue;
			 Criteria criteria = new Criteria();
			 criteria.methodName="equalineNO";
			 criteria.argList = new ArrayList();
			 criteria.argList.add(lineNO);
			 Unit u =IntraP.getFirst(sm, criteria);
			 if(u!=null) 
			 {
				 cs.sm=sm;
				 cs.rep=u;
				 System.out.println(u);
				 break;
			 }
			 
		 }
	}



	protected static List raw2Inter(List rawchainList) {
		// well-formed
		List chainList = new ArrayList();
	    for(Object o1: rawchainList)
	    {
	    	if(o1 instanceof List)
	    	{
	    		List  rawchain = (List)o1;
	    		List<CallSite>  chain = new  ArrayList<CallSite>();
	    		chainList.add(chain);
	    		for(Object o2:rawchain)
	    		{
	    			if(!(o2 instanceof List)) System.err.println("invalid chain");
	    			List rawsite = (List)o2;
	    			CallSite callsite = genFromRaw(rawsite);
	    			chain.add(callsite);
	    			
	    		}
	    	}
	    }
		
		return chainList;
	}



	private static CallSite genFromRaw(List site) {
        List classL = (List) site.get(0);
        List methodL =(List) site.get(1);
        List lineL =(List) site.get(2);
        CallSite cs = new CallSite();
        cs.classname="";
        for(Object ele:classL)
        {
        	if(!(ele instanceof String)) System.err.println("callsite invalid");
        	cs.classname +=("."+(String)ele);
        	
        }
        cs.classname=cs.classname.substring(1);
        
        cs.methodname= (String)methodL.get(0);
        String lineNOStr  = (String)lineL.get(0);
        cs.lineNO= Integer.parseInt(lineNOStr);
        return cs;

	}



	private static void addgetRegionPackToJtp(Pack jtp) {

		jtp.add(new Transform("jtp.getRegion", new BodyTransformer() {

			@Override
			protected void internalTransform(Body b, String phaseName,
					Map options) {
				SootMethod  sm =b.getMethod();
				if(!sm.hasActiveBody())
				{
					return;
				}
				else {
					Body bb =sm.getActiveBody();
				    UnitGraph ug = new EnhancedUnitGraph(bb);			    
				}				
			}
		}));

	}


	


}
