package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.*;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.*;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Obracun {

	private JFrame frame;
	private List<Zaposlenik> _zaposlenici;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Obracun window = new Obracun();
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
	public Obracun() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Obračuni");
		ImageIcon img = new ImageIcon("icons/calculator_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		_zaposlenici = Sistem.Zaposlenici.lista();
		
		JLabel lblUposlenici = new JLabel("Uposlenici");
		lblUposlenici.setBounds(10, 11, 200, 50);
		frame.getContentPane().add(lblUposlenici);
		
		JButton btnIzmjeneObracuna = new JButton("Izmjene obračuna");
		btnIzmjeneObracuna.setBounds(119, 213, 148, 23);
		btnIzmjeneObracuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				IzmjenaObracuna io = new IzmjenaObracuna();
				io.main(null);
			}
		});
		frame.getContentPane().add(btnIzmjeneObracuna);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(276, 213, 148, 23);
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnIzlaz);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 414, 152);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		String[] kolone = {"ID",
		        "Ime",
		        "Prezime",
		        "Odjel"};

		DefaultTableModel model = new DefaultTableModel();
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
