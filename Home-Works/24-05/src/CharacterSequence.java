public class CharacterSequence {
    public static void main(String[] args) {
        String str = "HelloWorld";
        CharSequence seq = "Helloworld";

        if (str.contentEquals(seq)) {
            System.out.println("The string is equal to the character sequence.");
        } else {
            System.out.println("The string is not equal to the character sequence.");
        }
    }
}
