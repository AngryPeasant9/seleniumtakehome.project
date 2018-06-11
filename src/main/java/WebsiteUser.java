import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class to represent the end user of a browser. Has several basic functions like clicking, entering text, etc
 * for navigating a given webpage.
 *
 * @author Jordan Hutcheson
 */
public class WebsiteUser {

    private WebDriver UserDriver;

    /**
     * Constructor for the class.
     */
    public WebsiteUser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        UserDriver = new ChromeDriver();
    }

    /**
     * Navigates to a give url.
     *
     *@param url: Url we wish to navigate to.
     */
    public void navigateUrl(String url) {
        UserDriver.get(url);
    }

    /**
     * Enters text into the given field identified by By object.
     *
     * @param byType: By object such as By.id("email") for identifying the field we want to enter text into.
     * @param text: Text we wish to enter into the field.
     */
    public void enterText(By byType, String text) {
        WebElement field = UserDriver.findElement(byType);
        field.sendKeys(text);
    }

    /**
     * Clicks a button identified by a By object.
     *
     * @param byType: By object such as By.id("email") for identifying the button we want to click.
     */
    public void clickButton(By byType) {
        WebElement button = UserDriver.findElement(byType);
        button.click();
    }

    /**
     * Returns the WebDriver user.
     */
    public WebDriver getUserDriver(){
        return UserDriver;
    }

    /**
     * Quits the webdriver. Shutting down all browsers attached to it and ending the Webdriver instance.
     */
    public void quit(){
        UserDriver.quit();
    }
}