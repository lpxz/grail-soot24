-Xmx8888m -Djava.library.path=./lib
32bit: memory is not enough forthe c ciode
64 bit: rt14.jar not available? 32 ok??
       libbuddy.so is under 32bits... require recompilation? too troublesome
//
 Here are the timings of solving the 12x12 NQueens problem on an Opteron 150 (2.4GHz, RedHat Enterprise Linux 3 in 32 bit mode, Sun JDK 1.5.0). This test simply does simple logic operations. It primarily tests the speed of node creation and BDD garbage collection. The command line I used to test was:
java -mx512m -Dbdd=package -jar javabdd-1.0b2.jar 12
Package 	Time 	Peak Memory Usage
buddy 	41s 	152mb
cudd 	46s 	171mb
cal 	68s 	251mb
java (-server) 	53s 	171mb
java (-client) 	54s 	152mb
jdd (-server) 	50s 	188mb
jdd (-client) 	49s 	169mb 