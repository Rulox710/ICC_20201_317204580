package chess.pieces;
import java.util.List;
import chess.items.Board;
import chess.items.Position;

/**
 * Clase abstracta Piece -Para definir piezas 
 */
public abstract class Piece{
    protected Position position;
    protected List<Position> legalMoves = null;
    protected PiecesTypeEnum type;
    protected ColorEnum color;
    protected Board board;

	/**
	 * Contructor
	 * @param p -Posición en el tablero de la pieza
	 * @param c -Color de la pieza 
	 */
    public Piece(Position p, ColorEnum color) {
        this.position = p;
        this.color = color;
    }

	/**
	 * Método isAppenable -Dada una pieza y una posición, devuelve un entero en relación al color entre la pieza y la posición
	 * @param p -Una posición
	 */
    public int isAppendable(Position p){
        Board board = Board.getInstance();
        Piece piece = board.getPiece(p);
        if(piece.getColor() == this.getColor())return -1;
        if(piece.getColor() != ColorEnum.NONE)return 0;
        return 1; //NONE
    }
    
    /**
     * Método observador de la posición
     * @return position
     */
    public Position getPosition(){
        return this.position;
    }
    
    /**
     * Método observador del color
     * @return color
     */
    public ColorEnum getColor(){
        return this.color;
    }

	/**
	 * Método obsevador del tipo de pieza
	 * @return type 
	 */
    public PiecesTypeEnum getType(){
        return this.type;
    }
    
    /**
     * Método moveTo -Comprueba los movimientos de un pieza y si la posición dada es válida para esa pieza, la traslada a ella
     * @param p -Una posición 
     */
    public void moveTo(Position p) {
        if (isLegalMove(p)) {
            this.position = p;
            this.legalMoves = null;
            return;
        } else
            return;
    }
    
    /**
     * Método que obtendrá los posibles movimientos de una pieza
     * @return List<Position>
     */
    public abstract List<Position> getLegalMoves();
   
	/**
     * Método isLegalMove -Dada una lista de posibles posiciones para una pieza, comprueba si una posición dada es posible según la lista
     * @param p -Una posición  
     */
    public boolean isLegalMove(Position p) {
        List<Position> moves = this.getLegalMoves();
        return (moves.contains(p)) ? true : false;
    }

	/**
	 * Método toString -Devuelve en un String el tipo de pieza
	 * @return type
	 */
    @Override
    public String toString() {
        return this.type.toString();
    }

	/**
	 * Método equals -Comprueba si una pieza es igual  a otro objeto
	 * @param obj -Un objeto
	 * @return boolean 
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
