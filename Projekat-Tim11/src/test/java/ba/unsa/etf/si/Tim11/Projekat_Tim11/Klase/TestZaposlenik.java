package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.Ignore;

public class TestZaposlenik extends TestCase {

	@Test (expected=Exception.class) public void testSetIme()
	{
		 try {
				Zaposlenik z=new Zaposlenik();
				z.setIme("");
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
		
	}
	
	@Test (expected=Exception.class) public void testSetIme1()
	{
		 try {
				Zaposlenik z=new Zaposlenik();
				z.setIme("z");
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
		
	}
	
	@Test (expected=Exception.class) public void testSetIme2()
	{
		 try {
				Zaposlenik z=new Zaposlenik();
				z.setIme("en");
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
		
	}
	
	@Test (expected=Exception.class) public void testSetPrezime()
	{
		 try {
				Zaposlenik z=new Zaposlenik();
				z.setPrezime("");
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
		
	}
	
	@Test (expected=Exception.class) public void testSetPrezime1()
	{
		 try {
				Zaposlenik z=new Zaposlenik();
				z.setPrezime("T");
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
		
	}
	
	@Test (expected=Exception.class) public void testSetPrezime2()
	{
		 try {
				Zaposlenik z=new Zaposlenik();
				z.setPrezime("Ta");
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
		
	}
	
	@Test (expected=Exception.class) public void testsetJmbg()
	{

		 try {
				Zaposlenik z=new Zaposlenik();
				z.setJmbg("");
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
		
		
		
	
	}
	
	@Test (expected=Exception.class) public void testsetJmbg1()
	{

		 try {
				Zaposlenik z=new Zaposlenik();
				z.setJmbg("2121992156832");
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
		
		
		
		
	}
	
	@Test (expected=Exception.class) public void testsetJmbg2()
	{

		 try {
				Zaposlenik z=new Zaposlenik();
				z.setJmbg("212199232654");
				fail("Nije bacen izuzetak");
		        }
		        catch(Exception e) {
		        	assertTrue(true);
		        }
		
		
		
		
	}
	
	
	public void testRadniStaz()
	{
		
		try{
			Date d=new Date();
		
		
			Zaposlenik z=new Zaposlenik();
			z.setDatumZaposlenja(d);
			assertEquals(0, z.radniStaz()) ;
		
		}
		catch(Exception e)
		{
			
			
			
		}
		
		
		
	}

}