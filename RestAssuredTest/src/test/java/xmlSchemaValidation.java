
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class xmlSchemaValidation {
	
	@Test
	void xmlValodation() {
		
		given()
		
		.when()
			.get("https://mocktarget.apigee.net/xml")
		
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlschema.xsd"));
	}

}
