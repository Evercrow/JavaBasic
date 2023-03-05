package Lesson7.Homework7;

import java.util.ArrayList;

import java.util.List;


/**
 * 3)класс Basket, содержащий массив купленных товаров.
 */
public class Basket {

    ArrayList<Merch> orderlist ;

    public Basket() {
        this.orderlist = new ArrayList<>();
    }
    public Basket(Merch[] merchList){
        this.orderlist = new ArrayList(List.of(merchList));

    }


    protected void clear(){
        orderlist.clear();
    }

    protected void addToBasket(Merch m){
        orderlist.add(m);
    }

    protected void removeFromBasket(Merch m){
        orderlist.remove(m);
    }

    public void showBasket() {
        System.out.println(orderlist.toString());
    }

    @Override
    public String toString() {
        return orderlist.toString();
    }
}
