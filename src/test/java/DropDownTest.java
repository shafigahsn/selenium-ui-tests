import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDownTest {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void testSelectOptionOne(){
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Option 1");

        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1");
    }
    @Test
    public void testSelectOptionTwo(){
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Option 2");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 2");
    }
    @AfterClass
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }

}
