package generadoresTesting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import clinicaDrStrange.GestorBD;

public class GeneradorPruebas {
	
	private int CANT_MEDICOS = 5000;
	private int CANT_PACIENTES = 50000;
	private int CANT_DIAGNOSTICOS = 70000; //Si usamos diags de 0, este numero se duplica
	
	public static void main(String args[]) throws IOException {
		GeneradorPruebas gen = new GeneradorPruebas();
		gen.escribirMedicos();
		gen.escribirPacientes();
		gen.escribirRandomDiags();
		gen.escribirDiagsDe0();
	}
	
	public void escribirMedicos() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(GestorBD.DATOS_MEDICOS_FILE));
		String nombre = "Nombre ";
		String especialidad = "Especialidad ";
		
		for(int i=0; i<CANT_MEDICOS; i++) {
			writer.write(i + "|" + nombre + i + "|" + especialidad + i);
			writer.newLine();
		}
		
		writer.close();
	}

	public void escribirPacientes() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(GestorBD.DATOS_PACIENTES_FILE));
		String nombre = "Nombre ";
		
		for(int i=0; i<CANT_PACIENTES; i++) {
			writer.write(i + "|" + nombre + i);
			writer.newLine();
		}
		
		writer.close();
	}
	
	public void escribirRandomDiags() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(GestorBD.DATOS_DIAGNOSTICO_FILE));
		int codMed, codPac;
		String diag = "Diagnostico ";
		Random ran = new Random();
		
		for(int i=0; i<CANT_DIAGNOSTICOS; i++) {
			codMed = ran.ints(0, 1000).findAny().getAsInt();
			codPac = ran.ints(0, 1000).findAny().getAsInt();
			writer.write(codPac + "|"  + codMed + "|" + diag + i);
			writer.newLine();
		}
		
		writer.close();
	}
	
	public void escribirDiagsDe0() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(GestorBD.DATOS_DIAGNOSTICO_FILE, true));
		int codMed = 0, codPac;
		String diag = "Diagnostico ";
		Random ran = new Random();
		
		for(int i=CANT_DIAGNOSTICOS; i<CANT_DIAGNOSTICOS*2; i++) {
			codPac = ran.ints(0, 2000).findAny().getAsInt();
			writer.write(codPac + "|"  + codMed + "|" + diag + i);
			writer.newLine();
		}
		
		writer.close();
	}
}
