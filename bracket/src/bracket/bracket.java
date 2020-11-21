package bracket;
import java.util.*;
public class bracket {
	 public static Boolean isProperly(String sequence) {
	        while (sequence.contains("()")) {
	            sequence = sequence.replaceAll("\\(\\)", "");
	        }
	        return (sequence.length() == 0);
	    }
	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        String parenthesesCheck = new String();

	        while (parenthesesCheck.isEmpty()) {
	            System.out.println("please enter a string");
	            parenthesesCheck = input.nextLine();
	        }

	        System.out.println(isProperly(parenthesesCheck));
	    }
}


