package pldi.locking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;

import ca.pfv.spmf.tests.MainTestDCI_Closed_Optimized;

import pldi.AHG.AHGAtomicSetTosser;
import pldi.locking.*;
import polyglot.ast.New;
import polyglot.frontend.VisitorPass;

import AA.SootUtil;
import Drivers.Setup;
import Drivers.Utils;
import soot.AnySubType;
import soot.ArrayType;
import soot.Body;
import soot.BodyTransformer;
import soot.EntryPoints;
import soot.G;
import soot.Local;
import soot.Modifier;
import soot.NullType;
import soot.Pack;
import soot.PackManager;
import soot.PatchingChain;
import soot.PointsToAnalysis;
import soot.PointsToSet;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Transform;
import soot.Type;
import soot.Unit;
import soot.jimple.ArrayRef;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.internal.JReturnStmt;
import soot.jimple.internal.JReturnVoidStmt;
import soot.jimple.internal.RValueBox;

import soot.jimple.spark.pag.Node;
import soot.jimple.spark.pag.PAG;
import soot.jimple.spark.sets.BitPointsToSet;
import soot.jimple.spark.sets.DoublePointsToSet;
import soot.jimple.spark.sets.HashPointsToSet;
import soot.jimple.spark.sets.HybridPointsToSet;
import soot.jimple.spark.sets.P2SetVisitor;
import soot.jimple.spark.sets.PointsToSetInternal;
import soot.jimple.toolkits.pointer.CodeBlockRWSet;
import soot.jimple.toolkits.pointer.RWSet;
import soot.jimple.toolkits.pointer.SideEffectAnalysis;
import soot.jimple.toolkits.thread.ThreadLocalObjectsAnalysis;
import soot.jimple.toolkits.thread.mhp.MhpTester;
import soot.jimple.toolkits.thread.mhp.SynchObliviousMhpAnalysis;

import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;
import soot.options.Options;
import soot.toolkits.graph.BlockGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.ZonedBlockGraph;
import soot.toolkits.graph.pdg.RegionAnalysis;
import soot.toolkits.scalar.FlowSet;
import soot.util.Chain;

public class LockRegionMUVIMiner_noXML_SEsetRep {
	public static boolean typebased= false; //;System.getProperty("typebased.option").equals("true");
	static String curApp = "";//System.getProperty("current.application");
	
	 static  int curMS =2; // Integer.valueOf(curMinSupport);
	
	   
		public static String varName = "";
		public static  String methName = "";
	

	protected static boolean optionOpenNesting = false;
	protected static boolean RWtogether = true;
	public static HashMap methodToExcUnitGraph = new HashMap();// run only once
																// after all
	public static HashMap methodToFlowSet = new HashMap();// run only once after
															// all

	public static HashMap field2Id = new HashMap();
	public static HashMap id2field =null;
	public static int curId = 0;

	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link LockProducer


		
		int benchmark =9;// 7 has a problem in locating the local variable
		String interString = "";
		switch (benchmark) {
        case 1:  
        	interString = "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Bayes.Bayes"; // java.lang.Math
		     {varName  = "learnerPtr";  methName  ="main";}
		     break;
        case 2:	     
        	interString = "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Genome.Genome"; // java.lang.Math
		    {varName  = "g";  methName  ="main";}
		    break;
        case 3:
        	interString =  "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Intruder.Intruder"; // java.lang.Math
		    {varName  = "argPtr";  methName  ="processPackets";}
		    break;
        case 4:
        	interString ="-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app KMeans.KMeans"; // java.lang.Math
	         { varName  = "args";  methName  ="work";}
	         break;
        case 5: 
        	interString = "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Labyrinth3D.Labyrinth"; // java.lang.Math
	     	{ varName  = "argPtr";  methName  ="solve";}
	     	break ;
        case 6:
        	interString = "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app MatrixMultiply.MatrixMultiply"; // java.lang.Math
		    { varName  = "matrix";  methName  ="main";}
		    break;
        case 7:
			 interString ="-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app SSCA2.SSCA2"; // java.lang.Math
	    	{ varName  = "tmp3";  methName  ="run";} // tmp1, tmp2, tmp3
	    	break; 
        case 8:
        	 interString= "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Vacation.Vacation"; // java.lang.Math
			{ varName  = "managerPtr";  methName  ="run";} // tmp1, tmp2, tmp3
			break;
        case 9:
        	 interString="-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Yada.java.yada"; // java.lang.Math
			{ varName  = "workHeapPtr";  methName  ="process";} // meshPtr,workHeapPtr
			break;
	    default:
	    	System.out.println("what benchmarks to process?");
		}
			
			

		

