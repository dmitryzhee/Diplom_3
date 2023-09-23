package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageBurger {

  private WebDriver driver;

  public LoginPageBurger(WebDriver driver) {
    this.driver = driver;
  }

  //ссылка на регистрацию
  private By registerLink = By.xpath("//a[text()='Зарегистрироваться']");

  public void clickRegisterLink() {
    driver.findElement(registerLink).click();
  }


}
