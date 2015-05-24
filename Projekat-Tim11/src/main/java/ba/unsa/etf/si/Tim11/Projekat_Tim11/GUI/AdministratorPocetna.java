package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Admin;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Zaposlenik;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem.Zaposlenici;






public class AdministratorPocetna {

	private JFrame frame;

	private static Admin _a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorPocetna window;
					if(_a != null) {
						window = new AdministratorPocetna(_a);
					}
					else {
						window = new AdministratorPocetna();
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
	public AdministratorPocetna() {
		initialize();
	}
	
	public AdministratorPocetna(Admin a) {
		initialize();
		_a = a;
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
      //   Admin a=Admini.nadji(_id);
        // String username=z.getIme();

 
		
	

		
	JLabel lblDobrodoliIme = new JLabel("Dobrodošli ,");
		lblDobrodoliIme.setBounds(25, 26, 137, 14);
		if(_a != null) {
			lblDobrodoliIme.setText("Dobrodošli, " + _a.getUsername());
		}
		
		frame.getContentPane().add(lblDobrodoliIme);
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(25, 51, 137, 144);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/user_icon.png"));
		
		JButton btnMojRaun = new JButton("Moj račun");
		
		btnMojRaun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PodaciAdministrator p = new PodaciAdministrator(_a);
				p.main(null);
			}
		});
		
		
		btnMojRaun.setFont(UIManager.getFont("Button.font"));
		btnMojRaun.setBounds(35, 214, 137, 23);
		frame.getContentPane().add(btnMojRaun);
		
		JButton btnAuriranjeFirmi = new JButton("Ažuriranje firmi");
		btnAuriranjeFirmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrikazFirmi pf = new PrikazFirmi();
				pf.main(null);
			}
		});
		btnAuriranjeFirmi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAuriranjeFirmi.setBounds(252, 63, 154, 33);

		frame.getContentPane().add(btnAuriranjeFirmi);
		
		JButton btnAuriranjeOperatera = new JButton("Ažuriranje operatera");
		btnAuriranjeOperatera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RadnjeOperateri ro = new RadnjeOperateri(_a);
				ro.main(null);
				
			}
		});
		btnAuriranjeOperatera.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAuriranjeOperatera.setBounds(252, 151, 154, 33);
		frame.getContentPane().add(btnAuriranjeOperatera);
		
		JButton btnRaspodjelaOperatera = new JButton("Raspodjela operatera");
		btnRaspodjelaOperatera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OperateriRaspodjela or = new OperateriRaspodjela(_a);
				or.main(null);
				
			}
		});
		btnRaspodjelaOperatera.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRaspodjelaOperatera.setBounds(252, 107, 154, 33);
		frame.getContentPane().add(btnRaspodjelaOperatera);
		
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(331, 227, 75, 23);
		frame.getContentPane().add(btnIzlaz);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnRaspodjelaOperatera, btnAuriranjeOperatera, btnAuriranjeFirmi, btnIzlaz, frame.getContentPane(), lblDobrodoliIme, lblSlika,btnMojRaun}));

		
		
		
	}
}
