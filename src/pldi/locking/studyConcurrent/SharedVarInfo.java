package pldi.locking.studyConcurrent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import pldi.locking.LockRegionMUVIMiner;

import soot.SootField;
import soot.Value;

public class SharedVarInfo {

	public static ArrayList<StaVarInfo> staPrimVarSet = new ArrayList<StaVarInfo>();

	public static ArrayList<StaVarInfo> staRefVarSet = new ArrayList<StaVarInfo>();

	public static ArrayList<InsVarInfo> insPrimVarSet = new ArrayList<InsVarInfo>();

	public static ArrayList<InsVarInfo> insRefVarSet = new ArrayList<InsVarInfo>();

	public static int methodNum;

	public static int synMethodNum;

	public static int synBlockNum;

	public static int lockNum;
	
	public static int threadNum;
	
	public static int staReadsNum;
	
	public static int insReadsNum;
	
	public static int staWritesNum;
	
	public static int insWritesNum;
	
	public static int sharedStaReadsNum;
	
	public static int sharedInsReadsNum;
	
	public static int sharedProtectedStaReadsNum;

	public static int sharedProtectedInsReadsNum;
	
	public static int sharedStaWritesNum;
	
	public static int sharedInsWritesNum;
	
	public static int sharedProtectedStaWritesNum;

	public static int sharedProtectedInsWritesNum;
	
	public static ArrayList<SynMethodInfo> synMethodRWNum = new ArrayList<SynMethodInfo>();
	
	public static ArrayList<SynBlockInfo> synBlockRWNum = new ArrayList<SynBlockInfo>();
	
	public static ArrayList<LockInfo> lockRWNum = new ArrayList<LockInfo>();
	
	public static ArrayList<ThreadInfo> threadRWNum = new ArrayList<ThreadInfo>();
	
	
	public static void addInsPrimVar(SootField sf, Value base){
		for(InsVarInfo vi : insPrimVarSet) {
			if(vi.getSootfield().equals(sf)){
				vi.addInsVar(base);
				return;
			}
		}
	}

	public static void addInsPrimVarRead(SootField sf, Value base) {
		for (InsVarInfo vi : insPrimVarSet) {
			if (vi.getSootfield().equals(sf)){
				vi.readplus(base);
				return;
			}
		}
	}

	public static void addInsPrimVarWrite(SootField sf, Value base) {
		for (InsVarInfo vi : insPrimVarSet) {
			if (vi.getSootfield().equals(sf)){
				vi.writeplus(base);
				return;
			}
		}
	}

	public static void setInsPrimVarShared(SootField sf, Value base) {
		for (InsVarInfo vi : insPrimVarSet) {
			if (vi.getSootfield().equals(sf)) {
				vi.setShared(base, true);
				return;
			}
		}
	}
	
	public static void addInsRefVar(SootField sf, Value base){
		for(InsVarInfo vi : insRefVarSet) {
			if(vi.getSootfield().equals(sf)){
				vi.addInsVar(base);
				return;
			}
		}
	}

	public static void addInsRefVarRead(SootField sf, Value base) {
		for (InsVarInfo vi : insRefVarSet) {
			if (vi.getSootfield().equals(sf)){
				vi.readplus(base);
				return;
			}
		}
	}

	public static void addInsRefVarWrite(SootField sf, Value base) {
		for (InsVarInfo vi : insRefVarSet) {
			if (vi.getSootfield().equals(sf)){
				vi.writeplus(base);
				return;
			}
		}
	}

	public static void setInsRefVarShared(SootField sf, Value base) {
		for (InsVarInfo vi : insRefVarSet) {
			if (vi.getSootfield().equals(sf)) {
				vi.setShared(base, true);
				return;
			}
		}
	}

	public static void addStaPrimVarRead(SootField sf) {
		for (StaVarInfo vi : staPrimVarSet) {
			if (vi.getSootfield().equals(sf)){
				vi.readplus();
				return;
			}
		}
	}

	public static void addStaPrimVarWrite(SootField sf) {
		for (StaVarInfo vi : staPrimVarSet) {
			if (vi.getSootfield().equals(sf)){
				vi.writeplus();
				return;
			}
		}
	}

