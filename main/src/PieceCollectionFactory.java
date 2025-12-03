public class PieceCollectionFactory {
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

    public static PieceCollection createRedPieceCollection() {
        return createCollection(true);
    }

    public static PieceCollection createBluePieceCollection() {
         return createCollection(false);
    }

    public static PieceCollection createCollection(boolean isRed) {
        PieceCollection.PieceCollectionBuilder builder = new PieceCollection.PieceCollectionBuilder(isRed);
        return builder
                .addPieces('1', NUM_ONES_IN_GAME)
                .addPieces('2', NUM_TWOS_IN_GAME)
                .addPieces('3', NUM_THREES_IN_GAME)
                .addPieces('4', NUM_FOURS_IN_GAME)
                .addPieces('5', NUM_FIVES_IN_GAME)
                .addPieces('6', NUM_SIXES_IN_GAME)
                .addPieces('7', NUM_SEVENS_IN_GAME)
                .addPieces('8', NUM_EIGHTS_IN_GAME)
                .addPieces('9', NUM_NINES_IN_GAME)
                .addPieces('S', NUM_SPIES_IN_GAME)
                .addPieces('B', NUM_BOMBS_IN_GAME)
                .addPieces('F', NUM_FLAGS_IN_GAME)
                .build();
    }
}
