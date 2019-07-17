package esi.atl.g44422.view;

import esi.atl.g44422.model.Board;
import esi.atl.g44422.model.Game;
import esi.atl.g44422.model.Piece;
import esi.atl.g44422.model.Position;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Represents a board in the application
 */
class GridBoard extends GridPane {

	private final Board board;

	/**
	 * Creates a new board for the application
	 *
	 * @param game the game
	 */
	public GridBoard(Game game) {
		super();
		this.board = game.getBoard();
		this.setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setHgap(1);
		this.setVgap(1);
		this.setAlignment(Pos.CENTER);

		initGrid(game);
		putPieces(board.getPiecesPut());
	}

	/**
	 * Initializes the grid with the cells
	 *
	 * @param game the game
	 */
	private void initGrid(Game game) {
		this.getChildren().clear();
		for(int j = 0; j < board.getSizeY(); j++) {
			for(int i = 0; i < board.getSizeX(); i++) {
				this.add(new ClickablePane(i, j, game), i, j, 1, 1);
			}
		}
	}

	/**
	 * Adds the pieces put on onto the board
	 *
	 * @param piecesPut the pieces that has been put on the board
	 */
	private void putPieces(ArrayList<Piece> piecesPut) {
		for(Piece piece : piecesPut) {
			for(Position pos : piece.getShape().getCells()) {
				Pane cell = new Pane();

				javafx.scene.paint.Color fillColor;
				switch(piece.getOwner().getColor()) {
					case RED:
						fillColor = Color.RED;
						break;
					case BLUE:
						fillColor = Color.BLUE;
						break;
					case GREEN:
						fillColor = Color.GREEN;
						break;
					case YELLOW:
						fillColor = Color.YELLOW;
						break;
					default:
						fillColor = Color.TRANSPARENT;
				}
				cell.setBackground(new Background(new BackgroundFill(fillColor, CornerRadii.EMPTY, Insets.EMPTY)));

				GridBoard.setConstraints(cell, pos.getX() + piece.getPosition().getX(), pos.getY() + piece.getPosition().getY());
				this.getChildren().set(((pos.getX() + piece.getPosition().getX()) + (pos.getY() + piece.getPosition().getY()) * this.board.getSizeX()), cell);
			}
		}
	}
}
