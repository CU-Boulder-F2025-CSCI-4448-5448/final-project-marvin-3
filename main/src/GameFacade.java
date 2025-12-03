import java.util.ArrayList;
import java.util.Scanner;

public class GameFacade {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Piece> takenRedPieces = new ArrayList<Piece>();
    ArrayList<Piece> takenBluePieces = new ArrayList<Piece>();
    boolean winner;

    public GameFacade() {
    }

    public void play() {
        setUpBoard();
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

    public void setUpBoard() {
        ArrayList<Piece> redPieces = PieceCollectionFactory.createRedPieceCollection().getPieces();
        ArrayList<Piece> bluePieces = PieceCollectionFactory.createBluePieceCollection().getPieces();
        System.out.println("Red, it's your turn to set up the board!");
        Board.getBoard().printBoard(true);
        for (Piece piece : redPieces) {
            placePiece(piece);
            Board.getBoard().printBoard(true);
        }
        //clear terminal
        System.out.println("Blue, it's your turn to set up the board!");
        Board.getBoard().printBoard(false);
        for (Piece piece : bluePieces) {
            placePiece(piece);
            Board.getBoard().printBoard(true);
        }
        //clear terminal
    }

    public void placePiece(Piece piece) {
        boolean validCoordinates = true;
        int x;
        int y;
        do {
            System.out.println("Type coordinates for " + piece);
            System.out.print("X coordinate: ");
            x = scanner.nextInt();
            System.out.print("Y coordinate: ");
            y = scanner.nextInt();
            validCoordinates = validate(x, y, piece.isRed());
            if (!validCoordinates) {
                System.out.println("Invalid coordinates!");
            }
        } while (!validCoordinates);
        Board.getBoard().addPiece(piece, x, y);

    }

    public boolean validate(int x, int y, boolean isRed) {
        if (Board.getBoard().isLakeSquare(x, y)) {return false;}
        if (Board.getBoard().squareHasPiece(x, y)) {return false;}
        else if (x >= 0 && x <= 9 && isRed && (y >= 0 && y <= 3)) {
            return true;
        }
        else if (x >= 0 && x <= 9 && !isRed && (y >= 6 && y <= 9)) {
            return true;
        }
        else {
            return false;
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

    boolean cannotMove(boolean isRedTurn) {
        return false;
    }


}
