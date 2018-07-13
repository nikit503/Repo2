package jdbc;

import java.sql.*;

public class Main {


    public static void main(String[] args) {

        String s = "testString";
        int id = 0;

        System.out.println("-------- Тестирование соединения с БД ------");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер отсутствует");
            e.printStackTrace();
            return;
        }

        System.out.println("Драйвер ОК!");
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Nikitos_PC:1521:orcl", "oracul", "qwe123");
             Statement statement = connection.createStatement()) {
//            System.out.println("Успех, соединение установлено!");

            statement.executeUpdate("DROP TABLE DATA");
            statement.executeUpdate("CREATE TABLE Data(ID INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1), name CHAR(30) NOT NULL)");
            statement.executeUpdate("INSERT INTO DATA (NAME) VALUES ('Maxon')");
            statement.executeUpdate("INSERT INTO DATA (NAME) VALUES ('Maxon2')");
            statement.executeUpdate("INSERT INTO DATA (NAME) VALUES ('Maxon3')");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM DATA");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("ID"));
                System.out.println(resultSet.getString("NAME"));
                System.out.println("*************");
            }
        } catch (SQLException e) {
//            System.out.println("Ошибка соединения с БД!");
            e.printStackTrace();
        }

    }

}
