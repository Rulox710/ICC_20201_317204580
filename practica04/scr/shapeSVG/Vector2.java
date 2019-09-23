package shapeSVG;
/**
 * Clase para poner vectores
 *
 * @author Raúl Nuño Valdés
 * @date 17 Septiembre 2019
 */

public class Vector2 {
    private double x;
    private double y;
    private double magnitud;
    
    /**
     * Constructor de la clase con dos parámetros double que dan la ubicación del vector
     * @param x -Punto del eje de las absisas
     * @param y -Punto del eje de las ordenadas
     * @param magnitud -Magnitud del vector
     */
    public Vector2 (double x, double y){
	this.x = x;
	this.y = y;
	this.magnitud = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    /**
     * Constructor de la clase vacío que da un punto por default en (0,0)
     */
    public Vector2 (){
	this.x = 0;
	this.y = 0;
    }

    /**
     * Método que mide la distancia entre dos vectores
     * @param b -Un vector
     */
    public double distancia (Vector2 b) {
	double X, Y, Z;
	X = this.obtenerX() - b.obtenerX();
	X = Math.pow(X, 2);
	Y = this.obtenerY() - b.obtenerY();
	Y = Math.pow(Y, 2);
	Z = Math.sqrt(X + Y);
	return Z;
    }

    /**
     * Método para escribir los vectores dados como SVG (Desconozco como se escriben en SVG, así que lo inventé)
     */
    public String toSVG() {
	String tot = "<point x=\"" + this.obtenerX() + "mm\" y=\"" + this.obtenerY() + "\"mm>";
	return tot;
    }

    /**
     * Método que describe con palabras qué se está representado
     */
    @Override
    public String toString() {
	String res = "(" + this.obtenerX() + ", " + this.obtenerY() + ")";
	return res;
    }

    /**
     * Método que compara a dos vectores y dice si son el mismo
     * @param x -Un vector 
     */
    public boolean equals(Vector2 x) {
	boolean a = false; 
	if (this.obtenerX() == x.obtenerX() && this.obtenerY() == x.obtenerY()) {
	    a = true;
	}
	return a;
    }

    /**
     * Getter del valor del eje de las absisas del vector
     */
    public double obtenerX(){
	return this.x;
    }
    
    /**
     * Setter del valor del eje de las absisas del vector
     * @param nuevoX -Un número
     */
    public void asignarX(double nuevoX) {
	this.x = nuevoX;
    }

    /**
     * Getter del valor del eje de las ordenadas del vector
     */
    public double obtenerY(){
	return this.y;
    }

    /**
     * Setter del valor del eje de las ordenadas del vector
     * @param nuevoY -Un número
     */
    public void asignarY(double nuevoY) {
	this.y = nuevoY;
    }

    /**
     * Getter del valor de magnitud del vector
     */
    public double obtenerMagnitud(){
      	return this.magnitud;
    }
}
