package chainingAPI;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import static io.restassured.RestAssured.*;

public class DeleteUser {
	
	@Test
	void deleteUser(ITestContext context) {
		
//		String BearerToken = (String) context.getAttribute("BearerToken");
//		int id = (Integer)context.getAttribute("user_id"); 		// Gets id value from CREATEUSER
		
		String BearerToken = (String) context.getSuite().getAttribute("BearerToken");
		int id = (Integer) context.getSuite().getAttribute("user_id");
		
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
