import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @Before
    public void setUp() {
        start();
        openSite("https://www.maccabi4u.co.il/14-he/Maccabi.aspx");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        stop();
    }


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
        // selenium perenosit fokus to next window (tab) in browser
        for (String handle : wd.getWindowHandles()) {
            wd.switchTo().window(handle);
        }

        //perenesti fokus na drugoi frame
        //WebElement f = wd.findElement(By.cssSelector("locator of iframe"));
        //wd.switchTo().frame(f);
        //vernut' fokus iz frame na glavnuy stranizu
        //wd.switchTo().defaultContent();
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

public void logIn() {
    click(By.cssSelector("#ctl00_ucNavigationBar_ucNavigationBarAreaLeft_ancOnline"));
    switchWindow();
    type(By.cssSelector("#identifyWithPasswordCitizenId"), "332300003");
    type(By.cssSelector("#password"), "sinsin");
    click(By.xpath("//button[@class='submit validatePassword']"));
}
    public void clickOnLogOut() {
        wd.findElement(By.xpath("//a[@id='ctl00_ctl00_wcSiteHeaderLobby1_btnLogout']//img")).click();
    }
}
