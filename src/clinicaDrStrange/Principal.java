package clinicaDrStrange;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import interfaces.InterfazUsuario;

public class Principal {
	
	public static void main(String args[]) {
		login();
		new InterfazUsuario().menuPrincipal();
	}
	
	/**
	 * Autentica al usuario
	 * @throws IOException
	 */
	public static void login() {
		String usuario, contrasenia;
		boolean loginExitoso = false;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File f = new File("./login.in");
		Scanner sc;
		try {
			
			while (!loginExitoso) {
				sc = new Scanner(f);
				
				System.out.println("Ingrese el usuario : ");
				usuario = br.readLine();
				System.out.println("Ingrese la contraseņa : ");
				contrasenia = br.readLine();
				
				while (!loginExitoso && sc.hasNextLine()) {
					String user = sc.next();
					String pass = sc.next();
					if (usuario.equals(user) && contrasenia.equals(pass))
						loginExitoso = true;
				}
				
				sc.close();
				if(!loginExitoso)
					System.out.println("Usuario o contraseņa incorrectos.\n");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir el archivo de credenciales de usuario.");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Error fatal en la aplicacion.");
			System.exit(2);
		}
		
	}

}
