package money;
import java.util.*;
public class money {

    public static int minSplit(double money) {
        double m50, m20, m10, m5, m1;
        m50 = money / 0.5;
        m20 = money % 0.5 / 0.2;
        m10 = money % 0.5 % 0.2 / 0.1;
        m5 = money % 0.5 % 0.2 % 0.1 / 0.05;
        m1 = money % 0.5 % 0.2 % 0.1 % 0.05 / 0.01;

        return (int) m50 + (int) m20 +(int) m10 + (int) m5 + (int)Math.round(m1);
    }

    public static void main(String[] args) {

        double money;
        Scanner m = new Scanner(System.in);
        money = m.nextDouble();
        int minimalAmount = minSplit(money);
        System.out.println(minimalAmount);
    }

}