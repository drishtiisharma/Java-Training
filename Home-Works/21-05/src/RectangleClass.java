//Q3. Write a Java program to create a class called "Rectangle" with width and height attributes. Calculate the area and perimeter of the rectangle.
class Rectangle{
	public double l,b,p,ar;
	Rectangle(double len,double bd){
		l=len;
		b=bd;
	}
	
	double perimeter(){
	    return 2*(l+b);
	}
	
	double area() {
		return l*b;
	}
	
	void show() {
		System.out.println("perimeter of rectangle: "+perimeter());
		System.out.println("area of rectangle: "+area());
	}
}
public class RectangleClass {

	public static void main(String[] args) {
		Rectangle r=new Rectangle(10,20);
		
		r.show();

	}

}
