package by.borisevich.phone.book.tool.converter;

import by.borisevich.phone.book.tool.converter.util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by dima on 10/7/16.
 */
public class TestDatabase {

    private static final String CONNECTION_URL = "jdbc:mysql://192.168.43.138:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "!Qwerty15";
    private static final String DATABASE = "ifinances";
    private static final String TABLE = "investment";
    private static final String QUERY = "select * from " + DATABASE + "." + TABLE;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, JsonProcessingException {

//        Class.forName(DRIVER);
        Connection con = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(QUERY);
            if (rs != null) {
                System.out.println("Column Type\t\t Column Name");

                ResultSetMetaData rsmd = rs.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.println(rsmd.getColumnTypeName(i) + "\t\t\t" + rsmd.getColumnName(i));
                }
            }

            List outList = ProcessResultSetUtil.resultSetToArrayList(rs);

            ObjectMapper mapper = new ObjectMapper();

            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(outList));
        } catch (SQLException e) {
            JDBCTutorialUtilities.printSQLException(e);
        }

    }
}
