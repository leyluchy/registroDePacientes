package clinicaDrStrange;

public class GestorInformes {

	/**
	 * Busca los pacientes que alguna vez diagnostico cierto medico, identificado
	 * por el codigo de medico. Los devuelve en un array de pacientes.
	 * Si no hay pacientes u ocurre una excepción, devuelve un array vacío.
	 * @param codMed
	 * @return
	 */
	public static Paciente[] traerListaDePacientesPorMedico(int codMed) {
		return (Paciente[]) GestorBD.traerPacientesXMedico(codMed).toArray();
	}
	
	/**
	 * Levanta un medico de la BD a partir del codigo. Si el medico no existe o
	 * hay una excepción devuelve null.
	 * @param codMed
	 * @return
	 */
	public static Medico traerMedico(int codMed) {
		return GestorBD.consultarMedico(codMed);
	}
	
	/**
	 * Busca los diagnosticos que realizo ese medico y los devuelve en un array.
	 * Si no se encuentran diagnosticos u ocurre un error, devuelve el array
	 * vacío.
	 * @param codMed
	 * @return
	 */
	public static Diagnostico[] traerDiagnosticosDeMedico (int codMed) {
		return (Diagnostico[]) GestorBD.consultarDiagnosticosXMedico(codMed).toArray();
	}
}
