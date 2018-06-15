package interfaces;

import clinicaDrStrange.GestorIngresoDatos;

public class InterfazIngresoDatos {

	private final String menuIngresoDatos =
			"   ..............................................." + "\n" +
			"   :-: -I N G R E S O  D E  P A C I E N T E S- :-:" + "\n" + 
			"   :-:.........................................:-:" + "\n" +
			"   :-: 1.  Datos del paciente                  :-:" + "\n" +
			"   :-: 2.  Situacion del paciente              :-:" + "\n" +
			"   :-: 3.  Datos del medico                    :-:" + "\n" +
			"   :-: 4.  Anterior                            :-:" + "\n" +
			"   ..............................................." + "\n" +
			"   ....Elija la opcion deseada: ";
	
	private final String leyendaIngresoPac = 
			"   ..............................................." + "\n" +
			"   :-:  - D A T O S  D E L  P A C I E N T E -  :-:" + "\n" + 
			"   :-:.........................................:-:" + "\n";
	
	private final String leyendaIngresoDiag =
			"   ....................................................." + "\n" +
			"   :-: - S I T U A C I O N  D E L  P A C I E N T E - :-:" + "\n" +
			"   :-:...............................................:-:" + "\n";
	
	private final String leyendaIngresoMed =
			"   ....................................................." + "\n" +
			"   :-:      - D A T O S   D E L   M E D I C O -      :-:" + "\n" +
			"   :-:...............................................:-:" + "\n";
	
	private final String errorGuardarEl = "Ha ocurrido un error al guardar el ";
	private final String vuelvaPronto = "Inténtelo más tarde.";
	
	/**
	 * Se encarga del proceso de ingreso de datos.
	 * */
	public void menuIngresoDeDatos() {
		int opc;
		do {
			System.out.println(menuIngresoDatos);
			opc = InterfazUsuario.leerEntero();

			if (opc < 1 || opc > 4)
				System.out.println(InterfazUsuario.errorOpcionIncorrecta);
			else if (opc != 4) {
				switch (opc) {
				case 1: // ingreso de datos, datos del paciente
					ingresoPacientes();
					break;
				case 2:// ingreso de datos, situacion del paciente
					ingresoDiagnosticos();
					break;
				case 3:// ingreso de datos, datos del medico
					ingresoMedicos();
				}
			}
			
		} while (opc != 4);
	}
	
	/**
	 * Pantalla para ingresar pacientes
	 */
	private void ingresoPacientes() {
		String op;
		int codpac;
		String nompac;
		do {
			System.out.println(leyendaIngresoPac);
			
			System.out.println("Digite el codigo del paciente: ");
			codpac = InterfazUsuario.leerEntero();
			System.out.println("Digite el nombre del paciente: ");
			nompac = InterfazUsuario.leerCadena();
			
			if( !GestorIngresoDatos.ingresoDatosPaciente(codpac, nompac) )
				//Si no lo pudo guardar
				System.out.println(errorGuardarEl + "paciente. " + vuelvaPronto);
			
			System.out.println("¿Desea ingresar otro paciente? S/N" + "\n");
			op = InterfazUsuario.leerCadena();
		} while (op.equals("S") || op.equals("s"));
	}
	
	/**
	 * Pantalla para ingresar diagnosticos
	 */
	private void ingresoDiagnosticos() {
		String op;
		String enfpac;
		int codp;
		int codm;
		
		do {
			System.out.println(leyendaIngresoDiag);

			System.out.println("Digite el codigo del paciente: ");
			codp = InterfazUsuario.leerEntero();
			System.out.println("Digite el codigo del medico: ");
			codm = InterfazUsuario.leerEntero();
			System.out.println("Digite el diagnostico del medico: ");
			enfpac = InterfazUsuario.leerCadena();
			
			if( !GestorIngresoDatos.ingresosituacionPaciente(codp, codm, enfpac) )
				//Si no lo pudo guardar
				System.out.println(errorGuardarEl + "diagnostico. " + vuelvaPronto);

			System.out.println("¿Desea ingresar otro registro al historial? S/N" + "\n");
			op = InterfazUsuario.leerCadena();
		} while (op.equals("S") || op.equals("s"));
	}
	
	/**
	 * Pantalla para ingresar medicos
	 */
	private void ingresoMedicos() {
		String op;
		int codmed;
		String nommed;
		String espmed;
		
		do {
			System.out.println(leyendaIngresoMed);

			System.out.println("Digite el codigo del medico: ");
			codmed = InterfazUsuario.leerEntero();
			System.out.println("Digite el nombre del medico: ");
			nommed = InterfazUsuario.leerCadena();
			System.out.println("Digite la especializacion del medico: ");
			espmed = InterfazUsuario.leerCadena();
			
			if( !GestorIngresoDatos.ingresoDatosMedico(codmed, nommed, espmed) )
				//Si no lo pudo guardar
				System.out.println(errorGuardarEl + "médico. " + vuelvaPronto);

			System.out.println("¿Desea ingresar otro medico? S/N" + "\n");
			op = InterfazUsuario.leerCadena();
		} while (op.equals("S") || op.equals("s"));
	}
}
