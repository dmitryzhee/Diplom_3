package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest implements TestData{

  protected WebDriver driver;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    driver.get(BASE_URI);
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

  }

  @After
  public void tearDown() {
    driver.quit();
  }

  public boolean isElementPresent(By by) {
    if (driver.findElement(by).isDisplayed()) {
      return true;
    } else return false;
  }
}


