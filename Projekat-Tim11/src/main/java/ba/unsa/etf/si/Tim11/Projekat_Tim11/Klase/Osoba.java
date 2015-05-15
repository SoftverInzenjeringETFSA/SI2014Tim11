package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

public class Osoba {

	private String _ime;
	private String _prezime;
	
	public Osoba(){
		
	}
	
	public Osoba(String ime, String prezime){
		_ime=ime;
		_prezime=prezime;
	}
	
	public String getIme(){
		return _ime;
	}
	
	public void setIme(String ime){
		_ime=ime;
	}
	
	public String getPrezime(){
		return _prezime;
	}
	
	public void setPrezime(String prezime){
		_prezime=prezime;
	}
}
