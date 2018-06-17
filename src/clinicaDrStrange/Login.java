package clinicaDrStrange;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Ejecución del codigo del programa ControlDePacientes
 * @author alexis
 *
 */
public class Login {
	
	/**
	 * Ejecución del producto
	 */
	/*public static void main(String args[]) {
		login();
		new InterfazUsuario().menuPrincipal();
	}*/
	
	/**
	 * Autentica al usuario.
	 * Pide el ingreso de las credenciales y las chequea contra las credenciales
	 * guardadas.
	 * No sale hasta que se ingrese un login exitoso.
	 * 
	 * O(cantUsuarios*cantIntentos)
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */
	public static boolean login(String usuario,String contrasenia) throws FileNotFoundException {
		boolean loginExitoso = false;
		File f = new File(GestorBD.DATOS_USUARIOS_FILE);
		Scanner sc;
				sc = new Scanner(f);				
				while (!loginExitoso && sc.hasNextLine()) {
					String user = sc.next();
					String pass = sc.next();
					if (usuario.equals(user) && contrasenia.equals(pass))
						loginExitoso = true;
				}
				sc.close();
				return loginExitoso;
	}
}
