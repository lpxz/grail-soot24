public synchronized Company.runModes getrunMode() {
    return mode;
}public void go() {
    byte co = 0;
    int deck[] = new int[33];
    long elapsed_time;
    long txntime;
    int txntype;
    boolean timed = false;
    boolean signaled_done = false;
    int i = 0;
    TimerData warehouseTimerDataPtr = company.getTimerDataPtr(warehouseId);
    long rampup_time = warehouseTimerDataPtr.getRampUpTime();
    long measurement_time = warehouseTimerDataPtr.getMeasurementTime();
    TimerData myTimerData = new TimerData();
    myTimerData.setWaitTimes(warehouseTimerDataPtr.getWaitTimes());
    deck = buildDeck();
    Warehouse warehousePtr = company.getWarehousePtr(warehouseId, false);
    createTxnInstances();
    synchronized (company.initThreadsCountMonitor) {
        synchronized (company.initThreadsStateChange) {
            company.initThreadsCount++;
            company.initThreadsStateChange.notify();
        }
        try {
            company.initThreadsCountMonitor.wait();
        } catch (InterruptedException e) {
        }
    }
    if ((rampup_time > 0) || (measurement_time > 0)) {
        timed = true;
    }
    if (JBButil.getLog().isLoggable(Level.FINEST)) {
        JBButil.getLog().finest("Benchmark " + JBBmain.Version + ": warehouse " + warehouseId);
    }
    while (this.getrunMode() != Company.runModes.STOP) {
        if ((!timed) && (this.getrunMode() == Company.runModes.DEFAULT_MODE)) {
            manualSelection();
            txntype = (new Integer(readUserValue()).intValue()) - 1;
        } else {
            txntype = deck[i];
            i++;
            if (i == 33) {
                deck = buildDeck();
                i = 0;
            }
        }
        txntime = goManual(txntype, myTimerData);
        if (this.getrunMode() == Company.runModes.RECORDING) myTimerData.updateTimerData(txntype, txntime);
        if (timed) {
            if ((this.getrunMode() == Company.runModes.RAMP_DOWN) && (!signaled_done)) {
                synchronized (company.threadsDoneCountMonitor) {
                    company.threadsDoneCount++;
                    company.threadsDoneCountMonitor.notify();
                    signaled_done = true;
                }
            }
        } else {
            if (txntype == pgm_exit) {
                break;
            }
        }
    }
    if (timed && (this.getrunMode() == Company.runModes.STOP)) {
        elapsed_time = company.getElapsedTime();
        myTimerData.calculateResponseTimeStats();
        double tpmc = myTimerData.updateTPMC(elapsed_time);
        double btps = myTimerData.updateBTPS(elapsed_time);
        long totalTransactions = 0;
        for (txntype = 0; txntype < maxTxnTypes; txntype++) {
            warehouseTimerDataPtr.rollupTimerData(txntype, myTimerData.getTransactionCount(txntype), myTimerData.getTotalTime(txntype), myTimerData.getTotalTimeSquare(txntype), myTimerData.getMinimumTime(txntype), myTimerData.getMaximumTime(txntype));
            company.getTimerDataPtr(co).rollupTimerData(txntype, myTimerData.getTransactionCount(txntype), myTimerData.getTotalTime(txntype), myTimerData.getTotalTimeSquare(txntype), myTimerData.getMinimumTime(txntype), myTimerData.getMaximumTime(txntype));
            totalTransactions += myTimerData.getTransactionCount(txntype);
        }
        company.getTimerDataPtr(co).accumulateTransactionStats(totalTransactions);
        warehouseTimerDataPtr.updateTPMC(tpmc);
        warehouseTimerDataPtr.updateBTPS(btps);
        company.getTimerDataPtr(co).updateTPMC(tpmc);
        company.getTimerDataPtr(co).updateBTPS(btps);
        synchronized (company.stopThreadsCountMonitor) {
            company.stopThreadsCount++;
            company.stopThreadsCountMonitor.notify();
        }
    }
}public void go() {
    byte co = 0;
    int deck[] = new int[33];
    long elapsed_time;
    long txntime;
    int txntype;
    boolean timed = false;
    boolean signaled_done = false;
    int i = 0;
    TimerData warehouseTimerDataPtr = company.getTimerDataPtr(warehouseId);
    long rampup_time = warehouseTimerDataPtr.getRampUpTime();
    long measurement_time = warehouseTimerDataPtr.getMeasurementTime();
    TimerData myTimerData = new TimerData();
    myTimerData.setWaitTimes(warehouseTimerDataPtr.getWaitTimes());
    deck = buildDeck();
    Warehouse warehousePtr = company.getWarehousePtr(warehouseId, false);
    createTxnInstances();
    synchronized (company.initThreadsCountMonitor) {
        synchronized (company.initThreadsStateChange) {
            company.initThreadsCount++;
            company.initThreadsStateChange.notify();
        }
        try {
            company.initThreadsCountMonitor.wait();
        } catch (InterruptedException e) {
        }
    }
    if ((rampup_time > 0) || (measurement_time > 0)) {
        timed = true;
    }
    if (JBButil.getLog().isLoggable(Level.FINEST)) {
        JBButil.getLog().finest("Benchmark " + JBBmain.Version + ": warehouse " + warehouseId);
    }
    while (this.getrunMode() != Company.runModes.STOP) {
        if ((!timed) && (this.getrunMode() == Company.runModes.DEFAULT_MODE)) {
            manualSelection();
            txntype = (new Integer(readUserValue()).intValue()) - 1;
        } else {
            txntype = deck[i];
            i++;
            if (i == 33) {
                deck = buildDeck();
                i = 0;
            }
        }
        txntime = goManual(txntype, myTimerData);
        if (this.getrunMode() == Company.runModes.RECORDING) myTimerData.updateTimerData(txntype, txntime);
        if (timed) {
            if ((this.getrunMode() == Company.runModes.RAMP_DOWN) && (!signaled_done)) {
                synchronized (company.threadsDoneCountMonitor) {
                    company.threadsDoneCount++;
                    company.threadsDoneCountMonitor.notify();
                    signaled_done = true;
                }
            }
        } else {
            if (txntype == pgm_exit) {
                break;
            }
        }
    }
    if (timed && (this.getrunMode() == Company.runModes.STOP)) {
        elapsed_time = company.getElapsedTime();
        myTimerData.calculateResponseTimeStats();
        double tpmc = myTimerData.updateTPMC(elapsed_time);
        double btps = myTimerData.updateBTPS(elapsed_time);
        long totalTransactions = 0;
        for (txntype = 0; txntype < maxTxnTypes; txntype++) {
            warehouseTimerDataPtr.rollupTimerData(txntype, myTimerData.getTransactionCount(txntype), myTimerData.getTotalTime(txntype), myTimerData.getTotalTimeSquare(txntype), myTimerData.getMinimumTime(txntype), myTimerData.getMaximumTime(txntype));
            company.getTimerDataPtr(co).rollupTimerData(txntype, myTimerData.getTransactionCount(txntype), myTimerData.getTotalTime(txntype), myTimerData.getTotalTimeSquare(txntype), myTimerData.getMinimumTime(txntype), myTimerData.getMaximumTime(txntype));
            totalTransactions += myTimerData.getTransactionCount(txntype);
        }
        company.getTimerDataPtr(co).accumulateTransactionStats(totalTransactions);
        warehouseTimerDataPtr.updateTPMC(tpmc);
        warehouseTimerDataPtr.updateBTPS(btps);
        company.getTimerDataPtr(co).updateTPMC(tpmc);
        company.getTimerDataPtr(co).updateBTPS(btps);
        synchronized (company.stopThreadsCountMonitor) {
            company.stopThreadsCount++;
            company.stopThreadsCountMonitor.notify();
        }
    }
}public void go() {
    byte co = 0;
    int deck[] = new int[33];
    long elapsed_time;
    long txntime;
    int txntype;
    boolean timed = false;
    boolean signaled_done = false;
    int i = 0;
    TimerData warehouseTimerDataPtr = company.getTimerDataPtr(warehouseId);
    long rampup_time = warehouseTimerDataPtr.getRampUpTime();
    long measurement_time = warehouseTimerDataPtr.getMeasurementTime();
    TimerData myTimerData = new TimerData();
    myTimerData.setWaitTimes(warehouseTimerDataPtr.getWaitTimes());
    deck = buildDeck();
    Warehouse warehousePtr = company.getWarehousePtr(warehouseId, false);
    createTxnInstances();
    synchronized (company.initThreadsCountMonitor) {
        synchronized (company.initThreadsStateChange) {
            company.initThreadsCount++;
            company.initThreadsStateChange.notify();
        }
        try {
            company.initThreadsCountMonitor.wait();
        } catch (InterruptedException e) {
        }
    }
    if ((rampup_time > 0) || (measurement_time > 0)) {
        timed = true;
    }
    if (JBButil.getLog().isLoggable(Level.FINEST)) {
        JBButil.getLog().finest("Benchmark " + JBBmain.Version + ": warehouse " + warehouseId);
    }
    while (this.getrunMode() != Company.runModes.STOP) {
        if ((!timed) && (this.getrunMode() == Company.runModes.DEFAULT_MODE)) {
            manualSelection();
            txntype = (new Integer(readUserValue()).intValue()) - 1;
        } else {
            txntype = deck[i];
            i++;
            if (i == 33) {
                deck = buildDeck();
                i = 0;
            }
        }
        txntime = goManual(txntype, myTimerData);
        if (this.getrunMode() == Company.runModes.RECORDING) myTimerData.updateTimerData(txntype, txntime);
        if (timed) {
            if ((this.getrunMode() == Company.runModes.RAMP_DOWN) && (!signaled_done)) {
                synchronized (company.threadsDoneCountMonitor) {
                    company.threadsDoneCount++;
                    company.threadsDoneCountMonitor.notify();
                    signaled_done = true;
                }
            }
        } else {
            if (txntype == pgm_exit) {
                break;
            }
        }
    }
    if (timed && (this.getrunMode() == Company.runModes.STOP)) {
        elapsed_time = company.getElapsedTime();
        myTimerData.calculateResponseTimeStats();
        double tpmc = myTimerData.updateTPMC(elapsed_time);
        double btps = myTimerData.updateBTPS(elapsed_time);
        long totalTransactions = 0;
        for (txntype = 0; txntype < maxTxnTypes; txntype++) {
            warehouseTimerDataPtr.rollupTimerData(txntype, myTimerData.getTransactionCount(txntype), myTimerData.getTotalTime(txntype), myTimerData.getTotalTimeSquare(txntype), myTimerData.getMinimumTime(txntype), myTimerData.getMaximumTime(txntype));
            company.getTimerDataPtr(co).rollupTimerData(txntype, myTimerData.getTransactionCount(txntype), myTimerData.getTotalTime(txntype), myTimerData.getTotalTimeSquare(txntype), myTimerData.getMinimumTime(txntype), myTimerData.getMaximumTime(txntype));
            totalTransactions += myTimerData.getTransactionCount(txntype);
        }
        company.getTimerDataPtr(co).accumulateTransactionStats(totalTransactions);
        warehouseTimerDataPtr.updateTPMC(tpmc);
        warehouseTimerDataPtr.updateBTPS(btps);
        company.getTimerDataPtr(co).updateTPMC(tpmc);
        company.getTimerDataPtr(co).updateBTPS(btps);
        synchronized (company.stopThreadsCountMonitor) {
            company.stopThreadsCount++;
            company.stopThreadsCountMonitor.notify();
        }
    }
}public void go() {
    byte co = 0;
    int deck[] = new int[33];
    long elapsed_time;
    long txntime;
    int txntype;
    boolean timed = false;
    boolean signaled_done = false;
    int i = 0;
    TimerData warehouseTimerDataPtr = company.getTimerDataPtr(warehouseId);
    long rampup_time = warehouseTimerDataPtr.getRampUpTime();
    long measurement_time = warehouseTimerDataPtr.getMeasurementTime();
    TimerData myTimerData = new TimerData();
    myTimerData.setWaitTimes(warehouseTimerDataPtr.getWaitTimes());
    deck = buildDeck();
    Warehouse warehousePtr = company.getWarehousePtr(warehouseId, false);
    createTxnInstances();
    synchronized (company.initThreadsCountMonitor) {
        synchronized (company.initThreadsStateChange) {
            company.initThreadsCount++;
            company.initThreadsStateChange.notify();
        }
        try {
            company.initThreadsCountMonitor.wait();
        } catch (InterruptedException e) {
        }
    }
    if ((rampup_time > 0) || (measurement_time > 0)) {
        timed = true;
    }
    if (JBButil.getLog().isLoggable(Level.FINEST)) {
        JBButil.getLog().finest("Benchmark " + JBBmain.Version + ": warehouse " + warehouseId);
    }
    while (this.getrunMode() != Company.runModes.STOP) {
        if ((!timed) && (this.getrunMode() == Company.runModes.DEFAULT_MODE)) {
            manualSelection();
            txntype = (new Integer(readUserValue()).intValue()) - 1;
        } else {
            txntype = deck[i];
            i++;
            if (i == 33) {
                deck = buildDeck();
                i = 0;
            }
        }
        txntime = goManual(txntype, myTimerData);
        if (this.getrunMode() == Company.runModes.RECORDING) myTimerData.updateTimerData(txntype, txntime);
        if (timed) {
            if ((this.getrunMode() == Company.runModes.RAMP_DOWN) && (!signaled_done)) {
                synchronized (company.threadsDoneCountMonitor) {
                    company.threadsDoneCount++;
                    company.threadsDoneCountMonitor.notify();
                    signaled_done = true;
                }
            }
        } else {
            if (txntype == pgm_exit) {
                break;
            }
        }
    }
    if (timed && (this.getrunMode() == Company.runModes.STOP)) {
        elapsed_time = company.getElapsedTime();
        myTimerData.calculateResponseTimeStats();
        double tpmc = myTimerData.updateTPMC(elapsed_time);
        double btps = myTimerData.updateBTPS(elapsed_time);
        long totalTransactions = 0;
        for (txntype = 0; txntype < maxTxnTypes; txntype++) {
            warehouseTimerDataPtr.rollupTimerData(txntype, myTimerData.getTransactionCount(txntype), myTimerData.getTotalTime(txntype), myTimerData.getTotalTimeSquare(txntype), myTimerData.getMinimumTime(txntype), myTimerData.getMaximumTime(txntype));
            company.getTimerDataPtr(co).rollupTimerData(txntype, myTimerData.getTransactionCount(txntype), myTimerData.getTotalTime(txntype), myTimerData.getTotalTimeSquare(txntype), myTimerData.getMinimumTime(txntype), myTimerData.getMaximumTime(txntype));
            totalTransactions += myTimerData.getTransactionCount(txntype);
        }
        company.getTimerDataPtr(co).accumulateTransactionStats(totalTransactions);
        warehouseTimerDataPtr.updateTPMC(tpmc);
        warehouseTimerDataPtr.updateBTPS(btps);
        company.getTimerDataPtr(co).updateTPMC(tpmc);
        company.getTimerDataPtr(co).updateBTPS(btps);
        synchronized (company.stopThreadsCountMonitor) {
            company.stopThreadsCount++;
            company.stopThreadsCountMonitor.notify();
        }
    }
}