import java.util.Random;
import java.util.Scanner;

public class rps {

    private static int userWins = 0;
    private static int computerWins = 0;
    private static int ties = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String[] choices = {"Rock", "Paper", "Scissors"};


        Random random = new Random();

        while (true) {
            // Get user's choice
            System.out.println("Enter your choice (Rock, Paper, or Scissors) or 'exit' to end the game: ");
            String userChoice = scanner.nextLine();


            if (userChoice.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing! Exiting the game.");
                break;
            }


            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid choice. Please enter Rock, Paper, or Scissors.");
                continue;
            }


            int computerChoiceIndex = random.nextInt(choices.length);
            String computerChoice = choices[computerChoiceIndex];


            System.out.println("Your choice: " + userChoice);
            System.out.println("Computer's choice: " + computerChoice);


            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);


            displayTable();
        }


        scanner.close();
    }

    private static boolean isValidChoice(String choice) {
        return choice.equalsIgnoreCase("Rock") || choice.equalsIgnoreCase("Paper") || choice.equalsIgnoreCase("Scissors");
    }

    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) {
            ties++;
            return "It's a tie!";
        } else if ((userChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors")) ||
                (userChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock")) ||
                (userChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("Paper"))) {
            userWins++;
            return "You win!";
        } else {
            computerWins++;
            return "Computer wins!";
        }
    }

    private static void displayTable() {
        System.out.println("\nGame Results Table:");
        System.out.println("---------------------");
        System.out.printf("| Wins  | Losses | Ties |\n");
        System.out.printf("| %-5d | %-7d | %-4d|\n", userWins, computerWins, ties);
        System.out.println("---------------------\n");
    }
}
