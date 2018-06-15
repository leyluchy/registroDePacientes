package interfaces;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import clinicaDrStrange.GestorInformes;

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
	
	/**
	 * Se encarga del proceso de informes.
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
		int sw;
		int sw1;
		String enfp;
		String nomm;
		int codme;
		
		try {
			System.out.println(leyendaEnfXMed);
			System.out.println("Digite el codigo del medico que desea consultar: ");
			codme = InterfazUsuario.leerEntero();

			sw1 = 1;
			while (sw1 != 0) {
				GestorInformes.
				System.out.println("El medico " + nomm + " trata las siguientes enfermedades:" + "\n");
						sw = 1;
						while (sw != 0) {
							try {
								codme = situpac.readUTF();
								enfp = situpac.readUTF();
	
								if (codme.equals(codme)) // compara el codigo del medico
															// de la tabla "datomed"
															// con el codigo del medico en la
															// tabla "situpac"
	
								{
									System.out.println(">>>> " + enfp + "\n");
								}
							} catch (EOFException e) {
								sw = 0;
							}
						}
						
						situpac.close();
					}
				} catch (EOFException e) {
					sw1 = 0;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
}
