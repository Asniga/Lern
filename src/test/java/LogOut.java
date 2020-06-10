import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LogOut extends TestBase {

    @Before
    public void ensurePreconditions() {   //proverka zalogiroval li User
      if (!isUserLoggedIn()){
          logIn();
      }
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//div[@class='firstTitle']//span[contains(text(),',')]"));
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Test
    public void logOut() {
        clickOnLogOut ();
    }


}
