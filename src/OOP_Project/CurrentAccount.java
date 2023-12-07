package OOP_Project;

public class CurrentAccount extends Account {
    protected static final double MIN_BALANCE = 3000;
      public CurrentAccount(double balance )
      {
          super( balance);

      }
    protected void checkMinimumBalance() {
        if (balance < MIN_BALANCE)
            System.out.println("Sorry Your Balance Amount Not Allowed \n Please aCheck If Your Balance Amount < 3000");
            // if balance < 3000 fees include we make try and catch for that exception
        }
    }

