package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) 
public class Osoba implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4217982052106559220L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ime;
	private String prezime;
	private String jmbg;
	private String adresa;
	private String telefon;
	private Date datumZaposlenja;
	private String pozicija;
	
	public Osoba(){	}
	
	public Osoba(String ime, String prezime, String jmbg,
			String adresa, String telefon, Date datumZaposlenja, String pozicija) {
		super();
		//mozda bi ovdje trebalo pozivati setere za svaku kako bi podaci ostali validni
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.telefon = telefon;
		this.datumZaposlenja = datumZaposlenja;
		this.pozicija = pozicija;
	}

	public Osoba(String ime, String prezime)throws Exception{
		Pattern pattern = Pattern.compile("[a-zA-Z]{3,}"); //mogu se unijeti velika,mala slova,brojevi
	    if (!pattern.matcher(ime).matches() || !pattern.matcher(prezime).matches()) {
	        throw new Exception("Ime i prezime moraju imati minimalno po 3 karaktera(samo velika ili mala slova)");
	    }
		this.ime=ime;
		this.prezime=prezime;
	}
	
	public String getIme(){
		return ime;
	}
	
	public void setIme(String ime) throws Exception{
		Pattern pattern = Pattern.compile("[a-zA-Z]{3,}"); //mogu se unijeti velika,mala slova,brojevi
	    if (!pattern.matcher(ime).matches() || !pattern.matcher(prezime).matches()) {
	        throw new Exception("Ime mora imati minimalno po 3 karaktera(samo velika ili mala slova)");
	    }
		this.ime=ime;
	}
	
	public String getPrezime(){
		return prezime;
	}
	
	public void setPrezime(String prezime) throws Exception{
		Pattern pattern = Pattern.compile("[a-zA-Z]{3,}"); //mogu se unijeti velika,mala slova,brojevi
	    if (!pattern.matcher(prezime).matches()) {
	        throw new Exception("Ime mora imati minimalno po 3 karaktera(samo velika ili mala slova)");
	    }
		this.prezime=prezime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) { //brisemo i ovo? (kao i u ostalim klasama zbog auto incrementa)
		this.id = id;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) throws Exception{
		Pattern pattern = Pattern.compile("[0-9]{13}"); //jmbg mora imati 13 brojeva
	    if (!pattern.matcher(jmbg).matches()) {
	        throw new Exception("Jmbg mora imati tacno 13 brojeva");
	    }
		this.jmbg = jmbg;
	}

	public String getAdresa() {
		
		return adresa;
	}

	public void setAdresa(String adresa)throws Exception {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9\\,\\s]{5,}"); //Adresa minimalno 5 karaktera(ukljucujuci zarez i razmake)
	    if (!pattern.matcher(adresa).matches()) {
	        throw new Exception("Adresa mora imati minimalno 5 karaktera, bez specijalnih znakova osim zareza i razmaka");
	    }
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) throws Exception{
		Pattern pattern = Pattern.compile("(\\+|00)?387\\d{2}\\-?\\d{3,4}-?\\d{3,4}"); //Adresa minimalno 5 karaktera(ukljucujuci zarez i razmake)
	    if (!pattern.matcher(adresa).matches()) {
	        throw new Exception("format telefona je: na prvom mjestu dvije nule ili plus(ili nijedno), slijedi 387, pozivni(dvije cifre), slijede dvije grupe po 3 ili 4 broja npr(38762224-555) ");
	    }
		this.telefon = telefon;
	}

	public Date getDatumZaposlenja() {
		return datumZaposlenja;
	}

	public void setDatumZaposlenja(Date datumZaposlenja) {
		this.datumZaposlenja = datumZaposlenja;
	}

	public String getPozicija() {
		return pozicija;
	}

	public void setPozicija(String pozicija) {
		//
		this.pozicija = pozicija;
	}
}
