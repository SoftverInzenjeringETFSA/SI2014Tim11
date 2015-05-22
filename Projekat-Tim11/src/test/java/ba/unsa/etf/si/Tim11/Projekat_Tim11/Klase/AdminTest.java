package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

public class AdminTest extends TestCase{

	//test konstruktora Admin
	@Test
	public void testKonstruktoraFirme() {
		try {
		
		Admin _a= new Admin("Edin","Strojil","1505991170272","Dolina 15","+38761566311",new Date(),"administrator");
		
		assertEquals("Edin",_a.getIme());
		assertEquals("Strojil",_a.getPrezime());
		}
		catch(Exception e){
			
			System.err.println(e.getMessage());
		}
	}

	//test metode setUsername 
	@Test
	public void testSetUsername() {
		try {
		
		Admin _a= new Admin("Edin","Strojil","1505991170272","Dolina 15","+38761566311",new Date(),"administrator");
		_a.setUsername("Strojki");
		assertEquals("Strojki",_a.getUsername());
		}
		catch(Exception e){
			
			System.err.println(e.getMessage());
		}
	}
	//test metode setUsername 
	@Test
	public void testSetUsernameException() {
		try {
		
		Admin _a= new Admin("Edin","Strojil","1505991170272","Dolina 15","+38761566311",new Date(),"administrator");
		_a.setUsername("Strojki!!!^4!@#");
		
		}
		catch(Exception e){
			
			System.err.println(e.getMessage());
		}
	}
	//test metode setPassword
	@Test
	public void testSetPasswordException() {
		try {
		
		Admin _a= new Admin("Edin","Strojil","1505991170272","Dolina 15","+38761566311",new Date(),"administrator");
		_a.setPassword("password#13!!@22#::;;");
		
		}
		catch(Exception e){
			
			System.err.println(e.getMessage());
		}
	}
	
	//test metoda vezanih za konstruktor klase Admin
		@Test
		public void testKonstruktoraIMetoda() {
			try {
			
			Admin _a= new Admin("Edin","Strojil","1505991170272","Dolina 15","+38761566311",new Date(),"administrator");
			
			assertEquals("Dolina 15",_a.getAdresa());
			assertEquals("1505991170272",_a.getJmbg());
			assertEquals("+38761566311",_a.getTelefon());
			assertEquals("administrator",_a.getPozicija());
			}
			catch(Exception e){
				
				System.err.println(e.getMessage());
			}
		}
		
		//test metode ispravanPassword
		@Test
		public void testMetodeIspravanPassword() {
			try {
				
				Admin _a= new Admin("Edin","Strojil","1505991170272","Dolina 15","+38761566311",new Date(),"administrator");
				_a.setPassword("password");
				assertEquals(true, _a.ispravanPassword("password"));
			
			}
				catch(Exception e){
					
					System.err.println(e.getMessage());
				}
			
		}
		
}
