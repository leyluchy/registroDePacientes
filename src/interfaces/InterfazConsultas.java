package interfaces;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import clinicaDrStrange.GestorInformes;
import clinicaDrStrange.Medico;
import clinicaDrStrange.Paciente;

public class InterfazConsultas {
	
	private final String menuInformes =
			"   ..............................................." + "\n" +
			"   :-:  C O N T R O L  D E  P A C I E N T E S  :-:" + "\n" +
			"   ..............................................." + "\n" +
			"   :-:           - I N F O R M E S -           :-:" + "\n" +
			"   :-:.........................................:-:" + "\n" +
			"   :-: 1. Listado de pacientes por medico      :-:" + "\n" +
			"   :-: 2. Enfermedades que atiende cada medico :-:" + "\n" +
			"   :-: 3. Anterior                             :-:" + "\n" +
			"   ..............................................." + "\n" +
			"   ....Elija la opcion deseada: ";
	
	private final String leyendaEnfXMed =
			"   ....................................................." + "\n" +
			"   :-:          - E S P E C I A L I D A D -          :-:" + "\n" +
			"   :-:...............................................:-:" + "\n";
	private final String leyendaPacXMed =
			"   ....................................................." + "\n" +
			"   :-:        - L I S T A   P A C I E N T E S -         " + "\n" +
			"   :-:            - P O R   M E D I C O -            :-:" + "\n" +
			"   :-:...............................................:-:" + "\n";
	
	/**
	 * Se encarga del proceso de informes.
	 * */
	public void menuInformes() { 
		int opc;
		System.out.println(menuInformes);
		
		do {
			opc = InterfazUsuario.leerEntero();
			
			if (opc < 1 || opc > 3)
				System.out.println(InterfazUsuario.errorOpcionIncorrecta);
			switch (opc) {
			case 1:
				listaPacXMed();
				break;
			case 2:
				enfXMed();
				break;
			}
		} while (opc != 3);
	}
	
	/**
	 * Pantalla para consultar las enfermedades que atiende cada medico
	 */
	private void enfXMed() {
		int codme;
		
		System.out.println(leyendaEnfXMed);
		System.out.println("Digite el codigo del medico que desea consultar: ");
		codme = InterfazUsuario.leerEntero();
		
		Medico med = GestorInformes.traerMedico(codme);
		System.out.println("El medico " + med.getNombreYApellido() + " se especializa en " + med.getEspecializacion() + "\n");
	}
	
	/**
	 * Pantalla para listar los pacientes de un medico
	 */
	private static void listaPacXMed() {
		int codme;
		Medico med;
		Paciente[] listaPac;
		
		System.out.println("Digite el codigo del medico que desea consultar: ");
		codme = InterfazUsuario.leerEntero();
		med = GestorInformes.traerMedico(codme);
		listaPac = GestorInformes.traerListaDePacientesPorMedico(codme);
		
		System.out.println("::: El medico " + med.getNombreYApellido() + " atiende a los siguientes pacientes: " + "\n");
		for(Paciente pac : listaPac)
			System.out.println("::: Paciente: " + pac.getNombreYApellido() + "\n");
	}
}
