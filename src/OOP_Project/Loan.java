package OOP_Project;

public class Loan {
    public  int loanDurationInMonths;
    public double loanAmount;
    public double clientBalance;
    public Installment[] installments;

    public Loan(int loanDurationInMonths, double loanAmount, double ClientBalance) {
        this.loanDurationInMonths = loanDurationInMonths;
        this.loanAmount = loanAmount;
        this.clientBalance = ClientBalance;
        this.installments = new Installment[loanDurationInMonths];
        initializeInstallments();
    }

    private void initializeInstallments() {
        for (int i = 0; i < loanDurationInMonths; i++) {
            installments[i] = new Installment(i + 1,false);
        }
    }

    public void payInstallment(int installmentNumber,boolean paid) {

        if (installmentNumber <= loanDurationInMonths && installmentNumber > 0&& paid==false) {
            double installmentAmount = calculateInstallmentAmount();
            if (clientBalance >= installmentAmount) {
                clientBalance -= installmentAmount;
                installments[installmentNumber - 1].setPaid(true);
                System.out.println("Installment " + installmentNumber + " paid successfully.");
            } else {
                System.out.println("Failed Transaction " + installmentNumber);
            }
        }
    }
public void  display_loan_history(){
        for (int i=0; i<=loanDurationInMonths;i++)
        {
            System.out.println(installments[i].installmentNumber);
            System.out.println();
            System.out.println(installments[i].paid);
        }
}


    private double calculateInstallmentAmount() {
        return loanAmount / loanDurationInMonths;
    }
    public void addLoanAmountToBalance() {
        clientBalance += loanAmount;
        System.out.println("Loan amount added to the client's balance.");
    }
    public double getClientBalance() {
        return clientBalance;
    }
}
