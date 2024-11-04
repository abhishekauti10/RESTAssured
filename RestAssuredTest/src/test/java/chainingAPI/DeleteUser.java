package chainingAPI;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import static io.restassured.RestAssured.*;

public class DeleteUser {
	
	@Test
	void deleteUser(ITestContext context) {
		
		String BearerToken = "622f6702ba7bd871b66390b7f91d41cfc3fe714250565d5308bffb46155cbeba";

		int id = (Integer)context.getAttribute("user_id"); 		// Gets id value from CREATEUSER
		
		given()
			.headers("Authorization", "Bearer " + BearerToken)
			.pathParam("id", id)
		
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
			.statusCode(204)
			.log().all();
	}

}
