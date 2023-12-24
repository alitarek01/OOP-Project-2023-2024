package OOP_Project;

import java.time.LocalDateTime;  // import the LocalDate class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.ArrayList;
import java.util.Scanner;
    public class Account {
        int accountNumber;
        double balance;
        protected int choice;
        private static int counter = 10000;
        String accountType;

        public Loan accountLoan;
        Scanner type = new Scanner(System.in);


        //Constructor
        public Account(double balance, String accountType) {
            accountNumber = counter;
            ++counter;
            this.accountType = accountType;
            this.balance = balance;
        }


        public void updateBalance(double amount) {
            this.balance += amount;
        }

        public boolean checkSufficientBalance(double amount) {
            if (amount <= this.balance) {
                return true;
            } else {
                return false;
            }
        }

        public boolean equals(Object obj) {
            // Check if the objects are the same instance
            if (this == obj) {
                return true;
            }

            // Check if the object is null or of a different class
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Account other = (Account) obj;

            return accountNumber == other.accountNumber;
        }

        public void makeTransaction(int transactionType, ArrayList<transaction> AllTransaction, ArrayList<Client> clients) throws TransactionException {
            double transactionAmount;
            int recipientAccountNumber;
            LocalDateTime myDateObj = LocalDateTime.now();  // Create a date object
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            boolean addNote;
            String transactionNote;
            Account recipientAccount = null;
            boolean recipientFound = false;
            if (transactionType == 1) {

                System.out.println("enter the amount you want to deposit ");
                transactionAmount = type.nextDouble();
                AllTransaction.add(new transaction(accountNumber, this, formattedDate, transactionAmount, "Deposit", 0));

            } else if (transactionType == 2) {
                System.out.println("enter the amount you want to Withdraw ");
                transactionAmount = type.nextDouble();
                AllTransaction.add(new transaction(accountNumber, this, formattedDate, transactionAmount, "Withdraw", 0));
            } else if (transactionType == 3) {
                while (true) {
                    System.out.println("Enter the recipient Account number:");
                    recipientAccountNumber = type.nextInt();
                    for (int x = 0; x < clients.size(); x++) {
                        for (int z = 0; z < clients.get(x).myAccounts.size(); z++) {
                            if (clients.get(x).myAccounts.get(z).accountNumber == recipientAccountNumber) {
                                recipientAccount = clients.get(x).myAccounts.get(z);
                                recipientFound = true;
                                System.out.println("recipient found");
                                break;
                            }
                        }
                        if (recipientFound) {
                            break;
                        }
                    }
                    if (recipientFound) {

                        System.out.println("Enter the amount you want to Transfer ");
                        transactionAmount = type.nextDouble();


                        System.out.println("\nPress 1 if you want to add note");
                        if (type.nextInt() == 1) {
                            addNote = true;
                        } else {
                            addNote = false;
                        }

                        if (addNote) {
                            System.out.println("Write Note for the transaction:");
                            transactionNote = type.next();
                            try {
                                AllTransaction.add(new transaction(accountNumber, this, formattedDate, transactionAmount, "Transfer",
                                        transactionNote, recipientAccountNumber, recipientAccount, 0));
                            } catch (TransactionException exp) {
                                System.out.println(exp.getMessage());
                            }
                        } else {
                            try {
                                AllTransaction.add(new transaction(accountNumber, this, formattedDate, transactionAmount, "Transfer",
                                        "", recipientAccountNumber, recipientAccount, 0));
                            } catch (TransactionException exp) {
                                System.out.println(exp.getMessage());
                            }
                        }
                        break;
                    } else {
                        throw new TransactionException("recipient Account number not found");
                    }
                }
            }
        }

        public void takeLoan() {
            while (true) {
                System.out.print("Enter Loan Amount:");
                int loanAmount = type.nextInt();
                if (loanAmount >= 1000) {
                    while (true) {
                        System.out.print("Enter Loan Duration:");
                        int loanDuration = type.nextInt();
                        if (loanDuration <= 120 && loanDuration >= 0) {

                            accountLoan = new Loan(loanDuration, loanAmount);
                            balance = accountLoan.addLoanAmountToBalance(balance);
                            return;
                        } else {
                            System.out.println("wrong Input, try Again!");
                            continue;
                        }
                    }
                } else {
                    System.out.println("wrong Input, try Again!");
                    continue;
                }
            }
        }

        public void payInstallment() {
            System.out.println("This is you Loan Installments\n-----------------------");
            accountLoan.display_loan_history();
            System.out.println("Press 1 to pay installments");
            System.out.println("Press 0 to cancel\n\nChoice: ");
            if (type.nextInt() == 1) {
                for (int j = 0; j < accountLoan.loanDurationInMonths; j++) {
                    if (!accountLoan.installments.get(j).paid) {
                        balance = accountLoan.payInstallment(j + 1, balance);
                        break;

                    }
                }

            }
            else {return;}
        }


        public void DisplayInfo() {
            System.out.println("--------------------------------");
            System.out.println("Account Type: " + accountType);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
            System.out.println("--------------------------------");
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public static void setCounter(int index) {
            counter = index;
        }

        public static int getCounter() {
            return counter;
        }

        public String getAccountType() {
            return accountType;
        }


        public Account(int accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }


    }






