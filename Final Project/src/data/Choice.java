package data;

/**
 * This class represents a single choice for the questions in the quiz
 *
 */
public class Choice {
	/**
	 * the text of the choice
	 */
	String text;
	
	/**
	 * the correctness of this choice
	 */
	boolean correct;
	
	/**
	 * returns the text of the choice
	 * @return
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * checks if the choice is a correct answer
	 * @return true if it is correct and false otherwise
	 */
	public boolean checkCorrect() {
		return this.correct;
	}
}
