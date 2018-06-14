import java.awt.EventQueue;

public class Principal {
	public static void main(String args[]) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Controlpac();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
