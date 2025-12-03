public abstract class Piece {
    private boolean isRed;
    private Character value;


    public Piece(boolean isRed, Character value) {
        this.isRed = isRed;
        this.value = value;
    }

    public boolean isRed() {return this.isRed;}

    public void printPiece(boolean isRedPerspective) {
        if (isRedPerspective == isRed) {
            System.out.print(" " + value + "  ");
        }
        else {
            System.out.print(" ?  ");
        }
    }

    public Character getValue() {return value;}

    abstract public boolean canMove();

}
