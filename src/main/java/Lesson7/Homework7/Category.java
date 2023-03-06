package Lesson7.Homework7;


import java.util.ArrayList;

import java.util.List;


/**
 *  2)класс Категория, имеющий переменные имя и массив товаров. Создать несколько объектов класса Категория.
 */
public class Category {
    String name;
    Merch[] assortment ;

    public Category(String name) {
        this(name, new Merch[]{new Merch()});
    }

    public Category(String name, Merch[] assortment) {
        this.name = name;
        this.assortment = assortment;
    }

    @Override
    public String toString() {
        StringBuilder m_list = new StringBuilder();
        for (Merch item:assortment){
            m_list.append(item.info());
            m_list.append("\n");
        }
        return String.format("%s\n%s",name, m_list);
    }


    public void removeLastitems(Basket basket){
        List<Merch> checked = new ArrayList<>(List.of(assortment));
        checked.removeAll(basket.orderlist);
        assortment = checked.toArray(new Merch[0]);
     //    assortment = (Merch[]) checked.toArray();  //bad behavior with non-null Merch objects

    }

    public void supply(Merch m){
        Merch[] expanded = new Merch[assortment.length+1];
        System.arraycopy(assortment,0,expanded,0,assortment.length);
        expanded[assortment.length] = m;
        this.assortment = expanded;
    }
}
