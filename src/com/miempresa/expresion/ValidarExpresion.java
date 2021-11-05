package com.miempresa.expresion;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
public class ValidarExpresion extends JFrame {

	private JPanel contentPane;
	private JButton btnValidar;
	private JTextField txtExpresion;
	private LinkedList<String> miLista = new LinkedList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					ValidarExpresion frame = new ValidarExpresion();
					frame.setVisible(true);
					
	}

	/**
	 * Create the frame.
	 */
	public ValidarExpresion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnValidar = new JButton("Validar");
		btnValidar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miLista.clear();
				String strExpresion = txtExpresion.getText();
				for(int i=0; i < strExpresion.length(); i++) {
					if( strExpresion.charAt(i) == '(' ) {
						miLista.addFirst("(");
					}
					if( strExpresion.charAt(i) == ')') {
						if(miLista.contains("(")) {
							miLista.removeFirst();
						}
						else {
							miLista.addLast(")");
						}
					}
				}
				if (miLista.isEmpty()) 
					JOptionPane.showMessageDialog(null, "La expresión algebráica está correcta.");
				else
					JOptionPane.showMessageDialog(null, "La expresión alegráica está incorrecta.");
			}
		});
		btnValidar.setBounds(225, 148, 89, 23);
		contentPane.add(btnValidar);
		
		txtExpresion = new JTextField();
		txtExpresion.setBounds(147, 117, 230, 20);
		contentPane.add(txtExpresion);
		txtExpresion.setColumns(10);
		
		JLabel lblIngreseExpresion = new JLabel("Ingrese la expresi\u00F3n algebr\u00E1ica:");
		lblIngreseExpresion.setBounds(147, 92, 230, 14);
		contentPane.add(lblIngreseExpresion);
	}
}
