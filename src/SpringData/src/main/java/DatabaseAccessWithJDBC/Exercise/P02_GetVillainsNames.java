package DatabaseAccessWithJDBC.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class P02_GetVillainsNames {
    private static final String CONECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "minions_db" + "?useTimezone=true&serverTimezone=UTC";
    private static final String PASSWORD = "12345";
    private static final String USERNAME = "root";

    public static void main(String[] args) throws IOException, SQLException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter user");
        String user = reader.readLine();
        user = user.trim().length() > 0 ? user : USERNAME;

        System.out.println("Enter password");
        String password = reader.readLine();
        password = password.trim().length() > 0 ? password : PASSWORD;

        Properties prop = new Properties();
        prop.setProperty("user", user);
        prop.setProperty("password", password);


        Connection con = DriverManager
                .getConnection(CONECTION_STRING + DB_NAME, prop);

        PreparedStatement preparedStatement =
                con.prepareStatement("SELECT v.`name` ,COUNT(DISTINCT mv.minion_id) as `m_count` FROM villains as v\n" +
                        "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                        "GROUP BY v.`name`\n" +
                        "HAVING m_count > ?\n" +
                        "ORDER BY m_count DESC;");

        preparedStatement.setInt(1,15);

        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            System.out.printf("| %-10s | %d |%n", result.getString("name"),
                    result.getInt("m_count"));

        }

    }
}
