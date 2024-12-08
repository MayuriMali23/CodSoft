import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("You need to guess a number between 1 and 100.");
            
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7; // Limit the number of attempts
            boolean guessedCorrectly = false;

            System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    break;
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Goodbye.");
        scanner.close();
    }
}