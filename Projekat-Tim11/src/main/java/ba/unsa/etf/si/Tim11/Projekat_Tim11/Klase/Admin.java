package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.io.Serializable;
import java.util.Date;

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

	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	String username;
	String password;
	
	public Admin(){}
	
	
	public Admin(String ime, String prezime, String jmbg,
			String adresa, String telefon, Date datumZaposlenja, String pozicija) {
		super(ime,prezime,jmbg,adresa,telefon,datumZaposlenja,pozicija);
		
	}
	
	public boolean ispravanPassword(String pass){
		return this.password==pass;
	}

}
