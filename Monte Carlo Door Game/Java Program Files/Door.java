
public class Door {

	// holds true for the winning door
	// false for the other two
	private boolean status;
	private boolean reveal;
	
	// assign the door status as fault default
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
	
	public boolean getReveal() {
		
		return reveal;
		
	}
	
	// set the status of the door
	public void setReveal(boolean revealed) {
		
		reveal = revealed;
		
		
	}
	
	
}
