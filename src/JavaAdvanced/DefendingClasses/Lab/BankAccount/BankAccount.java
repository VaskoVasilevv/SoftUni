package JavaAdvanced.DefendingClasses.Lab.BankAccount;

public class BankAccount {
    private final static double DEFALUT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFALUT_INTEREST_RATE;
    private static int bankAccountCount = 1;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = bankAccountCount++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * this.balance * years;
    }

    public int getId() {
        return id;
    }

}
