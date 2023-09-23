package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageBurger {

  private WebDriver driver;

  public MainPageBurger(WebDriver driver) {
    this.driver = driver;
  }

  //кнопка "Личный кабинет"
  private By profileButton = By.xpath("//p[text()='Личный Кабинет']");

  public void pressProfileButton() {
    driver.findElement(profileButton).click();
  }



}
