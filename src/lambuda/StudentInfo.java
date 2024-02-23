package lambuda;

import java.util.ArrayList;
import java.util.List;

public class StudentInfo {

    public static void main(String[] strings) {
        Student student = new Student("test1", 2);
        Student student2 = new Student("test2", 50);
        Student student3 = new Student("test3", 15);
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);
        students.add(student3);
        filterStudent(students, (Student p) -> {return p.getAge() < 30;});
        filterStudent(students, new StudentChecks() {
            @Override
            public boolean check(Student student) {
                return student.getAge() < 30;
            }
        });
    }

    static void filterStudent(List<Student> students, StudentChecks studentChecks) {
        for (Student student: students) {
            if(studentChecks.check(student)) {
                System.out.println(student);
            }
        }
    }
}
