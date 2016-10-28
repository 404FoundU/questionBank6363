package org.questionBank.data;
// Generated Oct 9, 2016 11:50:10 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Answer generated by hbm2java
 */
@Entity
@Table(name = "Answer", catalog = "questionbank")
public class Answer implements java.io.Serializable {

	private String answerId;
	private String questionId;
	private String answerText;

	public Answer() {
	}

	public Answer(String answerId) {
		this.answerId = answerId;
	}

	public Answer(String answerId, String questionId, String answerText) {
		this.answerId = answerId;
		this.questionId = questionId;
		this.answerText = answerText;
	}

	@Id

	@Column(name = "answer_id", unique = true, nullable = false, length = 7)
	public String getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	@Column(name = "question_id", length = 7)
	public String getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	@Column(name = "answer_text", length = 200)
	public String getAnswerText() {
		return this.answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

}