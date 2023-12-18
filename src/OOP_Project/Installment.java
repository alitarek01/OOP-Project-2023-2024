package OOP_Project;

public class Installment {
    public int installmentNumber;
    public boolean paid;

    public Installment(int installmentNumber,boolean paid) {
        this.installmentNumber = installmentNumber;
        this.paid = paid;
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
