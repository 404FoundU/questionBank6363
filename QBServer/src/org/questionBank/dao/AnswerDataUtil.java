package org.questionBank.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.questionBank.data.Question;
import org.questionBank.data.QuestionHome;
import org.questionBank.data.Answer;
import org.questionBank.data.AnswerHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AnswerDataUtil {

	private static final Logger log = LogManager.getLogger(AnswerDataUtil.class);
	
	public AnswerDataUtil(){ }

	@Autowired
	private AnswerHome ah = new AnswerHome();
	
 private static String QUESTIONID_ERROR = "Invalid Question Selected.";
//	private static int MIN_CHAPTER_LENGTH = 1;
//	private static int MAX_CHAPTER_LENGTH = 7;
//	private static String MIN_CHAPTER_LENGTH_ERROR = "Question Chapter value must be at least "+MIN_CHAPTER_LENGTH+" characters long.";
//	private static String MAX_CHAPTER_LENGTH_ERROR = "Question Chapter value must be at most "+MAX_CHAPTER_LENGTH+" characters long.";
	private static int MIN_ANSWERTEXT_LENGTH = 4;
	private static int MAX_ANSWERTEXT_LENGTH = 256;
	private static String MIN_ANSWERTEXT_LENGTH_ERROR = "Answer must be at least "+MIN_ANSWERTEXT_LENGTH+" characters long.";
	private static String MAX_ANSWERTEXT_LENGTH_ERROR = "Answer must be at most "+MAX_ANSWERTEXT_LENGTH+" characters long.";
 
	public Answer createAnswer(Integer questionId,String answerText) throws InvalidAnswerException {
		
		Answer a = new Answer();
		//a.setId(id);
		a.setQuestionId(questionId);
		a.setAnswerText(answerText);

		validateAnswer(a);
		// Save Answer to DB
		log.info("Creating Answer");
		log.debug(describeAnswer(a));
		ah.persist(a);
		return a;
	}
	
	public String describeAnswer(Answer answer){
		String str = "Answer ["+answer.getId()+"]:\r\n";
		str += "- Id: ["+answer.getId()+"]\r\n";
		str += "- QuestionID: ["+answer.getQuestionId()+"]\r\n";
		str += "- Answer: ["+answer.getAnswerText()+"]\r\n";
		return str;
	}
	
public void deleteAnswer(Integer id){
		// TODO: test this
		Answer del = ah.findById(id); 
		ah.remove(del);
	}
	
	public Answer findAnswer(Integer id){
		// TODO: test this
	return ah.findById(id);
	}
	
	public List<Answer> findAnswersByQuestionId(Integer questionId){
		// TODO: test this
	return ah.findByQuestionId(questionId);
	}
	

	public boolean updateAnswer(Integer id,String answerText) throws InvalidAnswerException {
		try{
			Answer a = findAnswer(id);
//			a.setQuestionId(questionId);
			a.setAnswerText(answerText);
	//		a.setId(id);
			validateAnswer(a);
			ah.merge(a);
			return true;
		}catch(RuntimeException re){
			List<String> err = new ArrayList<String>();
			err.add(re.getMessage());
			throw new InvalidAnswerException(err);
		}
	}
	
	public List<Answer> getAnswer(){
		// TODO: implement this
		return new ArrayList<Answer>();
		
	}
	
	public List<Map<String,Object>> getDataForQuestionAnswers(Integer questionId){
		List<Answer> answers = ah.getAnswersForQuestion(questionId);
		return getAnswersData(answers);
	}
	
	public List<Map<String,Object>> getAnswersData(List<Answer> answers){
		List<Map<String,Object>> AnswerData = new ArrayList<Map<String,Object>>();
		for(Answer answer : answers){
			AnswerData.add(mapAnswer(answer));
		}
		return AnswerData;
	}
	
	public Map<String,Object> mapAnswer(Answer answer){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", answer.getId());
		map.put("questionId", answer.getQuestionId());
		map.put("answer", answer.getAnswerText());
		return map;
	}
	
	public List<String> answerErrors(Answer answer) {
		return getAnswerErrors(answer);
	}
	
	private List<String> getAnswerErrors(Answer answer){
		List<String> errors = new ArrayList<String>();
		
		if(answer.getQuestionId() == null)
		 errors.add(QUESTIONID_ERROR);
		//else if(question.getChapter().length() > MAX_CHAPTER_LENGTH)
		//	errors.add(MAX_CHAPTER_LENGTH_ERROR);
		if(answer.getAnswerText() == null || answer.getAnswerText().length() < MIN_ANSWERTEXT_LENGTH)
			errors.add(MIN_ANSWERTEXT_LENGTH_ERROR);
		else if(answer.getAnswerText().length() > MAX_ANSWERTEXT_LENGTH)
			errors.add(MAX_ANSWERTEXT_LENGTH_ERROR);
		return errors;
	}
	
	public void validateAnswer(Answer answer) throws InvalidAnswerException {
		List<String> errors = getAnswerErrors(answer);
		if(!errors.isEmpty()){
			throw new InvalidAnswerException(errors);
		}
	}
}
