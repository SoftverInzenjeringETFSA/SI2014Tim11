package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class RadnjeOperateri {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	
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
		frame.setBounds(100, 100, 478, 300);
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
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDodaj.setBounds(303, 73, 132, 23);
		frame.getContentPane().add(btnDodaj);
		
		JButton btnObrii = new JButton("Obriši");
		btnObrii.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnObrii.setBounds(303, 119, 132, 23);
		frame.getContentPane().add(btnObrii);
		
		JButton btnDodajPermisiju = new JButton("Dodaj permisiju");
		btnDodajPermisiju.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDodajPermisiju.setBounds(303, 166, 132, 23);
		frame.getContentPane().add(btnDodajPermisiju);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnIzlaz.setBounds(380, 227, 72, 23);
		frame.getContentPane().add(btnIzlaz);
		
		JLabel lblSlika = new JLabel("Pretrazi");
		lblSlika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSlika.setBounds(224, 47, 72, 29);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/search16.png"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 286, 168);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ime i prezime", "Adresa"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(29);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(1).setMinWidth(2);
		scrollPane.setViewportView(table);
		

		
		
		
		
		
		
	
	}
}
