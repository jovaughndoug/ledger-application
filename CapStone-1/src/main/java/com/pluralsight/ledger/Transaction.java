package com.pluralsight.ledger;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private LocalDate date;
    private LocalTime time;
    private String vendor;
    private String description;
    private Double amount;

    @Override
    public String toString() {
        return "Transaction" +
                "date=" + date +
                ", time=" + time +
                ", vendor='" + vendor + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
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
}

