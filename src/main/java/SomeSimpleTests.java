import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class SomeSimpleTests {
    @Test
    public void testSearchGoogle() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        if (searchBox.isDisplayed()) {
            System.out.println("searchBox is Displayed");
        }
        if (searchBox.isEnabled()) {
            System.out.println("searchBox is Enabled");
        }
        searchBox.sendKeys("ChromeDriver");
        searchBox.clear();
        searchBox.click();
        if (searchBox.isSelected()) {
            System.out.println("searchBox is Selected");
        } else System.out.println("searchBox is NOT Selected");
        searchBox.sendKeys("Java");
        searchBox.submit();
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.quit();
    }
    @Test
    public void hidingElementsTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://next.privat24.ua/money-transfer/card?lang=en");
        WebElement addCommentButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".commentToggler_Jy6hnlSrFB")));
        addCommentButton.click();
        WebElement commentField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sc-ehkVkK")));
        WebElement closeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title=\"Close\"]")));
        closeButton.click();
        //ExpectedConditions.stalenessOf return False when element isEnabled and True when it's disabled.
        Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(commentField)));
        Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(addCommentButton)));
        driver.quit();
    }
}
