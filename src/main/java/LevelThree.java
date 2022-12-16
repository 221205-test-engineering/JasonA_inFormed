import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class LevelThree {

    static WebDriver driver;
    public static void main(String [] args){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Jason/IdeaProjects/inFormed/src/main/resources/level-3.html");  //open html file

        WebElement Box1 = driver.findElement(By.xpath("/html/body/form/input[1]"));
        WebElement Box2 = driver.findElement(By.xpath("/html/body/form/input[2]"));
        WebElement Box3 = driver.findElement(By.xpath("/html/body/form/input[3]"));
        WebElement Box4 = driver.findElement(By.xpath("/html/body/form/input[4]"));

        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30)) // how long in total to wait for page load
                .pollingEvery(Duration.ofNanos(1)) //during those seconds - we are looking at DOM every 2 seconds
                .ignoring(ElementNotInteractableException.class) //if any exception occurs - we ignore it and keep polling
                .until(ExpectedConditions.visibilityOf(Box1))
                .sendKeys("Hello");

        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30)) // how long in total to wait for page load
                .pollingEvery(Duration.ofNanos(1)) //during those seconds - we are looking at DOM every 2 seconds
                .ignoring(ElementNotInteractableException.class) //if any exception occurs - we ignore it and keep polling
                .until(ExpectedConditions.visibilityOf(Box2))
                .sendKeys("From");

        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30)) // how long in total to wait for page load
                .pollingEvery(Duration.ofNanos(1)) //during those seconds - we are looking at DOM every 2 seconds
                .ignoring(ElementNotInteractableException.class) //if any exception occurs - we ignore it and keep polling
                .until(ExpectedConditions.visibilityOf(Box3))
                .sendKeys("Jason");

        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30)) // how long in total to wait for page load
                .pollingEvery(Duration.ofNanos(1)) //during those seconds - we are looking at DOM every 2 seconds
                .ignoring(ElementNotInteractableException.class) //if any exception occurs - we ignore it and keep polling
                .until(ExpectedConditions.visibilityOf(Box4))
                .sendKeys("Abdool");

        WebElement submit = driver.findElement(By.xpath("/html/body/form/button"));

        submit.click();

    }
}
