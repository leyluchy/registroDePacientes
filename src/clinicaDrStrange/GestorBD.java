package clinicaDrStrange;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorBD {

	public static final String DATOS_PACIENTES_FILE="./datopac.txt";
	public static final String DATOS_DIAGNOSTICO_FILE="./situpac.txt";
	public static final String DATOS_MEDICOS_FILE="./datomed.txt";
	public static final String DATOS_USUARIOS_FILE="./login.in";
	
	/**
	 * Permite ingresar pacientes en la BD
	 * O(1)
	 * @param paciente El paciente ingresado
	 * @return true si logrï¿½ ingresar con exito, false en caso contrario
	 */
	public static boolean ingresarPaciente(Paciente paciente) {
		BufferedWriter datopac;
		try {
			datopac = new BufferedWriter(new FileWriter(DATOS_PACIENTES_FILE, true));
			datopac.write(paciente.getCodigoPaciente()+"|"+paciente.getNombreYApellido());
			datopac.newLine();
			datopac.close();
		} catch (IOException e) {
			return false;
		}
		try { //Solo por si no logrï¿½ cerrar el archivo
			datopac.close();
		} catch (IOException e) {}
		return true;
	}
	
	/**
	 * Permite ingresar diagnosticos en la BD
	 * 
	 * O(1)
	 * @param diagnostico el diagnostico ingresado
	 * @return true si logrï¿½ ingresar con exito, false en caso contrario
	 */
	public static boolean ingresarDiagnostico(Diagnostico diagnostico) {
		BufferedWriter situpac;
		try {
			situpac = new BufferedWriter(new FileWriter(DATOS_DIAGNOSTICO_FILE, true));
			situpac.write(diagnostico.getCodigoPaciente()+"|"+diagnostico.getCodigoMedico()+"|"+diagnostico.getDiagnostico());
			situpac.newLine();
			situpac.close();
		} catch (IOException e) {
			return false;
		}
		try {//Solo por si no logrï¿½ cerrar el archivo
			situpac.close();
		} catch (IOException e) {}
		return true;
	}
	
	/**
	 * Permite ingresar medicos en la BD
	 * O(1)
	 * @param medico el medico ingresado
	 * @return true si logrï¿½ ingresar con exito, false en caso contrario
	 */
	public static boolean ingresarMedico(Medico medico) {
		BufferedWriter datomed;
		try {
			datomed = new BufferedWriter(new FileWriter(DATOS_MEDICOS_FILE, true));
			datomed.write(medico.getCodigoMedico()+"|"+medico.getNombreYApellido()+"|"+medico.getEspecializacion());
			datomed.newLine();
			datomed.close();
		} catch (IOException e) {
			return false;
		}
		try {//Solo por si no logrï¿½ cerrar el archivo
			datomed.close();
		} catch (IOException e) {}
		return true;
	}
	
	/**
	 * A partir del codigo de un medico busca entre los diagnosticos. Por cada diagnostico
	 * que escribio ese medico, busca el paciente en la BD de pacientes y con ellos arma
	 * una lista de pacientes.
	 * O(cantDiagnosticos*cantPacientes)
	 * @param codMed
	 * @return
	 */
	public static List<Paciente> traerPacientesXMedico(int codMed) {
		List<Paciente> lista = new ArrayList<Paciente>();
		Paciente aux;
		String linea;
		
		try {
			BufferedReader situpac = new BufferedReader(new FileReader(DATOS_DIAGNOSTICO_FILE));
			
			while( (linea = situpac.readLine()) != null) {
				String[] lineaPartida = linea.split("\\|");
				if( Integer.parseInt(lineaPartida[1]) == codMed &&
						(aux = consultarPaciente(lineaPartida[0])) != null )
					lista.add(aux);
			}
			
			situpac.close();
		} catch (IOException e) {}
		return lista;
	}
	
	/**
	 * Busca un paciente en la BD a traves del codigo pasado como string.
	 * Si no lo encuentra u ocurre una excepciï¿½n, devuelve null.
	 * O(n) n=cant pacientes.
	 * @param codPaciente
	 * @return
	 */
	private static Paciente consultarPaciente(String codPaciente) {
		String linea;
		try {
			BufferedReader datopac = new BufferedReader(new FileReader(DATOS_PACIENTES_FILE));
			while((linea = datopac.readLine()) != null) {
				String[] lineaPartida = linea.split("\\|");
				if(lineaPartida[0].equals(codPaciente)) {
					Paciente pac = new Paciente(Integer.parseInt(lineaPartida[0]), lineaPartida[1]);
					datopac.close();
					return pac;
				}
			}
			datopac.close();
		} catch (IOException e) {}
		return null;
	}
	
	/**
	 * La consulta de un medico, se usa para consultar su especialdiad
	 * O(cantMedicos)
	 * @param codMed codigo del medico pedido
	 * @return el objeto Medico buscado
	 */
	public static Medico consultarMedico(int codMedico) {
		String linea;
		try {
			BufferedReader datomed= new BufferedReader(new FileReader(DATOS_MEDICOS_FILE));
			while((linea=datomed.readLine()) != null) {
				String[] lineaPartida = linea.split("\\|");
				if(codMedico==Integer.parseInt(lineaPartida[0])) {
					Medico med=new Medico(Integer.parseInt(lineaPartida[0]),lineaPartida[1],lineaPartida[2]);
					datomed.close();
					return med;
				}
			}
			datomed.close();
		}catch (IOException e) {}
		return null;
	}
	
	/**
	 * Trae los diagnosticos de un medico
	 * O(cantDiag)
	 * @param codMedico
	 * @return
	 */
	public static ArrayList<Diagnostico> consultarDiagnosticosXMedico(int codMedico) {
		String linea;
		ArrayList<Diagnostico> diag =new ArrayList<Diagnostico>();
		try {
			BufferedReader datodiag= new BufferedReader(new FileReader(DATOS_DIAGNOSTICO_FILE));
			while((linea=datodiag.readLine()) != null) {
				String[] lineaPartida = linea.split("\\|");
				if(codMedico==Integer.parseInt(lineaPartida[1])) {
					diag.add(new Diagnostico(Integer.parseInt(lineaPartida[0]),Integer.parseInt(lineaPartida[1]),lineaPartida[2]));
				}
			}
			datodiag.close();
		}catch (IOException e) {}
		return diag;
	}
	
	/**
	 * Trae el ultimo codigo de la ultima linea de un archivo de medicos o pacientes
	 * O(cantRegistros)
	 * @param file el archivo a buscar
	 * @return 	el numero del ultimo codigo, coincidente con la fila analizada, -1 si no se hallaron codigos,
	 *			null si no se puede acceder al archivo
	 */
	public static Integer lastLine(String file) {
		String actual=null,lastString=null;
		int last=-1;
		BufferedReader datomed = null;
		try {
			datomed = new BufferedReader(new FileReader(file));
			while((actual=datomed.readLine())!=null) {
				lastString=actual;	
			}
			if(lastString!=null)
				last=Integer.parseInt(lastString.split("\\|")[0]);
			datomed.close();
		} catch (IOException e) {
			return null;
		}
		return new Integer(last);
	}
	
	/**
	 * Chequea la integridad de los archivos de la BD
	 * @return true si se encuentran disponibles, false si no es así
	 */
	public static boolean checkFilesExistence() {
		try {
			BufferedReader x = new BufferedReader(new FileReader(DATOS_USUARIOS_FILE));
			x.close();
			x = new BufferedReader(new FileReader(DATOS_PACIENTES_FILE));
			x.close();
			x = new BufferedReader(new FileReader(DATOS_DIAGNOSTICO_FILE));
			x.close();
			x = new BufferedReader(new FileReader(DATOS_MEDICOS_FILE));
			x.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
