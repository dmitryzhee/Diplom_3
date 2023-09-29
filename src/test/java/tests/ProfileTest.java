package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page_object.LoginPageBurger;
import page_object.MainPageBurger;
import page_object.ProfilePageBurger;

public class ProfileTest extends BaseTest implements TestData{

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
  public void profileLogoutSuccess() {
    user = USER;
    client.createUser(user);
    MainPageBurger mainPageBurger = new MainPageBurger(driver);
    LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
    ProfilePageBurger profilePageBurger = new ProfilePageBurger(driver);
    mainPageBurger.clickLoginLink();
    loginPageBurger.login(user.getEmail(), user.getPassword());
    mainPageBurger.pressProfileButton();
    profilePageBurger.logout();
    Assert.assertTrue(isElementPresent(loginPageBurger.getLoginButton()));
  }

  @Test
  public void returnToConstructorSuccess() {
    user = USER;
    client.createUser(user);
    MainPageBurger mainPageBurger = new MainPageBurger(driver);
    LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
    mainPageBurger.clickLoginLink();
    loginPageBurger.login(user.getEmail(), user.getPassword());
    mainPageBurger.pressProfileButton();
    mainPageBurger.clickConstructorLink();
    Assert.assertTrue(isElementPresent(mainPageBurger.getBunSectionHeader()));
  }

}
