package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.io.Serializable;
import java.util.Date;

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
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.telefon = telefon;
		this.datumZaposlenja = datumZaposlenja;
		this.pozicija = pozicija;
	}

	public Osoba(String ime, String prezime){
		this.ime=ime;
		this.prezime=prezime;
	}
	
	public String getIme(){
		return ime;
	}
	
	public void setIme(String ime){
		this.ime=ime;
	}
	
	public String getPrezime(){
		return prezime;
	}
	
	public void setPrezime(String prezime){
		this.prezime=prezime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
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
		this.pozicija = pozicija;
	}
}
