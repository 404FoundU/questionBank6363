package org.questionBank.controller;

import org.questionBank.dao.QuestionDataUtil;
import org.questionBank.data.Answer;
import org.questionBank.data.Course;
import org.questionBank.data.Question;
import org.questionBank.exception.InvalidAnswerException;
import org.questionBank.exception.InvalidQuestionException;

import java.util.List;

import org.questionBank.dao.AnswerDataUtil;
import org.questionBank.dao.CourseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class QuestionController {
	
	@Autowired
	QuestionDataUtil questionDAO;
	@Autowired
	AnswerDataUtil answerDAO;
	@Autowired
	CourseDataUtil courseDAO;

	// Create
	@RequestMapping(value="/CourseAddQuestion",method=RequestMethod.GET)
	public ModelAndView addQuestionView(@RequestParam(required=false) Integer courseId, @RequestParam(required=false) String question,
										@RequestParam(required=false) String chapter){
		ModelAndView mve =  null;
		Course course = null;
		if(courseId!=null)
		{
	    	course = courseDAO.findCourse(courseId);
		}
		
		Question q = questionDAO.populateQuestion(course, question, chapter);
		mve = new ModelAndView("views/questions/AddQuestion");
		mve.addObject("question", q);
		if(question != null || chapter != null){
			mve.addObject("errors", questionDAO.questionErrors(q));
		}
		List<Course> courses = courseDAO.getCourses();
		mve.addObject("courses", courses);
		return mve;
	}

		
	@RequestMapping(value="/CourseAddQuestion",method=RequestMethod.POST)
	public ModelAndView createQuestion(@ModelAttribute("question") Question que, @RequestParam(required=false) Integer courseId, @RequestParam(required=false) String question,
										@RequestParam(required=false) String chapter,@RequestParam(required=false) String answerText){
		ModelAndView mve =  null;
		try {
			//Course course = null;
			//if(courseId!=null)
			//{
			//course = courseDAO.findCourse(courseId); 
			//}
			//else
			//{
			//Course course = courseDAO.findCourse(que.getId());	
			Question newQuestion = questionDAO.createQuestion(que);
			Answer newAnswer = answerDAO.createAnswer(newQuestion,answerText);
			mve=new ModelAndView("redirect:ShowQuestion?id="+newQuestion.getId());
			mve.addObject("question", newQuestion);
			mve.addObject("answer",newAnswer);
		} 
		catch (InvalidQuestionException qe) {
			mve=new ModelAndView("redirect:TeacherAddCourse");
			mve.addObject("courseId", courseId);
			mve.addObject("question", question);
			mve.addObject("chapter", chapter);
			mve.addObject("answerText", answerText);
		}
		catch (InvalidAnswerException ae) {
			mve=new ModelAndView("redirect:TeacherAddCourse");
			mve.addObject("courseId", courseId);
			mve.addObject("question", question);
			mve.addObject("chapter", chapter);
			mve.addObject("answerText", answerText);		}
		return mve;
	}

	
	
	// Show
	@RequestMapping(value="/ShowQuestion",method=RequestMethod.GET)
	public ModelAndView showQuestion(@RequestParam("id") int id){
		ModelAndView mve = null;
		mve = new ModelAndView("views/questions/ShowQuestion");
		Question q = questionDAO.findQuestion(id);
		List<Answer> answers = answerDAO.findAnswersByQuestionId(q.getId());
		Answer a = null;
		if(answers.isEmpty())
		{
			a = new Answer();
		}
		else
		{
			a = answers.get(0);
		}
		
		mve.addObject("question",q);
		mve.addObject("answer",a);
		mve.addObject("errors", questionDAO.questionErrors(q));
		return mve;
	}
	
	// Edit
	@RequestMapping(value="/EditQuestion",method=RequestMethod.GET)
	public ModelAndView editQuestion(@RequestParam("id") int id,@RequestParam("answerId") int answerId){
		ModelAndView mve = null;
		mve = new ModelAndView("views/questions/EditQuestion");
		Question q = questionDAO.findQuestion(id);
		Answer a = answerDAO.findAnswer(answerId);
		try{
			questionDAO.validateQuestion(q);
			answerDAO.validateAnswer(a);
		}catch(InvalidQuestionException ex){
			mve.addObject("errors", questionDAO.questionErrors(q));
		}
		catch(InvalidAnswerException ex){
			mve.addObject("errors", answerDAO.answerErrors(a));
		}
		List<Course> courses = courseDAO.getCourses();
		mve.addObject("question",q);
		mve.addObject("answer",a);
		mve.addObject("courses", courses);
		return mve;
	}

	@RequestMapping(value="/UpdateQuestion",method=RequestMethod.POST)
	public ModelAndView updateQuestion(@ModelAttribute("question") Question question, @RequestParam(required=false) Integer answerId, @RequestParam(required=false) String answerText){
		ModelAndView mve =  null;
		try {
			questionDAO.updateQuestion(question);
			answerDAO.updateAnswer(answerId, answerText);
			Answer newAnswer = answerDAO.findAnswer(answerId);
			mve=new ModelAndView("redirect:ShowQuestion?id="+question.getId());
			mve.addObject("question", question);
			mve.addObject("answer", newAnswer);
		} catch (InvalidQuestionException e) {
			mve=new ModelAndView("redirect:EditQuestion?id="+question.getId()+"&answerId="+answerId);
		}
		catch (InvalidAnswerException ex) {
			mve=new ModelAndView("redirect:EditQuestion?id="+question.getId()+"&answerId="+answerId);
		}
		return mve;
	}

}
