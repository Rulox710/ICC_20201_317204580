package chess.pieces.chessPieces;

import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

/**
 * Clase Rook -Una pieza de tipo ROOK Torre
 * @author Iabin
 * @see Piece.java
 */
public class Rook extends Piece {
	
	/**
	 * Costructor de la clase
	 * @see Piece.java
	 */
    public Rook(Position p, ColorEnum color) {
        super(p, color);
        this.type = PiecesTypeEnum.ROOK;
    }

	/**
	 * @see Piece.java -getLegalMoves
	 */
    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        this.legalMoves = new LinkedList<Position>();
		// Posibles movimientos hacia la derecha del tablero
        for (int i = this.position.getX() + 1; i < 8; i++) {
            Position nextLegalPosition = new Position(i, this.position.getY());
            if (this.isAppendable(nextLegalPosition) == -1)
                break;
            if (this.isAppendable(nextLegalPosition) == 0) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }
		// Posibles movimientos hacia la izquierda del tablero
        for (int i = this.position.getX() - 1; i >= 0; i--) {
            Position nextLegalPosition = new Position(i, this.position.getY());
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }
		// Posibles movimientos hacia abajo del tablero
        for (int i = this.position.getY() + 1; i < 8; i++) {
            Position nextLegalPosition = new Position(this.position.getX(), i);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }
		// Posibles movimientos hacia arriba del tablero
        for (int i = this.position.getY() - 1; i >= 0; i--) {
            Position nextLegalPosition = new Position(this.position.getX(), i);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }
        return this.legalMoves;
    }

	/**
	 * @see Piece.java -equals
	 */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Piece))return false;
        Piece p = (Piece)obj;
        if(p.getType().equals(this.type) && p.getColor().equals(this.getColor()) && p.getPosition().equals(this.position))
        return true;
        return false;
    }
}
