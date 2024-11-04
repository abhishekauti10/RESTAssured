package chainingAPI;
import org.testng.annotations.Test;
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
		data.put("gender", "female");
		data.put("email",fk.internet().emailAddress());
		data.put("status", "active");

//		String BearerToken = (String) context.getAttribute("BearerToken");
//		int id = (Integer) context.getAttribute("user_id"); 		// Gets id value from CREATEUSER
		
		String BearerToken = (String) context.getSuite().getAttribute("BearerToken");
		int id = (Integer) context.getSuite().getAttribute("user_id");
		
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
