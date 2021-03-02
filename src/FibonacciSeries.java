import java.util.Scanner;

/**
 *  Write a java program to print the fibonacci series with and without recursion.
 *
 *  A Fibonacci sequence is a series of numbers in which each (Fibonacci number) is the sum of the two preceding numbers.
 *  The simplest is the series 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, etc.
 */
public class FibonacciSeries {

//Private Static Method(s)-
    /**
     * Fibonacci Series without recursion.
     *
     * @param num Length of the series array.
     */
    private static void fib_0(int num) {

        int[] array = new int[num];

        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i < array.length; i++) { array[i] = array[i - 1] + array[i - 2]; }

        for (int i: array) { System.out.print(i + " "); }
    }

    /**
     * Fibonacci Series without recursion.
     *
     * @param num Length of the series.
     */
    private static void fib_1(int num) {

        int n1 = 0, n2 = 1, n3;

        System.out.print(n1 + " " + n2 + " ");

        for (int i = 2; i < num; i++) {

            n3 = n1 + n2;

            System.out.print(n3 + " ");

            n1 = n2;
            n2 = n3;
        }
    }

    /**
     * Fibonacci Series using recursion.
     *
     * @param num The index of the Fibonacci number to return.
     * @return A Fibonacci number in the Fibonacci Series.
     */
    private static int fib_2(int num) {

        if (num == 0) return  0;
        if (num < 2) return  1;

        return fib_2(num - 1) + fib_2(num - 2);
    }

    /**
     * Helper method that calls the recursive Fibonacci Series method.
     *
     * @param num Length of the series array.
     */
    private static void fib_2_helper(int num) {

        int[] array = new int[num];

        for (int i = 0; i < num; i++) { array[i] = fib_2(i); }

        for (int i: array) { System.out.print(i + " "); }
    }

//Public Static Method(s)-
    /**
     * Test's user input.
     */
    public static void inputProcessor() {

        Scanner cin = new Scanner(System.in);
        boolean isInt = false;
        int temp = -1;

        System.out.print("\nEnter the range of Fibonacci Series to process: ");

        do {
            try {

                temp = Integer.parseInt(cin.next().trim());
                isInt = true;

                if (temp < 3 || temp > 20) {

                    System.out.print("Valid Range is from 3 to 20, try again: ");
                    isInt = false;
                }
            } catch (NumberFormatException | NullPointerException e) {

                System.out.print("Did not enter an integer, try again: ");
            }
        } while (!isInt);

        System.out.println();
        fib_0(temp);
        System.out.println();
        fib_1(temp);
        System.out.println();
        fib_2_helper(temp);
        System.out.println();
    }

}//End of Class.
