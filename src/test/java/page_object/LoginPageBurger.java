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

  //ссылка "Восстановить пароль"
  private By restorePassword = By.xpath("//a[text()='Восстановить пароль']");

  //поле "Email"
  private By emailField = By.xpath("//label[text()='Email']/following-sibling::input");

  //поле "Пароль"
  private By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input");

  //кнопка "Войти"
  private By loginButton = By.xpath("//button[text()='Войти']");

  public By getLoginButton() {
    return loginButton;
  }

  public void clickRegisterLink() {
    driver.findElement(registerLink).click();
  }

  public void clickRestorePasswordLink() {
    driver.findElement(restorePassword).click();
  }

  public void fillEmailField (String email) {
    driver.findElement(emailField).click();
    driver.findElement(emailField).sendKeys(email);
  }

  public void fillPasswordField (String password) {
    driver.findElement(passwordField).click();
    driver.findElement(passwordField).sendKeys(password);
  }

  public void clickLoginButton() {
    driver.findElement(loginButton).click();
  }

  public void login(String email, String password) {
    fillEmailField(email);
    fillPasswordField(password);
    clickLoginButton();
  }


}
