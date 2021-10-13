import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;


    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }


    public Human() {

    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }


    public int getYear() {
        return year;
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + ",\n" +
                "surname='" + surname + ",\n" +
                "year=" + year + "\n" +
                '}';
    }

}