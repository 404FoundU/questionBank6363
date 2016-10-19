package org.questionBank.data;
// Generated Oct 18, 2016 9:47:48 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Answer generated by hbm2java
 */
@Entity
@Table(name = "Answer", catalog = "questionbank")
public class Answer implements java.io.Serializable {

	private Integer id;
	private Integer questionId;
	private String answerText;

	public Answer() {
	}

	public Answer(Integer questionId, String answerText) {
		this.questionId = questionId;
		this.answerText = answerText;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "question_id")
	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
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
