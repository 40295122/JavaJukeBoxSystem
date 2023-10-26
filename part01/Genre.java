package part01;
/**
 * Genre Enumeration
 * @author Laura
 *
 */
public enum Genre {
	ROCK(0), POP(1), DANCE(2), JAZZ(3), CLASSICAL(4), OTHER(5);
	
	/**
	 * Array of strings that will be used to correspond to each value of the genre enumeration
	 */
	private String spelling[] = {"Rock and Roll", "Easy Listening Pop", "Techno Dance", "Smooth Jazz", "Classical", "Unknown Genre"};
	
	private int index;
	
	/**
	 * Constructor for Genre
	 * @param num - number associated with the value of the genre enumeration
	 */
	private Genre (int num) {
		index = num;
	}
	
	/**
	 * Converts the value of the genre enumeration to string
	 */
	public String toString() {
		return spelling[index];
	}
}
	
