import java.util.Date;

public class transaction {
    private static int counter = 0;
    private String transactionId;
    private String customerId;
    private String recipientId;
    private String employeeId;
    private boolean transactionStatus;
    private Date transactionDate;
    private double transactionAmount;
    private String transactionType;//deposit,withdrawl,transfer
    private String transactionDescription;//transfer reason
    
    public transaction(String customerId, Date transactionDate, double transactionAmount
    , String transactionType, String transactionDescription,String recipientId, String employeeId) {
        this.transactionId = Integer.toString(counter++);
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.transactionDescription = transactionDescription;
        this.recipientId = recipientId;
        this.employeeId = employeeId;
        if (transactionAmount > 0) {
            if (Account.checkSufficientBalance(customerId, transactionAmount)) {
                    Account.updateBalance(-transactionAmount);
                    Account.updateBalance(transactionAmount);
                    this.transactionStatus = true;
                } else {
                    this.transactionStatus = false;
                    System.out.println("Insufficient balance.");
            }
        } else {
            this.transactionStatus = false;
            System.out.println("Invalid deposit amount.");
        }
    }
    public transaction(String customerId, Date transactionDate, double transactionAmount
    , String transactionType, String employeeId) {
        this.transactionId = Integer.toString(counter++);
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.employeeId = employeeId;
        if(transactionType.equals("Deposit")){
            if (transactionAmount > 0) {
                this.transactionStatus = true;
                transactionDescription = "Deposit to account";
                Account.updateBalance(customerId, transactionAmount);
            } else {
                this.transactionStatus = false;
                System.out.println("Invalid deposit amount.");
            }
        }else{
            if (transactionAmount > 0) {
                if (Account.checkSufficientBalance(customerId, transactionAmount)) {
                    this.transactionStatus = true;
                    transactionDescription = "Withdrawal from account";
                    Account.updateBalance(customerId, -transactionAmount);
                } else {
                    this.transactionStatus = false;
                    System.out.println("Insufficient balance.");
                }
            } else {
                this.transactionStatus = false;
                System.out.println("Invalid withdrawal amount.");
            }
        }
    }

    public String getemployeeId() {
        return employeeId;
    }
    
    public void setemployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTransactionId() {
        return transactionId;
    }
    
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
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
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", transactionDate=" + transactionDate +
                ", transactionAmount=" + transactionAmount +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", RecipientId='" + recipientId + '\'' +
                ", employeeId='" + employeeId +
                '}';
    }

}

