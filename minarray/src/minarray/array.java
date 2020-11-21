package minarray;
import java.util.*;
public class array {

	public static int notContains(int[] arrayOfNumbers) {
 
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            arrayOfNumbers[i] = Math.abs(arrayOfNumbers[i]);
        }

        Arrays.sort(arrayOfNumbers);

        int j = 1, tempIndex = 0;

        if (arrayOfNumbers[0] != j) {
            System.out.println(j);
            return 0;
        }

        for (int i = 0; i < arrayOfNumbers.length; i++) {

            if (arrayOfNumbers[i] < j) {
                continue;
            }

            tempIndex = i - 1;
            if (tempIndex < 0) {
                tempIndex = 0;
            }

            if (arrayOfNumbers[i] - arrayOfNumbers[tempIndex] >= 2) {
                j = arrayOfNumbers[tempIndex] + 1;             
                break;
            }

        }
        return j;
    }
    public static void main(String[] args) {

        int arrayOfNumbers[] = {-1, 1, 2,5, -999};

        System.out.println(notContains(arrayOfNumbers));
    }
}