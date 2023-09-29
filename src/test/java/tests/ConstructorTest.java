package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import page_object.LoginPageBurger;
import page_object.MainPageBurger;

public class ConstructorTest extends BaseTest implements TestData {

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

//  @Test
//  public void sectionSelectSuccess() {
//    user = USER;
//    client.createUser(user);
//    MainPageBurger mainPageBurger = new MainPageBurger(driver);
//    mainPageBurger.clickBunSectionHeader();
//
//
//
//
//  }
}
