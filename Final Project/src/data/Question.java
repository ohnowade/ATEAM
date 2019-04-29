package data;

/**
 * This represents a question in the quiz
 *
 */
public class Question {
	/**
	 * The topic this question belongs to 
	 */
	private String topic;
	
	/**
	 * The text of current question 
	 */
	private String text;
	
	/**
	 * The choices of current question
	 */
	private Choice[] choices;
	
	/**
	 * The path of the image contained in this question
	 */
	private String imagePath;
	
	/**
	 * returns the topic this question belongs to
	 * @return
	 */
	public String getTopic() {
		return this.topic;
	}
	
	/**
	 * returns the text of this question
	 * @return
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * retrieves all choices of this question
	 * @return
	 */
	public Choice[] getChoices() {
		return this.choices;
	}
	
	/**
	 * retrieves the path of the image for this question
	 * @return
	 */
	public String getImagePath() {
		return this.imagePath;
	}
}
