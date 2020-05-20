package Animals;

public class Fish extends Wild {
    public Fish(int id, int age, double weight, String color, boolean isPredator) {
        super(id, age, weight, color, isPredator);
    }

    @Override
    public String voice() {
        return "o_o";
    }
}
