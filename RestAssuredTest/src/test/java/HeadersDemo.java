import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {

	@Test
	void headers() {
		
		given()
		
		
		.when()
			.get("https://www.google.co.uk/")
			
		.then()
			.header("Server", "gws")
			.log().all();
	}
	
	@Test
	void getCoockie() {
		
		Response res = given()
		
		.when()
			.get("https://www.google.co.uk/");
		
		
		Headers hds = res.getHeaders();
		
		for(Header hd : hds) {
			
			System.out.println(hd.getName()+ " " + hd.getValue());
		}

	}
}
