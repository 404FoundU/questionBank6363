package org.questionBank.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCourseDataUtil {

	@Test
	public void testValidateCourse(){
		CourseDataUtil courseDAO = new CourseDataUtil();
		String badTitle1 = "";
		String badTitle2 = "ab";
		String goodTitle = "abc";
		String badDept1 = "";
		String badDept2 = "12";
		String goodDept = "123";
		Integer badCredit1 = -1;
		Integer badCredit2 = 6;
		Integer goodCredit = 3;
		try{
			courseDAO.validateCourse(badTitle1, badDept1, badCredit1);
		}catch(InvalidCourseException ex){
			assertEquals(3, ex.getErrors().size());
			assertEquals(ex.getMessage(), "Errors creating Course:\r\n"+
											 "* Course Title value must be at least 3 characters long.\r\n"+
											 "* Course Department Name value must be at least 3 characters long.\r\n"+
											 "* Course Credit value must be between 0.0 and 5.0.");
		}
		try{
			courseDAO.validateCourse(badTitle2, goodDept, goodCredit);
		}catch(InvalidCourseException ex){
			assertEquals(1, ex.getErrors().size());
			assertEquals(ex.getMessage(), "Errors creating Course:\r\n"+
											 "* Course Title value must be at least 3 characters long.");
		}
		try{
			courseDAO.validateCourse(goodTitle, badDept2, goodCredit);
		}catch(InvalidCourseException ex){
			assertEquals(1, ex.getErrors().size());
			assertEquals(ex.getMessage(), "Errors creating Course:\r\n"+
											 "* Course Department Name value must be at least 3 characters long.");
		}
		try{
			courseDAO.validateCourse(goodTitle, goodDept, badCredit2);
		}catch(InvalidCourseException ex){
			assertEquals(1, ex.getErrors().size());
			assertEquals(ex.getMessage(), "Errors creating Course:\r\n"+
											 "* Course Credit value must be between 0.0 and 5.0.");
		}
	}
	
}
