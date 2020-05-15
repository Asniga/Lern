
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OpenBrowser {
    WebDriver wd;

    @Before
    public void setUp() {
        start();
    }


    @Test
    public void chromeBrowserTest() {
        openSite("https://www.maccabi4u.co.il/14-he/Maccabi.aspx");
        click(By.cssSelector("#ctl00_ucNavigationBar_ucNavigationBarAreaLeft_ancOnline"));
        switchWindow();
        type(By.cssSelector("#identifyWithPasswordCitizenId"),"332300003");
        type(By.cssSelector("#password"),"sinsin");
        click(By.xpath("//button[@class='submit validatePassword']"));
    }




    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        stop();
    }


    //-----------------------------------
    public void start() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   // ishet locator vse vremya, poka ne proidet 5 sec
    }

    public void stop() {
        wd.quit();
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void switchWindow() {
        for (String handle : wd.getWindowHandles()) {
            wd.switchTo().window(handle);
        }   // selenium perenosit fokus to next window (tab) in browser
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }
}