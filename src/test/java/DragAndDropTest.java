import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    public void testDragAtoB(){
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        //Method1: standard Actions API(works in most real apps)
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();
        //After dragging A->B, column b should now contain header "A"
        String headerB = driver.findElement(By.cssSelector("#column-b header")).getText();
        Assert.assertEquals(headerB,"A","Column B should contain 'A' after drag");
    }
    @Test
    public void testDragBToA(){
        WebElement source = driver.findElement(By.id("column-b"));
        WebElement target = driver.findElement(By.id("column-a"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).moveToElement(target).release(target).perform();

        String headerA = driver.findElement(By.cssSelector("#column-a header")).getText();
        Assert.assertEquals(headerA,"B","Column A should contain 'B' after drag");
    }
    @AfterMethod
    public void teardown(){
        if (driver != null){
            driver.quit();
        }
    }
}
