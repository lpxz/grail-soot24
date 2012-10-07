package AVdetect.graph;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.ext.DOTExporter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;
import org.jgrapht.graph.Pseudograph;

import soot.Local;

import AVdetect.edge.CommunicationCausalEdge;
import AVdetect.edge.LocalCausalEdge;
import AVdetect.edge.LockingCausalEdge;
import AVdetect.edge.SharedAccessCausalEdge;
import AVdetect.edge.abstractclass.CausalEdge;
import AVdetect.eventnode.JoinThreadEvent;
import AVdetect.eventnode.LockingEvent;
import AVdetect.eventnode.NotifyingEvent;
import AVdetect.eventnode.SharedAccessEvent;
import AVdetect.eventnode.StartThreadEvent;
import AVdetect.eventnode.ThreadBeginEvent;
import AVdetect.eventnode.ThreadEndEvent;
import AVdetect.eventnode.UnlockingEvent;
import AVdetect.eventnode.WaitingEvent;
import AVdetect.eventnode.abstractclass.CommunicationEvent;
import AVdetect.eventnode.abstractclass.CriticalEvent;
import AVdetect.eventnode.abstractclass.LockReleEvent;
import AVdetect.manager.MemoryManager;
import AVdetect.manager.ThreadManager;

public class CausalGraph {
	boolean containShAc = true;	
	CriticalEvent root = null;
	ThreadManager tm = null;
	MemoryManager mm =null;
	public DirectedPseudograph<CriticalEvent, CausalEdge> coreG = null;

	public CausalGraph() {
		coreG = new DirectedPseudograph<CriticalEvent, CausalEdge>(
				CausalEdge.class);
		tm = new ThreadManager();
		mm = new MemoryManager();
	}
	public ThreadManager getThreadManager()
	{
		return tm;
	}
	public MemoryManager getMemoryManager()
	{
		return mm;
	}

	// if(!biG2.containsVertex(o)) biG2.addVertex(o);
	// if(!biG2.containsVertex(prepStack)) biG2.addVertex(prepStack);
	// if(!biG2.containsEdge(o, prepStack)) biG2.addEdge(o, prepStack);
	//
	public void setRoot(CriticalEvent para)
	{
		root = para;
	}
	public CriticalEvent getRoot()
	{
		return root;
	}
	public void addVertex(CriticalEvent e) {
		coreG.addVertex(e);

	}

	public synchronized void addVertex_complete(CriticalEvent e)// definitely
																// slow
	{// central processor
		if(coreG.vertexSet().size()==0)// you are the first
		{
			setRoot(e);
		}
		addVertex(e);
		formLocalCausalEdge(e);
		// //form locking unlocking matching locally.
		maintainLocalLockMatching(e);
		formCrossingHardCausalEdge(e);
		
		// does not form the crossing soft causal edge
		if (e instanceof ThreadBeginEvent) {
			tm.setBeginningEvent4ItsThread(e);
		}

	}

	private void formLocalCausalEdge(CriticalEvent e) {
		long tid = e.getTh();
		long mid = e.getMem();
		CriticalEvent e2 = tm.getLastEventOfThread(tid);
		tm.updateLastEvent4ItsThread(e);
		if (e2 != null)// the first event: e2==null
		{
			addEdge_edgetype(e2, e, LocalCausalEdge.class);
		}

	}

