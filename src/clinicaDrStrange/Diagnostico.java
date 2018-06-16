package clinicaDrStrange;

/**
 * Un diagnóstico es lo que el médico decide que le pasa al paciente.
 * Una instancia de esta clase tiene el diagnóstico en sí y su asociación
 * a un médico y a un paciente.
 */
public class Diagnostico {

	private int codigoPaciente;
	private int codigoMedico;
	private String diagnostico;
	
	/**
	 * Un diagnóstico se crea a partir del código del paciente diagnosticado,
	 * el código del médico que diagnostica y un texto con el diagnóstico en
	 * sí.
	 * 
	 * O(1)
	 * @param codPaciente
	 * @param codMedico
	 * @param diagnostico
	 */
	public Diagnostico(int codPaciente, int codMedico, String diagnostico) {
		setCodigoPaciente(codPaciente);
		setCodigoMedico(codMedico);
		setDiagnostico(diagnostico);
	}
	
	/**
	 * Devuelve el código de paciente diagnosticado
	 * 
	 * O(1)
	 * @return
	 */
	public int getCodigoPaciente() {
		return codigoPaciente;
	}
	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}
	
	/**
	 * Devuelve el código del médico que escribió el diagnóstico
	 * 
	 * O(1)
	 * @return
	 */
	public int getCodigoMedico() {
		return codigoMedico;
	}
	public void setCodigoMedico(int codigoMedico) {
		this.codigoMedico = codigoMedico;
	}
	
	/**
	 * Devuelve un texto con el diagnóstico
	 * 
	 * O(1)
	 * @return
	 */
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	
}
