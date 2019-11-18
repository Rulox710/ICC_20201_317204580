package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

/**
 * Clase Freelancer -Una pieza del tipo FREELANCER caballo
 * @author Raúl
 */
public class Freelancer extends Piece {
	
	/**
     * Contructor de la clase 
     * @see Piece.java
     */
    public Freelancer(Position p, ColorEnum color) {
        super(p,color);
        this.type = PiecesTypeEnum.FREELANCER;
        
    }

    /**
	 * @see Piece.java -getLegalMoves
	 */
    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        if (this.legalMoves == null) {
            this.legalMoves = new LinkedList<Position>();

            if(this.position.getX()+1 < 8 && this.position.getY()-2 >= 0){
				Position nextLegalPosition = new Position(this.position.getX()+1, this.position.getY()-2);
				Piece piece = board.getPiece(nextLegalPosition);
				if(piece.getColor() != this.getColor()){
					this.legalMoves.add(nextLegalPosition);
				}
			} 
			
			if(this.position.getX()-1 >= 0 && this.position.getY()-2 >= 0){
				Position nextLegalPosition = new Position(this.position.getX()-1, this.position.getY()-2);
				Piece piece = board.getPiece(nextLegalPosition);
				if(piece.getColor() != this.getColor()){
					this.legalMoves.add(nextLegalPosition);
				}
			}

			if(this.position.getX()+2 < 8 && this.position.getY()-1 >= 0){
				Position nextLegalPosition = new Position(this.position.getX()+2, this.position.getY()-1);
				Piece piece = board.getPiece(nextLegalPosition);
				if(piece.getColor() != this.getColor()){
					this.legalMoves.add(nextLegalPosition);
				}
			}
			
			if(this.position.getX()+2 < 8 && this.position.getY()+1 < 8){
				Position nextLegalPosition = new Position(this.position.getX()+2, this.position.getY()+1);
				Piece piece = board.getPiece(nextLegalPosition);
				if(piece.getColor() != this.getColor()){
					this.legalMoves.add(nextLegalPosition);
				}
			}
			
			if(this.position.getX()+1 < 8 && this.position.getY()+2 < 8){
				Position nextLegalPosition = new Position(this.position.getX()+1, this.position.getY()+2);
				Piece piece = board.getPiece(nextLegalPosition);
				if(piece.getColor() != this.getColor()){
					this.legalMoves.add(nextLegalPosition);
				}
			}
			
			if(this.position.getX()-1 >= 0 && this.position.getY()+2 < 8){
			Position nextLegalPosition = new Position(this.position.getX()-1, this.position.getY()+2);
				Piece piece = board.getPiece(nextLegalPosition);
				if(piece.getColor() != this.getColor()){
					this.legalMoves.add(nextLegalPosition);
				}
			}
			
			if(this.position.getX()-2 >= 0 && this.position.getY()+1 < 8){
				Position nextLegalPosition = new Position(this.position.getX()-2, this.position.getY()+1);
				Piece piece = board.getPiece(nextLegalPosition);
				if(piece.getColor() != this.getColor()){
					this.legalMoves.add(nextLegalPosition);
				}
			}
			
			if(this.position.getX()-2 >= 0 && this.position.getY()-1 >= 0){
				Position nextLegalPosition = new Position(this.position.getX()-2, this.position.getY()-1);
				Piece piece = board.getPiece(nextLegalPosition);
				if(piece.getColor() != this.getColor()){
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
        if (!(obj instanceof Freelancer))
            return false;
        Freelancer t = (Freelancer) obj;
        return (t.getColor() == this.getColor() 
                && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}
