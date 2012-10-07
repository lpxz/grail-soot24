package Drivers;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jboss.serial.io.JBossObjectInputStream;


import soot.EntryPoints;
import soot.FastHierarchy;
import soot.Pack;
import soot.PackManager;
import soot.PhaseOptions;
import soot.PointsToAnalysis;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Transform;

import soot.jimple.paddle.PaddleTransformer;
import soot.jimple.spark.pag.PAG;
import soot.jimple.spark.solver.OnFlyCallGraph;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.ContextManager;
import soot.jimple.toolkits.callgraph.OnFlyCallGraphBuilder;
import soot.jimple.toolkits.callgraph.ReachableMethods;
import soot.jimple.toolkits.callgraph.TransitiveTargets;
import soot.options.Options;
import soot.options.PaddleOptions;

public class Setup {
	


	public static SootMethod curMethod = null;
	public static String curClassname;
	public static String[] releClassname={"aThread.RunnableWriter","aThread.RunnableReader","aThread.RWResource"};//"aThread.RunnableWriter","aThread.RunnableReader","aThread.RWResource"
	public static String curMethodname;
	public static String defaultCopyToName="copyTo";

	public static void setPhaseOptionsForPaddleWork( )
	{
		PhaseOptions.v().setPhaseOption("cg.paddle", "enabled:true");
		PhaseOptions.v().setPhaseOption("cg.paddle", "verbose:true");
		//default is insensitive!
		PhaseOptions.v().setPhaseOption("cg.paddle", "context:1cfa");// kobjsens object-sensitive, comapred to 1cfa
	//	PhaseOptions.v().setPhaseOption("cg.paddle", "k:1");// default
		//PhaseOptions.v().setPhaseOption("cg.paddle", "context-heap:true");// heap sensitive
		// bdd versions 
		PhaseOptions.v().setPhaseOption("cg.paddle", "bdd:true");
//		PhaseOptions.v().setPhaseOption("cg.paddle", "backend:javabdd");
		// john whaley's javabdd & zdd, good, purely java
//		PhaseOptions.v().setPhaseOption("cg.paddle", "backend:sable");
		PhaseOptions.v().setPhaseOption("cg.paddle", "backend:buddy");
//		PhaseOptions.v().setPhaseOption("cg.paddle", "backend:cudd");

		// specjbb  kobjsens, 2 , heapsensitive, 3hours, no result!
		//specjbb 1cfa, heap-sens, 2 hours, no result
		// specjbb 1cfa no heap-sens, 2 hours, no result
		/// very small, toy, sablejbb 20mini no results..
		///the same toy, javabdd uses 1min, get result.
		
		
		

		
		
		
	}
	
//	public static void setPhaseOptionsForPaddleWork()
//	{
//		HashMap opt = new HashMap();
//		opt.put("enabled","true");
//		opt.put("verbose","true");
//		opt.put("bdd","true");
//		opt.put("backend","buddy");
//		opt.put("context","insens");
//		opt.put("k","2");
//		opt.put("string-constants", "true");
//		opt.put("propagator","auto");
//		opt.put("conf","cha-context-aot");
//		opt.put("order","32");
//		opt.put("q","auto");
//		opt.put("set-impl","double");
//		opt.put("double-set-old","hybrid");
//		opt.put("double-set-new","hybrid");
//		opt.put("pre-jimplify","false");
//		opt.put("context-counts", "true");
//		opt.put("total-context-counts", "true");
//		opt.put("method-context-counts", "true");
//		opt.put("set-mass", "true");
//		opt.put("number-nodes", "true");
//		
//		PaddleTransformer pt = new PaddleTransformer();
//		PaddleOptions paddle_opt = new PaddleOptions(opt);
//		pt.setup(paddle_opt);
//		pt.solve(paddle_opt);
//		soot.jimple.paddle.Results.v().makeStandardSootResults();
//	}
    
//@deprecated
  public  static void setupPatchOptions(){
		PhaseOptions.v().setPhaseOption("jb", "use-original-names:true");// does work
		PhaseOptions.v().setPhaseOption("jb.ulp", "enabled:false");//important 
	
		
		List excludesList= new ArrayList();
		excludesList.add("jrockit.");
		excludesList.add("com.bea.jrockit");
		excludesList.add("sun.");
		Options.v().set_exclude(excludesList);
		
		
		soot.options.Options.v().set_keep_line_number(true); // line tag on 
		soot.options.Options.v().set_whole_program(true);
		soot.options.Options.v().set_app(true);// --app usage.
	//	soot.options.Options.v().set_src_prec(2);// public static final int src_prec_only_class = 2;
		
		//java soot.Main HelloWorld
		//java soot.Main --app HelloWorld
		//java soot.Main -i java. --app HelloWorld

//		List excludesList= new ArrayList();
//		excludesList.add("jrockit.");
//		excludesList.add("com.bea.jrockit");
//		excludesList.add("sun.");
//		soot.options.Options.v().set_exclude(excludesList);
		
		
		List includesList= new ArrayList();
		includesList.add("org.apache");
		includesList.add("org.w3c");
		
		soot.options.Options.v().set_include(includesList);
		

		
    //    PhaseOptions.v().setPhaseOption("cg", "verbose:true");
		//set_exclude


   }
	public static void setupBOptionsBStringEntryNotWhole() {
		soot.options.Options.v().set_output_format(1);
		soot.options.Options.v().set_keep_line_number(true); // line tag on 
		soot.options.Options.v().set_whole_program(false);
		soot.options.Options.v().set_app(true);// --app usage.
		
	
		soot.options.Options.v().set_app(true);
		List excludesList= new ArrayList();
		excludesList.add("jrockit.");
		excludesList.add("com.bea.jrockit");
		soot.options.Options.v().set_exclude(excludesList);
		//set_exclude

		


	}









	
	private static void setPhaseOptionsForFieldRW() {
		PhaseOptions.v().setPhaseOption("jap.fieldrw", "enabled:true");//enable tagger 

		PhaseOptions.v().setPhaseOption("tag.fieldrw", "enabled:true");//enable tag aggregator

		
	}





