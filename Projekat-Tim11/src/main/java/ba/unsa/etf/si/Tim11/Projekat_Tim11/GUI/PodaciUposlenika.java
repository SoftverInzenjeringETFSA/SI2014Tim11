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

import java.util.*;
import java.util.regex.Pattern;

import com.toedter.calendar.JCalendar;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PodaciUposlenika {

	private JFrame frame;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtJmbg;
	private JTextField txtAdresa;
	private JTextField txtPozicija;
	private static Operater _o;
	private static Zaposlenik _z;
	private static Firma _f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PodaciUposlenika window;
					if(_f != null & _o != null) {
						if(_z != null) {
							window = new PodaciUposlenika(_f, _o, _z);
						}
						else {
							window = new PodaciUposlenika(_f, _o);
						}
					}
					else {
						window = new PodaciUposlenika();
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
	public PodaciUposlenika() {
		initialize();
	}
	
	public PodaciUposlenika(Firma f, Operater o) {
		initialize();
		_f = f;
		_o = o;
		_z = null;
	}
	
	public PodaciUposlenika(Firma f, Operater o, Zaposlenik z) {
		initialize();
		_f = f;
		_o = o;
		_z = z;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 398);
		frame.setTitle("Podaci o uposleniku");
		ImageIcon img = new ImageIcon("icons/login_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(10, 11, 78, 14);
		frame.getContentPane().add(lblIme);
		
		txtIme = new JTextField();
		txtIme.setBounds(98, 8, 200, 20);
		frame.getContentPane().add(txtIme);
		txtIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(0, 36, 88, 14);
		frame.getContentPane().add(lblPrezime);
		
		txtPrezime = new JTextField();
		txtPrezime.setBounds(98, 33, 200, 20);
		frame.getContentPane().add(txtPrezime);
		txtPrezime.setColumns(10);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJmbg.setBounds(10, 61, 78, 14);
		frame.getContentPane().add(lblJmbg);
		
		txtJmbg = new JTextField();
		txtJmbg.setBounds(98, 58, 200, 20);
		frame.getContentPane().add(txtJmbg);
		txtJmbg.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(10, 86, 78, 14);
		frame.getContentPane().add(lblAdresa);
		
		txtAdresa = new JTextField();
		txtAdresa.setBounds(98, 83, 200, 20);
		frame.getContentPane().add(txtAdresa);
		txtAdresa.setColumns(10);
		
		JLabel lblPozicija = new JLabel("Pozicija u firmi:");
		lblPozicija.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPozicija.setBounds(-26, 111, 114, 14);
		frame.getContentPane().add(lblPozicija);
		
		txtPozicija = new JTextField();
		txtPozicija.setBounds(98, 108, 200, 20);
		frame.getContentPane().add(txtPozicija);
		txtPozicija.setColumns(10);
		
		JLabel lblZaposlen = new JLabel("Zaposlen:");
		lblZaposlen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZaposlen.setBounds(10, 237, 78, 14);
		frame.getContentPane().add(lblZaposlen);
		
		final JCalendar calZaposlen = new JCalendar();
		calZaposlen.setBounds(98, 237, 200, 112);
		frame.getContentPane().add(calZaposlen);
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(329, 32, 148, 183);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/uposlenik_icon.png"));
		
		JLabel lblOsnovica = new JLabel("Osnovica:");
		lblOsnovica.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOsnovica.setBounds(10, 136, 78, 14);
		frame.getContentPane().add(lblOsnovica);
		
		JLabel lblFaktor = new JLabel("Faktor:");
		lblFaktor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFaktor.setBounds(10, 161, 78, 14);
		frame.getContentPane().add(lblFaktor);
		
		JLabel lblKoeficijent = new JLabel("Koeficijent:");
		lblKoeficijent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKoeficijent.setBounds(10, 186, 78, 14);
		frame.getContentPane().add(lblKoeficijent);
		
		final JSpinner spinKoeficijent = new JSpinner();
		spinKoeficijent.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spinKoeficijent.setBounds(98, 183, 200, 20);
		frame.getContentPane().add(spinKoeficijent);
		
		JLabel lblTopliObrok = new JLabel("Topli obrok:");
		lblTopliObrok.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTopliObrok.setBounds(10, 211, 78, 14);
		frame.getContentPane().add(lblTopliObrok);
		
		final JSpinner spinOsnovica = new JSpinner();
		spinOsnovica.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spinOsnovica.setBounds(98, 133, 200, 20);
		frame.getContentPane().add(spinOsnovica);
		
		final JSpinner spinFaktor = new JSpinner();
		spinFaktor.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spinFaktor.setBounds(98, 158, 200, 20);
		frame.getContentPane().add(spinFaktor);
		
		final JSpinner spinTopliObrok = new JSpinner();
		spinTopliObrok.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spinTopliObrok.setBounds(98, 208, 200, 20);
		frame.getContentPane().add(spinTopliObrok);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtIme.getText().length() == 0 || txtPrezime.getText().length() == 0 || txtJmbg.getText().length() == 0
						|| txtAdresa.getText().length() == 0 || txtPozicija.getText().length() == 0) {
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
				if(_z == null) {
					try {
						_z = new Zaposlenik();
						_z.setIme(txtIme.getText());
						_z.setPrezime(txtPrezime.getText());
						_z.setJmbg(txtJmbg.getText());
						_z.setAdresa(txtAdresa.getText());
						_z.setPozicija(txtPozicija.getText());
						_z.setDatumZaposlenja(calZaposlen.getDate());
						_z.setDnevniTopliObrok((Double) spinTopliObrok.getValue());
						_z.setFaktor((Double) spinFaktor.getValue());
						_z.setKoeficijent((Double) spinKoeficijent.getValue());
						_z.setOsnovica((Double) spinOsnovica.getValue());
						_z.setFirma(_f);
						Sistem.Zaposlenici.dodaj(_z);
						_f.dodajZaposlenika(_z);
						Sistem.Firme.izmijeni(_f);
						
						JOptionPane.showMessageDialog(frame, "Uspješno ste dodali novog zaposlenika");
						frame.dispose();
						UposleniciPrikaz up = new UposleniciPrikaz(_o);
						up.main(null);
					}
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					try {
						int indeks = _f.getZaposlenici().indexOf(_z);
						_f.getZaposlenici().remove(_z);
						_z.setIme(txtIme.getText());
						_z.setPrezime(txtPrezime.getText());
						_z.setJmbg(txtJmbg.getText());
						_z.setAdresa(txtAdresa.getText());
						_z.setPozicija(txtPozicija.getText());
						_z.setDatumZaposlenja(calZaposlen.getDate());
						_z.setDnevniTopliObrok((Double) spinTopliObrok.getValue());
						_z.setFaktor((Double) spinFaktor.getValue());
						_z.setKoeficijent((Double) spinKoeficijent.getValue());
						_z.setOsnovica((Double) spinOsnovica.getValue());
						_z.setFirma(_f);
						Sistem.Zaposlenici.izmijeni(_z);
						_f.getZaposlenici().add(indeks, _z);
						Sistem.Firme.izmijeni(_f);
						JOptionPane.showMessageDialog(frame, "Uspješno ste ažurirali zaposlenika ID: " + _z.getId());
						frame.dispose();
						UposleniciPrikaz up = new UposleniciPrikaz(_o);
						up.main(null);
					}
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnPotvrdi.setBounds(329, 266, 118, 23);
		frame.getContentPane().add(btnPotvrdi);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UposleniciPrikaz up = new UposleniciPrikaz(_o);
				up.main(null);
			}
		});
		btnIzlaz.setBounds(329, 300, 118, 23);
		frame.getContentPane().add(btnIzlaz);
		
		if(_z != null) {
			txtIme.setText(_z.getIme());
			txtPrezime.setText(_z.getPrezime());
			txtJmbg.setText(_z.getJmbg());
			txtAdresa.setText(_z.getAdresa());
			txtPozicija.setText(_z.getPozicija());
			calZaposlen.setDate(_z.getDatumZaposlenja());
			spinKoeficijent.setValue(_z.getKoeficijent());
			spinFaktor.setValue(_z.getFaktor());
			spinTopliObrok.setValue(_z.getDnevniTopliObrok());
			spinOsnovica.setValue(_z.getOsnovica());
		}
	}
}
