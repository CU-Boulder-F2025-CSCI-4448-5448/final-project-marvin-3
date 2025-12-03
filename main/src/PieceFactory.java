import java.util.ArrayList;
import java.util.Arrays;

public class PieceFactory {


    public static Piece createOne(boolean isRed) {
        return new MoveablePiece(isRed, '1');
    }

    public static Piece createTwo(boolean isRed) {
        return new MoveablePiece(isRed, '2');
    }

    public static Piece createThree(boolean isRed) {
        return new MoveablePiece(isRed, '3');
    }

    public static Piece createFour(boolean isRed) {
        return new MoveablePiece(isRed, '4');
    }

    public static Piece createFive(boolean isRed) {
        return new MoveablePiece(isRed, '5');
    }

    public static Piece createSix(boolean isRed) {
        return new MoveablePiece(isRed, '6');
    }

    public static Piece createSeven(boolean isRed) {
        return new MoveablePiece(isRed, '7');
    }

    public static Piece createEight(boolean isRed) {
        return new MoveablePiece(isRed, '8');
    }

    public static Piece createNine(boolean isRed) {
        return new MoveablePiece(isRed, '9');
    }

    public static Piece createSpy(boolean isRed) {
        return new Spy(isRed);
    }

    public static Piece createBomb(boolean isRed) {
        return new Bomb(isRed);
    }

    public static Piece createFlag(boolean isRed) {
        return new Flag(isRed);
    }
}



