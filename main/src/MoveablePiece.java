public class MoveablePiece extends Piece {
    public MoveablePiece(boolean isRed, Character value) {
        super(isRed, value);
    }

    public boolean canMove(boolean isRedTurn) {
        System.out.println("Invalid selection!");
        return (isRedTurn && isRed()) || (!isRedTurn && !isRed());
    }

    public String strikeResult(Piece piece) {
        Character otherValue = piece.getValue();
        if (otherValue == 'F') {
            return "WINGAME";
        } else if (otherValue == 'B') {
            return "LOSE";
        } else {
            int thisNumeric = this.getValue() - '0';
            int otherNumeric;
            if (otherValue == 'S') {otherNumeric = 10;}
            else {otherNumeric = otherValue - '0';}
            if (thisNumeric < otherNumeric) {return "WIN";}
            else if (thisNumeric > otherNumeric) {return "LOSE";}
            else {return "TIE";}
        }
    }

}