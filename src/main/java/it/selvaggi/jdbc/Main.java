package it.selvaggi.jdbc;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //creo le viste
        String queryIta = "CREATE VIEW italian_students AS SELECT first_name, last_name FROM students WHERE Country = 'Italy';";
        MyJdbcUtil.updateQuery(queryIta);

        String queryGer = "CREATE VIEW german_students AS SELECT first_name, last_name FROM students WHERE Country = 'Germany';";
        MyJdbcUtil.updateQuery(queryGer);

        //select sulla vista italian
        String selectIta = "SELECT * FROM italian_students;";
        ArrayList<Student> italianStudents = MyJdbcUtil.studentQuery(selectIta);

        //stampo gli studenti italiani
        System.out.println("Stampo gli studenti italiani:");
        italianStudents.forEach(student -> System.out.println(student));

        System.out.println();

        //select sulla vista german
        String selectGer = "SELECT * FROM german_students;";
        ArrayList<Student> germanStudents = MyJdbcUtil.studentQuery(selectGer);

        //stampo gli studenti tedeschi
        System.out.println("Stampo gli studenti tedeschi:");
        germanStudents.forEach(student -> System.out.println(student));

    }

}

