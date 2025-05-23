interface Addition
{
	int add(int x,int y);
}
public class LambdaExpDemo1 {

	public static void main(String[] args) {
		
		Addition ad =(int x,int y)->{
			return x+y;
		};
		System.out.println("Sum = "+ad.add(10, 20));
		
		Addition ad1 =(x,y)->{
			return x+y;
		};
		System.out.println("Sum = "+ad1.add(100, 200));
		
		Addition ad2 =(x,y)->(x+y);
		System.out.println("Sum = "+ad2.add(1000, 2000));
	}

}
