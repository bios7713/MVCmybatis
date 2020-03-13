package Model.DTO;

import java.io.Serializable;
@SuppressWarnings("serial")
public class QuestionOption implements Serializable {
	
	String question;
	String option;
	
	
	
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}

	
}
