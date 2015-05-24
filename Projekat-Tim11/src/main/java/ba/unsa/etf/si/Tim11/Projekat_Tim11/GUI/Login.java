package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;
import java.util.*;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.*;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField txtKorisnickoIme;
	private JPasswordField passSifra;
	private List<Operater> _operateri;
	private List<Admin> _administratori;	

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
	 * @throws Exception 
	 */
	public Login() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	
	private void generateDB(){
		try{
			Admin a= new Admin("Temp","Tempić","1505991170272","Dolina 15","+38761566311",new Date(),"administrator");
			a.setUsername("admin");
			a.setPassword("pass");
			Firma f=new Firma("Temp","Temp");
			Operater o=new Operater("Temp","Tempić","1505991170272","Dolina 15","+38761566311",new Date(),"operater");
			o.setUsername("operater");
			o.setPassword("pass");
			o.setPrivilegije(true);
			Zaposlenik z=new Zaposlenik(f, "Temp","Tempić","1505991170272","Dolina 15","+38761566311",new Date(),"zaposlenik", 1, 1, 1, 1);
			Plata p=new Plata(z, new Date(), 1, 1, 1, 1, 1, 1, 4, 1, 1);
			p.setZaposlenik(z);
			z.dodajPlatu(p);
			o.setFirma(f);
			f.dodajZaposlenika(z);
			f.dodajOperatera(o);
			Sistem.Admini.dodaj(a);
			Sistem.Firme.dodaj(f);
			
		}
		catch(Exception ex){
			
		}
	}
	
	

	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Login");
		ImageIcon img = new ImageIcon("icons/login_icon.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setLayout(null);
		_operateri = Sistem.Operateri.lista();
		_administratori = Sistem.Admini.lista();
		
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime:");
		lblKorisnikoIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnikoIme.setBounds(37, 76, 134, 35);
		frame.getContentPane().add(lblKorisnikoIme);
		
		txtKorisnickoIme = new JTextField();
		txtKorisnickoIme.setBounds(181, 83, 120, 20);
		frame.getContentPane().add(txtKorisnickoIme);
		txtKorisnickoIme.setColumns(10);
		
		JLabel lblSifra = new JLabel("Šifra:");
		lblSifra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSifra.setBounds(60, 112, 111, 50);
		frame.getContentPane().add(lblSifra);
		
		passSifra = new JPasswordField();
		passSifra.setBounds(181, 127, 120, 20);
		frame.getContentPane().add(passSifra);
		
		final JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean jeOperater = true;
				boolean jeAdministrator = false;
				char[] pass = passSifra.getPassword();
				String passString = new String(pass);
			
				for(Operater o : _operateri) {
					if(o.getUsername().equals(txtKorisnickoIme.getText()) && o.ispravanPassword(passString) && o.getPrivilegije())
					{
						frame.dispose();
						OperaterPocetna op = new OperaterPocetna(o);
						op.main(null);
						jeOperater = true;
						break;
					}
					else if(o.getUsername().equals(txtKorisnickoIme.getText()) && o.ispravanPassword(passString) && !o.getPrivilegije())
					{
						frame.dispose();
						OperaterBezPermisijaPocetna op = new OperaterBezPermisijaPocetna(o);
						op.main(null);
						jeOperater = true;
						break;
					}
					else {
						jeOperater = false;
					}
				}
				for(Admin a : _administratori) {
					if(a.getUsername().equals(txtKorisnickoIme.getText()) && a.ispravanPassword(passString)) {
						frame.dispose();
						AdministratorPocetna ap = new AdministratorPocetna(a);
						ap.main(null);
						jeAdministrator = true;
						break;
					}
				}
				if(!jeOperater && !jeAdministrator) {
					JOptionPane.showMessageDialog(frame, "Neispravni podaci");
				}
			}
		});
		btnOk.setBounds(181, 187, 120, 23);
		frame.getContentPane().add(btnOk);
		
		btnOk.setEnabled(false);
		
		txtKorisnickoIme.getDocument().addDocumentListener(new DocumentListener() {

		     public void removeUpdate(DocumentEvent e) {
		    	 String pass = new String(passSifra.getPassword());
		    	 if(txtKorisnickoIme.getText().length() != 0 && pass.length() != 0) {
		    		 btnOk.setEnabled(true);
		    	 }
		    	 else {
		    		 btnOk.setEnabled(false);
		    	 }
		    	 passSifra.getDocument().addDocumentListener(new DocumentListener() {

				     public void removeUpdate(DocumentEvent e) {
				    	 String pass = new String(passSifra.getPassword());
				    	 if(txtKorisnickoIme.getText().length() != 0 && pass.length() != 0) {
				    		 btnOk.setEnabled(true);
				    	 }
				    	 else {
				    		 btnOk.setEnabled(false);
				    	 }
				     }
				     
				     public void insertUpdate(DocumentEvent e) {
				    	 String pass = new String(passSifra.getPassword());
				    	 if(txtKorisnickoIme.getText().length() != 0 && pass.length() != 0) {
				    		 btnOk.setEnabled(true);
				    	 }
				    	 else {
				    		 btnOk.setEnabled(false);
				    	 }
				     }
				     
				     public void changedUpdate(DocumentEvent e) {
					        // TODO add code!

					 }
				});
		     }
		     
		     public void insertUpdate(DocumentEvent e) {
		    	 String pass = new String(passSifra.getPassword());
		    	 if(txtKorisnickoIme.getText().length() != 0 && pass.length() != 0) {
		    		 btnOk.setEnabled(true);
		    	 }
		    	 else {
		    		 btnOk.setEnabled(false);
		    	 }
		    	 passSifra.getDocument().addDocumentListener(new DocumentListener() {

				     public void removeUpdate(DocumentEvent e) {
				    	 String pass = new String(passSifra.getPassword());
				    	 if(txtKorisnickoIme.getText().length() != 0 && pass.length() != 0) {
				    		 btnOk.setEnabled(true);
				    	 }
				    	 else {
				    		 btnOk.setEnabled(false);
				    	 }
				     }
				     
				     public void insertUpdate(DocumentEvent e) {
				    	 String pass = new String(passSifra.getPassword());
				    	 if(txtKorisnickoIme.getText().length() != 0 && pass.length() != 0) {
				    		 btnOk.setEnabled(true);
				    	 }
				    	 else {
				    		 btnOk.setEnabled(false);
				    	 }
				     }
				     
				     public void changedUpdate(DocumentEvent e) {
					        // TODO add code!

					 }
				});
		     }
		     
		     public void changedUpdate(DocumentEvent e) {
			        // TODO add code!

			 }
		});
	}
}
