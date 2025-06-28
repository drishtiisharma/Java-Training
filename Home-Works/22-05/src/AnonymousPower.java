//11. Write a program to implement square method of "Power Interface" by using anonymous class expression class.

interface Power{
	public int square(int a);
}


public class AnonymousPower {

	public static void main(String[] args) {
		Power s=new Power() {
			public int square(int a) {
				return a*a;
			}
		};
		
		System.out.println("square: "+s.square(12));

	}

}
