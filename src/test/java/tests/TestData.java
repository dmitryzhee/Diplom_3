package tests;

import java.util.Random;

public interface TestData {

  String BASE_URI = "https://stellarburgers.nomoreparties.site/";

  String USER_CREATION_ENDPOINT = "/api/auth/register";

  String USER_DATA_ENDPOINT = "/api/auth/user";

  String LOGIN_ENDPOINT = "/api/auth/login";

  Random random = new Random();

  User USER = User.builder().email("burger-test@test.com").password("Aa12345").name("Alex").build();

  User RANDOM_USER = User.builder().email(String.format("test-burger%s@test.com", random.nextInt(9999))).password("Aa12345").name("John").build();


}
