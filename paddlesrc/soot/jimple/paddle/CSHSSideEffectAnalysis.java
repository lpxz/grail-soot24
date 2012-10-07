package soot.jimple.paddle;

import soot.*;
import soot.jimple.*;
import soot.jimple.paddle.bdddomains.*;
import java.util.*;

import Drivers.paddle.TestPaddle;

import jedd.Attribute;
import jedd.internal.RelationContainer;
import junit.framework.Assert;

//==============
// methdo is not a method, it is multiple method instances!
// allocnode is not an object, it is multple allocation isntaces!
public class CSHSSideEffectAnalysis {
	final jedd.internal.RelationContainer ntread = new jedd.internal.RelationContainer(
			new jedd.Attribute[] { A_fld.v(), A_ctxt.v(), A_method.v(), A_stmt.v(),
					A_objc.v(), A_obj.v()},
			new jedd.PhysicalDomain[] { FD.v(), C2.v(), MT.v(), ST.v(), CH1.v(),H1.v()},
			("<soot.jimple.paddle.bdddomains.A_method, soot.jimple.paddle."
					+ "bdddomains.A_stmt, soot.jimple.paddle.bdddomains.A_fld:soot."
					+ "jimple.paddle.bdddomains.FD, soot.jimple.paddle.bdddomains.A"
					+ "_obj> ntread = jedd.internal.Jedd.v().falseBDD() at SideEffe"
					+ "ctAnalysis.jedd:30,4-39"), jedd.internal.Jedd.v()
					.falseBDD());

	final jedd.internal.RelationContainer ntwrite = new jedd.internal.RelationContainer(
			new jedd.Attribute[] {A_fld.v(), A_ctxt.v(), A_method.v(), A_stmt.v(),
					A_objc.v(), A_obj.v()},
			new jedd.PhysicalDomain[] { FD.v(), C2.v(), MT.v(), ST.v(), CH1.v(),H1.v() },
			("<soot.jimple.paddle.bdddomains.A_method, soot.jimple.paddle."
					+ "bdddomains.A_stmt, soot.jimple.paddle.bdddomains.A_fld:soot."
					+ "jimple.paddle.bdddomains.FD, soot.jimple.paddle.bdddomains.A"
					+ "_obj> ntwrite = jedd.internal.Jedd.v().falseBDD() at SideEff"
					+ "ectAnalysis.jedd:31,4-39"), jedd.internal.Jedd.v()
					.falseBDD());

	public final jedd.internal.RelationContainer read = new jedd.internal.RelationContainer(
			new jedd.Attribute[] { A_fld.v(), A_ctxt.v(), A_method.v(), A_stmt.v(),
					A_objc.v(), A_obj.v()},
			new jedd.PhysicalDomain[] { FD.v(), C2.v(), MT.v(), ST.v(), CH1.v(),H1.v()},
			("<soot.jimple.paddle.bdddomains.A_method, soot.jimple.paddle."
					+ "bdddomains.A_stmt, soot.jimple.paddle.bdddomains.A_fld, soot"
					+ ".jimple.paddle.bdddomains.A_obj> read = jedd.internal.Jedd.v"
					+ "().falseBDD() at SideEffectAnalysis.jedd:35,4-36"),
			jedd.internal.Jedd.v().falseBDD());

	public final jedd.internal.RelationContainer write = new jedd.internal.RelationContainer(
			new jedd.Attribute[] { A_fld.v(), A_ctxt.v(), A_method.v(), A_stmt.v(),
					A_objc.v(), A_obj.v()},
			new jedd.PhysicalDomain[] { FD.v(), C2.v(), MT.v(), ST.v(), CH1.v(),H1.v() },
			("<soot.jimple.paddle.bdddomains.A_method, soot.jimple.paddle."
					+ "bdddomains.A_stmt, soot.jimple.paddle.bdddomains.A_fld, soot"
					+ ".jimple.paddle.bdddomains.A_obj> write = jedd.internal.Jedd."
					+ "v().falseBDD() at SideEffectAnalysis.jedd:36,4-36"),
			jedd.internal.Jedd.v().falseBDD());

