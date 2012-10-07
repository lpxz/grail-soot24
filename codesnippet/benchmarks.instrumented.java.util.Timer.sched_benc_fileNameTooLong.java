/**
     * Terminates this timer, discarding any currently scheduled tasks.
     * Does not interfere with a currently executing task (if it exists).
     * Once a timer has been terminated, its execution thread terminates
     * gracefully, and no more tasks may be scheduled on it.
     *
     * <p>Note that calling this method from within the run method of a
     * timer task that was invoked by this timer absolutely guarantees that
     * the ongoing task execution is the last task execution that will ever
     * be performed by this timer.
     *
     * <p>This method may be called repeatedly; the second and subsequent 
     * calls have no effect.
     */
public void cancel() {
    synchronized (queue) {
        thread.newTasksMayBeScheduled = false;
        queue.clear();
        queue.notify();
    }
}/**
     * Schedule the specifed timer task for execution at the specified
     * time with the specified period, in milliseconds.  If period is
     * positive, the task is scheduled for repeated execution; if period is
     * zero, the task is scheduled for one-time execution. Time is specified
     * in Date.getTime() format.  This method checks timer state, task state,
     * and initial execution time, but not period.
     *
     * @throws IllegalArgumentException if <tt>time()</tt> is negative.
     * @throws IllegalStateException if task was already scheduled or
     *         cancelled, timer was cancelled, or timer thread terminated.
     */
private void sched(TimerTask task, long time, long period) {
    if (time < 0) throw new IllegalArgumentException("Illegal execution time.");
    synchronized (queue) {
        if (!thread.newTasksMayBeScheduled) throw new IllegalStateException("Timer already cancelled.");
        synchronized (task.lock) {
            if (task.state != TimerTask.VIRGIN) throw new IllegalStateException("Task already scheduled or cancelled");
            task.nextExecutionTime = time;
            task.period = period;
            task.state = TimerTask.SCHEDULED;
        }
        queue.add(task);
        if (queue.getMin() == task) queue.notify();
    }
}/**
     * Schedule the specifed timer task for execution at the specified
     * time with the specified period, in milliseconds.  If period is
     * positive, the task is scheduled for repeated execution; if period is
     * zero, the task is scheduled for one-time execution. Time is specified
     * in Date.getTime() format.  This method checks timer state, task state,
     * and initial execution time, but not period.
     *
     * @throws IllegalArgumentException if <tt>time()</tt> is negative.
     * @throws IllegalStateException if task was already scheduled or
     *         cancelled, timer was cancelled, or timer thread terminated.
     */
private void sched(TimerTask task, long time, long period) {
    if (time < 0) throw new IllegalArgumentException("Illegal execution time.");
    synchronized (queue) {
        if (!thread.newTasksMayBeScheduled) throw new IllegalStateException("Timer already cancelled.");
        synchronized (task.lock) {
            if (task.state != TimerTask.VIRGIN) throw new IllegalStateException("Task already scheduled or cancelled");
            task.nextExecutionTime = time;
            task.period = period;
            task.state = TimerTask.SCHEDULED;
        }
        queue.add(task);
        if (queue.getMin() == task) queue.notify();
    }
}/**
     * The main timer loop.  (See class comment.)
     */
private void mainLoop() {
    while (true) {
        try {
            TimerTask task;
            boolean taskFired;
            synchronized (queue) {
                while (queue.isEmpty() && newTasksMayBeScheduled) queue.wait();
                if (queue.isEmpty()) break;
                long currentTime, executionTime;
                task = queue.getMin();
                synchronized (task.lock) {
                    if (task.state == TimerTask.CANCELLED) {
                        queue.removeMin();
                        continue;
                    }
                    currentTime = System.currentTimeMillis();
                    executionTime = task.nextExecutionTime;
                    if (taskFired = (executionTime <= currentTime)) {
                        if (task.period == 0) {
                            queue.removeMin();
                            task.state = TimerTask.EXECUTED;
                        } else {
                            queue.rescheduleMin(task.period < 0 ? currentTime - task.period : executionTime + task.period);
                        }
                    }
                }
                if (!taskFired) queue.wait(executionTime - currentTime);
            }
            if (taskFired) task.run();
        } catch (InterruptedException e) {
        }
    }
}/**
     * The main timer loop.  (See class comment.)
     */
private void mainLoop() {
    while (true) {
        try {
            TimerTask task;
            boolean taskFired;
            synchronized (queue) {
                while (queue.isEmpty() && newTasksMayBeScheduled) queue.wait();
                if (queue.isEmpty()) break;
                long currentTime, executionTime;
                task = queue.getMin();
                synchronized (task.lock) {
                    if (task.state == TimerTask.CANCELLED) {
                        queue.removeMin();
                        continue;
                    }
                    currentTime = System.currentTimeMillis();
                    executionTime = task.nextExecutionTime;
                    if (taskFired = (executionTime <= currentTime)) {
                        if (task.period == 0) {
                            queue.removeMin();
                            task.state = TimerTask.EXECUTED;
                        } else {
                            queue.rescheduleMin(task.period < 0 ? currentTime - task.period : executionTime + task.period);
                        }
                    }
                }
                if (!taskFired) queue.wait(executionTime - currentTime);
            }
            if (taskFired) task.run();
        } catch (InterruptedException e) {
        }
    }
}public void run() {
    try {
        mainLoop();
    } finally {
        synchronized (queue) {
            newTasksMayBeScheduled = false;
            queue.clear();
        }
    }
}