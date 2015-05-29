package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;

import javax.persistence.*;

@Entity
public class Operater extends Osoba implements Account,Serializable{
	
	
	private static final long serialVersionUID = -5250987363270323512L;
	
	@Column(unique=true)
	private String username;
	private String password;
	private boolean privilegije;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "firma")
	private Firma firma;
	
	public Firma getFirma() {
		return firma;
	}

	public void setFirma(Firma firma) {
		this.firma = firma;
	}

	public Operater(){this.privilegije = false;}

	public Operater(String ime, String prezime, String jmbg,String adresa, String telefon, Date datumZaposlenja, String pozicija) throws Exception {
		super(ime,prezime,jmbg,adresa,telefon,datumZaposlenja,pozicija);
		this.privilegije = false;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) throws Exception{
		 Pattern pattern = Pattern.compile("[a-zA-Z0-9_\\.]{3,}"); //mogu se unijeti velika,mala slova,brojevi,tacka i donja crta(minimalno 3 karaktera)
		    if (!pattern.matcher(username).matches()) {
		        throw new Exception("Username mora imati minimalno 3 karaktera(velika i mala slova,brojevi, znakovi(,_)(minimalno tri karaktera)");
		    }
		this.username = username;
	}


	public void setPassword(String password) throws Exception{
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]{3,}"); //mogu se unijeti velika,mala slova,brojevi
	    if (!pattern.matcher(password).matches()) {
	        throw new Exception("Password mora imati minimalno 3 karaktera(velika i mala slova i brojevi(minimalno 3 karaktera)");
	    }
		this.password = password;
	}

	public boolean getPrivilegije() {
		return this.privilegije;
	}

	public void setPrivilegije(Boolean privilegije) {
		
		
		this.privilegije = privilegije;
	}
	
	public boolean ispravanPassword(String pass){
		return this.password.equals(pass);
	}
	
	
	
	

}
