package org.questionBank.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.questionBank.data.Course;
import org.questionBank.data.Question;
import org.questionBank.exception.InvalidCourseException;
import org.questionBank.home.CourseHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDataUtil {

	private static final Logger log = LogManager.getLogger(CourseDataUtil.class);
	
	public CourseDataUtil(){ }

	@Autowired
	private CourseHome ch = new CourseHome();
	
	// Validation
	private static int MIN_DEPT_NAME_LENGTH = 3;
	private static int MAX_DEPT_NAME_LENGTH = 8;
	private static String MIN_DEPT_NAME_ERROR = "Course Department Name value must be at least 3 characters long.";
	private static String MAX_DEPT_NAME_ERROR = "Course Department Name value must be at most 8 characters long.";
	private static Integer MIN_CREDIT = 0;
	private static Integer MAX_CREDIT = 5;
	private static String CREDIT_ERROR = "Course Credit value must be between 0.0 and 5.0.";
	private static int MIN_COURSE_NAME_LENGTH = 2;
	private static int MAX_COURSE_NAME_LENGTH = 64;
	private static String MIN_COURSE_NAME_ERROR = "Course Name value must be at least 2 characters long.";
	private static String MAX_COURSE_NAME_ERROR = "Course Name value must be at most 64 characters long.";
	private static int MIN_COURSE_NUMBER_LENGTH = 3;
	private static int MAX_COURSE_NUMBER_LENGTH = 4;
	private static String COURSE_NUMBER_ERROR = "Course Number value must be 3 or 4 digits long";
	private static String INVALID_PERSON_ID = "Invalid Person Id given";
	private static String INVALID_COURSE_ID = "Invalid Person Id given";
	
	public Course populateCourse(String courseName, String courseNumber, String deptName, Integer credit){
		Course course = new Course();
		course.setCourseNumber(courseNumber);
		course.setCourseName(courseName);
		course.setDeptName(deptName);
		course.setCredit(credit);
		return course;
	}

//	public Teaches assignTeacherToCourse(Integer userId, Integer courseId) throws InvalidTeachesException {
//		TeachesId tid = new TeachesId(userId, courseId);
//		validateTeachesId(tid);
//		Teaches teaches = new Teaches();
//		teaches.setId(tid);
//		return teaches;
//	}
	
	public Course createCourse(String courseName, String courseNumber, String deptName, Integer credit) throws InvalidCourseException {
		Course course = populateCourse(courseName, courseNumber, deptName, credit);
		validateCourse(course);
		// Save Course to DB
		log.info("Creating Course");
		log.debug(describeCourse(course));
		ch.persist(course);
		return course;
	}
//	
//	public Course createCourseForTeacher(Integer userId, String courseName, String courseNumber, String deptName, Integer credit) throws InvalidCourseException, InvalidTeachesException {
//		Course course = createCourse(courseName, courseNumber, deptName, credit);
//		Teaches teaches = assignTeacherToCourse(userId, course.getId());
//		// Save Teaches join to DB
//		log.info("Creating Teaches Association");
//		log.debug(describeTeaches(teaches));
//		th.persist(teaches);
//		return course;
//	}
	
	public String describeCourse(Course course){
		String str = "Course ["+course.getCourseName()+"]:\r\n";
		str += "- Id ["+course.getId()+"]\r\n";
		str += "- Name: ["+course.getCourseName()+"]\r\n";
		str += "- Number: ["+course.getCourseNumber()+"]\r\n";
		str += "- Department: ["+course.getDeptName()+"]\r\n";
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
		Course course = ch.findById(id);
		return course;
	}
	
	public boolean updateCourse(Integer id, String courseName, String courseNumber, String deptName, 
								Integer credit) throws InvalidCourseException {
		// TODO: implement this
		try{
			Course course = findCourse(id);
			course.setCourseName(courseName);
			course.setCourseNumber(courseNumber);
			course.setDeptName(deptName);
			course.setCredit(credit);
			validateCourse(course);
			ch.merge(course);
			return true;
		}catch(RuntimeException re){
			List<String> err = new ArrayList<String>();
			err.add(re.getMessage());
			throw new InvalidCourseException(err);
		}
	}
	
	public List<Course> getCourses(){
		// TODO: implement this
		return ch.getCourses();
		
	}
	
	public List<Map<String,Object>> getDataForAllCourses(){
		List<Course> courses = ch.getCourses();
		return getCoursesData(courses);
	}
	
	public List<Map<String, Object>> getDataForTeacherCourses(Integer userId){
		List<Course> courses = ch.getCoursesForPersonId(userId);
		return getCoursesData(courses);
	}
	
	public List<Map<String,Object>> getCoursesData(List<Course> courses){
		List<Map<String,Object>> coursesData = new ArrayList<Map<String,Object>>();
		for(Course course : courses){
			coursesData.add(mapCourse(course));
		}
		return coursesData;
	}
	
	public Map<String,Object> mapCourse(Course course){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", course.getId());
		map.put("courseNumber", course.getCourseNumber());
		map.put("courseName", course.getCourseName());
		map.put("deptName", course.getDeptName());
		map.put("credit", course.getCredit());
		return map;
	}
	
	public List<String> courseErrors(Course course) {
		return getCourseErrors(course);
	}
	
	private List<String> getCourseErrors(Course course){
		List<String> errors = new ArrayList<String>();
		if(course.getDeptName() == null || course.getDeptName().length() < MIN_DEPT_NAME_LENGTH)
			errors.add(MIN_DEPT_NAME_ERROR);
		if(course.getDeptName().length() > MAX_DEPT_NAME_LENGTH)
			errors.add(MAX_DEPT_NAME_ERROR);
		if(course.getCourseName() == null || course.getCourseName().length() < MIN_COURSE_NAME_LENGTH)
			errors.add(MIN_COURSE_NAME_ERROR);
		if(course.getCourseName().length() > MAX_COURSE_NAME_LENGTH)
			errors.add(MAX_COURSE_NAME_ERROR);
		if(course.getCourseNumber() == null || course.getCourseNumber().length() < MIN_COURSE_NUMBER_LENGTH || 
				course.getCourseNumber().length() > MAX_COURSE_NUMBER_LENGTH)
			errors.add(COURSE_NUMBER_ERROR);
		if(MIN_CREDIT.compareTo(course.getCredit()) > 0 || MAX_CREDIT.compareTo(course.getCredit()) < 0)
			errors.add(CREDIT_ERROR);
		return errors;
	}
	
	public void validateCourse(Course course) throws InvalidCourseException {
		List<String> errors = getCourseErrors(course);
		if(!errors.isEmpty()){
			throw new InvalidCourseException(errors);
		}
	}
}