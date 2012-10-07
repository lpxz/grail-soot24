public synchronized void display(PrintStream out) {
    synchronized (out) {
        if (Transaction.enableLogWrite) queuedLog.display(out);
    }
    ;
}