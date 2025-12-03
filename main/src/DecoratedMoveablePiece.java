public class DecoratedMoveablePiece extends MoveablePiece {
    private final MoveablePiece innerPiece;

    public DecoratedMoveablePiece(boolean isRed, Character value) {
        super(isRed, value);
        innerPiece = new MoveablePiece(isRed,value);
    }

    public Character getValue() {return innerPiece.getValue();}

}
