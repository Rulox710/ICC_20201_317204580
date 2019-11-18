package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

/**
 * Clase Bishop -Una pieza del tipo BISHOP alfil
 * @author Raúl
 */
public class Bishop extends Piece {
    
    /**
     * Contructor de la clase 
     * @see Piece.java
     */
    public Bishop(Position p, ColorEnum color) {
        super(p,color);
        this.type = PiecesTypeEnum.BISHOP;        
    }

	/**
	 * @see Piece.java -getLegalMoves
	 */
    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        if (this.legalMoves == null) {
            this.legalMoves = new LinkedList<Position>();
            
            // Derecha abajo
            for(int i = this.position.getX()+1, j = this.position.getY()+1; i < 8 && j < 8; i++, j++){
                Position nextLegalPosition = new Position(i,j);
                Piece piece = board.getPiece(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == -1)break;
                if (this.isAppendable(nextLegalPosition) == 0){
                    this.legalMoves.add(nextLegalPosition);
                    break;
				}
				this.legalMoves.add(nextLegalPosition);
			}
			
			// Izquierda abajo
			for(int i = this.position.getX()-1, j = this.position.getY()+1; i>=0 && j < 8; i--, j++){
				Position nextLegalPosition = new Position(i,j);
				Piece piece = board.getPiece(nextLegalPosition);	
				if (this.isAppendable(nextLegalPosition) == -1)break;
                if (this.isAppendable(nextLegalPosition) == 0){
                    this.legalMoves.add(nextLegalPosition);
                    break;
				}
				this.legalMoves.add(nextLegalPosition);
			}
			
			// Derecha arriba
			for(int i = this.position.getX()+1, j = this.position.getY()-1; i < 8 && j >= 0; i++, j--){
				Position nextLegalPosition = new Position(i,j);
				Piece piece = board.getPiece(nextLegalPosition);
				if (this.isAppendable(nextLegalPosition) == -1)break;
                if (this.isAppendable(nextLegalPosition) == 0){
                    this.legalMoves.add(nextLegalPosition);
                    break;
				}
				this.legalMoves.add(nextLegalPosition);
			}
			// Izquierda arriba
			for(int i = this.position.getX()-1, j = this.position.getY()-1; i >= 0 && j >= 0; i--, j--){
                Position nextLegalPosition = new Position(i,j);
                Piece piece = board.getPiece(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == -1)break;
                if (this.isAppendable(nextLegalPosition) == 0){
                    this.legalMoves.add(nextLegalPosition);
                    break;
				}
				this.legalMoves.add(nextLegalPosition);
			}
		}
		return this.legalMoves;
	}
    
    /**
     * @see Piece.java -equals
     */
    @Override
    public boolean equals(Object obj) {
		if (!(obj instanceof Bishop))
			return false;
        Bishop t = (Bishop) obj;
        return (t.getColor() == this.getColor() 
                && this.getPosition().equals(t.getPosition())) ? true : false;
    }
}
