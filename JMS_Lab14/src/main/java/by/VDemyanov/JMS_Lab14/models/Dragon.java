package by.VDemyanov.JMS_Lab14.models;

public class Dragon {
    private int id;
    private String name;
    private int power;
    private int health;

    public Dragon() {

    }

    public Dragon(int id, String name, int power, int health) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", power=" + power +
                ", health=" + health +
                '}';
    }
}
