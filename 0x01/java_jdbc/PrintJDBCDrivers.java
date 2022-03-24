import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

    public class PrintJDBCDrivers {


        public static void main(String[] args) {

            for (Enumeration<Driver> element = DriverManager.getDrivers(); element.hasMoreElements(); ) {
                Driver driver = element.nextElement();
                printDriver(driver);
            }

        }

        public static void printDriver(Driver driver) {
            String nome = driver.getClass().getName();
            int majorVersion = driver.getMajorVersion();
            int minorVersionnorVersion = driver.getMinorVersion();

            System.out.println("Nome Driver: "+nome);
            System.out.println("Driver Maior Versão: "+ majorVersion);
            System.out.println("Driver Menor Versão: "+ minorVersionnorVersion);


        }


    }

