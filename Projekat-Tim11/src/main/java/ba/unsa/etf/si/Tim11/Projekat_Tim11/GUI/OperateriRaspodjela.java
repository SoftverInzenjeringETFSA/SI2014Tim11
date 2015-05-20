package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

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
		frame.setBounds(100, 100, 450, 325);
		frame.setTitle("Operateri");
		ImageIcon img = new ImageIcon("icons/calculator_icon.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblFirma = new JLabel("Firma");
		lblFirma.setBounds(20, 11, 46, 14);
		frame.getContentPane().add(lblFirma);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(168, 11, 46, 14);
		frame.getContentPane().add(lblId);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(20, 36, 79, 20);
		frame.getContentPane().add(comboBox);
		
		txtID = new JTextField();
		txtID.setBounds(153, 36, 86, 20);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JLabel lblSlika = new JLabel("Pretraži");
		lblSlika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSlika.setBounds(249, 33, 73, 23);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/search16.png"));
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 302, 183);
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
		
		
		
		
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(220, 227, 89, 23);
		frame.getContentPane().add(btnIzlaz);
		
		JButton btnUredi = new JButton("Uredi");
		btnUredi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUredi.setBounds(322, 91, 89, 23);
		frame.getContentPane().add(btnUredi);
		
		JButton btnIzlaz_1 = new JButton("Izlaz");
		btnIzlaz_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnIzlaz_1.setBounds(335, 252, 89, 23);
		frame.getContentPane().add(btnIzlaz_1);
		
		
	}
}
