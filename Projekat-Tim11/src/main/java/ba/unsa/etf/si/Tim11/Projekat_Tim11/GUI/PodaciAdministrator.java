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

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Admin;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Firma;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import java.util.Date;
import java.util.List;

public class PodaciAdministrator {

	private JFrame frame;
	private static Admin _a;
	private List<Firma> _firme;

	
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
		_firme = Sistem.Firme.lista();
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(10, 11, 78, 14);
		frame.getContentPane().add(lblIme);
		
		
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(0, 36, 88, 14);
		frame.getContentPane().add(lblPrezime);
		
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblJmbg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJmbg.setBounds(10, 61, 78, 14);
		frame.getContentPane().add(lblJmbg);
		
		
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(10, 86, 78, 14);
		frame.getContentPane().add(lblAdresa);
		
		
		
		JLabel lblPozicija = new JLabel("Pozicija u firmi:");
		lblPozicija.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPozicija.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPozicija.setBounds(-26, 136, 114, 14);
		frame.getContentPane().add(lblPozicija);
		
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(216, 11, 148, 162);
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
	
		btnIzlaz.setBounds(239, 184, 118, 23);
		frame.getContentPane().add(btnIzlaz);
		
		JLabel lblKontaktTelefon = new JLabel("Kontakt telefon:");
		lblKontaktTelefon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKontaktTelefon.setBounds(10, 111, 78, 14);
		frame.getContentPane().add(lblKontaktTelefon);
		
		JLabel lblImeadmin = new JLabel("");
		lblImeadmin.setBounds(111, 11, 95, 14);
		frame.getContentPane().add(lblImeadmin);
		
		JLabel lblPrezimeadmin = new JLabel("");
		lblPrezimeadmin.setBounds(98, 36, 95, 14);
		frame.getContentPane().add(lblPrezimeadmin);
		
		JLabel lblJmbgadmin = new JLabel("");
		lblJmbgadmin.setBounds(98, 61, 95, 14);
		frame.getContentPane().add(lblJmbgadmin);
		
		JLabel lblAdresaadmin = new JLabel("");
		lblAdresaadmin.setBounds(111, 86, 95, 14);
		frame.getContentPane().add(lblAdresaadmin);
		
		JLabel lblKontaktadmin = new JLabel("");
		lblKontaktadmin.setBounds(98, 111, 95, 14);
		frame.getContentPane().add(lblKontaktadmin);
		
		JLabel lblAdministrator = new JLabel("Administrator");
		lblAdministrator.setBounds(98, 136, 95, 14);
		frame.getContentPane().add(lblAdministrator);

		if(_a != null) {
			lblImeadmin.setText("Temp");
			lblPrezimeadmin.setText("Tempić");
			lblJmbgadmin.setText("1505991170272");
			lblAdresaadmin.setText("Dolina 15");
			lblKontaktadmin.setText("+38761566311");
			
		}
	}
}