package data;

public class gManager {
	private String Password="", Id="";
	public gManager(String id, String password) {
		Password = password;
		Id = id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getId() {
		return Id;
	}	
}
