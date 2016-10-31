package org.questionBank.controller;

import java.util.List;
import java.util.Map;

import org.questionBank.dao.CourseDataUtil;
import org.questionBank.dao.InvalidCourseException;
import org.questionBank.data.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CourseController {
	
	@Autowired
	CourseDataUtil courseDAO;

	// List
	@RequestMapping(value="/TeacherCourseView",method=RequestMethod.GET)
	public ModelAndView listCourses(){
		ModelAndView mve =  null;
		List<Map<String,Object>> courses = courseDAO.getDataForAllCourses();
		mve = new ModelAndView("views/courses/teachercourseview");
		mve.addObject("courses", courses);
		return mve;
	}

	// Create
	@RequestMapping(value="/TeacherAddCourse",method=RequestMethod.GET)
	public ModelAndView addCoursesView(){
		ModelAndView mve =  null;
		mve = new ModelAndView("views/courses/AddCourse");
		return mve;
	}

	@RequestMapping(value="/TeacherAddCourse",method=RequestMethod.POST)
	public ModelAndView createCourse(@RequestParam String courseName, @RequestParam String courseNumber,
									 @RequestParam String deptName, @RequestParam Integer credit){
		ModelAndView mve =  null;
		try {
			Course newCourse = courseDAO.createCourse(courseName, courseNumber, deptName, credit);
			mve=new ModelAndView("redirect:teacherdashboard.jsp");
			mve.addObject("course", newCourse);
		} catch (InvalidCourseException e) {
			mve=new ModelAndView("redirect:TeacherAddCourse");
			mve.addObject("message", e.getMessage());
		}
		return mve;
	}
	
	// Show
	@RequestMapping(value="/ShowCourse",method=RequestMethod.GET)
	public ModelAndView showCourse(@RequestParam("id") int id){
		ModelAndView mve = null;
		mve = new ModelAndView("views/courses/ShowCourse");
		Course c = courseDAO.findCourse(id);
		mve.addObject("course",c);
		return mve;
	}
	
	// Edit
	@RequestMapping(value="/EditCourse",method=RequestMethod.GET)
	public ModelAndView editCourse(@RequestParam("id") int id){
		ModelAndView mve = null;
		mve = new ModelAndView("views/courses/EditCourse");
		Course c = courseDAO.findCourse(id);
		try{
			courseDAO.validateCourse(c);
		}catch(InvalidCourseException ex){
			mve.addObject("errors", courseDAO.courseErrors(c));
		}
		mve.addObject("course",c);
		return mve;
	}

	@RequestMapping(value="/UpdateCourse",method=RequestMethod.POST)
	public ModelAndView updateCourse(@RequestParam Integer id, @RequestParam String courseName, 
									 @RequestParam String courseNumber,@RequestParam String deptName, 
									 @RequestParam Integer credit){
		ModelAndView mve =  null;
		try {
			courseDAO.updateCourse(id, courseName, courseNumber, deptName, credit);
			Course newCourse = courseDAO.findCourse(id);
			mve=new ModelAndView("redirect:ShowCourse?id="+id);
			mve.addObject("course", newCourse);
		} catch (InvalidCourseException e) {
			mve=new ModelAndView("redirect:EditCourse?id="+id);
		}
		return mve;
	}
	
}
