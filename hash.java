
import java.util.*;

public class hash {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(30);
        hashSet.add(20);

        System.out.println(hashSet.size()); // 3

        HashSet<Student> students = new HashSet<>();

        students.add(new Student(1, "abc"));
        students.add(new Student(2, "pqr"));
        students.add(new Student(3, "xyz"));
        students.add(new Student(2, "pqr"));

        System.out.println(students.size()); // 3
    }
}

class Student {
    int rNo;
    String name;

    public Student(int rNo, String name) {
        this.rNo = rNo;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rNo, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Student other = (Student) obj;

        return rNo == other.rNo
                && Objects.equals(name, other.name);
    }
}
