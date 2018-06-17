package clinicaDrStrange;

import java.util.List;

public class GestorInformes {

	/**
	 * Busca los pacientes que alguna vez diagnostico cierto medico, identificado
	 * por el codigo de medico. Los devuelve en un array de pacientes.
	 * Si no hay pacientes u ocurre una excepción, devuelve un array vacío.
	 * 
	 * O(diags*pacientes)
	 * @param codMed
	 * @return
	 */
	public static String[] traerListaDePacientesPorMedico(int codMed) {
		GestorBD.traerPacientesXMedico(codMed);
	}
	
	/**
	 * Levanta un medico de la BD a partir del codigo. Si el medico no existe o
	 * hay una excepción devuelve null.
	 * 
	 * O(medicos)
	 * @param codMed
	 * @return
	 */
	public static String traerMedico(int codMed) {
		return GestorBD.consultarMedico(codMed);
	}
	
	/**
	 * Busca los diagnosticos que realizo ese medico y los devuelve en un array.
	 * Si no se encuentran diagnosticos u ocurre un error, devuelve el array
	 * vacío.
	 * 
	 * O(diags)
	 * @param codMed
	 * @return
	 */
	public static String[] traerDiagnosticosDeMedico (int codMed) {
		return GestorBD.consultarDiagnosticosXMedico(codMed);
	}
}
