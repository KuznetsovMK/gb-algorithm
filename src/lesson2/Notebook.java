package lesson2;

import java.util.Objects;

public class Notebook {
    private int price;
    private int memory;
    private String manufacturer;


    public Notebook(int price, int memory, String manufacturer) {
        this.price = price;
        this.memory = memory;
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public int getMemory() {
        return memory;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", memory=" + memory +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

}
