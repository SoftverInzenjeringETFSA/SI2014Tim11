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

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.*;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.*;

import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

public class UposleniciPrikaz {

	private JFrame frame;
	private JTextField txtID;
	private static Operater _o;
	private List<Zaposlenik> _zaposlenici; 
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UposleniciPrikaz window;
					if(_o != null) {
						window = new UposleniciPrikaz(_o);
					}
					else {
						window = new UposleniciPrikaz();
					}
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
	
	public UposleniciPrikaz(Operater o) {
		initialize();
		_o = o;
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
		_zaposlenici = Sistem.Zaposlenici.lista();
		
		JLabel lblFirma = new JLabel("Firma:");
		lblFirma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirma.setBounds(-31, 39, 102, 14);
		frame.getContentPane().add(lblFirma);
		
		JComboBox<String> comboFirma = new JComboBox<String>();
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
				OperaterPocetna op = new OperaterPocetna(_o);
				op.main(null);
			}
		});
		btnIzlaz.setBounds(355, 258, 124, 23);
		frame.getContentPane().add(btnIzlaz);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 273, 337, -180);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		String[] kolone = {"ID",
		        "Ime",
		        "Prezime",
		        "Odjel"};

		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		
		JButton btnPretraga = new JButton("");
		btnPretraga.setBounds(428, 28, 35, 34);
		btnPretraga.setIcon(new ImageIcon("icons/search_icon.png"));
		frame.getContentPane().add(btnPretraga);
		
		
		model.setColumnIdentifiers(kolone);
		for (Zaposlenik z : _zaposlenici) {
			  Object[] o = new Object[4];
			  o[0] = z.getId();
			  o[1] = z.getIme();
			  o[2] = z.getPrezime();
			  o[3] = z.getPozicija();
			  model.addRow(o);
		}
	}
}
