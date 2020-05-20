package Animals;

public class Dog extends Pet {
    public Dog(int id, int age, double weight, String color, String name) {
        this(id, age, weight, color, name, false);
    }

    public Dog(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }

    @Override
    public String voice() {
        String voice = super.voice();

        return voice + (voice.isEmpty() ? "" : " ") + "Woof.";
    }
}
