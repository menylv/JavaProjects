
interface Edible {
    String howToEat();
}

// Animal
class Animal implements Edible {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String howToEat() {
        return name + ". " + name +
               " needs to be cooked first before eating.";
    }
}

// Fruit
class Fruit implements Edible {

    protected String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String howToEat() {
        return name;
    }
}

// Apple
class Apple extends Fruit {

    public Apple(String name) {
        super(name);
    }

    public String howToEat() {
        return super.howToEat() +
               ". " + name + " can make apple pie.";
    }
}

// Orange
class Orange extends Fruit {

    public Orange(String name) {
        super(name);
    }

    public String howToEat() {
        return super.howToEat() +
               ". " + name + " can make orange butter cake.";
    }
}
