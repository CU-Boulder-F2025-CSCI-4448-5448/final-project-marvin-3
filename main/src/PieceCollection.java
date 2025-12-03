import java.util.ArrayList;

public class PieceCollection {
    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    private PieceCollection(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
    public ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    public static class PieceCollectionBuilder {
        private final boolean isRed;
        private final ArrayList<Piece> pieces = new ArrayList<>();

        private static final int NUM_PIECES_IN_COLLECTION = 40;


        public PieceCollectionBuilder(boolean isRed) {
            this.isRed = isRed;
        }


        public PieceCollectionBuilder addPieces(char rank, int count) {
            switch (rank) {
                case '1': {
                    for (int i = 0; i < count; i++) {
                        pieces.add(PieceFactory.createOne(isRed));
                    }
                    break;
                }

                case '2': {
                    for (int i = 0; i < count; i++) {
                        pieces.add(PieceFactory.createTwo(isRed));
                    }
                    break;
                }
                case '3': {
                    for (int i = 0; i < count; i++) {
                        pieces.add(PieceFactory.createThree(isRed));
                    }
                    break;
                }
                case '4': {
                    for (int i = 0; i < count; i++) {
                        pieces.add(PieceFactory.createFour(isRed));
                    }
                    break;
                }
                case '5': {
                    for (int i = 0; i < count; i++) {
                        pieces.add(PieceFactory.createFive(isRed));
                    }
                    break;
                }
                case '6': {
                    for (int i = 0; i < count; i++) {
                        pieces.add(PieceFactory.createSix(isRed));
                    }
                    break;
                }
                case '7': {
                    for (int i = 0; i < count; i++) {
                        pieces.add(PieceFactory.createSeven(isRed));
                    }
                    break;
                }
                case '8': {
                    for (int i = 0; i < count; i++) {
                        pieces.add(PieceFactory.createEight(isRed));
                    }
                    break;
                }
                case '9': {
                    for (int i = 0; i < count; i++) {
                        pieces.add(PieceFactory.createNine(isRed));
                    }
                    break;
                }
                case 'S': {
                    for (int i = 0; i < count; i++) {
                        pieces.add(PieceFactory.createSpy(isRed));
                    }
                    break;
                }
                case 'B': {
                    for (int i = 0; i < count; i++) {
                        pieces.add(PieceFactory.createBomb(isRed));
                    }
                    break;
                }
                case 'F': {
                    for (int i = 0; i < count; i++) {
                        pieces.add(PieceFactory.createFlag(isRed));
                    }
                    break;
                }
                default: {
                    break;
                }

            }

            return this;
        }

        public PieceCollection build() {
            if (this.pieces.size() == NUM_PIECES_IN_COLLECTION) {
                return new PieceCollection(this.pieces);
            }
            else {
                throw new RuntimeException("Piece collection failed to build!");
            }
        }
    }



}
