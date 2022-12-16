import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class LevelOne {

    static WebDriver driver;
    public static void main(String [] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Jason/IdeaProjects/inFormed/src/main/resources/level-1.html");  //open html file

        String str = driver.findElement(By.id("randomString")).getText();

        WebElement input = driver.findElement(By.xpath("/html/body/form/input"));
        WebElement submit = driver.findElement(By.xpath("/html/body/form/button"));
        input.sendKeys(str);

        submit.click();

    }
}
