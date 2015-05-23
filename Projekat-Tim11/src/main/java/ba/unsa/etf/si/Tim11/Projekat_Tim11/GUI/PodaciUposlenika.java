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
	private JTextField txtOsnovica;
	private JTextField txtFaktor;
	private JTextField txtTopliObrok;

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
		
		txtOsnovica = new JTextField();
		txtOsnovica.setBounds(98, 133, 200, 20);
		frame.getContentPane().add(txtOsnovica);
		txtOsnovica.setColumns(10);
		
		JLabel lblFaktor = new JLabel("Faktor:");
		lblFaktor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFaktor.setBounds(10, 161, 78, 14);
		frame.getContentPane().add(lblFaktor);
		
		txtFaktor = new JTextField();
		txtFaktor.setBounds(98, 158, 200, 20);
		txtFaktor.setText("1");
		frame.getContentPane().add(txtFaktor);
		txtFaktor.setColumns(10);
		
		JLabel lblKoeficijent = new JLabel("Koeficijent:");
		lblKoeficijent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKoeficijent.setBounds(10, 186, 78, 14);
		frame.getContentPane().add(lblKoeficijent);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Double(0.0), new Double(0.0), null, new Double(0.1)));
		spinner.setBounds(98, 183, 200, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblTopliObrok = new JLabel("Topli obrok:");
		lblTopliObrok.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTopliObrok.setBounds(10, 211, 78, 14);
		frame.getContentPane().add(lblTopliObrok);
		
		txtTopliObrok = new JTextField();
		txtTopliObrok.setBounds(98, 208, 200, 20);
		frame.getContentPane().add(txtTopliObrok);
		txtTopliObrok.setColumns(10);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(_z == null) {
					try {
						_z = new Zaposlenik();
						_z.setIme(txtIme.getText());
						_z.setPrezime(txtPrezime.getText());
						_z.setJmbg(txtJmbg.getText());
						_z.setAdresa(txtAdresa.getText());
						_z.setPozicija(txtPozicija.getText());
						_z.setDatumZaposlenja(calZaposlen.getDate());
						_z.setDnevniTopliObrok(Double.parseDouble(txtTopliObrok.getText()));
						_z.setFaktor(Double.parseDouble(txtFaktor.getText()));
						_z.setKoeficijent((Double) spinner.getValue());
						_z.setOsnovica(Double.parseDouble(txtOsnovica.getText()));
						_z.setFirma(_f);
						Sistem.Zaposlenici.dodaj(_z);
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
						_z.setIme(txtIme.getText());
						_z.setPrezime(txtPrezime.getText());
						_z.setJmbg(txtJmbg.getText());
						_z.setAdresa(txtAdresa.getText());
						_z.setPozicija(txtPozicija.getText());
						_z.setDatumZaposlenja(calZaposlen.getDate());
						_z.setDnevniTopliObrok(Double.parseDouble(txtTopliObrok.getText()));
						_z.setFaktor(Double.parseDouble(txtFaktor.getText()));
						_z.setKoeficijent((Double) spinner.getValue());
						_z.setOsnovica(Double.parseDouble(txtOsnovica.getText()));
						_z.setFirma(_f);
						Sistem.Zaposlenici.izmijeni(_z);
						JOptionPane.showMessageDialog(frame, "Uspješno ste izmijenili zaposlenika");
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
			txtTopliObrok.setText(String.valueOf(_z.getDnevniTopliObrok()));
			txtFaktor.setText(String.valueOf(_z.getFaktor()));
			txtOsnovica.setText(String.valueOf(_z.getOsnovica()));
			spinner.setValue(_z.getKoeficijent());
		}
	}
}