	private jedd.internal.RelationContainer addValue(Value v, Context ctxt, SootMethod m,
			Stmt s) {
		if (v instanceof InstanceFieldRef) {
			Scene.v().getUnitNumberer().add(s);
			InstanceFieldRef ifr = (InstanceFieldRef) v;
			SootField f = ifr.getField();
			Scene.v().getFieldNumberer().add(f);
			
			PointsToSetReadOnly cvP2S= p2sets().get(ctxt,varNode(m, (Local) ifr.getBase()));
			Assert.assertTrue(cvP2S instanceof BDDPointsToSet);
			RelationContainer cvP2S_RC=((BDDPointsToSet)cvP2S).bdd();
			
			
			RelationContainer toret= new jedd.internal.RelationContainer(
					new jedd.Attribute[] { A_fld.v(), A_ctxt.v(), A_method.v(), A_stmt.v(),
							A_objc.v(), A_obj.v() },
					new jedd.PhysicalDomain[] { FD.v(), C2.v(), MS.v(), ST.v(), CH1.v(),H1.v() },
					("return jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().re"
							+ "ad(jedd.internal.Jedd.v().literal(new java.lang.Object[...],"
							+ " new jedd.Attribute[...], new jedd.PhysicalDomain[...])), je"
							+ "dd.internal.Jedd.v().project(p2sets().getReader(varNode(m, ("
							+ "soot.Local) ifr.getBase())).get(), new jedd.PhysicalDomain[."
							+ "..]), new jedd.PhysicalDomain[...]); at SideEffectAnalysis.j"
							+ "edd:46,12-18"), jedd.internal.Jedd.v().join(
									
							jedd.internal.Jedd.v().read(
									jedd.internal.Jedd.v().literal(// A_ctxt, C1
											new Object[] { ctxt, m, s, f },
											new jedd.Attribute[] { A_ctxt.v(),
													A_method.v(), A_stmt.v(),
													A_fld.v() },
											new jedd.PhysicalDomain[] { C2.v(), MS.v(),
													ST.v(), FD.v() })),
													
													cvP2S_RC,// CH1, H1
													
							new jedd.PhysicalDomain[] {}));// unconditionally join
//			jedd.internal.Jedd.v().project(
//					p2sets().getReader(
//							varNode(m, (Local) ifr.getBase()))
//							.get(),
//					new jedd.PhysicalDomain[] { V1.v(),
//							CH1.v(), C1.v() }	
//
//)			
							return toret;
		} else if (v instanceof StaticFieldRef) {
			Scene.v().getUnitNumberer().add(s);
			StaticFieldRef sfr = (StaticFieldRef) v;
			SootField f = sfr.getField();
			Scene.v().getFieldNumberer().add(f);
			return new jedd.internal.RelationContainer(
					new jedd.Attribute[] { A_ctxt.v(),A_method.v(), A_stmt.v(), A_fld.v(),
							A_objc.v(), A_obj.v() },
					new jedd.PhysicalDomain[] { C2.v(), MS.v(), ST.v(), FD.v(), CH1.v(), H1.v() },
					("return jedd.internal.Jedd.v().literal(new java.lang.Object[."
							+ "..], new jedd.Attribute[...], new jedd.PhysicalDomain[...]);"
							+ " at SideEffectAnalysis.jedd:54,12-18"),
					jedd.internal.Jedd.v().literal(
							new Object[] { ctxt, m, s, f, null, null },
							new jedd.Attribute[] { A_ctxt.v(),A_method.v(), A_stmt.v(), A_fld.v(),
									A_objc.v(), A_obj.v()  },
							new jedd.PhysicalDomain[] { C2.v(), MS.v(), ST.v(), FD.v(), CH1.v(), H1.v()}));
		} else if (v instanceof ArrayRef) {
			Scene.v().getUnitNumberer().add(s);
			ArrayRef ar = (ArrayRef) v;
			
			PointsToSetReadOnly cvP2S= p2sets().get(ctxt, varNode(m, (Local) ar.getBase()));
			Assert.assertTrue(cvP2S instanceof BDDPointsToSet);
			RelationContainer cvP2S_RC= ((BDDPointsToSet)cvP2S).bdd();
			
			
			RelationContainer toret=  new jedd.internal.RelationContainer(
					new jedd.Attribute[] {A_ctxt.v(), A_fld.v(), A_method.v(), A_stmt.v(),
							A_objc.v(), A_obj.v() },
					new jedd.PhysicalDomain[] {C2.v(), FD.v(), MS.v(), ST.v(), CH1.v(), H1.v() },
					("return jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().re"
							+ "ad(jedd.internal.Jedd.v().literal(new java.lang.Object[...],"
							+ " new jedd.Attribute[...], new jedd.PhysicalDomain[...])), je"
							+ "dd.internal.Jedd.v().project(p2sets().getReader(varNode(m, ("
							+ "soot.Local) ar.getBase())).get(), new jedd.PhysicalDomain[.."
							+ ".]), new jedd.PhysicalDomain[...]); at SideEffectAnalysis.je"
							+ "dd:62,12-18"), jedd.internal.Jedd.v().join(
							
									jedd.internal.Jedd.v().read(
									jedd.internal.Jedd.v().literal(
											new Object[] { ctxt, m, s,
													ArrayElement.v() },
											new jedd.Attribute[] { A_ctxt.v(),
													A_method.v(), A_stmt.v(),
													A_fld.v() },
											new jedd.PhysicalDomain[] { C2.v(), MS.v(),
													ST.v(), FD.v() })),
													
						            cvP2S_RC.bdd(),
						            
							        new jedd.PhysicalDomain[] {}));
			
//			jedd.internal.Jedd.v().project(
//					p2sets().getReader(
//							varNode(m, (Local) ar.getBase()))
//							.get(),
//					new jedd.PhysicalDomain[] { V1.v(),
//							CH1.v(), C1.v() })
			return toret;
		}
		return new jedd.internal.RelationContainer(new jedd.Attribute[] {},
				new jedd.PhysicalDomain[] {},
				("return jedd.internal.Jedd.v().falseBDD(); at SideEffectAnaly"
						+ "sis.jedd:69,1-7"), jedd.internal.Jedd.v().falseBDD());
	}

