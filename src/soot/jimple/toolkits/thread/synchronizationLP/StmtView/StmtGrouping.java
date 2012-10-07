package soot.jimple.toolkits.thread.synchronizationLP.StmtView;

import java.util.List;
import java.util.Set;

import soot.Unit;
import soot.jimple.toolkits.thread.synchronizationLP.CriticalSection;
// at last, we protect the data through the stmt!
// and the lock is placed before/end the stmt, not the data!
public interface StmtGrouping {
    public Object    lock4Group(Set<Object>  group); // interfaces
    
    public Set<Object> getOrMakeGroup(Object obj); 
    public Set<Set<Object>> allGroups_mappedTo();
    
    // not tested !!!:
   public List<Object> locks4StmtViaGroup(Unit stmt);
   // key:
    public List<Object> locks4StmtViaGroup(CriticalSection itemCurr, Unit data);
    public List<Set<Object>> whichGroups(Unit stmt);// groups may have order, do not use set
    public List<Set<Object>> whichGroups(CriticalSection itemCurr, Unit csUnit);
}
