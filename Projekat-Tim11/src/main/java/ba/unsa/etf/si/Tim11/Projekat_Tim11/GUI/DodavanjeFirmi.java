package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Admin;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Firma;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Zaposlenik;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodavanjeFirmi {

	private JFrame frame;
	private JTextField textNaziv;
	private JTextField txtSjediste;
	private JTextField textAdministrator;
	private static Admin _a;
	private static Firma _f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(){
				try {
					DodavanjeFirmi window;
					if(_a!=null) {
						
							window = new DodavanjeFirmi(_a);
						}
						else {
							window = new DodavanjeFirmi();
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
	public DodavanjeFirmi() {
		initialize();
	}

	public DodavanjeFirmi(Admin a) {
		_a=a;
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 329, 297);
		frame.setTitle("Dodavanje firme");
		ImageIcon img = new ImageIcon("icons/firma.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setLayout(null);
		
		JLabel lblNaziv = new JLabel("Naziv");
		lblNaziv.setBounds(25, 11, 33, 14);
		frame.getContentPane().add(lblNaziv);
		
		JLabel lbSjediste = new JLabel("Sjediste");
		lbSjediste.setBounds(25, 55, 48, 14);
		frame.getContentPane().add(lbSjediste);
		
		JLabel lblAdministrator = new JLabel("Administrator");
		lblAdministrator.setBounds(25, 100, 93, 14);
		frame.getContentPane().add(lblAdministrator);
		
		JLabel lblDatumDodavanja = new JLabel("Datum dodavanja");
		lblDatumDodavanja.setBounds(25, 163, 93, 14);
		frame.getContentPane().add(lblDatumDodavanja);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
			
					frame.dispose();
					PrikazFirmi pf = new PrikazFirmi(_a);
					pf.main(null);
				}
			});
		btnIzlaz.setBounds(224, 227, 77, 21);
		frame.getContentPane().add(btnIzlaz);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						_f = new Firma();
						_f.setIme(textNaziv.getText());
						_f.setSjediste(txtSjediste.getText());
						
						Sistem.Firme.dodaj(_f);
					
						JOptionPane.showMessageDialog(frame, "Uspješno ste dodali novu firmu");
						frame.dispose();
						PrikazFirmi pf=new PrikazFirmi(_a);
						pf.main(null);
					}
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				
			}
		});
		btnPotvrdi.setBounds(109, 228, 77, 19);
		frame.getContentPane().add(btnPotvrdi);
		
		textNaziv = new JTextField();
		textNaziv.setBounds(25, 24, 86, 20);
		frame.getContentPane().add(textNaziv);
		textNaziv.setColumns(10);
		
		txtSjediste = new JTextField();
		txtSjediste.setColumns(10);
		txtSjediste.setBounds(25, 69, 86, 20);
		frame.getContentPane().add(txtSjediste);
		
		textAdministrator = new JTextField();
		textAdministrator.setColumns(10);
		textAdministrator.setBounds(25, 125, 86, 20);
		frame.getContentPane().add(textAdministrator);
		textAdministrator.setText("Admin");
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(25, 188, 88, 21);
		frame.getContentPane().add(dateChooser);

		dateChooser.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{dateChooser.getCalendarButton()}));
		
		
		
		
		
	}
}
