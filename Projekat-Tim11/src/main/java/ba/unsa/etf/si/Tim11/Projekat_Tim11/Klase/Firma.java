package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.io.Serializable;
import java.util.*;

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
