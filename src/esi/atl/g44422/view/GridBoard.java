package esi.atl.g44422.view;

import esi.atl.g44422.model.GameInterface;
import esi.atl.g44422.model.Piece;
import esi.atl.g44422.model.Position;
import esi.atl.g44422.util.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Represents a board in the application.
 */
class GridBoard extends GridPane implements Observer {

    private final GameInterface game;

    /**
     * Creates a new board for the application.
     *
     * @param game the game
     */
    GridBoard(GameInterface game) {
        super();

        this.game = game;

        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setHgap(1);
        this.setVgap(1);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(0, 0, 0, 0));

        initGrid();
        putPieces(this.game.getBoard().getPiecesPut());

        this.update();
    }

    /**
     * Initializes the grid with the cells.
     */
    private void initGrid() {
        this.getChildren().clear();
        for (int j = 0; j < this.game.getBoard().getSizeY(); j++) {
            for (int i = 0; i < this.game.getBoard().getSizeX(); i++) {
                this.add(new ClickablePane(i, j, this.game), i, j, 1, 1);
            }
        }
    }

    /**
     * Adds the pieces put on onto the board.
     *
     * @param piecesPut the pieces that has been put on the board
     */
    private void putPieces(ArrayList<Piece> piecesPut) {

        for (Piece piece : piecesPut) {
            for (Position pos : piece.getShape().getCells()) {
                Position finalPos = Position.add(piece.getPosition(), pos);
                ((ClickablePane) this.getChildren().get(finalPos.getY() * this.game.getBoard().getSizeX() + finalPos.getX())).setColor(piece.getOwner());
            }
        }
    }

    /**
     * Updates the grid board.
     */
    public void update() {
        this.initGrid();
        this.putPieces(this.game.getBoard().getPiecesPut());
    }
}
