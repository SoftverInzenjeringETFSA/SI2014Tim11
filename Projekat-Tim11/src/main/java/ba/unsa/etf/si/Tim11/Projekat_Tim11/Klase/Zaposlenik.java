package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;


@Entity
public class Zaposlenik extends Osoba implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9221881616260285723L;



	
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "zaposlenik")
	  private List<Plata> plate;
	
	

	public List<Plata> getPlate() {
		 return this.plate;
	}

	public void setPlate(List<Plata> plate) {
		this.plate = plate;
	}

	public Zaposlenik(){
		this.plate=new ArrayList<Plata>();
	}
	
	public Zaposlenik(String ime, String prezime, String jmbg,
			String adresa, String telefon, Date datumZaposlenja, String pozicija) {
		super(ime,prezime,jmbg,adresa,telefon,datumZaposlenja,pozicija);
		this.plate=new ArrayList<Plata>();
	}
}
