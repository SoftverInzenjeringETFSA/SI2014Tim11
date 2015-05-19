package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UposleniciPrikaz {

	private JFrame frame;
	private JTextField txtID;
	private JTable tableUposlenici;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UposleniciPrikaz window = new UposleniciPrikaz();
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
	public UposleniciPrikaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 330);
		frame.setTitle("Uposlenici");
		ImageIcon img = new ImageIcon("icons/staff_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirma = new JLabel("Firma:");
		lblFirma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirma.setBounds(-31, 39, 102, 14);
		frame.getContentPane().add(lblFirma);
		
		JComboBox comboFirma = new JComboBox();
		comboFirma.setBounds(81, 36, 124, 20);
		frame.getContentPane().add(comboFirma);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(215, 39, 70, 14);
		frame.getContentPane().add(lblId);
		
		txtID = new JTextField();
		txtID.setBounds(295, 36, 124, 20);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		tableUposlenici = new JTable();
		tableUposlenici.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ime", "Prezime", "Odjel"
			}
		));
		tableUposlenici.setBounds(341, 97, -298, 142);
		frame.getContentPane().add(tableUposlenici);
		
		JButton btnDodavanje = new JButton("Dodavanje");
		btnDodavanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PodaciUposlenika pu = new PodaciUposlenika();
				pu.main(null);
			}
		});
		btnDodavanje.setBounds(355, 126, 124, 23);
		frame.getContentPane().add(btnDodavanje);
		
		JButton btnAzuriranje = new JButton("Ažuriranje");
		btnAzuriranje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PodaciUposlenika pu = new PodaciUposlenika();
				pu.main(null);
			}
		});
		btnAzuriranje.setBounds(355, 160, 124, 23);
		frame.getContentPane().add(btnAzuriranje);
		
		JButton btnBrisanje = new JButton("Brisanje");
		btnBrisanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Da li ste sigurni?", "Upozorenje", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION) {
					
				}
				if(dialogResult == JOptionPane.NO_OPTION) {
					
				}
			}
		});
		btnBrisanje.setBounds(355, 194, 124, 23);
		frame.getContentPane().add(btnBrisanje);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnIzlaz.setBounds(355, 258, 124, 23);
		frame.getContentPane().add(btnIzlaz);
	}

}
