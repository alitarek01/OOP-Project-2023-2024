package OOP_Project;

public class CurrentAccount extends Account {
    protected static final double MIN_BALANCE = 3000;
<<<<<<< HEAD
    public CurrentAccount(double balance )
    {
        super( balance);
=======
      public CurrentAccount(double balance )
      {
          super( balance,"Current Account");
>>>>>>> d7dba2fd7af9463531794d2d44ce307dfe11d8ca

    }

    public CurrentAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    protected void checkMinimumBalance() {
        if (balance < MIN_BALANCE)
            System.out.println("Sorry Your Balance Amount Not Allowed \n Please aCheck If Your Balance Amount < 3000");
            // if balance < 3000 fees include we make try and catch for that exception
        }

    }

