import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        System.out.println("=================================");
        System.out.println("        NUMBER GUESSING GAME");
        System.out.println("=================================");

        do {

            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");
            System.out.println("Try to guess the number!");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                if (guess == number) {

                    guessedCorrectly = true;

                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("\nCongratulations!");
                    System.out.println("You guessed the correct number.");
                    System.out.println("Number: " + number);
                    System.out.println("Attempts used: " + attempts);
                    System.out.println("Round Score: " + score);

                    break;

                } else if (guess > number) {

                    System.out.println("Too High! Try a smaller number.");

                } else {

                    System.out.println("Too Low! Try a larger number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("\nTotal Score: " + totalScore);

            System.out.print("\nDo you want to play another round? (Y/N): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n=================================");
        System.out.println("       THANK YOU FOR PLAYING!");
        System.out.println("       Final Score: " + totalScore);
        System.out.println("=================================");

        scanner.close();
    }
}
