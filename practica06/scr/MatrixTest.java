public class MatrixTest{
    
    public static double [][]lista1 = {{1,2},{1,4}};
    public static Matrix lala = new Matrix(lista1);
    
    public static double [][]lista2 = {{2,4},{2,8}};
    public static Matrix nana = new Matrix(lista2);

    public static double [][]lista3 = {{4,8},{4,16}};
    public static Matrix momo = new Matrix(lista3); 

    public static double [][]lista4 = {{1,2,3},{1,1,1},{0,1,-1}};
    public static Matrix rito = new Matrix(lista4);

    public static Matrix mikan = new Matrix(rito.matriz);

    public static double [][]lista5 = {{3,7,2},{2,4,3},{1,0,2}};
    public static Matrix haruna = new Matrix(lista5);
    
    public static void scalarProduct_test(){
	lala.scalarProduct(2);
	if(lala.equals(nana)){
	    System.out.println("Buen SCALAR");
	} else {
	    System.out.println("scalar product failed");
	}
    }
    public static void add_test(){
	nana.add(lala);
	if (nana.equals(momo)) {
	    System.out.println("Buen ADD");
	} else {   
	System.out.println("addition failed");
	}
    }
    public static void matrixProduct_test(){
	rito.matrixProduct(rito);
	if(rito.equals(haruna)){
	    System.out.println("Buen PRODUCT");
	} else {
	    System.out.println("matrix product failed");
	}
    }
    public static void setElement_test(){
	momo.setElement(1,0,500);
	if(momo.matriz[1][0] == 500){
	    System.out.println("Buen SET");
	} else {	    
	    System.out.println("setElement failed");
	}
    }
    public static void getElement_test(){
	if(momo.getElement(1,0) == 500) {
	    System.out.println("Buen GET");
	} else {
        System.out.println("Get element failed");
	}
    }
    public static void determinant_test(){
	if (mikan.determinant() == 3) {
	    System.out.println("Buen DETERMINANT, auque sólo sive en 3x3");
	} else {
        System.out.println("Determinant failed");
	}
    }
    public static void equals_test(){
	if (lala.equals(lala) == true && lala.equals(lista1) == false) {
	    System.out.println("Buen EQUALS");
	} else {
	    System.out.println("equals failed");
	}
    }
    
    public static void main(String[] args) {
        scalarProduct_test();
        add_test();
        matrixProduct_test();
        setElement_test();
        getElement_test();
        determinant_test();
        equals_test();
    }
}
