import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private static final int MAX_ATTEMPTS = 5;
    private static final int POINTS_PER_ROUND = 100;
    private static final int POINT_DEDUCTION_PER_ATTEMPT = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean roundWon = false;

            System.out.println("I have selected a number between 1 and 100. Try to guess it!");

            while (attempts < MAX_ATTEMPTS && !roundWon) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    roundWon = true;
                    int pointsEarned = POINTS_PER_ROUND - (attempts - 1) * POINT_DEDUCTION_PER_ATTEMPT;
                    totalScore += pointsEarned;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("You earned " + pointsEarned + " points.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("The number is higher. Try again.");
                } else {
                    System.out.println("The number is lower. Try again.");
                }
            }

            if (!roundWon) {
                System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
            }

            System.out.print("Your total score is " + totalScore + ". Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is " + totalScore + ".");
        scanner.close();
    }
}
