package org.questionBank.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.questionBank.dao.CourseDataUtil;
import org.questionBank.dao.InvalidCourseException;
import org.questionBank.dao.QuestionDataUtil;
import org.questionBank.dao.AnswerDataUtil;
import org.questionBank.data.Answer;
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
	@Autowired
	QuestionDataUtil questionDAO;
	@Autowired
	AnswerDataUtil answerDAO;

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
	public ModelAndView addCoursesView(@RequestParam(required=false) String courseName, @RequestParam(required=false) String courseNumber,
			 @RequestParam(required=false) String deptName, @RequestParam(required=false) Integer credit){
		ModelAndView mve =  null;
		Course c = null;
		if(courseName != null || courseNumber != null || deptName != null || credit != null){
			c = new Course(courseName, courseNumber, deptName, credit);
		}
		mve = new ModelAndView("views/courses/AddCourse");
		if(c != null){
			mve.addObject("course", c);
			mve.addObject("errors", courseDAO.courseErrors(c));
		}
		return mve;
	}

	@RequestMapping(value="/TeacherAddCourse",method=RequestMethod.POST)
	public ModelAndView createCourse(HttpServletRequest request, @RequestParam String courseName, @RequestParam String courseNumber,
									 @RequestParam String deptName, @RequestParam Integer credit){
		ModelAndView mve =  null;
		try {
			HttpSession s = request.getSession();
			Object uid = s.getAttribute("userId");
			Course newCourse;
			if(uid != null){
				Integer userId = (Integer) uid;
				newCourse = courseDAO.createCourseForTeacher(userId, courseName, courseNumber, deptName, credit);
			}else{
				newCourse = courseDAO.createCourse(courseName, courseNumber, deptName, credit);
			}
			mve=new ModelAndView("redirect:ShowCourse?id="+newCourse.getId());
			mve.addObject("course", newCourse);
		} catch (InvalidCourseException e) {
			mve=new ModelAndView("redirect:TeacherAddCourse");
			mve.addObject("courseName", courseName);
			mve.addObject("courseNumber", courseNumber);
			mve.addObject("deptName", deptName);
			mve.addObject("credit", credit);
		}
		return mve;
	}
	
	// Show
	@RequestMapping(value="/ShowCourse",method=RequestMethod.GET)
	public ModelAndView showCourse(@RequestParam("id") int id){
		ModelAndView mve = null;
		mve = new ModelAndView("views/courses/ShowCourse");
		Course c = courseDAO.findCourse(id);
		
		List<Map<String,Object>> questions = questionDAO.getDataForCourseQuestions(c.getId());
		for(Map<String,Object> question : questions)
		{
			Object qid = question.get("id");
			if(qid != null && (qid instanceof Integer) )
			{
				int questionId = (Integer)qid;
				List<Answer> answers = answerDAO.findAnswersByQuestionId(questionId);
				if(answers.isEmpty())
				{
					question.put("answer", "");
				}
				else if(answers.size() > 1)
				{ 
					question.put("answer", "Multiple Answers");
				}
				else
				{ 
					Answer a = answers.get(0);
					question.put("answer", a.getAnswerText());
				}
			}
   			    
			
				
			
		}
		
		
		mve.addObject("course",c);
		mve.addObject("questions",questions);
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
