package db;

import java.sql.*;

public class ConnectionHelper {

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new org.h2.Driver());
            return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTableTEST (Connection connection, Statement statement) {
        try {
            ResultSet resultSet = connection.getMetaData().getTables(null, null, "NOKIATEST", null);
            if (!resultSet.next()) {
                statement.execute("create table NOKIATEST (\n" +
                        "ID bigint (20) identity not null, \n" +
                        "DISPLAYNAME varchar(255), \n" +
                        "NAME  varchar(255) \n" +
                        ");\n");
                System.out.println("table NOKIATEST created \n");
            }else {
                System.out.println("table NOKIATEST already exists");
                fillTable(statement);
                viewTableTEST(statement);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void fillTable (Statement statement) {
        try {
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT count(*) AS rowcount FROM NOKIATEST");
            resultSet.next();
            int count = resultSet.getInt("rowcount");
            if (count == 0) {
                String query = "insert into NOKIATEST (\n" +
                        "ID, DISPLAYNAME, NAME) \n" +
                        "values (0, 'Afterdark', 'afterdark');\n";
                statement.execute(query);
                System.out.println("table NOKIATEST filling \n");
            }else {
                System.out.println("table NOKIATEST already filling");
                viewTableTEST(statement);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewTableTEST(Statement statement) {
        try {
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM NOKIATEST");
            while (resultSet.next()) {
                String displayName = resultSet.getString("DISPLAYNAME");
                String name = resultSet.getString("NAME");
                System.out.println(resultSet.getString("ID") + " " + displayName + " " + name);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
