//package soot.jimple.toolkits.visitor.jpaul.Graphs;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.WeakHashMap;
//
//import polyglot.ast.New;
//// refers to the jgraphT please for convinient algorithms
//public class BiPartite<XType, YType> {
//    
//	public HashSet<XType> X= null;// new HashSet<XType>();
//	public HashSet<YType> Y =null;//new HashSet<YType>();
//	public HashMap<Object, HashSet<Object>>  edgesMap=null;//  new HashMap<XType, YType>();
//	
//	public BiPartite()
//	{
//		X= new HashSet<XType>();
//		Y= new HashSet<YType>();
//		edgesMap =new HashMap<Object, HashSet<Object>>();
//	}
//	
//	public void addedge(XType xtmp , YType ytmp)
//	{
//		// X, Y are domains, while the edge map store for both x-y, and y-x for convinience
//		X.add(xtmp);
//		Y.add(ytmp);
//		//================
//		HashSet neighbours = null;
//		if(edgesMap.get(xtmp)==null) 
//		{
//			neighbours= new HashSet();
//			edgesMap.put(xtmp, neighbours);			
//		}
//		neighbours = edgesMap.get(xtmp);// ok neigbour 
//		neighbours.add(ytmp);
//		//================
//       	if(edgesMap.get(ytmp)==null) 
//       	{
//       		neighbours= new HashSet();
//       		edgesMap.put(ytmp, neighbours);
//       	}
//       	neighbours = edgesMap.get(ytmp);
//       	neighbours.add(xtmp);
//       	
//	}
//	public static void main(String[] args) {
//		BiPartite<Object, Object> biPartite= new BiPartite<Object, Object>();
//		biPartite.addedge("a", "anode1");
//		biPartite.addedge("a", "anode2");
//		biPartite.addedge("b", "anode2");
//		biPartite.addedge("c", "anode2");
//		
//		biPartite.addedge("d", "anode3");
//		
//		
//
//         
//
//	}
//
//}
