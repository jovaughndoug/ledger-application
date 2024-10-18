# Ledger Application
Description:
This application is an accounting ledger.
It allows users to read transactions from a csv file
and view the data in various ways. Also allows user to add transactions to file.

## Features
1. Add Deposits
2. Make Payments
3. Display All Transactions
4. Display Payments
5. Display Deposits
6. Display Reports
* Allows user to sort through the transactions in different ways


# Project Structure
* src/main/resources/
* src/main/java/com/pluralsight/ledger
* LedgerApplication.java
* Transaction.java: Defines a transaction.
* transaction.csv: CSV File that data is read from and written to.
* FileIO.java: Controls writing to and reading from the CSV file.

# New Lessons
## Creating Filters For Data
The reportScreen method has a switch case screen that 
allows the user to search though the CSV file with 
different filters. Each of the different cases manipulates the
data to only show whatever option the user chooses
## LocalDate & LocalTime Class
The LocalDate & LocalTime classes was a pivotal part of this program
These classes can be used as a data type for dates and times.
You can then use these to manipulate data in certain ways that focus dates and times.
### Other lessons Learned
* Switch case: Can use these as a sort of condensed if else statement. Allows for cleaner code.
* BufferedWriter: Allows data to be directly written to file of choosing.
* Array Lists: Allows data to be grouped together by certain parameters without a set size for the array.
* ToString: Method that allows for data to be written as a string in the way I choose.
* Search: Compared the string written by user to see what matches in file.


# What I would Improve
I feel I can improve tremendously.
My code does everything that I want it to
but, it could be much cleaner. Also, continuous testing to see if there is any unforeseen bugs
that may need fixing. Also implementing new terms and way of simplifying things that I made complicated.
One more thing I noticed I need to learn to get started better. Once I'm in the
process I get in my "groove".

Making my application more visually pleasing is a goal of mine.
Whether it be adding color to the prompts, or just a more seamless interface
for the user.


