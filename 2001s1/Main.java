import java.io.*;
import java.util.*;

public class Main {

	enum Suit {
		Clubs(new ArrayList<>()), Diamonds(new ArrayList<>()), Hearts(new ArrayList<>()), Spades(new ArrayList<>());
		
		List<Character> list;

		Suit(List<Character> list) {
			this.list = list;			
		}
		
		List<Character> getList() {
			return list;
		}
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hand = scanner.next();
	System.out.println("Cards Dealt\tPoints");
	
	Suit current = Suit.Clubs;

	for(char c : hand.toCharArray()) {
		switch(c) {
			case 'C':
				break;
			case 'D':
				current = Suit.Diamonds;
				break;
			case 'H':
				current = Suit.Hearts;
				break;
			case 'S':
				current = Suit.Spades;
				break;
			default:
				current.getList().add(c);
				break;
		}		
	}
	int total = 0;
	for(Suit suit : Suit.values()) {
		int points = 0;
		StringBuilder line = new StringBuilder(suit.toString());
		for(char c : suit.getList()) {
			line.append(" ").append(c);
			switch(c) {
				case 'A':
					points += 4;
					break;
				case 'K':
					points += 3;
					break;
				case 'Q':
					points += 2;
					break;
				case 'J':
					points += 1;
					break;
			}
		}
		if(suit.getList().size() == 0) {
			points += 3;
		} else if(suit.getList().size() == 1) {
			points += 2;
		} else if(suit.getList().size() == 2) {
			points += 1;	
		}
		line.append("\t").append(points);
		total += points;
		System.out.println(line);
	}
	System.out.println("Total " + total);
    }
}