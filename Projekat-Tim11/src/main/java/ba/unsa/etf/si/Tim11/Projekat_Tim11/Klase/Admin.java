package ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase;

public class Admin extends Osoba implements Account {
	
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

	String username;
	String password;
	
	public Admin(){}
	
	public boolean ispravanPassword(String pass){
		return this.password==pass;
	}

}
