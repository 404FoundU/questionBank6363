package org.questionBank.dao;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.questionBank.data.Answer;

/**
 * Tests for {@Answer}.
 *
 */

@RunWith(JUnit4.class)
public class TestAnswer {
	
	private Answer a1;
	private Answer a2;
	private Answer a3;
	
	/**
	 * Create 3 Answer instance
	 * Note: this method is called once before every test method
	 */
	@Before
	 public void setUp(){
	  this.a1 = new Answer(1, "answer1");
	  this.a2 = new Answer(2, "answer2");
	  this.a3 = new Answer(3, "answer3");
	  a1.setId(10);
	  a2.setId(11);
	  a3.setId(12);

	 }
	 
	 @Test
	 public void getId(){
		 assertEquals(new Integer(10),a1.getId());
		 assertEquals(new Integer(11),a2.getId());
		 assertEquals(new Integer(12),a3.getId());
	
	 }
	
	 @Test
	 public void getQuestionId(){
		 assertEquals(new Integer(1), a1.getQuestionId());
		 assertEquals(new Integer(2), a2.getQuestionId());
		 assertEquals(new Integer(3), a3.getQuestionId());
	
	 }
	 
	 @Test
	 public void getAnswerText(){
		 assertEquals("answer1", a1.getAnswerText());
		 assertEquals("answer2", a2.getAnswerText());
		 assertEquals("answer3", a3.getAnswerText());
		 
	 }
	 
	 
	
	
}
