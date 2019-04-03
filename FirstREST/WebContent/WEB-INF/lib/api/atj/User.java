package atj;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
//@Named(value="Account")
//@Named("Account")
@RequestScoped
public class User {
private String email;
private String rights;
private String[] access;
private String password;

public User(){
	
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getRights() {
	return rights;
}

public void setRights(String rights) {
	this.rights = rights;
}

public String[] getAccess() {
	return access;
}

public void setAccess(String[] access) {
	this.access = access;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public void generatePassword(IPasswordGenerator passGen) {
    this.password = passGen.generate();
  }

}
