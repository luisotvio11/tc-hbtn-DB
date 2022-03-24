import java.sql.*;

public class ConnectionSQLite {
    public static void main(String args[]) {

        initConnection();

        System.out.println("Database Criado com sucesso");

    }


        public static void initConnection () {
            Connection c = null;

            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:sqlite_database_2022.db");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Conexão estabelecida com sucesso");
        }
    }
