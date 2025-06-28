class Dist{
	
	int feet, inches;
	
	Dist(int f, int i){
		feet=f;
		inches=i;
	}
	
	int feetToInches() {
		return feet*12;
	}
	
	double inchesToFeet() {
		return (double)inches/12;
	}
	
	void showDistance() {
		System.out.println("distance: "+feet+" ft "+inches+" in");
	}
}
public class DistConst {

	public static void main(String[] args) {
		Dist d=new Dist(5, 8);
		d.showDistance();
		
		System.out.println("feet to inches: "+d.feetToInches()+" inches");
		System.out.println("inches to feet: "+d.inchesToFeet()+" feet");

	}

}
