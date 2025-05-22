
public class ForEachDemo {

	public static void main(String[] args) {
		int a[]= {10,20,30,40,50};
		System.out.println("using index loop:");
		for(int i=0;i<5;i++) {
			System.out.println(a[i]);
		}
		System.out.println();
		System.out.println("using for-each loop:");
		for (int i : a) {
			System.out.println(i);
		}

	}

}
