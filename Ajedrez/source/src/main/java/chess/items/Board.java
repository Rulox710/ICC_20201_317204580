package chess.items;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.chessPieces.Empty;
import chess.pieces.chessPieces.*;

/**
 * Clase Board -Crea al tablero
 * @author Iabin
 */
public class Board{
    public int SIZE = 8;
    public Piece[][] matrix;
    private static Board instance = null;
    
    /**
     * Constructor de la clase
     */
    private Board(){
        this.matrix = new Piece[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.matrix[i][j] = new Empty(new Position(i, j), ColorEnum.NONE);
            }
        }
        /*
        this.matrix[4][0] = new Rook(new Position(4, 0), ColorEnum.WHITE);
        this.matrix[7][0] = new Rook(new Position(7, 0), ColorEnum.BLACK);
        this.matrix[4][4] = new Rook(new Position(4, 4), ColorEnum.BLACK);
        */
		this.matrix[4][0] = new Bishop(new Position(4, 0), ColorEnum.WHITE);
        this.matrix[5][4] = new Pawn(new Position (5,4),ColorEnum.BLACK);
        this.matrix[7][0] = new Freelancer(new Position(7, 0), ColorEnum.BLACK);
        this.matrix[5][1] = new Bishop(new Position(5,1), ColorEnum.WHITE);
        this.matrix[3][1] = new Pawn(new Position(3, 1), ColorEnum.BLACK);
        this.matrix[5][5] = new Queen(new Position(5, 5), ColorEnum.WHITE);
		this.matrix[5][6] = new King(new Position(5, 6), ColorEnum.WHITE);
    }
	
	/**
	 * Método que genera una nueva instancia del tablero
	 */
    public static Board getInstance(){
        if(instance == null)
            instance = new Board();
        return instance;
    }

	/**
	 * Getter getSize -Obtiene el tamaño del tablero 
	 * @return SIZE -Int
	 */
    public int getSize(){
        return this.SIZE;
    }
	
	/**
	 * Método move -Mueve una pieza de una posición a otra
	 * @param Position -Posición inicial de la pieza a mover
	 * @param Position -Posición final de la pieza a mover
	 */
    public void move(Position p, Position q){
        if(!p.isLegal() || !q.isLegal())return;
        Piece piece = this.getPiece(p);
        if(!piece.isLegalMove(q))return;
        piece.moveTo(q);
        this.matrix[p.getX()][p.getY()] = new Empty(p,ColorEnum.NONE);
        this.matrix[q.getX()][q.getY()] = piece; 
    }
    
    /**
     * Método getPiece -Obtiene el tipo de pieza en una posición del tablero
     * @param Position -Posición en el tablero deseada
     * @return Piece 
     */
    public Piece getPiece(Position p){
        //if(p.isOutOfBoard(SIZE))return null;
        return this.matrix[p.getX()][p.getY()];
    }

	/**
	 * Método toString -Escribe los tipos de pieza en el tablero en la consola
	 * @return result -String con el tipo de pieza que ocupa esa parte del tablero
	 */
	 @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result = " "+ this.matrix[i][j]+" "+result;
            }
            result += '\n';
        }
        return result;
    }
}
