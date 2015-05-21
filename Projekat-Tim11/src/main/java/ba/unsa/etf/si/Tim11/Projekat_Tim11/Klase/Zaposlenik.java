package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;


@Entity
public class Zaposlenik extends Osoba implements Serializable{
	
	/**
	 * 
	 */
	private double dnevniTopliObrok;
	private double faktor;
	private double osnovica;
	private double satnica;
	
	private static final long serialVersionUID = 9221881616260285723L;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "zaposlenik")
	private List<Plata> plate;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "firma")
	private Firma firma;
	
	public Firma getFirma() {
		return firma;
	}
	
	public double getDnevniTopliObrok() {
		return dnevniTopliObrok;
	}


	public void setDnevniTopliObrok(double dnevniTopliObrok) throws Exception{
		if(dnevniTopliObrok<=0) throw new Exception("Dnevni topli obrok ne moze biti manji od 0");
		this.dnevniTopliObrok = dnevniTopliObrok;
	}
	public double getFaktor() {
		return faktor;
	}


	public void setFaktor(double faktor)throws Exception {
		if(faktor<1) throw new Exception("Faktor ne moze biti manji od 0");
		this.faktor = faktor;
	}
	public double getOsnovica() {
		return osnovica;
	}


	public void setOsnovica(double osnovica) throws Exception {
		if(osnovica<=0) throw new Exception("Osnovica ne moze biti manja od 0");
		this.osnovica = osnovica;
	}
	public double getSatnica() {
		return satnica;
	}


	public void setSatnica(double satnica) throws Exception{
		if(satnica<=0) throw new Exception("satnica ne moze biti manja od 0");
		this.satnica = satnica;
	}

	public void setFirma(Firma firma) {
		this.firma = firma;
	}

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
			String adresa, String telefon, Date datumZaposlenja, String pozicija,
			double dnevniTopliObrok,double faktor,double osnovica,double satnica) throws Exception //podaci za obračun plate koji se unose prilikom dodavanja zaposlenika u sistem
	{																				//baca izuzetak ako 
		super(ime,prezime,jmbg,adresa,telefon,datumZaposlenja,pozicija);
		this.plate=new ArrayList<Plata>();
		this.setDnevniTopliObrok(dnevniTopliObrok);
		this.setFaktor(faktor);
		this.setOsnovica(osnovica);
		this.setSatnica(satnica);
		
	}
}
