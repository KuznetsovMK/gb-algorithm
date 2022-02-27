package lesson3;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1).
 * Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.
 */

public class Main {

    public static void main(String[] args) {

        Integer[] arr1 = {1, 2};
        Integer[] arr2 = {1, 2, 4};
        Integer[] arr3 = {1, 2, 3, 4, 5, 7, 8};
        Integer[] arr4 = {1, 2, 4, 5, 6, 7, 8};

        Map<Integer[], Integer> map = new HashMap<>();
        map.put(arr1, 3);
        map.put(arr2, 3);
        map.put(arr3, 6);
        map.put(arr4, 3);

        test(map);
    }

    public static void test(Map<Integer[], Integer> map) {

        for (Map.Entry<Integer[], Integer> o : map.entrySet()) {
            Integer[] arr = o.getKey();
            Integer expected = o.getValue();
            Integer actual = actualSum(arr);

            System.out.println("Ожидаемый результат: " + expected + ", Полученный результат: " + actual);

        }
    }

    public static int actualSum(Integer[] arr) {
        int result = 0;
        for (int j : arr) {
            result += j;
        }

        int trueResult = 0;
        for (int i = 1; i <= arr.length + 1; i++) {
            trueResult += i;
        }

        return trueResult - result;
    }
}
