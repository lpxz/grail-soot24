package pldi.locking.studyConcurrent;

import java.io.File;
import java.util.HashMap;

import soot.PackManager;
import soot.PhaseOptions;
import soot.Scene;
import soot.SootClass;
import soot.Transform;
import soot.jimple.spark.SparkTransformer;
import soot.options.Options;

public class SootMain {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out
					.println("Syntax: java Main --app <main_classfile> [sootoptions]");
			System.exit(0);
		}
		String mainclass = args[0];
		setOptions(mainclass);
		String[] args1 = { "-cp", ".", "-pp", "-validate","-include","org.apache.", mainclass };
		PackManager.v().getPack("wjtp")
				.add(new Transform("wjtp.profiler", EvaluatorB.v()));
		soot.Main.main(args1);
	}

	private static void setOptions(String mainclass) {
		PhaseOptions.v().setPhaseOption("jb", "enabled:true");
		Options.v().set_keep_line_number(true);
		Options.v().setPhaseOption("jb", "use-original-names:true");
		Options.v().set_whole_program(true);
		Options.v().set_app(true);

		// Enable Spark
		HashMap<String, String> opt = new HashMap<String, String>();
		// opt.put("verbose","true");
		opt.put("propagator", "worklist");
		opt.put("simple-edges-bidirectional", "false");
		opt.put("on-fly-cg", "true");
		opt.put("set-impl", "double");
		opt.put("double-set-old", "hybrid");
		opt.put("double-set-new", "hybrid");
		opt.put("pre_jimplify", "true");
		SparkTransformer.v().transform("", opt);
		PhaseOptions.v().setPhaseOption("cg.spark", "enabled:true");

		Scene.v().setSootClassPath(
				System.getProperty("sun.boot.class.path") + File.pathSeparator
						+ System.getProperty("java.class.path"));

		SootClass appclass = Scene.v().loadClassAndSupport(mainclass);
		Scene.v().setMainClass(appclass);

	}

}
