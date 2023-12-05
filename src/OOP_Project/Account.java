package OOP_Project;

import java.util.Scanner;

public class Account {
    protected int accountNumber;
    public String getAccountNumber() {
        return Integer.toString(accountNumber);
    }
    protected String customerName;

    double balance;

    protected int choice ;

    protected double amount ;

    static int counter = 0;
    Scanner Type = new Scanner(System.in);

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public double getBalance()
    {
        return balance;
    }




    public Account(String customerName, double balance) {
        this.accountNumber = counter ++;
        this.customerName = customerName;
        this.balance = balance;
    }
    public void AskTypeOfAccount( String accountHolder, double balance)
    {
        System.out.println("Choose The Type Of OOP_Project.Account ");
        System.out.println("For Saving OOP_Project.Account Choose 1 \n For Current OOP_Project.Account Choose 2");
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

    }
//    public Account [] (SavingAccount temp)
//    {
//        int arrayOfLength = this.length ;
//        Account [] array  = new Account[arrayOfLength + 1];
//        System.arraycopy(this , 0 , array , 0 ,arrayOfLength);
//        array[arrayOfLength] = temp ;
//        return array ;
//    }

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



    public void DisplayInfo() {
        System.out.println("OOP_Project.Account Number: " + accountNumber);
        System.out.println("OOP_Project.Account Holder: " + customerName);
        System.out.println("Balance: $" + balance);
    }
}
