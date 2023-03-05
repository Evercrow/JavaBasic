package Lesson7.Homework7;

/**
 * 4)класс User, содержащий логин, пароль и объект класса Basket. Создать несколько объектов класса User.
 */
public class User {
    private String login;
    private String password;
    private Basket basket;

    public String getLogin() {
        return login;
    }

    public Basket getBasket() {
        return basket;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.basket = new Basket();
    }

    public void confirmOrder(Category shop){
        System.out.println(this.login+" покупает свою корзину");
        shop.removeLastitems(this.basket);
        this.basket.clear();
    }
    public void putIn(Merch m){
        basket.addToBasket(m);
    }

    public void takeOut(Merch m){
        basket.removeFromBasket(m);
    }
    public void checkBasket(){
        System.out.println("Корзина покупателя "+this.login+" :");
        this.basket.showBasket();
    }
}
