package Animals;

public class Wild extends Animal {
    private boolean isPredator;

    public Wild(int id, int age, double weight, String color, boolean isPredator) {
        super(id, age, weight, color);

        this.isPredator = isPredator;
    }

    public boolean isPredator() {
        return isPredator;
    }

    @Override
    public String voice() {
        String voice = super.voice();

        return voice + (voice.isEmpty() ? "" : ", ") + "I am a wild animal" + (isPredator ? " and I am going to eat you" : "") + ".";
    }
}
