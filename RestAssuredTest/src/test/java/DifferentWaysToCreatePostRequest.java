import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

/*
Different ways to create POST request
1)POST request body using HASHMAP
2)POST request body creation using Org.JSON
3)POST request body creation using POJO class
4)POST request body external JSON file data
*/

public class DifferentWaysToCreatePostRequest {

	
	void testPOSTUsingHashmap() {		//POST request body using HASHMAP
		
		HashMap data = new HashMap();
		
		data.put("name", "abhi");
		data.put("location", "mumbai");
		data.put("phone", "123456");
		
		String courseArr[] = {"C","C++"};
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("localhostURLByJson-Server")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("abhi"))
			.body("location", equalTo("mumbai"))
			.body("phone", equalTo("123456"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
	}
	
	void testPOSTUsingJsonLibrary() {
		
		JSONObject data = new JSONObject();
		
		data.put("name", "shek");
		data.put("location", "thane");
		data.put("phone", "654321");
		
		String courseArr[] = {"java","py"};
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data.toString())				//converst json data into string format to pass
		
		.when()
			.post("localhostURLByJson-Server")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("abhi"))
			.body("location", equalTo("mumbai"))
			.body("phone", equalTo("123456"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
	}
	
	void testPOSTUsingPOJO() {
		
		POJOforPOSTrequests data = new POJOforPOSTrequests();
		
		data.setName("govind");
		data.setLocation("pune");
		data.setPhone("890654321");
		String courses[] = {"abc","efg"};
		
		data.setCourses(courses);
		
		given()
			.contentType("application/json")
			.body(data)				
			
		.when()
			.post("localhostURLByJson-Server")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("abhi"))
			.body("location", equalTo("mumbai"))
			.body("phone", equalTo("123456"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
		
	}
	
	void testPOSTusingExternalJSONfile() throws FileNotFoundException {
		
		File f = new File(".\\body.json");
		
		FileReader fr = new FileReader(f);
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data.toString())				
		
		.when()
			.post("localhostURLByJson-Server")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("abhi"))
			.body("location", equalTo("mumbai"))
			.body("phone", equalTo("123456"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
		
	}
}
