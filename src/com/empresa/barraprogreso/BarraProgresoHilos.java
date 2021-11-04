package com.empresa.barraprogreso;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BarraProgresoHilos extends JFrame {

	private JPanel contentPane;
	private JLabel lblHilo1;
	private JProgressBar prgHilo1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					BarraProgresoHilos frame = new BarraProgresoHilos();
					frame.setVisible(true);
					
	}

	/**
	 * Create the frame.
	 */
	public BarraProgresoHilos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				prgHilo1.setStringPainted(true);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblHilo1 = new JLabel("Hilo");
		lblHilo1.setBounds(104, 38, 46, 14);
		contentPane.add(lblHilo1);
		
		prgHilo1 = new JProgressBar();
		prgHilo1.setBounds(104, 63, 146, 24);
		contentPane.add(prgHilo1);
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = 0;
				prgHilo1.setValue(0);
				
				new HiloRunnable("miHilo1");
				try 
				{
					while(i<100) 
					{
						Thread.sleep(500);
						i+=10;
						prgHilo1.setValue(i);
					}
				}
				catch(InterruptedException x) {
					JOptionPane.showMessageDialog(null, x.getMessage());
				}
				JOptionPane.showMessageDialog(null, "El hilo ha terminado el progreso.");
				
			}
		});
		btnComenzar.setBounds(104, 123, 146, 23);
		contentPane.add(btnComenzar);
	}
}
