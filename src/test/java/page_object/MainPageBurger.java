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

  //заголовок секции конструктора "Соусы"
  private By sauceSectionHeader = By.xpath("//span[text()='Соусы']");

  //заголовок секции конструктора "Начинки"
  private By fillingSectionHeader = By.xpath("//span[text()='Начинки']");

  //заголовок выбранной в данный момент секция конструктора
  private By currentSectionHeader = By.xpath("//div[contains(@class, 'tab_type_current')]");



  public By getBunSectionHeader() {
    return bunSectionHeader;
  }

  public By getCurrentSectionHeader() {
    return currentSectionHeader;
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

  public void clickBunSectionHeader() {
    driver.findElement(bunSectionHeader).click();
  }

  public void clickSauceSectionHeader() {
    driver.findElement(sauceSectionHeader).click();
  }

  public void clickFillingSectionHeader() {
    driver.findElement(fillingSectionHeader).click();
  }



}
