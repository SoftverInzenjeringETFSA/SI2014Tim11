package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField txtKorisnickoIme;
	private JPasswordField passSifra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Login");
		ImageIcon img = new ImageIcon("icons/login_icon.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setLayout(null);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime:");
		lblKorisnikoIme.setBounds(101, 76, 70, 35);
		frame.getContentPane().add(lblKorisnikoIme);
		
		txtKorisnickoIme = new JTextField();
		txtKorisnickoIme.setBounds(181, 83, 120, 20);
		frame.getContentPane().add(txtKorisnickoIme);
		txtKorisnickoIme.setColumns(10);
		
		JLabel lblSifra = new JLabel("Šifra:");
		lblSifra.setBounds(145, 112, 26, 50);
		frame.getContentPane().add(lblSifra);
		
		passSifra = new JPasswordField();
		passSifra.setBounds(181, 127, 120, 20);
		frame.getContentPane().add(passSifra);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOk.setBounds(181, 187, 120, 23);
		frame.getContentPane().add(btnOk);
	}
}