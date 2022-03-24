import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

    public class PrintJDBCDrivers{


        public static void getDriver(Driver d) {
    
            String nome = d.getClass().getName();
            int majorVersion = d.getMajorVersion();
            int minorVersion = d.getMinorVersion();
    
            System.out.println("Driver Name: " + nome);
            System.out.println("Driver Major Version: " + majorVersion);
            System.out.println("Driver Driver Minor: " + minorVersion);
    
    
        }
    
        public static void main(String[] args) {
            for (Enumeration<Driver> element = DriverManager.getDrivers(); element.hasMoreElements();) {
                Driver driver = element.nextElement();
                getDriver(driver);
            }
    
        }
    
    }