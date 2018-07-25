package ar.santaCorp.historiasClinicas.test;
import ar.santaCorp.historiasClinicas.util.FileManager;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

// Ojo con esto, todas las clases de testing tienen que terminar con la palabra test,
// sino hay que ponerle al surefire
// <includes>
//  <include>**/*.java</include>
// </includes>

public class FileManagerTest {

	@Test
	public void test() {
		ArrayList x = FileManager.getFileLines("src/test/resources/FileManagerTestCase.txt");
		
		assertEquals(x.get(0),"test");		

	}
}
