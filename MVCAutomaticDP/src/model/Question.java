package model;

import java.util.ArrayList;
import java.util.List;

import model.Answer;

public class Question {

	private String uniqueID;
	private String header;
	private String label;
	private String type;
	private int startColumn;
	private int endColumn;
	private List<Answer> answersList;

	public Question() {
		setUniqueID(null);
		setHeader(null);
		setLabel(null);
		setType(null);
		setStartColumn(0);
		setEndColumn(0);
		answersList = new ArrayList<Answer>();
	}
	
	public Question(String uniqueID, String label) {
		setUniqueID(uniqueID);
		setHeader(null);
		setLabel(label);
		setType(null);
		setStartColumn(0);
		setEndColumn(0);
		answersList = new ArrayList<Answer>();
	}

	public void addAnswer(Answer answer) {
		this.answersList.add(answer);
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStartColumn() {
		return startColumn;
	}

	public void setStartColumn(int startColumn) {
		this.startColumn = startColumn;
	}

	public int getEndColumn() {
		return endColumn;
	}

	public void setEndColumn(int endColumn) {
		this.endColumn = endColumn;
	}

	public List<Answer> getAnswersList() {
		return answersList;
	}

	public void setAnswersList(List<Answer> answersList) {
		this.answersList = answersList;
	}

}
