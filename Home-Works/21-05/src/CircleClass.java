//Write a Java program to create a class called "Circle" with a radius attribute. You can access and modify this attribute. Calculate the area and circumference of the circle.
class Circle{
	public double r;
	
	Circle(double rad){
		r=rad;
	}
	
	double area() {
		return 3.14*r*r;
	}
	
	double circumference() {
		return 2*3.14*r;
	}
	
	//SETTER AND GETTER METHODS
	void setRadius(double radius) {
		this.r=radius;
	}
	double getRadius() {
		return r;
	}
	void show() {
		System.out.println("area of circle: "+area());
		System.out.println("circumference of circle: "+circumference());
	}
}

public class CircleClass {

	public static void main(String[] args) {
		Circle c=new Circle(8);
		System.out.println("before modifying: ");
		c.show();
		System.out.println();
		
		System.out.println("after modifying: ");
		c.setRadius(12);
		c.show();
		

	}

}
