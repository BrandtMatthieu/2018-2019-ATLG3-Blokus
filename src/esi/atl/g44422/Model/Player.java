package esi.atl.g44422.Model;

import java.util.ArrayList;

/**
 * Represents a player in the game
 */
public class Player {

    private String nickname;
    private ArrayList<Piece> stock;
    private ArrayList<Piece> piecesPut;
    private Color color;

    private static final boolean[][][] defaultPieces = {
        {
            {true}
        },
        {
            {true},
            {true}
        },
        {
            {true},
            {true},
            {true}
        },
        {
            {true, false},
            {true, true}
        },
        {
            {true},
            {true},
            {true},
            {true}
        },
        {
            {true, false},
            {true, false},
            {true, true}
        },
        {
            {true, false},
            {true, true},
            {true, false}
        },
        {
            {true, true},
            {true, true}
        },
        {
            {true, true, false},
            {false, true, true}
        },
        {
            {true},
            {true},
            {true},
            {true},
            {true}
        },
        {
            {false, true},
            {false, true},
            {false, true},
            {true, true}
        },
        {
            {false, true},
            {false, true},
            {true, true},
            {true, false}
        },
        {
            {false, true},
            {true, true},
            {true, true}
        },
        {
            {true, true},
            {false, true},
            {true, true}
        },
        {
            {true, false},
            {true, true},
            {true, false},
            {true, false},},
        {
            {false, true, false},
            {false, true, false},
            {true, true, true},},
        {
            {true, false, false},
            {true, false, false},
            {true, true, true}
        },
        {
            {true, true, false},
            {false, true, true},
            {false, true, true}
        },
        {
            {true, false, false},
            {true, true, true},
            {false, false, true}
        },
        {
            {true, false, false},
            {true, true, true},
            {false, true, false}
        },
        {
            {false, true, false},
            {true, true, true},
            {false, true, false}
        }
    };

    /**
     * Creates a new player for the game
     * @param nickname the nickname of the player
     * @param color the color of the player
     */
    public Player(String nickname, Color color) {
        this.nickname = nickname;
        this.color = color;
        this.stock = new ArrayList<Piece>();
        this.piecesPut = new ArrayList<Piece>();
        this.initStock();
    }

    /**
     * Returns the nickname of the player
     * @return the nickname of the player
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * Returns the color of the player
     * @return the color of the player
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Returns the stock of pieces of the player
     * @return the stock of pieces of the player
     */
    public ArrayList<Piece> getStock() {
        return this.stock;
    }

    /**
     * Initializes the stock of pieces of the player
     */
    private void initStock() {
        for (boolean[][] piece : this.defaultPieces) {
            this.stock.add(new Piece(piece, this.color));
        }
    }

    /**
     * Returns the score of the player
     * @return the score of the player
     */
    public int getScore() {
        int score = 0;
        for (Piece piece : this.piecesPut) {
            score += piece.getValue();
        }
        return score;
    }

    /**
     * Add a piece to the put pieces list
     * @param piece the put piece
     */
    public void addPutPiece(Piece piece) {
        this.piecesPut.add(piece);
    }
}
