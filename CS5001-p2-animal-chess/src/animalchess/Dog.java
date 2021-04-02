package animalchess;

import java.util.ArrayList;

/**
 * A Dog class extends from Piece class.
 * @author Mengying Chen
 * @version 1.0
 * Since 15 October 2020
 */
public class Dog extends Piece {

    /**
     * constructor.
     * @param owner is the player who owns the dog piece
     * @param square is the situation where the dog piece is placed
     */
    public Dog(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * getter.
     * @return square[][] is the legalMoves list of dog
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
                if (i == row - forward && (j == col - 1 || j == col + 1)) {
                    continue;
                }
                if (game.getSquare(i, j).getPiece() == null || !game.getSquare(i, j).getPiece().getOwner().equals(getOwner())) {
                    result.add(game.getSquare(i, j));
                }
            }
        } return result;
    }
}

