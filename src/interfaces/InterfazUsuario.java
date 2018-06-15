package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterfazUsuario {
	private final String menuPrincipal =
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
	
	static final String errorOpcionIncorrecta = "Debe digitar una opcion del menu" + "\n";
	
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
				new InterfazIngresoDatos().menuIngresoDeDatos();
			else if (opc == 2)// seleción informes
				new InterfazConsultas().menuInformes();
			
		} while (opc != 3);
	}
		
	/**
	 * Lee un entero por consola. Si no logra reconocer un entero, devuelve -1
	 * @return
	 */
	static int leerEntero() {
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
	
	/**
	 * Lee una string por consola. Si no la reconoce, la devuelve vacía.
	 * @return
	 */
	static String leerCadena() {
		String linea = new String("");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			linea = br.readLine();
		} catch (Exception e) {
			return "";
		}
		return (linea);
	}
}
