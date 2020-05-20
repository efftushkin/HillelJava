package Animals;

public class Animal {
    int id;
    int age;
    double weight;
    String color;

    public Animal(int id, int age, double weight, String color) {
        this.id = id;
        this.age = age;
        this.weight = weight;

        if (color == null) {
            this.color = "rainbow";
        } else {
            this.color = color;
        }
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String voice() {
        return "Hello";
    }
}
