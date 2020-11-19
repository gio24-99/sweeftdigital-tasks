package palindrome;
import java.util.*;
public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palindrome="";
        while (palindrome.isEmpty()) {
          System.out.println("please enter the word");
          palindrome = sc.nextLine();
        }
        String reversedText = new StringBuilder(palindrome).reverse().toString();
        if (palindrome.equals(reversedText)) {
            System.out.println(palindrome + " is Palindrome");
        }
        else {
          System.out.println(palindrome + " is not Palindrome");
        }
        
    }
}