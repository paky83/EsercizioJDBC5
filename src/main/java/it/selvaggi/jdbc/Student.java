package it.selvaggi.jdbc;

/**
 * Class Student
 * @author Pasquale Selvaggi
 */
public class Student {

    private String name;
    private String surname;

    public Student(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                '}';
    }
}
