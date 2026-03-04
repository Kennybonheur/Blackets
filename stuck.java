import java.util.*;

public class stuck {

    public static boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();//  array that remainder us the last blacket we have seen.

        for (char ch : s.toCharArray()) {

            switch (ch) {

                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;

                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;

                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;

                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;

                default:
                    // If any other character is found
                    return false;
            }
        }

        return stack.isEmpty();// this means that all the brackets are matched and closed properly.
    }

    // we want user to enter a string of brackets and we will check if it is valid or not.
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a bracket sequence: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Nothing is entered");
        } 
        else if (!input.matches("[()\\[\\]{}]+")) {// this the main character we have to check.
            System.out.println("Please enter only brackets");
        } 
        else {
            if (isValid(input)) {
                System.out.println("TRUE");
            } else {
                System.out.println("FALSE");
            }
        }

        scanner.close();
    }
}