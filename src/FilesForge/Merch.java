package FilesForge;

import java.io.Serializable;

public class Merch implements Serializable {
    private int id;
    private String name;

    public Merch(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Merch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
