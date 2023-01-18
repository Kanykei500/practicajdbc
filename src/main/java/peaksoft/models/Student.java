package peaksoft.models;

public class Student {
    private long id;
    private String name;
    private Byte age;

    public Student(long id, String name, byte age) {
        this.id=id;
        this.name=name;
        this.age=age;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Student(String name, Byte age) {
        this.name = name;
        this.age = age;
    }

    public Student() {


    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
