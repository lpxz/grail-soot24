protected void beforeRead() {
    synchronized (waitingReaderMonitor_) {
        synchronized (this) {
            if (allowReader()) {
                ++activeReaders_;
                return;
            } else ++waitingReaders_;
        }
        try {
            waitingReaderMonitor_.wait();
        } catch (InterruptedException ex) {
        }
    }
}protected void beforeRead() {
    synchronized (waitingReaderMonitor_) {
        synchronized (this) {
            if (allowReader()) {
                ++activeReaders_;
                return;
            } else ++waitingReaders_;
        }
        try {
            waitingReaderMonitor_.wait();
        } catch (InterruptedException ex) {
        }
    }
}protected synchronized void notifyReaders() {
    synchronized (waitingReaderMonitor_) {
        waitingReaderMonitor_.notifyAll();
    }
    activeReaders_ = waitingReaders_;
    waitingReaders_ = 0;
}protected void beforeWrite() {
    Object monitor = new Object();
    synchronized (monitor) {
        synchronized (this) {
            if (allowWriter()) {
                ++activeWriters_;
                return;
            }
            waitingWriterMonitors_.addElement(monitor);
        }
        try {
            monitor.wait();
        } catch (InterruptedException ex) {
        }
    }
}protected void beforeWrite() {
    Object monitor = new Object();
    synchronized (monitor) {
        synchronized (this) {
            if (allowWriter()) {
                ++activeWriters_;
                return;
            }
            waitingWriterMonitors_.addElement(monitor);
        }
        try {
            monitor.wait();
        } catch (InterruptedException ex) {
        }
    }
}protected synchronized void notifyWriter() {
    if (waitingWriterMonitors_.size() > 0) {
        Object oldest = waitingWriterMonitors_.firstElement();
        waitingWriterMonitors_.removeElementAt(0);
        synchronized (oldest) {
            oldest.notify();
        }
        ++activeWriters_;
    }
}