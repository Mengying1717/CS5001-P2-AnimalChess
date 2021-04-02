package animalchess;

import java.util.ArrayList;

/**
 * A abstract Piece class.
 * @author Mengying Chen
 * @version 1.0
 * Since 15 October 2020
 */
public abstract class Piece {

    private Player owner;
    private Square square;

    /**
     * constructor.
     * @param owner is player who own this piece
     * @param square is the situation where the piece is placed
     */
    public Piece(Player owner, Square square) {
        this.owner = owner;
        this.square = square;
        square.placePiece(this);
    }

    /**
     * Create a legalMoves list.
     * @return ArrayList<Square>
     */
    public abstract ArrayList<Square> getLegalMoves();

    /**
     * The rule about how to move the piece.
     * @param toSquare is the square of destination for moving
     */
    public void move(Square toSquare) {
        if (square != null) {
            square.removePiece();
        }
        if (toSquare.getPiece() != null && toSquare.getPiece().owner != this.owner) {
            toSquare.getPiece().beCaptured(this.owner);
            this.square = toSquare;
        }
        toSquare.placePiece(this);
        this.square = toSquare;
    }

    /**
     * The procoes of being captured.
     * @param capturer is the player who capture the piece of opponent.
     */
    public void beCaptured(Player capturer) {
        this.owner = capturer;
        capturer.addPieceToHand(this);
        this.square.removePiece();
        square = null;
    }

    /**
     * getter.
     * @return square
     */
    public Square getSquare() {
        this.square = square;
        return square;
    }

    /**
     * getter.
     * @return player
     */
    public Player getOwner() {
        this.owner = owner;
        return owner;
    }

}
