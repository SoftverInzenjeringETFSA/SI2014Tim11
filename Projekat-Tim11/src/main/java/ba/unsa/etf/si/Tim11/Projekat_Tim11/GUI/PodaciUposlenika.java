package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PodaciUposlenika {

	private JFrame frame;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtJmbg;
	private JTextField txtAdresa;
	private JTextField txtPozicija;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PodaciUposlenika window = new PodaciUposlenika();
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
		lblIme.setBounds(10, 32, 78, 14);
		frame.getContentPane().add(lblIme);
		
		txtIme = new JTextField();
		txtIme.setBounds(98, 29, 200, 20);
		frame.getContentPane().add(txtIme);
		txtIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(0, 67, 88, 14);
		frame.getContentPane().add(lblPrezime);
		
		txtPrezime = new JTextField();
		txtPrezime.setBounds(98, 64, 200, 20);
		frame.getContentPane().add(txtPrezime);
		txtPrezime.setColumns(10);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJmbg.setBounds(10, 108, 78, 14);
		frame.getContentPane().add(lblJmbg);
		
		txtJmbg = new JTextField();
		txtJmbg.setBounds(98, 105, 200, 20);
		frame.getContentPane().add(txtJmbg);
		txtJmbg.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(10, 151, 78, 14);
		frame.getContentPane().add(lblAdresa);
		
		txtAdresa = new JTextField();
		txtAdresa.setBounds(98, 148, 200, 20);
		frame.getContentPane().add(txtAdresa);
		txtAdresa.setColumns(10);
		
		JLabel lblPozicija = new JLabel("Pozicija u firmi:");
		lblPozicija.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPozicija.setBounds(-26, 196, 114, 14);
		frame.getContentPane().add(lblPozicija);
		
		txtPozicija = new JTextField();
		txtPozicija.setBounds(98, 193, 200, 20);
		frame.getContentPane().add(txtPozicija);
		txtPozicija.setColumns(10);
		
		JLabel lblZaposlen = new JLabel("Zaposlen:");
		lblZaposlen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZaposlen.setBounds(10, 237, 78, 14);
		frame.getContentPane().add(lblZaposlen);
		
		JCalendar calZaposlen = new JCalendar();
		calZaposlen.setBounds(98, 237, 200, 112);
		frame.getContentPane().add(calZaposlen);
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(329, 32, 148, 183);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/uposlenik_icon.png"));
		
		JButton btnPotvrdi = new JButton("Potvrdi");
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
	}
}
