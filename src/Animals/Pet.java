package Animals;

public class Pet extends Animal {
    private String name;
    private boolean isVaccinated;

    public Pet(int id, int age, double weight, String color, String name, boolean isVaccinated){
        super(id, age, weight, color);

        if (name == null) {
            this.name = "incognita";
        } else {
            this.name = name;
        }

        this.isVaccinated = isVaccinated;
    }
    public Pet(int id, int age, double weight, String color, String name){
        this(id, age, weight, color, name, false);
    }

    public void vaccinate() {
        isVaccinated = true;
    }

    public String getName() {
        return name;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    @Override
    public String voice(){
        String voice = super.voice();

        return voice + (voice.isEmpty() ? "M" : ", m") + "y name is " + name + ". ";
    }
}
