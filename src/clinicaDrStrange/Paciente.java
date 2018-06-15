package clinicaDrStrange;

public class Paciente {

	private int codigoPaciente;
	private String nombreYApellido;
	
	public Paciente(int cod, String nom) {
		setCodigoPaciente(cod);
		setNombreYApellido(nom);
	}
	
	public int getCodigoPaciente() {
		return codigoPaciente;
	}
	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}
	public String getNombreYApellido() {
		return nombreYApellido;
	}
	public void setNombreYApellido(String nombreYAprellido) {
		this.nombreYApellido = nombreYAprellido;
	}
	
	
}