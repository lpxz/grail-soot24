package AVfix.manager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import soot.Body;
import soot.G;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.Stmt;
import soot.options.Options;
import soot.tagkit.Host;
import soot.tagkit.LineNumberTag;
import soot.tagkit.SourceLineNumberTag;
import soot.tagkit.SourceLnPosTag;

public class AVfixUtil {
	public static String getFullMethodName(StackTraceElement ste)
	{ 
		String classname = ste.getClassName();
		String methodname = ste.getMethodName();
		return classname + "." + methodname;
		
	}

	public static String origAnalyzedFolder ="";
	
	
	public static List<StackTraceElement> snapshot(List<StackTraceElement> ctxtStack )
	{
		List<StackTraceElement> ret = new ArrayList<StackTraceElement>();
		ret.addAll(ctxtStack);
		return ret;
		
	}
	
	
	public static Stmt search4CallSiteStmt(String secondClass,
			String secondMethod, String className, String mName,
			String filename, int eleLineNO) {
	//	System.out.println(secondClass + " " + secondMethod );
		
		boolean check = couplingCheck(secondClass, filename);
		if(!check)
		{
			System.err.println("seems not matching between the caller and the callee!!");
			
		}
		if(check)// the second one really matches the caller, instead of the far-away relative
		{
			//
			    String argsOfToyW = "-app -f J -pp -cp /home/lpxz/java_standard/jre/lib/jsse.jar:"+ origAnalyzedFolder+" " + secondClass; // java.lang.Math
				String interString = argsOfToyW;
				String[] finalArgs = interString.split(" ");
		        soot.Main.v().processCmdLine(finalArgs);
		        Options.v().set_keep_line_number(true);
			
				
				List excludesList= new ArrayList();
				excludesList.add("jrockit.");
				excludesList.add("com.bea.jrockit");
				excludesList.add("sun.");
				Options.v().set_exclude(excludesList);
			
				
			    SootClass secondclass = Scene.v().loadClassAndSupport(secondClass);
			    SootClass curclass = Scene.v().loadClassAndSupport(className);
			    secondclass.setApplicationClass();
			    curclass.setApplicationClass();
			    
			    
			    Scene.v().loadNecessaryClasses();
			    List<SootMethod> sms = secondclass.getMethods();
			    List<SootMethod> hit = new ArrayList<SootMethod>();
			    for(SootMethod sm : sms)
			    {
			    	if(sm.getName().equals(secondMethod))
			    	{
			    		hit.add(sm);
			    	}
			    }
			    boolean theParent = false;
			    int recentMethodEntry = -1;
			    SootMethod recentMethod  = null;
			    for(SootMethod sm:hit)
			    {
			    	sm.retrieveActiveBody(); 		    	
			    	
			    	if(sm.hasActiveBody())
			    	{
			    		Body bb = sm.getActiveBody();
			    	    Stmt stmt  =(Stmt) bb.getUnits().getFirst();
			    	    int lineNO = getLineNum(stmt);
			    	    if(eleLineNO >=lineNO)
			    	    {
			    	    	// lineNO is valid for candidates
			    	    	if(lineNO>recentMethodEntry)// this one is more recent.
			    	    	{
			    	    		recentMethodEntry = lineNO;
			    	    		recentMethod = sm;
			    	    	}
			    	    }
			    	    
			    	}
			    }
			    if(recentMethod==null) 
			    	{
			    	G.reset();return null;
			    	}
			    Body bb =recentMethod.getActiveBody();// recentMethod!=NULL

			    HashSet<Unit> possibleUnits  = new HashSet<Unit>();
	    		Iterator<Unit> it =bb.getUnits().iterator();
	    	    while (it.hasNext()) {
					Stmt unit = (Stmt) it.next();
					if(unit.containsInvokeExpr())
					{
						String invokedM =unit.getInvokeExpr().getMethod().getName();
						if(mName.equals(invokedM))
						{
							if(getLineNum(unit)==eleLineNO)// exactly the same??
							{
								// hit 
								G.reset();
								return unit;
							}
							else {
								possibleUnits.add(unit);
							}
							
							
						}
					}
				}
	    	    if(possibleUnits.size() !=0)
	    	    {
	    	    	// still not return the signature yet, 
	    	    	G.reset();
	    	    	throw new RuntimeException("check please!line no is not exactly the same?");
	    	    }
			    

		}
		
		G.reset();
		return null;
	}
	
private static boolean couplingCheck(String secondClass, String filename) {
		
		if(filename.contains(".java"))
		{
			int index =filename.indexOf(".java");
			if(index !=-1)
			{
				String pureName =filename.substring(0, index);
				if(secondClass.contains(pureName))
				{
					return true; //pass
				}
			}
			
		}
		return false;
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
	
	public static Body search4MethodBodyInClass(String mName, String className) {
        String argsOfToyW = "-f J -pp -cp . " + className; // java.lang.Math
		String interString = argsOfToyW;
		String[] finalArgs = interString.split(" ");
        soot.Main.v().processCmdLine(finalArgs);
		
	
		
		List excludesList= new ArrayList();
		excludesList.add("jrockit.");
		excludesList.add("com.bea.jrockit");
		excludesList.add("sun.");
		Options.v().set_exclude(excludesList);
	
		Scene.v().loadNecessaryClasses();
	    SootClass sc = Scene.v().loadClassAndSupport(className);
	    sc.setApplicationClass();
	    List<SootMethod> sms = sc.getMethods();
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
	    	G.reset();
	    	return hit.get(0).getActiveBody();
	    }
	    else {
	    	G.reset();
			return null;
		}
	}
	
	
}
