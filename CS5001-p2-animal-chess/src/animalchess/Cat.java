package animalchess;

import java.util.ArrayList;

/**
 * A Cat class extends from Promotable class.
 * @author Mengying Chen
 * @version 1.0
 * Since 15 October 2020
 */
public class Cat extends PromotablePiece {

    /**
     * constructor.
     * @param owner is the player who owns the cat piece
     * @param square is the situation where the cat piece is placed
     */
    public Cat(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * getter.
     * @return square[][] is the legalMoves list of cat
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        ArrayList<Square> result = new ArrayList<Square>();
        Game game = getSquare().getGame();

        int row = getSquare().getRow();
        int col = getSquare().getCol();

        int forward = 1 - 2 * getOwner().getPlayerNumber();
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i < 0 || i > 5 || j < 0 || j > 4) {
                    continue;
                }
                if ((getIsPromoted()) && (i == row - forward && (j == col - 1 || j == col + 1))) {
                    continue;
                }
                if ((!getIsPromoted()) && ((i == row - forward && j == col) || i == row)) {
                    continue;
                }
                if (game.getSquare(i, j).getPiece() == null || !game.getSquare(i, j).getPiece().getOwner().equals(getOwner())) {
                    result.add(game.getSquare(i, j));
                }
            }
        } return result;
    }
}
