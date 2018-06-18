package clinicaDrStrange;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JList;


public class Pantalla {

	private JFrame frmLogin;
	private JTextField textFieldUsername;
	private JTextField textFieldPass;
	private JTextField textPacienteName;
	private JTextField textCodMed;
	private JTextField textCodPac;
	private JTextField textNomMed;
	private JTextField textEsp;
	private JTextField textMedBuscadorPac;
	private JTextField textDiagXMed;

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
					if(Login.login(textFieldUsername.getText(), textFieldPass.getText())) {
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
				frmLogin.setTitle("Menú de informes");
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
		btnEnfXMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setTitle("Enfermedades que atiende cada médico");
				CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
				cl.next(ventanaPrincipal);
				cl.next(ventanaPrincipal);
				cl.next(ventanaPrincipal);
				cl.next(ventanaPrincipal);
				cl.next(ventanaPrincipal);
				cl.next(ventanaPrincipal);
			}
		});
		btnEnfXMed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnfXMed.setBounds(71, 89, 282, 54);
		panelConsultas.add(btnEnfXMed);
		
		JButton btnPacXMed = new JButton("Listado de Pacientes por Medico");
		btnPacXMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setTitle("Listado de Pacientes por Médico");
				CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
				cl.next(ventanaPrincipal);
				cl.next(ventanaPrincipal);
				cl.next(ventanaPrincipal);
				cl.next(ventanaPrincipal);
				cl.next(ventanaPrincipal);
			}
		});
		btnPacXMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPacXMed.setBounds(71, 11, 282, 54);
		panelConsultas.add(btnPacXMed);
		
		JPanel panelIngreso = new JPanel();
		ventanaPrincipal.add(panelIngreso, "name_7457108944068");
		panelIngreso.setLayout(null);
		
		JButton btnPaciente = new JButton("Datos del Paciente");
		btnPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setTitle("Ingreso de Pacientes");
				CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
				cl.next(ventanaPrincipal);
			}
		});
		btnPaciente.setBounds(33, 27, 174, 73);
		btnPaciente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelIngreso.add(btnPaciente);
		
		JButton btnMedico = new JButton("Datos del Medico");
		btnMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setTitle("Ingreso de Personal");
				CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
				cl.next(ventanaPrincipal);
				cl.next(ventanaPrincipal);
				cl.next(ventanaPrincipal);
			}
		});
		btnMedico.setBounds(33, 123, 174, 73);
		btnMedico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelIngreso.add(btnMedico);
		
		JButton btnDiagnostico = new JButton("Situaci\u00F3n del Paciente");
		btnDiagnostico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setTitle("Ingreso de Diagnosticos");
				CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
				cl.next(ventanaPrincipal);
				cl.next(ventanaPrincipal);
			}
		});
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
		panelIngPacientes.setLayout(null);
		
		JLabel lblNombreDelPaciente = new JLabel("Nombre del paciente:");
		lblNombreDelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDelPaciente.setBounds(10, 76, 148, 25);
		panelIngPacientes.add(lblNombreDelPaciente);
		
		textPacienteName = new JTextField();
		textPacienteName.setHorizontalAlignment(SwingConstants.LEFT);
		textPacienteName.setBounds(159, 78, 262, 25);
		panelIngPacientes.add(textPacienteName);
		textPacienteName.setColumns(10);
		
		JButton btnIngresarPaciente = new JButton("A\u00F1adir");
		btnIngresarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Integer codpac;
			if(Utilidades.textoDeCajaValido(textPacienteName.getText())) {
				if((codpac = GestorIngresoDatos.ingresoDatosPaciente(textPacienteName.getText())) != null)
					JOptionPane.showMessageDialog(null, "Paciente guardado con código: "+codpac.intValue(), "Código", JOptionPane.INFORMATION_MESSAGE);
				else 
					JOptionPane.showMessageDialog(null, "Error de acceso a la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			else
				JOptionPane.showMessageDialog(null, "Campo vacío o con caracteres invalidos", "Error", JOptionPane.ERROR_MESSAGE);
			textPacienteName.setText("");
			}
		});
		btnIngresarPaciente.setBounds(89, 169, 117, 23);
		panelIngPacientes.add(btnIngresarPaciente);
		
		JButton btnAnterior2 = new JButton("Anterior");
		btnAnterior2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLogin.setTitle("Menú de ingreso de datos");
				CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
				cl.previous(ventanaPrincipal);
			}
		});
		btnAnterior2.setBounds(236, 169, 117, 23);
		panelIngPacientes.add(btnAnterior2);
		
		JLabel lblIngresoDePacientes = new JLabel("Ingreso de Pacientes");
		lblIngresoDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresoDePacientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIngresoDePacientes.setBounds(10, 11, 411, 23);
		panelIngPacientes.add(lblIngresoDePacientes);
		
		JPanel panelIngDiagnosticos = new JPanel();
		ventanaPrincipal.add(panelIngDiagnosticos, "name_7536857381278");
		panelIngDiagnosticos.setLayout(null);
		
		JLabel lblCdigoDeMdico = new JLabel("C\u00F3digo de M\u00E9dico");
		lblCdigoDeMdico.setBounds(10, 37, 92, 23);
		panelIngDiagnosticos.add(lblCdigoDeMdico);
		
		textCodMed = new JTextField();
		textCodMed.setBounds(108, 37, 313, 23);
		panelIngDiagnosticos.add(textCodMed);
		textCodMed.setColumns(10);
		
		JLabel lblCdigoDePaciente = new JLabel("C\u00F3digo de Paciente");
		lblCdigoDePaciente.setBounds(10, 76, 92, 23);
		panelIngDiagnosticos.add(lblCdigoDePaciente);
		
		textCodPac = new JTextField();
		textCodPac.setColumns(10);
		textCodPac.setBounds(108, 71, 313, 23);
		panelIngDiagnosticos.add(textCodPac);
		
		JLabel lblDiagnostico = new JLabel("Diagnostico");
		lblDiagnostico.setBounds(10, 110, 92, 23);
		panelIngDiagnosticos.add(lblDiagnostico);
		
		JTextArea textDiagnostico = new JTextArea();
		textDiagnostico.setWrapStyleWord(true);
		textDiagnostico.setLineWrap(true);
		textDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDiagnostico.setBounds(108, 105, 313, 59);
		//panelIngDiagnosticos.add(textDiagnostico);
		
		JScrollPane textScroll = new JScrollPane(textDiagnostico);
		textScroll.setBounds(108, 105, 313, 59);
		panelIngDiagnosticos.add(textScroll);
		
		
		JButton btnIngDiagnostico = new JButton("A\u00F1adir");
		btnIngDiagnostico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Utilidades.textoDeCajaValido(textCodMed.getText()) && Utilidades.isNumber(textCodMed.getText())
						&& Utilidades.textoDeCajaValido(textCodPac.getText()) && Utilidades.isNumber(textCodPac.getText())
						&& Utilidades.textoDeCajaValido(textDiagnostico.getText())) {
					if(GestorIngresoDatos.ingresosituacionPaciente(Integer.parseInt(textCodPac.getText()), Integer.parseInt(textCodMed.getText()), textDiagnostico.getText()))
						JOptionPane.showMessageDialog(null, "Guardado de diagnostico exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					else 
						JOptionPane.showMessageDialog(null, "Error de acceso a la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				else
					JOptionPane.showMessageDialog(null, "Campos vacíos o con caracteres invalidos", "Error", JOptionPane.ERROR_MESSAGE);
				textCodMed.setText("");
				textCodPac.setText("");
				textDiagnostico.setText("");
				
			}
		});
		btnIngDiagnostico.setBounds(71, 175, 89, 23);
		panelIngDiagnosticos.add(btnIngDiagnostico);
		
		JButton buttonVolver3 = new JButton("Anterior");
		buttonVolver3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setTitle("Menú de ingreso de datos");
				CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
				cl.previous(ventanaPrincipal);
				cl.previous(ventanaPrincipal);
			}
		});
		buttonVolver3.setBounds(233, 175, 89, 23);
		panelIngDiagnosticos.add(buttonVolver3);
		
		JLabel lblNewLabel = new JLabel("Ingreso de Diagnosticos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 411, 23);
		panelIngDiagnosticos.add(lblNewLabel);
		
		JPanel panelIngMedicos = new JPanel();
		ventanaPrincipal.add(panelIngMedicos, "name_7547961131497");
		panelIngMedicos.setLayout(null);
		
		JLabel lblNombreDelMdico = new JLabel("Nombre del m\u00E9dico:");
		lblNombreDelMdico.setBounds(10, 58, 130, 17);
		lblNombreDelMdico.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelMdico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelIngMedicos.add(lblNombreDelMdico);
		
		textNomMed = new JTextField();
		textNomMed.setBounds(150, 58, 271, 20);
		textNomMed.setHorizontalAlignment(SwingConstants.LEFT);
		textNomMed.setColumns(10);
		panelIngMedicos.add(textNomMed);
		
		JLabel lblEspecialidadMdica = new JLabel("Especialidad m\u00E9dica:");
		lblEspecialidadMdica.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecialidadMdica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEspecialidadMdica.setBounds(10, 107, 130, 17);
		panelIngMedicos.add(lblEspecialidadMdica);
		
		textEsp = new JTextField();
		textEsp.setHorizontalAlignment(SwingConstants.LEFT);
		textEsp.setColumns(10);
		textEsp.setBounds(150, 107, 271, 20);
		panelIngMedicos.add(textEsp);
		
		JButton button_1 = new JButton("A\u00F1adir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer codmed;
				if(Utilidades.textoDeCajaValido(textNomMed.getText()) && Utilidades.textoDeCajaValido(textEsp.getText())) {
					if((codmed = GestorIngresoDatos.ingresoDatosMedico(textNomMed.getText(), textEsp.getText())) != null)
						JOptionPane.showMessageDialog(null, "Médico guardado con código: "+codmed.intValue(), "Código", JOptionPane.INFORMATION_MESSAGE);
					else 
						JOptionPane.showMessageDialog(null, "Error de acceso a la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				else
					JOptionPane.showMessageDialog(null, "Campos vacíos o con caracteres invalidos", "Error", JOptionPane.ERROR_MESSAGE);
				textNomMed.setText("");
				textEsp.setText("");
			}
		});
		button_1.setBounds(74, 168, 89, 23);
		panelIngMedicos.add(button_1);
		
		JButton button_2 = new JButton("Anterior");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setTitle("Registro de Pacientes");
				CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
				cl.previous(ventanaPrincipal);
				cl.previous(ventanaPrincipal);
				cl.previous(ventanaPrincipal);
			}
		});
		button_2.setBounds(236, 168, 89, 23);
		panelIngMedicos.add(button_2);
		
		JLabel lblIngresoDeMdicos = new JLabel("Ingreso de M\u00E9dicos");
		lblIngresoDeMdicos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresoDeMdicos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIngresoDeMdicos.setBounds(10, 11, 411, 23);
		panelIngMedicos.add(lblIngresoDeMdicos);
		
		JPanel panelPacXMedicos = new JPanel();
		ventanaPrincipal.add(panelPacXMedicos, "name_7565553789194");
		panelPacXMedicos.setLayout(null);
		
		JList<String> listPac = new JList<String>(new DefaultListModel<>());
		listPac.setBounds(209, 73, 65, 41);
		//panelPacXMedicos.add(list);
		JScrollPane sliderPac= new JScrollPane(listPac);
		sliderPac.setBounds(10, 76, 411, 104);
		panelPacXMedicos.add(sliderPac);
		
		JLabel lblCdigoDeMedico = new JLabel("C\u00F3digo de Medico:");
		lblCdigoDeMedico.setBounds(10, 46, 91, 14);
		panelPacXMedicos.add(lblCdigoDeMedico);
		
		textMedBuscadorPac = new JTextField();
		textMedBuscadorPac.setBounds(111, 43, 201, 20);
		panelPacXMedicos.add(textMedBuscadorPac);
		textMedBuscadorPac.setColumns(10);
		
		JButton btnBuscarPacXMed = new JButton("Buscar");
		btnBuscarPacXMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultListModel<String>) listPac.getModel()).removeAllElements();
				if(Utilidades.textoDeCajaValido(textMedBuscadorPac.getText()) && Utilidades.isNumber(textMedBuscadorPac.getText())) {
					String nomMed = GestorInformes.traerMedico(Integer.parseInt(textMedBuscadorPac.getText()));
					if(nomMed != null) {
					ArrayList<String> listaPac=GestorInformes.traerListaDePacientesPorMedico(Integer.parseInt(textMedBuscadorPac.getText()));
						if(listaPac != null && !listaPac.isEmpty()) {
							((DefaultListModel<String>) listPac.getModel()).addElement("El medico " + nomMed + " atiende a los siguientes pacientes: ");
							for(String nombrePaciente : listaPac)
								((DefaultListModel<String>) listPac.getModel()).addElement(nombrePaciente);
						}
						else
							JOptionPane.showMessageDialog(null, "El médico "+nomMed+" no atiende a ningun paciente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null, "Médico inexistente o error de acceso a la Base de datos", "Error", JOptionPane.ERROR_MESSAGE);
				}else
					JOptionPane.showMessageDialog(null, "Campo vacío o con caracteres invalidos", "Error", JOptionPane.ERROR_MESSAGE);
				textMedBuscadorPac.setText("");
			}
		});
		btnBuscarPacXMed.setBounds(332, 42, 89, 23);
		panelPacXMedicos.add(btnBuscarPacXMed);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textMedBuscadorPac.setText("");
				//limpiar lista
				((DefaultListModel<String>) listPac.getModel()).removeAllElements();
				frmLogin.setTitle("Menú de informes");
				CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
				cl.previous(ventanaPrincipal);
				cl.previous(ventanaPrincipal);
				cl.previous(ventanaPrincipal);
				cl.previous(ventanaPrincipal);
				cl.previous(ventanaPrincipal);
			}
		});
		btnAnterior.setBounds(167, 191, 89, 23);
		panelPacXMedicos.add(btnAnterior);
		
		JLabel lblListadoDePacientes = new JLabel("Listado de Pacientes por M\u00E9dico");
		lblListadoDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDePacientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListadoDePacientes.setBounds(10, 11, 411, 23);
		panelPacXMedicos.add(lblListadoDePacientes);
		
		JPanel panelDiagXMedicos = new JPanel();
		panelDiagXMedicos.setLayout(null);
		ventanaPrincipal.add(panelDiagXMedicos, "name_66180703742827");
		
		JList<String> listDiag = new JList<String>(new DefaultListModel<>());
		listDiag.setBounds(0, 0, 4, 22);
		//panelDiagXMedicos.add(textArea);
		
		JScrollPane sliderDiag = new JScrollPane(listDiag);
		sliderDiag.setBounds(10, 79, 411, 101);
		panelDiagXMedicos.add(sliderDiag);
		
		JLabel label = new JLabel("C\u00F3digo de Medico:");
		label.setBounds(10, 49, 91, 14);
		panelDiagXMedicos.add(label);
		
		textDiagXMed = new JTextField();
		textDiagXMed.setColumns(10);
		textDiagXMed.setBounds(111, 46, 201, 20);
		panelDiagXMedicos.add(textDiagXMed);
		
		JButton btnBuscarDiagXMed = new JButton("Buscar");
		btnBuscarDiagXMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultListModel<String>) listDiag.getModel()).removeAllElements();
				if(Utilidades.textoDeCajaValido(textDiagXMed.getText()) && Utilidades.isNumber(textDiagXMed.getText())) {
					String nomMed = GestorInformes.traerMedico(Integer.parseInt(textDiagXMed.getText()));
					if(nomMed != null) {
					ArrayList<String> listaDiag=GestorInformes.traerDiagnosticosDeMedico(Integer.parseInt(textDiagXMed.getText()));
						if(listaDiag != null && !listaDiag.isEmpty()) {
							((DefaultListModel<String>) listDiag.getModel()).addElement("El medico " + nomMed + " realizó los siguientes diagnosticos: ");
							for(String diagnostico : listaDiag)
								((DefaultListModel<String>) listDiag.getModel()).addElement(diagnostico);
						}
						else
							JOptionPane.showMessageDialog(null, "El médico "+nomMed+" no diagnosticó ninguna enfermedad", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null, "Médico inexistente o error de acceso a la Base de datos", "Error", JOptionPane.ERROR_MESSAGE);
				}else
					JOptionPane.showMessageDialog(null, "Campo vacío o con caracteres invalidos", "Error", JOptionPane.ERROR_MESSAGE);
				textDiagXMed.setText("");
			}
		});
		btnBuscarDiagXMed.setBounds(332, 45, 89, 23);
		panelDiagXMedicos.add(btnBuscarDiagXMed);
		
		JButton button_4 = new JButton("Anterior");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDiagXMed.setText("");
				//limpiar lista
				frmLogin.setTitle("Menú de informes");
				CardLayout cl = (CardLayout) (ventanaPrincipal.getLayout());
				cl.previous(ventanaPrincipal);
				cl.previous(ventanaPrincipal);
				cl.previous(ventanaPrincipal);
				cl.previous(ventanaPrincipal);
				cl.previous(ventanaPrincipal);
				cl.previous(ventanaPrincipal);
			}
		});
		button_4.setBounds(167, 191, 89, 23);
		panelDiagXMedicos.add(button_4);
		
		JLabel lblListadoDeDiagnosticos = new JLabel("Listado de Diagnosticos por M\u00E9dico");
		lblListadoDeDiagnosticos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeDiagnosticos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListadoDeDiagnosticos.setBounds(10, 11, 411, 23);
		panelDiagXMedicos.add(lblListadoDeDiagnosticos);
	}
}
