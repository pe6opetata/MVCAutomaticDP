package model;

import java.io.BufferedWriter;
import java.io.IOException;

public class LabelFactory {
	

	public void writeGenderLabel(BufferedWriter writeToLabel, Question question) throws IOException {
		writeToLabel.write(question.getHeader().toUpperCase() + " " + question.getHeader().toUpperCase() + ". "
				+ "AGE & GENDER OF RESPONDENTS");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("AGE AGE GROUP");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("GENDER GENDER");
		writeToLabel.newLine();
		writeToLabel.flush();
		int i = 1;
		for (Answer answer : question.getAnswersList()) {
			writeToLabel.write("   " + i + " " + answer.getLabel());
			writeToLabel.newLine();
			writeToLabel.flush();
			i++;
		}
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();

	}

	public void writeAgeLabel(BufferedWriter writeToLabel, Question question) throws IOException {
		writeToLabel.write(question.getHeader().toUpperCase() + " " + question.getHeader().toUpperCase() + ". "
				+ "AGE OF RESPONDENTS - DETAILED");
		writeToLabel.newLine();
		writeToLabel.flush();
		int i = 1;
		for (Answer answer : question.getAnswersList()) {
			writeToLabel.write("   " + i + " " + answer.getLabel());
			writeToLabel.newLine();
			writeToLabel.flush();
			i++;
		}
		writeToLabel.write("   _99 Mean");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("   _98 Error Variance");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("   _97 Standard Error");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();

	}

