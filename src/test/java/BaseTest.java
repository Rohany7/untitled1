import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class BaseTest {

    WebDriver driver;

    private String CONFIG_PATH = "/src/test/java/config.properties";   // so that nobody can change the path

    public FileInputStream fin;

    public Properties properties;

    Logger log = LogManager.getLogger(BaseTest.class);

    public BaseTest(){

    }

    @BeforeClass
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
//        driver = new EdgeDriver();
        properties = loadProperties();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        log.info("Browser is opened!");

    }

    @AfterClass
    public void teardown() {
        driver.close();
        log.info("Browser is closed..");
    }

    public Properties loadProperties() {
        String path = System.getProperty("user.dir");

        FileInputStream fin = null;
        try {
             fin = new FileInputStream(new File(path+CONFIG_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties properties = new Properties();
        try {
            properties.load(fin);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;

    }
}
