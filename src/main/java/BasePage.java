import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(WebElement element, String value) {
        element.sendKeys(value);
    }
    public void click(WebElement element) {
        element.click();
    }

}
