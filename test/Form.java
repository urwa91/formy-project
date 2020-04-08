import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class Form {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        FormPages formPages = new FormPages();
        FormPages.submitForm(driver);

        ConfirmationPage confirmationPage = new ConfirmationPage();
        ConfirmationPage.waitForAlertBanner(driver);

        assertEquals("The form was successfully submitted!", ConfirmationPage.getAlertBannerText(driver));

        driver.quit();
    }



}
