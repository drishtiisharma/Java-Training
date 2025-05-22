//3.Write a Java program to create an interface Flyable with a method called fly_obj(). Create three classes Spacecraft, Airplane, and Helicopter that implement the Flyable interface. Implement the fly_obj() method for each of the three classes.

interface Flyable{
	void fly_obj();
}

class Spacecraft implements Flyable{

	@Override
	public void fly_obj() {
		System.out.println("spacecraft is flying...");
		
	}
	
}

class Airplane implements Flyable{

	@Override
	public void fly_obj() {
		System.out.println("airplane is flying...");
		
	}
	
}

class Helicopter implements Flyable{

	@Override
	public void fly_obj() {
		System.out.println("helicopter is flying....");
		
	}
	
}

public class FlyableInterface {

	public static void main(String[] args) {
		Spacecraft s=new Spacecraft();
		Airplane a=new Airplane();
		Helicopter h=new Helicopter();
		
		s.fly_obj();
		a.fly_obj();
		h.fly_obj();

	}

}
