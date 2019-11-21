import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.nio.file.Paths;

public class Writter {

    public static void main(String... args){
        
        //LEER DE ARCHIVOS
        try {
            Path path = Paths.get("csv.txt");//La ruta de donde está mi archivo
            List<String> lines = Files.readAllLines(path);//Leo todas las lineas en una lista
            for (String string : lines) {//Itero sobre cada linea
                String row[] = string.split(",");//Lo separo por comas
                
                double raw[] = {Double.parseDouble(row[0]),Double.parseDouble(row[1])};
                
                System.out.println("x: " + raw[0] + " y: " + raw[1]);//IMprimo lo que leí
            }
            
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
		
        //ESCRIBIR EN ARCHIVOS 
        try{
            //La ruta a donde voy a escribir el archivo
            Path path = Paths.get("hola.txt");
            
			Path poth = Paths.get("csv.txt");//La ruta de donde está mi archivo
            
            String a = "";
            
            List<String> lines = Files.readAllLines(poth);
			for (String string : lines) {
				
				String row[] = string.split(",");//Lo separo por comas
                
                double raw[] = {Double.parseDouble(row[0]),Double.parseDouble(row[1])};
				
				double rew [] = {Math.sqrt(Math.pow(raw[0],2)+Math.pow(raw[1],2)),Math.atan(Math.toRadians(raw[1]/raw[0]))};
				//Lo escribo
				a = a + String.valueOf(rew[0]) + "," + String.valueOf(rew[1]) + "\n";
				

			}
			Files.write(path, a.getBytes());
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
        
        
    }
    
    
}
