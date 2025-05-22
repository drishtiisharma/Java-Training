//9. Write a program to implement add method of "Addition Interface" by using anonymous class

interface Addition{
	public int add(int a,int b);
}

public class AnonymousClass {

	public static void main(String[] args) {
		
		Addition ad=new Addition() {
			public int add(int a,int b) {
				return a+b;
			}
		};
		
		int res=ad.add(15, 15);
		System.out.println("sum: "+res);

	}

}
