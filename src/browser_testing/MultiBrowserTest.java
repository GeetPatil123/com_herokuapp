package browser_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-3 - Project Name: com-herokuapp BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Setup chrome browser
 * * 2. Open URL
 * * 3. Print the title of the page
 * * 4. Print the current url
 * * 5. Print the page source
 * * 6. Enter the email to email field
 * * 7. Enter the password to password field
 * * 8. Close the browser
 */

public class MultiBrowserTest {

    static String browser = "Chrome";

    static String baseUrl = "http://the-internet.herokuapp.com/login";

    static WebDriver driver;

    public static void main(String[] args) {

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name: ");
        }

        //open the URL the Browser
        driver.get(baseUrl);

        //maximise the Browser
        driver.manage().window().maximize();

        //we give the implicit wait to the Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //get the Title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //get the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //get the page source
        System.out.println("Page source: " + driver.getPageSource());

        //find the userName field element
        WebElement userName = driver.findElement(By.name("username"));

        //type the userName to the username field element
        userName.sendKeys("tomsmith ");

        //find the password field element, and type the password into password field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //closing the Browser
        driver.close();


    }
}
