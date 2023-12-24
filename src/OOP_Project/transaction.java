package OOP_Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class transaction {
    private static int counter = 1;
    private int transactionId;
    private int customerId;
    private int recipientId;
    private int employeeId=0;
    private boolean transactionStatus ;
    private String transactionDate;
    private double transactionAmount;
    private String transactionType;//deposit,withdraw,transfer
    private String transactionDescription;//transfer reason


    public transaction(int customerId, Account account, String transactionDate, double transactionAmount,String transactionType,
                    String transactionDescription, int recipientId, Account recipAccount, int employeeId) throws TransactionException{
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
                    throw new TransactionException("Insufficient balance.");
                }
            } else {
                this.transactionStatus = false;
                throw new TransactionException("Invalid transfer amount.");
            }
        }else{
            this.transactionStatus = false;
            throw new TransactionException("Customer account number cannot be equal to Recipient account number.");
        }
    }

    public transaction(int customerId, Account account, String transactionDate, double transactionAmount,
                    String transactionType, int employeeId) {
        this.transactionId = counter++;
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.employeeId = employeeId;
        this.transactionType = transactionType;

        if (transactionType.equals("Deposit")) {
            try{handleDeposit(account);}catch (TransactionException exp){
                System.out.println(exp.getMessage());
            }
        } else {
            try{handleWithdrawal(account);}catch (TransactionException exp){
                System.out.println(exp.getMessage());
            }
        }
    }

    private void handleDeposit(Account account) throws TransactionException {
        if (transactionAmount > 0) {
            this.transactionStatus = true;
            transactionDescription = "Deposit to account";
            account.updateBalance(transactionAmount);
        } else {
            this.transactionStatus = false;
            throw new TransactionException("Invalid transfer amount.");

        }
    }

    private void handleWithdrawal(Account account) throws TransactionException {
        
        if (transactionAmount > 0) {
            if (account.checkSufficientBalance(transactionAmount)) {
                this.transactionStatus = true;
                if(transactionType.equals("Installment")){
                    int i = 0;
                    int installmentindx = 0;
                    for ( Installment itr: account.accountLoan.installments) {
                        if(!itr.paid){
                            installmentindx = i;
                            break;
                        }
                        i++;
                    }
                    transactionDescription = "Installment number " + installmentindx;
                }
                else if(transactionType.equals("Withdrawal")){
                    transactionDescription = "Withdrawal from account";
                }
                else{
                    transactionDescription = "Current Account Fees";
                }
                if(!transactionType.equals("Installment")){
                    account.updateBalance(-transactionAmount);
                }
            } else {
                this.transactionStatus = false;
                throw new TransactionException("Insufficient Balance.");

            }
        } else {
            this.transactionStatus = false;
            throw new TransactionException("Invalid transfer amount.");
        }
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
        this.transactionId = transactionId;//leh
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
                return "Transaction{" + '\n' +
                        "transactionId='" + transactionId + '\n' +
                        ", customerId='" + customerId + '\n' +
                        ", transactionDate=" + transactionDate + '\n' +
                        ", transactionAmount=" + transactionAmount + '\n' +
                        ", transactionType='" + transactionType + '\n' +
                        ", transactionDescription='" + transactionDescription + '\n' +
                        ", RecipientId='" + recipientId + '\n' +
                        ", transactionStatus='" + status + '\n' +
                        '}';
            }else{
                return "Transaction{" + '\n'+
                        "transactionId='" + transactionId + '\n' +
                        ", customerId='" + customerId + '\n' +
                        ", transactionDate=" + transactionDate + '\n' +
                        ", transactionAmount=" + transactionAmount + '\n' +
                        ", transactionType='" + transactionType + '\n' +
                        ", transactionDescription='" + transactionDescription + '\n' +
                        ", RecipientId='" + recipientId + '\n' +
                        ", employeeId='" + employeeId + '\n' +
                        ", transactionStatus='" + status + '\n' +
                        '}';
            }
        }
        else{
            if(employeeId == 0){
                return "Transaction{" +'\n' +
                        "transactionId=" + transactionId + '\n' +
                        ", customerId=" + customerId + '\n' +
                        ", transactionDate=" + transactionDate + '\n' +
                        ", transactionAmount=" + transactionAmount + '\n' +
                        ", transactionType=" + transactionType + '\n' +
                        ", transactionDescription=" + transactionDescription + '\n' +
                        ", transactionStatus=" + status + '\n' +
                        '}';
            }else{
                return '\n' +
                        "transactionId=" + transactionId + '\n' +
                        ", customerId=" + customerId + '\n' +
                        ", transactionDate=" + transactionDate + '\n' +
                        ", transactionAmount=" + transactionAmount + '\n' +
                        ", transactionType=" + transactionType + '\n' +
                        ", transactionDescription=" + transactionDescription + '\n' +
                        ", employeeId=" + employeeId + '\n' +
                        ", transactionStatus=" + status + '\n'
                        ;
            }
        }
    }

    public static void ReadTransactions(ArrayList<transaction> transactions) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("TRANSACTIONS.txt"));
            String line;
            while ((line = reader.readLine()) != null)
            {
                int customerId=Integer.parseInt(line);
                int recipientId=Integer.parseInt(reader.readLine());
                int employeeId=Integer.parseInt(reader.readLine());
                boolean transactionStatus=Boolean.parseBoolean(reader.readLine()) ;
                String transactionDate= reader.readLine();
                double transactionAmount=Double.parseDouble(reader.readLine());
                String transactionType= reader.readLine();           //deposit,withdraw,transfer
                String transactionDescription= reader.readLine();
                transactions.add(new transaction(customerId,recipientId,employeeId,transactionStatus,
                        transactionDate,transactionAmount,transactionType,transactionDescription));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public transaction(int customerId, int recipientId, int employeeId, boolean transactionStatus, String transactionDate,
                    double transactionAmount, String transactionType, String transactionDescription) {
        this.transactionId=counter++;
        this.customerId = customerId;
        this.recipientId = recipientId;
        this.employeeId = employeeId;
        this.transactionStatus = transactionStatus;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.transactionDescription = transactionDescription;
    }

    public static void saveTransactions(ArrayList<transaction> transactions){
        try {
            BufferedWriter writer =new BufferedWriter(new FileWriter("TRANSACTIONS.txt"));
            for (transaction t: transactions) {
                writer.write(t.save());
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  String save(){
        return  customerId+"\n"+ recipientId+"\n"+ employeeId+"\n"+ transactionStatus+"\n"+
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