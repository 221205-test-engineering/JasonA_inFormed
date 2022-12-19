import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LevelSeven {

    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Jason/IdeaProjects/inFormed/src/main/resources/level-7.html");  //open html file

        //lgButton /html/body/button[2]
        //smButton2 /html/body/button[1]
        //submit /html/body/button[3]

        WebElement lgButton = driver.findElement(By.xpath("/html/body/button[2]"));
        WebElement smButton = driver.findElement(By.xpath("/html/body/button[1]"));
        WebElement submit = driver.findElement(By.xpath("/html/body/button[3]"));

        lgButton.click();

        //we need to get a reference to current window with driver.manage.window
        //Use dimensions to resize the window size. width and height arguments
        Dimension resize = new Dimension(500, 500);
        driver.manage().window().setSize(resize);

        smButton.click();
        submit.click();

    }
}
