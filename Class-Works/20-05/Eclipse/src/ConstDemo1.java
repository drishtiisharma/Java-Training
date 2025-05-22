class Box{
	double l,b,h;
	
	Box(){
		System.out.println("**no argument constructor**");
	}
	
	Box(double l,double b, double h){
		System.out.println("**3 argument constructor**");
		this.l=l;
		this.b=b;
		this.h=h;
	}
	
	void show() {
		System.out.println("length: "+l);
		System.out.println("breadth: "+b);
		System.out.println("height: "+h);
	}
	
	void volume() {
		double v= l*b*h;
		System.out.println("volume of box: "+v);
	}
	void volume(double len) { //method overloading
		double v= l*b*h;
		System.out.println("volume of box: "+v);
	}
	
}
public class ConstDemo1 {

	public static void main(String[] args) {
		Box b1=new Box();
		b1.show();
		Box b2=new Box(4,5,6);		
		b2.show();
		
		b2.volume();
		

	}

}
