package testCases;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class petStore {
	@Test(description = "Get all available pets")
	public void getPetIDs() throws IOException {

		String input = System.getProperty("user.dir") + "/src/test/java/input/petStore.json";
		String req = new String(Files.readAllBytes(Paths.get(input)));
		System.out.println("Request: " + req);
		String baseURL="https://petstore.swagger.io/v2/pet/findByStatus?status=";
		Response res = given().header("Content-Type", "Application/JSON").body(req).get(baseURL+"available");
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.getBody().prettyPrint());
		List<Long> IDs=res.jsonPath().getList("id");
		for(Long i:IDs)
		{
			System.out.println("ID:"+i);
		}
		
	}

	@Test(description = "Add new Pet")
	public void addNewPet() throws IOException {
		String input=System.getProperty("user.dir")+"/src/test/java/input/addPet.json";
		String req=new String(Files.readAllBytes(Paths.get(input)));
		System.out.println("Request to add pet:"+req);
		String URL="https://petstore.swagger.io/v2/pet";
		Response res = given().header("Content-Type", "Application/JSON").body(req).post(URL);
		System.out.println("Response:" + res.getBody().prettyPrint());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(description = "Update image URL for Parrot")
	public void updatePet() throws IOException {
		String input=System.getProperty("user.dir")+"/src/test/java/input/updatePet.json";
		String req=new String(Files.readAllBytes(Paths.get(input)));
		System.out.println("Request to add pet:"+req);
		String URL="https://petstore.swagger.io/v2/pet";
		Response res = given().header("Content-Type", "Application/JSON").body(req).put(URL);
		System.out.println("Response:" + res.getBody().prettyPrint());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(description = "Delete one record")
	public void deletePet() throws IOException {
		String ID= "9222968140497181111";
		String URL="https://petstore.swagger.io/v2/pet/"+ID;
		Response res = given().header("Content-Type", "Application/JSON").delete(URL);
		System.out.println("Response:" + res.getBody().prettyPrint());
		Assert.assertEquals(res.getStatusCode(), 200);
	}

}
