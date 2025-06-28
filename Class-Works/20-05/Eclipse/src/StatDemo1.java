class Stat1{
	int id;
	static int count;
	
	Stat1(){
		count++;
		id=count;
	}
	
	static void show() {
		//System.out.println("id: "+id);
		System.out.println("count: "+count);
	}
	
	void showId() {
		System.out.println("id: "+id);
	}
}
public class StatDemo1{

	public static void main(String[] args) {
	Stat1 s1=new Stat1();
	s1.showId();
	Stat1.show();
	
	Stat1 s2=new Stat1();
	Stat1 s3=new Stat1();
	
	s2.showId();	
	Stat1.show();
	
	s3.showId();
	Stat1.show();
	}

}
