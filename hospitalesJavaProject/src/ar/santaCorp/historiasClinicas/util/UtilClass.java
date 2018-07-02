package ar.santaCorp.historiasClinicas.util;

public class UtilClass {
	public static void main()
	{
		//
	}
	public void helloClassUtil(String texto)
	{
		boolean condicion = true;
		int contador = 0;
		
		while(condicion)
		{
			System.out.println(contador);
			contador++;
			if(contador>10)
			{
				condicion = false;
			}
		}
		System.out.println(texto instanceof String); 
		
	}
}
