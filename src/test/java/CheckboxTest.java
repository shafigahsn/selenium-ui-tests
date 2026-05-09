import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxTest {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkboxCanBeChecked(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.cssSelector("input[type='checkbox']:first-child"));

        if(!checkbox1.isSelected()){
            checkbox1.click();
        }
        Assert.assertTrue(checkbox1.isSelected(),"Checkbox 1 should be checked");
    }

    @Test
    public void checkboxCanBeUnchecked(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox2 = driver.findElement(By.cssSelector("input[type='checkbox']:last-child"));

        if(checkbox2.isSelected()){
            checkbox2.click();
        }
        Assert.assertFalse(checkbox2.isSelected(),"Checkbox 2 should be unchecked");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
