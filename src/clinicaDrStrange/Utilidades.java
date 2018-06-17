package clinicaDrStrange;

public class Utilidades {

	public static boolean blanco(String text) {
		return text.equals("");
	}
	
	private static boolean tienePipes(String text) {
		return text.contains("|");
	}
	
	private static boolean tieneSaltosDeLinea(String text) {
		return text.contains("\n");
	}
	
	public static boolean textoDeCajaValido(String text) {
		return (!blanco(text)&&!tienePipes(text)&&!tieneSaltosDeLinea(text));
	}
	
	public static boolean isNumber(String text) {
		try {
			Integer.parseInt(text);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
}
