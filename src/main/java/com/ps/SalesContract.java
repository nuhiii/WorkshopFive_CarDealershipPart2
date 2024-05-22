package com.ps;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean isFinanced;
    private double totalPrice;
    private double monthlyPayment;

    // Constructor
    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = 0.05;
        this.recordingFee = 100;
        if (vehicleSold.getPrice() < 10000) {
            this.processingFee = 295;
        }
        else {
            this.processingFee = 495;
        }
        this.isFinanced = isFinanced;
    }

    // Getters and Setters
    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean getIsFinanced() {
        return isFinanced;
    }

    public void setIsFinanced(boolean financed) {
        isFinanced = financed;
    }

    // Override Methods
    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
