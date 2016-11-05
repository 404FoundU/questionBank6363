package org.questionBank.dao;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.questionBank.data.Teaches;

/**
 * Tests for {@Teaches}.
 *
 */

@RunWith(JUnit4.class)
public class TestTeaches {
	
	private Teaches a1;
	private Teaches a2;
	private Teaches a3;
	
	/**
	 * Create 3 Teaches instance
	 * Note: this method is called once before every test method
	 */
//	@Before
//	 public void setUp(){
//	  this.a1 = new Teaches(1, "Teaches1");
//	  this.a2 = new Teaches(2, "Teaches2");
//	  this.a3 = new Teaches(3, "Teaches3");
//	  a1.setId(10);
//	  a2.setId(11);
//	  a3.setId(12);

//	 }
	 
	 @Test
	 public void getId(){
		 assertEquals(10,a1.getId());
		 assertEquals(11,a2.getId());
		 assertEquals(12,a3.getId());
	
	 }
	
//	 @Test
//	 public void getQuestionId(){
//		 assertEquals(1, a1.getQuestionId());
//		 assertEquals(2, a2.getQuestionId());
//		 assertEquals(3, a3.getQuestionId());
//	
//	 }
//	 
//	 @Test
//	 public void getTeachesText(){
//		 assertEquals("asnwer1", a1.getTeachesText());
//		 assertEquals("asnwer2", a2.getTeachesText());
//		 assertEquals("Teaches3", a3.getTeachesText());
//		 
//	 }
//	 
	 
	
	
}
