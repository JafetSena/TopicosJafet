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
public class ValidarExpresion extends JFrame {

	private JPanel contentPane;
	private JButton btnValidar;
	private JTextField txtExpresion;
	private Stack<String> miPila = new Stack<String>();

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
				String strExpresion = txtExpresion.getText();
				for(int i=0; i < strExpresion.length(); i++) {
					if( strExpresion.charAt(i) == '(' ) {
						miPila.push("(");
					}
					if( strExpresion.charAt(i) == ')') {
						if( !miPila.empty() ) {
							miPila.pop();
						}
					}
					
				}
				
				if (miPila.empty()) 
					JOptionPane.showMessageDialog(null, "La expresión algebráica está completa.");
				else
					JOptionPane.showMessageDialog(null, "La expresión alegráica está incompleta.");
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
