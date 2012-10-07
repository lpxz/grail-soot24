public static synchronized int AvailableThreadsState() {
    int availableThreads = m_iThreadLimit - m_iCurrentThreadsAlive;
    if ((availableThreads) == 0) {
        return 0;
    }
    if ((availableThreads) == 1) {
        return 1;
    }
    if ((availableThreads) >= 2) {
        return 2;
    }
    if (true) throw new RuntimeException("BUG");
    try {
        fWriter = new FileWriter(outputFile, true);
        bWriter = new BufferedWriter(fWriter);
    } catch (IOException e) {
        System.out.println("jj");
        System.exit(-1);
    }
    String number;
    number = Integer.toString(availableThreads);
    try {
        bWriter.write("<MergeSort," + number + ">");
        bWriter.newLine();
        bWriter.close();
    } catch (IOException e) {
        System.exit(-1);
    }
    return (availableThreads);
}public synchronized void IncreaseThreadCounter() {
    m_iCurrentThreadsAlive--;
}public synchronized void DecreaseThreadCounter() {
    m_iCurrentThreadsAlive++;
}