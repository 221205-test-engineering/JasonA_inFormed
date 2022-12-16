import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LevelTwo {

    static WebDriver driver;
    public static void main(String[] args) throws ParseException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Jason/IdeaProjects/inFormed/src/main/resources/level-2.html");  //open html file

        String strDrop = driver.findElement(By.xpath("/html/body/dl/dd[1]")).getText();
        Select drop = new Select(driver.findElement(By.xpath("/html/body/form/select")));

        //Select dropbox
        drop.selectByVisibleText(strDrop);

        //Selecting the first checkbox
        driver.findElement(By.xpath("/html/body/form/fieldset[1]/input[1]")).click();
        //Selecting the second checkbox
        driver.findElement(By.xpath("/html/body/form/fieldset[1]/input[2]")).click();
        //Selecting the last checkbox
        driver.findElement(By.xpath("/html/body/form/fieldset[1]/input[3]")).click();

        //Select Radio Button 2
        driver.findElement(By.xpath("/html/body/form/fieldset[2]/input[2]")).click();

        //Selecting date
        String date = driver.findElement(By.xpath("/html/body/dl/dd[4]")).getText();

        //Change date format for input MM-dd-yyyy
        String startTime = date;
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
        Date dateValue = input.parse(startTime);        //Add an exception or try and catch for parse.
        SimpleDateFormat output = new SimpleDateFormat("MM-dd-yyyy");

        WebElement datebox = driver.findElement(By.xpath("/html/body/form/input"));
        datebox.sendKeys(output.format(dateValue));

        //Select button to submit
        String strButton = driver.findElement(By.xpath("/html/body/dl/dd[5]")).getText();

        if (strButton.equals("1")) {
            driver.findElement(By.xpath("/html/body/form/button[1]")).click();
        } else if(strButton.equals("2")) {
            driver.findElement(By.xpath("/html/body/form/button[2]")).click();
        } else {
            driver.findElement(By.xpath("/html/body/form/button[3]")).click();
        }

    }
}
