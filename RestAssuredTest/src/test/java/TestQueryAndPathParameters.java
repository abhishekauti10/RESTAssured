import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestQueryAndPathParameters {
	
	//https://reqres.in/api/users?page=2&id=5
	
	@Test
	void queryAndPathparameter() {
		
		given()
			.pathParam("mypath", "user")
			.queryParam("page", 2)
			.queryParam("id", 5)
			
		.when()
			.get("https://reqres.in/api/{mypath}")
			
			
		.then()
			.statusCode(200)
			.log().all();
	}

}
