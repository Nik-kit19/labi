package labs.labi2_3;

public class Student implements Comparable<Student> {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student o) {
        int c = name.compareTo(o.name);
        return c != 0 ? c : Integer.compare(age, o.age);
    }
}
