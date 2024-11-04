package chainingAPI;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import static io.restassured.RestAssured.*;
import com.github.javafaker.Faker;
import org.json.JSONObject;


public class CreateUser {
	
	@Test
	void createUser(ITestContext context) {
		
		Faker fk = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", fk.name().fullName());
		data.put("gender", "male");
		data.put("email",fk.internet().emailAddress());
		data.put("status", "inactive");
		
		String BearerToken = "622f6702ba7bd871b66390b7f91d41cfc3fe714250565d5308bffb46155cbeba";
		
		int id = given()
			.headers("Authorization", "Bearer "+ BearerToken)
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		
		System.out.println("Generated id = " + id);
		
		// when working at test level
//		context.setAttribute("user_id", id);
//		context.setAttribute("BearerToken", BearerToken);
		
		
		// when working at suite level
		context.getSuite().setAttribute("user_id", id);
		context.getSuite().setAttribute("BearerToken", BearerToken);
		
	}
}
