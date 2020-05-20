package Animals;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[13];

        animals[0] = new Animal(0, 3, 11, null);
        animals[1] = new Wild(1, 2, 12, "Gray", false);
        animals[2] = new Fish(2, 1, 0.5, "Red", true);
        animals[3] = new Giraffe(3, 4, 1000, "Brown");
        animals[4] = new Lion(4, 1, 100, "Yellow");
        animals[5] = new Wolf(5, 3, 60, "White");
        animals[6] = new Crocodile(6, 5, 400, "Green");
        animals[7] = new Pet(7, 1, 1, null, "Pet");
        animals[8] = new Cat(8, 2, 2, "White", "Tom");
        animals[9] = new Dog(9, 2, 10, "Red", "Spike");
        animals[10] = new GuideDog(10, 4, 15, "Black", "Pointer", true, true);
        animals[11] = new GuideDog(11, 1, 5, "Black and White", "Little", true, false);
        animals[12] = new Hamster(12, 1, 0.2, "White", "Marshmallow");

        for (Animal animal : animals) {
            System.out.println(animal.voice());
        }
    }
}
