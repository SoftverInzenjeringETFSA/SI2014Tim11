package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

public class OperateriRaspodjela {

	private JFrame frame;
	private JTextField txtID;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperateriRaspodjela window = new OperateriRaspodjela();
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
	public OperateriRaspodjela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Operateri");
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
		
		txtID = new JTextField();
		txtID.setBounds(153, 51, 86, 20);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(224, 39, 46, 38);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/search16.png"));
		
		
		
		
		table = new JTable();
		table.setBounds(128, 184, 101, -84);
		frame.getContentPane().add(table);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(220, 227, 89, 23);
		frame.getContentPane().add(btnIzlaz);
		
		JButton btnUredi = new JButton("Uredi");
		btnUredi.setBounds(321, 227, 89, 23);
		frame.getContentPane().add(btnUredi);
		
		
	}

}
