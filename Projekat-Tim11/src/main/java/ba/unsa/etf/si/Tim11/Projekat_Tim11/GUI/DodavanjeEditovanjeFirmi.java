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
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class DodavanjeEditovanjeFirmi {

	private JFrame frame;
	private JTextField textNaziv;
	private JTextField txtSjediste;
	private static Admin _a;
	private static Firma _f;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()  {
			public void run() {
				try {
					DodavanjeEditovanjeFirmi window;
					if( _a != null) {
						if(_f != null) {
							window = new DodavanjeEditovanjeFirmi(_f, _a);
						}
						else {
							window = new DodavanjeEditovanjeFirmi(_a);
						}
					}
					else {
						window = new DodavanjeEditovanjeFirmi();
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
	public DodavanjeEditovanjeFirmi() {
		initialize();
	}

	public DodavanjeEditovanjeFirmi(Firma f, Admin a) {
		initialize();
		_a=a;
		_f=f;
	
	}

	public DodavanjeEditovanjeFirmi(Admin _a2) {
		initialize();
	_a=_a2;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 437, 297);
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
		
		JLabel lblAdministrator = new JLabel("Administrator:");
		lblAdministrator.setBounds(25, 110, 93, 14);
		frame.getContentPane().add(lblAdministrator);
		
		JLabel lblDatumDodavanja = new JLabel("Datum dodavanja");
		lblDatumDodavanja.setBounds(206, 11, 93, 14);
		frame.getContentPane().add(lblDatumDodavanja);
		
		final JCalendar calDatum = new JCalendar();
		calDatum.setBounds(206, 24, 188, 121);
		frame.getContentPane().add(calDatum);
		
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
			
					frame.dispose();
					PrikazFirmi pf = new PrikazFirmi(_a);
					pf.main(null);
				}
			});
		btnIzlaz.setBounds(296, 218, 77, 21);
		frame.getContentPane().add(btnIzlaz);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				if(textNaziv.getText().length() == 0 || txtSjediste.getText().length() == 0 ) {
					JOptionPane.showMessageDialog(frame, "Morate popuniti sva polja");
					return;
				}
				if(calDatum.getDate().after(new Date())) {
					JOptionPane.showMessageDialog(frame, "Pogresan datum");
					return;
				}

				
				if(_f == null) {
					try {
						_f = new Firma();
						_f.setIme(textNaziv.getText());
						_f.setSjediste(txtSjediste.getText());
						Sistem.Firme.dodaj(_f);
						JOptionPane.showMessageDialog(frame, "Uspješno ste dodali novu firmu");
						frame.dispose();
				
						PrikazFirmi pf = new PrikazFirmi(_a);
						pf.main(null);
					}
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
					else {
						try {
							
							_f.setIme(textNaziv.getText());
							_f.setIme(txtSjediste.getText());
							Sistem.Firme.izmijeni(_f);
						
							JOptionPane.showMessageDialog(frame, "Uspješno ste ažurirali firmu: " + _f.getIme());
							frame.dispose();
						PrikazFirmi pff=new PrikazFirmi(_a);
							pff.main(null);
						}
						catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
		
		});
		btnPotvrdi.setBounds(181, 219, 77, 19);
		frame.getContentPane().add(btnPotvrdi);
		
		

		
		textNaziv = new JTextField();
		textNaziv.setBounds(25, 24, 86, 20);
		frame.getContentPane().add(textNaziv);
		textNaziv.setColumns(10);
		
		txtSjediste = new JTextField();
		txtSjediste.setColumns(10);
		txtSjediste.setBounds(25, 69, 86, 20);
		frame.getContentPane().add(txtSjediste);
		
		if(_f != null) 
		{
			textNaziv.setText(_f.getIme());
			txtSjediste.setText(_f.getSjediste());
	
		}
		textNaziv.setText("");
		txtSjediste.setText(""); 
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAdmin.setLabelFor(lblAdministrator);
		lblAdmin.setBounds(25, 125, 46, 14);
		frame.getContentPane().add(lblAdmin);
	
		
	}
		}
