package com.tws.refactoring.extract_method;

public class Order {
    private final Double amount;

    public Order(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }
}
