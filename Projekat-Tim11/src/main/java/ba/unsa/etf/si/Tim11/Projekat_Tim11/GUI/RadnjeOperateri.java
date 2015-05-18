package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class RadnjeOperateri {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadnjeOperateri window = new RadnjeOperateri();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RadnjeOperateri() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Uposlenici");
		ImageIcon img = new ImageIcon("icons/calculator_icon.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblFirma = new JLabel("Firma");
		lblFirma.setBounds(25, 26, 46, 14);
		frame.getContentPane().add(lblFirma);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(168, 26, 46, 14);
		frame.getContentPane().add(lblId);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(20, 51, 79, 20);
		frame.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(128, 51, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(303, 77, 105, 23);
		frame.getContentPane().add(btnDodaj);
		
		JButton btnObrii = new JButton("Obriši");
		btnObrii.setBounds(303, 121, 105, 23);
		frame.getContentPane().add(btnObrii);
		
		JButton btnDodajPermisiju = new JButton("Dodaj permisiju");
		btnDodajPermisiju.setBounds(303, 166, 105, 23);
		frame.getContentPane().add(btnDodajPermisiju);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(303, 215, 105, 23);
		frame.getContentPane().add(btnIzlaz);
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(224, 39, 46, 38);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/search.png"));
		
		table_1 = new JTable();
		table_1.setBounds(201, 106, -157, 120);
		frame.getContentPane().add(table_1);
		
	
	}
}
