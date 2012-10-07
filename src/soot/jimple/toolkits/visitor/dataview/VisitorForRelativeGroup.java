package soot.jimple.toolkits.visitor.dataview;



import java.io.OutputStream;
import java.io.PrintStream;

import Drivers.RelativeBiPartiteCrawler;

import soot.dava.toolkits.base.AST.transformations.FinalFieldDefinition;
import soot.jimple.spark.pag.Node;
import soot.jimple.spark.sets.P2SetVisitor;
import soot.jimple.spark.sets.PointsToSetInternal;
import soot.jimple.spark.sets.SortedArraySet;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.contexts.InvokeContext;
import soot.jimple.toolkits.visitor.contexts.LocalContext;
import soot.jimple.toolkits.visitor.contexts.RHSContextImpl;
import soot.jimple.toolkits.visitor.contexts.RefContext;
import soot.Local;
import soot.PointsToAnalysis;
import soot.PointsToSet;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Value;
import soot.jimple.*;
import soot.util.Chain;

/**
 * Copyright (c) 2007-2008
 * Pallavi Joshi	<pallavi@cs.berkeley.edu>
 * Koushik Sen <ksen@cs.berkeley.edu>
 * All rights reserved.
 * <p/>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * <p/>
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * <p/>
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * <p/>
 * 3. The names of the contributors may not be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 * <p/>
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
public class VisitorForRelativeGroup extends Visitor {
   public static PrintStream outputStream = System.out;
    public VisitorForRelativeGroup(Visitor visitor) {
        super(visitor);
    }


    public int getStSize() {
        return st.getSize();
    }

    private Stmt getStmtToBeInstrumented(Chain units, AssignStmt assignStmt, Value leftOp) {
        Stmt cur = assignStmt;
        Stmt succ;
        Stmt last = (Stmt) units.getLast();

        while (cur != last) {
            succ = (Stmt) units.getSuccOf(cur);
            if ((succ != null) && (succ instanceof InvokeStmt)) {
                InvokeExpr iExpr = succ.getInvokeExpr();
                if (iExpr.getMethod().getSubSignature().indexOf("<init>") != -1) {
                    if (((InstanceInvokeExpr) iExpr).getBase() == leftOp) {
//                        System.out.println("what is this:"+leftOp+assignStmt.toString());
//                        what is this:$r0$r0 = new java.lang.Object
                    	return succ;
                    }
                }
            }
            cur = succ;
        }
        return assignStmt;
    }

    private Stmt getStmtToBeInstrumented2(SootMethod sm, Chain units, AssignStmt assignStmt,
                                          Value objectOnWhichMethodIsInvoked, Stmt currStmtToBeInstrumented) {
        Stmt cur = assignStmt;
        Stmt succ;
        Stmt last = (Stmt) units.getLast();

        if (sm.getSubSignature().indexOf("<init>") != -1 && objectOnWhichMethodIsInvoked != null) {
            while (cur != last) {
                succ = (Stmt) units.getSuccOf(cur);
                if ((succ != null) && (succ instanceof InvokeStmt)) {
                    InvokeExpr iExpr = succ.getInvokeExpr();
                    if (iExpr.getMethod().getSubSignature().indexOf("<init>") != -1) {
                        if (((InstanceInvokeExpr) iExpr).getBase() == objectOnWhichMethodIsInvoked) {
                            return succ;
                        }
                    }
                }
                cur = succ;
            }
        }
        return currStmtToBeInstrumented;
    }

    private Value getMethodsTargetObject(SootMethod sm, Chain units) {
        Value objectOnWhichMethodIsInvoked = null;
        if (!sm.isStatic()) {
            Stmt startStmt = (Stmt) units.getFirst();
            if (startStmt instanceof IdentityStmt) {
                objectOnWhichMethodIsInvoked = ((IdentityStmt) startStmt).getLeftOp();
            } else {
                System.err.println("First statement within a non-static method is not an IdentityStmt");
                System.exit(-1);
            }
        }
        return objectOnWhichMethodIsInvoked;
    }

    public void visitStmtAssign(SootMethod sm, Chain units, AssignStmt assignStmt) {
        Value leftOp = assignStmt.getLeftOp();
        Value rightOp = assignStmt.getRightOp();
        if ((rightOp instanceof NewExpr)
                || (rightOp instanceof NewArrayExpr)
                || (rightOp instanceof NewMultiArrayExpr)) {
            Stmt stmtToBeInstrumented = getStmtToBeInstrumented(units, assignStmt, leftOp);
            Value objectOnWhichMethodIsInvoked = getMethodsTargetObject(sm, units);

            stmtToBeInstrumented = getStmtToBeInstrumented2(sm, units, assignStmt,
                    objectOnWhichMethodIsInvoked, stmtToBeInstrumented);
    //        outputStream.println("assignStmt: newExpr     " + assignStmt);
            
        }
        else {
    //    	 outputStream.println("assignStmt: nonNewExpr     " + assignStmt);
		}
        nextVisitor.visitStmtAssign(sm, units, assignStmt);
    }

    public void visitStmtEnterMonitor(SootMethod sm, Chain units, EnterMonitorStmt enterMonitorStmt) {
    //    outputStream.println("entermonitor:          " + enterMonitorStmt);
        nextVisitor.visitStmtEnterMonitor(sm, units, enterMonitorStmt);
    }

    public void visitStmtExitMonitor(SootMethod sm, Chain units, ExitMonitorStmt exitMonitorStmt) {
  //      outputStream.println("exitmonitor:			"  + exitMonitorStmt);
        nextVisitor.visitStmtExitMonitor(sm, units, exitMonitorStmt);
    }

    public void visitInstanceInvokeExpr(SootMethod sm, Chain units, Stmt s, InstanceInvokeExpr invokeExpr, InvokeContext context) {
        Value base = invokeExpr.getBase();
        String sig = invokeExpr.getMethod().getSubSignature();
        if (sig.equals("void wait()")) {
  //         outputStream.println("wait invocation:			" + invokeExpr);
        } else if (sig.equals("void wait(long)") || sig.equals("void wait(long,int)")) {
    //       outputStream.println("wait(long) invocation:			" + invokeExpr);
        } else if (sig.equals("void notify()")) {
    //    	  outputStream.println("notify invocation:			" + invokeExpr);
        } else if (sig.equals("void notifyAll()")) {
    //    	  outputStream.println("notifyall invocation:			" + invokeExpr);
        } else if (sig.equals("void start()") && isThreadSubType(invokeExpr.getMethod().getDeclaringClass())) {
     //   	  outputStream.println("start invocation:			" + invokeExpr);
        } else if (sig.equals("void join()") && isThreadSubType(invokeExpr.getMethod().getDeclaringClass())) {
     //   	  outputStream.println("join invocation:			" + invokeExpr);
        } else if ((sig.equals("void join(long)") || sig.equals("void join(long,int)"))
                && isThreadSubType(invokeExpr.getMethod().getDeclaringClass())) {
     //   	  outputStream.println("join(long) invocation:			" + invokeExpr);
        }

        nextVisitor.visitInstanceInvokeExpr(sm, units, s, invokeExpr, context);


         //you should not add myLockBefore for any invocation,right? some notation? synchronized? like static 
//        if (invokeExpr.getMethod().getSubSignature().indexOf("<init>") == -1) {
//            String ssig = invokeExpr.getMethod().getSubSignature();
//            ssig = ssig.substring(ssig.indexOf(' ') + 1);
//            Value sig2 = StringConstant.v(ssig);
//            addCallWithObjectString(units, s, "myLockBefore", base, sig2, true);
//            // t = t.syncMethod() is problematic, so do not pass t
//            addCall(units, s, "myUnlockAfter", false);
//        }
    }

    public void visitStaticInvokeExpr(SootMethod sm, Chain units, Stmt s, StaticInvokeExpr invokeExpr, InvokeContext context) {
        nextVisitor.visitStaticInvokeExpr(sm, units, s, invokeExpr, context);

     
//        if (invokeExpr.getMethod().isSynchronized()) {
//            addCallWithInt(units, s, "myLockBefore",
//                    IntConstant.v(st.get(invokeExpr.getMethod().getDeclaringClass().getName())), true);
//            addCallWithInt(units, s, "myUnlockAfter",
//                    IntConstant.v(st.get(invokeExpr.getMethod().getDeclaringClass().getName())), false);
//        }
    }


    public void visitArrayRef(SootMethod sm, Chain units, Stmt s, final ArrayRef arrayRef, RefContext context) {
//        if (context == RHSContextImpl.getInstance()) {
//            addCallWithObjectInt(units, s, "myReadBefore", arrayRef.getBase(), arrayRef.getIndex(), true);
//        } else {
//            addCallWithObjectInt(units, s, "myWriteBefore", arrayRef.getBase(), arrayRef.getIndex(), true);
//        }
      final Value base = arrayRef.getBase();
      final Value index= arrayRef.getIndex();// kind of useless
      PointsToSet basePointsToSet = RelativeBiPartiteCrawler.pToAnalysis.reachingObjects((Local)base);
      PointsToSet indexPointsToSet = RelativeBiPartiteCrawler.pToAnalysis.reachingObjectsOfArrayElement(basePointsToSet);
      // I hope I use it in a right way
      if(basePointsToSet instanceof PointsToSetInternal)
      {
    	  if(!RelativeBiPartiteCrawler.gBiPartite.containsVertex(base))
    	  {
    		  RelativeBiPartiteCrawler.gBiPartite.addVertex(base);
    	  }
    	  PointsToSetInternal basePointsToSetInternal= (PointsToSetInternal)basePointsToSet;
          basePointsToSetInternal.forall(new P2SetVisitor() {
			
			@Override
			public void visit(Node n) {
				// TODO Auto-generated method stub
		    	  if(!RelativeBiPartiteCrawler.gBiPartite.containsVertex(n))
		    	  {
		    		  RelativeBiPartiteCrawler.gBiPartite.addVertex(n);
		    	  }
		    	  RelativeBiPartiteCrawler.gBiPartite.addEdge(base, n);
				
			}
		});
      }else {
		throw new RuntimeException();
	}
      if(indexPointsToSet instanceof PointsToSetInternal)
      {
    	  PointsToSetInternal indexPointsToSetInternal= (PointsToSetInternal)indexPointsToSet;
    	 if(!RelativeBiPartiteCrawler.gBiPartite.containsVertex(arrayRef))
    	 { RelativeBiPartiteCrawler.gBiPartite.addVertex(arrayRef);}
    	  indexPointsToSetInternal.forall(new P2SetVisitor() {
			
			@Override
			public void visit(Node n) {
		    	 if(!RelativeBiPartiteCrawler.gBiPartite.containsVertex(n))
		    	 { RelativeBiPartiteCrawler.gBiPartite.addVertex(n);}
			    RelativeBiPartiteCrawler.gBiPartite.addEdge(arrayRef, n);	
			}
		});
      }
      else
      {
    	throw new RuntimeException();  
      }
      

  // no need to decompress      nextVisitor.visitArrayRef(sm, units, s, arrayRef, context);
 }

    public void visitInstanceFieldRef(SootMethod sm, Chain units, Stmt s, final InstanceFieldRef instanceFieldRef, RefContext context) {
        if (!sm.getName().equals("<init>") || !instanceFieldRef.getField().getName().equals("this$0")) {
         //     outputStream.println("visitInstanceField:			" + s);
        	//            Value v = IntConstant.v(st.get(instanceFieldRef.getField().getName()));
//            if (context == RHSContextImpl.getInstance()) {
//                addCallWithObjectInt(units, s, "myReadBefore", instanceFieldRef.getBase(), v, true);
//            } else {
//                addCallWithObjectInt(units, s, "myWriteBefore", instanceFieldRef.getBase(), v, true);
//            }
        }
        final Value base = instanceFieldRef.getBase();
        final SootField field = instanceFieldRef.getField();
        
        
		if(base.getType() instanceof RefType)// special treatment of exceptions
		{
			SootClass baseClass = ((RefType) base.getType()).getSootClass();
			if(Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(
				baseClass, RefType.v("java.lang.Exception").getSootClass()))
				return ;
		}
        
        PointsToSet baseSet =RelativeBiPartiteCrawler.pToAnalysis.reachingObjects((Local)base);
        PointsToSet fieldSet = RelativeBiPartiteCrawler.pToAnalysis.reachingObjects((Local)base, field);
        if(baseSet instanceof PointsToSetInternal)
        {
        	if(!RelativeBiPartiteCrawler.gBiPartite.containsVertex(base))
        	{	RelativeBiPartiteCrawler.gBiPartite.addVertex(base);}
             PointsToSetInternal baseSetInternal= (PointsToSetInternal)baseSet;
             baseSetInternal.forall(new P2SetVisitor() {
				
				@Override
				public void visit(Node n) {
					if(!RelativeBiPartiteCrawler.gBiPartite.containsVertex(n))
					{RelativeBiPartiteCrawler.gBiPartite.addVertex(n);}
					RelativeBiPartiteCrawler.gBiPartite.addEdge(base, n);
				}
			});
             
        }
        else {
			throw new RuntimeException();
		}
        
        
        if(fieldSet instanceof PointsToSetInternal)
        {
        	if(!RelativeBiPartiteCrawler.gBiPartite.containsVertex(instanceFieldRef))// I have to add an complete object containing the base and the field!
        	{	RelativeBiPartiteCrawler.gBiPartite.addVertex(instanceFieldRef);}
             PointsToSetInternal fieldSetInternal= (PointsToSetInternal)fieldSet;
             fieldSetInternal.forall(new P2SetVisitor() {
				
				@Override
				public void visit(Node n) {
					if(!RelativeBiPartiteCrawler.gBiPartite.containsVertex(n))
					{RelativeBiPartiteCrawler.gBiPartite.addVertex(n);}
					RelativeBiPartiteCrawler.gBiPartite.addEdge(instanceFieldRef, n);
				}
			});
             
        }
        else {
			throw new RuntimeException();
		}
        
   //     nextVisitor.visitInstanceFieldRef(sm, units, s, instanceFieldRef, context);
    }


    public void visitStaticFieldRef(SootMethod sm, Chain units, Stmt s, final StaticFieldRef staticFieldRef, RefContext context) {
//        Value v1 = IntConstant.v(st.get(staticFieldRef.getField().getDeclaringClass().getName()));
//        Value v2 = IntConstant.v(st.get(staticFieldRef.getField().getName()));
//        if (context == RHSContextImpl.getInstance()) {
//            addCallWithIntInt(units, s, "myReadBefore", v1, v2, true);
//        } else {
//            addCallWithIntInt(units, s, "myWriteBefore", v1, v2, true);
//        }
 
//        nextVisitor.visitStaticFieldRef(sm, units, s, staticFieldRef, context);
    	// In soot, they model staticField as a globalVarNode, not they miss the static class yet.
    	// I do not know whether it is necessary, but currently I model it out.
          SootClass oneClass= staticFieldRef.getField().getDeclaringClass();
          SootField staticField = staticFieldRef.getField();
          LPFakeClassNode oneClassnode = new LPFakeClassNode();// mimic the point-to set of the  class.
          PointsToSet staticFieldPointsToSet = RelativeBiPartiteCrawler.pToAnalysis.reachingObjects(staticField);
          
          if(true)
          {
        	  if(!RelativeBiPartiteCrawler.gBiPartite.containsVertex(oneClass))
        	  {
        		  RelativeBiPartiteCrawler.gBiPartite.addVertex(oneClass);        		  
        	  }
        	  if(!RelativeBiPartiteCrawler.gBiPartite.containsVertex(oneClassnode))
        	  {
        		  RelativeBiPartiteCrawler.gBiPartite.addVertex(oneClassnode);
        	  }
        	  RelativeBiPartiteCrawler.gBiPartite.addEdge(oneClass, oneClassnode);
          }
          else {
			throw new RuntimeException();
		}
          
          if(staticFieldPointsToSet instanceof PointsToSetInternal)
          {
        	  if(!RelativeBiPartiteCrawler.gBiPartite.containsVertex(staticFieldRef))
        	  {
        		  RelativeBiPartiteCrawler.gBiPartite.addVertex(staticFieldRef);
        	  }
        	  
        	PointsToSetInternal staticFieldInternal = (PointsToSetInternal) staticFieldPointsToSet;
        	staticFieldInternal.forall(new P2SetVisitor() {
				
				@Override
				public void visit(Node n) {
		        	  if(!RelativeBiPartiteCrawler.gBiPartite.containsVertex(n))
		        	  {
		        		  RelativeBiPartiteCrawler.gBiPartite.addVertex(n);
		        	  }
		        	  RelativeBiPartiteCrawler.gBiPartite.addEdge(staticFieldRef, n);
		        	  
					
				}
			});
          }
          else {
			throw new RuntimeException();
		}
     
    }

    
    public void visitLocal(SootMethod sm, Chain units, Stmt s, final Local local, LocalContext context) {
    	//				boolean bvalue= PHThreadLocalAnalysis.tlo.isObjectThreadLocal(local, sm);
       //  			    System.out.print("\n local: "+local.toString()+ " threadlocal:"+bvalue);	
    		PointsToSet  localPointsToSet= RelativeBiPartiteCrawler.pToAnalysis.reachingObjects(local);
    		if(localPointsToSet instanceof PointsToSetInternal)
    		{
    			if(!RelativeBiPartiteCrawler.gBiPartite.containsVertex(local))
    			{
    				RelativeBiPartiteCrawler.gBiPartite.addVertex(local);
    			}
    			PointsToSetInternal localPointsToSetInternal = (PointsToSetInternal)localPointsToSet;
    			localPointsToSetInternal.forall(new P2SetVisitor() {
					
					@Override
					public void visit(Node n) {
						if(!RelativeBiPartiteCrawler.gBiPartite.containsVertex(n))
						{
							RelativeBiPartiteCrawler.gBiPartite.addVertex(n);
						}
						RelativeBiPartiteCrawler.gBiPartite.addEdge(local, n);
					}
				});
    		}
    		else {
				throw new RuntimeException();
			}
    			
    		
        }/*
         * StaticFieldRef{RHSContext,LHSContext}
         */



    

        public void visitCaughtExceptionRef(SootMethod sm, Chain units, IdentityStmt s, CaughtExceptionRef caughtExceptionRef) {
    //    
//    				boolean bvalue= PHThreadLocalAnalysis.tlo.isObjectThreadLocal(caughtExceptionRef, sm);
//      			    System.out.print("\n caughtexceptionref: "+caughtExceptionRef.toString()+ " threadlocal:"+bvalue);	
// simply ignore them!!!!!!!!
        }/*
         * ParameterRef{IdentityContext}
         */

        public void visitParameterRef(SootMethod sm, Chain units, IdentityStmt s, ParameterRef parameterRef) {
        //visitParameter:r0 := @parameter0: java.lang.String[]
        	// there must be some Local variable for clustering the andoes.
        	// it is totally safe to ignore the parameter
        	// because 
        	// 1 as a local, it is absolutely safe, 
        	// 2 as the heap pointer, 
        	// the danger can also not happen on para!, maybe on the local variables 
        	// who get values from para!

         
        }/*
         * ThisRef{IdentityContext}
         */

        public void visitThisRef(SootMethod sm, Chain units, IdentityStmt s, ThisRef thisRef) {
//visitThisRef:r0 := @this: Toy
         // no need to care about the this ref too!
        	
        }/*
         * RHSContext,IfContext}
         */
        
       public class LPFakeClassNode // 
        {
        	
        	}

}

