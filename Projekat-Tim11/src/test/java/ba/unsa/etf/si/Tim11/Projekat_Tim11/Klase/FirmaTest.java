package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.TestCase;



import org.junit.Test;

public class FirmaTest extends TestCase{

	//private Firma f;
	//testovi za konstruktore klase Firma
	
	@Test
	(expected=Exception.class)public void testKonstruktoraFirme() {
		try {
		
		Firma _f = new Firma();
		Operater _o = new Operater("Edin","Strojil","1506991170272","Nagiba Nizbrdice 4","+38761555555",new Date(),"zaposlenik");
		_f.dodajOperatera(_o);
		assertEquals(1,_f.getOperateri().size());
		}
		catch(Exception e){
			
			System.err.println(e.getMessage());
		}
	}

	//provjerava da li je je ispravan konstruktor s dva parametra
	@Test
	public void testSetImeFirme() {
		try {
		Firma _f = new Firma("Hamina Magaza","Sarajevo");
		
		assertEquals("Hamina Magaza", _f.getIme());
		assertEquals("Sarajevo", _f.getSjediste());
		
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
		
	}
	//provjerava da li je bacen izuzetak za provjeru imena firme u konstruktoru s dva parametra
	@Test
	(expected=Exception.class)public void testSetImeSjedisteFirme() {
		try {
			Firma _f = new Firma();
		_f.setIme("@#$$!%!113$");
		fail("Nije bacen izuzetak");
		}
		catch(Exception e){
			assertTrue(true);
			
		}
		
	}
	//test za provjeru metode sjedista firme
	@Test 
	public void testSjedistaFirme() {
		try {Firma _f = new Firma();
		_f.setSjediste("Dojcland");
		assertEquals("Dojcland",_f.getSjediste());
		}
		catch (Exception e){
			System.err.println(e.getMessage());
			
		}
		
	}
	//test za provjeru get i set metoda imena firme
		@Test 
		public void testSetImeFirmeUporedivo() {
			try {
				Firma _f = new Firma();
				_f.setIme("HamoPipaOstalaEkipa");
				assertEquals("HamoPipaOstalaEkipa",_f.getIme());
				}
			catch (Exception e){
				System.err.println(e.getMessage());				
			}		
		}
		
		//Test dodavanja Zaposlenika i provjere da li se nalazi u listi
				@Test 
				public void testDodavanjaZaposlenika(){
							
					try {
									
								Firma _f = new Firma();
								Zaposlenik _z= new Zaposlenik(_f,"Adnan","Muslija","1502994190023","Džamijska 4","+38761508633",new Date(),"zaposlenik",10.0,1.0,2.7,300.0);
								_f.dodajZaposlenika(_z);
								
								assertEquals(1,_f.getZaposlenici().size());
						}
					catch (Exception e){
								System.err.println(e.getMessage());				
							}		
						}
		
		
		
		//test pretrage dodanog zaposlenika preko IDa u ovom slucaju privremeno dodanog
		@Test 
		public void testPretragaZaposlenikaUFirmiPrekoId() {
			try {
				Firma _f = new Firma();
				_f.setIme("ProdajaMagleINC");
				Zaposlenik _z= new Zaposlenik(_f,"Adnan","Muslija","1502994190023","Džamijska 4","+38761508633",new Date(),"zaposlenik",10.0,1.0,2.7,300.0);
				long id =312;
				_z.setId(id);;
				_f.dodajZaposlenika(_z);
				
				assertSame(_z,_f.nadjiZaposlenika(id));
			}
			catch (Exception e){
				System.err.println(e.getMessage());				
			}		
		}
		//test za provjeru exceptiona prilikom pronalaska Zaposlenika
		
		@Test
		(expected=Exception.class)public void testPronalaskaZaposlenikaException() {
		
			try {
				Firma _f = new Firma();					
				Zaposlenik _z= new Zaposlenik(_f,"Adnan","Muslija","1502994190023","Džamijska 4","+38761508633",new Date(),"zaposlenik",10.0,1.0,2.7,300.0);
				long id =123;
				_z.setId(id);
				_f.dodajZaposlenika(_z);
				assertEquals(_z,_f.nadjiZaposlenika(id));
				}
		catch(Exception e){
						
				System.err.println(e.getMessage());	
				}
			}
			
		
		//test metode brisi zaposlenika ideja je da dodamo  zaposlenika sa njegovim IDom i obrisemo pozivom metode a onda
		//provjerimo velicinu liste zaposlenika
		@Test 
		public void testBrisanjaZaposlenikaUFirmiPrekoId() {
					
			try {
							
						Firma _f = new Firma();
						Zaposlenik _z= new Zaposlenik(_f,"Adnan","Muslija","1502994190023","Džamijska 4","+38761508633",new Date(),"zaposlenik",10.0,1.0,2.7,300.0);
						
						long id =312;
						
						_z.setId(id);;
						_f.dodajZaposlenika(_z);
						_f.izbrisiZaposlenika(id);
						
						assertEquals(0,_f.getZaposlenici().size());
				}
			catch (Exception e){
						System.err.println(e.getMessage());				
					}		
				}
		//Test dodavanja Operatera i provjere da li se nalazi u listi
		@Test 
		public void testDodavanjaOperatera(){
					
			try {
							
						Firma _f = new Firma();
						Operater _op=new Operater("Hamal","Hamalovic","1506991170272","Put Zivota 2","+38761566311",new Date(),"zaposlenik");
						_f.dodajOperatera(_op);
						
						assertEquals(1,_f.getOperateri().size());
				}
			catch (Exception e){
						System.err.println(e.getMessage());				
					}		
				}
		
		
		
		//Test pronalaska Operatera preko IDa i usporedbe
		@Test 
		public void testPronalaskaOperatera(){
					
			try {
							
						Firma _f = new Firma();
						Operater _op=new Operater("Hamal","Hamalovic","1506991170272","Put Zivota 2","+38761566311",new Date(),"zaposlenik");
						long id =123;
						_op.setId(id);
						_f.dodajOperatera(_op);
						
						assertSame(_op,_f.nadjiOperatera(id));
				}
			catch (Exception e){
						System.err.println(e.getMessage());				
					}		
				}
		
		
	//test za provjeru exceptiona prilikom pronalaska Operatera
			
	@Test
	(expected=Exception.class)public void testPronalaskaOperateraException() {
	
		try {
			Firma _f = new Firma();
				
			Operater _op = new Operater("Edin","Strojil","1506991170272","Nagiba Nizbrdice 4","+38761555555",new Date(),"zaposlenik");
			long id =123;
			_op.setId(id);
			_f.dodajOperatera(_op);
			assertEquals(_op,_f.nadjiOperatera(id));
			}
	catch(Exception e){
					
			System.err.println(e.getMessage());	
			}
		}
	

	//Test brisanja operatera i provjera da li je vraceno true ili false za izvrsenu operaciju
	@Test 
	public void testBrisanjaOperatera(){
				
		try {
						
					Firma _f = new Firma();
					Operater _op=new Operater("Hamal","Hamalovic","1506991170272","Put Zivota 2","+38761566311",new Date(),"zaposlenik");
					long id =123;
					_op.setId(id);
					_f.dodajOperatera(_op);
					
					
					assertSame(true,_f.izbrisiOperatera(id));
			}
		catch (Exception e){
					System.err.println(e.getMessage());				
				}		
			}

	/*//Test brisanja operatera i provjera duzine liste operatera da potvrdimo brisanje
	@Test 
	public void testBrisanjaOperateraDuzinaListeProvjera(){
				
		try {
						
					Firma _f = new Firma();
					Operater _op=new Operater("Hamal","Hamalovic","1506991170272","Put Zivota 2","+38761566311",new Date(),"zaposlenik");
					long id =212;
					_op.setId(id);
					_f.dodajOperatera(_op);
					_f.izbrisiOperatera(id);
					
					assertEquals(0, _f.getOperateri().size());
			}
		catch (Exception e){
					System.err.println(e.getMessage());				
				}		
			}
		
	//Test brisanja operatera i provjera da li je obrisani id ostao 
	@Test 
	public void testBrisanjaOperateraProvjeraIDaNakonBrisanja(){
				
		try {
						
					Firma _f = new Firma();
					Operater _op=new Operater("Hamal","Hamalovic","1506991170272","Put Zivota 2","+38761566311",new Date(),"zaposlenik");
					long id =212;
					_op.setId(id);
					_f.dodajOperatera(_op);
					_f.izbrisiOperatera(id);
					
					assertNotEquals(_op, _f.nadjiOperatera(id));
			}
		catch (Exception e){
					System.err.println(e.getMessage());				
				}		
			}
		*/
		//testiranje toString metode
		@Test 
		public void testToString() {
			
			try{
				Firma _f =new Firma();
				long id =123;
				_f.setId(id);
				_f.setIme("Hamina Pekara");
				assertEquals("123 Hamina Pekara",_f.toString());
			}
			catch(Exception e){
				System.err.println(e.getMessage());
			}
		}
		
		//testiranje equals metode
		@Test 
		public void testEquals() {
			
			try{
				Firma _f =new Firma();
				long id =123;
				_f.setId(id);
				assertEquals(123,_f.getId());
			}
			catch(Exception e){
				System.err.println(e.getMessage());
			}
		}
		//testiranje equals metode tako da uporedimo dvije firme kojima je dodan isti id
				@Test 
				public void testTipaSaEquals() {
					
					try{
						Firma _f =new Firma();
						long id =123;
						Firma _k =new Firma();
						_f.setId(id);
						_k.setId(id);
						assertSame(true,_k.equals(_f));
					}
					catch(Exception e){
						System.err.println(e.getMessage());
					}
				}
	
		
}
