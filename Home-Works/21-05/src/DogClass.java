//Q2. Write a Java program to create a class called "Dog" with a name and breed attribute. Create two instances of the "Dog" class, set their attributes using the constructor and modify the attributes using the setter methods and print the updated values.

class Dog{
	String name;
	String breed;
	
	Dog(String n,String b){ //constructor
		name=n;
		breed=b;
	}
	//SETTER METHODS
	void setName(String newName) { //setter method to modify the name
		name=newName;
	}
	
	void setBreed(String newBreed) { //setter method to modify the breed
		breed=newBreed;
	}
	//GETTER METHODS
	String getName() {
		return name;
	}
	
	String getBreed() {
		return breed;
	}
	
	void show() {
		System.out.println("dog name: "+name);
		System.out.println("dog breed: "+breed);
		System.out.println();
	}
	
}

public class DogClass {

	public static void main(String[] args) {
		System.out.println("before changing:");
		Dog d1=new Dog("tommy","labrador");
		Dog d2=new Dog("bruno","bulldog");
		d1.show();
		d2.show();

		
		System.out.println();
		System.out.println("after changing:");
		//setting new names and breed
		d1.setName("max");
		d1.setBreed("husky");
		
		d2.setName("charlie");
		d2.setBreed("german shepherd");
		
		d1.show();
		d2.show();
		


	}

}
