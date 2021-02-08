import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int denom = scanner.nextInt();
		
		int gcd = gcd(num, denom);

		num = num / gcd;
		denom = denom / gcd;

		if(num > denom) {
			System.out.print((num / denom) + " ");
		}
		if(num % denom > 0) {
			System.out.println((num % denom) + "/" + denom);
		}
	}
	
	private static int gcd(int m, int n) {
		if(n == 0) {
			return m;
		} else {
			return gcd(n, m % n);
		}
	}

	public static String fractionString(int a, int b) {
		return "";
	}
		
}