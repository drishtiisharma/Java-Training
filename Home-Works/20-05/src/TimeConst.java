class Time{
	
	int hours,mins,secs;
	Time(int h, int m, int s){
		hours=h;
		mins=m;
		secs=s;
	}
	
	int hoursTomins() {
		return hours*60;
	}
	
	int minsToSeconds() {
		return mins*60;
	}
	
	double minsTohours() {
		return (double)mins/60;
	}
	
	void displayTime() {
		System.out.println("time: "+ hours+" h "+mins+" m "+secs+" s");
	}
}
public class TimeConst {

	public static void main(String[] args) {
		Time t=new Time(4, 15, 45);
		t.displayTime();
		
		System.out.println("Hours to Minutes: " + t.hoursTomins() + " minutes");
        System.out.println("Minutes to Seconds: " + t.minsToSeconds() + " seconds");
        System.out.println("Minutes to Hours: " + t.minsTohours() + " hours");

	}

}
