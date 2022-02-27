package lesson3;

import java.util.Arrays;
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
        Integer[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        Integer[] arr6 = {1, 2, 4, 5, 6};
        Integer[] arr7 = {};

        Map<Integer[], Integer> map = new HashMap<>();
        map.put(arr1, 3);
        map.put(arr2, 3);
        map.put(arr3, 6);
        map.put(arr4, 3);
        map.put(arr5, 11);
        map.put(arr6, 3);
        map.put(arr7, 1);

        test(map);
    }

    public static int actualSum(Integer[] arr) {
        int result = 0;
        for (int j : arr) {
            result += j;
        }

        int trueResult = 0;

        int cnt = 0;
        int i = 1;
        if (arr.length > 0) {
            i = arr[0];
        }
        while (cnt < arr.length + 1) {
            trueResult += i;
            i++;
            cnt++;
        }
        return trueResult - result;
    }

    public static void test(Map<Integer[], Integer> map) {
        System.out.println("Тест2");
        for (Map.Entry<Integer[], Integer> o : map.entrySet()) {
            Integer[] arr = o.getKey();
            Integer expected = o.getValue();

            arr = smartSearch(arr);
            System.out.println("Ожидаемый результат: " + expected + ", Полученный результат: " + arr[0]);
        }
    }

    public static Integer[] smartSearch(Integer[] arr) {
        if (arr.length < 3) {
            int temp = actualSum(arr);
            Integer[] result = new Integer[1];
            result[0] = temp;
            return result;
        }

        int idx = arr[0] - 1;
        int head = 0;
        int base = 1;
        int j = 0;

        while (base + idx == arr[base - 1]) {
            head = base - 1;
            base *= 2;
            if (base > arr.length) break;
        }

        return smartSearch(Arrays.copyOfRange(arr, head, base));
    }
}
