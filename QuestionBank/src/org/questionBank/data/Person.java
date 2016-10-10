package org.questionBank.data;
// Generated Oct 9, 2016 11:50:10 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Person generated by hbm2java
 */
@Entity
@Table(name = "Person", catalog = "questionbank")
public class Person implements java.io.Serializable {

	private String perId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;

	public Person() {
	}

	public Person(String perId) {
		this.perId = perId;
	}

	public Person(String perId, String firstName, String lastName, String userName, String password) {
		this.perId = perId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	@Id

	@Column(name = "per_id", unique = true, nullable = false, length = 7)
	public String getPerId() {
		return this.perId;
	}

	public void setPerId(String perId) {
		this.perId = perId;
	}

	@Column(name = "first_name", length = 50)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 50)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "user_name", length = 7)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
