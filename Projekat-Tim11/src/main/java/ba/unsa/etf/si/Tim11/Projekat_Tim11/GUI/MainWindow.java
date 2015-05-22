
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
	Firma f=new Firma();
	Operater _op;
	Admin _ad;
	private void initialize() {
		try {
			f.setIme("name");
			_op=new Operater("Adnan","Muslija","1502994190023","Džamijska 4","+38761508633",new Date(),"zaposlenik");
			_ad=new Admin("Adnan","Muslija","1502994190023","Džamijska 4","+38761508633",new Date(),"administrator");
			_op.setPassword("1234");
			_op.setUsername("user");
			_op.setFirma(f);
			_ad.setPassword("0000");
			_ad.setUsername("Admin");
			_z=new Zaposlenik(f,"Adnan","Muslija","1502994190023","Džamijska 4","+38761508633",new Date(),"zaposlenik",10.0,1.0,2.7,300.0);
			_z.setFirma(f);
			f.dodajOperatera(_op);
			f.dodajZaposlenika(_z);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
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
				
				//Long id=Sistem.Firme.dodaj(f);
				Sistem.Admini.dodaj(_ad);
				final Zaposlenik temp=Sistem.Zaposlenici.nadji(2);
				Firma tf=temp.getFirma();
				lbl_ime.setText("ID: "+tf.getId());
				btn_ime.setVisible(false);
			}
		});
		btn_ime.setBounds(164, 166, 113, 52);
		frame.getContentPane().add(btn_ime);
	}
}
