package com.empresa.quiz;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;

public class VentanaQuiz extends JFrame {

	private JPanel contentPane;
	private ButtonGroup radGrupo;
	private JComboBox<String> cboPreguntas;
	Quiz miPregunta1 = new Quiz("1. ¿Cuál es el animal marino más grande del mundo?", "c) Ballena azul");
	Quiz miPregunta2 = new Quiz("2. ¿Cómo se le conoce al punto en el océano más alejado de cualquier tierra firme?", "a) Punto nemo");
	Quiz miPregunta3 = new Quiz("3. ¿Qué porcentaje se tiene estimado que se ha explorado de todo el océano?", "b) 5%");
	Quiz miPregunta4 = new Quiz("4. ¿Qué especie de tiburón puede vivir hasta 500 años?", "c) Tiburón de groenlandia");
	Quiz miPregunta5 = new Quiz("5. ¿Cómo se llama al punto más profundo en el océano?", "a) Fosa de las marianas");
	private JRadioButton radRespuesta1;
	private JRadioButton radRespuesta2;
	private JRadioButton radRespuesta3;
	public int intPuntuacion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		VentanaQuiz frame = new VentanaQuiz();
		frame.setVisible(true);
	}
	void CambiarPreguntas() {
		
		if(cboPreguntas.getSelectedItem().toString()=="1. ¿Cuál es el animal marino más grande del mundo?") {
			radRespuesta1.setText("a) Tiburón ballena");
			radRespuesta2.setText("b) Orca");
			radRespuesta3.setText("c) Ballena azul");
		}
		else if(cboPreguntas.getSelectedItem().toString()=="2. ¿Cómo se le conoce al punto en el océano más alejado de cualquier tierra firme?") {
			radRespuesta1.setText("a) Punto nemo");
			radRespuesta2.setText("b) Abismo challenger");
			radRespuesta3.setText("c) Triangulo de las bermudas");
		}
		else if(cboPreguntas.getSelectedItem().toString()=="3. ¿Qué porcentaje se tiene estimado que se ha explorado de todo el océano?") {
			radRespuesta1.setText("a) 70%");
			radRespuesta2.setText("b) 5%");
			radRespuesta3.setText("c) 95%");
		}
		else if(cboPreguntas.getSelectedItem().toString()=="4. ¿Qué especie de tiburón puede vivir hasta 500 años?") {
			radRespuesta1.setText("a) Tiburón peregrino");
			radRespuesta2.setText("b) Tiburón anguila");
			radRespuesta3.setText("c) Tiburón de groenlandia");
		}
		else if(cboPreguntas.getSelectedItem().toString()=="5. ¿Cómo se llama al punto más profundo en el océano?") {
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
				radGrupo = new ButtonGroup();
				radGrupo.add(radRespuesta1);
				radGrupo.add(radRespuesta2);
				radGrupo.add(radRespuesta3);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblPreguntas = new JLabel("Preguntas:");
		lblPreguntas.setBounds(33, 28, 83, 14);
		contentPane.add(lblPreguntas);
		
		cboPreguntas = new JComboBox<String>();
		cboPreguntas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiarPreguntas();
				radGrupo.clearSelection();
			}
		});
		cboPreguntas.setModel(new DefaultComboBoxModel<String>(new String[] {"1. \u00BFCu\u00E1l es el animal marino m\u00E1s grande del mundo?", "2. \u00BFC\u00F3mo se le conoce al punto en el oc\u00E9ano m\u00E1s alejado de cualquier tierra firme?", "3. \u00BFQu\u00E9 porcentaje se tiene estimado que se ha explorado de todo el oc\u00E9ano?", "4. \u00BFQu\u00E9 especie de tibur\u00F3n puede vivir hasta 500 a\u00F1os?", "5. \u00BFC\u00F3mo se llama al punto m\u00E1s profundo en el oc\u00E9ano?"}));
		
		cboPreguntas.setToolTipText("");
		cboPreguntas.setBounds(33, 53, 523, 22);
		contentPane.add(cboPreguntas);
		
		JButton btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				intPuntuacion = 0;
				if(miPregunta1.ComprobarRespuesta()) {
					intPuntuacion += 20;
				}
				if(miPregunta2.ComprobarRespuesta()) {
					intPuntuacion += 20;
				}
				if(miPregunta3.ComprobarRespuesta()) {
					intPuntuacion += 20;
				}
				if(miPregunta4.ComprobarRespuesta()) {
					intPuntuacion += 20;
				}
				if(miPregunta5.ComprobarRespuesta()) {
					intPuntuacion += 20;
				}
				
				if(intPuntuacion >= 70) {
					JOptionPane.showMessageDialog(btnEvaluar, "Calificación: "+intPuntuacion+"\nAprobado.");
				}
				else {
					JOptionPane.showMessageDialog(btnEvaluar, "Calificación: "+intPuntuacion+"\nReprobado.");
				}
			}
		});
		btnEvaluar.setBounds(382, 245, 89, 23);
		contentPane.add(btnEvaluar);
		
		radRespuesta1 = new JRadioButton("a) Tibur\u00F3n ballena");
		radRespuesta1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cboPreguntas.getSelectedItem().toString()=="1. ¿Cuál es el animal marino más grande del mundo?") {
					miPregunta1.strRespuesta = radRespuesta1.getText();
				}
				if(cboPreguntas.getSelectedItem().toString()=="2. ¿Cómo se le conoce al punto en el océano más alejado de cualquier tierra firme?") {
					miPregunta2.strRespuesta = radRespuesta1.getText();
				}
				if(cboPreguntas.getSelectedItem().toString()=="3. ¿Qué porcentaje se tiene estimado que se ha explorado de todo el océano?") {
					miPregunta3.strRespuesta = radRespuesta1.getText();
				}
				if(cboPreguntas.getSelectedItem().toString()=="4. ¿Qué especie de tiburón puede vivir hasta 500 años?") {
					miPregunta4.strRespuesta = radRespuesta1.getText();
				}
				if(cboPreguntas.getSelectedItem().toString()=="5. ¿Cómo se llama al punto más profundo en el océano?") {
					miPregunta5.strRespuesta = radRespuesta1.getText();
				}
			}
		});
		radRespuesta1.setBounds(33, 82, 269, 23);
		contentPane.add(radRespuesta1);
		
		radRespuesta2 = new JRadioButton("b) Orca");
		radRespuesta2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cboPreguntas.getSelectedItem().toString()=="1. ¿Cuál es el animal marino más grande del mundo?") {
					miPregunta1.strRespuesta = radRespuesta2.getText();
				}
				if(cboPreguntas.getSelectedItem().toString()=="2. ¿Cómo se le conoce al punto en el océano más alejado de cualquier tierra firme?") {
					miPregunta2.strRespuesta = radRespuesta2.getText();
				}
				if(cboPreguntas.getSelectedItem().toString()=="3. ¿Qué porcentaje se tiene estimado que se ha explorado de todo el océano?") {
					miPregunta3.strRespuesta = radRespuesta2.getText();
				}
				if(cboPreguntas.getSelectedItem().toString()=="4. ¿Qué especie de tiburón puede vivir hasta 500 años?") {
					miPregunta4.strRespuesta = radRespuesta2.getText();
				}
				if(cboPreguntas.getSelectedItem().toString()=="5. ¿Cómo se llama al punto más profundo en el océano?") {
					miPregunta5.strRespuesta = radRespuesta2.getText();
				}
			}
		});
		radRespuesta2.setBounds(33, 121, 269, 23);
		contentPane.add(radRespuesta2);
		
		radRespuesta3 = new JRadioButton("c) Ballena azul");
		radRespuesta3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cboPreguntas.getSelectedItem().toString()=="1. ¿Cuál es el animal marino más grande del mundo?") {
					miPregunta1.strRespuesta = radRespuesta3.getText();
				}
				if(cboPreguntas.getSelectedItem().toString()=="2. ¿Cómo se le conoce al punto en el océano más alejado de cualquier tierra firme?") {
					miPregunta2.strRespuesta = radRespuesta3.getText();
				}
				if(cboPreguntas.getSelectedItem().toString()=="3. ¿Qué porcentaje se tiene estimado que se ha explorado de todo el océano?") {
					miPregunta3.strRespuesta = radRespuesta3.getText();
				}
				if(cboPreguntas.getSelectedItem().toString()=="4. ¿Qué especie de tiburón puede vivir hasta 500 años?") {
					miPregunta4.strRespuesta = radRespuesta3.getText();
				}
				if(cboPreguntas.getSelectedItem().toString()=="5. ¿Cómo se llama al punto más profundo en el océano?") {
					miPregunta5.strRespuesta = radRespuesta3.getText();
				}
			}
		});
		radRespuesta3.setBounds(33, 164, 269, 23);
		contentPane.add(radRespuesta3);
		
	}
}
