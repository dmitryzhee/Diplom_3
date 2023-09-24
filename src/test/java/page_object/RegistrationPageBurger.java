package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPageBurger {

  private WebDriver driver;

  public RegistrationPageBurger(WebDriver driver) {
    this.driver = driver;
  }

  //поле "Имя"
  private By nameField = By.xpath("//label[text()='Имя']/following-sibling::input");
  //поле "Email"
  private By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
  //поле "Пароль"
  private By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input");
  //кнопка "Зарегистрироваться"
  private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");

  //ссылка "Войти"
  private By loginLink = By.xpath("//a[text()='Войти']");


  public void fillNameField (String name) {
    driver.findElement(nameField).click();
    driver.findElement(nameField).sendKeys(name);
  }

  public void fillEmailField (String email) {
    driver.findElement(emailField).click();
    driver.findElement(emailField).sendKeys(email);
  }

  public void fillPasswordField (String password) {
    driver.findElement(passwordField).click();
    driver.findElement(passwordField).sendKeys(password);
  }

  public void pressRegisterButton() {
    driver.findElement(registerButton).click();
  }

  public void register(String name, String email, String password) {
    fillNameField(name);
    fillEmailField(email);
    fillPasswordField(password);
    pressRegisterButton();
  }

  public void clickLoginLink() {
    driver.findElement(loginLink).click();
  }


}
