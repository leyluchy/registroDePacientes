package clinicaDrStrange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterfazUsuario {
	private String menuPrincipal =
			"   .............................................." + "\n" +
			"   :-:          C L Í NI C A   D E L          :-:" + "\n" +
			"   :-:    >>>> D R .   S T R A N G E <<<<     :-:" + "\n" +
			"   :-:  C O N T R O L  D E  P A C I E N T E S :-:" + "\n" +
			"   :-:........................................:-:" + "\n" +
			"   :-: 1.  Ingreso de datos                   :-:" + "\n" +
			"   :-: 2.  Informes                           :-:" + "\n" +
			"   :-: 3.  Salir                              :-:" + "\n" +
			"   .............................................." + "\n" +
			"   ....Elija la opcion deseada: ";
	
	private String menuIngresoDatos =
			"   ..............................................." + "\n" +
			"   :-: -I N G R E S O  D E  P A C I E N T E S- :-:" + "\n" + 
			"   :-:.........................................:-:" + "\n" +
			"   :-: 1.  Datos del paciente                  :-:" + "\n" +
			"   :-: 2.  Situacion del paciente              :-:" + "\n" +
			"   :-: 3.  Datos del medico                    :-:" + "\n" +
			"   :-: 4.  Anterior                            :-:" + "\n" +
			"   ..............................................." + "\n" +
			"   ....Elija la opcion deseada: ";
	
	private String errorOpcionIncorrecta = "Debe digitar una opcion del menu" + "\n";
	
	/**
	 * Muestra el menu principal y deriva el proceso segun la opcion elegida.
	 * */
	public void menuPrincipal() {
		int opc; // variable de selección usada en el menu principal

		do {
			opc = 0;
			System.out.println(menuPrincipal);
			opc = leerEntero();
			if (opc < 1 || opc > 3) 
				System.out.println(errorOpcionIncorrecta);
			else if (opc == 1) // selección ingreso de pacientes
				//procesarIngresoDeDatos();
			{}
			else if (opc == 2)// seleción informes
				//procesarInformes();
			{}
			
		} while (opc != 3);
	}
	
	/**
	 * Se encarga del proceso de ingreso de datos.
	 * */
	public void menuIngresoDeDatos() {
		int opc;
		do {
			System.out.println(menuIngresoDatos);
			opc = leerEntero();

			if (opc < 1 || opc > 4)
				System.out.println(errorOpcionIncorrecta);
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
	 * Lee un entero por consola. Si no logra reconocer un entero, devuelve -1
	 * @return
	 */
	private int leerEntero() {
		String linea;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			linea = br.readLine();
			int ne = Integer.parseInt(linea);
			return ne;
		} catch (IOException|NumberFormatException e) {
			return -1;
		}
	}
}
