package databaseHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentFetch {
    public ResultSet getAllStudentDetails(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery("SELECT * FROM student;");
        System.out.println("RollNumber \t Name \t Year \t Cpi");
        while (dataSet.next()) {
            //System.out.println("Name: "+ dataSet.getDouble("cpi"));
            int roll = dataSet.getInt("rollNumber");
            String name = dataSet.getString("name");
            int year = dataSet.getInt("year");
            double cpi = dataSet.getDouble("cpi");
            System.out.println(roll + "\t" + name + "\t" + year + "\t" + cpi);
        }
        return dataSet;
    }
}
