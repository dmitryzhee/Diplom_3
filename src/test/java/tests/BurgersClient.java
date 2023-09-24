package tests;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BurgersClient implements TestData {
  private RequestSpecification requestSpecification;

  public void setRequestSpecification(RequestSpecification requestSpecification) {
    this.requestSpecification = requestSpecification;
  }

  public ValidatableResponse createUser(User user) {
    return given()
            .spec(requestSpecification)
            .body(user)
            .post(USER_CREATION_ENDPOINT)
            .then()
            .log().all();
  }

  public ValidatableResponse login(User user) {
    return given()
            .spec(requestSpecification)
            .body(user)
            .post(LOGIN_ENDPOINT)
            .then()
            .log().all();
  }

  public ValidatableResponse deleteUser(String token) {
    return given()
            .spec(requestSpecification)
            .header("authorization", token)
            .delete(USER_DATA_ENDPOINT)
            .then()
            .log().all();
  }
}