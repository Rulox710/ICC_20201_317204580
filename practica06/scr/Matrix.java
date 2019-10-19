/**
 *@author Raúl Nuño Valdés
 */

public class Matrix {

    public int n;
    public int m;
    public double[][]matriz;

    //Construye una matriz vacia de n por m
    public Matrix(int n, int m) {
	if  (n > 0 && m > 0) {
	this.matriz = new double[n][];
	for(int i = 0; i < n; i++){
	    this.matriz[i] = new double[m];
	    for (int j = 0; j < this.matriz[0].length; j++){
		this.matriz[i][j] = 0;
	    }
	}
	this.n = n;
	this.m = m;
	} else {
	    new Error("Matriz de 0 elementos en una filoa y/o columna");
	}
    }
    
    //Construye una matriz dado un arreglo
    public Matrix(double[][]array){
	this.n = array.length;
	this.m = array[0].length;
	this.matriz = new double[array.length][];
	for (int i = 0; i < this.n; i++) {
	    this.matriz[i] = new double[array[i].length];
	    for(int j = 0; j < this.m; j++) {
		this.matriz[i][j] = array[i][j];
	    }
	}
    }
    
    //Función que calcula producto escalar
    public void scalarProduct(double scalar){
	for (int i = 0; i < this.matriz.length; i++) {
	    for (int j = 0; j < this.matriz[0].length; j++) {
		this.matriz[i][j] = this.matriz[i][j] * scalar;
	    }
	}
    }
    
    //Función que calcula suma de matrices
    public void add (Matrix m) {
	if (this.matriz.length == m.matriz.length && this.matriz[0].length == m.matriz[0].length) {	    
	    for (int i = 0; i < this.matriz.length; i++) {
		for (int j = 0; j < this.matriz[0].length; j++) {
		    this.matriz[i][j] = this.matriz[i][j] + m.matriz[i][j];
		}
	    }
	} else {
	    System.out.print ("Matrices de tamaños diferentes");
	}
    }
    
    //Función que calcula producto de matrices
    public void matrixProduct (Matrix m) {
	
	if (this.matriz.length == m.matriz.length && this.matriz[0].length == m.matriz[0].length && this.matriz.length == this.matriz[0].length) {
	    Matrix original = new Matrix (this.matriz);
	    double suma = 0;  
	    for(int i = 0; i < this.matriz.length; i++){
		for(int j = 0; j < this.matriz.length; j++){ 
		    for(int k = 0; k < this.matriz.length; k++){  
			suma += original.matriz[i][k] * m.matriz[k][j];
		    }
		    this.matriz[i][j] = 0;
		    this.matriz[i][j] = suma;
		    suma = 0;
		}
		suma = 0;
	    }
	} else {
	    System.out.print ("Matrices de tamaños diferentes");
	}	
    }
    
    //Función que obtiene el elemento i j
    public double getElement (int i, int j) {
	return this.matriz[i][j];
    }
    
    //function set element
    public void setElement (int i, int j,double e) {
	this.matriz[i][j] = e;
    }
    
    //Función que calcula el determinante si es nxn
    // No pude con esta: Simplemente usé el método de GaussJordan por no dejar suelto el método, pero sólo sirve para una matriz de 3x3
    public int determinant() {
	double det=((this.matriz[0][0])*(this.matriz[1][1])*(this.matriz[2][2])+(this.matriz[1][0])*(this.matriz[2][1])*(this.matriz[0][2])+(this.matriz[2][0])*(this.matriz[0][1])*(this.matriz[1][2]))-((this.matriz[2][0])*(this.matriz[1][1])*(this.matriz[0][2])+(this.matriz[1][0])*(this.matriz[0][1])*(this.matriz[2][2])+(this.matriz[0][0])*(this.matriz[2][1])*(this.matriz[1][2]));
	return (int)det;
    }
    //Función que te dice si 2 matrices son iguales
    @Override
    public boolean equals(Object o){
	boolean a = true;
	if (o != null && o instanceof Matrix) {
	    Matrix temp = (Matrix)o;
	    if(this.n == temp.n && this.m == temp.m){
		for (int i = 0; i < this.n; i++) {
		    for(int j = 0; j < this.m; j++) {
			if (this.matriz[i][j] == temp.matriz[i][j]) {
			    a = a && true;
			} else {
			    a = a && false;
			}
		    }
		    return a;
		}
	    }
	}
	return false;
    }
}
