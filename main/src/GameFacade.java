import java.util.ArrayList;
import java.util.Scanner;

public class GameFacade {
    Scanner scanner = new Scanner(System.in);
    private boolean gameOver = false;
    boolean winner;
    String confirmationKey;

    public GameFacade() {
    }

    public static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public boolean play() {
        setUpBoard();
        clearScreen();
        System.out.println("Pass the computer to the red player and then press enter to continue");
        confirmationKey = scanner.nextLine();
        boolean isRedTurn = true;
        while (!gameOver) {
            if (cannotMove(isRedTurn)) {
                gameOver = true;
                this.winner = !isRedTurn;
                break;
            }
            turn(isRedTurn);
            if (Board.flagFound) {
                gameOver = true;
                this.winner = isRedTurn;
                break;
            }
            Board.getBoard().printBoard(isRedTurn);
            System.out.println("Press enter to clear screen");
            scanner.nextLine();
            confirmationKey = scanner.nextLine();
            clearScreen();
            System.out.println("Give computer to other player and then press enter to continue");
            scanner.nextLine();
            confirmationKey = scanner.nextLine();
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
            System.out.print("X coordinate: ");
            xCoordStarting = scanner.nextInt();
            System.out.print("Y coordinate: ");
            yCoordStarting = scanner.nextInt();
            validSelect = Board.getBoard().select(xCoordStarting,yCoordStarting,isRedTurn);
        }
        while (!validSelect);
        boolean validMove;
        do {
            System.out.println("Type coordinates of destination square");
            System.out.print("X coordinate: ");
            int xCoordEnding = scanner.nextInt();
            System.out.print("Y coordinate: ");
            int yCoordEnding = scanner.nextInt();
            validMove = Board.getBoard().move(xCoordStarting,yCoordStarting,xCoordEnding,yCoordEnding,isRedTurn);
        }
        while (!validMove);
    }

    boolean cannotMove(boolean isRedTurn) {
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if (!Board.getBoard().surrounded(j, i, isRedTurn)) {
                    return false;
                }
            }
        }
        return true;
    }


}
