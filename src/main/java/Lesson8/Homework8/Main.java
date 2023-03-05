package Lesson8.Homework8;

public class Main {
    public static void main(String[] args) {

        Merch[] baked = {
                new Merch("Плюшка",60,3.0F),
                new Merch("Нарезной батон",40),
                new Merch("Осетинский пирог",120,5.0F)
        };
        Merch[] milk = {new Merch(),new Merch(),new Merch()};
        Category[] shop_catalogue = {
                new Category("Хлебобулочные",baked),
                new Category("Молочные продукты",milk),
                new Category("Пустая категория")
        };



//        5)Вывести на консоль каталог продуктов. (все продукты магазина)

        System.out.println("Весь ассортимент магазина:\n");
        for (Category c: shop_catalogue){
            System.out.println(c);

        }
        //новая поставка в магазин
        System.out.println("------------");
        System.out.println("Положим на полку ватрушку");
        shop_catalogue[0].supply(new Merch("Ватрушка",65,4.5F));
        System.out.println(shop_catalogue[0]);


//        6)Вывести на консоль покупки посетителей магазина. (После покупки у пользователя добавляется товар, а из магазина - удаляется)
        System.out.println("------------");
        System.out.println("товары магазина до покупки");
        System.out.println(shop_catalogue[0]);

        User customer1 = new User("Tony", "*5**");
        customer1.putIn(new Merch("Осетинский пирог",120,5.0F));
        customer1.putIn(new Merch("ватрушка",65,4.5F));
        customer1.checkBasket();


        customer1.confirmOrder(shop_catalogue[0]);
        System.out.println("товары магазина после покупки");
        System.out.println(shop_catalogue[0]);
    }
}
