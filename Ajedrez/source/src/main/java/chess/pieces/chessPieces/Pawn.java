package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

/**
 * Clase Pawn -Una pieza del tipo PAWN Peon
 * @author Raúl
 */
public class Pawn extends Piece {
	
	/**
     * Contructor de la clase 
     * @see Piece.java
     */
    public Pawn(Position p, ColorEnum color) {
        super(p,color);
        this.type = PiecesTypeEnum.PAWN;
        
    }
    
    /**
	 * @see Piece.java -getLegalMoves
	 */
    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        if (this.legalMoves == null) {
            this.legalMoves = new LinkedList<Position>();
			// Para color negro
			if (this.getColor() == ColorEnum.BLACK){
				// Posible movimiento uno
				if (this.position.getY() >= 0) {
					Position nextLegalPosition = new Position(this.position.getX(), this.position.getY()+1);
					Piece piece = board.getPiece(nextLegalPosition);
					if(piece.getColor() == ColorEnum.NONE){
						this.legalMoves.add(nextLegalPosition);
					}
				}
				// Posible movimiento dos
				if (this.position.getY() >= 0 && this.position.getY() == 1){
					Position nextLegalPosition = new Position(this.position.getX(), this.position.getY()+2);
					Piece piece = board.getPiece(nextLegalPosition);
					if(piece.getColor() == ColorEnum.NONE){
						this.legalMoves.add(nextLegalPosition);
					}
				}
				// Posible movimiento en diagonal derecha
				if (this.position.getY() >= 0 && this.position.getX() >= 0){
					Position nextLegalPosition = new Position(this.position.getX()+1, this.position.getY()+1);
					Piece piece = board.getPiece(nextLegalPosition);
					if(piece.getColor() == ColorEnum.WHITE){
						this.legalMoves.add(nextLegalPosition);
					}
				}
				// Posible movimiento en diagonal izquierda
				if (this.position.getY() >= 0 && this.position.getX() < 8){
					Position nextLegalPosition = new Position(this.position.getX()-1, this.position.getY()+1);
					Piece piece = board.getPiece(nextLegalPosition);
					if(piece.getColor() == ColorEnum.WHITE){
						this.legalMoves.add(nextLegalPosition);
					}
				}
			}
			// Para blanco
			if (this.getColor() == ColorEnum.WHITE) {
				// Posible uno adelante
				if (this.position.getY() < 8) {
					Position nextLegalPosition = new Position(this.position.getX(), this.position.getY()-1);
					Piece piece = board.getPiece(nextLegalPosition);
					if(piece.getColor() == ColorEnum.NONE){
						this.legalMoves.add(nextLegalPosition);
					}
				}
				// Posible dos adelante
				if (this.position.getY() < 8 && this.position.getY() == 6){
					Position nextLegalPosition = new Position(this.position.getX(), this.position.getY()-2);
					Piece piece = board.getPiece(nextLegalPosition);
					if(piece.getColor() == ColorEnum.NONE){
						this.legalMoves.add(nextLegalPosition);
					}
				}
				// Posible diagonal derecha
				if (this.position.getY() < 8 && this.position.getX() >= 0){
					Position nextLegalPosition = new Position(this.position.getX()+1, this.position.getY()-1);
					Piece piece = board.getPiece(nextLegalPosition);
					if(piece.getColor() == ColorEnum.BLACK){
						this.legalMoves.add(nextLegalPosition);
					}
				}
				// Posible diagonal izquierda
				if (this.position.getY() < 8 && this.position.getX() < 8){
					Position nextLegalPosition = new Position(this.position.getX()-1, this.position.getY()-1);
					Piece piece = board.getPiece(nextLegalPosition);
					if(piece.getColor() == ColorEnum.BLACK){
						this.legalMoves.add(nextLegalPosition);
					}
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
        if (!(obj instanceof Pawn))
            return false;

        Pawn t = (Pawn) obj;
        return (t.getColor() == this.getColor() 
                && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}