	private void formCrossingHardCausalEdge(CriticalEvent e) {
		long tid = e.getTh();
		long mid = e.getMem();
		CriticalEvent e3 =null;
		//synchronized (mm) // no need, the addvertex_complete as a big lock
		{
			e3 = mm.getLastEventOfMemory(mid);
			mm.updateLastEvent4Memory(mid, e);
		}

		// memory does not necessarily mean shared variables only, it may mean
		// threads, monitors, or locks.
		if (e3 != null) {
			if (e3.getTh() != e.getTh()) {
				// e is a remote event as to e3
				if (e instanceof LockingEvent && e3 instanceof UnlockingEvent)// lock
																				// match
																				// unlock
				{
					addEdge_edgetype(e3, e, LockingCausalEdge.class);
				}
				if (e instanceof WaitingEvent && e3 instanceof NotifyingEvent)// wait
																				// match
																				// notify
				{
					addEdge_edgetype(e3, e, CommunicationCausalEdge.class);
				}

				if (e instanceof ThreadBeginEvent
						&& e3 instanceof StartThreadEvent)// wait match notify
				{
					addEdge_edgetype(e3, e, CommunicationCausalEdge.class);
				}

				if (e instanceof JoinThreadEvent
						&& e3 instanceof ThreadEndEvent)// wait match notify
				{
					addEdge_edgetype(e3, e, CommunicationCausalEdge.class);
				}
				if(containShAc==true)
				{
					if (e instanceof SharedAccessEvent && e3 instanceof SharedAccessEvent)
					{
						
						addEdge_edgetype(e3, e, SharedAccessCausalEdge.class);
					//	System.out.println(e3.hashCode() +":"+ e3.getMem() + ":" + e3.getTh()+ " "+ e.hashCode() +":"+ e.getMem() + ":" + e.getTh());
						
					}
				}
				


				// e -> lock , e3-> wait() |=> impossible
			}
			// otherwise, no need to add the crossing edge
		}

	}


	private void maintainLocalLockMatching(CriticalEvent e) {
		if (!(e instanceof LockReleEvent))
			return;
		if (e instanceof LockingEvent) {
			tm
					.updateLastUnmatchedLocking4ItsThread((LockingEvent) e);
		}
		if (e instanceof UnlockingEvent) {
			tm
					.matchLastUnmatchedLocking4ItsThread((UnlockingEvent) e);
		}
	}

	public CausalEdge addEdge_edgetype(CriticalEvent e1, CriticalEvent e2, Class clazz) {
		if (!coreG.containsVertex(e1)) {
			coreG.addVertex(e1);
		}
		if (!coreG.containsVertex(e2)) {
			coreG.addVertex(e2);
		}
		if (!coreG.containsEdge(e1, e2)) {
			return coreG.addEdge_edgetype_lpxz(e1, e2, clazz);
		}
		else {
			return coreG.getEdge(e1, e2);
		}
	}

	public  void removeSharedAccessEdges()
	{
		List<CausalEdge> edges =CausalGraphTraversal.getSharedAccessEdges(this);
		for(CausalEdge edge : edges)
		{
			this.coreG.removeEdge(edge);
		}
	}
	static DOTExporter<CriticalEvent, CausalEdge> dotEx = new DOTExporter<CriticalEvent, CausalEdge>();

	public void exportCausalGraph(String filename) {

		File file = new File(filename);
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			dotEx.export4CausalGraph(fw, coreG);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Set<CriticalEvent> outgoingNodesOf(CausalGraph cg, CriticalEvent ce)
	{
		Set<CriticalEvent> events = new  HashSet<CriticalEvent>();
		Set<CausalEdge> edges =cg.coreG.outgoingEdgesOf(ce);
		for(CausalEdge edge : edges)
		{
			events.add((CriticalEvent)edge.getTarget());
		}
		return events;
	}
	// public void addEdge(CriticalEvent e1, CriticalEvent e2 )
	// {
	// if(!coreG.containsVertex(e1))
	// { coreG.addVertex(e1);}
	// if(!coreG.containsVertex(e2))
	// {
	// coreG.addVertex(e2);
	// }
	// if(!coreG.containsEdge(e1, e2))
	// {
	// coreG.addEdge(e1, e2);
	// }
	// }
	// public static void test1()
	// {
	// CausalGraph cg = new CausalGraph();
	// CriticalEvent e1 = new SharedAccessEvent(Thread.currentThread().getId(),
	// -1);
	// CriticalEvent e2 = new CommunicationEvent();
	// CriticalEvent e3 = new CommunicationEvent();
	// CriticalEvent e4 = new SharedAccessEvent();
	//
	// cg.addVertex(e1);
	// cg.addVertex(e2);
	// cg.addVertex(e3);
	// cg.addVertex(e4);
	//
	//
	//
	// cg.addEdge_edgetype(e1, e2, LocalCausalEdge.class);
	// cg.addEdge_edgetype(e3, e4, LocalCausalEdge.class);
	// cg.addEdge_edgetype(e2, e3, CommunicationCausalEdge.class);
	//
	// System.out.println(cg.coreG.outgoingEdgesOf(e2).size());
	// cg.exportCausalGraph("test.dot");
	// }

	public static void main(String[] args) {

	}

}
