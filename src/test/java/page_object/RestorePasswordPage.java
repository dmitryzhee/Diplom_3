package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {

  private WebDriver driver;

  public RestorePasswordPage(WebDriver driver) {
    this.driver = driver;
  }

  //ссылка "Войти"
  private By loginLink = By.xpath("//a[text()='Войти']");

  public void clickLoginLink() {
    driver.findElement(loginLink).click();
  }

}
