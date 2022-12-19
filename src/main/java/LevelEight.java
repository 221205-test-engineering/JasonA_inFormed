import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LevelEight {

    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Jason/IdeaProjects/inFormed/src/main/resources/level-8.html");  //open html file

        WebElement file = driver.findElement(By.xpath("/html/body/input"));
        WebElement submit = driver.findElement(By.xpath("/html/body/button"));

        //without clicking the Choose File button, we will use Sendkeys to send
        //the absolute path of the image file which we would like to upload.
        file.sendKeys("C:/Users/Jason/IdeaProjects/inFormed/src/main/resources/lvl8text.txt");

        submit.click();

    }
}
