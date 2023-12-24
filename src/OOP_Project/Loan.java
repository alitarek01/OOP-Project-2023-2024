package OOP_Project;

import java.util.ArrayList;

public class Loan {
    public  int loanDurationInMonths;
    public double loanAmount;
    public double clientBalance;
    public boolean loanStatus = false;
    public ArrayList <Installment> installments = new ArrayList<>();

    public Loan(int loanDurationInMonths, double loanAmount) {
        this.loanDurationInMonths = loanDurationInMonths;
        this.loanAmount = loanAmount;
        loanStatus = true;
        initializeInstallments();

    }

    private void initializeInstallments() {
        for (int j = 0; j < loanDurationInMonths; j++) {
            installments.add( new Installment(j + 1,false,calculateInstallmentAmount()));
        }

    }

    public double payInstallment(int installmentNumber,double clientBalance) {

        if (installmentNumber <= loanDurationInMonths && installmentNumber > 0 ) {
            if (clientBalance >= installments.get(installmentNumber-1).installmentAmount) {
                clientBalance -= installments.get(installmentNumber-1).installmentAmount;
                installments.get(installmentNumber - 1).setPaid(true);
                System.out.println("Installment " + installmentNumber + " paid successfully.");
                return clientBalance;
            } else {
                System.out.println("Failed Transaction Number: " + installmentNumber);
                return clientBalance;
            }
        }
        return clientBalance;
    }
public void  display_loan_history(){
        for (int i=0; i<loanDurationInMonths;i++)
        {
            System.out.println("--------------------");
            System.out.println("Installment No. "+installments.get(i).installmentNumber);
            if (installments.get(i).paid) {
                System.out.println("State: Paid");
            }
            else {
                System.out.println("State: Unpaid");
            }
                System.out.println("--------------------");
        }

}


    private double calculateInstallmentAmount() {
        return loanAmount / loanDurationInMonths;
    }
    public double addLoanAmountToBalance(double clientBalance) {
        clientBalance += loanAmount;
        System.out.println("Loan amount added to the client's balance.");
        return clientBalance;
    }
    public double getClientBalance() {
        return clientBalance;
    }
}
