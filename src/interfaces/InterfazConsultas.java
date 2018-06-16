package interfaces;

import clinicaDrStrange.GestorInformes;
import clinicaDrStrange.Medico;
import clinicaDrStrange.Paciente;

/**
 * Interfaz encargada de las consultas de datos
 * @author alexis
 *
 */
public class InterfazConsultas {
	
	/**
	 * Son los banners de los menúes
	 */
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
		String op;
		
		System.out.println(leyendaEnfXMed);
		do {
			System.out.println("Digite el codigo del medico que desea consultar: ");
			codme = InterfazUsuario.leerEntero();
			
			if(codme != -1) {
				Medico med = GestorInformes.traerMedico(codme);
				if(med != null)
					System.out.println("El medico " + med.getNombreYApellido() + " se especializa en " + med.getEspecializacion() + "\n");
				else
					System.out.println("No existe un médico con ese código");
				}
			else
				System.out.println("Codigo inválido.");
			
			System.out.println("¿Desea consultar otro médico? S/N" + "\n");
			op = InterfazUsuario.leerCadena();
		} while (op.equals("S") || op.equals("s"));
	}
	
	/**
	 * Pantalla para listar los pacientes de un medico
	 */
	private void listaPacXMed() {
		int codme;
		String op;
		Medico med;
		Paciente[] listaPac;
		
		System.out.println(leyendaPacXMed);
		do {
			System.out.println("Digite el codigo del medico que desea consultar: ");
			codme = InterfazUsuario.leerEntero();
			if(codme != -1) {
				
				//Busco el medico en base al codigo ingresado
				med = GestorInformes.traerMedico(codme);
				if(med != null) {
					
					//Si existe el medico, busco los pacientes
					listaPac = GestorInformes.traerListaDePacientesPorMedico(codme);
					if(listaPac != null && listaPac.length > 0) {
						
						//Si tiene pacientes, los listo
						System.out.println("::: El medico " + med.getNombreYApellido() + " atiende a los siguientes pacientes: " + "\n");
						for(Paciente pac : listaPac)
							System.out.println("::: Paciente: " + pac.getNombreYApellido() + "\n");
					}
					else
						//Si no tiene pacientes
						System.out.println("::: El médico " + med.getNombreYApellido() + " no atiende a ningún paciente");
				}
				else
					//Si no existe el medico
					System.out.println("::: No existe un médico con ese código");
			}
			else
				//Si el codigo no es valido
				System.out.println("Codigo inválido.");
						
			System.out.println("¿Desea consultar otro médico? S/N" + "\n");
			op = InterfazUsuario.leerCadena();
		} while (op.equals("S") || op.equals("s"));
	}
}
