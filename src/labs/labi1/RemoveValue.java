package labs.labi1;

import java.util.Arrays;

public class RemoveValue {

    public int removeElementInplace(int[] numbers, int val) {
        int write = 0;
        for (int read = 0; read < numbers.length; read++) {
            if (numbers[read] == val) {
                continue;
            }
            numbers[write] = numbers[read];
            write++;
        }
        return write;
    }

    public static void main(String[] args) {
        RemoveValue task = new RemoveValue();

        int[] a = {4, 5, 5, 4};
        int len = task.removeElementInplace(a, 4);
        System.out.println("Output: " + len + ", arr = " + Arrays.toString(Arrays.copyOf(a, len)));

        int[] b = {0, 2, 6, 6, 1, 0, 4, 6};
        len = task.removeElementInplace(b, 6);
        System.out.println("Output: " + len + ", arr = " + Arrays.toString(Arrays.copyOf(b, len)));
    }
}
