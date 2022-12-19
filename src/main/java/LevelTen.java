import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class LevelTen {

    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Jason/IdeaProjects/inFormed/src/main/resources/level-10.html");  //open html file

        WebElement file = driver.findElement(By.xpath("/html/body/input"));
        WebElement review = driver.findElement(By.xpath("/html/body/button"));

        TakesScreenshot ss = (TakesScreenshot)driver;

        File screenshot = ss.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File("C:/Users/Jason/IdeaProjects/inFormed/src/main/resources/screenshot.png"));
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        file.sendKeys("C:/Users/Jason/IdeaProjects/inFormed/src/main/resources/screenshot.png");

        review.click();

    }
}
