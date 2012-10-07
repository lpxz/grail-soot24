package soot.jimple.toolkits.thread.synchronizationLP.DataView;

import java.util.List;
import java.util.Set;

public interface DataGrouping {
    public List<Set<Object>> whichGroups(Object data);// groups may have order, do not use set
    public Object    lock4Group(Set<Object>  group); // interfaces
    public List<Object> locks4DataViaGroup(Object data);
    public Set<Object> getOrMakeGroup(Object obj); 
    public Set<Set<Object>> allGroups_mappedTo();
}
