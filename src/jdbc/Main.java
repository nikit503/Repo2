package jdbc;

import java.sql.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {



    private static int  TOTALSIZE = 12;
    private static int numOfThreads = Runtime.getRuntime().availableProcessors();
//    private static int numOfThreads = 4;
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
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
//            System.out.println("Успех, соединение установлено!");

//            statement.executeUpdate("DROP TABLE DATA");
//
//            statement.executeUpdate("CREATE TABLE Data(ID INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1), name CHAR(30) NOT NULL)");
//            statement.executeUpdate("INSERT INTO DATA (NAME) VALUES ('Maxon')");
//            statement.executeUpdate("INSERT INTO DATA (NAME) VALUES ('Vacyan')");
//            statement.executeUpdate("INSERT INTO DATA (NAME) VALUES ('Толик')");
//            statement.executeUpdate("INSERT INTO DATA (NAME) VALUES ('Женек')");
//            statement.executeUpdate("INSERT INTO DATA (NAME) VALUES ('Колян')");
//
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM DATA");

            ForkJoinPool forkJoinPool = new ForkJoinPool(numOfThreads);
            forkJoinPool.invoke(new Calc(connection,1,TOTALSIZE));

//            while (resultSet.next()){
//                System.out.println(resultSet.getInt("ID"));
//                System.out.println(resultSet.getString("NAME"));
//                System.out.println("*************");
//            }


          /*  Runnable runnable = () -> {
                printBetween(1,3);

            };
*/



//            new Thread(runnable).start();
//            new Thread(runnable).start();








        } catch (SQLException e) {
//            System.out.println("Ошибка соединения с БД!");
            e.printStackTrace();
        }


    }

    static class Calc extends RecursiveTask {
        int from;
        int to;
        Connection connection;
        ResultSet resultSet;

        Calc(Connection connection, int from, int to) {
            this.from = from;
            this.to = to;
            this.connection = connection;
        }

        @Override
        protected Object compute() {
            if((to-from)<=TOTALSIZE/numOfThreads){

                try {
                    System.out.println("Init connection");
                    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    resultSet = statement.executeQuery("SELECT * FROM DATA");

                    System.out.println("from "+from+"   to  "+to+" and thread "+Thread.currentThread().getName());
                    resultSet.absolute(from-1);
                    System.out.println(Thread.currentThread().getName());
                    while (resultSet.next() && resultSet.getRow()<=to) {
                        System.out.println("Now row "+resultSet.getRow()+" and thread "+Thread.currentThread().getName()+ "   "+resultSet.getInt("ID") + "  " + resultSet.getString(2));
                    }
                    System.out.println("Close connection");
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else {
                int middle = (to+from)/2;
                Calc firstHalf = new Calc(connection, from,middle);

                firstHalf.fork();
                Calc secondHalf = new Calc(connection, middle+1,to);
                secondHalf.compute();
                firstHalf.join();
            }
            return null;
        }
    }
}
