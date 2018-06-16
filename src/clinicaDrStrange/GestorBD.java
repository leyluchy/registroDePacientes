package clinicaDrStrange;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorBD {

	public static final String DATOS_PACIENTES_FILE="./datopac.txt";
	public static final String DATOS_DIAGNOSTICO_FILE="./situpac.txt";
	public static final String DATOS_MEDICOS_FILE="./datomed.txt";
	
	/**
	 * Permite ingresar pacientes en la BD
	 * @param paciente El paciente ingresado
	 * @return true si logró ingresar con exito, false en caso contrario
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
		try { //Solo por si no logró cerrar el archivo
			datopac.close();
		} catch (IOException e) {}
		return true;
	}
	
	/**
	 * Permite ingresar diagnosticos en la BD
	 * @param diagnostico el diagnostico ingresado
	 * @return true si logró ingresar con exito, false en caso contrario
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
		try {//Solo por si no logró cerrar el archivo
			situpac.close();
		} catch (IOException e) {}
		return true;
	}
	
	/**
	 * Permite ingresar medicos en la BD
	 * @param medico el medico ingresado
	 * @return true si logró ingresar con exito, false en caso contrario
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
		try {//Solo por si no logró cerrar el archivo
			datomed.close();
		} catch (IOException e) {}
		return true;
	}
	
	/**
	 * La consulta de un medico, se usa para consultar su especialdiad
	 * @param codMed codigo del medico pedido
	 * @return el objeto Medico buscado
	 */
	public static Medico consultarMedico(int codMed) {
		BufferedReader datomed = null;
		Medico medico=null;
		String[] line;
		String aux;
		boolean continuar=true;
		try {
			datomed = new BufferedReader(new FileReader(DATOS_MEDICOS_FILE));
			while(continuar && (aux=datomed.readLine())!=null) {
				line=aux.split("|");
				if(Integer.parseInt(line[0])==codMed) {
					medico=new Medico(Integer.parseInt(line[0]),line[1],line[2]);
					continuar=false;
				}
			//DUDA: este close no tiene que ir fuera del while?
			datomed.close();
			}
			
		} catch (IOException e) {
			return null;
		}
		try {
			datomed.close();
		} catch (IOException e) {}
		return medico;
	}
	
	//Falta traer pacientes por medico
	public static List<Paciente> traerPacientesXMedico(int codMed) {
		List<Paciente> lista = new ArrayList<Paciente>();
		Paciente aux;
		String linea;
		
		try {
			BufferedReader situpac = new BufferedReader(new FileReader(DATOS_DIAGNOSTICO_FILE));
			
			while( (linea = situpac.readLine()) != null) {
				String[] lineaPartida = linea.split("|");
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
	 * Si no lo encuentra u ocurre una excepción, devuelve null.
	 * @param codPaciente
	 * @return
	 */
	private static Paciente consultarPaciente(String codPaciente) {
		String linea;
		try {
			BufferedReader datopac = new BufferedReader(new FileReader(DATOS_PACIENTES_FILE));
			while((linea = datopac.readLine()) != null) {
				String[] lineaPartida = linea.split("|");
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
	 * Trae el ultimo codigo de la ultima linea de un archivo de medicos o pacientes
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
				//DUDA: puede ser que este if y close vayan fuera del while?
				if(lastString!=null)
					last=Integer.parseInt(lastString.split("|")[0]);
				datomed.close();
			}
		} catch (IOException e) {
			return null;
		}
		return new Integer(last);
	}
}
