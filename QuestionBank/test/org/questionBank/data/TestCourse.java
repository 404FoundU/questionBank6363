package org.questionBank.data;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.questionBank.data.Course;

/**
 * Tests for {@Course}.
 *
 */

@RunWith(JUnit4.class)
public class TestCourse {
	
	private Course c1;
	private Course c2;
	private Course c3;
	
	/**
	 * Create 3 Course instance
	 * Note: this method is called once before every test method
	 */
	@Before
	 public void setUp(){
	  this.c1 = new Course("Calculus", "100","math",3);
	  this.c2 = new Course("Agile", "6363","csci",2);
	  this.c3 = new Course("DataBase", "5225","csci",1);
	  c1.setId(1);
	  c2.setId(2);
	  c3.setId(3);

	 }
	 
	 @Test
	 public void getId(){
		 assertEquals(new Integer(1),c1.getId());
		 assertEquals(new Integer(2),c2.getId());
		 assertEquals(new Integer(3),c3.getId());
	
	 }
	
	 @Test
	 public void getCourseName(){
		 assertEquals("Calculus", c1.getCourseName());
		 assertEquals("Agile", c2.getCourseName());
		 assertEquals("DataBase", c3.getCourseName());
	
	 }
	 
	 @Test
	 public void getCourseNumber(){
		 assertEquals("100", c1.getCourseNumber());
		 assertEquals("6363", c2.getCourseNumber());
		 assertEquals("5225", c3.getCourseNumber());
		 
	 }
	 
	 @Test
	 public void getDeptName(){
		 assertEquals("math",c1.getDeptName());
		 assertEquals("csci", c2.getDeptName());
		 assertEquals("csci", c3.getDeptName());
		 
	 }
	 
	 
	 @Test
	 public void getCredit(){
		 assertEquals(new Integer(3), c1.getCredit());
		 assertEquals(new Integer(2), c2.getCredit());
		 assertEquals(new Integer(1), c3.getCredit());
	 }
	
	
	
}
