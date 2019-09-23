package shapeSVG;

/**
 * Clase para hacer un rectágulo
 *
 * @author Raúl Nuño Valdés
 * @date 21 Septiembre 2019
 */
public class Rectangulo {
    private Vector2 v0;
    private double ancho;
    private double largo;
    private double perimetro;
    private double area;

    /**
     * Constructor de la clase
     * @param v0 -Las coordenadas de donde trendrá orígen el rectángulo
     * @param ancho -El ancho que tendrá el rectángulo
     * @param largo -El largo que tengrá el rectángulo
     */
    public Rectangulo(Vector2 v0, double ancho, double largo) {
	this.v0 = v0;
	this.ancho = ancho;
	this.largo = largo;
	this.perimetro = (2 * ancho) + (2 * largo);
	this.area = ancho * largo;
	/*
	this.v1 = new Vector2(v0.obtenerX() + ancho, v0.obtnerY());
	this.v2 = new Vector2(v0.obtenerX(), v0.obtenerY() + largo);
	this.v3 = new Vector2(v0.obtenerX() + ancho, v0.obtenerY() + largo);
	*/
    }

    /**
     * Contrunctor de la clase
     * @param x -Valor en el eje de las absisas que tendrá la coordenada de donde tendrá orígen el rectángulo
     * @param y -Valor en el eje de las ordenadas que tendrá la coordenada de donde tendrá orígen el rectángulo
     * @param ancho -Ancho del rectángulo
     * @param largo -Largo del rectángulo
     */
    public Rectangulo(double x, double y, double ancho, double largo) {
	this.v0 = new Vector2(x, y);
	this.ancho = ancho;
	this.largo = largo;
	this.perimetro = (2 * ancho) + (2 * largo);
        this.area = ancho * largo;
	/*
	this.v1	= new Vector2(v0.obtenerX() + ancho, v0.obtnerY());
        this.v2	= new Vector2(v0.obtenerX(), v0.obtenerY() + largo);
        this.v3	= new Vector2(v0.obtenerX() + ancho, v0.obtenerY() + largo);
	*/
    }

    /**
     * Constructor de la clase vacío que tendrá por default coordenadas (0,0) con largo y ancho de 100
     */
    public Rectangulo() {
	this.v0 = new Vector2();
	this.largo = 100;
	this.ancho = 100;
	this.perimetro = (2 * ancho) + (2 * largo);
        this.area = ancho * largo;
	/*
	this.v1	= new Vector2(100, 0);
        this.v2	= new Vector2(0, 100);
        this.v3	= new Vector2(100, 100);
	*/
    }

    /**
     * Método para escribir en SVG los valores del rectángulo
     */
    public String toSVG(){
	String svg = "<rect x=\"" + this.obtenerOrigen().obtenerX() + "\" y=\"" + this.obtenerOrigen().obtenerY() + "\" width=\"" + this.obtenerAncho() + "\" height=\"" + this.obtenerLargo() + "\" stroke=\"black\" fill=\"none\" />";
	return svg;
    }

    /**
     * Método para describir con palabras entendibles para los humanos al rectángulo 
     */
    @Override
    public String toString(){
	String str = "El rectángulo inicia en " + this.obtenerOrigen() + ",  tiene una ancho de " + this.obtenerAncho() + " y una altura de " + this.obtenerLargo() + ".";
	str = str + "Su perímetro es de " + this.obtenerPerimetro() + " y su área es de " + this.obtenerArea();
	return str;
    }

    /**
     * Método que dice si un rectángulo mide igual a otro, y por tanto son iguales
     * @param x -Un rectangulo
     */
    public boolean equals(Rectangulo x){
	boolean a = false;
	if((this.obtenerAncho() == x.obtenerAncho() && this.obtenerArea() == x.obtenerArea()) || (this.obtenerAncho() == x.obtenerLargo() && this.obtenerArea() == x.obtenerArea())) {
	    a = true;
	}
	return a;
    }
    
    /**
     * Método que obtiene el valor de la coordenada inicial
     */
    public Vector2 obtenerOrigen() {
	return this.v0;
    }

    /**
     * Método que cambia el vaolor de la coordenada inicial
     */
    public void asignarOrigen(double nuevoX, double nuevoY){
	this.v0.asignarX(nuevoX);
        this.v0.asignarY(nuevoY);
    }

    /**
     * Método que obtiene el valor del ancho
     */
    public double obtenerAncho() {
	return this.ancho;
    }

    /**
     * Método que cambia el valor del ancho
     */
    public void asignarAncho(double nuevoAncho) {
	this.ancho = nuevoAncho;
    }
    
    /**
     * Método que obtiene el valor del largo
     */
    public double obtenerLargo() {
	return this.largo;
    }

    /**
     * Método que cambia valor del largo
     */
    public void asignarLargo(double nuevoLargo) {
	this.largo = nuevoLargo;
    }

    /**
     * Método que obtiene el valor del preímetro
     */
    public double obtenerPerimetro(){
	return this.perimetro;
    }

    /**
     * Método que obtiene el valor del área
     */
    public double obtenerArea() {
        return this.area;
    }   
}
