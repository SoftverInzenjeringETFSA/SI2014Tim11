
package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;
import java.awt.TexturePaint;

import javax.swing.JFrame;

import java.util.*;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.*;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Util.*;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import org.hibernate.internal.util.compare.CalendarComparator;
import org.hibernate.type.descriptor.java.CalendarTypeDescriptor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JTextField textField;
	Plata plata;
	private void initialize() {
		try {
			f.setIme("name");
			_op=new Operater("Adnan","Muslija","1502994190023","Džamijska 4","+38761508633",new Date(),"zaposlenik");
			_ad=new Admin("Adnan","Muslija","1502994190023","Džamijska 4","+38761508633",new Date(),"administrator");
			_op.setPassword("1234");
			_op.setUsername("user");
			_op.setFirma(f);
			_ad.setPassword("0000");
			_ad.setUsername("Administrator");
			
			
			_z=new Zaposlenik(f,"Adnan","Muslija","1502994190023","Džamijska 4","+38761508633",new Date(2010,10,5),"zaposlenik",0,1.0,2.7,270.0);
			Calendar trenutni= Calendar.getInstance();
			
			Date pom=new Date(trenutni.get(Calendar.YEAR),trenutni.get(Calendar.MONTH)+1,trenutni.get(Calendar.DAY_OF_MONTH));
			
			plata=new Plata(_z,pom,_z.getDnevniTopliObrok(),_z.getFaktor(),_z.getKoeficijent(),_z.getOsnovica(),21,0,21,_z.radniStaz(),0);
			
			
			
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
		lbl_ime.setBounds(100, 120, 243, 67);
		frame.getContentPane().add(lbl_ime);
		
		final JButton btn_ime = new JButton("Prikaži ime");
		btn_ime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Long id=Sistem.Firme.dodaj(f);
				final Zaposlenik temp=Sistem.Zaposlenici.nadji(10);
				Firma tf=temp.getFirma();
				lbl_ime.setText("ID: "+tf.getId());
				btn_ime.setVisible(false);
			}
		});
		btn_ime.setBounds(277, 198, 113, 52);
		frame.getContentPane().add(btn_ime);
		
		textField = new JTextField();
		textField.setBounds(133, 45, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblZaTestiranjePlate = new JLabel("Izračunaj neto");
		lblZaTestiranjePlate.setBounds(44, 48, 79, 14);
		frame.getContentPane().add(lblZaTestiranjePlate);
		
		JButton btnIzracunaj = new JButton("izracunaj");
		btnIzracunaj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(Double.toString(plata.izracunajNetoPlatu()));
				
			}
		});
		btnIzracunaj.setBounds(241, 44, 89, 23);
		frame.getContentPane().add(btnIzracunaj);
	}
}
