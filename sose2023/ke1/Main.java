package sose2023.ke1;

public class Main {

	public static void main(String[] args) {
		
		int[] start = {0,0};
		int[] end = {5,5};
		
		Wall[] walls = {Wall.UP, Wall.DOWN};
		
		Labyrinth lab = new Labyrinth(5, 5);
		
		lab.setWall(0,0, Wall.RIGHT);
		lab.setTrap(1, 0);
		
		lab.setStart(3, 4);
		lab.setEnd(3, 1);
		
		lab.setWall(2, 3, Wall.UP);
		lab.setWall(2, 3, Wall.LEFT);
		
		//System.out.println(lab.playingField[0][0]);
		
		lab.print();
	}
	
}
