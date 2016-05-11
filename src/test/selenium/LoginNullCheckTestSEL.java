import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by VGE on 11.05.2016.
 */
@RunWith(Arquillian.class)
public class LoginNullCheckTestSEL {
    private static final String name = "PMOTest";
    private static final String password = "12345";
    private static final String greetingMessage = "Hello " + name;
    private LoginPageObject loginPage;
    @Drone
    private WebDriver driver;


    @Before
    public void openTheBrowser() {
        loginPage = PageFactory.initElements(driver, LoginPageObject.class);
        loginPage.open("http://localhost:8080/loginTimeout.xhtml");
    }

    @Test
    public void testLoginPage() {
        loginPage.login(name, password);
        while (driver.findElement(By.id("greetingForm:greetingLabel")) == null) {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }
        assertTrue(driver.findElement(By.id("greetingForm:greetingLabel")).getText().equals(greetingMessage));
    }

    @After
    public void closeTheBrowser() {
        loginPage.close();
    }
}
