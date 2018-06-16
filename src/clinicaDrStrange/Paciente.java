package clinicaDrStrange;

public class Paciente {

	private int codigoPaciente;
	private String nombreYApellido;
	
	/**
	 * Un paciente es una persona que se atiende en esta clínica.
	 * Se lo identifica a partir de un código único, y se guarda
	 * su nombre y apellido en una misma string.
	 * 
	 * O(1)
	 * @param cod
	 * @param nom
	 */
	public Paciente(int cod, String nom) {
		setCodigoPaciente(cod);
		setNombreYApellido(nom);
	}
	
	/**
	 * Devuelve el código único del paciente.
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
	 * Devuelve el nombre y apellido en una string.
	 * O(1)
	 * @return
	 */
	public String getNombreYApellido() {
		return nombreYApellido;
	}
	public void setNombreYApellido(String nombreYAprellido) {
		this.nombreYApellido = nombreYAprellido;
	}
	
	
}
