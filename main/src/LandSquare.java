public class LandSquare extends Square {
    private Piece piece = null;

    public boolean hasPiece() {return piece != null;}

    public void printSquare(boolean isRedPerspective) {
        if (hasPiece()) {
            piece.printPiece(isRedPerspective);
        }
        else {System.out.print(" -  ");}
    }

    public boolean selectSquare(boolean isRedTurn) {
        if (!hasPiece()) {
            System.out.print("Invalid! Square is empty!");
            return false;
        }
        else {
            return piece.canMove(isRedTurn);
        }
    }

    public void addPiece(Piece piece) {
        if (hasPiece()) {throw new RuntimeException("Square already has piece!");}
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void removePiece() {
        piece = null;
    }
}
