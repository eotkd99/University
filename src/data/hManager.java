package data;

public class hManager {
	private String Password="", Id="";
	public hManager(String id, String password) {
		Password = password;
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
	public void setId(String id) {
		Id = id;
	}
}
