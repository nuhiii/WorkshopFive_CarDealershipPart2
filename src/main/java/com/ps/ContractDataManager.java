package com.ps;

import java.io.*;

public class ContractDataManager {

    public void saveContract(Contract contract){
        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("DB_Contract.csv", true));
            if (contract instanceof SalesContract salesContract){
                bufWriter.write(String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f\n",
                        salesContract.getDate(),
                        salesContract.getCustomerName(),
                        salesContract.getCustomerEmail(),
                        salesContract.getVehicleSold().getVin(),
                        salesContract.getVehicleSold().getYear(),
                        salesContract.getVehicleSold().getMake(),
                        salesContract.getVehicleSold().getModel(),
                        salesContract.getVehicleSold().getVehicleType(),
                        salesContract.getVehicleSold().getColor(),
                        salesContract.getVehicleSold().getOdometer(),
                        salesContract.getVehicleSold().getPrice(),
                        salesContract.getSalesTaxAmount(),
                        salesContract.getRecordingFee(),
                        salesContract.getProcessingFee(),
                        salesContract.getTotalPrice(),
                        salesContract.getIsFinanced() ? "YES" : "NO",
                        salesContract.getMonthlyPayment()));
            } else if (contract instanceof LeaseContract leaseContract){
                bufWriter.write(String.format("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f\n",
                        leaseContract.getDate(),
                        leaseContract.getCustomerName(),
                        leaseContract.getCustomerEmail(),
                        leaseContract.getVehicleSold().getVin(),
                        leaseContract.getVehicleSold().getYear(),
                        leaseContract.getVehicleSold().getMake(),
                        leaseContract.getVehicleSold().getModel(),
                        leaseContract.getVehicleSold().getVehicleType(),
                        leaseContract.getVehicleSold().getColor(),
                        leaseContract.getVehicleSold().getOdometer(),
                        leaseContract.getVehicleSold().getPrice(),
                        leaseContract.getExpectedEndingValue(),
                        leaseContract.getLeaseFee(),
                        leaseContract.getTotalPrice(),
                        leaseContract.getMonthlyPayment()));
            }
            bufWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
