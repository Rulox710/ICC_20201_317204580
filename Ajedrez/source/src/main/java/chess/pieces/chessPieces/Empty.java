package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
/**
 * Esta clase crea una pieza que representa la nada
 * @author Iabin
 */
public class Empty extends Piece{
	/**
	 * Constructor de la clase
	 * @see Position.java
	 * @param p Parámetro de posición
	 * @param c Parámetro de color
	 */
    public Empty(Position p, ColorEnum c){
        super(p,c);
        this.type = PiecesTypeEnum.EMPTY;
    }
    /**
     * Contructor de la clase vacío
     */
    public Empty(){
        super(new Position(0,0),ColorEnum.NONE);
        this.type = PiecesTypeEnum.EMPTY;
    }
	/**
	 * Método getLegalMoves para registrar los posibles movimientos de esta pieza
	 */
    @Override
    public List<Position> getLegalMoves() {
        return new LinkedList<>();
    }

	/**
	 * Método equals para saber si una pieza de este tipo es igual o otr pieza
	 */
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Empty)? true: false;
    }

}
