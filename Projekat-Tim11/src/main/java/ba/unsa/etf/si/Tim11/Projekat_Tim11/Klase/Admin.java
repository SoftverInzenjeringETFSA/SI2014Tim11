package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;

import javax.naming.OperationNotSupportedException;
import javax.persistence.Entity;


@Entity
public class Admin extends Osoba implements Account, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4924022100117216060L;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) throws Exception{
		 Pattern pattern = Pattern.compile("[a-zA-Z0-9_\\.]{3,}"); //mogu se unijeti velika,mala slova,brojevi,tacka i donja crta
		    if (!pattern.matcher(username).matches()) {
		        throw new Exception("Username mora imati minimalno 3 karaktera(velika i mala slova,brojevi, znakovi(,_)(minimalno tri karaktera)");
		    }
		this.username = username;
	}


	public void setPassword(String password) throws Exception{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]{3,}"); //mogu se unijeti velika,mala slova,brojevi
	    if (!pattern.matcher(username).matches()) {
	        throw new Exception("Password mora imati minimalno 3 karaktera(velika i mala slova i brojevi(minimalno 3 karaktera)");
	    }
		this.password = password;
	}

	String username;
	String password;
	
	public Admin(){}
	
	
	public Admin(String ime, String prezime, String jmbg,
			String adresa, String telefon, Date datumZaposlenja, String pozicija) throws Exception {
		super(ime,prezime,jmbg,adresa,telefon,datumZaposlenja,pozicija);
		
	}
	
	public boolean ispravanPassword(String pass){
		return this.password.equals(pass);
	}

}
