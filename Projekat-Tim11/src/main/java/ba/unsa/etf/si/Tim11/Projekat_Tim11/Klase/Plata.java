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
	private double faktor;			//faktor za licni odbitak(djeca ovo ono :D)
	private double koeficijent;    //koeficijent slozenosti za razlicite stepene stručnosti(nekvalifikovani radnik << doktor)
	private double osnovica;	   // fiksna za svaku firmu posebno
	
	
	private int stvarniRad;				//broj radnih dana  koliko je zaposlenih radio u nekom mjesecu
	private int bolovanje;				//broj dana bolovanja
	private int brojRadnihDana;      //ovo se odnosi na to koliko u mjesecu ima radnih dana
	private int godineStaza;		 //ovo mozemo dobiti iz klase zaposlenika preko metode
	private int godisnjiOdmor;		//broj dana godisnjeg odmora
	
	//dodana dva atributa
	private double nocniRad;        //predstavlja zaradu za nocni rad(broj_sati_nocnog_rada*satnica_za_nocni_Rad)
	private int prazniciRad;         //broj dana koliko se radilo za praznike
	

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "zaposlenik")
	private Zaposlenik zaposlenik;
	
	public Plata(Zaposlenik zaposlenik,Date datum, double dnevniTopliObrok,
				double faktor,double koeficijent,double osnovica,
				int stvarniRad, int bolovanje, int brojRadnihDana,
	           int godineStaza, int godisnjiOdmor) throws Exception
	{
		if((stvarniRad+bolovanje+godisnjiOdmor)>brojRadnihDana) throw new Exception("Zbir stvarnog rada, bolovanja i godisnjeg odmora u jednom mjesecu ne moze biti >31");
		
		this.setZaposlenik(zaposlenik);
		this.setDatum(datum);
		this.setDnevniTopliObrok(dnevniTopliObrok);
		this.setFaktor(faktor);
		this.setKoeficijent(koeficijent);
		this.setOsnovica(osnovica);
		this.setStvarniRad(stvarniRad);
		this.setBolovanje(bolovanje);
		this.setBrojRadnihDana(brojRadnihDana);
		this.setGodineStaza(godineStaza);
		this.setGodisnjiOdmor(godisnjiOdmor);
		
	}
	
	//konstruktor sa dva dodatna parametra: nocniRad i radPraznici
	
	
	public Plata(Zaposlenik zaposlenik,Date datum, double dnevniTopliObrok,
			double faktor,double koeficijent,double osnovica,
			int stvarniRad, int bolovanje, int brojRadnihDana,
           int godineStaza, int godisnjiOdmor, double nocniRad,int prazniciRad) throws Exception
{
	if((stvarniRad+bolovanje+godisnjiOdmor)>brojRadnihDana) throw new Exception("Zbir stvarnog rada, bolovanja i godisnjeg odmora u jednom mjesecu ne moze biti >31");
	
	this.setZaposlenik(zaposlenik);
	this.setDatum(datum);
	this.setDnevniTopliObrok(dnevniTopliObrok);
	this.setFaktor(faktor);
	this.setKoeficijent(koeficijent);
	this.setOsnovica(osnovica);
	this.setStvarniRad(stvarniRad);
	this.setBolovanje(bolovanje);
	this.setBrojRadnihDana(brojRadnihDana);
	this.setGodineStaza(godineStaza);
	this.setGodisnjiOdmor(godisnjiOdmor);
	this.setNocniRad(nocniRad);
	this.setPrazniciRad(prazniciRad);
	
}

	public Plata(){};
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
		if(faktor<1) throw new Exception("Faktor ne moze biti manji od 1");
		this.faktor = faktor;
	}
	public double getKoeficijent()
	{
		return koeficijent;
	}
	public void  setKoeficijent(double koeficijent) throws Exception
	{
		if(koeficijent<1) throw new Exception("Koeficijent ne moze biti manji od 1");
		this.koeficijent = koeficijent;
		
	}

	public double getOsnovica() {
		return osnovica;
	}


	public void setOsnovica(double osnovica) throws Exception {
		if(osnovica<=0) throw new Exception("Osnovica ne moze biti manja od 0");
		this.osnovica = osnovica;
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

	public double getNocniRad()
	{
		return this.nocniRad;
	}
	public void  setNocniRad(double nocniRad)
	{	
		//trebalo bi neku provjeru ubaciti da se ne moze unijeti nesto previse nocnog rada, to uraditi mozda u formi
		
		this.nocniRad=nocniRad;
	}
	public int getPrazniciRad()
	{
		return this.prazniciRad;
	}
	public void setPrazniciRad(int prazniciRad) throws Exception
	{
		if(this.prazniciRad>10) throw new Exception("Max broj radnih dana praznika je 10!");
		this.prazniciRad=prazniciRad;
	}
	public void setGodisnjiOdmor(int godisnjiOdmor)throws Exception { //nisam imao kad pogledat koliko smije biti dana godisnjeg
		if(godisnjiOdmor<0 || godisnjiOdmor>31)  throw new Exception("Godisnji odmor mora biti izmedju 0 i 30 dana");
		this.godisnjiOdmor = godisnjiOdmor;
	}
	
	
	
	public double izracunajMinuliRad(double dohodak) throws Exception {
		if(dohodak < 0) throw new Exception("Dohodak ne može biti negativan!");
		double procenat= godineStaza*0.6;        
		double minuliRad=(dohodak*procenat)/100;
		return minuliRad;
		//test
		
	}
	
	public double izracunajDohodak() throws Exception {     //podijelio sam racun da je lakse za razumjeti
		double dohodak1=zaposlenik.getOsnovica()*zaposlenik.getKoeficijent();
		double dohodak2=dohodak1+izracunajMinuliRad(dohodak1);
		return dohodak2;
	}

	public double izracunajStopuPoreza() {
		double d1=17;          //doprinos za PIO/MIo
		double d2=12.5;        //doprinos za zdravstveno osiguranje
		double d3=1.5;         //doprinos za osiguranje od nezaposlenosti
		/*
		double d4=6;		   //doprinos za PIO na teret poslodavca
		double d5=4;           //doprinos za zdravstveno osiguranje na teret poslodavca
		double d6=0.5;         //doprinos za osiguranje od nezaposlenosti na teret poslodavca
		*/
		double pom= 100-(d1+d2+d3);  //da se mogu promijeniti stope, inace je sad ovo =69
		double stopa= 100/pom;
		return stopa;
	}
	
	
	public double izracunajPorezNaDohodak() throws Exception
	{
		double licniOdbitak=300;   //osnovni licni odbitak
		licniOdbitak=licniOdbitak*zaposlenik.getFaktor();
		double osnovicaZaPorez=this.izracunajDohodak()-licniOdbitak;
		double porezNaDohodak=(osnovicaZaPorez*10)/100;    // izracunavanje poreza od 10% na osnovicaZaPorez
		return porezNaDohodak;
	}
	public double izracunajBrutoPlatu() throws Exception{
		double bruto= izracunajDohodak()*izracunajStopuPoreza();
		return bruto;
	}
	public double izracunajNetoPlatu() throws Exception
	{
		/*
			Posto nam neto zavisi od stvarnog rada(koliko je stvarno sati zaposlenik radio),
			racuna se prvo satnica za taj  mjesec(dohodak/(radni dani u mjesecu)) i mnozi se 
			sa stvarnim radom(stvarni rad). Od dobijenog iznosa se oduzima porez na dohodak
		 */
		double satnica=(this.izracunajDohodak())/(this.brojRadnihDana*8);
		double neto=satnica*(this.stvarniRad*8);   //broj radnih dana * 8=ukupna moguca satnica za jedan mjesec
		
		if(this.bolovanje !=0) 
		{
			//rekli smo da bolovanje racunamo kao 80% zarade
		double netoBolovanje=((satnica*80)/100)*(this.bolovanje*8);   //uzeo sam 80% satnice valjda je to ok
		neto+=netoBolovanje;         //neto je zarada kada je zap. radio dok je netoBolovanje zarada kad je zaposlenik bio na bolovanju
		}
		double ukupanTopli=this.stvarniRad*this.zaposlenik.getDnevniTopliObrok(); //ukupan topli obrok* broj dana koje je zaposlenik radio
												          		  //sto znaci da nam u sustini godisnji odmor znaci 
		
		if(this.prazniciRad !=0)	
		{ 
			//15% vise na satnicu za praznike
			double netoPraznici=((satnica*115)/100)*(this.prazniciRad*8);
			neto+=netoPraznici;
		}
		neto+=this.nocniRad;       //samo sam ovako dodao posto je nocniRad dodatak na platu
		neto-=izracunajPorezNaDohodak();
		neto+=ukupanTopli;
		return neto;
	
	}			
	public String toString()
	{
		return Long.toString(id)+" "+Double.toString(zaposlenik.getOsnovica());
	}
}