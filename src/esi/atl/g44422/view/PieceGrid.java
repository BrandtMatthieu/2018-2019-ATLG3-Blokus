package esi.atl.g44422.view;

import esi.atl.g44422.model.AIPlayer;
import esi.atl.g44422.model.Game;
import esi.atl.g44422.model.Piece;
import esi.atl.g44422.model.Position;
import javafx.geometry.Insets;
import javafx.scene.layout.*;

/**
 * Represents a piece in the application
 */
class PieceGrid extends GridPane {
	/**
	 * @param piece    the piece
	 * @param cellSize the size of a small cell
	 * @param game     the game
	 */
	public PieceGrid(Piece piece, int cellSize, Game game) {
		super();
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setHgap(1);
		this.setVgap(1);

		for(Position cell : piece.getShape().getCells()) {
			Pane pieceCell = new Pane();
			pieceCell.setPrefSize(cellSize, cellSize);
			javafx.scene.paint.Color fillColor;
			switch(piece.getOwner().getColor()) {
				case RED:
					fillColor = javafx.scene.paint.Color.RED;
					break;
				case BLUE:
					fillColor = javafx.scene.paint.Color.BLUE;
					break;
				case GREEN:
					fillColor = javafx.scene.paint.Color.GREEN;
					break;
				case YELLOW:
					fillColor = javafx.scene.paint.Color.YELLOW;
					break;
				default:
					fillColor = javafx.scene.paint.Color.TRANSPARENT;
			}
			Background background = new Background(new BackgroundFill(fillColor, CornerRadii.EMPTY, Insets.EMPTY));
			pieceCell.setBackground(background);
			this.add(pieceCell, cell.getX(), cell.getY());
		}
		if(!(piece.getOwner() instanceof AIPlayer)) {
			this.setOnMouseClicked((event) -> {
				if(game.getCurrentPlayer() == piece.getOwner()) {
					game.currentPlayerSelectsPiece(piece);
				}
			});
		}
	}
}
