import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class LevelNine {

    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Jason/IdeaProjects/inFormed/src/main/resources/level-9.html");  //open html file

        WebElement Box = driver.findElement(By.xpath("/html/body/form/input"));

        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30)) // how long in total to wait for page load
                .pollingEvery(Duration.ofNanos(1)) //during those seconds - we are looking at DOM every 1 seconds
                .ignoring(ElementNotInteractableException.class) //if any exception occurs - we ignore it and keep polling
                .until(ExpectedConditions.visibilityOf(Box))
                .sendKeys("a");

        WebElement submit = driver.findElement(By.xpath("/html/body/form/button"));

        submit.click();

    }
}
