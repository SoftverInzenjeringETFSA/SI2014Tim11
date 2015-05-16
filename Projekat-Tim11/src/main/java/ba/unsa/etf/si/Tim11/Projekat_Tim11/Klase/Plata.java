package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.util.*;

public class Plata  {
	
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
	
	
	public Plata(){}


	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public void setDnevniTopliObrok(double dnevniTopliObrok) {
		this.dnevniTopliObrok = dnevniTopliObrok;
	}


	public double getFaktor() {
		return faktor;
	}


	public void setFaktor(double faktor) {
		this.faktor = faktor;
	}


	public double getOsnovica() {
		return osnovica;
	}


	public void setOsnovica(double osnovica) {
		this.osnovica = osnovica;
	}


	public double getSatnica() {
		return satnica;
	}


	public void setSatnica(double satnica) {
		this.satnica = satnica;
	}


	public int getStvarniRad() {
		return stvarniRad;
	}


	public void setStvarniRad(int stvarniRad) {
		this.stvarniRad = stvarniRad;
	}


	public int getBolovanje() {
		return bolovanje;
	}


	public void setBolovanje(int bolovanje) {
		this.bolovanje = bolovanje;
	}


	public int getBrojRadnihDana() {
		return brojRadnihDana;
	}


	public void setBrojRadnihDana(int brojRadnihDana) {
		this.brojRadnihDana = brojRadnihDana;
	}


	public int getGodineStaza() {
		return godineStaza;
	}


	public void setGodineStaza(int godineStaza) {
		this.godineStaza = godineStaza;
	}


	public int getGodisnjiOdmor() {
		return godisnjiOdmor;
	}


	public void setGodisnjiOdmor(int godisnjiOdmor) {
		this.godisnjiOdmor = godisnjiOdmor;
	}
	
	
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
