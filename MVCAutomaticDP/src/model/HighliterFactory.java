package model;

import java.io.BufferedWriter;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.jsoup.Jsoup;

public class HighliterFactory {
	
	public void makeHighliters(BufferedWriter writeToHighliter, Cell label) throws IOException {
		if (label.toString().contains("div id=\"textHighlighter")) {
			String[] nums = label.toString().split("\\D+");
			int num = Integer.parseInt(nums[1]);
			String clearedLabel = label.toString().replaceAll("<[^>]+>", "");
			String[] words = clearedLabel.split("#\\|#");
			if (num == 1) {
				writeToHighliter.write("HIGHLIGHTER HIGHLIGHTER");
				writeToHighliter.newLine();
				writeToHighliter.flush();
				writeToHighliter.write("  1 LIKE");
				writeToHighliter.newLine();
				writeToHighliter.flush();
				writeToHighliter.write("  2 DISLIKE");
				writeToHighliter.newLine();
				writeToHighliter.flush();
				writeToHighliter.newLine();
				writeToHighliter.flush();
				writeToHighliter.newLine();
				writeToHighliter.flush();
			}
			writeToHighliter.write("HGLTR_" + num + "SUM \u0019 &qst(" + num + "). TEXT HIGHLIGHTER SUMMARY - \"\"");
			writeToHighliter.newLine();
			writeToHighliter.flush();
			writeToHighliter.write("HGLTR_" + num + "A &qst(" + num + "). TEXT HIGHLIGHTER: Marked as LIKE - \"\"");
			writeToHighliter.newLine();
			writeToHighliter.flush();
			writeToHighliter.write("HGLTR_" + num + "B &qst(" + num + "). TEXT HIGHLIGHTER: Marked as DISLIKE - \"\"");
			writeToHighliter.newLine();
			writeToHighliter.flush();
			writeToHighliter.write("SUM_HGLTR_" + num + " SUMMARY");
			writeToHighliter.newLine();
			writeToHighliter.flush();
			int i = 1;
			for (String word : words) {
				writeToHighliter.write("   " + i++ + " " + Jsoup.parse(word).text());
				writeToHighliter.newLine();
				writeToHighliter.flush();
			}
			writeToHighliter.write("   98 None of these");
			writeToHighliter.newLine();
			writeToHighliter.flush();
			writeToHighliter.write("   99 Any");
			writeToHighliter.newLine();
			writeToHighliter.flush();
			writeToHighliter.write("   _89 Average number of mentions");
			writeToHighliter.newLine();
			writeToHighliter.flush();
			writeToHighliter.write("   _88 Error Variance");
			writeToHighliter.newLine();
			writeToHighliter.flush();
			writeToHighliter.write("   _87 Standard Error");
			writeToHighliter.newLine();
			writeToHighliter.flush();
			writeToHighliter.newLine();
			writeToHighliter.flush();

		}

	}

}
