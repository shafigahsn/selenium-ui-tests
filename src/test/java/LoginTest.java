import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validLoginTest(){
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String successMsg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(successMsg.contains("You logged into a secure area!"));
    }

    @Test
    public void invalidLoginTest() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String errorMsg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(errorMsg.contains("Your username is invalid"));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
