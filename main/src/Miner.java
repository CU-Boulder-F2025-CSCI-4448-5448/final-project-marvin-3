public class Miner extends DecoratedMoveablePiece{
    public Miner(boolean isRed) {super(isRed, '8');}

    public String strikeResult(Piece piece) {
        Character otherValue = piece.getValue();
        if (otherValue == 'F') {
            return "WINGAME";
        } else if (otherValue == 'B') {
            return "WIN";
        } else {
            int thisNumeric = this.getValue() - '0';
            int otherNumeric;
            if (otherValue == 'S') {otherNumeric = 10;}
            else {otherNumeric= otherValue - '0';}
            if (thisNumeric < otherNumeric) {return "WIN";}
            else if (thisNumeric > otherNumeric) {return "LOSE";}
            else {return "TIE";}
        }
    }
}
