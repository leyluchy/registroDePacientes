package clinicaDrStrange;

import java.util.ArrayList;

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
	public static ArrayList<String> traerListaDePacientesPorMedico(int codMed) {
		ArrayList<String> nombres = new ArrayList<String>();
		for(Paciente pac : GestorBD.traerPacientesXMedico(codMed))
			nombres.add(pac.getNombreYApellido());
		return nombres;
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
	public static ArrayList<String> traerDiagnosticosDeMedico (int codMed) {
		ArrayList<String> diags = new ArrayList<String>();
		for(Diagnostico d : GestorBD.consultarDiagnosticosXMedico(codMed))
			diags.add(d.getDiagnostico());
		return diags;
	}
}
