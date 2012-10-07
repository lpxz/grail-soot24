package AVfix.manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import AVfix.node.EntryStatement;

public class MethodManager {
	public static HashMap<String, HashSet<EntryStatement>> m2CSMs = new HashMap<String, HashSet<EntryStatement>>();

	public static EntryStatement search4EntryStatement(String methodName,
			List<StackTraceElement> ctxtStack) {
		HashSet<EntryStatement> entrySs =m2CSMs.get(methodName);
		if(entrySs==null)
			 return null;
		for(EntryStatement entry:entrySs)
		{
			List<StackTraceElement> stes =entry.getStes();
			if(ctxtsMatch(stes,ctxtStack)){
				//// main has a special ctxt: empty, 
				//the methods with different parameters can not be invoked under the same ctxt!
				
				
				return entry;
			}
		}
	    
		
	
		
		return null;
	}

	private static boolean ctxtsMatch(List<StackTraceElement> stes,
			List<StackTraceElement> ctxtStack) {
		if(stes.size() != ctxtStack.size()) return false;
		boolean toret = true;
		for(int i=0; i < stes.size(); i++)
		{
			StackTraceElement ste = stes.get(i);
			StackTraceElement ste2 = ctxtStack.get(i);
			if(!ste.toString().equals(ste2))
			{
				toret =false;
			}
		}
		
		return toret;
	}

	public static void register4EntryMethod(String methodName,
			EntryStatement newOne) {
		HashSet<EntryStatement> entrySs =m2CSMs.get(methodName);
		if(entrySs==null)
		{
		  entrySs = new HashSet<EntryStatement>();
		  m2CSMs.put(methodName, entrySs);
		}
		entrySs.add(newOne);
		
	}
	

}
