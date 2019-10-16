package com.tws.refactoring.extract_method;

import java.util.List;

public class OwingPrinter {
    public void printOwing(String name, List<Order> orders) {
        Double totalAmount = calculateAmount(orders);
        calculateAmount(orders);
        System.out.print(renderReceipt(name, totalAmount));
    }

    private Double calculateAmount(List<Order> orders) {
        return orders.stream().mapToDouble(Order::getAmount).sum();
    }

    private String renderReceipt(String name, Double totalAmount) {
        StringBuilder receiptText = new StringBuilder();
        receiptText
                .append("*****************************\n")
                .append("****** Customer totals ******\n")
                .append("*****************************\n")
                .append("name: ").append(name).append(" \n")
                .append("amount: ").append(totalAmount).append(" \n");
        return receiptText.toString();
    }
}
