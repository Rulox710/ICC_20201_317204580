import shapeSVG.*;

public class Main {
    /*
     * String necesarios para el html
     */
    public static String html = "<html>";
    public static String inicio = "<svg width=\"750\" height=\"750\">";
    public static String fin = "</svg>";
    
    /*
     * Objetos creados por el autor
     */
    public static Vector2 v1 = new Vector2();
    public static Vector2 v2 = new Vector2(100,100);
	
    public static Vector2 vc1 = new Vector2(100,50);
    public static Vector2 vc2 = new Vector2(125,125);
    public static Vector2 vc3 = new Vector2(25,125);
	
    public static Linea l1 = new Linea(200,0 , 0,200);
    public static Linea lComparacion = new Linea(v1, v2); //Debe dar "false" pues no son la misma lines
	
    public static Rectangulo r1 = new Rectangulo(v1, 200, 200);
    public static Rectangulo rComparacion = new Rectangulo (100,100,200,200); // Debe dar "true" ya que son el mismo cuadrado, solo que en diferente ubicación
	
    public static Triangulo t1 = new Triangulo(100,50 , 125,125 , 25,125);
    public static Triangulo tComparacion = new Triangulo (vc2, vc3, vc1); // Debe dar "true" pues son el mismo triangulo, solo que se han cambiado la ubicación de sus vectores 

    public static Circulo c1 = new Circulo(v2, 100);
    public static Circulo cComparacion = new Circulo(); // Debe dar "false" pues no son iguales

    public static Triangulo tr = new Triangulo(10,25 , 350,25 , (360/2),350);

    /*
     * Se ha escrito ciertas pruebas. Descomente la que quiera probar primero. 
     */
    public static void main(String []args) {	
	//escribir();

	//todoEnSVG();

	//recursivo();
    }

    /*
     * Descomenta la llamada de este método para ver todos los objetos creados descritos con palabras comprencibles para los mortales
     */
    public static void escribir(){
	String hola = "En este método se contienen todas las descripciones para todos los objetos creados en Main por el autor.";
	String compa = "Ambos objetos son iguales: ";
	
	System.out.println(hola + "\n");

	System.out.println("v1= " + v1.toString());
	System.out.println("v2= " + v2.toString());
	System.out.println(compa + v1.equals(v2) + "\n");
	
	System.out.println("l1= " + l1.toString());
	System.out.println("lCompararcion= " + lComparacion.toString());
	System.out.println(compa + l1.equals(lComparacion) + "\n");
	
	System.out.println("r1= " + r1.toString());
	System.out.println("rComparacion= " + rComparacion.toString());
	System.out.println(compa + r1.equals(rComparacion) + "\n");

	System.out.println("t1= " + t1.toString());
	System.out.println("tComparacion= " + tComparacion.toString());
	System.out.println(compa + t1.equals(tComparacion) + "\n");

	System.out.println("c1= " + c1.toString());
	System.out.println("cComparacion= " + cComparacion.toString());
	System.out.println(compa + c1.equals(cComparacion) + "\n");
    }

    /*
     * Descomenta la llamada de este método para ver el SVG de las figuras. Puede enviarlas a "ejemplo.html" para checar su funcionamiento. No olvides comentar la llamada del método "escribir()" en el método "main"
     */
    public static void todoEnSVG() {
	System.out.println(html);
	System.out.println(inicio);

	System.out.println(l1.toSVG());
	System.out.println(r1.toSVG());
	System.out.println(t1.toSVG());
	System.out.println(c1.toSVG());
	
	System.out.println(fin);
    }
    
    
    /*
     * Descomenta la llamada de este método para probar recursivamente un triángulo. Se hizo lo que se pudo :'(
     */

    public static void recursivo() {
	System.out.println(html);
	System.out.println(inicio);

	System.out.println(tr.toSVG());
	
	Triangulo r1 = new Triangulo(tr.obtenerCooX().obtenerX(), tr.obtenerCooX().obtenerY(), tr.obtenerCooY().obtenerX(),tr.obtenerCooY().obtenerY() , tr.obtenerCooZ().obtenerX(), tr.obtenerCooZ().obtenerY());
	
	Triangulo r2 = new Triangulo(tr.obtenerCooX().obtenerX(), tr.obtenerCooX().obtenerY(), tr.obtenerCooY().obtenerX(),tr.obtenerCooY().obtenerY() , tr.obtenerCooZ().obtenerX(), tr.obtenerCooZ().obtenerY());
	Triangulo r3 = new Triangulo(tr.obtenerCooX().obtenerX(), tr.obtenerCooX().obtenerY(), tr.obtenerCooY().obtenerX(),tr.obtenerCooY().obtenerY() , tr.obtenerCooZ().obtenerX(), tr.obtenerCooZ().obtenerY());

	
	for(int i = 1; i <= 5; i++) {
	    r1.asignarCooX(r1.obtenerCooX().obtenerX(), r1.obtenerCooX().obtenerY());
	    r1.asignarCooY((r1.obtenerCooX().obtenerX()+r1.obtenerCooY().obtenerX())/2 , (r1.obtenerCooX().obtenerY()+r1.obtenerCooY().obtenerY())/2);
	    r1.asignarCooZ((r1.obtenerCooX().obtenerX()+r1.obtenerCooZ().obtenerX())/2 , (r1.obtenerCooX().obtenerY()+r1.obtenerCooZ().obtenerY())/2);	    
	    System.out.println(r1.toSVG());
	    
	}

	for(int i = 1; i <= 5; i++) {
	    r2.asignarCooX((r2.obtenerCooY().obtenerX()+r2.obtenerCooX().obtenerX())/2 , (r2.obtenerCooY().obtenerY()+r2.obtenerCooX().obtenerY())/2);
	    r2.asignarCooY(r2.obtenerCooY().obtenerX(), r2.obtenerCooY().obtenerY());
	    r2.asignarCooZ((r2.obtenerCooY().obtenerX()+r2.obtenerCooZ().obtenerX())/2 , (r2.obtenerCooY().obtenerY()+r2.obtenerCooZ().obtenerY())/2);
	    System.out.println(r2.toSVG());	    
	}

	for(int i = 1 ;i <= 5; i++) {
	    r3.asignarCooX((r3.obtenerCooZ().obtenerX()+r3.obtenerCooX().obtenerX())/2, (r3.obtenerCooZ().obtenerY()+r3.obtenerCooX().obtenerY())/2);
	    r3.asignarCooY((r3.obtenerCooZ().obtenerX()+r3.obtenerCooY().obtenerX())/2, (r3.obtenerCooZ().obtenerY()+r3.obtenerCooY().obtenerY())/2);
	    r3.asignarCooZ(r3.obtenerCooZ().obtenerX(), r3.obtenerCooZ().obtenerY());
	    System.out.println(r3.toSVG());
	}
	
	System.out.println(fin);
    }
}
