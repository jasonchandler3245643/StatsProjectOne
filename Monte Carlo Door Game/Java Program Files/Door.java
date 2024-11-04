
/**
 * Represents a Door in the Price is Right Game
 * 
 * Doors have a status that is true for the winning door only
 * and reveal that is true if the host has revealed the door
 * 
 * @author jchan
 *
 */
public class Door {

	private boolean status;
	private boolean reveal;
	
	/**
	 * Make the door a dud by default
	 * 
	 */
	public Door() {
		
		status = false;
		
	}
	
	// return the door's status
	public boolean getStatus() {
		
		return status;
		
	}
	
	// set the status of the door
	public void setStatus(boolean doorStatus) {
		
		status = doorStatus;
		
		
	}
	
	// set reveal
	public boolean getReveal() {
		
		return reveal;
		
	}
	
	// set the status of the door
	public void setReveal(boolean revealed) {
		
		reveal = revealed;
		
		
	}
	
	
}