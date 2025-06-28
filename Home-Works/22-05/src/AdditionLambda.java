//10.Write a program to implement add method of "Addition Interface" by using labbda expression class

@FunctionalInterface
interface Addn{
	int add(int a, int b);
}

public class AdditionLambda {

	public static void main(String[] args) {
		Addn op=(a,b)->(a+b);
		System.out.println("sum: "+op.add(10, 20));

	}

}
