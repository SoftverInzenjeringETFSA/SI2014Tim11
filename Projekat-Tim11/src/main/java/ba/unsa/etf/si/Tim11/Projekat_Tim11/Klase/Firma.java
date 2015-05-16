package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.util.*;

public class Firma {
	
	long id;
	private String ime;
	private List<Zaposlenik> zaposlenici;
	private List<Operater> operateri;
	
	public Firma(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public List<Zaposlenik> getZaposlenici() {
		return zaposlenici;
	}

	public void setZaposlenici(List<Zaposlenik> zaposlenici) {
		this.zaposlenici = zaposlenici;
	}

	public List<Operater> getOperateri() {
		return operateri;
	}

	public void setOperateri(List<Operater> operateri) {
		this.operateri = operateri;
	}
	
	public void dodajZaposlenika(Zaposlenik z){
		
	}
	
	public Zaposlenik nadjiZaposlenika(long id){
		throw new UnsupportedOperationException(); 
	}
	
	public Boolean izbrisiZaposlenika(long id){
		throw new UnsupportedOperationException();
	}
	
	public void dodajOperatera(Operater o){
		
	}
	
	public Operater nadjiOperatera(long id){
		throw new UnsupportedOperationException(); 
	}
	
	public Boolean izbrisiOperatera(long id){
		throw new UnsupportedOperationException();
	}
	
	

}
