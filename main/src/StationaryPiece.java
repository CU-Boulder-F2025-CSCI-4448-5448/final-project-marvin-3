public class StationaryPiece extends Piece{
    public StationaryPiece(boolean isRed, Character value) {
        super(isRed, value);
    }

    public boolean canMove(boolean isRedTurn) {
        return false;
    }
}
