import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    @Test
    public void testSearchGoogle(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        if (searchBox.isDisplayed()) {
            System.out.println("searchBox is Displayed");}
        if (searchBox.isEnabled()) {
            System.out.println("searchBox is Enabled");}
        searchBox.sendKeys("ChromeDriver");
        searchBox.clear();
        searchBox.click();
        if(searchBox.isSelected()){
            System.out.println("searchBox is Selected");}
        else System.out.println("searchBox is NOT Selected");
        searchBox.sendKeys("Java");
        searchBox.submit();
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.quit();
    }
}
