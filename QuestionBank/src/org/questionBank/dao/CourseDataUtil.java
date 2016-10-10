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
	private static int TITLE_LENGTH = 3;
	private static String TITLE_ERROR = "Course Title value must be at least 3 characters long.";
	private static int DEPT_NAME_LENGTH = 3;
	private static String DEPT_NAME_ERROR = "Course Department Name value must be at least 3 characters long.";
	private static Integer MIN_CREDIT = 0;
	private static Integer MAX_CREDIT = 5;
	private static String CREDIT_ERROR = "Course Credit value must be between 0.0 and 5.0.";

	public Course createCourse(String courseNumber, String courseName, String title, String deptName, Integer credit) throws InvalidCourseException {
		Course course = new Course();
		validateCourse(title, deptName, credit);
		course.setCourseNumber(courseNumber);
		course.setCourseName(courseName);
		course.setTitle(title);
		course.setDeptName(deptName);
		course.setCredit(credit);
		// Save Course to DB
		log.info("Creating Course");
		log.debug(describeCourse(course));
		ch.persist(course);
		return course;
	}
	
	public String describeCourse(Course course){
		String str = "Course ["+course.getCourseName()+"]:\r\n";
		str += "- Id ["+course.getId()+"]\r\n";
		str += "- Name: ["+course.getCourseName()+"]\r\n";
		str += "- Number: ["+course.getCourseNumber()+"]\r\n";
		str += "- Department: ["+course.getDeptName()+"]\r\n";
		str += "- Title: ["+course.getTitle()+"]\r\n";
		str += "- Credit: ["+course.getCredit()+"]\r\n";
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
