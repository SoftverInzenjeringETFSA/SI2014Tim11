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

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Firma;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Operater;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Zaposlenik;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class DodavanjeOperatera {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtPrezime;
	private JTextField txtJmbg;
	private JTextField txtAdresa;
	private JTextField txtPozicija;
	private JTextField txtIme;
	private static Firma _f;
	private static Operater _o;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeOperatera window;
					if(_o != null) {
						
							window = new DodavanjeOperatera(_f, _o );
						
					}
					else {
						window = new DodavanjeOperatera();
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
	public DodavanjeOperatera() {
		initialize();
	}

	

	public DodavanjeOperatera(Firma f, Operater o) {
		initialize();
		_f = f;
		_o = o;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 398);
		frame.setTitle("Dodavanje operatera");
		ImageIcon img = new ImageIcon("icons/login_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(10, 32, 78, 14);
		frame.getContentPane().add(lblIme);
		txtIme = new JTextField();
		txtIme.setBounds(106, 29, 88, 20);
		frame.getContentPane().add(txtIme);
		txtIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(0, 67, 88, 14);
		frame.getContentPane().add(lblPrezime);
		
	
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJmbg.setBounds(10, 108, 78, 14);
		frame.getContentPane().add(lblJmbg);
		
		
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(10, 151, 78, 14);
		frame.getContentPane().add(lblAdresa);
		
		
		
		JLabel lblPozicija = new JLabel("Pozicija u firmi:");
		lblPozicija.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPozicija.setBounds(-26, 196, 114, 14);
		frame.getContentPane().add(lblPozicija);
		
	
		
		JLabel lblZaposlen = new JLabel("Zaposlen:");
		lblZaposlen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZaposlen.setBounds(10, 237, 78, 14);
		frame.getContentPane().add(lblZaposlen);
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(329, 32, 148, 183);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/uposlenik_icon.png"));
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
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
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(106, 237, 91, 20);
		frame.getContentPane().add(dateChooser);
		
		textField = new JTextField();
		textField.setBounds(106, 267, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFirma = new JLabel("Firma");
		lblFirma.setBounds(49, 270, 46, 14);
		frame.getContentPane().add(lblFirma);
		
		txtPrezime = new JTextField();
		txtPrezime.setBounds(111, 64, 86, 20);
		frame.getContentPane().add(txtPrezime);
		txtPrezime.setColumns(10);
		
		txtJmbg = new JTextField();
		txtJmbg.setBounds(111, 105, 86, 20);
		frame.getContentPane().add(txtJmbg);
		txtJmbg.setColumns(10);
		
		txtAdresa = new JTextField();
		txtAdresa.setBounds(106, 148, 86, 20);
		frame.getContentPane().add(txtAdresa);
		txtAdresa.setColumns(10);
		
		txtPozicija = new JTextField();
		txtPozicija.setText("Operater");
		txtPozicija.setBounds(106, 193, 86, 20);
		frame.getContentPane().add(txtPozicija);
		txtPozicija.setColumns(10);
	}
}