	public static void setStaPrimVarShared(SootField sf) {
		for (StaVarInfo vi : staPrimVarSet) {
			if (vi.getSootfield().equals(sf)){
				vi.setShared(true);
				return;
			}
		}
	}

	public static void addStaRefVarRead(SootField sf) {
		for (StaVarInfo vi : staRefVarSet) {
			if (vi.getSootfield().equals(sf)){
				vi.readplus();
				return;
			}
		}
	}

	public static void addStaRefVarWrite(SootField sf) {
		for (StaVarInfo vi : staRefVarSet) {
			if (vi.getSootfield().equals(sf)){
				vi.writeplus();
				return;
			}
		}
	}

	public static void setStaRefVarShared(SootField sf) {
		for (StaVarInfo vi : staRefVarSet) {
			if (vi.getSootfield().equals(sf)){
				vi.setShared(true);
				return;
			}
		}
	}
	
	public static void addSynMethod(SynMethod sm){
		for(SynMethodInfo smi : synMethodRWNum){
			if(smi.getSynMethod().equals(sm))
				return;
		}
		synMethodRWNum.add(new SynMethodInfo(sm));
	}

	public static void addSynMethodRead(SynMethod sm) {
		for (SynMethodInfo smi : synMethodRWNum) {
			if (smi.getSynMethod().equals(sm)){
				smi.addSharedRead();
				return;
			}
		}
	}

	public static void addSynMethodWrite(SynMethod sm) {
		for (SynMethodInfo smi : synMethodRWNum) {
			if (smi.getSynMethod().equals(sm)){
				smi.addSharedWrite();
				return;
			}
		}
	}
	
	public static void addSynBlock(SynBlock synBlock){
		for(SynBlockInfo sbi: synBlockRWNum){
			if(sbi.getSynBlock().equals(synBlock))
				return;
		}
		synBlockRWNum.add(new SynBlockInfo(synBlock));
	}
	
	public static void addSynBlockRead(SynBlock synBlock){
		for(SynBlockInfo sbi: synBlockRWNum){
			if(sbi.getSynBlock().equals(synBlock)){
				sbi.addSharedRead();
				return;
			}
		}
	}
	
	public static void addSynBlockWrite(SynBlock synBlock){
		for(SynBlockInfo sbi: synBlockRWNum){
			if(sbi.getSynBlock().equals(synBlock)){
				sbi.addSharedWrite();
				return;
			}
		}
	}
	
	public static void addLock(LockDetail lockDetail){
		for(LockInfo li: lockRWNum){
			if(li.getLockDetail().equals(lockDetail))
				return;
		}
		lockRWNum.add(new LockInfo(lockDetail));
	}
	
	public static void addLockRead(LockDetail lockDetail){
		for(LockInfo li: lockRWNum){
			if(li.getLockDetail().equals(lockDetail)){
				li.addSharedRead();
				return;
			}
		}
	}
	
	public static void addLockWrite(LockDetail lockDetail){
		for(LockInfo li: lockRWNum){
			if(li.getLockDetail().equals(lockDetail)){
				li.addSharedWrite();
				return;
			}
		}
	}
	
	public static void addStaReadsNum(){
		staReadsNum++;
	}
	
	public static void addInsReadsNum(){
		insReadsNum++;
	}
	public static void addStaWritesNum(){
		staWritesNum++;
	}
	
	public static void addInsWritesNum(){
		insWritesNum++;
	}
	
	
	public static void addSharedStaReadsNum(){
		sharedStaReadsNum++;
	}
	
	public static void addSharedInsReadsNum(){
		sharedInsReadsNum++;
	}
	
	public static void addSharedProStaReadsNum(){
		sharedProtectedStaReadsNum++;
	}
	
	public static void addSharedProInsReadsNum(){
		sharedProtectedInsReadsNum++;
	}
	
	public static void addSharedStaWritesNum(){
		sharedStaWritesNum++;
	}
	
	public static void addSharedInsWritesNum(){
		sharedInsWritesNum++;
	}
	
	public static void addSharedProStaWritesNum(){
		sharedProtectedStaWritesNum++;
	}
	
	public static void addSharedProInsWritesNum(){
		sharedProtectedInsWritesNum++;
	}
	
