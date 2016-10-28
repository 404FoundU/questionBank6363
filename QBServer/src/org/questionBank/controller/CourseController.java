package org.questionBank.controller;

import java.util.List;
import java.util.Map;

import org.questionBank.dao.CourseDataUtil;
import org.questionBank.dao.InvalidCourseException;
import org.questionBank.data.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
			@RequestParam String title, @RequestParam String deptName, @RequestParam Integer credit){
		ModelAndView mve =  null;
		try {
			Course newCourse = courseDAO.createCourse(courseName, courseNumber, title, deptName, credit);
			mve=new ModelAndView("redirect:teacherdashboard.jsp");
			mve.addObject("course", newCourse);
		} catch (InvalidCourseException e) {
			mve=new ModelAndView("redirect:TeacherAddCourse");
			mve.addObject("message", e.getMessage());
		}
		return mve;
	}
	
	// Show
	@RequestMapping(value="/ShowCourse/{courseId}",method=RequestMethod.GET)
	public ModelAndView showCourse(@PathVariable("courseId") Integer courseId){
		ModelAndView mve = null;
		mve = new ModelAndView("views/courses/ShowCourse");
		Course c = courseDAO.findCourse(courseId);
		mve.addObject("course",c);
		return mve;
	}
	
	// Edit
	@RequestMapping(value="/EditCourse/{courseId}",method=RequestMethod.GET)
	public ModelAndView editCourse(@PathVariable("courseId") Integer courseId){
		ModelAndView mve = new ModelAndView("views/courses/EditCourse");
		Course c = courseDAO.findCourse(courseId);
		mve.addObject("course",c);
		return mve;
	}
	
}
