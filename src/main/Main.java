package main;

import connection.DatabaseConnection;
import databaseHelper.StudentEntry;
import databaseHelper.StudentFetch;
import student.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    StudentFetch studentFetch = new StudentFetch();
    ResultSet allStudentSet = studentFetch.getAllStudentDetails(DatabaseConnection.getConnection());

    public Main() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        db.attemptConnection();
        System.out.println("enter student roll number:");
        final Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine();
        String name = scanner.nextLine();
        int year = scanner.nextInt();
        double cpi = scanner.nextDouble();
        Student student = new Student(id, name, year, cpi);
        StudentEntry entry = new StudentEntry();
        if (entry.createNewStudentInDatabase(DatabaseConnection.getConnection(), student)) {
            System.out.println(" Successful");
        } else
            System.out.println("fail");
    }
}
