package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import junit.framework.TestCase;
import junit.framework.JUnit4TestAdapter;

import org.junit.Test;
import org.junit.Ignore;
import java.util.Date;

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
			        	System.err.println(e.getMessage());	
			        }
			
		
		
	}
}