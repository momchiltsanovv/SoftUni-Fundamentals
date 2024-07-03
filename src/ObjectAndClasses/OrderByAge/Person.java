package ObjectAndClasses.OrderByAge;

public class Person {

    private String name, id;
    private byte age;


    public Person(String name, String id, byte age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " with ID: " + this.id + " is " + this.age + " years old.";

    }


}
