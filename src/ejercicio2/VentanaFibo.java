package ejercicio2;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class VentanaFibo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumero1;
	private JTextField txtNumero2;
	private JTextField txtIteraciones;
	private JTextArea inputSerie;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		VentanaFibo frame = new VentanaFibo();
		frame.setVisible(true);
	}
	/**
	 * Create the frame.
	 */
	public VentanaFibo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(260, 209, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int varNumero1 = Integer.parseInt(txtNumero1.getText());
				int varNumero2 = Integer.parseInt(txtNumero2.getText());
				int varIteraciones = Integer.parseInt(txtIteraciones.getText());
				int i = 0;
				int Suma = 0;
				String cadena = "";
				while(i<varIteraciones)
		        {
		            Suma = varNumero1 + varNumero2;
		            
		            varNumero1 = varNumero2;
		            varNumero2 = Suma;
		            cadena = cadena + " " + Suma;
		            i++;
		        }
				inputSerie.setText(cadena);
			}
		});
		btnGenerar.setBounds(29, 209, 89, 23);
		contentPane.add(btnGenerar);
		
		txtNumero1 = new JTextField();
		txtNumero1.setBounds(219, 24, 73, 20);
		contentPane.add(txtNumero1);
		txtNumero1.setColumns(10);
		
		JLabel lblNumero1 = new JLabel("Numero 1:");
		lblNumero1.setBounds(100, 27, 73, 14);
		contentPane.add(lblNumero1);
		
		JLabel lblNumero2 = new JLabel("Numero 2:");
		lblNumero2.setBounds(100, 72, 73, 14);
		contentPane.add(lblNumero2);
		
		txtNumero2 = new JTextField();
		txtNumero2.setColumns(10);
		txtNumero2.setBounds(219, 69, 73, 20);
		contentPane.add(txtNumero2);
		
		JLabel lblIteraciones = new JLabel("Iteraciones:");
		lblIteraciones.setBounds(100, 114, 73, 14);
		contentPane.add(lblIteraciones);
		
		txtIteraciones = new JTextField();
		txtIteraciones.setColumns(10);
		txtIteraciones.setBounds(219, 111, 73, 20);
		contentPane.add(txtIteraciones);
		
		inputSerie = new JTextArea();
		inputSerie.setEditable(false);
		inputSerie.setBounds(100, 139, 192, 59);
		contentPane.add(inputSerie);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNumero1.setText("");
				txtNumero2.setText("");
				txtIteraciones.setText("");
				inputSerie.setText("");
			}
		});
		btnBorrar.setBounds(143, 209, 89, 23);
		contentPane.add(btnBorrar);
	}
}
