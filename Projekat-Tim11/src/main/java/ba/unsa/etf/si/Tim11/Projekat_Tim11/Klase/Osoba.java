package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.util.Date;

public class Osoba {

	private long id;
	private String ime;
	private String prezime;
	private String jmbg;
	private String adresa;
	private String telefon;
	private Date datumZaposlenja;
	private String pozicija;
	
	public Osoba(){	}
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
