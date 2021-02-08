import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			list.add(scanner.nextInt());
		}
		Collections.sort(list);
		for(Integer i : list) {
			System.out.println(i);
		}
	}

}