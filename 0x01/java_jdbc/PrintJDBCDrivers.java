import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Collections;
import java.util.List;

public class PrintJDBCDrivers{


    public static void printDriver(Driver driver) {

        String nome = driver.getClass().getName();
        int majorVersion = driver.getMajorVersion();
        int minorVersion = driver.getMinorVersion();

        System.out.println("Driver Name: " + nome);
        System.out.println("Driver Major Version: " + majorVersion);
        System.out.println("Driver Driver Minor: " + minorVersion);


    }

    public static void main(String[] args) {
        for (Enumeration<Driver> element = DriverManager.getDrivers(); element.hasMoreElements();) {
            Driver driver = element.nextElement();
            printDriver(driver);
        }

    }
            
        }
    