	public static void addThread(ThreadDetail threadDetail){
		for(ThreadInfo ti: threadRWNum){
			if(ti.getThreadDetail().equals(threadDetail))
				return;
		}
		threadRWNum.add(new ThreadInfo(threadDetail));
	}
	
	public static void addThreadRead(ThreadDetail threadDetail){
		for(ThreadInfo ti: threadRWNum){
			if(ti.getThreadDetail().equals(threadDetail)){
				ti.addSharedRead();
				return;
			}
		}
	}
	
	public static void addThreadWrite(ThreadDetail threadDetail){
		for(ThreadInfo ti: threadRWNum){
			if(ti.getThreadDetail().equals(threadDetail)){
				ti.addSharedWrite();
				return;
			}
		}
	}
	
	public static void printQ16Info() throws Exception{
		File questionB = new File("QuestionB1-6.txt");
		if(!questionB.exists())
			questionB.createNewFile();
		PrintWriter pw=new PrintWriter(new FileWriter(questionB),true);
		
		System.out.println("\n\nQB 1-6:");
		pw.println("QuestionB 1-6:");
		
		System.out.println("\nStaticPrimVariable:");
		pw.println("\nStaticPrimVariable:");
		
		int sharedStaPrimVarNum = 0;
		for(StaVarInfo vi:staPrimVarSet){
			if(vi.isShared())
				sharedStaPrimVarNum++;
			System.out.println(vi.toString());
			pw.println(vi.toString());
		}
		System.out.println("Static Primitive Variable Shared/Total: " + sharedStaPrimVarNum + "/" + staPrimVarSet.size());
		pw.println("Static Primitive Variable Shared/Total: " + sharedStaPrimVarNum + "/" + staPrimVarSet.size());
		
		System.out.println("\nStaticRefVariable:");
		pw.println("\nStaticRefVariable:");
		
		int sharedStaRefVarNum = 0;
		for(StaVarInfo vi:staRefVarSet){
			if(vi.isShared())
				sharedStaRefVarNum++;
			System.out.println(vi.toString());
			pw.println(vi.toString());
		}
		System.out.println("Static Reference Variable Shared/Total: " + sharedStaRefVarNum + "/" + staRefVarSet.size());
		pw.println("Static Reference Variable Shared/Total: " + sharedStaRefVarNum + "/" + staRefVarSet.size());
		
		System.out.println("\nInstancePrimVariable:");
		pw.println("\nInstancePrimVariable:");
		
		int sharedInsPrimVarNum = 0;
		for(InsVarInfo vi:insPrimVarSet){
			for(InsVarDetail ivd: vi.getDetail()){
				if(ivd.isShared()){
					sharedInsPrimVarNum++;
					break;
				}
			}
			System.out.println(vi.toString());
			pw.println(vi.toString());
		}
		System.out.println("Instance Primitive Variable Shared/Total: " + sharedInsPrimVarNum + "/" + insPrimVarSet.size());
		pw.println("Instance Primitive Variable Shared/Total: " + sharedInsPrimVarNum + "/" + insPrimVarSet.size());

		System.out.println("\nInstanceRefVariable:");
		pw.println("\nInstanceRefVariable:");
		
		int sharedInsRefVarNum = 0;
		for(InsVarInfo vi:insRefVarSet){
			for(InsVarDetail ivd: vi.getDetail()){
				if(ivd.isShared()){
					sharedInsRefVarNum++;
					break;
				}
			}
			System.out.println(vi.toString());
			pw.println(vi.toString());
		}
		System.out.println("Instance Reference Variable Shared/Total: " + sharedInsRefVarNum + "/" + insRefVarSet.size());
		pw.println("Instance Reference Variable Shared/Total: " + sharedInsRefVarNum + "/" + insRefVarSet.size());

		System.out.println("\nStaFieldReads/Shared/Protected: " + staReadsNum + "/" + sharedStaReadsNum + "/" + sharedProtectedStaReadsNum);
		System.out.println("\nInsFieldReads/Shared/Protected: " + insReadsNum + "/" + sharedInsReadsNum + "/" + sharedProtectedInsReadsNum);
		System.out.println("\nStaFieldWrites/Shared/Protected: " + staWritesNum + "/" + sharedStaWritesNum + "/" + sharedProtectedStaWritesNum);
		System.out.println("\nInsFieldWrites/Shared/Protected: " + insWritesNum + "/" + sharedInsWritesNum + "/" + sharedProtectedInsWritesNum);
		
		//print Lock info
		System.out.println("\nmethodNum/synMethodNum/synBlockNum/lockNum: "
				+ methodNum + "/" + synMethodNum + "/" + synBlockNum + "/"
				+ lockNum);
		pw.println("\nmethodNum/synMethodNum/synBlockNum/lockNum: "
				+ methodNum + "/" + synMethodNum + "/" + synBlockNum + "/"
				+ lockNum);
		System.out.println("\nsynMethod Detail:");
		pw.println("\nsynMethod Detail:");
		
		for(SynMethodInfo smi:synMethodRWNum){
			System.out.println(smi.toString());
			pw.println(smi.toString());
			System.out.println();
			pw.println();
		}
		
		System.out.println("\nsynBlock Detail:");
		pw.println("\nsynBlock Detail:");
		
		for(SynBlockInfo sbi:synBlockRWNum){
			System.out.println(sbi.toString());
			pw.println(sbi.toString());
			System.out.println();
			pw.println();
		}
		
		System.out.println("\nlock Detail:");
		pw.println("\nlock Detail:");
		for(LockInfo li:lockRWNum){
			System.out.println(li.toString());
			pw.println(li.toString());
			System.out.println();
			pw.println();
		}
		
		pw.close();
	}
	
