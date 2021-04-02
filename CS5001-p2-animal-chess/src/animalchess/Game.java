package animalchess;

/**
 * A Game class which includes the attribute of class.
 * @author Mengying Chen
 * @version 1.0
 * Since 15 October 2020
 */
public class Game {

    /**
     * Initialize height of chessboard to be a public static final variable.
     */
    public static final int HEIGHT = 6;

    /**
     * Initialize width of chessboard to be a public static final variable.
     */
    public static final int WIDTH = 5;

    private Player player0;
    private Player player1;

    //Add board

    private Square[][] board = new Square[HEIGHT][WIDTH];

    /**
     * constructor.
     * @param p0 0
     * @param p1 1
     */
    public Game(Player p0, Player p1) {
        this.player0 = p0;
        this.player1 = p1;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (row >= 4) {
                    board[row][col] = new Square(this, row, col, player0);
                }
                else if (row <= 1) {
                    board[row][col] = new Square(this, row, col, player1);
                }
                else {
                    board[row][col] = new Square(this, row, col, null);
                }
            }
        }

        //Add Cats to initial setup
        new Cat(p0, board[0][0]);
        new Cat(p0, board[0][4]);
        new Cat(p1, board[5][0]);
        new Cat(p1, board[5][4]);

        //Add Dogs to initial setup
        new Dog(p0, board[0][1]);
        new Dog(p0, board[0][3]);
        new Dog(p1, board[5][1]);
        new Dog(p1, board[5][3]);

        //Add Lions to initial setup
        new Lion(p0, board[0][2]);
        new Lion(p1, board[5][2]);

        //Add Chicks to initial setup
        new Chick(p0, board[2][1]);
        new Chick(p0, board[2][2]);
        new Chick(p0, board[2][3]);
        new Chick(p1, board[3][1]);
        new Chick(p1, board[3][2]);
        new Chick(p1, board[3][3]);

    }

    /**
     * getter.
     * @param playerNumber is the number of player
     * @return player
     */
    public Player getPlayer(int playerNumber) {
        if (playerNumber == player0.getPlayerNumber()) {
            return player0;
        }
        else if (playerNumber == player1.getPlayerNumber()) {
            return player1;
        }
        throw new IllegalArgumentException();
    }

    /**
     * getter.
     * @return player who has won the game
     */
    public Player getWinner() {
        if (player0.hasWon()) {
            return player0;
        }
        else if (player1.hasWon()) {
            return player1;
        }
        return null;
    }

    /**
     * getter.
     * @param row is the horizontal coordinate of the square the chessboard
     * @param col is the vertical coordinate of thr square the chessboard
     * @return board[][]
     */
    public Square getSquare(int row, int col) {
        return board[row][col];
    }
}

