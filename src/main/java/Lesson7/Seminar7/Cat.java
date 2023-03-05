package Lesson7.Seminar7;

public class Cat extends Animal {

        private String color;

        public Cat () {
                super("Имя");
                this.color = "Серый";
        }
        public Cat(String color) {
                super("Имя");
                this.color = color;
        }



        public Cat(String name, int age, String color) {
                super(name, age);
                this.color = color;
        }


        public String getColor() {
                return color;
        }

        public void setColor(String color) {
                this.color = color;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                if(age > 0 && age < 30){
                        this.age = age;
                } else {
                        System.out.println("Введен неверный возраст");
                }

        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }




        @Override
        public String animalInfo() {
                return String.format("%s , цвет %s",super.animalInfo(),color)  ;
        }

        @Override
        public void voice(){
                System.out.println("Мяу-мяу");

        }
}
