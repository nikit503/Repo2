package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        Connection connection;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@Nikitos_PC:1521:orcl", "oracul", "qwe123");

        } catch (SQLException e) {
            System.out.println("Ошибка соединения с БД!");
            e.printStackTrace();
            return;
        }
        if (connection != null) {
            System.out.println("Успех, соединение установлено!");
        } else {
            System.out.println("Ошибка соединения");
        }
    }

}
