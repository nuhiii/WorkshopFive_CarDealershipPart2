package com.ps;

public class LeaseContract extends Contract{
    private double expectedEndingValue;
    private double leaseFee;
    private double totalPrice;
    private double monthlyPayment;

    // Constructor
    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice() * 0.50;
        this.leaseFee = vehicleSold.getPrice() * 0.07;
    }

    // Getters and Setters
    public double getExpectedEndingValue() {
        return  expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    // Override Methods
    @Override
    public double getTotalPrice() {
        return expectedEndingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        return (getTotalPrice() * (0.04 / 12)) / (1 - Math.pow(1 + (0.04 / 12), -36));
    }
}
