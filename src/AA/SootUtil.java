package AA;

import pldi.locking.CriticalSection;
import soot.jimple.Stmt;
import soot.jimple.toolkits.pointer.CodeBlockRWSet;
import soot.tagkit.Host;
import soot.tagkit.LineNumberTag;
import soot.tagkit.SourceLineNumberTag;
import soot.tagkit.SourceLnPosTag;


public class SootUtil {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	
	public static String getMark(CriticalSection tn) {
		Stmt begin = tn.beginning;
		return tn.method.getDeclaringClass().getName() + " _ " + tn.method.getName() + "_" +getLineNum(begin);
		
		
	}

	public static String getMark(CodeBlockRWSet atomicSet) {
		return  "AtomicSet" + atomicSet.hashCode();
		
		
	}

}
