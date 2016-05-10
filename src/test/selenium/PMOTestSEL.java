import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import sun.rmi.runtime.Log;


/**
 * Created by VGE on 10.05.2016.
 */
@RunWith(Arquillian.class)
public class PMOTestSEL {
    private LoginPageObject loginPage;

    @Drone
    private WebDriver driver;


    @Before
    public void openTheBrowser() {
        loginPage = PageFactory.initElements(driver, LoginPageObject.class);
        loginPage.open("http://localhost:8080/login.xhtml");
    }

    @Test
    public void testLoginPage() {
        loginPage.login("PMOTest", "12345");
    }

    @After
    public void closeTheBrowser() {
        loginPage.close();
    }

}
