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

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Operater;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class DodavanjeOperatera {

	private JFrame frame;
	private JTextField txtFirma;
	private JTextField txtPrezime;
	private JTextField txtJmbg;
	private JTextField txtAdresa;
	private JTextField txtPozicija;
	private JTextField txtIme;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeOperatera window = new DodavanjeOperatera();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public DodavanjeOperatera() throws Exception {
		initialize();
	}


	Operater _op=new Operater();




	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
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
		_op.setIme(txtIme.getText());
		
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
		
				frame.dispose();
			}
		});


		btnPotvrdi.setBounds(329, 266, 118, 23);
		frame.getContentPane().add(btnPotvrdi);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistem.Operateri.dodaj(_op);
				frame.dispose();
			}
		});
		btnIzlaz.setBounds(329, 300, 118, 23);
		frame.getContentPane().add(btnIzlaz);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(106, 237, 91, 20);
		frame.getContentPane().add(dateChooser);
		
		txtFirma = new JTextField();
		txtFirma.setBounds(106, 267, 86, 20);
		frame.getContentPane().add(txtFirma);
		txtFirma.setColumns(10);
		
		
		JLabel lblFirma = new JLabel("Firma");
		lblFirma.setBounds(49, 270, 46, 14);
		frame.getContentPane().add(lblFirma);
		
		txtPrezime = new JTextField();
		txtPrezime.setBounds(111, 64, 86, 20);
		frame.getContentPane().add(txtPrezime);
		txtPrezime.setColumns(10);
		_op.setPrezime(txtPrezime.getText());
		
		txtJmbg = new JTextField();
		txtJmbg.setBounds(111, 105, 86, 20);
		frame.getContentPane().add(txtJmbg);
		txtJmbg.setColumns(10);
		_op.setJmbg(txtJmbg.getText());
		
		txtAdresa = new JTextField();
		txtAdresa.setBounds(106, 148, 86, 20);
		frame.getContentPane().add(txtAdresa);
		txtAdresa.setColumns(10);
		_op.setAdresa(txtAdresa.getText());
		
		txtPozicija = new JTextField();
		txtPozicija.setBounds(106, 193, 86, 20);
		frame.getContentPane().add(txtPozicija);
		txtPozicija.setColumns(10);
		_op.setPozicija("operater");
	}
}
