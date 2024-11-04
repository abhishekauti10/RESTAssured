
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.Map;

public class CookieDemo {

	@Test
	void coockies() {
		
		given()
		
		
		.when()
			.get("https://www.google.co.uk/")
			
		.then()
			.cookie("AEC","AVYB7cpU4veL5kYMYpb9bALFMkbxdvLd1XpTBdmZwR5bTnOudJWKfua5EQ")
			.log().all();
	}
	
	@Test
	void getCoockie() {
		
		Response res = given()
		
		.when()
			.get("https://www.google.co.uk/");
		
		String cv = res.getCookie("AEC");
		System.out.println("THIS IS COOCKIE = " + cv);
		
		Map <String, String> cvs = res.getCookies();
		
		for(String k : cvs.keySet()) {
			
			String cve = res.getCookie(k);
			System.out.println(k + " " + cve);
		}

	}
}
