package shapeSVG;

/**
 * Clase para hacer una línea
 *
 * @author Raúl Nuño Valdés
 * @date 17(24) Septiembre 2019
 * @version Corrección
 */
public class Linea {
    private Vector2 v1;
    private Vector2 v2;
    private double longitud;

    /**
     * Constructor de la clase que dados dos vectores da una linea
     * @param v1 -Un vector
     * @param v2 -Otro vector
     */
    public Linea(Vector2 v1, Vector2 v2) {
	this.v1 = v1;
	this.v2 = v2;
    }
    /**
     * Constructor de la clase que dados dos números para un punto y otros dos números para otro punto, crea los puntos de la linea y la linea
     * @param x1 -El punto del eje de las absisas que valdrá el primer vector
     * @param y1 -El punot del eje de las ordenadas que valdrá el primer vector
     * @param x2 -El punto del eje de las absisas que valdrá el segundo vector
     * @param y2 -El punto del eje de las ordenadas que valdrá el segundo vector 
     */
    public Linea(double x1, double y1, double x2, double y2) {
	this.v1 = new Vector2(x1, y1);
	this.v2 = new Vector2(x2, y2);
    }

    /**
     * Constructor de la clase vacíio que crea una linea por default en (0,0) y (100,100)
     */
    public Linea() {
	Vector2 v1 = new Vector2();
	Vector2 v2 = new Vector2(100, 100);
    }

    /**
     * Método para escribir la linea creada como SVG de html
     */
    public String toSVG() {
	String svg = "<line x1=\"" + this.obtenerCooX().obtenerX() + "\" y1=\"" + this.obtenerCooX().obtenerY()  + "\" x2=\"" + this.obtenerCooY().obtenerX() + "\" y2=\"" + this.obtenerCooY().obtenerY() + "\" style=\"stroke:#000; stroke-width:1\" />";
	return svg;
	    }

    /**
     * Método que describe lo que se está representando con palabras
     */
    @Override
    public String toString() {
	String str = "La linea inicia en " + this.obtenerCooX() + " y termina en " + obtenerCooY();
	return str;
    }

    /**
     * Método que dice si dos lineas miden igula y, por tanto, son iguales
     */
    public boolean equals(Linea x) {
	boolean a = false;
	if (this.obtenerCooX().distancia(this.obtenerCooY()) == x.obtenerCooX().distancia(x.obtenerCooY())){
	    a = true;
	}
	return a;
    }

    /**
     * Método que obtiene el valor del primer vector usado para crear la linea
     */
    public Vector2 obtenerCooX() {
	return this.v1;
    }

    /**
     * Método para cambiar el valor de la primera coordenada de la linea
     * @param nuevoX -El valor a asignar a la primera coordenada en el eje de las absisas
     * @param nuevoY -El valor a asignar a la primera coordenada en el eje de las ordenadas
     */
    public void asignarCooX(double nuevoX, double nuevoY) {
	this.v1 = new Vector2(nuevoX, nuevoY);
    }

    /**
     * Método para obtener el valor de la segunda coordenada usada para crear la linea
     */
    public Vector2 obtenerCooY() {
	return this.v2;
    }

    /**
     * Método para cambiar el valor de la segunda coordenada de linea
     * @param nuevoX -El valor a asignar a la segunda coordenada en el eje de las absisas
     * @param nuevoY -El valor a asignar a la segunda coordenada en el eje de las ordenadas    
     */
    public void asignarCooY(double nuevoX, double nuevoY) {
	this.v2 = new Vector2(nuevoX, nuevoY);
    }
}
