public class PaymentDetails {
    private double deposit;
    private double totalCost;
    private double remainingBalance;

    public PaymentDetails(double deposit, double totalCost) {
        this.deposit = deposit;
        this.totalCost = totalCost;
        this.remainingBalance = totalCost - deposit;
    }

    public double getDeposit() {
        return deposit;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "deposit=" + deposit +
                ", totalCost=" + totalCost +
                ", remainingBalance=" + remainingBalance +
                '}';
    }
}
