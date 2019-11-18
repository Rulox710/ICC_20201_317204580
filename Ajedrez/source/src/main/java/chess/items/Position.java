package chess.items;

/**
 * Clase Position -Para definir coordenadas
 * @author Iabin
 */
public class Position{
    private int x;
    private int y;

	/**
	 * Constructor de la clase
	 * @param x -Posición en el eje x [0,7]
	 * @param y -Posición en el eje y [0,7]
	 */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

	/**
	 * Método isLegal -Decide si no se han salido del tablero las posiciones
	 */
    public boolean isLegal(){
        return (this.x < 8 && this.x > -1 && this.y < 8 && this.y > -1 )? true: false;
    }
    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

	/**
	 * Método equals -Decide si una posición es la misma que otra
	 */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Position))return false;
        Position p = (Position)obj;
        return (p.getX()==this.getX() && p.getY()== this.getY())? true: false;
    }
	
	/**
	 * Método toString -Escribe en la consola la posición deseada
	 */
    @Override
    public String toString() {
        return "  ||x:"+this.getX()+" y:"+this.getY()+"||";
    }
    
    /**
     * Método isOutBoard -Decide si una posición está fuera del tablero
     * æparam board_size -El tamaño del tablero en términos de casillas
     * @return boolean
     */
    public boolean isOutOfBoard(int board_size){
        if(this.y >= board_size)return false;
        if(this.x >= board_size)return false;
        if(this.y < 0)return false;
        if(this.x < 0)return false;
        return true;
    }
}
