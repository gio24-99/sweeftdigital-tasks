package stairs;
import java.util.*;
public class stairs {
	static int stair(int n) {
        if (n <= 1)
            return n;

        return stair(n - 1) + stair(n - 2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int stairCount = 0;

        while (stairCount == 0) {
            System.out.println("please enter the n number of stairs");
            stairCount = input.nextInt();

            int numberOfIterations = stair(stairCount + 1);
            System.out.println(numberOfIterations);
        }
    }
}

