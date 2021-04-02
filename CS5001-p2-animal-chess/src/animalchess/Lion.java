package animalchess;

import java.util.ArrayList;

/**
 * A Lion class extends from Piece class.
 * @author Mengying Chen
 * @version 1.0
 * Since 15 October 2020
 */

public class Lion extends Piece {

    /**
     * constructor.
     * @param owner is the player who owns the lion piece
     * @param square is the situation where the lion piece is placed
     */
    public Lion(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * getter.
     * @return square[][] is the legalMoves list of lion
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        ArrayList<Square> result = new ArrayList<Square>();
        Game game = getSquare().getGame();

        int row = getSquare().getRow();
        int col = getSquare().getCol();

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i < 0 || i > 5 || j < 0 || j > 4) {
                    continue;
                }
                if (game.getSquare(i, j).getPiece() == null
                        || !game.getSquare(i, j).getPiece().getOwner().equals(getOwner())) {
                    result.add(game.getSquare(i, j));
                }
            }
        }
        return result;
    }

    /**
     * The capturer who capture the lion is the winner.
     * @param capturer is the player who capture the lion piece
     */
    @Override
    public void beCaptured(Player capturer) {
        super.beCaptured(capturer);
        capturer.winGame();
    }
}
