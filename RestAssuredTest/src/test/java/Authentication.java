import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Authentication {

	@Test
	void basicAuthentication() {
		
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	@Test
	void preemtiveAuthentication() {
		
		given()
			.auth().preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	@Test
	void digestAuthentication() {
		
		given()
			.auth().digest("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	@Test
	void bearerToken() {
		
		String bToken = "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";
		given()
			.header("Authorization","Bearer "+ bToken)
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	void oAuth1Token() {
		
		given()
			.auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecrete")
		.when()
			.get("url")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	void oAuth2Token() {
		
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	void apiKeyAuthentication() {
		
		given()
			.queryParam("appid", "2dfcf8e9381976f7022c2563b2f12861")
		.when()
			.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
		.then()
			.statusCode(200)
			.log().all();
	}
}
