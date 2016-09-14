package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;

public class Questionnaire {

	public enum Type {
		NONE, BRAND_TRACKING, CONCEPT_TEST, AD_TEST, INSIGHTS, PREDICTIVE_MARKET, PACK_TEST
	}

	private HashMap<String, Question> questionsMap;
	private int columnWidth = 4;
	private Type type;

	private File file;
	private FileInputStream inputFile;
	private StringBuilder logBuffer;

	public Questionnaire() {
		setQuestionsMap(new LinkedHashMap<String, Question>());
		setColumnWidth(4);
		setType(Type.NONE);
		setFile(null);
		setInputFile(null);
		setLogBuffer(new StringBuilder());
	}

	public Questionnaire(String fileName, int columnWidth, Type type) throws FileNotFoundException, IOException {
		setQuestionsMap(new LinkedHashMap<String, Question>());
		setColumnWidth(columnWidth);
		setType(type);
		setFile(new File(fileName));
		setInputFile(new FileInputStream(getFile()));
		setLogBuffer(new StringBuilder());

		loadQuestions();

	}

	private void loadQuestions() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(getInputFile());

		XSSFSheet questionsSheet = workbook.getSheet("Questions");
		XSSFSheet answersSheet = workbook.getSheet("Answers 1");

		setupQuestions(questionsSheet);
		setupAnswers(answersSheet);

		workbook.close();
	}

	private void setupQuestions(XSSFSheet questionsSheet) {

		Iterator<Row> questionRowIterator = questionsSheet.iterator();

		// Adding all questions in the hashmap

		while (questionRowIterator.hasNext()) {
			Row row = questionRowIterator.next();
			
			Cell questionIDCell = row.getCell(1);
			Cell labelCell = row.getCell(2);
			Cell codeCell = row.getCell(4);

			String questionID = getPrefix(questionIDCell);
			String label = clearText(labelCell);			

			Question question = getQuestionsMap().get(questionID);

			if (null == question) {
				question = new Question(questionID, label);
				logInfo("I'm adding question " + questionID + " : " + label);
			} else {
				int code = (int) codeCell.getNumericCellValue();;
				Answer answer = new Answer(question, label, code);
				question.addAnswer(answer);
				logInfo("I'm adding answer to " + questionID + " : " + answer.getLabel());
			}
			questionsMap.put(questionID, question);
		}
	}

	private void setupAnswers(XSSFSheet answersSheet) {
		Iterator<Cell> questionIDIterator = answersSheet.getRow(0).cellIterator();
		Iterator<Cell> typeIterator = answersSheet.getRow(1).cellIterator();
		Iterator<Cell> startColumnIterator = answersSheet.getRow(2).cellIterator();
		Iterator<Cell> headerIterator = answersSheet.getRow(3).cellIterator();

		while (typeIterator.hasNext()) {
			Cell questionIDCell = questionIDIterator.next();
			Cell typeCell = typeIterator.next();
			Cell columnCell = startColumnIterator.next();
			Cell headerCell = headerIterator.next();
			
			String questionID = getPrefix(questionIDCell);
			String header = getPrefix(headerCell);
			int startColumn = (int) columnCell.getNumericCellValue();
			int endColumn = startColumn + getColumnWidth() - 1;

			Question question = questionsMap.get(questionID);
			if (question != null) {
				if (question.getStartColumn() == 0) {
					question.setStartColumn(startColumn);
					question.setEndColumn(endColumn);
					question.setType(typeCell.toString());
					question.setHeader(header);
					logInfo("I'm configuring question " + questionID + " right now!");
				}
			} else {
				System.err.println("Unable to find the question with ID: " + questionID + "!");
			}
		}
	}

	private String clearText(Cell labelCell) {
		if (Cell.CELL_TYPE_NUMERIC == labelCell.getCellType())
			return Integer.toString((int) labelCell.getNumericCellValue());
		else {
			return Jsoup.parse(labelCell.toString()).text();			
		}
	}

	private static String getPrefix(Cell input) {
		if (input == null) {
			return "";
		}
		String cellValue = input.getStringCellValue();
		if (cellValue == null || cellValue.isEmpty()) {
			return "";
		}
		return cellValue.split("_")[0];
	}

	private void logInfo(String message) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss ");
		logBuffer.append(dateFormat.format(new Date()));
		logBuffer.append(message);
		logBuffer.append(System.getProperty("line.separator"));
	}

	public String getLog() {
		return logBuffer.toString();
	}

	public HashMap<String, Question> getQuestionsMap() {
		return questionsMap;
	}

	public void setQuestionsMap(HashMap<String, Question> questionsMap) {
		this.questionsMap = questionsMap;
	}

	public int getColumnWidth() {
		return columnWidth;
	}

	public void setColumnWidth(int columnWidth) {
		this.columnWidth = columnWidth;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public FileInputStream getInputFile() {
		return inputFile;
	}

	public void setInputFile(FileInputStream inputFile) {
		this.inputFile = inputFile;
	}

	public StringBuilder getLogBuffer() {
		return logBuffer;
	}

	public void setLogBuffer(StringBuilder logBuffer) {
		this.logBuffer = logBuffer;
	}

}
