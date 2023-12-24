package OOP_Project;

public class Installment {
    public int installmentNumber;
    public boolean paid;
    public double installmentAmount;
    public Installment(int installmentNumber,boolean paid, double installmentAmount) {
        this.installmentNumber = installmentNumber;
        this.paid = paid;
        this.installmentAmount = installmentAmount;
    }

    public int getInstallmentNumber() {
        return installmentNumber;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
