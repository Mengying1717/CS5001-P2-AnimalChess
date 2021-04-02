package animalchess;

import java.util.ArrayList;

/**
 * A player class which includes the attribute of player.
 * @author Mengying Chen
 * @version 1.0
 * Since 15 October 2020
 */
public class Player {
    private String name;
    private int playerNumber;
    private ArrayList<Piece> handPieces;
    private boolean hasWon;

    /**
     * constructor.
     * @param name is the name of player
     * @param playerNumber is the number of player
     */
    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
        handPieces = new ArrayList<Piece>();
        hasWon = false;
    }

    /**
     * getter.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter.
     * @return playerNumber
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * getter.
     * @return handPiece
     */
    public ArrayList<Piece> getHand() {
        return handPieces;
    }

    /**
     * When the piece is captured, the piece will be add the hand.
     * @param piece which is captured
     */
    public void addPieceToHand(Piece piece) {
        handPieces.add(piece);
    }

    /**
     * When the piece is dropped, the piece will be removed from hand.
     * @param piece is which piece is added to the hand
     * @param square is where the piece will be move to
     */
    public void dropPiece(Piece piece, Square square) {
        if (!handPieces.contains(piece)) {
            throw new IllegalArgumentException("player" + playerNumber + "tries to drop a piece that is not in his hand");
        }
        else {
            handPieces.remove(piece);
            piece.move(square);
        }
    }

    /**
     * When the lion is captured, one of the player win the game, hasWon will be true.
     */
    public void winGame() {
        hasWon = true;
    }

    /**
     * When a player has won, the player get winner.
     * @return hasWon
     */
    public boolean hasWon() {
        return hasWon;
    }
}
