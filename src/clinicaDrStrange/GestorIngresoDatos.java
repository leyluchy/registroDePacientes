package clinicaDrStrange;

public class GestorIngresoDatos {

	/**
	 * Ingresa un medico, y devuelve la posici�n del mismo
	 * O(medicos)
	 * @param codmed
	 * @param nommed
	 * @param espmed
	 * @return codigo de Medico si sali� bien, null si hay error de archivo
	 */
	public static Integer ingresoDatosMedico(String nommed, String espmed) {
		Integer ultimo=GestorBD.lastLine(GestorBD.DATOS_MEDICOS_FILE);
		if(ultimo==null)
			return null;
		Medico med = new Medico(ultimo+1, nommed, espmed);
		GestorBD.ingresarMedico(med);
		return new Integer(ultimo+1);
	}

	/**
	 * Ingresa una situaci�n de paciente, y devuelve true
	 * O(1)
	 * @param codp
	 * @param codm
	 * @param enfpac
	 * @return true si sali� bien, false si ocurri� alg�n error de BD
	 */
	public static boolean ingresosituacionPaciente(int codp, int codm, String enfpac) {
		Diagnostico diag = new Diagnostico(codp, codm, enfpac);
		return GestorBD.ingresarDiagnostico(diag);
	}

	/**
	 * Ingresa un paciente y devuelve la posicion del mismo
	 * O(pacientes)
	 * @param codpac
	 * @param nompac
	 * @return codigo de Paciente si sali� bien, null si hay error de archivo
	 */
	public static Integer ingresoDatosPaciente(String nompac) {
		Integer ultimo=GestorBD.lastLine(GestorBD.DATOS_PACIENTES_FILE);
		if(ultimo==null)
			return null;
		Paciente pac = new Paciente(ultimo+1, nompac);
		GestorBD.ingresarPaciente(pac);
		return new Integer(ultimo+1);
	}
}
