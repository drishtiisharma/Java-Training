import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable
{
	int roll;
	String name;
	double marks;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int roll, String name, double marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return  roll + "\t" + name + "\t" + marks;
	}
	
}
public class SerializationDemo {

	public static void main(String[] args) {
		
		try 
		{ //serialization
			Student s1 = new Student(101, "Ram", 89);
			System.out.println(s1);
			FileOutputStream fos = new FileOutputStream("stud.doc");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(s1);
			fos.close();
			oos.close();
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		try 
		{
			//deserialization
			FileInputStream fis = new FileInputStream("stud.doc");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Student s2 =(Student) ois.readObject();
			System.out.println(s2);
			fis.close();
			ois.close();
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}

	}

}
