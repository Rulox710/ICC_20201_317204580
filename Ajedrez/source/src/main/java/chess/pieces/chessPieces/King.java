package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

/**
 * Clase King -Una pieza del tipo KING rey
 * @author Raúl
 */
public class King extends Piece {
	
	/**
     * Contructor de la clase 
     * @see Piece.java
     */
    public King(Position p, ColorEnum color) {
        super(p,color);
        this.type = PiecesTypeEnum.KING;
        
    }
	/**
	 * @see Piece.java -getLegalMoves
	 */
    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        if (this.legalMoves == null) {
            this.legalMoves = new LinkedList<Position>();
            // Posible movimiento derecha
            if (this.position.getX() >= 0) {
				Position nextLegalPosition = new Position(this.position.getX()+1, this.position.getY());
				Piece piece = board.getPiece(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == -1){
				} else {
                    this.legalMoves.add(nextLegalPosition);
				}
			}
			// Posible movimiento izquierda
			if (this.position.getX() < 8) {
				Position nextLegalPosition = new Position(this.position.getX()-1, this.position.getY());
				Piece piece = board.getPiece(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == -1){
				} else {
                    this.legalMoves.add(nextLegalPosition);
				}
			}
			// Posible movimiento abajo
			if (this.position.getY() >= 0) {
				Position nextLegalPosition = new Position(this.position.getX(), this.position.getY()+1);
				Piece piece = board.getPiece(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == -1){
				} else {
                    this.legalMoves.add(nextLegalPosition);
				}
			}
			// Posible movimiento arriba
			if (this.position.getY() < 8) {
				Position nextLegalPosition = new Position(this.position.getX(), this.position.getY()-1);
				Piece piece = board.getPiece(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == -1){
				} else {
                    this.legalMoves.add(nextLegalPosition);
				}
			}
			// Posible movimiento diagonal derecha abajo
			if (this.position.getX() >= 0 && this.position.getY() >= 0) {
				Position nextLegalPosition = new Position(this.position.getX()+1, this.position.getY()+1);
				Piece piece = board.getPiece(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == -1){
				} else {
                    this.legalMoves.add(nextLegalPosition);
				}
			}
			// Posible movimiento diagonal derecha arriba
			if (this.position.getX() >= 0 && this.position.getY() < 8) {
				Position nextLegalPosition = new Position(this.position.getX()+1, this.position.getY()-1);
				Piece piece = board.getPiece(nextLegalPosition);
				if (this.isAppendable(nextLegalPosition) == -1){
				} else {
                    this.legalMoves.add(nextLegalPosition);
				}
			}
			// Posible movimiento diagonal izquierda abajo
			if (this.position.getX() < 8 && this.position.getY() >= 0) {
				Position nextLegalPosition = new Position(this.position.getX()-1, this.position.getY()+1);
				Piece piece = board.getPiece(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == -1){
				} else {
                    this.legalMoves.add(nextLegalPosition);
				}
			}
			// Posible movimiento diagonal izquierda arriba
			if (this.position.getX() < 8 && this.position.getY() < 8) {
				Position nextLegalPosition = new Position(this.position.getX()-1, this.position.getY()-1);
				Piece piece = board.getPiece(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == -1){
				} else {
                    this.legalMoves.add(nextLegalPosition);
				}
			}
        }
        return this.legalMoves;
    }
    
    /**
     * @see Piece.java -equals
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof King))
            return false;

        King t = (King) obj;
        return (t.getColor() == this.getColor() 
                && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}
