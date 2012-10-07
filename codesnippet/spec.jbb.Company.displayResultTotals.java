public void displayResultTotals(boolean showWarehouseDetail) {
    short warehouseId;
    TimerData warehouseTimerData;
    synchronized (initThreadsStateChange) {
        while (initThreadsCount != MaxWarehouses) {
            try {
                initThreadsStateChange.wait();
            } catch (InterruptedException e) {
            }
        }
    }
    if (JBBmain.multiJVMMode) {
        System.out.println(JBBmain.instanceId + ":READY");
        JBBmain.socOut.println(JBBmain.instanceId + ":READY");
        JBBmain.socOut.flush();
        String mesg = "NULL";
        String needMsg = JBBmain.instanceId + ":START";
        try {
            while (!mesg.matches(needMsg)) mesg = JBBmain.socIn.readLine();
        } catch (java.io.IOException excep) {
            JBButil.getLog().log(Level.WARNING, excep + ": Unable to read from socket", excep);
            System.exit(1);
        }
        String messageReceived = ">>>>>>>> Got Message: " + mesg;
        JBButil.getLog().info(messageReceived);
        System.out.println(messageReceived);
    }
    setrunMode(runModes.RAMP_UP);
    synchronized (initThreadsCountMonitor) {
        initThreadsCountMonitor.notifyAll();
    }
    String msg;
    long start_time = 0;
    long end_time = 0;
    long start_rampup_time = 0;
    long end_rampdown_time = 0;
    DecimalFormat df = new DecimalFormat("#####.##");
    long tmpTime = 0;
    if (JBBmain.multiJVMMode) {
        setrunMode(runModes.MULTI_RAMP);
        start_rampup_time = System.currentTimeMillis();
        tmpTime = (long) per_jvm_warehouse_rampup;
        msg = "User Thread Multi-JVM Rampup padding began " + new Date().toString() + " for " + tmpTime + " seconds";
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) tmpTime);
    }
    if (rampup_time > 0) {
        msg = "User Thread Rampup began " + new Date().toString() + " for " + df.format(rampup_time / 60.) + " minutes";
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) rampup_time);
    }
    if (measurement_time > 0) {
        msg = "Timing Measurement began " + new Date().toString() + " for " + df.format(measurement_time / 60.) + " minutes";
        setrunMode(runModes.RECORDING);
        start_time = System.currentTimeMillis();
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) measurement_time);
    }
    end_time = System.currentTimeMillis();
    msg = "Timing Measurement ended " + new Date().toString();
    JBButil.getLog().info(msg);
    System.out.println(msg);
    if (JBBmain.multiJVMMode) {
        setrunMode(runModes.MULTI_RAMP);
        tmpTime = (long) per_jvm_warehouse_rampdown;
        msg = "User Thread Multi-JVM Rampdown padding began " + new Date().toString() + " for " + tmpTime + " seconds";
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) tmpTime);
        end_rampdown_time = System.currentTimeMillis();
    }
    setrunMode(runModes.RAMP_DOWN);
    elapsed_time = end_time - start_time;
    System.out.println("");
    synchronized (threadsDoneCountMonitor) {
        while (threadsDoneCount != MaxWarehouses) {
            try {
                threadsDoneCountMonitor.wait();
            } catch (InterruptedException e) {
            }
        }
    }
    setrunMode(runModes.STOP);
    synchronized (stopThreadsCountMonitor) {
        while (stopThreadsCount != MaxWarehouses) {
            try {
                stopThreadsCountMonitor.wait();
            } catch (InterruptedException e) {
            }
        }
    }
    outPropFile.println(propPrefix + "warehouses=" + MaxWarehouses);
    if (JBBmain.multiJVMMode) {
        outPropFile.println(propPrefix + "start_rampup_time_milliseconds=" + start_rampup_time);
        outPropFile.println(propPrefix + "end_rampdown_time_milliseconds=" + end_rampdown_time);
    }
    outPropFile.println(propPrefix + "start_time_milliseconds=" + start_time);
    outPropFile.println(propPrefix + "end_time_milliseconds=" + end_time);
    outPropFile.println(propPrefix + "elapsed_milliseconds=" + elapsed_time);
    System.out.println("");
    int total_warehouse_trans = 0;
    long min_transaction_count = Long.MAX_VALUE;
    long max_transaction_count = Long.MIN_VALUE;
    for (warehouseId = 1; warehouseId <= MaxWarehouses; warehouseId++) {
        warehouseTimerData = getTimerDataPtr(warehouseId);
        warehouseTimerData.calculateResponseTimeStats();
        if (showWarehouseDetail) warehouseTimerData.propResults(propPrefix + "warehouse_" + warehouseId + ".", outPropFile);
        total_warehouse_trans = 0;
        for (int txntype = 0; txntype < Transaction.maxTxnTypes; txntype++) {
            total_warehouse_trans += warehouseTimerData.getTransactionCount(txntype);
        }
        if (total_warehouse_trans < min_transaction_count) {
            min_transaction_count = total_warehouse_trans;
        }
        if (total_warehouse_trans > max_transaction_count) {
            max_transaction_count = total_warehouse_trans;
        }
    }
    System.out.println("Calculating results");
    companyTimerData.calculateResponseTimeStats();
    companyTimerData.displayThreadResults();
    long diff = max_transaction_count - min_transaction_count;
    float diff_pct = 100 * (float) diff / (float) max_transaction_count;
    System.out.println("");
    System.out.println("Minimum transactions by a warehouse = " + min_transaction_count);
    System.out.println("Maximum transactions by a warehouse = " + max_transaction_count);
    System.out.println("Difference (thread spread) = " + diff + " (" + df.format(diff_pct) + "%)");
    System.out.println("");
    companyTimerData.displayResults(("COMPANY with " + MaxWarehouses + " warehouses "), JBButil.currentTotalMem(), JBButil.currentFreeMem());
    companyTimerData.propResults(propPrefix + "company.", outPropFile, JBButil.currentTotalMem(), JBButil.currentFreeMem());
    companyTimerData.propThreadResults(propPrefix + "company.", outPropFile);
    outPropFile.println(propPrefix + "company.min_warehouse_transactions=" + min_transaction_count);
    outPropFile.println(propPrefix + "company.max_warehouse_transactions=" + max_transaction_count);
    if (Transaction.steadyStateMem) {
        trimOrdersForSteadyState();
    }
    setrunMode(runModes.DEFAULT_MODE);
}public void displayResultTotals(boolean showWarehouseDetail) {
    short warehouseId;
    TimerData warehouseTimerData;
    synchronized (initThreadsStateChange) {
        while (initThreadsCount != MaxWarehouses) {
            try {
                initThreadsStateChange.wait();
            } catch (InterruptedException e) {
            }
        }
    }
    if (JBBmain.multiJVMMode) {
        System.out.println(JBBmain.instanceId + ":READY");
        JBBmain.socOut.println(JBBmain.instanceId + ":READY");
        JBBmain.socOut.flush();
        String mesg = "NULL";
        String needMsg = JBBmain.instanceId + ":START";
        try {
            while (!mesg.matches(needMsg)) mesg = JBBmain.socIn.readLine();
        } catch (java.io.IOException excep) {
            JBButil.getLog().log(Level.WARNING, excep + ": Unable to read from socket", excep);
            System.exit(1);
        }
        String messageReceived = ">>>>>>>> Got Message: " + mesg;
        JBButil.getLog().info(messageReceived);
        System.out.println(messageReceived);
    }
    setrunMode(runModes.RAMP_UP);
    synchronized (initThreadsCountMonitor) {
        initThreadsCountMonitor.notifyAll();
    }
    String msg;
    long start_time = 0;
    long end_time = 0;
    long start_rampup_time = 0;
    long end_rampdown_time = 0;
    DecimalFormat df = new DecimalFormat("#####.##");
    long tmpTime = 0;
    if (JBBmain.multiJVMMode) {
        setrunMode(runModes.MULTI_RAMP);
        start_rampup_time = System.currentTimeMillis();
        tmpTime = (long) per_jvm_warehouse_rampup;
        msg = "User Thread Multi-JVM Rampup padding began " + new Date().toString() + " for " + tmpTime + " seconds";
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) tmpTime);
    }
    if (rampup_time > 0) {
        msg = "User Thread Rampup began " + new Date().toString() + " for " + df.format(rampup_time / 60.) + " minutes";
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) rampup_time);
    }
    if (measurement_time > 0) {
        msg = "Timing Measurement began " + new Date().toString() + " for " + df.format(measurement_time / 60.) + " minutes";
        setrunMode(runModes.RECORDING);
        start_time = System.currentTimeMillis();
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) measurement_time);
    }
    end_time = System.currentTimeMillis();
    msg = "Timing Measurement ended " + new Date().toString();
    JBButil.getLog().info(msg);
    System.out.println(msg);
    if (JBBmain.multiJVMMode) {
        setrunMode(runModes.MULTI_RAMP);
        tmpTime = (long) per_jvm_warehouse_rampdown;
        msg = "User Thread Multi-JVM Rampdown padding began " + new Date().toString() + " for " + tmpTime + " seconds";
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) tmpTime);
        end_rampdown_time = System.currentTimeMillis();
    }
    setrunMode(runModes.RAMP_DOWN);
    elapsed_time = end_time - start_time;
    System.out.println("");
    synchronized (threadsDoneCountMonitor) {
        while (threadsDoneCount != MaxWarehouses) {
            try {
                threadsDoneCountMonitor.wait();
            } catch (InterruptedException e) {
            }
        }
    }
    setrunMode(runModes.STOP);
    synchronized (stopThreadsCountMonitor) {
        while (stopThreadsCount != MaxWarehouses) {
            try {
                stopThreadsCountMonitor.wait();
            } catch (InterruptedException e) {
            }
        }
    }
    outPropFile.println(propPrefix + "warehouses=" + MaxWarehouses);
    if (JBBmain.multiJVMMode) {
        outPropFile.println(propPrefix + "start_rampup_time_milliseconds=" + start_rampup_time);
        outPropFile.println(propPrefix + "end_rampdown_time_milliseconds=" + end_rampdown_time);
    }
    outPropFile.println(propPrefix + "start_time_milliseconds=" + start_time);
    outPropFile.println(propPrefix + "end_time_milliseconds=" + end_time);
    outPropFile.println(propPrefix + "elapsed_milliseconds=" + elapsed_time);
    System.out.println("");
    int total_warehouse_trans = 0;
    long min_transaction_count = Long.MAX_VALUE;
    long max_transaction_count = Long.MIN_VALUE;
    for (warehouseId = 1; warehouseId <= MaxWarehouses; warehouseId++) {
        warehouseTimerData = getTimerDataPtr(warehouseId);
        warehouseTimerData.calculateResponseTimeStats();
        if (showWarehouseDetail) warehouseTimerData.propResults(propPrefix + "warehouse_" + warehouseId + ".", outPropFile);
        total_warehouse_trans = 0;
        for (int txntype = 0; txntype < Transaction.maxTxnTypes; txntype++) {
            total_warehouse_trans += warehouseTimerData.getTransactionCount(txntype);
        }
        if (total_warehouse_trans < min_transaction_count) {
            min_transaction_count = total_warehouse_trans;
        }
        if (total_warehouse_trans > max_transaction_count) {
            max_transaction_count = total_warehouse_trans;
        }
    }
    System.out.println("Calculating results");
    companyTimerData.calculateResponseTimeStats();
    companyTimerData.displayThreadResults();
    long diff = max_transaction_count - min_transaction_count;
    float diff_pct = 100 * (float) diff / (float) max_transaction_count;
    System.out.println("");
    System.out.println("Minimum transactions by a warehouse = " + min_transaction_count);
    System.out.println("Maximum transactions by a warehouse = " + max_transaction_count);
    System.out.println("Difference (thread spread) = " + diff + " (" + df.format(diff_pct) + "%)");
    System.out.println("");
    companyTimerData.displayResults(("COMPANY with " + MaxWarehouses + " warehouses "), JBButil.currentTotalMem(), JBButil.currentFreeMem());
    companyTimerData.propResults(propPrefix + "company.", outPropFile, JBButil.currentTotalMem(), JBButil.currentFreeMem());
    companyTimerData.propThreadResults(propPrefix + "company.", outPropFile);
    outPropFile.println(propPrefix + "company.min_warehouse_transactions=" + min_transaction_count);
    outPropFile.println(propPrefix + "company.max_warehouse_transactions=" + max_transaction_count);
    if (Transaction.steadyStateMem) {
        trimOrdersForSteadyState();
    }
    setrunMode(runModes.DEFAULT_MODE);
}public void displayResultTotals(boolean showWarehouseDetail) {
    short warehouseId;
    TimerData warehouseTimerData;
    synchronized (initThreadsStateChange) {
        while (initThreadsCount != MaxWarehouses) {
            try {
                initThreadsStateChange.wait();
            } catch (InterruptedException e) {
            }
        }
    }
    if (JBBmain.multiJVMMode) {
        System.out.println(JBBmain.instanceId + ":READY");
        JBBmain.socOut.println(JBBmain.instanceId + ":READY");
        JBBmain.socOut.flush();
        String mesg = "NULL";
        String needMsg = JBBmain.instanceId + ":START";
        try {
            while (!mesg.matches(needMsg)) mesg = JBBmain.socIn.readLine();
        } catch (java.io.IOException excep) {
            JBButil.getLog().log(Level.WARNING, excep + ": Unable to read from socket", excep);
            System.exit(1);
        }
        String messageReceived = ">>>>>>>> Got Message: " + mesg;
        JBButil.getLog().info(messageReceived);
        System.out.println(messageReceived);
    }
    setrunMode(runModes.RAMP_UP);
    synchronized (initThreadsCountMonitor) {
        initThreadsCountMonitor.notifyAll();
    }
    String msg;
    long start_time = 0;
    long end_time = 0;
    long start_rampup_time = 0;
    long end_rampdown_time = 0;
    DecimalFormat df = new DecimalFormat("#####.##");
    long tmpTime = 0;
    if (JBBmain.multiJVMMode) {
        setrunMode(runModes.MULTI_RAMP);
        start_rampup_time = System.currentTimeMillis();
        tmpTime = (long) per_jvm_warehouse_rampup;
        msg = "User Thread Multi-JVM Rampup padding began " + new Date().toString() + " for " + tmpTime + " seconds";
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) tmpTime);
    }
    if (rampup_time > 0) {
        msg = "User Thread Rampup began " + new Date().toString() + " for " + df.format(rampup_time / 60.) + " minutes";
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) rampup_time);
    }
    if (measurement_time > 0) {
        msg = "Timing Measurement began " + new Date().toString() + " for " + df.format(measurement_time / 60.) + " minutes";
        setrunMode(runModes.RECORDING);
        start_time = System.currentTimeMillis();
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) measurement_time);
    }
    end_time = System.currentTimeMillis();
    msg = "Timing Measurement ended " + new Date().toString();
    JBButil.getLog().info(msg);
    System.out.println(msg);
    if (JBBmain.multiJVMMode) {
        setrunMode(runModes.MULTI_RAMP);
        tmpTime = (long) per_jvm_warehouse_rampdown;
        msg = "User Thread Multi-JVM Rampdown padding began " + new Date().toString() + " for " + tmpTime + " seconds";
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) tmpTime);
        end_rampdown_time = System.currentTimeMillis();
    }
    setrunMode(runModes.RAMP_DOWN);
    elapsed_time = end_time - start_time;
    System.out.println("");
    synchronized (threadsDoneCountMonitor) {
        while (threadsDoneCount != MaxWarehouses) {
            try {
                threadsDoneCountMonitor.wait();
            } catch (InterruptedException e) {
            }
        }
    }
    setrunMode(runModes.STOP);
    synchronized (stopThreadsCountMonitor) {
        while (stopThreadsCount != MaxWarehouses) {
            try {
                stopThreadsCountMonitor.wait();
            } catch (InterruptedException e) {
            }
        }
    }
    outPropFile.println(propPrefix + "warehouses=" + MaxWarehouses);
    if (JBBmain.multiJVMMode) {
        outPropFile.println(propPrefix + "start_rampup_time_milliseconds=" + start_rampup_time);
        outPropFile.println(propPrefix + "end_rampdown_time_milliseconds=" + end_rampdown_time);
    }
    outPropFile.println(propPrefix + "start_time_milliseconds=" + start_time);
    outPropFile.println(propPrefix + "end_time_milliseconds=" + end_time);
    outPropFile.println(propPrefix + "elapsed_milliseconds=" + elapsed_time);
    System.out.println("");
    int total_warehouse_trans = 0;
    long min_transaction_count = Long.MAX_VALUE;
    long max_transaction_count = Long.MIN_VALUE;
    for (warehouseId = 1; warehouseId <= MaxWarehouses; warehouseId++) {
        warehouseTimerData = getTimerDataPtr(warehouseId);
        warehouseTimerData.calculateResponseTimeStats();
        if (showWarehouseDetail) warehouseTimerData.propResults(propPrefix + "warehouse_" + warehouseId + ".", outPropFile);
        total_warehouse_trans = 0;
        for (int txntype = 0; txntype < Transaction.maxTxnTypes; txntype++) {
            total_warehouse_trans += warehouseTimerData.getTransactionCount(txntype);
        }
        if (total_warehouse_trans < min_transaction_count) {
            min_transaction_count = total_warehouse_trans;
        }
        if (total_warehouse_trans > max_transaction_count) {
            max_transaction_count = total_warehouse_trans;
        }
    }
    System.out.println("Calculating results");
    companyTimerData.calculateResponseTimeStats();
    companyTimerData.displayThreadResults();
    long diff = max_transaction_count - min_transaction_count;
    float diff_pct = 100 * (float) diff / (float) max_transaction_count;
    System.out.println("");
    System.out.println("Minimum transactions by a warehouse = " + min_transaction_count);
    System.out.println("Maximum transactions by a warehouse = " + max_transaction_count);
    System.out.println("Difference (thread spread) = " + diff + " (" + df.format(diff_pct) + "%)");
    System.out.println("");
    companyTimerData.displayResults(("COMPANY with " + MaxWarehouses + " warehouses "), JBButil.currentTotalMem(), JBButil.currentFreeMem());
    companyTimerData.propResults(propPrefix + "company.", outPropFile, JBButil.currentTotalMem(), JBButil.currentFreeMem());
    companyTimerData.propThreadResults(propPrefix + "company.", outPropFile);
    outPropFile.println(propPrefix + "company.min_warehouse_transactions=" + min_transaction_count);
    outPropFile.println(propPrefix + "company.max_warehouse_transactions=" + max_transaction_count);
    if (Transaction.steadyStateMem) {
        trimOrdersForSteadyState();
    }
    setrunMode(runModes.DEFAULT_MODE);
}public void displayResultTotals(boolean showWarehouseDetail) {
    short warehouseId;
    TimerData warehouseTimerData;
    synchronized (initThreadsStateChange) {
        while (initThreadsCount != MaxWarehouses) {
            try {
                initThreadsStateChange.wait();
            } catch (InterruptedException e) {
            }
        }
    }
    if (JBBmain.multiJVMMode) {
        System.out.println(JBBmain.instanceId + ":READY");
        JBBmain.socOut.println(JBBmain.instanceId + ":READY");
        JBBmain.socOut.flush();
        String mesg = "NULL";
        String needMsg = JBBmain.instanceId + ":START";
        try {
            while (!mesg.matches(needMsg)) mesg = JBBmain.socIn.readLine();
        } catch (java.io.IOException excep) {
            JBButil.getLog().log(Level.WARNING, excep + ": Unable to read from socket", excep);
            System.exit(1);
        }
        String messageReceived = ">>>>>>>> Got Message: " + mesg;
        JBButil.getLog().info(messageReceived);
        System.out.println(messageReceived);
    }
    setrunMode(runModes.RAMP_UP);
    synchronized (initThreadsCountMonitor) {
        initThreadsCountMonitor.notifyAll();
    }
    String msg;
    long start_time = 0;
    long end_time = 0;
    long start_rampup_time = 0;
    long end_rampdown_time = 0;
    DecimalFormat df = new DecimalFormat("#####.##");
    long tmpTime = 0;
    if (JBBmain.multiJVMMode) {
        setrunMode(runModes.MULTI_RAMP);
        start_rampup_time = System.currentTimeMillis();
        tmpTime = (long) per_jvm_warehouse_rampup;
        msg = "User Thread Multi-JVM Rampup padding began " + new Date().toString() + " for " + tmpTime + " seconds";
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) tmpTime);
    }
    if (rampup_time > 0) {
        msg = "User Thread Rampup began " + new Date().toString() + " for " + df.format(rampup_time / 60.) + " minutes";
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) rampup_time);
    }
    if (measurement_time > 0) {
        msg = "Timing Measurement began " + new Date().toString() + " for " + df.format(measurement_time / 60.) + " minutes";
        setrunMode(runModes.RECORDING);
        start_time = System.currentTimeMillis();
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) measurement_time);
    }
    end_time = System.currentTimeMillis();
    msg = "Timing Measurement ended " + new Date().toString();
    JBButil.getLog().info(msg);
    System.out.println(msg);
    if (JBBmain.multiJVMMode) {
        setrunMode(runModes.MULTI_RAMP);
        tmpTime = (long) per_jvm_warehouse_rampdown;
        msg = "User Thread Multi-JVM Rampdown padding began " + new Date().toString() + " for " + tmpTime + " seconds";
        JBButil.getLog().info(msg);
        System.out.println(msg);
        JBButil.SecondsToSleep((int) tmpTime);
        end_rampdown_time = System.currentTimeMillis();
    }
    setrunMode(runModes.RAMP_DOWN);
    elapsed_time = end_time - start_time;
    System.out.println("");
    synchronized (threadsDoneCountMonitor) {
        while (threadsDoneCount != MaxWarehouses) {
            try {
                threadsDoneCountMonitor.wait();
            } catch (InterruptedException e) {
            }
        }
    }
    setrunMode(runModes.STOP);
    synchronized (stopThreadsCountMonitor) {
        while (stopThreadsCount != MaxWarehouses) {
            try {
                stopThreadsCountMonitor.wait();
            } catch (InterruptedException e) {
            }
        }
    }
    outPropFile.println(propPrefix + "warehouses=" + MaxWarehouses);
    if (JBBmain.multiJVMMode) {
        outPropFile.println(propPrefix + "start_rampup_time_milliseconds=" + start_rampup_time);
        outPropFile.println(propPrefix + "end_rampdown_time_milliseconds=" + end_rampdown_time);
    }
    outPropFile.println(propPrefix + "start_time_milliseconds=" + start_time);
    outPropFile.println(propPrefix + "end_time_milliseconds=" + end_time);
    outPropFile.println(propPrefix + "elapsed_milliseconds=" + elapsed_time);
    System.out.println("");
    int total_warehouse_trans = 0;
    long min_transaction_count = Long.MAX_VALUE;
    long max_transaction_count = Long.MIN_VALUE;
    for (warehouseId = 1; warehouseId <= MaxWarehouses; warehouseId++) {
        warehouseTimerData = getTimerDataPtr(warehouseId);
        warehouseTimerData.calculateResponseTimeStats();
        if (showWarehouseDetail) warehouseTimerData.propResults(propPrefix + "warehouse_" + warehouseId + ".", outPropFile);
        total_warehouse_trans = 0;
        for (int txntype = 0; txntype < Transaction.maxTxnTypes; txntype++) {
            total_warehouse_trans += warehouseTimerData.getTransactionCount(txntype);
        }
        if (total_warehouse_trans < min_transaction_count) {
            min_transaction_count = total_warehouse_trans;
        }
        if (total_warehouse_trans > max_transaction_count) {
            max_transaction_count = total_warehouse_trans;
        }
    }
    System.out.println("Calculating results");
    companyTimerData.calculateResponseTimeStats();
    companyTimerData.displayThreadResults();
    long diff = max_transaction_count - min_transaction_count;
    float diff_pct = 100 * (float) diff / (float) max_transaction_count;
    System.out.println("");
    System.out.println("Minimum transactions by a warehouse = " + min_transaction_count);
    System.out.println("Maximum transactions by a warehouse = " + max_transaction_count);
    System.out.println("Difference (thread spread) = " + diff + " (" + df.format(diff_pct) + "%)");
    System.out.println("");
    companyTimerData.displayResults(("COMPANY with " + MaxWarehouses + " warehouses "), JBButil.currentTotalMem(), JBButil.currentFreeMem());
    companyTimerData.propResults(propPrefix + "company.", outPropFile, JBButil.currentTotalMem(), JBButil.currentFreeMem());
    companyTimerData.propThreadResults(propPrefix + "company.", outPropFile);
    outPropFile.println(propPrefix + "company.min_warehouse_transactions=" + min_transaction_count);
    outPropFile.println(propPrefix + "company.max_warehouse_transactions=" + max_transaction_count);
    if (Transaction.steadyStateMem) {
        trimOrdersForSteadyState();
    }
    setrunMode(runModes.DEFAULT_MODE);
}