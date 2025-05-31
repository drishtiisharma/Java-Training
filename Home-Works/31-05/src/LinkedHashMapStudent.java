import java.util.LinkedHashMap;
import java.util.Map;

class Stu {
    private String name;
    private double permarks;

    public Stu(String name, double permarks) {
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

public class LinkedHashMapStudent {

    public static void main(String[] args) {
        // Creating LinkedHashMap with key = roll number, value = Stu object
        LinkedHashMap<Integer, Stu> studentMap = new LinkedHashMap<>();

        // Adding students
        studentMap.put(101, new Stu("Radha", 88.5));
        studentMap.put(102, new Stu("Mohan", 75.0));
        studentMap.put(103, new Stu("Sita", 91.2));
        studentMap.put(104, new Stu("Ram", 64.8));

        // Printing map in insertion order
        System.out.println("Using LinkedHashMap:");
        for (Map.Entry<Integer, Stu> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
