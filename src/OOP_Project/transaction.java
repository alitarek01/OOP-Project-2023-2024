package OOP_Project;

import java.util.ArrayList;
//import java.util.Date;
public class transaction {
    private static int counter = 0;
    private int transactionId;
    private int customerId;
    private int recipientId;
    private int employeeId;
    private boolean transactionStatus ;
    private String transactionDate;
    private double transactionAmount;
    private String transactionType;//deposit,withdraw,transfer
    private String transactionDescription;//transfer reason
    private static ArrayList<Account> Account = new ArrayList<>();

    int index;
    int indexOfRecipient;

    public transaction(int customerId, String transactionDate, double transactionAmount,String transactionType,
    String transactionDescription, int recipientId) {
        this.transactionId = counter++;
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.transactionDescription = transactionDescription;
        this.recipientId = recipientId;
       // this.employeeId = employeeId;
        index = findAccountIndex(customerId);
        indexOfRecipient = findAccountIndex(recipientId);
// use equals() instead of != with strings
        if(customerId != recipientId){
            if (index != -1 || indexOfRecipient != -1) {
                if (transactionAmount > 0) {
                    if (Account.get(index).checkSufficientBalance(transactionAmount)) {
                        Account.get(index).updateBalance(-transactionAmount);
                        Account.get(indexOfRecipient).updateBalance(transactionAmount);
                        this.transactionStatus = true;
                    } else {
                        this.transactionStatus = false;
                        System.out.println("Insufficient balance.");
                    }
                } else {
                    this.transactionStatus = false;
                    System.out.println("Invalid transfer amount.");
                }
            } else {
                this.transactionStatus = false;
                System.out.println("Customer or Recipient not found.");
            }
        }else{
            this.transactionStatus = false;
            System.out.println("Customer account number can not be equal to Recipient account number.");
        }
    }

    public transaction(int customerId, String transactionDate, double transactionAmount,
    String transactionType) {
        this.transactionId = counter++;
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
//        this.employeeId = employeeId;
        index = findAccountIndex(customerId);

        if (index != -1) {
            if (transactionType.equals("Deposit")) {
                handleDeposit();
            } else {
                handleWithdrawal();
            }
        } else {
            this.transactionStatus = false;
            System.out.println("Customer not found.");
        }
    }

    private void handleDeposit() {
        if (transactionAmount > 0) {
            this.transactionStatus = true;
            transactionDescription = "Deposit to account";
            Account.get(index).updateBalance(transactionAmount);
        } else {
            this.transactionStatus = false;
            System.out.println("Invalid deposit amount.");
        }
    }

    private void handleWithdrawal() {
        if (transactionAmount > 0) {
            if (Account.get(index).checkSufficientBalance(transactionAmount)) {
                this.transactionStatus = true;
                transactionDescription = "Withdrawal from account";
                Account.get(index).updateBalance(-transactionAmount);
            } else {
                this.transactionStatus = false;
                System.out.println("Insufficient balance.");
            }
        } else {
            this.transactionStatus = false;
            System.out.println("Invalid withdrawal amount.");
        }
    }

    private int findAccountIndex(int customerId) {
        for (int i = 0; i < Account.size(); i++) {
            if (Account.get(i).getAccountNumber() == customerId) {
                return i;
            }
        }
        return -1; // Customer not found
    }

    public int getemployeeId() {
        return employeeId;
    }
    
    public void setemployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getTransactionId() {
        return transactionId;
    }
    
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    @Override
    public String toString() {
        String status = transactionStatus ? "Successful" : "Failed";
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", transactionDate=" + transactionDate +
                ", transactionAmount=" + transactionAmount +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", RecipientId='" + recipientId + '\'' +
                ", employeeId='" + employeeId +
                ", transactionStatus='" + status + '\'' +
                '}';
    }

}

