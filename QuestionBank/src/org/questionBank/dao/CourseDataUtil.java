package org.questionBank.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.questionBank.data.Course;
import org.questionBank.data.CourseHome;

public class CourseDataUtil {
	
	public CourseDataUtil(){ }
	
	private CourseHome ch = new CourseHome();
	
	// Validation
	private static int TITLE_LENGTH = 3;
	private static String TITLE_ERROR = "Course Title value must be at least 3 characters long.";
	private static int DEPT_NAME_LENGTH = 3;
	private static String DEPT_NAME_ERROR = "Course Department Name value must be at least 3 characters long.";
	private static BigDecimal MIN_CREDIT = new BigDecimal(0.0);
	private static BigDecimal MAX_CREDIT = new BigDecimal(5.0);
	private static String CREDIT_ERROR = "Course Credit value must be between 0.0 and 5.0.";

	public Course createCourse(String courseNumber, String courseName, String title, String deptName, BigDecimal credit) throws InvalidCourseException {
		Course course = new Course();
		validateCourse(title, deptName, credit);
		course.setCourseNumber(courseNumber);
		course.setCourseName(courseName);
		course.setTitle(title);
		course.setDeptName(deptName);
		course.setCredit(credit);
		// Save Course to DB
		ch.persist(course);
		return course;
	}
	
	public void deleteCourse(BigDecimal id){
		// TODO: test this
		Course del = ch.findById(id); 
		ch.remove(del);
	}
	
	public Course findCourse(BigDecimal id){
		// TODO: test this
		return ch.findById(id);
	}
	
	public boolean updateCourse(BigDecimal id){
		// TODO: implement this
		return false;
	}
	
	public List<Course> getCourses(){
		// TODO: implement this
		return new ArrayList<Course>();
	}
	
	protected void validateCourse(String title, String deptName, BigDecimal credit) throws InvalidCourseException {
		List<String> errors = new ArrayList<String>();
		if(title == null || title.length() < TITLE_LENGTH)
			errors.add(TITLE_ERROR);
		if(deptName == null || deptName.length() < DEPT_NAME_LENGTH)
			errors.add(DEPT_NAME_ERROR);
		if(MIN_CREDIT.compareTo(credit) > 0 || MAX_CREDIT.compareTo(credit) < 0)
			errors.add(CREDIT_ERROR);
		if(!errors.isEmpty()){
			throw new InvalidCourseException(errors);
		}
	}
}
