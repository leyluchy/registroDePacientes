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
	
	public static boolean ingresarDiagnostico(int codPac,int codMed, int diag) {
		PrintWriter situpac;
		try {
			situpac = new PrintWriter(new FileWriter("./situpac.txt", true));
			situpac.println(codPac+"|"+codMed+"|"+diag);
			situpac.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public static boolean ingresarMedico(int codMed, String nyap, String esp) {
		PrintWriter datomed;
		try {
			datomed = new PrintWriter(new FileWriter("./datomed.txt", true));
			datomed.println(codMed+"|"+nyap+"|"+esp);
			datomed.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	/*public static boolean consultarEspecialidad(int codMed, String spe) {
		
	}*/
}
