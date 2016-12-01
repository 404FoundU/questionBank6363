package org.questionBank.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.questionBank.data.Person;
import org.questionBank.exception.InvalidCredentialException;
import org.questionBank.exception.UserAlreadyExistException;
import org.questionBank.home.PersonHome;
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
			throw new InvalidCredentialException("Invalid Username/Password");
		}
	}
	
	public Person teacherLogin(String userName,String password) throws InvalidCredentialException {
		validateUserCredential(userName,password);
		Person person = findUserByUserName(userName);
		
		if(person.getPassword().equals(password)){
			return person;
		}else{
			throw new InvalidCredentialException("Invalid Password");
		}
	}
	
	public Person findPerson(Integer id){
		// TODO: test this
		Person person = ph.findById(id);
		return person;
	}
	
	public Person findUserByUserName(String userName) throws InvalidCredentialException {
		List<Person> people = ph.findUsersByUserName(userName);
		if(people==null || people.isEmpty()){
			throw new InvalidCredentialException("Invalid Username");
		}
		if(people.size() > 1){
			throw new InvalidCredentialException("Multiple Users Found");
		}
		Person person  = people.get(0);
		return person;
	}
	
	private void validateUserCredential(String username, String password)  throws InvalidCredentialException{
		if(username==null||username.equals(""))
			throw new InvalidCredentialException("Username Empty");
		if(password==null||password.equals(""))
			throw new InvalidCredentialException("Password Empty");
	}
	private void validateUserCredential(String username, String password, String rpassword)  throws InvalidCredentialException{
		if(username==null||username.equals(""))
			throw new InvalidCredentialException("Username Empty");
		if(password==null||password.equals(""))
			throw new InvalidCredentialException("Password Empty");
		if(rpassword==null||rpassword.equals(""))
			throw new InvalidCredentialException("Repeat Password Empty");
		if(!password.equals(rpassword))
			throw new InvalidCredentialException("Password Not Matching");
	}
	public Person createPerson( String userName, String password, String firstName, String rpassword, String lastName) throws InvalidCredentialException, UserAlreadyExistException {
		Person person=null;
		validateUserCredential(userName, password , rpassword);
		List<Person> people=ph.findUsersByUserName(userName);
		if(people != null && !people.isEmpty())
			throw new UserAlreadyExistException("User name not available");
		person=new Person();
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
