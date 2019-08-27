package esi.atl.g44422.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents an artificial intelligence controlled player.
 */
public class AIPlayer extends Player {

    /**
     * The game the AI player is in.
     */
    private final GameInterface game;

    /**
     * Creates a new artificial intelligence controlled player.
     *
     * @param nickname the name of the player
     * @param color the color of the player
     * @param game the game
     */
    public AIPlayer(final String nickname, final Color color, final Game game) {
        super(nickname, color);
        this.game = game;
    }

    /**
     * Let the AI player play.
     */
    synchronized void play() {

        Piece testingPiece;
        ArrayList<Piece> piecesToTest = new ArrayList<>(this.getStock());
        while (!piecesToTest.isEmpty()) {
            testingPiece = piecesToTest.get(new Random().nextInt(piecesToTest.size()));
            this.game.currentPlayerSelectsPiece(testingPiece);
            for (int flip = 0; flip < 2; flip++) {
                for (int turn = 0; turn < 4; turn++) {
                    for (int y = 0; y <= this.game.getBoard().getSizeY() - testingPiece.getShape().getSizeY(); y++) {
                        for (int x = 0; x <= this.game.getBoard().getSizeX() - testingPiece.getShape().getSizeX(); x++) {
                            this.game.currentPlayerSetsPosition(new Position(x, y));
                            if (this.game.canPutSelectedPiece()) {
                                this.game.currentPlayerPutsPiece();
                                this.game.currentPlayerEndsTurn();
                                return;
                            }
                        }
                    }
                    this.game.currentPlayerTurnsPiece();
                }
                this.game.currentPlayerFlipsPiece();
            }
            piecesToTest.remove(testingPiece);
        }
        this.game.currentPlayerSkips();
    }
}
