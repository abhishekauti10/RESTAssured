package chainingAPI;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import static io.restassured.RestAssured.*;


public class GetUser {

	@Test
	void getUser(ITestContext context) {
		
		int id = (Integer)context.getAttribute("user_id");			// Gets id value from CREATEUSER
		
		String BearerToken = "622f6702ba7bd871b66390b7f91d41cfc3fe714250565d5308bffb46155cbeba";
		
		given()
			.headers("Authorization", "Bearer " + BearerToken)
			.pathParam("id", id)
		
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
			
		.then()
			.statusCode(200)
			.log().all();
	}
}