	public static void setPhaseOptionsForSparkWork() {
		
		HashMap opt = new HashMap();
		
//		PhaseOptions.v().setPhaseOption("jb", "use-original-names:true");// does work
//		PhaseOptions.v().setPhaseOption("jb.ulp", "enabled:false");//important 
//		
//		PhaseOptions.v().setPhaseOption("jb.ls", "enabled:true");// does not work
		
		
	   
		//
		 PhaseOptions.v().setPhaseOption("cg.spark", "enabled:true");
		 PhaseOptions.v().setPhaseOption("cg.spark", "verbose:false");
		 PhaseOptions.v().setPhaseOption("cg.spark", "force-gc:true");
		 
		 
		   
		
		 PhaseOptions.v().setPhaseOption("cg.spark", "simplify-offline:true");// need the simplication for eclipse
		 PhaseOptions.v().setPhaseOption("cg.spark", "simplify-sccs:true");
		 PhaseOptions.v().setPhaseOption("cg.spark", "ignore-types-for-sccs:true");
		 PhaseOptions.v().setPhaseOption("cg.spark", "propagator:worklist");
		// PhaseOptions.v().setPhaseOption("cg.spark", "propagator:alias");
		 PhaseOptions.v().setPhaseOption("cg.spark", "set-impl:double");
		 PhaseOptions.v().setPhaseOption("cg.spark", "double-set-old:hybrid");
		 PhaseOptions.v().setPhaseOption("cg.spark", "double-set-new:hybrid");		
		 PhaseOptions.v().setPhaseOption("cg.spark", "topo-sort:true");
		 
      
 
		
	}







//	public static void setPhaseOptionsForTheirTransactionTransformer() {
//		//
//		 PhaseOptions.v().setPhaseOption("wjtp.tn", "enabled:true");
//		 
//		// 			Map newMap=setOptionsMap(); // wrapper style  within the TheirTrans...
//		// soot.options.Options.getDeclaredOptionsForPhase( getPhaseName() );
//		 PhaseOptions.v().setPhaseOption("wjtp.tn", "locking-scheme:medium-grained");
//		 PhaseOptions.v().setPhaseOption("wjtp.tn", "avoid-deadlock:true");
//		 PhaseOptions.v().setPhaseOption("wjtp.tn", "open-nesting:true");
//		 PhaseOptions.v().setPhaseOption("wjtp.tn", "do-mhp:true");
//		 
//		 PhaseOptions.v().setPhaseOption("wjtp.tn", "do-tlo:true"); 
//		 PhaseOptions.v().setPhaseOption("wjtp.tn", "print-graph:true");
//		 PhaseOptions.v().setPhaseOption("wjtp.tn", "print-table:true");
//		 PhaseOptions.v().setPhaseOption("wjtp.tn", "print-debug:true");
//		 
//		 
//		
//	}
	public static void setPhaseOptionsForDemandCS() {
		PhaseOptions.v().setPhaseOption("cg.spark", "cs-demand:true");
		
	}

	

	public static void setPhaseOptionsForMyTransactionTransformer() {
		//
		 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "enabled:true");
		 
		// 			Map newMap=setOptionsMap(); // wrapper style  within the TheirTrans...
		// soot.options.Options.getDeclaredOptionsForPhase( getPhaseName() );
//		 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "locking-scheme:medium-grained");
//		 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "avoid-deadlock:true");
//		 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "open-nesting:true");
//		 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "do-mhp:true");
//		 
//		 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "do-tlo:true"); 
//		 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "print-graph:true");
//		 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "print-table:true");
//		 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "print-debug:true");
		 //configure directly in the source code please, it is more efficient
		 
		
	}

	public static void setPhaseOptionsForTheirTransactionTransformer() {
	      PhaseOptions.v().setPhaseOption("wjtp.tn", "enabled:true");
	      PhaseOptions.v().setPhaseOption("wjtp.tn", "locking-scheme:single-static");
	      PhaseOptions.v().setPhaseOption("wjtp.tn", "do-mhp:true");
	      PhaseOptions.v().setPhaseOption("wjtp.tn", "do-tlo:true");
	      
		
	}
	
}