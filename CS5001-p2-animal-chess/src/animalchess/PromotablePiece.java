package animalchess;

/**
 * A PromotablePiece class extends from Piece class.
 * @author Mengying Chen
 * @version 1.0
 * Since 15 October 2020
 */
public abstract class PromotablePiece extends Piece {
    private boolean isPromoted;
    private Square square;

    /**
     * The attributes of promotable piece.
     * @param owner is the player who owns the promotable piece
     * @param square is the situation where the promotable piece is on
     */
    public PromotablePiece(Player owner, Square square) {
        super(owner, square);
        isPromoted = false;
    }

    /**
     * getter.
     * @return isPromoted
     */
    public boolean getIsPromoted() {
        return isPromoted;
    }

    /**
     * When isPromoted is true, the piece promote successfully.
     */
    public void promote() {
        isPromoted = true;
    }

    /**
     * The rule about how to move the piece.
     * @param toSquare is the square of destination for moving
     */
    @Override
    public void move(Square toSquare) {
        if (toSquare.isPromotionZone(getOwner())) {
            super.move(toSquare);
            promote();
        }
        else {
            super.move(toSquare);
        }
   }

    /**
     * The procoes of being captured.
     * @param capturer is who capture the piece of opponent.
     */
    @Override
    public void beCaptured(Player capturer) {
        super.beCaptured(capturer);
        isPromoted = false;
    }
}
