import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Collections;
import java.util.List;

public class Teste {
        public static void main(String[] argv) throws Exception {
            List drivers = Collections.list(DriverManager.getDrivers());
            for (int i = 0; i < drivers.size(); i++) {
                Driver driver = (Driver) drivers.get(i);


                String name = driver.getClass().getName();
                System.out.println("Nome do Driver " + name);


                int majorVersion = driver.getMajorVersion();
                System.out.println("Maior Versão " + majorVersion);
                int minorVersion = driver.getMinorVersion();
                System.out.println("Menor Versão " + minorVersion);

            }
        }
    }