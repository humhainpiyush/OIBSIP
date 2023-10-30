import java.util.Scanner;
import java.util.Random;

public class Game {
    private static int starting = 1;
    private static int ending = 100;
    private static int rounds = 0;
    private static int maxChance = 5;
    private static int numChances = 0;
    private static int points = 0;

    private static int generateRandomNumber(int starting, int ending) {
        Random random = new Random();
        int randomNumber = random.nextInt(ending) + starting;
        return randomNumber;
    }

    private static int getUserGuess(Scanner sc) {
        System.out.print("Enter your guess: ");
        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("\nInvalid input. Please enter a valid number\n");
            sc.next();
            return getUserGuess(sc);
        }
    }

    private static int playGame(int number, int maxChance, Scanner sc) {
        int attempts = 0;

        while (attempts < maxChance) {
            int userGuess = getUserGuess(sc);
            attempts++;

            String result = compareGuess(number, userGuess);
            System.out.println(result);

            if (result.equals("Correct")) {
                System.out.println("\nCongratulations! You guessed the correct number in " + attempts + " attempts.");
                return attempts;
            }
        }

        System.out.println(
                "\nSorry, you've reached the maximum number of attempts. The correct number was " + number + ".");
        return attempts;
    }

    private static String compareGuess(int number, int userGuess) {
        if (userGuess == number) {
            points++;
            return "Correct";
        } else if (userGuess < number)
            return "Too Low";
        else
            return "Too High";
    }

    private static void displayScore() {
        System.out.println("\n=====GAME OVER=====");
        System.out.println("Score Points: " + (points * 5));
        System.out.println("Total rounds played: " + rounds);
        System.out.println("Total attempts taken: " + numChances);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            rounds++;
            int number = generateRandomNumber(starting, ending);
            System.out.println("\n==== Round " + rounds + " ====");

            int totalAttempts = playGame(number, maxChance, scanner);
            numChances += totalAttempts;

            System.out.println("\nDo you want to play again: (yes/no)");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        displayScore();
        scanner.close();
    }
}