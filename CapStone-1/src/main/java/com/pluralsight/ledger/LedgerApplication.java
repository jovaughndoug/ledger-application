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




    public LedgerApplication() throws IOException {
    }

    public static void main(String[] args) throws IOException {
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
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("d")) {
                addDeposit(scanner);
            }

            if (choice.equalsIgnoreCase("P")) {
                System.out.println("come on ");

            }
            if (choice.equalsIgnoreCase("L")) {
                ledgerscreen(scanner);

            }
            if (choice.equalsIgnoreCase("x")) {
                System.out.println("The Program is now closing");
                looper = false;
            }
            else {
                    System.out.println("Sorry Invalid Response, Please Try again\n ");


                }


            }

        }

    public static void ledgerscreen(Scanner scanner) throws IOException {
        FileReader fileReader = new FileReader("./src/main/resources/transaction.csv");
        BufferedReader bufferedReader= new BufferedReader(fileReader);
        String buff = bufferedReader.readLine();
        int counter = 0;
        System.out.println("""
                A) All-Display all entries
                D) Deposits
                P) Payments
                R) Reports
                Please Select a Letter:
                
                """);
        String ledgeranswer = scanner.nextLine();
        switch (ledgeranswer){
            case "a" :
                while ((buff = bufferedReader.readLine()) != null) {
                    String [] dataParts = buff.split("\\|");
                    Transaction transaction = new Transaction((LocalDate.parse(dataParts[0])),(LocalTime.parse(dataParts[1])) ,(dataParts[2]),(dataParts[3]),Double.parseDouble(dataParts[4]));
                    System.out.println(transaction);



                }


        }


    }
//Method To Add Deposit//
    public static void addDeposit(Scanner scanner ) {
        System.out.println(" How much Would you Like to Deposit");
        double  depositamount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println(" Who is this Deposit Coming From: ");
        String depositvendor = scanner.nextLine();
        System.out.println(" Transaction Deposit ");
        String depositdescription = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.now();
        Transaction t = new Transaction(dateTime.toLocalDate(),dateTime.toLocalTime(), depositdescription, depositvendor,depositamount);



        LocalDateTime dt = LocalDateTime.now();



    }
    }



