package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

public class OperaterTest extends TestCase {

	//test get/set firme Operatera
	@Test
	public void testFirmeOperatera() {
			try{
				
				Operater _o = new Operater("Edin","Strojil","1506991170272","Nagiba Nizbrdice 4","+38761555555",new Date(),"zaposlenik");
				Firma _f =new Firma("Hamina Cevapara","Sarajevo");
				_o.setFirma(_f);
				assertEquals(_f,_o.getFirma());			
				
			}
			catch(Exception e){
				System.err.println(e.getMessage());
			}

	}
	//test konstruktora get/set metode Operatera
		@Test
		public void testKonstruktoraOperatera(){
				try{
					
					Operater _o = new Operater("Edin","Strojil","1506991170272","Nagiba Nizbrdice 4","+38761555555",new Date(),"zaposlenik");
					Firma _f =new Firma("Hamina Cevapara","Sarajevo");
					_o.setFirma(_f);
					_o.setAdresa("Pionirska 16");
					assertEquals(_f,_o.getFirma());		
					assertEquals("Edin",_o.getIme());		
					assertEquals("Strojil",_o.getPrezime());		
					assertEquals("Pionirska 16",_o.getAdresa());		
					assertEquals("+38761555555",_o.getTelefon());
					_o.setPozicija("administrator");
					assertEquals("administrator",_o.getPozicija());
					assertNotNull("ne postoji zabiljezen datum zaposlenja",_o.getDatumZaposlenja());
				}
				catch(Exception e){
					System.err.println(e.getMessage());
				}

		}
	//test setUsername Operatera
	@Test
	public void testSetUsername() {
			try{
				
				Operater _o = new Operater("Edin","Strojil","1506991170272","Nagiba Nizbrdice 4","+38761555555",new Date(),"zaposlenik");
				_o.setUsername("Hamo");
				assertEquals("Hamo",_o.getUsername());			
				
			}
			catch(Exception e){
				System.err.println(e.getMessage());
			}

	}
	//test setUsername Operatera
		@Test
		public void testSetUsernamePogresanUnos() {
				try{
					
					Operater _o = new Operater("Edin","Strojil","1506991170272","Nagiba Nizbrdice 4","+38761555555",new Date(),"zaposlenik");
					_o.setUsername("Hamo!@#2!..;");		
					
				}
				catch(Exception e){
					System.err.println(e.getMessage());
				}

		}
		//test setUsername Operatera
		@Test
		public void testSetUsernamePrekratakUnos() {
				try{
					
					Operater _o = new Operater("Edin","Strojil","1506991170272","Nagiba Nizbrdice 4","+38761555555",new Date(),"zaposlenik");
					_o.setUsername("Ha");		
					
				}
				catch(Exception e){
					System.err.println(e.getMessage());
				}

		}
		//test setPassworda Operatera
		@Test
		public void testSetPassworda() {
				try{
							
							Operater _o = new Operater("Edin","Strojil","1506991170272","Nagiba Nizbrdice 4","+38761555555",new Date(),"zaposlenik");
							_o.setPassword("password");		
							assertEquals(true, _o.ispravanPassword("password"));
						}
				catch(Exception e){
							System.err.println(e.getMessage());
						}

				}
		
		/*Mozda jos uraditi testiranje za SetPrivilegije i GetPrivilegije ali to dok skontamo kako koristiti*/

}
