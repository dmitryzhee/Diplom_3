package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageBurger {

  private WebDriver driver;

  private PageHeaderBurger pageHeaderBurger;

  public MainPageBurger(WebDriver driver) {
    this.driver = driver;
    this.pageHeaderBurger = new PageHeaderBurger(driver);
  }


  //кнопка "Войти в аккаунт"
  private By loginLink = By.xpath("//button[text()='Войти в аккаунт']");

  //заголовок секции конструктора "Булки"
  private By bunSectionHeader = By.xpath("//span[text()='Булки']");

  //заголовок секции конструктора "Соусы"
  private By sauceSectionHeader = By.xpath("//span[text()='Соусы']");

  //заголовок секции конструктора "Начинки"
  private By fillingSectionHeader = By.xpath("//span[text()='Начинки']");

  //заголовок выбранной в данный момент секция конструктора
  private By currentSectionHeader = By.xpath("//div[contains(@class, 'tab_type_current')]");

  private By parentSection = By.xpath("..");



  public By getBunSectionHeader() {
    return bunSectionHeader;
  }

  public By getSauceSectionHeader() {
    return sauceSectionHeader;
  }

  public By getFillingSectionHeader() {
    return fillingSectionHeader;
  }

  public By getParentSection() {
    return parentSection;
  }

  public By getCurrentSectionHeader() {
    return currentSectionHeader;
  }

  public void clickProfileButton() {
    pageHeaderBurger.clickProfileLink();
  }

  public void clickLoginLink() {
    driver.findElement(loginLink).click();
  }

  public void clickConstructorLink() {
    pageHeaderBurger.clickConstructorLink();
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
