package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Firma;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem;

import com.toedter.calendar.JDateChooser;

public class EditovanjeFirma {

	private JFrame frame;

	private JTextField textNaziv;
	public Firma f;
	private JTextField textSjediste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditovanjeFirma window = new EditovanjeFirma();
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
	public EditovanjeFirma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Firma f= new Firma();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 269);
		frame.setTitle("Azuriranje firme");
		ImageIcon img = new ImageIcon("icons/firma.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setLayout(null);
	
		
		JLabel lblNaziv = new JLabel("Naziv");
		lblNaziv.setBounds(287, 31, 46, 14);
		
		frame.getContentPane().add(lblNaziv);
	
		JLabel lblDatumDodavanja = new JLabel("Datum dodavanja");
		lblDatumDodavanja.setBounds(230, 70, 93, 14);
		frame.getContentPane().add(lblDatumDodavanja);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(347, 198, 77, 21);
		frame.getContentPane().add(btnIzlaz);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBounds(204, 199, 77, 19);
		frame.getContentPane().add(btnPotvrdi);
		Sistem.Firme.dodaj(f);
		
		
		textNaziv = new JTextField();
		textNaziv.setBounds(320, 28, 86, 20);
		frame.getContentPane().add(textNaziv);
		textNaziv.setColumns(10);
		//f.ime=textNaziv.getText();
		//f.setIme(textNaziv.);
		f.ime=textNaziv.getText();

		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(320, 70, 88, 21);
		frame.getContentPane().add(dateChooser);

		dateChooser.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{dateChooser.getCalendarButton()}));
		
		JLabel lblSjediste = new JLabel("Sjediste");
		lblSjediste.setBounds(264, 118, 46, 14);
		frame.getContentPane().add(lblSjediste);
		
		textSjediste = new JTextField();
		textSjediste.setBounds(320, 115, 86, 20);
		frame.getContentPane().add(textSjediste);
		textSjediste.setColumns(10);
		
		
		
		
		
	}
}

