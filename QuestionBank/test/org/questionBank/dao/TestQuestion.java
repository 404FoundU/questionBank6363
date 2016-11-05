package org.questionBank.dao;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.questionBank.data.Question;

/**
 * Tests for {@Question}.
 *
 */

@RunWith(JUnit4.class)
public class TestQuestion {
	
	private Question q1;
	private Question q2;
	private Question q3;
	
	/**
	 * Create 3 Question instance
	 * Note: this method is called once before every test method
	 */
	@Before
	 public void setUp(){
	  this.q1 = new Question(1, "question1", "ch1");
	  this.q2 = new Question(2, "question2", "ch2");
	  this.q3 = new Question(3, "question3", "ch3");
	  q1.setId(1);
	  q2.setId(2);
	  q3.setId(3);
	 }
	 
	 @Test
	 public void getId(){
		 assertEquals(new Integer(1),q1.getId());
		 assertEquals(new Integer(2),q2.getId());
		 assertEquals(new Integer(3),q3.getId());
	
	 }
	
	 @Test
	 public void getCourseId(){
		 assertEquals(new Integer(1),q1.getCourseId());
		 assertEquals(new Integer(2),q2.getCourseId());
		 assertEquals(new Integer(3),q3.getCourseId());
	
	 }
	 
	 @Test
	 public void getQuestion(){
		 assertEquals("question1",q1.getQuestion());
		 assertEquals("question2",q2.getQuestion());
		 assertEquals("question3",q3.getQuestion());
	 }
	 
	 @Test
	 public void getChapter(){
		 assertEquals("ch1",q1.getChapter());
		 assertEquals("ch2",q2.getChapter());
		 assertEquals("ch3",q3.getChapter());
	 }
	
	
	
}
