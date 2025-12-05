import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameFacade {
    Scanner scanner = new Scanner(System.in);
    private boolean gameOver = false;
    boolean winner;
    Character confirmationKey;

    public GameFacade() {
    }

    public static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public boolean play() {
        setUpBoard();
        clearScreen();
        System.out.println("Pass the computer to the red player and then enter any letter+enter to continue");
        confirmationKey = scanner.next().charAt(0);
        boolean isRedTurn = true;
        while (!gameOver) {
            if (cannotMove(isRedTurn)) {
                gameOver = true;
                this.winner = !isRedTurn;
                if (winner) {
                    System.out.println("Blue cannot move and red wins!");
                }
                else {
                    System.out.println("Red cannot move and blue wins!");
                }
                break;
            }
            turn(isRedTurn);
            if (Board.flagFound) {
                gameOver = true;
                this.winner = isRedTurn;
                break;
            }
            Board.getBoard().printBoard(isRedTurn);
            System.out.println("Enter any letter+enter to clear screen");
            confirmationKey = scanner.next().charAt(0);
            clearScreen();
            System.out.println("Give computer to other player and then enter any letter+enter to continue");
            confirmationKey = scanner.next().charAt(0);
            clearScreen();
            isRedTurn = !isRedTurn;
        }
        return winner;
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
        clearScreen();
        System.out.println("Blue, it's your turn to set up the board!");
        Board.getBoard().printBoard(false);
        for (Piece piece : bluePieces) {
            placePiece(piece);
            Board.getBoard().printBoard(false);
        }
        clearScreen();
    }

    public void placePiece(Piece piece) {
        boolean validCoordinates;
        int x;
        int y;
        do {
            System.out.println("Type coordinates for " + piece);
            x = getIntSafely("X coordinate: ");
            y = getIntSafely("Y coordinate: ");
            validCoordinates = validate(x, y, piece.isRed());
            if (!validCoordinates) {
                System.out.println("Invalid coordinates!");
            }
        } while (!validCoordinates);
        Board.getBoard().addPiece(piece, x, y);

    }

    public boolean validate(int x, int y, boolean isRed) {
        if (x > 9 || x < 0 || y > 9 || y < 0) {
            System.out.println("Out of bounds!");
            return false;
        }
        if (Board.getBoard().isLakeSquare(x, y)) {
            System.out.println("This is a lake square!");
            return false;
        }
        if (Board.getBoard().squareHasPiece(x, y)) {
            System.out.println("This square is occupied!");
            return false;
        }
        else if (isRed && y <= 3) {
            return true;
        }
        else if (!isRed && y >= 6) {
            return true;
        }
        else {
            return false;
        }
    }

    public void turn(boolean isRedTurn) {
        if (isRedTurn) {System.out.println("Red's turn!");}
        else{System.out.println("Blue's turn!");}
        System.out.println(Board.messageToOtherPlayer);
        Board.getBoard().printBoard(isRedTurn);
        int xCoordStarting;
        int yCoordStarting;
        boolean validSelect;
        do {
            System.out.println("Type coordinates of piece to move");
            xCoordStarting = getIntSafely("X coordinate: ");
            yCoordStarting = getIntSafely("Y coordinate: ");
            validSelect = Board.getBoard().select(xCoordStarting,yCoordStarting,isRedTurn);
        }
        while (!validSelect);
        boolean validMove;
        do {
            System.out.println("Type coordinates of destination square");
            int xCoordEnding = getIntSafely("X coordinate: ");
            int yCoordEnding = getIntSafely("Y coordinate: ");
            validMove = Board.getBoard().move(xCoordStarting,yCoordStarting,xCoordEnding,yCoordEnding,isRedTurn);
        }
        while (!validMove);
    }

    boolean cannotMove(boolean isRedTurn) {
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                Square square = Board.getBoard().getSquare(i,j);
                if (!(square instanceof LandSquare land)) continue;

                if (!land.hasPiece()) continue;

                if (land.getPieceColor() != isRedTurn) continue;

                if (!(land.getPiece() instanceof MoveablePiece)) continue;

                if (!Board.getBoard().surrounded(i, j, isRedTurn)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getIntSafely(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException exception) {
                System.out.println("Please enter an integer!");
                scanner.nextLine();
            }
        }
    }


}
