import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class ParsingJSONDataResponse {

	
	@Test
	void firstResponse() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.header("X-Powered-By", "Express")
			.body("data[1].first_name",equalTo("Lindsay"));
		
	}
	
	@Test
	void secondResponse() {
		
		Response res = given()
				
				.when()
					.get("https://reqres.in/api/users?page=2");
					
		Assert.assertEquals(res.getStatusCode(),200);
		
		Assert.assertEquals(res.getHeader("Vary"),"Accept-Encoding");
		
		String lastName = res.jsonPath().get("data[1].last_name").toString();
		Assert.assertEquals(lastName, "Ferguson");
		
	}
		
}
