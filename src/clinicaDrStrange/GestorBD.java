package clinicaDrStrange;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GestorBD {

	/**
	 * Permite ingresar pacientes en la BD
	 * @param paciente El paciente ingresado
	 * @return true si logró ingresar con exito, false en caso contrario
	 */
	public static boolean ingresarPaciente(Paciente paciente) {
		BufferedWriter datopac;
		try {
			datopac = new BufferedWriter(new FileWriter("./datopac.txt", true));
			datopac.write(paciente.getCodigoPaciente()+"|"+paciente.getNombreYApellido());
			datopac.newLine();
			datopac.close();
		} catch (IOException e) {
			return false;
		}
		try { //Solo por si no logró cerrar el archivo
			datopac.close();
		} catch (IOException e) {}
		return true;
	}
	
	public static boolean ingresarDiagnostico(Diagnostico diagnostico) {
		BufferedWriter situpac;
		try {
			situpac = new BufferedWriter(new FileWriter("./situpac.txt", true));
			situpac.write(diagnostico.getCodigoPaciente()+"|"+diagnostico.getCodigoMedico()+"|"+diagnostico.getDiagnostico());
			situpac.newLine();
			situpac.close();
		} catch (IOException e) {
			return false;
		}
		try {//Solo por si no logró cerrar el archivo
			situpac.close();
		} catch (IOException e) {}
		return true;
	}
	
	public static boolean ingresarMedico(Medico medico) {
		BufferedWriter datomed;
		try {
			datomed = new BufferedWriter(new FileWriter("./datomed.txt", true));
			datomed.write(medico.getCodigoMedico()+"|"+medico.getNombreYApellido()+"|"+medico.getEspecializacion());
			datomed.newLine();
			datomed.close();
		} catch (IOException e) {
			return false;
		}
		try {//Solo por si no logró cerrar el archivo
			datomed.close();
		} catch (IOException e) {}
		return true;
	}
	
	public static Medico consultarMedico(int codMed, String spe) {
		BufferedReader datomed = null;
		Medico medico=null;
		try {
			datomed = new BufferedReader(new FileReader("./datomed.txt"));
			datomed.readLine();
			
		} catch (IOException e) {
			return null;
		}
		return medico;
	}
}
