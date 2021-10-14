package com.empresa.quiz;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;

public class VentanaQuiz extends JFrame {

	private JPanel contentPane;
	private ButtonGroup radGrupo;
	Quiz miPregunta1 = new Quiz("1. �Cu�l es el animal marino m�s grande del mundo?", "c) Ballena azul");
	Quiz miPregunta2 = new Quiz("2. �C�mo se le conoce al punto en el oc�ano m�s alejado de cualquier tierra firme?", "a) Punto nemo");
	Quiz miPregunta3 = new Quiz("3. �Qu� porcentaje se tiene estimado que se ha explorado de todo el oc�ano?", "b) 5%");
	Quiz miPregunta4 = new Quiz("4. �Qu� especie de tibur�n puede vivir hasta 500 a�os?", "c) Tibur�n de groenlandia");
	Quiz miPregunta5 = new Quiz("5. �C�mo se llama al punto m�s profundo en el oc�ano?", "a) Fosa de las marianas");
	private JRadioButton radRespuesta1;
	private JRadioButton radRespuesta2;
	private JRadioButton radRespuesta3;
	public int intPuntuacion;
	public int i = 0;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JLabel lblPregunta; 
	public String strPregunta[] = {"1. �Cu�l es el animal marino m�s grande del mundo?","2. �C�mo se le conoce al punto en el oc�ano m�s alejado de cualquier tierra firme?", "3. �Qu� porcentaje se tiene estimado que se ha explorado de todo el oc�ano?","4. �Qu� especie de tibur�n puede vivir hasta 500 a�os?","5. �C�mo se llama al punto m�s profundo en el oc�ano?"};
	private JButton btnSalir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		VentanaQuiz frame = new VentanaQuiz();
		frame.setVisible(true);
	}
	void CambiarPreguntas() {
		radGrupo.clearSelection();
		if(lblPregunta.getText()=="1. �Cu�l es el animal marino m�s grande del mundo?") {
			radRespuesta1.setText("a) Tibur�n ballena");
			radRespuesta2.setText("b) Orca");
			radRespuesta3.setText("c) Ballena azul");
		}
		if(lblPregunta.getText()=="2. �C�mo se le conoce al punto en el oc�ano m�s alejado de cualquier tierra firme?") {
			radRespuesta1.setText("a) Punto nemo");
			radRespuesta2.setText("b) Abismo challenger");
			radRespuesta3.setText("c) Triangulo de las bermudas");
		}
		if(lblPregunta.getText()=="3. �Qu� porcentaje se tiene estimado que se ha explorado de todo el oc�ano?") {
			radRespuesta1.setText("a) 70%");
			radRespuesta2.setText("b) 5%");
			radRespuesta3.setText("c) 95%");
		}
		if(lblPregunta.getText()=="4. �Qu� especie de tibur�n puede vivir hasta 500 a�os?") {
			radRespuesta1.setText("a) Tibur�n peregrino");
			radRespuesta2.setText("b) Tibur�n anguila");
			radRespuesta3.setText("c) Tibur�n de groenlandia");
		}
		if(lblPregunta.getText()=="5. �C�mo se llama al punto m�s profundo en el oc�ano?") {
			radRespuesta1.setText("a) Fosa de las marianas");
			radRespuesta2.setText("b) Fosa de las bermudas");
			radRespuesta3.setText("c) Estrecho de berlin");
		}
	}
	

	/**
	 * Create the frame.
	 */
	public VentanaQuiz() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				btnAnterior.setEnabled(false);
				radGrupo = new ButtonGroup();
				radGrupo.add(radRespuesta1);
				radGrupo.add(radRespuesta2);
				radGrupo.add(radRespuesta3);
				
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblPregunta = new JLabel("1. \u00BFCu\u00E1l es el animal marino m\u00E1s grande del mundo?");
		lblPregunta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPregunta.setBounds(33, 28, 523, 14);
		contentPane.add(lblPregunta);
		
		JButton btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String strEstado;
				intPuntuacion = 0;
				int intAciertos = 0;
				if(miPregunta1.ComprobarRespuesta()) {
					intPuntuacion += 20;
					intAciertos++;
				}
				if(miPregunta2.ComprobarRespuesta()) {
					intPuntuacion += 20;
					intAciertos++;
				}
				if(miPregunta3.ComprobarRespuesta()) {
					intPuntuacion += 20;
					intAciertos++;
				}
				if(miPregunta4.ComprobarRespuesta()) {
					intPuntuacion += 20;
					intAciertos++;
				}
				if(miPregunta5.ComprobarRespuesta()) {
					intPuntuacion += 20;
					intAciertos++;
				}
				
				if(intPuntuacion >= 70) {
					strEstado = "Aprobado";
				}
				else {
					strEstado = "Reprobado";
				}
				JOptionPane.showMessageDialog(btnEvaluar, "Calificaci�n: "+intPuntuacion+"\nAciertos: " + intAciertos + "/5\n" + strEstado);
			}
		});
		btnEvaluar.setBounds(279, 245, 89, 23);
		contentPane.add(btnEvaluar);
		
		radRespuesta1 = new JRadioButton("a) Tibur\u00F3n ballena");
		radRespuesta1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(lblPregunta.getText()=="1. �Cu�l es el animal marino m�s grande del mundo?") {
					miPregunta1.strRespuesta = radRespuesta1.getText();
				}
				if(lblPregunta.getText()=="2. �C�mo se le conoce al punto en el oc�ano m�s alejado de cualquier tierra firme?") {
					miPregunta2.strRespuesta = radRespuesta1.getText();
				}
				if(lblPregunta.getText()=="3. �Qu� porcentaje se tiene estimado que se ha explorado de todo el oc�ano?") {
					miPregunta3.strRespuesta = radRespuesta1.getText();
				}
				if(lblPregunta.getText()=="4. �Qu� especie de tibur�n puede vivir hasta 500 a�os?") {
					miPregunta4.strRespuesta = radRespuesta1.getText();
				}
				if(lblPregunta.getText()=="5. �C�mo se llama al punto m�s profundo en el oc�ano?") {
					miPregunta5.strRespuesta = radRespuesta1.getText();
				}
			}
		});
		radRespuesta1.setBounds(43, 59, 269, 23);
		contentPane.add(radRespuesta1);
		
		radRespuesta2 = new JRadioButton("b) Orca");
		radRespuesta2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(lblPregunta.getText()=="1. �Cu�l es el animal marino m�s grande del mundo?") {
					miPregunta1.strRespuesta = radRespuesta2.getText();
				}
				if(lblPregunta.getText()=="2. �C�mo se le conoce al punto en el oc�ano m�s alejado de cualquier tierra firme?") {
					miPregunta2.strRespuesta = radRespuesta2.getText();
				}
				if(lblPregunta.getText()=="3. �Qu� porcentaje se tiene estimado que se ha explorado de todo el oc�ano?") {
					miPregunta3.strRespuesta = radRespuesta2.getText();
				}
				if(lblPregunta.getText()=="4. �Qu� especie de tibur�n puede vivir hasta 500 a�os?") {
					miPregunta4.strRespuesta = radRespuesta2.getText();
				}
				if(lblPregunta.getText()=="5. �C�mo se llama al punto m�s profundo en el oc�ano?") {
					miPregunta5.strRespuesta = radRespuesta2.getText();
				}
			}
		});
		radRespuesta2.setBounds(43, 85, 269, 23);
		contentPane.add(radRespuesta2);
		
		radRespuesta3 = new JRadioButton("c) Ballena azul");
		radRespuesta3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(lblPregunta.getText()=="1. �Cu�l es el animal marino m�s grande del mundo?") {
					miPregunta1.strRespuesta = radRespuesta3.getText();
				}
				if(lblPregunta.getText()=="2. �C�mo se le conoce al punto en el oc�ano m�s alejado de cualquier tierra firme?") {
					miPregunta2.strRespuesta = radRespuesta3.getText();
				}
				if(lblPregunta.getText()=="3. �Qu� porcentaje se tiene estimado que se ha explorado de todo el oc�ano?") {
					miPregunta3.strRespuesta = radRespuesta3.getText();
				}
				if(lblPregunta.getText()=="4. �Qu� especie de tibur�n puede vivir hasta 500 a�os?") {
					miPregunta4.strRespuesta = radRespuesta3.getText();
				}
				if(lblPregunta.getText()=="5. �C�mo se llama al punto m�s profundo en el oc�ano?") {
					miPregunta5.strRespuesta = radRespuesta3.getText();
				}
			}
		});
		radRespuesta3.setBounds(43, 112, 269, 23);
		contentPane.add(radRespuesta3);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					i--;
					if(i==0) {
						btnAnterior.setEnabled(false);
					}
					if(i==3) {
						btnSiguiente.setEnabled(true);
					}
					lblPregunta.setText(strPregunta[i]);
					CambiarPreguntas();
			}
		});
		btnAnterior.setBounds(33, 245, 89, 23);
		contentPane.add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					i++;
					if(i==4) {
						btnSiguiente.setEnabled(false);
					}
					if(i==1) {
						btnAnterior.setEnabled(true);
					}
					lblPregunta.setText(strPregunta[i]);
					CambiarPreguntas();
			}
		});
		btnSiguiente.setBounds(132, 245, 89, 23);
		contentPane.add(btnSiguiente);
		
		btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(378, 245, 89, 23);
		contentPane.add(btnSalir);
		
	}
}
