package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class bubble {
    public static void bubbleSort(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = 0; j < numbers.size() - 1 - i; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {

                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(4,3,1,5,2));

        System.out.println(numbers);

        bubbleSort(numbers);

        System.out.println(numbers);
    }
}
