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
        this.salesTaxAmount = vehicleSold.getPrice() * 0.05;
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
        return getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if(isFinanced){
            if(getVehicleSold().getPrice() >= 10000){
                return (getVehicleSold().getPrice() * 0.0425) / (1 - Math.pow(1 + (0.0425 / 12), -48));
            }
            else{
                return (getVehicleSold().getPrice() * 0.0525) / (1 - Math.pow(1 + (0.0525 / 12), -24));
            }
        }
        else{
            return 0;
        }
    }
}
