import java.util.Map;
import java.util.TreeMap;

class Stu1 {
    private String name;
    private double permarks;

    public Stu1(String name, double permarks) {
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

public class StudentTreeMap {

    public static void main(String[] args) {
        TreeMap<Integer, Stu1> studentMap = new TreeMap<>();

        studentMap.put(101, new Stu1("Radha", 88.5));
        studentMap.put(102, new Stu1("Mohan", 75.0));
        studentMap.put(103, new Stu1("Sita", 91.2));
        studentMap.put(104, new Stu1("Ram", 64.8));

        System.out.println("Using TreeMap:");
        for (Map.Entry<Integer, Stu1> entry : studentMap.entrySet()) {
            System.out.println("Roll No: " + entry.getKey() + " = " + entry.getValue());
        }
    }
}
