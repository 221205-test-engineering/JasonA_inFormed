import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LevelFive {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Jason/IdeaProjects/inFormed/src/main/resources/level-5.html");  //open html file

        WebElement input = driver.findElement(By.cssSelector("input[type='text']"));
        WebElement btn = driver.findElement(By.xpath("/html/body/form/button[2]"));

        for (int i = 0; i <= 100; i++) {
            input.sendKeys("s");
            driver.switchTo().alert().accept(); //switch to the alert and accept the message to close it
        }
        btn.click();

    }

}
