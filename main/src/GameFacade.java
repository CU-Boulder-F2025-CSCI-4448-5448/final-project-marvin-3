import java.util.ArrayList;
import java.util.Scanner;

public class GameFacade {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Piece> redPieces = new ArrayList<Piece>();
    ArrayList<Piece> bluePieces = new ArrayList<Piece>();
    ArrayList<Piece> takenRedPieces = new ArrayList<Piece>();
    ArrayList<Piece> takenBluePieces = new ArrayList<Piece>();
    boolean winner;

    public GameFacade() {
        //redPieces = PieceFactory.createRedPieces();
        //bluePieces = PieceFactory.createBluePieces();
    }

    public void play() {
        placePieces();
        //while loop for turns until one player wins
        boolean isRedTurn = true;
        boolean gameOver = false;
        while (!gameOver) {
            if (cannotMove(isRedTurn)) {
                gameOver = true;
                this.winner = !isRedTurn;
                break;
            }
            turn(isRedTurn);
            isRedTurn = !isRedTurn;
        }
    }

    public void placePieces() {
        //place pieces
    }



    public void turn(boolean isRedTurn) {
        //do while valid piece - put in own function?
        Board.getBoard().printBoard(isRedTurn);
        System.out.println("Type coordinates of piece to move");
        System.out.print("X coordinate: ");
        int xCoord = scanner.nextInt();
        System.out.print("Y coordinate: ");
        int yCoord = scanner.nextInt();

        //function for selecting where piece moves - do while

        //if action is strike, compare values and decide winner and move accordingly
        //if move, move
        //print hidden board showing moved


        System.out.println("Give computer to other player and enter any key");
        scanner.nextLine();
    }

    boolean cannotMove(boolean isRedTurn) {
        return false;
    }


}
