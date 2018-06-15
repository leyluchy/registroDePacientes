package clinicaDrStrange;

public class GestorIngresoDatos {

	/**
	 * Ingresa un medico, y devuelve la posición del 
	 * @param codmed
	 * @param nommed
	 * @param espmed
	 * @return codigo de Medico si salió bien, null si hay error de archivo
	 */
	public static Integer ingresoDatosMedico(String nommed, String espmed) {
		int ultimo=GestorBD.lastLine(GestorBD.DATOS_MEDICOS_FILE);
		Medico med = new Medico(ultimo+1, nommed, espmed);
		return ultimo+1;
	}

	public static boolean ingresosituacionPaciente(int codp, int codm, String enfpac) {
		Diagnostico diag = new Diagnostico(codp, codm, enfpac);
		return false;
	}

	/**
	 * 
	 * @param codpac
	 * @param nompac
	 * @return codigo de Paciente si salió bien, null si hay error de archivo
	 */
	public static Integer ingresoDatosPaciente(String nompac) {
		int ultimo=GestorBD.lastLine(GestorBD.DATOS_PACIENTES_FILE);
		Paciente pac = new Paciente(ultimo+1, nompac);
		return ultimo+1;
	}
}
