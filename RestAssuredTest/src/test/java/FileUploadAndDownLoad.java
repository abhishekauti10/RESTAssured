import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUploadAndDownLoad {

	@Test
	void fileUpload() {
		
		File myFile = new File("/Users/abhishekauti/Downloads/students.json");
		
		given()
			.multiPart("file", myFile)
			.contentType("multipart/form-data")
			
		
		.when()
			.post("https://the-internet.herokuapp.com/upload")
			
		.then()
			.body("html.body[1].div[1].div.form,input.id", equalTo("students.json"));
		
	}
	
	void fileDownload() {
		
		given()
		
		.when()
			.post("https://the-internet.herokuapp.com/download/selenium-snapshot.png")
			
		.then()
			.log().body();
		
	}
}
