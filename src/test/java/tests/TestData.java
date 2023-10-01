package tests;

import java.util.Random;

public interface TestData {

  String BASE_URI = "https://stellarburgers.nomoreparties.site/";

  String LOGIN_URI = "https://stellarburgers.nomoreparties.site/login";

  String USER_CREATION_ENDPOINT = "/api/auth/register";

  String USER_DATA_ENDPOINT = "/api/auth/user";

  String LOGIN_ENDPOINT = "/api/auth/login";

  Random random = new Random();

  User USER = User.builder().email("burgertest437@testburger.com").password("Ab12345!").name("TestyBurger").build();

  User USER_PASSWORD_TOO_SHORT = User.builder().email("burgertest400@testburger.com").password("1234").name("TestyBurger").build();

  User RANDOM_USER = User.builder().email(String.format("test-burger%s@test.com", random.nextInt(9999))).password("Aa12345").name("John").build();


}
