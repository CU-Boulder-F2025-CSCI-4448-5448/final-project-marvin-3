public class Board {
    private static int BOARD_WIDTH = 10;
    private Square[][] board;
    private static Board instance;

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
        Square square = board[x][y];
        if (square instanceof LakeSquare) {
            throw new RuntimeException("Cannot add piece to lake square!");
        };
        if (square instanceof LandSquare landSquare){
            landSquare.addPiece(piece);
        }
    }

    public void printBoard(boolean isRedPerspective) {
        if (isRedPerspective) {
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

    public boolean select(int xCoord, int yCoord) {
        Square currentSquare = board[xCoord][yCoord];
        if (currentSquare.equals(new LakeSquare())) {return false;}
        else {
            LandSquare landSquare = (LandSquare) currentSquare;
            return landSquare.selectSquare();
        }
    }

    public boolean squareHasPiece(int x, int y) {
        Square square = board[x][y];
        if (square instanceof LandSquare) {
            LandSquare landSquare = (LandSquare) square;
            return landSquare.hasPiece();
        }
        else {return false;}
    }

    public boolean isLakeSquare(int x, int y) {
        return board[x][y] instanceof LakeSquare;
    }

    public void strike(int xCoordStriking, int yCoordStriking, int xCoordStruck, int yCoordStruck) {

    }
}

    //public void printBoardHidden() {}




