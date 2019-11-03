import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.Math;

public class CAI_Problem {
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    public static boolean checkForDupes(int check[][], int x, int y){
        int combo[] = new int[10];
        int comboFlip[] = new int[10];
        int inputCombo = (x*10) + y;
        int inputComboFlip = (y*10) + x;
        for(int i = 0; i < 10; i++){
            combo[i] = ((check[i][0] * 10) + (check[i][1]));
            comboFlip[i] = ((check[i][1] * 10) + (check[i][0]));
        }
        for(int j = 0; j < 10; j++){
            if((inputCombo == combo[j]) || (inputComboFlip == comboFlip[j]) || (inputComboFlip == combo[j]) || (inputCombo == comboFlip[j])){
                return true;
            }
        }
        return false;
    }
    public static double[] askQuestion(int level, int type){
        SecureRandom rand = new SecureRandom();
        //int answerList[] = new int[10];
        double doubleList[] = new double[10];
        int numberList[][] = new int[10][2];
        int count = 0;
        while(count < 10){
            int randDig1 = rand.nextInt(level);
            int randDig2 = rand.nextInt(level);
            if(checkForDupes(numberList, randDig1, randDig2)){
            }
            else {
                numberList[count][0] = randDig1;
                numberList[count][1] = randDig2;
                count++;
            }
        }
        switch(type) {
            case 1:
                for (int j = 0; j < 10; j++) {
                    doubleList[j] = (double)numberList[j][0] + (double)numberList[j][1];
                    System.out.println("#" + (j + 1) + ": How much is " + numberList[j][0] + " plus " + numberList[j][1]);
                }
                break;
            case 2:
                for (int j = 0; j < 10; j++) {
                    doubleList[j] = (double)numberList[j][0] * (double)numberList[j][1];
                    System.out.println("#" + (j + 1) + ": How much is " + numberList[j][0] + " times " + numberList[j][1]);
                }
                break;
            case 3:
                for (int j = 0; j < 10; j++) {
                    doubleList[j] = ((double)numberList[j][0]) - ((double)numberList[j][1]);
                    System.out.println("#" + (j + 1) + ": How much is " + numberList[j][0] + " minus " + numberList[j][1] + "");
                }
                break;
            case 4:
                for (int j = 0; j < 10; j++) {
                    if(numberList[j][1] == 0){
                        numberList[j][1] += 1;
                    }
                    doubleList[j] = round(((double)numberList[j][0] / (double)numberList[j][1]), 2);
                    System.out.println("#" + (j + 1) + ": How much is " + numberList[j][0] + " divided by " + numberList[j][1]);
                }
                break;
            case 5:
                int randOp;
                for(int j = 0; j < 10; j++) {
                    randOp = rand.nextInt(4) + 1;
                    switch (randOp) {
                        case 1:
                            doubleList[j] = (double) numberList[j][0] + (double) numberList[j][1];
                            System.out.println("#" + (j + 1) + ": How much is " + numberList[j][0] + " plus " + numberList[j][1]);
                            break;
                        case 2:
                            doubleList[j] = (double) numberList[j][0] * (double) numberList[j][1];
                            System.out.println("#" + (j + 1) + ": How much is " + numberList[j][0] + " times " + numberList[j][1]);
                            break;
                        case 3:
                            doubleList[j] = ((double) numberList[j][0]) - ((double) numberList[j][1]);
                            System.out.println("#" + (j + 1) + ": How much is " + numberList[j][0] + " minus " + numberList[j][1] + "");
                            break;
                        case 4:
                            if (numberList[j][1] == 0) {
                                numberList[j][1] += 1;
                            }
                            doubleList[j] = round(((double) numberList[j][0] / (double) numberList[j][1]), 2);
                            System.out.println("#" + (j + 1) + ": How much is " + numberList[j][0] + " divided by " + numberList[j][1]);
                            break;
                    }
                }
                break;
        }
        return doubleList;
    }
    public static void printRandomCorrect(){
        SecureRandom rand = new SecureRandom();
        int randResp = rand.nextInt(4)+1;
        switch(randResp){
            case 1:
                System.out.println("Very good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;
        }
    }
    public static void printRandomWrong(){
        SecureRandom rand = new SecureRandom();
        int randResp = rand.nextInt(4)+1;
        switch(randResp){
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don't give up!");
                break;
            case 4:
                System.out.println("No. Keep trying");
                break;
        }
    }
    public static void mathTest(int level, int type){
        Scanner scnr = new Scanner(System.in);
        double correctAnswer;
        int score = 0;
        switch(level){
            case 1:
                level = 10;
                break;
            case 2:
                level = 100;
                break;
            case 3:
                level = 1000;
                break;
            case 4:
                level = 10000;
                break;
        }
        double answerList[] = askQuestion(level, type);
        System.out.println("Your Math Test:");
        for(int i = 0; i <10; i++){
            System.out.print("Please enter your answer to #" + (i+1) + ": ");
            correctAnswer = scnr.nextDouble();
            if(correctAnswer == answerList[i]){
                printRandomCorrect();
                score += 10;
            }
            else {
                printRandomWrong();
            }
        }
        System.out.println("You scored " + (score/10) + " out of 10.");
        if(score < 75){
            System.out.println("Please ask your teacher for extra help.");
        }
        else{
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
    }
    public static int genDiff(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter a difficulty level for your math test:");
        System.out.println("[1] For one digit numbers");
        System.out.println("[2] For two digit numbers");
        System.out.println("[3] For three digit numbers");
        System.out.println("[4] For four digit numbers");
        System.out.print("Your choice: ");
        int level = scnr.nextInt();
        return level;
    }
    public static int genType(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter a difficulty level for your math test: [1], [2], [3], [4]");
        System.out.println("[1] For addition");
        System.out.println("[2] For multiplication");
        System.out.println("[3] For subtraction");
        System.out.println("[4] For division");
        System.out.println("[5] For a random mix");
        System.out.print("Your choice: ");
        int type = scnr.nextInt();
        return type;
    }
    public static void main(String [] args) {
        Scanner scnr = new Scanner(System.in);
        char answer;
        boolean play = true;
        while(play){
            System.out.print("Do you wish to take a math test? Y / N: ");
            answer = scnr.next().charAt(0);
            if(answer == 'Y') {
                int level = genDiff();
                int type = genType();
                mathTest(level, type);
            }
            else if(answer == 'N'){
                play = false;
            }
            else{
                System.out.println("Invalid Response.");
            }
        }
    }
}
