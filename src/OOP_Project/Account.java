package OOP_Project;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;  // import the LocalDate class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
public class Account {
    protected int accountNumber;


    double balance;

    protected int choice ;
    private static int counter=10000;

    public static void setCounter(int index) {
        counter=index;
    }

    public static int getCounter() {
        return counter;
    }

    Scanner type = new Scanner(System.in) ;
    ArrayList <transaction> accountTransaction = new ArrayList<>();
    //Constructor
    public Account( double balance) {
        this.accountNumber = ++counter ;
        this.balance = balance;
    }



    public void  updateBalance (double amount){
            this.balance += amount ;
    }

    public boolean checkSufficientBalance (double amount){
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

    public void makeTransaction () {
        System.out.println("choose your transaction type \n press 1 to make a deposit \n press 2 to make a Withdraw \n press 3 to make a transfer  ");
        int transactionType = type.nextInt() ;
        double transactionAmount ;
        int recipientAccountNumber;
        LocalDateTime myDateObj = LocalDateTime.now();  // Create a date object
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        boolean addNote;
        String transactionNote;
        if (transactionType == 1)
        {

            transactionAmount = type.nextDouble();
            //System.out.println(formattedDate);  // Display the current date
            System.out.println("enter the amount you want to deposit ");
            accountTransaction.add(new transaction( accountNumber ,formattedDate, transactionAmount,"Deposit"));

        }
        else if (transactionType == 2) {
            System.out.println("enter the amount you want to Withdraw ");
            transactionAmount = type.nextDouble();
            accountTransaction.add(new transaction( accountNumber ,formattedDate, transactionAmount,"Withdraw"));
        }
        else if (transactionType == 3){
            System.out.println("enter the amount you want to Transfer ");
            transactionAmount = type.nextDouble();

            System.out.println("Enter the recipient Account number:");
            recipientAccountNumber=type.nextInt();

            System.out.println("\nPress 1 if you want to add note");
            addNote = type.nextBoolean();

            if(addNote) {
                System.out.println("Write Note for the transaction:");
                transactionNote = type.next();
                accountTransaction.add(new transaction(accountNumber,  formattedDate, transactionAmount,"Transfer",
                        transactionNote,  recipientAccountNumber));
            }
            else {
                accountTransaction.add(new transaction(accountNumber,  formattedDate, transactionAmount,"Transfer",
                        "",  recipientAccountNumber));
            }
        }
    }




    public void DisplayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public double getBalance()
    {
        return balance;
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
    //second constructor

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
