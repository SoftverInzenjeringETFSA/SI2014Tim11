package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.util.*;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.*;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Util.*;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private Osoba _o;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Zaposlenik _z;
	Plata _p=new Plata();
	private void initialize() {
		_z=new Zaposlenik("Adnan","Muslija","1502994190023","Džamijska 4","+38761508633",new Date(),"zaposlenik");

		_p.setOsnovica(100);
		_p.setZaposlenik(_z);
		_z.getPlate().add(_p);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JLabel lbl_ime = new JLabel("Ime:  ");
		lbl_ime.setBounds(118, 82, 243, 73);
		frame.getContentPane().add(lbl_ime);
		
		final JButton btn_ime = new JButton("Prikaži ime");
		btn_ime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(_z.getPlate().size());
				Sistem.Zaposlenici.dodaj(_z);	
				lbl_ime.setText("ID: "+_z.getId());
				btn_ime.setVisible(false);
			}
		});
		btn_ime.setBounds(164, 166, 113, 52);
		frame.getContentPane().add(btn_ime);
	}
}
