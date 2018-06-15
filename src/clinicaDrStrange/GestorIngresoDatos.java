package clinicaDrStrange;

public class GestorIngresoDatos {

	/**
	 * 
	 * @param codmed
	 * @param nommed
	 * @param espmed
	 * @return codigo de Medico si salió bien, null si hay error de archivo
	 */
	public static Integer ingresoDatosMedico(int codmed, String nommed, String espmed) {
		int ultimo=GestorBD.lastLine(GestorBD.DATOS_MEDICOS_FILE);
		Medico med = new Medico(codmed, nommed, espmed);
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
	 * @return
	 */
	public static Integer ingresoDatosPaciente(int codpac, String nompac) {
		int ultimo=GestorBD.lastLine(GestorBD.DATOS_PACIENTES_FILE);
		Paciente pac = new Paciente(codpac, nompac);
		return ultimo+1;
	}
}