	public void writeFTraceLabel(BufferedWriter writeToLabel, Question question) throws IOException {
		writeToLabel.write("C Things to be edited: FT1, FT2, <specify>, <question_name>, <question_name2>");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write(
				"FT1S <question_name2>. SUMMARY MEAN: DEGREE TO WHICH PEOPLE WOULD FEEL EMOTIONS (3=Strongly, 1=Not very strongly)");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _1 Surprise");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _2 Happy");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _3 Neutral");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _4 Sadness");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _5 Fear");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _6 Anger");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _7 Disgust");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _8 Contempt");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  12 Any Happiness/Surprise");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  22 Any positive");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  48 Any negative");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _99 Overall emotional intensity");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _98 Error Variance");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _97 Standard Error");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("S_FT1 \u0019 SUMMARY:");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write(
				"FT1 <question_name>. WHICH OF THESE FACES BEST EXPRESSES HOW YOU THINK PEOPLE WOULD FEEL ABOUT THIS <specify>?");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("EMOTION_T FACE TRACE");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("EMOT FACE TRACE");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  1 Surprise");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  2 Happy");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  3 Neutral");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  4 Sadness");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  5 Fear");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  6 Anger");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  7 Disgust");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  8 Contempt");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  12 Any Happiness/Surprise");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  22 Any positive");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  48 Any negative");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _99 Overall emotional intensity");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _98 Error Variance");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _97 Standard Error");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("S_FT2 \u0019 SUMMARY:");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write(
				"FT2_1 <question_name2>(1). DEGREE TO WHICH PEOPLE WOULD FEEL EMOTION ABOUT THIS <specify>: Surprise");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write(
				"FT2_2 <question_name2>(2). DEGREE TO WHICH PEOPLE WOULD FEEL EMOTION ABOUT THIS <specify>: Happiness");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write(
				"FT2_4 <question_name2>(4). DEGREE TO WHICH PEOPLE WOULD FEEL EMOTION ABOUT THIS <specify>: Sadness");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write(
				"FT2_5 <question_name2>(5). DEGREE TO WHICH PEOPLE WOULD FEEL EMOTION ABOUT THIS <specify>: Fear");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write(
				"FT2_6 <question_name2>(6). DEGREE TO WHICH PEOPLE WOULD FEEL EMOTION ABOUT THIS <specify>: Anger");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write(
				"FT2_7 <question_name2>(7). DEGREE TO WHICH PEOPLE WOULD FEEL EMOTION ABOUT THIS <specify>: Disgust");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write(
				"FT2_8 <question_name2>(8). DEGREE TO WHICH PEOPLE WOULD FEEL EMOTION ABOUT THIS <specify>: Contempt");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  1 A little (1.)");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  2 Moderately (2.)");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  3 A lot (3.)");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _99 Mean");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _98 Error Variance");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _97 Standard Error");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write(
				"FT2_3 <question_name2>(3). DEGREE TO WHICH PEOPLE WOULD FEEL EMOTION ABOUT THIS <specify>: Neutral");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  3 Slightly positive");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  2 Completely neutral");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  1 Slightly negative");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();

	}

	public void writeRatingLabel(BufferedWriter writeToLabel, Question question) throws IOException {
		int i = 1;
		writeToLabel.write(question.getHeader().toUpperCase() + " " + question.getHeader().toUpperCase()
				+ ". STANDARD RATINGS: MEANS SUMMARY - " + question.getLabel());
		writeToLabel.newLine();
		writeToLabel.flush();
		for (Answer answer : question.getAnswersList()) {
			writeToLabel.write("   _" + i + " " + answer.getLabel());
			writeToLabel.newLine();
			writeToLabel.flush();
			i++;
		}
		writeToLabel.newLine();
		writeToLabel.flush();

		i = 1;

		writeToLabel.write(question.getHeader().toUpperCase() + "I \u0019 " + question.getHeader().toUpperCase()
				+ "(i). STANDARD RATINGS: TOP BOX - " + question.getLabel());
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write(question.getHeader().toUpperCase() + "II " + question.getHeader().toUpperCase()
				+ "(ii). STANDARD RATINGS: SECOND BOX - " + question.getLabel());
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write(question.getHeader().toUpperCase() + "III " + question.getHeader().toUpperCase()
				+ "(iii). STANDARD RATINGS: TOP 2 BOX - " + question.getLabel());
		writeToLabel.newLine();
		writeToLabel.flush();
		for (Answer answer : question.getAnswersList()) {
			writeToLabel.write("   " + i + " " + answer.getLabel());
			writeToLabel.newLine();
			writeToLabel.flush();
			i++;
		}
		writeToLabel.write("   99 None of these");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();

		i = 1;

		writeToLabel.write("S_" + question.getHeader().toUpperCase() + " \u0019 " + "SUMMARY:");
		writeToLabel.newLine();
		writeToLabel.flush();
		for (Answer answer : question.getAnswersList()) {
			writeToLabel.write(question.getHeader().toUpperCase() + "_" + i + " " + question.getHeader().toUpperCase()
					+ "(" + i + "). STANDARD RATINGS: " + answer.getLabel());
			writeToLabel.newLine();
			writeToLabel.flush();
			i++;
		}
		writeToLabel.write("  1 -3 Very negative (-3.)");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  2 -2 .. (-2.)");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  3 -1 .. (-1.)");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  4 0 Neutral (0.)");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  5 +1 .. (1.)");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  6 +2 .. (2.)");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  7 +3 Very positive (3.)");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  77 Top box");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  67 Top 2 box");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  345 Middle 3 box");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  12 Bottom 2 box");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  15 Other");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _99 Mean");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _98 Error Variance");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("  _97 Standard Error");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();

	}

	public void writeMultiLabel(BufferedWriter writeToLabel, Question question) throws IOException {
		writeToLabel.write(question.getHeader().toUpperCase() + " " + question.getHeader().toUpperCase() + ". "
				+ question.getLabel().toUpperCase());
		writeToLabel.newLine();
		writeToLabel.flush();
		int i = 1;
		for (Answer answer : question.getAnswersList()) {
			writeToLabel.write("   " + i + " " + answer.getLabel());
			writeToLabel.newLine();
			writeToLabel.flush();
			i++;
		}

		writeToLabel.write("   _99 Average number of mentions");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("   _98 Error Variance");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("   _97 Standard Error");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();

	}

	public void writeSingleLabel(BufferedWriter writeToLabel, Question question) throws IOException {
		writeToLabel.write(question.getHeader().toUpperCase() + " " + question.getHeader().toUpperCase() + ". "
				+ question.getLabel().toUpperCase());
		writeToLabel.newLine();
		writeToLabel.flush();
		int i = 1;
		for (Answer answer : question.getAnswersList()) {
			writeToLabel.write("   " + i + " " + answer.getLabel());
			writeToLabel.newLine();
			writeToLabel.flush();
			i++;
		}
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();

	}

	public void endLabel(BufferedWriter writeToLabel) throws IOException {
		writeToLabel.write("TOT TOTAL");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("T_W TOTAL");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("TOTAL Base: All respondents");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("T_NW2 Base: All respondents");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("T_FACE Base: All ratings");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("T_TWO Base: Two ideas rated");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("T_SEEN Base: All seeing each idea");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("T_FT2_1 Base: All who feel emotion: Surprise");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("T_FT2_2 Base: All who feel emotion: Happiness");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("T_FT2_3 Base: All who feel emotion: Neutral");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("T_FT2_4 Base: All who feel emotion: Sadness");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("T_FT2_5 Base: All who feel emotion: Fear");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("T_FT2_6 Base: All who feel emotion: Anger");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("T_FT2_7 Base: All who feel emotion: Disgust");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("T_FT2_8 Base: All who feel emotion: Contempt");
		writeToLabel.newLine();
		writeToLabel.flush();

	}

	public void startLabel(BufferedWriter writeToLabel) throws IOException {
		writeToLabel.write("CROSS ANALYSIS OF BREAKS");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("WEIGHTS WEIGHTING VARIABLES");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("TWOSHAPES \u0019 THOSE RATING THE IDEA AS ONE TO SELL OR DOUBLE SHARES IN ");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("IDEAS ALL SEEING EACH IDEA");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("SELLSHARE THOSE RATING IDEA AS ONE TO SELL SHARE IN");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("DOUBLESHARE THOSE RATING IDEA AS ONE TO DOUBLE SHARE IN");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("CONCEPT CONCEPT MOST PREFERED");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("FACE_TT FACE TRACE SUMMARY");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("SUMMARY_PRODUCT1 Autocharting Summary Table");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("SUMMARY_PRODUCT2 Norms Summary");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.write("IDEASEEN ALL SEEING EACH IDEA");
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();
		writeToLabel.newLine();
		writeToLabel.flush();

	}


}
