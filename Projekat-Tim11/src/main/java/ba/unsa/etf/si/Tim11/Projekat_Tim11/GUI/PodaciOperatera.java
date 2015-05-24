package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.*;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem;

import com.toedter.calendar.JCalendar;

import javax.swing.JComboBox;

public class PodaciOperatera {

	private JFrame frame;
	private static Operater _o;
	private List<Firma> _firme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PodaciOperatera window;
					if(_o != null) {
						window = new PodaciOperatera(_o);
					}
					else {
						window = new PodaciOperatera();
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
	public PodaciOperatera() {
		initialize();
	}
	
	public PodaciOperatera(Operater o) {
		initialize();
		_o = o;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 398);
		frame.setTitle("Podaci o operateru");
		ImageIcon img = new ImageIcon("icons/staff_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		_firme = Sistem.Firme.lista();
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(57, 40, 78, 14);
		frame.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(47, 75, 88, 14);
		frame.getContentPane().add(lblPrezime);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJmbg.setBounds(57, 111, 78, 14);
		frame.getContentPane().add(lblJmbg);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(57, 145, 78, 14);
		frame.getContentPane().add(lblAdresa);
		
		JLabel lblPozicija = new JLabel("Pozicija u firmi:");
		lblPozicija.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPozicija.setBounds(21, 254, 114, 14);
		frame.getContentPane().add(lblPozicija);
		
		JLabel lblZaposlen = new JLabel("Zaposlen:");
		lblZaposlen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZaposlen.setBounds(57, 289, 78, 14);
		frame.getContentPane().add(lblZaposlen);
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(329, 23, 148, 183);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/uposlenik_icon.png"));
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OperaterPocetna op = new OperaterPocetna(_o);
				op.main(null);
			}
		});
		btnIzlaz.setBounds(329, 326, 118, 23);
		frame.getContentPane().add(btnIzlaz);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefon.setBounds(55, 183, 80, 14);
		frame.getContentPane().add(lblTelefon);
		
		JLabel lblFirma = new JLabel("Firma:");
		lblFirma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirma.setBounds(57, 219, 78, 14);
		frame.getContentPane().add(lblFirma);
		
		JLabel lblImeOdgovor = new JLabel("");
		lblImeOdgovor.setBounds(145, 40, 174, 14);
		frame.getContentPane().add(lblImeOdgovor);
		
		JLabel lblPrezimeOdgovor = new JLabel("");
		lblPrezimeOdgovor.setBounds(145, 75, 174, 14);
		frame.getContentPane().add(lblPrezimeOdgovor);
		
		JLabel lblJmbgOdgovor = new JLabel("");
		lblJmbgOdgovor.setBounds(145, 111, 174, 14);
		frame.getContentPane().add(lblJmbgOdgovor);
		
		JLabel lblAdresaOdgovor = new JLabel("");
		lblAdresaOdgovor.setBounds(145, 145, 174, 14);
		frame.getContentPane().add(lblAdresaOdgovor);
		
		JLabel lblTelefonOdgovor = new JLabel("");
		lblTelefonOdgovor.setBounds(145, 183, 174, 14);
		frame.getContentPane().add(lblTelefonOdgovor);
		
		JLabel lblFirmaOdgovor = new JLabel("");
		lblFirmaOdgovor.setBounds(145, 219, 174, 14);
		frame.getContentPane().add(lblFirmaOdgovor);
		
		JLabel lblPozicijaOdgovor = new JLabel("");
		lblPozicijaOdgovor.setBounds(145, 254, 174, 14);
		frame.getContentPane().add(lblPozicijaOdgovor);
		
		JLabel lblZaposlenOdgovor = new JLabel("");
		lblZaposlenOdgovor.setBounds(145, 289, 174, 14);
		frame.getContentPane().add(lblZaposlenOdgovor);
		
		if(_o != null) {
			lblImeOdgovor.setText(_o.getIme());
			lblPrezimeOdgovor.setText(_o.getPrezime());
			lblJmbgOdgovor.setText(_o.getJmbg());
			lblAdresaOdgovor.setText(_o.getAdresa());
			lblTelefonOdgovor.setText(_o.getTelefon());
			lblPozicijaOdgovor.setText(_o.getPozicija());
			lblZaposlenOdgovor.setText(_o.getDatumZaposlenja().toString());
			lblFirmaOdgovor.setText(_o.getFirma().toString());
		}
	}
}
