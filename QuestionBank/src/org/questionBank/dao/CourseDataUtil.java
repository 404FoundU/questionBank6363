package org.questionBank.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.questionBank.data.Course;
import org.questionBank.data.CourseHome;

public class CourseDataUtil {

	private static final Logger log = LogManager.getLogger(CourseDataUtil.class);
	
	public CourseDataUtil(){ }
	
	private CourseHome ch = new CourseHome();
	
	// Validation
	private static int MIN_DEPT_NAME_LENGTH = 2;
	private static int MAX_DEPT_NAME_LENGTH = 8;
	private static String MIN_DEPT_NAME_ERROR = "Course Department Name value must be at least 3 characters long.";
	private static String MAX_DEPT_NAME_ERROR = "Course Department Name value must be at most 8 characters long.";
	private static Integer MIN_CREDIT = 0;
	private static Integer MAX_CREDIT = 5;
	private static String CREDIT_ERROR = "Course Credit value must be between 0.0 and 5.0.";

	public Course createCourse(String courseNumber, String courseName, String title, String deptName, Integer credit) throws InvalidCourseException {
		Course course = new Course();
		validateCourse(title, deptName, credit);
		course.setCourseNumber(courseNumber);
		course.setCourseName(courseName);
		course.setDeptName(deptName);
		course.setCredit(credit);
		// Save Course to DB
		log.info("Creating Course");
		log.debug(describeCourse(course));
		ch.persist(course);
		return course;
	}
	
	public String describeCourse(Course course){
		String str = "Course ["+course.getCourseName()+"]:\r\n"+
					 "- Id ["+course.getId()+"]\r\n"+
					 "- Name: ["+course.getCourseName()+"]\r\n"+
					 "- Number: ["+course.getCourseNumber()+"]\r\n"+
					 "- Department: ["+course.getDeptName()+"]\r\n"+
					 "- Credit: ["+course.getCredit()+"]\r\n";
		return str;
	}
	
	public void deleteCourse(Integer id){
		// TODO: test this
		Course del = ch.findById(id); 
		ch.remove(del);
	}
	
	public Course findCourse(Integer id){
		// TODO: test this
		return ch.findById(id);
	}
	
	public boolean updateCourse(Integer id){
		// TODO: implement this
		return false;
	}
	
	public List<Course> getCourses(){
		// TODO: implement this
		return new ArrayList<Course>();
	}
	
	protected void validateCourse(String title, String deptName, Integer credit) throws InvalidCourseException {
		List<String> errors = new ArrayList<String>();
		if(deptName == null || deptName.length() < MIN_DEPT_NAME_LENGTH)
			errors.add(MIN_DEPT_NAME_ERROR);
		if(deptName.length() < MAX_DEPT_NAME_LENGTH)
			errors.add(MAX_DEPT_NAME_ERROR);
		if(MIN_CREDIT.compareTo(credit) > 0 || MAX_CREDIT.compareTo(credit) < 0)
			errors.add(CREDIT_ERROR);
		if(!errors.isEmpty()){
			throw new InvalidCourseException(errors);
		}
	}
}
