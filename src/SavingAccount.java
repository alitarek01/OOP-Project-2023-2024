public class SavingAccount extends Account  {
    protected final double interestRate = 0.2;

    public SavingAccount( String customerName, double balance) {
        super( customerName, balance);
    }



    public void CalculateInterest() {
        double interest = balance * interestRate ;
        balance += interest;
        System.out.println("New balance: $" + balance);
    }
}
