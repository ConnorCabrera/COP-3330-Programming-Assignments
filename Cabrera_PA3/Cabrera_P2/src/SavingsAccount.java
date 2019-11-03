public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double bal){
        savingsBalance = bal;
    }
    public void calculateMonthlyInterest(){
        double monthlyInterest = (savingsBalance * annualInterestRate)/12;
        savingsBalance += monthlyInterest;

    }
    public static void modifyInterestRate(double rate){
        annualInterestRate = rate;
    }
    public void printBal(){
        System.out.println(savingsBalance);
    }

}
