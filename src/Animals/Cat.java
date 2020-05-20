package Animals;

public class Cat extends Pet {
    public Cat(int id, int age, double weight, String color, String name) {
        this(id, age, weight, color, name, false);
    }

    public Cat(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }

    @Override
    public String voice() {
        String voice = super.voice();

        return voice + (voice.isEmpty() ? "" : " ") + "Meow.";
    }}
