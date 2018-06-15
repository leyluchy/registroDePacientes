package clinicaDrStrange;

public class GestorIngresoDatos {

	/**
	 * Ingresa un medico, y devuelve la posición del mismo
	 * @param codmed
	 * @param nommed
	 * @param espmed
	 * @return codigo de Medico si salió bien, null si hay error de archivo
	 */
	public static Integer ingresoDatosMedico(String nommed, String espmed) {
		Integer ultimo=GestorBD.lastLine(GestorBD.DATOS_MEDICOS_FILE);
		if(ultimo==null)
			return null;
		Medico med = new Medico(ultimo+1, nommed, espmed);
		return new Integer(ultimo+1);
	}

	/**
	 * Ingresa una situación de paciente, y devuelve true
	 * @param codp
	 * @param codm
	 * @param enfpac
	 * @return true si salió bien, false si ocurrió algún error de BD
	 */
	public static boolean ingresosituacionPaciente(int codp, int codm, String enfpac) {
		Diagnostico diag = new Diagnostico(codp, codm, enfpac);
		return false;
	}

	/**
	 * Ingresa un paciente y devuelve la posicion del mismo
	 * @param codpac
	 * @param nompac
	 * @return codigo de Paciente si salió bien, null si hay error de archivo
	 */
	public static Integer ingresoDatosPaciente(String nompac) {
		Integer ultimo=GestorBD.lastLine(GestorBD.DATOS_PACIENTES_FILE);
		if(ultimo==null)
			return null;
		Paciente pac = new Paciente(ultimo+1, nompac);
		return new Integer(ultimo+1);
	}
}
