package clinicaDrStrange;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestorBD {

	public static boolean ingresarPaciente(int codPac, String nyap) {
		PrintWriter datopac;
		try {
			datopac = new PrintWriter(new FileWriter("./datopac.txt", true));
			datopac.println(codPac+"|"+nyap);
			datopac.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	//public static boolean ingresarDiagnostico()
}
