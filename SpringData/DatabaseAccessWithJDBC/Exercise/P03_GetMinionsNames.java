 package DatabaseAccessWithJDBC.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class P03_GetMinionsNames {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "minions_db" + "?useTimezone=true&serverTimezone=UTC";
    private static final String PASSWORD = "12345";
    private static final String USERNAME = "root";
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ;

    public static void main(String[] args) throws IOException, SQLException {


        Properties prop = getProp(reader);

        System.out.println("Enter Villain id");
        int id = Integer.parseInt(reader.readLine());


        PreparedStatement preparedStatement = null;

        Connection con = DriverManager
                .getConnection(CONNECTION_STRING + DB_NAME, prop);

        preparedStatement = con.prepareStatement("SELECT v.name,m.`name`,m.age FROM minions as m\n" +
                "JOIN minions_villains mv on m.id = mv.minion_id\n" +
                "JOIN villains v on v.id = mv.villain_id\n" +
                "WHERE v.id = ?;");

        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            System.out.printf("| %s %s%n", "Villain: ", result.getString("v.name"));
            System.out.printf("| %-20s | %02d |%n", result.getString("m.name"),
                    result.getInt("age"));
            while (result.next()) {
                System.out.printf("| %-20s | %02d |%n", result.getString("m.name"),
                        result.getInt("age"));
            }
        } else {
            System.out.println("No villain with ID " + id + " exists in the database.");
        }


    }

    private static Properties getProp(BufferedReader reader) throws IOException {
        System.out.println("Enter user");
        String user = reader.readLine();
        user = user.trim().length() > 0 ? user : USERNAME;

        System.out.println("Enter password");
        String password = reader.readLine();
        password = password.trim().length() > 0 ? password : PASSWORD;

        Properties prop = new Properties();
        prop.setProperty("user", user);
        prop.setProperty("password", password);
        return prop;
    }
}
