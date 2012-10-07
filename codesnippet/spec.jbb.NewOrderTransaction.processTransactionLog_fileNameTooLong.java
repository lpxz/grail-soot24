public synchronized void processTransactionLog() {
    JBButil.getLog().entering("spec.jbb.NewOrderTransaction", "processTransactionLog");
    orderLog.clearBuffer();
    xmlOrderLog.clear();
    setupOrderLog();
    Date screenDate = thisOrder.getEntryTime();
    orderLog.putInt(districtId, 28, 1, 2);
    orderLog.putDate(screenDate, 60, 1, 10);
    orderLog.putTime(screenDate, 71, 1, 8);
    orderLog.putInt(customerId, 11, 2, 4);
    orderLog.putText(customerLastName, 24, 2, 16);
    orderLog.putText(customerCreditStatus, 51, 2, 2);
    orderLog.putDouble(customerDiscountRate.movePointRight(2).toString(), 63, 2, 5);
    orderLog.putInt(orderId, 14, 3, 8);
    orderLog.putInt(orderline_count, 41, 3, 2);
    orderLog.putDouble(warehouseTaxRate.movePointRight(2).toString(), 58, 3, 5);
    orderLog.putDouble(districtTaxRate.movePointRight(2).toString(), 73, 3, 5);
    if (orderline_count > 0) {
        Orderline[] orderlineList;
        int lineCount, i;
        orderlineList = thisOrder.getOrderlineList();
        lineCount = thisOrder.getOrderlineCount();
        Orderline currentOrderLine;
        for (i = 0; i < lineCount; i++) {
            int displayLine = i + 6;
            if (i >= 15) displayLine = 14 + 6;
            currentOrderLine = (Orderline) orderlineList[i];
            orderLog.putInt(currentOrderLine.getSupplyWarehouse(), 2, displayLine, 4);
            orderLog.putInt(currentOrderLine.getItemId(), 9, displayLine, 6);
            orderLog.putText(currentOrderLine.getItemName(), 18, displayLine, 24);
            orderLog.putInt(currentOrderLine.getQuantity(), 44, displayLine, 2);
            orderLog.putInt(currentOrderLine.getStockQuantity(), 50, displayLine, 3);
            orderLog.putChar(currentOrderLine.getBrandGeneric(), 57, displayLine);
            orderLog.putDollars(currentOrderLine.getItemPrice(), 62, displayLine, 7);
            orderLog.putDollars(currentOrderLine.getAmount(), 71, displayLine, 8);
        }
    }
    if (orderline_count > 0) {
        orderLog.putText("---- Order is valid ----", 18, 21, 24);
        orderLog.putDollars(thisOrder.getTotalAmount(), 70, 21, 9);
    } else {
        orderLog.putText("ITEM NUMBER IS NOT VALID", 18, 21, 24);
        orderLog.putDollars(0.0, 69, 21, 9);
    }
    xmlOrderLog.populateXML(orderLog);
    if (Transaction.enableLogWrite) orderLog.display();
    if (Transaction.validationFlag) {
        String[] s = orderLog.validate();
        if (s.length != validationLog.length) {
            StringBuffer sb = new StringBuffer(200);
            sb.append("VALIDATION ERROR:  mismatch in screen lengths for NewOrderTransaction");
            sb.append(System.getProperty("line.separator"));
            sb.append("    Screen length should be:  " + validationLog.length);
            sb.append(System.getProperty("line.separator"));
            sb.append("    Screen length is:  " + s.length);
            JBButil.getLog().warning(sb.toString());
            Transaction.invalidateRun();
        }
        for (int i = 0; i < validationLog.length; i++) {
            if (checkLine[i]) {
                if (!s[i].equals(validationLog[i])) {
                    StringBuffer sb = new StringBuffer(200);
                    sb.append("VALIDATION ERROR:  incorrect output for NewOrderTransaction");
                    sb.append(System.getProperty("line.separator"));
                    sb.append("    Line " + (i + 1) + " should be:  |" + validationLog[i] + "|");
                    sb.append(System.getProperty("line.separator"));
                    sb.append("    Line " + (i + 1) + " is:  |" + s[i] + "|");
                    JBButil.getLog().warning(sb.toString());
                    Transaction.invalidateRun();
                }
            }
        }
    }
    JBButil.getLog().exiting("spec.jbb.NewOrderTransaction", "processTransactionLog");
}