import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by VGE on 10.05.2016.
 */
class LoginPageObject {
    private WebDriver driver;

    @FindBy(id = "loginForm:nameInputField")
    private WebElement nameInputField;

    @FindBy(id = "loginForm:passwordInputField")
    private WebElement passwordInputField;

    @FindBy(id = "loginForm:loginButton")
    private WebElement loginButton;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    void open(String url) {
        driver.get(url);
    }

    void close() {
        driver.quit();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    void login(String name, String password) {
        nameInputField.sendKeys(name);
        passwordInputField.sendKeys(password);
        loginButton.click();
    }

    public void typeName(String name) {
        nameInputField.sendKeys(name);
    }

    public void typePassword(String password) {
        passwordInputField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
