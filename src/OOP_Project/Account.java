package OOP_Project;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;  // import the LocalDate class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
public class Account {
    int accountNumber;
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
    //ArrayList <transaction> accountTransaction = new ArrayList<>();


    //Constructor
    public Account( double balance) {
        accountNumber=counter;
        ++counter;

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

    public void makeTransaction (int transactionType,ArrayList <transaction> AllTransaction,ArrayList<Client> clients) {
        double transactionAmount ;
        int recipientAccountNumber;
        LocalDateTime myDateObj = LocalDateTime.now();  // Create a date object
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        boolean addNote;
        String transactionNote;
        Account recipientAccount=null;
        boolean recipientFound =false;
        if (transactionType == 1)
        {

            System.out.println("enter the amount you want to deposit ");
            transactionAmount = type.nextDouble();
            AllTransaction.add(new transaction( accountNumber,this,formattedDate, transactionAmount,"Deposit",0));

        }
        else if (transactionType == 2) {
            System.out.println("enter the amount you want to Withdraw ");
            transactionAmount = type.nextDouble();
            AllTransaction.add(new transaction( accountNumber , this ,formattedDate, transactionAmount,"Withdraw",0));
        }
        else if (transactionType == 3){
            while(true) {
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
                    if (type.nextInt()==1){addNote=true;}
                    else{addNote=false;}

                    if (addNote) {
                        System.out.println("Write Note for the transaction:");
                        transactionNote = type.next();
                        AllTransaction.add(new transaction(accountNumber, this,formattedDate,transactionAmount,"Transfer",
                                transactionNote,recipientAccountNumber,recipientAccount,0));
                    } else {
                        AllTransaction.add(new transaction(accountNumber, this, formattedDate, transactionAmount, "Transfer",
                                "", recipientAccountNumber, recipientAccount, 0));
                    }
                    break;
                } else {
                    System.out.println("recipient Account number not found");
                    return;
                }
            }
        }
    }




    public void DisplayInfo() {
        System.out.println("--------------------------------");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("--------------------------------");
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

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
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
