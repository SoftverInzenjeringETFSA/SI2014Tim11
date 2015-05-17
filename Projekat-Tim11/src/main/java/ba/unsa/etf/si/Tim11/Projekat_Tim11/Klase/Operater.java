package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

public class Operater extends Osoba implements Account{
	
	private String username;
	private String password;
	private String privilegije;
	
	public Operater(){}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrivilegije() {
		return privilegije;
	}

	public void setPrivilegije(String privilegije) {
		this.privilegije = privilegije;
	}
	
	public boolean ispravanPassword(String pass){
		return this.password==pass;
	}

}
