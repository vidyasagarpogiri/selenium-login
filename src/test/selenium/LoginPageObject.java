import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by VGE on 10.05.2016.
 */
public class LoginPageObject {
    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(name = "btnG")
    private WebElement searchButton;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void close() {
        driver.quit();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchButton.click();
    }

    public void typeSearchTerm(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public void clickOnSearch() {
        searchButton.click();
    }
}
