import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int score =0;

            for (int i = 1; i <= 10; i++) {
                int number1= (int) (Math.random()*10) +1 ;
                int number2= (int) (Math.random()*10) + 1;

                System.out.println("What is " + number1 + " * " + number2 + "?" );
                int answer = Integer.parseInt(scanner.nextLine());

                int correctAnswer = number1 * number2;

                if (answer == correctAnswer) {
                    System.out.println("Correct!");
                    score++;
                }
                else{
                    System.out.println("Incorrect! The answer is: " + correctAnswer);
                }
            }
            System.out.println("Your score is " + score + "out of 10");

            if (score == 10) {
                System.out.println("Congratulations! You have mastered the multiplication table!!");
                break;
            }
            else {
                System.out.println("Lets try again till getting the full points!!\n");
            }
        }
    }
}
