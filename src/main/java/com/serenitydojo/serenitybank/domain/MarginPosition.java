package com.serenitydojo.serenitybank.domain;

public class MarginPosition {

    private final String security;
    private final BuySell buySell;
    private final Double numberOfShares;
    private final Double initialPrice;
    private final Double cashAmount;
    private final Double marginLoan;
    private final Double initialValue;

    public MarginPosition(String security, BuySell buySell, Double numberOfShares, Double initialPrice, Double cashAmount, Double marginLoan, Double initialValue, Double initialMargin) {
        this.security = security;
        this.buySell = buySell;
        this.numberOfShares = numberOfShares;
        this.initialPrice = initialPrice;
        this.cashAmount = cashAmount;
        this.marginLoan = marginLoan;
        this.initialValue = initialValue;
        this.initialMargin = initialMargin;
    }

    private final Double initialMargin;

    public String getSecurity() {
        return security;
    }

    public Double getNumberOfShares() {
        return numberOfShares;
    }

    public Double getInitialValue() {
        return initialValue;
    }

    public Double getInitialMargin() {
        return initialMargin;
    }
}
