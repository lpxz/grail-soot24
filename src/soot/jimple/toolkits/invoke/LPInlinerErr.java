/* Soot - a J*va Optimization Framework
 * Copyright (C) 1999 Patrick Lam, Raja Vallee-Rai
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

/*
 * Modified by the Sable Research Group and others 1997-1999.  
 * See the 'credits' file distributed with Soot for the complete list of
 * contributors.  (Soot is distributed at http://www.sable.mcgill.ca/soot)
 */

package soot.jimple.toolkits.invoke;
import soot.options.*;

import soot.*;
import soot.jimple.*;
import soot.jimple.toolkits.callgraph.*;
import soot.jimple.toolkits.thread.synchronizationLP.Jimples.JimpleGen;
import soot.tagkit.Host;
import java.util.*;

/** Uses the Scene's currently-active InvokeGraph to inline monomorphic call sites. */
public class LPInlinerErr extends SceneTransformer
{ // fail to acheive the purpose:
	// keep the orig one and the relationship, and create a new inlinedVersion
	// through  setting the name, 
	// the reference relationship belongs to the inlined version
	/// as nobody knows  the cloned version...
	// and also you hsould add if(xx instanceof) {inline this way}..
	// so complicated..I discard this crazy action.
	// and I also worry about the point of achieving this.
	
	
	// passed by the user!
	public static  List<List> orig_ToBeOrig_newNamePost_lists = new ArrayList<List>();

	
//  orig, toBeOrig, newNamePostfix (the name is evovling along with each request.)
	// after "tobeorig" (final), orig is not called the orignal name, while the toBeOrig is going to take it
	// you can access the result here
	// it is created, not passed by the user!

private static final String tmpStr = "_tmp";
    // SOotMethod, InvokeStmt, ContainerMethod
	public ArrayList<List> tgt_Invo_Container__newPostFix_Lists = new ArrayList<List>();
	

    public LPInlinerErr(  ) {}// no need to use g at all!
    
