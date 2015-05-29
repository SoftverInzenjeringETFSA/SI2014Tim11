package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.*;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.*;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem.Firme;

import java.util.*;
import java.util.regex.Pattern;

import com.toedter.calendar.JCalendar;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPasswordField;

public class DodavanjeEditovanjeOperatera {

	private JFrame frame;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtJmbg;
	private JTextField txtAdresa;
	private JTextField txtPozicija;
	private static Operater _o;
	private static Firma _f;
	private static Admin _a;
	private JPasswordField txtSifra;
	private JTextField txtUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeEditovanjeOperatera window;
					if(_f != null & _a != null) {
						if(_o != null) {
							window = new DodavanjeEditovanjeOperatera(_f, _a, _o);
						}
						else {
							window = new DodavanjeEditovanjeOperatera(_f, _a);
						}
					}
					else {
						window = new DodavanjeEditovanjeOperatera();
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
	public DodavanjeEditovanjeOperatera() {
		initialize();
	}
	
	public DodavanjeEditovanjeOperatera(Firma f, Admin a) {
		initialize();
		_f = f;
		_a = a;
		_o= null;
	}
	
	

	public DodavanjeEditovanjeOperatera(Firma f, Admin a, Operater o) {
		initialize();
		_f=f;
		_o=o;
		_a=a;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 382);
		frame.setTitle("Podaci o operateru");
		ImageIcon img = new ImageIcon("icons/login_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setBounds(10, 11, 78, 14);
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblIme);
		
		txtIme = new JTextField();
		txtIme.setBounds(98, 8, 200, 20);
		frame.getContentPane().add(txtIme);
		txtIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(0, 42, 88, 14);
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblPrezime);
		
		txtPrezime = new JTextField();
		txtPrezime.setBounds(98, 39, 200, 20);
		frame.getContentPane().add(txtPrezime);
		txtPrezime.setColumns(10);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setBounds(10, 72, 78, 14);
		lblJmbg.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblJmbg);
		
		txtJmbg = new JTextField();
		txtJmbg.setBounds(98, 69, 200, 20);
		frame.getContentPane().add(txtJmbg);
		txtJmbg.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setBounds(10, 103, 78, 14);
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblAdresa);
		
		txtAdresa = new JTextField();
		txtAdresa.setBounds(98, 100, 200, 20);
		frame.getContentPane().add(txtAdresa);
		txtAdresa.setColumns(10);
		
		JLabel lblPozicija = new JLabel("Pozicija u firmi:");
		lblPozicija.setBounds(-26, 134, 114, 14);
		lblPozicija.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblPozicija);
		
		txtPozicija = new JTextField();
		txtPozicija.setBounds(98, 131, 200, 20);
		frame.getContentPane().add(txtPozicija);
		txtPozicija.setColumns(10);
		txtPozicija.setText("Operater");
		
		JLabel lblSifra = new JLabel("Sifra:");
		lblSifra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSifra.setBounds(10, 193, 78, 14);
		frame.getContentPane().add(lblSifra);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(10, 165, 78, 14);
		frame.getContentPane().add(lblUsername);
		
		txtSifra = new JPasswordField();
		txtSifra.setBounds(98, 190, 200, 20);
		frame.getContentPane().add(txtSifra);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(98, 162, 200, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblZaposlen = new JLabel("Zaposlen:");
		lblZaposlen.setBounds(10, 223, 78, 14);
		lblZaposlen.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblZaposlen);
		
		final JCalendar calZaposlen = new JCalendar();
		calZaposlen.setBounds(98, 221, 200, 112);
		frame.getContentPane().add(calZaposlen);
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(329, 32, 148, 157);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/uposlenik_icon.png"));
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBounds(359, 199, 118, 23);
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] pass = txtSifra.getPassword();
				String passString = new String(pass);
				if(txtIme.getText().length() == 0 || txtPrezime.getText().length() == 0 || txtJmbg.getText().length() == 0
						|| txtAdresa.getText().length() == 0 || txtPozicija.getText().length() == 0
						|| txtUsername.getText().length() == 0 || passString.length() == 0) {
					JOptionPane.showMessageDialog(frame, "Morate popuniti sva polja");
					return;
				}
				if(calZaposlen.getDate().after(new Date())) {
					JOptionPane.showMessageDialog(frame, "Pogresan datum");
					return;
				}
				Pattern patternIme = Pattern.compile("[a-zA-ZĐđŠšČčĆćŽž]{3,}"); //mogu se unijeti velika,mala slova,brojevi
				Pattern patternJmbg = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])[0-9]{9}$");
				Pattern patternAdresa = Pattern.compile("[a-zA-Z0-9\\,\\sĐđŠšČčĆćŽž]{5,}");
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
				else if(txtUsername.getText().length() < 5 || passString.length() < 5) {
					JOptionPane.showMessageDialog(frame, "Username i sifra moraju imati minimalno 5 karaktera");
			        return;
				}
				if(_o == null) {
					try {
						_o = new Operater();
						_o.setIme(txtIme.getText());
						_o.setPrezime(txtPrezime.getText());
						_o.setJmbg(txtJmbg.getText());
						_o.setAdresa(txtAdresa.getText());	
						_o.setPozicija(txtPozicija.getText());
						_o.setUsername(txtUsername.getText());
						_o.setPassword(passString);
						_o.setDatumZaposlenja(calZaposlen.getDate());				
						_o.setFirma(_f);	
						Sistem.Operateri.dodaj(_o);
						_f.dodajOperatera(_o);
						Sistem.Firme.izmijeni(_f);		
						
						JOptionPane.showMessageDialog(frame, "Uspješno ste dodali novog operatera");
						frame.dispose();
						OperatoriPrikazAdmin ro = new OperatoriPrikazAdmin(_a);
						ro.main(null);
					}
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					try {
						int indeks = _f.getOperateri().indexOf(_o);
						_f.getOperateri().remove(indeks);
						_o.setIme(txtIme.getText());
						_o.setPrezime(txtPrezime.getText());
						_o.setJmbg(txtJmbg.getText());
						_o.setAdresa(txtAdresa.getText());	
						_o.setPozicija(txtPozicija.getText());
						_o.setUsername(txtUsername.getText());
						_o.setPassword(passString);
						_o.setDatumZaposlenja(calZaposlen.getDate());				
					
						_o.setFirma(_f);
						Sistem.Operateri.izmijeni(_o);
						_f.getOperateri().add(indeks,_o);
						Sistem.Firme.izmijeni(_f);	
						
						frame.dispose();
						OperatoriPrikazAdmin rp = new OperatoriPrikazAdmin(_a);
						rp.main(null);
					}
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		frame.getContentPane().add(btnPotvrdi);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(359, 233, 118, 23);
	
			btnIzlaz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				OperatoriPrikazAdmin up = new OperatoriPrikazAdmin(_a);
					up.main(null);
				}
			});
		frame.getContentPane().add(btnIzlaz);
		
		if(_o != null) {
			txtIme.setText(_o.getIme());
			txtPrezime.setText(_o.getPrezime());
			txtJmbg.setText(_o.getJmbg());
			txtAdresa.setText(_o.getAdresa());
			txtPozicija.setText(_o.getPozicija());
			txtUsername.setText(_o.getUsername());
			calZaposlen.setDate(_o.getDatumZaposlenja());
		}
	}
}
