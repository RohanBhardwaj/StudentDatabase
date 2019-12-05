package databaseHelper;

import student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentEntry {
    public boolean createNewStudentInDatabase(Connection connection, Student student) throws SQLException {
//insert into student (rollNumber, name, year, cpi) VALUES (1458,'Rohan',2,8.0);
        int rollNumber = student.getRollNumber();
        String name = student.getName();
        int year = student.getYear();
        double cpi = student.getCpi();
        //PreparedStatement is an interface
        //PreparedStatement p =connection.prepareStatement("insert into student (rollNumber, name, year, cpi)"
        PreparedStatement p = connection.prepareStatement("insert into student (rollNumber, name, year, cpi)"
                + " VALUES (?,?,?,?);");//for sending data we use prepareStatement
        p.setInt(1, rollNumber);
        p.setString(2, name);
        p.setInt(3, year);
        p.setDouble(4, cpi);
        int rows = p.executeUpdate();//firing the query
        return rows >= 1;
    }
}
