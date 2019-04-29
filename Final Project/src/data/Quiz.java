package data;

import java.util.Stack;

/**
 * This class serve to support the program function during quiz period. Function
 * includes:
	1. Show question for the quiz 
	2. Show answer for the quiz 
	3. Compare answer show correctness 
	4. Keep counts of correctness
 * 
 * @author oudon
 *
 */
public class Quiz {
	int numCorrect;
	int numAnswered;
	Stack<Question> question;

	/**
	 * default constructor
	 */
	public Quiz() {

	}

	/**
	 * Check if the question is correct;
	 * 
	 * @return
	 */
	boolean checkCorrect() {
		return true;
	}
}
