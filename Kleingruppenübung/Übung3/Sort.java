import java.util.*;
import java.util.function.*;

public class Sort {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Do you want to check your Bubblesort or your Insertionsort implementation?");
            System.out.println("Pass the argument 'bubble' or 'insertion' to choose.");
            return;
        }
        if (args[0].equals("bubble")) {
            test(Bubble::bubble);
        } else if (args[0].equals("insertion")) {
            test(Insertion::insertion);
        } else {
            System.out.println("unknown argument " + args[0]);
        }
    }

    public static void test(Consumer<int[]> sort) {
        Random rand = new Random(System.currentTimeMillis());
        int[] empty = new int[0];
        sort.accept(empty);
        int[] singleton = new int[1];
        singleton[0] = rand.nextInt();
        int[] clone = Arrays.copyOf(singleton, 1);
        sort.accept(singleton);
        check(Arrays.equals(singleton, clone), Arrays.toString(singleton) + " != " + Arrays.toString(clone));
        for (int i = 0; i < 10000; i++) {
            int length = rand.nextInt(10);
            int[] a = new int[length];
            for (int j = 0; j < length; j++) {
                a[j] = rand.nextInt();
            }
            int[] b = Arrays.copyOf(a, length);
            sort.accept(a);
            Arrays.sort(b);
            check(Arrays.equals(a, b), Arrays.toString(a) + " != " + Arrays.toString(b));
        }
        System.out.println("All tests passed.");
    }

    private static void check(boolean b, String m) {
        if (!b) {
            System.out.println("ERROR: " + m);
            System.exit(-1);
        }
    }

}
