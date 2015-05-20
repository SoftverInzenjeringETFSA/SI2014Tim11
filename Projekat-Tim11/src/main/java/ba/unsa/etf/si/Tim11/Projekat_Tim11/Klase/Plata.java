package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
public class Plata implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2627822191389243415L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date datum;
	private double dnevniTopliObrok;
	private double faktor;
	private double osnovica;
	private double satnica;
	private int stvarniRad;
	private int bolovanje;
	private int brojRadnihDana; 
	private int godineStaza;
	private int godisnjiOdmor;
	

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "zaposlenik")
	private Zaposlenik zaposlenik;
	
	public Plata(){}


	public Zaposlenik getZaposlenik() {
		return zaposlenik;
	}


	public void setZaposlenik(Zaposlenik zaposlenik) {
		this.zaposlenik = zaposlenik;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) { //i za ovo imamo auto increment
		this.id = id;
	}


	public Date getDatum() {
		return datum;
	}


	public void setDatum(Date datum) {
		this.datum = datum;
	}


	public double getDnevniTopliObrok() {
		return dnevniTopliObrok;
	}


	public void setDnevniTopliObrok(double dnevniTopliObrok) throws Exception{
		if(dnevniTopliObrok<0) throw new Exception("Dnevni topli obrok ne moze biti manji od 0");
		this.dnevniTopliObrok = dnevniTopliObrok;
	}


	public double getFaktor() {
		return faktor;
	}


	public void setFaktor(double faktor)throws Exception {
		if(faktor<0) throw new Exception("Faktor ne moze biti manji od 0");
		this.faktor = faktor;
	}


	public double getOsnovica() {
		return osnovica;
	}


	public void setOsnovica(double osnovica) throws Exception {
		if(osnovica<0) throw new Exception("Osnovica ne moze biti manja od 0");
		this.osnovica = osnovica;
	}


	public double getSatnica() {
		return satnica;
	}


	public void setSatnica(double satnica) throws Exception{
		if(satnica<0) throw new Exception("satnica ne moze biti manja od 0");
		this.satnica = satnica;
	}


	public int getStvarniRad() {
		return stvarniRad;
	}


	public void setStvarniRad(int stvarniRad)throws Exception {
		if(stvarniRad<0 || stvarniRad>31) throw new Exception("Stvarni rad moze biti izmedju 0 i 31 dana");

		this.stvarniRad = stvarniRad;
	}


	public int getBolovanje() {
		return bolovanje;
	}


	public void setBolovanje(int bolovanje)throws Exception {
		if(bolovanje<0 || bolovanje>31) throw new Exception("Bolovanje moze biti izmedju 0 i 31 dana");

		this.bolovanje = bolovanje;
	}


	public int getBrojRadnihDana() {
		return brojRadnihDana;
	}


	public void setBrojRadnihDana(int brojRadnihDana)throws Exception {
		if(brojRadnihDana<0 || brojRadnihDana>31) throw new Exception("Broj radnih dana moze biti izmedju 0 i 31");
		this.brojRadnihDana = brojRadnihDana;
	}


	public int getGodineStaza() {
		return godineStaza;
	}


	public void setGodineStaza(int godineStaza)throws Exception {
		if(godineStaza<0) throw new Exception("Godine staza ne mogu biti negativne");
		this.godineStaza = godineStaza;
	}


	public int getGodisnjiOdmor() {
		return godisnjiOdmor;
	}


	public void setGodisnjiOdmor(int godisnjiOdmor)throws Exception { //nisam imao kad pogledat koliko smije biti dana godisnjeg
		if(godisnjiOdmor<10 || godisnjiOdmor>30)  throw new Exception("Godisnji odmor mora biti izmedju 10 i 30 dana");
		this.godisnjiOdmor = godisnjiOdmor;
	}
	
	
	//nisam ove jos uradio(Ensar)
	public double izracunajStvarniRad() {
		throw new UnsupportedOperationException();
	}
	
	public double izracunajBolovanje() {
		throw new UnsupportedOperationException();
	}

	public double izracunajTopliObrok() {
		throw new UnsupportedOperationException();
	}
	
	public double izracunajBrutoPlatu(){
		throw new UnsupportedOperationException();
	}

}
