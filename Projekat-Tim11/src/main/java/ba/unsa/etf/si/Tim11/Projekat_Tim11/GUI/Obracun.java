package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Obracun {

	private JFrame frame;
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
		
		JLabel lblUposlenici = new JLabel("Uposlenici");
		lblUposlenici.setBounds(10, 11, 200, 50);
		frame.getContentPane().add(lblUposlenici);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ime", "Prezime", "Odjel"
			}
		));
		table.setBounds(10, 192, 414, -143);
		frame.getContentPane().add(table);
		
		JButton btnIzmjeneObracuna = new JButton("Izmjene obračuna");
		btnIzmjeneObracuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JFrame frejm = new JFrame();
				frejm.setBounds(100, 100, 450, 300);
				frejm.setVisible(true);
			}
		});
		btnIzmjeneObracuna.setBounds(119, 213, 148, 23);
		frame.getContentPane().add(btnIzmjeneObracuna);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnIzlaz.setBounds(276, 213, 148, 23);
		frame.getContentPane().add(btnIzlaz);
	}
}
