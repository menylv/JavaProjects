package Edible;


public class Person {

    private String name;
    @SuppressWarnings("unused")
    private Edible eat;

    public Person(String name) {
        this.name = name;
    }

    public String eating(Edible eat) {
        return name + " is eating " + eat.howToEat();
    }
}