		String[] finalArgs = interString.split(" ");

		soot.Main.v().processCmdLine(finalArgs);
		
	
		
		List excludesList= new ArrayList();
		excludesList.add("jrockit.");
		excludesList.add("com.bea.jrockit");
		excludesList.add("sun.");
		Options.v().set_exclude(excludesList);
		
	///	Options.v().set_output_dir("paddle_public.jar");
	//	Options.v().set_output_jar(true);// same as the name as the outdir (actually substitue it), so must be set.

		 Setup.setupPatchOptions();
		Scene.v().loadNecessaryClasses();
		// Setup.setPhaseOptionsForPaddleWork();
		Setup.setPhaseOptionsForSparkWork();	
		
		Pack wjtp = PackManager.v().getPack("wjtp");
		//addMethodLocker2wjtp(wjtp);		
		addMUVIPackToWJtp(wjtp);
		
		PackManager.v().runPacks();// 1
		G.v().reset();  // memory
	//	PackManager.v().writeOutput();
	}

	private static void addMethodLocker2wjtp(Pack wjtp) {
		wjtp.add(new Transform("wjtp.SM2SB",
				new SceneTransformer() {
					
					@Override
					protected void internalTransform(String phaseName, Map options) {						 
						
					Chain<SootClass> scs =Scene.v().getApplicationClasses();
					for(SootClass sc : scs)
					{
					    List<SootMethod> sms =sc.getMethods();
					    for(SootMethod sm:sms)
					    {
					    	  if(sm.isSynchronized())
							  {
								  
								  {
									  sm.setModifiers(sm.getModifiers() & ~Modifier.SYNCHRONIZED);
									  if(sm.hasActiveBody())
									  {
										 Body body = sm.getActiveBody();
										 PatchingChain<Unit> units = body.getUnits();
										 Stmt firstNon =body.getFirstNonIdentityStmt();
										 if(firstNon instanceof JReturnStmt || firstNon instanceof JReturnVoidStmt)
										 {// the empty body incurs problems during the lock injection.
											 Stmt nop=Jimple.v().newNopStmt();
											 units.insertBefore(nop, firstNon);									 
										 }	
										 MethodLocker.addlock(sm);
									  }							  
									 
								  }
								
							  }
					    }
					}
						
						
					}
				}));
		
	}

	protected static HashMap tn2SE = new HashMap();

	// List entryPoints=EntryPoints.v().methodsOfApplicationClasses();
	// List mainEntries = new ArrayList();
	// for(int i=0;i< entryPoints.size(); i++)
	// {
	// if(entryPoints.get(i).toString().contains("main"))
	// {
	// mainEntries.add(entryPoints.get(i));
	// }
	// }
	//
	// soot.Scene.v().setEntryPoints(mainEntries); // process : app and its
	// reachable methods.

	public static void addMUVIPackToWJtp(Pack wjtp) {

		wjtp.add(new Transform("wjtp.muvi", new SceneTransformer() {
			
			public  PointsToSet sample = null;
			List<CriticalSection> criticalSections = null;
			HashMap<CriticalSection, CodeBlockRWSet>  cs2CBSs = new HashMap<CriticalSection, CodeBlockRWSet>();
			
			List<CodeBlockRWSet> frequentCBSS = new ArrayList<CodeBlockRWSet>();

            Set<MyPair> tmpPairs = new  HashSet<MyPair>();
            
			@Override
			protected void internalTransform(String phaseName, Map options){


                    String rawData = "/home/lpxz/eclipse/workspace/soot24/smpf/"+ curApp+ "_"+ curMS+ "_smpfData";
                    String processedData = "/home/lpxz/eclipse/workspace/soot24/smpf/"+ curApp+ "_"+ curMS+"_smpfProcessed";
                    String processedReadableData = "/home/lpxz/eclipse/workspace/soot24/smpf/"+ curApp+ "_"+ curMS+"_smpfProcessedReadable";
                    dumpItemSet("", rawData);// responsible for creating the file if it is does not exist yet.
                    dumpItemSet("", processedData);// responsible for creating the file if it is does not exist yet.
                    dumpItemSet("", processedReadableData);// responsible for creating the file if it is does not exist yet.
                    
                    
                    String itemset =collectItemSet();
					dumpItemSet(itemset ,rawData);
					MainTestDCI_Closed_Optimized.DCI_close(rawData,processedData, curMS );
					String interpretedString =interpretProcessedData(processedData);
					dumpItemSet(interpretedString ,processedReadableData);
					
					//===========query now:
					System.out.println(">>>>>>>>>>>>>>>>query:");
					for(CodeBlockRWSet atomicSet: frequentCBSS)
					{
						System.out.println("atomic set:" + SootUtil.getMark(atomicSet));
						printRWSet(atomicSet, "summary: ");
						dumpASetToAHG(atomicSet);
						
						for(CriticalSection cs : criticalSections)
						{
							CodeBlockRWSet cscbs = cs2CBSs.get(cs);
							if(cscbs.hasNonEmptyInterestingIntersection(atomicSet))
							{
								System.out.println("this transaction accesses the set:"   + SootUtil.getMark(cs));
							}
							
						}
						System.out.println("");
					}			
					
			}



			
			


			private void dumpASetToAHG(CodeBlockRWSet atomicSet) {
				AHGAtomicSetTosser.p2a = Scene.v().getPointsToAnalysis();
				Local cache = null;
				
				
					Set<Local> localS= Utils.getLocals(null, methName, varName);// seems there are 6 locals in the set.. so I limit to the main scope!
					cache =(Local) localS.toArray()[0];
					
				
				
		        AHGAtomicSetTosser.atomicsetSE =atomicSet;
				AHGAtomicSetTosser.toBuildG  = new DirectedPseudograph<String, DefaultEdge>(DefaultEdge.class);			       
				AHGAtomicSetTosser.ahg_root(cache);// I wnat the graph now, graph and color at the same time
				
				File file = new File("./dot/"+  SootUtil.getMark(atomicSet)+".dot");
				System.out.println("writing to " +"./dot/"+  SootUtil.getMark(atomicSet) +".dot" );
				
				FileWriter fw;
				try { 
					fw = new  FileWriter(file);
					AHGAtomicSetTosser.dotEx.export4AHG(fw, AHGAtomicSetTosser.toBuildG);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}







			private String interpretProcessedData(String processedData) {
				//4 1 3:1
				 StringBuilder sb  = new StringBuilder();
				 try {
				      BufferedReader input =  new BufferedReader(new FileReader(processedData));
				      try {
				        String line = null; 
				        while (( line = input.readLine()) != null){
				        	String interpretedLine = interpretProcessedData_line(line);
				        	sb.append(interpretedLine);
				        	//=====formatting:
				        	
				        	sb.append(System.getProperty(("line.separator")));
				        	sb.append("**************************************************");	
				        	sb.append(System.getProperty(("line.separator")));
				        				        	
				        }
				      }
				      finally {
				        input.close();
				      }
				    }
				    catch (IOException ex){
				      ex.printStackTrace();
				    }
				    
				    return sb.toString();

				
				
			}



			
			private String interpretProcessedData_line(String line) {
				//4 1 3:1
				StringBuilder sb = new StringBuilder();
				int maohao = line.indexOf(':');
				String beforeMaoHao = line.substring(0, maohao);
				String afterMaoHao = line.substring(maohao+1);
				
				String s[] = beforeMaoHao.split(" ");
				tmpPairs.clear();
				
				 for (int i = 0; i< s.length; i++){
					    int id = Integer.parseInt(s[i]);
					    MyPair pair=getField(id);
					    tmpPairs.add(pair);
					    sb.append(pair.toString());
					    //formating
					    sb.append(System.getProperty("line.separator"));				    
				 }
				 
				CodeBlockRWSet frequentCBS= toCodeBlockRWRep(tmpPairs);
				frequentCBSS.add(frequentCBS);// we get it now
				
				
				
				 sb.append(":");
				 sb.append(afterMaoHao);
				 //formating:
				 sb.append(System.getProperty("line.separator"));
				return sb.toString();
			}






			private MyPair getField(int id) {
				if(id2field==null)
				{
				  id2field=new HashMap();
				  Iterator it=  field2Id.keySet().iterator();
				  while (it.hasNext()) {
					Object key = (Object) it.next();
					Object value = field2Id.get(key);
					id2field.put(value, key);					
				  }
				}
				return (MyPair)id2field.get(id);

			}






			private String collectItemSet() {
				StringBuilder sb = new StringBuilder();
				MhpTester mhp = new SynchObliviousMhpAnalysis();
				ThreadLocalObjectsAnalysis tlo = new ThreadLocalObjectsAnalysis(
						mhp);
				PointsToAnalysis pta = Scene.v().getPointsToAnalysis();
	           criticalSections = getCriticalSectionsFromAppClass();
				CriticalSectionAwareSideEffectAnalysis tasea = new CriticalSectionAwareSideEffectAnalysis(
						pta, Scene.v().getCallGraph(), criticalSections,
						tlo, optionOpenNesting);
				
				System.err.println(" NO of critical sections:" + criticalSections.size());

				// remove file, openfile,append mode
				Iterator<CriticalSection> tnIt = criticalSections
						.iterator();
			
				while (tnIt.hasNext()) { // foreach transaction
					// tn.read,stmtRead: CodeBlockRWSet: fields: field->
					// pointtoset
					// @LockProducer
					CriticalSection tn = tnIt.next();
					
					
					for (Unit unit : tn.units) {
						Stmt stmt = (Stmt) unit;
						HashSet uses = new HashSet();
						RWSet stmtRead = tasea.readSet(tn.method, stmt, tn,// bad tt impl!, memory
								uses);

						if (stmtRead != null)
							{
							tn.read.union(stmtRead);
						    
							}
					
						RWSet stmtWrite = tasea.writeSet(tn.method, stmt,
								tn, uses);
						if (stmtWrite != null)
						{
							tn.write.union(stmtRead);
						    
						}
							
					}
                    
					 generateSMPFData(tn,sb);
					 
				}
				System.gc();// release memory, it works
				return sb.toString();
			}



			private void generateSMPFData(CriticalSection tn, StringBuilder sb ) {
				
				CodeBlockRWSet read = tn.read;
				CodeBlockRWSet write = tn.write;
				CodeBlockRWSet together = new CodeBlockRWSet();
				if (RWtogether) {
					together.union(read);
					together.union(write);
				}
				// @Pair
				
				
				cs2CBSs.put(tn, together);
				
				
				Set<MyPair> tnpairs = toPairRep(together);
				for (MyPair p : tnpairs) {
					int id = getOrCreateId(p);
					sb.append(id);
					sb.append(" ");
				}
				if(tnpairs.size()!=0)
				{
					sb.append(System.getProperty("line.separator"));
				}
				
			}
			
			
			private CodeBlockRWSet toCodeBlockRWRep( Set<MyPair> together) {
				CodeBlockRWSet cbs = new CodeBlockRWSet();
				Set<MyPair> globals = selectGlobals(together);
				
				together.removeAll(globals);// now it contains only the instance fields
				
				for(MyPair global: globals)
				{					
					cbs.addGlobal((SootField)global.o2);
				}
				
				Map<Object, PointsToSet> instanceF2P = new  HashMap<Object, PointsToSet>();
				for(MyPair instance: together)
				{
				    Node node = (Node)instance.getO1();
				    Object f = instance.getO2();// maybe arrayelementnode
				    PointsToSetInternal returnP2S= (PointsToSetInternal) instanceF2P.get(f);
				    if(returnP2S==null)
				    {
				    	returnP2S = createPointToOnSample(node,sample);// needs type from node.
				    	instanceF2P.put(f, returnP2S);
				    }
				    returnP2S.add(node);				    
				}
				
				
				Iterator keyit =instanceF2P.keySet().iterator();
				while (keyit.hasNext()) {
					Object object = (Object) keyit.next();
					PointsToSet corrP2S=instanceF2P.get(object);
					cbs.addFieldRef(corrP2S, object);
				}
				
				return cbs;
			}

			private Set<MyPair> selectGlobals(Set<MyPair> together) {
				Set ret = new HashSet<MyPair>();
				for(MyPair pair : together)
				{
					Object o =pair.getO2();
					if(o  instanceof SootField)
					{
						SootField sf = (SootField)o;
						if(sf.isStatic())
						{
							ret.add(pair);
						}
					}
				}
				
				return ret;
				
			}






			private PointsToSetInternal createPointToOnSample(
					Node node, PointsToSet sample2) {
			    Type tt = node.getType();
			    PAG pag = (PAG)Scene.v().getPointsToAnalysis();
			    PointsToSetInternal ret = null;
				
				if(sample2 instanceof DoublePointsToSet)
				{
					ret = new DoublePointsToSet(tt, pag);
				}else if (sample2 instanceof HashPointsToSet) {
					ret = new  HashPointsToSet(tt, pag);
				}else if (sample2 instanceof HybridPointsToSet) {
					ret = new  HybridPointsToSet(tt, pag);
				}
				else if (sample2 instanceof BitPointsToSet) {
					ret = new  BitPointsToSet(tt, pag);
				}

				
				return ret;
			}






			private Set<MyPair> toPairRep(CodeBlockRWSet together) {
				final Set<MyPair> ps = new HashSet<MyPair>();
				Set globals = together.getGlobals();
				Set fset = together.getFields();
				for (Object g : globals) {
					String containingClass = "";
					if (g instanceof SootField) {
						SootField gfield = (SootField) g;
						SootClass sc = gfield.getDeclaringClass();
						containingClass = gfield.getDeclaringClass().toString();
						if (interesting(containingClass)) {
							MyPair p = new MyPair(sc, gfield);
							ps.add(p);
						}
					} else {
						throw new RuntimeException();
					}
				}

				for (final Object f : fset) {
					if (together.getBaseForField(f).isEmpty())
						continue;			
				   
					PointsToSetInternal p2s = (PointsToSetInternal) together
							.getBaseForField(f);
				
					if(sample==null)
						{sample = p2s;}
					
					p2s.forall(new P2SetVisitor() {
	
						@Override 
						public void visit(Node n) {										
						
						        Type  t =n.getType();
						//type: anysubtype, nulltype,(ignore), arraytype,reftype
								if(t instanceof AnySubType || t instanceof NullType)
								{
									return;
								}
								else if(t instanceof RefType)
								{
								   SootClass sc =((RefType)t).getSootClass();
								   if(interesting(sc.getName()))// filter for reftype!
								   {
									   if(typebased)
									   {
										   MyPair p = new MyPair(t, f);
											ps.add(p);  
									   }
									   else
									   {
										   MyPair p = new MyPair(n, f);
											ps.add(p); 
									   }
 
								   }

								}
								else
								{
									
									//System.err.println("warning: the node is not of a reftype:"+ n);
									if(typebased)
									   {
//										System.err.println(t);
//										System.err.println(f);
//										int[]
//									    ARRAY_ELEMENTS_NODE
										   MyPair p = new MyPair(t, f);
											ps.add(p);  
									   }
									   else
									   {
										   MyPair p = new MyPair(n, f);
											ps.add(p); 
									   }
								}								
									
						 }

					});			
					
				}
				return ps;
			}

			private boolean interesting(String containingClass) {
				
				List<String> excludes=Scene.v().getExcludedPackages();
				List<String> includes=Options.v().include();
				
				
				
				boolean interesting = true;
				for(String str:excludes)
				{
					if(containingClass.startsWith(str))
					{
						interesting= false;
						
					}
				}
				
				for(String str:includes)
				{
					if(containingClass.startsWith(str))
					{
						interesting= true;
						
					}
				}
				
				return interesting;
			}






			private int getOrCreateId(MyPair p) {
				if (!field2Id.containsKey(p)) {
					field2Id.put(p, ++curId);// must be positive, limitation of DCI_closed
				}
				Integer id = (Integer) field2Id.get(p);
				return id.intValue();
			}

			
			private void dumpItemSet(String itemset, String filename) {
				
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
			
			
			private List<CriticalSection> getCriticalSectionsFromAppClass() {
				List<CriticalSection> criticalSections = new Vector<CriticalSection>();
				Map<SootMethod, FlowSet> methodToFlowSet = new HashMap<SootMethod, FlowSet>();
				Map<SootMethod, ExceptionalUnitGraph> methodToExcUnitGraph = new HashMap<SootMethod, ExceptionalUnitGraph>();
				Iterator runAnalysisClassesIt = Scene.v()
						.getApplicationClasses().iterator();
				while (runAnalysisClassesIt.hasNext()) {

					SootClass appClass = (SootClass) runAnalysisClassesIt
							.next();

					// if(appClass.toString().contains("jrockit.")||appClass.toString().contains("com.bea.jrockit."))
					// {
					// System.out.println("!!!!!!!!!!!!!!!!!!");
					// continue;
					// }
					Iterator methodsIt = appClass.getMethods().iterator();
					while (methodsIt.hasNext()) {
						SootMethod method = (SootMethod) methodsIt.next();
						if (method.isConcrete()) {
							Body b = method.retrieveActiveBody();
							ExceptionalUnitGraph eug = new ExceptionalUnitGraph(
									b);
							methodToExcUnitGraph.put(method, eug);

							// run the intraprocedural analysis I want to know
							// here!
							SynchronizedRegionFinder ta = new SynchronizedRegionFinder(
									eug, b, optionOpenNesting);
							Chain units = b.getUnits();
							Unit lastUnit = (Unit) units.getLast();
							FlowSet fs = (FlowSet) ta.getFlowBefore(lastUnit);

							// add the results to the list of results
							if(!fs.isEmpty())
							{
								methodToFlowSet.put(method, fs);
							}
							
						}
					}
				}

				// Create a composite list of all transactions

				for (FlowSet fs : methodToFlowSet.values()) {
					List fList = fs.toList();
					for (int i = 0; i < fList.size(); i++)
						criticalSections
								.add(((SynchronizedRegionFlowPair) fList.get(i)).tn);
				}

				return criticalSections;
			}

			private void storeRWSet(CriticalSection tn, CodeBlockRWSet tnRSet) {
				// System.err.println("\n\n");
				CodeBlockRWSet toret = new CodeBlockRWSet();
				Set gs = tnRSet.getGlobals();
				int gnum = 0;
				for (Object g : gs) {
					String containingClass = "";
					if (g instanceof SootField) {
						SootField gfield = (SootField) g;
						containingClass = gfield.getDeclaringClass().toString();
						if (!containingClass.equals("")
								&& !containingClass.contains("java.lang")) {
							gnum++;
							toret.addGlobal(gfield);

							// System.err.println(g.toString());
						}
					} else {
						throw new RuntimeException();
						// toret.addGlobal((SootField)g);// there is no static
						// array_element_node!
						// System.err.println(g.getClass());
					}

				}
				// System.err.println(somewords +
				// "  side effect (nonjava G)#:"+gnum+"\n");

				Set fset = tnRSet.getFields();

				int nonemptyf = 0;
				for (Object f : fset) {
					if (tnRSet.getBaseForField(f).isEmpty())
						continue;
					String containingClass = "";
					if (f instanceof SootField) {
						SootField gfield = (SootField) f;
						containingClass = gfield.getDeclaringClass().toString();
						if (!containingClass.equals("")
								&& !containingClass.contains("java.lang")) {
							nonemptyf++;
							tnRSet.addFieldRef(tnRSet.getBaseForField(f), f);
							// System.err.println(f.toString());
						}
					} else {
						tnRSet.addFieldRef(tnRSet.getBaseForField(f), f);
						// System.err.println(f.getClass());
					}

				}
				tn2SE.put(tn, toret);
				// System.err.println(somewords +
				// " side effect (nonempty, nonjava fields)#"+nonemptyf);
				// return nonemptyf>0;

			}

			private boolean printRWSet(CodeBlockRWSet tnRSet, String somewords) {
				
				Set gs = tnRSet.getGlobals();
				int gnum = 0;
				for (Object g : gs) {
					String containingClass = "";
					if (g instanceof SootField) {
						SootField gfield = (SootField) g;
						containingClass = gfield.getDeclaringClass().toString();
						if (!containingClass.equals("")
								&& !containingClass.contains("java.lang")) {
							gnum++;
							System.out.println(g.toString());
						}
					} else {
						System.out.println(g.getClass());
					}

				}
				System.out.println(somewords + "side effect (nonjava G)#:"
						+ gnum );

				Set fset = tnRSet.getFields();

				int nonemptyf = 0;
				for (Object f : fset) {
					if (tnRSet.getBaseForField(f).isEmpty())
						continue;
					String containingClass = "";
					if (f instanceof SootField) {
						SootField gfield = (SootField) f;
						containingClass = gfield.getDeclaringClass().toString();
						if (!containingClass.equals("")
								&& !containingClass.contains("java.lang")) {
							nonemptyf++;
							System.out.println(f.toString());
						}
					} else {
						System.out.println(f.getClass());
					}

				}
				System.out.println(somewords
						+ " side effect (nonempty, nonjava fields)#"
						+ nonemptyf);
				return nonemptyf > 0;

			}

		}));

	}

}
