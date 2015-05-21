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
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtJmbg;
	private JTextField txtAdresa;
	private JTextField txtPozicija;
	private JTextField txtTelefon;
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
		lblIme.setBounds(10, 23, 78, 14);
		frame.getContentPane().add(lblIme);
		
		txtIme = new JTextField();
		txtIme.setBounds(98, 20, 200, 20);
		frame.getContentPane().add(txtIme);
		txtIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(0, 54, 88, 14);
		frame.getContentPane().add(lblPrezime);
		
		txtPrezime = new JTextField();
		txtPrezime.setBounds(98, 51, 200, 20);
		frame.getContentPane().add(txtPrezime);
		txtPrezime.setColumns(10);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJmbg.setBounds(10, 85, 78, 14);
		frame.getContentPane().add(lblJmbg);
		
		txtJmbg = new JTextField();
		txtJmbg.setBounds(98, 82, 200, 20);
		frame.getContentPane().add(txtJmbg);
		txtJmbg.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(10, 116, 78, 14);
		frame.getContentPane().add(lblAdresa);
		
		txtAdresa = new JTextField();
		txtAdresa.setBounds(98, 113, 200, 20);
		frame.getContentPane().add(txtAdresa);
		txtAdresa.setColumns(10);
		
		JLabel lblPozicija = new JLabel("Pozicija u firmi:");
		lblPozicija.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPozicija.setBounds(-26, 209, 114, 14);
		frame.getContentPane().add(lblPozicija);
		
		txtPozicija = new JTextField();
		txtPozicija.setBounds(98, 206, 200, 20);
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
		btnIzlaz.setBounds(329, 300, 118, 23);
		frame.getContentPane().add(btnIzlaz);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefon.setBounds(10, 147, 80, 14);
		frame.getContentPane().add(lblTelefon);
		
		txtTelefon = new JTextField();
		txtTelefon.setBounds(98, 144, 200, 20);
		frame.getContentPane().add(txtTelefon);
		txtTelefon.setColumns(10);
		
		JLabel lblFirma = new JLabel("Firma:");
		lblFirma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirma.setBounds(10, 178, 78, 14);
		frame.getContentPane().add(lblFirma);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(98, 175, 200, 20);
		frame.getContentPane().add(comboBox);
		
		if(_o != null) {
			txtIme.setText(_o.getIme());
			txtPrezime.setText(_o.getPrezime());
			txtJmbg.setText(_o.getJmbg());
			txtAdresa.setText(_o.getAdresa());
			txtTelefon.setText(_o.getTelefon());
			txtPozicija.setText(_o.getPozicija());
			calZaposlen.setDate(_o.getDatumZaposlenja());
		}
		if(_firme.size() != 0) {
			for(Firma f : _firme) {
				comboBox.addItem(f.toString());
			}
		}
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date datum = calZaposlen.getDate();
				String firma = (String) comboBox.getSelectedItem();
				try {
					if (_o != null) {
						_o.setIme(txtIme.getText());
						_o.setPrezime(txtPrezime.getText());
						_o.setJmbg(txtJmbg.getText());
						_o.setAdresa(txtAdresa.getText());
						_o.setTelefon(txtTelefon.getText());
						_o.setPozicija(txtPozicija.getText());
						_o.setDatumZaposlenja(datum);
						for (Firma f : _firme) {
							if (f.toString().equals(firma)) {
								_o.setFirma(f);
							}
						}
						JOptionPane.showMessageDialog(frame, "Uspješno ste ažurirali podatke");
						frame.dispose();
						OperaterPocetna op = new OperaterPocetna(_o);
						op.main(null);
					}
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPotvrdi.setBounds(329, 266, 118, 23);
		frame.getContentPane().add(btnPotvrdi);
	}
}
