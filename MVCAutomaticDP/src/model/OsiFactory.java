package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class OsiFactory {
	

	public void writeGenderQuestion(BufferedWriter writeToOsi, Question question) throws IOException {
		writeToOsi.write("l " + question.getHeader());
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("ttl " + question.getHeader());
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("ttl TOTAL");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("C n10  T_NW   ;wm=0");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n10 TOT");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n03 AGE");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n03 GENDER");
		writeToOsi.newLine();
		writeToOsi.flush();
		int i = 1;
		for (Answer answer : question.getAnswersList()) {
			writeToOsi.write("n01   " + i + "   ;c=c(" + question.getStartColumn() + "," + question.getEndColumn()
					+ ") .in. (" + answer.getCode() + ")");
			writeToOsi.newLine();
			writeToOsi.flush();
			i++;
		}
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.newLine();
		writeToOsi.flush();

	}

	public void writeAgeQuestion(BufferedWriter writeToOsi, Question question) throws IOException {
		writeToOsi.write("l " + question.getHeader());
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("ttl " + question.getHeader());
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("ttl TOTAL");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("C n10  T_NW   ;wm=0");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n10 TOT");
		writeToOsi.newLine();
		writeToOsi.flush();
		int i = 1;
		for (Answer answer : question.getAnswersList()) {
			writeToOsi.write("n01   " + i + "   ;c=c(" + question.getStartColumn() + "," + question.getEndColumn()
					+ ") .in. (" + answer.getCode() + ");fac=" + answer.getLabel().replaceAll("\\D+", ""));
			writeToOsi.newLine();
			writeToOsi.flush();
			i++;
		}
		writeToOsi.write("n12   _99   ;dec=6");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n20   _98   ;dec=6");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n19   _97   ;dec=6");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.newLine();
		writeToOsi.flush();

	}

	public void writeFTraceQuestion(BufferedWriter writeToOsi, Question question) throws IOException {
		writeToOsi.write("#include ftr.qin;col(a)=" + (question.getEndColumn() + 32) + ";col(b)=" + question.getEndColumn()
				+ ";lvl=prod");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.newLine();
		writeToOsi.flush();

	}

	public void writeRatingQuestion(BufferedWriter writeToOsi, Question question) throws IOException {
		
		writeToOsi.write("l " + question.getHeader() + "g;anlev=prod");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n23 " + question.getHeader() + "_TOP");
		writeToOsi.newLine();
		writeToOsi.flush();
		int colWidth = question.getEndColumn() - question.getStartColumn() + 1;
		for(int i = 1; i <= question.getAnswersList().size(); i++) {
			writeToOsi.write("n01   " + i + "   ;col(b)=" + (question.getEndColumn() - 1 + (i-1)*colWidth));
			writeToOsi.newLine();
			writeToOsi.flush();	
		}
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("side");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("ttl " + question.getHeader() + "g");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("ttl T_nw2");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("C n10  T_NW   ;wm=0");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n10 TOT");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n01   7   ;c=c(b00,b01) .eq. 3;fac=3");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n01   6   ;c=c(b00,b01) .eq. 2;fac=2");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n01   5   ;c=c(b00,b01) .eq. 1;fac=1");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n01   4   ;c=c(b00,b01)=$ 0$;fac=0 ");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n01   3   ;c=c(b00,b01) .eq. -1;fac=-1");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n01   2   ;c=c(b00,b01) .eq. -2;fac=-2");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n01   1   ;c=c(b00,b01) .eq. -3;fac=-3");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n03 S_" + question.getHeader());
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n01   67  ;c=c(b00,b01) .in. (2:3)");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n01  345  ;c=c(b00,b01) .in. (-1:1)");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n01   12  ;c=c(b00,b01) .in. (-3:-2)");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n12 _99  ;dec=6");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n20 _98  ;dec=6");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n19 _97  ;dec=6");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.newLine();
		writeToOsi.flush();
		
		
		writeToOsi.write("#include s_rat" + question.getAnswersList().size() + ".qin;col(b)=" + (question.getEndColumn() - 1)
				+ ";qst=" + question.getHeader() + ";lvl=prod");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.newLine();
		writeToOsi.flush();

	}

	public void writeMultiQuestion(BufferedWriter writeToOsi, Question question) throws IOException {
		writeToOsi.write("l " + question.getHeader());
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("ttl " + question.getHeader());
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("ttl TOTAL");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("C n10  T_NW   ;wm=0");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n10 TOT");
		writeToOsi.newLine();
		writeToOsi.flush();
		int i = 1;
		List<Answer> answers = question.getAnswersList();
		for (int j = 0; j < answers.size(); j++) {
			// int start = question.getStartCol() +
			// ProcessExcelFile.SIZE_OFF * (i - 1);
			int currCol = question.getEndColumn() + (question.getEndColumn() - question.getStartColumn() + 1) * (i - 1);
			writeToOsi.write("n01   " + i + "   ;c=c" + currCol + "'1'");
			writeToOsi.newLine();
			writeToOsi.flush();
			i++;
		}
		/*
		 * if (question.getTitle().substring(1).length() == 1) {
		 * writeToOsi.write("n25   ;inc=t10" + question.getTitle().substring(1)
		 * + ";c=t10" + question.getTitle().substring(1) + " .gt. 0");
		 * writeToOsi.newLine(); writeToOsi.flush(); } else {
		 * writeToOsi.write("n25   ;inc=t1" + question.getTitle().substring(1) +
		 * ";c=t1" + question.getTitle().substring(1) + " .gt. 0");
		 * writeToOsi.newLine(); writeToOsi.flush(); }
		 */
		writeToOsi.write("n05   ;op=1;id=z1;norow");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n15  ;c=-1;op=1;id=z2");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n01   _99 ;op=1;ex=z1/z2;dec=6;notstat");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("C n12   _99   ;dec=6");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("C n20   _98   ;dec=6");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("C n19   _97   ;dec=6");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.newLine();
		writeToOsi.flush();

	}

	public void writeSingleQuestion(BufferedWriter writeToOsi, Question question) throws IOException {

		writeToOsi.write("l " + question.getHeader());
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("ttl " + question.getHeader());
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("ttl TOTAL");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("C n10  T_NW   ;wm=0");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n10 TOT");
		writeToOsi.newLine();
		writeToOsi.flush();
		int i = 1;
		for (Answer answer : question.getAnswersList()) {
			writeToOsi.write("n01   " + i + "   ;c=c(" + question.getStartColumn() + "," + question.getEndColumn()
					+ ") .in. (" + answer.getCode() + ")");
			writeToOsi.newLine();
			writeToOsi.flush();
			i++;
		}
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.newLine();
		writeToOsi.flush();

	}

	public void startOsi(BufferedWriter writeToOsi) throws IOException {
		writeToOsi.write("l cross");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("ttl cross");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("ttl TOTAL");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("C n10  T_NW   ;wm=0");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.write("n10 TOT");
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.newLine();
		writeToOsi.flush();
		writeToOsi.newLine();
		writeToOsi.flush();
	}

}
