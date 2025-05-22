//7.Write a Java program to create an interface Sortable with a method sort() that sorts an array of integers in ascending order. Create two classes BubbleSort and SelectionSort that implement the Sortable interface and provide their own implementations of the sort() method.

interface Sortable{
	void sort(int[] arr);
}

class BubbleSort implements Sortable{

	@Override
	public void sort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		display(arr);
	}
	
	public void display(int[] arr) {
		System.out.println("array sorted by bubble sort: ");
		for(int num: arr) {
			System.out.print(num+" ");
		}
	}
	
	
}

class SelectionSort implements Sortable{

	@Override
	public void sort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			int min=i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
		display(arr);
	}
	public void display(int[] arr) {
		System.out.println("array sorted by selection sort: ");
		for(int num: arr) {
			System.out.print(num+" ");
		}
	}
	
}
public class SortableInterface {

	public static void main(String[] args) {
		int[] array1 = {34,12,25,8,15};
        int[] array2 = {19,25,6,45,8};  

        Sortable b = new BubbleSort();
        b.sort(array1);
        
        System.out.println();

        Sortable s = new SelectionSort();
        s.sort(array2);

	}

}
