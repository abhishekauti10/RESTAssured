package chainingAPI;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import org.json.JSONObject;

public class UpdateUser {

	@Test
	void updateUser(ITestContext context) {

		Faker fk = new Faker();

		JSONObject data = new JSONObject();

		data.put("name", fk.name().fullName());
		data.put("gender", "male");
		data.put("email",fk.internet().emailAddress());
		data.put("status", "active");

		String BearerToken = "622f6702ba7bd871b66390b7f91d41cfc3fe714250565d5308bffb46155cbeba";

		int id = (Integer) context.getAttribute("user_id"); 		// Gets id value from CREATEUSER
		
		given()
			.headers("Authorization", "Bearer "+ BearerToken)
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())
				
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
				
		.then()
			.statusCode(200)
			.log().all();
				
	}
}
