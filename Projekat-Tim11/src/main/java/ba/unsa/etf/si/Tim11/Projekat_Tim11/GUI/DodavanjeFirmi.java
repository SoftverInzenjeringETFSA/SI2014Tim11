package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DodavanjeFirmi {

	private JFrame frame;
	private JTextField textNaziv;
	private JTextField textID;
	private JTextField textAdministrator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeFirmi window = new DodavanjeFirmi();
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
	public DodavanjeFirmi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Dodavanje firme");
		ImageIcon img = new ImageIcon("icons/firma.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setLayout(null);
		
		JLabel lblNaziv = new JLabel("Naziv");
		lblNaziv.setBounds(287, 31, 46, 14);
		frame.getContentPane().add(lblNaziv);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(297, 73, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblAdministrator = new JLabel("Administrator");
		lblAdministrator.setBounds(249, 98, 84, 14);
		frame.getContentPane().add(lblAdministrator);
		
		JLabel lblDatumDodavanja = new JLabel("Datum dodavanja");
		lblDatumDodavanja.setBounds(220, 133, 93, 14);
		frame.getContentPane().add(lblDatumDodavanja);
		
		JLabel lblVrstaFirme = new JLabel("Vrsta firme");
		lblVrstaFirme.setBounds(213, 165, 84, 14);
		frame.getContentPane().add(lblVrstaFirme);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(347, 229, 77, 21);
		frame.getContentPane().add(btnIzlaz);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBounds(220, 229, 77, 19);
		frame.getContentPane().add(btnPotvrdi);
		
		textNaziv = new JTextField();
		textNaziv.setBounds(320, 28, 86, 20);
		frame.getContentPane().add(textNaziv);
		textNaziv.setColumns(10);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(320, 64, 86, 20);
		frame.getContentPane().add(textID);
		
		textAdministrator = new JTextField();
		textAdministrator.setColumns(10);
		textAdministrator.setBounds(320, 95, 86, 20);
		frame.getContentPane().add(textAdministrator);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(323, 126, 88, 21);
		frame.getContentPane().add(dateChooser);

		dateChooser.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{dateChooser.getCalendarButton()}));
		
		JComboBox comboBoxVrstaFirme = new JComboBox();
		comboBoxVrstaFirme.setModel(new DefaultComboBoxModel(new String[] {"Trgovina", "Agencija za nekretnine", "Robna Kuca"}));
		comboBoxVrstaFirme.setBounds(322, 162, 84, 20);
		frame.getContentPane().add(comboBoxVrstaFirme);
		
		
		
		
		
	}
}