import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++) {
			long a = scanner.nextLong();
			long b = scanner.nextLong();
			long p = scanner.nextLong();
			if(a*b == p) {
				System.out.println("POSSIBLE DOUBLE SIGMA");
			} else {
				System.out.println("16 BIT S/W ONLY");
			}
		}
	}

}