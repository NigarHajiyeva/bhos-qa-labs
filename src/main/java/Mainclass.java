import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mainclass {
    public static void main(String[] args) {
        Random rand=new Random();
        Student tom = new Student("Tom", "Johnson", "tom1@gmail.com", "IT2021");
        Student anna = new Student("Anna", "Bell", "anna1@gmail.com", "IT2021");
        Student layla = new Student("Layla", "Smith", "layla@gmail.com", "IT2021");
        Student david = new Student("David", "Brown", "dev@gmail.com", "IT2021");

        List<Student> students = new ArrayList<>();
        Classroom it2021 = new Classroom(students);
        it2021.addStudent(anna);
        it2021.addStudent(tom);
        it2021.addStudent(layla);
        it2021.addStudent(david);

        System.out.println("The all members of class:" + it2021.toString());

        System.out.println("The count of students:" + it2021.studentCount());

        it2021.deleteStudent(anna);
        System.out.println("The count of students after deleting Anna:" + it2021.studentCount());





    }
}
