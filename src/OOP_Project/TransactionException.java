package OOP_Project;

public class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
        System.out.println("Transaction failed!");
    }
}