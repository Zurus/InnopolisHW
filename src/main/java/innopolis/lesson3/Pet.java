package innopolis.lesson3;


import innopolis.lesson1.person.Person;

public class Pet implements Comparable<Pet> {
    private String serial;
    private String name;
    private Person owner;
    private int weight;

    public Pet(String serial, String name, Person owner, int weight) {
        this.serial = serial;
        this.name = name;
        this.owner = owner;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return serial.equals(pet.serial);
    }

    @Override
    public int hashCode() {
        return serial.toCharArray()[0];
    }

    @Override
    public int compareTo(Pet o) {
        int compareRes = 0;
        compareRes = getOwner().compareTo(o.getOwner());
        if (compareRes == 0) {
            compareRes = name.compareTo(o.getName());
            if (compareRes == 0) {
                compareRes = (new Integer(weight)).compareTo(o.getWeight());
            }
        }
        return compareRes;
    }

    public String getSerial() {
        return serial;
    }

    public String getName() {
        return name;
    }

    public Person getOwner() {
        return owner;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "serial='" + serial + '\'' +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", weight=" + weight +
                '}';
    }
}
