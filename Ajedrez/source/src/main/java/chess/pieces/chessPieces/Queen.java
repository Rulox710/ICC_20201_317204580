package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

/**
 * Clase Queen -Una pieza de tipo QUEEN Reina
 * @author Raúl
 */
public class Queen extends Piece {
    
    /**
     * Contructor de la clase 
     * @see Piece.java
     */
    public Queen(Position p, ColorEnum color) {
        super(p,color);
        this.type = PiecesTypeEnum.QUEEN;        
    }
	
	/**
	 * @see Piece.java -getLegalMoves
	 */
    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        if (this.legalMoves == null) {
            this.legalMoves = new LinkedList<Position>();
            // Posibles movimientos hacia la derecha del tablero
            for(int i = this.position.getX()+1;i < 8; i++){
                Position nextLegalPosition = new Position(i, this.position.getY());
				if (this.isAppendable(nextLegalPosition) == -1) break;
				if (this.isAppendable(nextLegalPosition) == 0){
					this.legalMoves.add(nextLegalPosition);
					break;
				}
				this.legalMoves.add(nextLegalPosition);              
			}
			// Posibles movimientos hacia la izquierda del tablero
            for(int i = this.position.getX()-1;i >= 0; i--){
                Position nextLegalPosition = new Position(i, this.position.getY());
                if (this.isAppendable(nextLegalPosition) == -1) break;
				if (this.isAppendable(nextLegalPosition) == 0){
					this.legalMoves.add(nextLegalPosition);
					break;
				}
				this.legalMoves.add(nextLegalPosition);
            }
			// Posibles movimientos hacia abajo del tablero
            for(int i = this.position.getY()+1;i < 8; i++){
                Position nextLegalPosition = new Position(this.position.getX(),i);
                if (this.isAppendable(nextLegalPosition) == -1) break;
				if (this.isAppendable(nextLegalPosition) == 0){
					this.legalMoves.add(nextLegalPosition);
					break;
				}
				this.legalMoves.add(nextLegalPosition);
            }
			// Posibles movimientos hacia arriba del tablero
            for(int i = this.position.getY()-1;i >= 0; i--){
                Position nextLegalPosition = new Position(this.position.getX(),i);
                if (this.isAppendable(nextLegalPosition) == -1) break;
				if (this.isAppendable(nextLegalPosition) == 0){
					this.legalMoves.add(nextLegalPosition);
					break;
                }
                this.legalMoves.add(nextLegalPosition);               
            }
            // Posibles movimientos en diagonal hacia abajo y derecha del tablero
            for(int i = this.position.getX()+1, j = this.position.getY()+1; i < 8 && j < 8; i++, j++){
                Position nextLegalPosition = new Position(i,j);
                if (this.isAppendable(nextLegalPosition) == -1) break;
				if (this.isAppendable(nextLegalPosition) == 0){
					this.legalMoves.add(nextLegalPosition);
					break;
				}
				this.legalMoves.add(nextLegalPosition);
			}
			// Posibles movimientos en diagonal hacia arriba y derecha del tablero
			for(int i = this.position.getX()-1, j = this.position.getY()+1; i>=0 && j < 8; i--, j++){
				Position nextLegalPosition = new Position(i,j);	
				if (this.isAppendable(nextLegalPosition) == -1) break;
				if (this.isAppendable(nextLegalPosition) == 0){
					this.legalMoves.add(nextLegalPosition);
					break;
				}
				this.legalMoves.add(nextLegalPosition);
			}
			// Posibles movimientos en diagonal hacia abajo e izquierda del tablero
			for(int i = this.position.getX()+1, j = this.position.getY()-1; i < 8 && j >= 0; i++, j--){
				Position nextLegalPosition = new Position(i,j);
				if (this.isAppendable(nextLegalPosition) == -1) break;
				if (this.isAppendable(nextLegalPosition) == 0){
					this.legalMoves.add(nextLegalPosition);
					break;
				}
				this.legalMoves.add(nextLegalPosition);
			}
			// Posibles movimientos en diagonal hacia arriba e izquierda del tablero
			for(int i = this.position.getX()-1, j = this.position.getY()-1; i >= 0 && j >= 0; i--, j--){
                Position nextLegalPosition = new Position(i,j);
				if (this.isAppendable(nextLegalPosition) == -1) break;
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
     * see Piece.java -equals
     */
    @Override
    public boolean equals(Object obj) {
		if (!(obj instanceof Queen))
			return false;
        Queen t = (Queen) obj;
        return (t.getColor() == this.getColor() 
                && this.getPosition().equals(t.getPosition())) ? true : false;
    }
}
