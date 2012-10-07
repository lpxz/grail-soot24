package Drivers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

import ca.pfv.spmf.tests.MainTestDCI_Closed_Optimized;

import pldi.locking.*;
import polyglot.ast.New;
import polyglot.frontend.VisitorPass;

import Drivers.Setup;
import Drivers.Utils;
import soot.AnySubType;
import soot.ArrayType;
import soot.Body;
import soot.BodyTransformer;
import soot.EntryPoints;
import soot.G;
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
import soot.Value;
import soot.jimple.ArrayRef;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.StringConstant;
import soot.jimple.internal.JReturnStmt;
import soot.jimple.internal.JReturnVoidStmt;
import soot.jimple.internal.RValueBox;
import soot.jimple.paddle.PaddleContextSensitiveCallGraph;
import soot.jimple.spark.pag.Node;
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

public class AddSelfReportWorker {
	public static boolean typebased= System.getProperty("typebased.option").equals("true");
	
	
	

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


		String outputFormat= args[0];
		String cpath=args[1];
		String mainClass = args[2];	
		String excludeOption = System.getProperty("exclude.option");
		String includeOption = System.getProperty("include.option");
		String reflectionOption = System.getProperty("dacapo.reflection.option");
		String reflString = reflectionOption.equals("true")?" -p cg reflection-log:"+cpath+"/refl.log":"";
		
		String jceJar = "/home/lpxz/java_standard/jre/lib/jce.jar";
		String rtJar = "/home/lpxz/java_standard/jre/lib/rt.jar";
		String argsOfmtrt = "-w -app -p cg.spark enabled -f " + outputFormat	
			    + reflString
				+ " -cp "
				+ jceJar + ":" + rtJar + ":" +cpath +":/home/lpxz/eclipse/workspace/soot24/classes"
				+ " -main-class "
				+ mainClass
				+ " "
				+ mainClass
				+excludeOption
				+includeOption
		       ;
//				+ " -d "
//				+ intermediateCP
				
		
		String interString = argsOfmtrt;
		String[] finalArgs = interString.split(" ");		
		System.out.println(argsOfmtrt);
	

		Pack wjtp = PackManager.v().getPack("wjtp");
		addSelfReport2wjtp(wjtp);		
		

      // soot.Main.main(finalArgs);// tune for saving the memory
		soot.Main.v().processCmdLine(finalArgs);
		System.out.println(argsOfmtrt);
		soot.Main.v().autoSetOptions();
		Setup.setPhaseOptionsForSparkWork();
		Scene.v().loadClassAndSupport("Drivers.Chocalate");
		Scene.v().loadNecessaryClasses();	
		
		PackManager.v().runPacks();// 1
   	PackManager.v().writeOutput();
	}

	private static void addSelfReport2wjtp(Pack wjtp) {
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
					    		  if(sm.hasActiveBody())
					    		  {
					    			  Body b =sm.getActiveBody();
					    			  PatchingChain<Unit> units = b.getUnits();
					    			 Stmt firstNonId= b.getFirstNonIdentityStmt();
					    			 SootClass injSC = Scene.v().loadClassAndSupport("Drivers.Chocalate");//insert something here
									    SootMethod injSM = injSC.getMethodByName("printMyName");
									    List<Value> args=new ArrayList<Value>();
									    args.add(StringConstant.v(sm.getDeclaringClass().getName() + ":" + sm.getName() +"is shared"));
									    InvokeExpr incExpr= Jimple.v().newStaticInvokeExpr(injSM.makeRef(), args);
									    Stmt incStmt = Jimple.v().newInvokeStmt(incExpr);
									    units.insertBefore(incStmt, firstNonId);										
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
			
			@Override
			protected void internalTransform(String phaseName, Map options){

				 String curApp = System.getProperty("current.application");
				 String curMinSupport = System.getProperty("current.min.support");
				 int curMS= Integer.valueOf(curMinSupport);
                    String rawData = "/home/lpxz/eclipse/workspace/soot24/smpf/"+ curApp+ "_"+ curMinSupport+ "_smpfData";
                    String processedData = "/home/lpxz/eclipse/workspace/soot24/smpf/"+ curApp+ "_"+ curMinSupport+"_smpfProcessed";
                    String processedReadableData = "/home/lpxz/eclipse/workspace/soot24/smpf/"+ curApp+ "_"+ curMinSupport+"_smpfProcessedReadable";
                    dumpItemSet("", rawData);// responsible for creating the file if it is does not exist yet.
                    dumpItemSet("", processedData);// responsible for creating the file if it is does not exist yet.
                    dumpItemSet("", processedReadableData);// responsible for creating the file if it is does not exist yet.
                    
                    
                    String itemset =collectItemSet();
					dumpItemSet(itemset ,rawData);
					MainTestDCI_Closed_Optimized.DCI_close(rawData,processedData, curMS );
					String interpretedString =interpretProcessedData(processedData);
					dumpItemSet(interpretedString ,processedReadableData);


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
				        	
				        	sb.append(System.getProperty(System.getProperty("line.separator")));
				        	sb.append("**************************************************");	
				        	sb.append(System.getProperty(System.getProperty("line.separator")));
				        				        	
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
				 for (int i = 0; i< s.length; i++){
					    int id = Integer.parseInt(s[i]);
					    MyPair pair=getField(id);
					    sb.append(pair.toString());
					    //formating
					    sb.append(System.getProperty("line.separator"));				    
				 }
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
				List<CriticalSection> criticalSections = getCriticalSectionsFromAppClass();
				CriticalSectionAwareSideEffectAnalysis tasea = new CriticalSectionAwareSideEffectAnalysis(
						pta, Scene.v().getCallGraph(), criticalSections,
						tlo, optionOpenNesting);
				
				

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
						    tn.read.getFields().clear();// release the set in time.
						    tn.read.getGlobals().clear();
							}
					
						RWSet stmtWrite = tasea.writeSet(tn.method, stmt,
								tn, uses);
						if (stmtWrite != null)
						{
							tn.write.union(stmtRead);
						    tn.write.getFields().clear();
						    tn.write.getGlobals().clear();
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
				System.err.println("\n\n");
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
							System.err.println(g.toString());
						}
					} else {
						System.err.println(g.getClass());
					}

				}
				System.err.println(somewords + "  side effect (nonjava G)#:"
						+ gnum + "\n");

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
							System.err.println(f.toString());
						}
					} else {
						System.err.println(f.getClass());
					}

				}
				System.err.println(somewords
						+ " side effect (nonempty, nonjava fields)#"
						+ nonemptyf);
				return nonemptyf > 0;

			}

		}));

	}

}
