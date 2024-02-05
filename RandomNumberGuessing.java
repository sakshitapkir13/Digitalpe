import java.util.Random;
import java.util.Scanner;

public class RandomNumberGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowlimit = 50;
        int highlimit = 70;
        int range = highlimit - lowlimit + 1;

        int randomNumber = random.nextInt(range) + lowlimit;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between " + lowlimit + " and " + highlimit + ". Try to guess it!");

        int guess;
        int attempts = 0;

        while (attempts < range) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;
            if(guess>highlimit){
                System.out.println("Invalid number");
            }
            else if(guess<lowlimit){
                System.out.println("Invalid Number");}
            else {

                if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    break;
                }
            }
        }

        if (attempts == range) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + randomNumber);
        }

        scanner.close();
    }
}
