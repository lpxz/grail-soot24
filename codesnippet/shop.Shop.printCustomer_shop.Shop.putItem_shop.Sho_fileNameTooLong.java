public synchronized void putItem() {
    items++;
    storage[items] = 1;
}public synchronized boolean isEmpty() {
    boolean empty;
    if (items == -1) empty = true; else empty = false;
    return empty;
}public synchronized void getItem() {
    storage[items] = 0;
    items--;
}public synchronized void printCustomer(String S, DataOutputStream out) throws IOException {
    out.writeBytes(S);
    return;
}