import java.util.*;
import static java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\\n");
		int n = scanner.nextInt();
		if(n == 0) {
			return;
		}
		Map<String, Integer> points = new HashMap<>();
		for(int i = 0; i < n; i++) {
			String input = scanner.next();
			String[] terms = input.trim().split(" ");
			int r = Integer.parseInt(terms[1]);
			int s = Integer.parseInt(terms[2]);
			int d = Integer.parseInt(terms[3]);
			points.put(terms[0], (2*r)+(3*s)+d);
		}
		if(points.keySet().size() == 1) {
			System.out.println(points.keySet().iterator().next());
			return;
		}
		List<Entry<String, Integer>> list = new LinkedList<>(points.entrySet());
		list.sort(Entry.<String,Integer>comparingByValue().reversed());
		
		if(list.get(0).getValue().intValue() == list.get(1).getValue().intValue()) {
			if(list.get(0).getKey().compareToIgnoreCase(list.get(1).getKey()) > 0) {
				Collections.swap(list, 0, 1);
			}
		}
		
		for(int i = 0; i < 2; i++) {
			System.out.println(list.get(i).getKey());
		}
	}
	


}