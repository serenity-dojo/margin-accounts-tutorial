package com.serenitydojo.serenitybank.domain;

public class MarginTransaction {
    private final String security;
    private final BuySell buySell;
    private final Double numberOfShares;
    private final Double cashAmount;
    private final Double marginLoan;

    public MarginTransaction(String security, BuySell buySell, Double numberOfShares, Double cashAmount, Double marginLoan) {
        this.security = security;
        this.buySell = buySell;
        this.numberOfShares = numberOfShares;
        this.cashAmount = cashAmount;
        this.marginLoan = marginLoan;
    }

    public String getSecurity() {
        return security;
    }

    public BuySell getBuySell() {
        return buySell;
    }

    public Double getNumberOfShares() {
        return numberOfShares;
    }

    public Double getCashAmount() {
        return cashAmount;
    }

    public Double getMarginLoan() {
        return marginLoan;
    }
}
