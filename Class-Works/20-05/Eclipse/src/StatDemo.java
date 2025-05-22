class Stat{
	int id;
	static int count;
	
	Stat(){
		count++;
		id=count;
	}
	
	void show() {
		System.out.println("id: "+id);
		System.out.println("count: "+count);
	}
}
public class StatDemo {

	public static void main(String[] args) {
	Stat s1=new Stat();
	s1.show();
	
	Stat s2=new Stat();
	Stat s3=new Stat();
	s2.show();
	s3.show();
	
	}

}
