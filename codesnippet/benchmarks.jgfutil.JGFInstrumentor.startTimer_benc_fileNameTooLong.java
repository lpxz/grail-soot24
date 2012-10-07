public static synchronized void startTimer(String name) {
    if (timers.containsKey(name)) {
        ((JGFTimer) timers.get(name)).start();
    } else {
        System.out.println("JGFInstrumentor.startTimer: failed -  timer " + name + " does not exist");
    }
}public static synchronized void stopTimer(String name) {
    if (timers.containsKey(name)) {
        ((JGFTimer) timers.get(name)).stop();
    } else {
        System.out.println("JGFInstrumentor.stopTimer: failed -  timer " + name + " does not exist");
    }
}