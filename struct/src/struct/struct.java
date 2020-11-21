package struct;
import java.util.*;
public class struct {
    public static LinkedList < Integer > list = new LinkedList < Integer > ();
    public static void GenerateNumbersInList(int number) {
        for (int i = 0; i < number; i++) {
            Random rand = new Random();
            int random = rand.nextInt(15000);
            list.add(random);
        }
    }

    public static void PrintLinkedListNumbers() {
        for (int number: list) {
            System.out.println(number);
        }
    }

    public static void AdjustLinkedList(int number) {
        if (number == 1) {
            System.out.println(list.getFirst() + "  is removed");
            list.removeFirst();
        } else if (number == 2) {
            System.out.println(list.getLast() + "  is removed");
            list.removeLast();
        }
        PrintLinkedListNumbers();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = 0;
        while (number == 0) {
            System.out.println("Please input the number of integers you want to initialize in the linked list");
            number = input.nextInt();
        }

        GenerateNumbersInList(number);
        PrintLinkedListNumbers();

        int receivedNum = 0;
        while (!list.isEmpty()) {
            System.out.println("enter 1 to remove first element or enter 2 to remove last element");
            receivedNum = input.nextInt();
            AdjustLinkedList(receivedNum);
        }
        System.out.println("Linked list is empty");
        input.close();

    }

}