package lesson2;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /**
         * Задание №1;
         */

        int[] priceArr = new int[31];
        int j = 0;
        for (int i = 500; i <= 2000; i += 50) {
            priceArr[j] = i;
            j++;
        }

        int[] memoryArr = new int[6];
        j = 0;
        for (int i = 4; i <= 24; i += 4) {
            memoryArr[j] = i;
            j++;
        }

        List<String> manufacturerList = new ArrayList<>(Arrays.asList("Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"));

        Map<String, Integer> manufacturerMap = new HashMap<>();
        for (int i = 0; i < manufacturerList.size(); i++) {
            manufacturerMap.put(manufacturerList.get(manufacturerList.size() - i - 1), i);
        }

        Random random = new Random();

        int n = 10000;

        Notebook[] notebooks = new Notebook[n];

        for (int i = 0; i < n; i++) {
            int priceArrayPosition = random.nextInt(priceArr.length);
            int memoryArrayPosition = random.nextInt(memoryArr.length);
            int manufacturerArrayPosition = random.nextInt(manufacturerList.size());

            notebooks[i] = new Notebook(priceArr[priceArrayPosition]
                    , memoryArr[memoryArrayPosition]
                    , manufacturerList.get(manufacturerArrayPosition));
        }
        Notebook[] sortArray = noteBookSort(notebooks, manufacturerMap);

        System.out.println(Arrays.toString(sortArray));


        /**
         * Задание №2;
         */

        Integer[] integers = {9, 7, 5, 3, 1};

        SelectionSort.sort(integers);

    }

    public static Notebook[] noteBookSort(Notebook[] notebooks, Map<String, Integer> manufacturerMap) {
        Notebook temp;

        for (int j = 0; j < notebooks.length; j++) {
            for (int i = 0; i < notebooks.length - j - 1; i++) {
                if (equalsNotebook(notebooks[i], notebooks[i + 1], manufacturerMap) == 1) {
                    temp = notebooks[i + 1];
                    notebooks[i + 1] = notebooks[i];
                    notebooks[i] = temp;
                }
            }
        }
        return notebooks;
    }

    public static int equalsNotebook(Notebook notebook1, Notebook notebook2, Map<String, Integer> manufacturerMap) {
        if (notebook1.getPrice() > notebook2.getPrice()) {
            return 1;
        }
        if (notebook1.getPrice() == notebook2.getPrice()) {
            if (notebook1.getMemory() > notebook2.getMemory()) {
                return 1;
            }
            if (notebook1.getMemory() == notebook2.getMemory()) {
                if (manufacturerMap.get(notebook1.getManufacturer()) > manufacturerMap.get(notebook2.getManufacturer()))
                    return 1;
            }
        }
        return -1;
    }
}
