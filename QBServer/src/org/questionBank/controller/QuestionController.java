package org.questionBank.controller;

import org.questionBank.dao.InvalidQuestionException;
import org.questionBank.dao.QuestionDataUtil;
import org.questionBank.data.Question;

import org.questionBank.dao.InvalidAnswerException;

import java.util.List;

import org.questionBank.dao.AnswerDataUtil;
import org.questionBank.data.Answer;

import org.springframework.beans.factory.annotation.Autowired;
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

	// Create
	@RequestMapping(value="/CourseAddQuestion",method=RequestMethod.GET)
	public ModelAndView addQuestionView(@RequestParam(required=false) Integer courseId, @RequestParam(required=false) String question,
										@RequestParam(required=false) String chapter){
		ModelAndView mve =  null;
		Question q = null;
		q = new Question(courseId, question, chapter);
		mve = new ModelAndView("views/questions/AddQuestion");
		mve.addObject("question", q);
		if(question != null || chapter != null){
			mve.addObject("errors", questionDAO.questionErrors(q));
		}
		return mve;
	}

		
	@RequestMapping(value="/CourseAddQuestion",method=RequestMethod.POST)
	public ModelAndView createQuestion(@RequestParam(required=false) Integer courseId, @RequestParam(required=false) String question,
										@RequestParam(required=false) String chapter,@RequestParam(required=false) String answerText){
		ModelAndView mve =  null;
		try {
			Question newQuestion = questionDAO.createQuestion(courseId, question, chapter);
			Answer newAnswer = answerDAO.createAnswer(newQuestion.getId(),answerText);
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
	public ModelAndView editQuestion(@RequestParam("id") int id){
		ModelAndView mve = null;
		mve = new ModelAndView("views/questions/EditQuestion");
		Question q = questionDAO.findQuestion(id);
		try{
			questionDAO.validateQuestion(q);
		}catch(InvalidQuestionException ex){
			mve.addObject("errors", questionDAO.questionErrors(q));
		}
		mve.addObject("question",q);
		return mve;
	}

	@RequestMapping(value="/UpdateQuestion",method=RequestMethod.POST)
	public ModelAndView updateQuestion(@RequestParam Integer id, @RequestParam(required=false) Integer courseId, 
			@RequestParam(required=false) String question, @RequestParam(required=false) String chapter){
		ModelAndView mve =  null;
		try {
			questionDAO.updateQuestion(id, courseId, question, chapter);
			Question newQuestion = questionDAO.findQuestion(id);
			mve=new ModelAndView("redirect:ShowQuestion?id="+id);
			mve.addObject("question", newQuestion);
		} catch (InvalidQuestionException e) {
			mve=new ModelAndView("redirect:EditQuestion?id="+id);
		}
		return mve;
	}

}