	public static void printQ7Info() throws Exception{
		File questionB = new File("QuestionB7.txt");
		if(!questionB.exists())
			questionB.createNewFile();
		PrintWriter pw=new PrintWriter(new FileWriter(questionB),true);
		
		System.out.println("\n\nQB 7:");
		pw.println("QB 7:");
		
		System.out.println("\nStaticPrimVariable:");
		for(StaVarInfo vi:staPrimVarSet)
			System.out.println(vi.toString());
		
		System.out.println("\nStaticRefVariable:");
		for(StaVarInfo vi:staRefVarSet)
			System.out.println(vi.toString());
		
		System.out.println("\nInstancePrimVariable:");
		for(InsVarInfo vi:insPrimVarSet)
			System.out.println(vi.toString());
		
		System.out.println("\nInstanceRefVariable:");
		for(InsVarInfo vi:insRefVarSet)
			System.out.println(vi.toString());
		
		//print Lock info
		System.out.println("\nmethodNum/synMethodNum/synBlockNum/lockNum: "
				+ methodNum + "/" + synMethodNum + "/" + synBlockNum + "/"
				+ lockNum);
		System.out.println("\nsynMethod Detail:");
		for(SynMethodInfo smi:synMethodRWNum){
			System.out.println(smi.toString());
			System.out.println();
		}
		
		System.out.println("\nsynBlock Detail:");
		for(SynBlockInfo sbi:synBlockRWNum){
			System.out.println(sbi.toString());
			System.out.println();
		}
		
		System.out.println("\nlock Detail:");
		for(LockInfo li:lockRWNum){
			System.out.println(li.toString());
			System.out.println();
		}
		
		//print Thread info
		System.out.println("\nthreadNum: "
				+ threadNum);
		pw.println("\nthreadNum: "
				+ threadNum);
		
		System.out.println("\nthread Detail:");
		pw.println("\nthread Detail:");
		
		for(ThreadInfo ti:threadRWNum){
			System.out.println(ti.toString());
			pw.println(ti.toString());
			
			System.out.println();
			pw.println();
		}
		pw.close();
	}
	private static void dumpItemSet(String itemset, String filename) {
		
		  try{
			  // Create file 
			  FileWriter fstream = new FileWriter(filename);
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write(itemset);
			  //Close the output stream
			  out.close();
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		
	}
	
	public static void printQ16BriefInfo() throws Exception{

		File questionB = new File("QuestionBBrief1-6.txt");
		if(!questionB.exists())
			questionB.createNewFile();
		PrintWriter pw=new PrintWriter(new FileWriter(questionB),true);
		
		System.out.println("\n\nQB 1-6 Brief:");
		pw.println("\n\nQB 1-6 Brief:");
		
		int sharedStaPrimVarNum = 0;
		for(StaVarInfo vi:staPrimVarSet){
			if(vi.isShared())
				sharedStaPrimVarNum++;
		}
		System.out.println("\nStatic Primitive Variable Shared/Total: " + sharedStaPrimVarNum + "/" + staPrimVarSet.size());
		pw.println("\nStatic Primitive Variable Shared/Total: " + sharedStaPrimVarNum + "/" + staPrimVarSet.size());
		
		
		int sharedStaRefVarNum = 0;
		for(StaVarInfo vi:staRefVarSet){
			if(vi.isShared())
				sharedStaRefVarNum++;
		}
		System.out.println("\nStatic Reference Variable Shared/Total: " + sharedStaRefVarNum + "/" + staRefVarSet.size());
		pw.println("\nStatic Reference Variable Shared/Total: " + sharedStaRefVarNum + "/" + staRefVarSet.size());
		
		
		int sharedInsPrimVarNum = 0;
		for(InsVarInfo vi:insPrimVarSet){
			for(InsVarDetail ivd: vi.getDetail()){
				if(ivd.isShared()){
					sharedInsPrimVarNum++;
					break;
				}
			}
		}
		System.out.println("\nInstance Primitive Variable Shared/Total: " + sharedInsPrimVarNum + "/" + insPrimVarSet.size());
		pw.println("\nInstance Primitive Variable Shared/Total: " + sharedInsPrimVarNum + "/" + insPrimVarSet.size());

		int sharedInsRefVarNum = 0;
		for(InsVarInfo vi:insRefVarSet){
			for(InsVarDetail ivd: vi.getDetail()){
				if(ivd.isShared()){
					sharedInsRefVarNum++;
					break;
				}
			}
		}
		System.out.println("\nInstance Reference Variable Shared/Total: " + sharedInsRefVarNum + "/" + insRefVarSet.size());
		pw.println("\nInstance Reference Variable Shared/Total: " + sharedInsRefVarNum + "/" + insRefVarSet.size());

		System.out.println("\nStaFieldReads/Shared/Protected: " + staReadsNum + "/" + sharedStaReadsNum + "/" + sharedProtectedStaReadsNum);
		System.out.println("\nInsFieldReads/Shared/Protected: " + insReadsNum + "/" + sharedInsReadsNum + "/" + sharedProtectedInsReadsNum);
		System.out.println("\nStaFieldWrites/Shared/Protected: " + staWritesNum + "/" + sharedStaWritesNum + "/" + sharedProtectedStaWritesNum);
		System.out.println("\nInsFieldWrites/Shared/Protected: " + insWritesNum + "/" + sharedInsWritesNum + "/" + sharedProtectedInsWritesNum);
		pw.println("\nStaFieldReads/Shared/Protected: " + staReadsNum + "/" + sharedStaReadsNum + "/" + sharedProtectedStaReadsNum);
		pw.println("\nInsFieldReads/Shared/Protected: " + insReadsNum + "/" + sharedInsReadsNum + "/" + sharedProtectedInsReadsNum);
		pw.println("\nStaFieldWrites/Shared/Protected: " + staWritesNum + "/" + sharedStaWritesNum + "/" + sharedProtectedStaWritesNum);
		pw.println("\nInsFieldWrites/Shared/Protected: " + insWritesNum + "/" + sharedInsWritesNum + "/" + sharedProtectedInsWritesNum);
		
		{
			//lpxz
			 String rawData = "/home/lpxz/eclipse/workspace/soot24/sharedanalysis/"+ SharedVariableStatistic.currentBM;
             String itemset="\nStatic Primitive Variable Shared/Total: " + sharedStaPrimVarNum + "/" + staPrimVarSet.size()+"\n" 
            	            +"\nStatic Reference Variable Shared/Total: " + sharedStaRefVarNum + "/" + staRefVarSet.size() +"\n" 
            	             +"\nInstance Primitive Variable Shared/Total: " + sharedInsPrimVarNum + "/" + insPrimVarSet.size()+"\n"
            	            +"\nInstance Reference Variable Shared/Total: " + sharedInsRefVarNum + "/" + insRefVarSet.size() + "\n"
                            + "\nStaFieldReads/Shared/: " + staReadsNum + "/" + sharedStaReadsNum + "/" +  "\n"
                            + "\nInsFieldReads/Shared/: " + insReadsNum + "/" + sharedInsReadsNum + "/" + "\n"
                    		+ "\nStaFieldWrites/Shared/: " + staWritesNum + "/" + sharedStaWritesNum + "/" + "\n"
                    		+ "\nInsFieldWrites/Shared/: " + insWritesNum + "/" + sharedInsWritesNum + "/" ;
		     dumpItemSet(itemset ,rawData);
		}
		//print Lock info
		System.out.println("\nmethodNum/synMethodNum/synBlockNum/lockNum: "
				+ methodNum + "/" + synMethodNum + "/" + synBlockNum + "/"
				+ lockNum);
		pw.println("\nmethodNum/synMethodNum/synBlockNum/lockNum: "
				+ methodNum + "/" + synMethodNum + "/" + synBlockNum + "/"
				+ lockNum);
		
		
		System.out.println("\nsynMethod Detail:");
		pw.println("\nsynMethod Detail:");
		
		int maxSynMethodReadNum = 0;
		int minSynMethodReadNum = 0;
		double aveSynMethodReadNum = 0;
		int maxSynMethodWriteNum = 0;
		int minSynMethodWriteNum = 0;
		double aveSynMethodWriteNum = 0;
		if(synMethodRWNum.size()>0){
			maxSynMethodReadNum = synMethodRWNum.get(0).getSharedReadNum();
			minSynMethodReadNum = synMethodRWNum.get(0).getSharedReadNum();
			maxSynMethodWriteNum = synMethodRWNum.get(0).getSharedWriteNum();
			minSynMethodWriteNum = synMethodRWNum.get(0).getSharedWriteNum();
		}
		for(SynMethodInfo smi:synMethodRWNum){
			if(smi.getSharedReadNum()>maxSynMethodReadNum)
				maxSynMethodReadNum = smi.getSharedReadNum();
			if(smi.getSharedReadNum()<minSynMethodReadNum)
				minSynMethodReadNum = smi.getSharedReadNum();
			aveSynMethodReadNum +=smi.getSharedReadNum();
			
			if(smi.getSharedWriteNum()>maxSynMethodWriteNum)
				maxSynMethodWriteNum = smi.getSharedWriteNum();
			if(smi.getSharedWriteNum()<minSynMethodWriteNum)
				minSynMethodWriteNum = smi.getSharedWriteNum();
			aveSynMethodWriteNum +=smi.getSharedWriteNum();
//			System.out.println(smi.toString());
//			System.out.println();
		}
		if(synMethodRWNum.size()>0){
			System.out.println("\nsynMethodSharedRead max/min/average: "+ maxSynMethodReadNum+"/"+minSynMethodReadNum+"/"+aveSynMethodReadNum/synMethodRWNum.size());
			System.out.println("\nsynMethodSharedWrite max/min/average: "+ maxSynMethodWriteNum+"/"+minSynMethodWriteNum+"/"+aveSynMethodWriteNum/synMethodRWNum.size());
			pw.println("\nsynMethodSharedRead max/min/average: "+ maxSynMethodReadNum+"/"+minSynMethodReadNum+"/"+aveSynMethodReadNum/synMethodRWNum.size());
			pw.println("\nsynMethodSharedWrite max/min/average: "+ maxSynMethodWriteNum+"/"+minSynMethodWriteNum+"/"+aveSynMethodWriteNum/synMethodRWNum.size());
		}
		
		
		
		System.out.println("\nsynBlock Detail:");
		pw.println("\nsynBlock Detail:");
		
		int maxSynBlockReadNum = 0;
		int minSynBlockReadNum = 0;
		double aveSynBlockReadNum = 0;
		int maxSynBlockWriteNum = 0;
		int minSynBlockWriteNum = 0;
		double aveSynBlockWriteNum = 0;
		if(synBlockRWNum.size()>0){
			maxSynBlockReadNum = synBlockRWNum.get(0).getSharedReadNum();
			minSynBlockReadNum = synBlockRWNum.get(0).getSharedReadNum();
			maxSynBlockWriteNum = synBlockRWNum.get(0).getSharedWriteNum();
			minSynBlockWriteNum = synBlockRWNum.get(0).getSharedWriteNum();
		}
		for(SynBlockInfo sbi:synBlockRWNum){
			if(sbi.getSharedReadNum()>maxSynBlockReadNum)
				maxSynBlockReadNum = sbi.getSharedReadNum();
			if(sbi.getSharedReadNum()<minSynBlockReadNum)
				minSynBlockReadNum = sbi.getSharedReadNum();
			aveSynBlockReadNum +=sbi.getSharedReadNum();
			
			if(sbi.getSharedWriteNum()>maxSynBlockWriteNum)
				maxSynBlockWriteNum = sbi.getSharedWriteNum();
			if(sbi.getSharedWriteNum()<minSynBlockWriteNum)
				minSynBlockWriteNum = sbi.getSharedWriteNum();
			aveSynBlockWriteNum +=sbi.getSharedWriteNum();
//			System.out.println(sbi.toString());
//			System.out.println();
		}
		if(synBlockRWNum.size()>0){
			System.out.println("\nsynBlockSharedRead max/min/average: "+ maxSynBlockReadNum+"/"+minSynBlockReadNum+"/"+aveSynBlockReadNum/synBlockRWNum.size());
			System.out.println("\nsynBlockSharedWrite max/min/average: "+ maxSynBlockWriteNum+"/"+minSynBlockWriteNum+"/"+aveSynBlockWriteNum/synBlockRWNum.size());
			pw.println("\nsynBlockSharedRead max/min/average: "+ maxSynBlockReadNum+"/"+minSynBlockReadNum+"/"+aveSynBlockReadNum/synBlockRWNum.size());
			pw.println("\nsynBlockSharedWrite max/min/average: "+ maxSynBlockWriteNum+"/"+minSynBlockWriteNum+"/"+aveSynBlockWriteNum/synBlockRWNum.size());
		}
		
		
		System.out.println("\nlock Detail:");
		pw.println("\nlock Detail:");
		
		int maxLockReadNum = 0;
		int minLockReadNum = 0;
		double aveLockReadNum = 0;
		int maxLockWriteNum = 0;
		int minLockWriteNum = 0;
		double aveLockWriteNum = 0;
		if(lockRWNum.size()>0){
			maxLockReadNum = lockRWNum.get(0).getSharedReadNum();
			minLockReadNum = lockRWNum.get(0).getSharedReadNum();
			maxLockWriteNum = lockRWNum.get(0).getSharedWriteNum();
			minLockWriteNum = lockRWNum.get(0).getSharedWriteNum();
		}
		for(LockInfo li:lockRWNum){
			if(li.getSharedReadNum()>maxLockReadNum)
				maxLockReadNum = li.getSharedReadNum();
			if(li.getSharedReadNum()<minLockReadNum)
				minLockReadNum = li.getSharedReadNum();
			aveLockReadNum +=li.getSharedReadNum();
			
			if(li.getSharedWriteNum()>maxLockWriteNum)
				maxLockWriteNum = li.getSharedWriteNum();
			if(li.getSharedWriteNum()<minLockWriteNum)
				minLockWriteNum = li.getSharedWriteNum();
			aveLockWriteNum +=li.getSharedWriteNum();
//			System.out.println(li.toString());
//			System.out.println();
		}
		if(lockRWNum.size()>0){
			System.out.println("\nlockSharedRead max/min/average: "+ maxLockReadNum+"/"+minLockReadNum+"/"+aveLockReadNum/lockRWNum.size());
			System.out.println("\nlockSharedWrite max/min/average: "+ maxLockWriteNum+"/"+minLockWriteNum+"/"+aveLockWriteNum/lockRWNum.size());
			pw.println("\nlockSharedRead max/min/average: "+ maxLockReadNum+"/"+minLockReadNum+"/"+aveLockReadNum/lockRWNum.size());
			pw.println("\nlockSharedWrite max/min/average: "+ maxLockWriteNum+"/"+minLockWriteNum+"/"+aveLockWriteNum/lockRWNum.size());
		}
		
	}
}
