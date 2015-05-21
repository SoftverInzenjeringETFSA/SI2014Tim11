package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Operater;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem;

import java.awt.Component;

public class OperaterPocetna {

	private JFrame frame;
	private static Operater _o;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperaterPocetna window;
					if(_o != null) {
						window = new OperaterPocetna(_o);
					}
					else {
						window = new OperaterPocetna();
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
	public OperaterPocetna() {
		initialize();
	}
	
	public OperaterPocetna(Operater o) {
		initialize();
		_o = o;
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
		if(_o != null) {
			lblDobrodosli.setText("Dobrodošli, " + _o.getUsername());
		}
		frame.getContentPane().add(lblDobrodosli);
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(48, 57, 137, 144);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/user_icon.png"));
		
		JButton btnMojRacun = new JButton("Moj račun");
		btnMojRacun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PodaciOperatera po = new PodaciOperatera(_o);
				po.main(null);
			}
		});
		btnMojRacun.setBounds(48, 212, 137, 23);
		frame.getContentPane().add(btnMojRacun);
		
		JButton btnObracun = new JButton("Obračun");
		btnObracun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Obracun o = new Obracun(_o);
				o.main(null);
			}
		});
		btnObracun.setBounds(263, 57, 137, 23);
		frame.getContentPane().add(btnObracun);
		
		JButton btnIzvjestaji = new JButton("Izvještaji");
		btnIzvjestaji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Izvjestaji i = new Izvjestaji();
				i.main(null);
			}
		});
		btnIzvjestaji.setBounds(263, 94, 137, 23);
		frame.getContentPane().add(btnIzvjestaji);
		
		JButton btnKorisnickiRacuni = new JButton("Korisnički računi");
		btnKorisnickiRacuni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UposleniciPrikaz up = new UposleniciPrikaz(_o);
				up.main(null);
			}
		});
		btnKorisnickiRacuni.setBounds(263, 128, 137, 23);
		frame.getContentPane().add(btnKorisnickiRacuni);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login l;
				try {
					l = new Login();
					l.main(null);
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnIzlaz.setBounds(263, 212, 137, 23);
		frame.getContentPane().add(btnIzlaz);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnMojRacun, btnObracun, btnIzvjestaji, btnKorisnickiRacuni, btnIzlaz, frame.getContentPane(), lblDobrodosli, lblSlika}));
	}
}
