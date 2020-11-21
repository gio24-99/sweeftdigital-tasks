package palindrome;
import java.util.*;
public class palindrome {
    public static Boolean isPalindrome(String text) {
        String reversedText = new StringBuilder(text).reverse().toString();
        return text.equals(reversedText);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palindrome = "";
        while (palindrome.isEmpty()) {
            System.out.println("please enter the word");
            palindrome = sc.nextLine();
        }
        System.out.println(isPalindrome(palindrome));
    }
}