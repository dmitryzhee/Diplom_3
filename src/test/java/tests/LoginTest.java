package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page_object.LoginPageBurger;
import page_object.MainPageBurger;
import page_object.RegistrationPageBurger;
import page_object.RestorePasswordPage;


public class LoginTest extends BaseTest implements TestData {

  private BurgersClient client = new BurgersClient();
  private RequestSpecification requestSpecification;

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
  public void mainPageButtonLoginSuccess() {
    user = USER;
    client.createUser(user);
    MainPageBurger mainPageBurger = new MainPageBurger(driver);
    LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
    mainPageBurger.clickLoginLink();
    loginPageBurger.login(user.getEmail(), user.getPassword());
  }

  @Test
  public void profileLoginSuccess() {
    user = USER;
    client.createUser(user);
    MainPageBurger mainPageBurger = new MainPageBurger(driver);
    LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
    mainPageBurger.clickProfileButton();
    loginPageBurger.login(user.getEmail(), user.getPassword());
  }

  @Test
  public void registrationPageLoginSuccess() {
    user = USER;
    client.createUser(user);
    MainPageBurger mainPageBurger = new MainPageBurger(driver);
    LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
    RegistrationPageBurger registrationPageBurger = new RegistrationPageBurger(driver);
    mainPageBurger.clickLoginLink();
    loginPageBurger.clickRegisterLink();
    registrationPageBurger.clickLoginLink();
    loginPageBurger.login(user.getEmail(), user.getPassword());
  }

  @Test
  public void restorePasswordPageLoginSuccess() {
    user = USER;
    client.createUser(user);
    MainPageBurger mainPageBurger = new MainPageBurger(driver);
    LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
    RestorePasswordPage restorePasswordPage = new RestorePasswordPage(driver);
    mainPageBurger.clickLoginLink();
    loginPageBurger.clickRestorePasswordLink();
    restorePasswordPage.clickLoginLink();
    loginPageBurger.login(user.getEmail(), user.getPassword());
  }


}
