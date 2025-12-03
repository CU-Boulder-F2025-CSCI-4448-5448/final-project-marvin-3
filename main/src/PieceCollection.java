import java.util.ArrayList;

public class PieceCollection {
    private ArrayList<Piece> pieces;
    private boolean isRed;

    public PieceCollection(boolean isRed) {
        this.isRed = isRed;
    }
}
/*public static ArrayList<Piece> createRedPieces() {
    ArrayList<Piece> ones = PieceFactory.createOnes(true, NUM_ONES_IN_GAME);
    ArrayList<Piece> twos = PieceFactory.createTwos(true, NUM_TWOS_IN_GAME);
    ArrayList<Piece> threes = PieceFactory.createThrees(true, NUM_THREES_IN_GAME);
    ArrayList<Piece> fours = PieceFactory.createFours(true, NUM_FOURS_IN_GAME);
    ArrayList<Piece> fives = PieceFactory.createFives(true, NUM_FIVES_IN_GAME);
    ArrayList<Piece> sixes = PieceFactory.createSixes(true, NUM_SIXES_IN_GAME);
    ArrayList<Piece> sevens = PieceFactory.createSevens(true, NUM_SEVENS_IN_GAME);
    ArrayList<Piece> eights = PieceFactory.createEights(true, NUM_EIGHTS_IN_GAME);
    ArrayList<Piece> nines = PieceFactory.createNines(true, NUM_NINES_IN_GAME);
    ArrayList<Piece> spies = PieceFactory.createSpies(true, NUM_SPIES_IN_GAME);
    ArrayList<Piece> bombs = PieceFactory.createBombs(true, NUM_BOMBS_IN_GAME);
    ArrayList<Piece> flags = PieceFactory.createFlags(true, NUM_FLAGS_IN_GAME);
    return ones.addAll(twos).addAll(threes).add(fours).add(fives).add(sixes).add(sevens).add(eights).add(nines).add(spies).add(bombs).add(flags);


}

public static ArrayList<Piece> createBluePieces() {
    ArrayList<Piece> ones = PieceFactory.createOnes(false, NUM_ONES_IN_GAME);
    ArrayList<Piece> twos = PieceFactory.createTwos(false, NUM_TWOS_IN_GAME);
    ArrayList<Piece> threes = PieceFactory.createThrees(false, NUM_THREES_IN_GAME);
    ArrayList<Piece> fours = PieceFactory.createFours(false, NUM_FOURS_IN_GAME);
    ArrayList<Piece> fives = PieceFactory.createFives(false, NUM_FIVES_IN_GAME);
    ArrayList<Piece> sixes = PieceFactory.createSixes(false, NUM_SIXES_IN_GAME);
    ArrayList<Piece> sevens = PieceFactory.createSevens(false, NUM_SEVENS_IN_GAME);
    ArrayList<Piece> eights = PieceFactory.createEights(false, NUM_EIGHTS_IN_GAME);
    ArrayList<Piece> nines = PieceFactory.createNines(false, NUM_NINES_IN_GAME);
    ArrayList<Piece> spies = PieceFactory.createSpies(false, NUM_SPIES_IN_GAME);
    ArrayList<Piece> bombs = PieceFactory.createBombs(false, NUM_BOMBS_IN_GAME);
    ArrayList<Piece> flags = PieceFactory.createFlags(false, NUM_FLAGS_IN_GAME);
    return ones.add(twos).add(threes).add(fours).add(fives).add(sixes).add(sevens).add(eights).add(nines).add(spies).add(bombs).add(flags);


}

 static final int NUM_ONES_IN_GAME = 1;
    static final int NUM_TWOS_IN_GAME = 1;
    static final int NUM_THREES_IN_GAME = 2;
    static final int NUM_FOURS_IN_GAME = 3;
    static final int NUM_FIVES_IN_GAME = 4;
    static final int NUM_SIXES_IN_GAME = 4;
    static final int NUM_SEVENS_IN_GAME = 4;
    static final int NUM_EIGHTS_IN_GAME = 5;
    static final int NUM_NINES_IN_GAME = 8;
    static final int NUM_SPIES_IN_GAME = 1;
    static final int NUM_BOMBS_IN_GAME = 6;
    static final int NUM_FLAGS_IN_GAME = 1;
    static final int NUM_RED_PIECES = 40;
 */