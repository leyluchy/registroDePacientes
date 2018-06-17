package clinicaDrStrange;

import java.util.LinkedList;
import java.util.List;

public class GestorInformes {

	/**
	 * Busca los pacientes que alguna vez diagnostico cierto medico, identificado
	 * por el codigo de medico. Devuelve los nombres de los pacientes en un array
	 * de strings.
	 * Si no hay pacientes u ocurre una excepción, devuelve un array vacío.
	 * 
	 * O(diags*pacientes)
	 * @param codMed
	 * @return
	 */
	public static String[] traerListaDePacientesPorMedico(int codMed) {
		List<String> nombres = new LinkedList<String>();
		for(Paciente pac : GestorBD.traerPacientesXMedico(codMed))
			nombres.add(pac.getNombreYApellido());
		return nombres.toArray(null);
	}
	
	/**
	 * Levanta un medico de la BD a partir del codigo y devuelve su nombre.
	 * Si el medico no existe o hay una excepción devuelve null.
	 * 
	 * O(medicos)
	 * @param codMed
	 * @return
	 */
	public static String traerMedico(int codMed) {
		Medico med = GestorBD.consultarMedico(codMed);
		if(med != null)
			return med.getNombreYApellido();
		return null;
	}
	
	/**
	 * Busca los diagnosticos que realizo ese medico y los devuelve en un array
	 * de strings.
	 * Si no se encuentran diagnosticos u ocurre un error, devuelve el array
	 * vacío.
	 * 
	 * O(diags)
	 * @param codMed
	 * @return
	 */
	public static String[] traerDiagnosticosDeMedico (int codMed) {
		List<String> diags = new LinkedList<String>();
		for(Diagnostico d : GestorBD.consultarDiagnosticosXMedico(codMed))
			diags.add(d.getDiagnostico());
		return diags.toArray(null);
	}
}
