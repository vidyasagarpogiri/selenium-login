import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

/**
 * Created by VGE on 11.05.2016.
 */
@RunWith(Arquillian.class)
public class LoginTimeOutTestSEL {
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
        String greetingLabelId = "greetingForm:greetingLabel";
        Graphene.waitModel().until(ExpectedConditions.visibilityOfElementLocated(By.id(greetingLabelId)));
        assertTrue(driver.findElement(By.id(greetingLabelId)).getText().equals(greetingMessage));
    }

    @After
    public void closeTheBrowser() {
        loginPage.close();
    }
}
