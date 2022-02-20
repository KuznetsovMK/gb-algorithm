package lesson1;

import java.util.ArrayList;
import java.util.List;


/**
 * 2. Определить сложность следующих алгоритмов:
 * -. Поиск элемента массива с известным индексом - O(1)
 * -. Дублирование одномерного массива через foreach - O(n^2)
 * -. Удаление элемента массива с известным индексом без сдвига - O(1)
 * -. Удаление элемента массива с неизвестным индексом без сдвига - O(n)
 * -. Удаление элемента массива с неизвестным индексом со сдвига - O(n)
 * .
 */

public class Lesson1 {
    public static void main(String[] args) {


        //a) O(n log n)
        int n = 10000;
        List<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                arrayList1.add(i * j);
            }
        }
        //140_000

        //b) O(n^2)
        n = 10000;
        List<Integer> arrayList2 = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            for (int j = i; j < n; j++) {
                arrayList2.add(i * j);
            }
        }
        //25_005_000

        //c) O(n^2)
        n = 10000;
        List<Integer> arrayList3 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayList3.add(i * j);
                n--;
            }
        }
        //9_991
    }
}
