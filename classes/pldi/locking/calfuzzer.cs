Warning: Phase wjtp.tnlp is not a standard Soot phase listed in XML files.
Transforming Hello... 
Transforming benchmarks.AtomicityTest$Transaction... 
Transforming benchmarks.testcases.TestRace8... 
==============
 tn units (no order)
exitmonitor r3
entermonitor $r4
exitmonitor r3
<benchmarks.testcases.TestRace8: boolean cond> = 0
$r5 = <benchmarks.testcases.TestRace8: java.lang.Object lock>
$r6 := @caughtexception
virtualinvoke $r5.<java.lang.Object: void notify()>()
==============

Transforming benchmarks.testcases.TestDeadlock8... 
Transforming benchmarks.testcases.Thread2a... 
==============
 tn units (no order)
exitmonitor $r7
$r8 := @caughtexception
entermonitor $r5
exitmonitor r2
exitmonitor r1
exitmonitor r2
throw $r10
exitmonitor r3
entermonitor $r6
entermonitor $r4
$r10 := @caughtexception
goto [?= exitmonitor r2]
throw $r8
entermonitor $r7
$r9 := @caughtexception
$r5 = r0.<benchmarks.testcases.Thread2a: java.lang.Object l3>
$r6 = r0.<benchmarks.testcases.Thread2a: java.lang.Object l2>
exitmonitor r3
throw $r9
exitmonitor r1
goto [?= exitmonitor r1]
==============

==============
 tn units (no order)
exitmonitor $r7
$r8 := @caughtexception
entermonitor $r5
exitmonitor r2
exitmonitor r1
exitmonitor r2
throw $r10
exitmonitor r3
entermonitor $r6
$r10 := @caughtexception
goto [?= exitmonitor r2]
entermonitor $r7
throw $r8
$r9 := @caughtexception
$r6 = r0.<benchmarks.testcases.Thread2a: java.lang.Object l2>
exitmonitor r3
throw $r9
==============

==============
 tn units (no order)
$r10 := @caughtexception
exitmonitor $r7
$r8 := @caughtexception
throw $r8
entermonitor $r7
$r9 := @caughtexception
exitmonitor r1
exitmonitor r2
exitmonitor r3
exitmonitor r3
throw $r9
entermonitor $r6
==============

==============
 tn units (no order)
exitmonitor $r7
$r8 := @caughtexception
entermonitor $r7
$r9 := @caughtexception
exitmonitor r2
exitmonitor r3
==============

Transforming benchmarks.testcases.TestRace9$1... 
==============
 tn units (no order)
exitmonitor r1
$r4 := @caughtexception
exitmonitor r1
$r3 = <benchmarks.testcases.TestRace9: java.lang.Object lock>
entermonitor $r2
<benchmarks.testcases.TestRace9: boolean cond> = 0
virtualinvoke $r3.<java.lang.Object: void notify()>()
==============

Transforming benchmarks.testcases.TestDeadlock1... 
Transforming benchmarks.testcases.TestDeadlock2a... 
Transforming benchmarks.testcases.TestRace3$1... 
Transforming benchmarks.testcases.ThreadB2b... 
Transforming benchmarks.testcases.ThreadL4... 
==============
 tn units (no order)
exitmonitor r3
throw $r10
exitmonitor r2
$r10 := @caughtexception
exitmonitor $r7
entermonitor $r5
$r5 = r0.<benchmarks.testcases.ThreadL4: java.lang.Object l6>
exitmonitor r3
exitmonitor r2
throw $r9
entermonitor $r4
exitmonitor r1
$r6 = r0.<benchmarks.testcases.ThreadL4: java.lang.Object l7>
$r8 := @caughtexception
goto [?= exitmonitor r2]
exitmonitor r1
entermonitor $r6
throw $r8
entermonitor $r7
$r9 := @caughtexception
goto [?= exitmonitor r1]
==============

==============
 tn units (no order)
exitmonitor r3
exitmonitor r2
$r10 := @caughtexception
exitmonitor $r7
entermonitor $r5
exitmonitor r3
exitmonitor r2
throw $r9
$r6 = r0.<benchmarks.testcases.ThreadL4: java.lang.Object l7>
$r8 := @caughtexception
goto [?= exitmonitor r2]
exitmonitor r1
entermonitor $r6
throw $r8
entermonitor $r7
$r9 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r3
$r8 := @caughtexception
exitmonitor $r7
entermonitor $r6
exitmonitor r3
throw $r8
exitmonitor r2
entermonitor $r7
throw $r9
$r9 := @caughtexception
==============

==============
 tn units (no order)
$r8 := @caughtexception
exitmonitor $r7
exitmonitor r3
exitmonitor r2
entermonitor $r7
$r9 := @caughtexception
==============

Transforming benchmarks.testcases.TestRace4... 
Transforming benchmarks.testcases.ThreadA2... 
==============
 tn units (no order)
exitmonitor r1
exitmonitor $r3
$r4 := @caughtexception
exitmonitor r1
entermonitor $r3
entermonitor $r2
throw $r4
==============

==============
 tn units (no order)
exitmonitor r1
exitmonitor $r3
$r4 := @caughtexception
entermonitor $r3
==============

Transforming benchmarks.testcases.SyncObjecb... 
==============
 tn units (no order)
virtualinvoke r1.<benchmarks.testcases.SyncObjecb: void m2()>()
return
r1 := @parameter0: benchmarks.testcases.SyncObjecb
r0 := @this: benchmarks.testcases.SyncObjecb
==============

==============
 tn units (no order)
$r1 = <java.lang.System: java.io.PrintStream out>
virtualinvoke $r1.<java.io.PrintStream: void print(java.lang.String)>("a")
return
r0 := @this: benchmarks.testcases.SyncObjecb
==============

Transforming benchmarks.testcases.TestDeadlock6... 
Transforming benchmarks.testcases.Lift... 
Transforming benchmarks.testcases.SyncObject... 
==============
 tn units (no order)
return
virtualinvoke r1.<benchmarks.testcases.SyncObject: void m2()>()
r0 := @this: benchmarks.testcases.SyncObject
r1 := @parameter0: benchmarks.testcases.SyncObject
==============

==============
 tn units (no order)
virtualinvoke $r1.<java.io.PrintStream: void print(java.lang.String)>("a")
r0 := @this: benchmarks.testcases.SyncObject
return
$r1 = <java.lang.System: java.io.PrintStream out>
==============

Transforming benchmarks.testcases.ThreadB1... 
==============
 tn units (no order)
throw $r8
exitmonitor r3
entermonitor $r6
exitmonitor r3
exitmonitor $r7
entermonitor $r7
$r8 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r3
exitmonitor $r7
entermonitor $r7
$r8 := @caughtexception
==============

==============
 tn units (no order)
entermonitor $r14
entermonitor $r12
exitmonitor r13
$r15 := @caughtexception
exitmonitor r13
throw $r15
exitmonitor $r14
==============

==============
 tn units (no order)
entermonitor $r14
exitmonitor r13
$r15 := @caughtexception
exitmonitor $r14
==============

Transforming benchmarks.testcases.Thread2... 
==============
 tn units (no order)
exitmonitor $r3
entermonitor $r3
exitmonitor r1
$r4 := @caughtexception
entermonitor $r2
exitmonitor r1
throw $r4
==============

==============
 tn units (no order)
exitmonitor $r3
entermonitor $r3
exitmonitor r1
$r4 := @caughtexception
==============

Transforming benchmarks.testcases.TestRace8$1... 
==============
 tn units (no order)
$r5 := @caughtexception
virtualinvoke $r4.<java.lang.Object: void wait()>()
goto [?= exitmonitor r2]
virtualinvoke r3.<java.lang.InterruptedException: void printStackTrace()>()
$z0 = <benchmarks.testcases.TestRace8: boolean cond>
entermonitor $r1
exitmonitor r2
exitmonitor r2
r3 = $r5
$r6 := @caughtexception
$r4 = <benchmarks.testcases.TestRace8: java.lang.Object lock>
if $z0 == 0 goto exitmonitor r2
==============

Transforming benchmarks.testcases.ThreadG3... 
==============
 tn units (no order)
entermonitor $r2
exitmonitor $r3
exitmonitor r1
exitmonitor r1
throw $r4
$r4 := @caughtexception
entermonitor $r3
==============

==============
 tn units (no order)
exitmonitor $r3
exitmonitor r1
$r4 := @caughtexception
entermonitor $r3
==============

Transforming benchmarks.testcases.TestDeadlock7... 
Transforming benchmarks.testcases.Thread1a... 
==============
 tn units (no order)
goto [?= exitmonitor r2]
entermonitor $r5
entermonitor $r6
exitmonitor r1
exitmonitor r1
throw $r8
$r8 := @caughtexception
goto [?= exitmonitor r1]
exitmonitor r3
$r5 = r0.<benchmarks.testcases.Thread1a: java.lang.Object l2>
$r9 := @caughtexception
exitmonitor $r7
entermonitor $r4
$r10 := @caughtexception
entermonitor $r7
throw $r9
exitmonitor r2
exitmonitor r3
$r6 = r0.<benchmarks.testcases.Thread1a: java.lang.Object l1>
exitmonitor r2
==============

==============
 tn units (no order)
goto [?= exitmonitor r2]
entermonitor $r5
entermonitor $r6
throw $r8
$r8 := @caughtexception
exitmonitor r3
$r9 := @caughtexception
exitmonitor $r7
entermonitor $r7
throw $r9
exitmonitor r2
exitmonitor r3
$r6 = r0.<benchmarks.testcases.Thread1a: java.lang.Object l1>
exitmonitor r2
==============

==============
 tn units (no order)
exitmonitor $r7
entermonitor $r6
throw $r8
entermonitor $r7
$r8 := @caughtexception
exitmonitor r2
exitmonitor r3
exitmonitor r3
$r9 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor $r7
entermonitor $r7
$r8 := @caughtexception
exitmonitor r3
==============

==============
 tn units (no order)
exitmonitor r15
exitmonitor r19
exitmonitor r17
throw $r21
entermonitor $r14
exitmonitor $r20
goto [?= exitmonitor r15]
$r23 := @caughtexception
$r22 := @caughtexception
exitmonitor r19
goto [?= exitmonitor r17]
exitmonitor r15
exitmonitor r17
throw $r22
entermonitor $r16
$r16 = r0.<benchmarks.testcases.Thread1a: java.lang.Object l4>
$r21 := @caughtexception
$r18 = r0.<benchmarks.testcases.Thread1a: java.lang.Object l4>
entermonitor $r20
entermonitor $r18
==============

==============
 tn units (no order)
exitmonitor r19
exitmonitor r17
throw $r21
exitmonitor $r20
exitmonitor r19
$r22 := @caughtexception
goto [?= exitmonitor r17]
exitmonitor r17
throw $r22
entermonitor $r16
$r21 := @caughtexception
$r18 = r0.<benchmarks.testcases.Thread1a: java.lang.Object l4>
entermonitor $r20
entermonitor $r18
==============

==============
 tn units (no order)
exitmonitor r19
$r21 := @caughtexception
exitmonitor r17
entermonitor $r20
throw $r21
exitmonitor $r20
$r22 := @caughtexception
exitmonitor r19
entermonitor $r18
==============

==============
 tn units (no order)
exitmonitor r19
$r21 := @caughtexception
entermonitor $r20
exitmonitor $r20
==============

Transforming benchmarks.testcases.TestDeadlock4... 
Transforming benchmarks.testcases.TestRace11$1... 
==============
 tn units (no order)
<benchmarks.testcases.TestRace11: boolean cond> = 0
$r3 = <benchmarks.testcases.TestRace11: java.lang.Object lock>
$r4 := @caughtexception
exitmonitor r2
virtualinvoke $r3.<java.lang.Object: void notify()>()
entermonitor $r1
exitmonitor r2
==============

Transforming benchmarks.testcases.ThreadB1b... 
Transforming benchmarks.testcases.TestRace2$1... 
Transforming benchmarks.testcases.ThreadG3a... 
==============
 tn units (no order)
exitmonitor r1
$r4 := @caughtexception
throw $r4
entermonitor $r2
exitmonitor r1
exitmonitor $r3
entermonitor $r3
==============

==============
 tn units (no order)
exitmonitor r1
$r4 := @caughtexception
exitmonitor $r3
entermonitor $r3
==============

Transforming benchmarks.testcases.Thread1b... 
Transforming benchmarks.testcases.TestRace1$1... 
Transforming benchmarks.testcases.ThreadB4b... 
Transforming benchmarks.testcases.TestRace2... 
Transforming benchmarks.testcases.ThreadB3b... 
Transforming benchmarks.testcases.ThreadL2... 
==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
$r3 := @caughtexception
virtualinvoke r0.<benchmarks.testcases.ThreadL2: void foo()>()
entermonitor $r2
==============

==============
 tn units (no order)
entermonitor $r3
$r4 := @caughtexception
exitmonitor r1
entermonitor $r2
exitmonitor r1
throw $r4
exitmonitor $r3
==============

==============
 tn units (no order)
entermonitor $r3
$r4 := @caughtexception
exitmonitor r1
exitmonitor $r3
==============

Transforming benchmarks.testcases.ThreadG1... 
==============
 tn units (no order)
entermonitor $r4
throw $r5
$r5 := @caughtexception
exitmonitor r1
entermonitor $r3
exitmonitor r1
exitmonitor $r4
==============

==============
 tn units (no order)
entermonitor $r4
$r5 := @caughtexception
exitmonitor r1
exitmonitor $r4
==============

==============
 tn units (no order)
entermonitor $r9
entermonitor $r11
$r11 = r0.<benchmarks.testcases.ThreadG1: java.lang.Object l3>
exitmonitor r2
$r14 := @caughtexception
entermonitor $r12
exitmonitor $r12
exitmonitor r2
goto [?= exitmonitor r10]
throw $r14
exitmonitor r10
exitmonitor r10
$r13 := @caughtexception
throw $r13
==============

==============
 tn units (no order)
entermonitor $r11
exitmonitor r2
$r14 := @caughtexception
exitmonitor r10
$r13 := @caughtexception
exitmonitor r2
exitmonitor $r12
entermonitor $r12
==============

==============
 tn units (no order)
exitmonitor $r12
entermonitor $r12
==============

Transforming benchmarks.testcases.ThreadB4... 
==============
 tn units (no order)
entermonitor $r2
throw $r4
exitmonitor r1
entermonitor $r3
exitmonitor $r3
exitmonitor r1
$r4 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r1
entermonitor $r3
exitmonitor $r3
$r4 := @caughtexception
==============

Transforming benchmarks.testcases.ThreadA1... 
==============
 tn units (no order)
entermonitor $r2
$r5 := @caughtexception
exitmonitor $r4
exitmonitor r1
entermonitor $r4
entermonitor $r3
throw $r5
exitmonitor $r3
exitmonitor r1
==============

==============
 tn units (no order)
entermonitor $r3
exitmonitor $r3
==============

==============
 tn units (no order)
$r5 := @caughtexception
exitmonitor $r4
exitmonitor r1
entermonitor $r4
==============

==============
 tn units (no order)
entermonitor $r11
exitmonitor $r11
throw $r12
exitmonitor r10
exitmonitor r10
entermonitor $r9
$r12 := @caughtexception
==============

==============
 tn units (no order)
entermonitor $r11
exitmonitor $r11
exitmonitor r10
$r12 := @caughtexception
==============

Transforming benchmarks.testcases.TestRace5$1... 
==============
 tn units (no order)
exitmonitor r2
exitmonitor r2
<benchmarks.testcases.TestRace5: int x> = $i1
$r3 := @caughtexception
$i1 = $i0 + 1
$i0 = <benchmarks.testcases.TestRace5: int x>
entermonitor $r1
==============

Transforming benchmarks.testcases.TestRace10$1... 
==============
 tn units (no order)
r2 = $r5
virtualinvoke $r4.<java.lang.Object: void wait()>()
$z0 = <benchmarks.testcases.TestRace10: boolean cond>
entermonitor $r3
virtualinvoke r2.<java.lang.InterruptedException: void printStackTrace()>()
exitmonitor r1
exitmonitor r1
goto [?= exitmonitor r1]
if $z0 == 0 goto exitmonitor r1
$r4 = <benchmarks.testcases.TestRace10: java.lang.Object lock>
$r6 := @caughtexception
$r5 := @caughtexception
==============

Transforming benchmarks.testcases.ButtonPress... 
Transforming benchmarks.testcases.ThreadG1a... 
==============
 tn units (no order)
$r6 = r0.<benchmarks.testcases.ThreadG1a: java.lang.Object l2>
entermonitor $r7
$r8 = r0.<benchmarks.testcases.ThreadG1a: java.lang.Object l1>
entermonitor $r9
$r13 := @caughtexception
$r10 := @caughtexception
goto [?= exitmonitor r2]
$r12 := @caughtexception
exitmonitor r2
$r7 = r0.<benchmarks.testcases.ThreadG1a: java.lang.Object l1>
entermonitor $r8
throw $r13
$r11 := @caughtexception
exitmonitor r1
throw $r12
goto [?= exitmonitor r3]
throw $r11
exitmonitor r3
exitmonitor r3
exitmonitor r2
exitmonitor r1
goto [?= exitmonitor r1]
exitmonitor r4
throw $r10
entermonitor $r5
exitmonitor $r9
exitmonitor r4
entermonitor $r6
==============

==============
 tn units (no order)
entermonitor $r7
$r8 = r0.<benchmarks.testcases.ThreadG1a: java.lang.Object l1>
entermonitor $r9
throw $r11
goto [?= exitmonitor r3]
exitmonitor r3
$r13 := @caughtexception
exitmonitor r3
$r10 := @caughtexception
goto [?= exitmonitor r2]
$r12 := @caughtexception
exitmonitor r2
exitmonitor r2
exitmonitor r1
throw $r10
exitmonitor r4
$r7 = r0.<benchmarks.testcases.ThreadG1a: java.lang.Object l1>
entermonitor $r8
$r11 := @caughtexception
exitmonitor $r9
entermonitor $r6
exitmonitor r4
==============

==============
 tn units (no order)
entermonitor $r7
$r8 = r0.<benchmarks.testcases.ThreadG1a: java.lang.Object l1>
entermonitor $r9
goto [?= exitmonitor r3]
exitmonitor r3
exitmonitor r3
$r10 := @caughtexception
exitmonitor r4
throw $r10
entermonitor $r8
exitmonitor $r9
$r11 := @caughtexception
exitmonitor r4
==============

==============
 tn units (no order)
$r10 := @caughtexception
throw $r10
exitmonitor r4
entermonitor $r9
entermonitor $r8
exitmonitor $r9
exitmonitor r4
==============

==============
 tn units (no order)
$r10 := @caughtexception
exitmonitor r4
entermonitor $r9
exitmonitor $r9
==============

==============
 tn units (no order)
entermonitor $r23
exitmonitor r20
$r19 = r0.<benchmarks.testcases.ThreadG1a: java.lang.Object l3>
exitmonitor r22
entermonitor $r19
exitmonitor $r25
exitmonitor r24
entermonitor $r25
exitmonitor r18
$r28 := @caughtexception
goto [?= exitmonitor r22]
$r29 := @caughtexception
throw $r26
goto [?= exitmonitor r20]
goto [?= exitmonitor r18]
$r23 = r0.<benchmarks.testcases.ThreadG1a: java.lang.Object l4>
entermonitor $r21
exitmonitor r18
$r21 = r0.<benchmarks.testcases.ThreadG1a: java.lang.Object l5>
$r27 := @caughtexception
throw $r28
exitmonitor r20
exitmonitor r24
entermonitor $r17
exitmonitor r22
$r26 := @caughtexception
throw $r27
==============

==============
 tn units (no order)
entermonitor $r23
$r23 = r0.<benchmarks.testcases.ThreadG1a: java.lang.Object l4>
entermonitor $r21
exitmonitor r20
exitmonitor r22
$r21 = r0.<benchmarks.testcases.ThreadG1a: java.lang.Object l5>
entermonitor $r19
exitmonitor $r25
$r27 := @caughtexception
exitmonitor r24
throw $r28
entermonitor $r25
$r28 := @caughtexception
exitmonitor r20
goto [?= exitmonitor r22]
exitmonitor r24
exitmonitor r22
$r26 := @caughtexception
throw $r26
throw $r27
goto [?= exitmonitor r20]
==============

==============
 tn units (no order)
entermonitor $r23
$r23 = r0.<benchmarks.testcases.ThreadG1a: java.lang.Object l4>
entermonitor $r21
exitmonitor r22
exitmonitor $r25
exitmonitor r24
$r27 := @caughtexception
entermonitor $r25
$r28 := @caughtexception
exitmonitor r20
goto [?= exitmonitor r22]
exitmonitor r24
exitmonitor r22
$r26 := @caughtexception
throw $r26
==============

==============
 tn units (no order)
exitmonitor r24
entermonitor $r25
entermonitor $r23
exitmonitor r24
$r26 := @caughtexception
exitmonitor $r25
==============

==============
 tn units (no order)
entermonitor $r25
exitmonitor $r25
==============

Transforming benchmarks.testcases.TestRace3... 
Transforming benchmarks.testcases.TestRace5... 
==============
 tn units (no order)
entermonitor $r4
exitmonitor r3
$r5 := @caughtexception
<benchmarks.testcases.TestRace5: int x> = $i1
exitmonitor r3
$i1 = $i0 + 1
$i0 = <benchmarks.testcases.TestRace5: int x>
==============

Transforming benchmarks.testcases.Floor... 
Transforming benchmarks.testcases.TestRace6$1... 
==============
 tn units (no order)
exitmonitor r2
exitmonitor r2
<benchmarks.testcases.TestRace6: int x> = $i1
$i0 = <benchmarks.testcases.TestRace6: int x>
entermonitor $r1
$r3 := @caughtexception
$i1 = $i0 + 1
==============

Transforming benchmarks.testcases.TestRace10... 
==============
 tn units (no order)
exitmonitor r3
$r6 := @caughtexception
exitmonitor r3
<benchmarks.testcases.TestRace10: boolean cond> = 0
$r5 = <benchmarks.testcases.TestRace10: java.lang.Object lock>
virtualinvoke $r5.<java.lang.Object: void notify()>()
entermonitor $r4
==============

Transforming benchmarks.testcases.TestDeadlock1a... 
Transforming benchmarks.testcases.TestDeadlock4b... 
Transforming benchmarks.testcases.TestRace11... 
==============
 tn units (no order)
$r8 := @caughtexception
$r6 = <benchmarks.testcases.TestRace11: java.lang.Object lock>
$z0 = <benchmarks.testcases.TestRace11: boolean cond>
exitmonitor r3
exitmonitor r3
$r7 := @caughtexception
virtualinvoke r4.<java.lang.InterruptedException: void printStackTrace()>()
goto [?= exitmonitor r3]
virtualinvoke $r6.<java.lang.Object: void wait()>()
if $z0 == 0 goto exitmonitor r3
r4 = $r7
entermonitor $r5
==============

Transforming benchmarks.testcases.ThreadA3... 
==============
 tn units (no order)
exitmonitor r1
$r4 := @caughtexception
entermonitor $r3
throw $r4
exitmonitor r1
entermonitor $r2
exitmonitor $r3
==============

==============
 tn units (no order)
exitmonitor r1
$r4 := @caughtexception
entermonitor $r3
exitmonitor $r3
==============

Transforming benchmarks.testcases.ThreadB2... 
==============
 tn units (no order)
exitmonitor r1
entermonitor $r3
$r4 := @caughtexception
entermonitor $r2
exitmonitor r1
exitmonitor $r3
==============

==============
 tn units (no order)
entermonitor $r3
exitmonitor $r3
==============

Transforming benchmarks.testcases.TestRace9... 
==============
 tn units (no order)
$z0 = <benchmarks.testcases.TestRace9: boolean cond>
goto [?= exitmonitor r3]
exitmonitor r3
virtualinvoke r4.<java.lang.InterruptedException: void printStackTrace()>()
entermonitor $r5
exitmonitor r3
r4 = $r7
$r8 := @caughtexception
virtualinvoke $r6.<java.lang.Object: void wait()>()
$r6 = <benchmarks.testcases.TestRace9: java.lang.Object lock>
$r7 := @caughtexception
if $z0 == 0 goto exitmonitor r3
==============

Transforming benchmarks.testcases.Controls... 
==============
 tn units (no order)
specialinvoke $r5.<java.lang.StringBuilder: void <init>(java.lang.String)>("*** Someone on floor ")
$r17 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
$r14 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i0)
exitmonitor r1
$r19 := @caughtexception
if $i2 != 1 goto exitmonitor r1
$r18.<benchmarks.testcases.Floor: boolean downFlag> = 0
$r16 = $r15.<benchmarks.testcases.Floor: java.util.Vector downPeople>
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.String toString()>()
$r11 = $r10[i0]
specialinvoke $r13.<java.lang.Integer: void <init>(int)>(i1)
$r10 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
$r13 = new java.lang.Integer
$r4 = <java.lang.System: java.io.PrintStream out>
exitmonitor r1
virtualinvoke $r4.<java.io.PrintStream: void println(java.lang.String)>($r9)
$r15 = $r14[i0]
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i1)
$r12 = $r11.<benchmarks.testcases.Floor: java.util.Vector downPeople>
$i2 = virtualinvoke $r16.<java.util.Vector: int size()>()
$r18 = $r17[i0]
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" wants to go to ")
virtualinvoke $r12.<java.util.Vector: void addElement(java.lang.Object)>($r13)
$r5 = new java.lang.StringBuilder
entermonitor $r3
==============

==============
 tn units (no order)
$r4 = <java.lang.System: java.io.PrintStream out>
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.String toString()>()
$r14 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i1)
$i2 = virtualinvoke $r16.<java.util.Vector: int size()>()
exitmonitor r1
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i0)
$r13 = new java.lang.Integer
exitmonitor r1
$r17 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
specialinvoke $r13.<java.lang.Integer: void <init>(int)>(i1)
$r18 = $r17[i0]
virtualinvoke $r4.<java.io.PrintStream: void println(java.lang.String)>($r9)
$r11 = $r10[i0]
$r18.<benchmarks.testcases.Floor: boolean upFlag> = 0
virtualinvoke $r12.<java.util.Vector: void addElement(java.lang.Object)>($r13)
$r16 = $r15.<benchmarks.testcases.Floor: java.util.Vector upPeople>
if $i2 != 1 goto exitmonitor r1
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" wants to go to ")
$r15 = $r14[i0]
$r12 = $r11.<benchmarks.testcases.Floor: java.util.Vector upPeople>
specialinvoke $r5.<java.lang.StringBuilder: void <init>(java.lang.String)>("*** Someone on floor ")
$r10 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
$r5 = new java.lang.StringBuilder
$r19 := @caughtexception
entermonitor $r3
==============

==============
 tn units (no order)
$r8 = $r7[i0]
exitmonitor r2
entermonitor $r4
if $z1 != 0 goto exitmonitor r2
exitmonitor r2
$r7 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
exitmonitor r2
$z1 = $r6.<benchmarks.testcases.Floor: boolean upFlag>
$r9 := @caughtexception
$r6 = $r5[i0]
$r8.<benchmarks.testcases.Floor: boolean upFlag> = 1
$r5 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
==============

==============
 tn units (no order)
$z1 = $r6.<benchmarks.testcases.Floor: boolean downFlag>
$r9 := @caughtexception
entermonitor $r4
exitmonitor r2
$r7 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
$r8.<benchmarks.testcases.Floor: boolean downFlag> = 1
exitmonitor r2
$r8 = $r7[i0]
$r6 = $r5[i0]
exitmonitor r2
if $z1 != 0 goto exitmonitor r2
$r5 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
==============

==============
 tn units (no order)
goto [?= z0 = $z1]
if z0 == 0 goto $z3 = 0
if $z2 != 0 goto $z3 = 0
z0 = $z1
$z2 = $r8.<benchmarks.testcases.Floor: boolean upFlag>
if $i1 == 0 goto $z1 = 0
z4 = $z3
$r8 = $r7[i0]
goto [?= z4 = $z3]
$z3 = 1
exitmonitor r1
$r5 = $r4[i0]
$r6 = $r5.<benchmarks.testcases.Floor: java.util.Vector upPeople>
$z1 = 0
exitmonitor r1
$r9 := @caughtexception
$z3 = 0
$r4 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
$z1 = 1
$r7 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
entermonitor $r3
$i1 = virtualinvoke $r6.<java.util.Vector: int size()>()
==============

==============
 tn units (no order)
$i1 = virtualinvoke $r6.<java.util.Vector: int size()>()
goto [?= z4 = $z3]
if $z2 != 0 goto $z3 = 0
goto [?= z0 = $z1]
$z1 = 0
$z3 = 0
$z1 = 1
$z2 = $r8.<benchmarks.testcases.Floor: boolean downFlag>
entermonitor $r3
z0 = $z1
if z0 == 0 goto $z3 = 0
$r6 = $r5.<benchmarks.testcases.Floor: java.util.Vector downPeople>
$z3 = 1
$r9 := @caughtexception
$r7 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
z4 = $z3
exitmonitor r1
exitmonitor r1
if $i1 == 0 goto $z1 = 0
$r5 = $r4[i0]
$r8 = $r7[i0]
$r4 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
==============

==============
 tn units (no order)
$r10 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
exitmonitor r1
$r5 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
specialinvoke $r9.<java.util.Vector: void <init>()>()
$r11 = $r10[i0]
$r8.<benchmarks.testcases.Floor: java.util.Vector upPeople> = $r9
$r9 = new java.util.Vector
entermonitor $r4
r2 = $r6.<benchmarks.testcases.Floor: java.util.Vector upPeople>
$r7 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
$r13 := @caughtexception
$r8 = $r7[i0]
exitmonitor r1
$r11.<benchmarks.testcases.Floor: boolean upFlag> = 0
$r6 = $r5[i0]
==============

==============
 tn units (no order)
$r11.<benchmarks.testcases.Floor: boolean downFlag> = 0
exitmonitor r1
entermonitor $r4
$r9 = new java.util.Vector
$r13 := @caughtexception
$r5 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
specialinvoke $r9.<java.util.Vector: void <init>()>()
exitmonitor r1
$r6 = $r5[i0]
r2 = $r6.<benchmarks.testcases.Floor: java.util.Vector downPeople>
$r8.<benchmarks.testcases.Floor: java.util.Vector downPeople> = $r9
$r7 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
$r10 = r0.<benchmarks.testcases.Controls: benchmarks.testcases.Floor[] floors>
$r11 = $r10[i0]
$r8 = $r7[i0]
==============

Transforming benchmarks.testcases.ThreadL1... 
==============
 tn units (no order)
exitmonitor $r3
entermonitor $r2
exitmonitor r1
$r4 := @caughtexception
entermonitor $r3
throw $r4
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor $r3
$r4 := @caughtexception
entermonitor $r3
exitmonitor r1
==============

Transforming benchmarks.testcases.TestRace1$2... 
Transforming benchmarks.testcases.ThreadG4... 
==============
 tn units (no order)
exitmonitor r1
$r7 := @caughtexception
$r6 := @caughtexception
exitmonitor r2
throw $r6
entermonitor $r3
entermonitor $r4
exitmonitor $r5
throw $r7
$r4 = r0.<benchmarks.testcases.ThreadG4: java.lang.Object l4>
entermonitor $r5
exitmonitor r2
exitmonitor r1
goto [?= exitmonitor r1]
==============

==============
 tn units (no order)
exitmonitor $r5
entermonitor $r4
throw $r7
exitmonitor r1
$r7 := @caughtexception
entermonitor $r5
$r6 := @caughtexception
exitmonitor r2
exitmonitor r2
throw $r6
==============

==============
 tn units (no order)
exitmonitor $r5
exitmonitor r1
$r7 := @caughtexception
entermonitor $r5
$r6 := @caughtexception
exitmonitor r2
==============

Transforming benchmarks.testcases.TestRace1... 
Transforming benchmarks.testcases.ThreadG2a... 
==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor $r3
entermonitor $r3
throw $r4
exitmonitor r1
entermonitor $r2
exitmonitor r1
==============

==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor $r3
entermonitor $r3
exitmonitor r1
==============

Transforming benchmarks.testcases.TestDeadlock1b... 
Transforming benchmarks.testcases.TestDeadlock3... 
Transforming benchmarks.testcases.TestRace6... 
==============
 tn units (no order)
$i1 = $i0 + 1
<benchmarks.testcases.TestRace6: int x> = $i1
$i0 = <benchmarks.testcases.TestRace6: int x>
exitmonitor r3
entermonitor $r4
exitmonitor r3
$r5 := @caughtexception
==============

Transforming benchmarks.testcases.TestRace7... 
==============
 tn units (no order)
exitmonitor r3
exitmonitor r4
entermonitor $r6
throw $r8
$r8 := @caughtexception
<benchmarks.testcases.TestRace7: int x> = $i1
entermonitor $r5
$r7 := @caughtexception
$r6 = <benchmarks.testcases.TestRace7: java.lang.Object lock2>
$i0 = <benchmarks.testcases.TestRace7: int x>
throw $r7
$i1 = $i0 + 1
goto [?= exitmonitor r3]
exitmonitor r4
exitmonitor r3
==============

==============
 tn units (no order)
exitmonitor r3
exitmonitor r4
<benchmarks.testcases.TestRace7: int x> = $i1
entermonitor $r6
$r7 := @caughtexception
$i0 = <benchmarks.testcases.TestRace7: int x>
$r8 := @caughtexception
$i1 = $i0 + 1
exitmonitor r4
==============

Transforming benchmarks.testcases.TestDeadlock2... 
Transforming benchmarks.testcases.ThreadG2... 
==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
$r4 := @caughtexception
exitmonitor $r3
entermonitor $r2
entermonitor $r3
==============

==============
 tn units (no order)
exitmonitor $r3
entermonitor $r3
==============

Transforming benchmarks.testcases.ThreadG4a... 
==============
 tn units (no order)
exitmonitor r1
entermonitor $r7
exitmonitor r1
$r13 := @caughtexception
$r11 := @caughtexception
exitmonitor r2
exitmonitor $r9
$r10 := @caughtexception
exitmonitor r2
exitmonitor r3
goto [?= exitmonitor r3]
$r6 = r0.<benchmarks.testcases.ThreadG4a: java.lang.Object l4>
entermonitor $r9
throw $r10
goto [?= exitmonitor r1]
$r8 = r0.<benchmarks.testcases.ThreadG4a: java.lang.Object l5>
goto [?= exitmonitor r2]
$r12 := @caughtexception
exitmonitor r4
exitmonitor r3
entermonitor $r5
throw $r12
entermonitor $r8
entermonitor $r6
exitmonitor r4
$r7 = r0.<benchmarks.testcases.ThreadG4a: java.lang.Object l3>
throw $r11
==============

==============
 tn units (no order)
entermonitor $r7
$r8 = r0.<benchmarks.testcases.ThreadG4a: java.lang.Object l5>
$r12 := @caughtexception
goto [?= exitmonitor r2]
exitmonitor r4
exitmonitor r3
$r11 := @caughtexception
exitmonitor r2
entermonitor $r8
exitmonitor $r9
entermonitor $r6
$r7 = r0.<benchmarks.testcases.ThreadG4a: java.lang.Object l3>
exitmonitor r4
$r10 := @caughtexception
throw $r11
exitmonitor r2
exitmonitor r3
goto [?= exitmonitor r3]
throw $r10
entermonitor $r9
==============

==============
 tn units (no order)
entermonitor $r7
$r8 = r0.<benchmarks.testcases.ThreadG4a: java.lang.Object l5>
exitmonitor r4
exitmonitor r3
$r11 := @caughtexception
entermonitor $r8
exitmonitor $r9
exitmonitor r4
$r10 := @caughtexception
exitmonitor r3
goto [?= exitmonitor r3]
entermonitor $r9
throw $r10
==============

==============
 tn units (no order)
exitmonitor $r9
entermonitor $r8
exitmonitor r4
exitmonitor r4
$r10 := @caughtexception
throw $r10
entermonitor $r9
==============

==============
 tn units (no order)
exitmonitor $r9
exitmonitor r4
$r10 := @caughtexception
entermonitor $r9
==============

Transforming benchmarks.testcases.TestRace7$1... 
==============
 tn units (no order)
exitmonitor r2
<benchmarks.testcases.TestRace7: int x> = $i1
$i1 = $i0 + 1
$r3 := @caughtexception
$i0 = <benchmarks.testcases.TestRace7: int x>
entermonitor $r1
exitmonitor r2
==============

Transforming benchmarks.testcases.ThreadA4... 
==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
exitmonitor r1
entermonitor $r3
exitmonitor $r3
$r4 := @caughtexception
==============

==============
 tn units (no order)
entermonitor $r3
exitmonitor $r3
==============

Transforming benchmarks.testcases.Thread2b... 
Transforming benchmarks.testcases.TestDeadlock5... 
Transforming benchmarks.testcases.TestRace4$1... 
==============
 tn units (no order)
exitmonitor r2
exitmonitor r2
$r3 := @caughtexception
$i0 = <benchmarks.testcases.TestRace4: int x>
$i1 = $i0 + 1
entermonitor $r1
<benchmarks.testcases.TestRace4: int x> = $i1
==============

Transforming benchmarks.testcases.ThreadL3... 
==============
 tn units (no order)
exitmonitor $r3
$r4 := @caughtexception
entermonitor $r2
entermonitor $r3
throw $r4
exitmonitor r1
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor $r3
$r4 := @caughtexception
entermonitor $r3
exitmonitor r1
==============

Transforming benchmarks.testcases.Thread7... 
==============
 tn units (no order)
entermonitor $r3
$r4 := @caughtexception
exitmonitor r1
exitmonitor $r3
entermonitor $r2
exitmonitor r1
==============

==============
 tn units (no order)
entermonitor $r3
exitmonitor $r3
==============

Transforming benchmarks.testcases.Thread1... 
==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
entermonitor $r2
exitmonitor $r3
entermonitor $r3
$r4 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor $r3
entermonitor $r3
==============

==============
 tn units (no order)
exitmonitor r9
entermonitor $r10
throw $r11
$r11 := @caughtexception
exitmonitor $r10
exitmonitor r9
entermonitor $r8
==============

==============
 tn units (no order)
entermonitor $r10
$r11 := @caughtexception
exitmonitor $r10
exitmonitor r9
==============

Transforming benchmarks.testcases.ThreadB3... 
==============
 tn units (no order)
entermonitor $r2
exitmonitor r1
exitmonitor r1
$r4 := @caughtexception
entermonitor $r3
exitmonitor $r3
==============

==============
 tn units (no order)
entermonitor $r3
exitmonitor $r3
==============

Transforming benchmarks.testcases.Thread8... 
==============
 tn units (no order)
entermonitor $r3
exitmonitor r1
exitmonitor r1
entermonitor $r2
exitmonitor $r3
$r4 := @caughtexception
==============

==============
 tn units (no order)
entermonitor $r3
exitmonitor $r3
==============

Transforming benchmarks.tsp.Tsp... 
Transforming benchmarks.tsp.PrioQElement... 
Transforming benchmarks.tsp.TspSolver... 
==============
 tn units (no order)
r1.<benchmarks.tsp.TourElement: int prefix_weight> = $i16
r1.<benchmarks.tsp.TourElement: int last> = $i11
$i15 = $r15[i1]
exitmonitor r0
if $i4 < 0 goto $r5 = <java.lang.System: java.io.PrintStream out>
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.String toString()>()
goto [?= $i10 = <benchmarks.tsp.Tsp: int TspSize>]
$i18 = $i17 + 1
$i6 = $i5 - 1
$i7 = <benchmarks.tsp.TspSolver: int TourStackTop>
$i9 = r2.<benchmarks.tsp.TourElement: int conn>
$i22 = staticinvoke <benchmarks.tsp.TspSolver: int calc_bound(int)>(i2)
if i3 < $i10 goto $r11 = r1.<benchmarks.tsp.TourElement: int[] prefix>
$r14 = r1.<benchmarks.tsp.TourElement: int[] prefix>
$r19 := @caughtexception
$r11[i3] = $i8
virtualinvoke $r5.<java.io.PrintStream: void println(java.lang.String)>($r8)
$r10 = <benchmarks.tsp.TspSolver: benchmarks.tsp.TourElement[] Tours>
$r16[$i18] = i1
$i5 = <benchmarks.tsp.TspSolver: int TourStackTop>
$r11 = r1.<benchmarks.tsp.TourElement: int[] prefix>
goto [?= $r9 = <benchmarks.tsp.TspSolver: benchmarks.tsp.TourElement[] Tours>]
$i13 = r1.<benchmarks.tsp.TourElement: int last>
$i4 = <benchmarks.tsp.TspSolver: int TourStackTop>
$r12 = r2.<benchmarks.tsp.TourElement: int[] prefix>
$r16 = r1.<benchmarks.tsp.TourElement: int[] prefix>
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i7)
$i14 = $r14[$i13]
$i16 = $i12 + $i15
r1 = $r9[i2]
r1.<benchmarks.tsp.TourElement: int conn> = $i9
$i11 = r2.<benchmarks.tsp.TourElement: int last>
$r6 = new java.lang.StringBuilder
r1.<benchmarks.tsp.TourElement: int last> = $i18
r2 = $r10[i0]
staticinvoke <java.lang.System: void exit(int)>(-1)
i2 = $r4[$i5]
specialinvoke $r6.<java.lang.StringBuilder: void <init>(java.lang.String)>("TourStackTop: ")
$i19 = r1.<benchmarks.tsp.TourElement: int conn>
$r13 = <benchmarks.tsp.TspSolver: int[][] weights>
i3 = 0
<benchmarks.tsp.TspSolver: int TourStackTop> = $i6
r1.<benchmarks.tsp.TourElement: int conn> = $i21
$i20 = 1 << i1
$i10 = <benchmarks.tsp.Tsp: int TspSize>
entermonitor $r3
$r4 = <benchmarks.tsp.TspSolver: int[] TourStack>
$i8 = $r12[i3]
$i12 = r2.<benchmarks.tsp.TourElement: int prefix_weight>
$i21 = $i19 | $i20
$r15 = $r13[$i14]
$r9 = <benchmarks.tsp.TspSolver: benchmarks.tsp.TourElement[] Tours>
i3 = i3 + 1
exitmonitor r0
$r5 = <java.lang.System: java.io.PrintStream out>
$i17 = r1.<benchmarks.tsp.TourElement: int last>
==============

==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
goto [?= $i5 = <benchmarks.tsp.Tsp: int TspSize>]
i2 = i2 + 1
$i5 = <benchmarks.tsp.Tsp: int TspSize>
$i3 = <benchmarks.tsp.TspSolver: int MinTourLen>
<benchmarks.tsp.TspSolver: int MinTourLen> = i0
$r3[i2] = $i4
if i0 >= $i3 goto exitmonitor r1
i2 = 0
$r4 := @caughtexception
if i2 < $i5 goto $r3 = <benchmarks.tsp.TspSolver: int[] MinTour>
$i4 = r0[i2]
$r3 = <benchmarks.tsp.TspSolver: int[] MinTour>
exitmonitor r1
==============

==============
 tn units (no order)
$r12 = r1.<benchmarks.tsp.TourElement: int[] prefix>
if i3 < $i46 goto $r15 = <benchmarks.tsp.TspSolver: int[][] weights>
if i3 == $i43 goto (branch)
$i56 = r1.<benchmarks.tsp.TourElement: int mst_weight>
$i13 = <benchmarks.tsp.Tsp: int TspSize>
r1.<benchmarks.tsp.TourElement: int mst_weight> = $i55
$i32 = r1.<benchmarks.tsp.TourElement: int last>
$i55 = $i54 + 1
if i3 == $i45 goto (branch)
$i39 = 2000000
$i30 = $i29 + 1
$i17 = r1.<benchmarks.tsp.TourElement: int prefix_weight>
$r4[$i14] = i1
i3 = i3 + 1
$r22 := @caughtexception
if $i32 == $i34 goto $i56 = r1.<benchmarks.tsp.TourElement: int mst_weight>
$i2 = <benchmarks.tsp.Tsp: int TspSize>
i3 = 0
if i6 >= i5 goto (branch)
$r18 = r1.<benchmarks.tsp.TourElement: int[] prefix>
$i23 = $r11[$i22]
i4 = i6
$i19 = $r8[$i18]
i1 = 0
$i8 = <benchmarks.tsp.Tsp: int TspSize>
$i18 = $i2 - 2
$i58 = $i56 + $i57
$i25 = $i17 + $i24
goto [?= i35 = i35 + 1]
entermonitor $r3
$i41 = 1 << i35
$i26 = r1.<benchmarks.tsp.TourElement: int prefix_weight>
$i37 = 1 << i35
i4 = i5
if $i26 >= $i27 goto r1.<benchmarks.tsp.TourElement: int lower_bound> = 2000000
$i12 = $i10 & $i11
$r9 = $r7[$i19]
r1.<benchmarks.tsp.TourElement: int mst_weight> = $i50
$i28 = r1.<benchmarks.tsp.TourElement: int prefix_weight>
$r13 = r1.<benchmarks.tsp.TourElement: int[] prefix>
r1.<benchmarks.tsp.TourElement: int lower_bound> = 2000000
if i6 >= i4 goto i3 = i3 + 1
i35 = 0
i5 = $i39
goto [?= $i31 = <benchmarks.tsp.Tsp: int TspSize>]
goto [?= $i46 = <benchmarks.tsp.Tsp: int TspSize>]
i6 = $r16[i3]
staticinvoke <benchmarks.tsp.TspSolver: void set_best(int,int[])>($i28, $r13)
exitmonitor r2
$i29 = <benchmarks.tsp.TspSolver: int TourStackTop>
$i7 = r1.<benchmarks.tsp.TourElement: int last>
goto [?= i3 = i3 + 1]
$i20 = $r9[i1]
r1.<benchmarks.tsp.TourElement: int mst_weight> = $i52
$i27 = <benchmarks.tsp.TspSolver: int MinTourLen>
r1.<benchmarks.tsp.TourElement: int prefix_weight> = $i25
if $i42 == 0 goto (branch)
$r17 = r1.<benchmarks.tsp.TourElement: int[] prefix>
$i43 = $r17[0]
$i50 = $i47 + $i49
$r10 = <benchmarks.tsp.TspSolver: int[][] weights>
$i21 = <benchmarks.tsp.Tsp: int StartNode>
$i22 = $r12[$i21]
$i54 = r1.<benchmarks.tsp.TourElement: int mst_weight>
$i24 = $i20 + $i23
goto [?= $i53 = <benchmarks.tsp.Tsp: int TspSize>]
goto [?= i35 = i35 + 1]
$r5 = r1.<benchmarks.tsp.TourElement: int[] prefix>
$r7 = <benchmarks.tsp.TspSolver: int[][] weights>
r1.<benchmarks.tsp.TourElement: int lower_bound> = $i58
$r5[$i15] = $i16
$r14 = <benchmarks.tsp.TspSolver: int[] TourStack>
$i33 = <benchmarks.tsp.Tsp: int TspSize>
$i57 = r1.<benchmarks.tsp.TourElement: int prefix_weight>
i35 = i35 + 1
$i46 = <benchmarks.tsp.Tsp: int TspSize>
$r4 = r1.<benchmarks.tsp.TourElement: int[] prefix>
$r16 = $r15[i35]
if $i12 != 0 goto i1 = i1 + 1
$r11 = $r10[i1]
$i31 = <benchmarks.tsp.Tsp: int TspSize>
exitmonitor r2
$i9 = $i8 - 2
$i48 = i5 + i4
if i1 < $i31 goto $i10 = r1.<benchmarks.tsp.TourElement: int conn>
$i40 = r1.<benchmarks.tsp.TourElement: int conn>
i4 = $i39
if i5 == 2000000 goto i35 = i35 + 1
$i15 = <benchmarks.tsp.Tsp: int TspSize>
if i35 < $i53 goto $i36 = r1.<benchmarks.tsp.TourElement: int conn>
<benchmarks.tsp.TspSolver: int TourStackTop> = $i30
$r14[$i30] = i0
$i14 = $i13 - 1
if $i38 == 0 goto i3 = 0
if i4 == 2000000 goto (branch)
$i45 = $r18[$i44]
$i53 = <benchmarks.tsp.Tsp: int TspSize>
$i47 = r1.<benchmarks.tsp.TourElement: int mst_weight>
$i10 = r1.<benchmarks.tsp.TourElement: int conn>
i1 = i1 + 1
$i11 = 1 << i1
exitmonitor r2
$i34 = $i33 - 1
$r8 = r1.<benchmarks.tsp.TourElement: int[] prefix>
$i36 = r1.<benchmarks.tsp.TourElement: int conn>
if i6 == 0 goto i3 = i3 + 1
r1.<benchmarks.tsp.TourElement: int mst_weight> = 0
$i52 = $i51 + i5
$i38 = $i36 & $i37
$i16 = <benchmarks.tsp.Tsp: int StartNode>
$r15 = <benchmarks.tsp.TspSolver: int[][] weights>
$i42 = $i40 & $i41
$i51 = r1.<benchmarks.tsp.TourElement: int mst_weight>
$i49 = $i48 >> 1
goto [?= i3 = i3 + 1]
if $i7 != $i9 goto r1.<benchmarks.tsp.TourElement: int mst_weight> = 0
$i44 = r1.<benchmarks.tsp.TourElement: int last>
i5 = i6
==============

==============
 tn units (no order)
if i3 == 0 goto $z4 = 0
$r8 = <benchmarks.tsp.TspSolver: int[][] weights>
r3 = $r10[i4]
$i13 = r2.<benchmarks.tsp.TourElement: int conn>
$r7 = r2.<benchmarks.tsp.TourElement: int[] prefix>
entermonitor $r0
i6 = i5 >> 1
r4.<benchmarks.tsp.PrioQElement: int index> = $i25
$i27 = <benchmarks.tsp.Tsp: int TspSize>
r4.<benchmarks.tsp.PrioQElement: int priority> = $i24
$r15 = <benchmarks.tsp.TspSolver: benchmarks.tsp.PrioQElement[] PrioQ>
i2 = i2 + 1
$z4 = 1
<benchmarks.tsp.TspSolver: int PrioQLast> = $i23
i8 = r4.<benchmarks.tsp.PrioQElement: int priority>
$i18 = <benchmarks.tsp.TspSolver: int MinTourLen>
if $i17 > $i18 goto $z5 = 0
r5 = $r16[i6]
$r16 = <benchmarks.tsp.TspSolver: benchmarks.tsp.PrioQElement[] PrioQ>
virtualinvoke $r11.<java.io.PrintStream: void println(java.lang.String)>($r14)
$i10 = <benchmarks.tsp.Tsp: int TspSize>
z1 = $z4
if $i20 < 4999 goto $i22 = <benchmarks.tsp.TspSolver: int PrioQLast>
$i24 = r3.<benchmarks.tsp.TourElement: int lower_bound>
i3 = $r9[i2]
$z6 = staticinvoke <benchmarks.tsp.TspSolver: boolean less_than(benchmarks.tsp.PrioQElement,benchmarks.tsp.PrioQElement)>(r4, r5)
$z3 = 1
goto [?= (branch)]
exitmonitor r1
$i26 = r5.<benchmarks.tsp.PrioQElement: int priority>
r2 = $r6[i0]
if $z6 != 0 goto i7 = r4.<benchmarks.tsp.PrioQElement: int index>
$r11 = <java.lang.System: java.io.PrintStream out>
if i2 < $i27 goto $r8 = <benchmarks.tsp.TspSolver: int[][] weights>
r5.<benchmarks.tsp.PrioQElement: int priority> = i8
exitmonitor r1
$i21 = <benchmarks.tsp.TspSolver: int PrioQLast>
$i20 = <benchmarks.tsp.TspSolver: int PrioQLast>
$z5 = 0
r4.<benchmarks.tsp.PrioQElement: int priority> = $i26
if z0 == 0 goto i2 = i2 + 1
$i15 = $i13 & $i14
$i14 = 1 << i2
$r18 := @caughtexception
if $i19 != -1 goto $r10 = <benchmarks.tsp.TspSolver: benchmarks.tsp.TourElement[] Tours>
goto [?= z0 = $z3]
if i5 <= 1 goto i2 = i2 + 1
$r6 = <benchmarks.tsp.TspSolver: benchmarks.tsp.TourElement[] Tours>
goto [?= z1 = $z4]
$i19 = staticinvoke <benchmarks.tsp.TspSolver: int new_tour(int,int)>(i0, i2)
$r10 = <benchmarks.tsp.TspSolver: benchmarks.tsp.TourElement[] Tours>
r4.<benchmarks.tsp.PrioQElement: int index> = i4
i4 = $i19
i5 = i6
specialinvoke $r12.<java.lang.StringBuilder: void <init>(java.lang.String)>("pqLast ")
$i12 = r2.<benchmarks.tsp.TourElement: int last>
goto [?= z2 = $z5]
$i17 = $i16 + i3
r4 = $r15[i5]
$r13 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i21)
$i9 = r2.<benchmarks.tsp.TourElement: int last>
i7 = r4.<benchmarks.tsp.PrioQElement: int index>
$i11 = $i10 - 1
$i25 = r5.<benchmarks.tsp.PrioQElement: int index>
$z4 = 0
$i16 = r2.<benchmarks.tsp.TourElement: int lower_bound>
$r17 = <benchmarks.tsp.TspSolver: benchmarks.tsp.PrioQElement[] PrioQ>
$i23 = $i22 + 1
staticinvoke <java.lang.System: void exit(int)>(-1)
$r9 = $r8[i1]
if z2 == 0 goto i2 = i2 + 1
goto [?= i2 = i2 + 1]
r5.<benchmarks.tsp.PrioQElement: int index> = i7
i6 = i5 >> 1
goto [?= $i27 = <benchmarks.tsp.Tsp: int TspSize>]
$z5 = 1
i2 = 0
z2 = $z5
$z3 = 0
$i22 = <benchmarks.tsp.TspSolver: int PrioQLast>
i1 = $r7[$i12]
$r12 = new java.lang.StringBuilder
r4 = r5
if $i15 != 0 goto $z3 = 0
$r14 = virtualinvoke $r13.<java.lang.StringBuilder: java.lang.String toString()>()
if $i9 == $i11 goto exitmonitor r1
z0 = $z3
i5 = $i23
if z1 == 0 goto i2 = i2 + 1
r5 = $r17[i6]
==============

==============
 tn units (no order)
i1 = 1
$r9 = <benchmarks.tsp.TspSolver: benchmarks.tsp.PrioQElement[] PrioQ>
r10.<benchmarks.tsp.PrioQElement: int index> = i5
$r8 = <benchmarks.tsp.TspSolver: benchmarks.tsp.PrioQElement[] PrioQ>
if $z0 == 0 goto i4 = i3
r5 = $r9[i3]
$r6 = <benchmarks.tsp.TspSolver: benchmarks.tsp.PrioQElement[] PrioQ>
i2 = staticinvoke <benchmarks.tsp.TspSolver: int LEFT_CHILD(int)>(i1)
$i15 = $i14 - 1
i3 = staticinvoke <benchmarks.tsp.TspSolver: int RIGHT_CHILD(int)>(i1)
$r13[$i28] = i0
$i13 = r3.<benchmarks.tsp.PrioQElement: int priority>
r10.<benchmarks.tsp.PrioQElement: int priority> = i6
$i27 = <benchmarks.tsp.TspSolver: int TourStackTop>
if i2 == $i16 goto i4 = i2
$i18 = r10.<benchmarks.tsp.PrioQElement: int priority>
$i22 = <benchmarks.tsp.Tsp: int TspSize>
$i9 = r2.<benchmarks.tsp.PrioQElement: int priority>
i5 = r2.<benchmarks.tsp.PrioQElement: int index>
r2.<benchmarks.tsp.PrioQElement: int index> = $i17
exitmonitor r1
goto [?= $i19 = <benchmarks.tsp.TspSolver: int PrioQLast>]
$i11 = <benchmarks.tsp.TspSolver: int PrioQLast>
r2 = r10
i7 = $r12.<benchmarks.tsp.TourElement: int last>
$i25 = $i24 - 1
exitmonitor r1
if i7 >= 1 goto $r13 = <benchmarks.tsp.TspSolver: int[] TourStack>
r3 = $r7[$i11]
i1 = i4
if i1 <= $i20 goto i2 = staticinvoke <benchmarks.tsp.TspSolver: int LEFT_CHILD(int)>(i1)
r10 = r5
$i12 = r3.<benchmarks.tsp.PrioQElement: int index>
<benchmarks.tsp.TspSolver: int PrioQLast> = $i15
$i19 = <benchmarks.tsp.TspSolver: int PrioQLast>
exitmonitor r1
$i28 = $i27 + 1
$r7 = <benchmarks.tsp.TspSolver: benchmarks.tsp.PrioQElement[] PrioQ>
$i8 = <benchmarks.tsp.TspSolver: int Done>
if $i29 != 0 goto $r6 = <benchmarks.tsp.TspSolver: benchmarks.tsp.PrioQElement[] PrioQ>
r2.<benchmarks.tsp.PrioQElement: int priority> = $i13
r4 = $r8[i2]
$i23 = <benchmarks.tsp.Tsp: int NodesFromEnd>
$i14 = <benchmarks.tsp.TspSolver: int PrioQLast>
$r12 = $r11[i0]
$i10 = <benchmarks.tsp.TspSolver: int MinTourLen>
exitmonitor r1
if $z1 == 0 goto $r11 = <benchmarks.tsp.TspSolver: benchmarks.tsp.TourElement[] Tours>
if i7 < $i21 goto $i22 = <benchmarks.tsp.Tsp: int TspSize>
entermonitor $r0
$r14 := @caughtexception
$r13 = <benchmarks.tsp.TspSolver: int[] TourStack>
<benchmarks.tsp.TspSolver: int Done> = 1
r2.<benchmarks.tsp.PrioQElement: int priority> = $i18
$i16 = <benchmarks.tsp.TspSolver: int PrioQLast>
$i24 = $i22 - $i23
i4 = i2
<benchmarks.tsp.TspSolver: int TourStackTop> = $i28
staticinvoke <benchmarks.tsp.TspSolver: void split_tour(int)>(i0)
$z1 = staticinvoke <benchmarks.tsp.TspSolver: boolean less_than(benchmarks.tsp.PrioQElement,benchmarks.tsp.PrioQElement)>(r10, r2)
<benchmarks.tsp.TspSolver: int Done> = 1
r2.<benchmarks.tsp.PrioQElement: int index> = $i12
goto [?= $z1 = staticinvoke <benchmarks.tsp.TspSolver: boolean less_than(benchmarks.tsp.PrioQElement,benchmarks.tsp.PrioQElement)>(r10, r2)]
$i20 = $i19 >> 1
r2 = $r6[1]
if $i8 == 0 goto $i29 = <benchmarks.tsp.TspSolver: int PrioQLast>
i6 = r2.<benchmarks.tsp.PrioQElement: int priority>
if $i9 < $i10 goto $r7 = <benchmarks.tsp.TspSolver: benchmarks.tsp.PrioQElement[] PrioQ>
$r11 = <benchmarks.tsp.TspSolver: benchmarks.tsp.TourElement[] Tours>
i4 = i3
r10 = r4
$i29 = <benchmarks.tsp.TspSolver: int PrioQLast>
i0 = r2.<benchmarks.tsp.PrioQElement: int index>
$i21 = <benchmarks.tsp.Tsp: int TspSize>
$z0 = staticinvoke <benchmarks.tsp.TspSolver: boolean less_than(benchmarks.tsp.PrioQElement,benchmarks.tsp.PrioQElement)>(r4, r5)
exitmonitor r1
if i7 < $i25 goto staticinvoke <benchmarks.tsp.TspSolver: void split_tour(int)>(i0)
$i17 = r10.<benchmarks.tsp.PrioQElement: int index>
==============

==============
 tn units (no order)
i3 = staticinvoke <benchmarks.tsp.TspSolver: int find_solvable_tour()>()
exitmonitor r1
if i0 == -1 goto i3 = staticinvoke <benchmarks.tsp.TspSolver: int find_solvable_tour()>()
entermonitor $r0
$r2 = <benchmarks.tsp.TspSolver: int[] TourStack>
$r3 := @caughtexception
<benchmarks.tsp.TspSolver: int TourStackTop> = $i2
$i1 = <benchmarks.tsp.TspSolver: int TourStackTop>
$i2 = $i1 + 1
$r2[$i2] = i0
exitmonitor r1
==============

Transforming benchmarks.tsp.TourElement... 
Transforming benchmarks.stringbuffer.StringBufferTest... 
Transforming benchmarks.stringbuffer.StringBuffer... 
==============
 tn units (no order)
$i0 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
r0 := @this: benchmarks.stringbuffer.StringBuffer
return $i0
==============

==============
 tn units (no order)
$r1 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i0 = lengthof $r1
r0 := @this: benchmarks.stringbuffer.StringBuffer
return $i0
==============

==============
 tn units (no order)
return
if i0 <= $i1 goto return
r0 := @this: benchmarks.stringbuffer.StringBuffer
$r1 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i1 = lengthof $r1
i0 := @parameter0: int
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void expandCapacity(int)>(i0)
==============

==============
 tn units (no order)
$i5 = $i4 + 1
$r1 = new java.lang.StringIndexOutOfBoundsException
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void copy()>()
goto [?= return]
r0.<benchmarks.stringbuffer.StringBuffer: boolean shared> = 0
specialinvoke $r1.<java.lang.StringIndexOutOfBoundsException: void <init>(int)>(i0)
if $i6 < i0 goto $r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
throw $r1
$z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
goto [?= return]
if i0 >= 0 goto $r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
i0 := @parameter0: int
$i4 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i3 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r3[$i3] = 0
r0.<benchmarks.stringbuffer.StringBuffer: int count> = i0
if $z1 == 0 goto return
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void expandCapacity(int)>(i0)
if $i2 >= i0 goto r0.<benchmarks.stringbuffer.StringBuffer: int count> = i0
$i6 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
r0.<benchmarks.stringbuffer.StringBuffer: int count> = $i5
$z1 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
if i0 <= $i1 goto $i2 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i2 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
goto [?= $i6 = r0.<benchmarks.stringbuffer.StringBuffer: int count>]
if $z0 == 0 goto $i6 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i1 = lengthof $r2
if i0 <= 0 goto $r5 = newarray (char)[16]
$r5 = newarray (char)[16]
r0.<benchmarks.stringbuffer.StringBuffer: char[] value> = $r5
return
r0 := @this: benchmarks.stringbuffer.StringBuffer
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void copy()>()
==============

==============
 tn units (no order)
$c2 = $r2[i0]
if i0 < $i1 goto $r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i1 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
throw $r1
$r1 = new java.lang.StringIndexOutOfBoundsException
i0 := @parameter0: int
r0 := @this: benchmarks.stringbuffer.StringBuffer
specialinvoke $r1.<java.lang.StringIndexOutOfBoundsException: void <init>(int)>(i0)
$r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
if i0 < 0 goto $r1 = new java.lang.StringIndexOutOfBoundsException
return $c2
==============

==============
 tn units (no order)
r0 := @this: benchmarks.stringbuffer.StringBuffer
r1 := @parameter2: char[]
$r5 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r2 = new java.lang.StringIndexOutOfBoundsException
if i1 < 0 goto $r3 = new java.lang.StringIndexOutOfBoundsException
specialinvoke $r3.<java.lang.StringIndexOutOfBoundsException: void <init>(int)>(i1)
throw $r2
specialinvoke $r2.<java.lang.StringIndexOutOfBoundsException: void <init>(int)>(i0)
return
i1 := @parameter1: int
if i1 <= $i3 goto (branch)
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r5, i0, r1, i2, $i4)
if i0 <= i1 goto $r5 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r3 = new java.lang.StringIndexOutOfBoundsException
$r4 = new java.lang.StringIndexOutOfBoundsException
throw $r3
$i3 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
throw $r4
$i4 = i1 - i0
i0 := @parameter0: int
i2 := @parameter3: int
if i0 >= 0 goto (branch)
specialinvoke $r4.<java.lang.StringIndexOutOfBoundsException: void <init>(java.lang.String)>("srcBegin > srcEnd")
==============

==============
 tn units (no order)
$i2 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
r0 := @this: benchmarks.stringbuffer.StringBuffer
throw $r1
$r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
specialinvoke $r1.<java.lang.StringIndexOutOfBoundsException: void <init>(int)>(i0)
if $z0 == 0 goto $r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
if i0 < 0 goto $r1 = new java.lang.StringIndexOutOfBoundsException
i0 := @parameter0: int
$r2[i0] = c1
return
c1 := @parameter1: char
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void copy()>()
$r1 = new java.lang.StringIndexOutOfBoundsException
if i0 < $i2 goto $z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
$z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
==============

==============
 tn units (no order)
return $r3
$r2 = staticinvoke <java.lang.String: java.lang.String valueOf(java.lang.Object)>(r1)
r0 := @this: benchmarks.stringbuffer.StringBuffer
r1 := @parameter0: java.lang.Object
$r3 = virtualinvoke r0.<benchmarks.stringbuffer.StringBuffer: benchmarks.stringbuffer.StringBuffer append(java.lang.String)>($r2)
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
r0.<benchmarks.stringbuffer.StringBuffer: int count> = i1
$i4 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void expandCapacity(int)>(i1)
$i3 = lengthof $r2
i0 = virtualinvoke r1.<java.lang.String: int length()>()
virtualinvoke r1.<java.lang.String: void getChars(int,int,char[],int)>(0, i0, $r3, $i4)
r1 := @parameter0: java.lang.String
r1 = staticinvoke <java.lang.String: java.lang.String valueOf(java.lang.Object)>(r1)
$i2 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
i1 = $i2 + i0
return r0
if r1 != null goto i0 = virtualinvoke r1.<java.lang.String: int length()>()
r0 := @this: benchmarks.stringbuffer.StringBuffer
if i1 <= $i3 goto $r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
==============

==============
 tn units (no order)
r1 := @parameter0: benchmarks.stringbuffer.StringBuffer
$r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
return r0
if r1 != null goto i0 = virtualinvoke r1.<benchmarks.stringbuffer.StringBuffer: int length()>()
$r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
r0.<benchmarks.stringbuffer.StringBuffer: int count> = i1
$i3 = lengthof $r2
$i4 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
r1 = <benchmarks.stringbuffer.StringBuffer: benchmarks.stringbuffer.StringBuffer NULL>
i0 = virtualinvoke r1.<benchmarks.stringbuffer.StringBuffer: int length()>()
i1 = $i2 + i0
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void expandCapacity(int)>(i1)
virtualinvoke r1.<benchmarks.stringbuffer.StringBuffer: void getChars(int,int,char[],int)>(0, i0, $r3, $i4)
if i1 <= $i3 goto $r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
r0 := @this: benchmarks.stringbuffer.StringBuffer
$i2 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
==============

==============
 tn units (no order)
$r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i4 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
r1 := @parameter0: char[]
return r0
if i1 <= $i3 goto $r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void expandCapacity(int)>(i1)
$i3 = lengthof $r2
$r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
i1 = $i2 + i0
i0 = lengthof r1
r0 := @this: benchmarks.stringbuffer.StringBuffer
r0.<benchmarks.stringbuffer.StringBuffer: int count> = i1
$i2 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r1, 0, $r3, $i4, i0)
==============

==============
 tn units (no order)
i1 := @parameter2: int
$i3 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
i2 = $i3 + i1
$i5 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
r0 := @this: benchmarks.stringbuffer.StringBuffer
r1 := @parameter0: char[]
$r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
if i2 <= $i4 goto $r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
return r0
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r1, i0, $r3, $i5, i1)
$i4 = lengthof $r2
i0 := @parameter1: int
r0.<benchmarks.stringbuffer.StringBuffer: int count> = i2
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void expandCapacity(int)>(i2)
==============

==============
 tn units (no order)
$r10 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i22 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void expandCapacity(int)>(i0)
$r4 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r6[$i7] = 117
$r13 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r4[$i5] = 114
$i5 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$r13[$i16] = 97
r0.<benchmarks.stringbuffer.StringBuffer: int count> = $i23
$i7 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i1 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
r0.<benchmarks.stringbuffer.StringBuffer: int count> = $i19
$i2 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
return r0
$r17 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r15[$i18] = 108
r0.<benchmarks.stringbuffer.StringBuffer: int count> = $i6
$r8 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
r0.<benchmarks.stringbuffer.StringBuffer: int count> = $i17
$r1 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
r0.<benchmarks.stringbuffer.StringBuffer: int count> = $i15
r0.<benchmarks.stringbuffer.StringBuffer: int count> = $i21
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void expandCapacity(int)>(i12)
$i13 = lengthof $r10
$i10 = $i9 + 1
$i17 = $i16 + 1
r0 := @this: benchmarks.stringbuffer.StringBuffer
r0.<benchmarks.stringbuffer.StringBuffer: int count> = $i8
$i20 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i16 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i14 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i8 = $i7 + 1
z0 := @parameter0: boolean
$r6 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i9 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i3 = lengthof $r1
$r2[$i1] = 116
$i15 = $i14 + 1
$r11[$i14] = 102
$r17[$i20] = 115
r0.<benchmarks.stringbuffer.StringBuffer: int count> = $i4
$r8[$i9] = 101
$r19[$i22] = 101
i12 = $i11 + 5
$i4 = $i1 + 1
$r11 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
if z0 == 0 goto $i11 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i21 = $i20 + 1
r0.<benchmarks.stringbuffer.StringBuffer: int count> = $i10
$i23 = $i22 + 1
$i19 = $i18 + 1
$r19 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
if i0 <= $i3 goto $r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i11 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i6 = $i5 + 1
if i12 <= $i13 goto $r11 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r15 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
goto [?= return r0]
$i18 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
i0 = $i2 + 4
==============

==============
 tn units (no order)
$r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i2 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i4 = lengthof $r1
$i3 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
c0 := @parameter0: char
if i1 <= $i4 goto $r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r2[$i2] = c0
$i5 = $i2 + 1
$r1 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void expandCapacity(int)>(i1)
r0 := @this: benchmarks.stringbuffer.StringBuffer
i1 = $i3 + 1
r0.<benchmarks.stringbuffer.StringBuffer: int count> = $i5
return r0
==============

==============
 tn units (no order)
if i0 <= i1 goto i2 = i1 - i0
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r3, $i4, $r4, i0, $i6)
$z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
r0.<benchmarks.stringbuffer.StringBuffer: int count> = $i8
specialinvoke $r1.<java.lang.StringIndexOutOfBoundsException: void <init>(int)>(i0)
$i8 = $i7 - i2
i2 = i1 - i0
if i1 <= $i3 goto (branch)
throw $r2
$i6 = $i5 - i1
throw $r1
if $z0 == 0 goto $r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i5 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
i1 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$r4 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r2 = new java.lang.StringIndexOutOfBoundsException
$i7 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
i1 := @parameter1: int
specialinvoke $r2.<java.lang.StringIndexOutOfBoundsException: void <init>()>()
$i4 = i0 + i2
$r1 = new java.lang.StringIndexOutOfBoundsException
return r0
if i0 >= 0 goto $i3 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i3 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
if i2 <= 0 goto return r0
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void copy()>()
i0 := @parameter0: int
r0 := @this: benchmarks.stringbuffer.StringBuffer
==============

==============
 tn units (no order)
$i7 = $i6 - 1
if i0 < 0 goto $r1 = new java.lang.StringIndexOutOfBoundsException
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void copy()>()
if $z0 == 0 goto $r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
return r0
if i0 < $i1 goto $z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
$r1 = new java.lang.StringIndexOutOfBoundsException
$z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
$r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
specialinvoke $r1.<java.lang.StringIndexOutOfBoundsException: void <init>()>()
$i1 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
i0 := @parameter0: int
$i6 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i4 = $i3 - i0
$r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r2, $i2, $r3, i0, $i5)
r0.<benchmarks.stringbuffer.StringBuffer: int count> = $i7
$i2 = i0 + 1
$i3 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i5 = $i4 - 1
throw $r1
r0 := @this: benchmarks.stringbuffer.StringBuffer
==============

==============
 tn units (no order)
$i7 = i1 - i0
$i6 = $i5 + i2
throw $r3
$i4 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
r1 := @parameter2: java.lang.String
if i3 <= $i8 goto $z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
return r0
$i11 = $i10 - i1
$i5 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i9 = i0 + i2
r0 := @this: benchmarks.stringbuffer.StringBuffer
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r5, i1, $r6, $i9, $i11)
if $z0 == 0 goto $r5 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
i2 = virtualinvoke r1.<java.lang.String: int length()>()
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void copy()>()
if i0 >= 0 goto $i4 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void expandCapacity(int)>(i3)
virtualinvoke r1.<java.lang.String: void getChars(int,int,char[],int)>(0, i2, $r7, i0)
goto [?= $r5 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>]
$i8 = lengthof $r4
$i10 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$r3 = new java.lang.StringIndexOutOfBoundsException
i1 := @parameter1: int
$r4 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r7 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
if i1 <= $i4 goto (branch)
if i0 <= i1 goto i2 = virtualinvoke r1.<java.lang.String: int length()>()
r0.<benchmarks.stringbuffer.StringBuffer: int count> = i3
$r5 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
specialinvoke $r2.<java.lang.StringIndexOutOfBoundsException: void <init>(int)>(i0)
specialinvoke $r3.<java.lang.StringIndexOutOfBoundsException: void <init>()>()
i0 := @parameter0: int
i1 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
$r2 = new java.lang.StringIndexOutOfBoundsException
$r6 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
throw $r2
i3 = $i6 - $i7
==============

==============
 tn units (no order)
i0 := @parameter0: int
r0 := @this: benchmarks.stringbuffer.StringBuffer
$r1 = virtualinvoke r0.<benchmarks.stringbuffer.StringBuffer: java.lang.String substring(int,int)>(i0, $i1)
return $r1
$i1 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
==============

==============
 tn units (no order)
if i1 <= $i2 goto (branch)
throw $r2
$r2 = new java.lang.StringIndexOutOfBoundsException
if i0 >= 0 goto $i2 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
specialinvoke $r3.<java.lang.StringIndexOutOfBoundsException: void <init>(int)>($i3)
$i3 = i1 - i0
$r4 = new java.lang.String
throw $r3
i0 := @parameter0: int
$r5 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
r0 := @this: benchmarks.stringbuffer.StringBuffer
i1 := @parameter1: int
$i4 = i1 - i0
$i2 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$r3 = new java.lang.StringIndexOutOfBoundsException
$r1 = new java.lang.StringIndexOutOfBoundsException
specialinvoke $r2.<java.lang.StringIndexOutOfBoundsException: void <init>(int)>(i1)
if i0 <= i1 goto $r4 = new java.lang.String
specialinvoke $r1.<java.lang.StringIndexOutOfBoundsException: void <init>(int)>(i0)
specialinvoke $r4.<java.lang.String: void <init>(char[],int,int)>($r5, i0, $i4)
return $r4
throw $r1
==============

==============
 tn units (no order)
specialinvoke $r4.<java.lang.StringIndexOutOfBoundsException: void <init>(int)>(i2)
specialinvoke $r3.<java.lang.StringIndexOutOfBoundsException: void <init>(int)>(i1)
$i8 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void expandCapacity(int)>(i3)
$r8 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
throw $r3
$r6 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i11 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
specialinvoke $r2.<java.lang.StringIndexOutOfBoundsException: void <init>()>()
if i2 >= 0 goto $i8 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
$r2 = new java.lang.StringIndexOutOfBoundsException
$i10 = i0 + i2
goto [?= $r6 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>]
i1 := @parameter2: int
if i1 < 0 goto $r3 = new java.lang.StringIndexOutOfBoundsException
throw $r2
throw $r4
if i3 <= $i9 goto $z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
return r0
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void copy()>()
$r5 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i5 = i1 + i2
if i0 <= $i4 goto (branch)
$i7 = lengthof r1
$i12 = $i11 - i0
$i6 = i1 + i2
if $z0 == 0 goto $r6 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r1, i1, $r8, i0, i2)
i2 := @parameter3: int
$i4 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
i0 := @parameter0: int
$r3 = new java.lang.StringIndexOutOfBoundsException
r0.<benchmarks.stringbuffer.StringBuffer: int count> = i3
i3 = $i8 + i2
$i9 = lengthof $r5
$r4 = new java.lang.StringIndexOutOfBoundsException
$r7 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
if $i5 < 0 goto $r3 = new java.lang.StringIndexOutOfBoundsException
if $i6 <= $i7 goto (branch)
if i0 < 0 goto $r2 = new java.lang.StringIndexOutOfBoundsException
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r6, i0, $r7, $i10, $i12)
r0 := @this: benchmarks.stringbuffer.StringBuffer
r1 := @parameter1: char[]
==============

==============
 tn units (no order)
$r2 = staticinvoke <java.lang.String: java.lang.String valueOf(java.lang.Object)>(r1)
$r3 = virtualinvoke r0.<benchmarks.stringbuffer.StringBuffer: benchmarks.stringbuffer.StringBuffer insert(int,java.lang.String)>(i0, $r2)
i0 := @parameter0: int
r0 := @this: benchmarks.stringbuffer.StringBuffer
return $r3
r1 := @parameter1: java.lang.Object
==============

==============
 tn units (no order)
$i4 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
i1 = virtualinvoke r1.<java.lang.String: int length()>()
throw $r2
if i0 < 0 goto $r2 = new java.lang.StringIndexOutOfBoundsException
$i3 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void copy()>()
$r6 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
if r1 != null goto i1 = virtualinvoke r1.<java.lang.String: int length()>()
$r4 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
r1 := @parameter1: java.lang.String
$i8 = $i7 - i0
virtualinvoke r1.<java.lang.String: void getChars(int,int,char[],int)>(0, i1, $r6, i0)
$r5 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r4, i0, $r5, $i6, $i8)
i2 = $i4 + i1
if $z0 == 0 goto $r4 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
specialinvoke $r2.<java.lang.StringIndexOutOfBoundsException: void <init>()>()
$i5 = lengthof $r3
if i2 <= $i5 goto $z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
r1 = staticinvoke <java.lang.String: java.lang.String valueOf(java.lang.Object)>(r1)
goto [?= $r4 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>]
$i6 = i0 + i1
r0 := @this: benchmarks.stringbuffer.StringBuffer
if i0 <= $i3 goto (branch)
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void expandCapacity(int)>(i2)
$i7 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
r0.<benchmarks.stringbuffer.StringBuffer: int count> = i2
return r0
$r2 = new java.lang.StringIndexOutOfBoundsException
i0 := @parameter0: int
==============

==============
 tn units (no order)
i2 = $i4 + i1
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r1, 0, $r6, i0, i1)
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r4, i0, $r5, $i6, $i8)
r0.<benchmarks.stringbuffer.StringBuffer: int count> = i2
if i0 <= $i3 goto i1 = lengthof r1
$i5 = lengthof $r3
$r2 = new java.lang.StringIndexOutOfBoundsException
$r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i6 = i0 + i1
r0 := @this: benchmarks.stringbuffer.StringBuffer
return r0
$r4 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
i1 = lengthof r1
goto [?= $r4 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>]
$i4 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
if $z0 == 0 goto $r4 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
specialinvoke $r2.<java.lang.StringIndexOutOfBoundsException: void <init>()>()
$i8 = $i7 - i0
if i0 < 0 goto $r2 = new java.lang.StringIndexOutOfBoundsException
r1 := @parameter1: char[]
$i3 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
i0 := @parameter0: int
$r5 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i7 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void expandCapacity(int)>(i2)
if i2 <= $i5 goto $z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void copy()>()
throw $r2
$r6 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
==============

==============
 tn units (no order)
$z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
if $z0 == 0 goto $r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i5 = i0 + 1
$r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r1 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$i3 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i7 = $i6 - i0
r0 := @this: benchmarks.stringbuffer.StringBuffer
r0.<benchmarks.stringbuffer.StringBuffer: int count> = i2
$r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
c1 := @parameter1: char
i0 := @parameter0: int
i2 = $i3 + 1
$r4 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r2, i0, $r3, $i5, $i7)
if i2 <= $i4 goto $z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void copy()>()
$r4[i0] = c1
return r0
$i4 = lengthof $r1
goto [?= $r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>]
$i6 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void expandCapacity(int)>(i2)
==============

==============
 tn units (no order)
i1 = i1 + -1
$i4 = i0 - 1
$z0 = r0.<benchmarks.stringbuffer.StringBuffer: boolean shared>
if $z0 == 0 goto $i3 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
$i7 = i0 - i1
$r3 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$r1 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
$c6 = $r3[$i5]
i1 = $i4 >> 1
$i3 = r0.<benchmarks.stringbuffer.StringBuffer: int count>
i0 = $i3 - 1
$r2[i1] = $c6
$i5 = i0 - i1
goto [?= (branch)]
$r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
c2 = $r1[i1]
specialinvoke r0.<benchmarks.stringbuffer.StringBuffer: void copy()>()
$r4[$i7] = c2
if i1 >= 0 goto $r1 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
return r0
$r4 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
r0 := @this: benchmarks.stringbuffer.StringBuffer
==============

==============
 tn units (no order)
r0.<benchmarks.stringbuffer.StringBuffer: boolean shared> = 0
return
$r4 = (char[]) $r3
$r2 = r0.<benchmarks.stringbuffer.StringBuffer: char[] value>
r1 := @parameter0: java.io.ObjectInputStream
r0.<benchmarks.stringbuffer.StringBuffer: char[] value> = $r4
$r3 = virtualinvoke $r2.<java.lang.Object: java.lang.Object clone()>()
virtualinvoke r1.<java.io.ObjectInputStream: void defaultReadObject()>()
r0 := @this: benchmarks.stringbuffer.StringBuffer
==============

Transforming benchmarks.elevator.Lift... 
Transforming benchmarks.elevator.Elevator... 
Transforming benchmarks.elevator.ButtonPress... 
Transforming benchmarks.elevator.Floor... 
Transforming benchmarks.elevator.Controls... 
==============
 tn units (no order)
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" wants to go to ")
specialinvoke $r5.<java.lang.StringBuilder: void <init>(java.lang.String)>("*** Someone on floor ")
$r14 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
$r10 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
exitmonitor r1
entermonitor $r3
$r16 = $r15.<benchmarks.elevator.Floor: java.util.Vector downPeople>
specialinvoke $r13.<java.lang.Integer: void <init>(int)>(i1)
exitmonitor r1
$r12 = $r11.<benchmarks.elevator.Floor: java.util.Vector downPeople>
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.String toString()>()
$r17 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i1)
$r18 = $r17[i0]
$r5 = new java.lang.StringBuilder
$i2 = virtualinvoke $r16.<java.util.Vector: int size()>()
$r19 := @caughtexception
virtualinvoke $r12.<java.util.Vector: void addElement(java.lang.Object)>($r13)
$r15 = $r14[i0]
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i0)
if $i2 != 1 goto exitmonitor r1
$r13 = new java.lang.Integer
virtualinvoke $r4.<java.io.PrintStream: void println(java.lang.String)>($r9)
$r18.<benchmarks.elevator.Floor: boolean downFlag> = 0
$r11 = $r10[i0]
$r4 = <java.lang.System: java.io.PrintStream out>
==============

==============
 tn units (no order)
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i0)
$r13 = new java.lang.Integer
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i1)
$r12 = $r11.<benchmarks.elevator.Floor: java.util.Vector upPeople>
if $i2 != 1 goto exitmonitor r1
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" wants to go to ")
$r4 = <java.lang.System: java.io.PrintStream out>
virtualinvoke $r12.<java.util.Vector: void addElement(java.lang.Object)>($r13)
$r15 = $r14[i0]
$r14 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
$r18.<benchmarks.elevator.Floor: boolean upFlag> = 0
virtualinvoke $r4.<java.io.PrintStream: void println(java.lang.String)>($r9)
$r19 := @caughtexception
specialinvoke $r5.<java.lang.StringBuilder: void <init>(java.lang.String)>("*** Someone on floor ")
entermonitor $r3
$i2 = virtualinvoke $r16.<java.util.Vector: int size()>()
exitmonitor r1
$r17 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
$r18 = $r17[i0]
exitmonitor r1
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.String toString()>()
$r10 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
$r16 = $r15.<benchmarks.elevator.Floor: java.util.Vector upPeople>
$r11 = $r10[i0]
$r5 = new java.lang.StringBuilder
specialinvoke $r13.<java.lang.Integer: void <init>(int)>(i1)
==============

==============
 tn units (no order)
if $z1 != 0 goto exitmonitor r2
$r8.<benchmarks.elevator.Floor: boolean upFlag> = 1
exitmonitor r2
$r9 := @caughtexception
$r5 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
exitmonitor r2
$r8 = $r7[i0]
$r7 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
$z1 = $r6.<benchmarks.elevator.Floor: boolean upFlag>
exitmonitor r2
entermonitor $r4
$r6 = $r5[i0]
==============

==============
 tn units (no order)
$r8 = $r7[i0]
$r8.<benchmarks.elevator.Floor: boolean downFlag> = 1
$z1 = $r6.<benchmarks.elevator.Floor: boolean downFlag>
$r5 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
$r6 = $r5[i0]
entermonitor $r4
$r7 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
exitmonitor r2
exitmonitor r2
exitmonitor r2
$r9 := @caughtexception
if $z1 != 0 goto exitmonitor r2
==============

==============
 tn units (no order)
exitmonitor r1
$r9 := @caughtexception
$r7 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
if $z2 != 0 goto $z3 = 0
entermonitor $r3
exitmonitor r1
$r4 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
$z1 = 0
$r6 = $r5.<benchmarks.elevator.Floor: java.util.Vector upPeople>
z4 = $z3
$r5 = $r4[i0]
z0 = $z1
if $i1 == 0 goto $z1 = 0
$z3 = 1
$i1 = virtualinvoke $r6.<java.util.Vector: int size()>()
$z1 = 1
$z2 = $r8.<benchmarks.elevator.Floor: boolean upFlag>
goto [?= z0 = $z1]
if z0 == 0 goto $z3 = 0
$r8 = $r7[i0]
goto [?= z4 = $z3]
$z3 = 0
==============

==============
 tn units (no order)
$z1 = 0
$i1 = virtualinvoke $r6.<java.util.Vector: int size()>()
exitmonitor r1
entermonitor $r3
if $i1 == 0 goto $z1 = 0
$z3 = 1
$r6 = $r5.<benchmarks.elevator.Floor: java.util.Vector downPeople>
$r9 := @caughtexception
$z1 = 1
if z0 == 0 goto $z3 = 0
z0 = $z1
$r8 = $r7[i0]
$z3 = 0
$r5 = $r4[i0]
$r4 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
goto [?= z0 = $z1]
exitmonitor r1
$z2 = $r8.<benchmarks.elevator.Floor: boolean downFlag>
$r7 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
if $z2 != 0 goto $z3 = 0
goto [?= z4 = $z3]
z4 = $z3
==============

==============
 tn units (no order)
entermonitor $r4
$r5 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
$r11.<benchmarks.elevator.Floor: boolean upFlag> = 0
$r8 = $r7[i0]
$r6 = $r5[i0]
$r11 = $r10[i0]
$r13 := @caughtexception
$r10 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
exitmonitor r1
exitmonitor r1
$r9 = new java.util.Vector
specialinvoke $r9.<java.util.Vector: void <init>()>()
$r7 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
r2 = $r6.<benchmarks.elevator.Floor: java.util.Vector upPeople>
$r8.<benchmarks.elevator.Floor: java.util.Vector upPeople> = $r9
==============

==============
 tn units (no order)
$r7 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
specialinvoke $r9.<java.util.Vector: void <init>()>()
$r10 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
$r8 = $r7[i0]
$r11 = $r10[i0]
$r5 = r0.<benchmarks.elevator.Controls: benchmarks.elevator.Floor[] floors>
$r9 = new java.util.Vector
entermonitor $r4
$r13 := @caughtexception
$r8.<benchmarks.elevator.Floor: java.util.Vector downPeople> = $r9
exitmonitor r1
exitmonitor r1
r2 = $r6.<benchmarks.elevator.Floor: java.util.Vector downPeople>
$r11.<benchmarks.elevator.Floor: boolean downFlag> = 0
$r6 = $r5[i0]
==============

Transforming benchmarks.JGFAllSizeB... 
Transforming benchmarks.JGFMonteCarloBenchSizeB... 
Transforming benchmarks.jgfutil.JGFTimer... 
Transforming benchmarks.jgfutil.JGFInstrumentor... 
==============
 tn units (no order)
$r7 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
if $z0 == 0 goto $r7 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
virtualinvoke $r2.<java.io.PrintStream: void println(java.lang.String)>($r6)
$r4 = virtualinvoke $r3.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r0)
goto [?= return]
$r3 = new java.lang.StringBuilder
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.String toString()>()
$r8 = new benchmarks.jgfutil.JGFTimer
r0 := @parameter0: java.lang.String
virtualinvoke $r7.<java.util.Hashtable: java.lang.Object put(java.lang.Object,java.lang.Object)>(r0, $r8)
return
specialinvoke $r8.<benchmarks.jgfutil.JGFTimer: void <init>(java.lang.String)>(r0)
$r1 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$r2 = <java.lang.System: java.io.PrintStream out>
$r5 = virtualinvoke $r4.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" already exists")
$z0 = virtualinvoke $r1.<java.util.Hashtable: boolean containsKey(java.lang.Object)>(r0)
specialinvoke $r3.<java.lang.StringBuilder: void <init>(java.lang.String)>("JGFInstrumentor.addTimer: warning -  timer ")
==============

==============
 tn units (no order)
$r9 = new benchmarks.jgfutil.JGFTimer
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
virtualinvoke $r3.<java.io.PrintStream: void println(java.lang.String)>($r7)
if $z0 == 0 goto $r8 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$r8 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
specialinvoke $r4.<java.lang.StringBuilder: void <init>(java.lang.String)>("JGFInstrumentor.addTimer: warning -  timer ")
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" already exists")
goto [?= return]
$r3 = <java.lang.System: java.io.PrintStream out>
r1 := @parameter1: java.lang.String
virtualinvoke $r8.<java.util.Hashtable: java.lang.Object put(java.lang.Object,java.lang.Object)>(r0, $r9)
specialinvoke $r9.<benchmarks.jgfutil.JGFTimer: void <init>(java.lang.String,java.lang.String)>(r0, r1)
$r4 = new java.lang.StringBuilder
return
$r2 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
r0 := @parameter0: java.lang.String
$z0 = virtualinvoke $r2.<java.util.Hashtable: boolean containsKey(java.lang.Object)>(r0)
$r5 = virtualinvoke $r4.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r0)
==============

==============
 tn units (no order)
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" already exists")
virtualinvoke $r3.<java.io.PrintStream: void println(java.lang.String)>($r7)
$z0 = virtualinvoke $r2.<java.util.Hashtable: boolean containsKey(java.lang.Object)>(r0)
virtualinvoke $r8.<java.util.Hashtable: java.lang.Object put(java.lang.Object,java.lang.Object)>(r0, $r9)
specialinvoke $r4.<java.lang.StringBuilder: void <init>(java.lang.String)>("JGFInstrumentor.addTimer: warning -  timer ")
return
r1 := @parameter1: java.lang.String
$r8 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$r2 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$r9 = new benchmarks.jgfutil.JGFTimer
goto [?= return]
if $z0 == 0 goto $r8 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$r3 = <java.lang.System: java.io.PrintStream out>
r0 := @parameter0: java.lang.String
i0 := @parameter2: int
specialinvoke $r9.<benchmarks.jgfutil.JGFTimer: void <init>(java.lang.String,java.lang.String,int)>(r0, r1, i0)
$r4 = new java.lang.StringBuilder
$r5 = virtualinvoke $r4.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r0)
==============

==============
 tn units (no order)
return
$r5 = <java.lang.System: java.io.PrintStream out>
$r4 = (benchmarks.jgfutil.JGFTimer) $r3
$r6 = new java.lang.StringBuilder
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" does not exist")
virtualinvoke $r4.<benchmarks.jgfutil.JGFTimer: void start()>()
$r1 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r0)
$z0 = virtualinvoke $r1.<java.util.Hashtable: boolean containsKey(java.lang.Object)>(r0)
r0 := @parameter0: java.lang.String
virtualinvoke $r5.<java.io.PrintStream: void println(java.lang.String)>($r9)
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.String toString()>()
$r2 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
goto [?= return]
specialinvoke $r6.<java.lang.StringBuilder: void <init>(java.lang.String)>("JGFInstrumentor.startTimer: failed -  timer ")
if $z0 == 0 goto $r5 = <java.lang.System: java.io.PrintStream out>
$r3 = virtualinvoke $r2.<java.util.Hashtable: java.lang.Object get(java.lang.Object)>(r0)
==============

==============
 tn units (no order)
$r1 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
if $z0 == 0 goto $r5 = <java.lang.System: java.io.PrintStream out>
goto [?= return]
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.String toString()>()
virtualinvoke $r5.<java.io.PrintStream: void println(java.lang.String)>($r9)
$r6 = new java.lang.StringBuilder
specialinvoke $r6.<java.lang.StringBuilder: void <init>(java.lang.String)>("JGFInstrumentor.stopTimer: failed -  timer ")
$r5 = <java.lang.System: java.io.PrintStream out>
$r2 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$r4 = (benchmarks.jgfutil.JGFTimer) $r3
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" does not exist")
virtualinvoke $r4.<benchmarks.jgfutil.JGFTimer: void stop()>()
return
$r3 = virtualinvoke $r2.<java.util.Hashtable: java.lang.Object get(java.lang.Object)>(r0)
r0 := @parameter0: java.lang.String
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r0)
$z0 = virtualinvoke $r1.<java.util.Hashtable: boolean containsKey(java.lang.Object)>(r0)
==============

==============
 tn units (no order)
$r6 = new java.lang.StringBuilder
$r4 = (benchmarks.jgfutil.JGFTimer) $r3
specialinvoke $r6.<java.lang.StringBuilder: void <init>(java.lang.String)>("JGFInstrumentor.addOpsToTimer: failed -  timer ")
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.String toString()>()
if $z0 == 0 goto $r5 = <java.lang.System: java.io.PrintStream out>
return
virtualinvoke $r4.<benchmarks.jgfutil.JGFTimer: void addops(double)>(d0)
$r5 = <java.lang.System: java.io.PrintStream out>
$z0 = virtualinvoke $r1.<java.util.Hashtable: boolean containsKey(java.lang.Object)>(r0)
$r3 = virtualinvoke $r2.<java.util.Hashtable: java.lang.Object get(java.lang.Object)>(r0)
r0 := @parameter0: java.lang.String
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r0)
virtualinvoke $r5.<java.io.PrintStream: void println(java.lang.String)>($r9)
goto [?= return]
$r2 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$r1 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" does not exist")
d0 := @parameter1: double
==============

==============
 tn units (no order)
goto [?= return]
specialinvoke $r6.<java.lang.StringBuilder: void <init>(java.lang.String)>("JGFInstrumentor.addTimeToTimer: failed -  timer ")
$r1 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$r5 = <java.lang.System: java.io.PrintStream out>
$r6 = new java.lang.StringBuilder
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r0)
$r4 = (benchmarks.jgfutil.JGFTimer) $r3
virtualinvoke $r4.<benchmarks.jgfutil.JGFTimer: void addtime(double)>(d0)
d0 := @parameter1: double
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" does not exist")
if $z0 == 0 goto $r5 = <java.lang.System: java.io.PrintStream out>
virtualinvoke $r5.<java.io.PrintStream: void println(java.lang.String)>($r9)
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.String toString()>()
$r2 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$z0 = virtualinvoke $r1.<java.util.Hashtable: boolean containsKey(java.lang.Object)>(r0)
r0 := @parameter0: java.lang.String
return
$r3 = virtualinvoke $r2.<java.util.Hashtable: java.lang.Object get(java.lang.Object)>(r0)
==============

==============
 tn units (no order)
$r5 = <java.lang.System: java.io.PrintStream out>
specialinvoke $r6.<java.lang.StringBuilder: void <init>(java.lang.String)>("JGFInstrumentor.readTimer: failed -  timer ")
d0 = 0.0
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.String toString()>()
r0 := @parameter0: java.lang.String
$r1 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" does not exist")
$r3 = virtualinvoke $r2.<java.util.Hashtable: java.lang.Object get(java.lang.Object)>(r0)
$r4 = (benchmarks.jgfutil.JGFTimer) $r3
$r6 = new java.lang.StringBuilder
return d0
$r2 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$z0 = virtualinvoke $r1.<java.util.Hashtable: boolean containsKey(java.lang.Object)>(r0)
goto [?= return d0]
virtualinvoke $r5.<java.io.PrintStream: void println(java.lang.String)>($r9)
if $z0 == 0 goto $r5 = <java.lang.System: java.io.PrintStream out>
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r0)
d0 = $r4.<benchmarks.jgfutil.JGFTimer: double time>
==============

==============
 tn units (no order)
goto [?= return]
$r4 = (benchmarks.jgfutil.JGFTimer) $r3
specialinvoke $r6.<java.lang.StringBuilder: void <init>(java.lang.String)>("JGFInstrumentor.resetTimer: failed -  timer ")
$r6 = new java.lang.StringBuilder
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r0)
r0 := @parameter0: java.lang.String
$r5 = <java.lang.System: java.io.PrintStream out>
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.String toString()>()
virtualinvoke $r4.<benchmarks.jgfutil.JGFTimer: void reset()>()
virtualinvoke $r5.<java.io.PrintStream: void println(java.lang.String)>($r9)
return
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" does not exist")
$r3 = virtualinvoke $r2.<java.util.Hashtable: java.lang.Object get(java.lang.Object)>(r0)
$r1 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$r2 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
if $z0 == 0 goto $r5 = <java.lang.System: java.io.PrintStream out>
$z0 = virtualinvoke $r1.<java.util.Hashtable: boolean containsKey(java.lang.Object)>(r0)
==============

==============
 tn units (no order)
$r6 = new java.lang.StringBuilder
specialinvoke $r6.<java.lang.StringBuilder: void <init>(java.lang.String)>("JGFInstrumentor.printTimer: failed -  timer ")
if $z0 == 0 goto $r5 = <java.lang.System: java.io.PrintStream out>
r0 := @parameter0: java.lang.String
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.String toString()>()
virtualinvoke $r5.<java.io.PrintStream: void println(java.lang.String)>($r9)
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" does not exist")
$r4 = (benchmarks.jgfutil.JGFTimer) $r3
$r5 = <java.lang.System: java.io.PrintStream out>
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r0)
$r2 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$r1 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
virtualinvoke $r4.<benchmarks.jgfutil.JGFTimer: void print()>()
$z0 = virtualinvoke $r1.<java.util.Hashtable: boolean containsKey(java.lang.Object)>(r0)
$r3 = virtualinvoke $r2.<java.util.Hashtable: java.lang.Object get(java.lang.Object)>(r0)
goto [?= return]
return
==============

==============
 tn units (no order)
if $z0 == 0 goto $r5 = <java.lang.System: java.io.PrintStream out>
$z0 = virtualinvoke $r1.<java.util.Hashtable: boolean containsKey(java.lang.Object)>(r0)
virtualinvoke $r5.<java.io.PrintStream: void println(java.lang.String)>($r9)
r0 := @parameter0: java.lang.String
$r6 = new java.lang.StringBuilder
$r3 = virtualinvoke $r2.<java.util.Hashtable: java.lang.Object get(java.lang.Object)>(r0)
$r5 = <java.lang.System: java.io.PrintStream out>
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.String toString()>()
specialinvoke $r6.<java.lang.StringBuilder: void <init>(java.lang.String)>("JGFInstrumentor.printTimer: failed -  timer ")
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r0)
$r1 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
$r4 = (benchmarks.jgfutil.JGFTimer) $r3
goto [?= return]
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" does not exist")
$r2 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable timers>
return
virtualinvoke $r4.<benchmarks.jgfutil.JGFTimer: void printperf()>()
==============

==============
 tn units (no order)
r1 := @parameter1: java.lang.Object
return
virtualinvoke $r2.<java.util.Hashtable: java.lang.Object put(java.lang.Object,java.lang.Object)>(r0, r1)
r0 := @parameter0: java.lang.String
$r2 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable data>
==============

==============
 tn units (no order)
virtualinvoke $r2.<java.util.Hashtable: java.lang.Object get(java.lang.Object)>(r0)
return
$r2 = <benchmarks.jgfutil.JGFInstrumentor: java.util.Hashtable data>
r1 := @parameter1: java.lang.Object
r0 := @parameter0: java.lang.String
==============

==============
 tn units (no order)
virtualinvoke $r26.<java.io.PrintStream: void println(java.lang.String)>($r30)
$r14 = new java.lang.StringBuilder
tableswitch(i1) {     case 0: goto $r14 = new java.lang.StringBuilder;     case 1: goto $r17 = new java.lang.StringBuilder;     default: goto $r20 = <java.lang.System: java.io.PrintStream out>; }
tableswitch(i0) {     case 1: goto $r2 = new java.lang.StringBuilder;     case 2: goto tableswitch(i1) {     case 0: goto $r5 = new java.lang.StringBuilder;     case 1: goto $r8 = new java.lang.StringBuilder;     case 2: goto $r11 = new java.lang.StringBuilder;     default: goto goto [?= $r20 = <java.lang.System: java.io.PrintStream out>]; };     case 3: goto tableswitch(i1) {     case 0: goto $r14 = new java.lang.StringBuilder;     case 1: goto $r17 = new java.lang.StringBuilder;     default: goto $r20 = <java.lang.System: java.io.PrintStream out>; };     default: goto $r20 = <java.lang.System: java.io.PrintStream out>; }
r1 = "Java Grande Forum Thread Benchmark Suite - Version 1.0 - Section "
specialinvoke $r5.<java.lang.StringBuilder: void <init>(java.lang.String)>($r6)
i2 := @parameter2: int
$r29 = virtualinvoke $r28.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" threads")
$r26 = <java.lang.System: java.io.PrintStream out>
$r7 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>("2 - Size A")
virtualinvoke $r20.<java.io.PrintStream: void println(java.lang.String)>(r0)
$r13 = virtualinvoke $r11.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>("2 - Size C")
$r24 = virtualinvoke $r23.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" thread")
$r20 = <java.lang.System: java.io.PrintStream out>
$r12 = staticinvoke <java.lang.String: java.lang.String valueOf(java.lang.Object)>(r1)
specialinvoke $r17.<java.lang.StringBuilder: void <init>(java.lang.String)>($r18)
goto [?= $r20 = <java.lang.System: java.io.PrintStream out>]
specialinvoke $r2.<java.lang.StringBuilder: void <init>(java.lang.String)>($r3)
$r16 = virtualinvoke $r14.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>("3 - Size A")
goto [?= $r20 = <java.lang.System: java.io.PrintStream out>]
r0 = virtualinvoke $r16.<java.lang.StringBuilder: java.lang.String toString()>()
specialinvoke $r11.<java.lang.StringBuilder: void <init>(java.lang.String)>($r12)
specialinvoke $r8.<java.lang.StringBuilder: void <init>(java.lang.String)>($r9)
specialinvoke $r27.<java.lang.StringBuilder: void <init>(java.lang.String)>("Executing on ")
$r10 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>("2 - Size B")
$r4 = virtualinvoke $r2.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>("1")
goto [?= $r20 = <java.lang.System: java.io.PrintStream out>]
$r5 = new java.lang.StringBuilder
r0 = virtualinvoke $r4.<java.lang.StringBuilder: java.lang.String toString()>()
$r9 = staticinvoke <java.lang.String: java.lang.String valueOf(java.lang.Object)>(r1)
specialinvoke $r14.<java.lang.StringBuilder: void <init>(java.lang.String)>($r15)
r0 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.String toString()>()
$r30 = virtualinvoke $r29.<java.lang.StringBuilder: java.lang.String toString()>()
$r11 = new java.lang.StringBuilder
goto [?= $r31 = <java.lang.System: java.io.PrintStream out>]
$r31 = <java.lang.System: java.io.PrintStream out>
r0 = virtualinvoke $r13.<java.lang.StringBuilder: java.lang.String toString()>()
r0 = ""
$r19 = virtualinvoke $r17.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>("3 - Size B")
$r8 = new java.lang.StringBuilder
$r15 = staticinvoke <java.lang.String: java.lang.String valueOf(java.lang.Object)>(r1)
i0 := @parameter0: int
specialinvoke $r22.<java.lang.StringBuilder: void <init>(java.lang.String)>("Executing on ")
$r28 = virtualinvoke $r27.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i2)
$r23 = virtualinvoke $r22.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i2)
goto [?= $r20 = <java.lang.System: java.io.PrintStream out>]
r0 = virtualinvoke $r19.<java.lang.StringBuilder: java.lang.String toString()>()
$r22 = new java.lang.StringBuilder
goto [?= $r20 = <java.lang.System: java.io.PrintStream out>]
r0 = virtualinvoke $r10.<java.lang.StringBuilder: java.lang.String toString()>()
$r3 = staticinvoke <java.lang.String: java.lang.String valueOf(java.lang.Object)>(r1)
if i2 != 1 goto $r26 = <java.lang.System: java.io.PrintStream out>
$r18 = staticinvoke <java.lang.String: java.lang.String valueOf(java.lang.Object)>(r1)
$r21 = <java.lang.System: java.io.PrintStream out>
virtualinvoke $r21.<java.io.PrintStream: void println(java.lang.String)>($r25)
return
$r6 = staticinvoke <java.lang.String: java.lang.String valueOf(java.lang.Object)>(r1)
$r17 = new java.lang.StringBuilder
i1 := @parameter1: int
$r2 = new java.lang.StringBuilder
$r27 = new java.lang.StringBuilder
$r25 = virtualinvoke $r24.<java.lang.StringBuilder: java.lang.String toString()>()
tableswitch(i1) {     case 0: goto $r5 = new java.lang.StringBuilder;     case 1: goto $r8 = new java.lang.StringBuilder;     case 2: goto $r11 = new java.lang.StringBuilder;     default: goto goto [?= $r20 = <java.lang.System: java.io.PrintStream out>]; }
virtualinvoke $r31.<java.io.PrintStream: void println(java.lang.String)>("")
==============

Transforming benchmarks.jgfutil.JGFSection1... 
Transforming benchmarks.jgfutil.JGFSection3... 
Transforming benchmarks.jgfutil.JGFSection2... 
Transforming benchmarks.JGFRayTracerBenchSizeB... 
Transforming benchmarks.moldyn.TournamentBarrier... 
Transforming benchmarks.moldyn.random... 
Transforming benchmarks.moldyn.md... 
Transforming benchmarks.moldyn.Barrier... 
Transforming benchmarks.moldyn.particle... 
Transforming benchmarks.moldyn.mdRunner... 
Transforming benchmarks.moldyn.JGFMolDynBench... 
Transforming benchmarks.jpf_test_cases.pipeline.Stage... 
Transforming benchmarks.jpf_test_cases.pipeline.Pipeline... 
Transforming benchmarks.jpf_test_cases.pipeline.BlockingQueue... 
==============
 tn units (no order)
r0.<benchmarks.jpf_test_cases.pipeline.BlockingQueue: int queue> = -1
$r2 := @caughtexception
i0 = r0.<benchmarks.jpf_test_cases.pipeline.BlockingQueue: int queue>
$i1 = r0.<benchmarks.jpf_test_cases.pipeline.BlockingQueue: int queue>
r1 = $r2
virtualinvoke r0.<java.lang.Object: void wait()>()
if $i1 < 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
goto [?= $i1 = r0.<benchmarks.jpf_test_cases.pipeline.BlockingQueue: int queue>]
return i0
goto [?= $i1 = r0.<benchmarks.jpf_test_cases.pipeline.BlockingQueue: int queue>]
r0 := @this: benchmarks.jpf_test_cases.pipeline.BlockingQueue
==============

==============
 tn units (no order)
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
i0 := @parameter0: int
return
r0 := @this: benchmarks.jpf_test_cases.pipeline.BlockingQueue
r0.<benchmarks.jpf_test_cases.pipeline.BlockingQueue: int queue> = i0
==============

==============
 tn units (no order)
r0.<benchmarks.jpf_test_cases.pipeline.BlockingQueue: int queue> = 0
r0 := @this: benchmarks.jpf_test_cases.pipeline.BlockingQueue
return
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
==============

Transforming benchmarks.jpf_test_cases.pipeline.Listener... 
Transforming benchmarks.jpf_test_cases.pipeline.PipeInttest... 
Transforming benchmarks.jpf_test_cases.boundedbuffer.Consumer... 
Transforming benchmarks.jpf_test_cases.boundedbuffer.Buffer... 
==============
 tn units (no order)
goto [?= $i0 = r0.<benchmarks.jpf_test_cases.boundedbuffer.Buffer: int count>]
virtualinvoke r0.<java.lang.Object: void notify()>()
$i3 = $i2 + 1
r0.<benchmarks.jpf_test_cases.boundedbuffer.Buffer: int count> = $i3
$i0 = r0.<benchmarks.jpf_test_cases.boundedbuffer.Buffer: int count>
$i1 = r0.<benchmarks.jpf_test_cases.boundedbuffer.Buffer: int size>
$i2 = r0.<benchmarks.jpf_test_cases.boundedbuffer.Buffer: int count>
if $i0 == $i1 goto virtualinvoke r0.<java.lang.Object: void wait()>()
virtualinvoke r0.<java.lang.Object: void wait()>()
r0 := @this: benchmarks.jpf_test_cases.boundedbuffer.Buffer
return
==============

==============
 tn units (no order)
return
r0 := @this: benchmarks.jpf_test_cases.boundedbuffer.Buffer
$i1 = r0.<benchmarks.jpf_test_cases.boundedbuffer.Buffer: int count>
goto [?= $i0 = r0.<benchmarks.jpf_test_cases.boundedbuffer.Buffer: int count>]
virtualinvoke r0.<java.lang.Object: void wait()>()
if $i0 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
$i2 = $i1 - 1
$i0 = r0.<benchmarks.jpf_test_cases.boundedbuffer.Buffer: int count>
virtualinvoke r0.<java.lang.Object: void notify()>()
r0.<benchmarks.jpf_test_cases.boundedbuffer.Buffer: int count> = $i2
==============

Transforming benchmarks.jpf_test_cases.boundedbuffer.BoundedBuffer... 
Transforming benchmarks.jpf_test_cases.boundedbuffer.Producer... 
Transforming benchmarks.jpf_test_cases.rax.Event... 
==============
 tn units (no order)
goto [?= return]
$r2 := @caughtexception
return
r1 = $r2
virtualinvoke r0.<java.lang.Object: void wait()>()
r0 := @this: benchmarks.jpf_test_cases.rax.Event
==============

==============
 tn units (no order)
r0 := @this: benchmarks.jpf_test_cases.rax.Event
$i1 = $i0 + 1
return
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
r0.<benchmarks.jpf_test_cases.rax.Event: int count> = $i1
$i0 = r0.<benchmarks.jpf_test_cases.rax.Event: int count>
==============

Transforming benchmarks.jpf_test_cases.rax.START... 
Transforming benchmarks.jpf_test_cases.rax.FirstTask... 
Transforming benchmarks.jpf_test_cases.rax.SecondTask... 
Transforming benchmarks.jpf_test_cases.readerswriters.Reader... 
Transforming benchmarks.jpf_test_cases.readerswriters.RWPrinter... 
==============
 tn units (no order)
$r9 := @caughtexception
throw $r11
exitmonitor r1
$r11 := @caughtexception
$r7 := @caughtexception
virtualinvoke $r8.<java.lang.Object: void wait()>()
goto [?= $r8 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: java.lang.Object waitingReaderMonitor_>]
entermonitor r0
exitmonitor r2
$i2 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int waitingReaders_>
r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeReaders_> = $i1
r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int waitingReaders_> = $i3
$z0 = virtualinvoke r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: boolean allowReader()>()
r10 = $r9
entermonitor $r3
throw $r7
if $z0 == 0 goto $i2 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int waitingReaders_>
exitmonitor r2
goto [?= exitmonitor r1]
exitmonitor r1
$i3 = $i2 + 1
$i0 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeReaders_>
exitmonitor r1
$i1 = $i0 + 1
exitmonitor r2
$r8 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: java.lang.Object waitingReaderMonitor_>
==============

==============
 tn units (no order)
if $z0 == 0 goto $i2 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int waitingReaders_>
$r11 := @caughtexception
exitmonitor r2
$r7 := @caughtexception
exitmonitor r1
entermonitor r0
exitmonitor r2
$i2 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int waitingReaders_>
r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeReaders_> = $i1
$i3 = $i2 + 1
r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int waitingReaders_> = $i3
$z0 = virtualinvoke r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: boolean allowReader()>()
$i0 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeReaders_>
$i1 = $i0 + 1
exitmonitor r2
==============

==============
 tn units (no order)
$r12 := @caughtexception
goto [?= virtualinvoke r2.<java.lang.Object: void wait()>()]
exitmonitor r3
entermonitor r2
$z0 = virtualinvoke r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: boolean allowWriter()>()
r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeWriters_> = $i1
r11 = $r10
exitmonitor r3
goto [?= exitmonitor r3]
exitmonitor r3
$i1 = $i0 + 1
entermonitor r0
$r8 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: benchmarks.jpf_test_cases.readerswriters.Vector waitingWriterMonitors_>
$r10 := @caughtexception
throw $r9
exitmonitor r4
exitmonitor r4
virtualinvoke r2.<java.lang.Object: void wait()>()
virtualinvoke $r8.<benchmarks.jpf_test_cases.readerswriters.Vector: void addElement(java.lang.Object)>(r2)
$r9 := @caughtexception
$i0 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeWriters_>
if $z0 == 0 goto $r8 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: benchmarks.jpf_test_cases.readerswriters.Vector waitingWriterMonitors_>
exitmonitor r4
==============

==============
 tn units (no order)
$i1 = $i0 + 1
$z0 = virtualinvoke r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: boolean allowWriter()>()
entermonitor r0
$r8 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: benchmarks.jpf_test_cases.readerswriters.Vector waitingWriterMonitors_>
r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeWriters_> = $i1
exitmonitor r4
exitmonitor r4
virtualinvoke $r8.<benchmarks.jpf_test_cases.readerswriters.Vector: void addElement(java.lang.Object)>(r2)
$r9 := @caughtexception
$i0 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeWriters_>
exitmonitor r4
if $z0 == 0 goto $r8 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: benchmarks.jpf_test_cases.readerswriters.Vector waitingWriterMonitors_>
==============

==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeReaders_> = $i0
goto [?= $i0 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int waitingReaders_>]
$r4 := @caughtexception
return
exitmonitor r1
$i0 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int waitingReaders_>
$r3 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: java.lang.Object waitingReaderMonitor_>
r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int waitingReaders_> = 0
r0 := @this: benchmarks.jpf_test_cases.readerswriters.RWPrinter
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
throw $r4
$r2 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: java.lang.Object waitingReaderMonitor_>
==============

==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
$r3 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: java.lang.Object waitingReaderMonitor_>
$r4 := @caughtexception
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: benchmarks.jpf_test_cases.readerswriters.Vector waitingWriterMonitors_>
$r5 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: benchmarks.jpf_test_cases.readerswriters.Vector waitingWriterMonitors_>
virtualinvoke r1.<java.lang.Object: void notify()>()
throw $r7
r0 := @this: benchmarks.jpf_test_cases.readerswriters.RWPrinter
if $i0 <= 0 goto return
$i2 = $i1 + 1
exitmonitor r2
virtualinvoke $r5.<benchmarks.jpf_test_cases.readerswriters.Vector: void removeElementAt(int)>(0)
$r4 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: benchmarks.jpf_test_cases.readerswriters.Vector waitingWriterMonitors_>
r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeWriters_> = $i2
$i0 = virtualinvoke $r3.<benchmarks.jpf_test_cases.readerswriters.Vector: int size()>()
entermonitor r1
$r7 := @caughtexception
$i1 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeWriters_>
r1 = virtualinvoke $r4.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object firstElement()>()
goto [?= $i1 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeWriters_>]
return
exitmonitor r2
==============

==============
 tn units (no order)
entermonitor r1
$r7 := @caughtexception
virtualinvoke r1.<java.lang.Object: void notify()>()
exitmonitor r2
exitmonitor r2
==============

==============
 tn units (no order)
$i1 = $i0 - 1
return
if $i2 != 0 goto return
r0 := @this: benchmarks.jpf_test_cases.readerswriters.RWPrinter
$i0 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeReaders_>
r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeReaders_> = $i1
virtualinvoke r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: void notifyWriter()>()
$i2 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeReaders_>
==============

==============
 tn units (no order)
$i0 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeWriters_>
virtualinvoke r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: void notifyReaders()>()
r0 := @this: benchmarks.jpf_test_cases.readerswriters.RWPrinter
virtualinvoke r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: void notifyWriter()>()
return
$i2 = r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int waitingReaders_>
r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: int activeWriters_> = $i1
if $i2 <= 0 goto virtualinvoke r0.<benchmarks.jpf_test_cases.readerswriters.RWPrinter: void notifyWriter()>()
$i1 = $i0 - 1
goto [?= return]
==============

Transforming benchmarks.jpf_test_cases.readerswriters.Vector... 
==============
 tn units (no order)
if $i1 > 0 goto $r2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
r1[i0] = $r3
i0 = i0 + -1
r1 := @parameter0: java.lang.Object[]
$r2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
$i1 = i0
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
$r3 = $r2[i0]
i0 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
return
goto [?= $i1 = i0]
==============

==============
 tn units (no order)
r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData> = $r3
if $i1 >= i0 goto return
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
$i3 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
i0 = lengthof $r2
specialinvoke r0.<benchmarks.jpf_test_cases.readerswriters.Vector: void arraycopy(java.lang.Object[],int,java.lang.Object[],int,int)>(r1, 0, $r4, 0, $i3)
$r3 = newarray (java.lang.Object)[$i2]
$i1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
return
$r4 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
$r2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
r1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
$i2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
==============

==============
 tn units (no order)
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
$i3 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int capacityIncrement>
specialinvoke r0.<benchmarks.jpf_test_cases.readerswriters.Vector: void arraycopy(java.lang.Object[],int,java.lang.Object[],int,int)>(r1, 0, $r4, 0, $i6)
$r4 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData> = $r3
$r2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
$i4 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int capacityIncrement>
r1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
i1 = lengthof $r2
goto [?= i2 = $i5]
if i0 <= i1 goto return
i0 := @parameter0: int
$i5 = i1 + $i4
i2 = i0
if $i3 <= 0 goto $i5 = i1 * 2
i2 = $i5
$i6 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
$i5 = i1 * 2
$r3 = newarray (java.lang.Object)[i2]
return
if i2 >= i0 goto $r3 = newarray (java.lang.Object)[i2]
==============

==============
 tn units (no order)
r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount> = i0
$i2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
return
i0 := @parameter0: int
if i0 <= $i2 goto i1 = i0
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
i1 = i0
if i1 < $i3 goto $r1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
virtualinvoke r0.<benchmarks.jpf_test_cases.readerswriters.Vector: void ensureCapacity(int)>(i0)
$r1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
goto [?= r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount> = i0]
i1 = i1 + 1
$r1[i1] = null
goto [?= $i3 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>]
$i3 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
==============

==============
 tn units (no order)
$r2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r3)
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
if i1 < $i2 goto $r2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
if $z0 == 0 goto i1 = i1 + 1
goto [?= $i2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>]
r1 := @parameter0: java.lang.Object
i1 = i0
$r3 = $r2[i1]
i1 = i1 + 1
$i2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
i0 := @parameter1: int
return i1
return -1
==============

==============
 tn units (no order)
return i1
return -1
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r3)
i0 := @parameter1: int
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
$r2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
$r3 = $r2[i1]
if i1 >= 0 goto $r2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
r1 := @parameter0: java.lang.Object
goto [?= (branch)]
i1 = i1 + -1
i1 = i0
if $z0 == 0 goto i1 = i1 + -1
==============

==============
 tn units (no order)
$r13 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$r10 := @caughtexception
$r8 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
$r15 = virtualinvoke $r14.<java.lang.StringBuilder: java.lang.String toString()>()
$r5 = virtualinvoke $r1.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
$r14 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" < 0")
specialinvoke $r11.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r15)
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
$r9 = $r8[i0]
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
$r12 = new java.lang.StringBuilder
specialinvoke $r1.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
if i0 < $i1 goto $r8 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
return $r9
i0 := @parameter0: int
throw $r3
$i1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
$r3 = new java.lang.ArrayIndexOutOfBoundsException
$i2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
r2 = $r10
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
$r11 = new java.lang.ArrayIndexOutOfBoundsException
$r1 = new java.lang.StringBuilder
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i2)
throw $r11
specialinvoke $r12.<java.lang.StringBuilder: void <init>(java.lang.String)>($r13)
==============

==============
 tn units (no order)
$r2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
$r1 = new java.util.NoSuchElementException
if $i0 != 0 goto $r2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
$i0 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
throw $r1
$r3 = $r2[0]
specialinvoke $r1.<java.util.NoSuchElementException: void <init>()>()
return $r3
==============

==============
 tn units (no order)
$i2 = $i1 - 1
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
throw $r1
$i1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
$r3 = $r2[$i2]
specialinvoke $r1.<java.util.NoSuchElementException: void <init>()>()
$r2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
if $i0 != 0 goto $r2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
$i0 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
$r1 = new java.util.NoSuchElementException
return $r3
==============

==============
 tn units (no order)
$i1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
$i2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
r1 := @parameter0: java.lang.Object
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i2)
$r3 = new java.lang.ArrayIndexOutOfBoundsException
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
if i0 < $i1 goto $r8 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
specialinvoke $r2.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
$r2 = new java.lang.StringBuilder
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
$r5 = virtualinvoke $r2.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
return
throw $r3
i0 := @parameter1: int
$r8[i0] = r1
$r8 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
==============

==============
 tn units (no order)
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.String toString()>()
if i0 < $i2 goto (branch)
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
throw $r2
$i4 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount> = $i8
throw $r7
$r5 = virtualinvoke $r4.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i3)
$r1 = new java.lang.StringBuilder
$r9 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
$r4 = virtualinvoke $r1.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
$r2 = new java.lang.ArrayIndexOutOfBoundsException
$i6 = i0 + 1
$r7 = new java.lang.ArrayIndexOutOfBoundsException
$r11 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
i0 := @parameter0: int
i1 = $i5 - 1
specialinvoke $r1.<java.lang.StringBuilder: void <init>(java.lang.String)>($r3)
$i3 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
$i2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
return
specialinvoke $r2.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r6)
$i5 = $i4 - i0
$i7 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
$i8 = $i7 - 1
$r3 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
if i0 >= 0 goto $i4 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
$r11[$i9] = null
specialinvoke r0.<benchmarks.jpf_test_cases.readerswriters.Vector: void arraycopy(java.lang.Object[],int,java.lang.Object[],int,int)>($r8, $i6, $r9, i0, i1)
$i9 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
if i1 <= 0 goto $i7 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
specialinvoke $r7.<java.lang.ArrayIndexOutOfBoundsException: void <init>(int)>(i0)
$r8 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
==============

==============
 tn units (no order)
r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount> = $i10
$i7 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
$r10 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
virtualinvoke r0.<benchmarks.jpf_test_cases.readerswriters.Vector: void ensureCapacity(int)>($i5)
$i4 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
specialinvoke $r2.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
specialinvoke $r3.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
$i9 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
$r3 = new java.lang.StringBuilder
$i2 = $i1 + 1
$i5 = $i4 + 1
$i10 = $i9 + 1
$i8 = $i7 - i0
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
throw $r2
$r10[i0] = r1
$i6 = i0 + 1
$i1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
return
if i0 < $i2 goto $i4 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
r1 := @parameter0: java.lang.Object
$i3 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
$r8 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
i0 := @parameter1: int
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$r5 = virtualinvoke $r3.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" > ")
specialinvoke r0.<benchmarks.jpf_test_cases.readerswriters.Vector: void arraycopy(java.lang.Object[],int,java.lang.Object[],int,int)>($r8, i0, $r9, $i6, $i8)
$r2 = new java.lang.ArrayIndexOutOfBoundsException
$r9 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i3)
==============

==============
 tn units (no order)
return
$i2 = $i1 + 1
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
$i0 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount> = $i3
$r2 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
$i1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
$i3 = $i0 + 1
virtualinvoke r0.<benchmarks.jpf_test_cases.readerswriters.Vector: void ensureCapacity(int)>($i2)
$r2[$i0] = r1
r1 := @parameter0: java.lang.Object
==============

==============
 tn units (no order)
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
virtualinvoke r0.<benchmarks.jpf_test_cases.readerswriters.Vector: void removeElementAt(int)>(i0)
return 0
r1 := @parameter0: java.lang.Object
if i0 < 0 goto return 0
i0 = virtualinvoke r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int indexOf(java.lang.Object)>(r1)
return 1
==============

==============
 tn units (no order)
if i0 < $i1 goto $r1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount> = 0
$r1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
return
$i1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
goto [?= $i1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>]
i0 = i0 + 1
i0 = 0
$r1[i0] = null
==============

==============
 tn units (no order)
specialinvoke $r9.<java.lang.InternalError: void <init>()>()
$i1 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
r1 = (benchmarks.jpf_test_cases.readerswriters.Vector) $r2
$r7 := @caughtexception
$r2 = specialinvoke r0.<java.lang.Object: java.lang.Object clone()>()
$r5 = r1.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
r8 = $r7
$r9 = new java.lang.InternalError
$r3 = newarray (java.lang.Object)[$i0]
return r1
specialinvoke r0.<benchmarks.jpf_test_cases.readerswriters.Vector: void arraycopy(java.lang.Object[],int,java.lang.Object[],int,int)>($r4, 0, $r5, 0, $i1)
r1.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData> = $r3
$i0 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: int elementCount>
r0 := @this: benchmarks.jpf_test_cases.readerswriters.Vector
throw $r9
$r4 = r0.<benchmarks.jpf_test_cases.readerswriters.Vector: java.lang.Object[] elementData>
==============

Transforming benchmarks.jpf_test_cases.readerswriters.Writer... 
Transforming benchmarks.jpf_test_cases.readerswriters.RWVSNTest... 
Transforming benchmarks.jpf_test_cases.MyRandom... 
Transforming benchmarks.jpf_test_cases.replicatedcasestudies.Collection... 
Transforming benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers... 
==============
 tn units (no order)
$r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier mainWorkerBarrier>
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: boolean stop> = 1
return
virtualinvoke $r1.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: void await()>()
==============

==============
 tn units (no order)
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers
virtualinvoke $r1.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: void add()>()
$r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator theCoord>
return
==============

==============
 tn units (no order)
return $i0
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers
$i0 = virtualinvoke $r1.<benchmarks.jpf_test_cases.replicatedcasestudies.SynchronizedCollection: int take()>()
$r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.SynchronizedCollection resultPool>
==============

==============
 tn units (no order)
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: boolean done> = 0
$r2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator theCoord>
$r4 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier mainWorkerBarrier>
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: boolean done> = 1
virtualinvoke $r1.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: void await()>()
$r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier mainWorkerBarrier>
virtualinvoke $r2.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: void mainAwaitTerminate()>()
$r3 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator theCoord>
return
virtualinvoke $r4.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: void await()>()
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers
virtualinvoke $r3.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: void notifyDoneChange()>()
==============

Transforming benchmarks.jpf_test_cases.replicatedcasestudies.SignsSrcAbs... 
Transforming benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier... 
==============
 tn units (no order)
goto [?= $l2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numBlocked>]
if $z0 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
$l3 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long participants>
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
$l2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numBlocked>
$z0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allBlocked>
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allBlocked> = 1
$l1 = $l0 + 1L
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allBlocked> = 0
$r3 := @caughtexception
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numBlocked> = 0L
if $b4 >= 0 goto r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allBlocked> = 1
r2 = $r3
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numBlocked> = $l1
return
goto [?= $l2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numBlocked>]
virtualinvoke r0.<java.lang.Object: void wait()>()
$l0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numBlocked>
$b4 = $l2 cmp $l3
==============

==============
 tn units (no order)
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
if $b4 >= 0 goto r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allReleased> = 1
r2 = $r3
$b4 = $l2 cmp $l3
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allReleased> = 0
virtualinvoke r0.<java.lang.Object: void wait()>()
return
$l2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numReleased>
$l1 = $l0 + 1L
goto [?= $l2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numReleased>]
if $z0 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
goto [?= $l2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numReleased>]
$r3 := @caughtexception
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numReleased> = $l1
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allReleased> = 1
$l3 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long participants>
$l0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numReleased>
$z0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allReleased>
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numReleased> = 0L
==============

==============
 tn units (no order)
r6 = $r5
virtualinvoke r0.<java.lang.Object: void wait()>()
$b9 = $l7 cmp $l8
if $b9 >= 0 goto r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allReleased> = 1
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allReleased> = 1
virtualinvoke r0.<java.lang.Object: void wait()>()
$l6 = $l5 + 1L
return
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numReleased> = $l6
goto [?= $l2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numBlocked>]
goto [?= $l2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numBlocked>]
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allBlocked> = 1
$l7 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numReleased>
$z0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allBlocked>
$l2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numBlocked>
$z1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allReleased>
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allBlocked> = 0
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allReleased> = 0
$l8 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long participants>
$b4 = $l2 cmp $l3
r2 = $r3
$l5 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numReleased>
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numBlocked> = 0L
if $z0 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
$l3 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long participants>
goto [?= $l7 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numReleased>]
$r3 := @caughtexception
goto [?= $l7 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numReleased>]
$r5 := @caughtexception
if $b4 >= 0 goto r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: boolean allBlocked> = 1
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numReleased> = 0L
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numBlocked> = $l1
$l0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier: long numBlocked>
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
$l1 = $l0 + 1L
if $z1 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
==============

Transforming benchmarks.jpf_test_cases.replicatedcasestudies.IntSrcAbs... 
Transforming benchmarks.jpf_test_cases.replicatedcasestudies.SynchronizedCollection... 
==============
 tn units (no order)
return $i0
$i0 = virtualinvoke $r1.<benchmarks.jpf_test_cases.replicatedcasestudies.Collection: int size()>()
$r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.SynchronizedCollection: benchmarks.jpf_test_cases.replicatedcasestudies.Collection theCollection>
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.SynchronizedCollection
==============

==============
 tn units (no order)
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.SynchronizedCollection
return $i0
$i0 = virtualinvoke $r1.<benchmarks.jpf_test_cases.replicatedcasestudies.Collection: int take()>()
$r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.SynchronizedCollection: benchmarks.jpf_test_cases.replicatedcasestudies.Collection theCollection>
==============

==============
 tn units (no order)
return
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.SynchronizedCollection
virtualinvoke $r1.<benchmarks.jpf_test_cases.replicatedcasestudies.Collection: void add()>()
$r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.SynchronizedCollection: benchmarks.jpf_test_cases.replicatedcasestudies.Collection theCollection>
==============

Transforming benchmarks.jpf_test_cases.replicatedcasestudies.Generic... 
Transforming benchmarks.jpf_test_cases.replicatedcasestudies.Configuration... 
Transforming benchmarks.jpf_test_cases.replicatedcasestudies.Worker... 
Transforming benchmarks.jpf_test_cases.replicatedcasestudies.Vector... 
==============
 tn units (no order)
r1[i0] = $r3
if $i1 > 0 goto $r2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
r1 := @parameter0: java.lang.Object[]
$r3 = $r2[i0]
i0 = i0 + -1
goto [?= $i1 = i0]
$r2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$i1 = i0
i0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
return
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
==============

==============
 tn units (no order)
$r3 = newarray (java.lang.Object)[$i2]
if $i1 >= i0 goto return
r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
$i2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
i0 = lengthof $r2
$r4 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$r2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
specialinvoke r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: void arraycopy(java.lang.Object[],int,java.lang.Object[],int,int)>(r1, 0, $r4, 0, $i3)
return
$i3 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
$i1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData> = $r3
==============

==============
 tn units (no order)
return
if i0 <= i1 goto return
$i5 = i1 * 2
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData> = $r3
if i2 >= i0 goto $r3 = newarray (java.lang.Object)[i2]
i2 = i0
$i5 = i1 + $i4
r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$r3 = newarray (java.lang.Object)[i2]
i1 = lengthof $r2
specialinvoke r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: void arraycopy(java.lang.Object[],int,java.lang.Object[],int,int)>(r1, 0, $r4, 0, $i6)
$i4 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int capacityIncrement>
if $i3 <= 0 goto $i5 = i1 * 2
goto [?= i2 = $i5]
$r2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
i0 := @parameter0: int
i2 = $i5
$r4 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$i3 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int capacityIncrement>
$i6 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
==============

==============
 tn units (no order)
if i1 < $i3 goto $r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$i2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
if i0 <= $i2 goto i1 = i0
i1 = i1 + 1
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
i0 := @parameter0: int
return
$i3 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
$r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
virtualinvoke r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: void ensureCapacity(int)>(i0)
goto [?= $i3 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>]
$r1[i1] = null
i1 = i0
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount> = i0
goto [?= r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount> = i0]
==============

==============
 tn units (no order)
if i1 < $i2 goto $r2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$r3 = $r2[i1]
return i1
i1 = i1 + 1
r1 := @parameter0: java.lang.Object
$r2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$i2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
return -1
goto [?= $i2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>]
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r3)
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
i1 = i0
i0 := @parameter1: int
if $z0 == 0 goto i1 = i1 + 1
==============

==============
 tn units (no order)
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r3)
i0 := @parameter1: int
$r2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
return -1
r1 := @parameter0: java.lang.Object
i1 = i0
if $z0 == 0 goto i1 = i1 + -1
i1 = i1 + -1
if i1 >= 0 goto $r2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
return i1
$r3 = $r2[i1]
goto [?= (branch)]
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
==============

==============
 tn units (no order)
if i0 < $i1 goto $r8 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
return $r9
$r5 = virtualinvoke $r1.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
$r13 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
throw $r11
specialinvoke $r1.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
throw $r3
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i2)
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
$r14 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" < 0")
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
specialinvoke $r11.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r15)
$r10 := @caughtexception
$r12 = new java.lang.StringBuilder
$r8 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$r1 = new java.lang.StringBuilder
$r9 = $r8[i0]
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
r2 = $r10
$r15 = virtualinvoke $r14.<java.lang.StringBuilder: java.lang.String toString()>()
$i1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
$i2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
specialinvoke $r12.<java.lang.StringBuilder: void <init>(java.lang.String)>($r13)
$r3 = new java.lang.ArrayIndexOutOfBoundsException
i0 := @parameter0: int
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$r11 = new java.lang.ArrayIndexOutOfBoundsException
==============

==============
 tn units (no order)
$r1 = new java.util.NoSuchElementException
$r2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
specialinvoke $r1.<java.util.NoSuchElementException: void <init>()>()
$i0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
$r3 = $r2[0]
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
return $r3
if $i0 != 0 goto $r2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
throw $r1
==============

==============
 tn units (no order)
$r2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$r1 = new java.util.NoSuchElementException
return $r3
$i0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
$r3 = $r2[$i2]
$i1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
throw $r1
specialinvoke $r1.<java.util.NoSuchElementException: void <init>()>()
$i2 = $i1 - 1
if $i0 != 0 goto $r2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
==============

==============
 tn units (no order)
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i2)
$i1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
i0 := @parameter1: int
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
if i0 < $i1 goto $r8 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$r5 = virtualinvoke $r2.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
$r8[i0] = r1
$i2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
throw $r3
$r2 = new java.lang.StringBuilder
return
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
r1 := @parameter0: java.lang.Object
$r8 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$r3 = new java.lang.ArrayIndexOutOfBoundsException
specialinvoke $r2.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
==============

==============
 tn units (no order)
$r2 = new java.lang.ArrayIndexOutOfBoundsException
$i8 = $i7 - 1
$r11[$i9] = null
if i0 >= 0 goto $i4 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
if i1 <= 0 goto $i7 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
$i9 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
specialinvoke $r7.<java.lang.ArrayIndexOutOfBoundsException: void <init>(int)>(i0)
$i2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
$i3 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
$r4 = virtualinvoke $r1.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
throw $r7
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
$r8 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$r11 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
throw $r2
$i7 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
$i4 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
specialinvoke $r1.<java.lang.StringBuilder: void <init>(java.lang.String)>($r3)
i1 = $i5 - 1
$r1 = new java.lang.StringBuilder
$r5 = virtualinvoke $r4.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i3)
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.String toString()>()
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount> = $i8
if i0 < $i2 goto (branch)
$i6 = i0 + 1
specialinvoke $r2.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r6)
$r9 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
return
$i5 = $i4 - i0
$r3 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$r7 = new java.lang.ArrayIndexOutOfBoundsException
specialinvoke r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: void arraycopy(java.lang.Object[],int,java.lang.Object[],int,int)>($r8, $i6, $r9, i0, i1)
i0 := @parameter0: int
==============

==============
 tn units (no order)
$i6 = i0 + 1
$r9 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$r10[i0] = r1
$i4 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
$i3 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
specialinvoke $r3.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
$r8 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
return
r1 := @parameter0: java.lang.Object
$i9 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
throw $r2
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount> = $i10
specialinvoke r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: void arraycopy(java.lang.Object[],int,java.lang.Object[],int,int)>($r8, i0, $r9, $i6, $i8)
$i5 = $i4 + 1
$r10 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$r2 = new java.lang.ArrayIndexOutOfBoundsException
i0 := @parameter1: int
$r5 = virtualinvoke $r3.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" > ")
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i3)
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
virtualinvoke r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: void ensureCapacity(int)>($i5)
$r3 = new java.lang.StringBuilder
if i0 < $i2 goto $i4 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
$i7 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
specialinvoke $r2.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
$i2 = $i1 + 1
$i10 = $i9 + 1
$i8 = $i7 - i0
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$i1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
==============

==============
 tn units (no order)
$r2[$i0] = r1
$r2 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
r1 := @parameter0: java.lang.Object
$i0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount> = $i3
return
$i1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
$i3 = $i0 + 1
virtualinvoke r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: void ensureCapacity(int)>($i2)
$i2 = $i1 + 1
==============

==============
 tn units (no order)
virtualinvoke r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: void removeElementAt(int)>(i0)
return 1
if i0 < 0 goto return 0
return 0
r1 := @parameter0: java.lang.Object
i0 = virtualinvoke r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int indexOf(java.lang.Object)>(r1)
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
==============

==============
 tn units (no order)
goto [?= $i1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>]
i0 = i0 + 1
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
return
$r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
i0 = 0
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount> = 0
if i0 < $i1 goto $r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$r1[i0] = null
$i1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
==============

==============
 tn units (no order)
throw $r9
$r4 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
$r9 = new java.lang.InternalError
r1 = (benchmarks.jpf_test_cases.replicatedcasestudies.Vector) $r2
specialinvoke r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: void arraycopy(java.lang.Object[],int,java.lang.Object[],int,int)>($r4, 0, $r5, 0, $i1)
$r2 = specialinvoke r0.<java.lang.Object: java.lang.Object clone()>()
$r5 = r1.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData>
return r1
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Vector
r1.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: java.lang.Object[] elementData> = $r3
$r3 = newarray (java.lang.Object)[$i0]
$i1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
r8 = $r7
$i0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Vector: int elementCount>
$r7 := @caughtexception
specialinvoke $r9.<java.lang.InternalError: void <init>()>()
==============

Transforming benchmarks.jpf_test_cases.replicatedcasestudies.SrcAbs... 
Transforming benchmarks.jpf_test_cases.replicatedcasestudies.StandardCountingSemaphore... 
==============
 tn units (no order)
$l1 = $l0 - 1L
r2 = $r3
virtualinvoke r0.<java.lang.Object: void wait()>()
$b2 = $l1 cmp 0L
$r3 := @caughtexception
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.StandardCountingSemaphore
return
goto [?= return]
$l0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardCountingSemaphore: long permits_>
if $b2 >= 0 goto return
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardCountingSemaphore: long permits_> = $l1
==============

==============
 tn units (no order)
virtualinvoke r0.<java.lang.Object: void notify()>()
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardCountingSemaphore: long permits_> = $l1
if $b2 >= 0 goto return
$b2 = $l0 cmp 0L
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.StandardCountingSemaphore
$l0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.StandardCountingSemaphore: long permits_>
$l1 = $l0 + 1L
return
==============

Transforming benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator... 
==============
 tn units (no order)
if $i0 != $i1 goto return
$r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
$i1 = $r1.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: int numWorkers>
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator
return
$i0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: int blockedTakers>
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
==============

==============
 tn units (no order)
return
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
$r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator
$z0 = $r1.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: boolean done>
if $z0 == 0 goto return
==============

==============
 tn units (no order)
$i0 = virtualinvoke $r2.<benchmarks.jpf_test_cases.replicatedcasestudies.Collection: int size()>()
$r2 = $r1.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.Collection workPool>
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator
$r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
if $i0 < 0 goto return
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
return
==============

==============
 tn units (no order)
$i1 = $r3.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: int numWorkers>
$r2 := @caughtexception
r1 = $r2
return
if $i0 != $i1 goto return
if $z0 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
goto [?= $i0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: int blockedTakers>]
$z0 = $r4.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: boolean done>
goto [?= $i0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: int blockedTakers>]
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator
$r4 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
$r3 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
$i0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: int blockedTakers>
virtualinvoke r0.<java.lang.Object: void wait()>()
==============

==============
 tn units (no order)
$r19 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
$i2 = virtualinvoke $r4.<benchmarks.jpf_test_cases.replicatedcasestudies.Collection: int size()>()
$r7 = $r6.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator theCoord>
virtualinvoke $r15.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: void notifyTakerChange()>()
if $z0 != 0 goto $r9 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
$z1 = $r11.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: boolean done>
$r11 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
$r12 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
$r4 = $r3.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.Collection workPool>
virtualinvoke $r7.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: void notifyTakerChange()>()
$r10 = $r9.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.Collection workPool>
$r9 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
$r8 := @caughtexception
$z0 = $r5.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: boolean done>
return i6
i6 = virtualinvoke $r17.<benchmarks.jpf_test_cases.replicatedcasestudies.Collection: int take()>()
$r3 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
$i5 = $i4 - 1
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: int blockedTakers> = $i1
goto [?= $r9 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>]
$i4 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: int blockedTakers>
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: int blockedTakers> = $i8
$i7 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: int blockedTakers>
z3 = 0
$r5 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
$r17 = $r16.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.Collection workPool>
goto [?= $r9 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>]
return 0
$i1 = $i0 + 1
if $i3 != 0 goto $r12 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
if $z2 == 0 goto z3 = 0
$z2 = $r12.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: boolean done>
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator
$r14 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
$i0 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: int blockedTakers>
$r20 = $r19.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator theCoord>
if $i2 != 0 goto $r9 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
virtualinvoke r0.<java.lang.Object: void wait()>()
$i3 = virtualinvoke $r10.<benchmarks.jpf_test_cases.replicatedcasestudies.Collection: int size()>()
virtualinvoke $r20.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: void notifyTakerChange()>()
$r16 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
$r15 = $r14.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator theCoord>
r2 = $r8
$i8 = $i7 - 1
if $z1 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
$r6 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: int blockedTakers> = $i5
==============

==============
 tn units (no order)
return
$r1 = r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers memberOf>
virtualinvoke r0.<benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator: void notifyPoolChange()>()
virtualinvoke $r2.<benchmarks.jpf_test_cases.replicatedcasestudies.Collection: void add()>()
$r2 = $r1.<benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers: benchmarks.jpf_test_cases.replicatedcasestudies.Collection workPool>
r0 := @this: benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator
==============

Transforming benchmarks.jpf_test_cases.nestedmonitors.Consumer... 
Transforming benchmarks.jpf_test_cases.nestedmonitors.Buffer... 
==============
 tn units (no order)
r0 := @this: benchmarks.jpf_test_cases.nestedmonitors.Buffer
r1 := @parameter0: java.lang.Object
virtualinvoke $r2.<benchmarks.jpf_test_cases.nestedmonitors.Semaphore: void down()>()
$r3 = r0.<benchmarks.jpf_test_cases.nestedmonitors.Buffer: benchmarks.jpf_test_cases.nestedmonitors.Semaphore full>
$r2 = r0.<benchmarks.jpf_test_cases.nestedmonitors.Buffer: benchmarks.jpf_test_cases.nestedmonitors.Semaphore empty>
virtualinvoke $r3.<benchmarks.jpf_test_cases.nestedmonitors.Semaphore: void up()>()
return
==============

==============
 tn units (no order)
virtualinvoke $r1.<benchmarks.jpf_test_cases.nestedmonitors.Semaphore: void down()>()
$r1 = r0.<benchmarks.jpf_test_cases.nestedmonitors.Buffer: benchmarks.jpf_test_cases.nestedmonitors.Semaphore full>
r0 := @this: benchmarks.jpf_test_cases.nestedmonitors.Buffer
$r2 = r0.<benchmarks.jpf_test_cases.nestedmonitors.Buffer: benchmarks.jpf_test_cases.nestedmonitors.Semaphore empty>
virtualinvoke $r2.<benchmarks.jpf_test_cases.nestedmonitors.Semaphore: void up()>()
return null
==============

Transforming benchmarks.jpf_test_cases.nestedmonitors.NestedMonitor... 
Transforming benchmarks.jpf_test_cases.nestedmonitors.Semaphore... 
==============
 tn units (no order)
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
$i1 = $i0 + 1
r0.<benchmarks.jpf_test_cases.nestedmonitors.Semaphore: int value> = $i1
r0 := @this: benchmarks.jpf_test_cases.nestedmonitors.Semaphore
$i0 = r0.<benchmarks.jpf_test_cases.nestedmonitors.Semaphore: int value>
return
==============

==============
 tn units (no order)
if $i0 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
$i0 = r0.<benchmarks.jpf_test_cases.nestedmonitors.Semaphore: int value>
r0 := @this: benchmarks.jpf_test_cases.nestedmonitors.Semaphore
return
goto [?= $i0 = r0.<benchmarks.jpf_test_cases.nestedmonitors.Semaphore: int value>]
r0.<benchmarks.jpf_test_cases.nestedmonitors.Semaphore: int value> = $i2
$i2 = $i1 - 1
$i1 = r0.<benchmarks.jpf_test_cases.nestedmonitors.Semaphore: int value>
virtualinvoke r0.<java.lang.Object: void wait()>()
==============

Transforming benchmarks.jpf_test_cases.nestedmonitors.Producer... 
Transforming benchmarks.JGFMolDynBenchSizeA... 
Transforming benchmarks.SimpleExample... 
==============
 tn units (no order)
<benchmarks.SimpleExample: int a> = 1
exitmonitor r1
exitmonitor r1
entermonitor $r2
$r3 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r5
exitmonitor r5
$r6 := @caughtexception
<benchmarks.SimpleExample: int b> = 2
entermonitor $r4
==============

Transforming benchmarks.philo.StartError... 
Transforming benchmarks.philo.Table... 
==============
 tn units (no order)
$z1 = $r3[i1]
exitmonitor r2
$r6[i2] = $z0
$r8 := @caughtexception
$i3 = i0 + 1
i2 = $i3 % 2
$i4 = r0.<benchmarks.philo.Table: int eatctr>
entermonitor r0
virtualinvoke r0.<java.lang.Object: void wait()>()
i1 = i0
if $z2 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
exitmonitor r2
$r5[i1] = $z0
$r6 = r0.<benchmarks.philo.Table: boolean[] forks>
$z0 = 0
$z2 = $r4[i2]
$i6 = $i4 + 1
if $z1 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
goto [?= $r3 = r0.<benchmarks.philo.Table: boolean[] forks>]
$r5 = r0.<benchmarks.philo.Table: boolean[] forks>
r0.<benchmarks.philo.Table: int eatctr> = $i6
$r3 = r0.<benchmarks.philo.Table: boolean[] forks>
$r4 = r0.<benchmarks.philo.Table: boolean[] forks>
==============

==============
 tn units (no order)
$z0 = 1
return
$r2[$i2] = $z0
$i2 = $i1 % 2
$i1 = i0 + 1
$r2 = r0.<benchmarks.philo.Table: boolean[] forks>
i0 := @parameter0: int
$r1[i0] = $z0
virtualinvoke r0.<java.lang.Object: void notify()>()
$r1 = r0.<benchmarks.philo.Table: boolean[] forks>
r0 := @this: benchmarks.philo.Table
==============

Transforming benchmarks.philo.Philo... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncList... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.LayeredSync... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncSet... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt... 
==============
 tn units (no order)
$i1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int set(int)>(i0)
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
$r4 := @caughtexception
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
exitmonitor r1
entermonitor $r2
==============

==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
z0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: boolean commit(int,int)>(i0, i1)
$r4 := @caughtexception
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
if z0 == 0 goto exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r1
$i0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int increment()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
entermonitor $r2
exitmonitor r1
$r4 := @caughtexception
==============

==============
 tn units (no order)
$r4 := @caughtexception
$i0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int decrement()>()
entermonitor $r2
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
$r4 := @caughtexception
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
$i1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int add(int)>(i0)
entermonitor $r2
==============

==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r4 := @caughtexception
$i1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int subtract(int)>(i0)
entermonitor $r2
==============

==============
 tn units (no order)
$i1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int multiply(int)>(i0)
$r4 := @caughtexception
exitmonitor r1
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
entermonitor $r2
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
==============

==============
 tn units (no order)
$r4 := @caughtexception
$i1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int divide(int)>(i0)
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
entermonitor $r2
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
==============

==============
 tn units (no order)
if r1 == null goto exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
entermonitor $r3
exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
virtualinvoke $r4.<java.lang.Object: void wait()>()
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: int value_>
if $i1 != i0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
$r5 := @caughtexception
exitmonitor r2
goto [?= $i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: int value_>]
==============

==============
 tn units (no order)
$r5 := @caughtexception
exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
goto [?= $i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: int value_>]
entermonitor $r3
if r1 == null goto exitmonitor r2
if $i1 == i0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: int value_>
interfaceinvoke r1.<java.lang.Runnable: void run()>()
exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
==============

==============
 tn units (no order)
exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: int value_>
entermonitor $r3
$r5 := @caughtexception
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
if r1 == null goto exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
exitmonitor r2
goto [?= $i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: int value_>]
if $i1 > i0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
==============

==============
 tn units (no order)
exitmonitor r2
goto [?= $i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: int value_>]
$r5 := @caughtexception
virtualinvoke $r4.<java.lang.Object: void wait()>()
entermonitor $r3
exitmonitor r2
if r1 == null goto exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
if $i1 >= i0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: int value_>
interfaceinvoke r1.<java.lang.Runnable: void run()>()
==============

==============
 tn units (no order)
exitmonitor r2
goto [?= $i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: int value_>]
entermonitor $r3
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: int value_>
interfaceinvoke r1.<java.lang.Runnable: void run()>()
if $i1 < i0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
virtualinvoke $r4.<java.lang.Object: void wait()>()
if r1 == null goto exitmonitor r2
exitmonitor r2
$r5 := @caughtexception
==============

==============
 tn units (no order)
goto [?= $i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: int value_>]
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
if $i1 <= i0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: java.lang.Object lock_>
if r1 == null goto exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt: int value_>
exitmonitor r2
$r5 := @caughtexception
exitmonitor r2
entermonitor $r3
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncCollection... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort... 
==============
 tn units (no order)
$r4 := @caughtexception
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
$s1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short set(short)>(s0)
exitmonitor r1
exitmonitor r1
entermonitor $r2
==============

==============
 tn units (no order)
$r4 := @caughtexception
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
z0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: boolean commit(short,short)>(s0, s1)
entermonitor $r2
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
if z0 == 0 goto exitmonitor r1
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
$r4 := @caughtexception
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
$s0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short increment()>()
exitmonitor r1
==============

==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor r1
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
$s0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short decrement()>()
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
entermonitor $r2
==============

==============
 tn units (no order)
exitmonitor r1
$s1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short add(short)>(s0)
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
$r4 := @caughtexception
exitmonitor r1
entermonitor $r2
==============

==============
 tn units (no order)
entermonitor $r2
$s1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short subtract(short)>(s0)
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
exitmonitor r1
$r4 := @caughtexception
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
==============

==============
 tn units (no order)
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
entermonitor $r2
$r4 := @caughtexception
exitmonitor r1
exitmonitor r1
$s1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short multiply(short)>(s0)
==============

==============
 tn units (no order)
exitmonitor r1
$s1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short divide(short)>(s0)
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
entermonitor $r2
$r4 := @caughtexception
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
exitmonitor r1
==============

==============
 tn units (no order)
$s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: short value_>
exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
virtualinvoke $r4.<java.lang.Object: void wait()>()
entermonitor $r3
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
goto [?= $s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: short value_>]
exitmonitor r2
if $s1 != s0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
if r1 == null goto exitmonitor r2
$r5 := @caughtexception
==============

==============
 tn units (no order)
interfaceinvoke r1.<java.lang.Runnable: void run()>()
exitmonitor r2
entermonitor $r3
virtualinvoke $r4.<java.lang.Object: void wait()>()
goto [?= $s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: short value_>]
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
$r5 := @caughtexception
if r1 == null goto exitmonitor r2
if $s1 == s0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
exitmonitor r2
$s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: short value_>
==============

==============
 tn units (no order)
$s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: short value_>
virtualinvoke $r4.<java.lang.Object: void wait()>()
$r5 := @caughtexception
exitmonitor r2
entermonitor $r3
exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
goto [?= $s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: short value_>]
if r1 == null goto exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
if $s1 > s0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
==============

==============
 tn units (no order)
$s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: short value_>
virtualinvoke $r4.<java.lang.Object: void wait()>()
goto [?= $s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: short value_>]
$r5 := @caughtexception
exitmonitor r2
if r1 == null goto exitmonitor r2
if $s1 >= s0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
interfaceinvoke r1.<java.lang.Runnable: void run()>()
exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
entermonitor $r3
==============

==============
 tn units (no order)
exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
$r5 := @caughtexception
goto [?= $s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: short value_>]
exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
if r1 == null goto exitmonitor r2
$s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: short value_>
entermonitor $r3
if $s1 < s0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
==============

==============
 tn units (no order)
$s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: short value_>
exitmonitor r2
if $s1 <= s0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
virtualinvoke $r4.<java.lang.Object: void wait()>()
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: java.lang.Object lock_>
goto [?= $s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort: short value_>]
entermonitor $r3
$r5 := @caughtexception
interfaceinvoke r1.<java.lang.Runnable: void run()>()
if r1 == null goto exitmonitor r2
exitmonitor r2
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList... 
==============
 tn units (no order)
return $r1
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
==============

==============
 tn units (no order)
i1 := @parameter2: int
i0 := @parameter1: int
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r1, i0, $r3, 0, i1)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
return
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = $r2
$r2 = newarray (java.lang.Object)[i1]
r1 := @parameter0: java.lang.Object[]
==============

==============
 tn units (no order)
return r2
i1 = lengthof $r4
goto [?= z0 = $z2]
i0 := @parameter0: int
if z0 != 0 goto return r2
r3[i0] = r1
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
r2 = $r5[i0]
r3 = newarray (java.lang.Object)[i1]
if r1 == null goto $z2 = 0
$z1 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>(r2)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r3
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
z0 = $z2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
$z2 = 1
if $z1 != 0 goto $z2 = 1
r1 := @parameter1: java.lang.Object
if r2 == r1 goto $z2 = 1
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: void rangeCheck(int,int)>(i0, i1)
$z2 = 0
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r6, 0, r3, 0, i1)
==============

==============
 tn units (no order)
r2[i0] = r1
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
$i1 = i0 + 1
return 1
r1 := @parameter0: java.lang.Object
i0 = lengthof $r3
r2 = newarray (java.lang.Object)[$i1]
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r4, 0, r2, 0, i0)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r2
==============

==============
 tn units (no order)
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
$i3 = i0 + 1
throw $r5
i0 := @parameter0: int
$r5 = new java.lang.IndexOutOfBoundsException
specialinvoke $r2.<java.lang.StringBuilder: void <init>(java.lang.String)>("Index: ")
i1 = lengthof $r4
return
r3[i0] = r1
$r6 = virtualinvoke $r2.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i0)
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r10, 0, r3, 0, i0)
if i0 > i1 goto $r5 = new java.lang.IndexOutOfBoundsException
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.String toString()>()
if i0 >= 0 goto $i2 = i1 + 1
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i1)
$r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
$i2 = i1 + 1
r3 = newarray (java.lang.Object)[$i2]
r1 := @parameter1: java.lang.Object
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r3
specialinvoke $r5.<java.lang.IndexOutOfBoundsException: void <init>(java.lang.String)>($r9)
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(", Size: ")
$r11 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
$i4 = i1 - i0
$r2 = new java.lang.StringBuilder
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r11, i0, r3, $i3, $i4)
==============

==============
 tn units (no order)
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: void rangeCheck(int,int)>(i0, i1)
$i3 = i1 - 1
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
return r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r2
i1 = lengthof $r3
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
r1 = $r4[i0]
r2 = newarray (java.lang.Object)[$i3]
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r5, 0, r2, 0, i0)
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r6, $i5, r2, i0, i2)
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
i2 = $i4 - 1
i0 := @parameter0: int
$i5 = i0 + 1
$i4 = i1 - i0
if i2 <= 0 goto r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r2
==============

==============
 tn units (no order)
if i2 < i1 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
if $z0 == 0 goto $r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
if $z1 == 0 goto return 0
i2 = i2 + 1
$r7 = $r6[i2]
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
if r1 == null goto return 0
if r1 == $r5 goto i3 = i2 + 1
goto [?= (branch)]
$r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
if r1 == $r13 goto r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r2
r2[$i4] = $r9
$r5 = $r4[i2]
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
i3 = i2 + 1
i1 = i0 - 1
$r15 = $r14[i1]
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
if i0 != 0 goto i1 = i0 - 1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
if i3 < i0 goto $i4 = i3 - 1
return 0
i3 = i3 + 1
i0 = lengthof $r3
$r14 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r7)
return 1
return 0
r2[i2] = $r11
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
goto [?= (branch)]
r2 = newarray (java.lang.Object)[i1]
return 1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r2
if r1 == null goto $r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
$r13 = $r12[i1]
$r12 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
$r11 = $r10[i2]
i2 = 0
$r9 = $r8[i3]
r1 := @parameter0: java.lang.Object
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r2
$z1 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r15)
$i4 = i3 - 1
==============

==============
 tn units (no order)
i3 = i2 - i1
$i5 = i1 - i0
specialinvoke $r3.<java.lang.IndexOutOfBoundsException: void <init>()>()
i2 = lengthof $r2
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r4, 0, r1, 0, i0)
return
throw $r3
i1 := @parameter1: int
r1 = newarray (java.lang.Object)[i4]
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r1
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r5, i1, r1, i0, i3)
if i0 >= i2 goto $r3 = new java.lang.IndexOutOfBoundsException
if i1 > i2 goto $r3 = new java.lang.IndexOutOfBoundsException
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
i0 := @parameter0: int
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
$r3 = new java.lang.IndexOutOfBoundsException
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
if i1 >= i0 goto i3 = i2 - i1
i4 = i2 - $i5
if i0 < 0 goto $r3 = new java.lang.IndexOutOfBoundsException
==============

==============
 tn units (no order)
r2[i1] = $r9
if r1 == null goto $r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
i1 = 0
return 1
i0 = lengthof $r3
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r7)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r2
r1 := @parameter0: java.lang.Object
goto [?= (branch)]
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
$i2 = i0 + 1
$r7 = $r6[i1]
r2 = newarray (java.lang.Object)[$i2]
if $z0 == 0 goto $r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
r2[i0] = r1
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
$r9 = $r8[i1]
$r5 = $r4[i1]
if r1 == $r5 goto return 0
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
if i1 < i0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
i1 = i1 + 1
return 0
==============

==============
 tn units (no order)
r5 = newarray (java.lang.Object)[i1]
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
if i2 < i0 goto r4 = r2[i2]
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r3, 0, r5, 0, i1)
if i1 != i0 goto r5 = newarray (java.lang.Object)[i1]
$i3 = i1
r4 = r2[i2]
r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
i2 = i2 + 1
return 0
r1 := @parameter0: java.util.Collection
if i0 != 0 goto r3 = newarray (java.lang.Object)[i0]
goto [?= (branch)]
i0 = lengthof r2
$z0 = interfaceinvoke r1.<java.util.Collection: boolean contains(java.lang.Object)>(r4)
return 1
r3[$i3] = r4
return 0
i1 = i1 + 1
i1 = 0
r3 = newarray (java.lang.Object)[i0]
if $z0 != 0 goto i2 = i2 + 1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r5
i2 = 0
==============

==============
 tn units (no order)
if i2 < i0 goto r4 = r2[i2]
i1 = 0
i2 = i2 + 1
r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
if i1 != i0 goto r5 = newarray (java.lang.Object)[i1]
goto [?= (branch)]
i1 = i1 + 1
if i0 != 0 goto r3 = newarray (java.lang.Object)[i0]
r4 = r2[i2]
r3 = newarray (java.lang.Object)[i0]
$i3 = i1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
$z0 = interfaceinvoke r1.<java.util.Collection: boolean contains(java.lang.Object)>(r4)
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r3, 0, r5, 0, i1)
i2 = 0
return 1
i0 = lengthof r2
if $z0 == 0 goto i2 = i2 + 1
r5 = newarray (java.lang.Object)[i1]
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r5
r1 := @parameter0: java.util.Collection
return 0
return 0
r3[$i3] = r4
==============

==============
 tn units (no order)
$z0 = interfaceinvoke r4.<java.util.Iterator: boolean hasNext()>()
r3 = newarray (java.lang.Object)[i0]
r3[$i5] = r5
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r3, 0, r6, i1, i2)
$i6 = i1 + i2
$i3 = staticinvoke <benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: int indexOf(java.lang.Object,java.lang.Object[],int)>(r5, r2, i1)
r1 := @parameter0: java.util.Collection
return 0
i2 = 0
if $i3 >= 0 goto $z0 = interfaceinvoke r4.<java.util.Iterator: boolean hasNext()>()
return 0
$i5 = i2
if $z0 != 0 goto r5 = interfaceinvoke r4.<java.util.Iterator: java.lang.Object next()>()
r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
if $i4 >= 0 goto $z0 = interfaceinvoke r4.<java.util.Iterator: boolean hasNext()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r6
r6 = newarray (java.lang.Object)[$i6]
r5 = interfaceinvoke r4.<java.util.Iterator: java.lang.Object next()>()
i2 = i2 + 1
r4 = interfaceinvoke r1.<java.util.Collection: java.util.Iterator iterator()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
if i0 != 0 goto r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
goto [?= $z0 = interfaceinvoke r4.<java.util.Iterator: boolean hasNext()>()]
$i4 = staticinvoke <benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: int indexOf(java.lang.Object,java.lang.Object[],int)>(r5, r3, i2)
return i2
i0 = interfaceinvoke r1.<java.util.Collection: int size()>()
if i2 != 0 goto $i6 = i1 + i2
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r2, 0, r6, 0, i1)
i1 = lengthof r2
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
return
$r1 = newarray (java.lang.Object)[0]
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = $r1
==============

==============
 tn units (no order)
i1 = lengthof $r4
$i4 = i1
i0 = interfaceinvoke r1.<java.util.Collection: int size()>()
r2[$i4] = $r6
if i0 != 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
goto [?= (branch)]
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
r3 = interfaceinvoke r1.<java.util.Collection: java.util.Iterator iterator()>()
r1 := @parameter0: java.util.Collection
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
return 0
return 1
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
i2 = i2 + 1
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r5, 0, r2, 0, i1)
i1 = i1 + 1
$i3 = i1 + i0
i2 = 0
if i2 < i0 goto $i4 = i1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r2
$r6 = interfaceinvoke r3.<java.util.Iterator: java.lang.Object next()>()
r2 = newarray (java.lang.Object)[$i3]
==============

==============
 tn units (no order)
i4 = i4 + 1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
r3[$i7] = $r13
r3 = newarray (java.lang.Object)[$i5]
if i0 > i1 goto $r6 = new java.lang.IndexOutOfBoundsException
goto [?= (branch)]
i1 = lengthof $r5
r1 := @parameter1: java.util.Collection
if i2 != 0 goto $i5 = i1 + i2
i2 = interfaceinvoke r1.<java.util.Collection: int size()>()
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(", Size: ")
$r10 = virtualinvoke $r9.<java.lang.StringBuilder: java.lang.String toString()>()
if i3 <= 0 goto r4 = interfaceinvoke r1.<java.util.Collection: java.util.Iterator iterator()>()
return 1
return 0
if i4 < i2 goto $i7 = i0
$r2 = new java.lang.StringBuilder
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r11, 0, r3, 0, i1)
i3 = i1 - i0
$r12 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r12, i0, r3, $i6, i3)
r4 = interfaceinvoke r1.<java.util.Collection: java.util.Iterator iterator()>()
specialinvoke $r6.<java.lang.IndexOutOfBoundsException: void <init>(java.lang.String)>($r10)
specialinvoke $r2.<java.lang.StringBuilder: void <init>(java.lang.String)>("Index: ")
$r11 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
i0 = i0 + 1
i4 = 0
throw $r6
if i0 >= 0 goto i2 = interfaceinvoke r1.<java.util.Collection: int size()>()
$i6 = i0 + i2
i0 := @parameter0: int
$r13 = interfaceinvoke r4.<java.util.Iterator: java.lang.Object next()>()
$r6 = new java.lang.IndexOutOfBoundsException
$i5 = i1 + i2
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r3
$r7 = virtualinvoke $r2.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i0)
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i1)
$i7 = i0
==============

==============
 tn units (no order)
r2[i1] = $r3
i1 = i1 + 1
$i2 = lengthof r2
return
goto [?= $i2 = lengthof r2]
r1 := @parameter0: java.io.ObjectInputStream
$r3 = virtualinvoke r1.<java.io.ObjectInputStream: java.lang.Object readObject()>()
virtualinvoke r1.<java.io.ObjectInputStream: void defaultReadObject()>()
i1 = 0
if i1 < $i2 goto $r3 = virtualinvoke r1.<java.io.ObjectInputStream: java.lang.Object readObject()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
i0 = virtualinvoke r1.<java.io.ObjectInputStream: int readInt()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_> = r2
r2 = newarray (java.lang.Object)[i0]
==============

==============
 tn units (no order)
return $r3
if i0 < 0 goto $r2 = new java.lang.IndexOutOfBoundsException
specialinvoke $r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: void <init>(benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList,int,int)>(r0, i0, i1)
$r3 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList
i1 := @parameter1: int
specialinvoke $r2.<java.lang.IndexOutOfBoundsException: void <init>()>()
$r2 = new java.lang.IndexOutOfBoundsException
throw $r2
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList
if i0 <= i1 goto $r3 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList
if i1 > i2 goto $r2 = new java.lang.IndexOutOfBoundsException
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
i2 = lengthof $r1
i0 := @parameter0: int
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedVariable... 
==============
 tn units (no order)
exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
exitmonitor r2
$r5 := @caughtexception
entermonitor $r4
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.BrokenBarrierException... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Executor... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.ReadWriteLock... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock... 
==============
 tn units (no order)
return 1
return 0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long writeHolds_> = $l5
$r1 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long writeHolds_>
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: java.lang.Thread activeWriter_>
return 0
$b3 = $l2 cmp 0L
if $b1 != 0 goto $r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: java.lang.Thread activeWriter_>
if $r2 != $r3 goto return 0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: java.lang.Thread activeWriter_> = $r1
$r3 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
if $b3 != 0 goto return 0
return 1
$l2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long activeReaders_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long writeHolds_> = 1L
$b1 = $l0 cmp 0L
$l4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long writeHolds_>
$l5 = $l4 + 1L
==============

==============
 tn units (no order)
if $b5 != 0 goto return null
$l1 = $l0 - 1L
return $r2
$b3 = $l2 cmp 0L
$l6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long waitingWriters_>
$b7 = $l6 cmp 0L
if $b3 <= 0 goto $l4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long activeReaders_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long activeReaders_> = $l1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long activeReaders_>
if $b7 <= 0 goto return null
$l2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long writeHolds_>
return null
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock writerLock_>
$l4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long activeReaders_>
return null
$b5 = $l4 cmp 0L
==============

==============
 tn units (no order)
if $b5 <= 0 goto $l6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long waitingWriters_>
return null
if $b3 <= 0 goto r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: java.lang.Thread activeWriter_> = null
$b7 = $l6 cmp 0L
return $r2
$l1 = $l0 - 1L
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long writeHolds_> = $l1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: java.lang.Thread activeWriter_> = null
return $r3
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long writeHolds_>
$b3 = $l2 cmp 0L
$z0 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: boolean allowReader()>()
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock readerLock_>
$l4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long waitingReaders_>
$l2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long writeHolds_>
$b5 = $l4 cmp 0L
$l6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long waitingWriters_>
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock writerLock_>
if $b7 <= 0 goto return null
if $z0 == 0 goto $l6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock: long waitingWriters_>
return null
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeoutException... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous$RendezvousFunction... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedPriorityQueue... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue... 
==============
 tn units (no order)
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node tail_>
$r11 := @caughtexception
exitmonitor r4
$r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node tail_>
r5 = $r9.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node next>
entermonitor $r8
exitmonitor r4
l0 = $r10.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: long count>
==============

==============
 tn units (no order)
r13 = r5.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node next>
$r14 := @caughtexception
exitmonitor r6
entermonitor r5
exitmonitor r6
l1 = r5.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: long count>
==============

==============
 tn units (no order)
l0 = $r8.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: long count>
exitmonitor r1
r2 = $r7.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node next>
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node head_>
entermonitor $r6
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node head_>
exitmonitor r1
$r9 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r3
entermonitor $r10
$r13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node tail_>
exitmonitor r3
$r14 := @caughtexception
l1 = $r13.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: long count>
$r11 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node tail_>
r12 = $r11.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node next>
==============

==============
 tn units (no order)
entermonitor $r4
l0 = $r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: long count>
r2 = $r5.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node next>
$r7 := @caughtexception
exitmonitor r1
exitmonitor r1
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node head_>
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node head_>
==============

==============
 tn units (no order)
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node tail_>
exitmonitor r3
exitmonitor r3
l1 = $r11.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: long count>
$r11 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node tail_>
r10 = $r9.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node next>
$r12 := @caughtexception
entermonitor $r8
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Slot... 
==============
 tn units (no order)
r1 := @parameter0: java.lang.Object
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Slot
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Slot: java.lang.Object item_> = r1
return
==============

==============
 tn units (no order)
return r1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Slot
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Slot: java.lang.Object item_> = null
r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Slot: java.lang.Object item_>
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Slot
return $r1
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Slot: java.lang.Object item_>
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean... 
==============
 tn units (no order)
$r3 := @caughtexception
$z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_>
exitmonitor r1
exitmonitor r1
entermonitor $r2
==============

==============
 tn units (no order)
exitmonitor r1
$r3 := @caughtexception
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_> = z0
z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_>
entermonitor $r2
==============

==============
 tn units (no order)
goto [?= z2 = $z4]
if z2 == 0 goto exitmonitor r1
entermonitor $r2
$r3 := @caughtexception
$z4 = 1
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_> = z1
z2 = $z4
exitmonitor r1
$z4 = 0
if z0 != $z3 goto $z4 = 0
$z3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_>
==============

==============
 tn units (no order)
$z4 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean get()>()
exitmonitor r5
$r9 := @caughtexception
exitmonitor r5
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean set(boolean)>($z2)
$r8 := @caughtexception
exitmonitor r4
$r7 = r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: java.lang.Object lock_>
$z1 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean get()>()
$z2 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean set(boolean)>($z1)
exitmonitor r4
entermonitor $r6
throw $r8
entermonitor $r7
==============

==============
 tn units (no order)
$z4 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean get()>()
exitmonitor r5
$z1 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean get()>()
$z2 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean set(boolean)>($z1)
exitmonitor r5
entermonitor $r7
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean set(boolean)>($z2)
$r8 := @caughtexception
==============

==============
 tn units (no order)
$z1 = 1
$z2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_> = $z1
exitmonitor r1
if $z0 == 0 goto $z1 = 1
$z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_>
exitmonitor r1
$z1 = 0
entermonitor $r2
$r4 := @caughtexception
goto [?= r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_> = $z1]
==============

==============
 tn units (no order)
$z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_>
exitmonitor r1
$z2 = $z1 & z0
$r4 := @caughtexception
exitmonitor r1
$z3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_> = $z2
entermonitor $r2
==============

==============
 tn units (no order)
entermonitor $r2
$z3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_> = $z2
$z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_>
exitmonitor r1
$z2 = $z1 | z0
$r4 := @caughtexception
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r1
$r4 := @caughtexception
$z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_>
exitmonitor r1
$z2 = $z1 ^ z0
$z3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_>
entermonitor $r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean value_> = $z2
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SemaphoreControlledChannel... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult$1... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.DefaultChannelCapacity... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.CondVar... 
==============
 tn units (no order)
r2 = $r8
$r9 := @caughtexception
throw r2
exitmonitor r1
interfaceinvoke $r7.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Sync: void release()>()
exitmonitor r1
virtualinvoke r0.<java.lang.Object: void wait()>()
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CondVar: benchmarks.EDU.oswego.cs.dl.util.concurrent.Sync mutex_>
$r8 := @caughtexception
entermonitor r0
virtualinvoke r0.<java.lang.Object: void notify()>()
goto [?= exitmonitor r1]
==============

==============
 tn units (no order)
throw r8
$r9 := @caughtexception
z1 = $z3
exitmonitor r1
if $b2 <= 0 goto exitmonitor r1
$l3 = staticinvoke <java.lang.System: long currentTimeMillis()>()
virtualinvoke r0.<java.lang.Object: void notify()>()
virtualinvoke r0.<java.lang.Object: void wait(long)>(l0)
$l4 = $l3 - l1
r8 = $r7
$b2 = l0 cmp 0L
if $b5 > 0 goto $z3 = 0
$z3 = 1
interfaceinvoke $r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Sync: void release()>()
$b5 = $l4 cmp l0
goto [?= z1 = $z3]
entermonitor r0
$r7 := @caughtexception
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CondVar: benchmarks.EDU.oswego.cs.dl.util.concurrent.Sync mutex_>
l1 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$z3 = 0
goto [?= exitmonitor r1]
exitmonitor r1
==============

==============
 tn units (no order)
virtualinvoke r0.<java.lang.Object: void notify()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CondVar
return
==============

==============
 tn units (no order)
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CondVar
return
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.ReaderPreferenceReadWriteLock... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync... 
==============
 tn units (no order)
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync: int readers_>
virtualinvoke $r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOSemaphore: void acquire()>()
return
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync: int readers_>
if $i0 != 0 goto $i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync: int readers_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync: int readers_> = $i2
$i2 = $i1 + 1
$r2 = $r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOSemaphore active_>
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync: benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock this$0>
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync
return z0
$z2 = 1
if $z1 != 0 goto $z2 = 1
$z2 = 0
$i3 = $i2 + 1
$i2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync: int readers_>
z0 = $z2
$r2 = $r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOSemaphore active_>
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync: benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock this$0>
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync: int readers_>
if z0 == 0 goto return z0
if $i1 > 0 goto $z2 = 1
$z1 = virtualinvoke $r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOSemaphore: boolean attempt(long)>(l0)
l0 := @parameter0: long
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync: int readers_> = $i3
goto [?= z0 = $z2]
==============

==============
 tn units (no order)
if $i1 != 0 goto return
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync
return
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync: benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock this$0>
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync: int readers_>
virtualinvoke $r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOSemaphore: void release()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync: int readers_> = $i1
$r3 = $r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOSemaphore active_>
$i1 = $i0 - 1
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble... 
==============
 tn units (no order)
entermonitor $r2
$r3 := @caughtexception
exitmonitor r1
$d0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_>
exitmonitor r1
==============

==============
 tn units (no order)
d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_>
entermonitor $r2
$r3 := @caughtexception
exitmonitor r1
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_> = d0
==============

==============
 tn units (no order)
$d2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_>
exitmonitor r1
$z1 = 0
goto [?= z0 = $z1]
$b0 = d0 cmpl $d2
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_> = d1
$z1 = 1
if $b0 != 0 goto $z1 = 0
z0 = $z1
if z0 == 0 goto exitmonitor r1
$r3 := @caughtexception
entermonitor $r2
==============

==============
 tn units (no order)
entermonitor $r6
$r8 := @caughtexception
entermonitor $r7
exitmonitor r5
$d2 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double set(double)>($d1)
$d1 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double get()>()
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double set(double)>($d2)
throw $r9
$r9 := @caughtexception
exitmonitor r4
exitmonitor r4
$r7 = r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: java.lang.Object lock_>
$d4 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double get()>()
exitmonitor r5
throw $r8
==============

==============
 tn units (no order)
exitmonitor r4
$r8 := @caughtexception
exitmonitor r5
entermonitor $r7
$d2 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double set(double)>($d1)
$d4 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double get()>()
exitmonitor r5
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double set(double)>($d2)
$d1 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double get()>()
$r9 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r1
$d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_>
exitmonitor r1
$d2 = $d1 + d0
$r4 := @caughtexception
entermonitor $r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_> = $d2
==============

==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_> = $d2
$d2 = $d1 - d0
exitmonitor r1
$d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_>
entermonitor $r2
==============

==============
 tn units (no order)
throw $r4
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble
return $d2
entermonitor $r2
$r4 := @caughtexception
$d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_>
exitmonitor r1
d0 := @parameter0: double
$d2 = $d1 * d0
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: java.lang.Object lock_>
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_> = $d2
==============

==============
 tn units (no order)
entermonitor $r2
$r4 := @caughtexception
$d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_>
exitmonitor r1
$d2 = $d1 * d0
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_> = $d2
==============

==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor r1
exitmonitor r1
$d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_>
entermonitor $r2
$d2 = $d1 / d0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double value_> = $d2
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat... 
==============
 tn units (no order)
entermonitor $r2
exitmonitor r1
$f1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float set(float)>(f0)
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
$r4 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
$r4 := @caughtexception
if z0 == 0 goto exitmonitor r1
z0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: boolean commit(float,float)>(f0, f1)
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
entermonitor $r2
==============

==============
 tn units (no order)
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
entermonitor $r2
$f1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float add(float)>(f0)
$r4 := @caughtexception
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
exitmonitor r1
==============

==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
exitmonitor r1
entermonitor $r2
$f1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float subtract(float)>(f0)
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
==============

==============
 tn units (no order)
entermonitor $r2
$r4 := @caughtexception
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
$f1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float multiply(float)>(f0)
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
$r4 := @caughtexception
$f1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float divide(float)>(f0)
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
entermonitor $r2
==============

==============
 tn units (no order)
entermonitor $r3
if r1 == null goto exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
exitmonitor r2
if $b0 != 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
$r5 := @caughtexception
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: float value_>
goto [?= $f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: float value_>]
$b0 = $f1 cmpl f0
exitmonitor r2
==============

==============
 tn units (no order)
if r1 == null goto exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
exitmonitor r2
exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
$f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: float value_>
$b0 = $f1 cmpl f0
entermonitor $r3
interfaceinvoke r1.<java.lang.Runnable: void run()>()
if $b0 == 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
goto [?= $f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: float value_>]
$r5 := @caughtexception
==============

==============
 tn units (no order)
if $b0 > 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
$f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: float value_>
exitmonitor r2
exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
virtualinvoke $r4.<java.lang.Object: void wait()>()
entermonitor $r3
$r5 := @caughtexception
if r1 == null goto exitmonitor r2
goto [?= $f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: float value_>]
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
$b0 = $f1 cmpg f0
==============

==============
 tn units (no order)
$r5 := @caughtexception
exitmonitor r2
goto [?= $f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: float value_>]
if r1 == null goto exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
exitmonitor r2
if $b0 >= 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
virtualinvoke $r4.<java.lang.Object: void wait()>()
$f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: float value_>
$b0 = $f1 cmpg f0
interfaceinvoke r1.<java.lang.Runnable: void run()>()
entermonitor $r3
==============

==============
 tn units (no order)
$f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: float value_>
goto [?= $f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: float value_>]
entermonitor $r3
exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
$r5 := @caughtexception
exitmonitor r2
if $b0 < 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
if r1 == null goto exitmonitor r2
$b0 = $f1 cmpl f0
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
interfaceinvoke r1.<java.lang.Runnable: void run()>()
==============

==============
 tn units (no order)
exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
$f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: float value_>
goto [?= $f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: float value_>]
$r5 := @caughtexception
interfaceinvoke r1.<java.lang.Runnable: void run()>()
if $b0 <= 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat: java.lang.Object lock_>
if r1 == null goto exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
exitmonitor r2
$b0 = $f1 cmpl f0
entermonitor $r3
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncMap... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon... 
==============
 tn units (no order)
return $r1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon: java.lang.Thread thread_>
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon: java.lang.Thread thread_> = null
return
==============

==============
 tn units (no order)
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon: java.lang.Thread thread_>
virtualinvoke r0.<java.lang.Object: void notify()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$RunLoop runLoop_>
goto [?= return]
$r4 = interfaceinvoke $r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory: java.lang.Thread newThread(java.lang.Runnable)>($r3)
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory threadFactory_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon: java.lang.Thread thread_> = $r4
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon: java.lang.Thread thread_>
virtualinvoke $r5.<java.lang.Thread: void start()>()
return
if $r1 != null goto virtualinvoke r0.<java.lang.Object: void notify()>()
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon: java.lang.Thread thread_>
virtualinvoke $r3.<java.lang.Thread: void interrupt()>()
return
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon: java.lang.Thread thread_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap heap_>
if $r2 == null goto return
virtualinvoke $r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: void clear()>()
==============

==============
 tn units (no order)
l0 = -1L
if $z0 == 0 goto l0 = 0L
return null
$r5 = virtualinvoke $r4.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object extract()>()
if $b3 <= 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap heap_>
goto [?= $b8 = l0 cmp 0L]
$l6 = r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode: long period>
if r1 == null goto $b8 = l0 cmp 0L
r6 = (benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode) $r5
l1 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$z0 = staticinvoke <java.lang.Thread: boolean interrupted()>()
goto [?= $b8 = l0 cmp 0L]
r1 = (benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode) $r3
l0 = l2 - l1
$b5 = $l4 cmp 0L
$z1 = virtualinvoke r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode: boolean getCancelled()>()
if $b5 <= 0 goto return r6
$r3 = virtualinvoke $r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object peek()>()
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap heap_>
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap heap_>
$l7 = l1 + $l6
if $z1 == 0 goto $l4 = r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode: long period>
virtualinvoke $r7.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: void insert(java.lang.Object)>(r6)
virtualinvoke r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode: void setTimeToRun(long)>($l7)
l2 = virtualinvoke r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode: long getTimeToRun()>()
if r6 == null goto $b8 = l0 cmp 0L
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap heap_>
r10 = $r9
virtualinvoke r0.<java.lang.Object: void wait(long)>(l0)
$r9 := @caughtexception
$l4 = r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode: long period>
if $b8 < 0 goto $z0 = staticinvoke <java.lang.Thread: boolean interrupted()>()
return null
return r6
goto [?= $z0 = staticinvoke <java.lang.Thread: boolean interrupted()>()]
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon
$b8 = l0 cmp 0L
l0 = 0L
$b3 = l2 cmp l1
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor... 
==============
 tn units (no order)
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor: java.lang.Thread thread_>
return $r1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor
==============

==============
 tn units (no order)
return
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor: java.lang.Thread thread_> = null
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor: java.lang.Thread thread_>
$r4 = interfaceinvoke $r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory: java.lang.Thread newThread(java.lang.Runnable)>($r3)
if $r1 != null goto return
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor$RunLoop runLoop_>
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor: java.lang.Thread thread_>
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor: benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory threadFactory_>
return
virtualinvoke $r5.<java.lang.Thread: void start()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor: java.lang.Thread thread_> = $r4
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode... 
==============
 tn units (no order)
return
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode: boolean cancelled_> = 1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode
==============

==============
 tn units (no order)
return $z0
$z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode: boolean cancelled_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode
==============

==============
 tn units (no order)
l0 := @parameter0: long
return
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode: long timeToRun_> = l0
==============

==============
 tn units (no order)
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode: long timeToRun_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode
return $l0
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask$Seq2... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous... 
==============
 tn units (no order)
r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous$RendezvousFunction rendezvousFunction_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous
r1 := @parameter0: benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous$RendezvousFunction
return r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous$RendezvousFunction rendezvousFunction_> = r1
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous
return $z0
$z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: boolean broken_>
==============

==============
 tn units (no order)
entermonitor r0
exitmonitor r2
exitmonitor r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: boolean broken_> = 0
goto [?= exitmonitor r2]
if $i0 == 0 goto r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: boolean broken_> = 0
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: int entries_>
$r3 := @caughtexception
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
exitmonitor r2
==============

==============
 tn units (no order)
$r11[i2] = r1
$z2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: boolean broken_>
r27 = $r26[i2]
exitmonitor r2
if i31 < $i32 goto $r29 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: int entries_> = 0
if i3 < $i25 goto $r23 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>
$l28 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: long departures_>
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: boolean broken_> = 1
$i25 = lengthof $r24
entermonitor r0
$b13 = l10 cmp 0L
$l16 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: long departures_>
$r14 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>
$r32 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.BrokenBarrierException
i31 = 0
throw r5
$i7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: int parties_>
throw r4
if $b24 > 0 goto throw r5
$z4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: boolean broken_>
goto [?= $r24 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>]
$r30 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>
$l20 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: long departures_>
$b30 = $l29 cmp 0L
$r24 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>
if z0 == 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l10)
$r26 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>
$r12 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous$RendezvousFunction rendezvousFunction_>
if $b30 > 0 goto $z5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: boolean broken_>
r5 = $r19
if $r12 == null goto $r26 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>
specialinvoke $r32.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BrokenBarrierException: void <init>(int)>(i2)
$z5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: boolean broken_>
i3 = i3 + 1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: long departures_> = $l23
$i5 = $i4 + 1
$r15 := @caughtexception
$l15 = (long) $i14
$l34 = (long) $i33
goto [?= $r26 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>]
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: long departures_> = $l9
goto [?= $r26 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>]
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: boolean broken_> = 1
if $b13 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l10)
$b24 = $l23 cmp 0L
$l22 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: long departures_>
if $z5 == 0 goto exitmonitor r2
$r25 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore entryGate_>
throw $r16
$i26 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: int entries_>
$l19 = (long) $i18
$r31 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore entryGate_>
$i32 = lengthof $r30
$i18 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: int entries_>
virtualinvoke $r25.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: void release(long)>($l27)
throw $r32
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
$r23 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>
$r20 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>
r4 = $r17
$r29 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>
$r13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous$RendezvousFunction rendezvousFunction_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: long departures_> = $l19
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: long departures_> = $l29
$l12 = $l11 - l1
$r18 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
$i33 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: int entries_>
n0 = null
virtualinvoke $r18.<java.lang.Thread: void interrupt()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: boolean broken_> = 1
$i8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: int entries_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: long departures_> = $l15
if $z2 != 0 goto $r26 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>
$l9 = (long) $i8
l10 = l0 - $l12
if $z4 != 0 goto $r26 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>
$i14 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: int entries_>
if $i6 != $i7 goto $z4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: boolean broken_>
goto [?= $r26 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>]
$r23[i3] = null
$b17 = $l16 cmp 0L
$z3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: boolean broken_>
virtualinvoke $r31.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: void release(long)>($l34)
if $b17 <= 0 goto r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: boolean broken_> = 1
if $b21 < 0 goto l10 = 0L
goto [?= $r26 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>]
$r29[i31] = null
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
exitmonitor r2
$i6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: int entries_>
$l29 = $l28 - 1L
$l23 = $l22 - 1L
$r17 := @caughtexception
i2 = $i4
if $z3 != 0 goto $r18 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
$i4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: int entries_>
goto [?= $z4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: boolean broken_>]
i3 = 0
$r11 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>
$l27 = (long) $i26
i31 = i31 + 1
specialinvoke $r16.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeoutException: void <init>(long)>(l0)
r21 = $r20[i2]
$r16 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeoutException
$b21 = $l20 cmp 1L
$l11 = staticinvoke <java.lang.System: long currentTimeMillis()>()
goto [?= $r30 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: java.lang.Object[] slots_>]
interfaceinvoke $r13.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous$RendezvousFunction: void rendezvousFunction(java.lang.Object[])>($r14)
l10 = 0L
$r19 := @caughtexception
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: int entries_> = 0
$r34 := @caughtexception
virtualinvoke r0.<java.lang.Object: void wait(long)>(l10)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous: int entries_> = $i5
r3 = $r15
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.TimedCallable... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Barrier... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWIterator... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncSortedMap... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node... 
==============
 tn units (no order)
r1 := @parameter0: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node next>
if $b2 != 0 goto return 0
l0 := @parameter1: long
return 1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node
if r1 != $r2 goto return 0
return 0
$b2 = l0 cmp $l1
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: long count>
==============

==============
 tn units (no order)
return z0
l0 := @parameter1: long
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node next>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: long count> = l1
z0 = $z1
l1 := @parameter3: long
$l2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: long count>
r1 := @parameter0: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node
$z1 = 0
r2 := @parameter2: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node
if z0 == 0 goto return z0
$b3 = $l2 cmp l0
$z1 = 1
if $b3 != 0 goto $z1 = 0
goto [?= z0 = $z1]
if $r3 != r1 goto $z1 = 0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node next> = r2
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef... 
==============
 tn units (no order)
$r5 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object set(java.lang.Object)>(r1)
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object lock_>
exitmonitor r2
entermonitor $r3
exitmonitor r2
$r6 := @caughtexception
virtualinvoke $r4.<java.lang.Object: void notifyAll()>()
==============

==============
 tn units (no order)
exitmonitor r3
$r6 := @caughtexception
exitmonitor r3
entermonitor $r4
if z0 == 0 goto exitmonitor r3
z0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: boolean commit(java.lang.Object,java.lang.Object)>(r1, r2)
virtualinvoke $r5.<java.lang.Object: void notifyAll()>()
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object lock_>
==============

==============
 tn units (no order)
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object value_>
$r6 := @caughtexception
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object lock_>
entermonitor $r3
goto [?= $r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object value_>]
exitmonitor r2
if r1 == null goto exitmonitor r2
exitmonitor r2
if $r5 != null goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object lock_>
virtualinvoke $r4.<java.lang.Object: void wait()>()
==============

==============
 tn units (no order)
exitmonitor r2
entermonitor $r3
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object value_>
if r1 == null goto exitmonitor r2
$r6 := @caughtexception
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object lock_>
goto [?= $r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object value_>]
if $r5 == null goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object lock_>
exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
virtualinvoke $r4.<java.lang.Object: void wait()>()
==============

==============
 tn units (no order)
if $r6 != r1 goto $r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object lock_>
if r2 == null goto exitmonitor r3
entermonitor $r4
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object lock_>
exitmonitor r3
virtualinvoke $r5.<java.lang.Object: void wait()>()
exitmonitor r3
interfaceinvoke r2.<java.lang.Runnable: void run()>()
$r7 := @caughtexception
goto [?= $r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object value_>]
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object value_>
==============

==============
 tn units (no order)
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object value_>
$r7 := @caughtexception
interfaceinvoke r2.<java.lang.Runnable: void run()>()
virtualinvoke $r5.<java.lang.Object: void wait()>()
goto [?= $r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object value_>]
entermonitor $r4
exitmonitor r3
if r2 == null goto exitmonitor r3
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object lock_>
if $r6 == r1 goto $r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef: java.lang.Object lock_>
exitmonitor r3
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode... 
==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode: boolean waiting> = 0
z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode: boolean waiting>
if z0 == 0 goto return z0
virtualinvoke r0.<java.lang.Object: void notify()>()
return z0
==============

==============
 tn units (no order)
r1 := @parameter0: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore
$r3 := @caughtexception
$z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode: boolean waiting>
$r4 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
if $b3 > 0 goto l1 = l0
return 0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode: boolean waiting> = 0
if $z1 != 0 goto $b3 = l0 cmp 0L
return 1
virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
return 1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode: boolean waiting> = 0
return 1
virtualinvoke $r4.<java.lang.Thread: void interrupt()>()
l1 = l0 - $l5
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode: boolean waiting> = 0
if $z3 == 0 goto $r4 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
l0 := @parameter1: long
$l5 = $l4 - l2
r2 = $r3
l1 = l0
throw r2
l2 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$z2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode: boolean waiting>
$b6 = l1 cmp 0L
if $z2 != 0 goto $l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$z3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode: boolean waiting>
if $z0 != 0 goto return 1
$z0 = virtualinvoke r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore: boolean recheck(benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode)>(r0)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode
$b3 = l0 cmp 0L
if $b6 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
return 0
==============

==============
 tn units (no order)
r2 = $r3
$r3 := @caughtexception
return
throw r2
$z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode: boolean waiting>
r1 := @parameter0: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore
virtualinvoke r0.<java.lang.Object: void wait()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode
if $z1 != 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
goto [?= $z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode: boolean waiting>]
return
$z0 = virtualinvoke r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore: boolean recheck(benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode)>(r0)
if $z2 == 0 goto $r4 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode: boolean waiting> = 0
$z2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode: boolean waiting>
virtualinvoke $r4.<java.lang.Thread: void interrupt()>()
if $z0 != 0 goto return
$r4 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
goto [?= return]
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$BlockedExecutionHandler... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock... 
==============
 tn units (no order)
exitmonitor r2
goto [?= exitmonitor r2]
if $r8 != null goto virtualinvoke r0.<java.lang.Object: void wait()>()
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_>
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_> = r1
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_>
virtualinvoke r0.<java.lang.Object: void notify()>()
exitmonitor r2
$l1 = $l0 + 1L
if r1 != $r6 goto $r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_> = $l1
virtualinvoke r0.<java.lang.Object: void wait()>()
throw r3
$r9 := @caughtexception
entermonitor r0
goto [?= exitmonitor r2]
r3 = $r9
$r10 := @caughtexception
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_> = 1L
==============

==============
 tn units (no order)
exitmonitor r2
if r1 != $r9 goto $r11 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_>
$l6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_>
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_>
$l8 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_>
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_>
exitmonitor r2
$b5 = l0 cmp 0L
$b10 = l1 cmp 0L
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_> = 1L
if $r11 != null goto $l8 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$r11 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_> = r1
exitmonitor r2
entermonitor r0
throw r3
$r12 := @caughtexception
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_> = $l4
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_> = $l7
$l7 = $l6 + 1L
exitmonitor r2
if $r8 != null goto $b5 = l0 cmp 0L
virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
exitmonitor r2
if r1 != $r6 goto $r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_>
exitmonitor r2
l2 = staticinvoke <java.lang.System: long currentTimeMillis()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_> = r1
l1 = l0 - $l9
$l3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_> = 1L
$r13 := @caughtexception
$l9 = $l8 - l2
exitmonitor r2
if $b10 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
$l4 = $l3 + 1L
virtualinvoke r0.<java.lang.Object: void notify()>()
l1 = l0
if $b5 > 0 goto l1 = l0
r3 = $r12
==============

==============
 tn units (no order)
$l1 = $l0 - 1L
return
if $r1 == $r2 goto $l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_>
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_>
throw $r3
virtualinvoke r0.<java.lang.Object: void notify()>()
$r1 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_> = null
if $b2 != 0 goto return
specialinvoke $r3.<java.lang.Error: void <init>(java.lang.String)>("Illegal Lock usage")
$b2 = $l1 cmp 0L
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_> = $l1
$r3 = new java.lang.Error
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_> = null
if $r1 != $r2 goto $r3 = new java.lang.Error
$l3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_>
return
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_> = $l4
$r3 = new java.lang.Error
$l4 = $l3 - l0
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_>
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock
throw $r3
$r1 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
l0 := @parameter0: long
$b6 = $l5 cmp 0L
specialinvoke $r3.<java.lang.Error: void <init>(java.lang.String)>("Illegal Lock usage")
$l5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_>
if $b6 != 0 goto return
if $b2 <= 0 goto $l3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_>
$b2 = l0 cmp $l1
virtualinvoke r0.<java.lang.Object: void notify()>()
==============

==============
 tn units (no order)
return $l0
$r1 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock
if $r1 == $r2 goto $l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_>
return 0L
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: java.lang.Thread owner_>
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock: long holds_>
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup... 
==============
 tn units (no order)
$z0 = r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: boolean active>
virtualinvoke r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: void setScanPriority(int)>(i0)
i1 = i1 + 1
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner[] threads>
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner[] threads>
virtualinvoke r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: void setPriority(int)>(i0)
if i1 < $i2 goto $r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner[] threads>
r1 = $r2[i1]
return
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup
$i2 = lengthof $r3
i0 := @parameter0: int
goto [?= $r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner[] threads>]
if $z0 != 0 goto i1 = i1 + 1
i1 = 0
==============

==============
 tn units (no order)
goto [?= $r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner[] threads>]
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner[] threads>
virtualinvoke r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: void setPriority(int)>(i0)
if $z0 == 0 goto i1 = i1 + 1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner[] threads>
i1 = 0
r1 = $r2[i1]
virtualinvoke r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: void setRunPriority(int)>(i0)
if i1 < $i2 goto $r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner[] threads>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup
i1 = i1 + 1
$i2 = lengthof $r3
$z0 = r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: boolean active>
i0 := @parameter0: int
return
==============

==============
 tn units (no order)
return $i0
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: int activeCount>
==============

==============
 tn units (no order)
$z0 = r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: boolean active>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup
return $z0
r1 := @parameter0: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup
$z0 = r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: boolean active>
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: int activeCount>
r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: boolean active> = 1
$i3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: int nstarted>
$i5 = $i0 + 1
r1 := @parameter0: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: int nstarted> = $i5
goto [?= return]
$i2 = $i1 + 1
return
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: int nstarted>
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner[] threads>
$i4 = lengthof $r3
$r6 = $r4[$i0]
if $i3 >= $i4 goto virtualinvoke r0.<java.lang.Object: void notifyAll()>()
if $z0 != 0 goto return
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: int activeCount> = $i2
virtualinvoke $r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: void start()>()
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner[] threads>
==============

==============
 tn units (no order)
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: int activeCount>
return
r1 := @parameter0: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup
r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: boolean active> = 0
$z0 = r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: boolean active>
$i1 = $i0 - 1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: int activeCount> = $i1
if $z0 == 0 goto return
==============

==============
 tn units (no order)
virtualinvoke $r6.<java.lang.Thread: void interrupt()>()
virtualinvoke r0.<java.lang.Object: void notify()>()
l0 := @parameter1: long
$b6 = 0
virtualinvoke r0.<java.lang.Object: void wait()>()
$r6 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
if $b4 <= 0 goto $b5 = l1 cmp 0L
$r4 := @caughtexception
$b5 = l1 cmp 0L
$b4 = l1 cmp 100L
r1 := @parameter0: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner
$i3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: int activeCount>
if $r3 != null goto l1 = l0 / 15L
$b6 = 1
if $i3 != 0 goto l1 = l0 / 15L
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: void setInactive(benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner)>(r1)
goto [?= return]
$r3 = virtualinvoke $r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: java.lang.Object peek()>()
goto [?= return]
l1 = 100L
r5 = $r4
return
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue entryQueue>
if $b5 != 0 goto $b6 = 0
virtualinvoke r0.<java.lang.Object: void wait(long,int)>(l1, b2)
goto [?= b2 = $b6]
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup
l1 = l0 / 15L
b2 = $b6
==============

==============
 tn units (no order)
goto [?= return]
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: int entries>
virtualinvoke r0.<java.lang.Object: void notify()>()
$i3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: int nstarted>
$i2 = $i1 + 1
virtualinvoke $r5.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: void start()>()
$i4 = lengthof $r2
return
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: int entries> = $i2
if $i3 >= $i4 goto virtualinvoke r0.<java.lang.Object: void notify()>()
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner[] threads>
$r5 = $r3[$i0]
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner[] threads>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: int nstarted> = $i5
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup: int nstarted>
$i5 = $i0 + 1
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode... 
==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode: boolean cancelled_> = 1
return
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode
==============

==============
 tn units (no order)
return $z0
$z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode: boolean cancelled_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode
==============

==============
 tn units (no order)
l0 := @parameter0: long
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode: long timeToRun_> = l0
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode
return
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode: long timeToRun_>
return $l0
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList... 
==============
 tn units (no order)
exitmonitor r2
exitmonitor r2
r3 = virtualinvoke $r5.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object set(int,java.lang.Object)>($i2, r1)
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: void checkForComodification()>()
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList l>
entermonitor $r4
$r9 := @caughtexception
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList l>
$i2 = i0 + $i1
$r7 = $r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: java.lang.Object[] expectedArray> = $r7
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int offset>
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: void rangeCheck(int)>(i0)
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList l>
entermonitor $r2
exitmonitor r1
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: void checkForComodification()>()
exitmonitor r1
$r5 := @caughtexception
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: void rangeCheck(int)>(i0)
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int offset>
$i2 = i0 + $i1
$r4 = virtualinvoke $r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object get(int)>($i2)
==============

==============
 tn units (no order)
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: void checkForComodification()>()
entermonitor $r2
exitmonitor r1
$r3 := @caughtexception
exitmonitor r1
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int size>
==============

==============
 tn units (no order)
$i2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int offset>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: java.lang.Object[] expectedArray> = $r7
$r4 = new java.lang.IndexOutOfBoundsException
if i0 < 0 goto $r4 = new java.lang.IndexOutOfBoundsException
$r7 = $r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
specialinvoke $r4.<java.lang.IndexOutOfBoundsException: void <init>()>()
if i0 <= $i1 goto $r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList l>
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList l>
$r9 := @caughtexception
$i4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int size>
throw $r4
$i5 = $i4 + 1
exitmonitor r2
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList l>
entermonitor $r3
virtualinvoke $r5.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: void add(int,java.lang.Object)>($i3, r1)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int size> = $i5
exitmonitor r2
$i3 = i0 + $i2
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: void checkForComodification()>()
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int size>
==============

==============
 tn units (no order)
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList l>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int size> = $i4
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: void rangeCheck(int)>(i0)
exitmonitor r1
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int offset>
$i2 = i0 + $i1
$r9 := @caughtexception
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList l>
$i3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int size>
entermonitor $r3
exitmonitor r1
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: void checkForComodification()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: java.lang.Object[] expectedArray> = $r6
r2 = virtualinvoke $r4.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object remove(int)>($i2)
$i4 = $i3 - 1
$r6 = $r5.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList: java.lang.Object[] array_>
==============

==============
 tn units (no order)
$r4 := @caughtexception
entermonitor $r2
$r3 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList$COWSubListIterator
exitmonitor r1
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: void checkForComodification()>()
specialinvoke $r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList$COWSubListIterator: void <init>(benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList,int)>(r0, 0)
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r1
if i0 <= $i1 goto $r9 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList$COWSubListIterator
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i2)
throw $r4
exitmonitor r1
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(", Size: ")
if i0 < 0 goto $r4 = new java.lang.IndexOutOfBoundsException
specialinvoke $r4.<java.lang.IndexOutOfBoundsException: void <init>(java.lang.String)>($r8)
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int size>
$r9 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList$COWSubListIterator
$r4 = new java.lang.IndexOutOfBoundsException
specialinvoke $r9.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList$COWSubListIterator: void <init>(benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList,int)>(r0, i0)
entermonitor $r3
$r2 = new java.lang.StringBuilder
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.String toString()>()
$r10 := @caughtexception
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: void checkForComodification()>()
$i2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int size>
specialinvoke $r2.<java.lang.StringBuilder: void <init>(java.lang.String)>("Index: ")
$r5 = virtualinvoke $r2.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i0)
==============

==============
 tn units (no order)
throw $r3
specialinvoke $r4.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: void <init>(benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList,int,int)>($r5, $i4, $i6)
$r6 := @caughtexception
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList l>
$i2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int size>
$i5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int offset>
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: void checkForComodification()>()
if i0 < 0 goto $r3 = new java.lang.IndexOutOfBoundsException
exitmonitor r1
exitmonitor r1
if i1 <= $i2 goto $r4 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList
$r4 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList
specialinvoke $r3.<java.lang.IndexOutOfBoundsException: void <init>()>()
$r3 = new java.lang.IndexOutOfBoundsException
entermonitor $r2
$i4 = i0 + $i3
$i3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList: int offset>
$i6 = i1 + $i5
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat... 
==============
 tn units (no order)
entermonitor $r2
exitmonitor r1
$r3 := @caughtexception
exitmonitor r1
$f0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_>
==============

==============
 tn units (no order)
$r3 := @caughtexception
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_> = f0
f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_>
entermonitor $r2
exitmonitor r1
exitmonitor r1
==============

==============
 tn units (no order)
$z1 = 1
$f2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_>
entermonitor $r2
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_> = f1
goto [?= z0 = $z1]
$r3 := @caughtexception
z0 = $z1
$b0 = f0 cmpl $f2
exitmonitor r1
$z1 = 0
if z0 == 0 goto exitmonitor r1
if $b0 != 0 goto $z1 = 0
==============

==============
 tn units (no order)
$r7 = r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: java.lang.Object lock_>
exitmonitor r4
$f4 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float get()>()
entermonitor $r6
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float set(float)>($f2)
exitmonitor r5
exitmonitor r4
exitmonitor r5
throw $r8
$r9 := @caughtexception
entermonitor $r7
$f2 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float set(float)>($f1)
$f1 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float get()>()
$r8 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r5
entermonitor $r7
$f2 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float set(float)>($f1)
$f4 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float get()>()
$f1 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float get()>()
$r8 := @caughtexception
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float set(float)>($f2)
exitmonitor r5
==============

==============
 tn units (no order)
exitmonitor r1
$r4 := @caughtexception
entermonitor $r2
$f2 = $f1 + f0
$f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_>
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_> = $f2
==============

==============
 tn units (no order)
exitmonitor r1
$r4 := @caughtexception
$f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_>
entermonitor $r2
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_> = $f2
$f2 = $f1 - f0
==============

==============
 tn units (no order)
throw $r4
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat
return $f2
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: java.lang.Object lock_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_> = $f2
$r4 := @caughtexception
exitmonitor r1
$f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_>
entermonitor $r2
f0 := @parameter0: float
exitmonitor r1
$f2 = $f1 * f0
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_> = $f2
$r4 := @caughtexception
exitmonitor r1
$f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_>
entermonitor $r2
exitmonitor r1
$f2 = $f1 * f0
==============

==============
 tn units (no order)
entermonitor $r2
$f2 = $f1 / f0
exitmonitor r1
$r4 := @caughtexception
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_> = $f2
$f1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat: float value_>
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous$Rotator... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean... 
==============
 tn units (no order)
$r4 := @caughtexception
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
exitmonitor r1
$z1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean set(boolean)>(z0)
entermonitor $r2
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: java.lang.Object lock_>
==============

==============
 tn units (no order)
$r4 := @caughtexception
z2 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean commit(boolean,boolean)>(z0, z1)
exitmonitor r1
if z2 == 0 goto exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: java.lang.Object lock_>
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
entermonitor $r2
==============

==============
 tn units (no order)
entermonitor $r2
$z0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean complement()>()
$r4 := @caughtexception
exitmonitor r1
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: java.lang.Object lock_>
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
==============

==============
 tn units (no order)
$r4 := @caughtexception
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: java.lang.Object lock_>
exitmonitor r1
entermonitor $r2
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$z1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean and(boolean)>(z0)
==============

==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$z1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean or(boolean)>(z0)
exitmonitor r1
$r4 := @caughtexception
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: java.lang.Object lock_>
==============

==============
 tn units (no order)
$z1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean: boolean xor(boolean)>(z0)
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
exitmonitor r1
$r4 := @caughtexception
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: java.lang.Object lock_>
entermonitor $r2
==============

==============
 tn units (no order)
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: boolean value_>
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: java.lang.Object lock_>
virtualinvoke $r4.<java.lang.Object: void wait()>()
exitmonitor r2
if r1 == null goto exitmonitor r2
goto [?= $z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: boolean value_>]
exitmonitor r2
entermonitor $r3
$r5 := @caughtexception
if $z0 != 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: java.lang.Object lock_>
==============

==============
 tn units (no order)
exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
exitmonitor r2
entermonitor $r3
$z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: boolean value_>
interfaceinvoke r1.<java.lang.Runnable: void run()>()
goto [?= $z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: boolean value_>]
if r1 == null goto exitmonitor r2
$r5 := @caughtexception
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: java.lang.Object lock_>
if $z0 == 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: java.lang.Object lock_>
==============

==============
 tn units (no order)
virtualinvoke $r4.<java.lang.Object: void wait()>()
$z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: boolean value_>
exitmonitor r2
if $z1 != z0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: java.lang.Object lock_>
$r5 := @caughtexception
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: java.lang.Object lock_>
goto [?= $z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: boolean value_>]
exitmonitor r2
if r1 == null goto exitmonitor r2
entermonitor $r3
==============

==============
 tn units (no order)
if r1 == null goto exitmonitor r2
exitmonitor r2
$z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: boolean value_>
goto [?= $z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: boolean value_>]
if $z1 == z0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: java.lang.Object lock_>
$r5 := @caughtexception
exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
entermonitor $r3
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean: java.lang.Object lock_>
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Puttable... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble... 
==============
 tn units (no order)
$r4 := @caughtexception
entermonitor $r2
$d1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double set(double)>(d0)
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
exitmonitor r1
==============

==============
 tn units (no order)
z0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: boolean commit(double,double)>(d0, d1)
entermonitor $r2
exitmonitor r1
if z0 == 0 goto exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r4 := @caughtexception
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
exitmonitor r1
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$d1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double add(double)>(d0)
exitmonitor r1
entermonitor $r2
$r4 := @caughtexception
exitmonitor r1
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
exitmonitor r1
$r4 := @caughtexception
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
$d1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double subtract(double)>(d0)
entermonitor $r2
==============

==============
 tn units (no order)
$d1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double multiply(double)>(d0)
exitmonitor r1
$r4 := @caughtexception
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
entermonitor $r2
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r4 := @caughtexception
$d1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble: double divide(double)>(d0)
entermonitor $r2
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
==============

==============
 tn units (no order)
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
entermonitor $r3
interfaceinvoke r1.<java.lang.Runnable: void run()>()
if $b0 != 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
$b0 = $d1 cmpl d0
goto [?= $d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: double value_>]
exitmonitor r2
$d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: double value_>
exitmonitor r2
if r1 == null goto exitmonitor r2
$r5 := @caughtexception
virtualinvoke $r4.<java.lang.Object: void wait()>()
==============

==============
 tn units (no order)
entermonitor $r3
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
$b0 = $d1 cmpl d0
$r5 := @caughtexception
goto [?= $d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: double value_>]
exitmonitor r2
if r1 == null goto exitmonitor r2
if $b0 == 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: double value_>
==============

==============
 tn units (no order)
$d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: double value_>
exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
if r1 == null goto exitmonitor r2
exitmonitor r2
$r5 := @caughtexception
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$b0 = $d1 cmpg d0
goto [?= $d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: double value_>]
entermonitor $r3
if $b0 > 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
==============

==============
 tn units (no order)
$r5 := @caughtexception
if $b0 >= 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
if r1 == null goto exitmonitor r2
$b0 = $d1 cmpg d0
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
$d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: double value_>
goto [?= $d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: double value_>]
virtualinvoke $r4.<java.lang.Object: void wait()>()
entermonitor $r3
interfaceinvoke r1.<java.lang.Runnable: void run()>()
exitmonitor r2
exitmonitor r2
==============

==============
 tn units (no order)
if r1 == null goto exitmonitor r2
exitmonitor r2
$d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: double value_>
interfaceinvoke r1.<java.lang.Runnable: void run()>()
virtualinvoke $r4.<java.lang.Object: void wait()>()
if $b0 < 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
entermonitor $r3
$r5 := @caughtexception
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
goto [?= $d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: double value_>]
exitmonitor r2
$b0 = $d1 cmpl d0
==============

==============
 tn units (no order)
if r1 == null goto exitmonitor r2
exitmonitor r2
if $b0 <= 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
$b0 = $d1 cmpl d0
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: java.lang.Object lock_>
$d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: double value_>
entermonitor $r3
$r5 := @caughtexception
exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
virtualinvoke $r4.<java.lang.Object: void wait()>()
goto [?= $d1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble: double value_>]
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue... 
==============
 tn units (no order)
return $i0
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int capacity_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue
==============

==============
 tn units (no order)
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int capacity_>
$i4 = $i0 - $i3
$i3 = $i1 + $i2
return $i4
$i2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int putSidePutPermits_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int takeSidePutPermits_>
==============

==============
 tn units (no order)
$r1 = new java.lang.IllegalArgumentException
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int takeSidePutPermits_> = $i4
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int capacity_> = i0
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int takeSidePutPermits_>
if i0 > 0 goto $i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int takeSidePutPermits_>
return
$i4 = $i1 + $i3
$i2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int capacity_>
throw $r1
i0 := @parameter0: int
$i3 = i0 - $i2
specialinvoke $r1.<java.lang.IllegalArgumentException: void <init>()>()
==============

==============
 tn units (no order)
throw $r8
$i1 = $i0 + 1
exitmonitor r1
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int takeSidePutPermits_>
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode head_>
r3 = $r5.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode next>
return r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode head_> = r3
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode head_>
r2 = r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: java.lang.Object value>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue
entermonitor $r4
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int takeSidePutPermits_> = $i1
virtualinvoke r0.<java.lang.Object: void notify()>()
r2 = null
r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: java.lang.Object value> = null
$r8 := @caughtexception
if r3 == null goto exitmonitor r1
exitmonitor r1
==============

==============
 tn units (no order)
$i1 = $i0 + 1
exitmonitor r1
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int takeSidePutPermits_>
r3 = $r5.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode next>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode head_> = r3
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode head_>
r2 = r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: java.lang.Object value>
entermonitor $r4
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int takeSidePutPermits_> = $i1
r2 = null
virtualinvoke r0.<java.lang.Object: void notify()>()
r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: java.lang.Object value> = null
$r8 := @caughtexception
if r3 == null goto exitmonitor r1
exitmonitor r1
==============

==============
 tn units (no order)
$r6 := @caughtexception
if r2 == null goto exitmonitor r1
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode head_>
exitmonitor r1
entermonitor $r3
$r5 = r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: java.lang.Object value>
r2 = $r4.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode next>
exitmonitor r1
exitmonitor r1
==============

==============
 tn units (no order)
virtualinvoke $r10.<java.lang.Object: void notify()>()
r3 = $r9
if r6 == null goto $r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: java.lang.Object takeGuard_>
r6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: java.lang.Object extract()>()
virtualinvoke $r8.<java.lang.Object: void wait()>()
goto [?= r6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: java.lang.Object extract()>()]
$r9 := @caughtexception
entermonitor $r5
exitmonitor r2
throw r3
exitmonitor r2
$r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: java.lang.Object takeGuard_>
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: java.lang.Object takeGuard_>
$r11 := @caughtexception
==============

==============
 tn units (no order)
$r11 := @caughtexception
if $b3 > 0 goto $l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
l1 = l0 - $l7
$l7 = $l6 - l2
$r8 := @caughtexception
r5 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: java.lang.Object extract()>()
goto [?= l2 = $l4]
$b3 = l0 cmp 0L
exitmonitor r2
$l4 = 0L
$b5 = l1 cmp 0L
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: java.lang.Object takeGuard_>
exitmonitor r2
virtualinvoke $r10.<java.lang.Object: void notify()>()
goto [?= r5 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: java.lang.Object extract()>()]
if r5 != null goto exitmonitor r2
virtualinvoke $r7.<java.lang.Object: void wait(long)>(l1)
$l6 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
l1 = l0
$r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: java.lang.Object takeGuard_>
if $b5 > 0 goto $r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: java.lang.Object takeGuard_>
r9 = $r8
throw r9
entermonitor $r4
l2 = $l4
==============

==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor r1
entermonitor $r2
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notify()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: java.lang.Object takeGuard_>
==============

==============
 tn units (no order)
$r7.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode next> = r3
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode last_>
exitmonitor r4
exitmonitor r4
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode last_> = r3
entermonitor $r6
$r8 := @caughtexception
==============

==============
 tn units (no order)
if $i2 <= 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
$r10 := @caughtexception
virtualinvoke r0.<java.lang.Object: void notify()>()
$r9 := @caughtexception
$i1 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int reconcilePutPermits()>()
goto [?= virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: void insert(java.lang.Object)>(r1)]
entermonitor $r7
exitmonitor r2
if $i0 > 0 goto virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: void insert(java.lang.Object)>(r1)
$i2 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int reconcilePutPermits()>()
$r11 := @caughtexception
throw $r10
exitmonitor r3
if $i1 > 0 goto exitmonitor r3
r4 = $r9
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int putSidePutPermits_>
virtualinvoke r0.<java.lang.Object: void wait()>()
goto [?= exitmonitor r3]
exitmonitor r3
throw r4
exitmonitor r2
entermonitor r0
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: void insert(java.lang.Object)>(r1)
==============

==============
 tn units (no order)
if $i2 <= 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
$r10 := @caughtexception
virtualinvoke r0.<java.lang.Object: void notify()>()
$r9 := @caughtexception
$i1 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int reconcilePutPermits()>()
$i2 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int reconcilePutPermits()>()
exitmonitor r3
if $i1 > 0 goto exitmonitor r3
r4 = $r9
virtualinvoke r0.<java.lang.Object: void wait()>()
goto [?= exitmonitor r3]
exitmonitor r3
entermonitor r0
throw r4
==============

==============
 tn units (no order)
exitmonitor r3
exitmonitor r3
exitmonitor r2
$i4 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int reconcilePutPermits()>()
entermonitor r0
if $b9 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
exitmonitor r3
throw r9
if $i6 <= 0 goto $l7 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$i3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int putSidePutPermits_>
l1 = l0 - $l8
if $b5 > 0 goto l1 = l0
$l7 = staticinvoke <java.lang.System: long currentTimeMillis()>()
exitmonitor r2
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: void insert(java.lang.Object)>(r1)
$b5 = l0 cmp 0L
virtualinvoke r0.<java.lang.Object: void notify()>()
r9 = $r8
if $i3 > 0 goto virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: void insert(java.lang.Object)>(r1)
goto [?= exitmonitor r3]
exitmonitor r3
virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
if $i4 > 0 goto exitmonitor r3
goto [?= virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: void insert(java.lang.Object)>(r1)]
$i6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int reconcilePutPermits()>()
l1 = l0
exitmonitor r2
$r10 := @caughtexception
$r11 := @caughtexception
$b9 = l1 cmp 0L
throw $r10
$r8 := @caughtexception
$l8 = $l7 - l2
exitmonitor r2
entermonitor $r6
l2 = staticinvoke <java.lang.System: long currentTimeMillis()>()
==============

==============
 tn units (no order)
exitmonitor r3
exitmonitor r3
$i4 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int reconcilePutPermits()>()
entermonitor r0
if $b9 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
exitmonitor r3
throw r9
if $i6 <= 0 goto $l7 = staticinvoke <java.lang.System: long currentTimeMillis()>()
l1 = l0 - $l8
$l7 = staticinvoke <java.lang.System: long currentTimeMillis()>()
if $b5 > 0 goto l1 = l0
$b5 = l0 cmp 0L
virtualinvoke r0.<java.lang.Object: void notify()>()
r9 = $r8
goto [?= exitmonitor r3]
virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
exitmonitor r3
if $i4 > 0 goto exitmonitor r3
$i6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: int reconcilePutPermits()>()
l1 = l0
$r10 := @caughtexception
$b9 = l1 cmp 0L
$l8 = $l7 - l2
$r8 := @caughtexception
l2 = staticinvoke <java.lang.System: long currentTimeMillis()>()
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode head_>
exitmonitor r1
if $r4 != null goto $z0 = 0
$z0 = 1
$z0 = 0
goto [?= exitmonitor r1]
$r5 := @caughtexception
entermonitor $r2
$r4 = $r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode next>
exitmonitor r1
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar... 
==============
 tn units (no order)
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
exitmonitor r1
$c1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char set(char)>(c0)
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
entermonitor $r2
$r4 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
exitmonitor r1
z0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: boolean commit(char,char)>(c0, c1)
$r4 := @caughtexception
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
if z0 == 0 goto exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
$c1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char add(char)>(c0)
$r4 := @caughtexception
==============

==============
 tn units (no order)
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
$c1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char subtract(char)>(c0)
exitmonitor r1
entermonitor $r2
$r4 := @caughtexception
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
==============

==============
 tn units (no order)
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
entermonitor $r2
exitmonitor r1
$c1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char multiply(char)>(c0)
$r4 := @caughtexception
==============

==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
$c1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char divide(char)>(c0)
entermonitor $r2
==============

==============
 tn units (no order)
interfaceinvoke r1.<java.lang.Runnable: void run()>()
exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
$c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: char value_>
$r5 := @caughtexception
goto [?= $c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: char value_>]
if $c1 != c0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
if r1 == null goto exitmonitor r2
entermonitor $r3
exitmonitor r2
==============

==============
 tn units (no order)
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
if $c1 == c0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
exitmonitor r2
$c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: char value_>
goto [?= $c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: char value_>]
if r1 == null goto exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
exitmonitor r2
entermonitor $r3
$r5 := @caughtexception
interfaceinvoke r1.<java.lang.Runnable: void run()>()
==============

==============
 tn units (no order)
if r1 == null goto exitmonitor r2
if $c1 > c0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
$c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: char value_>
entermonitor $r3
exitmonitor r2
exitmonitor r2
$r5 := @caughtexception
virtualinvoke $r4.<java.lang.Object: void wait()>()
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
goto [?= $c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: char value_>]
==============

==============
 tn units (no order)
$r5 := @caughtexception
interfaceinvoke r1.<java.lang.Runnable: void run()>()
exitmonitor r2
$c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: char value_>
if r1 == null goto exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
if $c1 >= c0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
goto [?= $c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: char value_>]
exitmonitor r2
entermonitor $r3
virtualinvoke $r4.<java.lang.Object: void wait()>()
==============

==============
 tn units (no order)
$r5 := @caughtexception
goto [?= $c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: char value_>]
$c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: char value_>
if r1 == null goto exitmonitor r2
exitmonitor r2
exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
virtualinvoke $r4.<java.lang.Object: void wait()>()
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
if $c1 < c0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
entermonitor $r3
==============

==============
 tn units (no order)
exitmonitor r2
if $c1 <= c0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
entermonitor $r3
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: java.lang.Object lock_>
$r5 := @caughtexception
virtualinvoke $r4.<java.lang.Object: void wait()>()
$c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: char value_>
if r1 == null goto exitmonitor r2
goto [?= $c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar: char value_>]
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte... 
==============
 tn units (no order)
entermonitor $r2
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r4 := @caughtexception
exitmonitor r1
exitmonitor r1
$b1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte set(byte)>(b0)
==============

==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
if z0 == 0 goto exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
entermonitor $r2
z0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: boolean commit(byte,byte)>(b0, b1)
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
$b0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte increment()>()
exitmonitor r1
entermonitor $r2
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r4 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r1
$r4 := @caughtexception
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
entermonitor $r2
$b0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte decrement()>()
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
==============

==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r4 := @caughtexception
exitmonitor r1
$b1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte add(byte)>(b0)
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
==============

==============
 tn units (no order)
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
entermonitor $r2
$r4 := @caughtexception
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
$b1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte subtract(byte)>(b0)
==============

==============
 tn units (no order)
exitmonitor r1
$b1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte multiply(byte)>(b0)
entermonitor $r2
$r4 := @caughtexception
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
exitmonitor r1
entermonitor $r2
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
$b1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte divide(byte)>(b0)
$r4 := @caughtexception
==============

==============
 tn units (no order)
virtualinvoke $r4.<java.lang.Object: void wait()>()
$r5 := @caughtexception
if r1 == null goto exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
if $b1 != b0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
entermonitor $r3
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
goto [?= $b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: byte value_>]
exitmonitor r2
exitmonitor r2
$b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: byte value_>
==============

==============
 tn units (no order)
$r5 := @caughtexception
interfaceinvoke r1.<java.lang.Runnable: void run()>()
if r1 == null goto exitmonitor r2
exitmonitor r2
if $b1 == b0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
goto [?= $b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: byte value_>]
$b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: byte value_>
exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
entermonitor $r3
==============

==============
 tn units (no order)
exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$r5 := @caughtexception
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
if r1 == null goto exitmonitor r2
entermonitor $r3
virtualinvoke $r4.<java.lang.Object: void wait()>()
goto [?= $b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: byte value_>]
$b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: byte value_>
exitmonitor r2
if $b1 > b0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
==============

==============
 tn units (no order)
exitmonitor r2
$r5 := @caughtexception
virtualinvoke $r4.<java.lang.Object: void wait()>()
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
goto [?= $b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: byte value_>]
exitmonitor r2
entermonitor $r3
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: byte value_>
if $b1 >= b0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
if r1 == null goto exitmonitor r2
==============

==============
 tn units (no order)
exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
virtualinvoke $r4.<java.lang.Object: void wait()>()
if $b1 < b0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
$r5 := @caughtexception
if r1 == null goto exitmonitor r2
goto [?= $b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: byte value_>]
entermonitor $r3
$b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: byte value_>
==============

==============
 tn units (no order)
entermonitor $r3
goto [?= $b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: byte value_>]
exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
interfaceinvoke r1.<java.lang.Runnable: void run()>()
exitmonitor r2
$r5 := @caughtexception
if $b1 <= b0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: java.lang.Object lock_>
$b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte: byte value_>
if r1 == null goto exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask$Wrap... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$RunLoop... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Mutex... 
==============
 tn units (no order)
if $z1 != 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
$r6 := @caughtexception
goto [?= $z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Mutex: boolean inuse_>]
exitmonitor r1
virtualinvoke r0.<java.lang.Object: void notify()>()
$r5 := @caughtexception
goto [?= exitmonitor r1]
exitmonitor r1
r2 = $r5
$z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Mutex: boolean inuse_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Mutex: boolean inuse_> = 1
virtualinvoke r0.<java.lang.Object: void wait()>()
entermonitor r0
throw r2
==============

==============
 tn units (no order)
return
virtualinvoke r0.<java.lang.Object: void notify()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Mutex
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Mutex: boolean inuse_> = 0
==============

==============
 tn units (no order)
if $b3 > 0 goto l1 = l0
if $z2 != 0 goto $l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
l1 = l0 - $l5
l1 = l0
exitmonitor r1
$b6 = l1 cmp 0L
exitmonitor r1
entermonitor r0
$z2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Mutex: boolean inuse_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Mutex: boolean inuse_> = 1
$l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
exitmonitor r1
if $b6 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
$r5 := @caughtexception
virtualinvoke r0.<java.lang.Object: void notify()>()
$z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Mutex: boolean inuse_>
$r6 := @caughtexception
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Mutex: boolean inuse_> = 1
exitmonitor r1
l2 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$l5 = $l4 - l2
virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
throw r2
exitmonitor r1
if $z1 != 0 goto $b3 = l0 cmp 0L
r2 = $r5
$b3 = l0 cmp 0L
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer... 
==============
 tn units (no order)
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int usedSlots_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer
return $i0
==============

==============
 tn units (no order)
entermonitor $r2
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int emptySlots_>
$r5 := @caughtexception
virtualinvoke $r4.<java.lang.Object: void notify()>()
exitmonitor r1
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int emptySlots_> = $i1
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: java.lang.Object putMonitor_>
$i1 = $i0 + 1
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer
virtualinvoke r0.<java.lang.Object: void notify()>()
$i1 = $i0 + 1
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int usedSlots_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int usedSlots_> = $i1
return
==============

==============
 tn units (no order)
exitmonitor r2
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int takePtr_>
exitmonitor r2
if $i0 <= 0 goto exitmonitor r2
entermonitor r0
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int usedSlots_>
$r5 := @caughtexception
$r4 = $r3[$i1]
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: java.lang.Object[] array_>
exitmonitor r2
==============

==============
 tn units (no order)
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int emptySlots_>
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: java.lang.Object putMonitor_>
r3 = $r8
$r10 := @caughtexception
if $i0 <= 0 goto $r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: java.lang.Object putMonitor_>
virtualinvoke $r7.<java.lang.Object: void wait()>()
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: void insert(java.lang.Object)>(r1)
goto [?= $i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int emptySlots_>]
throw r3
entermonitor $r6
goto [?= $i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int emptySlots_>]
$r8 := @caughtexception
virtualinvoke $r9.<java.lang.Object: void notify()>()
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: java.lang.Object putMonitor_>
exitmonitor r2
exitmonitor r2
==============

==============
 tn units (no order)
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: java.lang.Object putMonitor_>
$l7 = $l6 - l1
$l6 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$r8 := @caughtexception
$i8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int emptySlots_>
$b3 = l0 cmp 0L
virtualinvoke $r7.<java.lang.Object: void wait(long)>(l2)
$r10 := @caughtexception
r3 = $r8
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: void insert(java.lang.Object)>(r1)
$l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$l4 = 0L
throw r3
exitmonitor r2
if $b3 > 0 goto $l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
l1 = $l4
l2 = l0 - $l7
if $i8 <= 0 goto $b5 = l2 cmp 0L
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: java.lang.Object putMonitor_>
entermonitor $r6
exitmonitor r2
$b5 = l2 cmp 0L
if $b5 > 0 goto $r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: java.lang.Object putMonitor_>
goto [?= l1 = $l4]
goto [?= $l6 = staticinvoke <java.lang.System: long currentTimeMillis()>()]
exitmonitor r2
l2 = l0
goto [?= $i8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int emptySlots_>]
virtualinvoke $r9.<java.lang.Object: void notify()>()
==============

==============
 tn units (no order)
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int usedSlots_>
goto [?= $i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int usedSlots_>]
goto [?= $i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int usedSlots_>]
throw r2
virtualinvoke r0.<java.lang.Object: void wait()>()
r2 = $r5
if $i0 <= 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
entermonitor r0
$r5 := @caughtexception
virtualinvoke r0.<java.lang.Object: void notify()>()
$r7 := @caughtexception
exitmonitor r1
r6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: java.lang.Object extract()>()
exitmonitor r1
==============

==============
 tn units (no order)
goto [?= $l6 = staticinvoke <java.lang.System: long currentTimeMillis()>()]
if $b3 > 0 goto $l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$l6 = staticinvoke <java.lang.System: long currentTimeMillis()>()
exitmonitor r1
l2 = l0
r6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: java.lang.Object extract()>()
$l4 = 0L
$b5 = l2 cmp 0L
if $i8 <= 0 goto $b5 = l2 cmp 0L
$l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
throw r2
virtualinvoke r0.<java.lang.Object: void notify()>()
l2 = l0 - $l7
r2 = $r5
virtualinvoke r0.<java.lang.Object: void wait(long)>(l2)
exitmonitor r1
goto [?= $i8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int usedSlots_>]
if $b5 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l2)
l1 = $l4
$l7 = $l6 - l1
$r5 := @caughtexception
entermonitor r0
$i8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer: int usedSlots_>
exitmonitor r1
$r7 := @caughtexception
$b3 = l0 cmp 0L
goto [?= l1 = $l4]
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactoryUser... 
==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactoryUser
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactoryUser: benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory threadFactory_> = r1
r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactoryUser: benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory threadFactory_>
return r2
r1 := @parameter0: benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactoryUser
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactoryUser: benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory threadFactory_>
return $r1
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Callable... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadedExecutor... 
==============
 tn units (no order)
virtualinvoke r2.<java.lang.Thread: void start()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadedExecutor
specialinvoke $r3.<java.lang.InterruptedException: void <init>()>()
r2 = interfaceinvoke $r4.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory: java.lang.Thread newThread(java.lang.Runnable)>(r1)
r1 := @parameter0: java.lang.Runnable
$r3 = new java.lang.InterruptedException
$r4 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadedExecutor: benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory getThreadFactory()>()
throw $r3
$z0 = staticinvoke <java.lang.Thread: boolean interrupted()>()
if $z0 == 0 goto $r4 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadedExecutor: benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory getThreadFactory()>()
return
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncSortedSet... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOSemaphore$FIFOWaitQueue... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner... 
==============
 tn units (no order)
return
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: void checkOverflow()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: void push(benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask)>(r1)
r1 := @parameter0: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask
==============

==============
 tn units (no order)
goto [?= $i3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int base>]
if $i4 >= $i6 goto virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: void checkOverflow()>()
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner$VolatileTaskRef[] deq>
if i2 >= i1 goto r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int top> = i2
$i5 = lengthof $r2
i2 = $i9 & $i11
$i11 = $i10 - 1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int base> = i1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner
return
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner$VolatileTaskRef[] deq>
$i8 = $i7 - 1
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner$VolatileTaskRef[] deq>
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner$VolatileTaskRef[] deq>
i2 = i2 + $i12
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int top> = i2
$i6 = i0 + $i5
i0 = $i3 - 1
$i3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int base>
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: void checkOverflow()>()
$i7 = lengthof $r3
$i9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int top>
$i4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int top>
i1 = i0 & $i8
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner$VolatileTaskRef[] deq>
$r5 = $r4[i1]
$i12 = lengthof $r7
virtualinvoke $r5.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner$VolatileTaskRef: void put(benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask)>(r1)
r1 := @parameter0: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask
$i10 = lengthof $r6
if i0 == i1 goto return
==============

==============
 tn units (no order)
$i3 = $i2 - 1
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner$VolatileTaskRef[] deq>
$r3 = $r1[$i4]
$i4 = i0 & $i3
$r4 = virtualinvoke $r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner$VolatileTaskRef: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask take()>()
i0 := @parameter0: int
$b5 = 0
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int base>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int top> = $b5
return null
return $r4
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int base> = $b5
$i2 = lengthof $r2
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner
if $i1 > i0 goto $b5 = 0
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner$VolatileTaskRef[] deq>
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int base> = i1
$r2 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask confirmTake(int)>(i1)
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int base>
return null
if i1 >= $i3 goto r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int base> = i1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int base> = $i2
$i2 = $i0 + 1
$i3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int top>
i1 = $i0
return $r2
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner$VolatileTaskRef[] deq>
$r5 = $r3[$i4]
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int base> = i0
$r6 = virtualinvoke $r5.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner$VolatileTaskRef: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask get()>()
$i2 = lengthof $r4
$r7 := @caughtexception
if i0 >= $i1 goto r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int base> = i0
entermonitor $r2
$i3 = $i2 - 1
exitmonitor r1
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner$VolatileTaskRef[] deq>
exitmonitor r1
$i4 = i0 & $i3
exitmonitor r1
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner: int top>
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef... 
==============
 tn units (no order)
entermonitor $r2
exitmonitor r1
exitmonitor r1
$r4 := @caughtexception
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object value_>
==============

==============
 tn units (no order)
exitmonitor r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object value_> = r1
entermonitor $r4
$r6 := @caughtexception
exitmonitor r2
r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object value_>
==============

==============
 tn units (no order)
exitmonitor r3
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object value_>
entermonitor $r4
$z1 = 1
exitmonitor r3
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object value_> = r2
z0 = $z1
$z1 = 0
goto [?= z0 = $z1]
$r6 := @caughtexception
if z0 == 0 goto exitmonitor r3
if r1 != $r5 goto $z1 = 0
==============

==============
 tn units (no order)
$r10 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object set(java.lang.Object)>($r9)
exitmonitor r5
exitmonitor r4
exitmonitor r5
entermonitor $r8
$r13 := @caughtexception
exitmonitor r4
$r12 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object get()>()
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object set(java.lang.Object)>($r10)
$r9 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object get()>()
entermonitor $r7
$r14 := @caughtexception
$r8 = r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object lock_>
throw $r13
==============

==============
 tn units (no order)
$r10 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object set(java.lang.Object)>($r9)
$r13 := @caughtexception
exitmonitor r5
$r12 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object get()>()
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object set(java.lang.Object)>($r10)
$r9 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef: java.lang.Object get()>()
exitmonitor r5
entermonitor $r8
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$Worker... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore... 
==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore
$l2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore: long permits_>
$b1 = $l0 cmp 0L
z0 = $z1
if $b1 <= 0 goto $z1 = 0
return z0
goto [?= z0 = $z1]
$z1 = 1
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore: long permits_>
$l3 = $l2 - 1L
if z0 == 0 goto return z0
$z1 = 0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore: long permits_> = $l3
==============

==============
 tn units (no order)
r1 := @parameter0: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore
$z1 = 1
goto [?= return z0]
$l2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore: long permits_>
goto [?= z0 = $z1]
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue wq_>
$b1 = $l0 cmp 0L
$l3 = $l2 - 1L
$z1 = 0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore: long permits_> = $l3
if z0 == 0 goto $r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue wq_>
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore: long permits_>
if $b1 <= 0 goto $z1 = 0
z0 = $z1
virtualinvoke $r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue: void insert(benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode)>(r1)
return z0
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore: long permits_> = $l1
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore: long permits_>
$l1 = $l0 + 1L
r1 = virtualinvoke $r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode extract()>()
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue wq_>
if r1 != null goto return r1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore
return r1
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor$RunLoop... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.ObservableSync$SyncObserver... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList$COWSubListIterator... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner$VolatileTaskRef... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask$Par2... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster... 
==============
 tn units (no order)
if $r2 != null goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
r1 := @parameter0: java.lang.String
$r3 = (benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster) $r5
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster
$r3 = null
return $r3
$r5 = virtualinvoke $r4.<java.util.HashMap: java.lang.Object get(java.lang.Object)>(r1)
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
goto [?= return $r3]
==============

==============
 tn units (no order)
r1 := @parameter0: java.beans.PropertyChangeListener
if r1 != null goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
r2[i0] = r1
return
r2 = newarray (java.beans.PropertyChangeListener)[$i1]
$i1 = i0 + 1
specialinvoke $r3.<java.lang.NullPointerException: void <init>()>()
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r5, 0, r2, 0, i0)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster
$r3 = new java.lang.NullPointerException
i0 = lengthof $r4
if i0 <= 0 goto r2[i0] = r1
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
throw $r3
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners> = r2
==============

==============
 tn units (no order)
r2[i1] = $r6
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
r2 = newarray (java.beans.PropertyChangeListener)[$i2]
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners> = r2
return
r1 := @parameter0: java.beans.PropertyChangeListener
if $z0 == 0 goto i1 = i1 + 1
return
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster
i0 = lengthof $r4
specialinvoke $r3.<java.lang.NullPointerException: void <init>()>()
$i2 = i0 + 1
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r8)
$r3 = new java.lang.NullPointerException
r2[i0] = r1
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
throw $r3
if i1 < i0 goto $r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
if r1 != null goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
i1 = i1 + 1
$r6 = $r5[i1]
goto [?= (branch)]
i1 = 0
$r8 = $r7[i1]
==============

==============
 tn units (no order)
return
r2 = newarray (java.beans.PropertyChangeListener)[i0]
if r1 != null goto r2 = newarray (java.beans.PropertyChangeListener)[i0]
$r9 = $r8[i1]
r2[i1] = $r9
$r5 = $r4[i1]
r1 := @parameter0: java.beans.PropertyChangeListener
i1 = 0
i2 = i2 + 1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster
return
if $z0 == 0 goto $r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
if $z1 == 0 goto return
if i1 < i0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
$r11 = $r10[i0]
return
i0 = $i3 - 1
$i3 = lengthof $r3
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners> = r2
r2[$i4] = $r7
if i2 <= i0 goto $i4 = i2 - 1
i2 = i1 + 1
goto [?= (branch)]
goto [?= (branch)]
$i4 = i2 - 1
$z1 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r11)
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r5)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners> = r2
$r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
if i0 < 0 goto return
i1 = i1 + 1
$r7 = $r6[i2]
==============

==============
 tn units (no order)
entermonitor r0
exitmonitor r4
$r11 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster
$r12 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.lang.Object source>
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
virtualinvoke $r13.<java.util.HashMap: java.lang.Object put(java.lang.Object,java.lang.Object)>(r1, r3)
$r8 = new java.util.HashMap
specialinvoke $r8.<java.util.HashMap: void <init>()>()
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
specialinvoke $r11.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: void <init>(java.lang.Object)>($r12)
$r10 = virtualinvoke $r9.<java.util.HashMap: java.lang.Object get(java.lang.Object)>(r1)
if r3 != null goto exitmonitor r4
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children> = $r8
$r15 := @caughtexception
if $r7 != null goto $r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
exitmonitor r4
$r13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
r3 = (benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster) $r10
goto [?= (branch)]
r3 = $r11
==============

==============
 tn units (no order)
$r12 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.lang.Object source>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children> = $r8
specialinvoke $r8.<java.util.HashMap: void <init>()>()
$r13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
$r11 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
exitmonitor r4
if r3 != null goto exitmonitor r4
if $r7 != null goto $r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
$r8 = new java.util.HashMap
r3 = $r11
r3 = (benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster) $r10
virtualinvoke $r13.<java.util.HashMap: java.lang.Object put(java.lang.Object,java.lang.Object)>(r1, r3)
goto [?= (branch)]
entermonitor r0
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
$r15 := @caughtexception
exitmonitor r4
$r10 = virtualinvoke $r9.<java.util.HashMap: java.lang.Object get(java.lang.Object)>(r1)
specialinvoke $r11.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: void <init>(java.lang.Object)>($r12)
==============

==============
 tn units (no order)
$r9 = virtualinvoke r1.<java.beans.PropertyChangeEvent: java.lang.String getPropertyName()>()
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
r2 = (benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster) $r10
entermonitor r0
$r10 = virtualinvoke $r8.<java.util.HashMap: java.lang.Object get(java.lang.Object)>($r9)
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
$r7 = virtualinvoke r1.<java.beans.PropertyChangeEvent: java.lang.String getPropertyName()>()
$r11 := @caughtexception
if $r6 == null goto exitmonitor r3
if $r7 == null goto exitmonitor r3
r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
exitmonitor r3
exitmonitor r3
==============

==============
 tn units (no order)
entermonitor r0
exitmonitor r3
exitmonitor r3
if r4 != null goto exitmonitor r3
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
$r9 := @caughtexception
exitmonitor r3
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
exitmonitor r3
if $r6 != null goto $r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.util.HashMap children>
$r8 = virtualinvoke $r7.<java.util.HashMap: java.lang.Object get(java.lang.Object)>(r1)
if r1 == null goto exitmonitor r3
r4 = (benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster) $r8
$i0 = lengthof $r5
exitmonitor r3
if $i0 <= 0 goto (branch)
==============

==============
 tn units (no order)
return
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
$r7 = $r6[i0]
if i0 < $i1 goto $r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
$i1 = lengthof $r8
r2 = $r3[i0]
i0 = 0
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster
r1 := @parameter0: java.io.ObjectOutputStream
$z0 = $r5 instanceof java.io.Serializable
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>
virtualinvoke r1.<java.io.ObjectOutputStream: void writeObject(java.lang.Object)>($r7)
i0 = i0 + 1
if $z0 == 0 goto i0 = i0 + 1
virtualinvoke r1.<java.io.ObjectOutputStream: void defaultWriteObject()>()
$r5 = $r4[i0]
virtualinvoke r1.<java.io.ObjectOutputStream: void writeObject(java.lang.Object)>(null)
goto [?= $r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster: java.beans.PropertyChangeListener[] listeners>]
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock... 
==============
 tn units (no order)
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingReaders_>
return
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingReaders_> = $l1
$l1 = $l0 - 1L
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingWriters_> = $l1
$l1 = $l0 - 1L
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingWriters_>
return
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock
==============

==============
 tn units (no order)
z0 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean allowReader()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long activeReaders_> = $l1
if z0 == 0 goto return z0
$l1 = $l0 + 1L
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long activeReaders_>
return z0
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock
==============

==============
 tn units (no order)
if $r2 != null goto $z1 = 0
$b1 = $l0 cmp 0L
$r1 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
goto [?= z0 = $z1]
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: java.lang.Thread activeWriter_> = $r1
if z0 == 0 goto return z0
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock
$z1 = 1
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: java.lang.Thread activeWriter_>
return z0
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long activeReaders_>
z0 = $z1
if $b1 != 0 goto $z1 = 0
$z1 = 0
==============

==============
 tn units (no order)
return z0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingReaders_> = $l1
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingReaders_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock
z0 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean startRead()>()
if z0 != 0 goto return z0
$l1 = $l0 + 1L
==============

==============
 tn units (no order)
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingWriters_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingWriters_> = $l1
if z0 != 0 goto return z0
z0 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean startWrite()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock
$l1 = $l0 + 1L
return z0
==============

==============
 tn units (no order)
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingReaders_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock
return z0
z0 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean startRead()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingReaders_> = $l1
$l1 = $l0 - 1L
if z0 == 0 goto return z0
==============

==============
 tn units (no order)
if z0 == 0 goto return z0
z0 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean startWrite()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock
$l1 = $l0 - 1L
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingWriters_> = $l1
return z0
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingWriters_>
==============

==============
 tn units (no order)
return null
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long activeReaders_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock
return $r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long activeReaders_> = $l1
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock writerLock_>
if $b4 <= 0 goto return null
$l1 = $l0 - 1L
$l3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingWriters_>
$b4 = $l3 cmp 0L
$b2 = $l1 cmp 0L
if $b2 != 0 goto return null
==============

==============
 tn units (no order)
if $b1 <= 0 goto $l2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingWriters_>
$l2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingWriters_>
if $b3 <= 0 goto return null
return null
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: java.lang.Thread activeWriter_> = null
$b1 = $l0 cmp 0L
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingReaders_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock
if $z0 == 0 goto $l2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: long waitingWriters_>
$b3 = $l2 cmp 0L
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock readerLock_>
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock writerLock_>
return $r1
$z0 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean allowReader()>()
return $r2
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult... 
==============
 tn units (no order)
$z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: boolean ready_>
return $r1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult
if $z0 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
virtualinvoke r0.<java.lang.Object: void wait()>()
goto [?= $z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: boolean ready_>]
$r1 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: java.lang.Object doGet()>()
==============

==============
 tn units (no order)
return $r1
$l6 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$b8 = l2 cmp 0L
if $b3 > 0 goto $l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$l4 = 0L
if $z0 == 0 goto $b5 = l2 cmp 0L
$z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: boolean ready_>
if $z1 == 0 goto $l6 = staticinvoke <java.lang.System: long currentTimeMillis()>()
throw $r4
l1 = $l4
$r1 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: java.lang.Object doGet()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult
$z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: boolean ready_>
specialinvoke $r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeoutException: void <init>(long)>(l0)
specialinvoke $r4.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeoutException: void <init>(long)>(l0)
if $b5 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l2)
$r2 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeoutException
$l7 = $l6 - l1
$b3 = l0 cmp 0L
$r3 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: java.lang.Object doGet()>()
goto [?= l1 = $l4]
throw $r2
l2 = l0
l0 := @parameter0: long
$r4 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeoutException
return $r3
virtualinvoke r0.<java.lang.Object: void wait(long)>(l2)
l2 = l0 - $l7
if $b8 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l2)
$l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$b5 = l2 cmp 0L
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: java.lang.Object value_> = r1
r1 := @parameter0: java.lang.Object
return
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: boolean ready_> = 1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
==============

==============
 tn units (no order)
return
specialinvoke $r2.<java.lang.reflect.InvocationTargetException: void <init>(java.lang.Throwable)>(r1)
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: java.lang.reflect.InvocationTargetException exception_> = $r2
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult
$r2 = new java.lang.reflect.InvocationTargetException
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: boolean ready_> = 1
r1 := @parameter0: java.lang.Throwable
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult
return $r1
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: java.lang.reflect.InvocationTargetException exception_>
==============

==============
 tn units (no order)
$z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: boolean ready_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult
return $z0
==============

==============
 tn units (no order)
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: java.lang.Object value_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult
return $r1
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: java.lang.Object value_> = null
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: java.lang.reflect.InvocationTargetException exception_> = null
return
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult: boolean ready_> = 0
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronousChannel... 
==============
 tn units (no order)
return
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronousChannel: java.lang.Object item_> = r1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronousChannel
r1 := @parameter0: java.lang.Object
==============

==============
 tn units (no order)
r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronousChannel: java.lang.Object item_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronousChannel
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronousChannel: java.lang.Object item_> = null
return r1
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronousChannel
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronousChannel: java.lang.Object item_>
return $r1
==============

==============
 tn units (no order)
$r7 := @caughtexception
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronousChannel: void insert(java.lang.Object)>(r1)
z0 = 1
exitmonitor r2
z0 = 0
$r9 := @caughtexception
$r8 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronousChannel: benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore itemTaken_>
goto [?= $r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronousChannel: benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore itemTaken_>]
virtualinvoke $r8.<java.lang.Thread: void interrupt()>()
goto [?= (branch)]
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronousChannel: benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore itemAvailable_>
entermonitor $r4
virtualinvoke $r5.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: void release()>()
virtualinvoke $r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: void acquire()>()
if z0 == 0 goto exitmonitor r2
exitmonitor r2
r3 = $r7
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar... 
==============
 tn units (no order)
$c0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_>
exitmonitor r1
exitmonitor r1
$r3 := @caughtexception
entermonitor $r2
==============

==============
 tn units (no order)
$r3 := @caughtexception
exitmonitor r1
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_> = c0
entermonitor $r2
c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_>
==============

==============
 tn units (no order)
z0 = $z1
$c2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_>
exitmonitor r1
$z1 = 1
if c0 != $c2 goto $z1 = 0
$r3 := @caughtexception
if z0 == 0 goto exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_> = c1
$z1 = 0
goto [?= z0 = $z1]
exitmonitor r1
entermonitor $r2
==============

==============
 tn units (no order)
$c4 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char set(char)>($c3)
$c3 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char get()>()
exitmonitor r5
exitmonitor r5
exitmonitor r4
$r8 := @caughtexception
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char set(char)>($c4)
$r9 := @caughtexception
throw $r8
exitmonitor r4
$r7 = r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: java.lang.Object lock_>
entermonitor $r6
entermonitor $r7
$c6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char get()>()
==============

==============
 tn units (no order)
$c4 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char set(char)>($c3)
$c3 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char get()>()
exitmonitor r5
exitmonitor r5
$r8 := @caughtexception
$c6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char get()>()
entermonitor $r7
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char set(char)>($c4)
==============

==============
 tn units (no order)
exitmonitor r1
$r4 := @caughtexception
entermonitor $r2
$i2 = $c1 + c0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_> = $c3
exitmonitor r1
$c3 = (char) $i2
$c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_>
==============

==============
 tn units (no order)
entermonitor $r2
exitmonitor r1
$c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_>
exitmonitor r1
$c3 = (char) $i2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_> = $c3
$r4 := @caughtexception
$i2 = $c1 - c0
==============

==============
 tn units (no order)
$r4 := @caughtexception
$i2 = $c1 * c0
c0 := @parameter0: char
$c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_>
$c3 = (char) $i2
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_> = $c3
entermonitor $r2
return $c3
exitmonitor r1
throw $r4
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: java.lang.Object lock_>
exitmonitor r1
==============

==============
 tn units (no order)
$r4 := @caughtexception
entermonitor $r2
exitmonitor r1
$i2 = $c1 * c0
$c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_>
$c3 = (char) $i2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_> = $c3
exitmonitor r1
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_> = $c3
$i2 = $c1 / c0
$r4 := @caughtexception
$c3 = (char) $i2
exitmonitor r1
entermonitor $r2
$c1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar: char value_>
exitmonitor r1
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$RunWhenBlocked... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.NullSync... 
==============
 tn units (no order)
$r1 = new java.lang.InterruptedException
return
specialinvoke $r1.<java.lang.InterruptedException: void <init>()>()
if $z0 == 0 goto return
throw $r1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.NullSync
$z0 = staticinvoke <java.lang.Thread: boolean interrupted()>()
==============

==============
 tn units (no order)
return 1
throw $r1
$r1 = new java.lang.InterruptedException
$z0 = staticinvoke <java.lang.Thread: boolean interrupted()>()
l0 := @parameter0: long
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.NullSync
if $z0 == 0 goto return 1
specialinvoke $r1.<java.lang.InterruptedException: void <init>()>()
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.NullSync
return
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt... 
==============
 tn units (no order)
entermonitor $r2
$r3 := @caughtexception
exitmonitor r1
exitmonitor r1
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
==============

==============
 tn units (no order)
$r3 := @caughtexception
entermonitor $r2
exitmonitor r1
exitmonitor r1
i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_> = i0
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_> = i1
if i0 != $i2 goto $z1 = 0
exitmonitor r1
$i2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
$z1 = 1
exitmonitor r1
entermonitor $r2
$r3 := @caughtexception
z0 = $z1
goto [?= z0 = $z1]
if z0 == 0 goto exitmonitor r1
$z1 = 0
==============

==============
 tn units (no order)
exitmonitor r4
$i4 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int set(int)>($i3)
$i6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int get()>()
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int set(int)>($i4)
entermonitor $r6
$r9 := @caughtexception
exitmonitor r5
$i3 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int get()>()
$r7 = r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: java.lang.Object lock_>
$r8 := @caughtexception
entermonitor $r7
exitmonitor r4
throw $r8
exitmonitor r5
==============

==============
 tn units (no order)
$i4 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int set(int)>($i3)
$i3 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int get()>()
$i6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int get()>()
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int set(int)>($i4)
$r8 := @caughtexception
exitmonitor r5
entermonitor $r7
exitmonitor r5
==============

==============
 tn units (no order)
exitmonitor r1
$r4 := @caughtexception
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_> = $i1
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
entermonitor $r2
$i1 = $i0 + 1
==============

==============
 tn units (no order)
exitmonitor r1
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
entermonitor $r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_> = $i1
$i1 = $i0 - 1
exitmonitor r1
$r4 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
$r4 := @caughtexception
entermonitor $r2
$i2 = $i1 + i0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_> = $i2
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_> = $i2
exitmonitor r1
exitmonitor r1
$r4 := @caughtexception
$i2 = $i1 - i0
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
entermonitor $r2
==============

==============
 tn units (no order)
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
return $i2
entermonitor $r2
i0 := @parameter0: int
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_> = $i2
throw $r4
$r4 := @caughtexception
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: java.lang.Object lock_>
exitmonitor r1
$i2 = $i1 * i0
==============

==============
 tn units (no order)
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
entermonitor $r2
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_> = $i2
$r4 := @caughtexception
exitmonitor r1
$i2 = $i1 * i0
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_> = $i2
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
exitmonitor r1
entermonitor $r2
$r4 := @caughtexception
$i2 = $i1 / i0
exitmonitor r1
==============

==============
 tn units (no order)
$i1 = neg $i0
$r3 := @caughtexception
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_> = $i1
exitmonitor r1
$i2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
entermonitor $r2
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
exitmonitor r1
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_> = $i1
exitmonitor r1
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
$i2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
$i1 = $i0 ^ -1
exitmonitor r1
$r3 := @caughtexception
entermonitor $r2
==============

==============
 tn units (no order)
entermonitor $r2
exitmonitor r1
exitmonitor r1
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
$r4 := @caughtexception
$i3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_> = $i2
$i2 = $i1 & i0
==============

==============
 tn units (no order)
$r4 := @caughtexception
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
entermonitor $r2
exitmonitor r1
$i3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
$i2 = $i1 | i0
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_> = $i2
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_> = $i2
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
$r4 := @caughtexception
entermonitor $r2
exitmonitor r1
$i3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt: int value_>
$i2 = $i1 ^ i0
exitmonitor r1
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte... 
==============
 tn units (no order)
$b0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
exitmonitor r1
exitmonitor r1
entermonitor $r2
$r3 := @caughtexception
==============

==============
 tn units (no order)
$r3 := @caughtexception
entermonitor $r2
exitmonitor r1
b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_> = b0
==============

==============
 tn units (no order)
$z1 = 1
if z0 == 0 goto exitmonitor r1
entermonitor $r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_> = b1
z0 = $z1
if b0 != $b2 goto $z1 = 0
$b2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
$z1 = 0
$r3 := @caughtexception
goto [?= z0 = $z1]
exitmonitor r1
exitmonitor r1
==============

==============
 tn units (no order)
$r7 = r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: java.lang.Object lock_>
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte set(byte)>($b4)
exitmonitor r4
$b6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte get()>()
throw $r8
exitmonitor r4
$b4 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte set(byte)>($b3)
exitmonitor r5
$r9 := @caughtexception
entermonitor $r7
$r8 := @caughtexception
exitmonitor r5
entermonitor $r6
$b3 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte get()>()
==============

==============
 tn units (no order)
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte set(byte)>($b4)
$b6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte get()>()
entermonitor $r7
exitmonitor r5
$r8 := @caughtexception
$b3 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte get()>()
exitmonitor r5
$b4 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte set(byte)>($b3)
==============

==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor r1
$i1 = $b0 + 1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_> = $b2
entermonitor $r2
$b2 = (byte) $i1
$b0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
exitmonitor r1
==============

==============
 tn units (no order)
$i1 = $b0 - 1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_> = $b2
exitmonitor r1
exitmonitor r1
$r4 := @caughtexception
$b2 = (byte) $i1
$b0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
entermonitor $r2
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_> = $b3
$i2 = $b1 + b0
exitmonitor r1
$r4 := @caughtexception
exitmonitor r1
entermonitor $r2
$b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
$b3 = (byte) $i2
==============

==============
 tn units (no order)
$b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_> = $b3
$i2 = $b1 - b0
$r4 := @caughtexception
entermonitor $r2
exitmonitor r1
exitmonitor r1
$b3 = (byte) $i2
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte
$b3 = (byte) $i2
exitmonitor r1
exitmonitor r1
$r4 := @caughtexception
return $b3
$i2 = $b1 * b0
entermonitor $r2
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: java.lang.Object lock_>
throw $r4
$b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_> = $b3
b0 := @parameter0: byte
==============

==============
 tn units (no order)
exitmonitor r1
$b3 = (byte) $i2
$i2 = $b1 * b0
entermonitor $r2
exitmonitor r1
$b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_> = $b3
$r4 := @caughtexception
==============

==============
 tn units (no order)
$b3 = (byte) $i2
$r4 := @caughtexception
exitmonitor r1
$b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_> = $b3
$i2 = $b1 / b0
exitmonitor r1
entermonitor $r2
==============

==============
 tn units (no order)
$r3 := @caughtexception
entermonitor $r2
$b2 = (byte) $b1
$b3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
$b0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
$b1 = neg $b0
exitmonitor r1
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_> = $b2
==============

==============
 tn units (no order)
$b2 = (byte) $b1
exitmonitor r1
$b3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
entermonitor $r2
exitmonitor r1
$b1 = $b0 ^ -1
$r3 := @caughtexception
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_> = $b2
$b0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
==============

==============
 tn units (no order)
$r3 := @caughtexception
$b4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
$b3 = (byte) $b2
exitmonitor r1
entermonitor $r2
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_> = $b3
$b2 = $b1 & b0
$b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
==============

==============
 tn units (no order)
$r3 := @caughtexception
$b2 = $b1 | b0
$b3 = (byte) $b2
exitmonitor r1
$b4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
$b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
entermonitor $r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_> = $b3
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_> = $b3
$b1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
$b3 = (byte) $b2
$r3 := @caughtexception
exitmonitor r1
$b4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte: byte value_>
$b2 = $b1 ^ b0
entermonitor $r2
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.PrioritySemaphore$PriorityWaitQueue... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue... 
==============
 tn units (no order)
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_>
$r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: java.lang.Object putLock_>
virtualinvoke $r10.<java.lang.Object: void notify()>()
$r11 := @caughtexception
$r8.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode next> = r3
entermonitor $r5
$r9 := @caughtexception
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode last_>
goto [?= $i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_>]
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode last_>
if $i0 <= 0 goto exitmonitor r2
specialinvoke $r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: void <init>(java.lang.Object)>(r1)
r3 = $r6
exitmonitor r4
exitmonitor r2
$r6 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode last_> = r3
exitmonitor r2
throw $r9
entermonitor $r7
exitmonitor r4
==============

==============
 tn units (no order)
exitmonitor r4
$r8.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode next> = r3
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode last_> = r3
$r9 := @caughtexception
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode last_>
entermonitor $r7
exitmonitor r4
==============

==============
 tn units (no order)
exitmonitor r1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue
r2 = null
return r2
throw $r7
if r3 == null goto exitmonitor r1
r3 = $r5.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode next>
exitmonitor r1
r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: java.lang.Object value> = null
entermonitor $r4
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode head_> = r3
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode head_>
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode head_>
r2 = r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: java.lang.Object value>
$r7 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r1
r2 = null
if r3 == null goto exitmonitor r1
r3 = $r5.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode next>
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode head_> = r3
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode head_>
r2 = r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: java.lang.Object value>
r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: java.lang.Object value> = null
$r7 := @caughtexception
entermonitor $r4
==============

==============
 tn units (no order)
r3 = $r11
$r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: java.lang.Object putLock_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_> = $i5
$i1 = $i0 + 1
exitmonitor r2
$i3 = $i2 - 1
throw r3
$r13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: java.lang.Object putLock_>
$i5 = $i4 - 1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_> = $i3
virtualinvoke $r13.<java.lang.Object: void notify()>()
$r11 := @caughtexception
$i2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_> = $i1
$r14 := @caughtexception
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_>
r7 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: java.lang.Object extract()>()
virtualinvoke $r10.<java.lang.Object: void wait()>()
goto [?= r7 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: java.lang.Object extract()>()]
entermonitor $r5
exitmonitor r2
$i4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_>
if r7 == null goto $r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: java.lang.Object putLock_>
==============

==============
 tn units (no order)
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode head_>
$r6 := @caughtexception
if r2 == null goto exitmonitor r1
r2 = $r4.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode next>
exitmonitor r1
exitmonitor r1
entermonitor $r3
$r5 = r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: java.lang.Object value>
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode head_>
$z0 = 1
$r4 = $r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode: benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode next>
exitmonitor r1
if $r4 != null goto $z0 = 0
$r5 := @caughtexception
$z0 = 0
entermonitor $r2
goto [?= exitmonitor r1]
==============

==============
 tn units (no order)
$r13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: java.lang.Object putLock_>
virtualinvoke $r9.<java.lang.Object: void wait(long)>(l1)
exitmonitor r2
$l4 = 0L
$l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
exitmonitor r2
$r10 := @caughtexception
$b7 = l1 cmp 0L
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_> = $i6
if $b7 > 0 goto $r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: java.lang.Object putLock_>
$r14 := @caughtexception
$i13 = $i12 - 1
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: java.lang.Object putLock_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_> = $i13
$l10 = staticinvoke <java.lang.System: long currentTimeMillis()>()
l2 = $l4
$b3 = l0 cmp 0L
$i12 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_>
$i9 = $i8 - 1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_> = $i9
$i8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_>
if r6 != null goto $i8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_>
$l11 = $l10 - l2
goto [?= l2 = $l4]
l1 = l0
throw r11
r6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: java.lang.Object extract()>()
if $b3 > 0 goto $l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$i6 = $i5 + 1
entermonitor $r4
r11 = $r10
l1 = l0 - $l11
virtualinvoke $r13.<java.lang.Object: void notify()>()
$i5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: int waitingForTake_>
goto [?= r6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue: java.lang.Object extract()>()]
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.LockedExecutor... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.CountDown... 
==============
 tn units (no order)
$r4 := @caughtexception
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CountDown: int count_>
goto [?= $i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CountDown: int count_>]
entermonitor r0
virtualinvoke r0.<java.lang.Object: void wait()>()
exitmonitor r1
exitmonitor r1
if $i0 > 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
==============

==============
 tn units (no order)
entermonitor r0
$b4 = l0 cmp 0L
if $i5 > 0 goto $l6 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$i5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CountDown: int count_>
$b8 = l1 cmp 0L
l1 = l0
if $i3 > 0 goto $b4 = l0 cmp 0L
exitmonitor r1
exitmonitor r1
$i3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CountDown: int count_>
$l6 = staticinvoke <java.lang.System: long currentTimeMillis()>()
exitmonitor r1
if $b8 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
$r4 := @caughtexception
exitmonitor r1
l1 = l0 - $l7
l2 = staticinvoke <java.lang.System: long currentTimeMillis()>()
exitmonitor r1
if $b4 > 0 goto l1 = l0
$l7 = $l6 - l2
virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
==============

==============
 tn units (no order)
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
$i1 = $i0 - 1
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CountDown: int count_>
return
if $i1 != 0 goto return
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CountDown: int count_> = $i1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CountDown
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CountDown
return $i0
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CountDown: int count_>
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$RunLoop... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$DiscardWhenBlocked... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap... 
==============
 tn units (no order)
$r10[i7] = $r12
return
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
$i6 = lengthof $r6
i7 = i10
$r9 = $r8[i10]
$i8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int count_>
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
if i7 > 0 goto i10 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int parent(int)>(i7)
$i3 = lengthof $r4
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
$r13[i7] = r1
$i2 = lengthof $r3
r2 = newarray (java.lang.Object)[i0]
$i4 = 3 * $i3
$i11 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int compare(java.lang.Object,java.lang.Object)>(r1, $r9)
if $i1 < $i2 goto i7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int count_>
$i9 = $i8 + 1
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
i7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int count_>
goto [?= (branch)]
$r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
i0 = $i5 + 1
r1 := @parameter0: java.lang.Object
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r5, 0, r2, 0, $i6)
if $i11 >= 0 goto $r13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
i10 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int parent(int)>(i7)
$r13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
$i1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int count_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int count_> = $i9
$r12 = $r11[i10]
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
$i5 = $i4 / 2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_> = r2
$r11 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
==============

==============
 tn units (no order)
$r12[i0] = $r14
goto [?= i3 = $i11]
$i6 = $i5 - 1
$r14 = $r13[i3]
return r1
$i9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int count_>
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
$r7 = $r6[i1]
$r9 = $r8[i2]
return null
$r15[i0] = r2
i0 = i3
i3 = $i11
if $i4 >= 1 goto i0 = 0
$i11 = i2
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
$i10 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int compare(java.lang.Object,java.lang.Object)>($r7, $r9)
goto [?= $r15 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>]
$i5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int count_>
if i1 < $i8 goto i2 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int right(int)>(i0)
$r13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int count_> = $i6
$r11 = $r10[i3]
$i7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int count_>
$i11 = i1
$i8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int count_>
if $i10 >= 0 goto $i11 = i2
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap
$i4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int count_>
i2 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int right(int)>(i0)
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
if $i12 <= 0 goto $r15 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
i0 = 0
$r15 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
$i12 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int compare(java.lang.Object,java.lang.Object)>(r2, $r11)
$r12 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
i1 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int left(int)>(i0)
if i2 >= $i9 goto $i11 = i1
$r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
goto [?= i1 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int left(int)>(i0)]
r2 = $r5[$i7]
r1 = $r3[i0]
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object[] nodes_>
$r2 = $r1[0]
if $i0 <= 0 goto return null
return $r2
return null
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int count_>
==============

==============
 tn units (no order)
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int count_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap
return $i0
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: int count_> = 0
return
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock... 
==============
 tn units (no order)
entermonitor r0
virtualinvoke $r9.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: void cancelledWaitingWriter()>()
r1 = r3
virtualinvoke r0.<java.lang.Object: void notify()>()
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
if $z2 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
exitmonitor r2
$r8 := @caughtexception
r3 = $r8
exitmonitor r2
$r10 := @caughtexception
if $z1 != 0 goto exitmonitor r2
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
virtualinvoke r0.<java.lang.Object: void wait()>()
$z2 = virtualinvoke $r7.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean startWriteFromWaitingWriter()>()
exitmonitor r2
$z1 = virtualinvoke $r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean startWriteFromNewWriter()>()
==============

==============
 tn units (no order)
virtualinvoke r0.<java.lang.Object: void notify()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock
return
==============

==============
 tn units (no order)
virtualinvoke r0.<java.lang.Object: void notify()>()
l1 = l0
$z1 = virtualinvoke $r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean startWrite()>()
goto [?= exitmonitor r2]
$b6 = l1 cmp 0L
virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
l1 = l0 - $l5
virtualinvoke $r9.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: void cancelledWaitingWriter()>()
$z3 = virtualinvoke $r10.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean startWriteFromWaitingWriter()>()
exitmonitor r2
$l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
virtualinvoke $r11.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: void cancelledWaitingWriter()>()
$z2 = virtualinvoke $r7.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean startWriteFromNewWriter()>()
$r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
exitmonitor r2
$r8 := @caughtexception
l2 = staticinvoke <java.lang.System: long currentTimeMillis()>()
exitmonitor r2
r1 = r3
entermonitor r0
if $z2 == 0 goto l1 = l0
if $b3 > 0 goto $r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
r3 = $r8
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
$r11 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
exitmonitor r2
$l5 = $l4 - l2
$r12 := @caughtexception
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
$b3 = l0 cmp 0L
virtualinvoke r0.<java.lang.Object: void notify()>()
goto [?= $r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>]
if $z3 == 0 goto $l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
if $b6 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
exitmonitor r2
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong... 
==============
 tn units (no order)
entermonitor $r2
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$l1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long set(long)>(l0)
exitmonitor r1
$r4 := @caughtexception
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
exitmonitor r1
==============

==============
 tn units (no order)
z0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: boolean commit(long,long)>(l0, l1)
if z0 == 0 goto exitmonitor r1
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
$r4 := @caughtexception
entermonitor $r2
==============

==============
 tn units (no order)
$l0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long increment()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
exitmonitor r1
$r4 := @caughtexception
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
entermonitor $r2
==============

==============
 tn units (no order)
exitmonitor r1
$l0 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long decrement()>()
$r4 := @caughtexception
exitmonitor r1
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
entermonitor $r2
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
$r4 := @caughtexception
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
entermonitor $r2
exitmonitor r1
exitmonitor r1
$l1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long add(long)>(l0)
==============

==============
 tn units (no order)
$r4 := @caughtexception
entermonitor $r2
exitmonitor r1
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
exitmonitor r1
$l1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long subtract(long)>(l0)
==============

==============
 tn units (no order)
$r4 := @caughtexception
$l1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long multiply(long)>(l0)
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
exitmonitor r1
entermonitor $r2
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
virtualinvoke $r3.<java.lang.Object: void notifyAll()>()
exitmonitor r1
exitmonitor r1
entermonitor $r2
$r4 := @caughtexception
$l1 = specialinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long divide(long)>(l0)
==============

==============
 tn units (no order)
virtualinvoke $r4.<java.lang.Object: void wait()>()
$b2 = $l1 cmp l0
if $b2 != 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
entermonitor $r3
goto [?= $l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: long value_>]
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$r5 := @caughtexception
if r1 == null goto exitmonitor r2
exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
exitmonitor r2
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: long value_>
==============

==============
 tn units (no order)
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$b2 = $l1 cmp l0
exitmonitor r2
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: long value_>
exitmonitor r2
if r1 == null goto exitmonitor r2
goto [?= $l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: long value_>]
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
virtualinvoke $r4.<java.lang.Object: void wait()>()
if $b2 == 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
entermonitor $r3
$r5 := @caughtexception
==============

==============
 tn units (no order)
if $b2 > 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: long value_>
virtualinvoke $r4.<java.lang.Object: void wait()>()
if r1 == null goto exitmonitor r2
goto [?= $l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: long value_>]
entermonitor $r3
$b2 = $l1 cmp l0
exitmonitor r2
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
exitmonitor r2
$r5 := @caughtexception
==============

==============
 tn units (no order)
goto [?= $l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: long value_>]
if $b2 >= 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
entermonitor $r3
exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
if r1 == null goto exitmonitor r2
exitmonitor r2
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: long value_>
$b2 = $l1 cmp l0
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$r5 := @caughtexception
virtualinvoke $r4.<java.lang.Object: void wait()>()
==============

==============
 tn units (no order)
$r5 := @caughtexception
$b2 = $l1 cmp l0
if r1 == null goto exitmonitor r2
exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
if $b2 < 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
goto [?= $l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: long value_>]
exitmonitor r2
virtualinvoke $r4.<java.lang.Object: void wait()>()
entermonitor $r3
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: long value_>
==============

==============
 tn units (no order)
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: long value_>
goto [?= $l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: long value_>]
if r1 == null goto exitmonitor r2
if $b2 <= 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
$b2 = $l1 cmp l0
interfaceinvoke r1.<java.lang.Runnable: void run()>()
$r5 := @caughtexception
exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong: java.lang.Object lock_>
virtualinvoke $r4.<java.lang.Object: void wait()>()
entermonitor $r3
exitmonitor r2
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.ObservableSync... 
==============
 tn units (no order)
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ObservableSync: java.lang.Object arg_>
return $r1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ObservableSync
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ObservableSync: java.lang.Object arg_> = r1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ObservableSync
return r2
r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ObservableSync: java.lang.Object arg_>
r1 := @parameter0: java.lang.Object
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.DirectExecutor... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort... 
==============
 tn units (no order)
$r3 := @caughtexception
entermonitor $r2
$s0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
exitmonitor r1
exitmonitor r1
==============

==============
 tn units (no order)
entermonitor $r2
$r3 := @caughtexception
exitmonitor r1
s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_> = s0
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_> = s1
$z1 = 0
z0 = $z1
entermonitor $r2
exitmonitor r1
exitmonitor r1
if s0 != $s2 goto $z1 = 0
if z0 == 0 goto exitmonitor r1
$z1 = 1
$s2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
goto [?= z0 = $z1]
$r3 := @caughtexception
==============

==============
 tn units (no order)
throw $r9
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short set(short)>($s4)
exitmonitor r5
entermonitor $r7
$s3 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short get()>()
$r8 := @caughtexception
throw $r8
exitmonitor r5
entermonitor $r6
exitmonitor r4
$r7 = r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: java.lang.Object lock_>
$s4 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short set(short)>($s3)
$s6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short get()>()
$r9 := @caughtexception
exitmonitor r4
==============

==============
 tn units (no order)
exitmonitor r5
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short set(short)>($s4)
$r8 := @caughtexception
$s3 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short get()>()
entermonitor $r7
$s6 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short get()>()
$s4 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short set(short)>($s3)
$r9 := @caughtexception
exitmonitor r4
exitmonitor r5
==============

==============
 tn units (no order)
$s0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_> = $s2
$r4 := @caughtexception
$s2 = (short) $i1
entermonitor $r2
exitmonitor r1
$i1 = $s0 + 1
exitmonitor r1
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_> = $s2
exitmonitor r1
exitmonitor r1
$s2 = (short) $i1
$s0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
$i1 = $s0 - 1
entermonitor $r2
$r4 := @caughtexception
==============

==============
 tn units (no order)
entermonitor $r2
$r4 := @caughtexception
$s3 = (short) $i2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_> = $s3
exitmonitor r1
exitmonitor r1
$i2 = $s1 + s0
$s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_> = $s3
entermonitor $r2
exitmonitor r1
exitmonitor r1
$s3 = (short) $i2
$s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
$r4 := @caughtexception
$i2 = $s1 - s0
==============

==============
 tn units (no order)
$s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
exitmonitor r1
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: java.lang.Object lock_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_> = $s3
$r4 := @caughtexception
$i2 = $s1 * s0
throw $r4
$s3 = (short) $i2
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort
return $s3
exitmonitor r1
s0 := @parameter0: short
entermonitor $r2
==============

==============
 tn units (no order)
exitmonitor r1
$s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_> = $s3
$r4 := @caughtexception
$i2 = $s1 * s0
$s3 = (short) $i2
entermonitor $r2
==============

==============
 tn units (no order)
entermonitor $r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_> = $s3
$i2 = $s1 / s0
exitmonitor r1
$s3 = (short) $i2
$r4 := @caughtexception
exitmonitor r1
$s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
==============

==============
 tn units (no order)
exitmonitor r1
$s2 = (short) $s1
$s1 = neg $s0
$s3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
entermonitor $r2
exitmonitor r1
$r3 := @caughtexception
$s0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_> = $s2
==============

==============
 tn units (no order)
$r3 := @caughtexception
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_> = $s2
$s2 = (short) $s1
$s0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
exitmonitor r1
exitmonitor r1
entermonitor $r2
$s1 = $s0 ^ -1
$s3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
==============

==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
$r3 := @caughtexception
$s3 = (short) $s2
$s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
$s2 = $s1 & s0
entermonitor $r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_> = $s3
$s4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_> = $s3
entermonitor $r2
$r3 := @caughtexception
exitmonitor r1
exitmonitor r1
$s4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
$s3 = (short) $s2
$s2 = $s1 | s0
$s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
==============

==============
 tn units (no order)
$s1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
entermonitor $r2
$r3 := @caughtexception
$s2 = $s1 ^ s0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_> = $s3
exitmonitor r1
exitmonitor r1
$s3 = (short) $s2
$s4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort: short value_>
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock... 
==============
 tn units (no order)
$r10 := @caughtexception
entermonitor r0
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
$z1 = virtualinvoke $r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean startReadFromNewReader()>()
virtualinvoke $r9.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: void cancelledWaitingReader()>()
$z2 = virtualinvoke $r7.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean startReadFromWaitingReader()>()
if $z2 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
$r8 := @caughtexception
r1 = r3
exitmonitor r2
if $z1 != 0 goto exitmonitor r2
virtualinvoke r0.<java.lang.Object: void wait()>()
exitmonitor r2
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
r3 = $r8
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
exitmonitor r2
==============

==============
 tn units (no order)
return
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock
==============

==============
 tn units (no order)
$z1 = virtualinvoke $r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean startRead()>()
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
exitmonitor r2
entermonitor r0
if $b3 > 0 goto $r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
$r11 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
$r8 := @caughtexception
virtualinvoke $r11.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: void cancelledWaitingReader()>()
exitmonitor r2
$z3 = virtualinvoke $r10.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean startReadFromWaitingReader()>()
if $z3 == 0 goto $l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
l2 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$l5 = $l4 - l2
$z2 = virtualinvoke $r7.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: boolean startReadFromNewReader()>()
$r12 := @caughtexception
$l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
goto [?= exitmonitor r2]
$b6 = l1 cmp 0L
r1 = r3
l1 = l0 - $l5
$b3 = l0 cmp 0L
goto [?= $r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>]
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
if $b6 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
virtualinvoke $r9.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock: void cancelledWaitingReader()>()
exitmonitor r2
exitmonitor r2
$r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock: benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock this$0>
if $z2 == 0 goto l1 = l0
r3 = $r8
exitmonitor r2
l1 = l0
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Sync... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedChannel... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon... 
==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon
return $r1
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: java.lang.Thread thread_>
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon
return
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: java.lang.Thread thread_> = null
==============

==============
 tn units (no order)
$r4 = interfaceinvoke $r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory: java.lang.Thread newThread(java.lang.Runnable)>($r3)
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$RunLoop runLoop_>
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: java.lang.Thread thread_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: java.lang.Thread thread_> = $r4
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory threadFactory_>
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: java.lang.Thread thread_>
goto [?= return]
if $r1 != null goto virtualinvoke r0.<java.lang.Object: void notify()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon
return
virtualinvoke $r5.<java.lang.Thread: void start()>()
virtualinvoke r0.<java.lang.Object: void notify()>()
==============

==============
 tn units (no order)
return
virtualinvoke $r3.<java.lang.Thread: void interrupt()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: java.lang.Thread thread_> = null
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: java.lang.Thread thread_>
virtualinvoke $r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: void clear()>()
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap heap_>
if $r2 == null goto r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: java.lang.Thread thread_> = null
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: java.lang.Thread thread_>
==============

==============
 tn units (no order)
r6 = (benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode) $r5
$l6 = r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode: long period>
l1 = virtualinvoke r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode: long getTimeToRun()>()
if $z0 != 0 goto $z1 = staticinvoke <java.lang.Thread: boolean interrupted()>()
$l3 = l1 - l0
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap heap_>
if r1 != null goto l0 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap heap_>
$z1 = staticinvoke <java.lang.Thread: boolean interrupted()>()
$b5 = $l4 cmp 0L
return r6
$r9 := @caughtexception
virtualinvoke r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode: void setTimeToRun(long)>($l7)
$r3 = virtualinvoke $r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object peek()>()
goto [?= $z1 = staticinvoke <java.lang.Thread: boolean interrupted()>()]
virtualinvoke r0.<java.lang.Object: void wait(long)>($l3)
if $z1 == 0 goto $r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap heap_>
$r5 = virtualinvoke $r4.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: java.lang.Object extract()>()
return null
l0 = staticinvoke <java.lang.System: long currentTimeMillis()>()
goto [?= $z1 = staticinvoke <java.lang.Thread: boolean interrupted()>()]
goto [?= $z1 = staticinvoke <java.lang.Thread: boolean interrupted()>()]
virtualinvoke $r7.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap: void insert(java.lang.Object)>(r6)
if $b2 <= 0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap heap_>
$l7 = l0 + $l6
$z0 = virtualinvoke r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode: boolean getCancelled()>()
$b2 = l1 cmp l0
$l4 = r6.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode: long period>
r1 = (benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode) $r3
goto [?= return null]
r10 = $r9
if $b5 <= 0 goto return r6
virtualinvoke r0.<java.lang.Object: void wait()>()
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon: benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap heap_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup$InvokableFJTask... 
==============
 tn units (no order)
return
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup$InvokableFJTask: boolean terminated> = 1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup$InvokableFJTask
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
==============

==============
 tn units (no order)
if $z0 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
$z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup$InvokableFJTask: boolean terminated>
virtualinvoke r0.<java.lang.Object: void wait()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup$InvokableFJTask
return
goto [?= $z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup$InvokableFJTask: boolean terminated>]
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor... 
==============
 tn units (no order)
if $i3 >= $i4 goto exitmonitor r1
$i4 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: int getMaximumPoolSize()>()
goto [?= exitmonitor r1]
exitmonitor r1
$i3 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: int getPoolSize()>()
entermonitor $r2
exitmonitor r1
$r3 := @caughtexception
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: void addThread(java.lang.Runnable)>(null)
exitmonitor r1
i1 = i1 + 1
==============

==============
 tn units (no order)
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: java.util.Map threads_>
r3 = (java.lang.Thread) $r7
exitmonitor r1
$z0 = interfaceinvoke r2.<java.util.Iterator: boolean hasNext()>()
virtualinvoke r3.<java.lang.Thread: void interrupt()>()
r2 = interfaceinvoke $r6.<java.util.Collection: java.util.Iterator iterator()>()
if $z0 != 0 goto $r7 = interfaceinvoke r2.<java.util.Iterator: java.lang.Object next()>()
goto [?= $z0 = interfaceinvoke r2.<java.util.Iterator: boolean hasNext()>()]
$r7 = interfaceinvoke r2.<java.util.Iterator: java.lang.Object next()>()
exitmonitor r1
entermonitor $r4
$r6 = interfaceinvoke $r5.<java.util.Map: java.util.Collection values()>()
$r8 := @caughtexception
==============

==============
 tn units (no order)
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: long keepAliveTime_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor
return $l0
==============

==============
 tn units (no order)
l0 := @parameter0: long
return
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: long keepAliveTime_> = l0
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: int poolSize_> = $i1
entermonitor $r3
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: java.util.Map threads_>
interfaceinvoke $r5.<java.util.Map: java.lang.Object remove(java.lang.Object)>(r1)
exitmonitor r2
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: int poolSize_>
exitmonitor r2
$i1 = $i0 - 1
$r7 := @caughtexception
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor
return $r1
$r1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$BlockedExecutionHandler blockedExecutionHandler_>
==============

==============
 tn units (no order)
specialinvoke $r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$RunWhenBlocked: void <init>(benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor)>(r0)
return
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$BlockedExecutionHandler blockedExecutionHandler_> = $r1
$r1 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$RunWhenBlocked
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor
==============

==============
 tn units (no order)
specialinvoke $r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$WaitWhenBlocked: void <init>(benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor)>(r0)
return
$r1 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$WaitWhenBlocked
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$BlockedExecutionHandler blockedExecutionHandler_> = $r1
==============

==============
 tn units (no order)
$r1 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$DiscardWhenBlocked
specialinvoke $r1.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$DiscardWhenBlocked: void <init>(benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor)>(r0)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$BlockedExecutionHandler blockedExecutionHandler_> = $r1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor
return
==============

==============
 tn units (no order)
$r5 := @caughtexception
exitmonitor r2
exitmonitor r2
exitmonitor r2
if $z0 == 0 goto $i2 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: int getPoolSize()>()
$i1 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: int getMinimumPoolSize()>()
if $i2 >= $i3 goto exitmonitor r2
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: void addThread(java.lang.Runnable)>(r1)
exitmonitor r2
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: benchmarks.EDU.oswego.cs.dl.util.concurrent.Channel handOff_>
$i3 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: int getMaximumPoolSize()>()
$z0 = interfaceinvoke $r4.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Channel: boolean offer(java.lang.Object,long)>(r1, 0L)
entermonitor $r3
$i0 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: int getPoolSize()>()
if $i0 >= $i1 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: benchmarks.EDU.oswego.cs.dl.util.concurrent.Channel handOff_>
virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: void addThread(java.lang.Runnable)>(r1)
$i2 = virtualinvoke r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor: int getPoolSize()>()
exitmonitor r2
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Channel... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore... 
==============
 tn units (no order)
$r6 := @caughtexception
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_> = $l3
$b1 = $l0 cmp 0L
goto [?= exitmonitor r1]
exitmonitor r1
exitmonitor r1
$r7 := @caughtexception
throw r2
if $b1 <= 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
r2 = $r6
$l2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_>
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_>
virtualinvoke r0.<java.lang.Object: void wait()>()
entermonitor r0
goto [?= $l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_>]
$l3 = $l2 - 1L
virtualinvoke r0.<java.lang.Object: void notify()>()
==============

==============
 tn units (no order)
virtualinvoke r0.<java.lang.Object: void wait(long)>(l2)
l1 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$l13 = $l12 - l1
$b7 = l0 cmp 0L
throw r7
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_> = $l6
$l10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_>
$l6 = $l5 - 1L
virtualinvoke r0.<java.lang.Object: void notify()>()
exitmonitor r1
$l8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_>
if $b7 > 0 goto l1 = staticinvoke <java.lang.System: long currentTimeMillis()>()
l2 = l0
$l12 = staticinvoke <java.lang.System: long currentTimeMillis()>()
entermonitor r0
$l11 = $l10 - 1L
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_> = $l11
l2 = l0 - $l13
$b4 = $l3 cmp 0L
exitmonitor r1
$l5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_>
if $b4 <= 0 goto $b7 = l0 cmp 0L
exitmonitor r1
$r6 := @caughtexception
$r8 := @caughtexception
$b9 = $l8 cmp 0L
exitmonitor r1
exitmonitor r1
$l3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_>
if $b14 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l2)
if $b9 <= 0 goto $l12 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$b14 = l2 cmp 0L
r7 = $r6
==============

==============
 tn units (no order)
$l1 = $l0 + 1L
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_>
virtualinvoke r0.<java.lang.Object: void notify()>()
return
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_> = $l1
==============

==============
 tn units (no order)
l1 = l1 + 1L
goto [?= $b5 = l1 cmp l0]
$b5 = l1 cmp l0
$r1 = new java.lang.IllegalArgumentException
specialinvoke $r1.<java.lang.IllegalArgumentException: void <init>(java.lang.String)>("Negative argument")
$l3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_>
if $b2 >= 0 goto $l3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_>
$l4 = $l3 + l0
throw $r1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore
$b2 = l0 cmp 0L
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_> = $l4
if $b5 < 0 goto virtualinvoke r0.<java.lang.Object: void notify()>()
return
l1 = 0L
l0 := @parameter0: long
virtualinvoke r0.<java.lang.Object: void notify()>()
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore: long permits_>
return $l0
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$WaitWhenBlocked... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Takable... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactoryUser$DefaultThreadFactory... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster... 
==============
 tn units (no order)
return $r3
$r3 = (benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster) $r5
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster
$r3 = null
r1 := @parameter0: java.lang.String
goto [?= return $r3]
if $r2 != null goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
$r5 = virtualinvoke $r4.<java.util.HashMap: java.lang.Object get(java.lang.Object)>(r1)
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
==============

==============
 tn units (no order)
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
r2[i0] = r1
return
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster
$i1 = i0 + 1
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r5, 0, r2, 0, i0)
r2 = newarray (java.beans.VetoableChangeListener)[$i1]
throw $r3
if i0 <= 0 goto r2[i0] = r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners> = r2
i0 = lengthof $r4
if r1 != null goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
specialinvoke $r3.<java.lang.NullPointerException: void <init>()>()
$r3 = new java.lang.NullPointerException
r1 := @parameter0: java.beans.VetoableChangeListener
==============

==============
 tn units (no order)
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
return
return
$r8 = $r7[i1]
$r3 = new java.lang.NullPointerException
if r1 != null goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster
r2 = newarray (java.beans.VetoableChangeListener)[$i2]
r1 := @parameter0: java.beans.VetoableChangeListener
$i2 = i0 + 1
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
i0 = lengthof $r4
specialinvoke $r3.<java.lang.NullPointerException: void <init>()>()
r2[i1] = $r6
i1 = 0
i1 = i1 + 1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners> = r2
throw $r3
if i1 < i0 goto $r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r8)
if $z0 == 0 goto i1 = i1 + 1
r2[i0] = r1
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
$r6 = $r5[i1]
goto [?= (branch)]
==============

==============
 tn units (no order)
if $z1 == 0 goto return
$r5 = $r4[i1]
if i1 < i0 goto $r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
r2[$i4] = $r7
goto [?= (branch)]
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners> = r2
$i4 = i2 - 1
r2 = newarray (java.beans.VetoableChangeListener)[i0]
if r1 != null goto r2 = newarray (java.beans.VetoableChangeListener)[i0]
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
if $z0 == 0 goto $r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
$r10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r5)
if i0 < 0 goto return
i1 = 0
r1 := @parameter0: java.beans.VetoableChangeListener
i1 = i1 + 1
$r7 = $r6[i2]
goto [?= (branch)]
return
return
return
$z1 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r11)
r2[i1] = $r9
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
i2 = i1 + 1
i2 = i2 + 1
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
$r11 = $r10[i0]
i0 = $i3 - 1
$i3 = lengthof $r3
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners> = r2
if i2 <= i0 goto $i4 = i2 - 1
$r9 = $r8[i1]
==============

==============
 tn units (no order)
r3 = (benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster) $r10
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
$r8 = new java.util.HashMap
$r13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
specialinvoke $r11.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: void <init>(java.lang.Object)>($r12)
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
if r3 != null goto exitmonitor r4
$r10 = virtualinvoke $r9.<java.util.HashMap: java.lang.Object get(java.lang.Object)>(r1)
entermonitor r0
$r12 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.lang.Object source>
r3 = $r11
$r11 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster
$r15 := @caughtexception
virtualinvoke $r13.<java.util.HashMap: java.lang.Object put(java.lang.Object,java.lang.Object)>(r1, r3)
exitmonitor r4
goto [?= (branch)]
if $r7 != null goto $r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
exitmonitor r4
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children> = $r8
specialinvoke $r8.<java.util.HashMap: void <init>()>()
==============

==============
 tn units (no order)
$r13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
if $r7 != null goto $r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
if r3 != null goto exitmonitor r4
r3 = $r11
exitmonitor r4
virtualinvoke $r13.<java.util.HashMap: java.lang.Object put(java.lang.Object,java.lang.Object)>(r1, r3)
entermonitor r0
$r10 = virtualinvoke $r9.<java.util.HashMap: java.lang.Object get(java.lang.Object)>(r1)
goto [?= (branch)]
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
$r15 := @caughtexception
specialinvoke $r11.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: void <init>(java.lang.Object)>($r12)
r3 = (benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster) $r10
$r8 = new java.util.HashMap
exitmonitor r4
specialinvoke $r8.<java.util.HashMap: void <init>()>()
$r12 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.lang.Object source>
$r11 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children> = $r8
==============

==============
 tn units (no order)
$r12 = virtualinvoke r1.<java.beans.PropertyChangeEvent: java.lang.String getPropertyName()>()
$r13 = virtualinvoke $r11.<java.util.HashMap: java.lang.Object get(java.lang.Object)>($r12)
exitmonitor r3
r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
$r11 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
if $r9 == null goto exitmonitor r3
$r10 = virtualinvoke r1.<java.beans.PropertyChangeEvent: java.lang.String getPropertyName()>()
entermonitor r0
$r9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
r2 = (benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster) $r13
$r14 := @caughtexception
if $r10 == null goto exitmonitor r3
exitmonitor r3
==============

==============
 tn units (no order)
$r9 := @caughtexception
exitmonitor r3
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
r4 = (benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster) $r8
entermonitor r0
exitmonitor r3
if $r6 != null goto $r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.util.HashMap children>
exitmonitor r3
exitmonitor r3
$r8 = virtualinvoke $r7.<java.util.HashMap: java.lang.Object get(java.lang.Object)>(r1)
exitmonitor r3
$i0 = lengthof $r5
if $i0 <= 0 goto (branch)
if r1 == null goto exitmonitor r3
$r5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
if r4 != null goto exitmonitor r3
==============

==============
 tn units (no order)
virtualinvoke r1.<java.io.ObjectOutputStream: void writeObject(java.lang.Object)>(null)
$r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
r2 = $r3[i0]
$r6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
r1 := @parameter0: java.io.ObjectOutputStream
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster
$z0 = $r5 instanceof java.io.Serializable
goto [?= $r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>]
$r5 = $r4[i0]
$r7 = $r6[i0]
if i0 < $i1 goto $r3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
i0 = 0
virtualinvoke r1.<java.io.ObjectOutputStream: void writeObject(java.lang.Object)>($r7)
$r4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster: java.beans.VetoableChangeListener[] listeners>
$i1 = lengthof $r8
if $z0 == 0 goto i0 = i0 + 1
virtualinvoke r1.<java.io.ObjectOutputStream: void defaultWriteObject()>()
i0 = i0 + 1
return
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$Signaller... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.PrioritySemaphore... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong... 
==============
 tn units (no order)
$r3 := @caughtexception
exitmonitor r1
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
entermonitor $r2
exitmonitor r1
==============

==============
 tn units (no order)
l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_> = l0
exitmonitor r1
entermonitor $r2
$r3 := @caughtexception
==============

==============
 tn units (no order)
$z1 = 1
z0 = $z1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_> = l1
$b3 = l0 cmp $l2
$r3 := @caughtexception
entermonitor $r2
goto [?= z0 = $z1]
exitmonitor r1
$z1 = 0
if $b3 != 0 goto $z1 = 0
$l2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
exitmonitor r1
if z0 == 0 goto exitmonitor r1
==============

==============
 tn units (no order)
throw $r8
$r7 = r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: java.lang.Object lock_>
$l2 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long get()>()
$r8 := @caughtexception
entermonitor $r7
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long set(long)>($l3)
entermonitor $r6
exitmonitor r4
$l3 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long set(long)>($l2)
exitmonitor r4
$r9 := @caughtexception
exitmonitor r5
goto [?= exitmonitor r4]
exitmonitor r5
==============

==============
 tn units (no order)
$l3 = virtualinvoke r3.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long set(long)>($l2)
exitmonitor r5
$r8 := @caughtexception
$l2 = virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long get()>()
entermonitor $r7
exitmonitor r5
virtualinvoke r2.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long set(long)>($l3)
==============

==============
 tn units (no order)
entermonitor $r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_> = $l1
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
$l1 = $l0 + 1L
$r4 := @caughtexception
exitmonitor r1
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
$l1 = $l0 - 1L
entermonitor $r2
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
$r4 := @caughtexception
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_> = $l1
==============

==============
 tn units (no order)
$r4 := @caughtexception
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_> = $l2
$l2 = $l1 + l0
entermonitor $r2
exitmonitor r1
exitmonitor r1
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
==============

==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor r1
$l2 = $l1 - l0
entermonitor $r2
exitmonitor r1
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_> = $l2
==============

==============
 tn units (no order)
exitmonitor r1
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
$l2 = $l1 * l0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_> = $l2
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong
$r4 := @caughtexception
return $l2
throw $r4
exitmonitor r1
l0 := @parameter0: long
entermonitor $r2
$r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: java.lang.Object lock_>
==============

==============
 tn units (no order)
exitmonitor r1
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
$l2 = $l1 * l0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_> = $l2
$r4 := @caughtexception
exitmonitor r1
entermonitor $r2
==============

==============
 tn units (no order)
$l2 = $l1 / l0
exitmonitor r1
$r4 := @caughtexception
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
entermonitor $r2
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_> = $l2
==============

==============
 tn units (no order)
$r3 := @caughtexception
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
exitmonitor r1
$l2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_> = $l1
$l1 = neg $l0
entermonitor $r2
exitmonitor r1
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_> = $l1
$l1 = $l0 ^ -1L
exitmonitor r1
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
$l2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
entermonitor $r2
$r3 := @caughtexception
exitmonitor r1
==============

==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor r1
exitmonitor r1
$l3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_> = $l2
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
$l2 = $l1 & l0
entermonitor $r2
==============

==============
 tn units (no order)
exitmonitor r1
$r4 := @caughtexception
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_> = $l2
entermonitor $r2
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
exitmonitor r1
$l2 = $l1 | l0
$l3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
==============

==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
$l3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
$r4 := @caughtexception
$l2 = $l1 ^ l0
entermonitor $r2
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong: long value_> = $l2
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore... 
==============
 tn units (no order)
if $b8 <= 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
virtualinvoke r0.<java.lang.Object: void notify()>()
$l1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_>
throw r2
$l11 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_>
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_>
entermonitor r0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_> = $l10
exitmonitor r1
virtualinvoke r0.<java.lang.Object: void wait()>()
$l6 = $l5 + 1L
$b8 = $l7 cmp 0L
$r9 := @caughtexception
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_> = $l14
$l5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_>
exitmonitor r1
$l9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_>
$l3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_>
if $b2 <= 0 goto $l5 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_>
$l12 = $l11 - 1L
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_> = $l12
$l14 = $l13 - 1L
r2 = $r9
$l13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_> = $l4
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_> = $l6
exitmonitor r1
$r11 := @caughtexception
$l4 = $l3 - 1L
$l7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_>
$l10 = $l9 - 1L
$b2 = $l0 cmp $l1
==============

==============
 tn units (no order)
$b12 = $l11 cmp 0L
$l21 = $l20 - 1L
exitmonitor r1
l2 = l0 - $l18
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_> = $l23
$l14 = $l13 - 1L
$r12 := @caughtexception
$r10 := @caughtexception
if $b8 > 0 goto $l9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_>
$b8 = l0 cmp 0L
$l18 = $l17 - l1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_> = $l14
$l23 = $l22 - 1L
$l13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_>
$l4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_>
$l11 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_>
virtualinvoke r0.<java.lang.Object: void notify()>()
l2 = l0
if $b12 <= 0 goto $l17 = staticinvoke <java.lang.System: long currentTimeMillis()>()
exitmonitor r1
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_> = $l7
throw r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_> = $l21
exitmonitor r1
l1 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$l3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_>
exitmonitor r1
$b5 = $l3 cmp $l4
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_> = $l16
$l17 = staticinvoke <java.lang.System: long currentTimeMillis()>()
if $b5 <= 0 goto $b8 = l0 cmp 0L
r2 = $r10
$l6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_>
$b19 = l2 cmp 0L
if $b19 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l2)
$l10 = $l9 + 1L
$l7 = $l6 - 1L
$l16 = $l15 - 1L
entermonitor r0
$l20 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_> = $l10
exitmonitor r1
virtualinvoke r0.<java.lang.Object: void wait(long)>(l2)
$l22 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_>
$l15 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_>
$l9 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long waits_>
==============

==============
 tn units (no order)
return
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_> = $l1
$l0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore
$l1 = $l0 + 1L
virtualinvoke r0.<java.lang.Object: void notify()>()
==============

==============
 tn units (no order)
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore
l1 = l1 + 1L
$l2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_>
virtualinvoke r0.<java.lang.Object: void notify()>()
return
$b4 = l1 cmp l0
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore: long permits_> = $l3
if $b4 < 0 goto virtualinvoke r0.<java.lang.Object: void notify()>()
$l3 = $l2 + l0
goto [?= $b4 = l1 cmp l0]
l1 = 0L
l0 := @parameter0: long
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeoutSync... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncList$SyncCollectionListIterator... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask$Seq... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.Latch... 
==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
$r4 := @caughtexception
goto [?= $z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Latch: boolean latched_>]
virtualinvoke r0.<java.lang.Object: void wait()>()
$z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Latch: boolean latched_>
if $z1 == 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
entermonitor r0
==============

==============
 tn units (no order)
if $b6 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
l1 = l0
$z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Latch: boolean latched_>
l2 = staticinvoke <java.lang.System: long currentTimeMillis()>()
if $b3 > 0 goto l1 = l0
exitmonitor r1
entermonitor r0
exitmonitor r1
virtualinvoke r0.<java.lang.Object: void wait(long)>(l1)
exitmonitor r1
l1 = l0 - $l5
$l5 = $l4 - l2
$b6 = l1 cmp 0L
if $z1 == 0 goto $b3 = l0 cmp 0L
$r4 := @caughtexception
$b3 = l0 cmp 0L
exitmonitor r1
exitmonitor r1
$z2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Latch: boolean latched_>
$l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
if $z2 == 0 goto $l4 = staticinvoke <java.lang.System: long currentTimeMillis()>()
==============

==============
 tn units (no order)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Latch: boolean latched_> = 1
return
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.Latch
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncCollection$SyncCollectionIterator... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier... 
==============
 tn units (no order)
r2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: java.lang.Runnable barrierCommand_>
return r2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: java.lang.Runnable barrierCommand_> = r1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier
r1 := @parameter0: java.lang.Runnable
==============

==============
 tn units (no order)
$z0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: boolean broken_>
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier
return $z0
==============

==============
 tn units (no order)
$i1 = $i0 + 1
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier
$i2 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int parties_>
return
$i0 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int resets_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int count_> = $i2
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int resets_> = $i1
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: boolean broken_> = 0
==============

==============
 tn units (no order)
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: boolean broken_> = 1
$i6 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int parties_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int count_> = $i5
l2 = $l11
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int resets_> = $i8
if $b16 > 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l3)
$z3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: boolean broken_>
$r13 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.BrokenBarrierException
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: boolean broken_> = 1
if i1 != 0 goto (branch)
$i8 = $i7 + 1
throw r3
specialinvoke $r14.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeoutException: void <init>(long)>(l0)
$i13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int resets_>
$r10 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeoutException
throw $r13
$z1 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: boolean broken_>
if $i12 != i10 goto $r12 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
r2 = $r9
goto [?= $z3 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: boolean broken_>]
$r5 = new java.lang.InterruptedException
throw $r14
specialinvoke $r10.<benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeoutException: void <init>(long)>(l0)
return 0
l3 = l0
r0 := @this: benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier
goto [?= l2 = $l11]
throw $r4
throw $r5
i10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int resets_>
if z0 == 0 goto virtualinvoke r0.<java.lang.Object: void wait(long)>(l3)
$i12 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int resets_>
specialinvoke $r5.<java.lang.InterruptedException: void <init>()>()
if $b9 > 0 goto i10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int resets_>
$r7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: java.lang.Runnable barrierCommand_>
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: boolean broken_> = 1
$i5 = $i4 - 1
$l15 = $l14 - l2
$r9 := @caughtexception
$l11 = staticinvoke <java.lang.System: long currentTimeMillis()>()
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
$r14 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeoutException
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int count_> = $i6
if $z1 == 0 goto $z2 = staticinvoke <java.lang.Thread: boolean interrupted()>()
l3 = l0 - $l15
if $r7 == null goto return 0
if z0 == 0 goto $l11 = 0L
i1 = $i5
r3 = $r11
$l14 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$r12 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
$r4 = new benchmarks.EDU.oswego.cs.dl.util.concurrent.BrokenBarrierException
z0 := @parameter0: boolean
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: boolean broken_> = 1
l0 := @parameter1: long
if $z3 == 0 goto $i13 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int resets_>
$b16 = l3 cmp 0L
$r11 := @caughtexception
$r8 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: java.lang.Runnable barrierCommand_>
$z2 = staticinvoke <java.lang.Thread: boolean interrupted()>()
specialinvoke $r13.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BrokenBarrierException: void <init>(int)>(i1)
$i7 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int resets_>
throw $r10
virtualinvoke $r12.<java.lang.Thread: void interrupt()>()
specialinvoke $r4.<benchmarks.EDU.oswego.cs.dl.util.concurrent.BrokenBarrierException: void <init>(int)>(i1)
return 0
$i4 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int count_>
virtualinvoke r0.<java.lang.Object: void wait(long)>(l3)
r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: boolean broken_> = 1
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
$l11 = 0L
virtualinvoke r0.<java.lang.Object: void notifyAll()>()
return i1
$b9 = l0 cmp 0L
if $z2 == 0 goto (branch)
if z0 == 0 goto i10 = r0.<benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier: int resets_>
interfaceinvoke $r8.<java.lang.Runnable: void run()>()
if i10 == $i13 goto (branch)
==============

Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOSemaphore... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask$Par... 
Transforming benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArraySet... 
Transforming benchmarks.Account... 
==============
 tn units (no order)
exitmonitor r1
i1 = virtualinvoke r0.<benchmarks.Account: int read()>()
$r2 = r0.<benchmarks.Account: java.lang.Object L>
entermonitor $r2
return
r0.<benchmarks.Account: int balance> = $i2
exitmonitor r1
i0 := @parameter0: int
r0 := @this: benchmarks.Account
$i2 = i1 - i0
$r3 := @caughtexception
throw $r3
goto [?= return]
==============

==============
 tn units (no order)
exitmonitor r1
$i2 = i1 - i0
$r3 := @caughtexception
entermonitor $r2
r0.<benchmarks.Account: int balance> = $i2
exitmonitor r1
==============

==============
 tn units (no order)
i0 = r0.<benchmarks.Account: int balance>
exitmonitor r1
entermonitor $r2
exitmonitor r1
$r3 := @caughtexception
==============

==============
 tn units (no order)
$i1 = r0.<benchmarks.Account: int balance>
exitmonitor r1
$i2 = $i1 + i0
r0.<benchmarks.Account: int balance> = $i2
entermonitor $r2
exitmonitor r1
$r4 := @caughtexception
==============

Transforming benchmarks.hedc.MetaSearchImpl... 
Transforming benchmarks.hedc.TaskFactory... 
Transforming benchmarks.hedc.PooledExecutorWithInvalidate$RunWhenBlocked... 
Transforming benchmarks.hedc.Rag$RagIterator... 
Transforming benchmarks.hedc.PooledExecutorWithInvalidate$BlockedExecutionHandler... 
Transforming benchmarks.hedc.SohoSynoptic$SohoIterator... 
Transforming benchmarks.hedc.MetaSearchResult$MetaSearchResultIterator... 
Transforming benchmarks.hedc.PooledExecutorWithInvalidate$WaitWhenBlocked... 
Transforming benchmarks.hedc.MetaSearch... 
Transforming benchmarks.hedc.MetaSearchRequest... 
==============
 tn units (no order)
return
if $i1 != 0 goto return
virtualinvoke $r3.<java.lang.Thread: void interrupt()>()
$i0 = r0.<benchmarks.hedc.MetaSearchRequest: int counter_>
$r3 = r0.<benchmarks.hedc.MetaSearchRequest: java.lang.Thread thread_>
$r1 = r0.<benchmarks.hedc.MetaSearchRequest: java.lang.Thread thread_>
r0 := @this: benchmarks.hedc.MetaSearchRequest
$i1 = $i0 - 1
r0.<benchmarks.hedc.MetaSearchRequest: int counter_> = $i1
if $r1 == null goto return
==============

Transforming benchmarks.hedc.MetaSearchResult... 
==============
 tn units (no order)
if $r1 == null goto r0.<benchmarks.hedc.MetaSearchResult: benchmarks.hedc.MetaSearchRequest request> = null
return
$r2 = r0.<benchmarks.hedc.MetaSearchResult: java.lang.Thread thread_>
r0 := @this: benchmarks.hedc.MetaSearchResult
r0.<benchmarks.hedc.MetaSearchResult: benchmarks.hedc.MetaSearchRequest request> = null
virtualinvoke $r2.<java.lang.Thread: void interrupt()>()
r0.<benchmarks.hedc.MetaSearchResult: boolean valid> = 0
$r1 = r0.<benchmarks.hedc.MetaSearchResult: java.lang.Thread thread_>
==============

Transforming benchmarks.hedc.RandomDate... 
Transforming benchmarks.hedc.PooledExecutorWithInvalidate$Worker... 
Transforming benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer... 
==============
 tn units (no order)
if $i3 >= 0 goto return z0
$r4 = r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: benchmarks.hedc.ethz.util.DoubleBufferCopy this$0>
$i2 = r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: int bufferFill_>
$r8 = r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: byte[] buffer_>
$i6 = virtualinvoke $r7.<java.io.InputStream: int read(byte[],int,int)>($r8, 0, $i5)
z0 = 0
if $i7 >= 0 goto return z0
return z0
z0 = 1
virtualinvoke $r5.<java.io.OutputStream: void flush()>()
r0 := @this: benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer
$r9 = r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: byte[] buffer_>
i0 := @parameter0: int
if $i1 <= 0 goto $i3 = r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: int bufferFill_>
$r2 = staticinvoke <benchmarks.hedc.ethz.util.DoubleBufferCopy: java.io.OutputStream access$0(benchmarks.hedc.ethz.util.DoubleBufferCopy)>($r1)
$i5 = lengthof $r9
$i7 = r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: int bufferFill_>
$r5 = staticinvoke <benchmarks.hedc.ethz.util.DoubleBufferCopy: java.io.OutputStream access$0(benchmarks.hedc.ethz.util.DoubleBufferCopy)>($r4)
r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: int bufferFill_> = 0
tableswitch(i0) {     case 1: goto $i1 = r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: int bufferFill_>;     case 2: goto $i4 = r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: int bufferFill_>;     default: goto return z0; }
$i1 = r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: int bufferFill_>
$r1 = r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: benchmarks.hedc.ethz.util.DoubleBufferCopy this$0>
goto [?= return z0]
$r3 = r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: byte[] buffer_>
z0 = 0
goto [?= return z0]
$r7 = staticinvoke <benchmarks.hedc.ethz.util.DoubleBufferCopy: java.io.InputStream access$1(benchmarks.hedc.ethz.util.DoubleBufferCopy)>($r6)
r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: int bufferFill_> = $i6
$r6 = r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: benchmarks.hedc.ethz.util.DoubleBufferCopy this$0>
if $i4 != 0 goto return z0
$i4 = r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: int bufferFill_>
$i3 = r0.<benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer: int bufferFill_>
virtualinvoke $r2.<java.io.OutputStream: void write(byte[],int,int)>($r3, 0, $i2)
==============

Transforming benchmarks.hedc.ethz.util.DoubleBufferCopy... 
Transforming benchmarks.hedc.ethz.util.Generator... 
==============
 tn units (no order)
$r5 = virtualinvoke $r4.<java.util.Vector: java.lang.Object elementAt(int)>(0)
$r7 := @caughtexception
exitmonitor r1
entermonitor $r2
if $i0 <= 0 goto r0 = newarray (char)[32552]
goto [?= exitmonitor r1]
$r4 = <benchmarks.hedc.ethz.util.Generator: java.util.Vector bufferPool_>
if r0 != null goto exitmonitor r1
$i0 = virtualinvoke $r3.<java.util.Vector: int size()>()
r0 = newarray (char)[32552]
virtualinvoke $r6.<java.util.Vector: void removeElementAt(int)>(0)
$r3 = <benchmarks.hedc.ethz.util.Generator: java.util.Vector bufferPool_>
exitmonitor r1
r0 = (char[]) $r5
$r6 = <benchmarks.hedc.ethz.util.Generator: java.util.Vector bufferPool_>
==============

==============
 tn units (no order)
$r5 := @caughtexception
$i2 = <benchmarks.hedc.ethz.util.Generator: int GEN_POOL_CAPACITY_>
entermonitor $r2
exitmonitor r1
exitmonitor r1
if $i1 >= $i2 goto exitmonitor r1
$r3 = <benchmarks.hedc.ethz.util.Generator: java.util.Vector bufferPool_>
$r4 = <benchmarks.hedc.ethz.util.Generator: java.util.Vector bufferPool_>
virtualinvoke $r4.<java.util.Vector: void addElement(java.lang.Object)>(r0)
$i1 = virtualinvoke $r3.<java.util.Vector: int size()>()
==============

==============
 tn units (no order)
exitmonitor r2
r1 = (char[]) $r5
$r4 = <benchmarks.hedc.ethz.util.Generator: java.util.TreeMap namedBufferPool_>
exitmonitor r2
entermonitor $r3
$r5 = virtualinvoke $r4.<java.util.TreeMap: java.lang.Object get(java.lang.Object)>(r0)
$r6 := @caughtexception
==============

==============
 tn units (no order)
virtualinvoke $r5.<java.util.TreeMap: java.lang.Object remove(java.lang.Object)>($r7)
r0 := @parameter0: java.lang.String
if $i0 <= 0 goto return
$r5 = <benchmarks.hedc.ethz.util.Generator: java.util.TreeMap namedBufferPool_>
$r4 = <benchmarks.hedc.ethz.util.Generator: java.util.TreeMap namedBufferPool_>
if $i1 < $i2 goto $r9 = <benchmarks.hedc.ethz.util.Generator: java.util.TreeMap namedBufferPool_>
$r6 = <benchmarks.hedc.ethz.util.Generator: java.util.TreeMap namedBufferPool_>
r1 := @parameter1: char[]
$i2 = <benchmarks.hedc.ethz.util.Generator: int GEN_POOL_CAPACITY_NAMED_>
return
$i1 = virtualinvoke $r4.<java.util.TreeMap: int size()>()
exitmonitor r2
goto [?= return]
virtualinvoke $r9.<java.util.TreeMap: java.lang.Object put(java.lang.Object,java.lang.Object)>(r0, r1)
exitmonitor r2
throw $r11
$i0 = <benchmarks.hedc.ethz.util.Generator: int GEN_POOL_CAPACITY_NAMED_>
$r7 = virtualinvoke $r6.<java.util.TreeMap: java.lang.Object lastKey()>()
$r9 = <benchmarks.hedc.ethz.util.Generator: java.util.TreeMap namedBufferPool_>
$r3 = <benchmarks.hedc.ethz.util.Generator: java.util.TreeMap namedBufferPool_>
entermonitor $r3
$r11 := @caughtexception
==============

==============
 tn units (no order)
virtualinvoke $r5.<java.util.TreeMap: java.lang.Object remove(java.lang.Object)>($r7)
$r5 = <benchmarks.hedc.ethz.util.Generator: java.util.TreeMap namedBufferPool_>
$r4 = <benchmarks.hedc.ethz.util.Generator: java.util.TreeMap namedBufferPool_>
if $i1 < $i2 goto $r9 = <benchmarks.hedc.ethz.util.Generator: java.util.TreeMap namedBufferPool_>
$r6 = <benchmarks.hedc.ethz.util.Generator: java.util.TreeMap namedBufferPool_>
$i2 = <benchmarks.hedc.ethz.util.Generator: int GEN_POOL_CAPACITY_NAMED_>
$i1 = virtualinvoke $r4.<java.util.TreeMap: int size()>()
exitmonitor r2
virtualinvoke $r9.<java.util.TreeMap: java.lang.Object put(java.lang.Object,java.lang.Object)>(r0, r1)
exitmonitor r2
$r7 = virtualinvoke $r6.<java.util.TreeMap: java.lang.Object lastKey()>()
entermonitor $r3
$r9 = <benchmarks.hedc.ethz.util.Generator: java.util.TreeMap namedBufferPool_>
$r11 := @caughtexception
==============

Transforming benchmarks.hedc.ethz.util.DoubleBufferCopy$CopyThread... 
Transforming benchmarks.hedc.ethz.util.Ftp... 
Transforming benchmarks.hedc.ethz.util.SystemProperties... 
Transforming benchmarks.hedc.ethz.util.Estimator... 
Transforming benchmarks.hedc.ethz.util.CopyStream... 
Transforming benchmarks.hedc.ethz.util.URLConnectionReader... 
Transforming benchmarks.hedc.ethz.util.BaseProperties... 
Transforming benchmarks.hedc.ethz.util.Logger... 
==============
 tn units (no order)
virtualinvoke $r3.<java.io.RandomAccessFile: void writeBytes(java.lang.String)>($r5)
$i1 = r0.<benchmarks.hedc.ethz.util.Logger: int logBuffer_>
$i2 = r0.<benchmarks.hedc.ethz.util.Logger: int logBuffer_>
return
$i0 = virtualinvoke $r1.<java.lang.StringBuffer: int length()>()
r0.<benchmarks.hedc.ethz.util.Logger: java.lang.StringBuffer buffer_> = $r6
specialinvoke $r6.<java.lang.StringBuffer: void <init>(int)>($i2)
$r2 = r0.<benchmarks.hedc.ethz.util.Logger: java.io.RandomAccessFile log_>
if $r2 == null goto $r6 = new java.lang.StringBuffer
$r5 = virtualinvoke $r4.<java.lang.StringBuffer: java.lang.String toString()>()
$r1 = r0.<benchmarks.hedc.ethz.util.Logger: java.lang.StringBuffer buffer_>
$r3 = r0.<benchmarks.hedc.ethz.util.Logger: java.io.RandomAccessFile log_>
$r6 = new java.lang.StringBuffer
if $i0 < $i1 goto return
r0 := @this: benchmarks.hedc.ethz.util.Logger
$r4 = r0.<benchmarks.hedc.ethz.util.Logger: java.lang.StringBuffer buffer_>
==============

==============
 tn units (no order)
staticinvoke <benchmarks.hedc.ethz.util.Messages: void warn(int,java.lang.String,java.lang.Object)>(0, "LOG02 - error occurred during logging (%1)", $r5)
r0.<benchmarks.hedc.ethz.util.Logger: java.io.RandomAccessFile log_> = null
r0 := @this: benchmarks.hedc.ethz.util.Logger
$r5 = virtualinvoke r1.<java.io.IOException: java.lang.String getMessage()>()
throw r2
return
r0.<benchmarks.hedc.ethz.util.Logger: java.io.RandomAccessFile log_> = null
$r3 = r0.<benchmarks.hedc.ethz.util.Logger: java.io.RandomAccessFile log_>
goto [?= return]
$r4 := @caughtexception
r2 = $r6
virtualinvoke $r3.<java.io.RandomAccessFile: void close()>()
r1 = $r4
r0.<benchmarks.hedc.ethz.util.Logger: java.io.RandomAccessFile log_> = null
virtualinvoke r0.<benchmarks.hedc.ethz.util.Logger: void writeEpilogue_()>()
$r6 := @caughtexception
goto [?= r0.<benchmarks.hedc.ethz.util.Logger: java.io.RandomAccessFile log_> = null]
==============

==============
 tn units (no order)
$i0 = r0.<benchmarks.hedc.ethz.util.Logger: int logBuffer_>
goto [?= return]
$r8 = virtualinvoke r1.<java.io.IOException: java.lang.String getMessage()>()
$r5 = virtualinvoke $r4.<java.lang.StringBuffer: java.lang.String toString()>()
$r2 = r0.<benchmarks.hedc.ethz.util.Logger: java.io.RandomAccessFile log_>
r0 := @this: benchmarks.hedc.ethz.util.Logger
$r7 := @caughtexception
virtualinvoke $r3.<java.io.RandomAccessFile: void writeBytes(java.lang.String)>($r5)
staticinvoke <benchmarks.hedc.ethz.util.Messages: void warn(int,java.lang.String,java.lang.Object)>(0, "LOG02 - error occurred during logging (%1)", $r8)
$r4 = r0.<benchmarks.hedc.ethz.util.Logger: java.lang.StringBuffer buffer_>
specialinvoke $r6.<java.lang.StringBuffer: void <init>(int)>($i0)
$r6 = new java.lang.StringBuffer
r1 = $r7
return
if $r2 == null goto return
$r3 = r0.<benchmarks.hedc.ethz.util.Logger: java.io.RandomAccessFile log_>
r0.<benchmarks.hedc.ethz.util.Logger: java.lang.StringBuffer buffer_> = $r6
==============

Transforming benchmarks.hedc.ethz.util.PropertyMonitoring... 
Transforming benchmarks.hedc.ethz.util.HttpLogger... 
==============
 tn units (no order)
$r11 = r0.<benchmarks.hedc.ethz.util.HttpLogger: java.io.RandomAccessFile log_>
goto [?= return]
$r10 = virtualinvoke $r9.<java.lang.StringBuilder: java.lang.String toString()>()
$r14 = virtualinvoke r1.<java.lang.Exception: java.lang.String getMessage()>()
$r3 = r0.<benchmarks.hedc.ethz.util.HttpLogger: java.io.RandomAccessFile log_>
r1 = $r13
return
specialinvoke $r6.<java.util.Date: void <init>()>()
$r4 = r0.<benchmarks.hedc.ethz.util.HttpLogger: java.io.RandomAccessFile log_>
virtualinvoke $r11.<java.io.RandomAccessFile: void writeBytes(java.lang.String)>("#Software: ethz.util.HttpLogger\n")
virtualinvoke $r4.<java.io.RandomAccessFile: void writeBytes(java.lang.String)>($r10)
$r8 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>($r7)
virtualinvoke $r3.<java.io.RandomAccessFile: void writeBytes(java.lang.String)>("#Version: 1.0\n")
$r12 = r0.<benchmarks.hedc.ethz.util.HttpLogger: java.io.RandomAccessFile log_>
staticinvoke <benchmarks.hedc.ethz.util.Messages: void error(java.lang.String,java.lang.Object)>("LOG02 - error occurred during logging (%1)", $r14)
if $r2 == null goto return
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>("\n")
$r5 = new java.lang.StringBuilder
r0 := @this: benchmarks.hedc.ethz.util.HttpLogger
$r2 = r0.<benchmarks.hedc.ethz.util.HttpLogger: java.io.RandomAccessFile log_>
r0.<benchmarks.hedc.ethz.util.HttpLogger: java.io.RandomAccessFile log_> = null
$r6 = new java.util.Date
$r7 = virtualinvoke $r6.<java.util.Date: java.lang.String toString()>()
$r13 := @caughtexception
specialinvoke $r5.<java.lang.StringBuilder: void <init>(java.lang.String)>("#Start-Date: ")
virtualinvoke $r12.<java.io.RandomAccessFile: void writeBytes(java.lang.String)>("#Fields: c-dns c-user s-user [s-date s-time] \"cs-method cs-uri cs-version\" cs-status cs-bytes s-time-taken\n")
==============

Transforming benchmarks.hedc.ethz.util.EstimatorFactory... 
Transforming benchmarks.hedc.ethz.util.EtcUtil... 
Transforming benchmarks.hedc.ethz.util.BufferedCopy... 
Transforming benchmarks.hedc.ethz.util.Messages... 
Transforming benchmarks.hedc.ethz.util.ObservableProperties... 
==============
 tn units (no order)
r8 = newarray (benchmarks.hedc.ethz.util.PropertyMonitoring)[$i6]
$r7 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
$r4[i0] = r1
return
$i8 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: int observersCount_>
$r9 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
$r10 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
i0 = i0 + 1
$i9 = $i8 + 1
$i6 = $i5 * 2
$i3 = $i2 + 1
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r9, 0, r8, 0, $i7)
$i7 = lengthof $r10
$r11[$i8] = r1
$r5 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
$r11 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
$i2 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: int observersCount_>
if $i3 < $i4 goto $r11 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
if $r3 != null goto i0 = i0 + 1
if i0 < $i1 goto $r2 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
r1 := @parameter0: benchmarks.hedc.ethz.util.PropertyMonitoring
return
r0.<benchmarks.hedc.ethz.util.ObservableProperties: int observersCount_> = $i9
r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_> = r8
goto [?= $r5 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>]
r0 := @this: benchmarks.hedc.ethz.util.ObservableProperties
$i1 = lengthof $r5
i0 = 0
$r2 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
$i5 = lengthof $r7
$i4 = lengthof $r6
$r6 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
$r4 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
$r3 = $r2[i0]
==============

==============
 tn units (no order)
if i0 < $i1 goto $r2 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
if $r3 != r1 goto i0 = i0 + 1
i0 = i0 + 1
i0 = 0
r1 := @parameter0: benchmarks.hedc.ethz.util.PropertyMonitoring
$i1 = lengthof $r5
$r5 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
goto [?= $r5 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>]
r0 := @this: benchmarks.hedc.ethz.util.ObservableProperties
$r2 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
return 0
return 1
$r3 = $r2[i0]
$r4 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
$r4[i0] = null
==============

==============
 tn units (no order)
if i0 < $i1 goto $r13 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
specialinvoke r0.<benchmarks.hedc.ethz.util.BaseProperties: java.lang.Object put(java.lang.Object,java.lang.Object)>(r1, r2)
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.String toString()>()
if r4 == null goto specialinvoke r0.<benchmarks.hedc.ethz.util.BaseProperties: java.lang.Object put(java.lang.Object,java.lang.Object)>(r1, r2)
$r15 = new java.lang.StringBuilder
$r21 = $r20[i0]
specialinvoke r0.<benchmarks.hedc.ethz.util.BaseProperties: java.lang.Object remove(java.lang.Object)>(r1)
staticinvoke <benchmarks.hedc.ethz.util.Messages: void debug(int,java.lang.String)>(3, $r9)
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>("=[")
i0 = 0
if $z2 != 0 goto return z0
$z2 = virtualinvoke r4.<java.lang.String: boolean equals(java.lang.Object)>(r2)
$z3 = interfaceinvoke $r21.<benchmarks.hedc.ethz.util.PropertyMonitoring: boolean propertyChanged(java.lang.String)>(r1)
i0 = i0 + 1
$r18 = virtualinvoke $r15.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>($r17)
return 1
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r2)
specialinvoke r0.<benchmarks.hedc.ethz.util.BaseProperties: java.lang.Object put(java.lang.Object,java.lang.Object)>(r1, r4)
$r19 = virtualinvoke $r18.<java.lang.StringBuilder: java.lang.String toString()>()
$r3 = new java.lang.StringBuilder
if r4 != null goto (branch)
z0 = z0 | $z3
r0 := @this: benchmarks.hedc.ethz.util.ObservableProperties
$r13 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
goto [?= return z0]
return z0
specialinvoke $r3.<java.lang.StringBuilder: void <init>(java.lang.String)>("ObservableProperties: put ")
$r17 = $r16[i0]
staticinvoke <benchmarks.hedc.ethz.util.Messages: void debug(int,java.lang.String)>(3, $r19)
specialinvoke r0.<benchmarks.hedc.ethz.util.BaseProperties: java.lang.Object remove(java.lang.Object)>(r1)
if r2 != null goto $r11 = virtualinvoke r0.<benchmarks.hedc.ethz.util.ObservableProperties: java.lang.Object get(java.lang.Object)>(r1)
$i1 = lengthof $r22
z1 = 1
if $r14 == null goto i0 = i0 + 1
specialinvoke $r15.<java.lang.StringBuilder: void <init>(java.lang.String)>("ObservableProperties: notifying ")
$r14 = $r13[i0]
r4 = (java.lang.String) $r11
$r16 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
$r11 = virtualinvoke r0.<benchmarks.hedc.ethz.util.ObservableProperties: java.lang.Object get(java.lang.Object)>(r1)
if z0 != 0 goto return z0
$r22 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
z0 = 0
r2 := @parameter1: java.lang.String
$r5 = virtualinvoke $r3.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r1)
$r20 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>
r1 := @parameter0: java.lang.String
goto [?= $r22 = r0.<benchmarks.hedc.ethz.util.ObservableProperties: benchmarks.hedc.ethz.util.PropertyMonitoring[] observers_>]
z1 = 0
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>("]")
if z1 != 0 goto specialinvoke r0.<benchmarks.hedc.ethz.util.BaseProperties: java.lang.Object remove(java.lang.Object)>(r1)
==============

Transforming benchmarks.hedc.ethz.util.SmartRef... 
Transforming benchmarks.hedc.ethz.util.RmiLogger... 
==============
 tn units (no order)
staticinvoke <benchmarks.hedc.ethz.util.Messages: void error(java.lang.String,java.lang.Object)>("LOG02 - error occurred during logging (%1)", $r14)
$r5 = new java.lang.StringBuilder
r0 := @this: benchmarks.hedc.ethz.util.RmiLogger
$r7 = virtualinvoke $r6.<java.util.Date: java.lang.String toString()>()
$r12 = r0.<benchmarks.hedc.ethz.util.RmiLogger: java.io.RandomAccessFile log_>
$r11 = r0.<benchmarks.hedc.ethz.util.RmiLogger: java.io.RandomAccessFile log_>
virtualinvoke $r11.<java.io.RandomAccessFile: void writeBytes(java.lang.String)>("#Software: ethz.util.RmiLogger\n")
virtualinvoke $r12.<java.io.RandomAccessFile: void writeBytes(java.lang.String)>("#Fields: c-dns c-user s-user [s-date s-time] cs-method {cs-parameters} cs-version s-exception cs-return s-time-taken\n")
r0.<benchmarks.hedc.ethz.util.RmiLogger: java.io.RandomAccessFile log_> = null
specialinvoke $r6.<java.util.Date: void <init>()>()
specialinvoke $r5.<java.lang.StringBuilder: void <init>(java.lang.String)>("#Start-Date: ")
$r10 = virtualinvoke $r9.<java.lang.StringBuilder: java.lang.String toString()>()
virtualinvoke $r3.<java.io.RandomAccessFile: void writeBytes(java.lang.String)>("#Version: 1.0\n")
return
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>("\n")
$r6 = new java.util.Date
$r2 = r0.<benchmarks.hedc.ethz.util.RmiLogger: java.io.RandomAccessFile log_>
virtualinvoke $r4.<java.io.RandomAccessFile: void writeBytes(java.lang.String)>($r10)
$r8 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>($r7)
if $r2 == null goto return
r1 = $r13
$r4 = r0.<benchmarks.hedc.ethz.util.RmiLogger: java.io.RandomAccessFile log_>
$r3 = r0.<benchmarks.hedc.ethz.util.RmiLogger: java.io.RandomAccessFile log_>
$r14 = virtualinvoke r1.<java.lang.Exception: java.lang.String getMessage()>()
$r13 := @caughtexception
goto [?= return]
==============

Transforming benchmarks.hedc.ethz.util.ThreadFactory... 
Transforming benchmarks.hedc.ethz.util.SerializePerformanceTest... 
Transforming benchmarks.hedc.DateFormatter... 
Transforming benchmarks.hedc.Rag... 
Transforming benchmarks.hedc.Messages... 
Transforming benchmarks.hedc.PooledExecutorWithInvalidate$DiscardWhenBlocked... 
Transforming benchmarks.hedc.FormFiller... 
Transforming benchmarks.hedc.Tester... 
Transforming benchmarks.hedc.Task... 
==============
 tn units (no order)
r0.<benchmarks.hedc.Task: java.lang.Thread thread_> = r1
return
goto [?= return]
if $z0 != 0 goto r0.<benchmarks.hedc.Task: java.lang.Thread thread_> = r1
$r2 = r0.<benchmarks.hedc.Task: java.lang.Thread thread_>
$z0 = r0.<benchmarks.hedc.Task: boolean valid>
r1 := @parameter0: java.lang.Thread
r0 := @this: benchmarks.hedc.Task
virtualinvoke $r2.<java.lang.Thread: void interrupt()>()
==============

Transforming benchmarks.hedc.PooledExecutorWithInvalidate... 
==============
 tn units (no order)
exitmonitor r1
$i3 = virtualinvoke r0.<benchmarks.hedc.PooledExecutorWithInvalidate: int getPoolSize()>()
$r3 := @caughtexception
exitmonitor r1
virtualinvoke r0.<benchmarks.hedc.PooledExecutorWithInvalidate: void addThread(benchmarks.hedc.Task)>(null)
exitmonitor r1
i1 = i1 + 1
if $i3 >= $i4 goto exitmonitor r1
$i4 = virtualinvoke r0.<benchmarks.hedc.PooledExecutorWithInvalidate: int getMaximumPoolSize()>()
goto [?= exitmonitor r1]
entermonitor $r2
==============

==============
 tn units (no order)
virtualinvoke r3.<java.lang.Thread: void interrupt()>()
r2 = interfaceinvoke $r6.<java.util.Collection: java.util.Iterator iterator()>()
$r8 := @caughtexception
$r6 = interfaceinvoke $r5.<java.util.Map: java.util.Collection values()>()
exitmonitor r1
r3 = (java.lang.Thread) $r7
$r5 = r0.<benchmarks.hedc.PooledExecutorWithInvalidate: java.util.Map threads_>
goto [?= $z0 = interfaceinvoke r2.<java.util.Iterator: boolean hasNext()>()]
if $z0 != 0 goto $r7 = interfaceinvoke r2.<java.util.Iterator: java.lang.Object next()>()
$r7 = interfaceinvoke r2.<java.util.Iterator: java.lang.Object next()>()
entermonitor $r4
exitmonitor r1
$z0 = interfaceinvoke r2.<java.util.Iterator: boolean hasNext()>()
==============

==============
 tn units (no order)
r0 := @this: benchmarks.hedc.PooledExecutorWithInvalidate
$l0 = r0.<benchmarks.hedc.PooledExecutorWithInvalidate: long keepAliveTime_>
return $l0
==============

==============
 tn units (no order)
r0.<benchmarks.hedc.PooledExecutorWithInvalidate: long keepAliveTime_> = l0
r0 := @this: benchmarks.hedc.PooledExecutorWithInvalidate
l0 := @parameter0: long
return
==============

==============
 tn units (no order)
exitmonitor r2
$r5 = r0.<benchmarks.hedc.PooledExecutorWithInvalidate: java.util.Map threads_>
exitmonitor r2
r0.<benchmarks.hedc.PooledExecutorWithInvalidate: int poolSize_> = $i1
$i0 = r0.<benchmarks.hedc.PooledExecutorWithInvalidate: int poolSize_>
$i1 = $i0 - 1
$r7 := @caughtexception
entermonitor $r3
interfaceinvoke $r5.<java.util.Map: java.lang.Object remove(java.lang.Object)>(r1)
==============

==============
 tn units (no order)
$r1 = r0.<benchmarks.hedc.PooledExecutorWithInvalidate: benchmarks.hedc.PooledExecutorWithInvalidate$BlockedExecutionHandler blockedExecutionHandler_>
return $r1
r0 := @this: benchmarks.hedc.PooledExecutorWithInvalidate
==============

==============
 tn units (no order)
r0 := @this: benchmarks.hedc.PooledExecutorWithInvalidate
specialinvoke $r1.<benchmarks.hedc.PooledExecutorWithInvalidate$RunWhenBlocked: void <init>(benchmarks.hedc.PooledExecutorWithInvalidate)>(r0)
r0.<benchmarks.hedc.PooledExecutorWithInvalidate: benchmarks.hedc.PooledExecutorWithInvalidate$BlockedExecutionHandler blockedExecutionHandler_> = $r1
return
$r1 = new benchmarks.hedc.PooledExecutorWithInvalidate$RunWhenBlocked
==============

==============
 tn units (no order)
r0 := @this: benchmarks.hedc.PooledExecutorWithInvalidate
return
r0.<benchmarks.hedc.PooledExecutorWithInvalidate: benchmarks.hedc.PooledExecutorWithInvalidate$BlockedExecutionHandler blockedExecutionHandler_> = $r1
$r1 = new benchmarks.hedc.PooledExecutorWithInvalidate$WaitWhenBlocked
specialinvoke $r1.<benchmarks.hedc.PooledExecutorWithInvalidate$WaitWhenBlocked: void <init>(benchmarks.hedc.PooledExecutorWithInvalidate)>(r0)
==============

==============
 tn units (no order)
return
$r1 = new benchmarks.hedc.PooledExecutorWithInvalidate$DiscardWhenBlocked
r0.<benchmarks.hedc.PooledExecutorWithInvalidate: benchmarks.hedc.PooledExecutorWithInvalidate$BlockedExecutionHandler blockedExecutionHandler_> = $r1
r0 := @this: benchmarks.hedc.PooledExecutorWithInvalidate
specialinvoke $r1.<benchmarks.hedc.PooledExecutorWithInvalidate$DiscardWhenBlocked: void <init>(benchmarks.hedc.PooledExecutorWithInvalidate)>(r0)
==============

==============
 tn units (no order)
$z0 = interfaceinvoke $r4.<benchmarks.EDU.oswego.cs.dl.util.concurrent.Channel: boolean offer(java.lang.Object,long)>(r1, 0L)
$i0 = virtualinvoke r0.<benchmarks.hedc.PooledExecutorWithInvalidate: int getPoolSize()>()
$r5 := @caughtexception
$r4 = r0.<benchmarks.hedc.PooledExecutorWithInvalidate: benchmarks.EDU.oswego.cs.dl.util.concurrent.Channel handOff_>
exitmonitor r2
exitmonitor r2
entermonitor $r3
exitmonitor r2
$i2 = virtualinvoke r0.<benchmarks.hedc.PooledExecutorWithInvalidate: int getPoolSize()>()
exitmonitor r2
if $i0 >= $i1 goto $r4 = r0.<benchmarks.hedc.PooledExecutorWithInvalidate: benchmarks.EDU.oswego.cs.dl.util.concurrent.Channel handOff_>
$i3 = virtualinvoke r0.<benchmarks.hedc.PooledExecutorWithInvalidate: int getMaximumPoolSize()>()
exitmonitor r2
virtualinvoke r0.<benchmarks.hedc.PooledExecutorWithInvalidate: void addThread(benchmarks.hedc.Task)>(r1)
if $z0 == 0 goto $i2 = virtualinvoke r0.<benchmarks.hedc.PooledExecutorWithInvalidate: int getPoolSize()>()
$i1 = virtualinvoke r0.<benchmarks.hedc.PooledExecutorWithInvalidate: int getMinimumPoolSize()>()
virtualinvoke r0.<benchmarks.hedc.PooledExecutorWithInvalidate: void addThread(benchmarks.hedc.Task)>(r1)
if $i2 >= $i3 goto exitmonitor r2
==============

Transforming benchmarks.hedc.SohoSynoptic... 
Transforming benchmarks.hedc.regexp.CompilerState... 
Transforming benchmarks.hedc.regexp.CharArrayState... 
Transforming benchmarks.hedc.regexp.Result... 
Transforming benchmarks.hedc.regexp.GroupReference... 
Transforming benchmarks.hedc.regexp.Regexp... 
Transforming benchmarks.hedc.regexp.MalformedRegexpException... 
Transforming benchmarks.hedc.regexp.SuccessRegexp... 
Transforming benchmarks.hedc.regexp.Literal... 
Transforming benchmarks.hedc.regexp.Multi... 
Transforming benchmarks.hedc.regexp.NoSuchMatchException... 
Transforming benchmarks.hedc.regexp.Group... 
Transforming benchmarks.hedc.regexp.RegexpCompiler... 
Transforming benchmarks.hedc.regexp.StringState... 
Transforming benchmarks.hedc.regexp.ContextMatch... 
Transforming benchmarks.hedc.regexp.CharClass... 
Transforming benchmarks.hedc.regexp.Alternatives... 
Transforming benchmarks.hedc.regexp.State... 
Transforming benchmarks.hedc.regexp.Dot... 
Transforming benchmarks.hedc.FormFiller$Filter... 
Transforming benchmarks.montecarlo.JGFMonteCarloBench... 
Transforming benchmarks.montecarlo.PathId... 
Transforming benchmarks.montecarlo.Universal... 
Transforming benchmarks.montecarlo.ToInitAllTasks... 
Transforming benchmarks.montecarlo.MonteCarloPath... 
Transforming benchmarks.montecarlo.RatePath... 
Transforming benchmarks.montecarlo.ToResult... 
Transforming benchmarks.montecarlo.AppDemo... 
Transforming benchmarks.montecarlo.PriceStock... 
Transforming benchmarks.montecarlo.ToTask... 
Transforming benchmarks.montecarlo.AppDemoThread... 
Transforming benchmarks.montecarlo.ReturnPath... 
Transforming benchmarks.montecarlo.DemoException... 
Transforming benchmarks.montecarlo.Utilities... 
Transforming benchmarks.montecarlo.CallAppDemo... 
Transforming benchmarks.TestMe... 
Transforming benchmarks.JGFRayTracerBenchSizeA... 
Transforming benchmarks.harness.MyThread... 
Transforming benchmarks.harness.JigsawHarnessPretex... 
Transforming benchmarks.JGFMonteCarloBenchSizeA... 
Transforming benchmarks.AtomicityTest... 
==============
 tn units (no order)
$r8 = <java.lang.System: java.io.PrintStream out>
exitmonitor r1
$i2 = $i1 + i0
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
entermonitor $r2
specialinvoke $r4.<java.lang.StringBuilder: void <init>(java.lang.String)>("Updated balance in deposit ")
$r11 = staticinvoke <java.lang.Integer: java.lang.Integer valueOf(int)>($i2)
$r10 = r0.<benchmarks.AtomicityTest: java.lang.Integer balance>
virtualinvoke $r3.<java.io.PrintStream: void println(java.lang.String)>($r7)
$r4 = new java.lang.StringBuilder
$r5 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
$r3 = <java.lang.System: java.io.PrintStream out>
r0.<benchmarks.AtomicityTest: java.lang.Integer balance> = $r11
$i1 = virtualinvoke $r10.<java.lang.Integer: int intValue()>()
$r6 = virtualinvoke $r4.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>($r5)
exitmonitor r1
$r12 := @caughtexception
virtualinvoke $r8.<java.io.PrintStream: void flush()>()
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.AtomicityTest: java.lang.Integer balance>
throw $r8
exitmonitor r6
$i2 = i1 - i0
$r2 = r0.<benchmarks.AtomicityTest: java.lang.Integer lock>
$r8 := @caughtexception
r0.<benchmarks.AtomicityTest: java.lang.Integer balance> = $r7
exitmonitor r6
goto [?= return]
exitmonitor r1
goto [?= $r5 = r0.<benchmarks.AtomicityTest: java.lang.Integer lock>]
i1 = virtualinvoke $r3.<java.lang.Integer: int intValue()>()
$r7 = staticinvoke <java.lang.Integer: java.lang.Integer valueOf(int)>($i2)
return
$r5 = r0.<benchmarks.AtomicityTest: java.lang.Integer lock>
entermonitor $r2
r0 := @this: benchmarks.AtomicityTest
exitmonitor r1
throw $r4
$r4 := @caughtexception
entermonitor $r5
i0 := @parameter0: int
==============

==============
 tn units (no order)
i1 = virtualinvoke $r3.<java.lang.Integer: int intValue()>()
$r3 = r0.<benchmarks.AtomicityTest: java.lang.Integer balance>
entermonitor $r2
exitmonitor r1
$r4 := @caughtexception
exitmonitor r1
==============

==============
 tn units (no order)
$r7 = staticinvoke <java.lang.Integer: java.lang.Integer valueOf(int)>($i2)
exitmonitor r6
$i2 = i1 - i0
$r8 := @caughtexception
r0.<benchmarks.AtomicityTest: java.lang.Integer balance> = $r7
entermonitor $r5
exitmonitor r6
==============

Transforming benchmarks.raytracer.RayTracerRunner... 
==============
 tn units (no order)
entermonitor $r5
goto [?= $i11 = <benchmarks.raytracer.JGFRayTracerBench: int nthreads>]
$i11 = <benchmarks.raytracer.JGFRayTracerBench: int nthreads>
i0 = 0
exitmonitor r3
$r6 := @caughtexception
$i7 = r0.<benchmarks.raytracer.RayTracerRunner: int id>
$l9 = r0.<benchmarks.raytracer.RayTracerRunner: long checksum>
$l10 = $l8 + $l9
exitmonitor r3
if $i7 != i0 goto i0 = i0 + 1
if i0 < $i11 goto $i7 = r0.<benchmarks.raytracer.RayTracerRunner: int id>
<benchmarks.raytracer.JGFRayTracerBench: long checksum1> = $l10
i0 = i0 + 1
$l8 = <benchmarks.raytracer.JGFRayTracerBench: long checksum1>
==============

Transforming benchmarks.raytracer.TournamentBarrier... 
Transforming benchmarks.raytracer.Isect... 
Transforming benchmarks.raytracer.Sphere... 
Transforming benchmarks.raytracer.Barrier... 
Transforming benchmarks.raytracer.Vec... 
Transforming benchmarks.raytracer.Interval... 
Transforming benchmarks.raytracer.RayTracer... 
Transforming benchmarks.raytracer.Primitive... 
Transforming benchmarks.raytracer.Light... 
Transforming benchmarks.raytracer.Surface... 
Transforming benchmarks.raytracer.Scene... 
Transforming benchmarks.raytracer.Ray... 
Transforming benchmarks.raytracer.JGFRayTracerBench... 
Transforming benchmarks.raytracer.View... 
Transforming benchmarks.JGFAllSizeA... 
Transforming benchmarks.ChessTest... 
Transforming benchmarks.sor.Sor... 
Transforming benchmarks.sor.sor_first_row_odd... 
Transforming benchmarks.sor.sor_first_row_even... 
Transforming benchmarks.JGFMolDynBenchSizeB... 
Transforming benchmarks.instrumented.java15.lang.Math... 
Transforming benchmarks.instrumented.java15.util.Arrays$ArrayList... 
Transforming benchmarks.instrumented.java15.util.HashMap$Values... 
Transforming benchmarks.instrumented.java15.util.SubList$1... 
Transforming benchmarks.instrumented.java15.util.LinkedHashMap$KeyIterator... 
Transforming benchmarks.instrumented.java15.util.IdentityHashMap$KeySet... 
Transforming benchmarks.instrumented.java15.util.Hashtable$Enumerator... 
==============
 tn units (no order)
goto [?= (branch)]
staticinvoke <benchmarks.instrumented.java15.util.Hashtable: void access$5(benchmarks.instrumented.java15.util.Hashtable,int)>($r18, $i11)
$i11 = $i10 - 1
staticinvoke <benchmarks.instrumented.java15.util.Hashtable: void access$4(benchmarks.instrumented.java15.util.Hashtable,int)>($r14, $i7)
i0 = $i4 % $i5
$i10 = staticinvoke <benchmarks.instrumented.java15.util.Hashtable: int access$1(benchmarks.instrumented.java15.util.Hashtable)>($r18)
$r14 = r0.<benchmarks.instrumented.java15.util.Hashtable$Enumerator: benchmarks.instrumented.java15.util.Hashtable this$0>
$r13 = r0.<benchmarks.instrumented.java15.util.Hashtable$Enumerator: benchmarks.instrumented.java15.util.Hashtable$Entry lastReturned>
$r12 = r0.<benchmarks.instrumented.java15.util.Hashtable$Enumerator: benchmarks.instrumented.java15.util.Hashtable$Entry lastReturned>
$r20 := @caughtexception
r4 = r3
$i8 = r0.<benchmarks.instrumented.java15.util.Hashtable$Enumerator: int expectedModCount>
$r18 = r0.<benchmarks.instrumented.java15.util.Hashtable$Enumerator: benchmarks.instrumented.java15.util.Hashtable this$0>
r3 = r2[i0]
entermonitor $r10
$i7 = $i6 + 1
$i9 = $i8 + 1
if r3 != null goto $r13 = r0.<benchmarks.instrumented.java15.util.Hashtable$Enumerator: benchmarks.instrumented.java15.util.Hashtable$Entry lastReturned>
r4.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next> = $r17
r4 = null
if r3 != $r13 goto r4 = r3
$r17 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
$i6 = staticinvoke <benchmarks.instrumented.java15.util.Hashtable: int access$3(benchmarks.instrumented.java15.util.Hashtable)>($r14)
exitmonitor r1
$i5 = lengthof r2
specialinvoke $r19.<benchmarks.instrumented.java15.util.ConcurrentModificationException: void <init>()>()
$r19 = new benchmarks.instrumented.java15.util.ConcurrentModificationException
r0.<benchmarks.instrumented.java15.util.Hashtable$Enumerator: benchmarks.instrumented.java15.util.Hashtable$Entry lastReturned> = null
r3 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
throw $r19
goto [?= $r18 = r0.<benchmarks.instrumented.java15.util.Hashtable$Enumerator: benchmarks.instrumented.java15.util.Hashtable this$0>]
exitmonitor r1
$r11 = r0.<benchmarks.instrumented.java15.util.Hashtable$Enumerator: benchmarks.instrumented.java15.util.Hashtable this$0>
r2 = staticinvoke <benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] access$2(benchmarks.instrumented.java15.util.Hashtable)>($r11)
$i3 = $r12.<benchmarks.instrumented.java15.util.Hashtable$Entry: int hash>
$r16 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
if r4 != null goto $r17 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
$i4 = $i3 & 2147483647
r0.<benchmarks.instrumented.java15.util.Hashtable$Enumerator: int expectedModCount> = $i9
r2[i0] = $r16
==============

Transforming benchmarks.instrumented.java15.util.TreeSet... 
Transforming benchmarks.instrumented.java15.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$1... 
Transforming benchmarks.instrumented.java15.util.AbstractMap$2... 
Transforming benchmarks.instrumented.java15.util.Collection... 
Transforming benchmarks.instrumented.java15.util.Collections$SynchronizedRandomAccessList... 
==============
 tn units (no order)
exitmonitor r1
$r6 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedRandomAccessList: java.lang.Object mutex>
$r7 := @caughtexception
entermonitor $r2
$r3 = new benchmarks.instrumented.java15.util.Collections$SynchronizedRandomAccessList
$r5 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.List: benchmarks.instrumented.java15.util.List subList(int,int)>(i0, i1)
specialinvoke $r3.<benchmarks.instrumented.java15.util.Collections$SynchronizedRandomAccessList: void <init>(benchmarks.instrumented.java15.util.List,java.lang.Object)>($r5, $r6)
exitmonitor r1
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedRandomAccessList: benchmarks.instrumented.java15.util.List list>
==============

Transforming benchmarks.instrumented.java15.util.TreeMap$KeyIterator... 
Transforming benchmarks.instrumented.java15.util.Collections$CheckedMap$CheckedEntrySet$1... 
Transforming benchmarks.instrumented.java15.util.ConcurrentModificationException... 
Transforming benchmarks.instrumented.java15.util.Collections$CopiesList... 
Transforming benchmarks.instrumented.java15.util.BitSet... 
Transforming benchmarks.instrumented.java15.util.Collections$SingletonSet... 
Transforming benchmarks.instrumented.java15.util.Collections$SynchronizedMap... 
==============
 tn units (no order)
$i0 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.Map: int size()>()
entermonitor $r2
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
$r4 := @caughtexception
exitmonitor r1
exitmonitor r1
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
exitmonitor r1
entermonitor $r2
$z0 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.Map: boolean isEmpty()>()
exitmonitor r1
$r4 := @caughtexception
==============

==============
 tn units (no order)
entermonitor $r3
exitmonitor r2
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Map: boolean containsKey(java.lang.Object)>(r1)
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
$r5 := @caughtexception
exitmonitor r2
==============

==============
 tn units (no order)
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Map: boolean containsValue(java.lang.Object)>(r1)
entermonitor $r3
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
exitmonitor r2
$r5 := @caughtexception
exitmonitor r2
==============

==============
 tn units (no order)
entermonitor $r3
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
exitmonitor r2
$r5 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Map: java.lang.Object get(java.lang.Object)>(r1)
$r6 := @caughtexception
exitmonitor r2
==============

==============
 tn units (no order)
entermonitor $r4
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java15.util.Map: java.lang.Object put(java.lang.Object,java.lang.Object)>(r1, r2)
$r7 := @caughtexception
exitmonitor r3
$r5 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
exitmonitor r3
==============

==============
 tn units (no order)
exitmonitor r2
entermonitor $r3
exitmonitor r2
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
$r6 := @caughtexception
$r5 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Map: java.lang.Object remove(java.lang.Object)>(r1)
==============

==============
 tn units (no order)
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
exitmonitor r2
exitmonitor r2
interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Map: void putAll(benchmarks.instrumented.java15.util.Map)>(r1)
$r5 := @caughtexception
entermonitor $r3
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
interfaceinvoke $r3.<benchmarks.instrumented.java15.util.Map: void clear()>()
exitmonitor r1
entermonitor $r2
exitmonitor r1
$r4 := @caughtexception
==============

==============
 tn units (no order)
specialinvoke $r4.<benchmarks.instrumented.java15.util.Collections$SynchronizedSet: void <init>(benchmarks.instrumented.java15.util.Set,java.lang.Object)>($r6, $r7)
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Set keySet>
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java15.util.Map: benchmarks.instrumented.java15.util.Set keySet()>()
r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Set keySet> = $r4
$r8 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Set keySet>
$r4 = new benchmarks.instrumented.java15.util.Collections$SynchronizedSet
$r7 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: java.lang.Object mutex>
exitmonitor r1
if $r3 != null goto $r8 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Set keySet>
entermonitor $r2
exitmonitor r1
$r9 := @caughtexception
$r5 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
==============

==============
 tn units (no order)
$r4 = new benchmarks.instrumented.java15.util.Collections$SynchronizedSet
exitmonitor r1
specialinvoke $r4.<benchmarks.instrumented.java15.util.Collections$SynchronizedSet: void <init>(benchmarks.instrumented.java15.util.Set,java.lang.Object)>($r6, $r7)
$r7 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: java.lang.Object mutex>
entermonitor $r2
exitmonitor r1
$r9 := @caughtexception
if $r3 != null goto $r8 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Set entrySet>
$r5 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java15.util.Map: benchmarks.instrumented.java15.util.Set entrySet()>()
$r8 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Set entrySet>
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Set entrySet>
r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Set entrySet> = $r4
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Collection values>
$r7 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: java.lang.Object mutex>
entermonitor $r2
exitmonitor r1
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java15.util.Map: benchmarks.instrumented.java15.util.Collection values()>()
$r5 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
$r4 = new benchmarks.instrumented.java15.util.Collections$SynchronizedCollection
if $r3 != null goto $r8 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Collection values>
$r9 := @caughtexception
specialinvoke $r4.<benchmarks.instrumented.java15.util.Collections$SynchronizedCollection: void <init>(benchmarks.instrumented.java15.util.Collection,java.lang.Object)>($r6, $r7)
r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Collection values> = $r4
$r8 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Collection values>
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r2
$r5 := @caughtexception
exitmonitor r2
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Map: boolean equals(java.lang.Object)>(r1)
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
entermonitor $r3
==============

==============
 tn units (no order)
exitmonitor r1
$i0 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.Map: int hashCode()>()
$r4 := @caughtexception
exitmonitor r1
entermonitor $r2
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
==============

==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
exitmonitor r1
$r4 = virtualinvoke $r3.<java.lang.Object: java.lang.String toString()>()
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedMap: benchmarks.instrumented.java15.util.Map m>
$r5 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r2
entermonitor $r3
$r4 := @caughtexception
virtualinvoke r1.<java.io.ObjectOutputStream: void defaultWriteObject()>()
exitmonitor r2
==============

Transforming benchmarks.instrumented.java15.util.TreeMap$1... 
Transforming benchmarks.instrumented.java15.util.AbstractMap... 
Transforming benchmarks.instrumented.java15.util.EnumMap$EntryIterator... 
Transforming benchmarks.instrumented.java15.util.Set... 
Transforming benchmarks.instrumented.java15.util.TreeMap$SubMap... 
Transforming benchmarks.instrumented.java15.util.IdentityHashMap$EntryIterator... 
Transforming benchmarks.instrumented.java15.util.Queue... 
Transforming benchmarks.instrumented.java15.util.Collections$EmptyList... 
Transforming benchmarks.instrumented.java15.util.AbstractMap$1$1... 
Transforming benchmarks.instrumented.java15.util.NoSuchElementException... 
Transforming benchmarks.instrumented.java15.util.AbstractList$ListItr... 
Transforming benchmarks.instrumented.java15.util.IdentityHashMap... 
Transforming benchmarks.instrumented.java15.util.Collections$UnmodifiableCollection$1... 
Transforming benchmarks.instrumented.java15.util.Hashtable$Entry... 
Transforming benchmarks.instrumented.java15.util.TreeMap$ValueIterator... 
Transforming benchmarks.instrumented.java15.util.Collections$SingletonMap... 
Transforming benchmarks.instrumented.java15.util.WeakHashMap$Values... 
Transforming benchmarks.instrumented.java15.util.Collections$EmptySet... 
Transforming benchmarks.instrumented.java15.util.HashMap$KeySet... 
Transforming benchmarks.instrumented.java15.util.Collections$1... 
Transforming benchmarks.instrumented.java15.util.Random... 
==============
 tn units (no order)
l0 := @parameter0: long
virtualinvoke $r1.<java.util.concurrent.atomic.AtomicLong: void set(long)>(l2)
return
$r1 = r0.<benchmarks.instrumented.java15.util.Random: java.util.concurrent.atomic.AtomicLong seed>
r0.<benchmarks.instrumented.java15.util.Random: boolean haveNextNextGaussian> = 0
l2 = $l1 & 281474976710655L
r0 := @this: benchmarks.instrumented.java15.util.Random
$l1 = l0 ^ 25214903917L
==============

==============
 tn units (no order)
$z0 = r0.<benchmarks.instrumented.java15.util.Random: boolean haveNextNextGaussian>
$d5 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Random: double nextDouble()>()
$d15 = d0 * d3
$d13 = $d12 / d2
if $b1 == 0 goto $d5 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Random: double nextDouble()>()
r0 := @this: benchmarks.instrumented.java15.util.Random
$d11 = staticinvoke <java.lang.Math: double log(double)>(d2)
d2 = $d9 + $d10
$d10 = d1 * d1
$b0 = d2 cmpl 1.0
r0.<benchmarks.instrumented.java15.util.Random: boolean haveNextNextGaussian> = 1
$d12 = -2.0 * $d11
return $d4
if $b0 >= 0 goto $d5 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Random: double nextDouble()>()
r0.<benchmarks.instrumented.java15.util.Random: double nextNextGaussian> = $d14
$b1 = d2 cmpl 0.0
$d9 = d0 * d0
$d7 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Random: double nextDouble()>()
d3 = staticinvoke <java.lang.Math: double sqrt(double)>($d13)
if $z0 == 0 goto $d5 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Random: double nextDouble()>()
return $d15
r0.<benchmarks.instrumented.java15.util.Random: boolean haveNextNextGaussian> = 0
d0 = $d6 - 1.0
$d6 = 2.0 * $d5
$d8 = 2.0 * $d7
$d4 = r0.<benchmarks.instrumented.java15.util.Random: double nextNextGaussian>
d1 = $d8 - 1.0
$d14 = d1 * d3
==============

==============
 tn units (no order)
virtualinvoke r2.<java.io.ObjectOutputStream$PutField: void put(java.lang.String,long)>("seed", $l0)
$l0 = virtualinvoke $r3.<java.util.concurrent.atomic.AtomicLong: long get()>()
$r3 = r0.<benchmarks.instrumented.java15.util.Random: java.util.concurrent.atomic.AtomicLong seed>
$d0 = r0.<benchmarks.instrumented.java15.util.Random: double nextNextGaussian>
virtualinvoke r1.<java.io.ObjectOutputStream: void writeFields()>()
$z0 = r0.<benchmarks.instrumented.java15.util.Random: boolean haveNextNextGaussian>
r1 := @parameter0: java.io.ObjectOutputStream
virtualinvoke r2.<java.io.ObjectOutputStream$PutField: void put(java.lang.String,boolean)>("haveNextNextGaussian", $z0)
virtualinvoke r2.<java.io.ObjectOutputStream$PutField: void put(java.lang.String,double)>("nextNextGaussian", $d0)
r2 = virtualinvoke r1.<java.io.ObjectOutputStream: java.io.ObjectOutputStream$PutField putFields()>()
r0 := @this: benchmarks.instrumented.java15.util.Random
return
==============

Transforming benchmarks.instrumented.java15.util.Collections$UnmodifiableSet... 
Transforming benchmarks.instrumented.java15.util.WeakHashMap$ValueIterator... 
Transforming benchmarks.instrumented.java15.util.Map$Entry... 
Transforming benchmarks.instrumented.java15.util.EnumMap$EntrySet... 
Transforming benchmarks.instrumented.java15.util.EnumSet... 
Transforming benchmarks.instrumented.java15.util.Hashtable$EmptyIterator... 
Transforming benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet... 
==============
 tn units (no order)
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet: benchmarks.instrumented.java15.util.SortedSet ss>
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.SortedSet: benchmarks.instrumented.java15.util.Comparator comparator()>()
entermonitor $r2
exitmonitor r1
exitmonitor r1
$r5 := @caughtexception
==============

==============
 tn units (no order)
$r6 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet: benchmarks.instrumented.java15.util.SortedSet ss>
exitmonitor r3
specialinvoke $r5.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet: void <init>(benchmarks.instrumented.java15.util.SortedSet,java.lang.Object)>($r7, $r8)
$r5 = new benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet
exitmonitor r3
$r8 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet: java.lang.Object mutex>
$r7 = interfaceinvoke $r6.<benchmarks.instrumented.java15.util.SortedSet: benchmarks.instrumented.java15.util.SortedSet subSet(java.lang.Object,java.lang.Object)>(r1, r2)
$r9 := @caughtexception
entermonitor $r4
==============

==============
 tn units (no order)
$r7 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet: java.lang.Object mutex>
entermonitor $r3
specialinvoke $r4.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet: void <init>(benchmarks.instrumented.java15.util.SortedSet,java.lang.Object)>($r6, $r7)
$r8 := @caughtexception
exitmonitor r2
$r5 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet: benchmarks.instrumented.java15.util.SortedSet ss>
exitmonitor r2
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java15.util.SortedSet: benchmarks.instrumented.java15.util.SortedSet headSet(java.lang.Object)>(r1)
$r4 = new benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet
==============

==============
 tn units (no order)
$r8 := @caughtexception
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java15.util.SortedSet: benchmarks.instrumented.java15.util.SortedSet tailSet(java.lang.Object)>(r1)
$r7 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet: java.lang.Object mutex>
$r4 = new benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet
specialinvoke $r4.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet: void <init>(benchmarks.instrumented.java15.util.SortedSet,java.lang.Object)>($r6, $r7)
exitmonitor r2
$r5 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet: benchmarks.instrumented.java15.util.SortedSet ss>
entermonitor $r3
exitmonitor r2
==============

==============
 tn units (no order)
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.SortedSet: java.lang.Object first()>()
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet: benchmarks.instrumented.java15.util.SortedSet ss>
exitmonitor r1
entermonitor $r2
exitmonitor r1
$r5 := @caughtexception
==============

==============
 tn units (no order)
entermonitor $r2
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet: benchmarks.instrumented.java15.util.SortedSet ss>
exitmonitor r1
$r5 := @caughtexception
exitmonitor r1
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.SortedSet: java.lang.Object last()>()
==============

Transforming benchmarks.instrumented.java15.util.Collections$UnmodifiableList$1... 
Transforming benchmarks.instrumented.java15.util.Iterator... 
Transforming benchmarks.instrumented.java15.util.EnumMap... 
Transforming benchmarks.instrumented.java15.util.LinkedHashMap$LinkedHashIterator... 
Transforming benchmarks.instrumented.java15.util.TreeMap$2... 
Transforming benchmarks.instrumented.java15.util.StringTokenizer... 
Transforming benchmarks.instrumented.java15.util.HashMap$EntryIterator... 
Transforming benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap... 
==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap: benchmarks.instrumented.java15.util.SortedMap sm>
exitmonitor r1
$r5 := @caughtexception
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.SortedMap: benchmarks.instrumented.java15.util.Comparator comparator()>()
==============

==============
 tn units (no order)
exitmonitor r3
$r8 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap: java.lang.Object mutex>
specialinvoke $r5.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap: void <init>(benchmarks.instrumented.java15.util.SortedMap,java.lang.Object)>($r7, $r8)
$r6 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap: benchmarks.instrumented.java15.util.SortedMap sm>
$r5 = new benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap
$r9 := @caughtexception
$r7 = interfaceinvoke $r6.<benchmarks.instrumented.java15.util.SortedMap: benchmarks.instrumented.java15.util.SortedMap subMap(java.lang.Object,java.lang.Object)>(r1, r2)
exitmonitor r3
entermonitor $r4
==============

==============
 tn units (no order)
$r8 := @caughtexception
$r7 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap: java.lang.Object mutex>
$r4 = new benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap
exitmonitor r2
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java15.util.SortedMap: benchmarks.instrumented.java15.util.SortedMap headMap(java.lang.Object)>(r1)
specialinvoke $r4.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap: void <init>(benchmarks.instrumented.java15.util.SortedMap,java.lang.Object)>($r6, $r7)
entermonitor $r3
$r5 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap: benchmarks.instrumented.java15.util.SortedMap sm>
exitmonitor r2
==============

==============
 tn units (no order)
$r5 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap: benchmarks.instrumented.java15.util.SortedMap sm>
exitmonitor r2
specialinvoke $r4.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap: void <init>(benchmarks.instrumented.java15.util.SortedMap,java.lang.Object)>($r6, $r7)
$r7 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap: java.lang.Object mutex>
$r4 = new benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java15.util.SortedMap: benchmarks.instrumented.java15.util.SortedMap tailMap(java.lang.Object)>(r1)
entermonitor $r3
$r8 := @caughtexception
exitmonitor r2
==============

==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap: benchmarks.instrumented.java15.util.SortedMap sm>
$r5 := @caughtexception
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.SortedMap: java.lang.Object firstKey()>()
entermonitor $r2
==============

==============
 tn units (no order)
$r5 := @caughtexception
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.SortedMap: java.lang.Object lastKey()>()
entermonitor $r2
exitmonitor r1
exitmonitor r1
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap: benchmarks.instrumented.java15.util.SortedMap sm>
==============

Transforming benchmarks.instrumented.java15.util.Arrays... 
Transforming benchmarks.instrumented.java15.util.Collections$CheckedList$1... 
Transforming benchmarks.instrumented.java15.util.EnumMap$Values... 
Transforming benchmarks.instrumented.java15.util.Collections$SynchronizedList... 
==============
 tn units (no order)
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedList: benchmarks.instrumented.java15.util.List list>
exitmonitor r2
entermonitor $r3
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.List: boolean equals(java.lang.Object)>(r1)
exitmonitor r2
$r5 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r1
$i0 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.List: int hashCode()>()
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedList: benchmarks.instrumented.java15.util.List list>
exitmonitor r1
$r4 := @caughtexception
entermonitor $r2
==============

==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.List: java.lang.Object get(int)>(i0)
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedList: benchmarks.instrumented.java15.util.List list>
$r5 := @caughtexception
entermonitor $r2
==============

==============
 tn units (no order)
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedList: benchmarks.instrumented.java15.util.List list>
exitmonitor r2
$r6 := @caughtexception
$r5 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.List: java.lang.Object set(int,java.lang.Object)>(i0, r1)
exitmonitor r2
entermonitor $r3
==============

==============
 tn units (no order)
entermonitor $r3
exitmonitor r2
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedList: benchmarks.instrumented.java15.util.List list>
$r5 := @caughtexception
exitmonitor r2
interfaceinvoke $r4.<benchmarks.instrumented.java15.util.List: void add(int,java.lang.Object)>(i0, r1)
==============

==============
 tn units (no order)
exitmonitor r1
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedList: benchmarks.instrumented.java15.util.List list>
$r5 := @caughtexception
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.List: java.lang.Object remove(int)>(i0)
exitmonitor r1
entermonitor $r2
==============

==============
 tn units (no order)
$i0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.List: int indexOf(java.lang.Object)>(r1)
exitmonitor r2
$r5 := @caughtexception
entermonitor $r3
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedList: benchmarks.instrumented.java15.util.List list>
exitmonitor r2
==============

==============
 tn units (no order)
$i0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.List: int lastIndexOf(java.lang.Object)>(r1)
$r5 := @caughtexception
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedList: benchmarks.instrumented.java15.util.List list>
exitmonitor r2
entermonitor $r3
exitmonitor r2
==============

==============
 tn units (no order)
exitmonitor r2
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedList: benchmarks.instrumented.java15.util.List list>
exitmonitor r2
$r5 := @caughtexception
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.List: boolean addAll(int,benchmarks.instrumented.java15.util.Collection)>(i0, r1)
entermonitor $r3
==============

==============
 tn units (no order)
$r6 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedList: java.lang.Object mutex>
$r7 := @caughtexception
$r5 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.List: benchmarks.instrumented.java15.util.List subList(int,int)>(i0, i1)
entermonitor $r2
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedList: benchmarks.instrumented.java15.util.List list>
$r3 = new benchmarks.instrumented.java15.util.Collections$SynchronizedList
exitmonitor r1
specialinvoke $r3.<benchmarks.instrumented.java15.util.Collections$SynchronizedList: void <init>(benchmarks.instrumented.java15.util.List,java.lang.Object)>($r5, $r6)
exitmonitor r1
==============

Transforming benchmarks.instrumented.java15.util.PriorityQueue$Itr... 
Transforming benchmarks.instrumented.java15.util.ListIterator... 
Transforming benchmarks.instrumented.java15.util.AbstractList$Itr... 
Transforming benchmarks.instrumented.java15.util.SortedSet... 
Transforming benchmarks.instrumented.java15.util.LinkedList$Entry... 
Transforming benchmarks.instrumented.java15.util.RandomAccessSubList... 
Transforming benchmarks.instrumented.java15.util.PriorityQueue... 
Transforming benchmarks.instrumented.java15.util.IdentityHashMap$ValueIterator... 
Transforming benchmarks.instrumented.java15.util.WeakHashMap$EntrySet... 
Transforming benchmarks.instrumented.java15.util.Hashtable... 
==============
 tn units (no order)
$i0 = r0.<benchmarks.instrumented.java15.util.Hashtable: int count>
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
return $i0
==============

==============
 tn units (no order)
return 1
return 0
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
$i0 = r0.<benchmarks.instrumented.java15.util.Hashtable: int count>
if $i0 != 0 goto return 0
==============

==============
 tn units (no order)
$r1 = specialinvoke r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Enumeration getEnumeration(int)>(0)
return $r1
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
==============

==============
 tn units (no order)
return $r1
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
$r1 = specialinvoke r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Enumeration getEnumeration(int)>(1)
==============

==============
 tn units (no order)
if r3 != null goto $r5 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object value>
if $i1 > 0 goto r3 = r2[i0]
throw $r4
goto [?= (branch)]
r1 := @parameter0: java.lang.Object
r2 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
goto [?= $i1 = i0]
$r5 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object value>
if $z0 == 0 goto r3 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
r3 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
return 0
if r1 != null goto r2 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
i0 = lengthof r2
specialinvoke $r4.<java.lang.NullPointerException: void <init>()>()
return 1
r3 = r2[i0]
$r4 = new java.lang.NullPointerException
$i1 = i0
$z0 = virtualinvoke $r5.<java.lang.Object: boolean equals(java.lang.Object)>(r1)
i0 = i0 + -1
==============

==============
 tn units (no order)
$i2 = i0 & 2147483647
$z0 = virtualinvoke $r4.<java.lang.Object: boolean equals(java.lang.Object)>(r1)
return 1
r2 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
if r3 != null goto $i4 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: int hash>
i0 = virtualinvoke r1.<java.lang.Object: int hashCode()>()
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
r3 = r2[i1]
goto [?= (branch)]
i1 = $i2 % $i3
if $i4 != i0 goto r3 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
r1 := @parameter0: java.lang.Object
if $z0 == 0 goto r3 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
$r4 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object key>
r3 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
$i4 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: int hash>
return 0
$i3 = lengthof r2
==============

==============
 tn units (no order)
r3 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
$i4 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: int hash>
goto [?= (branch)]
r1 := @parameter0: java.lang.Object
return null
r2 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
$i3 = lengthof r2
if r3 != null goto $i4 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: int hash>
if $i4 != i0 goto r3 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
i1 = $i2 % $i3
$r4 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object key>
$r5 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object value>
if $z0 == 0 goto r3 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
r3 = r2[i1]
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
$z0 = virtualinvoke $r4.<java.lang.Object: boolean equals(java.lang.Object)>(r1)
$i2 = i0 & 2147483647
return $r5
i0 = virtualinvoke r1.<java.lang.Object: int hashCode()>()
==============

==============
 tn units (no order)
$i8 = r0.<benchmarks.instrumented.java15.util.Hashtable: int threshold>
$i2 = i0 & 2147483647
return r5
$r10 = new benchmarks.instrumented.java15.util.Hashtable$Entry
i1 = $i2 % $i3
$i6 = $i5 + 1
$r6 = new java.lang.NullPointerException
i0 = virtualinvoke r1.<java.lang.Object: int hashCode()>()
r0.<benchmarks.instrumented.java15.util.Hashtable: int modCount> = $i6
r3[i1] = $r10
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
$i4 = r4.<benchmarks.instrumented.java15.util.Hashtable$Entry: int hash>
r2 := @parameter1: java.lang.Object
throw $r6
$z0 = virtualinvoke $r7.<java.lang.Object: boolean equals(java.lang.Object)>(r1)
if $z0 == 0 goto r4 = r4.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
$i3 = lengthof r3
i1 = $i9 % $i10
r4.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object value> = r2
$i11 = r0.<benchmarks.instrumented.java15.util.Hashtable: int count>
specialinvoke $r10.<benchmarks.instrumented.java15.util.Hashtable$Entry: void <init>(int,java.lang.Object,java.lang.Object,benchmarks.instrumented.java15.util.Hashtable$Entry)>(i0, r1, r2, r9)
goto [?= (branch)]
r0.<benchmarks.instrumented.java15.util.Hashtable: int count> = $i12
r4 = r3[i1]
if r2 != null goto r3 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
r1 := @parameter0: java.lang.Object
specialinvoke $r6.<java.lang.NullPointerException: void <init>()>()
r4 = r4.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
r5 = r4.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object value>
r3 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
if $i7 < $i8 goto r9 = r3[i1]
$i12 = $i11 + 1
$i5 = r0.<benchmarks.instrumented.java15.util.Hashtable: int modCount>
return null
r3 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
$r7 = r4.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object key>
if $i4 != i0 goto r4 = r4.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
$i10 = lengthof r3
$i9 = i0 & 2147483647
r9 = r3[i1]
virtualinvoke r0.<benchmarks.instrumented.java15.util.Hashtable: void rehash()>()
if r4 != null goto $i4 = r4.<benchmarks.instrumented.java15.util.Hashtable$Entry: int hash>
$i7 = r0.<benchmarks.instrumented.java15.util.Hashtable: int count>
==============

==============
 tn units (no order)
return r5
$i2 = i0 & 2147483647
$r8 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
i0 = virtualinvoke r1.<java.lang.Object: int hashCode()>()
i1 = $i2 % $i3
r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object value> = null
r3 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
r0.<benchmarks.instrumented.java15.util.Hashtable: int modCount> = $i6
r3 = r2[i1]
if $z0 == 0 goto r4 = r3
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
$i7 = r0.<benchmarks.instrumented.java15.util.Hashtable: int count>
$r9 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
$r6 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object key>
$z0 = virtualinvoke $r6.<java.lang.Object: boolean equals(java.lang.Object)>(r1)
if $i4 != i0 goto r4 = r3
r0.<benchmarks.instrumented.java15.util.Hashtable: int count> = $i8
r2[i1] = $r9
r4.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next> = $r8
$i8 = $i7 - 1
$i5 = r0.<benchmarks.instrumented.java15.util.Hashtable: int modCount>
$i4 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: int hash>
r2 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
r4 = r3
return null
r1 := @parameter0: java.lang.Object
$i6 = $i5 + 1
if r4 == null goto $r9 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
r5 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object value>
if r3 != null goto $i4 = r3.<benchmarks.instrumented.java15.util.Hashtable$Entry: int hash>
r4 = null
goto [?= $i7 = r0.<benchmarks.instrumented.java15.util.Hashtable: int count>]
$i3 = lengthof r2
goto [?= (branch)]
==============

==============
 tn units (no order)
$r5 = interfaceinvoke r2.<benchmarks.instrumented.java15.util.Iterator: java.lang.Object next()>()
if $z0 != 0 goto $r5 = interfaceinvoke r2.<benchmarks.instrumented.java15.util.Iterator: java.lang.Object next()>()
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
goto [?= $z0 = interfaceinvoke r2.<benchmarks.instrumented.java15.util.Iterator: boolean hasNext()>()]
r2 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Set: benchmarks.instrumented.java15.util.Iterator iterator()>()
$r6 = interfaceinvoke r3.<benchmarks.instrumented.java15.util.Map$Entry: java.lang.Object getKey()>()
r3 = (benchmarks.instrumented.java15.util.Map$Entry) $r5
virtualinvoke r0.<benchmarks.instrumented.java15.util.Hashtable: java.lang.Object put(java.lang.Object,java.lang.Object)>($r6, $r7)
return
r1 := @parameter0: benchmarks.instrumented.java15.util.Map
$z0 = interfaceinvoke r2.<benchmarks.instrumented.java15.util.Iterator: boolean hasNext()>()
$r4 = interfaceinvoke r1.<benchmarks.instrumented.java15.util.Map: benchmarks.instrumented.java15.util.Set entrySet()>()
$r7 = interfaceinvoke r3.<benchmarks.instrumented.java15.util.Map$Entry: java.lang.Object getValue()>()
==============

==============
 tn units (no order)
r1[i0] = null
goto [?= i0 = i0 + -1]
$i1 = r0.<benchmarks.instrumented.java15.util.Hashtable: int modCount>
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
i0 = i0 + -1
return
r0.<benchmarks.instrumented.java15.util.Hashtable: int count> = 0
i0 = lengthof r1
$i2 = $i1 + 1
if i0 >= 0 goto r1[i0] = null
r0.<benchmarks.instrumented.java15.util.Hashtable: int modCount> = $i2
r1 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
==============

==============
 tn units (no order)
r1.<benchmarks.instrumented.java15.util.Hashtable: int modCount> = 0
i0 = lengthof $r5
r1 = (benchmarks.instrumented.java15.util.Hashtable) $r2
r1.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Set entrySet> = null
$r5 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
if $r8 == null goto $r12 = null
$i1 = lengthof $r3
$r4 = newarray (benchmarks.instrumented.java15.util.Hashtable$Entry)[$i1]
goto [?= $i3 = i0]
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
$r14 := @caughtexception
$r3 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
i0 = i0 + -1
$r6[$i2] = $r12
$i3 = i0
$r8 = $r7[i0]
$r12 = null
$r12 = (benchmarks.instrumented.java15.util.Hashtable$Entry) $r11
$r11 = virtualinvoke $r10.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object clone()>()
r15 = $r14
throw $r16
$r2 = specialinvoke r0.<java.lang.Object: java.lang.Object clone()>()
$r9 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
if $i3 > 0 goto $r6 = r1.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
return r1
$r6 = r1.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
specialinvoke $r16.<java.lang.InternalError: void <init>()>()
$r16 = new java.lang.InternalError
goto [?= $r6[$i2] = $r12]
r1.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Set keySet> = null
r1.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Collection values> = null
$i2 = i0
r1.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table> = $r4
$r7 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
$r10 = $r9[i0]
==============

==============
 tn units (no order)
goto [?= $r21 = virtualinvoke $r17.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>($r18)]
virtualinvoke r1.<java.lang.StringBuffer: java.lang.StringBuffer append(java.lang.String)>("{")
$r18 = virtualinvoke $r20.<java.lang.StringBuilder: java.lang.String toString()>()
$r13 = virtualinvoke $r15.<java.lang.StringBuilder: java.lang.String toString()>()
r1 = $r7
virtualinvoke r1.<java.lang.StringBuffer: java.lang.StringBuffer append(java.lang.String)>($r22)
$r8 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Set entrySet()>()
$r7 = new java.lang.StringBuffer
if i1 >= i0 goto i1 = i1 + 1
r4 = interfaceinvoke r3.<benchmarks.instrumented.java15.util.Map$Entry: java.lang.Object getKey()>()
goto [?= $r16 = staticinvoke <java.lang.String: java.lang.String valueOf(java.lang.Object)>($r13)]
$i2 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Hashtable: int size()>()
specialinvoke $r7.<java.lang.StringBuffer: void <init>()>()
r5 = interfaceinvoke r3.<benchmarks.instrumented.java15.util.Map$Entry: java.lang.Object getValue()>()
$r15 = virtualinvoke $r14.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r4)
i1 = 0
$r16 = staticinvoke <java.lang.String: java.lang.String valueOf(java.lang.Object)>($r13)
$r22 = virtualinvoke $r21.<java.lang.StringBuilder: java.lang.String toString()>()
specialinvoke $r14.<java.lang.StringBuilder: void <init>()>()
$r26 = virtualinvoke r1.<java.lang.StringBuffer: java.lang.String toString()>()
specialinvoke $r12.<java.lang.StringBuilder: void <init>(java.lang.String)>($r16)
$r19 = new java.lang.StringBuilder
r2 = interfaceinvoke $r8.<benchmarks.instrumented.java15.util.Set: benchmarks.instrumented.java15.util.Iterator iterator()>()
return $r26
goto [?= (branch)]
$r21 = virtualinvoke $r17.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>($r18)
specialinvoke $r19.<java.lang.StringBuilder: void <init>()>()
$r20 = virtualinvoke $r19.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r5)
if r5 != r0 goto $r19 = new java.lang.StringBuilder
r3 = (benchmarks.instrumented.java15.util.Map$Entry) $r10
virtualinvoke r1.<java.lang.StringBuffer: java.lang.StringBuffer append(java.lang.String)>("}")
$r12 = new java.lang.StringBuilder
if r4 != r0 goto $r14 = new java.lang.StringBuilder
i1 = i1 + 1
virtualinvoke r1.<java.lang.StringBuffer: java.lang.StringBuffer append(java.lang.String)>(", ")
$r10 = interfaceinvoke r2.<benchmarks.instrumented.java15.util.Iterator: java.lang.Object next()>()
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
$r14 = new java.lang.StringBuilder
if i1 <= i0 goto $r10 = interfaceinvoke r2.<benchmarks.instrumented.java15.util.Iterator: java.lang.Object next()>()
i0 = $i2 - 1
$r17 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>("=")
$r13 = "(this Map)"
$r18 = "(this Map)"
==============

==============
 tn units (no order)
if $z2 != 0 goto $z3 = interfaceinvoke r3.<benchmarks.instrumented.java15.util.Iterator: boolean hasNext()>()
r2 = (benchmarks.instrumented.java15.util.Map) r1
$r9 = interfaceinvoke r2.<benchmarks.instrumented.java15.util.Map: java.lang.Object get(java.lang.Object)>(r5)
return 0
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
if $r9 != null goto return 0
if $z3 != 0 goto $r8 = interfaceinvoke r3.<benchmarks.instrumented.java15.util.Iterator: java.lang.Object next()>()
r14 = $r13
return 0
return 0
if $i0 == $i1 goto $r7 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Set entrySet()>()
$r10 = interfaceinvoke r2.<benchmarks.instrumented.java15.util.Map: java.lang.Object get(java.lang.Object)>(r5)
goto [?= return 1]
goto [?= $z3 = interfaceinvoke r3.<benchmarks.instrumented.java15.util.Iterator: boolean hasNext()>()]
r5 = interfaceinvoke r4.<benchmarks.instrumented.java15.util.Map$Entry: java.lang.Object getKey()>()
r12 = $r11
if r1 != r0 goto $z0 = r1 instanceof benchmarks.instrumented.java15.util.Map
$i0 = interfaceinvoke r2.<benchmarks.instrumented.java15.util.Map: int size()>()
return 1
if r6 != null goto $r10 = interfaceinvoke r2.<benchmarks.instrumented.java15.util.Map: java.lang.Object get(java.lang.Object)>(r5)
r3 = interfaceinvoke $r7.<benchmarks.instrumented.java15.util.Set: benchmarks.instrumented.java15.util.Iterator iterator()>()
r4 = (benchmarks.instrumented.java15.util.Map$Entry) $r8
if $z0 != 0 goto r2 = (benchmarks.instrumented.java15.util.Map) r1
$i1 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Hashtable: int size()>()
$r8 = interfaceinvoke r3.<benchmarks.instrumented.java15.util.Iterator: java.lang.Object next()>()
r6 = interfaceinvoke r4.<benchmarks.instrumented.java15.util.Map$Entry: java.lang.Object getValue()>()
$r7 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Set entrySet()>()
$r11 := @caughtexception
r1 := @parameter0: java.lang.Object
$z2 = virtualinvoke r6.<java.lang.Object: boolean equals(java.lang.Object)>($r10)
return 0
$r13 := @caughtexception
$z0 = r1 instanceof benchmarks.instrumented.java15.util.Map
return 1
$z1 = interfaceinvoke r2.<benchmarks.instrumented.java15.util.Map: boolean containsKey(java.lang.Object)>(r5)
$z3 = interfaceinvoke r3.<benchmarks.instrumented.java15.util.Iterator: boolean hasNext()>()
return 0
return 0
if $z1 != 0 goto $z3 = interfaceinvoke r3.<benchmarks.instrumented.java15.util.Iterator: boolean hasNext()>()
==============

==============
 tn units (no order)
goto [?= $i7 = lengthof r1]
i0 = 0
return i0
i1 = 0
r2 = r2.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
r0.<benchmarks.instrumented.java15.util.Hashtable: float loadFactor> = $f2
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
i0 = i0 + $i6
$i6 = $i4 ^ $i5
$r3 = r2.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object key>
r2 = r1[i1]
r0.<benchmarks.instrumented.java15.util.Hashtable: float loadFactor> = $f4
$r4 = r2.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object value>
i1 = i1 + 1
$f4 = neg $f3
$i4 = virtualinvoke $r3.<java.lang.Object: int hashCode()>()
$f2 = neg $f1
$f1 = r0.<benchmarks.instrumented.java15.util.Hashtable: float loadFactor>
goto [?= (branch)]
return i0
r1 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
$i7 = lengthof r1
if $i2 == 0 goto return i0
$b3 = $f0 cmpg 0.0F
$f0 = r0.<benchmarks.instrumented.java15.util.Hashtable: float loadFactor>
if r2 != null goto $r3 = r2.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object key>
$i5 = virtualinvoke $r4.<java.lang.Object: int hashCode()>()
$f3 = r0.<benchmarks.instrumented.java15.util.Hashtable: float loadFactor>
$i2 = r0.<benchmarks.instrumented.java15.util.Hashtable: int count>
if i1 < $i7 goto r2 = r1[i1]
if $b3 >= 0 goto $f1 = r0.<benchmarks.instrumented.java15.util.Hashtable: float loadFactor>
==============

==============
 tn units (no order)
r2 = $r5[i0]
i0 = $i3 - 1
goto [?= (branch)]
virtualinvoke r1.<java.io.ObjectOutputStream: void defaultWriteObject()>()
virtualinvoke r1.<java.io.ObjectOutputStream: void writeInt(int)>($i1)
$i3 = lengthof $r4
$r7 = r2.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object value>
$i1 = lengthof $r3
r0 := @this: benchmarks.instrumented.java15.util.Hashtable
virtualinvoke r1.<java.io.ObjectOutputStream: void writeInt(int)>($i2)
return
$r5 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
$r6 = r2.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object key>
$i2 = r0.<benchmarks.instrumented.java15.util.Hashtable: int count>
goto [?= (branch)]
r1 := @parameter0: java.io.ObjectOutputStream
if i0 >= 0 goto $r5 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
$r3 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
i0 = i0 + -1
if r2 != null goto $r6 = r2.<benchmarks.instrumented.java15.util.Hashtable$Entry: java.lang.Object key>
r2 = r2.<benchmarks.instrumented.java15.util.Hashtable$Entry: benchmarks.instrumented.java15.util.Hashtable$Entry next>
virtualinvoke r1.<java.io.ObjectOutputStream: void writeObject(java.lang.Object)>($r6)
virtualinvoke r1.<java.io.ObjectOutputStream: void writeObject(java.lang.Object)>($r7)
$r4 = r0.<benchmarks.instrumented.java15.util.Hashtable: benchmarks.instrumented.java15.util.Hashtable$Entry[] table>
==============

Transforming benchmarks.instrumented.java15.util.AbstractMap$2$1... 
Transforming benchmarks.instrumented.java15.util.Dictionary... 
Transforming benchmarks.instrumented.java15.util.Collections$SelfComparable... 
Transforming benchmarks.instrumented.java15.util.Collections$ReverseComparator2... 
Transforming benchmarks.instrumented.java15.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$UnmodifiableEntry... 
Transforming benchmarks.instrumented.java15.util.HashMap$ValueIterator... 
Transforming benchmarks.instrumented.java15.util.Collections$CheckedList... 
Transforming benchmarks.instrumented.java15.util.AbstractMap$SimpleEntry... 
Transforming benchmarks.instrumented.java15.util.TooManyListenersException... 
Transforming benchmarks.instrumented.java15.util.TreeMap$3... 
Transforming benchmarks.instrumented.java15.util.HashMap$KeyIterator... 
Transforming benchmarks.instrumented.java15.util.Hashtable$EmptyEnumerator... 
Transforming benchmarks.instrumented.java15.util.AbstractMap$1... 
Transforming benchmarks.instrumented.java15.util.EnumMap$EnumMapIterator... 
Transforming benchmarks.instrumented.java15.util.Hashtable$KeySet... 
Transforming benchmarks.instrumented.java15.util.EmptyStackException... 
Transforming benchmarks.instrumented.java15.util.ArrayList... 
Transforming benchmarks.instrumented.java15.util.LinkedHashMap$EntryIterator... 
Transforming benchmarks.instrumented.java15.util.LinkedHashSet... 
Transforming benchmarks.instrumented.java15.util.Enumeration... 
Transforming benchmarks.instrumented.java15.util.WeakHashMap$KeyIterator... 
Transforming benchmarks.instrumented.java15.util.Vector... 
==============
 tn units (no order)
r1 := @parameter0: java.lang.Object[]
r0 := @this: benchmarks.instrumented.java15.util.Vector
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r2, 0, r1, 0, $i0)
return
$i0 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
==============

==============
 tn units (no order)
if $i3 >= i0 goto return
r0 := @this: benchmarks.instrumented.java15.util.Vector
$r5 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData> = $r4
r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$r3 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
return
$i5 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int modCount>
r0.<benchmarks.instrumented.java15.util.Vector: int modCount> = $i2
i0 = lengthof $r3
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r2, 0, $r5, 0, $i5)
$i4 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i2 = $i1 + 1
$r4 = newarray (java.lang.Object)[$i4]
$i3 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
==============

==============
 tn units (no order)
i0 := @parameter0: int
return
specialinvoke r0.<benchmarks.instrumented.java15.util.Vector: void ensureCapacityHelper(int)>(i0)
$i2 = $i1 + 1
r0.<benchmarks.instrumented.java15.util.Vector: int modCount> = $i2
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int modCount>
r0 := @this: benchmarks.instrumented.java15.util.Vector
==============

==============
 tn units (no order)
specialinvoke r0.<benchmarks.instrumented.java15.util.Vector: void ensureCapacityHelper(int)>(i0)
$i2 = r0.<benchmarks.instrumented.java15.util.Vector: int modCount>
i1 = i0
$i4 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
r0.<benchmarks.instrumented.java15.util.Vector: int modCount> = $i3
r0.<benchmarks.instrumented.java15.util.Vector: int elementCount> = i0
if i0 <= $i4 goto i1 = i0
if i1 < $i5 goto $r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
goto [?= $i5 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>]
$r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
i1 = i1 + 1
r0 := @this: benchmarks.instrumented.java15.util.Vector
return
goto [?= r0.<benchmarks.instrumented.java15.util.Vector: int elementCount> = i0]
i0 := @parameter0: int
$r2[i1] = null
$i5 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i3 = $i2 + 1
==============

==============
 tn units (no order)
return $i0
r0 := @this: benchmarks.instrumented.java15.util.Vector
$i0 = lengthof $r1
$r1 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
==============

==============
 tn units (no order)
return $i0
r0 := @this: benchmarks.instrumented.java15.util.Vector
$i0 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
==============

==============
 tn units (no order)
return 0
r0 := @this: benchmarks.instrumented.java15.util.Vector
$i0 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
return 1
if $i0 != 0 goto return 0
==============

==============
 tn units (no order)
i0 := @parameter1: int
i3 = i0
return -1
r1 := @parameter0: java.lang.Object
r0 := @this: benchmarks.instrumented.java15.util.Vector
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r5)
if $r3 != null goto i1 = i1 + 1
$i4 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i2 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$r3 = $r2[i1]
i1 = i0
goto [?= return -1]
if i3 < $i4 goto $r4 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
return i3
i1 = i1 + 1
$r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$r4 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
goto [?= $i4 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>]
goto [?= $i2 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>]
return i1
if r1 != null goto i3 = i0
$r5 = $r4[i3]
if $z0 == 0 goto i3 = i3 + 1
if i1 < $i2 goto $r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
i3 = i3 + 1
==============

==============
 tn units (no order)
r1 := @parameter0: java.lang.Object
$i1 = $i0 - 1
$i0 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
r0 := @this: benchmarks.instrumented.java15.util.Vector
return $i2
$i2 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Vector: int lastIndexOf(java.lang.Object,int)>(r1, $i1)
==============

==============
 tn units (no order)
i0 := @parameter1: int
r1 := @parameter0: java.lang.Object
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i3)
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r11)
return i4
$i3 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
i4 = i0
r0 := @this: benchmarks.instrumented.java15.util.Vector
$r2 = new java.lang.StringBuilder
$r3 = new java.lang.IndexOutOfBoundsException
goto [?= (branch)]
goto [?= (branch)]
if $r9 != null goto i1 = i1 + -1
goto [?= return -1]
if i1 >= 0 goto $r8 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$r9 = $r8[i1]
return -1
i1 = i0
if r1 != null goto i4 = i0
$i2 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
specialinvoke $r3.<java.lang.IndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
$r11 = $r10[i4]
throw $r3
$r10 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
if i0 < $i2 goto (branch)
i1 = i1 + -1
specialinvoke $r2.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
return i1
$r5 = virtualinvoke $r2.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
if i4 >= 0 goto $r10 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
i4 = i4 + -1
$r8 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
if $z0 == 0 goto i4 = i4 + -1
==============

==============
 tn units (no order)
i0 := @parameter0: int
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$r7 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
throw $r2
$r1 = new java.lang.StringBuilder
$i2 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$r4 = virtualinvoke $r1.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
specialinvoke $r1.<java.lang.StringBuilder: void <init>(java.lang.String)>($r3)
specialinvoke $r2.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r6)
r0 := @this: benchmarks.instrumented.java15.util.Vector
$r5 = virtualinvoke $r4.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i2)
if i0 < $i1 goto $r7 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$r8 = $r7[i0]
$r3 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.String toString()>()
$r2 = new java.lang.ArrayIndexOutOfBoundsException
return $r8
==============

==============
 tn units (no order)
return $r3
if $i0 != 0 goto $r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
r0 := @this: benchmarks.instrumented.java15.util.Vector
$r3 = $r2[0]
$r1 = new benchmarks.instrumented.java15.util.NoSuchElementException
$i0 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
throw $r1
specialinvoke $r1.<benchmarks.instrumented.java15.util.NoSuchElementException: void <init>()>()
==============

==============
 tn units (no order)
$r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
specialinvoke $r1.<benchmarks.instrumented.java15.util.NoSuchElementException: void <init>()>()
$r1 = new benchmarks.instrumented.java15.util.NoSuchElementException
$r3 = $r2[$i2]
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
if $i0 != 0 goto $r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$i0 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
return $r3
$i2 = $i1 - 1
r0 := @this: benchmarks.instrumented.java15.util.Vector
throw $r1
==============

==============
 tn units (no order)
$r8[i0] = r1
throw $r3
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
if i0 < $i1 goto $r8 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$r3 = new java.lang.ArrayIndexOutOfBoundsException
$r8 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$r2 = new java.lang.StringBuilder
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
$i2 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
return
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i2)
r0 := @this: benchmarks.instrumented.java15.util.Vector
i0 := @parameter1: int
specialinvoke $r2.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
r1 := @parameter0: java.lang.Object
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$r5 = virtualinvoke $r2.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
==============

==============
 tn units (no order)
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$r3 = new java.lang.StringBuilder
$r5 = virtualinvoke $r3.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
specialinvoke $r3.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
$r2 = new java.lang.ArrayIndexOutOfBoundsException
$r12[$i11] = null
r0 := @this: benchmarks.instrumented.java15.util.Vector
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i5)
$r9 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
if i1 <= 0 goto $i9 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i11 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
if i0 < $i4 goto (branch)
$i5 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r9, $i8, $r10, i0, i1)
$i9 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
throw $r2
$i4 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
r0.<benchmarks.instrumented.java15.util.Vector: int elementCount> = $i10
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
$i8 = i0 + 1
return
$i7 = $i6 - i0
specialinvoke $r2.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
$r10 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
specialinvoke $r8.<java.lang.ArrayIndexOutOfBoundsException: void <init>(int)>(i0)
$i10 = $i9 - 1
i1 = $i7 - 1
r0.<benchmarks.instrumented.java15.util.Vector: int modCount> = $i3
throw $r8
if i0 >= 0 goto $i6 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i3 = $i2 + 1
$r8 = new java.lang.ArrayIndexOutOfBoundsException
$r12 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$i2 = r0.<benchmarks.instrumented.java15.util.Vector: int modCount>
i0 := @parameter0: int
$i6 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
==============

==============
 tn units (no order)
$i3 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$r3 = new java.lang.ArrayIndexOutOfBoundsException
r1 := @parameter0: java.lang.Object
$i11 = $i10 + 1
$r10 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$r9 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
specialinvoke r0.<benchmarks.instrumented.java15.util.Vector: void ensureCapacityHelper(int)>($i6)
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.String toString()>()
$i9 = $i8 - i0
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i4)
$r6 = virtualinvoke $r4.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" > ")
$r4 = new java.lang.StringBuilder
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int modCount>
$i8 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$r5 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$i5 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
return
$i10 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
specialinvoke $r4.<java.lang.StringBuilder: void <init>(java.lang.String)>($r5)
$i7 = i0 + 1
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r8)
r0 := @this: benchmarks.instrumented.java15.util.Vector
i0 := @parameter1: int
$r11 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$i4 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i2 = $i1 + 1
$r11[i0] = r1
throw $r3
if i0 <= $i3 goto $i5 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
r0.<benchmarks.instrumented.java15.util.Vector: int modCount> = $i2
$i6 = $i5 + 1
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r9, i0, $r10, $i7, $i9)
r0.<benchmarks.instrumented.java15.util.Vector: int elementCount> = $i11
==============

==============
 tn units (no order)
r0.<benchmarks.instrumented.java15.util.Vector: int elementCount> = $i5
$i0 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
return
r0 := @this: benchmarks.instrumented.java15.util.Vector
r0.<benchmarks.instrumented.java15.util.Vector: int modCount> = $i2
$i4 = $i3 + 1
$r3[$i0] = r1
$i2 = $i1 + 1
$i5 = $i0 + 1
r1 := @parameter0: java.lang.Object
specialinvoke r0.<benchmarks.instrumented.java15.util.Vector: void ensureCapacityHelper(int)>($i4)
$i3 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int modCount>
$r3 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
==============

==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java15.util.Vector
return 1
r1 := @parameter0: java.lang.Object
virtualinvoke r0.<benchmarks.instrumented.java15.util.Vector: void removeElementAt(int)>(i0)
if i0 < 0 goto return 0
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int modCount>
return 0
$i2 = $i1 + 1
i0 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Vector: int indexOf(java.lang.Object)>(r1)
r0.<benchmarks.instrumented.java15.util.Vector: int modCount> = $i2
==============

==============
 tn units (no order)
return
$i3 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
r0.<benchmarks.instrumented.java15.util.Vector: int modCount> = $i2
$r2[i0] = null
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int modCount>
r0.<benchmarks.instrumented.java15.util.Vector: int elementCount> = 0
$r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
goto [?= $i3 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>]
i0 = i0 + 1
$i2 = $i1 + 1
r0 := @this: benchmarks.instrumented.java15.util.Vector
if i0 < $i3 goto $r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
i0 = 0
==============

==============
 tn units (no order)
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r4, 0, $r5, 0, $i1)
$i0 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$r7 := @caughtexception
r8 = $r7
r1.<benchmarks.instrumented.java15.util.Vector: int modCount> = 0
r0 := @this: benchmarks.instrumented.java15.util.Vector
throw $r9
$r2 = specialinvoke r0.<java.lang.Object: java.lang.Object clone()>()
r1 = (benchmarks.instrumented.java15.util.Vector) $r2
r1.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData> = $r3
return r1
$r3 = newarray (java.lang.Object)[$i0]
$r4 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$r5 = r1.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
specialinvoke $r9.<java.lang.InternalError: void <init>()>()
$r9 = new java.lang.InternalError
==============

==============
 tn units (no order)
r1 = newarray (java.lang.Object)[$i0]
return r1
$r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r2, 0, r1, 0, $i1)
$i0 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
r0 := @this: benchmarks.instrumented.java15.util.Vector
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
==============

==============
 tn units (no order)
if $i0 >= $i1 goto $r5 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
r0 := @this: benchmarks.instrumented.java15.util.Vector
$r3 = virtualinvoke $r2.<java.lang.Class: java.lang.Class getComponentType()>()
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
r1[$i6] = null
$i2 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$r5 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$i3 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r5, 0, r1, 0, $i3)
$i4 = lengthof r1
if $i4 <= $i5 goto return r1
$i5 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$r4 = staticinvoke <java.lang.reflect.Array: java.lang.Object newInstance(java.lang.Class,int)>($r3, $i2)
r1 := @parameter0: java.lang.Object[]
$i6 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i0 = lengthof r1
r1 = (java.lang.Object[]) $r4
return r1
$r2 = virtualinvoke r1.<java.lang.Object: java.lang.Class getClass()>()
==============

==============
 tn units (no order)
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
r0 := @this: benchmarks.instrumented.java15.util.Vector
$r1 = new java.lang.ArrayIndexOutOfBoundsException
return $r3
throw $r1
if i0 < $i1 goto $r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$r3 = $r2[i0]
$r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
i0 := @parameter0: int
specialinvoke $r1.<java.lang.ArrayIndexOutOfBoundsException: void <init>(int)>(i0)
==============

==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java15.util.Vector
r1 := @parameter1: java.lang.Object
return r2
if i0 < $i1 goto $r4 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$r5 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
r2 = $r4[i0]
i0 := @parameter0: int
$r4 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(int)>(i0)
$r3 = new java.lang.ArrayIndexOutOfBoundsException
throw $r3
$r5[i0] = r1
==============

==============
 tn units (no order)
$r3[$i0] = r1
$i4 = $i3 + 1
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int modCount>
r1 := @parameter0: java.lang.Object
return 1
r0 := @this: benchmarks.instrumented.java15.util.Vector
$r3 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
r0.<benchmarks.instrumented.java15.util.Vector: int modCount> = $i2
specialinvoke r0.<benchmarks.instrumented.java15.util.Vector: void ensureCapacityHelper(int)>($i4)
$i0 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i3 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i2 = $i1 + 1
r0.<benchmarks.instrumented.java15.util.Vector: int elementCount> = $i5
$i5 = $i0 + 1
==============

==============
 tn units (no order)
$i2 = r0.<benchmarks.instrumented.java15.util.Vector: int modCount>
$r7 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$i7 = i0 + 1
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(int)>(i0)
r0 := @this: benchmarks.instrumented.java15.util.Vector
$i6 = $i5 - i0
return r2
$i3 = $i2 + 1
throw $r3
$i4 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r5, $i7, $r6, i0, i1)
$r5 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$i9 = $i8 - 1
$i5 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
i0 := @parameter0: int
r2 = $r4[i0]
$r4 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$r6 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
if i0 < $i4 goto $r4 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$i8 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
r0.<benchmarks.instrumented.java15.util.Vector: int modCount> = $i3
r0.<benchmarks.instrumented.java15.util.Vector: int elementCount> = $i9
$r7[$i9] = null
if i1 <= 0 goto $r7 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
i1 = $i6 - 1
$r3 = new java.lang.ArrayIndexOutOfBoundsException
==============

==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java15.util.Vector
return $z0
$z0 = specialinvoke r0.<benchmarks.instrumented.java15.util.AbstractList: boolean containsAll(benchmarks.instrumented.java15.util.Collection)>(r1)
r1 := @parameter0: benchmarks.instrumented.java15.util.Collection
==============

==============
 tn units (no order)
$i6 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i4 = $i3 + i0
r3 = interfaceinvoke r1.<benchmarks.instrumented.java15.util.Collection: java.lang.Object[] toArray()>()
$i5 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i7 = $i6 + i0
specialinvoke r0.<benchmarks.instrumented.java15.util.Vector: void ensureCapacityHelper(int)>($i4)
if i0 == 0 goto return 0
return 0
r0.<benchmarks.instrumented.java15.util.Vector: int elementCount> = $i7
r0.<benchmarks.instrumented.java15.util.Vector: int modCount> = $i2
$i1 = r0.<benchmarks.instrumented.java15.util.Vector: int modCount>
i0 = lengthof r3
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r3, 0, $r4, $i5, i0)
return 1
r0 := @this: benchmarks.instrumented.java15.util.Vector
r1 := @parameter0: benchmarks.instrumented.java15.util.Collection
$i2 = $i1 + 1
$i3 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$r4 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
==============

==============
 tn units (no order)
return $z0
r0 := @this: benchmarks.instrumented.java15.util.Vector
$z0 = specialinvoke r0.<benchmarks.instrumented.java15.util.AbstractList: boolean removeAll(benchmarks.instrumented.java15.util.Collection)>(r1)
r1 := @parameter0: benchmarks.instrumented.java15.util.Collection
==============

==============
 tn units (no order)
$z0 = specialinvoke r0.<benchmarks.instrumented.java15.util.AbstractList: boolean retainAll(benchmarks.instrumented.java15.util.Collection)>(r1)
r0 := @this: benchmarks.instrumented.java15.util.Vector
return $z0
r1 := @parameter0: benchmarks.instrumented.java15.util.Collection
==============

==============
 tn units (no order)
$i10 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i9 = i0 + i1
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r3, 0, $r7, i0, i1)
i2 = $i8 - i0
return 0
$i8 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
if i0 < 0 goto $r4 = new java.lang.ArrayIndexOutOfBoundsException
$i7 = $i6 + i1
$r5 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
if i0 <= $i5 goto r3 = interfaceinvoke r1.<benchmarks.instrumented.java15.util.Collection: java.lang.Object[] toArray()>()
throw $r4
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r5, i0, $r6, $i9, i2)
i1 = lengthof r3
specialinvoke $r4.<java.lang.ArrayIndexOutOfBoundsException: void <init>(int)>(i0)
specialinvoke r0.<benchmarks.instrumented.java15.util.Vector: void ensureCapacityHelper(int)>($i7)
i0 := @parameter0: int
$r4 = new java.lang.ArrayIndexOutOfBoundsException
r0 := @this: benchmarks.instrumented.java15.util.Vector
if i2 <= 0 goto $r7 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
r0.<benchmarks.instrumented.java15.util.Vector: int elementCount> = $i11
return 1
$i4 = $i3 + 1
$r6 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$i11 = $i10 + i1
r3 = interfaceinvoke r1.<benchmarks.instrumented.java15.util.Collection: java.lang.Object[] toArray()>()
$r7 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$i6 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
r0.<benchmarks.instrumented.java15.util.Vector: int modCount> = $i4
r1 := @parameter1: benchmarks.instrumented.java15.util.Collection
$i5 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
if i1 == 0 goto return 0
$i3 = r0.<benchmarks.instrumented.java15.util.Vector: int modCount>
==============

==============
 tn units (no order)
return $z0
$z0 = specialinvoke r0.<benchmarks.instrumented.java15.util.AbstractList: boolean equals(java.lang.Object)>(r1)
r0 := @this: benchmarks.instrumented.java15.util.Vector
r1 := @parameter0: java.lang.Object
==============

==============
 tn units (no order)
$i0 = specialinvoke r0.<benchmarks.instrumented.java15.util.AbstractList: int hashCode()>()
return $i0
r0 := @this: benchmarks.instrumented.java15.util.Vector
==============

==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java15.util.Vector
$r1 = specialinvoke r0.<benchmarks.instrumented.java15.util.AbstractList: java.lang.String toString()>()
return $r1
==============

==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java15.util.Vector
i1 := @parameter1: int
i0 := @parameter0: int
$r1 = specialinvoke r0.<benchmarks.instrumented.java15.util.AbstractList: benchmarks.instrumented.java15.util.List subList(int,int)>(i0, i1)
$r2 = staticinvoke <benchmarks.instrumented.java15.util.Collections: benchmarks.instrumented.java15.util.List synchronizedList(benchmarks.instrumented.java15.util.List,java.lang.Object)>($r1, r0)
return $r2
==============

==============
 tn units (no order)
$r4 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$r3 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
i1 := @parameter1: int
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r2, i1, $r3, i0, i2)
$r4[$i10] = null
r0.<benchmarks.instrumented.java15.util.Vector: int modCount> = $i5
$i7 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
$i4 = r0.<benchmarks.instrumented.java15.util.Vector: int modCount>
$i5 = $i4 + 1
r0 := @this: benchmarks.instrumented.java15.util.Vector
$i10 = $i9 - 1
$i9 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
goto [?= $i11 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>]
i2 = $i6 - i1
$i8 = i1 - i0
return
$r2 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
if $i11 != i3 goto $r4 = r0.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
i3 = $i7 - $i8
r0.<benchmarks.instrumented.java15.util.Vector: int elementCount> = $i10
$i11 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
i0 := @parameter0: int
$i6 = r0.<benchmarks.instrumented.java15.util.Vector: int elementCount>
==============

==============
 tn units (no order)
return
virtualinvoke r1.<java.io.ObjectOutputStream: void defaultWriteObject()>()
r1 := @parameter0: java.io.ObjectOutputStream
r0 := @this: benchmarks.instrumented.java15.util.Vector
==============

Transforming benchmarks.instrumented.java15.util.Collections$SingletonList... 
Transforming benchmarks.instrumented.java15.util.IdentityHashMap$EntrySet... 
Transforming benchmarks.instrumented.java15.util.JumboEnumSet$EnumSetIterator... 
Transforming benchmarks.instrumented.java15.util.Collections$EmptyMap... 
Transforming benchmarks.instrumented.java15.util.WeakHashMap$HashIterator... 
Transforming benchmarks.instrumented.java15.util.Collections$CheckedMap... 
Transforming benchmarks.instrumented.java15.util.HashMap$Entry... 
Transforming benchmarks.instrumented.java15.util.Collections$UnmodifiableSortedSet... 
Transforming benchmarks.instrumented.java15.util.EnumMap$KeySet... 
Transforming benchmarks.instrumented.java15.util.LinkedHashMap$Entry... 
Transforming benchmarks.instrumented.java15.util.Collections$SingletonMap$ImmutableEntry... 
Transforming benchmarks.instrumented.java15.util.Collections$UnmodifiableMap$UnmodifiableEntrySet... 
Transforming benchmarks.instrumented.java15.util.Collections$CheckedMap$CheckedEntrySet$CheckedEntry... 
Transforming benchmarks.instrumented.java15.util.Collections$UnmodifiableRandomAccessList... 
Transforming benchmarks.instrumented.java15.util.Collections$SynchronizedCollection... 
==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor r1
exitmonitor r1
entermonitor $r2
$i0 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.Collection: int size()>()
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedCollection: benchmarks.instrumented.java15.util.Collection c>
==============

==============
 tn units (no order)
entermonitor $r2
exitmonitor r1
$z0 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.Collection: boolean isEmpty()>()
exitmonitor r1
$r4 := @caughtexception
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedCollection: benchmarks.instrumented.java15.util.Collection c>
==============

==============
 tn units (no order)
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedCollection: benchmarks.instrumented.java15.util.Collection c>
entermonitor $r3
$r5 := @caughtexception
exitmonitor r2
exitmonitor r2
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Collection: boolean contains(java.lang.Object)>(r1)
==============

==============
 tn units (no order)
exitmonitor r1
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.Collection: java.lang.Object[] toArray()>()
$r5 := @caughtexception
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedCollection: benchmarks.instrumented.java15.util.Collection c>
exitmonitor r1
entermonitor $r2
==============

==============
 tn units (no order)
$r5 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Collection: java.lang.Object[] toArray(java.lang.Object[])>(r1)
exitmonitor r2
entermonitor $r3
exitmonitor r2
$r6 := @caughtexception
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedCollection: benchmarks.instrumented.java15.util.Collection c>
==============

==============
 tn units (no order)
entermonitor $r3
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Collection: boolean add(java.lang.Object)>(r1)
exitmonitor r2
exitmonitor r2
$r5 := @caughtexception
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedCollection: benchmarks.instrumented.java15.util.Collection c>
==============

==============
 tn units (no order)
entermonitor $r3
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Collection: boolean remove(java.lang.Object)>(r1)
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedCollection: benchmarks.instrumented.java15.util.Collection c>
exitmonitor r2
exitmonitor r2
$r5 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r2
$r5 := @caughtexception
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedCollection: benchmarks.instrumented.java15.util.Collection c>
entermonitor $r3
exitmonitor r2
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Collection: boolean containsAll(benchmarks.instrumented.java15.util.Collection)>(r1)
==============

==============
 tn units (no order)
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Collection: boolean addAll(benchmarks.instrumented.java15.util.Collection)>(r1)
exitmonitor r2
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedCollection: benchmarks.instrumented.java15.util.Collection c>
exitmonitor r2
$r5 := @caughtexception
entermonitor $r3
==============

==============
 tn units (no order)
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedCollection: benchmarks.instrumented.java15.util.Collection c>
exitmonitor r2
entermonitor $r3
$r5 := @caughtexception
exitmonitor r2
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Collection: boolean removeAll(benchmarks.instrumented.java15.util.Collection)>(r1)
==============

==============
 tn units (no order)
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Collection: boolean retainAll(benchmarks.instrumented.java15.util.Collection)>(r1)
exitmonitor r2
exitmonitor r2
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedCollection: benchmarks.instrumented.java15.util.Collection c>
entermonitor $r3
$r5 := @caughtexception
==============

==============
 tn units (no order)
$r4 := @caughtexception
entermonitor $r2
exitmonitor r1
interfaceinvoke $r3.<benchmarks.instrumented.java15.util.Collection: void clear()>()
exitmonitor r1
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedCollection: benchmarks.instrumented.java15.util.Collection c>
==============

==============
 tn units (no order)
entermonitor $r2
$r5 := @caughtexception
$r4 = virtualinvoke $r3.<java.lang.Object: java.lang.String toString()>()
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedCollection: benchmarks.instrumented.java15.util.Collection c>
exitmonitor r1
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r2
virtualinvoke r1.<java.io.ObjectOutputStream: void defaultWriteObject()>()
$r4 := @caughtexception
exitmonitor r2
entermonitor $r3
==============

Transforming benchmarks.instrumented.java15.util.Collections$UnmodifiableMap... 
Transforming benchmarks.instrumented.java15.util.IdentityHashMap$Values... 
Transforming benchmarks.instrumented.java15.util.EnumMap$ValueIterator... 
Transforming benchmarks.instrumented.java15.util.TreeMap$SubMapEntryIterator... 
Transforming benchmarks.instrumented.java15.util.TreeMap$Entry... 
Transforming benchmarks.instrumented.java15.util.Collections$CheckedRandomAccessList... 
Transforming benchmarks.instrumented.java15.util.AbstractSet... 
Transforming benchmarks.instrumented.java15.util.Hashtable$EntrySet... 
Transforming benchmarks.instrumented.java15.util.LinkedHashMap... 
Transforming benchmarks.instrumented.java15.util.HashMap... 
Transforming benchmarks.instrumented.java15.util.List... 
Transforming benchmarks.instrumented.java15.util.TreeMap$EntryIterator... 
Transforming benchmarks.instrumented.java15.util.SubList... 
Transforming benchmarks.instrumented.java15.util.WeakHashMap$Entry... 
Transforming benchmarks.instrumented.java15.util.Vector$1... 
==============
 tn units (no order)
if $i1 >= $i2 goto exitmonitor r1
$i3 = $i0 + 1
exitmonitor r1
entermonitor $r2
$r4 = r0.<benchmarks.instrumented.java15.util.Vector$1: benchmarks.instrumented.java15.util.Vector this$0>
$r3 = r0.<benchmarks.instrumented.java15.util.Vector$1: benchmarks.instrumented.java15.util.Vector this$0>
$i0 = r0.<benchmarks.instrumented.java15.util.Vector$1: int count>
exitmonitor r1
exitmonitor r1
r0.<benchmarks.instrumented.java15.util.Vector$1: int count> = $i3
$i1 = r0.<benchmarks.instrumented.java15.util.Vector$1: int count>
$r7 = $r5[$i0]
$r8 := @caughtexception
$r5 = $r4.<benchmarks.instrumented.java15.util.Vector: java.lang.Object[] elementData>
$i2 = $r3.<benchmarks.instrumented.java15.util.Vector: int elementCount>
==============

Transforming benchmarks.instrumented.java15.util.JumboEnumSet... 
Transforming benchmarks.instrumented.java15.util.Collections$CheckedSortedMap... 
Transforming benchmarks.instrumented.java15.util.Collections$UnmodifiableSortedMap... 
Transforming benchmarks.instrumented.java15.util.Map... 
Transforming benchmarks.instrumented.java15.util.LinkedList... 
Transforming benchmarks.instrumented.java15.util.Stack... 
==============
 tn units (no order)
$i1 = i0 - 1
return r1
virtualinvoke r0.<benchmarks.instrumented.java15.util.Stack: void removeElementAt(int)>($i1)
r0 := @this: benchmarks.instrumented.java15.util.Stack
r1 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Stack: java.lang.Object peek()>()
i0 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Stack: int size()>()
==============

==============
 tn units (no order)
return $r2
r0 := @this: benchmarks.instrumented.java15.util.Stack
i0 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Stack: int size()>()
$r2 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Stack: java.lang.Object elementAt(int)>($i1)
if i0 != 0 goto $i1 = i0 - 1
specialinvoke $r1.<benchmarks.instrumented.java15.util.EmptyStackException: void <init>()>()
throw $r1
$r1 = new benchmarks.instrumented.java15.util.EmptyStackException
$i1 = i0 - 1
==============

==============
 tn units (no order)
return $i2
return -1
i0 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Stack: int lastIndexOf(java.lang.Object)>(r1)
r0 := @this: benchmarks.instrumented.java15.util.Stack
$i2 = $i1 - i0
if i0 < 0 goto return -1
r1 := @parameter0: java.lang.Object
$i1 = virtualinvoke r0.<benchmarks.instrumented.java15.util.Stack: int size()>()
==============

Transforming benchmarks.instrumented.java15.util.TreeMap$SubMap$EntrySetView... 
Transforming benchmarks.instrumented.java15.util.AbstractCollection... 
Transforming benchmarks.instrumented.java15.util.WeakHashMap$EntryIterator... 
Transforming benchmarks.instrumented.java15.util.Collections$EmptySet$1... 
Transforming benchmarks.instrumented.java15.util.AbstractSequentialList... 
Transforming benchmarks.instrumented.java15.util.LinkedList$ListItr... 
Transforming benchmarks.instrumented.java15.util.IdentityHashMap$KeyIterator... 
Transforming benchmarks.instrumented.java15.util.Collections$UnmodifiableList... 
Transforming benchmarks.instrumented.java15.util.Collections$CheckedCollection... 
Transforming benchmarks.instrumented.java15.util.EnumSet$SerializationProxy... 
Transforming benchmarks.instrumented.java15.util.Collections$UnmodifiableCollection... 
Transforming benchmarks.instrumented.java15.util.Collections$SingletonSet$1... 
Transforming benchmarks.instrumented.java15.util.Collections$CheckedSet... 
Transforming benchmarks.instrumented.java15.util.HashSet... 
Transforming benchmarks.instrumented.java15.util.Collections... 
Transforming benchmarks.instrumented.java15.util.TreeMap... 
Transforming benchmarks.instrumented.java15.util.IdentityHashMap$IdentityHashMapIterator... 
Transforming benchmarks.instrumented.java15.util.RegularEnumSet$EnumSetIterator... 
Transforming benchmarks.instrumented.java15.util.Hashtable$ValueCollection... 
Transforming benchmarks.instrumented.java15.util.HashMap$EntrySet... 
Transforming benchmarks.instrumented.java15.util.Collections$CheckedSortedSet... 
Transforming benchmarks.instrumented.java15.util.AbstractList... 
Transforming benchmarks.instrumented.java15.util.RandomAccess... 
Transforming benchmarks.instrumented.java15.util.AbstractQueue... 
Transforming benchmarks.instrumented.java15.util.Collections$CheckedMap$CheckedEntrySet... 
Transforming benchmarks.instrumented.java15.util.LinkedHashMap$ValueIterator... 
Transforming benchmarks.instrumented.java15.util.TreeMap$PrivateEntryIterator... 
Transforming benchmarks.instrumented.java15.util.WeakHashMap... 
Transforming benchmarks.instrumented.java15.util.Collections$SynchronizedSet... 
==============
 tn units (no order)
exitmonitor r2
$r5 := @caughtexception
exitmonitor r2
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java15.util.Collection: boolean equals(java.lang.Object)>(r1)
$r4 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSet: benchmarks.instrumented.java15.util.Collection c>
entermonitor $r3
==============

==============
 tn units (no order)
$r4 := @caughtexception
$r3 = r0.<benchmarks.instrumented.java15.util.Collections$SynchronizedSet: benchmarks.instrumented.java15.util.Collection c>
exitmonitor r1
exitmonitor r1
$i0 = interfaceinvoke $r3.<benchmarks.instrumented.java15.util.Collection: int hashCode()>()
entermonitor $r2
==============

Transforming benchmarks.instrumented.java15.util.SortedMap... 
Transforming benchmarks.instrumented.java15.util.WeakHashMap$KeySet... 
Transforming benchmarks.instrumented.java15.util.RegularEnumSet... 
Transforming benchmarks.instrumented.java15.util.EnumMap$KeyIterator... 
Transforming benchmarks.instrumented.java15.util.Comparator... 
Transforming benchmarks.instrumented.java15.util.HashMap$HashIterator... 
Transforming benchmarks.instrumented.java15.util.Collections$ReverseComparator... 
Transforming benchmarks.instrumented.java.util.Arrays$ArrayList... 
Transforming benchmarks.instrumented.java.util.HashMap$Values... 
Transforming benchmarks.instrumented.java.util.SubList$1... 
Transforming benchmarks.instrumented.java.util.TaskQueue... 
Transforming benchmarks.instrumented.java.util.LinkedHashMap$KeyIterator... 
Transforming benchmarks.instrumented.java.util.IdentityHashMap$KeySet... 
Transforming benchmarks.instrumented.java.util.Hashtable$Enumerator... 
==============
 tn units (no order)
if r4 != null goto $r17 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
$r18 = r0.<benchmarks.instrumented.java.util.Hashtable$Enumerator: benchmarks.instrumented.java.util.Hashtable this$0>
$i9 = $i8 + 1
$i5 = lengthof r2
$r17 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
$r14 = r0.<benchmarks.instrumented.java.util.Hashtable$Enumerator: benchmarks.instrumented.java.util.Hashtable this$0>
if r3 != null goto $r13 = r0.<benchmarks.instrumented.java.util.Hashtable$Enumerator: benchmarks.instrumented.java.util.Hashtable$Entry lastReturned>
$r13 = r0.<benchmarks.instrumented.java.util.Hashtable$Enumerator: benchmarks.instrumented.java.util.Hashtable$Entry lastReturned>
specialinvoke $r19.<benchmarks.instrumented.java.util.ConcurrentModificationException: void <init>()>()
$r11 = r0.<benchmarks.instrumented.java.util.Hashtable$Enumerator: benchmarks.instrumented.java.util.Hashtable this$0>
$i4 = $i3 & 2147483647
$r12 = r0.<benchmarks.instrumented.java.util.Hashtable$Enumerator: benchmarks.instrumented.java.util.Hashtable$Entry lastReturned>
r0.<benchmarks.instrumented.java.util.Hashtable$Enumerator: int expectedModCount> = $i9
if r3 != $r13 goto r4 = r3
r4 = null
throw $r19
$r16 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
$i3 = $r12.<benchmarks.instrumented.java.util.Hashtable$Entry: int hash>
r0.<benchmarks.instrumented.java.util.Hashtable$Enumerator: benchmarks.instrumented.java.util.Hashtable$Entry lastReturned> = null
r2 = staticinvoke <benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] access$2(benchmarks.instrumented.java.util.Hashtable)>($r11)
$i7 = $i6 + 1
r4.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next> = $r17
$i10 = staticinvoke <benchmarks.instrumented.java.util.Hashtable: int access$1(benchmarks.instrumented.java.util.Hashtable)>($r18)
goto [?= $r18 = r0.<benchmarks.instrumented.java.util.Hashtable$Enumerator: benchmarks.instrumented.java.util.Hashtable this$0>]
exitmonitor r1
$i8 = r0.<benchmarks.instrumented.java.util.Hashtable$Enumerator: int expectedModCount>
exitmonitor r1
r3 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
$i11 = $i10 - 1
r4 = r3
i0 = $i4 % $i5
staticinvoke <benchmarks.instrumented.java.util.Hashtable: void access$5(benchmarks.instrumented.java.util.Hashtable,int)>($r18, $i11)
r3 = r2[i0]
$r20 := @caughtexception
r2[i0] = $r16
goto [?= (branch)]
$i6 = staticinvoke <benchmarks.instrumented.java.util.Hashtable: int access$3(benchmarks.instrumented.java.util.Hashtable)>($r14)
entermonitor $r10
staticinvoke <benchmarks.instrumented.java.util.Hashtable: void access$4(benchmarks.instrumented.java.util.Hashtable,int)>($r14, $i7)
$r19 = new benchmarks.instrumented.java.util.ConcurrentModificationException
==============

Transforming benchmarks.instrumented.java.util.TreeSet... 
Transforming benchmarks.instrumented.java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$1... 
Transforming benchmarks.instrumented.java.util.AbstractMap$2... 
Transforming benchmarks.instrumented.java.util.Collection... 
Transforming benchmarks.instrumented.java.util.Collections$SynchronizedRandomAccessList... 
==============
 tn units (no order)
entermonitor $r2
exitmonitor r1
$r7 := @caughtexception
specialinvoke $r3.<benchmarks.instrumented.java.util.Collections$SynchronizedRandomAccessList: void <init>(benchmarks.instrumented.java.util.List,java.lang.Object)>($r5, $r6)
exitmonitor r1
$r5 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.List: benchmarks.instrumented.java.util.List subList(int,int)>(i0, i1)
$r6 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedRandomAccessList: java.lang.Object mutex>
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedRandomAccessList: benchmarks.instrumented.java.util.List list>
$r3 = new benchmarks.instrumented.java.util.Collections$SynchronizedRandomAccessList
==============

Transforming benchmarks.instrumented.java.util.TreeMap$KeyIterator... 
Transforming benchmarks.instrumented.java.util.ConcurrentModificationException... 
Transforming benchmarks.instrumented.java.util.Collections$CopiesList... 
Transforming benchmarks.instrumented.java.util.BitSet... 
Transforming benchmarks.instrumented.java.util.Collections$SingletonSet... 
Transforming benchmarks.instrumented.java.util.Collections$SynchronizedMap... 
==============
 tn units (no order)
$i0 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.Map: int size()>()
exitmonitor r1
$r4 := @caughtexception
exitmonitor r1
entermonitor $r2
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
==============

==============
 tn units (no order)
$z0 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.Map: boolean isEmpty()>()
$r4 := @caughtexception
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
exitmonitor r1
exitmonitor r1
entermonitor $r2
==============

==============
 tn units (no order)
$r5 := @caughtexception
exitmonitor r2
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Map: boolean containsKey(java.lang.Object)>(r1)
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
exitmonitor r2
entermonitor $r3
==============

==============
 tn units (no order)
exitmonitor r2
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Map: boolean containsValue(java.lang.Object)>(r1)
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
exitmonitor r2
entermonitor $r3
$r5 := @caughtexception
==============

==============
 tn units (no order)
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
$r5 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Map: java.lang.Object get(java.lang.Object)>(r1)
exitmonitor r2
exitmonitor r2
entermonitor $r3
$r6 := @caughtexception
==============

==============
 tn units (no order)
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java.util.Map: java.lang.Object put(java.lang.Object,java.lang.Object)>(r1, r2)
exitmonitor r3
$r7 := @caughtexception
$r5 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
exitmonitor r3
entermonitor $r4
==============

==============
 tn units (no order)
$r6 := @caughtexception
exitmonitor r2
entermonitor $r3
exitmonitor r2
$r5 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Map: java.lang.Object remove(java.lang.Object)>(r1)
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
==============

==============
 tn units (no order)
exitmonitor r2
interfaceinvoke $r4.<benchmarks.instrumented.java.util.Map: void putAll(benchmarks.instrumented.java.util.Map)>(r1)
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
exitmonitor r2
entermonitor $r3
$r5 := @caughtexception
==============

==============
 tn units (no order)
exitmonitor r1
$r4 := @caughtexception
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
entermonitor $r2
interfaceinvoke $r3.<benchmarks.instrumented.java.util.Map: void clear()>()
exitmonitor r1
==============

==============
 tn units (no order)
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java.util.Map: benchmarks.instrumented.java.util.Set keySet()>()
$r5 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
$r9 := @caughtexception
exitmonitor r1
r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Set keySet> = $r4
specialinvoke $r4.<benchmarks.instrumented.java.util.Collections$SynchronizedSet: void <init>(benchmarks.instrumented.java.util.Set,java.lang.Object)>($r6, $r7)
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Set keySet>
if $r3 != null goto $r8 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Set keySet>
entermonitor $r2
exitmonitor r1
$r7 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: java.lang.Object mutex>
$r4 = new benchmarks.instrumented.java.util.Collections$SynchronizedSet
$r8 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Set keySet>
==============

==============
 tn units (no order)
$r7 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: java.lang.Object mutex>
r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Set entrySet> = $r4
entermonitor $r2
$r8 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Set entrySet>
specialinvoke $r4.<benchmarks.instrumented.java.util.Collections$SynchronizedSet: void <init>(benchmarks.instrumented.java.util.Set,java.lang.Object)>($r6, $r7)
if $r3 != null goto $r8 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Set entrySet>
$r4 = new benchmarks.instrumented.java.util.Collections$SynchronizedSet
$r9 := @caughtexception
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Set entrySet>
exitmonitor r1
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java.util.Map: benchmarks.instrumented.java.util.Set entrySet()>()
exitmonitor r1
$r5 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
==============

==============
 tn units (no order)
if $r3 != null goto $r8 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Collection values>
exitmonitor r1
$r4 = new benchmarks.instrumented.java.util.Collections$SynchronizedCollection
$r7 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: java.lang.Object mutex>
entermonitor $r2
exitmonitor r1
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Collection values>
$r5 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java.util.Map: benchmarks.instrumented.java.util.Collection values()>()
r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Collection values> = $r4
specialinvoke $r4.<benchmarks.instrumented.java.util.Collections$SynchronizedCollection: void <init>(benchmarks.instrumented.java.util.Collection,java.lang.Object)>($r6, $r7)
$r9 := @caughtexception
$r8 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Collection values>
==============

==============
 tn units (no order)
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
$r5 := @caughtexception
entermonitor $r3
exitmonitor r2
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Map: boolean equals(java.lang.Object)>(r1)
exitmonitor r2
==============

==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
$r4 := @caughtexception
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
$i0 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.Map: int hashCode()>()
entermonitor $r2
==============

==============
 tn units (no order)
exitmonitor r1
exitmonitor r1
$r4 = virtualinvoke $r3.<java.lang.Object: java.lang.String toString()>()
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedMap: benchmarks.instrumented.java.util.Map m>
entermonitor $r2
$r5 := @caughtexception
==============

Transforming benchmarks.instrumented.java.util.TreeMap$1... 
Transforming benchmarks.instrumented.java.util.AbstractMap... 
Transforming benchmarks.instrumented.java.util.Set... 
Transforming benchmarks.instrumented.java.util.TreeMap$SubMap... 
Transforming benchmarks.instrumented.java.util.IdentityHashMap$EntryIterator... 
Transforming benchmarks.instrumented.java.util.Collections$EmptyList... 
Transforming benchmarks.instrumented.java.util.AbstractMap$1$1... 
Transforming benchmarks.instrumented.java.util.NoSuchElementException... 
Transforming benchmarks.instrumented.java.util.Properties... 
==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java.util.Properties
r1 := @parameter0: java.lang.String
return $r3
$r3 = virtualinvoke r0.<benchmarks.instrumented.java.util.Properties: java.lang.Object put(java.lang.Object,java.lang.Object)>(r1, r2)
r2 := @parameter1: java.lang.String
==============

==============
 tn units (no order)
goto [?= r5 = virtualinvoke r4.<java.io.BufferedReader: java.lang.String readLine()>()]
$r13 = new java.lang.StringBuilder
$i17 = virtualinvoke $r18.<java.lang.String: int indexOf(int)>($c16)
$z0 = specialinvoke r0.<benchmarks.instrumented.java.util.Properties: boolean continueLine(java.lang.String)>(r5)
$r10 = " \t\r\n\f"
goto [?= (branch)]
if i12 >= i0 goto $r22 = ""
goto [?= $z0 = specialinvoke r0.<benchmarks.instrumented.java.util.Properties: boolean continueLine(java.lang.String)>(r5)]
r8 = $r22
$c8 = virtualinvoke r6.<java.lang.String: char charAt(int)>(i3)
i15 = i15 + 1
if i15 < i0 goto $r18 = " \t\r\n\f"
i1 = i1 + 1
$r16 = virtualinvoke $r15.<java.lang.StringBuilder: java.lang.String toString()>()
$r18 = " \t\r\n\f"
if $i17 != -1 goto i15 = i15 + 1
$c20 = virtualinvoke r5.<java.lang.String: char charAt(int)>(i15)
i15 = i15 + 1
r21 = virtualinvoke r5.<java.lang.String: java.lang.String substring(int,int)>(i1, i12)
goto [?= i15 = i12]
goto [?= (branch)]
goto [?= r8 = $r22]
specialinvoke $r13.<java.lang.StringBuilder: void <init>(java.lang.String)>($r14)
$r12 = new java.lang.String
$i9 = virtualinvoke $r10.<java.lang.String: int indexOf(int)>($c8)
specialinvoke $r12.<java.lang.String: void <init>(java.lang.String)>($r16)
r5 = virtualinvoke r4.<java.io.BufferedReader: java.lang.String readLine()>()
goto [?= $i11 = virtualinvoke r6.<java.lang.String: int length()>()]
goto [?= r5 = virtualinvoke r4.<java.io.BufferedReader: java.lang.String readLine()>()]
$i14 = virtualinvoke $r17.<java.lang.String: int indexOf(int)>(c13)
if i1 < i0 goto $r9 = " \t\r\n\f"
r24 = specialinvoke r0.<benchmarks.instrumented.java.util.Properties: java.lang.String loadConvert(java.lang.String)>(r8)
r6 = ""
$i19 = virtualinvoke $r19.<java.lang.String: int indexOf(int)>($c18)
if $i19 == -1 goto (branch)
virtualinvoke r0.<benchmarks.instrumented.java.util.Properties: java.lang.Object put(java.lang.Object,java.lang.Object)>(r23, r24)
if r6 != null goto $i7 = i0 - 1
$r9 = " \t\r\n\f"
i12 = i12 + 1
r11 = virtualinvoke r6.<java.lang.String: java.lang.String substring(int,int)>(i3, $i11)
$c5 = virtualinvoke r5.<java.lang.String: char charAt(int)>(i1)
r23 = specialinvoke r0.<benchmarks.instrumented.java.util.Properties: java.lang.String loadConvert(java.lang.String)>(r21)
c13 = virtualinvoke r5.<java.lang.String: char charAt(int)>(i12)
$i11 = virtualinvoke r6.<java.lang.String: int length()>()
goto [?= (branch)]
i0 = virtualinvoke r5.<java.lang.String: int length()>()
$i6 = virtualinvoke $r9.<java.lang.String: int indexOf(int)>($c5)
specialinvoke $r2.<java.io.BufferedReader: void <init>(java.io.Reader)>($r3)
$r2 = new java.io.BufferedReader
r4 = $r2
$i21 = virtualinvoke $r20.<java.lang.String: int indexOf(int)>($c20)
goto [?= $i10 = virtualinvoke r6.<java.lang.String: int length()>()]
if c2 == 35 goto r5 = virtualinvoke r4.<java.io.BufferedReader: java.lang.String readLine()>()
specialinvoke $r3.<java.io.InputStreamReader: void <init>(java.io.InputStream,java.lang.String)>(r1, "8859_1")
goto [?= i12 = i12 + 1]
$i4 = virtualinvoke r5.<java.lang.String: int length()>()
goto [?= (branch)]
i0 = virtualinvoke r5.<java.lang.String: int length()>()
$r14 = staticinvoke <java.lang.String: java.lang.String valueOf(java.lang.Object)>(r7)
$r3 = new java.io.InputStreamReader
r1 := @parameter0: java.io.InputStream
$r22 = ""
$i10 = virtualinvoke r6.<java.lang.String: int length()>()
r0 := @this: benchmarks.instrumented.java.util.Properties
i15 = i12
if i15 >= i0 goto (branch)
if i12 < i0 goto c13 = virtualinvoke r5.<java.lang.String: char charAt(int)>(i12)
i3 = i3 + 1
$r22 = virtualinvoke r5.<java.lang.String: java.lang.String substring(int,int)>(i15, i0)
i3 = 0
if $i6 != -1 goto i1 = i1 + 1
i1 = 0
return
if $i4 <= 0 goto r5 = virtualinvoke r4.<java.io.BufferedReader: java.lang.String readLine()>()
i12 = i12 + 1
r6 = virtualinvoke r4.<java.io.BufferedReader: java.lang.String readLine()>()
$c18 = virtualinvoke r5.<java.lang.String: char charAt(int)>(i15)
goto [?= (branch)]
if $z0 != 0 goto r6 = virtualinvoke r4.<java.io.BufferedReader: java.lang.String readLine()>()
if i3 < $i10 goto $r10 = " \t\r\n\f"
goto [?= r21 = virtualinvoke r5.<java.lang.String: java.lang.String substring(int,int)>(i1, i12)]
$r20 = " \t\r\n\f"
$c16 = virtualinvoke r5.<java.lang.String: char charAt(int)>(i15)
if c2 == 33 goto r5 = virtualinvoke r4.<java.io.BufferedReader: java.lang.String readLine()>()
i15 = i15 + 1
c2 = virtualinvoke r5.<java.lang.String: char charAt(int)>(i1)
if $i21 != -1 goto i15 = i15 + 1
$r15 = virtualinvoke $r13.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r11)
if i15 < i0 goto $r20 = " \t\r\n\f"
$r17 = "=: \t\r\n\f"
$i7 = i0 - 1
goto [?= (branch)]
if $i9 != -1 goto i3 = i3 + 1
r5 = $r12
i12 = i1
if i1 != i0 goto c2 = virtualinvoke r5.<java.lang.String: char charAt(int)>(i1)
r7 = virtualinvoke r5.<java.lang.String: java.lang.String substring(int,int)>(0, $i7)
if c13 != 92 goto $r17 = "=: \t\r\n\f"
if $i14 == -1 goto i12 = i12 + 1
if r5 != null goto $i4 = virtualinvoke r5.<java.lang.String: int length()>()
$r19 = "=:"
==============

==============
 tn units (no order)
return
$r4 := @caughtexception
virtualinvoke r0.<benchmarks.instrumented.java.util.Properties: void store(java.io.OutputStream,java.lang.String)>(r1, r2)
r1 := @parameter0: java.io.OutputStream
goto [?= return]
r3 = $r4
r2 := @parameter1: java.lang.String
r0 := @this: benchmarks.instrumented.java.util.Properties
==============

==============
 tn units (no order)
r21 = specialinvoke r0.<benchmarks.instrumented.java.util.Properties: java.lang.String saveConvert(java.lang.String,boolean)>(r8, 1)
exitmonitor r6
goto [?= $z0 = interfaceinvoke r7.<java.util.Enumeration: boolean hasMoreElements()>()]
$r24 = staticinvoke <java.lang.String: java.lang.String valueOf(java.lang.Object)>(r21)
$r28 := @caughtexception
$z0 = interfaceinvoke r7.<java.util.Enumeration: boolean hasMoreElements()>()
$r19 = interfaceinvoke r7.<java.util.Enumeration: java.lang.Object nextElement()>()
$r27 = virtualinvoke $r26.<java.lang.StringBuilder: java.lang.String toString()>()
r22 = specialinvoke r0.<benchmarks.instrumented.java.util.Properties: java.lang.String saveConvert(java.lang.String,boolean)>(r9, 0)
$r23 = new java.lang.StringBuilder
$r25 = virtualinvoke $r23.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>("=")
r7 = virtualinvoke r0.<benchmarks.instrumented.java.util.Properties: java.util.Enumeration keys()>()
staticinvoke <benchmarks.instrumented.java.util.Properties: void writeln(java.io.BufferedWriter,java.lang.String)>(r5, $r27)
$r20 = virtualinvoke r0.<benchmarks.instrumented.java.util.Properties: java.lang.Object get(java.lang.Object)>(r8)
if $z0 != 0 goto $r19 = interfaceinvoke r7.<java.util.Enumeration: java.lang.Object nextElement()>()
entermonitor r0
r8 = (java.lang.String) $r19
exitmonitor r6
specialinvoke $r23.<java.lang.StringBuilder: void <init>(java.lang.String)>($r24)
r9 = (java.lang.String) $r20
$r26 = virtualinvoke $r25.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(r22)
==============

==============
 tn units (no order)
r1 := @parameter0: benchmarks.instrumented.java.util.Hashtable
if $z0 != 0 goto $r6 = interfaceinvoke r2.<java.util.Enumeration: java.lang.Object nextElement()>()
$r7 = virtualinvoke r0.<benchmarks.instrumented.java.util.Properties: java.lang.Object get(java.lang.Object)>(r3)
r0 := @this: benchmarks.instrumented.java.util.Properties
r3 = (java.lang.String) $r6
$r4 = r0.<benchmarks.instrumented.java.util.Properties: benchmarks.instrumented.java.util.Properties defaults>
if $r4 == null goto r2 = virtualinvoke r0.<benchmarks.instrumented.java.util.Properties: java.util.Enumeration keys()>()
$r5 = r0.<benchmarks.instrumented.java.util.Properties: benchmarks.instrumented.java.util.Properties defaults>
$z0 = interfaceinvoke r2.<java.util.Enumeration: boolean hasMoreElements()>()
virtualinvoke r1.<benchmarks.instrumented.java.util.Hashtable: java.lang.Object put(java.lang.Object,java.lang.Object)>(r3, $r7)
$r6 = interfaceinvoke r2.<java.util.Enumeration: java.lang.Object nextElement()>()
specialinvoke $r5.<benchmarks.instrumented.java.util.Properties: void enumerate(benchmarks.instrumented.java.util.Hashtable)>(r1)
return
goto [?= $z0 = interfaceinvoke r2.<java.util.Enumeration: boolean hasMoreElements()>()]
r2 = virtualinvoke r0.<benchmarks.instrumented.java.util.Properties: java.util.Enumeration keys()>()
==============

Transforming benchmarks.instrumented.java.util.AbstractList$ListItr... 
Transforming benchmarks.instrumented.java.util.ResourceBundle... 
==============
 tn units (no order)
r3 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
r2 = virtualinvoke $r4.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Collection values()>()
exitmonitor r1
$z0 = interfaceinvoke r2.<benchmarks.instrumented.java.util.Collection: boolean remove(java.lang.Object)>(r3)
$r4 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.Hashtable underConstruction>
exitmonitor r1
if $z0 != 0 goto $z0 = interfaceinvoke r2.<benchmarks.instrumented.java.util.Collection: boolean remove(java.lang.Object)>(r3)
$r5 := @caughtexception
entermonitor $r0
==============

==============
 tn units (no order)
goto [?= (branch)]
$r25 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
virtualinvoke $r27.<java.lang.Object: void wait()>()
r34 = virtualinvoke $r32.<sun.misc.SoftCache: java.lang.Object get(java.lang.Object)>($r33)
r8 = virtualinvoke $r18.<sun.misc.SoftCache: java.lang.Object get(java.lang.Object)>($r19)
r7 = virtualinvoke $r11.<java.lang.ref.ReferenceQueue: java.lang.ref.Reference poll()>()
$r28 := @caughtexception
z0 = $z1
virtualinvoke $r39.<benchmarks.instrumented.java.util.Hashtable: java.lang.Object put(java.lang.Object,java.lang.Object)>(r38, $r40)
if r9 == $r25 goto $z1 = 0
exitmonitor r6
goto [?= $r29 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>]
virtualinvoke $r20.<benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey: void clear()>()
$r23 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
$r20 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
entermonitor $r5
$r31 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
$r24 = virtualinvoke $r22.<benchmarks.instrumented.java.util.Hashtable: java.lang.Object get(java.lang.Object)>($r23)
virtualinvoke $r35.<benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey: void clear()>()
exitmonitor r6
if r8 == null goto $r22 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.Hashtable underConstruction>
virtualinvoke $r29.<benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey: void setKeyValues(java.lang.ClassLoader,java.lang.String,java.util.Locale)>(r0, r1, r2)
r38 = virtualinvoke $r37.<benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey: java.lang.Object clone()>()
$r35 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
$r22 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.Hashtable underConstruction>
r9 = (java.lang.Thread) $r24
$r19 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
virtualinvoke $r12.<sun.misc.SoftCache: java.lang.Object remove(java.lang.Object)>($r14)
$r11 = <benchmarks.instrumented.java.util.ResourceBundle: java.lang.ref.ReferenceQueue referenceQueue>
virtualinvoke $r26.<benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey: void clear()>()
$r33 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
$r30 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.Hashtable underConstruction>
goto [?= z0 = $z1]
$r18 = <benchmarks.instrumented.java.util.ResourceBundle: sun.misc.SoftCache cacheList>
$z1 = 0
$r26 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
$r37 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
virtualinvoke $r42.<benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey: void clear()>()
$r29 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
if z0 != 0 goto $r26 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
$r32 = <benchmarks.instrumented.java.util.ResourceBundle: sun.misc.SoftCache cacheList>
virtualinvoke $r17.<benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey: void setKeyValues(java.lang.ClassLoader,java.lang.String,java.util.Locale)>(r0, r1, r2)
r7 = virtualinvoke $r16.<java.lang.ref.ReferenceQueue: java.lang.ref.Reference poll()>()
$r14 = virtualinvoke $r13.<benchmarks.instrumented.java.util.ResourceBundle$LoaderReference: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey getCacheKey()>()
exitmonitor r6
$r39 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.Hashtable underConstruction>
$r16 = <benchmarks.instrumented.java.util.ResourceBundle: java.lang.ref.ReferenceQueue referenceQueue>
$r27 = <benchmarks.instrumented.java.util.ResourceBundle: sun.misc.SoftCache cacheList>
if r7 != null goto $r12 = <benchmarks.instrumented.java.util.ResourceBundle: sun.misc.SoftCache cacheList>
$r12 = <benchmarks.instrumented.java.util.ResourceBundle: sun.misc.SoftCache cacheList>
if z0 == 0 goto $r37 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
$z1 = 1
$r43 := @caughtexception
if r34 == null goto $r37 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
$r17 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
exitmonitor r6
z0 = virtualinvoke $r30.<benchmarks.instrumented.java.util.Hashtable: boolean containsKey(java.lang.Object)>($r31)
$r40 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
goto [?= (branch)]
$r13 = (benchmarks.instrumented.java.util.ResourceBundle$LoaderReference) r7
r10 = $r28
if r9 == null goto $z1 = 0
$r42 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
==============

==============
 tn units (no order)
$r51 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
exitmonitor r46
$z2 = 0
z3 = $z2
exitmonitor r46
$r53 := @caughtexception
$r49 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
$z2 = 1
$r52 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
virtualinvoke $r47.<benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey: void setKeyValues(java.lang.ClassLoader,java.lang.String,java.util.Locale)>(r0, r1, r2)
$r48 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.Hashtable underConstruction>
$r47 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
goto [?= z3 = $z2]
$r50 = virtualinvoke $r48.<benchmarks.instrumented.java.util.Hashtable: java.lang.Object get(java.lang.Object)>($r49)
virtualinvoke $r52.<benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey: void clear()>()
entermonitor $r45
if $r50 != $r51 goto $z2 = 0
==============

==============
 tn units (no order)
$r11 := @caughtexception
$r6 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
entermonitor $r3
$r7 = <benchmarks.instrumented.java.util.ResourceBundle: sun.misc.SoftCache cacheList>
exitmonitor r4
$r9 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
virtualinvoke $r6.<benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey: void setKeyValues(java.lang.ClassLoader,java.lang.String,java.util.Locale)>(r0, r1, r2)
exitmonitor r4
virtualinvoke $r9.<benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey: void clear()>()
r5 = virtualinvoke $r7.<sun.misc.SoftCache: java.lang.Object get(java.lang.Object)>($r8)
$r8 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
==============

==============
 tn units (no order)
$r6 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
virtualinvoke $r14.<benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey: void clear()>()
entermonitor $r4
$r8 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
exitmonitor r5
exitmonitor r5
$r12 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
virtualinvoke $r6.<benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey: void setKeyValues(java.lang.ClassLoader,java.lang.String,java.util.Locale)>(r0, r1, r2)
$r15 = <benchmarks.instrumented.java.util.ResourceBundle: sun.misc.SoftCache cacheList>
virtualinvoke $r11.<benchmarks.instrumented.java.util.Hashtable: java.lang.Object remove(java.lang.Object)>($r12)
$r11 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.Hashtable underConstruction>
virtualinvoke $r7.<sun.misc.SoftCache: java.lang.Object put(java.lang.Object,java.lang.Object)>($r9, r3)
$r7 = <benchmarks.instrumented.java.util.ResourceBundle: sun.misc.SoftCache cacheList>
virtualinvoke $r15.<java.lang.Object: void notifyAll()>()
$r9 = virtualinvoke $r8.<benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey: java.lang.Object clone()>()
$r14 = <benchmarks.instrumented.java.util.ResourceBundle: benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey cacheKey>
$r16 := @caughtexception
==============

Transforming benchmarks.instrumented.java.util.IdentityHashMap... 
Transforming benchmarks.instrumented.java.util.Collections$UnmodifiableCollection$1... 
Transforming benchmarks.instrumented.java.util.PropertyResourceBundle... 
Transforming benchmarks.instrumented.java.util.Hashtable$Entry... 
Transforming benchmarks.instrumented.java.util.TreeMap$ValueIterator... 
Transforming benchmarks.instrumented.java.util.Collections$SingletonMap... 
Transforming benchmarks.instrumented.java.util.WeakHashMap$Values... 
Transforming benchmarks.instrumented.java.util.Collections$EmptySet... 
Transforming benchmarks.instrumented.java.util.HashMap$KeySet... 
Transforming benchmarks.instrumented.java.util.Collections$1... 
Transforming benchmarks.instrumented.java.util.Random... 
==============
 tn units (no order)
if $z0 == 0 goto $r1 = r0.<benchmarks.instrumented.java.util.Random: sun.misc.AtomicLong seed>
l0 := @parameter0: long
r0 := @this: benchmarks.instrumented.java.util.Random
r0.<benchmarks.instrumented.java.util.Random: boolean haveNextNextGaussian> = 0
l2 = $l1 & 281474976710655L
return
$r1 = r0.<benchmarks.instrumented.java.util.Random: sun.misc.AtomicLong seed>
$l1 = l0 ^ 25214903917L
$z0 = virtualinvoke $r1.<sun.misc.AtomicLong: boolean attemptSet(long)>(l2)
==============

==============
 tn units (no order)
if $z0 == 0 goto $d5 = virtualinvoke r0.<benchmarks.instrumented.java.util.Random: double nextDouble()>()
r0.<benchmarks.instrumented.java.util.Random: double nextNextGaussian> = $d14
d3 = staticinvoke <java.lang.Math: double sqrt(double)>($d13)
$d9 = d0 * d0
if $b0 >= 0 goto $d5 = virtualinvoke r0.<benchmarks.instrumented.java.util.Random: double nextDouble()>()
r0 := @this: benchmarks.instrumented.java.util.Random
$d10 = d1 * d1
$d6 = 2.0 * $d5
r0.<benchmarks.instrumented.java.util.Random: boolean haveNextNextGaussian> = 0
$b1 = d2 cmpl 0.0
return $d15
$d15 = d0 * d3
return $d4
$z0 = r0.<benchmarks.instrumented.java.util.Random: boolean haveNextNextGaussian>
$d14 = d1 * d3
d1 = $d8 - 1.0
$d12 = -2.0 * $d11
$b0 = d2 cmpl 1.0
d0 = $d6 - 1.0
if $b1 == 0 goto $d5 = virtualinvoke r0.<benchmarks.instrumented.java.util.Random: double nextDouble()>()
d2 = $d9 + $d10
r0.<benchmarks.instrumented.java.util.Random: boolean haveNextNextGaussian> = 1
$d8 = 2.0 * $d7
$d11 = staticinvoke <java.lang.Math: double log(double)>(d2)
$d4 = r0.<benchmarks.instrumented.java.util.Random: double nextNextGaussian>
$d7 = virtualinvoke r0.<benchmarks.instrumented.java.util.Random: double nextDouble()>()
$d13 = $d12 / d2
$d5 = virtualinvoke r0.<benchmarks.instrumented.java.util.Random: double nextDouble()>()
==============

==============
 tn units (no order)
r2 = virtualinvoke r1.<java.io.ObjectOutputStream: java.io.ObjectOutputStream$PutField putFields()>()
virtualinvoke r1.<java.io.ObjectOutputStream: void writeFields()>()
$d0 = r0.<benchmarks.instrumented.java.util.Random: double nextNextGaussian>
r0 := @this: benchmarks.instrumented.java.util.Random
virtualinvoke r2.<java.io.ObjectOutputStream$PutField: void put(java.lang.String,double)>("nextNextGaussian", $d0)
$l0 = virtualinvoke $r3.<sun.misc.AtomicLong: long get()>()
return
virtualinvoke r2.<java.io.ObjectOutputStream$PutField: void put(java.lang.String,long)>("seed", $l0)
$r3 = r0.<benchmarks.instrumented.java.util.Random: sun.misc.AtomicLong seed>
r1 := @parameter0: java.io.ObjectOutputStream
virtualinvoke r2.<java.io.ObjectOutputStream$PutField: void put(java.lang.String,boolean)>("haveNextNextGaussian", $z0)
$z0 = r0.<benchmarks.instrumented.java.util.Random: boolean haveNextNextGaussian>
==============

Transforming benchmarks.instrumented.java.util.Collections$UnmodifiableSet... 
Transforming benchmarks.instrumented.java.util.WeakHashMap$ValueIterator... 
Transforming benchmarks.instrumented.java.util.Map$Entry... 
Transforming benchmarks.instrumented.java.util.Hashtable$EmptyIterator... 
Transforming benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet... 
==============
 tn units (no order)
exitmonitor r1
$r5 := @caughtexception
entermonitor $r2
exitmonitor r1
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet: benchmarks.instrumented.java.util.SortedSet ss>
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.SortedSet: benchmarks.instrumented.java.util.Comparator comparator()>()
==============

==============
 tn units (no order)
exitmonitor r3
$r9 := @caughtexception
$r5 = new benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet
$r6 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet: benchmarks.instrumented.java.util.SortedSet ss>
$r8 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet: java.lang.Object mutex>
entermonitor $r4
$r7 = interfaceinvoke $r6.<benchmarks.instrumented.java.util.SortedSet: benchmarks.instrumented.java.util.SortedSet subSet(java.lang.Object,java.lang.Object)>(r1, r2)
specialinvoke $r5.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet: void <init>(benchmarks.instrumented.java.util.SortedSet,java.lang.Object)>($r7, $r8)
exitmonitor r3
==============

==============
 tn units (no order)
entermonitor $r3
$r8 := @caughtexception
specialinvoke $r4.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet: void <init>(benchmarks.instrumented.java.util.SortedSet,java.lang.Object)>($r6, $r7)
$r5 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet: benchmarks.instrumented.java.util.SortedSet ss>
$r4 = new benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet
exitmonitor r2
exitmonitor r2
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java.util.SortedSet: benchmarks.instrumented.java.util.SortedSet headSet(java.lang.Object)>(r1)
$r7 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet: java.lang.Object mutex>
==============

==============
 tn units (no order)
specialinvoke $r4.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet: void <init>(benchmarks.instrumented.java.util.SortedSet,java.lang.Object)>($r6, $r7)
$r7 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet: java.lang.Object mutex>
exitmonitor r2
entermonitor $r3
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java.util.SortedSet: benchmarks.instrumented.java.util.SortedSet tailSet(java.lang.Object)>(r1)
$r5 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet: benchmarks.instrumented.java.util.SortedSet ss>
$r4 = new benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet
$r8 := @caughtexception
exitmonitor r2
==============

==============
 tn units (no order)
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.SortedSet: java.lang.Object first()>()
entermonitor $r2
exitmonitor r1
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet: benchmarks.instrumented.java.util.SortedSet ss>
$r5 := @caughtexception
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
exitmonitor r1
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.SortedSet: java.lang.Object last()>()
$r5 := @caughtexception
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet: benchmarks.instrumented.java.util.SortedSet ss>
==============

Transforming benchmarks.instrumented.java.util.Collections$UnmodifiableList$1... 
Transforming benchmarks.instrumented.java.util.Iterator... 
Transforming benchmarks.instrumented.java.util.TimerTask... 
==============
 tn units (no order)
r0.<benchmarks.instrumented.java.util.TimerTask: int state> = 3
goto [?= z0 = $z1]
if $i0 != 1 goto $z1 = 0
exitmonitor r1
$r3 := @caughtexception
$i0 = r0.<benchmarks.instrumented.java.util.TimerTask: int state>
$z1 = 1
exitmonitor r1
entermonitor $r2
z0 = $z1
$z1 = 0
==============

==============
 tn units (no order)
$b1 = $l0 cmp 0L
$l4 = $l5 - $l6
$l3 = r0.<benchmarks.instrumented.java.util.TimerTask: long period>
if $b1 >= 0 goto $l5 = r0.<benchmarks.instrumented.java.util.TimerTask: long nextExecutionTime>
$l0 = r0.<benchmarks.instrumented.java.util.TimerTask: long period>
exitmonitor r1
$l6 = r0.<benchmarks.instrumented.java.util.TimerTask: long period>
goto [?= exitmonitor r1]
entermonitor $r2
$l4 = $l2 + $l3
$l5 = r0.<benchmarks.instrumented.java.util.TimerTask: long nextExecutionTime>
$l2 = r0.<benchmarks.instrumented.java.util.TimerTask: long nextExecutionTime>
exitmonitor r1
$r3 := @caughtexception
==============

Transforming benchmarks.instrumented.java.util.LinkedHashMap$LinkedHashIterator... 
Transforming benchmarks.instrumented.java.util.TreeMap$2... 
Transforming benchmarks.instrumented.java.util.StringTokenizer... 
Transforming benchmarks.instrumented.java.util.HashMap$EntryIterator... 
Transforming benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap... 
==============
 tn units (no order)
$r5 := @caughtexception
exitmonitor r1
exitmonitor r1
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap: benchmarks.instrumented.java.util.SortedMap sm>
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.SortedMap: benchmarks.instrumented.java.util.Comparator comparator()>()
entermonitor $r2
==============

==============
 tn units (no order)
$r9 := @caughtexception
$r8 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap: java.lang.Object mutex>
$r6 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap: benchmarks.instrumented.java.util.SortedMap sm>
entermonitor $r4
specialinvoke $r5.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap: void <init>(benchmarks.instrumented.java.util.SortedMap,java.lang.Object)>($r7, $r8)
exitmonitor r3
$r7 = interfaceinvoke $r6.<benchmarks.instrumented.java.util.SortedMap: benchmarks.instrumented.java.util.SortedMap subMap(java.lang.Object,java.lang.Object)>(r1, r2)
exitmonitor r3
$r5 = new benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap
==============

==============
 tn units (no order)
$r8 := @caughtexception
exitmonitor r2
specialinvoke $r4.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap: void <init>(benchmarks.instrumented.java.util.SortedMap,java.lang.Object)>($r6, $r7)
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java.util.SortedMap: benchmarks.instrumented.java.util.SortedMap headMap(java.lang.Object)>(r1)
exitmonitor r2
$r4 = new benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap
entermonitor $r3
$r7 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap: java.lang.Object mutex>
$r5 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap: benchmarks.instrumented.java.util.SortedMap sm>
==============

==============
 tn units (no order)
exitmonitor r2
$r7 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap: java.lang.Object mutex>
entermonitor $r3
$r4 = new benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap
$r6 = interfaceinvoke $r5.<benchmarks.instrumented.java.util.SortedMap: benchmarks.instrumented.java.util.SortedMap tailMap(java.lang.Object)>(r1)
$r5 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap: benchmarks.instrumented.java.util.SortedMap sm>
exitmonitor r2
$r8 := @caughtexception
specialinvoke $r4.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap: void <init>(benchmarks.instrumented.java.util.SortedMap,java.lang.Object)>($r6, $r7)
==============

==============
 tn units (no order)
entermonitor $r2
exitmonitor r1
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap: benchmarks.instrumented.java.util.SortedMap sm>
$r5 := @caughtexception
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.SortedMap: java.lang.Object firstKey()>()
exitmonitor r1
==============

==============
 tn units (no order)
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.SortedMap: java.lang.Object lastKey()>()
exitmonitor r1
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap: benchmarks.instrumented.java.util.SortedMap sm>
entermonitor $r2
$r5 := @caughtexception
exitmonitor r1
==============

Transforming benchmarks.instrumented.java.util.EventListenerProxy... 
Transforming benchmarks.instrumented.java.util.Arrays... 
Transforming benchmarks.instrumented.java.util.ResourceBundle$LoaderReference... 
Transforming benchmarks.instrumented.java.util.Collections$SynchronizedList... 
==============
 tn units (no order)
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.List: boolean equals(java.lang.Object)>(r1)
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedList: benchmarks.instrumented.java.util.List list>
exitmonitor r2
exitmonitor r2
$r5 := @caughtexception
entermonitor $r3
==============

==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedList: benchmarks.instrumented.java.util.List list>
$r4 := @caughtexception
exitmonitor r1
$i0 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.List: int hashCode()>()
==============

==============
 tn units (no order)
exitmonitor r1
entermonitor $r2
exitmonitor r1
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.List: java.lang.Object get(int)>(i0)
$r5 := @caughtexception
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedList: benchmarks.instrumented.java.util.List list>
==============

==============
 tn units (no order)
exitmonitor r2
entermonitor $r3
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedList: benchmarks.instrumented.java.util.List list>
$r6 := @caughtexception
exitmonitor r2
$r5 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.List: java.lang.Object set(int,java.lang.Object)>(i0, r1)
==============

==============
 tn units (no order)
entermonitor $r3
exitmonitor r2
interfaceinvoke $r4.<benchmarks.instrumented.java.util.List: void add(int,java.lang.Object)>(i0, r1)
$r5 := @caughtexception
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedList: benchmarks.instrumented.java.util.List list>
exitmonitor r2
==============

==============
 tn units (no order)
exitmonitor r1
$r5 := @caughtexception
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.List: java.lang.Object remove(int)>(i0)
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedList: benchmarks.instrumented.java.util.List list>
entermonitor $r2
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r2
exitmonitor r2
$r5 := @caughtexception
$i0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.List: int indexOf(java.lang.Object)>(r1)
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedList: benchmarks.instrumented.java.util.List list>
entermonitor $r3
==============

==============
 tn units (no order)
$r5 := @caughtexception
exitmonitor r2
$i0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.List: int lastIndexOf(java.lang.Object)>(r1)
entermonitor $r3
exitmonitor r2
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedList: benchmarks.instrumented.java.util.List list>
==============

==============
 tn units (no order)
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.List: boolean addAll(int,benchmarks.instrumented.java.util.Collection)>(i0, r1)
exitmonitor r2
entermonitor $r3
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedList: benchmarks.instrumented.java.util.List list>
$r5 := @caughtexception
exitmonitor r2
==============

==============
 tn units (no order)
$r7 := @caughtexception
specialinvoke $r3.<benchmarks.instrumented.java.util.Collections$SynchronizedList: void <init>(benchmarks.instrumented.java.util.List,java.lang.Object)>($r5, $r6)
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedList: benchmarks.instrumented.java.util.List list>
$r6 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedList: java.lang.Object mutex>
exitmonitor r1
exitmonitor r1
$r3 = new benchmarks.instrumented.java.util.Collections$SynchronizedList
entermonitor $r2
$r5 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.List: benchmarks.instrumented.java.util.List subList(int,int)>(i0, i1)
==============

Transforming benchmarks.instrumented.java.util.ListIterator... 
Transforming benchmarks.instrumented.java.util.AbstractList$Itr... 
Transforming benchmarks.instrumented.java.util.SortedSet... 
Transforming benchmarks.instrumented.java.util.LinkedList$Entry... 
Transforming benchmarks.instrumented.java.util.RandomAccessSubList... 
Transforming benchmarks.instrumented.java.util.IdentityHashMap$ValueIterator... 
Transforming benchmarks.instrumented.java.util.WeakHashMap$EntrySet... 
Transforming benchmarks.instrumented.java.util.Hashtable... 
==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java.util.Hashtable
$i0 = r0.<benchmarks.instrumented.java.util.Hashtable: int count>
return $i0
==============

==============
 tn units (no order)
if $i0 != 0 goto return 0
r0 := @this: benchmarks.instrumented.java.util.Hashtable
return 1
return 0
$i0 = r0.<benchmarks.instrumented.java.util.Hashtable: int count>
==============

==============
 tn units (no order)
return $r1
$r1 = specialinvoke r0.<benchmarks.instrumented.java.util.Hashtable: java.util.Enumeration getEnumeration(int)>(0)
r0 := @this: benchmarks.instrumented.java.util.Hashtable
==============

==============
 tn units (no order)
return $r1
r0 := @this: benchmarks.instrumented.java.util.Hashtable
$r1 = specialinvoke r0.<benchmarks.instrumented.java.util.Hashtable: java.util.Enumeration getEnumeration(int)>(1)
==============

==============
 tn units (no order)
if $i1 > 0 goto r3 = r2[i0]
goto [?= (branch)]
r0 := @this: benchmarks.instrumented.java.util.Hashtable
throw $r4
r3 = r2[i0]
i0 = lengthof r2
$r4 = new java.lang.NullPointerException
return 1
r1 := @parameter0: java.lang.Object
return 0
specialinvoke $r4.<java.lang.NullPointerException: void <init>()>()
if r3 != null goto $r5 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object value>
$i1 = i0
r3 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
$r5 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object value>
r2 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
i0 = i0 + -1
$z0 = virtualinvoke $r5.<java.lang.Object: boolean equals(java.lang.Object)>(r1)
if r1 != null goto r2 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
if $z0 == 0 goto r3 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
goto [?= $i1 = i0]
==============

==============
 tn units (no order)
i0 = virtualinvoke r1.<java.lang.Object: int hashCode()>()
if r3 != null goto $i4 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: int hash>
r3 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
r1 := @parameter0: java.lang.Object
$i2 = i0 & 2147483647
if $i4 != i0 goto r3 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
r2 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
$r4 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object key>
$i3 = lengthof r2
r0 := @this: benchmarks.instrumented.java.util.Hashtable
return 1
goto [?= (branch)]
$z0 = virtualinvoke $r4.<java.lang.Object: boolean equals(java.lang.Object)>(r1)
$i4 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: int hash>
return 0
if $z0 == 0 goto r3 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
i1 = $i2 % $i3
r3 = r2[i1]
==============

==============
 tn units (no order)
goto [?= (branch)]
$i2 = i0 & 2147483647
r0 := @this: benchmarks.instrumented.java.util.Hashtable
i0 = virtualinvoke r1.<java.lang.Object: int hashCode()>()
if $i4 != i0 goto r3 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
return null
r3 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
$i3 = lengthof r2
$z0 = virtualinvoke $r4.<java.lang.Object: boolean equals(java.lang.Object)>(r1)
$r4 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object key>
r2 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
$i4 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: int hash>
return $r5
if $z0 == 0 goto r3 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
r1 := @parameter0: java.lang.Object
i1 = $i2 % $i3
if r3 != null goto $i4 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: int hash>
$r5 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object value>
r3 = r2[i1]
==============

==============
 tn units (no order)
$i12 = $i11 + 1
$i9 = i0 & 2147483647
virtualinvoke r0.<benchmarks.instrumented.java.util.Hashtable: void rehash()>()
r0.<benchmarks.instrumented.java.util.Hashtable: int modCount> = $i6
return r5
r1 := @parameter0: java.lang.Object
if $i7 < $i8 goto $r9 = new benchmarks.instrumented.java.util.Hashtable$Entry
i1 = $i9 % $i10
$r6 = new java.lang.NullPointerException
r4 = r4.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
r5 = r4.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object value>
$i2 = i0 & 2147483647
r0.<benchmarks.instrumented.java.util.Hashtable: int count> = $i12
goto [?= (branch)]
$i5 = r0.<benchmarks.instrumented.java.util.Hashtable: int modCount>
throw $r6
r0 := @this: benchmarks.instrumented.java.util.Hashtable
specialinvoke $r9.<benchmarks.instrumented.java.util.Hashtable$Entry: void <init>(int,java.lang.Object,java.lang.Object,benchmarks.instrumented.java.util.Hashtable$Entry)>(i0, r1, r2, $r10)
if $z0 == 0 goto r4 = r4.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
r4 = r3[i1]
$i11 = r0.<benchmarks.instrumented.java.util.Hashtable: int count>
$i4 = r4.<benchmarks.instrumented.java.util.Hashtable$Entry: int hash>
i0 = virtualinvoke r1.<java.lang.Object: int hashCode()>()
$r10 = r3[i1]
r3 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
$z0 = virtualinvoke $r7.<java.lang.Object: boolean equals(java.lang.Object)>(r1)
$i3 = lengthof r3
i1 = $i2 % $i3
return null
$i7 = r0.<benchmarks.instrumented.java.util.Hashtable: int count>
if $i4 != i0 goto r4 = r4.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
specialinvoke $r6.<java.lang.NullPointerException: void <init>()>()
if r4 != null goto $i4 = r4.<benchmarks.instrumented.java.util.Hashtable$Entry: int hash>
r2 := @parameter1: java.lang.Object
r3[i1] = r11
$r7 = r4.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object key>
$r9 = new benchmarks.instrumented.java.util.Hashtable$Entry
$i8 = r0.<benchmarks.instrumented.java.util.Hashtable: int threshold>
r3 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
r4.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object value> = r2
if r2 != null goto r3 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
r11 = $r9
$i6 = $i5 + 1
$i10 = lengthof r3
==============

==============
 tn units (no order)
if $z0 == 0 goto r4 = r3
i0 = virtualinvoke r1.<java.lang.Object: int hashCode()>()
r1 := @parameter0: java.lang.Object
r3 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
if r3 != null goto $i4 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: int hash>
$z0 = virtualinvoke $r6.<java.lang.Object: boolean equals(java.lang.Object)>(r1)
return r5
if $i4 != i0 goto r4 = r3
$i6 = $i5 + 1
r3.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object value> = null
r2[i1] = $r9
r5 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object value>
r2 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
return null
$i4 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: int hash>
$i8 = $i7 - 1
$r9 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
i1 = $i2 % $i3
$r6 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object key>
$r8 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
goto [?= $i7 = r0.<benchmarks.instrumented.java.util.Hashtable: int count>]
$i3 = lengthof r2
r0.<benchmarks.instrumented.java.util.Hashtable: int count> = $i8
if r4 == null goto $r9 = r3.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
r4 = null
r4.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next> = $r8
$i2 = i0 & 2147483647
r4 = r3
$i5 = r0.<benchmarks.instrumented.java.util.Hashtable: int modCount>
goto [?= (branch)]
r0.<benchmarks.instrumented.java.util.Hashtable: int modCount> = $i6
r0 := @this: benchmarks.instrumented.java.util.Hashtable
r3 = r2[i1]
$i7 = r0.<benchmarks.instrumented.java.util.Hashtable: int count>
==============

==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java.util.Hashtable
virtualinvoke r0.<benchmarks.instrumented.java.util.Hashtable: java.lang.Object put(java.lang.Object,java.lang.Object)>($r6, $r7)
$r5 = interfaceinvoke r2.<benchmarks.instrumented.java.util.Iterator: java.lang.Object next()>()
r3 = (benchmarks.instrumented.java.util.Map$Entry) $r5
goto [?= $z0 = interfaceinvoke r2.<benchmarks.instrumented.java.util.Iterator: boolean hasNext()>()]
if $z0 != 0 goto $r5 = interfaceinvoke r2.<benchmarks.instrumented.java.util.Iterator: java.lang.Object next()>()
return
$r7 = interfaceinvoke r3.<benchmarks.instrumented.java.util.Map$Entry: java.lang.Object getValue()>()
r2 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Set: benchmarks.instrumented.java.util.Iterator iterator()>()
$r6 = interfaceinvoke r3.<benchmarks.instrumented.java.util.Map$Entry: java.lang.Object getKey()>()
$r4 = interfaceinvoke r1.<benchmarks.instrumented.java.util.Map: benchmarks.instrumented.java.util.Set entrySet()>()
r1 := @parameter0: benchmarks.instrumented.java.util.Map
$z0 = interfaceinvoke r2.<benchmarks.instrumented.java.util.Iterator: boolean hasNext()>()
==============

==============
 tn units (no order)
r1 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
i0 = lengthof r1
$i2 = $i1 + 1
r1[i0] = null
if i0 >= 0 goto r1[i0] = null
r0.<benchmarks.instrumented.java.util.Hashtable: int modCount> = $i2
goto [?= i0 = i0 + -1]
r0 := @this: benchmarks.instrumented.java.util.Hashtable
r0.<benchmarks.instrumented.java.util.Hashtable: int count> = 0
i0 = i0 + -1
return
$i1 = r0.<benchmarks.instrumented.java.util.Hashtable: int modCount>
==============

==============
 tn units (no order)
$r16 = new java.lang.InternalError
$r12 = (benchmarks.instrumented.java.util.Hashtable$Entry) $r11
$r4 = newarray (benchmarks.instrumented.java.util.Hashtable$Entry)[$i1]
$r3 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
$r8 = $r7[i0]
$r6[$i2] = $r12
$i3 = i0
r1.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Collection values> = null
specialinvoke $r16.<java.lang.InternalError: void <init>()>()
$i1 = lengthof $r3
i0 = lengthof $r5
$r2 = specialinvoke r0.<java.lang.Object: java.lang.Object clone()>()
$r14 := @caughtexception
return r1
$r7 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
$r12 = null
if $i3 > 0 goto $r6 = r1.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
$i2 = i0
goto [?= $i3 = i0]
if $r8 == null goto $r12 = null
r15 = $r14
r1.<benchmarks.instrumented.java.util.Hashtable: int modCount> = 0
$r10 = $r9[i0]
r1 = (benchmarks.instrumented.java.util.Hashtable) $r2
$r5 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
goto [?= $r6[$i2] = $r12]
$r9 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
r1.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Set keySet> = null
i0 = i0 + -1
r1.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table> = $r4
$r6 = r1.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
throw $r16
r1.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Set entrySet> = null
r0 := @this: benchmarks.instrumented.java.util.Hashtable
$r11 = virtualinvoke $r10.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object clone()>()
==============

==============
 tn units (no order)
$r6 = new java.lang.StringBuffer
$r13 = virtualinvoke $r11.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>($r12)
if r4 != r0 goto $r12 = r4
if i1 <= i0 goto $r9 = interfaceinvoke r2.<benchmarks.instrumented.java.util.Iterator: java.lang.Object next()>()
virtualinvoke r1.<java.lang.StringBuffer: java.lang.StringBuffer append(java.lang.String)>("}")
specialinvoke $r11.<java.lang.StringBuilder: void <init>()>()
r1 = $r6
goto [?= $r13 = virtualinvoke $r11.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>($r12)]
$r16 = virtualinvoke $r14.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>($r15)
$r17 = virtualinvoke $r16.<java.lang.StringBuilder: java.lang.String toString()>()
i0 = $i2 - 1
r5 = interfaceinvoke r3.<benchmarks.instrumented.java.util.Map$Entry: java.lang.Object getValue()>()
virtualinvoke r1.<java.lang.StringBuffer: java.lang.StringBuffer append(java.lang.String)>(", ")
if r5 != r0 goto $r15 = r5
$r15 = "(this Map)"
$r12 = r4
$r14 = virtualinvoke $r13.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>("=")
return $r21
goto [?= $r16 = virtualinvoke $r14.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>($r15)]
$r21 = virtualinvoke r1.<java.lang.StringBuffer: java.lang.String toString()>()
virtualinvoke r1.<java.lang.StringBuffer: java.lang.StringBuffer append(java.lang.String)>($r17)
goto [?= (branch)]
$i2 = virtualinvoke r0.<benchmarks.instrumented.java.util.Hashtable: int size()>()
specialinvoke $r6.<java.lang.StringBuffer: void <init>()>()
$r11 = new java.lang.StringBuilder
virtualinvoke r1.<java.lang.StringBuffer: java.lang.StringBuffer append(java.lang.String)>("{")
r0 := @this: benchmarks.instrumented.java.util.Hashtable
$r15 = r5
$r12 = "(this Map)"
r2 = interfaceinvoke $r7.<benchmarks.instrumented.java.util.Set: benchmarks.instrumented.java.util.Iterator iterator()>()
$r9 = interfaceinvoke r2.<benchmarks.instrumented.java.util.Iterator: java.lang.Object next()>()
r3 = (benchmarks.instrumented.java.util.Map$Entry) $r9
i1 = 0
i1 = i1 + 1
if i1 >= i0 goto i1 = i1 + 1
r4 = interfaceinvoke r3.<benchmarks.instrumented.java.util.Map$Entry: java.lang.Object getKey()>()
$r7 = virtualinvoke r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Set entrySet()>()
==============

==============
 tn units (no order)
return 0
if r6 != null goto $r10 = interfaceinvoke r2.<benchmarks.instrumented.java.util.Map: java.lang.Object get(java.lang.Object)>(r5)
r6 = interfaceinvoke r4.<benchmarks.instrumented.java.util.Map$Entry: java.lang.Object getValue()>()
if $i0 == $i1 goto $r7 = virtualinvoke r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Set entrySet()>()
if $z1 != 0 goto $z3 = interfaceinvoke r3.<benchmarks.instrumented.java.util.Iterator: boolean hasNext()>()
r5 = interfaceinvoke r4.<benchmarks.instrumented.java.util.Map$Entry: java.lang.Object getKey()>()
$z1 = interfaceinvoke r2.<benchmarks.instrumented.java.util.Map: boolean containsKey(java.lang.Object)>(r5)
if $z2 != 0 goto $z3 = interfaceinvoke r3.<benchmarks.instrumented.java.util.Iterator: boolean hasNext()>()
return 0
r4 = (benchmarks.instrumented.java.util.Map$Entry) $r8
r3 = interfaceinvoke $r7.<benchmarks.instrumented.java.util.Set: benchmarks.instrumented.java.util.Iterator iterator()>()
if $r9 != null goto return 0
$r8 = interfaceinvoke r3.<benchmarks.instrumented.java.util.Iterator: java.lang.Object next()>()
return 1
r14 = $r13
if $z0 != 0 goto r2 = (benchmarks.instrumented.java.util.Map) r1
if r1 != r0 goto $z0 = r1 instanceof benchmarks.instrumented.java.util.Map
if $z3 != 0 goto $r8 = interfaceinvoke r3.<benchmarks.instrumented.java.util.Iterator: java.lang.Object next()>()
r12 = $r11
return 0
$z3 = interfaceinvoke r3.<benchmarks.instrumented.java.util.Iterator: boolean hasNext()>()
return 0
$r10 = interfaceinvoke r2.<benchmarks.instrumented.java.util.Map: java.lang.Object get(java.lang.Object)>(r5)
return 1
goto [?= return 1]
$r7 = virtualinvoke r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Set entrySet()>()
return 0
r0 := @this: benchmarks.instrumented.java.util.Hashtable
return 0
$z0 = r1 instanceof benchmarks.instrumented.java.util.Map
$i1 = virtualinvoke r0.<benchmarks.instrumented.java.util.Hashtable: int size()>()
$z2 = virtualinvoke r6.<java.lang.Object: boolean equals(java.lang.Object)>($r10)
goto [?= $z3 = interfaceinvoke r3.<benchmarks.instrumented.java.util.Iterator: boolean hasNext()>()]
$i0 = interfaceinvoke r2.<benchmarks.instrumented.java.util.Map: int size()>()
r2 = (benchmarks.instrumented.java.util.Map) r1
$r9 = interfaceinvoke r2.<benchmarks.instrumented.java.util.Map: java.lang.Object get(java.lang.Object)>(r5)
r1 := @parameter0: java.lang.Object
$r11 := @caughtexception
$r13 := @caughtexception
==============

==============
 tn units (no order)
r2 = r2.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
$b3 = $f0 cmpg 0.0F
$r3 = r2.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object key>
$i2 = r0.<benchmarks.instrumented.java.util.Hashtable: int count>
$r4 = r2.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object value>
if i1 < $i7 goto r2 = r1[i1]
$f0 = r0.<benchmarks.instrumented.java.util.Hashtable: float loadFactor>
r0 := @this: benchmarks.instrumented.java.util.Hashtable
if $i2 == 0 goto return i0
if r2 != null goto $r3 = r2.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object key>
$i4 = virtualinvoke $r3.<java.lang.Object: int hashCode()>()
r2 = r1[i1]
return i0
$f3 = r0.<benchmarks.instrumented.java.util.Hashtable: float loadFactor>
$f4 = neg $f3
r0.<benchmarks.instrumented.java.util.Hashtable: float loadFactor> = $f4
i1 = 0
$f1 = r0.<benchmarks.instrumented.java.util.Hashtable: float loadFactor>
i0 = 0
i0 = i0 + $i6
$f2 = neg $f1
goto [?= (branch)]
$i5 = virtualinvoke $r4.<java.lang.Object: int hashCode()>()
$i7 = lengthof r1
return i0
r1 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
r0.<benchmarks.instrumented.java.util.Hashtable: float loadFactor> = $f2
goto [?= $i7 = lengthof r1]
if $b3 >= 0 goto $f1 = r0.<benchmarks.instrumented.java.util.Hashtable: float loadFactor>
$i6 = $i4 ^ $i5
i1 = i1 + 1
==============

==============
 tn units (no order)
virtualinvoke r1.<java.io.ObjectOutputStream: void writeObject(java.lang.Object)>($r6)
$r7 = r2.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object value>
$r5 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
goto [?= (branch)]
if r2 != null goto $r6 = r2.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object key>
$i1 = lengthof $r3
r2 = $r5[i0]
$i3 = lengthof $r4
virtualinvoke r1.<java.io.ObjectOutputStream: void writeObject(java.lang.Object)>($r7)
i0 = $i3 - 1
$r6 = r2.<benchmarks.instrumented.java.util.Hashtable$Entry: java.lang.Object key>
$r3 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
$r4 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
r1 := @parameter0: java.io.ObjectOutputStream
r0 := @this: benchmarks.instrumented.java.util.Hashtable
virtualinvoke r1.<java.io.ObjectOutputStream: void writeInt(int)>($i2)
i0 = i0 + -1
return
r2 = r2.<benchmarks.instrumented.java.util.Hashtable$Entry: benchmarks.instrumented.java.util.Hashtable$Entry next>
virtualinvoke r1.<java.io.ObjectOutputStream: void writeInt(int)>($i1)
$i2 = r0.<benchmarks.instrumented.java.util.Hashtable: int count>
goto [?= (branch)]
if i0 >= 0 goto $r5 = r0.<benchmarks.instrumented.java.util.Hashtable: benchmarks.instrumented.java.util.Hashtable$Entry[] table>
virtualinvoke r1.<java.io.ObjectOutputStream: void defaultWriteObject()>()
==============

Transforming benchmarks.instrumented.java.util.AbstractMap$2$1... 
Transforming benchmarks.instrumented.java.util.Dictionary... 
Transforming benchmarks.instrumented.java.util.PropertyPermission... 
==============
 tn units (no order)
return
if $r2 != null goto virtualinvoke r1.<java.io.ObjectOutputStream: void defaultWriteObject()>()
$r2 = r0.<benchmarks.instrumented.java.util.PropertyPermission: java.lang.String actions>
virtualinvoke r1.<java.io.ObjectOutputStream: void defaultWriteObject()>()
r0 := @this: benchmarks.instrumented.java.util.PropertyPermission
virtualinvoke r0.<benchmarks.instrumented.java.util.PropertyPermission: java.lang.String getActions()>()
r1 := @parameter0: java.io.ObjectOutputStream
==============

==============
 tn units (no order)
return
specialinvoke r0.<benchmarks.instrumented.java.util.PropertyPermission: void init(int)>($i0)
$i0 = staticinvoke <benchmarks.instrumented.java.util.PropertyPermission: int getMask(java.lang.String)>($r2)
r1 := @parameter0: java.io.ObjectInputStream
virtualinvoke r1.<java.io.ObjectInputStream: void defaultReadObject()>()
$r2 = r0.<benchmarks.instrumented.java.util.PropertyPermission: java.lang.String actions>
r0 := @this: benchmarks.instrumented.java.util.PropertyPermission
==============

Transforming benchmarks.instrumented.java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$UnmodifiableEntry... 
Transforming benchmarks.instrumented.java.util.HashMap$ValueIterator... 
Transforming benchmarks.instrumented.java.util.AbstractMap$SimpleEntry... 
Transforming benchmarks.instrumented.java.util.TooManyListenersException... 
Transforming benchmarks.instrumented.java.util.TreeMap$3... 
Transforming benchmarks.instrumented.java.util.HashMap$KeyIterator... 
Transforming benchmarks.instrumented.java.util.Hashtable$EmptyEnumerator... 
Transforming benchmarks.instrumented.java.util.AbstractMap$1... 
Transforming benchmarks.instrumented.java.util.Hashtable$KeySet... 
Transforming benchmarks.instrumented.java.util.EmptyStackException... 
Transforming benchmarks.instrumented.java.util.ArrayList... 
Transforming benchmarks.instrumented.java.util.MissingResourceException... 
Transforming benchmarks.instrumented.java.util.EventListener... 
Transforming benchmarks.instrumented.java.util.LinkedHashMap$EntryIterator... 
Transforming benchmarks.instrumented.java.util.LinkedHashSet... 
Transforming benchmarks.instrumented.java.util.WeakHashMap$KeyIterator... 
Transforming benchmarks.instrumented.java.util.Vector... 
==============
 tn units (no order)
r1 := @parameter0: java.lang.Object[]
r0 := @this: benchmarks.instrumented.java.util.Vector
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r2, 0, r1, 0, $i0)
$i0 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
return
$r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
==============

==============
 tn units (no order)
return
r0.<benchmarks.instrumented.java.util.Vector: int modCount> = $i2
$i3 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$r4 = newarray (java.lang.Object)[$i4]
$r5 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i2 = $i1 + 1
$i5 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$r3 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
i0 = lengthof $r3
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int modCount>
if $i3 >= i0 goto return
r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData> = $r4
r0 := @this: benchmarks.instrumented.java.util.Vector
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r2, 0, $r5, 0, $i5)
r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i4 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
==============

==============
 tn units (no order)
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int modCount>
i0 := @parameter0: int
return
specialinvoke r0.<benchmarks.instrumented.java.util.Vector: void ensureCapacityHelper(int)>(i0)
r0.<benchmarks.instrumented.java.util.Vector: int modCount> = $i2
r0 := @this: benchmarks.instrumented.java.util.Vector
$i2 = $i1 + 1
==============

==============
 tn units (no order)
specialinvoke r0.<benchmarks.instrumented.java.util.Vector: void ensureCapacityHelper(int)>(i0)
r0 := @this: benchmarks.instrumented.java.util.Vector
i1 = i0
if i1 < $i5 goto $r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$r2[i1] = null
goto [?= r0.<benchmarks.instrumented.java.util.Vector: int elementCount> = i0]
$i4 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i2 = r0.<benchmarks.instrumented.java.util.Vector: int modCount>
$i3 = $i2 + 1
if i0 <= $i4 goto i1 = i0
goto [?= $i5 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>]
r0.<benchmarks.instrumented.java.util.Vector: int elementCount> = i0
$i5 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
return
i1 = i1 + 1
i0 := @parameter0: int
r0.<benchmarks.instrumented.java.util.Vector: int modCount> = $i3
==============

==============
 tn units (no order)
$i0 = lengthof $r1
r0 := @this: benchmarks.instrumented.java.util.Vector
$r1 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
return $i0
==============

==============
 tn units (no order)
$i0 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
return $i0
r0 := @this: benchmarks.instrumented.java.util.Vector
==============

==============
 tn units (no order)
return 1
return 0
if $i0 != 0 goto return 0
r0 := @this: benchmarks.instrumented.java.util.Vector
$i0 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
==============

==============
 tn units (no order)
goto [?= $i4 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>]
if $z0 == 0 goto i3 = i3 + 1
goto [?= return -1]
i3 = i0
$i4 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
return i1
$i2 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
if i3 < $i4 goto $r4 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
i1 = i0
if i1 < $i2 goto $r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
r1 := @parameter0: java.lang.Object
r0 := @this: benchmarks.instrumented.java.util.Vector
$r5 = $r4[i3]
if r1 != null goto i3 = i0
goto [?= $i2 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>]
$r3 = $r2[i1]
return -1
return i3
i1 = i1 + 1
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r5)
$r4 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
i3 = i3 + 1
if $r3 != null goto i1 = i1 + 1
i0 := @parameter1: int
==============

==============
 tn units (no order)
$i1 = $i0 - 1
r0 := @this: benchmarks.instrumented.java.util.Vector
$i2 = virtualinvoke r0.<benchmarks.instrumented.java.util.Vector: int lastIndexOf(java.lang.Object,int)>(r1, $i1)
return $i2
$i0 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
r1 := @parameter0: java.lang.Object
==============

==============
 tn units (no order)
if i0 < $i2 goto (branch)
if i1 >= 0 goto $r8 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
goto [?= return -1]
return -1
i1 = i0
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i3)
$r9 = $r8[i1]
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$r8 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
r0 := @this: benchmarks.instrumented.java.util.Vector
return i4
goto [?= (branch)]
if r1 != null goto i4 = i0
$r10 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i2 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$r3 = new java.lang.IndexOutOfBoundsException
i4 = i4 + -1
throw $r3
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r11)
i4 = i0
goto [?= (branch)]
r1 := @parameter0: java.lang.Object
$r2 = new java.lang.StringBuilder
$r11 = $r10[i4]
if $z0 == 0 goto i4 = i4 + -1
$r5 = virtualinvoke $r2.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
specialinvoke $r2.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
i0 := @parameter1: int
specialinvoke $r3.<java.lang.IndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
if i4 >= 0 goto $r10 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
if $r9 != null goto i1 = i1 + -1
return i1
i1 = i1 + -1
$i3 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
==============

==============
 tn units (no order)
throw $r2
return $r8
$r8 = $r7[i0]
specialinvoke $r1.<java.lang.StringBuilder: void <init>(java.lang.String)>($r3)
$r4 = virtualinvoke $r1.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
$r2 = new java.lang.ArrayIndexOutOfBoundsException
r0 := @this: benchmarks.instrumented.java.util.Vector
$r3 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$r7 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$r5 = virtualinvoke $r4.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i2)
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$i2 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
i0 := @parameter0: int
$r1 = new java.lang.StringBuilder
if i0 < $i1 goto $r7 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
specialinvoke $r2.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r6)
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.String toString()>()
==============

==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java.util.Vector
return $r3
$r3 = $r2[0]
$r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i0 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
specialinvoke $r1.<benchmarks.instrumented.java.util.NoSuchElementException: void <init>()>()
throw $r1
if $i0 != 0 goto $r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$r1 = new benchmarks.instrumented.java.util.NoSuchElementException
==============

==============
 tn units (no order)
throw $r1
r0 := @this: benchmarks.instrumented.java.util.Vector
$i2 = $i1 - 1
$r1 = new benchmarks.instrumented.java.util.NoSuchElementException
$r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i0 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$r3 = $r2[$i2]
specialinvoke $r1.<benchmarks.instrumented.java.util.NoSuchElementException: void <init>()>()
return $r3
if $i0 != 0 goto $r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
==============

==============
 tn units (no order)
return
r0 := @this: benchmarks.instrumented.java.util.Vector
$r2 = new java.lang.StringBuilder
specialinvoke $r2.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
$r8 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
r1 := @parameter0: java.lang.Object
$r5 = virtualinvoke $r2.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$r8[i0] = r1
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
$i2 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
i0 := @parameter1: int
$r3 = new java.lang.ArrayIndexOutOfBoundsException
throw $r3
if i0 < $i1 goto $r8 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i2)
==============

==============
 tn units (no order)
$r2 = new java.lang.ArrayIndexOutOfBoundsException
$r10 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i2 = r0.<benchmarks.instrumented.java.util.Vector: int modCount>
$i8 = i0 + 1
specialinvoke $r3.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
$r9 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
i0 := @parameter0: int
r0.<benchmarks.instrumented.java.util.Vector: int elementCount> = $i10
$r5 = virtualinvoke $r3.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
specialinvoke $r8.<java.lang.ArrayIndexOutOfBoundsException: void <init>(int)>(i0)
if i0 < $i4 goto (branch)
if i1 <= 0 goto $i9 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i5)
$i10 = $i9 - 1
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r9, $i8, $r10, i0, i1)
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$i6 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$i4 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
r0 := @this: benchmarks.instrumented.java.util.Vector
$r3 = new java.lang.StringBuilder
specialinvoke $r2.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
throw $r2
r0.<benchmarks.instrumented.java.util.Vector: int modCount> = $i3
$i3 = $i2 + 1
$r8 = new java.lang.ArrayIndexOutOfBoundsException
if i0 >= 0 goto $i6 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$i5 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
throw $r8
$r12[$i11] = null
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
$r12 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i11 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$i7 = $i6 - i0
$i9 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
i1 = $i7 - 1
return
==============

==============
 tn units (no order)
$r11[i0] = r1
$r5 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$r10 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
specialinvoke $r4.<java.lang.StringBuilder: void <init>(java.lang.String)>($r5)
r0 := @this: benchmarks.instrumented.java.util.Vector
$r4 = new java.lang.StringBuilder
$i5 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$i7 = i0 + 1
$i8 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$r6 = virtualinvoke $r4.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" > ")
$i4 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i4)
$r9 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int modCount>
$i10 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
r0.<benchmarks.instrumented.java.util.Vector: int modCount> = $i2
$i3 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
return
$i6 = $i5 + 1
$r11 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
i0 := @parameter1: int
r0.<benchmarks.instrumented.java.util.Vector: int elementCount> = $i11
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r8)
$i2 = $i1 + 1
r1 := @parameter0: java.lang.Object
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r9, i0, $r10, $i7, $i9)
$i9 = $i8 - i0
$r3 = new java.lang.ArrayIndexOutOfBoundsException
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.String toString()>()
specialinvoke r0.<benchmarks.instrumented.java.util.Vector: void ensureCapacityHelper(int)>($i6)
$i11 = $i10 + 1
throw $r3
if i0 <= $i3 goto $i5 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
==============

==============
 tn units (no order)
specialinvoke r0.<benchmarks.instrumented.java.util.Vector: void ensureCapacityHelper(int)>($i4)
r0.<benchmarks.instrumented.java.util.Vector: int modCount> = $i2
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int modCount>
$i4 = $i3 + 1
$r3[$i0] = r1
r1 := @parameter0: java.lang.Object
$i0 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
return
r0.<benchmarks.instrumented.java.util.Vector: int elementCount> = $i5
$i3 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
r0 := @this: benchmarks.instrumented.java.util.Vector
$r3 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i5 = $i0 + 1
$i2 = $i1 + 1
==============

==============
 tn units (no order)
r0.<benchmarks.instrumented.java.util.Vector: int modCount> = $i2
$i2 = $i1 + 1
return 0
r1 := @parameter0: java.lang.Object
if i0 < 0 goto return 0
return 1
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int modCount>
virtualinvoke r0.<benchmarks.instrumented.java.util.Vector: void removeElementAt(int)>(i0)
i0 = virtualinvoke r0.<benchmarks.instrumented.java.util.Vector: int indexOf(java.lang.Object)>(r1)
r0 := @this: benchmarks.instrumented.java.util.Vector
==============

==============
 tn units (no order)
r0.<benchmarks.instrumented.java.util.Vector: int elementCount> = 0
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int modCount>
$r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i2 = $i1 + 1
r0.<benchmarks.instrumented.java.util.Vector: int modCount> = $i2
r0 := @this: benchmarks.instrumented.java.util.Vector
$i3 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
goto [?= $i3 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>]
return
i0 = i0 + 1
i0 = 0
if i0 < $i3 goto $r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$r2[i0] = null
==============

==============
 tn units (no order)
r1.<benchmarks.instrumented.java.util.Vector: int modCount> = 0
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r4, 0, $r5, 0, $i1)
r8 = $r7
$r3 = newarray (java.lang.Object)[$i0]
$r7 := @caughtexception
return r1
throw $r9
$r2 = specialinvoke r0.<java.lang.Object: java.lang.Object clone()>()
r0 := @this: benchmarks.instrumented.java.util.Vector
$r9 = new java.lang.InternalError
r1 = (benchmarks.instrumented.java.util.Vector) $r2
specialinvoke $r9.<java.lang.InternalError: void <init>()>()
$r5 = r1.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i0 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$r4 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
r1.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData> = $r3
==============

==============
 tn units (no order)
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$i0 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
r0 := @this: benchmarks.instrumented.java.util.Vector
return r1
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r2, 0, r1, 0, $i1)
$r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
r1 = newarray (java.lang.Object)[$i0]
==============

==============
 tn units (no order)
if $i4 <= $i5 goto return r1
r1 := @parameter0: java.lang.Object[]
$r2 = virtualinvoke r1.<java.lang.Object: java.lang.Class getClass()>()
$i0 = lengthof r1
$i5 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
if $i0 >= $i1 goto $r5 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r5, 0, r1, 0, $i3)
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
return r1
$r4 = staticinvoke <java.lang.reflect.Array: java.lang.Object newInstance(java.lang.Class,int)>($r3, $i2)
$r3 = virtualinvoke $r2.<java.lang.Class: java.lang.Class getComponentType()>()
$i3 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
r1[$i6] = null
$i4 = lengthof r1
$i2 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$i6 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
r1 = (java.lang.Object[]) $r4
r0 := @this: benchmarks.instrumented.java.util.Vector
$r5 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
==============

==============
 tn units (no order)
$r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
if i0 < $i1 goto $r2 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
i0 := @parameter0: int
$r3 = $r2[i0]
specialinvoke $r1.<java.lang.ArrayIndexOutOfBoundsException: void <init>(int)>(i0)
r0 := @this: benchmarks.instrumented.java.util.Vector
return $r3
throw $r1
$r1 = new java.lang.ArrayIndexOutOfBoundsException
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
==============

==============
 tn units (no order)
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$r5 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$r5[i0] = r1
i0 := @parameter0: int
if i0 < $i1 goto $r4 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$r4 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
r0 := @this: benchmarks.instrumented.java.util.Vector
r1 := @parameter1: java.lang.Object
throw $r3
r2 = $r4[i0]
return r2
$r3 = new java.lang.ArrayIndexOutOfBoundsException
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(int)>(i0)
==============

==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java.util.Vector
$i5 = $i0 + 1
r1 := @parameter0: java.lang.Object
r0.<benchmarks.instrumented.java.util.Vector: int modCount> = $i2
$i3 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int modCount>
$r3[$i0] = r1
$i0 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$i4 = $i3 + 1
$i2 = $i1 + 1
return 1
r0.<benchmarks.instrumented.java.util.Vector: int elementCount> = $i5
$r3 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
specialinvoke r0.<benchmarks.instrumented.java.util.Vector: void ensureCapacityHelper(int)>($i4)
==============

==============
 tn units (no order)
i1 = $i6 - 1
$i8 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$i6 = $i5 - i0
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r5, $i7, $r6, i0, i1)
i0 := @parameter0: int
r0.<benchmarks.instrumented.java.util.Vector: int elementCount> = $i9
r0.<benchmarks.instrumented.java.util.Vector: int modCount> = $i3
$r5 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i9 = $i8 - 1
$i5 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(int)>(i0)
$r7[$i9] = null
$i2 = r0.<benchmarks.instrumented.java.util.Vector: int modCount>
$i4 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
r2 = $r4[i0]
r0 := @this: benchmarks.instrumented.java.util.Vector
$i7 = i0 + 1
$r6 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
if i0 < $i4 goto $r4 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$r4 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
throw $r3
$r7 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
return r2
if i1 <= 0 goto $r7 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$r3 = new java.lang.ArrayIndexOutOfBoundsException
$i3 = $i2 + 1
==============

==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java.util.Vector
r1 := @parameter0: benchmarks.instrumented.java.util.Collection
$z0 = specialinvoke r0.<benchmarks.instrumented.java.util.AbstractList: boolean containsAll(benchmarks.instrumented.java.util.Collection)>(r1)
return $z0
==============

==============
 tn units (no order)
return 0
$i2 = $i1 + 1
r0.<benchmarks.instrumented.java.util.Vector: int modCount> = $i2
$i4 = $i3 + i0
r0.<benchmarks.instrumented.java.util.Vector: int elementCount> = $i7
$i3 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
r1 := @parameter0: benchmarks.instrumented.java.util.Collection
$i1 = r0.<benchmarks.instrumented.java.util.Vector: int modCount>
i0 = lengthof r3
r0 := @this: benchmarks.instrumented.java.util.Vector
$i7 = $i6 + i0
$i5 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
return 1
if i0 == 0 goto return 0
$i6 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r3, 0, $r4, $i5, i0)
r3 = interfaceinvoke r1.<benchmarks.instrumented.java.util.Collection: java.lang.Object[] toArray()>()
specialinvoke r0.<benchmarks.instrumented.java.util.Vector: void ensureCapacityHelper(int)>($i4)
$r4 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
==============

==============
 tn units (no order)
$z0 = specialinvoke r0.<benchmarks.instrumented.java.util.AbstractList: boolean removeAll(benchmarks.instrumented.java.util.Collection)>(r1)
r1 := @parameter0: benchmarks.instrumented.java.util.Collection
r0 := @this: benchmarks.instrumented.java.util.Vector
return $z0
==============

==============
 tn units (no order)
r1 := @parameter0: benchmarks.instrumented.java.util.Collection
r0 := @this: benchmarks.instrumented.java.util.Vector
return $z0
$z0 = specialinvoke r0.<benchmarks.instrumented.java.util.AbstractList: boolean retainAll(benchmarks.instrumented.java.util.Collection)>(r1)
==============

==============
 tn units (no order)
i2 = $i8 - i0
$i10 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
throw $r4
i1 = lengthof r3
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r3, 0, $r7, i0, i1)
if i0 <= $i5 goto r3 = interfaceinvoke r1.<benchmarks.instrumented.java.util.Collection: java.lang.Object[] toArray()>()
if i0 < 0 goto $r4 = new java.lang.ArrayIndexOutOfBoundsException
$i9 = i0 + i1
$r6 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r5, i0, $r6, $i9, i2)
i0 := @parameter0: int
specialinvoke $r4.<java.lang.ArrayIndexOutOfBoundsException: void <init>(int)>(i0)
r0.<benchmarks.instrumented.java.util.Vector: int modCount> = $i4
$i5 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$i3 = r0.<benchmarks.instrumented.java.util.Vector: int modCount>
$r7 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
$i6 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
return 0
if i1 == 0 goto return 0
r0.<benchmarks.instrumented.java.util.Vector: int elementCount> = $i11
specialinvoke r0.<benchmarks.instrumented.java.util.Vector: void ensureCapacityHelper(int)>($i7)
if i2 <= 0 goto $r7 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
r0 := @this: benchmarks.instrumented.java.util.Vector
r1 := @parameter1: benchmarks.instrumented.java.util.Collection
$i7 = $i6 + i1
$r4 = new java.lang.ArrayIndexOutOfBoundsException
return 1
r3 = interfaceinvoke r1.<benchmarks.instrumented.java.util.Collection: java.lang.Object[] toArray()>()
$i4 = $i3 + 1
$i11 = $i10 + i1
$i8 = r0.<benchmarks.instrumented.java.util.Vector: int elementCount>
$r5 = r0.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
==============

==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java.util.Vector
return $z0
$z0 = specialinvoke r0.<benchmarks.instrumented.java.util.AbstractList: boolean equals(java.lang.Object)>(r1)
r1 := @parameter0: java.lang.Object
==============

==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java.util.Vector
$i0 = specialinvoke r0.<benchmarks.instrumented.java.util.AbstractList: int hashCode()>()
return $i0
==============

==============
 tn units (no order)
return $r1
$r1 = specialinvoke r0.<benchmarks.instrumented.java.util.AbstractList: java.lang.String toString()>()
r0 := @this: benchmarks.instrumented.java.util.Vector
==============

==============
 tn units (no order)
return $r2
i0 := @parameter0: int
r0 := @this: benchmarks.instrumented.java.util.Vector
$r2 = staticinvoke <benchmarks.instrumented.java.util.Collections: benchmarks.instrumented.java.util.List synchronizedList(benchmarks.instrumented.java.util.List,java.lang.Object)>($r1, r0)
i1 := @parameter1: int
$r1 = specialinvoke r0.<benchmarks.instrumented.java.util.AbstractList: benchmarks.instrumented.java.util.List subList(int,int)>(i0, i1)
==============

==============
 tn units (no order)
virtualinvoke r1.<java.io.ObjectOutputStream: void defaultWriteObject()>()
r1 := @parameter0: java.io.ObjectOutputStream
return
r0 := @this: benchmarks.instrumented.java.util.Vector
==============

Transforming benchmarks.instrumented.java.util.Collections$SingletonList... 
Transforming benchmarks.instrumented.java.util.IdentityHashMap$EntrySet... 
Transforming benchmarks.instrumented.java.util.Collections$EmptyMap... 
Transforming benchmarks.instrumented.java.util.ResourceBundle$1... 
Transforming benchmarks.instrumented.java.util.WeakHashMap$HashIterator... 
Transforming benchmarks.instrumented.java.util.TimerThread... 
==============
 tn units (no order)
r0.<benchmarks.instrumented.java.util.TimerThread: boolean newTasksMayBeScheduled> = 0
exitmonitor r8
$r10 := @caughtexception
virtualinvoke $r9.<benchmarks.instrumented.java.util.TaskQueue: void clear()>()
exitmonitor r8
$r9 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
entermonitor $r7
==============

==============
 tn units (no order)
entermonitor $r4
goto [?= virtualinvoke $r12.<benchmarks.instrumented.java.util.TaskQueue: void rescheduleMin(long)>($l9)]
$i2 = r2.<benchmarks.instrumented.java.util.TimerTask: int state>
$r5 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
virtualinvoke $r5.<java.lang.Object: void wait()>()
$b7 = $l6 cmp 0L
exitmonitor r3
if $z2 != 0 goto $r5 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
$r10 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
$l10 = r2.<benchmarks.instrumented.java.util.TimerTask: long period>
if $z3 == 0 goto $r8 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
$r11 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
$z3 = virtualinvoke $r7.<benchmarks.instrumented.java.util.TaskQueue: boolean isEmpty()>()
l0 = staticinvoke <java.lang.System: long currentTimeMillis()>()
$r7 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
virtualinvoke $r10.<benchmarks.instrumented.java.util.TaskQueue: void removeMin()>()
$b5 = $l4 cmp 0L
$r6 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
virtualinvoke $r14.<java.lang.Object: void wait(long)>($l11)
$r9 = r2.<benchmarks.instrumented.java.util.TimerTask: java.lang.Object lock>
$l8 = r2.<benchmarks.instrumented.java.util.TimerTask: long period>
$l4 = r2.<benchmarks.instrumented.java.util.TimerTask: long period>
exitmonitor r1
$l9 = l0 - $l8
$r13 := @caughtexception
if $b7 >= 0 goto $l10 = r2.<benchmarks.instrumented.java.util.TimerTask: long period>
exitmonitor r1
r2 = virtualinvoke $r8.<benchmarks.instrumented.java.util.TaskQueue: benchmarks.instrumented.java.util.TimerTask getMin()>()
if $b5 != 0 goto $r12 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
$z1 = virtualinvoke $r6.<benchmarks.instrumented.java.util.TaskQueue: boolean isEmpty()>()
if $z1 == 0 goto $r7 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
$r8 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
$r12 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
throw $r13
$z2 = r0.<benchmarks.instrumented.java.util.TimerThread: boolean newTasksMayBeScheduled>
$b3 = l1 cmp l0
exitmonitor r3
if $b3 > 0 goto $z4 = 0
$l9 = l1 + $l10
$l6 = r2.<benchmarks.instrumented.java.util.TimerTask: long period>
$l11 = l1 - l0
$r14 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
$z4 = 1
if $i2 != 3 goto l0 = staticinvoke <java.lang.System: long currentTimeMillis()>()
entermonitor $r9
exitmonitor r3
goto [?= (branch)]
z0 = $z4
$r15 := @caughtexception
if z0 != 0 goto exitmonitor r1
l1 = r2.<benchmarks.instrumented.java.util.TimerTask: long nextExecutionTime>
virtualinvoke $r11.<benchmarks.instrumented.java.util.TaskQueue: void removeMin()>()
exitmonitor r1
if $z4 == 0 goto exitmonitor r3
r2.<benchmarks.instrumented.java.util.TimerTask: int state> = 2
exitmonitor r1
goto [?= z0 = $z4]
virtualinvoke $r12.<benchmarks.instrumented.java.util.TaskQueue: void rescheduleMin(long)>($l9)
goto [?= exitmonitor r3]
goto [?= $r6 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>]
$z4 = 0
==============

==============
 tn units (no order)
$r12 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
$b3 = l1 cmp l0
exitmonitor r3
if $b3 > 0 goto $z4 = 0
$l9 = l1 + $l10
goto [?= virtualinvoke $r12.<benchmarks.instrumented.java.util.TaskQueue: void rescheduleMin(long)>($l9)]
$i2 = r2.<benchmarks.instrumented.java.util.TimerTask: int state>
$l6 = r2.<benchmarks.instrumented.java.util.TimerTask: long period>
$b7 = $l6 cmp 0L
exitmonitor r3
$r10 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
$z4 = 1
$l10 = r2.<benchmarks.instrumented.java.util.TimerTask: long period>
if $i2 != 3 goto l0 = staticinvoke <java.lang.System: long currentTimeMillis()>()
entermonitor $r9
$r11 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
l0 = staticinvoke <java.lang.System: long currentTimeMillis()>()
exitmonitor r3
z0 = $z4
virtualinvoke $r10.<benchmarks.instrumented.java.util.TaskQueue: void removeMin()>()
$b5 = $l4 cmp 0L
$l8 = r2.<benchmarks.instrumented.java.util.TimerTask: long period>
virtualinvoke $r11.<benchmarks.instrumented.java.util.TaskQueue: void removeMin()>()
l1 = r2.<benchmarks.instrumented.java.util.TimerTask: long nextExecutionTime>
$l4 = r2.<benchmarks.instrumented.java.util.TimerTask: long period>
$l9 = l0 - $l8
$r13 := @caughtexception
if $b7 >= 0 goto $l10 = r2.<benchmarks.instrumented.java.util.TimerTask: long period>
if $z4 == 0 goto exitmonitor r3
r2.<benchmarks.instrumented.java.util.TimerTask: int state> = 2
if $b5 != 0 goto $r12 = r0.<benchmarks.instrumented.java.util.TimerThread: benchmarks.instrumented.java.util.TaskQueue queue>
goto [?= exitmonitor r3]
goto [?= z0 = $z4]
virtualinvoke $r12.<benchmarks.instrumented.java.util.TaskQueue: void rescheduleMin(long)>($l9)
$z4 = 0
==============

Transforming benchmarks.instrumented.java.util.HashMap$Entry... 
Transforming benchmarks.instrumented.java.util.Collections$UnmodifiableSortedSet... 
Transforming benchmarks.instrumented.java.util.LinkedHashMap$Entry... 
Transforming benchmarks.instrumented.java.util.Collections$SingletonMap$ImmutableEntry... 
Transforming benchmarks.instrumented.java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet... 
Transforming benchmarks.instrumented.java.util.Collections$UnmodifiableRandomAccessList... 
Transforming benchmarks.instrumented.java.util.Collections$SynchronizedCollection... 
==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor r1
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedCollection: benchmarks.instrumented.java.util.Collection c>
exitmonitor r1
$i0 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.Collection: int size()>()
entermonitor $r2
==============

==============
 tn units (no order)
exitmonitor r1
$z0 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.Collection: boolean isEmpty()>()
$r4 := @caughtexception
entermonitor $r2
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedCollection: benchmarks.instrumented.java.util.Collection c>
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r2
entermonitor $r3
exitmonitor r2
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedCollection: benchmarks.instrumented.java.util.Collection c>
$r5 := @caughtexception
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Collection: boolean contains(java.lang.Object)>(r1)
==============

==============
 tn units (no order)
$r4 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.Collection: java.lang.Object[] toArray()>()
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedCollection: benchmarks.instrumented.java.util.Collection c>
exitmonitor r1
$r5 := @caughtexception
exitmonitor r1
entermonitor $r2
==============

==============
 tn units (no order)
exitmonitor r2
$r6 := @caughtexception
exitmonitor r2
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedCollection: benchmarks.instrumented.java.util.Collection c>
$r5 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Collection: java.lang.Object[] toArray(java.lang.Object[])>(r1)
entermonitor $r3
==============

==============
 tn units (no order)
entermonitor $r3
$r5 := @caughtexception
exitmonitor r2
exitmonitor r2
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedCollection: benchmarks.instrumented.java.util.Collection c>
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Collection: boolean add(java.lang.Object)>(r1)
==============

==============
 tn units (no order)
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Collection: boolean remove(java.lang.Object)>(r1)
exitmonitor r2
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedCollection: benchmarks.instrumented.java.util.Collection c>
$r5 := @caughtexception
exitmonitor r2
entermonitor $r3
==============

==============
 tn units (no order)
$r5 := @caughtexception
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedCollection: benchmarks.instrumented.java.util.Collection c>
exitmonitor r2
exitmonitor r2
entermonitor $r3
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Collection: boolean containsAll(benchmarks.instrumented.java.util.Collection)>(r1)
==============

==============
 tn units (no order)
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedCollection: benchmarks.instrumented.java.util.Collection c>
exitmonitor r2
exitmonitor r2
$r5 := @caughtexception
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Collection: boolean addAll(benchmarks.instrumented.java.util.Collection)>(r1)
entermonitor $r3
==============

==============
 tn units (no order)
exitmonitor r2
entermonitor $r3
$r5 := @caughtexception
exitmonitor r2
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Collection: boolean removeAll(benchmarks.instrumented.java.util.Collection)>(r1)
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedCollection: benchmarks.instrumented.java.util.Collection c>
==============

==============
 tn units (no order)
exitmonitor r2
exitmonitor r2
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedCollection: benchmarks.instrumented.java.util.Collection c>
entermonitor $r3
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Collection: boolean retainAll(benchmarks.instrumented.java.util.Collection)>(r1)
$r5 := @caughtexception
==============

==============
 tn units (no order)
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedCollection: benchmarks.instrumented.java.util.Collection c>
interfaceinvoke $r3.<benchmarks.instrumented.java.util.Collection: void clear()>()
$r4 := @caughtexception
entermonitor $r2
exitmonitor r1
exitmonitor r1
==============

==============
 tn units (no order)
exitmonitor r1
$r4 = virtualinvoke $r3.<java.lang.Object: java.lang.String toString()>()
entermonitor $r2
exitmonitor r1
$r5 := @caughtexception
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedCollection: benchmarks.instrumented.java.util.Collection c>
==============

Transforming benchmarks.instrumented.java.util.Collections$UnmodifiableMap... 
Transforming benchmarks.instrumented.java.util.IdentityHashMap$Values... 
Transforming benchmarks.instrumented.java.util.TreeMap$SubMapEntryIterator... 
Transforming benchmarks.instrumented.java.util.ResourceBundleEnumeration... 
Transforming benchmarks.instrumented.java.util.TreeMap$Entry... 
Transforming benchmarks.instrumented.java.util.AbstractSet... 
Transforming benchmarks.instrumented.java.util.Hashtable$EntrySet... 
Transforming benchmarks.instrumented.java.util.LinkedHashMap... 
Transforming benchmarks.instrumented.java.util.HashMap... 
Transforming benchmarks.instrumented.java.util.List... 
Transforming benchmarks.instrumented.java.util.TreeMap$EntryIterator... 
Transforming benchmarks.instrumented.java.util.SubList... 
Transforming benchmarks.instrumented.java.util.WeakHashMap$Entry... 
Transforming benchmarks.instrumented.java.util.Vector$1... 
==============
 tn units (no order)
$r3 = r0.<benchmarks.instrumented.java.util.Vector$1: benchmarks.instrumented.java.util.Vector this$0>
$r8 := @caughtexception
$r4 = r0.<benchmarks.instrumented.java.util.Vector$1: benchmarks.instrumented.java.util.Vector this$0>
$r5 = $r4.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] elementData>
exitmonitor r1
$i2 = $r3.<benchmarks.instrumented.java.util.Vector: int elementCount>
$i0 = r0.<benchmarks.instrumented.java.util.Vector$1: int count>
r0.<benchmarks.instrumented.java.util.Vector$1: int count> = $i3
exitmonitor r1
$r7 = $r5[$i0]
$i1 = r0.<benchmarks.instrumented.java.util.Vector$1: int count>
exitmonitor r1
entermonitor $r2
if $i1 >= $i2 goto exitmonitor r1
$i3 = $i0 + 1
==============

Transforming benchmarks.instrumented.java.util.Collections$UnmodifiableSortedMap... 
Transforming benchmarks.instrumented.java.util.Map... 
Transforming benchmarks.instrumented.java.util.LinkedList... 
Transforming benchmarks.instrumented.java.util.PropertyPermissionCollection... 
Transforming benchmarks.instrumented.java.util.Stack... 
==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java.util.Stack
return r1
r1 = virtualinvoke r0.<benchmarks.instrumented.java.util.Stack: java.lang.Object peek()>()
i0 = virtualinvoke r0.<benchmarks.instrumented.java.util.Stack: int size()>()
$i1 = i0 - 1
virtualinvoke r0.<benchmarks.instrumented.java.util.Stack: void removeElementAt(int)>($i1)
==============

==============
 tn units (no order)
throw $r1
$r2 = virtualinvoke r0.<benchmarks.instrumented.java.util.Stack: java.lang.Object elementAt(int)>($i1)
if i0 != 0 goto $i1 = i0 - 1
i0 = virtualinvoke r0.<benchmarks.instrumented.java.util.Stack: int size()>()
$r1 = new benchmarks.instrumented.java.util.EmptyStackException
r0 := @this: benchmarks.instrumented.java.util.Stack
return $r2
$i1 = i0 - 1
specialinvoke $r1.<benchmarks.instrumented.java.util.EmptyStackException: void <init>()>()
==============

==============
 tn units (no order)
return $i2
if i0 < 0 goto return -1
$i1 = virtualinvoke r0.<benchmarks.instrumented.java.util.Stack: int size()>()
r1 := @parameter0: java.lang.Object
r0 := @this: benchmarks.instrumented.java.util.Stack
return -1
i0 = virtualinvoke r0.<benchmarks.instrumented.java.util.Stack: int lastIndexOf(java.lang.Object)>(r1)
$i2 = $i1 - i0
==============

Transforming benchmarks.instrumented.java.util.TreeMap$SubMap$EntrySetView... 
Transforming benchmarks.instrumented.java.util.AbstractCollection... 
==============
 tn units (no order)
exitmonitor r3
if $z0 != 0 goto exitmonitor r3
$z0 = virtualinvoke r0.<benchmarks.instrumented.java.util.AbstractCollection: boolean contains(java.lang.Object)>($r5)
exitmonitor r3
exitmonitor r3
$r5 = interfaceinvoke r2.<benchmarks.instrumented.java.util.Iterator: java.lang.Object next()>()
entermonitor r1
$r6 := @caughtexception
==============

Transforming benchmarks.instrumented.java.util.WeakHashMap$EntryIterator... 
Transforming benchmarks.instrumented.java.util.Collections$EmptySet$1... 
Transforming benchmarks.instrumented.java.util.AbstractSequentialList... 
Transforming benchmarks.instrumented.java.util.LinkedList$ListItr... 
Transforming benchmarks.instrumented.java.util.IdentityHashMap$KeyIterator... 
Transforming benchmarks.instrumented.java.util.Timer... 
==============
 tn units (no order)
$r15 := @caughtexception
$r13 = virtualinvoke $r12.<benchmarks.instrumented.java.util.TaskQueue: benchmarks.instrumented.java.util.TimerTask getMin()>()
r1.<benchmarks.instrumented.java.util.TimerTask: int state> = 1
$r8 = r1.<benchmarks.instrumented.java.util.TimerTask: java.lang.Object lock>
$r9 = new java.lang.IllegalStateException
specialinvoke $r9.<java.lang.IllegalStateException: void <init>(java.lang.String)>("Task already scheduled or cancelled")
$i3 = r1.<benchmarks.instrumented.java.util.TimerTask: int state>
$r10 := @caughtexception
$r7 = new java.lang.IllegalStateException
virtualinvoke $r11.<benchmarks.instrumented.java.util.TaskQueue: void add(benchmarks.instrumented.java.util.TimerTask)>(r1)
exitmonitor r2
exitmonitor r3
if $i3 == 0 goto r1.<benchmarks.instrumented.java.util.TimerTask: long nextExecutionTime> = l0
specialinvoke $r7.<java.lang.IllegalStateException: void <init>(java.lang.String)>("Timer already cancelled.")
$r6 = r0.<benchmarks.instrumented.java.util.Timer: benchmarks.instrumented.java.util.TimerThread thread>
r1.<benchmarks.instrumented.java.util.TimerTask: long period> = l1
$r11 = r0.<benchmarks.instrumented.java.util.Timer: benchmarks.instrumented.java.util.TaskQueue queue>
throw $r10
$z0 = $r6.<benchmarks.instrumented.java.util.TimerThread: boolean newTasksMayBeScheduled>
exitmonitor r2
entermonitor $r8
exitmonitor r3
entermonitor $r5
throw $r7
if $z0 != 0 goto $r8 = r1.<benchmarks.instrumented.java.util.TimerTask: java.lang.Object lock>
$r12 = r0.<benchmarks.instrumented.java.util.Timer: benchmarks.instrumented.java.util.TaskQueue queue>
r1.<benchmarks.instrumented.java.util.TimerTask: long nextExecutionTime> = l0
if $r13 != r1 goto exitmonitor r2
$r14 = r0.<benchmarks.instrumented.java.util.Timer: benchmarks.instrumented.java.util.TaskQueue queue>
virtualinvoke $r14.<java.lang.Object: void notify()>()
goto [?= $r11 = r0.<benchmarks.instrumented.java.util.Timer: benchmarks.instrumented.java.util.TaskQueue queue>]
throw $r9
==============

==============
 tn units (no order)
exitmonitor r3
if $i3 == 0 goto r1.<benchmarks.instrumented.java.util.TimerTask: long nextExecutionTime> = l0
entermonitor $r8
$r9 = new java.lang.IllegalStateException
r1.<benchmarks.instrumented.java.util.TimerTask: int state> = 1
exitmonitor r3
specialinvoke $r9.<java.lang.IllegalStateException: void <init>(java.lang.String)>("Task already scheduled or cancelled")
r1.<benchmarks.instrumented.java.util.TimerTask: long period> = l1
$i3 = r1.<benchmarks.instrumented.java.util.TimerTask: int state>
$r10 := @caughtexception
throw $r9
r1.<benchmarks.instrumented.java.util.TimerTask: long nextExecutionTime> = l0
==============

==============
 tn units (no order)
virtualinvoke $r4.<benchmarks.instrumented.java.util.TaskQueue: void clear()>()
exitmonitor r1
$r3.<benchmarks.instrumented.java.util.TimerThread: boolean newTasksMayBeScheduled> = 0
$r5 = r0.<benchmarks.instrumented.java.util.Timer: benchmarks.instrumented.java.util.TaskQueue queue>
entermonitor $r2
exitmonitor r1
virtualinvoke $r5.<java.lang.Object: void notify()>()
$r4 = r0.<benchmarks.instrumented.java.util.Timer: benchmarks.instrumented.java.util.TaskQueue queue>
$r6 := @caughtexception
$r3 = r0.<benchmarks.instrumented.java.util.Timer: benchmarks.instrumented.java.util.TimerThread thread>
==============

Transforming benchmarks.instrumented.java.util.Collections$UnmodifiableList... 
Transforming benchmarks.instrumented.java.util.ListResourceBundle... 
==============
 tn units (no order)
$r8 = $r7[0]
if i0 < $i2 goto $r7 = r1[i0]
r3 = (java.lang.String) $r8
goto [?= $i2 = lengthof r1]
r0.<benchmarks.instrumented.java.util.ListResourceBundle: benchmarks.instrumented.java.util.Map lookup> = r2
return
r0 := @this: benchmarks.instrumented.java.util.ListResourceBundle
$i1 = lengthof r1
if r4 != null goto virtualinvoke r2.<benchmarks.instrumented.java.util.HashMap: java.lang.Object put(java.lang.Object,java.lang.Object)>(r3, r4)
specialinvoke $r10.<java.lang.NullPointerException: void <init>()>()
$i2 = lengthof r1
i0 = 0
$r5 = r0.<benchmarks.instrumented.java.util.ListResourceBundle: benchmarks.instrumented.java.util.Map lookup>
throw $r10
specialinvoke $r6.<benchmarks.instrumented.java.util.HashMap: void <init>(int)>($i1)
r1 = virtualinvoke r0.<benchmarks.instrumented.java.util.ListResourceBundle: java.lang.Object[][] getContents()>()
$r9 = r1[i0]
r4 = $r9[1]
$r6 = new benchmarks.instrumented.java.util.HashMap
if $r5 == null goto r1 = virtualinvoke r0.<benchmarks.instrumented.java.util.ListResourceBundle: java.lang.Object[][] getContents()>()
$r10 = new java.lang.NullPointerException
virtualinvoke r2.<benchmarks.instrumented.java.util.HashMap: java.lang.Object put(java.lang.Object,java.lang.Object)>(r3, r4)
$r7 = r1[i0]
return
i0 = i0 + 1
r2 = $r6
if r3 == null goto $r10 = new java.lang.NullPointerException
==============

Transforming benchmarks.instrumented.java.util.Observable... 
==============
 tn units (no order)
$r4 = r0.<benchmarks.instrumented.java.util.Observable: benchmarks.instrumented.java.util.Vector obs>
return
if $z0 != 0 goto return
specialinvoke $r2.<java.lang.NullPointerException: void <init>()>()
if r1 != null goto $r3 = r0.<benchmarks.instrumented.java.util.Observable: benchmarks.instrumented.java.util.Vector obs>
throw $r2
$r2 = new java.lang.NullPointerException
$z0 = virtualinvoke $r3.<benchmarks.instrumented.java.util.Vector: boolean contains(java.lang.Object)>(r1)
virtualinvoke $r4.<benchmarks.instrumented.java.util.Vector: void addElement(java.lang.Object)>(r1)
$r3 = r0.<benchmarks.instrumented.java.util.Observable: benchmarks.instrumented.java.util.Vector obs>
r1 := @parameter0: benchmarks.instrumented.java.util.Observer
r0 := @this: benchmarks.instrumented.java.util.Observable
==============

==============
 tn units (no order)
virtualinvoke $r2.<benchmarks.instrumented.java.util.Vector: boolean removeElement(java.lang.Object)>(r1)
$r2 = r0.<benchmarks.instrumented.java.util.Observable: benchmarks.instrumented.java.util.Vector obs>
r1 := @parameter0: benchmarks.instrumented.java.util.Observer
return
r0 := @this: benchmarks.instrumented.java.util.Observable
==============

==============
 tn units (no order)
exitmonitor r3
if $z0 != 0 goto $r5 = r0.<benchmarks.instrumented.java.util.Observable: benchmarks.instrumented.java.util.Vector obs>
exitmonitor r3
exitmonitor r3
virtualinvoke r0.<benchmarks.instrumented.java.util.Observable: void clearChanged()>()
$r5 = r0.<benchmarks.instrumented.java.util.Observable: benchmarks.instrumented.java.util.Vector obs>
entermonitor r0
$z0 = r0.<benchmarks.instrumented.java.util.Observable: boolean changed>
r4 = virtualinvoke $r5.<benchmarks.instrumented.java.util.Vector: java.lang.Object[] toArray()>()
$r6 := @caughtexception
==============

==============
 tn units (no order)
$r1 = r0.<benchmarks.instrumented.java.util.Observable: benchmarks.instrumented.java.util.Vector obs>
virtualinvoke $r1.<benchmarks.instrumented.java.util.Vector: void removeAllElements()>()
r0 := @this: benchmarks.instrumented.java.util.Observable
return
==============

==============
 tn units (no order)
return
r0.<benchmarks.instrumented.java.util.Observable: boolean changed> = 1
r0 := @this: benchmarks.instrumented.java.util.Observable
==============

==============
 tn units (no order)
r0 := @this: benchmarks.instrumented.java.util.Observable
return
r0.<benchmarks.instrumented.java.util.Observable: boolean changed> = 0
==============

==============
 tn units (no order)
return $z0
$z0 = r0.<benchmarks.instrumented.java.util.Observable: boolean changed>
r0 := @this: benchmarks.instrumented.java.util.Observable
==============

==============
 tn units (no order)
$i0 = virtualinvoke $r1.<benchmarks.instrumented.java.util.Vector: int size()>()
$r1 = r0.<benchmarks.instrumented.java.util.Observable: benchmarks.instrumented.java.util.Vector obs>
r0 := @this: benchmarks.instrumented.java.util.Observable
return $i0
==============

Transforming benchmarks.instrumented.java.util.Collections$UnmodifiableCollection... 
Transforming benchmarks.instrumented.java.util.Collections$SingletonSet$1... 
Transforming benchmarks.instrumented.java.util.HashSet... 
Transforming benchmarks.instrumented.java.util.Collections... 
Transforming benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey... 
Transforming benchmarks.instrumented.java.util.TreeMap... 
Transforming benchmarks.instrumented.java.util.IdentityHashMap$IdentityHashMapIterator... 
Transforming benchmarks.instrumented.java.util.Hashtable$ValueCollection... 
Transforming benchmarks.instrumented.java.util.HashMap$EntrySet... 
Transforming benchmarks.instrumented.java.util.Timer$1... 
==============
 tn units (no order)
$r6 = r0.<benchmarks.instrumented.java.util.Timer$1: benchmarks.instrumented.java.util.Timer this$0>
$r5 = staticinvoke <benchmarks.instrumented.java.util.Timer: benchmarks.instrumented.java.util.TimerThread access$1(benchmarks.instrumented.java.util.Timer)>($r4)
exitmonitor r1
virtualinvoke $r7.<java.lang.Object: void notify()>()
$r8 := @caughtexception
entermonitor $r3
exitmonitor r1
$r4 = r0.<benchmarks.instrumented.java.util.Timer$1: benchmarks.instrumented.java.util.Timer this$0>
$r5.<benchmarks.instrumented.java.util.TimerThread: boolean newTasksMayBeScheduled> = 0
$r7 = staticinvoke <benchmarks.instrumented.java.util.Timer: benchmarks.instrumented.java.util.TaskQueue access$0(benchmarks.instrumented.java.util.Timer)>($r6)
==============

Transforming benchmarks.instrumented.java.util.AbstractList... 
Transforming benchmarks.instrumented.java.util.RandomAccess... 
Transforming benchmarks.instrumented.java.util.Observer... 
Transforming benchmarks.instrumented.java.util.LinkedHashMap$ValueIterator... 
Transforming benchmarks.instrumented.java.util.EventObject... 
Transforming benchmarks.instrumented.java.util.WeakHashMap... 
Transforming benchmarks.instrumented.java.util.Collections$SynchronizedSet... 
==============
 tn units (no order)
exitmonitor r2
$z0 = interfaceinvoke $r4.<benchmarks.instrumented.java.util.Collection: boolean equals(java.lang.Object)>(r1)
exitmonitor r2
$r5 := @caughtexception
entermonitor $r3
$r4 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSet: benchmarks.instrumented.java.util.Collection c>
==============

==============
 tn units (no order)
$r4 := @caughtexception
exitmonitor r1
$r3 = r0.<benchmarks.instrumented.java.util.Collections$SynchronizedSet: benchmarks.instrumented.java.util.Collection c>
exitmonitor r1
entermonitor $r2
$i0 = interfaceinvoke $r3.<benchmarks.instrumented.java.util.Collection: int hashCode()>()
==============

Transforming benchmarks.instrumented.java.util.SortedMap... 
Transforming benchmarks.instrumented.java.util.WeakHashMap$KeySet... 
Transforming benchmarks.instrumented.java.util.Comparator... 
Transforming benchmarks.instrumented.java.util.HashMap$HashIterator... 
Transforming benchmarks.instrumented.java.util.Collections$ReverseComparator... 
Transforming benchmarks.dstest.StackDeadlockTest... 
Transforming benchmarks.dstest.ListFactory... 
Transforming benchmarks.dstest.HashMapDeadlockTest... 
Transforming benchmarks.dstest.IdentityHashMapFactory... 
Transforming benchmarks.dstest.HashMapFactory... 
Transforming benchmarks.dstest.IdentityHashMapDeadlockTest... 
Transforming benchmarks.dstest.NoSuchElementException... 
Transforming benchmarks.dstest.MTSetDeadlock... 
Transforming benchmarks.dstest.ArrayListDeadlock2Test... 
Transforming benchmarks.dstest.MTArrayListTest... 
Transforming benchmarks.dstest.WeakHashMapFactory... 
Transforming benchmarks.dstest.TreeMapDeadlockTest... 
Transforming benchmarks.dstest.SetDeadlockTest... 
Transforming benchmarks.dstest.StackFactory... 
Transforming benchmarks.dstest.MTSetTest... 
Transforming benchmarks.dstest.Enumeration... 
Transforming benchmarks.dstest.MapDeadlockTest... 
Transforming benchmarks.dstest.ArrayListFactory... 
Transforming benchmarks.dstest.Vector... 
==============
 tn units (no order)
return
goto [?= $i1 = i0]
r1[i0] = $r3
$r3 = $r2[i0]
r1 := @parameter0: java.lang.Object[]
i0 = i0 + -1
$r2 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$i1 = i0
if $i1 > 0 goto $r2 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
i0 = r0.<benchmarks.dstest.Vector: int elementCount>
r0 := @this: benchmarks.dstest.Vector
==============

==============
 tn units (no order)
r1 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$r3 = newarray (java.lang.Object)[$i2]
$i3 = r0.<benchmarks.dstest.Vector: int elementCount>
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>(r1, 0, $r4, 0, $i3)
$r2 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$i1 = r0.<benchmarks.dstest.Vector: int elementCount>
r0 := @this: benchmarks.dstest.Vector
if $i1 >= i0 goto return
$i2 = r0.<benchmarks.dstest.Vector: int elementCount>
$r4 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
return
r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData> = $r3
i0 = lengthof $r2
==============

==============
 tn units (no order)
return
if i0 <= $i1 goto return
i0 := @parameter0: int
$r1 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$i1 = lengthof $r1
specialinvoke r0.<benchmarks.dstest.Vector: void ensureCapacityHelper(int)>(i0)
r0 := @this: benchmarks.dstest.Vector
==============

==============
 tn units (no order)
$r2[i1] = null
specialinvoke r0.<benchmarks.dstest.Vector: void ensureCapacityHelper(int)>(i0)
i1 = i1 + 1
if i0 <= $i2 goto i1 = i0
if i0 <= $i3 goto i1 = i0
$i4 = r0.<benchmarks.dstest.Vector: int elementCount>
i0 := @parameter0: int
goto [?= r0.<benchmarks.dstest.Vector: int elementCount> = i0]
goto [?= $i4 = r0.<benchmarks.dstest.Vector: int elementCount>]
$i3 = lengthof $r1
i1 = i0
if i1 < $i4 goto $r2 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$r1 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$r2 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
r0.<benchmarks.dstest.Vector: int elementCount> = i0
$i2 = r0.<benchmarks.dstest.Vector: int elementCount>
r0 := @this: benchmarks.dstest.Vector
return
==============

==============
 tn units (no order)
return $r1
r0 := @this: benchmarks.dstest.Vector
$r1 = new benchmarks.dstest.VectorEnumerator
specialinvoke $r1.<benchmarks.dstest.VectorEnumerator: void <init>(benchmarks.dstest.Vector)>(r0)
==============

==============
 tn units (no order)
if $z0 == 0 goto i1 = i1 + 1
return -1
$i2 = r0.<benchmarks.dstest.Vector: int elementCount>
i0 := @parameter1: int
return i1
r1 := @parameter0: java.lang.Object
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r3)
if i1 < $i2 goto $r2 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$r3 = $r2[i1]
i1 = i0
$r2 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
i1 = i1 + 1
goto [?= $i2 = r0.<benchmarks.dstest.Vector: int elementCount>]
r0 := @this: benchmarks.dstest.Vector
==============

==============
 tn units (no order)
$r3 = $r2[i1]
r1 := @parameter0: java.lang.Object
i1 = i0
$z0 = virtualinvoke r1.<java.lang.Object: boolean equals(java.lang.Object)>($r3)
return -1
$r2 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
return i1
i1 = i1 + -1
if i1 >= 0 goto $r2 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
r0 := @this: benchmarks.dstest.Vector
if $z0 == 0 goto i1 = i1 + -1
goto [?= (branch)]
i0 := @parameter1: int
==============

==============
 tn units (no order)
$i2 = r0.<benchmarks.dstest.Vector: int elementCount>
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
return $r9
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
specialinvoke $r12.<java.lang.StringBuilder: void <init>(java.lang.String)>($r13)
specialinvoke $r1.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
$r8 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
r2 = $r10
$r12 = new java.lang.StringBuilder
$r11 = new java.lang.ArrayIndexOutOfBoundsException
r0 := @this: benchmarks.dstest.Vector
$r1 = new java.lang.StringBuilder
throw $r11
i0 := @parameter0: int
specialinvoke $r11.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r15)
$r3 = new java.lang.ArrayIndexOutOfBoundsException
$r14 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" < 0")
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i2)
$i1 = r0.<benchmarks.dstest.Vector: int elementCount>
throw $r3
$r10 := @caughtexception
$r9 = $r8[i0]
if i0 < $i1 goto $r8 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$r15 = virtualinvoke $r14.<java.lang.StringBuilder: java.lang.String toString()>()
$r13 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$r5 = virtualinvoke $r1.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
==============

==============
 tn units (no order)
return $r3
r0 := @this: benchmarks.dstest.Vector
throw $r1
$r3 = $r2[0]
$i0 = r0.<benchmarks.dstest.Vector: int elementCount>
$r1 = new benchmarks.dstest.NoSuchElementException
if $i0 != 0 goto $r2 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
specialinvoke $r1.<benchmarks.dstest.NoSuchElementException: void <init>()>()
$r2 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
==============

==============
 tn units (no order)
throw $r1
$r3 = $r2[$i2]
$i2 = $i1 - 1
$i1 = r0.<benchmarks.dstest.Vector: int elementCount>
$r2 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
r0 := @this: benchmarks.dstest.Vector
return $r3
$r1 = new benchmarks.dstest.NoSuchElementException
specialinvoke $r1.<benchmarks.dstest.NoSuchElementException: void <init>()>()
if $i0 != 0 goto $r2 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$i0 = r0.<benchmarks.dstest.Vector: int elementCount>
==============

==============
 tn units (no order)
r0 := @this: benchmarks.dstest.Vector
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i2)
i0 := @parameter1: int
throw $r3
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
$r2 = new java.lang.StringBuilder
r1 := @parameter0: java.lang.Object
$r8[i0] = r1
specialinvoke $r2.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
$i2 = r0.<benchmarks.dstest.Vector: int elementCount>
$r5 = virtualinvoke $r2.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
$r8 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$r3 = new java.lang.ArrayIndexOutOfBoundsException
if i0 < $i1 goto $r8 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
$i1 = r0.<benchmarks.dstest.Vector: int elementCount>
return
==============

==============
 tn units (no order)
specialinvoke $r2.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r6)
$r11 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
if i0 < $i2 goto (branch)
specialinvoke $r7.<java.lang.ArrayIndexOutOfBoundsException: void <init>(int)>(i0)
$r11[$i9] = null
$i8 = $i7 - 1
i0 := @parameter0: int
$r2 = new java.lang.ArrayIndexOutOfBoundsException
i1 = $i5 - 1
$r8 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$i5 = $i4 - i0
throw $r2
r0.<benchmarks.dstest.Vector: int elementCount> = $i8
$r1 = new java.lang.StringBuilder
$i2 = r0.<benchmarks.dstest.Vector: int elementCount>
$r4 = virtualinvoke $r1.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" >= ")
$i7 = r0.<benchmarks.dstest.Vector: int elementCount>
specialinvoke $r1.<java.lang.StringBuilder: void <init>(java.lang.String)>($r3)
r0 := @this: benchmarks.dstest.Vector
$i9 = r0.<benchmarks.dstest.Vector: int elementCount>
return
$r7 = new java.lang.ArrayIndexOutOfBoundsException
if i1 <= 0 goto $i7 = r0.<benchmarks.dstest.Vector: int elementCount>
if i0 >= 0 goto $i4 = r0.<benchmarks.dstest.Vector: int elementCount>
$r3 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$i4 = r0.<benchmarks.dstest.Vector: int elementCount>
$i3 = r0.<benchmarks.dstest.Vector: int elementCount>
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.String toString()>()
$r9 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$r5 = virtualinvoke $r4.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i3)
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r8, $i6, $r9, i0, i1)
$i6 = i0 + 1
throw $r7
==============

==============
 tn units (no order)
i1 = $i2 + 1
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r9, i0, $r10, $i5, $i7)
$i8 = r0.<benchmarks.dstest.Vector: int elementCount>
$i3 = r0.<benchmarks.dstest.Vector: int elementCount>
$i6 = r0.<benchmarks.dstest.Vector: int elementCount>
$i4 = lengthof $r8
$r8 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$r5 = virtualinvoke $r2.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(" > ")
$r2 = new java.lang.StringBuilder
specialinvoke r0.<benchmarks.dstest.Vector: void ensureCapacityHelper(int)>(i1)
r0 := @this: benchmarks.dstest.Vector
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.String toString()>()
$i2 = r0.<benchmarks.dstest.Vector: int elementCount>
if i0 < i1 goto $r8 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
i0 := @parameter1: int
$i5 = i0 + 1
$r4 = staticinvoke <java.lang.String: java.lang.String valueOf(int)>(i0)
$i7 = $i6 - i0
$r10 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
return
specialinvoke $r3.<java.lang.ArrayIndexOutOfBoundsException: void <init>(java.lang.String)>($r7)
$r9 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$i9 = $i8 + 1
throw $r3
specialinvoke $r2.<java.lang.StringBuilder: void <init>(java.lang.String)>($r4)
$r11[i0] = r1
if i1 <= $i4 goto $r9 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
r0.<benchmarks.dstest.Vector: int elementCount> = $i9
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i3)
$r3 = new java.lang.ArrayIndexOutOfBoundsException
r1 := @parameter0: java.lang.Object
$r11 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
==============

==============
 tn units (no order)
r0 := @this: benchmarks.dstest.Vector
$i1 = r0.<benchmarks.dstest.Vector: int elementCount>
$r3[$i1] = r1
$i3 = lengthof $r2
i0 = $i2 + 1
$r3 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
r0.<benchmarks.dstest.Vector: int elementCount> = $i4
specialinvoke r0.<benchmarks.dstest.Vector: void ensureCapacityHelper(int)>(i0)
r1 := @parameter0: java.lang.Object
return
if i0 <= $i3 goto $r3 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$i2 = r0.<benchmarks.dstest.Vector: int elementCount>
$r2 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$i4 = $i1 + 1
==============

==============
 tn units (no order)
return 1
r1 := @parameter0: java.lang.Object
r0 := @this: benchmarks.dstest.Vector
virtualinvoke r0.<benchmarks.dstest.Vector: void removeElementAt(int)>(i0)
return 0
if i0 < 0 goto return 0
i0 = virtualinvoke r0.<benchmarks.dstest.Vector: int indexOf(java.lang.Object)>(r1)
==============

==============
 tn units (no order)
r0.<benchmarks.dstest.Vector: int elementCount> = 0
return
if i0 < $i1 goto $r1 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$r1 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
i0 = 0
$r1[i0] = null
r0 := @this: benchmarks.dstest.Vector
i0 = i0 + 1
$i1 = r0.<benchmarks.dstest.Vector: int elementCount>
goto [?= $i1 = r0.<benchmarks.dstest.Vector: int elementCount>]
==============

==============
 tn units (no order)
r1 = (benchmarks.dstest.Vector) $r2
specialinvoke $r9.<java.lang.InternalError: void <init>()>()
$i0 = r0.<benchmarks.dstest.Vector: int elementCount>
r0 := @this: benchmarks.dstest.Vector
$r4 = r0.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$r9 = new java.lang.InternalError
$i1 = r0.<benchmarks.dstest.Vector: int elementCount>
r8 = $r7
return r1
r1.<benchmarks.dstest.Vector: java.lang.Object[] elementData> = $r3
$r5 = r1.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$r7 := @caughtexception
throw $r9
$r2 = specialinvoke r0.<java.lang.Object: java.lang.Object clone()>()
$r3 = newarray (java.lang.Object)[$i0]
staticinvoke <java.lang.System: void arraycopy(java.lang.Object,int,java.lang.Object,int,int)>($r4, 0, $r5, 0, $i1)
==============

==============
 tn units (no order)
$r4 = new java.lang.StringBuffer
virtualinvoke r1.<java.lang.StringBuffer: java.lang.StringBuffer append(java.lang.String)>(r3)
i0 = $i2 - 1
specialinvoke $r4.<java.lang.StringBuffer: void <init>()>()
$i2 = virtualinvoke r0.<benchmarks.dstest.Vector: int size()>()
i1 = 0
return $r10
virtualinvoke r1.<java.lang.StringBuffer: java.lang.StringBuffer append(java.lang.String)>("]")
virtualinvoke r1.<java.lang.StringBuffer: java.lang.StringBuffer append(java.lang.String)>("[")
if i1 >= i0 goto i1 = i1 + 1
goto [?= (branch)]
virtualinvoke r1.<java.lang.StringBuffer: java.lang.StringBuffer append(java.lang.String)>(", ")
r3 = virtualinvoke $r6.<java.lang.Object: java.lang.String toString()>()
r0 := @this: benchmarks.dstest.Vector
i1 = i1 + 1
if i1 <= i0 goto $r6 = interfaceinvoke r2.<benchmarks.dstest.Enumeration: java.lang.Object nextElement()>()
$r6 = interfaceinvoke r2.<benchmarks.dstest.Enumeration: java.lang.Object nextElement()>()
r1 = $r4
r2 = virtualinvoke r0.<benchmarks.dstest.Vector: benchmarks.dstest.Enumeration elements()>()
$r10 = virtualinvoke r1.<java.lang.StringBuffer: java.lang.String toString()>()
==============

Transforming benchmarks.dstest.LinkedHashMapFactory... 
Transforming benchmarks.dstest.MTListDeadlock... 
Transforming benchmarks.dstest.MTSBTest... 
Transforming benchmarks.dstest.MTListTest... 
Transforming benchmarks.dstest.MapFactory... 
Transforming benchmarks.dstest.SimpleObject... 
Transforming benchmarks.dstest.LinkedHashMapDeadlockTest... 
Transforming benchmarks.dstest.VectorEnumerator... 
==============
 tn units (no order)
exitmonitor r1
$r8 := @caughtexception
exitmonitor r1
if $i1 >= $i2 goto exitmonitor r1
r0.<benchmarks.dstest.VectorEnumerator: int count> = $i3
$i2 = $r3.<benchmarks.dstest.Vector: int elementCount>
$r3 = r0.<benchmarks.dstest.VectorEnumerator: benchmarks.dstest.Vector vector>
entermonitor $r2
$i1 = r0.<benchmarks.dstest.VectorEnumerator: int count>
$i0 = r0.<benchmarks.dstest.VectorEnumerator: int count>
$r4 = r0.<benchmarks.dstest.VectorEnumerator: benchmarks.dstest.Vector vector>
$r5 = $r4.<benchmarks.dstest.Vector: java.lang.Object[] elementData>
$i3 = $i0 + 1
$r7 = $r5[$i0]
exitmonitor r1
==============

Transforming benchmarks.dstest.TreeMapFactory... 
Transforming benchmarks.dstest.MTLinkedHashSetTest... 
Transforming benchmarks.dstest.ListDeadlockTest... 
Transforming benchmarks.dstest.MTLinkedListInfiniteLoop... 
Transforming benchmarks.dstest.LinkedListDeadlockTest... 
Transforming benchmarks.dstest.ArrayListDeadlockTest... 
Transforming benchmarks.dstest.MTTreeSetTest... 
Transforming benchmarks.dstest.WeakHashMapDeadlockTest... 
Transforming benchmarks.dstest.MTHashtableTest... 
Transforming benchmarks.dstest.MTVectorTest... 
Transforming benchmarks.dstest.LinkedListFactory... 
Transforming javato.instrumentor.RecursiveVisitor... 
Transforming javato.instrumentor.UnknownASTNodeException... 
Transforming javato.instrumentor.TransformClass... 
Transforming javato.instrumentor.SymbolTables... 
Transforming javato.instrumentor.contexts.InstanceOfContextImpl... 
Transforming javato.instrumentor.contexts.ThrowContextImpl... 
Transforming javato.instrumentor.contexts.NewExprContext... 
Transforming javato.instrumentor.contexts.NewExprContextImpl... 
Transforming javato.instrumentor.contexts.NewMultiArrayContextImpl... 
Transforming javato.instrumentor.contexts.RefContext... 
Transforming javato.instrumentor.contexts.TypeContext... 
Transforming javato.instrumentor.contexts.SwitchContext... 
Transforming javato.instrumentor.contexts.Context... 
Transforming javato.instrumentor.contexts.IfSecondContextImpl... 
Transforming javato.instrumentor.contexts.TableSwitchContextImpl... 
Transforming javato.instrumentor.contexts.LocalContext... 
Transforming javato.instrumentor.contexts.LookupSwitchContextImpl... 
Transforming javato.instrumentor.contexts.InvokeOnlyTargetContextImpl... 
Transforming javato.instrumentor.contexts.IfContextImpl... 
Transforming javato.instrumentor.contexts.LocalOrConstantContext... 
Transforming javato.instrumentor.contexts.LengthContextImpl... 
Transforming javato.instrumentor.contexts.LookupSwitchDefaultContextImpl... 
Transforming javato.instrumentor.contexts.GotoContextImpl... 
Transforming javato.instrumentor.contexts.GotoContext... 
Transforming javato.instrumentor.contexts.LabelContext... 
Transforming javato.instrumentor.contexts.InvokeAndAssignArgumentContextImpl... 
Transforming javato.instrumentor.contexts.ReturnContextImpl... 
Transforming javato.instrumentor.contexts.RHSSecondContextImpl... 
Transforming javato.instrumentor.contexts.RHSFirstContextImpl... 
Transforming javato.instrumentor.contexts.LHSContext... 
Transforming javato.instrumentor.contexts.ParameterRefContextImpl... 
Transforming javato.instrumentor.contexts.SpecialContext... 
Transforming javato.instrumentor.contexts.TableSwitchDefaultContextImpl... 
Transforming javato.instrumentor.contexts.ExitMonitorContextImpl... 
Transforming javato.instrumentor.contexts.InvokeAndAssignContextImpl... 
Transforming javato.instrumentor.contexts.LHSContextImpl... 
Transforming javato.instrumentor.contexts.RHSContext... 
Transforming javato.instrumentor.contexts.CaughtExceptionRefContextImpl... 
Transforming javato.instrumentor.contexts.EnterMonitorContextImpl... 
Transforming javato.instrumentor.contexts.NewArrayContextImpl... 
Transforming javato.instrumentor.contexts.RHSContextImpl... 
Transforming javato.instrumentor.contexts.LookupSwitchLabelContextImpl... 
Transforming javato.instrumentor.contexts.InvokeOnlyContextImpl... 
Transforming javato.instrumentor.contexts.BinopExprContext... 
Transforming javato.instrumentor.contexts.ThisRefContextImpl... 
Transforming javato.instrumentor.contexts.IfFirstContextImpl... 
Transforming javato.instrumentor.contexts.TableSwitchLabelContextImpl... 
Transforming javato.instrumentor.contexts.CastContextImpl... 
Transforming javato.instrumentor.contexts.InvokeContext... 
Transforming javato.instrumentor.contexts.IfContext... 
Transforming javato.instrumentor.contexts.NegContextImpl... 
Transforming javato.instrumentor.contexts.InvokeAndAssignTargetContextImpl... 
Transforming javato.instrumentor.contexts.InvokeOnlyArgumentContextImpl... 
Transforming javato.instrumentor.Visitor... 
Transforming javato.instrumentor.TransformerForInstrumentation... 
Transforming javato.activetesting.instrumentor.DefaultVisitor... 
Transforming javato.activetesting.instrumentor.VisitorForThreadLocal... 
Transforming javato.activetesting.instrumentor.VisitorForActiveTesting... 
Transforming javato.activetesting.instrumentor.InstrumentorForActiveTesting... 
Transforming javato.activetesting.instrumentor.VisitorForInstrumentionOfSTM... 
Transforming javato.activetesting.instrumentor.VisitorForQueryTag... 
Transforming javato.activetesting.IGoodlockAnalysis... 
==============
 tn units (no order)
entermonitor $r1
r0.<javato.activetesting.IGoodlockAnalysis: javato.activetesting.igoodlock.GoodlockDS gl> = $r4
$r4 = new javato.activetesting.igoodlock.GoodlockDS
specialinvoke $r3.<javato.activetesting.reentrant.IgnoreRentrantLock: void <init>()>()
$r5 := @caughtexception
specialinvoke $r4.<javato.activetesting.igoodlock.GoodlockDS: void <init>()>()
exitmonitor r2
exitmonitor r2
$r3 = new javato.activetesting.reentrant.IgnoreRentrantLock
r0.<javato.activetesting.IGoodlockAnalysis: javato.activetesting.reentrant.IgnoreRentrantLock ignoreRentrantLock> = $r3
==============

==============
 tn units (no order)
$r6 = r0.<javato.activetesting.IGoodlockAnalysis: javato.activetesting.reentrant.IgnoreRentrantLock ignoreRentrantLock>
virtualinvoke $r7.<javato.activetesting.igoodlock.GoodlockDS: void lock(int,int,int)>($i0, $i1, $i2)
entermonitor $r4
$i1 = virtualinvoke r2.<java.lang.Integer: int intValue()>()
$z0 = virtualinvoke $r6.<javato.activetesting.reentrant.IgnoreRentrantLock: boolean lockBefore(java.lang.Integer,java.lang.Integer)>(r2, r3)
$r8 := @caughtexception
exitmonitor r5
$i2 = virtualinvoke r3.<java.lang.Integer: int intValue()>()
exitmonitor r5
if $z0 == 0 goto exitmonitor r5
$r7 = r0.<javato.activetesting.IGoodlockAnalysis: javato.activetesting.igoodlock.GoodlockDS gl>
$i0 = virtualinvoke r1.<java.lang.Integer: int intValue()>()
==============

==============
 tn units (no order)
$i1 = virtualinvoke r2.<java.lang.Integer: int intValue()>()
$r6 = r0.<javato.activetesting.IGoodlockAnalysis: javato.activetesting.reentrant.IgnoreRentrantLock ignoreRentrantLock>
$r8 := @caughtexception
$r7 = r0.<javato.activetesting.IGoodlockAnalysis: javato.activetesting.igoodlock.GoodlockDS gl>
if $z0 == 0 goto exitmonitor r5
virtualinvoke $r7.<javato.activetesting.igoodlock.GoodlockDS: void unlock(int,int,int)>($i0, $i1, $i2)
$z0 = virtualinvoke $r6.<javato.activetesting.reentrant.IgnoreRentrantLock: boolean unlockAfter(java.lang.Integer,java.lang.Integer)>(r2, r3)
exitmonitor r5
$i0 = virtualinvoke r1.<java.lang.Integer: int intValue()>()
exitmonitor r5
$i2 = virtualinvoke r3.<java.lang.Integer: int intValue()>()
entermonitor $r4
==============

==============
 tn units (no order)
exitmonitor r2
$r3 = r0.<javato.activetesting.IGoodlockAnalysis: javato.activetesting.igoodlock.GoodlockDS gl>
staticinvoke <javato.activetesting.common.Parameters: void writeIntegerList(java.lang.String,int)>($r4, i0)
entermonitor $r1
$r5 := @caughtexception
i0 = virtualinvoke $r3.<javato.activetesting.igoodlock.GoodlockDS: int dumpDeadlocks()>()
exitmonitor r2
$r4 = <javato.activetesting.common.Parameters: java.lang.String ERROR_LIST_FILE>
==============

Transforming javato.activetesting.igoodlock.GoodlockDS... 
Transforming javato.activetesting.igoodlock.Node... 
Transforming javato.activetesting.igoodlock.InterEdges$InterEdgeIterator... 
Transforming javato.activetesting.igoodlock.LockGraph... 
Transforming javato.activetesting.igoodlock.LockTree... 
Transforming javato.activetesting.igoodlock.Pair... 
Transforming javato.activetesting.igoodlock.InterEdges... 
Transforming javato.activetesting.igoodlock.Path... 
Transforming javato.activetesting.igoodlock.LockNode... 
Transforming javato.activetesting.igoodlock.DeadlockCycleInfo... 
Transforming javato.activetesting.RaceFuzzerAnalysis... 
Transforming javato.activetesting.scheduler.StallBreaker... 
==============
 tn units (no order)
$r7 := @caughtexception
goto [?= $l0 = <javato.activetesting.common.Parameters: long stallCheckerInterval>]
virtualinvoke r2.<java.lang.Object: void wait(long)>($l0)
$l0 = <javato.activetesting.common.Parameters: long stallCheckerInterval>
$r6 := @caughtexception
entermonitor r2
staticinvoke <javato.activetesting.scheduler.StallBreaker: void breakAnyStall()>()
exitmonitor r3
r4 = $r6
exitmonitor r3
==============

Transforming javato.activetesting.scheduler.LivelockBreaker... 
==============
 tn units (no order)
r8 = $r7
$r9 := @caughtexception
$i4 = $i3 % 5
virtualinvoke r2.<java.lang.Object: void wait(long)>($l0)
exitmonitor r3
$l0 = r0.<javato.activetesting.scheduler.LivelockBreaker: long waitTime>
if $z1 != 0 goto $l0 = r0.<javato.activetesting.scheduler.LivelockBreaker: long waitTime>
$r7 := @caughtexception
goto [?= $l0 = r0.<javato.activetesting.scheduler.LivelockBreaker: long waitTime>]
if $i4 != 0 goto $l0 = r0.<javato.activetesting.scheduler.LivelockBreaker: long waitTime>
$z1 = virtualinvoke $r5.<java.util.concurrent.atomic.AtomicBoolean: boolean getAndSet(boolean)>(0)
$i2 = $i1 + 1
staticinvoke <javato.activetesting.activechecker.ActiveChecker: void reduceProbability()>()
$i3 = r0.<javato.activetesting.scheduler.LivelockBreaker: int breakCount>
exitmonitor r3
if z0 == 0 goto $l0 = r0.<javato.activetesting.scheduler.LivelockBreaker: long waitTime>
$r5 = <javato.activetesting.activechecker.ActiveChecker: java.util.concurrent.atomic.AtomicBoolean dirty>
r0.<javato.activetesting.scheduler.LivelockBreaker: int breakCount> = $i2
z0 = staticinvoke <javato.activetesting.activechecker.ActiveChecker: boolean unblockAThread()>()
entermonitor r2
$i1 = r0.<javato.activetesting.scheduler.LivelockBreaker: int breakCount>
==============

Transforming javato.activetesting.activechecker.ActiveChecker... 
==============
 tn units (no order)
i0 = staticinvoke <javato.activetesting.scheduler.StallBreaker: int getActiveThreadCount()>()
if i0 <= 1 goto exitmonitor r2
$r5 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
$r3 = <javato.activetesting.activechecker.ActiveChecker: javato.activetesting.common.MersenneTwisterFast rand>
if $b1 > 0 goto exitmonitor r2
exitmonitor r2
$r4 = <javato.activetesting.activechecker.ActiveChecker: java.util.Map threadToSemaphoreAndTime>
$b1 = $d1 cmpg $d0
$d0 = <javato.activetesting.activechecker.ActiveChecker: double probability>
$d1 = virtualinvoke $r3.<javato.activetesting.common.MersenneTwisterFast: double nextDouble()>()
if $r6 != null goto exitmonitor r2
$r7 = <javato.activetesting.activechecker.ActiveChecker: java.util.LinkedList blockedThreads>
virtualinvoke r0.<javato.activetesting.activechecker.ActiveChecker: void check(java.util.Collection)>($r7)
exitmonitor r2
$r6 = interfaceinvoke $r4.<java.util.Map: java.lang.Object get(java.lang.Object)>($r5)
entermonitor $r1
$r8 := @caughtexception
==============

==============
 tn units (no order)
$r4 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>()
if $r5 != null goto exitmonitor r2
$r6 := @caughtexception
if i1 <= 1 goto exitmonitor r2
entermonitor $r1
$r3 = <javato.activetesting.activechecker.ActiveChecker: java.util.Map threadToSemaphoreAndTime>
exitmonitor r2
exitmonitor r2
i1 = staticinvoke <javato.activetesting.scheduler.StallBreaker: int getActiveThreadCount()>()
virtualinvoke r0.<javato.activetesting.activechecker.ActiveChecker: void block(int)>(i0)
$r5 = interfaceinvoke $r3.<java.util.Map: java.lang.Object get(java.lang.Object)>($r4)
==============

==============
 tn units (no order)
$i2 = virtualinvoke $r4.<java.util.LinkedList: int size()>()
$r7 = (javato.activetesting.activechecker.ActiveChecker) $r6
if $i1 != 0 goto $r3 = <javato.activetesting.activechecker.ActiveChecker: javato.activetesting.common.MersenneTwisterFast rand>
$r2 = <javato.activetesting.activechecker.ActiveChecker: java.util.LinkedList blockedThreads>
$r5 = <javato.activetesting.activechecker.ActiveChecker: java.util.LinkedList blockedThreads>
exitmonitor r1
i0 = virtualinvoke $r3.<javato.activetesting.common.MersenneTwisterFast: int nextInt(int)>($i2)
exitmonitor r1
$r4 = <javato.activetesting.activechecker.ActiveChecker: java.util.LinkedList blockedThreads>
$r6 = virtualinvoke $r5.<java.util.LinkedList: java.lang.Object get(int)>(i0)
$r8 := @caughtexception
entermonitor $r0
$r3 = <javato.activetesting.activechecker.ActiveChecker: javato.activetesting.common.MersenneTwisterFast rand>
virtualinvoke $r7.<javato.activetesting.activechecker.ActiveChecker: void unblock(int)>(0)
exitmonitor r1
$i1 = virtualinvoke $r2.<java.util.LinkedList: int size()>()
==============

Transforming javato.activetesting.activechecker.Semaphore... 
==============
 tn units (no order)
r0 := @this: javato.activetesting.activechecker.Semaphore
r0.<javato.activetesting.activechecker.Semaphore: int waitTime> = i0
r0.<javato.activetesting.activechecker.Semaphore: int counter> = $i2
return
$i1 = r0.<javato.activetesting.activechecker.Semaphore: int counter>
virtualinvoke r0.<java.lang.Object: void notify()>()
$i2 = $i1 + 1
i0 := @parameter0: int
==============

==============
 tn units (no order)
return
$i1 = r0.<javato.activetesting.activechecker.Semaphore: int counter>
$r3 := @caughtexception
r0.<javato.activetesting.activechecker.Semaphore: int counter> = $i2
virtualinvoke r1.<java.lang.InterruptedException: void printStackTrace()>()
staticinvoke <java.lang.Thread: void sleep(long)>($l5)
r0 := @this: javato.activetesting.activechecker.Semaphore
r1 = $r3
$i3 = r0.<javato.activetesting.activechecker.Semaphore: int waitTime>
goto [?= $i0 = r0.<javato.activetesting.activechecker.Semaphore: int counter>]
virtualinvoke r0.<java.lang.Object: void wait()>()
goto [?= return]
$i2 = $i1 - 1
if $i3 <= 0 goto return
if $i0 <= 0 goto virtualinvoke r0.<java.lang.Object: void wait()>()
$l5 = (long) $i4
$i0 = r0.<javato.activetesting.activechecker.Semaphore: int counter>
$i4 = r0.<javato.activetesting.activechecker.Semaphore: int waitTime>
==============

==============
 tn units (no order)
i0 := @parameter0: int
$i2 = $i1 - i0
$i1 = r0.<javato.activetesting.activechecker.Semaphore: int counter>
return
r0 := @this: javato.activetesting.activechecker.Semaphore
r0.<javato.activetesting.activechecker.Semaphore: int counter> = $i2
==============

Transforming javato.activetesting.activechecker.ActiveChecker$Pair... 
Transforming javato.activetesting.common.IntCounter... 
Transforming javato.activetesting.common.WeakIdentityHashMap... 
Transforming javato.activetesting.common.WeakIdentityHashMap$SimpleEntry... 
Transforming javato.activetesting.common.WeakIdentityHashMap$KeyIterator... 
Transforming javato.activetesting.common.WeakIdentityHashMap$ValueIterator... 
Transforming javato.activetesting.common.WeakIdentityHashMap$KeySet... 
Transforming javato.activetesting.common.MersenneTwisterFast... 
Transforming javato.activetesting.common.WeakIdentityHashMap$Values... 
Transforming javato.activetesting.common.Parameters... 
Transforming javato.activetesting.common.WeakIdentityHashMap$EntrySet... 
Transforming javato.activetesting.common.WeakIdentityHashMap$EntryIterator... 
Transforming javato.activetesting.common.WeakIdentityHashMap$Entry... 
Transforming javato.activetesting.common.WeakIdentityHashMap$HashIterator... 
Transforming javato.activetesting.analysis.SyncMethodCache... 
==============
 tn units (no order)
specialinvoke r0.<javato.activetesting.analysis.SyncMethodCache: void setToCache(int,java.lang.Class,java.lang.String,boolean)>(i0, r4, r2, 0)
goto [?= (branch)]
r1 := @parameter1: java.lang.Object
if r5 != $r10 goto $r11 = <javato.activetesting.analysis.SyncMethodCache$SYNC_STATUS: javato.activetesting.analysis.SyncMethodCache$SYNC_STATUS NONSYNC>
return 1
i2 = i2 + 1
return 0
specialinvoke r0.<javato.activetesting.analysis.SyncMethodCache: void setToCache(int,java.lang.Class,java.lang.String,boolean)>(i0, r4, r2, 0)
if r5 != $r11 goto (branch)
r3 = virtualinvoke r1.<java.lang.Object: java.lang.Class getClass()>()
r2 := @parameter2: java.lang.String
i0 := @parameter0: int
if r3 != null goto r6 = virtualinvoke r3.<java.lang.Class: java.lang.reflect.Method[] getDeclaredMethods()>()
return 1
return 0
r5 = specialinvoke r0.<javato.activetesting.analysis.SyncMethodCache: javato.activetesting.analysis.SyncMethodCache$SYNC_STATUS getFromCache(int,java.lang.Class,java.lang.String)>(i0, r4, r2)
if i2 < i1 goto r8 = r7[i2]
$i3 = virtualinvoke r9.<java.lang.String: int indexOf(java.lang.String)>(r2)
r6 = virtualinvoke r3.<java.lang.Class: java.lang.reflect.Method[] getDeclaredMethods()>()
$i4 = virtualinvoke r9.<java.lang.String: int indexOf(java.lang.String)>("synchronized")
r3 = virtualinvoke r3.<java.lang.Class: java.lang.Class getSuperclass()>()
if $i4 == -1 goto specialinvoke r0.<javato.activetesting.analysis.SyncMethodCache: void setToCache(int,java.lang.Class,java.lang.String,boolean)>(i0, r4, r2, 0)
$r11 = <javato.activetesting.analysis.SyncMethodCache$SYNC_STATUS: javato.activetesting.analysis.SyncMethodCache$SYNC_STATUS NONSYNC>
r8 = r7[i2]
i2 = 0
specialinvoke r0.<javato.activetesting.analysis.SyncMethodCache: void setToCache(int,java.lang.Class,java.lang.String,boolean)>(i0, r4, r2, 1)
r4 = r3
r0 := @this: javato.activetesting.analysis.SyncMethodCache
r7 = r6
i1 = lengthof r6
r9 = virtualinvoke r8.<java.lang.reflect.Method: java.lang.String toString()>()
$r10 = <javato.activetesting.analysis.SyncMethodCache$SYNC_STATUS: javato.activetesting.analysis.SyncMethodCache$SYNC_STATUS SYNC>
return 0
if $i3 == -1 goto i2 = i2 + 1
==============

Transforming javato.activetesting.analysis.SyncMethodCache$SYNC_STATUS... 
Transforming javato.activetesting.analysis.ObserverForActiveTesting$1... 
==============
 tn units (no order)
specialinvoke $r1.<java.util.LinkedList: void <init>()>()
$r1 = new java.util.LinkedList
return $r1
r0 := @this: javato.activetesting.analysis.ObserverForActiveTesting$1
==============

Transforming javato.activetesting.analysis.ObserverForActiveTesting$2... 
==============
 tn units (no order)
specialinvoke $r1.<java.util.LinkedList: void <init>()>()
return $r1
r0 := @this: javato.activetesting.analysis.ObserverForActiveTesting$2
$r1 = new java.util.LinkedList
==============

Transforming javato.activetesting.analysis.Analysis... 
Transforming javato.activetesting.analysis.ObserverForActiveTesting... 
Transforming javato.activetesting.analysis.AnalysisImpl... 
Transforming javato.activetesting.analysis.CheckerAnalysisImpl... 
Transforming javato.activetesting.analysis.Observer... 
==============
 tn units (no order)
$r3 = <javato.activetesting.analysis.Observer: javato.activetesting.common.WeakIdentityHashMap objectMap>
r2 = staticinvoke <java.lang.Integer: java.lang.Integer valueOf(int)>($i0)
$r1 = <javato.activetesting.analysis.Observer: javato.activetesting.common.WeakIdentityHashMap objectMap>
virtualinvoke $r3.<javato.activetesting.common.WeakIdentityHashMap: java.lang.Object put(java.lang.Object,java.lang.Object)>(r0, r2)
if r2 != null goto $r5 = (java.lang.Integer) r2
$r5 = (java.lang.Integer) r2
<javato.activetesting.analysis.Observer: int currentId> = $i1
r0 := @parameter0: java.lang.Object
$i1 = $i0 + 1
r2 = virtualinvoke $r1.<javato.activetesting.common.WeakIdentityHashMap: java.lang.Object get(java.lang.Object)>(r0)
return $r5
$i0 = <javato.activetesting.analysis.Observer: int currentId>
==============

==============
 tn units (no order)
return "Unknown Object"
$r4 = virtualinvoke $r0.<javato.activetesting.common.WeakIdentityHashMap: java.util.Set keySet()>()
r3 = (java.lang.Integer) $r6
$i1 = virtualinvoke r3.<java.lang.Integer: int intValue()>()
$r6 = virtualinvoke $r5.<javato.activetesting.common.WeakIdentityHashMap: java.lang.Object get(java.lang.Object)>(r2)
i0 := @parameter0: int
r1 = interfaceinvoke $r4.<java.util.Set: java.util.Iterator iterator()>()
if $i1 != i0 goto $z0 = interfaceinvoke r1.<java.util.Iterator: boolean hasNext()>()
return r2
$r0 = <javato.activetesting.analysis.Observer: javato.activetesting.common.WeakIdentityHashMap objectMap>
goto [?= $z0 = interfaceinvoke r1.<java.util.Iterator: boolean hasNext()>()]
$r5 = <javato.activetesting.analysis.Observer: javato.activetesting.common.WeakIdentityHashMap objectMap>
if r3 == null goto $z0 = interfaceinvoke r1.<java.util.Iterator: boolean hasNext()>()
if $z0 != 0 goto r2 = interfaceinvoke r1.<java.util.Iterator: java.lang.Object next()>()
r2 = interfaceinvoke r1.<java.util.Iterator: java.lang.Object next()>()
$z0 = interfaceinvoke r1.<java.util.Iterator: boolean hasNext()>()
==============

Transforming javato.activetesting.reentrant.LockSetWithCount... 
Transforming javato.activetesting.reentrant.ThreadLocal... 
Transforming javato.activetesting.reentrant.IgnoreRentrantLock$1... 
Transforming javato.activetesting.reentrant.IgnoreRentrantLock... 
Transforming javato.activetesting.HybridAnalysis... 
==============
 tn units (no order)
entermonitor $r1
exitmonitor $r1
==============

==============
 tn units (no order)
exitmonitor $r4
entermonitor $r4
==============

==============
 tn units (no order)
exitmonitor $r4
entermonitor $r4
==============

==============
 tn units (no order)
entermonitor $r4
exitmonitor $r4
==============

==============
 tn units (no order)
entermonitor $r4
exitmonitor $r4
==============

==============
 tn units (no order)
exitmonitor $r4
entermonitor $r4
==============

==============
 tn units (no order)
entermonitor $r4
exitmonitor $r4
==============

==============
 tn units (no order)
exitmonitor $r4
entermonitor $r4
==============

==============
 tn units (no order)
entermonitor $r4
exitmonitor $r4
==============

==============
 tn units (no order)
entermonitor $r4
exitmonitor $r4
==============

==============
 tn units (no order)
exitmonitor r2
$r4 := @caughtexception
entermonitor $r1
exitmonitor r2
staticinvoke <javato.activetesting.common.Parameters: void writeIntegerList(java.lang.String,int)>($r3, b0)
b0 = 0
$r3 = <javato.activetesting.common.Parameters: java.lang.String ERROR_LIST_FILE>
==============

Transforming javato.activetesting.lockset.LockSetTracker... 
Transforming javato.activetesting.lockset.LockSet... 
Transforming javato.activetesting.PrintTraceAnalysis... 
==============
 tn units (no order)
exitmonitor r2
exitmonitor r2
virtualinvoke $r3.<java.io.PrintStream: void println(java.lang.String)>("initialize()")
$r3 = <java.lang.System: java.io.PrintStream out>
entermonitor $r1
$r4 := @caughtexception
==============

==============
 tn units (no order)
$r10 = virtualinvoke $r9.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r2)
virtualinvoke $r6.<java.io.PrintStream: void println(java.lang.String)>($r14)
$r12 = virtualinvoke $r11.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r3)
exitmonitor r5
specialinvoke $r7.<java.lang.StringBuilder: void <init>(java.lang.String)>("lockBefore(")
$r15 := @caughtexception
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
exitmonitor r5
$r11 = virtualinvoke $r10.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
$r6 = <java.lang.System: java.io.PrintStream out>
$r7 = new java.lang.StringBuilder
$r14 = virtualinvoke $r13.<java.lang.StringBuilder: java.lang.String toString()>()
$r13 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(")")
entermonitor $r4
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r1)
==============

==============
 tn units (no order)
$r6 = <java.lang.System: java.io.PrintStream out>
$r13 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(")")
exitmonitor r5
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
$r10 = virtualinvoke $r9.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r2)
exitmonitor r5
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r1)
specialinvoke $r7.<java.lang.StringBuilder: void <init>(java.lang.String)>("unlockAfter(")
$r11 = virtualinvoke $r10.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
$r12 = virtualinvoke $r11.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r3)
$r15 := @caughtexception
$r14 = virtualinvoke $r13.<java.lang.StringBuilder: java.lang.String toString()>()
virtualinvoke $r6.<java.io.PrintStream: void println(java.lang.String)>($r14)
$r7 = new java.lang.StringBuilder
entermonitor $r4
==============

==============
 tn units (no order)
$r6 = <java.lang.System: java.io.PrintStream out>
specialinvoke $r7.<java.lang.StringBuilder: void <init>(java.lang.String)>("newExprAfter(")
entermonitor $r4
$r10 = virtualinvoke $r9.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r2)
$r13 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(")")
$r11 = virtualinvoke $r10.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
$r7 = new java.lang.StringBuilder
exitmonitor r5
exitmonitor r5
virtualinvoke $r6.<java.io.PrintStream: void println(java.lang.String)>($r14)
$r15 := @caughtexception
$r14 = virtualinvoke $r13.<java.lang.StringBuilder: java.lang.String toString()>()
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r1)
$r12 = virtualinvoke $r11.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r3)
==============

==============
 tn units (no order)
$r9 := @caughtexception
entermonitor $r2
$r4 = <java.lang.System: java.io.PrintStream out>
specialinvoke $r5.<java.lang.StringBuilder: void <init>(java.lang.String)>("methodEnterBefore(")
exitmonitor r3
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(")")
virtualinvoke $r4.<java.io.PrintStream: void println(java.lang.String)>($r8)
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.String toString()>()
$r5 = new java.lang.StringBuilder
exitmonitor r3
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r1)
==============

==============
 tn units (no order)
$r9 := @caughtexception
exitmonitor r3
$r5 = new java.lang.StringBuilder
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(")")
specialinvoke $r5.<java.lang.StringBuilder: void <init>(java.lang.String)>("methodExitAfter(")
virtualinvoke $r4.<java.io.PrintStream: void println(java.lang.String)>($r8)
$r4 = <java.lang.System: java.io.PrintStream out>
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.String toString()>()
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r1)
exitmonitor r3
entermonitor $r2
==============

==============
 tn units (no order)
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r1)
exitmonitor r5
$r12 = virtualinvoke $r11.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r3)
entermonitor $r4
specialinvoke $r7.<java.lang.StringBuilder: void <init>(java.lang.String)>("startBefore(")
$r6 = <java.lang.System: java.io.PrintStream out>
$r10 = virtualinvoke $r9.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r2)
virtualinvoke $r6.<java.io.PrintStream: void println(java.lang.String)>($r14)
$r14 = virtualinvoke $r13.<java.lang.StringBuilder: java.lang.String toString()>()
exitmonitor r5
$r11 = virtualinvoke $r10.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
$r13 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(")")
$r15 := @caughtexception
$r7 = new java.lang.StringBuilder
==============

==============
 tn units (no order)
$r14 = virtualinvoke $r13.<java.lang.StringBuilder: java.lang.String toString()>()
specialinvoke $r7.<java.lang.StringBuilder: void <init>(java.lang.String)>("waitAfter(")
$r11 = virtualinvoke $r10.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
$r12 = virtualinvoke $r11.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r3)
entermonitor $r4
exitmonitor r5
$r13 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(")")
virtualinvoke $r6.<java.io.PrintStream: void println(java.lang.String)>($r14)
$r15 := @caughtexception
$r6 = <java.lang.System: java.io.PrintStream out>
$r10 = virtualinvoke $r9.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r2)
exitmonitor r5
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r1)
$r7 = new java.lang.StringBuilder
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
==============

==============
 tn units (no order)
$r7 = new java.lang.StringBuilder
$r6 = <java.lang.System: java.io.PrintStream out>
$r13 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(")")
$r14 = virtualinvoke $r13.<java.lang.StringBuilder: java.lang.String toString()>()
exitmonitor r5
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r1)
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
$r15 := @caughtexception
$r10 = virtualinvoke $r9.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r2)
entermonitor $r4
$r11 = virtualinvoke $r10.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
exitmonitor r5
$r12 = virtualinvoke $r11.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r3)
virtualinvoke $r6.<java.io.PrintStream: void println(java.lang.String)>($r14)
specialinvoke $r7.<java.lang.StringBuilder: void <init>(java.lang.String)>("notifyBefore(")
==============

==============
 tn units (no order)
entermonitor $r4
$r12 = virtualinvoke $r11.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r3)
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
exitmonitor r5
$r15 := @caughtexception
$r6 = <java.lang.System: java.io.PrintStream out>
$r7 = new java.lang.StringBuilder
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r1)
$r10 = virtualinvoke $r9.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r2)
$r11 = virtualinvoke $r10.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
$r14 = virtualinvoke $r13.<java.lang.StringBuilder: java.lang.String toString()>()
$r13 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(")")
virtualinvoke $r6.<java.io.PrintStream: void println(java.lang.String)>($r14)
specialinvoke $r7.<java.lang.StringBuilder: void <init>(java.lang.String)>("notifyAllBefore(")
exitmonitor r5
==============

==============
 tn units (no order)
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r1)
$r13 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(")")
specialinvoke $r7.<java.lang.StringBuilder: void <init>(java.lang.String)>("joinAfter(")
virtualinvoke $r6.<java.io.PrintStream: void println(java.lang.String)>($r14)
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
exitmonitor r5
$r10 = virtualinvoke $r9.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r2)
exitmonitor r5
$r14 = virtualinvoke $r13.<java.lang.StringBuilder: java.lang.String toString()>()
$r12 = virtualinvoke $r11.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r3)
$r6 = <java.lang.System: java.io.PrintStream out>
$r7 = new java.lang.StringBuilder
$r15 := @caughtexception
entermonitor $r4
$r11 = virtualinvoke $r10.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
==============

==============
 tn units (no order)
$r13 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(")")
$r6 = <java.lang.System: java.io.PrintStream out>
$r7 = new java.lang.StringBuilder
virtualinvoke $r6.<java.io.PrintStream: void println(java.lang.String)>($r14)
$r11 = virtualinvoke $r10.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
$r12 = virtualinvoke $r11.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r3)
$r14 = virtualinvoke $r13.<java.lang.StringBuilder: java.lang.String toString()>()
exitmonitor r5
exitmonitor r5
specialinvoke $r7.<java.lang.StringBuilder: void <init>(java.lang.String)>("readBefore(")
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r1)
$r10 = virtualinvoke $r9.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r2)
$r15 := @caughtexception
entermonitor $r4
==============

==============
 tn units (no order)
$r15 := @caughtexception
virtualinvoke $r6.<java.io.PrintStream: void println(java.lang.String)>($r14)
exitmonitor r5
$r7 = new java.lang.StringBuilder
entermonitor $r4
specialinvoke $r7.<java.lang.StringBuilder: void <init>(java.lang.String)>("writeBefore(")
$r14 = virtualinvoke $r13.<java.lang.StringBuilder: java.lang.String toString()>()
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r1)
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
exitmonitor r5
$r6 = <java.lang.System: java.io.PrintStream out>
$r10 = virtualinvoke $r9.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r2)
$r12 = virtualinvoke $r11.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>(r3)
$r13 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(")")
$r11 = virtualinvoke $r10.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(",")
==============

==============
 tn units (no order)
virtualinvoke $r3.<java.io.PrintStream: void println(java.lang.String)>("finish()")
$r4 := @caughtexception
$r3 = <java.lang.System: java.io.PrintStream out>
exitmonitor r2
entermonitor $r1
exitmonitor r2
==============

Transforming javato.activetesting.DeadlockFuzzerAnalysis... 
==============
 tn units (no order)
virtualinvoke $r9.<java.io.PrintStream: void println(java.lang.String)>($r13)
$r13 = virtualinvoke $r12.<java.lang.StringBuilder: java.lang.String toString()>()
specialinvoke $r4.<javato.activetesting.lockset.LockSetTracker: void <init>()>()
r0.<javato.activetesting.DeadlockFuzzerAnalysis: javato.activetesting.reentrant.IgnoreRentrantLock ignoreRentrantLock> = $r5
$r6 = virtualinvoke r3.<javato.activetesting.igoodlock.DeadlockCycleInfo: java.util.List getCycles()>()
$r14 := @caughtexception
$r10 = new java.lang.StringBuilder
$i0 = <javato.activetesting.common.Parameters: int errorId>
$r9 = <java.lang.System: java.io.PrintStream out>
specialinvoke $r5.<javato.activetesting.reentrant.IgnoreRentrantLock: void <init>()>()
exitmonitor r2
$r5 = new javato.activetesting.reentrant.IgnoreRentrantLock
entermonitor $r1
specialinvoke $r10.<java.lang.StringBuilder: void <init>(java.lang.String)>("cycle ")
$r12 = virtualinvoke $r10.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.Object)>($r11)
exitmonitor r2
$i1 = $i0 - 1
r3 = staticinvoke <javato.activetesting.igoodlock.DeadlockCycleInfo: javato.activetesting.igoodlock.DeadlockCycleInfo read()>()
$r7 = interfaceinvoke $r6.<java.util.List: java.lang.Object get(int)>($i1)
$r8 = (java.util.List) $r7
r0.<javato.activetesting.DeadlockFuzzerAnalysis: javato.activetesting.lockset.LockSetTracker lsTracker> = $r4
$r4 = new javato.activetesting.lockset.LockSetTracker
r0.<javato.activetesting.DeadlockFuzzerAnalysis: java.util.List deadlockingCycle> = $r8
$r11 = r0.<javato.activetesting.DeadlockFuzzerAnalysis: java.util.List deadlockingCycle>
==============

==============
 tn units (no order)
if z0 == 0 goto $r10 = r0.<javato.activetesting.DeadlockFuzzerAnalysis: javato.activetesting.lockset.LockSetTracker lsTracker>
goto [?= exitmonitor r5]
if $z3 == 0 goto exitmonitor r5
$r11 = new javato.activetesting.activechecker.ActiveChecker
$r12 = new javato.activetesting.activechecker.ActiveChecker
exitmonitor r5
goto [?= exitmonitor r5]
$r10 = r0.<javato.activetesting.DeadlockFuzzerAnalysis: javato.activetesting.lockset.LockSetTracker lsTracker>
$r8 = r0.<javato.activetesting.DeadlockFuzzerAnalysis: javato.activetesting.lockset.LockSetTracker lsTracker>
r6 = virtualinvoke $r10.<javato.activetesting.lockset.LockSetTracker: java.util.List getLockSetIids(java.lang.Integer)>(r2)
$z3 = specialinvoke r0.<javato.activetesting.DeadlockFuzzerAnalysis: boolean needToPause(java.util.List)>(r6)
$z1 = virtualinvoke $r7.<javato.activetesting.reentrant.IgnoreRentrantLock: boolean lockBefore(java.lang.Integer,java.lang.Integer)>(r2, r3)
virtualinvoke $r11.<javato.activetesting.activechecker.ActiveChecker: void check(int)>(30)
specialinvoke $r12.<javato.activetesting.activechecker.ActiveChecker: void <init>()>()
exitmonitor r5
$r7 = r0.<javato.activetesting.DeadlockFuzzerAnalysis: javato.activetesting.reentrant.IgnoreRentrantLock ignoreRentrantLock>
if $z2 == 0 goto $z3 = specialinvoke r0.<javato.activetesting.DeadlockFuzzerAnalysis: boolean needToPause(java.util.List)>(r6)
if $z1 == 0 goto exitmonitor r5
$r9 = staticinvoke <java.lang.Runtime: java.lang.Runtime getRuntime()>()
virtualinvoke $r9.<java.lang.Runtime: void halt(int)>(1)
$z2 = specialinvoke r0.<javato.activetesting.DeadlockFuzzerAnalysis: boolean needToYieldOthers(java.util.List)>(r6)
entermonitor $r4
virtualinvoke $r12.<javato.activetesting.activechecker.ActiveChecker: void check()>()
$r13 := @caughtexception
z0 = virtualinvoke $r8.<javato.activetesting.lockset.LockSetTracker: boolean lockBefore(java.lang.Integer,java.lang.Integer,java.lang.Integer)>(r1, r2, r3)
specialinvoke $r11.<javato.activetesting.activechecker.ActiveChecker: void <init>()>()
==============

==============
 tn units (no order)
exitmonitor r5
virtualinvoke $r7.<javato.activetesting.lockset.LockSetTracker: void unlockAfter(java.lang.Integer)>(r2)
if $z0 == 0 goto exitmonitor r5
$r8 := @caughtexception
$r7 = r0.<javato.activetesting.DeadlockFuzzerAnalysis: javato.activetesting.lockset.LockSetTracker lsTracker>
exitmonitor r5
$z0 = virtualinvoke $r6.<javato.activetesting.reentrant.IgnoreRentrantLock: boolean unlockAfter(java.lang.Integer,java.lang.Integer)>(r2, r3)
$r6 = r0.<javato.activetesting.DeadlockFuzzerAnalysis: javato.activetesting.reentrant.IgnoreRentrantLock ignoreRentrantLock>
entermonitor $r4
==============

Writing to sootOutput/Hello.jimple
Writing to sootOutput/benchmarks.AtomicityTest$Transaction.jimple
Writing to sootOutput/benchmarks.testcases.TestRace8.jimple
Writing to sootOutput/benchmarks.testcases.TestDeadlock8.jimple
Writing to sootOutput/benchmarks.testcases.Thread2a.jimple
Writing to sootOutput/benchmarks.testcases.TestRace9$1.jimple
Writing to sootOutput/benchmarks.testcases.TestDeadlock1.jimple
Writing to sootOutput/benchmarks.testcases.TestDeadlock2a.jimple
Writing to sootOutput/benchmarks.testcases.TestRace3$1.jimple
Writing to sootOutput/benchmarks.testcases.ThreadB2b.jimple
Writing to sootOutput/benchmarks.testcases.ThreadL4.jimple
Writing to sootOutput/benchmarks.testcases.TestRace4.jimple
Writing to sootOutput/benchmarks.testcases.ThreadA2.jimple
Writing to sootOutput/benchmarks.testcases.SyncObjecb.jimple
Writing to sootOutput/benchmarks.testcases.TestDeadlock6.jimple
Writing to sootOutput/benchmarks.testcases.Lift.jimple
Writing to sootOutput/benchmarks.testcases.SyncObject.jimple
Writing to sootOutput/benchmarks.testcases.ThreadB1.jimple
Writing to sootOutput/benchmarks.testcases.Thread2.jimple
Writing to sootOutput/benchmarks.testcases.TestRace8$1.jimple
Writing to sootOutput/benchmarks.testcases.ThreadG3.jimple
Writing to sootOutput/benchmarks.testcases.TestDeadlock7.jimple
Writing to sootOutput/benchmarks.testcases.Thread1a.jimple
Writing to sootOutput/benchmarks.testcases.TestDeadlock4.jimple
Writing to sootOutput/benchmarks.testcases.TestRace11$1.jimple
Writing to sootOutput/benchmarks.testcases.ThreadB1b.jimple
Writing to sootOutput/benchmarks.testcases.TestRace2$1.jimple
Writing to sootOutput/benchmarks.testcases.ThreadG3a.jimple
Writing to sootOutput/benchmarks.testcases.Thread1b.jimple
Writing to sootOutput/benchmarks.testcases.TestRace1$1.jimple
Writing to sootOutput/benchmarks.testcases.ThreadB4b.jimple
Writing to sootOutput/benchmarks.testcases.TestRace2.jimple
Writing to sootOutput/benchmarks.testcases.ThreadB3b.jimple
Writing to sootOutput/benchmarks.testcases.ThreadL2.jimple
Writing to sootOutput/benchmarks.testcases.ThreadG1.jimple
Writing to sootOutput/benchmarks.testcases.ThreadB4.jimple
Writing to sootOutput/benchmarks.testcases.ThreadA1.jimple
Writing to sootOutput/benchmarks.testcases.TestRace5$1.jimple
Writing to sootOutput/benchmarks.testcases.TestRace10$1.jimple
Writing to sootOutput/benchmarks.testcases.ButtonPress.jimple
Writing to sootOutput/benchmarks.testcases.ThreadG1a.jimple
Writing to sootOutput/benchmarks.testcases.TestRace3.jimple
Writing to sootOutput/benchmarks.testcases.TestRace5.jimple
Writing to sootOutput/benchmarks.testcases.Floor.jimple
Writing to sootOutput/benchmarks.testcases.TestRace6$1.jimple
Writing to sootOutput/benchmarks.testcases.TestRace10.jimple
Writing to sootOutput/benchmarks.testcases.TestDeadlock1a.jimple
Writing to sootOutput/benchmarks.testcases.TestDeadlock4b.jimple
Writing to sootOutput/benchmarks.testcases.TestRace11.jimple
Writing to sootOutput/benchmarks.testcases.ThreadA3.jimple
Writing to sootOutput/benchmarks.testcases.ThreadB2.jimple
Writing to sootOutput/benchmarks.testcases.TestRace9.jimple
Writing to sootOutput/benchmarks.testcases.Controls.jimple
Writing to sootOutput/benchmarks.testcases.ThreadL1.jimple
Writing to sootOutput/benchmarks.testcases.TestRace1$2.jimple
Writing to sootOutput/benchmarks.testcases.ThreadG4.jimple
Writing to sootOutput/benchmarks.testcases.TestRace1.jimple
Writing to sootOutput/benchmarks.testcases.ThreadG2a.jimple
Writing to sootOutput/benchmarks.testcases.TestDeadlock1b.jimple
Writing to sootOutput/benchmarks.testcases.TestDeadlock3.jimple
Writing to sootOutput/benchmarks.testcases.TestRace6.jimple
Writing to sootOutput/benchmarks.testcases.TestRace7.jimple
Writing to sootOutput/benchmarks.testcases.TestDeadlock2.jimple
Writing to sootOutput/benchmarks.testcases.ThreadG2.jimple
Writing to sootOutput/benchmarks.testcases.ThreadG4a.jimple
Writing to sootOutput/benchmarks.testcases.TestRace7$1.jimple
Writing to sootOutput/benchmarks.testcases.ThreadA4.jimple
Writing to sootOutput/benchmarks.testcases.Thread2b.jimple
Writing to sootOutput/benchmarks.testcases.TestDeadlock5.jimple
Writing to sootOutput/benchmarks.testcases.TestRace4$1.jimple
Writing to sootOutput/benchmarks.testcases.ThreadL3.jimple
Writing to sootOutput/benchmarks.testcases.Thread7.jimple
Writing to sootOutput/benchmarks.testcases.Thread1.jimple
Writing to sootOutput/benchmarks.testcases.ThreadB3.jimple
Writing to sootOutput/benchmarks.testcases.Thread8.jimple
Writing to sootOutput/benchmarks.tsp.Tsp.jimple
Writing to sootOutput/benchmarks.tsp.PrioQElement.jimple
Writing to sootOutput/benchmarks.tsp.TspSolver.jimple
Writing to sootOutput/benchmarks.tsp.TourElement.jimple
Writing to sootOutput/benchmarks.stringbuffer.StringBufferTest.jimple
Writing to sootOutput/benchmarks.stringbuffer.StringBuffer.jimple
Writing to sootOutput/benchmarks.elevator.Lift.jimple
Writing to sootOutput/benchmarks.elevator.Elevator.jimple
Writing to sootOutput/benchmarks.elevator.ButtonPress.jimple
Writing to sootOutput/benchmarks.elevator.Floor.jimple
Writing to sootOutput/benchmarks.elevator.Controls.jimple
Writing to sootOutput/benchmarks.JGFAllSizeB.jimple
Writing to sootOutput/benchmarks.JGFMonteCarloBenchSizeB.jimple
Writing to sootOutput/benchmarks.jgfutil.JGFTimer.jimple
Writing to sootOutput/benchmarks.jgfutil.JGFInstrumentor.jimple
Writing to sootOutput/benchmarks.jgfutil.JGFSection1.jimple
Writing to sootOutput/benchmarks.jgfutil.JGFSection3.jimple
Writing to sootOutput/benchmarks.jgfutil.JGFSection2.jimple
Writing to sootOutput/benchmarks.JGFRayTracerBenchSizeB.jimple
Writing to sootOutput/benchmarks.moldyn.TournamentBarrier.jimple
Writing to sootOutput/benchmarks.moldyn.random.jimple
Writing to sootOutput/benchmarks.moldyn.md.jimple
Writing to sootOutput/benchmarks.moldyn.Barrier.jimple
Writing to sootOutput/benchmarks.moldyn.particle.jimple
Writing to sootOutput/benchmarks.moldyn.mdRunner.jimple
Writing to sootOutput/benchmarks.moldyn.JGFMolDynBench.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.pipeline.Stage.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.pipeline.Pipeline.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.pipeline.BlockingQueue.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.pipeline.Listener.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.pipeline.PipeInttest.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.boundedbuffer.Consumer.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.boundedbuffer.Buffer.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.boundedbuffer.BoundedBuffer.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.boundedbuffer.Producer.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.rax.Event.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.rax.START.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.rax.FirstTask.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.rax.SecondTask.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.readerswriters.Reader.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.readerswriters.RWPrinter.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.readerswriters.Vector.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.readerswriters.Writer.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.readerswriters.RWVSNTest.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.MyRandom.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.replicatedcasestudies.Collection.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.replicatedcasestudies.ReplicatedWorkers.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.replicatedcasestudies.SignsSrcAbs.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.replicatedcasestudies.StandardBarrier.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.replicatedcasestudies.IntSrcAbs.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.replicatedcasestudies.SynchronizedCollection.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.replicatedcasestudies.Generic.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.replicatedcasestudies.Configuration.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.replicatedcasestudies.Worker.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.replicatedcasestudies.Vector.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.replicatedcasestudies.SrcAbs.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.replicatedcasestudies.StandardCountingSemaphore.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.replicatedcasestudies.Coordinator.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.nestedmonitors.Consumer.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.nestedmonitors.Buffer.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.nestedmonitors.NestedMonitor.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.nestedmonitors.Semaphore.jimple
Writing to sootOutput/benchmarks.jpf_test_cases.nestedmonitors.Producer.jimple
Writing to sootOutput/benchmarks.JGFMolDynBenchSizeA.jimple
Writing to sootOutput/benchmarks.SimpleExample.jimple
Writing to sootOutput/benchmarks.philo.StartError.jimple
Writing to sootOutput/benchmarks.philo.Table.jimple
Writing to sootOutput/benchmarks.philo.Philo.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncList.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.LayeredSync.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncSet.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableInt.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncCollection.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableShort.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedVariable.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.BrokenBarrierException.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Executor.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.ReadWriteLock.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantWriterPreferenceReadWriteLock.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeoutException.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous$RendezvousFunction.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedPriorityQueue.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Slot.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SemaphoreControlledChannel.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult$1.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.DefaultChannelCapacity.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.CondVar.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.ReaderPreferenceReadWriteLock.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock$ReaderSync.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedDouble.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableFloat.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncMap.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$TaskNode.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask$Seq2.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.TimedCallable.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Barrier.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWIterator.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncSortedMap.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitFreeQueue$Node.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableRef.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue$WaitNode.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$BlockedExecutionHandler.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.ReentrantLock.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOReadWriteLock.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$TaskNode.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedFloat.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Rendezvous$Rotator.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableBoolean.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Puttable.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableDouble.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedLinkedQueue.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableChar.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableByte.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask$Wrap.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon$RunLoop.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Mutex.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedBuffer.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactoryUser.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Callable.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadedExecutor.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore$WaitQueue.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncSortedSet.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOSemaphore$FIFOWaitQueue.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedRef.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$Worker.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedSemaphore.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.QueuedExecutor$RunLoop.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.ObservableSync$SyncObserver.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArrayList$COWSubList$COWSubListIterator.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunner$VolatileTaskRef.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedNode.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask$Par2.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.PropertyChangeMulticaster.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FutureResult.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronousChannel.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedChar.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$RunWhenBlocked.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.NullSync.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedInt.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedByte.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.PrioritySemaphore$PriorityWaitQueue.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.LinkedQueue.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.LockedExecutor.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.CountDown.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeDaemon$RunLoop.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$DiscardWhenBlocked.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Heap.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$WriterLock.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WaitableLong.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.ObservableSync.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.DirectExecutor.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedShort.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$ReaderLock.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Sync.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.BoundedChannel.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.ClockDaemon.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup$InvokableFJTask.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Channel.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Semaphore.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.PooledExecutor$WaitWhenBlocked.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Takable.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactoryUser$DefaultThreadFactory.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.VetoableChangeMulticaster.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WriterPreferenceReadWriteLock$Signaller.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.PrioritySemaphore.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SynchronizedLong.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.TimeoutSync.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.ThreadFactory.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncList$SyncCollectionListIterator.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask$Seq.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.Latch.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.SyncCollection$SyncCollectionIterator.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.CyclicBarrier.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FIFOSemaphore.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.FJTask$Par.jimple
Writing to sootOutput/benchmarks.EDU.oswego.cs.dl.util.concurrent.CopyOnWriteArraySet.jimple
Writing to sootOutput/benchmarks.Account.jimple
Writing to sootOutput/benchmarks.hedc.MetaSearchImpl.jimple
Writing to sootOutput/benchmarks.hedc.TaskFactory.jimple
Writing to sootOutput/benchmarks.hedc.PooledExecutorWithInvalidate$RunWhenBlocked.jimple
Writing to sootOutput/benchmarks.hedc.Rag$RagIterator.jimple
Writing to sootOutput/benchmarks.hedc.PooledExecutorWithInvalidate$BlockedExecutionHandler.jimple
Writing to sootOutput/benchmarks.hedc.SohoSynoptic$SohoIterator.jimple
Writing to sootOutput/benchmarks.hedc.MetaSearchResult$MetaSearchResultIterator.jimple
Writing to sootOutput/benchmarks.hedc.PooledExecutorWithInvalidate$WaitWhenBlocked.jimple
Writing to sootOutput/benchmarks.hedc.MetaSearch.jimple
Writing to sootOutput/benchmarks.hedc.MetaSearchRequest.jimple
Writing to sootOutput/benchmarks.hedc.MetaSearchResult.jimple
Writing to sootOutput/benchmarks.hedc.RandomDate.jimple
Writing to sootOutput/benchmarks.hedc.PooledExecutorWithInvalidate$Worker.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.DoubleBufferCopy$Buffer.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.DoubleBufferCopy.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.Generator.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.DoubleBufferCopy$CopyThread.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.Ftp.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.SystemProperties.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.Estimator.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.CopyStream.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.URLConnectionReader.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.BaseProperties.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.Logger.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.PropertyMonitoring.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.HttpLogger.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.EstimatorFactory.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.EtcUtil.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.BufferedCopy.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.Messages.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.ObservableProperties.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.SmartRef.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.RmiLogger.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.ThreadFactory.jimple
Writing to sootOutput/benchmarks.hedc.ethz.util.SerializePerformanceTest.jimple
Writing to sootOutput/benchmarks.hedc.DateFormatter.jimple
Writing to sootOutput/benchmarks.hedc.Rag.jimple
Writing to sootOutput/benchmarks.hedc.Messages.jimple
Writing to sootOutput/benchmarks.hedc.PooledExecutorWithInvalidate$DiscardWhenBlocked.jimple
Writing to sootOutput/benchmarks.hedc.FormFiller.jimple
Writing to sootOutput/benchmarks.hedc.Tester.jimple
Writing to sootOutput/benchmarks.hedc.Task.jimple
Writing to sootOutput/benchmarks.hedc.PooledExecutorWithInvalidate.jimple
Writing to sootOutput/benchmarks.hedc.SohoSynoptic.jimple
Writing to sootOutput/benchmarks.hedc.regexp.CompilerState.jimple
Writing to sootOutput/benchmarks.hedc.regexp.CharArrayState.jimple
Writing to sootOutput/benchmarks.hedc.regexp.Result.jimple
Writing to sootOutput/benchmarks.hedc.regexp.GroupReference.jimple
Writing to sootOutput/benchmarks.hedc.regexp.Regexp.jimple
Writing to sootOutput/benchmarks.hedc.regexp.MalformedRegexpException.jimple
Writing to sootOutput/benchmarks.hedc.regexp.SuccessRegexp.jimple
Writing to sootOutput/benchmarks.hedc.regexp.Literal.jimple
Writing to sootOutput/benchmarks.hedc.regexp.Multi.jimple
Writing to sootOutput/benchmarks.hedc.regexp.NoSuchMatchException.jimple
Writing to sootOutput/benchmarks.hedc.regexp.Group.jimple
Writing to sootOutput/benchmarks.hedc.regexp.RegexpCompiler.jimple
Writing to sootOutput/benchmarks.hedc.regexp.StringState.jimple
Writing to sootOutput/benchmarks.hedc.regexp.ContextMatch.jimple
Writing to sootOutput/benchmarks.hedc.regexp.CharClass.jimple
Writing to sootOutput/benchmarks.hedc.regexp.Alternatives.jimple
Writing to sootOutput/benchmarks.hedc.regexp.State.jimple
Writing to sootOutput/benchmarks.hedc.regexp.Dot.jimple
Writing to sootOutput/benchmarks.hedc.FormFiller$Filter.jimple
Writing to sootOutput/benchmarks.montecarlo.JGFMonteCarloBench.jimple
Writing to sootOutput/benchmarks.montecarlo.PathId.jimple
Writing to sootOutput/benchmarks.montecarlo.Universal.jimple
Writing to sootOutput/benchmarks.montecarlo.ToInitAllTasks.jimple
Writing to sootOutput/benchmarks.montecarlo.MonteCarloPath.jimple
Writing to sootOutput/benchmarks.montecarlo.RatePath.jimple
Writing to sootOutput/benchmarks.montecarlo.ToResult.jimple
Writing to sootOutput/benchmarks.montecarlo.AppDemo.jimple
Writing to sootOutput/benchmarks.montecarlo.PriceStock.jimple
Writing to sootOutput/benchmarks.montecarlo.ToTask.jimple
Writing to sootOutput/benchmarks.montecarlo.AppDemoThread.jimple
Writing to sootOutput/benchmarks.montecarlo.ReturnPath.jimple
Writing to sootOutput/benchmarks.montecarlo.DemoException.jimple
Writing to sootOutput/benchmarks.montecarlo.Utilities.jimple
Writing to sootOutput/benchmarks.montecarlo.CallAppDemo.jimple
Writing to sootOutput/benchmarks.TestMe.jimple
Writing to sootOutput/benchmarks.JGFRayTracerBenchSizeA.jimple
Writing to sootOutput/benchmarks.harness.MyThread.jimple
Writing to sootOutput/benchmarks.harness.JigsawHarnessPretex.jimple
Writing to sootOutput/benchmarks.JGFMonteCarloBenchSizeA.jimple
Writing to sootOutput/benchmarks.AtomicityTest.jimple
Writing to sootOutput/benchmarks.raytracer.RayTracerRunner.jimple
Writing to sootOutput/benchmarks.raytracer.TournamentBarrier.jimple
Writing to sootOutput/benchmarks.raytracer.Isect.jimple
Writing to sootOutput/benchmarks.raytracer.Sphere.jimple
Writing to sootOutput/benchmarks.raytracer.Barrier.jimple
Writing to sootOutput/benchmarks.raytracer.Vec.jimple
Writing to sootOutput/benchmarks.raytracer.Interval.jimple
Writing to sootOutput/benchmarks.raytracer.RayTracer.jimple
Writing to sootOutput/benchmarks.raytracer.Primitive.jimple
Writing to sootOutput/benchmarks.raytracer.Light.jimple
Writing to sootOutput/benchmarks.raytracer.Surface.jimple
Writing to sootOutput/benchmarks.raytracer.Scene.jimple
Writing to sootOutput/benchmarks.raytracer.Ray.jimple
Writing to sootOutput/benchmarks.raytracer.JGFRayTracerBench.jimple
Writing to sootOutput/benchmarks.raytracer.View.jimple
Writing to sootOutput/benchmarks.JGFAllSizeA.jimple
Writing to sootOutput/benchmarks.ChessTest.jimple
Writing to sootOutput/benchmarks.sor.Sor.jimple
Writing to sootOutput/benchmarks.sor.sor_first_row_odd.jimple
Writing to sootOutput/benchmarks.sor.sor_first_row_even.jimple
Writing to sootOutput/benchmarks.JGFMolDynBenchSizeB.jimple
Writing to sootOutput/benchmarks.instrumented.java15.lang.Math.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Arrays$ArrayList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.HashMap$Values.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.SubList$1.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.LinkedHashMap$KeyIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.IdentityHashMap$KeySet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Hashtable$Enumerator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.TreeSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$1.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.AbstractMap$2.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collection.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$SynchronizedRandomAccessList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.TreeMap$KeyIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$CheckedMap$CheckedEntrySet$1.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.ConcurrentModificationException.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$CopiesList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.BitSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$SingletonSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$SynchronizedMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.TreeMap$1.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.AbstractMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.EnumMap$EntryIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Set.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.TreeMap$SubMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.IdentityHashMap$EntryIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Queue.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$EmptyList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.AbstractMap$1$1.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.NoSuchElementException.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.AbstractList$ListItr.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.IdentityHashMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$UnmodifiableCollection$1.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Hashtable$Entry.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.TreeMap$ValueIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$SingletonMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.WeakHashMap$Values.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$EmptySet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.HashMap$KeySet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$1.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Random.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$UnmodifiableSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.WeakHashMap$ValueIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Map$Entry.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.EnumMap$EntrySet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.EnumSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Hashtable$EmptyIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$SynchronizedSortedSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$UnmodifiableList$1.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Iterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.EnumMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.LinkedHashMap$LinkedHashIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.TreeMap$2.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.StringTokenizer.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.HashMap$EntryIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$SynchronizedSortedMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Arrays.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$CheckedList$1.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.EnumMap$Values.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$SynchronizedList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.PriorityQueue$Itr.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.ListIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.AbstractList$Itr.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.SortedSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.LinkedList$Entry.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.RandomAccessSubList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.PriorityQueue.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.IdentityHashMap$ValueIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.WeakHashMap$EntrySet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Hashtable.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.AbstractMap$2$1.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Dictionary.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$SelfComparable.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$ReverseComparator2.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$UnmodifiableEntry.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.HashMap$ValueIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$CheckedList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.AbstractMap$SimpleEntry.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.TooManyListenersException.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.TreeMap$3.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.HashMap$KeyIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Hashtable$EmptyEnumerator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.AbstractMap$1.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.EnumMap$EnumMapIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Hashtable$KeySet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.EmptyStackException.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.ArrayList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.LinkedHashMap$EntryIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.LinkedHashSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Enumeration.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.WeakHashMap$KeyIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Vector.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$SingletonList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.IdentityHashMap$EntrySet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.JumboEnumSet$EnumSetIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$EmptyMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.WeakHashMap$HashIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$CheckedMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.HashMap$Entry.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$UnmodifiableSortedSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.EnumMap$KeySet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.LinkedHashMap$Entry.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$SingletonMap$ImmutableEntry.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$UnmodifiableMap$UnmodifiableEntrySet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$CheckedMap$CheckedEntrySet$CheckedEntry.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$UnmodifiableRandomAccessList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$SynchronizedCollection.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$UnmodifiableMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.IdentityHashMap$Values.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.EnumMap$ValueIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.TreeMap$SubMapEntryIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.TreeMap$Entry.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$CheckedRandomAccessList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.AbstractSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Hashtable$EntrySet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.LinkedHashMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.HashMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.List.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.TreeMap$EntryIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.SubList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.WeakHashMap$Entry.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Vector$1.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.JumboEnumSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$CheckedSortedMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$UnmodifiableSortedMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Map.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.LinkedList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Stack.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.TreeMap$SubMap$EntrySetView.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.AbstractCollection.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.WeakHashMap$EntryIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$EmptySet$1.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.AbstractSequentialList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.LinkedList$ListItr.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.IdentityHashMap$KeyIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$UnmodifiableList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$CheckedCollection.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.EnumSet$SerializationProxy.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$UnmodifiableCollection.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$SingletonSet$1.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$CheckedSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.HashSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.TreeMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.IdentityHashMap$IdentityHashMapIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.RegularEnumSet$EnumSetIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Hashtable$ValueCollection.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.HashMap$EntrySet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$CheckedSortedSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.AbstractList.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.RandomAccess.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.AbstractQueue.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$CheckedMap$CheckedEntrySet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.LinkedHashMap$ValueIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.TreeMap$PrivateEntryIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.WeakHashMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$SynchronizedSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.SortedMap.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.WeakHashMap$KeySet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.RegularEnumSet.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.EnumMap$KeyIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Comparator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.HashMap$HashIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java15.util.Collections$ReverseComparator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Arrays$ArrayList.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.HashMap$Values.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.SubList$1.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TaskQueue.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.LinkedHashMap$KeyIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.IdentityHashMap$KeySet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Hashtable$Enumerator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TreeSet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$1.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.AbstractMap$2.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collection.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$SynchronizedRandomAccessList.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TreeMap$KeyIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.ConcurrentModificationException.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$CopiesList.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.BitSet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$SingletonSet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$SynchronizedMap.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TreeMap$1.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.AbstractMap.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Set.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TreeMap$SubMap.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.IdentityHashMap$EntryIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$EmptyList.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.AbstractMap$1$1.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.NoSuchElementException.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Properties.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.AbstractList$ListItr.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.ResourceBundle.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.IdentityHashMap.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$UnmodifiableCollection$1.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.PropertyResourceBundle.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Hashtable$Entry.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TreeMap$ValueIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$SingletonMap.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.WeakHashMap$Values.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$EmptySet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.HashMap$KeySet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$1.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Random.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$UnmodifiableSet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.WeakHashMap$ValueIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Map$Entry.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Hashtable$EmptyIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$SynchronizedSortedSet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$UnmodifiableList$1.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Iterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TimerTask.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.LinkedHashMap$LinkedHashIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TreeMap$2.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.StringTokenizer.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.HashMap$EntryIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$SynchronizedSortedMap.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.EventListenerProxy.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Arrays.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.ResourceBundle$LoaderReference.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$SynchronizedList.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.ListIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.AbstractList$Itr.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.SortedSet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.LinkedList$Entry.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.RandomAccessSubList.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.IdentityHashMap$ValueIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.WeakHashMap$EntrySet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Hashtable.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.AbstractMap$2$1.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Dictionary.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.PropertyPermission.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$UnmodifiableEntry.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.HashMap$ValueIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.AbstractMap$SimpleEntry.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TooManyListenersException.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TreeMap$3.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.HashMap$KeyIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Hashtable$EmptyEnumerator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.AbstractMap$1.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Hashtable$KeySet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.EmptyStackException.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.ArrayList.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.MissingResourceException.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.EventListener.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.LinkedHashMap$EntryIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.LinkedHashSet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.WeakHashMap$KeyIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Vector.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$SingletonList.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.IdentityHashMap$EntrySet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$EmptyMap.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.ResourceBundle$1.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.WeakHashMap$HashIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TimerThread.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.HashMap$Entry.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$UnmodifiableSortedSet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.LinkedHashMap$Entry.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$SingletonMap$ImmutableEntry.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$UnmodifiableRandomAccessList.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$SynchronizedCollection.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$UnmodifiableMap.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.IdentityHashMap$Values.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TreeMap$SubMapEntryIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.ResourceBundleEnumeration.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TreeMap$Entry.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.AbstractSet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Hashtable$EntrySet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.LinkedHashMap.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.HashMap.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.List.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TreeMap$EntryIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.SubList.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.WeakHashMap$Entry.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Vector$1.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$UnmodifiableSortedMap.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Map.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.LinkedList.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.PropertyPermissionCollection.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Stack.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TreeMap$SubMap$EntrySetView.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.AbstractCollection.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.WeakHashMap$EntryIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$EmptySet$1.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.AbstractSequentialList.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.LinkedList$ListItr.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.IdentityHashMap$KeyIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Timer.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$UnmodifiableList.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.ListResourceBundle.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Observable.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$UnmodifiableCollection.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$SingletonSet$1.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.HashSet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.ResourceBundle$ResourceCacheKey.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.TreeMap.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.IdentityHashMap$IdentityHashMapIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Hashtable$ValueCollection.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.HashMap$EntrySet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Timer$1.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.AbstractList.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.RandomAccess.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Observer.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.LinkedHashMap$ValueIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.EventObject.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.WeakHashMap.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$SynchronizedSet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.SortedMap.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.WeakHashMap$KeySet.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Comparator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.HashMap$HashIterator.jimple
Writing to sootOutput/benchmarks.instrumented.java.util.Collections$ReverseComparator.jimple
Writing to sootOutput/benchmarks.dstest.StackDeadlockTest.jimple
Writing to sootOutput/benchmarks.dstest.ListFactory.jimple
Writing to sootOutput/benchmarks.dstest.HashMapDeadlockTest.jimple
Writing to sootOutput/benchmarks.dstest.IdentityHashMapFactory.jimple
Writing to sootOutput/benchmarks.dstest.HashMapFactory.jimple
Writing to sootOutput/benchmarks.dstest.IdentityHashMapDeadlockTest.jimple
Writing to sootOutput/benchmarks.dstest.NoSuchElementException.jimple
Writing to sootOutput/benchmarks.dstest.MTSetDeadlock.jimple
Writing to sootOutput/benchmarks.dstest.ArrayListDeadlock2Test.jimple
Writing to sootOutput/benchmarks.dstest.MTArrayListTest.jimple
Writing to sootOutput/benchmarks.dstest.WeakHashMapFactory.jimple
Writing to sootOutput/benchmarks.dstest.TreeMapDeadlockTest.jimple
Writing to sootOutput/benchmarks.dstest.SetDeadlockTest.jimple
Writing to sootOutput/benchmarks.dstest.StackFactory.jimple
Writing to sootOutput/benchmarks.dstest.MTSetTest.jimple
Writing to sootOutput/benchmarks.dstest.Enumeration.jimple
Writing to sootOutput/benchmarks.dstest.MapDeadlockTest.jimple
Writing to sootOutput/benchmarks.dstest.ArrayListFactory.jimple
Writing to sootOutput/benchmarks.dstest.Vector.jimple
Writing to sootOutput/benchmarks.dstest.LinkedHashMapFactory.jimple
Writing to sootOutput/benchmarks.dstest.MTListDeadlock.jimple
Writing to sootOutput/benchmarks.dstest.MTSBTest.jimple
Writing to sootOutput/benchmarks.dstest.MTListTest.jimple
Writing to sootOutput/benchmarks.dstest.MapFactory.jimple
Writing to sootOutput/benchmarks.dstest.SimpleObject.jimple
Writing to sootOutput/benchmarks.dstest.LinkedHashMapDeadlockTest.jimple
Writing to sootOutput/benchmarks.dstest.VectorEnumerator.jimple
Writing to sootOutput/benchmarks.dstest.TreeMapFactory.jimple
Writing to sootOutput/benchmarks.dstest.MTLinkedHashSetTest.jimple
Writing to sootOutput/benchmarks.dstest.ListDeadlockTest.jimple
Writing to sootOutput/benchmarks.dstest.MTLinkedListInfiniteLoop.jimple
Writing to sootOutput/benchmarks.dstest.LinkedListDeadlockTest.jimple
Writing to sootOutput/benchmarks.dstest.ArrayListDeadlockTest.jimple
Writing to sootOutput/benchmarks.dstest.MTTreeSetTest.jimple
Writing to sootOutput/benchmarks.dstest.WeakHashMapDeadlockTest.jimple
Writing to sootOutput/benchmarks.dstest.MTHashtableTest.jimple
Writing to sootOutput/benchmarks.dstest.MTVectorTest.jimple
Writing to sootOutput/benchmarks.dstest.LinkedListFactory.jimple
Writing to sootOutput/javato.instrumentor.RecursiveVisitor.jimple
Writing to sootOutput/javato.instrumentor.UnknownASTNodeException.jimple
Writing to sootOutput/javato.instrumentor.TransformClass.jimple
Writing to sootOutput/javato.instrumentor.SymbolTables.jimple
Writing to sootOutput/javato.instrumentor.contexts.InstanceOfContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.ThrowContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.NewExprContext.jimple
Writing to sootOutput/javato.instrumentor.contexts.NewExprContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.NewMultiArrayContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.RefContext.jimple
Writing to sootOutput/javato.instrumentor.contexts.TypeContext.jimple
Writing to sootOutput/javato.instrumentor.contexts.SwitchContext.jimple
Writing to sootOutput/javato.instrumentor.contexts.Context.jimple
Writing to sootOutput/javato.instrumentor.contexts.IfSecondContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.TableSwitchContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.LocalContext.jimple
Writing to sootOutput/javato.instrumentor.contexts.LookupSwitchContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.InvokeOnlyTargetContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.IfContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.LocalOrConstantContext.jimple
Writing to sootOutput/javato.instrumentor.contexts.LengthContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.LookupSwitchDefaultContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.GotoContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.GotoContext.jimple
Writing to sootOutput/javato.instrumentor.contexts.LabelContext.jimple
Writing to sootOutput/javato.instrumentor.contexts.InvokeAndAssignArgumentContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.ReturnContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.RHSSecondContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.RHSFirstContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.LHSContext.jimple
Writing to sootOutput/javato.instrumentor.contexts.ParameterRefContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.SpecialContext.jimple
Writing to sootOutput/javato.instrumentor.contexts.TableSwitchDefaultContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.ExitMonitorContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.InvokeAndAssignContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.LHSContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.RHSContext.jimple
Writing to sootOutput/javato.instrumentor.contexts.CaughtExceptionRefContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.EnterMonitorContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.NewArrayContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.RHSContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.LookupSwitchLabelContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.InvokeOnlyContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.BinopExprContext.jimple
Writing to sootOutput/javato.instrumentor.contexts.ThisRefContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.IfFirstContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.TableSwitchLabelContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.CastContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.InvokeContext.jimple
Writing to sootOutput/javato.instrumentor.contexts.IfContext.jimple
Writing to sootOutput/javato.instrumentor.contexts.NegContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.InvokeAndAssignTargetContextImpl.jimple
Writing to sootOutput/javato.instrumentor.contexts.InvokeOnlyArgumentContextImpl.jimple
Writing to sootOutput/javato.instrumentor.Visitor.jimple
Writing to sootOutput/javato.instrumentor.TransformerForInstrumentation.jimple
Writing to sootOutput/javato.activetesting.instrumentor.DefaultVisitor.jimple
Writing to sootOutput/javato.activetesting.instrumentor.VisitorForThreadLocal.jimple
Writing to sootOutput/javato.activetesting.instrumentor.VisitorForActiveTesting.jimple
Writing to sootOutput/javato.activetesting.instrumentor.InstrumentorForActiveTesting.jimple
Writing to sootOutput/javato.activetesting.instrumentor.VisitorForInstrumentionOfSTM.jimple
Writing to sootOutput/javato.activetesting.instrumentor.VisitorForQueryTag.jimple
Writing to sootOutput/javato.activetesting.IGoodlockAnalysis.jimple
Writing to sootOutput/javato.activetesting.igoodlock.GoodlockDS.jimple
Writing to sootOutput/javato.activetesting.igoodlock.Node.jimple
Writing to sootOutput/javato.activetesting.igoodlock.InterEdges$InterEdgeIterator.jimple
Writing to sootOutput/javato.activetesting.igoodlock.LockGraph.jimple
Writing to sootOutput/javato.activetesting.igoodlock.LockTree.jimple
Writing to sootOutput/javato.activetesting.igoodlock.Pair.jimple
Writing to sootOutput/javato.activetesting.igoodlock.InterEdges.jimple
Writing to sootOutput/javato.activetesting.igoodlock.Path.jimple
Writing to sootOutput/javato.activetesting.igoodlock.LockNode.jimple
Writing to sootOutput/javato.activetesting.igoodlock.DeadlockCycleInfo.jimple
Writing to sootOutput/javato.activetesting.RaceFuzzerAnalysis.jimple
Writing to sootOutput/javato.activetesting.scheduler.StallBreaker.jimple
Writing to sootOutput/javato.activetesting.scheduler.LivelockBreaker.jimple
Writing to sootOutput/javato.activetesting.activechecker.ActiveChecker.jimple
Writing to sootOutput/javato.activetesting.activechecker.Semaphore.jimple
Writing to sootOutput/javato.activetesting.activechecker.ActiveChecker$Pair.jimple
Writing to sootOutput/javato.activetesting.common.IntCounter.jimple
Writing to sootOutput/javato.activetesting.common.WeakIdentityHashMap.jimple
Writing to sootOutput/javato.activetesting.common.WeakIdentityHashMap$SimpleEntry.jimple
Writing to sootOutput/javato.activetesting.common.WeakIdentityHashMap$KeyIterator.jimple
Writing to sootOutput/javato.activetesting.common.WeakIdentityHashMap$ValueIterator.jimple
Writing to sootOutput/javato.activetesting.common.WeakIdentityHashMap$KeySet.jimple
Writing to sootOutput/javato.activetesting.common.MersenneTwisterFast.jimple
Writing to sootOutput/javato.activetesting.common.WeakIdentityHashMap$Values.jimple
Writing to sootOutput/javato.activetesting.common.Parameters.jimple
Writing to sootOutput/javato.activetesting.common.WeakIdentityHashMap$EntrySet.jimple
Writing to sootOutput/javato.activetesting.common.WeakIdentityHashMap$EntryIterator.jimple
Writing to sootOutput/javato.activetesting.common.WeakIdentityHashMap$Entry.jimple
Writing to sootOutput/javato.activetesting.common.WeakIdentityHashMap$HashIterator.jimple
Writing to sootOutput/javato.activetesting.analysis.SyncMethodCache.jimple
Writing to sootOutput/javato.activetesting.analysis.SyncMethodCache$SYNC_STATUS.jimple
Writing to sootOutput/javato.activetesting.analysis.ObserverForActiveTesting$1.jimple
Writing to sootOutput/javato.activetesting.analysis.ObserverForActiveTesting$2.jimple
Writing to sootOutput/javato.activetesting.analysis.Analysis.jimple
Writing to sootOutput/javato.activetesting.analysis.ObserverForActiveTesting.jimple
Writing to sootOutput/javato.activetesting.analysis.AnalysisImpl.jimple
Writing to sootOutput/javato.activetesting.analysis.CheckerAnalysisImpl.jimple
Writing to sootOutput/javato.activetesting.analysis.Observer.jimple
Writing to sootOutput/javato.activetesting.reentrant.LockSetWithCount.jimple
Writing to sootOutput/javato.activetesting.reentrant.ThreadLocal.jimple
Writing to sootOutput/javato.activetesting.reentrant.IgnoreRentrantLock$1.jimple
Writing to sootOutput/javato.activetesting.reentrant.IgnoreRentrantLock.jimple
Writing to sootOutput/javato.activetesting.HybridAnalysis.jimple
Writing to sootOutput/javato.activetesting.lockset.LockSetTracker.jimple
Writing to sootOutput/javato.activetesting.lockset.LockSet.jimple
Writing to sootOutput/javato.activetesting.PrintTraceAnalysis.jimple
Writing to sootOutput/javato.activetesting.DeadlockFuzzerAnalysis.jimple
