package OOP_Project;

import java.time.LocalDateTime;
import java.time.LocalDate;  // import the LocalDate class
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CurrentAccount extends Account {
    protected static final double MIN_BALANCE = 3000;
    protected static final double Fees_Rate = 0.1;
    boolean accountStatus;
    public CurrentAccount(double balance, ArrayList<transaction> allTransactions,int employeeId) {
        super(balance, "Current Account");
        accountStatus = checkMinimumBalance();
        if(!accountStatus){
            System.out.println("balance less than min balance, fees would be applied");
            System.out.println("1 - To continue");
            System.out.println("2 - To change balance");
            try (Scanner in = new Scanner(System.in)) {
                int choice = in.nextInt();
                while(choice != 1 && choice != 2){
                    System.out.println("invalid choice");
                    choice = in.nextInt();
                }
                if(choice == 1){
                    super.balance -= super.getBalance()*Fees_Rate;
                    LocalDateTime myDateObj = LocalDateTime.now();  // Create a date object
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    String formattedDate = myDateObj.format(myFormatObj);
                    allTransactions.add(new transaction(super.accountNumber,this,formattedDate,super.getBalance()*Fees_Rate,"Fees",employeeId));
                }
                else {
                    super.balance = in.nextDouble();
                }
            }
        }
    }

    public CurrentAccount( double balance,String accountType, LocalDate creationDate) {
        super(balance,accountType,creationDate);

    }

    protected boolean checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            System.out.println("Sorry Your Balance Amount Not Allowed \n Please Check If Your Balance Amount < 3000");
            return false;
        }
        // if balance < 3000 fees include we make try and catch for that exception

        else{
            return true;
        }
    }


}