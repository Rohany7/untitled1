import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    WebDriver driver;

    Logger log = LogManager.getLogger();

    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement btnLogin;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void Login(String name, String pass) {

        log.info("Entering credentials");
        enterText(username,name);
        enterText(password,pass);

        log.info("clicked on login button ");
        log.trace("Clicked");
        click(btnLogin);
    }
}
