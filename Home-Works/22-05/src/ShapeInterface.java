//1.Write a Java program to create an interface Shape with the getArea() method. Create three classes Rectangle, Circle, and Triangle that implement the Shape interface. Implement the getArea() method for each of the three classes.

interface Shape{
	double getArea();
}

class Rectangle implements Shape{
	double l,b;
	
	public Rectangle(double l, double b) {
		this.l = l;
		this.b = b;
	}

	@Override
	public double getArea() {
		return l*b;
	}
	
}

class Circle implements Shape{
	double r;
	

	public Circle(double r) {
		this.r = r;
	}

	@Override
	public double getArea() {
		return 3.14*r*r;
	}
	
}

class Triangle implements Shape{
	double l,h;
	

	public Triangle(double l, double h) {
		this.l = l;
		this.h = h;
	}

	@Override
	public double getArea() {
		return 0.5*l*h;
	}
	
}

public class ShapeInterface {

	public static void main(String[] args) {
		Rectangle r=new Rectangle(5,10);
		Circle c=new Circle(12.5);
		Triangle t=new Triangle(13,10);
		
		System.out.println("area of rectangle: "+r.getArea());
		System.out.println("area of circle: "+c.getArea());
		System.out.println("area of triangle: "+t.getArea());
		

	}

}
