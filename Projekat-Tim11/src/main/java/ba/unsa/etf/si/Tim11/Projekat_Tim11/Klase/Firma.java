package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Firma implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8423658855400776683L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	private String ime;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "firma")
	private List<Zaposlenik> zaposlenici;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "firma")
	private List<Operater> operateri;
	
	public Firma(){
		zaposlenici=new ArrayList<Zaposlenik>();
		operateri=new ArrayList<Operater>();
	}
	public Firma(long id, String ime, List<Zaposlenik> zaposlenici, List<Operater> operateri) throws Exception
	{
		this.setId(id);
		this.setIme(ime);
		this.setZaposlenici(zaposlenici);
		this.setOperateri(operateri);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) { // ovo bi trebalo izbrisati? posto u bazi imamo auto increment za id, a i radi konflikta
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) throws Exception {
		 Pattern pattern = Pattern.compile("[a-zA-Z0-9\\s\\.]{3,}"); //mogu se unijeti mala, velika slova, brojevi, i tacka
		    if (!pattern.matcher(ime).matches()) 
		    	throw new Exception("Ime mora imati najmanje 3 karaktera(dozvoljena velika, mala slova brojevi tacka i razmak)");
		
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
		zaposlenici.add(z);
	}
	
	public Zaposlenik nadjiZaposlenika(long id) throws Exception{
		
		for(Zaposlenik z: zaposlenici)
		{
			if(z.getId()==id)
				return z;
		}
		throw new Exception("Ne postoji zaposlenik sa ID-em: "+id); 
	}
	
	public Boolean izbrisiZaposlenika(long id){
		
		for(Zaposlenik z: zaposlenici)
		{
			if(z.getId()==id)
			{
				zaposlenici.remove(z);
				return true;
			}
				
		}
		return false;
	}
	
	public void dodajOperatera(Operater o){
		
		operateri.add(o);
	}
	
	public Operater nadjiOperatera(long id) throws Exception{
		for(Operater o: operateri)
		{
			if(o.getId()==id)
				return o;
		}
		throw new Exception("Ne postoji operater sa ID-em: "+id); 
		
	}
	
	public Boolean izbrisiOperatera(long id){
		for(Operater o: operateri)
		{
			if(o.getId()==id)
			{
				zaposlenici.remove(o);
				return true;
			}
				
		}
		return false;
	}
	public String toString()
	{
		return Long.toString(id)+" "+ime;
	}
	
	

}
