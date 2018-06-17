package clinicaDrStrange;

import java.awt.EventQueue;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla {

	private JFrame frmLogin;
	private JTextField textFieldUsername;
	private JTextField textFieldPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		checkFilesExistence();
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Pantalla window = new Pantalla();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pantalla() {
		initialize();
	}

	private static void checkFilesExistence() {
		if(!GestorBD.checkFilesExistence()) {
			JOptionPane.showMessageDialog(null, "La instalación está corrupta, reinstale el programa", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 447, 264);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel ventanaPrincipal = new JPanel();
		frmLogin.getContentPane().add(ventanaPrincipal, "name_7335397165490");
		ventanaPrincipal.setLayout(new CardLayout(0, 0));
		
		JPanel panelLogin = new JPanel();
		ventanaPrincipal.add(panelLogin, "name_7389155882408");
		panelLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		lblLogin.setBounds(133, 11, 157, 71);
		panelLogin.add(lblLogin);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNombreDeUsuario.setBounds(20, 93, 157, 33);
		panelLogin.add(lblNombreDeUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblContrasea.setBounds(243, 93, 157, 33);
		panelLogin.add(lblContrasea);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(20, 137, 157, 20);
		panelLogin.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldPass = new JTextField();
		textFieldPass.setColumns(10);
		textFieldPass.setBounds(243, 137, 157, 20);
		panelLogin.add(textFieldPass);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(Principal.login(textFieldUsername.getText(), textFieldPass.getText())) {
						JOptionPane.showMessageDialog(null, "Ingreso exitoso", "Exito", JOptionPane.INFORMATION_MESSAGE);
						frmLogin.setTitle("Registro de Pacientes");
						CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
						cl.next(ventanaPrincipal);
					}
					else
						JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos", "Error de Autenticación", JOptionPane.INFORMATION_MESSAGE);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Error al acceder a los datos de usuario", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnIngresar.setBounds(133, 180, 157, 23);
		panelLogin.add(btnIngresar);
		
		JPanel panelPrincipal = new JPanel();
		ventanaPrincipal.add(panelPrincipal, "name_7402978886284");
		panelPrincipal.setLayout(null);
		
		JButton btnIngresoDatos = new JButton("Ingreso de datos");
		btnIngresoDatos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnIngresoDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLogin.setTitle("Menú de ingreso de datos");
				CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
				cl.next(ventanaPrincipal);
				cl.next(ventanaPrincipal);
			}
		});
		btnIngresoDatos.setBounds(124, 41, 168, 53);
		panelPrincipal.add(btnIngresoDatos);
		
		JButton btnConsultas = new JButton("Informes");
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
				cl.next(ventanaPrincipal);
			}
		});
		btnConsultas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsultas.setBounds(124, 123, 168, 53);
		panelPrincipal.add(btnConsultas);
		
		JButton button = new JButton("?");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Registro de pacientes-Grupo 4-2018", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button.setBounds(402, 202, 29, 23);
		panelPrincipal.add(button);
		
		JPanel panelConsultas = new JPanel();
		ventanaPrincipal.add(panelConsultas, "name_7443988783398");
		panelConsultas.setLayout(null);
		
		JButton btnVolver = new JButton("Anterior");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setTitle("Registro de Pacientes");
				CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
				cl.previous(ventanaPrincipal);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(71, 167, 282, 47);
		panelConsultas.add(btnVolver);
		
		JButton btnEnfXMed = new JButton("Enfermedades que atiende cada Medico");
		btnEnfXMed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnfXMed.setBounds(71, 96, 282, 47);
		panelConsultas.add(btnEnfXMed);
		
		JButton btnPacXMed = new JButton("Listado de Pacientes por Medico");
		btnPacXMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPacXMed.setBounds(71, 11, 282, 54);
		panelConsultas.add(btnPacXMed);
		
		JPanel panelIngreso = new JPanel();
		ventanaPrincipal.add(panelIngreso, "name_7457108944068");
		panelIngreso.setLayout(null);
		
		JButton btnPaciente = new JButton("Datos del Paciente");
		btnPaciente.setBounds(33, 27, 174, 73);
		btnPaciente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelIngreso.add(btnPaciente);
		
		JButton btnMedico = new JButton("Datos del Medico");
		btnMedico.setBounds(33, 123, 174, 73);
		btnMedico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelIngreso.add(btnMedico);
		
		JButton btnDiagnostico = new JButton("Situaci\u00F3n del Paciente");
		btnDiagnostico.setBounds(217, 27, 185, 73);
		btnDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelIngreso.add(btnDiagnostico);
		
		JButton btnVolver1 = new JButton("Anterior");
		btnVolver1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setTitle("Registro de Pacientes");
				CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
				cl.previous(ventanaPrincipal);
				cl.previous(ventanaPrincipal);
			}
		});
		btnVolver1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVolver1.setBounds(217, 123, 185, 73);
		panelIngreso.add(btnVolver1);
		
		JPanel panelIngPacientes = new JPanel();
		ventanaPrincipal.add(panelIngPacientes, "name_7523786327087");
		
		JPanel panelIngDiagnosticos = new JPanel();
		ventanaPrincipal.add(panelIngDiagnosticos, "name_7536857381278");
		
		JPanel panelIngMedicos = new JPanel();
		ventanaPrincipal.add(panelIngMedicos, "name_7547961131497");
		
		JPanel panelPacXMedicos = new JPanel();
		ventanaPrincipal.add(panelPacXMedicos, "name_7565553789194");
		
		JPanel panelEnfXMed = new JPanel();
		ventanaPrincipal.add(panelEnfXMed, "name_7583955999448");
	}
}
