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
public class LPInliner extends SceneTransformer
{ 

	
//  orig, toBeOrig, newNamePostfix (the name is evovling along with each request.)
	// after "tobeorig" (final), orig is not called the orignal name, while the toBeOrig is going to take it
	// you can access the result here
	// it is created, not passed by the user!

private static final String tmpStr = "_tmp";
    // SOotMethod, InvokeStmt, ContainerMethod
	public ArrayList<List> tgt_Invo_Container__newPostFix_Lists = new ArrayList<List>();
	

    public LPInliner(  ) {}// no need to use g at all!
    
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
                	//just inline, nomatter whether it is a virtual call
                    SiteInliner.inlineSite(inlinee, invokeStmt, container, options);
                     // it is not a right time to adjust the name now
                    // it would mess up! toBeOrig does not have any relatives in the CG now!
                   if( rerunJb ) {
                        PackManager.v().getPack("jb").apply(container.getActiveBody());
                    }
                }
            }
            

        }
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



