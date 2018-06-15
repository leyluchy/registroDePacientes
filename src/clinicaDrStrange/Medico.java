package clinicaDrStrange;

public class Medico {

	private int codigoMedico;
	private String nombreYApellido;
	private String especializacion;
	
	public Medico(int codMed, String nyap, String esp) {
		this.codigoMedico=codMed;
		this.nombreYApellido=nyap;
		this.especializacion=esp;
	}
	
	public int getCodigoMedico() {
		return codigoMedico;
	}
	public void setCodigoMedico(int codigoMedico) {
		this.codigoMedico = codigoMedico;
	}
	public String getNombreYApellido() {
		return nombreYApellido;
	}
	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}
	public String getEspecializacion() {
		return especializacion;
	}
	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}
	
}
