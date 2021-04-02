package animalchess;

/**
 * A square class which includes the attribute of piece square.
 * @author Mengying Chen
 * @version 1.0
 * Since 15 October 2020
 */
public class Square {

    private int row;
    private int col;
    private Game game;
    private Player promotesPlayer;
    private Piece piece;

    /**
     * constructor.
     * @param game is this game including two players
     * @param row is the row of the square
     * @param col id the col of the square
     */
    public Square(Game game, int row, int col) {
        this.game = game;
        this.row = row;
        this.col = col;
    }

    /**
     * constructor.
     * @param game is this game including two players
     * @param row is the horizontal coordinate of the square
     * @param col is the vertical coordinate of thr square
     * @param promotesPlayer is the player whose piece has promoted successfully
     */
    public Square(Game game, int row, int col, Player promotesPlayer) {
        this.game = game;
        this.row = row;
        this.col = col;
        this.promotesPlayer = promotesPlayer;
    }

    /**
     * When the piece is moved to another square, the value piece of this square will change.
     * @param piece is moved
     */
    public void placePiece(Piece piece) {
        if (this.piece != null) {
            throw new IllegalArgumentException("placePiece attempts to place");
        }
        else {
            this.piece = piece;
        }
    }

    /**
     * When the piece is removed from a square, the value of piece in this square will be null.
     */
    public void removePiece() {
        this.piece = null;
    }

    /**
     *When player is in the isPromotionZone, if the player is the promotes player, return true.
     * @param player is the player whose piece is in the promotion zone.
     * @return promotesPlayer
     */
    public boolean isPromotionZone(Player player) {
        return player.equals(promotesPlayer);
    }

    /**
     * getter.
     * @return game
     */
    public Game getGame() {
        return game;
    }

    /**
     * getter.
     * @return piece
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * getter.
     * @return row
     */
    public int getRow() {
        return row;

    }

    /**
     * getter.
     * @return col
     */
    public int getCol() {
        return col;

    }

}
