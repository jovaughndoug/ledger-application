package com.pluralsight.ledger;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private LocalDate date;
    private LocalTime time;
    private String vendor;
    private String description;
    private Double amount;

    public String writeTofile() {
        return
                date +
                "|" + time +
                "|" + vendor +
                "|" + description +
                "|" + amount;
    }

    @Override
    public String toString() {
        return "Transaction" +
                " Date:  " + date +
                " Time:  " + time +
                " Vendor:  '" + vendor + '\'' +
                " Description:  '" + description + '\'' +
                " Amount:$ " + amount;
    }

    public Transaction(LocalDate date, LocalTime time, String vendor, String description, Double amount) {
        this.date = date;
        this.time = time;
        this.vendor = vendor;
        this.description = description;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getVendor() {
        return vendor;
    }

    public String getDescription() {
        return description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

