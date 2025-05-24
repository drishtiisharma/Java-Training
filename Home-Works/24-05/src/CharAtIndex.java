import java.util.Scanner;

public class CharAtIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.print("Enter the index: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < input.length()) {
            char result = input.charAt(index);
            System.out.println("Character at index " + index + " is: " + result);
        } else {
            System.out.println("Invalid index! Please enter a number between 0 and " + (input.length() - 1));
        }
    }
}
