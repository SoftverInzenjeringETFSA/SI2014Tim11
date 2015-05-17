package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem;

import java.util.List;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.*;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Util.*;

import org.hibernate.*;

public final class Sistem {
	
	private static Transaction t;
	private static Session s;
	
	private static void openSession(){
		if(s!=null){
			s.close();
			s=null;
		}
		s=HibernateUtil.getSessionFactory().openSession();
		t=s.beginTransaction();
	}
	
	private static void closeSession(){
		if(s!=null){
			s.close();
			s=null;
			t=null;
		}	
	}
	
	
	private Sistem() {}
	
	public static class Osobe{
		
		public static Long dodaj(Osoba o){
			openSession();
			
			Long id= (Long) s.save(o);
			t.commit();
			
			closeSession();
			return id;	
		}
		
		public static Osoba nadji(int id){
			openSession();
			Osoba o = (Osoba) s.get(Osoba.class,new Long(id));
			t.commit();
			
			closeSession();
			return o;
		}
		
		public static void izbrisi(int id){
			openSession();
			Object instance = s.load(Osoba.class, new Long(id));
			if (instance != null)
				s.delete(instance);
			
			t.commit();
			closeSession();
		}
		
		public static Osoba izmijeni(Osoba o){
			openSession();
			s.update(o);
			t.commit();
			closeSession();
			long l=o.getId();
			int id=(int) l;
			return nadji(id);
		}
		
		public static List<Osoba> lista(){
			openSession();
			List<Osoba> osobe=s.createCriteria(Osoba.class).list();
			t.commit();
			return osobe;
		}
	
	}
	
	
	public static class Zaposlenici{
		
		public static Long dodaj(Zaposlenik o){
			openSession();
			
			Long id= (Long) s.save(o);
			t.commit();
			
			closeSession();
			return id;	
		}
		
		public static Zaposlenik nadji(int id){
			openSession();
			Zaposlenik o = (Zaposlenik) s.get(Zaposlenik.class,new Long(id));
			t.commit();
			
			closeSession();
			return o;
		}
		
		public static void izbrisi(int id){
			openSession();
			Object instance = s.load(Zaposlenik.class, new Long(id));
			if (instance != null)
				s.delete(instance);
			
			t.commit();
			closeSession();
		}
		
		public static Zaposlenik izmijeni(Zaposlenik o){
			openSession();
			s.update(o);
			t.commit();
			closeSession();
			long l=o.getId();
			int id=(int) l;
			return nadji(id);
		}
		
		public static List<Zaposlenik> lista(){
			openSession();
			List<Zaposlenik> zaposlenici=s.createCriteria(Zaposlenik.class).list();
			t.commit();
			return zaposlenici;
		}
	
	}
	
	
	

}
