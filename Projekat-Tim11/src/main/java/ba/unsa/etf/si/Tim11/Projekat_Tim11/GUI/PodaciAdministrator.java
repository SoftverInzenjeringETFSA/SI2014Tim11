package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Admin;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Firma;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class PodaciAdministrator {

	private JFrame frame;
	private static Admin _a;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtJmbg;
	private JTextField txtAdresa;
	private JTextField txtTelefon;

	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
			try {
				PodaciAdministrator window;
				if(_a != null) {
					window = new PodaciAdministrator(_a);
				}
				else {
					window = new PodaciAdministrator();
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
	public PodaciAdministrator() {
		initialize();
	}

	public PodaciAdministrator(Admin _a2) {
		initialize();
		_a=_a2;// TODO Auto-generated constructor stub
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 255);
		frame.setTitle("Podaci o administratoru");
		ImageIcon img = new ImageIcon("icons/login_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(23, 34, 78, 14);
		frame.getContentPane().add(lblIme);
		
		
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(13, 59, 88, 14);
		frame.getContentPane().add(lblPrezime);
		
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblJmbg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJmbg.setBounds(23, 84, 78, 14);
		frame.getContentPane().add(lblJmbg);
		
		
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(23, 109, 78, 14);
		frame.getContentPane().add(lblAdresa);
		
		
		
		JLabel lblPozicija = new JLabel("Pozicija u firmi:");
		lblPozicija.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPozicija.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPozicija.setBounds(-13, 159, 114, 14);
		frame.getContentPane().add(lblPozicija);
		
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(226, 11, 148, 162);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/uposlenik_icon.png"));
		
		JButton btnIzlaz = new JButton("Izlaz");
		 btnIzlaz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					AdministratorPocetna ap = new AdministratorPocetna(_a);
					ap.main(null);
				}
			});
	
		btnIzlaz.setBounds(269, 184, 105, 23);
		frame.getContentPane().add(btnIzlaz);
		
		JLabel lblKontaktTelefon = new JLabel("Kontakt telefon:");
		lblKontaktTelefon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKontaktTelefon.setBounds(23, 134, 78, 14);
		frame.getContentPane().add(lblKontaktTelefon);
		
		JLabel lblAdministrator = new JLabel("Administrator");
		lblAdministrator.setBounds(111, 159, 105, 14);
		frame.getContentPane().add(lblAdministrator);
		
		txtIme = new JTextField();
		txtIme.setBounds(111, 31, 105, 20);
		frame.getContentPane().add(txtIme);
		txtIme.setColumns(10);
		
		txtPrezime = new JTextField();
		txtPrezime.setBounds(111, 56, 105, 20);
		frame.getContentPane().add(txtPrezime);
		txtPrezime.setColumns(10);
		
		txtJmbg = new JTextField();
		txtJmbg.setBounds(111, 81, 105, 20);
		frame.getContentPane().add(txtJmbg);
		txtJmbg.setColumns(10);
		
		txtAdresa = new JTextField();
		txtAdresa.setBounds(111, 106, 105, 20);
		frame.getContentPane().add(txtAdresa);
		txtAdresa.setColumns(10);
		
		txtTelefon = new JTextField();
		txtTelefon.setBounds(111, 131, 105, 20);
		frame.getContentPane().add(txtTelefon);
		txtTelefon.setColumns(10);
		
		JButton btnSpasi = new JButton("Spasi");
		btnSpasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtIme.getText().length() == 0 || txtPrezime.getText().length() == 0 || txtJmbg.getText().length() == 0
						|| txtAdresa.getText().length() == 0 || txtTelefon.getText().length() == 0) {
					JOptionPane.showMessageDialog(frame, "Morate popuniti sva polja");
					return;
				}
				Pattern patternIme = Pattern.compile("[a-zA-ZĐđŠšČčĆćŽž]{3,}"); //mogu se unijeti velika,mala slova,brojevi
				Pattern patternJmbg = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])[0-9]{9}$");
				Pattern patternAdresa = Pattern.compile("[a-zA-Z0-9\\,\\sĐđŠšČčĆćŽž]{5,}");
				Pattern patternTelefon = Pattern.compile("(\\+|00)?387\\d{2}\\-?\\d{3,4}\\-?\\d{3,4}");
				if (!patternIme.matcher(txtIme.getText()).matches()) {
					JOptionPane.showMessageDialog(frame, "Neispravan unos imena");
			        return;
			    }
				else if(!patternIme.matcher(txtPrezime.getText()).matches()) {
					JOptionPane.showMessageDialog(frame, "Neispravan unos prezimena");
			        return;
				}
				else if(!patternJmbg.matcher(txtJmbg.getText()).matches()) {
					JOptionPane.showMessageDialog(frame, "Neispravan unos jmbga");
			        return;
				}
				else if(!patternAdresa.matcher(txtAdresa.getText()).matches()) {
					JOptionPane.showMessageDialog(frame, "Neispravan unos adrese");
			        return;
				}
				else if(!patternTelefon.matcher(txtTelefon.getText()).matches()) {
					JOptionPane.showMessageDialog(frame, "Neispravan unos telefona");
			        return;
				}
				if(_a != null) {
					try {
						_a.setIme(txtIme.getText());
						_a.setPrezime(txtPrezime.getText());
						_a.setJmbg(txtJmbg.getText());
						_a.setAdresa(txtAdresa.getText());
						_a.setTelefon(txtTelefon.getText());
						Sistem.Admini.izmijeni(_a);
						JOptionPane.showMessageDialog(frame, "Uspješno ste ažurirali admina");
						frame.dispose();
						AdministratorPocetna ap = new AdministratorPocetna(_a);
						ap.main(null);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnSpasi.setBounds(111, 184, 105, 23);
		frame.getContentPane().add(btnSpasi);
		
		if(_a != null) {
			txtIme.setText(_a.getIme());
			txtPrezime.setText(_a.getPrezime());
			txtJmbg.setText(_a.getJmbg());
			txtAdresa.setText(_a.getAdresa());
			txtTelefon.setText(_a.getTelefon());
		}
	}
}