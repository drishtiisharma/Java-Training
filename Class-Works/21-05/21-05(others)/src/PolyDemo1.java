abstract class Shape{
	double dim1,dim2;

	Shape() {
		dim1=0;
		dim2=0;
	}

	Shape(double dim1, double dim2) {
		this.dim1 = dim1;
		this.dim2 = dim2;
	}
	//can be made abstract
	abstract void area();
}

class Rectangle extends Shape{

	public Rectangle() {
		super();
	}

	public Rectangle(double dim1, double dim2) {
		super(dim1, dim2);
	}
	
	void area() {
		double a=dim1*dim2;
		System.out.println("area of rectangle: "+a);
	}
}

class Triangle extends Shape{

	public Triangle() {
		super();
	}

	public Triangle(double dim1, double dim2) {
		super(dim1, dim2);
	}
	
	void area() {
		double a=0.5*dim1*dim2;
		System.out.println("area of triangle: "+a);
	}
}

class Circle extends Shape{

	public Circle() {
		super();
	}

	public Circle(double dim1, double dim2) {
		super(dim1, dim2);
	}
	
	void area() {
		double a=3.14*dim1*dim1;
		System.out.println("area of circle: "+a);
	}
}

public class PolyDemo1 {

	public static void main(String[] args) {
		
		Shape ref;
		//Shape ref=new Shape(); ---> will give error as abstract class cannot be instantiated
		Rectangle r=new Rectangle(8,5);
		Triangle t=new Triangle(10,8);
		Circle c=new Circle(4,0);
		
		ref=r;
		ref.area();
		
		ref=t;
		ref.area();
		
		ref=c;
		ref.area();
	}

}
