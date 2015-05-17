package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Operater extends Osoba implements Account,Serializable{
	
	
	private static final long serialVersionUID = -5250987363270323512L;
	
	private String username;
	private String password;
	private String privilegije;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "firma")
	private Firma firma;
	
	public Firma getFirma() {
		return firma;
	}

	public void setFirma(Firma firma) {
		this.firma = firma;
	}

	public Operater(){}

	public Operater(String ime, String prezime, String jmbg,String adresa, String telefon, Date datumZaposlenja, String pozicija) {
		super(ime,prezime,jmbg,adresa,telefon,datumZaposlenja,pozicija);

	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrivilegije() {
		return privilegije;
	}

	public void setPrivilegije(String privilegije) {
		this.privilegije = privilegije;
	}
	
	public boolean ispravanPassword(String pass){
		return this.password==pass;
	}
	
	

}
