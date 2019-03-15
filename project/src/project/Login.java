package project;
import java.util.HashMap;

public class Login {
	HashMap<String, String> userDictionary;
	
	public Login() {
    userDictionary = new HashMap<String, String>();
    userDictionary.put("","");
    userDictionary.put("aya","0000");
	}
    
    
	 public boolean validte(String username,String password) {
		 boolean validation;
		 String fetchedpassword =(String) userDictionary.get(username);
		 if (fetchedpassword != null) {
			 validation=fetchedpassword.equals(password);
			 
		 }
		 else {
			 validation= false ;
		 }
		 
		 return validation;
		 
	 }

}
