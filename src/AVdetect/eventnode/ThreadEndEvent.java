package AVdetect.eventnode;

import AVdetect.eventnode.abstractclass.CommunicationEvent;
import AVdetect.eventnode.abstractclass.LockReleEvent;

public class ThreadEndEvent extends CommunicationEvent{
//lock unlock
	
	public ThreadEndEvent(long thpara, long mempara) {
		super(thpara, mempara);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
