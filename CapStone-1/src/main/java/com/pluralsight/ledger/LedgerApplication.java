package com.pluralsight.ledger;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerApplication {

    FileWriter fileWriter = new FileWriter("./src/main/resources/transaction.csv");
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    static ArrayList<Transaction> alltransactions = new ArrayList<>();
    static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("./src/main/resources/transaction.csv");
        bufferedReader = new BufferedReader(fileReader);
        String buff = bufferedReader.readLine();
        while ((buff = bufferedReader.readLine()) != null) {
            String[] dataParts = buff.split("\\|");
            Transaction transaction = new Transaction((LocalDate.parse(dataParts[0])), (LocalTime.parse(dataParts[1])), (dataParts[2]), (dataParts[3]), Double.parseDouble(dataParts[4]));
            alltransactions.add(transaction);
        }

        Scanner scanner = new Scanner(System.in);
        ui(scanner);


    }


    public LedgerApplication() throws IOException {
    }

    public static void ui(Scanner scanner) throws IOException {
        boolean looper = true;
        while (looper) {
            System.out.println("""
                    ++++++++++++++++++++++++++++++++++++++++++++++++
                    ++++++++++++++++++++++++++++++++++++++++++++++++
                    :) ;)  Welcome to JO'S Accounting Ledger (; (:
                    ++++++++++++++++++++++++++++++++++++++++++++++++
                    ++++++++++++++++++++++++++++++++++++++++++++++++
                                    
                                Please Select a letter
                                D) Add Deposit
                                P) Make Payment(Debit)
                                L) Ledger
                                X) Exit
                    """);

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("d")) {
                addDeposit(scanner);
            } else if (choice.equalsIgnoreCase("P")) {
                System.out.println("come on ");

            } else if (choice.equalsIgnoreCase("L")) {
                ledgerscreen(scanner);

            } else if (choice.equalsIgnoreCase("x")) {
                System.out.println("The Program is now closing");
                looper = false;
            } else {
                System.out.println("Sorry Invalid Response, Please Try again\n ");


            }


        }

    }

    public static void ledgerscreen(Scanner scanner) throws IOException {
        boolean ledgeLoop = true;
        while (ledgeLoop) {


            System.out.println("""
                    A) All-Display all entries
                    D) Deposits
                    P) Payments
                    R) Reports
                    H) Return To Home Screen
                    Please Select a Letter:
                                    
                    """);


            String ledgeranswer = scanner.nextLine().toLowerCase();
            switch (ledgeranswer) {
                case "a":
                    for (Transaction a : alltransactions) {
                        System.out.println(a);
                    }
                    break;

                case "d":
                    for (Transaction d : alltransactions) {
                        if (d.getAmount() < 0) {
                            System.out.println(d);
                        }
                    }
                case "p":
                    for (Transaction p : alltransactions) {
                        if (p.getAmount() > 0) {
                            System.out.println(p);

                        }


                    }
                case "r" :

                case "h":
                    ui(scanner);
                default:
                    System.out.println("Sorry Invalid Response Try Again!!");

            }
        }


    }


    //Method To Add Deposit//
    public static void addDeposit(Scanner scanner) {
        System.out.println(" How much Would you Like to Deposit");
        double depositamount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println(" Who is this Deposit Coming From: ");
        String depositvendor = scanner.nextLine();
        System.out.println(" Transaction Deposit ");
        String depositdescription = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.now();
        Transaction ad = new Transaction(dateTime.toLocalDate(), dateTime.toLocalTime(), depositdescription, depositvendor, depositamount);


        //LocalDateTime dt = LocalDateTime.now();


    }

    public static void addPaymentIn(Scanner scanner) {
        System.out.println(" How much Would you Like to Deposit");
        double paymentamount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println(" Who is this Deposit Coming From: ");
        String paymentvendor = scanner.nextLine();
        System.out.println(" Transaction Deposit ");
        String paymentdescription = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.now();
        Transaction pi = new Transaction(dateTime.toLocalDate(), dateTime.toLocalTime(), paymentdescription, paymentdescription, paymentamount);

    }

    public static void reportsScreen(Scanner scanner) {
        System.out.println("""
                
                """);

    }
}



