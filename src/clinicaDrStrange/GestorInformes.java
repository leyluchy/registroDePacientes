package clinicaDrStrange;

import java.util.List;

public class GestorInformes {

	/**
	 * Busca los pacientes que alguna vez diagnostico cierto medico, identificado
	 * por el codigo de medico. Los devuelve en un array de pacientes.
	 * Si no hay pacientes u ocurre una excepci�n, devuelve un array vac�o.
	 * @param codMed
	 * @return
	 */
	public static List<Paciente> traerListaDePacientesPorMedico(int codMed) {
		return GestorBD.traerPacientesXMedico(codMed);
	}
	
	/**
	 * Levanta un medico de la BD a partir del codigo. Si el medico no existe o
	 * hay una excepci�n devuelve null.
	 * @param codMed
	 * @return
	 */
	public static Medico traerMedico(int codMed) {
		return GestorBD.consultarMedico(codMed);
	}
	
	/**
	 * Busca los diagnosticos que realizo ese medico y los devuelve en un array.
	 * Si no se encuentran diagnosticos u ocurre un error, devuelve el array
	 * vac�o.
	 * @param codMed
	 * @return
	 */
	public static List<Diagnostico> traerDiagnosticosDeMedico (int codMed) {
		return GestorBD.consultarDiagnosticosXMedico(codMed);
	}
}
