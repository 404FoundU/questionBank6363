package org.questionBank.data;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.questionBank.data.Teaches;
import org.questionBank.data.TeachesId;

/**
 * Tests for {@Teaches}.
 *
 */

@RunWith(JUnit4.class)
public class TestTeaches {
	
	private TeachesId teachesId1;
	private TeachesId teachesId2;
	private TeachesId teachesId3;

	
	/**
	 * Create 3 Teaches instance
	 * Note: this method is called once before every test method
	 */
	@Before
	 public void setUp(){
		teachesId1 = new TeachesId(1,10);
		teachesId2 = new TeachesId(2,20);
		teachesId3 = new TeachesId(3,30);


	 }
	 
	 @Test
	 public void getPerId(){
		 assertEquals(1,teachesId1.getPerId());
		 assertEquals(2,teachesId2.getPerId());
		 assertEquals(3,teachesId3.getPerId());
	 }
	
	 @Test
	 public void getCourseId(){
		 assertEquals(10, teachesId1.getCourseId());
		 assertEquals(20, teachesId2.getCourseId());
		 assertEquals(30, teachesId3.getCourseId());
	
	 }
	
	
}
