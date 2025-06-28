interface Camera {
    void clickPhoto();
}

interface MusicPlayer {
    void playMusic();
}

class Smartphone implements Camera, MusicPlayer {
    public void clickPhoto() {
        System.out.println("Photo clicked.");
    }
    public void playMusic() {
        System.out.println("Playing music.");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone();
        phone.clickPhoto();
        phone.playMusic();
    }
}
