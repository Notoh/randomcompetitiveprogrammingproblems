import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int quarters = scanner.nextInt();
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();
        
	int played = 0;

	while(quarters > 0) {
		played++;
		if(played % 3 == 0) {
			third++;
			if(third % 10 == 0) {
				quarters += 9;
			}	
		} else if(played % 2 == 0) {
			second++;
			if(second % 100 == 0) {
				quarters += 60;
			}
		} else {
			first++;
			if(first % 35 == 0) {
				quarters += 30;
			}
		}
		quarters--;	
	}
        
	System.out.println("Martha plays " + played + " times before going broke.");
    }
}