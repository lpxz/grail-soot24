public void run() {
    yield();
    System.out.println("Costumer " + id + " invoked");
    buy();
    Integer I;
    I = new Integer(id);
    String idStr = I.toString();
    I = new Integer(purchasedItems);
    String purchasedItemsStr = I.toString();
    String dataStr = "   costumer  " + idStr + ": " + purchasedItemsStr;
    try {
        my_shop.printCustomer(dataStr, out);
    } catch (IOException e) {
        System.out.println(e.toString());
    }
    int i = 0;
    if (purchasedItems == -1) i = 2; else if (purchasedItems < 10) i = 1;
    synchronized (lock) {
        if (i != 0) if (S.get() != 2) S.set(i);
    }
    return;
}