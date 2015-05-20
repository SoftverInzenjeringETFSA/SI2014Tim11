package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import junit.framework.TestCase;
import junit.framework.JUnit4TestAdapter;

import org.junit.Test;
import org.junit.Ignore;


public class PlataTest extends TestCase {

	


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

	
	@Test (expected=Exception.class) public void testSetSatnica() {
		 try {
				Plata p=new Plata();
				p.setSatnica(-0.5);
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
				Plata p=new Plata();
				p.setGodisnjiOdmor(31);
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
		
	}
@Ignore public void testIzracunajStvarniRad() {
		fail("Not yet implemented");
	}

@Ignore	public void testIzracunajBolovanje() {
		fail("Not yet implemented");
	}

@Ignore	public void testIzracunajTopliObrok() {
		fail("Not yet implemented");
	}

@Ignore	public void testIzracunajBrutoPlatu() {
		fail("Not yet implemented");
	}

}
