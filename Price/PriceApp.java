// a) Interface Price
interface Price {
    void getPrice(Customer c);
}

// f) Customer
class Customer {
    private String name;
    private double salary;

    public Customer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

// b) Product
class Product implements Price {
    private String type;
    private Customer buy;

    public Product(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "The product type is " + type + ".";
    }

    // Customer buys the product if salary exceeds RM4000
    @Override
    public void getPrice(Customer c) {
        buy = c;
        System.out.println(this);   // calls the subclass toString()
        if (c.getSalary() > 4000) {
            System.out.println("The customer's name is " + c.getName() + " with salary RM"
                    + c.getSalary() + " can buy this product.");
            System.out.println("Your salary is higher than the price's product.");
        } else {
            System.out.println("The customer's name is " + c.getName() + " with salary RM"
                    + c.getSalary() + " cannot buy this product.");
            System.out.println("The product price is more than your salary.");
        }
    }
}

// c) SmartPhone
class SmartPhone extends Product {
    private String nameSP;
    private double priceSP;

    public SmartPhone(String type, String nameSP, double priceSP) {
        super(type);
        this.nameSP = nameSP;
        this.priceSP = priceSP;
    }

    @Override
    public String toString() {
        return "The product is " + nameSP + ".";
    }
}

// d) Laptop
class Laptop extends Product {
    private String nameL;
    private double priceL;

    public Laptop(String type, String nameL, double priceL) {
        super(type);
        this.nameL = nameL;
        this.priceL = priceL;
    }

    @Override
    public String toString() {
        return "The product is " + nameL + ".";
    }
}

// e) Car
class Car implements Price {
    private String brand;
    private double priceCar;
    private Customer buy;

    public Car(String brand, double priceCar) {
        this.brand = brand;
        this.priceCar = priceCar;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "The car brand is " + brand + " with price RM" + priceCar + ".";
    }

    // Customer buys the car if salary exceeds RM8000
    @Override
    public void getPrice(Customer c) {
        buy = c;
        System.out.println(this);
        if (c.getSalary() > 8000) {
            System.out.println("The customer's name is " + c.getName() + " with salary RM"
                    + c.getSalary() + " can buy this car. Your salary is higher than the price's car.");
        } else {
            System.out.println("The customer's name is " + c.getName() + " with salary RM"
                    + c.getSalary() + " cannot buy this car. The car price is more than your salary.");
        }
    }
}

// Main class (the only public class, must match the file name)
public class PriceApp {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone("SmartPhone", "Iphone 14 ProMax", 5500.00);
        Laptop lp = new Laptop("Laptop", "Lenovo Yoga", 6000.00);
        Car c = new Car("BMW", 200000);
        Customer c1 = new Customer("Sally", 3000.00);
        Customer c2 = new Customer("Aaron", 8000.00);
        Customer c3 = new Customer("Simon", 10000.00);

        sp.getPrice(c1);
        lp.getPrice(c2);
        c.getPrice(c3);
    }
}