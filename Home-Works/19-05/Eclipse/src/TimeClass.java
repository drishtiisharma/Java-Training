import java.util.Scanner;

class Time{
	int h;
	double m;
	double s;
	
	void getData() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter hour(s):");
		h=sc.nextInt();
		System.out.println("enter minute(s):");
		m=sc.nextDouble();
		System.out.println("enter second(s)");
		s=sc.nextDouble();
		
		sc.close();
	}
	
	void showData() {
		System.out.println();
		System.out.println("time in hours: "+h);
		System.out.println("time in minutes: "+m);
		System.out.println("time in seconds: "+s);
	}
	
	// 1 hour=60mins
	// 1 min=60 secs
	// 1 hour= 3600 secs
	
	void hourToTime(double hour) {
		System.out.println();
		h=(int)hour;
		double rem=(hour-h)*60;
		m=(int)rem;
		s=(int)((rem-m)*60);
		
	}
	
	double timeToHour() {
		System.out.println();
		return h+(m/60.0)+(s/3600.0);
	}
	
	
}
public class TimeClass {

	public static void main(String[] args) {
		Time t=new Time();
		t.getData();
		
		Time t1=new Time();
		t1.hourToTime(2.75);
		t.timeToHour();
		
		t.showData();
		t1.showData();
		
		t1.timeToHour();
		
	}

}
