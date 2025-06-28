//5.Write a Java program to create an interface Resizable with methods resizeWidth(int width) and resizeHeight(int height) that allow an object to be resized. Create a class Rectangle that implements the Resizable interface and implements the resize methods.

interface Resizeable{
	void resizeWidth(int width);
	void resizeHeight(int height);
}

class Rectangle1 implements Resizeable{
	int width, height;

	

	public Rectangle1(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	void show() {
		System.out.println("original width: "+width);
		System.out.println("original height: "+height);
	}

	@Override
	public void resizeWidth(int w) {
		this.width=w;
		System.out.println("width resized to: "+width);
	}

	@Override
	public void resizeHeight(int h) {
		this.height=h;
		System.out.println("height resized to: "+height);
	
	}
	
}


public class ResizeInterface {

	public static void main(String[] args) {
		Rectangle1 r=new Rectangle1(10,20);
		r.show();
		System.out.println();
		r.resizeWidth(5);
		r.resizeHeight(15);

	}

}