	private NodeFactory gnf;

	private VarNode varNode(SootMethod m, Local l) {
		return (VarNode) new MethodNodeFactory(m, gnf).getNode(l);
	}

	private AbsP2Sets p2sets() {
		return Results.v().p2sets();
	}

	private jedd.internal.RelationContainer ntReadSet(Context ctxt,SootMethod m, Stmt s) {
		Scene.v().getUnitNumberer().add(s);
		if (s instanceof AssignStmt) {
			AssignStmt a = (AssignStmt) s;
			Value r = a.getRightOp();
			return new jedd.internal.RelationContainer(
					new jedd.Attribute[] { A_fld.v(), A_ctxt.v(), A_method.v(), A_stmt.v(),
							A_objc.v(), A_obj.v() },
					new jedd.PhysicalDomain[] {  FD.v(), C2.v(), MT.v(), ST.v(), CH1.v(),H1.v()},
					("return jedd.internal.Jedd.v().replace(addValue(r, m, s), new"
							+ " jedd.PhysicalDomain[...], new jedd.PhysicalDomain[...]); at"
							+ " SideEffectAnalysis.jedd:88,5-11"),
					jedd.internal.Jedd.v().replace(addValue(r,ctxt ,m, s),
							new jedd.PhysicalDomain[] { MS.v() },
							new jedd.PhysicalDomain[] { MT.v() }));
		}
		return new jedd.internal.RelationContainer(new jedd.Attribute[] {},
				new jedd.PhysicalDomain[] {},
				("return jedd.internal.Jedd.v().falseBDD(); at SideEffectAnaly"
						+ "sis.jedd:90,8-14"), jedd.internal.Jedd.v()
						.falseBDD());
	}

	private jedd.internal.RelationContainer ntWriteSet(Context ctxt , SootMethod m, Stmt s) {
		Scene.v().getUnitNumberer().add(s);
		if (s instanceof AssignStmt) {
			AssignStmt a = (AssignStmt) s;
			Value l = a.getLeftOp();
			// tofix!
			return new jedd.internal.RelationContainer(
					new jedd.Attribute[] { A_fld.v(), A_ctxt.v(), A_method.v(), A_stmt.v(),
							A_objc.v(), A_obj.v() },
					new jedd.PhysicalDomain[] { FD.v(), C2.v(), MT.v(), ST.v(), CH1.v(),H1.v() },
					"return addValue(l, m, s); at SideEffectAnalysis.jedd:99,5-11",
					jedd.internal.Jedd.v().replace(addValue(l,ctxt ,m, s),
							new jedd.PhysicalDomain[] { MS.v() },
							new jedd.PhysicalDomain[] { MT.v() }));
		}
		return new jedd.internal.RelationContainer(new jedd.Attribute[] {},
				new jedd.PhysicalDomain[] {},
				("return jedd.internal.Jedd.v().falseBDD(); at SideEffectAnaly"
						+ "sis.jedd:101,8-14"), jedd.internal.Jedd.v()
						.falseBDD());
	}

