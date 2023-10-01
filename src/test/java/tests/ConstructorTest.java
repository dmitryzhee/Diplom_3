package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import page_object.LoginPageBurger;
import page_object.MainPageBurger;

public class ConstructorTest extends BaseTest implements TestData {

  private BurgersClient client = new BurgersClient();
  private RequestSpecification requestSpecification;

  private MainPageBurger mainPageBurger;

  private LoginPageBurger loginPageBurger;


  private User user;

  @Before
  public void setUp() {
    super.setUp();
    requestSpecification = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .build();
    client.setRequestSpecification(requestSpecification);
    user = USER;
    client.createUser(user);
    mainPageBurger = new MainPageBurger(driver);
    loginPageBurger = new LoginPageBurger(driver);
    mainPageBurger.clickProfileButton();
    loginPageBurger.login(user.getEmail(), user.getPassword());
  }

  @After
  public void tearDown() {
    if (user.equals(USER)) {
      Authorization authorization = client.login(user).extract().as(Authorization.class);
      client.deleteUser(authorization.getAccessToken());}
    super.tearDown();
  }

  @Test
  public void bunSectionSelectSuccess() {
    Assert.assertTrue(isElementPresent(mainPageBurger.getBunSectionHeader()));
    mainPageBurger.clickFillingSectionHeader();
    mainPageBurger.clickBunSectionHeader();
    WebElement bunSectionHeader = driver.findElement(mainPageBurger.getBunSectionHeader());
    WebElement currentSectionHeaderExpected = bunSectionHeader.findElement(mainPageBurger.getParentElement()); //родитель заголовка секции изменяется при ее выборе
    WebElement currentSectionHeaderActual = driver.findElement(mainPageBurger.getCurrentSectionHeader());
    Assert.assertEquals(currentSectionHeaderExpected,currentSectionHeaderActual);
  }

  @Test
  public void sauceSectionSelectSuccess() {
    Assert.assertTrue(isElementPresent(mainPageBurger.getBunSectionHeader()));
    mainPageBurger.clickSauceSectionHeader();
    WebElement sauceSectionHeader = driver.findElement(mainPageBurger.getSauceSectionHeader());
    WebElement currentSectionHeaderExpected = sauceSectionHeader.findElement(mainPageBurger.getParentElement()); //родитель заголовка секции изменяется при ее выборе
    WebElement currentSectionHeaderActual = driver.findElement(mainPageBurger.getCurrentSectionHeader());
    Assert.assertEquals(currentSectionHeaderExpected,currentSectionHeaderActual);
  }

  @Test
  public void fillingSectionSelectSuccess() {
    Assert.assertTrue(isElementPresent(mainPageBurger.getBunSectionHeader()));
    mainPageBurger.clickFillingSectionHeader();
    WebElement fillingSectionHeader = driver.findElement(mainPageBurger.getFillingSectionHeader());
    WebElement currentSectionHeaderExpected = fillingSectionHeader.findElement(mainPageBurger.getParentElement()); //родитель заголовка секции изменяется при ее выборе
    WebElement currentSectionHeaderActual = driver.findElement(mainPageBurger.getCurrentSectionHeader());
    Assert.assertEquals(currentSectionHeaderExpected,currentSectionHeaderActual);
  }
}
