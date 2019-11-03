import java.util.Scanner;

public class bank {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);
        SavingsAccount.modifyInterestRate(0.04);
        for(int i = 0; i < 12; i++){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }
        saver1.printBal();
        saver2.printBal();
        SavingsAccount.modifyInterestRate(0.05);
        for(int i = 0; i < 12; i++){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }
        saver1.printBal();
        saver2.printBal();
    }
}
