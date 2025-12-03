public abstract class Piece {
    private boolean isRed;
    private Character value;


    public Piece(boolean isRed, Character value) {
        this.isRed = isRed;
        this.value = value;
    }

    public void printPiece(boolean isRedPerspective) {
        if (isRedPerspective == isRed) {
            System.out.print(" " + value + "  ");
        }
        else {
            System.out.print(" ?  ");
        }
    }
}
