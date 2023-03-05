package Lesson7.Homework7;

import java.util.Objects;

/**
 * 1)класс Товар, имеющий переменные имя, цена, рейтинг.
 */
public class Merch {
    private final String name;
    private final int price;
    private float rating;

    static int count = 1;



    public Merch(String name, int price, float rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        count++;
    }

    public Merch(String name, int price) {
        this(name, price,0.0F);
    }
    public Merch() {
        this("Товар"+count , 100,0.0F);
    }


    public String info() {
        return String.format("%s : %d руб. , %.1f",name,price,rating);
    }

    @Override
    public String toString() {
        return info();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Merch merch = (Merch) o;
        return price == merch.price && Float.compare(merch.rating, rating) == 0 && Objects.equals(name, merch.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, rating);
    }
}
