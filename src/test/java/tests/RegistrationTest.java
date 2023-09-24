package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page_object.LoginPageBurger;
import page_object.MainPageBurger;
import page_object.RegistrationPageBurger;

public class RegistrationTest extends BaseTest{

  private MainPageBurger mainPageBurger;

  private LoginPageBurger loginPageBurger;

  private RegistrationPageBurger registrationPageBurger;


  @Test
  public void registrationSuccess() {
    mainPageBurger = new MainPageBurger(driver);
    loginPageBurger = new LoginPageBurger(driver);
    registrationPageBurger = new RegistrationPageBurger(driver);
    mainPageBurger.pressProfileButton();
    loginPageBurger.clickRegisterLink();
    registrationPageBurger.register("Иван", "testburger8398@burger.test", "12345");
  }
}
