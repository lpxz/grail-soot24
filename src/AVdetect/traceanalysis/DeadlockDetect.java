package AVdetect.traceanalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jgrapht.alg.CycleDetector;
import org.jgrapht.alg.StrongConnectivityInspector;
import org.jgrapht.ext.DOTExporter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;

import AVdetect.edge.abstractclass.CausalEdge;
import AVdetect.eventnode.abstractclass.CriticalEvent;
import Drivers.Utils;

public class DeadlockDetect {

	public static String readFile(File file, List<String> lines)
	throws IOException {
BufferedReader reader = new BufferedReader(new InputStreamReader(
		new FileInputStream(file)));
try {
	StringBuilder ret = new StringBuilder();
	String line;
	while ((line = reader.readLine()) != null) {
		ret.append(line);
		lines.add(line);
		ret.append("\n");
	}
	return ret.toString();
} finally {
	reader.close();
}
}
	public static DirectedPseudograph ddg = new DirectedPseudograph(DefaultEdge.class);
	public static void main(String[] args) {
		List<String> lines = new ArrayList<String>();
		String testfile = "/home/lpxz/eclipse/workspace/soot24/src/AVdetect/traceanalysis/trace.txt";
	
		try {
			String source = readFile(new File(testfile), lines);
			analyze(lines);
			

	    }
		catch (Exception e) {
			e.printStackTrace();
		}
		
//		StrongConnectivityInspector sci = new StrongConnectivityInspector(ddg);
//		List<Set> sccList= sci.stronglyConnectedSets();// ntoe there, we have the scc, not the cycle, scc is more strong than cycle
//	    System.out.println(sccList.size());
//	    
//	    CycleDetector cd = new CycleDetector(ddg);
//	   Set cyclesSet = cd.findCycles();// nto so good, not guaranteed that all cycles are returned
//	
//	   
//	   System.out.println(cyclesSet.size());
	    
	    
	}
	public static HashMap<String, Set> thread2lockSet = new HashMap<String, Set>(); 
	private static void analyze(List<String> lines) {
	   for(String str:lines)
	   {
		   System.err.println(str);
		  
		   if(str.contains(" tolock") || str.contains(" unlocked") || str.contains(" locked"))
		   {
			  // System.err.println(str);
			   int space =str.lastIndexOf(' ');
		       int maohao = str.lastIndexOf(':');
		       
			   String tname = str.substring(0, space);
		       String action  = str.substring(space+1, maohao);
		       String lID = str.substring(maohao+1);
		       int lockID =Integer.parseInt(lID);
		       
		       if(action.equals("tolock"))
		       {
		    	   
		    	   // before success, check:
		    	   Iterator it =(thread2lockSet.keySet().iterator());
		    	   boolean blocked = false;
		    	   while (it.hasNext()) {
					Object object = (Object) it.next();
					Set lockSet =thread2lockSet.get(object);
					 if(lockSet.contains(lockID) && !object.equals(tname))
					 {
						 blocked =true;
						 quickAdd(ddg, tname, object, lockID);
					 }
				    }
		    	  
		    	   

		       }
		       else if (action.equals("locked")) {
		    	   boolean blocked = false;
		    	   Iterator it =(thread2lockSet.keySet().iterator());
		    	   while (it.hasNext()) {
					Object object = (Object) it.next();
					Set lockSet =thread2lockSet.get(object);
					 if(lockSet.contains(lockID) && !object.equals(tname))
					 {
						 blocked =true;
						System.out.println("I want:" + lockID + " ,but it is owned by" + object + "----said by " + tname);
					 }
				    }
		    	   if(blocked)
		    	   {
			  //  	  throw new RuntimeException();		    	  
		    	   }
		    	   Set lSet = thread2lockSet.get(tname);
		    	   if(lSet==null)
		    	   {
		    		   thread2lockSet.put(tname, new HashSet());
		    	   }
		    	   thread2lockSet.get(tname).add(lockID);
				
			}
		       else if(action.equals("unlocked")){
				   thread2lockSet.get(tname).remove(lockID);
				   //=============update the ddg tooo:
				   try {
					   Iterator<DefaultEdge> it =  ddg.incomingEdgesOf(tname).iterator();
					     while (it.hasNext()) {
							DefaultEdge defaultEdge = (DefaultEdge) it.next();
							if(defaultEdge.label.equals(""+lockID))
							{
								ddg.removeEdge(defaultEdge);// remove the relations for those who want lockID
							}
							
						} 
				} catch (Exception e) {
				    // no such vertex yet
				//	System.out.println("no such vertex yet. wait");
				}
				 
		       }
		       else {
				throw new RuntimeException();
			}
		       
		       
		   }
	   }
		
	}
	private static void quickAdd(DirectedPseudograph ddg, String tname,
			Object object, int lockID) {
		// tname-> e->object
		if(!ddg.containsVertex(tname)) ddg.addVertex(tname);
		if(!ddg.containsVertex(object)) ddg.addVertex(object);
		 DefaultEdge e1= new DefaultEdge();
		 e1.setLabel(""+lockID);
		ddg.addEdge(tname, object, e1);
		// may form a new cycle!
		StrongConnectivityInspector sci = new StrongConnectivityInspector(ddg);
		List<Set> sccList= sci.stronglyConnectedSets();// ntoe there, we have the scc, not the cycle, scc is more strong than cycle
		for(Set scc : sccList)
		{
			if(scc.size()<2) continue; 
			System.err.println("cycle invovles" );
			DOTExporter<CriticalEvent, CausalEdge> dotEx = new DOTExporter<CriticalEvent, CausalEdge>();
			{

				File file = new File("/home/lpxz/eclipse/workspace/soot24/src/AVdetect/traceanalysis/seesee");
				FileWriter fw;
				try {
					fw = new FileWriter(file);
					dotEx.export4CausalGraph(fw, ddg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			for(Object object2:  scc)
			{
			   System.err.print((object2)); ;	
			}
			System.err.println();
		}
		
	}
	
}
