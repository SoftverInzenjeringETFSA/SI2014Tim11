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

public class DodavanjeEditovanjeOperatera {

	private JFrame frame;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtJmbg;
	private JTextField txtAdresa;
	private JTextField txtPozicija;
	private static Operater _o;
	private static Zaposlenik _z;
	private static Firma _f;
	private static Admin _a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeEditovanjeOperatera window;
					if(_f != null & _o != null) {
						if(_z != null) {
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
		_f=f;
		_o=o;
		_a=a;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 323);
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
		lblPrezime.setBounds(0, 36, 88, 14);
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblPrezime);
		
		txtPrezime = new JTextField();
		txtPrezime.setBounds(98, 33, 200, 20);
		frame.getContentPane().add(txtPrezime);
		txtPrezime.setColumns(10);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setBounds(10, 61, 78, 14);
		lblJmbg.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblJmbg);
		
		txtJmbg = new JTextField();
		txtJmbg.setBounds(98, 58, 200, 20);
		frame.getContentPane().add(txtJmbg);
		txtJmbg.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setBounds(10, 86, 78, 14);
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblAdresa);
		
		txtAdresa = new JTextField();
		txtAdresa.setBounds(98, 83, 200, 20);
		frame.getContentPane().add(txtAdresa);
		txtAdresa.setColumns(10);
		
		JLabel lblPozicija = new JLabel("Pozicija u firmi:");
		lblPozicija.setBounds(-26, 111, 114, 14);
		lblPozicija.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblPozicija);

		
		txtPozicija = new JTextField();
		txtPozicija.setBounds(98, 108, 200, 20);
		frame.getContentPane().add(txtPozicija);
		txtPozicija.setColumns(10);
		txtPozicija.setText("Operater");
		
		JLabel lblZaposlen = new JLabel("Zaposlen:");
		lblZaposlen.setBounds(10, 175, 78, 14);
		lblZaposlen.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblZaposlen);
		
		final JCalendar calZaposlen = new JCalendar();
		calZaposlen.setBounds(98, 155, 200, 112);
		frame.getContentPane().add(calZaposlen);
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(329, 32, 148, 157);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/uposlenik_icon.png"));
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBounds(359, 199, 118, 23);
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(_o == null) {
					try {
						_o = new Operater();
						_o.setIme(txtIme.getText());
						_o.setPrezime(txtPrezime.getText());
						_o.setJmbg(txtJmbg.getText());
						_o.setAdresa(txtAdresa.getText());
					
						_o.setDatumZaposlenja(calZaposlen.getDate());
				
						_o.setFirma(_f);
						Sistem.Operateri.dodaj(_o);
						_f.dodajOperatera(_o);
						
						JOptionPane.showMessageDialog(frame, "Uspješno ste dodali novog operatera");
						frame.dispose();
						RadnjeOperateri ro = new RadnjeOperateri(_a);
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
				
						_o.setDatumZaposlenja(calZaposlen.getDate());
					
					
						_o.setFirma(_f);
						Sistem.Operateri.izmijeni(_o);
						_f.getOperateri().add(indeks,_o);
		
						JOptionPane.showMessageDialog(frame, "Uspješno ste izmijenili operatera");
						frame.dispose();
						RadnjeOperateri rp = new RadnjeOperateri(_a);
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
				RadnjeOperateri up = new RadnjeOperateri(_a);
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
			calZaposlen.setDate(_o.getDatumZaposlenja());

		}
	}
}