	private void findNTRWSets(Context ctxt , SootMethod m) {
		if(!m.hasActiveBody()) return;
		for (Iterator sIt = m.retrieveActiveBody().getUnits().iterator(); sIt
				.hasNext();) {
			final Stmt s = (Stmt) sIt.next();
	//		System.out.println("ntRW of " + s + " in " + m);
			ntwrite.eqUnion(ntWriteSet(ctxt, m, s));
			ntread.eqUnion(ntReadSet(ctxt, m, s));
		}
		SootClass c = m.getDeclaringClass();
		if (!c.isApplicationClass()) {
			m.releaseActiveBody();
		}
	}

	private AbsCallGraph cg() {
		return Results.v().callGraph();
	}

	private void closure() {
		read.eqUnion(ntread);
		write.eqUnion(ntwrite);
		final jedd.internal.RelationContainer closecg = new jedd.internal.RelationContainer(
				new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_tgtc.v(), A_tgtm.v() },
				new jedd.PhysicalDomain[] {C1.v(),  MS.v(), ST.v(), C2.v(), MT.v() },
				("<soot.jimple.paddle.bdddomains.A_srcm:soot.jimple.paddle.bdd"
						+ "domains.MS, soot.jimple.paddle.bdddomains.A_stmt:soot.jimple"
						+ ".paddle.bdddomains.ST, soot.jimple.paddle.bdddomains.A_tgtm:"
						+ "soot.jimple.paddle.bdddomains.MT> closecg = jedd.internal.Je"
						+ "dd.v().project(cg().ciEdges().get(), new jedd.PhysicalDomain"
						+ "[...]); at SideEffectAnalysis.jedd:129,33-40"),
				jedd.internal.Jedd.v().project(cg().csEdges().get(),
						new jedd.PhysicalDomain[] { KD.v() }));// 5-tuple
		while (!jedd.internal.Jedd.v().equals(
				jedd.internal.Jedd.v().read(closecg),
				closecg.eqUnion(jedd.internal.Jedd.v().compose(
						jedd.internal.Jedd.v().read(
								jedd.internal.Jedd.v().replace(closecg,
										new jedd.PhysicalDomain[] {C2.v(), MT.v() },
										new jedd.PhysicalDomain[] {C3.v(), M3.v() })), // this one's tail connect with the below's head
						jedd.internal.Jedd.v().replace(
								jedd.internal.Jedd.v().project(closecg,
										new jedd.PhysicalDomain[] { ST.v() }),
								new jedd.PhysicalDomain[] { C1.v(), MS.v() },
								new jedd.PhysicalDomain[] { C3.v(), M3.v() }),
						new jedd.PhysicalDomain[] { C3.v(), M3.v() }))))
			;
		
		
		// okay ,closecg : C1.v(),  MS.v(), ST.v(), C2.v(), MT.v() 
		//ntread: FD.v(), C2.v(), MT.v(), ST.v(), CH1.v(),H1.v() 
		read.eqUnion(jedd.internal.Jedd.v().replace(
				jedd.internal.Jedd.v().compose(
						jedd.internal.Jedd.v().read(closecg),
						jedd.internal.Jedd.v().project(ntread,
								new jedd.PhysicalDomain[] { ST.v() }),
						new jedd.PhysicalDomain[] { C2.v(), MT.v() }),
				new jedd.PhysicalDomain[] { C1.v(),MS.v() },
				new jedd.PhysicalDomain[] { C2.v(), MT.v() }));
		write.eqUnion(jedd.internal.Jedd.v().replace(
				jedd.internal.Jedd.v().compose(
						jedd.internal.Jedd.v().read(closecg),
						jedd.internal.Jedd.v().project(ntwrite,
								new jedd.PhysicalDomain[] { ST.v() }),
						new jedd.PhysicalDomain[] { C2.v(), MT.v() }),
				new jedd.PhysicalDomain[] { C1.v(),MS.v() },
				new jedd.PhysicalDomain[] { C2.v(), MT.v() }));
	}

	public void analyze() {
		// the method to analyze are those called
		gnf = Results.v().nodeFactory();
		for (Iterator mIt = new jedd.internal.RelationContainer(
				new jedd.Attribute[] { A_tgtc.v(), A_tgtm.v() },
				new jedd.PhysicalDomain[] {C2.v(),  MT.v() },
				("jedd.internal.Jedd.v().project(cg().ciEdges().get(), new jed"
						+ "d.PhysicalDomain[...]).iterator() at SideEffectAnalysis.jedd"
						+ ":141,82-90"), jedd.internal.Jedd.v().project(
						cg().csEdges().get(),
						new jedd.PhysicalDomain[] { C1.v(), KD.v(), MS.v(), ST.v() }))
				.iterator(new Attribute[]{A_tgtc.v(), A_tgtm.v()}); mIt.hasNext();) {
			Object[] tuple = (Object[])mIt.next();
			Context ctxt = (Context) tuple[0];
			SootMethod m = (SootMethod) tuple[1];
			
			if (m.isAbstract())
				continue;
			if (m.isNative())
				continue;
			if(TestPaddle.ignoreInit)
			{
				if(m.getName().equalsIgnoreCase(SootMethod.constructorName))
					continue;
				if(m.getName().equalsIgnoreCase(SootMethod.staticInitializerName))
					continue;
				
			}
//			 if(m.getName().contains("setItem"))
//			 {
//				 System.out.println("!!!!!!!!!!!!!!!!!!!setItem method: ");
//			 }
			findNTRWSets(ctxt,m);
		}
		closure();
	}

	public Iterator readSet(SootMethod m, Stmt s) {
		Scene.v().getUnitNumberer().add(s);
		return new jedd.internal.RelationContainer(
				new jedd.Attribute[] { A_fld.v() },
				new jedd.PhysicalDomain[] { FD.v() },
				("jedd.internal.Jedd.v().project(jedd.internal.Jedd.v().compos"
						+ "e(jedd.internal.Jedd.v().read(read), jedd.internal.Jedd.v()."
						+ "literal(new java.lang.Object[...], new jedd.Attribute[...], "
						+ "new jedd.PhysicalDomain[...]), new jedd.PhysicalDomain[...])"
						+ ", new jedd.PhysicalDomain[...]).iterator() at SideEffectAnal"
						+ "ysis.jedd:155,13-21"), jedd.internal.Jedd.v()
						.project(
								jedd.internal.Jedd.v().compose(
										jedd.internal.Jedd.v().read(read),
										jedd.internal.Jedd.v().literal(
												new Object[] { m, s },
												new jedd.Attribute[] {
														A_method.v(),
														A_stmt.v() },
												new jedd.PhysicalDomain[] {
														MT.v(), ST.v() }),
										new jedd.PhysicalDomain[] { MT.v(),
												ST.v() }),
								new jedd.PhysicalDomain[] { H1.v() }))
				.iterator();
	}

	public Iterator writeSet(SootMethod m, Stmt s) {
		Scene.v().getUnitNumberer().add(s);
		return new jedd.internal.RelationContainer(
				new jedd.Attribute[] { A_fld.v() },
				new jedd.PhysicalDomain[] { FD.v() },
				("jedd.internal.Jedd.v().project(jedd.internal.Jedd.v().compos"
						+ "e(jedd.internal.Jedd.v().read(write), jedd.internal.Jedd.v()"
						+ ".literal(new java.lang.Object[...], new jedd.Attribute[...],"
						+ " new jedd.PhysicalDomain[...]), new jedd.PhysicalDomain[...]"
						+ "), new jedd.PhysicalDomain[...]).iterator() at SideEffectAna"
						+ "lysis.jedd:162,13-21"), jedd.internal.Jedd.v()
						.project(
								jedd.internal.Jedd.v().compose(
										jedd.internal.Jedd.v().read(write),
										jedd.internal.Jedd.v().literal(
												new Object[] { m, s },
												new jedd.Attribute[] {
														A_method.v(),
														A_stmt.v() },
												new jedd.PhysicalDomain[] {
														MS.v(), ST.v() }),
										new jedd.PhysicalDomain[] { MS.v(),
												ST.v() }),
								new jedd.PhysicalDomain[] { H1.v() }))
				.iterator();
	}

	public CSHSSideEffectAnalysis() {
		super();
	}
}
