package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePageBurger {

  private WebDriver driver;

  public ProfilePageBurger(WebDriver driver) {
    this.driver = driver;
  }

  //кнопка "Выйти"
  private By logoutButton = By.xpath("//button[text()='Выход']");

  public By getLogoutButton() {
    return logoutButton;
  }

  public void logout() {
    driver.findElement(logoutButton).click();
  }
}
