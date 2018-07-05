package ar.santaCorp.historiasClinicas.util;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileManager {
	private String pathToFile;
	
	public static void main(String[] args) {
		
	}
	
	public FileManager()
	{
		
	}
	
	public static ArrayList listDirectoryFiles(String p_pathDirectory)
	{
		ArrayList directoryFiles = new ArrayList();
		File f = new File(p_pathDirectory);
		if (f.exists()){ 
			File[] ficheros = f.listFiles();
			for (int i=0;i<ficheros.length;i++){
				String pathHospital = p_pathDirectory+"/"+ficheros[i].getName();
				File hispitalFile = new File(pathHospital);
				if(!hispitalFile.isDirectory())
				{
					directoryFiles.add(pathHospital);
					System.out.println("-------------->"+pathHospital);
				}
			}
			return directoryFiles;
		}
		return null;
	}
	public static ArrayList getFileLines(String p_pathToFile)
	{
		
		
		ArrayList _lineList = new ArrayList();
		try
		{
			FileReader fr = new FileReader(p_pathToFile);
			BufferedReader br = new BufferedReader(fr);
			
			String linea;
			
	        while((linea=br.readLine())!=null)
	        {
	        	_lineList.add(linea);
	        }
	        fr.close();
			return _lineList;
			
		}catch(Exception e){
			System.out.println("El archivo no pudo ser leido");
	      }
		return null;
	}
	
	public static boolean fileExist(String p_pathToFile)
	{
		
		File f = new File(p_pathToFile);
		if(f.exists() && !f.isDirectory()) { 
		    return true;
		}
		return false;
	}
	
	public static boolean setFile(String p_pathToFile, String p_fileContent)
	{
		
		try {
			FileWriter fr = new FileWriter(p_pathToFile);
			
			PrintWriter pw = new PrintWriter(fr);
			pw.print(p_fileContent);
			fr.close();
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
		return true;
	}

	public static String getFileContent(String p_pathToFile)
	{
		
		String resultStr = "";
		try {
			FileReader fr = new FileReader(p_pathToFile);
			BufferedReader br = new BufferedReader(fr);
			System.out.println("Intento obtener todo el contenido de un archivo");
			// falta implementar esta parte del codigo, la idea es que retorne todo el contenido del file.
			
			// Lectura del fichero
				String linea;
				while((linea=br.readLine())!=null)
				{
					resultStr+=linea;
				}
			fr.close();
			
			return resultStr;
			
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
		return null;
	}
	
	public static boolean deleteFile(String p_pathToFile)
	{
		
		try {
			Path path = Paths.get(p_pathToFile);
		    Files.delete(path);
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", p_pathToFile);
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", p_pathToFile);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}
		return true;
	}
}
