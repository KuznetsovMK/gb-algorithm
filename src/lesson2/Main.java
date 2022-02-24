package lesson2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 10000;
        int cnt = 0;
        Random random = new Random();
        Notebook[] arr = new Notebook[n];

        while (true) {
            int t = random.nextInt(2000);
            if ((t % 50 == 0) && (t >= 500 && t <= 2000)) {
                   arr[cnt] = new Notebook()
            }
        }

    }
}
