import java.util.Random;
import java.util.Scanner;

public class game1 {

    public static void main(String[] args) {
        // Generate a random number between 1 and 100
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Initialize variables to keep track of attempts
        int attempts = 0;
        boolean guessedCorrectly = false;

        // Start the game loop
        while (!guessedCorrectly) {
            attempts++;

            // Prompt the user to guess the number
            System.out.println("Guess a number between 1 and 100: ");
            int guess = scanner.nextInt();

            // Compare the guess with the random number
            if (guess == randomNumber) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts!");
            } else if (guess < randomNumber) {
                System.out.println("Too low. Guess higher.");
            } else {
                System.out.println("Too high. Guess lower.");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
