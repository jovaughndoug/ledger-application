package com.pluralsight.ledger;


import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerApplication {

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
                    ================================================
                    ================================================
                    :) ;)  Welcome to JO'S Accounting Ledger (; (:
                    ================================================
                    ================================================                             
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
                addPaymentIn(scanner);


            } else if (choice.equalsIgnoreCase("L")) {
                ledgerscreen(scanner);

            } else if (choice.equalsIgnoreCase("x")) {
                System.out.println("The Program is now closing");
                looper = false;
                return;
            } else {
                System.out.println("Sorry Invalid Response, Please Try again\n ");


            }


        }

    }

    public static void ledgerscreen(Scanner scanner) throws IOException {
        boolean ledgeLoop = true;
        while (ledgeLoop) {


            System.out.println("""
                    ===============================
                    A) All-Display all entries
                    D) Deposits
                    P) Payments
                    R) Reports
                    H) Return To Home Screen
                    Please Select a Letter:
                     ==============================               
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
                        if (d.getAmount() > 0) {
                            System.out.println(d);
                        }

                    }
                    break;
                case "p":
                    for (Transaction p : alltransactions) {
                        if (p.getAmount() < 0) {
                            System.out.println(p);

                        }


                    }
                    break;
                case "r":
                    reportsScreen(scanner);
                    break;
                case "h":
                    ui(scanner);
                    break;
                default:
                    System.out.println("Sorry Invalid Response Try Again!!");

            }
        }


    }


    //Method To Add Deposit//
    public static void addDeposit(Scanner scanner) throws IOException {
        FileWriter fileWriter = new FileWriter("./src/main/resources/transaction.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        System.out.println(" How much Would you Like to Deposit? ");
        double depositamount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println(" Who is this Deposit Coming From?  ");
        String depositvendor = scanner.nextLine();
        System.out.println(" Transaction Description? ");
        String depositdescription = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String newDateFormat = dateTime.format(dtf);
        Transaction ad = new Transaction(dateTime.toLocalDate(),LocalTime.parse(newDateFormat), depositdescription, depositvendor, depositamount);
        alltransactions.add(0, ad);
        bufferedWriter.write(ad.writeTofile() + "\n");
        bufferedWriter.close();
        System.out.println(" Your deposit has been recorded successfully ");


        //LocalDateTime dt = LocalDateTime.now();


    }

    public static void addPaymentIn(Scanner scanner) throws IOException {
        FileWriter fileWriter = new FileWriter("./src/main/resources/transaction.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        System.out.println(" How much was your payment? (Enter a Negative Number Please ex. -100.35) ");
        double paymentamount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println(" Who did you make this payment to?  ");
        String paymentvendor = scanner.nextLine();
        System.out.println(" Payment Description( What did you Purchase)? ");
        String paymentdescription = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String newDateFormat = dateTime.format(dtf);
        Transaction pi = new Transaction(dateTime.toLocalDate(),LocalTime.parse(newDateFormat), paymentvendor, paymentdescription, paymentamount);
        alltransactions.add(0, pi);
        bufferedWriter.write(pi.writeTofile() + "\n");
        bufferedWriter.close();
        System.out.println(" Your Payment has been added successfully ");
        return;


    }

    public static void reportsScreen(Scanner scanner) throws IOException {
        boolean reportLooper = true;
        while (reportLooper) {
            System.out.println("""
                    ====================
                    ====================
                    Welcome to Reports
                    =====================
                    =====================
                    1) Month to Date
                    2) Previous Month
                    3)Year to Date
                    4)Previous Year
                    5)Search by Vendor
                    0) Back to the ledger
                    """);
            String reportAnswer = scanner.nextLine();

            switch (reportAnswer) {
                case "1":
                    for (Transaction mtd : alltransactions) {
                        if (mtd.getDate().getMonth().equals(LocalDate.now().getMonth())) {
                            System.out.println(mtd.toString());

                        }

                    }
                    break;
                case "2":
                    for (Transaction previousMonth : alltransactions) {
                        LocalDate firstofLastMonth = calculateFirstofLastMonth().minusDays(1);
                        LocalDate lastofLastMonth = calculateLastofLastMonth().plusDays(1);

                        LocalDate transactionDate = previousMonth.getDate();

                        if (transactionDate.isAfter(firstofLastMonth) && transactionDate.isBefore(lastofLastMonth)) {

                            System.out.println(previousMonth);
                        }


                    }
                    break;

                case "3":
                    for (Transaction ytd : alltransactions) {
                        if (ytd.getDate().getYear() == LocalDate.now().getYear()) {
                            System.out.println("\n" + ytd.toString());
                        }
                    }
                    break;
                case "4":
                    for (Transaction previousyear : alltransactions) {
                        if (previousyear.getDate().getYear() == (LocalDate.now().getYear()) - 1) {
                            System.out.println("\n" + previousyear.toString());
                        }
                    }
                    break;
                case "5":
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println(" What is the vendor you would like to search for? ");
                    String reportSearch = scanner1.nextLine();
                    for (Transaction vSearch : alltransactions) {
                        if (vSearch.getVendor().equalsIgnoreCase(reportSearch)) {
                            System.out.println(vSearch);
                        }
                    }
                    break;
                case "0": {
                    ui(scanner);
                }
                    break;
                default:
                    System.out.println("sorry Invalid Response");





            }
        }
    }

    private static LocalDate calculateFirstofLastMonth() {
        LocalDate today = LocalDate.now();
        LocalDate lastMonth = today.minusMonths(1);
        LocalDate firstofLastMonth = LocalDate.of(lastMonth.getYear(), lastMonth.getMonth(), 1);
        return firstofLastMonth;

    }

    private static LocalDate calculateLastofLastMonth() {
        LocalDate today = LocalDate.now();
        LocalDate lastMonth = today.minusMonths(1);
        int lastDayofLastMonth = lastMonth.getMonth().length(false);
        LocalDate lastofLastMonth = LocalDate.of((lastMonth.getYear()), lastMonth.getMonth(), lastDayofLastMonth);
        return lastofLastMonth;

    }
}



