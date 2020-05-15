
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OpenBrowser {
    WebDriver wd = new ChromeDriver();

    @Before
    public void setUp(){
        wd.get("https://www.maccabi4u.co.il/14-he/Maccabi.aspx");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void chromeBrowserTest(){
    wd.findElement(By.cssSelector("#ctl00_ucNavigationBar_ucNavigationBarAreaLeft_ancOnline")).click();
        for (String handle : wd.getWindowHandles()) { wd.switchTo().window(handle);}   // selenium perenosit fokus to next window (tab) in browser
        wd.findElement(By.cssSelector("#identifyWithPasswordCitizenId")).click();
        wd.findElement(By.cssSelector("#identifyWithPasswordCitizenId")).clear();
        wd.findElement(By.cssSelector("#identifyWithPasswordCitizenId")).sendKeys("332300003");
        wd.findElement(By.cssSelector("#password")).click();
        wd.findElement(By.cssSelector("#password")).clear();
        wd.findElement(By.cssSelector("#password")).sendKeys("sinsin");

        wd.findElement(By.xpath("//button[@class='submit validatePassword']")).click();
    }


    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        wd.quit();
    }
}