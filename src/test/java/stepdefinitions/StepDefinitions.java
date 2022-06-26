package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import pages.Login;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.ReusableFunc.ReusableFunction;
import com.model.Location;

public class StepDefinitions {

	Response response;
	ReusableFunction func=new ReusableFunction();
	public WebDriver driver;
	Login loginPg = PageFactory.initElements(driver, Login.class);
		//update
	@When("I send Get request api")
	public void i_send_post_api() {
	    // Write code here that turns the phrase above into concrete actions
	    /*response=given()
	            .when()
	            .get("https://reqres.in/api/users").prettyPeek();*/
		WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.gmail.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPg.email.sendKeys("kmpraveen25@gmail.com");

        //driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kmpraveen25@gmail.com");
   }
	
	@Then("verify the response status code as {int}")
	public void verify_the_response_status_code_as(int statusCode) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(),statusCode);
	}
	
	@When("I send post request api with {int},{string},{string},{string},{string},{string},{string}")
	public void i_send_post_request_api_with(int id, String email, String firstName, String lastName, String avatat, String url, String text) {
	    // Write code here that turns the phrase above into concrete actions
		Location locData=func.createLocationData(id,email,firstName,lastName,avatat,url,text);
		//JSONObject json=new JSONObject(locData);
	}

	
	/*@When("I send post request api with")
	public void postApi(){
		
		//Location locData=func.createLocationData(DEFAULT_PORT, baseURI, basePath, DEFAULT_SESSION_ID_VALUE, DEFAULT_PATH, DEFAULT_URI, DEFAULT_BODY_ROOT_PATH);
	    
		/*response=given().body("{\n" +
	           "    \"data\": {\n" +
	           "        \"id\": 2,\n" +
	           "        \"email\": \"janet.weaver@reqres.in\",\n" +
	           "        \"first_name\": \"test\",\n" +
	           "        \"last_name\": \"Weaver\",\n" +
	           "        \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\n" +
	           "    },\n" +
	           "    \"support\": {\n" +
	           "        \"url\": \"https://reqres.in/#support-heading\",\n" +
	           "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
	           "    }\n" +
	           "}").when().post("https://reqres.in/api/users/2").prettyPeek();
		/*Location location=new Location.LocationBuilder().id(20)
				.build();*/
		
	   //System.out.println("praveen post:"+response.getStatusCode());
	//}

}
