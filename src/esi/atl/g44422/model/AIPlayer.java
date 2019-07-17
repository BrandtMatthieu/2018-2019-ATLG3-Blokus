package esi.atl.g44422.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents an artificial intelligence controlled player
 */
public class AIPlayer extends Player {

	private final Game game;

	/**
	 * Creates a new artificial intelligence controlled player
	 *
	 * @param nickname the name of the player
	 * @param color    the color of the player
	 * @param game     the game
	 */
	public AIPlayer(String nickname, Color color, Game game) {
		super(nickname, color);
		this.game = game;
	}

	/**
	 * Let the player play
	 */
	void play() {
		Piece testingPiece;
		ArrayList<Piece> piecesToTest = new ArrayList<>(this.getStock());
		while(!piecesToTest.isEmpty()) {
			testingPiece = piecesToTest.get(new Random().nextInt(piecesToTest.size()));
			game.currentPlayerSelectsPiece(testingPiece);
			System.out.println(this.getNickname() + " testing piece\n" + testingPiece);
			for(int j = 0; j <= game.getBoard().getSizeY() - testingPiece.getShape().getSizeY(); j++) {
				for(int i = 0; i <= game.getBoard().getSizeX() - testingPiece.getShape().getSizeX(); i++) {
					game.currentPlayerSetsPosition(new Position(i, j));
					for(int a = 0; a < 4; a++) {
						if(game.canPutSelectedPiece()) {
							game.currentPlayerPutsPiece();
							return;
						} else {
							game.currentPlayerTurnsPiece();
						}
					}
					game.currentPlayerFlipsPiece();
					for(int a = 0; a < 4; a++) {
						if(game.canPutSelectedPiece()) {
							game.currentPlayerPutsPiece();
							return;
						} else {
							game.currentPlayerTurnsPiece();
						}
					}
				}
			}
			piecesToTest.remove(testingPiece);
		}
		game.currentPlayerSkips();
	}
}
