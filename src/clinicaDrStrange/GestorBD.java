package clinicaDrStrange;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	
	public static Medico consultarMedico(int codMed) {
		BufferedReader datomed = null;
		Medico medico=null;
		String[] line;
		String aux;
		boolean continuar=true;
		try {
			datomed = new BufferedReader(new FileReader("./datomed.txt"));
			while(continuar && (aux=datomed.readLine())!=null) {
				line=aux.split("|");
				if(Integer.parseInt(line[0])==codMed) {
					medico=new Medico(Integer.parseInt(line[0]),line[1],line[2]);
					continuar=false;
				}
			datomed.close();
			}
			
		} catch (IOException e) {
			return null;
		}
		try {
			datomed.close();
		} catch (IOException e) {}
		return medico;
	}
}
