package Lesson7.Seminar7;

public class Animal {
    protected String name;
    protected int age;


    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String animalInfo(){
        return String.format("Кличка %s , возраст %d",name,age);
    }

    public void voice(){
        System.out.println("Животное подает голос");

    }

    public void jump(){
        System.out.println("Прыжок!");
    }

    @Override
    public String toString() {
        return animalInfo();
    }
}
