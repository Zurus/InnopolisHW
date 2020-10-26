package innopolis.lesson1.common;

public class Person {

    private String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                " age=" + age +
                " sex=" + sex +"}" ;
    }

    @Override
    public boolean equals(Object obj) {
        String objName = ((Person)obj).getName();
        int objAge = ((Person)obj).getAge();
        return name.equalsIgnoreCase(objName) && age == objAge;
    }
}
