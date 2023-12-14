package OOP_Project;

public class SavingAccount extends Account {
    protected final double interestRate = 0.2;

    public SavingAccount(  double balance) {
        super(balance);
    }

    public SavingAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void CalculateInterest() {
        double interest = balance * interestRate ;
        balance += interest;
        System.out.println("New balance: $" + balance);
    }

}
