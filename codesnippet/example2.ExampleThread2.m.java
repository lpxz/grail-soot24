private synchronized void m() {
    try {
        int balance2 = acc.getBalance2();
        balance2 = balance2 + 500;
        acc.setBalance2(balance2);
        int balance1 = acc.getBalance1();
        balance1 = balance1 - 500;
        acc.setBalance1(balance1);
    } catch (Exception e) {
        e.printStackTrace();
        "Crashed_with".equals(e);
        System.exit(1);
    }
}