import java.io.*;
import java.util.*;

public class Main {
	public static class MutableInteger {
    		private int value;
    		public MutableInteger(int value) {
        		this.value = value;
    		}
    		public void set(int value) {
        		this.value = value;
    		}
    		public int get() {
        		return value;
    		}
	}

	enum Direction {
		DOWN(new MutableInteger(1)), RIGHT(new MutableInteger(1)), UP(new MutableInteger(2)), LEFT(new MutableInteger(2));
		
		private final MutableInteger value;
		private Direction(MutableInteger value) {
			this.value = value;
		}	
		
		public MutableInteger getValue() {
			return value;
		}
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
	int second = scanner.nextInt();
	List<String> lines = new ArrayList<>();
	lines.add("" + first);

	int current = first+1;

	String currentStr = lines.get(0);
	
	Direction direction = Direction.DOWN;
	
	while(current <= second) {
		for(int i = 0; i < direction.getValue().get() && current <= second; i++) {
			switch(direction) {
				case DOWN: {
			
					if(lines.indexOf(currentStr)+1 >= lines.size()) { //no line below, let's add one
						lines.add("" +  current);
						currentStr = "" + current;
						current++;
					} else { //if we are going down on an existing line, we are always adding the number on the LEFT
						String temp = lines.get(lines.indexOf(currentStr) + 1);
						currentStr = current + " " + temp;
						lines.set(lines.indexOf(temp), currentStr);
						current++;
					}
					break;	
				}
				case RIGHT: {
					String toAdd = currentStr + " " + current;
					lines.set(lines.indexOf(currentStr), toAdd);
					current++;
					currentStr = toAdd;
					break;	
				}
				case UP: {
					if(lines.indexOf(currentStr) == 0) { //top row, need to add a new one
						lines.add(0, "" + current);
						currentStr = "" + current;
						current++;
					} else { //add right of existing row
						String temp = lines.get(lines.indexOf(currentStr)-1);
						currentStr = temp + " " + current;
						lines.set(lines.indexOf(temp), currentStr);
						current++;
					}
					break;
				}
				case LEFT: {
					String toAdd = current + " " + currentStr;
					lines.set(lines.indexOf(currentStr), toAdd);
					current++;
					currentStr = toAdd;
					break;
				}
			}
		}
		direction.getValue().set(direction.getValue().get() + 2);
		switch(direction) {
			case DOWN:
				direction = Direction.RIGHT; break;
			case RIGHT: 
				direction = Direction.UP; break;
			case UP:
				direction = Direction.LEFT; break;
			case LEFT:
				direction = Direction.DOWN; break;
		}	
	}
	for(String string : lines) {
		System.out.println(string);
	}
	
    }
}