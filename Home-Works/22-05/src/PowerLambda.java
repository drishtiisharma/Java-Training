//12. Write a program to implement square method of "Power Interface" by using labbda expression class expression class.

interface Pow{
	int square(int a);
}

public class PowerLambda {

	public static void main(String[] args) {
		Pow p=(a)->(a*a);
		System.out.println("square: "+p.square(13));

	}

}
