package clinicaDrStrange;

/**
 * Un diagn�stico es lo que el m�dico decide que le pasa al paciente.
 * Una instancia de esta clase tiene el diagn�stico en s� y su asociaci�n
 * a un m�dico y a un paciente.
 */
public class Diagnostico {

	private int codigoPaciente;
	private int codigoMedico;
	private String diagnostico;
	
	/**
	 * Un diagn�stico se crea a partir del c�digo del paciente diagnosticado,
	 * el c�digo del m�dico que diagnostica y un texto con el diagn�stico en
	 * s�.
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
	 * Devuelve el c�digo de paciente diagnosticado
	 * @return
	 */
	public int getCodigoPaciente() {
		return codigoPaciente;
	}
	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}
	
	/**
	 * Devuelve el c�digo del m�dico que escribi� el diagn�stico
	 * @return
	 */
	public int getCodigoMedico() {
		return codigoMedico;
	}
	public void setCodigoMedico(int codigoMedico) {
		this.codigoMedico = codigoMedico;
	}
	
	/**
	 * Devuelve un texto con el diagn�stico
	 * @return
	 */
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	
}
