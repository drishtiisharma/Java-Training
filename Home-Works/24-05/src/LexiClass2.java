public class LexiClass2 {
    public static void main(String[] args) {
        String str1 = "Apple";
        String str2 = "apple";

        if (str1.equalsIgnoreCase(str2)) {
            System.out.println("The strings are equal.");
        } 
        else {
            System.out.println("The strings are not equal at all.");
        }
    }
}
