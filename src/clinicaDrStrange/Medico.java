package clinicaDrStrange;

public class Medico {

	private int codigoMedico;
	private String nombreYApellido;
	private String especializacion;
	
	/**
	 * Un médico tiene un código único, un nombre y apellido
	 * y una especialidad.
	 * 
	 * O(1)
	 * @param codMed
	 * @param nyap
	 * @param esp
	 */
	public Medico(int codMed, String nyap, String esp) {
		this.codigoMedico=codMed;
		this.nombreYApellido=nyap;
		this.especializacion=esp;
	}
	
	/**
	 * Devuelve el código del médico
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
	 * Devuelve una string con nombre y apellido
	 * 
	 * O(1)
	 * @return
	 */
	public String getNombreYApellido() {
		return nombreYApellido;
	}
	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}
	
	/**
	 * Devuelve una string con la especialidad
	 * 
	 * O(1)
	 * @return
	 */
	public String getEspecializacion() {
		return especializacion;
	}
	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}
	
}
