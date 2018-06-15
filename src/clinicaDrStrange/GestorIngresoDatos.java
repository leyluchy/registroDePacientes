package clinicaDrStrange;

public class GestorIngresoDatos {

	public static boolean ingresoDatosMedico(int codmed, String nommed, String espmed) {
		Medico med = new Medico(codmed, nommed, espmed);
		return false;
	}

	public static boolean ingresosituacionPaciente(int codp, int codm, String enfpac) {
		Diagnostico diag = new Diagnostico(codp, codm, enfpac);
		return false;
	}

	public static boolean ingresoDatosPaciente(int codpac, String nompac) {
		Paciente pac = new Paciente(codpac, nompac);
		return false;
	}
}
