public class DecoratedMoveablePiece extends MoveablePiece {
    private final BasicMoveablePiece innerPiece;

    public DecoratedMoveablePiece(boolean isRed, Character value) {
        super(isRed, value);
        innerPiece = new BasicMoveablePiece(isRed,value);
    }

    public Character getValue() {return innerPiece.getValue();}

}
