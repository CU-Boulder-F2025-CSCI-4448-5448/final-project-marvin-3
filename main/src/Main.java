import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Stratego! Play game? Yes/No");
        String input = scanner.nextLine().trim();
        switch (input) {
            case "Yes":
                GameFacade gameFacade = new GameFacade();
                gameFacade.play();
                break;
            case "No":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid input!");
        }

    }
}
