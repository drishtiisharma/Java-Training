//8.Write a Java program to create an interface Playable with a method play() that takes no arguments and returns void. Create three classes Football, Volleyball, and Basketball that implement the Playable interface and override the play() method to play the respective sports.

interface Playable{
	void play();
}

class Football implements Playable{

	@Override
	public void play() {
		System.out.println("playing football...");
		
	}
	
}

class Volleyball implements Playable{

	@Override
	public void play() {
		System.out.println("playing volleyball...");
		
	}
	
}

class Basketball implements Playable{

	@Override
	public void play() {
		System.out.println("playing basketball...");
		
	}
	
}

public class PlayableInterface {

	public static void main(String[] args) {
		Football f=new Football();
		Volleyball v=new Volleyball();
		Basketball b=new Basketball();
		
		f.play();
		v.play();
		b.play();
	}

}
