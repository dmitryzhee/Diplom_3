package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.LoginPageBurger;
import page_object.MainPageBurger;
import page_object.ProfilePageBurger;
import page_object.RegistrationPageBurger;

import java.time.Duration;

public class RegistrationTest extends BaseTest{

  private BurgersClient client = new BurgersClient();

  private RequestSpecification requestSpecification;

  private MainPageBurger mainPageBurger;

  private LoginPageBurger loginPageBurger;

  private ProfilePageBurger profilePageBurger;

  private RegistrationPageBurger registrationPageBurger;

  private User user;

  @Before
  public void setUp() {
    super.setUp();
    requestSpecification = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .build();
    client.setRequestSpecification(requestSpecification);
  }

  @After
  public void tearDown() {
    if (user.equals(USER)) {
      Authorization authorization = client.login(user).extract().as(Authorization.class);
      client.deleteUser(authorization.getAccessToken());}
    super.tearDown();
  }


  @Test
  public void registrationSuccess() {
    user = USER;
    mainPageBurger = new MainPageBurger(driver);
    loginPageBurger = new LoginPageBurger(driver);
    profilePageBurger = new ProfilePageBurger(driver);
    registrationPageBurger = new RegistrationPageBurger(driver);
    mainPageBurger.clickProfileButton();
    loginPageBurger.clickRegisterLink();
    registrationPageBurger.register(user.getEmail(), user.getPassword(), user.getName());
    new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.urlToBe(LOGIN_URI));
    loginPageBurger.login(user.getEmail(), user.getPassword());
    mainPageBurger.clickProfileButton();
    Assert.assertTrue(isElementPresent(profilePageBurger.getLogoutButton()));
  }

  @Test
  public void registrationWithPasswordTooShortFailure() {
    user = USER_PASSWORD_TOO_SHORT;
    mainPageBurger = new MainPageBurger(driver);
    loginPageBurger = new LoginPageBurger(driver);
    registrationPageBurger = new RegistrationPageBurger(driver);
    mainPageBurger.clickProfileButton();
    loginPageBurger.clickRegisterLink();
    registrationPageBurger.register(user.getEmail(), user.getPassword(), user.getName());
    Assert.assertTrue(isElementPresent(registrationPageBurger.getInvalidPasswordError()));
  }




}