    protected void internalTransform(String phaseName, Map options)
    {
    	
    	//============================
    	//tell info
    	List entry1= new ArrayList();
    	   CallGraph cgTmp = Scene.v().getCallGraph();
    	SootClass toyC = Scene.v().loadClassAndSupport("Toy");
    	SootMethod sm = toyC.getMethodByName("main");
    	Iterator<Edge> outEdges = cgTmp.edgesOutOf(sm);
         while (outEdges.hasNext()) {
			Edge edge = (Edge) outEdges.next();
			if(edge.getTgt().method().getName().contains("sum"))
			{
				entry1.add(edge.getTgt().method());
				entry1.add(edge.srcStmt());
				entry1.add(sm);
				entry1.add("_newName");
			}
		}
         tgt_Invo_Container__newPostFix_Lists.add(entry1);
    	//=============================
        Filter explicitInvokesFilter = new Filter( new ExplicitEdgesPred() );
        if(Options.v().verbose())
            G.v().out.println("[] Inlining methods...");

        boolean enableNullPointerCheckInsertion = true;//PhaseOptions.getBoolean(options, "insert-null-checks");
        boolean enableRedundantCastInsertion = true;// PhaseOptions.getBoolean(options, "insert-redundant-casts");
        String modifierOptions ="";//  PhaseOptions.getString(options, "allowed-modifier-changes");
        float expansionFactor =  1;//PhaseOptions.getFloat(options, "expansion-factor");
        int maxContainerSize =10000;// PhaseOptions.getInt(options, "max-container-size");
        int maxInlineeSize = 1000;// PhaseOptions.getInt(options, "max-inlinee-size");
        boolean rerunJb = true;// PhaseOptions.getBoolean(options, "rerun-jb");

        HashMap instanceToStaticMap = new HashMap();

        CallGraph cg = Scene.v().getCallGraph();
        Hierarchy hierarchy = Scene.v().getActiveHierarchy();

      
        // Visit each potential site in reverse pseudo topological order.
        // we do not worry about the cyclic problem, so do not use reversed topological order
        // add requests have been put into the tgtInvoContainerLIsts.
        if(tgt_Invo_Container__newPostFix_Lists.size()==0) throw new RuntimeException("seems you do not want to inline anything!");
        // Proceed to inline the sites, one at a time, keeping track of
        // expansion rates.
        {

        	Iterator<List> sitesIt = tgt_Invo_Container__newPostFix_Lists.iterator();
            while (sitesIt.hasNext())
            {
                List l = sitesIt.next();
                SootMethod inlinee = (SootMethod)l.get(0);
                int inlineeSize = ((JimpleBody)(inlinee.retrieveActiveBody())).getUnits().size();

                Stmt invokeStmt = (Stmt)l.get(1);

                SootMethod container = (SootMethod)l.get(2);
                
             
                String newPostFixPart = null;
                try {
                	newPostFixPart= (String) l.get(3);
				} catch (IndexOutOfBoundsException e) {
					l.add("_differentName");
					newPostFixPart= (String) l.get(3);					
				}
                int containerSize = ((JimpleBody)(container.retrieveActiveBody())).getUnits().size();
                
                if (inlineeSize + containerSize > maxContainerSize)
                    continue;

                if (inlineeSize > maxInlineeSize)
                    continue;



                if(InlinerSafetyManager.ensureInlinability(inlinee, invokeStmt, container, modifierOptions))
                {
                    // Not that it is important to check right before inlining if the site is still valid.
                    SootMethod toBeOrig = cloneItIfNoClone(container);
                    //// this is the backup of the orig, and to be orignal (namely) after the orignal moves away
                    SiteInliner.inlineSite(inlinee, invokeStmt, container, options);
                    SootMethod orig=container;
                	
                    Iterator<List> it= orig_ToBeOrig_newNamePost_lists.iterator();
                	List corrEntry = null;
                	while (it.hasNext()) {
            			List list = (List) it.next();
            			if(list.get(0)==container) 
            			{
                           corrEntry = list;
            			}
            		}
                	if(corrEntry==null)
                	{corrEntry = new ArrayList();  
                     corrEntry.add(orig);
                     corrEntry.add(toBeOrig);
                     corrEntry.add("");                     
                	orig_ToBeOrig_newNamePost_lists.add(corrEntry);
                	
                	}              	
                	
    				String oldNamePostFix= (String)corrEntry.get(2);
    				String newPostFix = oldNamePostFix +newPostFixPart;
    				corrEntry.add(2, newPostFix);
  
                    // it is not a right time to adjust the name now
                    // it would mess up! toBeOrig does not have any relatives in the CG now!
                   if( rerunJb ) {
                        PackManager.v().getPack("jb").apply(container.getActiveBody());
                    }
                }
            }
            
            {
            	// tobeOrig process
            	Iterator<List> it2 =orig_ToBeOrig_newNamePost_lists.iterator();
            	while (it2.hasNext()) {
					List list = (List) it2.next();
					SootMethod orig= (SootMethod)list.get(0);
					SootMethod toBeOrig =(SootMethod) list.get(1);
					String newPostFix = (String)list.get(2);
					String origName = orig.getName();
					orig.setName(origName+newPostFix);
					toBeOrig.setName(origName);
				}
            }
        }
    }

    public SootMethod cloneItIfNoClone(SootMethod container) {
    	
    	Iterator<List> it= orig_ToBeOrig_newNamePost_lists.iterator();
    	while (it.hasNext()) {
			List list = (List) it.next();
			if(list.get(0)==container) return (SootMethod)list.get(1);// hashmap mechanism
		}
    	SootClass sc = container.getDeclaringClass();
    	String methodName= container.getName()+tmpStr;
    	List< Type> paraTypes = container.getParameterTypes();
    	Type retType = container.getReturnType();
    	
		SootMethod toBeTheOrig =  new SootMethod(methodName, paraTypes, retType,
				container.getModifiers());
		sc.addMethod(toBeTheOrig);
		
		return toBeTheOrig ;
	}

	private final HashMap<SootMethod, Integer> methodToOriginalSize = new HashMap<SootMethod, Integer>();
    private void computeAverageMethodSizeAndSaveOriginalSizes()
    {
        long sum = 0, count = 0;
        Iterator classesIt = Scene.v().getApplicationClasses().iterator();

        while (classesIt.hasNext())
        {
            SootClass c = (SootClass) classesIt.next();

            Iterator methodsIt = c.methodIterator();
            while (methodsIt.hasNext())
            {
                SootMethod m = (SootMethod) methodsIt.next();
                if (m.isConcrete())
                {
                    int size = ((JimpleBody)m.retrieveActiveBody()).getUnits().size();
                    sum += size;
                    methodToOriginalSize.put(m, new Integer(size));
                    count++;
                }
            }
        }
        if (count == 0)
            return;
    }
}



