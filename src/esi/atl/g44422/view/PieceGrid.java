package esi.atl.g44422.view;

import esi.atl.g44422.model.AIPlayer;
import esi.atl.g44422.model.GameInterface;
import esi.atl.g44422.model.Piece;
import esi.atl.g44422.model.Position;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Represents a piece in the application.
 */
public class PieceGrid extends GridPane {

	private final Piece piece;
	private final GameInterface game;

	/**
	 * Creates a new piece grid.
	 *
	 * @param piece    the piece
	 * @param cellSize the size of a small cell
	 * @param game     the game
	 */
	PieceGrid(Piece piece, int cellSize, GameInterface game) {
		super();

		this.piece = piece;
		this.game = game;

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setHgap(1);
		this.setVgap(1);

		if(this.piece != null) {
			for(Position cell : this.piece.getShape().getCells()) {
				Pane pieceCell = new Pane();
				pieceCell.setPrefSize(cellSize, cellSize);
				javafx.scene.paint.Color fillColor;
				switch(this.piece.getOwner().getColor()) {
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
				Background background = new Background(new BackgroundFill(fillColor, CornerRadii.EMPTY, Insets.EMPTY));
				pieceCell.setBackground(background);
				this.add(pieceCell, cell.getX(), cell.getY());
			}
			if(!(this.piece.getOwner() instanceof AIPlayer)) {
				this.setCursor(Cursor.HAND);
				this.setOnMouseClicked((event) -> {
					if(this.game.getCurrentPlayer() == this.piece.getOwner()) {
						this.game.currentPlayerSelectsPiece(this.piece);
					}
				});
			}
		}
	}
}
