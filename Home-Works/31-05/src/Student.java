import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Student1 {
	private String name;
	private double permarks;

	public Student1(String name, double permarks) {
		this.name = name;
		this.permarks = permarks;
	}

	public String getName() {
		return name;
	}

	public double getPermarks() {
		return permarks;
	}

	@Override
	public String toString() {
		return String.format("%-10s %.1f", name, permarks);
	}
}

public class Student {
	public static void main(String[] args) {

		HashMap<Integer, Student1> map = new HashMap<>();
		HashSet<Student1> set = new HashSet<>();

		map.put(101, new Student1("Radha", 88.5));
		map.put(102, new Student1("Mohan", 75.0));
		map.put(103, new Student1("Sita", 91.2));
		map.put(104, new Student1("Ram", 64.8));

		//adding all values to hashset
		set.addAll(map.values());

		System.out.println("Using HashMap:");
		for (Map.Entry<Integer, Student1> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

		System.out.println("\nUsing HashSet:");
		for (Student1 s : set) {
			System.out.println(s);
		}
	}
}
