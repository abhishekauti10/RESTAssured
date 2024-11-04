import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FakerDataGenerator {
	
	
	@Test
	void dummyDataGenerate() {
		
		Faker faker = new Faker();
		
		String fn = faker.name().firstName();
		String ln = faker.name().lastName();
		String mn = faker.phoneNumber().cellPhone();
		String ad = faker.address().fullAddress();
		
		
		System.out.println(fn);
		System.out.println(ln);
		System.out.println(mn);
		System.out.println(ad);
		
		
	}

}
