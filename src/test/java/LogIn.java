import org.junit.Test;
import org.openqa.selenium.By;


public class LogIn extends TestBase{

    @Test
    public void testLogIn() {
        click(By.cssSelector("#ctl00_ucNavigationBar_ucNavigationBarAreaLeft_ancOnline"));
        switchWindow();
        type(By.cssSelector("#identifyWithPasswordCitizenId"), "123");
        type(By.cssSelector("#password"), "sinsin");
        click(By.xpath("//button[@class='submit validatePassword']"));
    }
}