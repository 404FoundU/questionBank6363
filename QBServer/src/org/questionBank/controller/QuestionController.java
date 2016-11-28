package org.questionBank.controller;

import org.questionBank.dao.QuestionDataUtil;
import org.questionBank.data.Answer;
import org.questionBank.data.Course;
import org.questionBank.data.Question;
import org.questionBank.exception.InvalidAnswerException;
import org.questionBank.exception.InvalidQuestionException;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value="/ViewQuestion",method=RequestMethod.GET)
	public ModelAndView viewQuestion(@RequestParam("id") int id){
		ModelAndView mve = null;
		mve = new ModelAndView("views/questions/ViewQuestion");
		Course c = courseDAO.findCourse(id);
		List<Map<String,Object>> questions = questionDAO.getDataForCourseQuestions(c);
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
					question.put("answerId", a.getId());
				}
			}
		}
		
		mve.addObject("course",c);
		mve.addObject("questions",questions);
		return mve;
	}
	
	@RequestMapping(value="/TeacherQuestionView",method=RequestMethod.GET)
		public ModelAndView listCourses(HttpServletRequest request){
			ModelAndView mve =  null;
			HttpSession s = request.getSession();
			Object uid = s.getAttribute("userId");
			if(uid != null){
				Integer userId = (Integer) uid;
				List<Map<String,Object>> courses = courseDAO.getDataForTeacherCourses(userId);
				mve = new ModelAndView("views/questions/teacherquestionview");
				/*Question q = questionDAO.findQuestion(courses.get(0)));
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
				mve.addObject("errors", questionDAO.questionErrors(q)); */
				mve.addObject("courses", courses);
				return mve;
			}else{
				mve = new ModelAndView("index");
				mve.addObject("message", "Invalid User ID for Session");
				return mve;
			}
		}
		
	   // @RequestMapping(value="/TeacherQuestionView",method=RequestMethod.GET)
		//public ModelAndView viewQuestions(@RequestParam("courseId") int id){
			//ModelAndView mve = null;
			//mve = new ModelAndView("views/questions/teacherquestionview");
			//Question q = questionDAO.findQuestion(id);
			//List<Answer> answers = answerDAO.findAnswersByQuestionId(q.getId());
			//Answer a = null;
			//if(answers.isEmpty())
			//{
				//a = new Answer();
			//}
			//else
			//{
				//a = answers.get(0);
			//}
			
			//mve.addObject("question",q);
			//mve.addObject("answer",a); 
			//mve.addObject("errors", questionDAO.questionErrors(q));
			//return mve;
		//}
		
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
