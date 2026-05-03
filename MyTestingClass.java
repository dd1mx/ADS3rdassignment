import java.util.*;

class MyTestingClass {
    int id;
    int group;

    public MyTestingClass(int id, int group) {
        this.id = id;
        this.group = group;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyTestingClass)) return false;
        MyTestingClass other = (MyTestingClass) obj;
        return id == other.id && group == other.group;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + group;
        return result;
    }

    @Override
    public String toString() {
        return "Key{id=" + id + ", group=" + group + "}";
    }
}

class Student {
    String name;
    double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', gpa=" + gpa + "}";
    }
}