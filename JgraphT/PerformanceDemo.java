

import java.io.*;

import java.sql.PreparedStatement;
import java.util.*;
import java.util.concurrent.CountDownLatch;

import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.*;



/**
 * A simple demo to test memory and CPU consumption on a graph with 3 million
 * elements.
 *
 * <p>NOTE: To run this demo you may need to increase the JVM max mem size. In
 * Sun's JVM it is done using the "-Xmx" switch. Specify "-Xmx300M" to set it to
 * 300MB.</p>
 *
 * <p>WARNING: Don't run this demo as-is on machines with less than 512MB
 * memory. Your machine will start paging severely. You need to first modify it
 * to have fewer graph elements. This is easily done by changing the loop
 * counters below.</p>
 *
 * @author Barak Naveh
 * @since Aug 10, 2003
 */
public final class PerformanceDemo implements Runnable
{
    //~ Methods ----------------------------------------------------------------

    Graph<Object, DefaultEdge> g =  new Pseudograph<Object, DefaultEdge>(DefaultEdge.class);
    int threadno;
    CountDownLatch start;
    CountDownLatch end;
    Object monitor = new Object();
    static Graph g1 =   new Pseudograph<Object, DefaultEdge>(DefaultEdge.class);
    static Graph g2 =   new Pseudograph<Object, DefaultEdge>(DefaultEdge.class);
    public static void PrepareGraphs()
    {
    	prepareGraph(g1);
    	prepareGraph(g2);   	
    }
    public static void prepareGraph(Graph g12) {
    	Object prev;
        Object curr;
        curr = prev = new Object();
        synchronized(g12)
        {
        	g12.addVertex(prev);
        }

    
        int numVertices = 5;// 1000/threadno;
        int numEdgesPerVertex = 2;
        int numElements = numVertices * (1 + numEdgesPerVertex);

     
        for (int i = 0; i < numVertices; i++) {
            curr = new Object();
            synchronized(g12)
            {
            	g12.addVertex(curr);
            }

            for (int j = 0; j < numEdgesPerVertex; j++) {
            	synchronized(g12)
            	{
            		g12.addEdge(prev, curr);
            	}
            }

            prev = curr;
        }
		
	}
	public PerformanceDemo(int i){
    	threadno = i;
    	start = new CountDownLatch(threadno);
    	end = new CountDownLatch(threadno);
    }
    /**
     * The starting point for the demo.
     *
     * @param args ignored.
     */
    public static void main(String [] args)
    {
    //	for(int i=0;i<10;i++)
    	new PerformanceDemo(1).kickoff(); 
    }

    public void kickoff(){
    	for(int i=0;i<threadno;i++){
    		new Thread(this).start();
    		start.countDown();
    	}
        long time = System.currentTimeMillis();
    	try {
			end.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(System.currentTimeMillis()-time);
    }
    	public void run() {
			try {
				start.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Object prev;
        Object curr;
        curr = prev = new Object();
        synchronized(g)
        {
        	g.addVertex(prev);
        }

    
        int numVertices = 50;// 1000/threadno;
        int numEdgesPerVertex = 20;
        int numElements = numVertices * (1 + numEdgesPerVertex);

//        System.out.println(
//            "\n" + "allocating graph with " + numElements
//            + " elements (may take a few tens of seconds)...");

        long  startTime= System.currentTimeMillis();
        for (int i = 0; i < numVertices; i++) {
            curr = new Object();
            synchronized(g)
            {
            g.addVertex(curr);
            }

            for (int j = 0; j < numEdgesPerVertex; j++) {
            	synchronized(g)
            	{
                g.addEdge(prev, curr);
            	}
            }

            prev = curr;
        }
        long  endTime= System.currentTimeMillis();
        long passedTime = endTime-startTime;
        System.out.println("the action costs :" +passedTime);
       
        long startTimeDump= System.currentTimeMillis();
      //  samefileDump(g);
        
        long endTimeDump= System.currentTimeMillis();
        long passedDumpTime= endTimeDump-startTimeDump;
        System.out.println("dump costs:" +passedDumpTime);
        end.countDown();
	}

    private static void reportPerformanceFor(String msg, long refTime)
    {
        double time = (System.currentTimeMillis() - refTime) / 1000.0;
        double mem = usedMemory()
            / (1024.0 * 1024.0);
        mem = Math.round(mem * 100) / 100.0;
        System.out.println(msg + " (" + time + " sec, " + mem + "MB)");
    }

    private static long usedMemory()
    {
        Runtime rt = Runtime.getRuntime();

        return rt.totalMemory() - rt.freeMemory();
    }
	
	
	
    public static void samefileDump(Object test) {
        FileOutputStream fos=null;
		ObjectOutputStream oos= null;

//		XStream xStream= new  XStream();
		try {
			if(oos==null)
			{
				fos= new FileOutputStream("testXS.txt");
			    oos = new  ObjectOutputStream(fos);
			}

		    oos.writeObject(test);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	
		
	}
}

// End PerformanceDemo.java
