package shapeSVG;

/**
 * Clase que crea un círculo
 *
 * @author Raul Nuño Valdés
 * @date 22 Septiembre 2019
 */
public class Circulo {
    private Vector2 centro;
    private double radio;
    private double perimetro;
    private double area;

    /**
     * Constructor de la clase
     * @param centro -Un vector
     * @param radio -Medida double del radio 
     */
    public Circulo(Vector2 centro, double radio) {
	this.centro = centro;
	this.radio = radio;
	this.perimetro = 2 * 3.1416 * this.radio;
	this.area = 3.1416 * Math.pow(this.radio,2);
    }

    /**
     * Constructor de la clase
     * @param x -Valor del eje de las absisas para el centro
     * @param y -Valor del eje de las ordenadas para el centro
     * @param radio -Valor del radio
     */
    public Circulo(double x, double y, double radio) {
	this.centro = new Vector2(x, y);
	this.radio = radio;
	this.perimetro = 2 * 3.1416 * this.radio;
        this.area = 3.1416 * Math.pow(this.radio,2);
    }

    /**
     * Constructor de la clase vacío, por defecto da centro en (50,50) con radio de 50
     */
    public Circulo() {
	this.centro = new Vector2(50,50);
	this.radio = 50;
	this.perimetro = 2 * 3.1416 * this.radio;
        this.area = 3.1416 * Math.pow(this.radio,2);
    }
    /**
     * Método que escribe en SVG un círculo
     */
    public String toSVG() {
	String svg = "<circle cx=\"" + this.obtenerC().obtenerX() + "\" cy=\"" + this.obtenerC().obtenerY() + "\" r=\"" + this.obtenerR() + "\" stroke=\"black\" stroke-width=\"1\" fill=\"none\" />";
	return svg;
    }
    
    /**
     * Método que describe un círculo
     */
    @Override
    public String toString() {
	String str = "El círculo descrito tiene suu centro en " + this.obtenerC() + " y un radio de " + this.obtenerR() + ". Su perímetro es de " + this.obtenerP() + " y su área es de " + this.obtenerA() + ".";
	return str;
    }

    /**
     * Método que dice si un círculo es igual a otro, sin importar su ubicación
     */
    public boolean equals(Circulo x) {
	boolean a = false;
	if(this.obtenerP() == x. obtenerP() && this.obtenerA() == x.obtenerA()) {
	    a = true;
	}
	return a;
    }

    /**
     * Método que devuelve el valor del centro
     */
    public Vector2 obtenerC() {
	return this.centro;
    }

    /**
     * Método que asigna un valor al centro
     * @param nuevoCentroX -El valor a asignar en el eje de las absisas
     * @param nuevoCentroY -El valor a asignar en el eje de lass ordenadas
     */
    public void asignarC(double nuevoCentroX, double nuevoCentroY) {
	this.centro.asignarX(nuevoCentroX);
	this.centro.asignarY(nuevoCentroY);
    }

    /**
     * Método que de vuelve el valor del  radio
     */
    public double obtenerR() {
	return this.radio;
    }

    /**
     * Método que asigna un valor al radio
     * @param nuevoRadio -Valor a asignar de radio
     */
    public void asignarR(double nuevoRadio) {
	this.radio = nuevoRadio;
    }
    
    /**
     * Método que obtiene el perímetro
     */
    public double obtenerP() {
	return this.perimetro;
    }

    /**
     * Método que obtiene el área
     */
    public double obtenerA() {
	return this.area;
    }
}
