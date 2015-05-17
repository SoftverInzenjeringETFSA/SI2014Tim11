package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class PodaciAdministrator {

	private JFrame frame;
	private JTextField txtIme;
	private JTextField txtprezime;
	private JTextField txtJmbg;
	private JTextField txtAdresa;
	private JTextField txtKontakt;
	private JTextField txtPozicija;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PodaciAdministrator window = new PodaciAdministrator();
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
	public PodaciAdministrator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 398);
		frame.setTitle("Podaci o administratoru");
		ImageIcon img = new ImageIcon("icons/login_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(10, 33, 78, 14);
		frame.getContentPane().add(lblIme);
		
		
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(0, 58, 88, 14);
		frame.getContentPane().add(lblPrezime);
		
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJmbg.setBounds(10, 83, 78, 14);
		frame.getContentPane().add(lblJmbg);
		
		
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(10, 108, 78, 14);
		frame.getContentPane().add(lblAdresa);
		
		
		
		JLabel lblPozicija = new JLabel("Pozicija u firmi:");
		lblPozicija.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPozicija.setBounds(-22, 158, 114, 14);
		frame.getContentPane().add(lblPozicija);
		
		
		JLabel lblZaposlen = new JLabel("Zaposlen:");
		lblZaposlen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZaposlen.setBounds(10, 183, 78, 14);
		frame.getContentPane().add(lblZaposlen);
		
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(329, 32, 148, 183);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/uposlenik_icon.png"));
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBounds(329, 266, 118, 23);
		frame.getContentPane().add(btnPotvrdi);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnIzlaz.setBounds(329, 300, 118, 23);
		frame.getContentPane().add(btnIzlaz);
		
		JLabel lblKontaktTelefon = new JLabel("Kontakt telefon:");
		lblKontaktTelefon.setBounds(10, 133, 78, 14);
		frame.getContentPane().add(lblKontaktTelefon);
		
		txtIme = new JTextField();
		txtIme.setBounds(98, 30, 86, 20);
		frame.getContentPane().add(txtIme);
		txtIme.setColumns(10);
		
		txtprezime = new JTextField();
		txtprezime.setBounds(98, 55, 86, 20);
		frame.getContentPane().add(txtprezime);
		txtprezime.setColumns(10);
		
		txtJmbg = new JTextField();
		txtJmbg.setBounds(98, 80, 86, 20);
		frame.getContentPane().add(txtJmbg);
		txtJmbg.setColumns(10);
		
		txtAdresa = new JTextField();
		txtAdresa.setBounds(98, 105, 86, 20);
		frame.getContentPane().add(txtAdresa);
		txtAdresa.setColumns(10);
		
		txtKontakt = new JTextField();
		txtKontakt.setBounds(98, 127, 86, 20);
		frame.getContentPane().add(txtKontakt);
		txtKontakt.setColumns(10);
		
		txtPozicija = new JTextField();
		txtPozicija.setText("Administrator");
		txtPozicija.setBounds(98, 155, 86, 20);
		frame.getContentPane().add(txtPozicija);
		txtPozicija.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(93, 183, 91, 20);
		frame.getContentPane().add(dateChooser);
	}
}