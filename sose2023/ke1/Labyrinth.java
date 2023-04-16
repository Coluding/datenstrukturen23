package sose2023.ke1;

import java.util.Arrays;

public class Labyrinth {
	
	Field[][] playingField;
	int height;
	int width;
	
	public Labyrinth(int height, int width) {
		
		this.height = height;
		this.width = width;
		
		playingField = buildLabyrinth();
	}
	
	Field[][] buildLabyrinth(){
		Field[][] field = new Field[this.height][this.width];
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				Wall[] walls;
				
				
				// check if field is a outer field which only has outer walls
				walls = checkOuterField(i, j);
				field[i][j] = new Field(walls,false);
				
			}
		}
		
		return field;
	}
	
	Wall[] checkOuterField(int i, int j) {
		Wall[] walls;

		
		if (i == 0 && j == 0) {
			walls = new Wall[2];
			walls[0] = Wall.UP;
			walls[1] = Wall.LEFT;
	
			
		}else if (j == 0) {
			walls = new Wall[1];
			walls[0] = Wall.LEFT;
			
		}else if (i == 0) {
			walls = new Wall[1];
			walls[0] = Wall.UP;
			
		}else if (i == this.height - 1 && j == this.width - 1) {
			walls = new Wall[2];
			walls[0] = Wall.DOWN;
			walls[1] = Wall.RIGHT;
			
		}else if (i == this.height - 1) {
			walls = new Wall[1];
			walls[0] = Wall.DOWN;
			
		}else if(j == this.width - 1) {
			walls = new Wall[1];
			walls[0] = Wall.RIGHT;
		
		}else {
			return new Wall[0];

		}
		
		return walls;
	}
	
	
	void setWall(int i ,int j, Wall wall) {
		// check if wall already exists in array otherwise add to the array new one
				
		if (Arrays.asList(playingField[i][j]).contains(wall)) {	
			System.out.printf("The wall %s already is in the field!", wall);
			return;
		}	
		for (int ind = 0; ind < playingField[i][j].walls.length; ind++) {
			if (playingField[i][j].walls[ind] == null) {
				int[] neighbors = findWallNeighbor(i, j, wall);
				playingField[i][j].walls[ind] = wall;
				playingField[neighbors[0]][neighbors[1]].walls[ind] = findOppositeWall(wall);
				return;
			}
		}	
		System.out.println("There are already four walls!");
	}
	
	int[] findWallNeighbor(int i, int j, Wall wall) {
		Field field = playingField[i][j];
		
		int[] positions = new int[2];
		
		switch (wall) {
		case UP: {
			positions[0] = i - 1;
			positions[1] = j;
			break;
		}
		case DOWN:{
			positions[0] = i + 1;
			positions[1] = j;
			break;
		}
		
		case LEFT: {
			positions[0] = i;
			positions[1] = j - 1;
			break;
		}
		
		case RIGHT: {
			positions[0] = i;
			positions[1] = j + 1;
			break;
		}
		
		}
		
		return positions;
		
	}
	
	Wall findOppositeWall(Wall wall) {
		
		Wall opposite;
		
		switch (wall) {
		case UP: opposite = Wall.DOWN;
		break;
		case DOWN: opposite = Wall.UP;
		break;
		case LEFT: opposite = Wall.RIGHT;
		break;
		default: opposite = Wall.LEFT;
		break;
		}
		
		return opposite;
	}
	
	void setTrap(int i , int j) {
		playingField[i][j].setTrap();
	}
	
	
	void unsetTrap(int i , int j) {
		playingField[i][j].unsetTrap();
	}
	
	int countTraps() {
		
		int counter = 0;
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				if (playingField[i][j].trap) {
					counter++;
				}
			}
		}
		
		return counter;
	}
	
	void setStart(int i, int j) {
		playingField[i][j].setStart();
	}
	
	void setEnd(int i , int j) {
		playingField[i][j].setEnd();
	}
	
	void print() {
		
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				System.out.println(String.format("Field %s %s ", i, j) + playingField[i][j]);
			}
			}
		
	}

}
