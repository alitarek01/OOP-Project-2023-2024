package OOP_Project;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;



public class Account {
    protected int accountNumber;
    public String getAccountNumber() {
        return Integer.toString(accountNumber);
    }


    double balance;

    protected int choice ;

    protected double amount ;

    static int counter = 0;

    double transactionAmount = 0.0 ;



    ArrayList <transaction> accountTransaction = new ArrayList<>();


    Scanner Type = new Scanner(System.in);

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public double getBalance()
    {
        return balance;
    }




    public Account( double balance) {
        this.accountNumber = counter ++;
        this.balance = balance;
    }
     /* public void AskTypeOfAccount( String accountHolder, double balance)
    {
        System.out.println("Choose The Type Of Account ");
        System.out.println("For Saving Account Choose 1 \n For Current Account Choose 2");
        Type.nextInt(choice);
        if (choice == 1)
        {
            SavingAccount temp = new SavingAccount( customerName,  balance);


        }else if (choice == 2)
        {
            CurrentAccount temp = new CurrentAccount( customerName,  balance) ;
        }
        else

        {
            System.out.println("Invalid Choice Please Try Again");
        }

    }*/


    public void  updateBalance (double amount)
    {
            this.balance += amount ;
    }

    public boolean checkSufficientBalance (double amount)
    {
        if(amount <= this.balance )
        {
            return true ;
        }
        else {
            return false ;
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

    public void makeTransaction ()
    {
        int transactionType = 0 ;

        System.out.println("choose your transaction type \n for deposit press 1 \n for withdraw press 2 \n for transfer press 3  ");
        Scanner type = new Scanner(System.in) ;
        type.nextInt(transactionType) ;
        if (transactionType == 1)
        {

            Date transactionDate = null;
            double transactionAmount = 0.0 ;
            System.out.println("enter the amount you want to deposit ");
            transactionAmount = type.nextDouble();


            // Define the date format expected from the user
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            try {
                // Parse the user input to a Date object
                System.out.print("Enter a date (yyyy-MM-dd): ");
                String userInput = type.nextLine();
                Date transactiondate = dateFormat.parse(userInput);

                // Print the parsed date
                System.out.println("Parsed Date: " + transactiondate);
            } catch (ParseException e) {
                // Handle the case where the entered date is not in the expected format
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            } finally {
                // Close the scanner to prevent resource leak
                type.close();
            }

            accountTransaction.add(new transaction( accountNumber ,transactionDate, transactionAmount,
             "deposit",  ""));



        }


    }




    public void DisplayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}
