import java.util.Scanner;

class Dist{
	int feet;
	double inch;
	
	void getData() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter feet: ");
		feet=sc.nextInt();
		System.out.println("enter inch: ");
		inch=sc.nextDouble();
		sc.close();
	}
	
	void showData() {
		System.out.println("feet: "+feet);
		System.out.println("inch: "+inch);
	}
	
	void feetToDist(double ft){
		feet=(int)ft;
		inch=(ft-feet)*12;
	}
	
	double distToFeet() {
		double ft;
		ft=feet+(inch/12);
		return ft;
	}
}


public class DistanceDemo {

	public static void main(String[] args) {
		Dist d1=new Dist();
		d1.getData();
		
		Dist d2=new Dist();
		d2.feetToDist(2.25);
		
		
		d1.showData();
		d2.showData();
		
		d1.distToFeet();
		
	}

}
