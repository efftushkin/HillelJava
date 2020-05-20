package Animals;

public class GuideDog extends Dog {
    private boolean isTrained;

    public GuideDog(int id, int age, double weight, String color, String name) {
        this(id, age, weight, color, name, false, false);
    }
    public GuideDog(int id, int age, double weight, String color, String name, boolean isVaccinated, boolean isTrained) {
        super(id, age, weight, color, name, isVaccinated);

        this.isTrained = isTrained;
    }

    public void train() {
        isTrained = true;
    }

    public boolean isTrained() {
        return isTrained;
    }

    @Override
    public String voice() {
        String voice = super.voice();

        return voice + (isTrained ? (voice.isEmpty() ? "" : " ") + "I can take you home." : "");
    }
}
