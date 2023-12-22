package OOP_Project;

import java.io.*;
import java.util.ArrayList;

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


    public transaction(int customerId, Account account, String transactionDate, double transactionAmount,String transactionType,
    String transactionDescription, int recipientId, Account recipAccount, int employeeId) {
        this.transactionId = counter++;
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.transactionDescription = transactionDescription;
        this.recipientId = recipientId;
        this.employeeId = employeeId;
        if(customerId != recipientId){
            if (transactionAmount > 0) {
                if (account.checkSufficientBalance(transactionAmount)) {
                    account.updateBalance(-transactionAmount);
                    recipAccount.updateBalance(transactionAmount);
                    this.transactionStatus = true;
                } else {
                    this.transactionStatus = false;
                    System.out.println("Insufficient balance.");
                }
            } else {
                this.transactionStatus = false;
                System.out.println("Invalid transfer amount.");
            }
        }else{
            this.transactionStatus = false;
            System.out.println("Customer account number can not be equal to Recipient account number.");
        }
    }

    public transaction(int customerId, Account account, String transactionDate, double transactionAmount,
    String transactionType, int employeeId) {
        this.transactionId = counter++;
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.employeeId = employeeId;


        if (transactionType.equals("Deposit")) {
            handleDeposit(account);
        } else {
            handleWithdrawal(account);
        }
    }

    private void handleDeposit(Account account) {
        if (transactionAmount > 0) {
            this.transactionStatus = true;
            transactionDescription = "Deposit to account";
            account.updateBalance(transactionAmount);
        } else {
            this.transactionStatus = false;
            System.out.println("Invalid deposit amount.");
        }
    }

    private void handleWithdrawal(Account account) {
        if (transactionAmount > 0) {
            if (account.checkSufficientBalance(transactionAmount)) {
                this.transactionStatus = true;
                transactionDescription = "Withdrawal from account";
                account.updateBalance(-transactionAmount);
            } else {
                this.transactionStatus = false;
                System.out.println("Insufficient balance.");
            }
        } else {
            this.transactionStatus = false;
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // private int findAccountIndex(int customerId) {
    //     for (int i = 0; i < Account.size(); i++) {
    //         if (Account.get(i).getAccountNumber() == customerId) {
    //             return i;
    //         }
    //     }
    //     return -1; // Customer not found
    // }

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
        if(transactionType.equals("Transfer")){
            if(employeeId == 0){
                return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", transactionDate=" + transactionDate +
                ", transactionAmount=" + transactionAmount +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", RecipientId='" + recipientId + '\'' +
                ", transactionStatus='" + status + '\'' +
                '}';
            }else{
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
        else{
            if(employeeId == 0){
                return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", transactionDate=" + transactionDate +
                ", transactionAmount=" + transactionAmount +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", transactionStatus='" + status + '\'' +
                '}';
            }else{
                return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", transactionDate=" + transactionDate +
                ", transactionAmount=" + transactionAmount +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", employeeId='" + employeeId +
                ", transactionStatus='" + status + '\'' +
                '}';
            }
        }
    }

    public static void ReadTransactions(ArrayList<transaction> transactions) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("TRANSACTIONS.txt"));
            int line;
            while ((line = Integer.parseInt(reader.readLine())) != -1)
            {
                int transactionId;
                int customerId=Integer.parseInt(reader.readLine());
                int recipientId=Integer.parseInt(reader.readLine());
                int employeeId=Integer.parseInt(reader.readLine());
                boolean transactionStatus=Boolean.parseBoolean(reader.readLine()) ;
                String transactionDate= reader.readLine();
                double transactionAmount=Double.parseDouble(reader.readLine());
                String transactionType= reader.readLine();           //deposit,withdraw,transfer
                String transactionDescription= reader.readLine();
                transactions.add(new transaction(customerId,transactionDate,transactionAmount,transactionType,
                        transactionDescription,recipientId,line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void saveTransactions(ArrayList<transaction> transactions){
        try {
            BufferedWriter writer =new BufferedWriter(new FileWriter("TRANSACTIONS.txt"));
            for (transaction t: transactions) {
                writer.write(t.save());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  String save(){
        return transactionId+"\n"+ customerId+"\n"+ recipientId+"\n"+ employeeId+"\n"+ transactionStatus+"\n"+
                transactionDate+"\n"+ transactionAmount+"\n"+ transactionType+"\n"+ transactionDescription+"\n";
    }
    public transaction(int customerId, String transactionDate, double transactionAmount,String transactionType,
                       String transactionDescription, int recipientId,int TransactionID) {
        this.transactionId = TransactionID;
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.transactionDescription = transactionDescription;
        this.recipientId = recipientId;}

}


