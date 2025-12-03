import java.util.Scanner;

public class GameFacade {
    Scanner scanner = new Scanner(System.in);

    public GameFacade() {

    }

    public void play() {
        //players set pieces
        //while loop for turns until one player wins
        boolean isRedTurn = true;
        boolean gameOver = false;
        while (!gameOver) {
          turn(isRedTurn);
          isRedTurn = !isRedTurn;
        }
    }

    public void turn(boolean isRedTurn) {
        //do while valid piece - put in own function?
        Board.getBoard().printBoard(isRedTurn);
        boolean validSelect = false;
        do {
            System.out.println("Type coordinates of piece to move");
            System.out.print("X coordinate: ");
            int xCoord = scanner.nextInt();
            System.out.print("Y coordinate: ");
            int yCoord = scanner.nextInt();
            validSelect = Board.getBoard().select(xCoord,yCoord);
        }
        while (!validSelect);

        //function for selecting where piece moves - do while

        //if action is strike, compare values and decide winner and move accordingly
        //if move, move
        //print hidden board showing moved

        System.out.println("Give computer to other player and enter any key");
        scanner.nextLine();
    }


}
