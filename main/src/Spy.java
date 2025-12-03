public class Spy extends DecoratedMoveablePiece {
    public Spy(boolean isRed, Character value) {super(isRed, 'S');}

    public String strikeResult(Piece piece) {
        Character otherValue = piece.getValue();
        if (otherValue == 'F') {return "WINGAME";}
        else if (otherValue == '1') {return "WIN";}
        else if (otherValue != 'S') {return "LOSE";}
        else {return "TIE";}
    }

}
