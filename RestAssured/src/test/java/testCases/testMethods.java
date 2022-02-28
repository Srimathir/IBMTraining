package testCases;

import static org.testng.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class testMethods {

	@Test
	public void getMethod() {
		Response res = given().when().get("https://reqres.in/api/users/2");
		System.out.println(res.asString());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("resp email:" + res.path("data.email").toString());
	}

	@Test(description = "print support url")
	public void getMethod1() {

		Response res = given().when().get("https://reqres.in/api/users/2");
		System.out.println("Url: " + res.getBody().jsonPath().getString("support.url"));
	}

	@Test(description = "POST")
	public void postMethod() {
		Response res = given().header("Content-Type", "Application/JSON")
				.body("{\r\n    \"name\": \"morpheus\",\r\n    \"job\": \"leader\"\r\n}")
				.post("https://reqres.in/api/users");
		System.out.println("Response:" + res.getBody().prettyPrint());
	}

	@Test(description = "")
	public void postMethod2() throws Exception {

		String input = System.getProperty("user.dir") + "/src/test/java/input/createUser.json";
		String req = new String(Files.readAllBytes(Paths.get(input)));
		System.out.println("Request: " + req);

		Response res = given().header("Content-Type", "Application/JSON").body(req).post("https://reqres.in/api/users");
		Assert.assertEquals(res.getStatusCode(), 201);
		System.out.println("Response" + res.getBody().asString());
	}

	@Test(description = "Put")
	public void putMethodExample1() throws Exception {

		String input = System.getProperty("user.dir") + "/src/test/java/input/input.json";
		String req = new String(Files.readAllBytes(Paths.get(input)));
		System.out.println("Request body passed for PUT: " + req);

		Response res = given().header("Content-Type", "Application/JSON").body(req)
				.put("https://reqres.in/api/users/2");
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("Response:" + res.getBody().asString());
	}

	@Test(description = "Delete")
	public void deleteMethodExample1() throws Exception {

		Response res = given().header("Content-Type", "Application/JSON").delete("https://reqres.in/api/users/2");
		Assert.assertEquals(res.getStatusCode(), 204);
	}
}
