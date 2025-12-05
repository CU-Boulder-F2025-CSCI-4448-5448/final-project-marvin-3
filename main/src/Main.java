import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StatsManager.printStats();
        System.out.println("Play new game? Yes/No");
        String input = scanner.nextLine().trim();
        switch (input) {
            case "Yes":
                System.out.print("Enter initials for RED player: ");
                String redInitials = scanner.nextLine().trim().toUpperCase();

                System.out.print("Enter initials for BLUE player: ");
                String blueInitials = scanner.nextLine().trim().toUpperCase();

                GameFacade gameFacade = new GameFacade();
                boolean redWon = gameFacade.play();

                if (redWon) {
                    StatsManager.recordWin(redInitials);
                } else {
                    StatsManager.recordWin(blueInitials);
                }
                break;
            case "No":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid input!");
        }

    }
}
