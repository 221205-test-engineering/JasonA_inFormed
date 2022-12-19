import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import javax.swing.*;
import java.time.Duration;

public class LevelSix {

    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Jason/IdeaProjects/inFormed/src/main/resources/level-6a.html");  //open html file

        //link 1 /html/body/form/h5[1]/a
        //button1 /html/body/button
        //link 2 /html/body/form/h5[2]/a
        //button2 /html/body/button
        ///submit button html/body/form/button

        String mainWindow = driver.getWindowHandle();

        WebElement link1 = driver.findElement(By.xpath("/html/body/form/h5[1]/a"));
        WebElement link2 = driver.findElement(By.xpath("/html/body/form/h5[2]/a"));
        WebElement submit = driver.findElement(By.xpath("html/body/form/button"));


        //open link 1
        new Actions(driver)
                .keyDown(Keys.CONTROL) //holds down CTRL button, when we click it will open a new tab
                .click(link1)
                .keyUp(Keys.CONTROL)   //release CTRL button
                .build()
                .perform();

        //switch to first tab
        for(String childWindow : driver.getWindowHandles()) {
            //If window handle is not main window, close it
            if (!childWindow.equals(mainWindow)) {
                driver.switchTo().window(childWindow);

                WebElement btn1 = driver.findElement(By.xpath("/html/body/button"));

                btn1.click();

                //Close child window
                driver.close();
            }
        }
        //switch back to main window
        driver.switchTo().window(mainWindow);

        //open link2
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .click(link2)
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

        //switch to first tab
        for(String childWindow : driver.getWindowHandles()) {
            //If window handle is not main window, close it
            if (!childWindow.equals(mainWindow)) {
                driver.switchTo().window(childWindow);

                WebElement btn2 = driver.findElement(By.xpath("/html/body/button"));

                btn2.click();

                //Close child window
                driver.close();
            }
        }
        //switch back to main window
        driver.switchTo().window(mainWindow);

        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))    //how long in total to wait for page to load
                .pollingEvery(Duration.ofSeconds(2))    //during the 10 seconds, look at DOM every 2 seconds
                .ignoring(ElementNotInteractableException.class)    //if an exception occurs - ignore it and keep polling
                .until(ExpectedConditions.visibilityOf(submit));    //the condition is the button has to be visible

        submit.click();

    }
}
