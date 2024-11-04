import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;

public class SerializationDeserialization {
	
	// converting POJO -----> JSON
	
	@Test
	void serialization() throws JsonProcessingException {
		
		POJOforPOSTrequests stupojo = new POJOforPOSTrequests();
		
		stupojo.setName("govind");
		stupojo.setLocation("pune");
		stupojo.setPhone("890654321");
		
		String courses[] = {"abc","efg"};
		stupojo.setCourses(courses);
		
		ObjectMapper om = new ObjectMapper();
		
		String jsondata = om.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
		
		System.out.println(jsondata);
		
	}
	
	// converting JSON -----> POJO
	@Test
	void deSerialization() throws JsonMappingException, JsonProcessingException {
		
		String jsondata = "{\n"
				+ "  \"name\" : \"govind\",\n"
				+ "  \"location\" : \"pune\",\n"
				+ "  \"phone\" : \"890654321\",\n"
				+ "  \"courses\" : [ \"abc\", \"efg\" ]\n"
				+ "}";
		ObjectMapper om = new ObjectMapper();
		
		POJOforPOSTrequests stupojo = om.readValue(jsondata, POJOforPOSTrequests.class);
		
		System.out.println("name "+stupojo.name);
		System.out.println("location "+stupojo.location);
		System.out.println("phone "+stupojo.phone);
		System.out.println("coure 1 "+stupojo.getCourses()[0]);
		System.out.println("coure 2 "+stupojo.getCourses()[1]);
				
	}

}
