package clinicaDrStrange;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;


class Controlpac {
	
	public Controlpac() throws IOException {
		login();
		procesar();
	}
	
	public static void login() throws IOException {
		String usuario, contrasenia;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				System.out.println("Ingrese el usuario : ");
				usuario = br.readLine();
				System.out.println("ingrese la contraseña : ");
				contrasenia = br.readLine();
				File f = new File("./login.in");
				Scanner sc = new Scanner(f);

				while (sc.hasNextLine()) {
					String user = sc.next();
					String pass = sc.next();
					if (usuario.equals(user) && contrasenia.equals(pass))
						return;
				}
				sc.close();

			} catch (FileNotFoundException e) {
				System.out.println("El archivo no existe...");
				System.exit(0);
			}
			System.out.println("Error al ingresar usuario o contraseña\n");

		}
	}
	
	/**
	 * Muestra el menu principal y deriva el proceso segun la opcion elegida.
	 * */
	public void procesar() {
		int opc; // variable de selección usada en el menu principal

		do {
			opc = 0;
			ps("   .............................................." + "\n");
			ps("   :-:          C L Í NI C A   D E L          :-:" + "\n");
			ps("   :-:    >>>> D R .   S T R A N G E <<<<     :-:" + "\n");
			ps("   :-:  C O N T R O L  D E  P A C I E N T E S :-:" + "\n");
			ps("   :-:........................................:-:" + "\n");
			ps("   :-: 1.  Ingreso de datos                   :-:" + "\n");
			ps("   :-: 2.  Informes                           :-:" + "\n");
			ps("   :-: 3.  Salir                              :-:" + "\n");
			ps("   .............................................." + "\n");
			ps("   ....Elija la opcion deseada: ");
			
			opc = LeerEntero();
			if (opc < 1 || opc > 3) 
				ps("Debe digitar una opcion del menu" + "\n");
			else if (opc == 1) // selección ingreso de pacientes
				procesarIngresoDeDatos();
			else if (opc == 2)// seleción informes
				procesarInformes();
			
		} while (opc != 3);
	}
	
	/**
	 * Se encarga del proceso de ingreso de datos.
	 * */
	public void procesarIngresoDeDatos() {
		int opc;
		
		do {

			ps("   ..............................................." + "\n");
			ps("   :-: -I N G R E S O  D E  P A C I E N T E S- :-:" + "\n");
			ps("   :-:.........................................:-:" + "\n");
			ps("   :-: 1.  Datos del paciente                  :-:" + "\n");
			ps("   :-: 2.  Situacion del paciente              :-:" + "\n");
			ps("   :-: 3.  Datos del medico                    :-:" + "\n");
			ps("   :-: 4.  Anterior                            :-:" + "\n");
			ps("   ..............................................." + "\n");
			ps("   ....Elija la opcion deseada: ");

			opc = LeerEntero();

			if (opc < 1 || opc > 4)
				ps("Debe digitar una opcion del menu" + "\n");
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
	 * Se encarga del proceso de informes.
	 * */
	public void procesarInformes() { 
		int opc;
		do {
			ps("   ..............................................." + "\n");
			ps("   :-:  C O N T R O L  D E  P A C I E N T E S  :-:" + "\n");
			ps("   ..............................................." + "\n");
			ps("   :-:           - I N F O R M E S -           :-:" + "\n");
			ps("   :-:.........................................:-:" + "\n");
			ps("   :-: 1. Listado de pacientes por medico      :-:" + "\n");
			ps("   :-: 2. Enfermedades que atiende cada medico :-:" + "\n");
			ps("   :-: 3. Anterior                             :-:" + "\n");
			ps("   ..............................................." + "\n");
			ps("   ....Elija la opcion deseada: ");
			
			opc = LeerEntero();
			if (opc < 1 || opc > 3) {
				ps("Seleccione una de las opciones del menu" + "\n");
			}

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
	
	public static void ps(String x) {
		System.out.print(x);
	}

	public static int LeerEntero() {
		String linea = new String("");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			linea = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int ne = 0;
		try {
			ne = Integer.parseInt(linea);
		} catch (Exception e) {
		}
		;
		return (ne);
	}

	public static String LeerCadena() {
		String linea = new String("");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			linea = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (linea);
	}
	
	private static void enfXMed() {
		int sw;
		int sw1;
		String codm;
		String codme;
		String enfp;
		String nomm;
		String codtem;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		DataInputStream datomed = null;
		try {
			System.out.println("Digite el codigo del medico que desea consultar: ");
			codtem = br.readLine();
			
			datomed = new DataInputStream(new FileInputStream("./datomed.txt"));

			sw1 = 1;
			while (sw1 != 0) {
				try {
					codm = datomed.readUTF();
					nomm = datomed.readUTF();
					if (codm.equals(codtem)) // compara el codigo digitado
												// con el codigo del medico de la
												// tabla "datomed"
					{
						System.out.println("El medico " + nomm + " trata las siguientes enfermedades:" + "\n");
	
						DataInputStream situpac = null;
						situpac = new DataInputStream(new FileInputStream("./situpac.txt"));
	
						sw = 1;
						while (sw != 0) {
							try {
								codme = situpac.readUTF();
								enfp = situpac.readUTF();
	
								if (codtem.equals(codme)) // compara el codigo del medico
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

	private static void ingresoMedicos() {
		String op;
		String codmed;
		String nommed;
		String espmed;
		PrintWriter datomed;
		try {
			datomed = new PrintWriter(new FileWriter("./datomed.txt", true));
		
			//DataOutputStream datomed = null;
			//datomed = new DataOutputStream(new FileOutputStream("./datomed.txt"));
			
			do {
	
				ps("   ....................................................." + "\n");
				ps("   :-:      - D A T O S   D E L   M E D I C O -      :-:" + "\n");
				ps("   :-:...............................................:-:" + "\n");
	
				ps("Digite el codigo del medico: ");
				codmed = LeerCadena();
				datomed.print(codmed + " ");
	
				ps("Digite el nombre del medico: ");
				nommed = LeerCadena();
				datomed.print(nommed + " ");
	
				ps("Digite la especializacion del medico: ");
				espmed = LeerCadena();
				datomed.print(espmed);
				datomed.println(); //No se por que, el println(String) o un "\n" no pone el salto de linea
	
				ps("Desea ingresar otro medico? S/N");
				ps("\n");
	
				op = LeerCadena();
	
			} while (op.equals("S") || op.equals("s"));
			
			datomed.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void ingresoDiagnosticos() {
		String op;
		String enfpac;
		String codp;
		String codm;
		
		PrintWriter situpac;
		try {
			situpac = new PrintWriter(new FileWriter("./situpac.txt", true));
			
			do {

				ps("   ....................................................." + "\n");
				ps("   :-: - S I T U A C I O N  D E L  P A C I E N T E - :-:" + "\n");
				ps("   :-:...............................................:-:" + "\n");

				ps("Digite el codigo del paciente: ");
				codp = LeerCadena();
				situpac.print(codp + " ");
				ps("Digite el codigo del medico: ");
				codm = LeerCadena();
				situpac.print(codm + " ");
				ps("Digite el diagnostico del medico: ");
				enfpac = LeerCadena();
				situpac.print(enfpac + " ");
				situpac.println();

				ps("Desea ingresar otro registro al historial? S/N");
				ps("\n");
				op = LeerCadena();

			} while (op.equals("S") || op.equals("s"));
			
			situpac.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void ingresoPacientes() {
		String op;
		String codpac;
		String nompac;
		
		PrintWriter datopac;
		try {
			datopac = new PrintWriter(new FileWriter("./datopac.txt", true));
			
			do {

				System.out.println("   ..............................................." + "\n" +
						"   :-:  - D A T O S  D E L  P A C I E N T E -  :-:" + "\n" + 
						"   :-:.........................................:-:" + "\n" + 
						"Digite el codigo del paciente: ");
				codpac = LeerCadena();
				datopac.print(codpac + " ");
				System.out.println("Digite el nombre del paciente: ");
				nompac = LeerCadena();

				datopac.print(nompac + " ");
				datopac.println();

				System.out.println("Desea ingresar otro paciente? S/N" + "\n");

				op = LeerCadena();

			} while (op.equals("S") || op.equals("s"));
			
			datopac.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void listaPacXMed() {
		String codtem, codm, nomm, codp, codme, codpa, nompa;
		int sw, sw1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			System.out.println("Digite el codigo del medico que desea consultar: ");
			codtem = br.readLine();

			DataInputStream datomed = null;
			datomed = new DataInputStream(new FileInputStream("./datomed.txt"));

			sw = 1;
			while (sw != 0) {
				try {
					codm = datomed.readUTF();
					nomm = datomed.readUTF();
					if (codm.equals(codtem)) // compara el codigo extraido de la
												// tabla "datomed" con el codigo
												// digitado
					{
						System.out.println("::: El medico " + nomm + " atiende a los siguientes pacientes: " + "\n");
						DataInputStream situpac = null;
						situpac = new DataInputStream(new FileInputStream("./situpac.txt"));
		
						sw = 1;
						while (sw != 0) {
							try {
								codp = situpac.readUTF();
								codme = situpac.readUTF();
								if (codme.equals(codtem)) // compara el codigo medico de la
															// tabla "datomed" con el de la
															// tabla "situpac"
								{
									DataInputStream datopac = null;
									datopac = new DataInputStream(
											new FileInputStream("./datopac.txt"));
		
									sw1 = 1;
									while (sw1 != 0) {
										try {
											codpa = datopac.readUTF();
											nompa = datopac.readUTF();
		
											if (codpa.equals(codp)) // compara el codigo del
																	// paciente de la tabla "situpac"
																	// con el codigo del paciente de
																	// la tabla "datopac"
											{
												System.out.println("::: Paciente: " + nompa + "\n");
											}
										} catch (EOFException e) {
											sw1 = 0;
										}
									}
									datopac.close();
								}
							} catch (EOFException e) {
								sw = 0;
							}
						}
						situpac.close();
					}
				} catch (EOFException e) {
					sw = 0;
				}
			}
			datomed.close();
		} catch (IOException ioe) {
		}
		;
	}
	
}
