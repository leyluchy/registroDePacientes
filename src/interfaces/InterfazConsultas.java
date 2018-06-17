package interfaces;

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
	
	/*private final String leyendaEnfXMed =
			"   ....................................................." + "\n" +
			"   :-:          - D I A G N O S T I C O S -          :-:" + "\n" +
			"   :-:...............................................:-:" + "\n";*/
	/*private final String leyendaPacXMed =
			"   ....................................................." + "\n" +
			"   :-:        - L I S T A   P A C I E N T E S -         " + "\n" +
			"   :-:            - P O R   M E D I C O -            :-:" + "\n" +
			"   :-:...............................................:-:" + "\n";
	*/
	/**
	 * Se encarga del proceso de informes.
	 * O(intentosMenu*intentosFuncion*(medicos+diags*pacientes))
	 * */
	public void menuInformes() { 
		int opc;
		
		do {
			System.out.println(menuInformes);
			opc = InterfazUsuario.leerEntero();
			
			if (opc < 1 || opc > 3)
				System.out.println(InterfazUsuario.errorOpcionIncorrecta);
			switch (opc) {
			case 1:
				//listaPacXMed();
				break;
			case 2:
				//enfXMed();
				break;
			}
		} while (opc != 3);
	}
	
	/**
	 * Pantalla para consultar las enfermedades que atiende cada medico
	 * O(intentos*(medicos+diags))
	 */
	/*private void enfXMed() {
		int codme;
		String op;
		
		System.out.println(leyendaEnfXMed);
		do {
			System.out.println("Digite el codigo del medico que desea consultar: ");
			codme = InterfazUsuario.leerEntero();
			
			if(codme != -1) {
				//Si ingreso un codigo valido
				Medico med = GestorInformes.traerMedico(codme);
				if(med != null) {
					//Si el medico existe
					List<Diagnostico> diags = GestorInformes.traerDiagnosticosDeMedico(codme);
					if(diags != null && !diags.isEmpty()) {
						//Si encontre diagnosticos para ese medico
						System.out.println("El medico " + med.getNombreYApellido() + " diagnosticó las siguientes enfermedades:");
						for(Diagnostico d : diags)
							System.out.println(">>>> " + d.getDiagnostico());
					}
					else
						//Si no encontre diagnosticos o hubo error
						System.out.println("El médoco " + med.getNombreYApellido() + " no diagnosticó ninguna enfermedad.");
				}
				else
					//Si no encontre el medico
					System.out.println("No existe un médico con ese código");
				}
			else
				System.out.println("Codigo inválido.");
			
			System.out.println("¿Desea consultar otro médico? S/N" + "\n");
			op = InterfazUsuario.leerCadena();
		} while (op.equals("S") || op.equals("s"));
	}*/
	
	/**
	 * Pantalla para listar los pacientes de un medico
	 * O(intentos*(medicos+diags*pacientes))
	 */
	/*private void listaPacXMed() {
		int codme;
		String op;
		Medico med;
		List<Paciente> listaPac;
		
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
					if(listaPac != null && !listaPac.isEmpty()) {
						
						//Si tiene pacientes, los listo
						System.out.println("::: El medico " + med.getNombreYApellido() + " atiende a los siguientes pacientes: ");
						for(Paciente pac : listaPac)
							System.out.println("::: Paciente: " + pac.getNombreYApellido());
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
	}*/
}
