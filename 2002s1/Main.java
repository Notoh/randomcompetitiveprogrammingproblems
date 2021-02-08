import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int pink = scanner.nextInt();
		int green = scanner.nextInt();
		int red = scanner.nextInt();
		int orange = scanner.nextInt();
		
		int required = scanner.nextInt();


	
		
		int minimum = Integer.MAX_VALUE;
		int combos = 0;	
		StringBuilder builder = new StringBuilder();
		for(int a = 0, totalPink = 0; a <= required; a++) {
			totalPink = a * pink;
			for(int b = 0, totalGreen = 0; b <= required; b++) {
				totalGreen = b * green;
				for(int c = 0, totalRed = 0; c <= required; c++) {
					totalRed = red * c;
					for(int d = 0,totalOrange = 0; d <= required; d++) {
						totalOrange = orange * d;
						if(totalPink + totalGreen + totalRed + totalOrange == required) {
							if(a+b+c+d < minimum) {
								minimum = a+b+c+d;
							}
							combos++;
							builder.append("# of PINK is " + a + " # of GREEN is " + b + " # of RED is " + c + " # of ORANGE is " + d + "\n");
						}
					}
				}
			}			
		}
		builder.append("Total combinations is " + combos + ".\n");
		builder.append("Minimum number of tickets to print is " + minimum + ".\n");
		System.out.print(builder);
	}
	
}