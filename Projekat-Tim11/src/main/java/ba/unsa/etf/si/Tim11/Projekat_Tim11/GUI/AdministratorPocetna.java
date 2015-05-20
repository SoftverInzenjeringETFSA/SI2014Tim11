package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Zaposlenik;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem.Zaposlenici;





public class AdministratorPocetna {

	private JFrame frame;

	private static int _id;
	
	public String Username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorPocetna window = new AdministratorPocetna(_id);
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
	public AdministratorPocetna() {
		initialize();
	}
	
	public AdministratorPocetna(int id) {
		initialize();
		_id = id;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Početna");
		ImageIcon img = new ImageIcon("icons/login_icon.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Zaposlenik z=Zaposlenici.nadji(_id);
         String username=z.getIme();
 
		
	

		
		JLabel lblDobrodoliIme = new JLabel("Dobrodošli,"+ username);
		lblDobrodoliIme.setBounds(48, 26, 97, 14);
		frame.getContentPane().add(lblDobrodoliIme);
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(25, 51, 137, 144);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/user_icon.png"));
		
		JButton btnMojRaun = new JButton("Moj račun");
		
		btnMojRaun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PodaciAdministrator o = new PodaciAdministrator();
				o.main(null);
			}
		});
		
		
		btnMojRaun.setFont(UIManager.getFont("Button.font"));
		btnMojRaun.setBounds(35, 214, 137, 23);
		frame.getContentPane().add(btnMojRaun);
		
		JButton btnAuriranjeFirmi = new JButton("Ažuriranje firmi");
		btnAuriranjeFirmi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAuriranjeFirmi.setBounds(252, 63, 154, 33);

		frame.getContentPane().add(btnAuriranjeFirmi);
		
		JButton btnAuriranjeOperatera = new JButton("Ažuriranje operatera");
		btnAuriranjeOperatera.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAuriranjeOperatera.setBounds(252, 151, 154, 33);
		frame.getContentPane().add(btnAuriranjeOperatera);
		
		JButton btnRaspodjelaOperatera = new JButton("Raspodjela operatera");
		btnRaspodjelaOperatera.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRaspodjelaOperatera.setBounds(252, 107, 154, 33);
		frame.getContentPane().add(btnRaspodjelaOperatera);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(331, 227, 75, 23);
		frame.getContentPane().add(btnIzlaz);
		
	}
}
