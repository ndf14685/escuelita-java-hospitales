import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Hospitales {

	public static void main(String[] args) throws IOException {
		
//////////// primer punto cumplido
		
		String[] ids;       // armo un array y no le digo cuantos elementos va a tener
		ids=obtenerIds();   // llamo al metodo que me busca los Ids (y me devuelve el array armado)
		
		System.out.println("1) Imprimo todos los Ids");
		for (String elemento:ids) { System.out.println(elemento); }
		
////////////segundo punto
		
	String[] campos;       // armo un array y no le digo cuantos elementos va a tener
	campos=obtenerCampos(22);   // llamo al metodo que me busca los Ids (y me devuelve el array armado)
	
	System.out.println("");	
	System.out.println("2) Imprimo todos los campos de un dado hospital:");
	for (String elemento:campos) { System.out.println(elemento); }

////////////tercer punto
	System.out.println("");	
	System.out.println("2) Imprimo bien los campos:");
	imprimirCampos(campos);	
	}

	public static void imprimirCampos(String[] campos) {
	System.out.println("Id              : "+campos[0]);
	System.out.println("Nombre          : "+campos[1]);
	System.out.println("Direccion       : "+campos[2]);
	System.out.println("Cantidad Medicos: "+campos[3]);	
	}

	
	

	public static String[] obtenerCampos(int id) throws IOException {
		
		File file = new File("./archivo.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String[] campos = new String[4]; // id,nombre,direcc,cant medico
		
		
		String linea;
		while ((linea = br.readLine()) != null)
		{
			String[] datos = linea.split(",");
			
			if (Integer.parseInt(datos[0])==id)
			{
				campos[0]=datos[0];
				campos[1]=datos[1];
				campos[2]=datos[2];
				campos[3]=datos[3];				
			}
		}
		br.close();
		
		
		
		return campos;
	}
	
	
	
	
	public static String[] obtenerIds() throws IOException {
		File file = new File("./archivo.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
		int cantlineas = 0;
		
		while ((linea = br.readLine()) != null)
		{
			cantlineas++;
		}
		br.close();
		
		
	 String[] ids = new String[cantlineas];

	 
		File file2 = new File("./archivo.txt");
		FileReader fr2 = new FileReader(file2);
		BufferedReader br2 = new BufferedReader(fr2);

	
		int a = 0;
		
		while ((linea = br2.readLine()) != null)
		{
			String[] datos = linea.split(",");
			ids[a]=datos[0];
			a++;
		}
		br2.close();
		return ids;
	}
	
	
	
	
	
	
/*  codigo fuente de clase para empezar a jugar
 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		File file = new File("./archivo.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
		while ((linea = br.readLine()) != null)
		{
			String[] datos = linea.split(",");
			System.out.println(datos[1]);
		}
		br.close();
	}
*/
}

/* hacer un metodo que lista todos los Ids               : ObtenerIds                  
Devuelve array con todos los ID

hacer un metodo que dado un Id devuelve los datos     : DatosPorId
Devuelve array de string donde sabes x la posicion si es el domicilio o que cosa del hospital

hacer un metodo que muestre bien por consola los datos: mostrarPorConsola

----------------------------------------------

formato del archivo

id,nombredelhospital,domicilio,cantidaddemedicos
*/
//pase de parametros entre metodos
//comparacion de un string contra un numerico
