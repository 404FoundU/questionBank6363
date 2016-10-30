package org.questionBank.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.questionBank.data.Course;
import org.questionBank.data.Person;
import org.questionBank.data.PersonHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class PersonDataUtil {

	private static final Logger log = LogManager.getLogger(PersonDataUtil.class);
	
	public PersonDataUtil(){ }
	
	@Autowired
	private PersonHome ph;
	
	
	public boolean adminLogin(String username,String password) throws InvalidCredentialException{
		validateUserCredential(username,password);
		if(username.equals("admin")&&password.equals("admin")){
			return true;
		}else{
			throw new InvalidCredentialException("invalid username or password");
		}
	}
	public boolean teacherLogin(String userName,String password) throws InvalidCredentialException{
		validateUserCredential(userName,password);
		Person person=ph.findByUserName(userName);
		
		if(person.getPassword().equals(password)){
			return true;
		}else{
			throw new InvalidCredentialException("invalid password");
		}
	}
	private void validateUserCredential(String username, String password)  throws InvalidCredentialException{
		if(username==null||username.equals(""))
			throw new InvalidCredentialException("username empty");
		if(password==null||password.equals(""))
			throw new InvalidCredentialException("password empty");
	}
	private void validateUserCredential(String username, String password, String rpassword)  throws InvalidCredentialException{
		if(username==null||username.equals(""))
			throw new InvalidCredentialException("username empty");
		if(password==null||password.equals(""))
			throw new InvalidCredentialException("password empty");
		if(rpassword==null||rpassword.equals(""))
			throw new InvalidCredentialException("repeat password empty");
		if(!password.equals(rpassword))
			throw new InvalidCredentialException("password not matching");
	}
	public Person createPerson( String userName, String password, String firstName, String rpassword, String lastName) throws InvalidCredentialException, UserAlreadyExistException {
		Person person=null;
		validateUserCredential(userName, password , rpassword);
		List<Person> people=ph.findUsersByUserName(userName);
		if(people != null && !people.isEmpty())
			throw new UserAlreadyExistException("User name not available");
		person=new Person();
		person.setPerId(userName);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setPassword(password);
		person.setUserName(userName);
		// Save Course to DB
		log.info("Creating person");
		ph.persist(person);
		return person;
	}
}
