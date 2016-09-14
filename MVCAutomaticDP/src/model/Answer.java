package model;

public class Answer {

	private Question question;
	private String label;
	private int code;

	public Answer() {
		this.question = new Question();
		setLabel(null);
		setCode(0);
	}

	public Answer(Question question, String label, int code) {
		setQuestion(question);
		setLabel(label);
		setCode(code);
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
