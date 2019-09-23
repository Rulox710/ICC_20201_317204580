package shapeSVG;

/**
 * Clase que crea un triángulo
 */
public class Triangulo{
    private Vector2 v0;
    private Vector2 v1;
    private Vector2 v2;
    private double perimetro;
    private double area;

    /**
     * Contructor de la clase
     * @param v0 -Un vector
     * @param v1 -Segundo vector
     * @param v2 -Tercer vector
     */
    public Triangulo(Vector2 v0, Vector2 v1, Vector2 v2) {
	this.v0 = v0;
	this.v1 = v1;
	this.v2 = v2;
	this.perimetro = this.v0.distancia(this.v1) + this.v1.distancia(this.v2) + this.v2.distancia(this.v0);
	double sp = this.perimetro / 2; 
	this.area = Math.sqrt(sp * (sp - this.v0.distancia(this.v1)) * (sp - this.v1.distancia(this.v2)) * (sp - this.v2.distancia(this.v0))); 
    }

    /**
     * Contructor de la clase
     * @param x0 -Punto del eje de las absisas que valdrá la primer coordenda
     * @param y0 -Punto del eje de las ordenadas que valdrá la primer coordenda 
     * @param x1 -Punto del eje de las absisas que valdrá la segunda coordenda 
     * @param y1 -Punto del eje de las ordenadas que valdrá la segunda coordenda 
     * @param x2 -Punto del eje de las absisas que valdrá la tercer coordenda 
     * @param y2 -Punto del eje de las ordenadas que valdrá la tercer coordenda 
     */
    public Triangulo(double x0, double y0, double x1, double y1, double x2, double y2) {
	this.v0 = new Vector2(x0, y0);
	this.v1 = new Vector2(x1, y1);
	this.v2 = new Vector2(x2, y2);
	this.perimetro = this.v0.distancia(this.v1) + this.v1.distancia(this.v2) + this.v2.distancia(this.v0);
        double sp = this.perimetro / 2;
	this.area = Math.sqrt(sp * (sp - this.v0.distancia(this.v1)) * (sp - this.v1.distancia(this.v2)) * (sp - this.v2.distancia(this.v0)));

    }
    
    /**
     * Contructor de la clase vacío que por default dará un triángulo con (0,0), (100,0) y (0,100)
     */
    public Triangulo() {
	this.v0 = new Vector2();
	this.v1 = new Vector2(100, 0);
	this.v2 = new Vector2(0,100);
	this.perimetro = this.v0.distancia(this.v1) + this.v1.distancia(this.v2) + this.v2.distancia(this.v0);
        double sp = this.perimetro/2;
            this.area = Math.sqrt(sp * (sp - this.v0.distancia(this.v1)) * (sp - this.v1.distancia(this.v2)) * (sp - this.v2.distancia(this.v0)));

    }

    /**
     * Método que escribe el SVG del triángulo
     */
    public String toSVG(){
	String svg = "<polygon points=\"" + this.obtenerCooX().obtenerX() + "," + this.obtenerCooX().obtenerY() + " " + this.obtenerCooY().obtenerX() + "," + this.obtenerCooY().obtenerY() + " " + this.obtenerCooZ().obtenerX() + "," + this.obtenerCooZ().obtenerY() + "\" style=\"fill:none;stroke:black;stroke-width:1\" />";
	return svg;
    }

    /**
     * Método que describe al triángulo
     */
    @Override
    public String toString() {
	String str = "La primer coordenada del triángulo está en " + this.obtenerCooX() + ", la segunda en " + this.obtenerCooY() + " y la tercera en " + this.obtenerCooZ() + ". Su perímetro es " + this.obtenerPerimetro() + " y su área es " + this.obtenerArea() + ".";
	return str;
    }

    /**
     * Método que dice si un triángulo es igual a otro, sin importar sus coordenadas (mismo perímetro y misma área)
     * @param x -Triángulo a comparar
     */
    public boolean equals(Triangulo x) {
	boolean a = false;
	if(this.obtenerPerimetro() == x.obtenerPerimetro() && this.obtenerArea() == x.obtenerArea()){
      	    a =true;
	}
	return a;
    }
    
    /**
     * Método que obtiene el valor de la primera coodenada
     */
    public Vector2 obtenerCooX() {
	return this.v0;
    }

    /**
     * Método que cambia el valor de la primer coodenada
     * @param nuevaX -Valor nuevo en el eje de las absisas
     * @param nuevaY -Valor nuevo en el eje de las ordenadas
     */
    public void asignarCooX(double nuevaX, double nuevaY) {
	this.v0.asignarX(nuevaX);
	this.v0.asignarY(nuevaY);
    }

    /**
     * Método que obtiene el valor de la segunda coodenada
     */
    public Vector2 obtenerCooY() {
        return this.v1;
    }

    /**
     * Método que cambia el valor de la segunda coodenada
     * @param nuevaX -Valor nuevo en el eje de las ordenadas
     * @param nuevaY -Valor nuevo en el eje de las ordenadas
     */
    public void	asignarCooY(double nuevaX, double nuevaY) {
	this.v1.asignarX(nuevaX);
        this.v1.asignarY(nuevaY);
    }

    /**
     * Método que obtiene el valor de la tercer coodenada
     */
    public Vector2 obtenerCooZ() {
        return this.v2;
    }

    /**
     * Método que cambia el valor de la tercer coodenada
     * @param nuevaX -Valor nuevo en el eje de las absisas
     * @param nuevaY -Valor nuevo en el eje de las ordenadas
     */
    public void	asignarCooZ(double nuevaX, double nuevaY) {
	this.v2.asignarX(nuevaX);
        this.v2.asignarY(nuevaY);
    }

    /**
     * Método que obtiene su perímetro
     */
    public double obtenerPerimetro() {
	return this.perimetro;
    }

    /**
     * Método que obtiene el área
     */
    public double obtenerArea() {
	return this.area;
    }
}
