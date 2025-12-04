import static java.lang.Math.abs;

public class Board {
    private static final int BOARD_WIDTH = 10;
    private final Square[][] board;
    private static Board instance;
    public static boolean flagFound = false;
    public static String messageToOtherPlayer = "";

    private Board() {
        board  = new Square[BOARD_WIDTH][BOARD_WIDTH];
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if ((i==4 || i==5) && (j==2 || j==3 || j==6 || j==7)) {
                    board[i][j] = new LakeSquare();
                }
                else {
                    board[i][j] = new LandSquare();
                }
            }
        }
    }

    public static Board getBoard() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public void addPiece(Piece piece, int x, int y) {
        Square square = board[y][x];
        if (square instanceof LakeSquare) {
            throw new RuntimeException("Cannot add piece to lake square!");
        };
        if (square instanceof LandSquare landSquare){
            landSquare.addPiece(piece);
        }
    }

    public void printBoard(boolean isRedPerspective) {
        if (!isRedPerspective) {
            System.out.println("  | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
            System.out.println("-------------------------------------------");
            for (int i = 0; i < BOARD_WIDTH; i++) {
                System.out.print(i + " |");
                for (int j = 0; j < BOARD_WIDTH; j++) {
                    Square square = board[i][j];
                    square.printSquare(isRedPerspective);
                }
                System.out.print("\n");
            }
        }
        else {
            System.out.println("  | 9 | 8 | 7 | 6 | 5 | 4 | 3 | 2 | 1 | 0 |");
            System.out.println("-------------------------------------------");
            for (int i = BOARD_WIDTH - 1; i >= 0; i--) {
                System.out.print(i + " |");
                for (int j = BOARD_WIDTH - 1; j >= 0; j--) {
                    Square square = board[i][j];
                    square.printSquare(isRedPerspective);
                }
                System.out.print("\n");
            }

        }
        System.out.print("\n\n\n");
        }

    public boolean select(int xCoord, int yCoord, boolean isRedTurn) {
        Square currentSquare = board[yCoord][xCoord];
        if (currentSquare instanceof LakeSquare) {
            System.out.println("Invalid! You selected a lake square!");
            return false;
        }
        else if (surrounded(xCoord, yCoord, isRedTurn)) {
            System.out.println("Piece is not moveable!");
            return false;
        }
        else {
            LandSquare landSquare = (LandSquare) currentSquare;
            return landSquare.selectSquare(isRedTurn);
        }
    }

    public boolean surrounded(int xCoord, int yCoord, boolean isRedTurn) {
        if(board[yCoord][xCoord] instanceof LandSquare) {
            LandSquare landSquare = (LandSquare) board[yCoord][xCoord];
            if (landSquare.getPieceColor() != isRedTurn) {
                return true;
            }
        }
        else if (board[yCoord][xCoord] instanceof LakeSquare) {
            return true;
        }
        Square aboveSquare;
        Square belowSquare;
        Square rightSquare;
        Square leftSquare;
        if (xCoord<9) {
            aboveSquare = board[yCoord][xCoord+1];
            if (aboveSquare instanceof LandSquare landSquare) {
                if (!landSquare.hasPiece() || landSquare.getPieceColor() != isRedTurn) {
                    return false;
                }
            }
        }
        if (xCoord>0) {
            belowSquare = board[yCoord][xCoord-1];
            if (belowSquare instanceof LandSquare landSquare) {
                if (!landSquare.hasPiece() || landSquare.getPieceColor() != isRedTurn) {
                    return false;
                }
            }
        }
        if (yCoord<9) {
            rightSquare = board[yCoord+1][xCoord];
            if (rightSquare instanceof LandSquare landSquare) {
                if (!landSquare.hasPiece() || landSquare.getPieceColor() != isRedTurn) {
                    return false;
                }
            }
        }
        if (yCoord>0) {
            leftSquare = board[yCoord-1][xCoord];
            if (leftSquare instanceof LandSquare landSquare) {
                if (!landSquare.hasPiece() || landSquare.getPieceColor() != isRedTurn) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean squareHasPiece(int x, int y) {
        Square square = board[y][x];
        if (square instanceof LandSquare) {
            LandSquare landSquare = (LandSquare) square;
            return landSquare.hasPiece();
        }
        else {return false;}
    }

    public boolean isLakeSquare(int x, int y) {
        return board[y][x] instanceof LakeSquare;
    }

    public void strike(LandSquare squareStriking, LandSquare squareStruck) {
        MoveablePiece pieceStriking = (MoveablePiece) squareStriking.getPiece();
        Piece pieceStruck = squareStruck.getPiece();
        String result = pieceStriking.strikeResult(pieceStruck);
        if (result == "WINGAME") {
            flagFound = true;
            System.out.println("You won the game! Congratulations!");
            messageToOtherPlayer = "The opponent found your flag! Game over!";
        }
        else if (result == "WIN") {
            squareStriking.removePiece();
            squareStruck.removePiece();
            squareStruck.addPiece(pieceStriking);
            System.out.println("Your " + pieceStriking + " took the opponent's " + pieceStruck);
            messageToOtherPlayer = "The opponent took your " + pieceStruck + " with their " + pieceStriking;
        }
        else if (result == "LOSE") {
            squareStriking.removePiece();
            System.out.println("Your " + pieceStriking + " lost against the opponent's " + pieceStruck);
            messageToOtherPlayer = "The opponent lost against your " + pieceStruck + " with their " + pieceStriking;
        }
        else if (result == "TIE") {
            squareStriking.removePiece();
            squareStruck.removePiece();
            System.out.println("Your " + pieceStriking + " tied against the opponent's " + pieceStruck + " and both are removed");
            messageToOtherPlayer = "The opponent tied against your " + pieceStruck + " with their " + pieceStriking + " and both are removed";
        }
    }

    public boolean move(int xCoordStarting, int yCoordStarting, int xCoordEnding, int yCoordEnding, boolean isRedTurn) {
        if (xCoordEnding < 0 || xCoordEnding > 9 || yCoordEnding < 0 || yCoordEnding > 9) {
            System.out.println("Invalid coordinates! You can't move off the map!");
            return false;
        }
        else if (abs(xCoordEnding - xCoordStarting) + abs(yCoordEnding - yCoordStarting) != 1) {
            System.out.println("Invalid coordinates! You can't move more or less than once!");
            return false;
        }
        else if (isLakeSquare(xCoordEnding,yCoordEnding)) {
            System.out.println("Invalid coordinates! You can't move into the lake!");
            return false;
        }
        LandSquare squareStarting = (LandSquare) board[yCoordStarting][xCoordStarting];
        Piece pieceToMove = getPiece(squareStarting);
        LandSquare squareEnding = (LandSquare) board[yCoordEnding][xCoordEnding];
        Piece pieceToTake = getPiece(squareEnding);
        if (pieceToTake == null) {
            System.out.println("Moving " + pieceToMove + " to " + xCoordEnding + "," + yCoordEnding);
            squareStarting.removePiece();
            squareEnding.addPiece(pieceToMove);
            return true;
        }
        else if (pieceToTake.isRed() && isRedTurn || !pieceToTake.isRed() && !isRedTurn) {
            System.out.println("Invalid coordinates! You can't move into one of your own pieces!");
            return false;
        }
        else {
            strike(squareStarting,squareEnding);
            return true;
        }
    }

    private Piece getPiece(LandSquare square) {
        return square.getPiece();
    }
}




