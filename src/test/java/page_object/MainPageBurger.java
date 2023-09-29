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

  //кнопка "Войти в аккаунт"
  private By loginLink = By.xpath("//p[text()='Личный Кабинет']");

  //ссылка на "Конструктор"
  private By constructorLink = By.xpath("//p[text()='Конструктор']");

  //заголовок секции конструктора "Булки"
  private By bunSectionHeader = By.xpath("//span[text()='Булки']");

  public By getBunSectionHeader() {
    return bunSectionHeader;
  }

  public void pressProfileButton() {
    driver.findElement(profileButton).click();
  }

  public void clickLoginLink() {
    driver.findElement(loginLink).click();
  }

  public void clickConstructorLink() {
    driver.findElement(constructorLink).click();
  }



}
