package innopolis.lesson1.person;

public class Person implements Comparable<Person> {

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


    @Override
    public int compareTo(Person o) {
        int compareRes = 0;
        //Сортирока мужикоффф
            compareRes = o.getSex().compareTo(getSex());
            if (compareRes == 0) {
                //Сортируем по возрасту
                compareRes = new Integer(o.getAge()).compareTo(getAge());
                if (compareRes == 0) {
                    //Сортировка по имени
                    compareRes = getName().compareTo(o.getName());
                }
            }
        return compareRes;
    }
}
