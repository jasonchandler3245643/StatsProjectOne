/**
 * Represents a single person in the Birthday experiment
 * Each has an int birthday that corresponds to a day of the year
 * 
 * @author Jason Chandler
 *
 */
public class Person {

	private int birthday;
	
	public Person(int day) {
		
		birthday = day;
		
	}

	public int getBirthday() {
		
		return birthday;
		
	} 
	
	public void setBirthday(int day) {
		
		birthday = day;
		
	}
	
}