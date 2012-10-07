package Drivers;

import java.io.File;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.options.Options;

public class PartialAnalysis {

	private final static String RT_CLASSPATH = "/home/lpxz/java_standard/jre/lib/rt.jar";
	
	private final static String SRC_CLASSPATH = "/home/lpxz/work/soot/examples/src";
	
	private final static String CLASS_TO_ANALYZE = "test.ppa.A";
	
	private final static String OUTPUT_DIR = "/home/lpxz/work/soot/examples/output";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scene scene = null;
		Options opt = Options.v();
		String classpath = RT_CLASSPATH + File.pathSeparator + SRC_CLASSPATH;
		opt.set_allow_phantom_refs(true);
		opt.set_output_format(Options.output_format_jimple);
		opt.set_output_dir(OUTPUT_DIR);
		opt.set_src_prec(Options.src_prec_java);
		opt.set_soot_classpath(classpath);
		opt.classes().add(CLASS_TO_ANALYZE);
		scene = Scene.v();
		scene.loadNecessaryClasses();
		
		SootClass sClass = scene.getSootClass(CLASS_TO_ANALYZE);
		for (Object oMethod : sClass.getMethods()) {
			SootMethod sMethod = (SootMethod) oMethod;
			System.out.println(sMethod.getSignature());
			for (Object oUnit : sMethod.retrieveActiveBody().getUnits()) {
				Unit unit = (Unit) oUnit;
				System.out.println("  " + unit.toString());
			}
		}
	}

}