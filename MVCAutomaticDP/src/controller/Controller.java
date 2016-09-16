package controller;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Question;
import model.HighliterFactory;
import model.LabelFactory;
import model.OsiFactory;
import model.Questionnaire;
import model.Questionnaire.Type;
import view.AppFrame;

public class Controller {

	private static final String OSI = "osi.axs";
	private static final String LABELS = "label.lab";
	private static final String HIGHLITERS = "highliters.lab";

	private AppFrame appFrame;
	private Questionnaire baseQuestionnaire;

	public void start() {
		appFrame = new AppFrame(this);
		baseQuestionnaire = new Questionnaire();
	}

	public boolean makeQuestionnaire(String filePath, int colWidth) {
		boolean madeQuestionnaire = false;

		try {
			baseQuestionnaire = new Questionnaire(filePath, colWidth, Type.NONE);
			madeQuestionnaire = true;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(appFrame, "Couldn't make the questionnaire");
		}

		return madeQuestionnaire;
	}

	public void exportFiles() throws IOException, InvalidFormatException {
		FileOutputStream highliters = new FileOutputStream(baseQuestionnaire.getFile().getParent() + "//" + HIGHLITERS);
		FileOutputStream osi = new FileOutputStream(baseQuestionnaire.getFile().getParent() + "//" + OSI);
		FileOutputStream label = new FileOutputStream(baseQuestionnaire.getFile().getParent() + "//" + LABELS);

		BufferedWriter writeToHighliter = new BufferedWriter(new OutputStreamWriter(highliters, "UTF-8"));
		BufferedWriter writeToOsi = new BufferedWriter(new OutputStreamWriter(osi, "UTF-8"));
		BufferedWriter writeToLabel = new BufferedWriter(new OutputStreamWriter(label, "UTF-8"));

		writeToOsi(writeToOsi);
		writeToLabels(writeToLabel);
		writeToHighliters(writeToHighliter);

		// logInfo("Processing file " + baseQuestionnaire.getFile().getAbsolutePath() + "...");

	}

	private void writeToHighliters(BufferedWriter writeToHighliter) throws InvalidFormatException, IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook(baseQuestionnaire.getFile());
		XSSFSheet questions = workbook.getSheet("Questions");
		Iterator<Row> questionRowIterator = questions.iterator();
		HighliterFactory factory = new HighliterFactory();
	
		while (questionRowIterator.hasNext()) {
			Row row = questionRowIterator.next();
			Cell label = row.getCell(2);
			factory.makeHighliters(writeToHighliter, label);
		
		}
		workbook.close();
	}

	private void writeToLabels(BufferedWriter writeToLabel) throws IOException {
		LabelFactory factory = new LabelFactory();
		factory.startLabel(writeToLabel);

		for (Question question : baseQuestionnaire.getQuestionsMap().values()) {
			if (question.getAnswersList() != null && !question.getAnswersList().isEmpty() && null != question.getHeader()) {
				if (isQuestionOfType("dropdown", question))
					factory.writeSingleLabel(writeToLabel, question);
				else if (isQuestionOfType("radiobutton", question))
					factory.writeSingleLabel(writeToLabel, question);
				else if (isQuestionOfType("checkbox", question))
					factory.writeMultiLabel(writeToLabel, question);
				else if (isQuestionOfType("rating", question))
					factory.writeRatingLabel(writeToLabel, question);
				else if (isQuestionOfType("facetrace", question))
					factory.writeFTraceLabel(writeToLabel, question);
				else if (isQuestionOfType("age", question))
					factory.writeAgeLabel(writeToLabel, question);
				else if (isQuestionOfType("gender", question))
					factory.writeGenderLabel(writeToLabel, question);
				else 
					factory.writeSingleLabel(writeToLabel, question);
			}
		}

		factory.endLabel(writeToLabel);

	}

	private void writeToOsi(BufferedWriter writeToOsi) throws IOException {
		OsiFactory factory = new OsiFactory();
		factory.startOsi(writeToOsi);
		for (Question question : baseQuestionnaire.getQuestionsMap().values()) {
			if (question.getAnswersList() != null && !question.getAnswersList().isEmpty()) {
				if (isQuestionOfType("dropdown", question))
					factory.writeSingleQuestion(writeToOsi, question);
				if (isQuestionOfType("radiobutton", question))
					factory.writeSingleQuestion(writeToOsi, question);
				if (isQuestionOfType("checkbox", question))
					factory.writeMultiQuestion(writeToOsi, question);
				if (isQuestionOfType("rating", question))
					factory.writeRatingQuestion(writeToOsi, question);
				if (isQuestionOfType("facetrace", question))
					factory.writeFTraceQuestion(writeToOsi, question);
				if (isQuestionOfType("age", question))
					factory.writeAgeQuestion(writeToOsi, question);
				if (isQuestionOfType("gender", question))
					factory.writeGenderQuestion(writeToOsi, question);
			}
		}

	}



	private static boolean isQuestionOfType(String questionType, Question question) {
		return questionType != null && question != null && questionType.equals(question.getType());
	}

	

	public Questionnaire getBaseQuestionnaire() {
		return baseQuestionnaire;
	}

	public void setBaseQuestionnaire(Questionnaire baseQuestionnaire) {
		this.baseQuestionnaire = baseQuestionnaire;
	}

}
