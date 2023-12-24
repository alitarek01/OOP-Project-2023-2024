package OOP_Project;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class SavingAccount extends Account {
    protected static double interestRate = 0.02;
    protected LocalDateTime accountDate  ;
    public SavingAccount(  double balance  ) {
        super("Saving Account" , balance);
        accountDate = LocalDateTime.now();
        DateTimeFormatter accountDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public SavingAccount(  double balance  , LocalDate date ) {
        super(balance,"Saving Account" , date);




    }

    public SavingAccount(double balance, Date date) {
        super();
    }


    @Override
    public void CalculateInterest(LocalDateTime currentDate ) {
        YearMonth yearMonth1 = YearMonth.from(currentDate);
        YearMonth yearMonth2 = YearMonth.from(super.myDateObj);
        long monthsDifference = ChronoUnit.MONTHS.between(yearMonth1, yearMonth2);

        double interest = balance * interestRate * monthsDifference ;
        if(monthsDifference != 0) {
            balance += interest;
            System.out.println("Interest added: $" + interest);
            System.out.println("New balance: $" + balance);
            accountDate = currentDate;
        }
        else {
            System.out.println("No Interest");
        }
    }

}