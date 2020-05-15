
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    WebDriver wd = new ChromeDriver();

    @Before
    public void setUp(){
        wd.get("https://www.google.com/");
    }

    @Test
    public void chromeBrowserTest(){

    }


    @After
    public void tearDown()  {
        wd.quit();
    }
}