package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class OperaterPocetna {

	private JFrame frame;
	private static String _username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperaterPocetna window = new OperaterPocetna(_username);
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
	public OperaterPocetna() {
		initialize();
	}
	
	public OperaterPocetna(String username) {
		initialize();
		_username = username;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Početna");
		ImageIcon img = new ImageIcon("icons/login_icon.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setLayout(null);
		
		JLabel lblDobrodosli = new JLabel("Dobrodošli,  ");
		lblDobrodosli.setBounds(48, 11, 200, 35);
		lblDobrodosli.setText("Dobrodošli, " + _username);
		frame.getContentPane().add(lblDobrodosli);
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(48, 57, 137, 144);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/user_icon.png"));
		
		JButton btnMojRacun = new JButton("Moj račun");
		btnMojRacun.setBounds(48, 212, 137, 23);
		frame.getContentPane().add(btnMojRacun);
		
		JButton btnObracun = new JButton("Obračun");
		btnObracun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Obracun o = new Obracun();
				o.main(null);
			}
		});
		btnObracun.setBounds(263, 57, 113, 23);
		frame.getContentPane().add(btnObracun);
		
		JButton btnIzvjestaji = new JButton("Izvještaji");
		btnIzvjestaji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Izvjestaji i = new Izvjestaji();
				i.main(null);
			}
		});
		btnIzvjestaji.setBounds(263, 94, 113, 23);
		frame.getContentPane().add(btnIzvjestaji);
		
		JButton btnKorisnickiRacuni = new JButton("Korisnički računi");
		btnKorisnickiRacuni.setBounds(263, 128, 113, 23);
		frame.getContentPane().add(btnKorisnickiRacuni);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnIzlaz.setBounds(263, 212, 113, 23);
		frame.getContentPane().add(btnIzlaz);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnMojRacun, btnObracun, btnIzvjestaji, btnKorisnickiRacuni, btnIzlaz, frame.getContentPane(), lblDobrodosli, lblSlika}));
	}
}
