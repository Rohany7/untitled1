import org.apache.commons.logging.Log;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void VerifyLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(properties.getProperty("name"),properties.getProperty("pass"));
    }
    @Test
    public void TestMethod2() {
        System.out.println("In test method2");
    }

    @Test
    public void TestMethod3() {
        System.out.println("In test method3");
    }
}
