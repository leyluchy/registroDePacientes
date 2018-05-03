import java.io.*;
import java.util.Scanner;

class bdatoa {
	public static void ps(String x) {
		System.out.print(x);

	}

	public static int LeerEntero() {
		String línea = new String("");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			línea = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int ne = 0;
		try {
			ne = Integer.parseInt(línea);
		} catch (Exception e) {
		}
		;
		return (ne);
	}

	public static String LeerCadena() {
		String línea = new String("");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			línea = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (línea);
	}

	public static void login() throws IOException {
		String usuario, contraseña;

		while (true) {
			try {
				ps("Ingrese el usuario : ");
				usuario = LeerCadena();
				ps("ingrese la contraseña : ");
				contraseña = LeerCadena();
				File f = new File("./login.in");
				Scanner sc = new Scanner(f);

				while (sc.hasNextLine()) {
					String user = sc.next();
					String pass = sc.next();
					if (usuario.equals(user) && contraseña.equals(pass))
						return;
				}

			} catch (FileNotFoundException e) {
				System.out.println("El archivo no existe...");
				System.exit(0);
			}
			ps("Error al ingresar usuario o contraseña\n");

		}
	}

	public static void main(String args[]) throws Exception {
		login();
		int op1, op2; // variables de selección usadas en los diferentes menús

		do {
			op1 = 0;

			ps("   .............................................." + "\n");
			ps("   :-:        C E N T R O  M E D I C O        :-:" + "\n");
			ps("   :-:   >>>> L O S  L A U R E L E S <<<<     :-:" + "\n");
			ps("   :-:  C O N T R O L  D E  P A C I E N T E S :-:" + "\n");
			ps("   :-:........................................:-:" + "\n");
			ps("   :-: 1.  Ingreso de datos                   :-:" + "\n");
			ps("   :-: 2.  Informes                           :-:" + "\n");
			ps("   :-: 3.  Salir                              :-:" + "\n");
			ps("   .............................................." + "\n");
			ps("   ....Elija la opcion deseada: ");
			// ps("\n");
			op1 = LeerEntero();
			if (op1 < 1 || op1 > 3) {
				ps("Debe digitar una opcion del menu" + "\n");
			}

			if (op1 == 1) // seleción ingreso de pacientes
			{

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

					op2 = LeerEntero();

					if (op2 < 1 || op2 > 4) {
						ps("Debe digitar una opcion del menu" + "\n");
					}

					switch (op2) {
					case 1: // ingreso de datos, datos del paciente
						ingresoPacientes();
						break;
					// ingreso de datos, situacion del paciente
					case 2:
						ingresoDiagnosticos();
						break;
					case 3:
						ingresoMedicos();
					}
				} while (op2 != 4);
			} else {
				if (op1 == 2) // seleción informes
				{

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
						op2 = LeerEntero();
						if (op2 < 1 || op2 > 3) {
							ps("Seleccione una de las opciones del menu" + "\n");
						}

						switch (op2) {
						case 1:
							listaPacXMed();
							break;

						case 2:
							enfXMed();
							break;
						}

					} while (op2 != 3);

				}
			}
		} while (op1 != 3);

	}

	private static void enfXMed() {
		int sw;
		int sw1;
		String codm;
		String codme;
		String enfp;
		String nomm;
		String codtem;
		ps("Digite el codigo del medico que desea consultar: ");
		codtem = LeerCadena();

		DataInputStream datomed = null;
		try {
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
						ps("El medico " + nomm + " trata las siguientes enfermedades:" + "\n");
	
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
									ps(">>>> " + enfp + "\n");
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

				ps("   ..............................................." + "\n");
				ps("   :-:  - D A T O S  D E L  P A C I E N T E -  :-:" + "\n");
				ps("   :-:.........................................:-:" + "\n");

				ps("Digite el codigo del paciente: ");
				codpac = LeerCadena();
				datopac.print(codpac + " ");
				ps("Digite el nombre del paciente: ");
				nompac = LeerCadena();

				datopac.print(nompac + " ");
				datopac.println();

				ps("Desea ingresar otro paciente? S/N" + "\n");

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
		try {

			ps("Digite el codigo del medico que desea consultar: ");
			codtem = LeerCadena();

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
						ps("::: El medico " + nomm + " atiende a los siguientes pacientes: " + "\n");
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
												ps("::: Paciente: " + nompa + "\n");
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
