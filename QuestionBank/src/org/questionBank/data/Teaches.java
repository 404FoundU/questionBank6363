package org.questionBank.data;
// Generated Oct 22, 2016 8:25:50 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Teaches generated by hbm2java
 */
@Entity
@Table(name = "Teaches", catalog = "questionbank")
public class Teaches implements java.io.Serializable {

	private TeachesId id;

	public Teaches() {
	}

	public Teaches(TeachesId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "perId", column = @Column(name = "per_id", nullable = false)),
			@AttributeOverride(name = "courseId", column = @Column(name = "course_id", nullable = false)) })
	public TeachesId getId() {
		return this.id;
	}

	public void setId(TeachesId id) {
		this.id = id;
	}

}
