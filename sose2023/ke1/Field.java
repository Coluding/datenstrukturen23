package sose2023.ke1;

public class Field {
	
	Wall[] walls = new Wall[4];
	boolean start;
	boolean end;
	boolean trap;
	boolean outer;
	
	public Field(Wall[] walls, boolean trap) {
		for (int i = 0; i<= walls.length - 1; i++) {
			this.walls[i] = walls[i];
		}
		this.trap = trap;
	}
	
	
	@Override
	public String toString() {
		String wallString = "";
		
		
		for (Wall wall: walls) {
			if (wall != null) {
			wallString += wall.toString() + " ";
			}
		}
		
		if (start) {
			wallString += " " + "[START FIELD]";
		}else if (end) {
			wallString += " " + "[END FIELD]";
		}else if(trap) {
			wallString += " " + "[TRAP FIELD]";
		}
		
		return String.format("Walls: %s", wallString) ;
	}
	
	void setTrap() {
		if (trap == false) {
			trap = true;
		}
	}
	
	void unsetTrap() {
		if (trap == true) {
			trap = false;	
		}
	}
	
	void setStart() {
		if (end) {
			throw new RuntimeException("This field is already an end field!");
		}
		start = true;
	}
	
	void setEnd() {
		if (start) {
			throw new RuntimeException("This field is already a start field!"); 
		}
		end = true;
	}
}
