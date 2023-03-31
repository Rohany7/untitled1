import org.apache.commons.logging.Log;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void VerifyLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(properties.getProperty("name"),properties.getProperty("pass"));
    }
    @Test
    public void TestMethod() {
        System.out.println("In test method");
    }
}
