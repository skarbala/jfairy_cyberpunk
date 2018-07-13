import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CyberPunkRegistrationTest {

  private WebDriver driver;

  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get("localhost:8888");
  }

  @Test
  public void testRegistration() {
    driver.findElement(By.name("email")).sendKeys("wewerwe@rwerweefewf.sk");
    driver.findElement(By.name("name")).sendKeys("efwefwefwf");
    driver.findElement(By.name("surname")).sendKeys("wefwefwef");
    driver.findElement(By.name("password")).sendKeys("password123");
    driver.findElement(By.name("passwordRepeat")).sendKeys("password123");

    driver.findElement(By.tagName("button")).click();

    String actualSuccessMessage = driver.findElement(By.cssSelector("div.success p")).getText();
    assertTrue(actualSuccessMessage.contains("efwefwefwf"));
    assertTrue(actualSuccessMessage.contains("wefwefwef"));
  }

  @After
  public void tearDown() {

  }
}
