package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.util.Date;

import junit.framework.TestCase;



import org.junit.Test;
import org.junit.Ignore;


public class TestPlata extends TestCase {

	


	@Test (expected=Exception.class) public void testSetDnevniTopliObrok()  {
		
	
        try {
		Plata p=new Plata();
		p.setDnevniTopliObrok(-0.5);
		fail("Nije bacen izuzetak");
        }
        catch(Exception e) {
        	assertTrue(true);
        }
	}

	

	@Test (expected=Exception.class) public void testSetFaktor() {
		 try {
				Plata p=new Plata();
				p.setFaktor(-1);
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
	}

	

	@Test (expected=Exception.class) public void testSetOsnovica() {
		 try {
				Plata p=new Plata();
				p.setOsnovica(-2);
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
	}

	

	

	@Test (expected=Exception.class) public void testSetStvarniRad() {
		 try {
				Plata p=new Plata();
				p.setStvarniRad(-1);
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
	}

	@Test (expected=Exception.class) public void testSetStvarniRad2() {
		 try {
				Plata p=new Plata();
				p.setStvarniRad(32);
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
	}

	@Test (expected=Exception.class) public void testSetBolovanje() {
		 try {
				Plata p=new Plata();
				p.setBolovanje(-1);
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
	}
	
	@Test (expected=Exception.class) public void testSetBolovanje2() {
		 try {
				Plata p=new Plata();
				p.setBolovanje(32);
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
	}



	@Test (expected=Exception.class) public void testSetBrojRadnihDana() {
		 try {
				Plata p=new Plata();
				p.setBrojRadnihDana(-1);
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
	}
 

	@Test (expected=Exception.class) public void testSetBrojRadnihDana2() {
		 try {
				Plata p=new Plata();
				p.setBrojRadnihDana(32);
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
	}

	
	@Test (expected=Exception.class) public void testSetGodineStaza() {
		 try {
				Plata p=new Plata();
				p.setGodineStaza(-1);
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
	}


	@Test (expected=Exception.class) public void testSetGodisnjiOdmor() {
		 try {
			 Firma _f = new Firma();
			 Zaposlenik _z= new Zaposlenik(_f,"Adnan","Muslija","1502994190023","Džamijska 4","+38761508633",new Date(),"zaposlenik",10.0,1.0,2.7,300.0);				
			 Plata p=new Plata(_z,new Date(),14.5, 1.0, 0.7,300,120,2,55,4,0);	
			 p.setGodisnjiOdmor(31);
				
		        }
		        catch(Exception e) {
		        	assertTrue(true);	
		        } 
		
	
	
} 
 public void testizracunajMinuliRad()
	
	{   try{
		Plata p=new Plata();
		p.setGodineStaza(1);
		assertEquals(0.6, p.izracunajMinuliRad(100));
	}
	catch(Exception e)
	{
		assertTrue(true);
	}
	}
 public void testizracunajDohodak(){
	 try{
			Plata p=new Plata();
			p.setGodineStaza(100);
			p.setOsnovica(1);
			p.setKoeficijent(1);
		    p.izracunajMinuliRad(100);
		   double dohodak= p.izracunajDohodak();
		    assertEquals(1.6, dohodak);
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	 
	 
 }
 
 public void testizracunajStopuPoreza()
 {
	 try{
			Plata p=new Plata();
			
		    assertEquals((100./69), p.izracunajStopuPoreza());
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	 
	 
	 
	 
	 
 }
 
 public void testIzracunajPorezNaDohodak()
 {
	 try{
		 Plata p=new Plata();
			p.setGodineStaza(1);
			p.setOsnovica(400);
			p.setKoeficijent(1);
			p.setFaktor(1);
			double roundOff = Math.round(p.izracunajPorezNaDohodak() * 100.0) / 100.0;
	        assertEquals(10.24, roundOff) ;
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	 
	 
	 
 }
	
 public void testizracunajBrutoPlatu()
 {   
	 try{
	 Plata p=new Plata();
	p.setGodineStaza(1);
	p.setOsnovica(400);
	p.setKoeficijent(1);
	p.setFaktor(1);
	double roundOff = Math.round(p.izracunajBrutoPlatu() * 100.0) / 100.0;
	assertEquals(583.19,roundOff) ;
	 }
	 catch(Exception e)
		{
			assertTrue(true);
		}
	 
	 
	 
 }
 
 public void testizracunajNetoPlatu()
 {
	 try{
		 Plata p=new Plata() ;
		 p.setOsnovica(300);
		 p.setKoeficijent(1);
		 p.setGodineStaza(1); //301.8
		 p.setBrojRadnihDana(25);
		 p.setStvarniRad(25);
		 p.setBolovanje(0);
		 p.setPrazniciRad(0);
		 p.setNocniRad(0);
		 p.setDnevniTopliObrok(10);
		 p.setFaktor(1);
		 assertEquals(301.8,p.izracunajDohodak()  ) ;
		 assertEquals(551.62, p.izracunajNetoPlatu());
		 
	 }
	 catch(Exception e)
	 {
		 assertTrue(true);
		 
	 }
 }
	 
	 public void testizracunajNetoPlatu1()
	 {
		 try{
			 Plata p=new Plata() ;
			 p.setOsnovica(300);
			 p.setKoeficijent(1);
			 p.setGodineStaza(1); //301.8
			 p.setBrojRadnihDana(25);
			 p.setStvarniRad(25);
			 p.setBolovanje(10);
			 p.setPrazniciRad(0);
			 p.setNocniRad(0);
			 p.setDnevniTopliObrok(10);
			 p.setFaktor(1);
			 assertEquals(301.8,p.izracunajDohodak()  ) ;
			 assertEquals(648.196, p.izracunajNetoPlatu());
			 
		 }
		 catch(Exception e)
		 {
			 assertTrue(true);
			 
		 }
		 
	 }
	 
	 public void testizracunajNetoPlatu2()
	 {
		 try{
			 Plata p=new Plata() ;
			 p.setOsnovica(300);
			 p.setKoeficijent(1);
			 p.setGodineStaza(1); //301.8
			 p.setBrojRadnihDana(25);
			 p.setStvarniRad(25);
			 p.setBolovanje(0);
			 p.setPrazniciRad(10);
			 p.setNocniRad(0);
			 p.setDnevniTopliObrok(10);
			 p.setFaktor(1);
			 assertEquals(301.8,p.izracunajDohodak()  ) ;
			 double roundOff = Math.round(p.izracunajNetoPlatu()    * 1000.0) / 1000.0;
			 assertEquals(690.448, roundOff);
			 
		 }
		 catch(Exception e)
		 {
			 assertTrue(true);
			 
		 }
		 
	 }
	 
	 public void testizracunajNetoPlatu3()
	 {
		 try{
			 Plata p=new Plata() ;
			 p.setOsnovica(300);
			 p.setKoeficijent(1);
			 p.setGodineStaza(1); //301.8
			 p.setBrojRadnihDana(25);
			 p.setStvarniRad(25);
			 p.setBolovanje(0);
			 p.setPrazniciRad(10);
			 p.setNocniRad(5);
			 p.setDnevniTopliObrok(10);
			 p.setFaktor(1);
			 assertEquals(301.8,p.izracunajDohodak()  ) ;
			 double roundOff = Math.round(p.izracunajNetoPlatu()    * 1000.0) / 1000.0;
			 assertEquals(695.448, roundOff);
			 
		 }
		 catch(Exception e)
		 {
			 assertTrue(true);
			 
		 }
		 
	 }
 

 
}