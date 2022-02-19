package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class elearningStepDef {
	WebDriver driver;

	@Given("^User should be on eleaning homepage$")
	public void user_should_be_on_eleaning_homepage() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Srimathi\\Documents\\SDET- Full stack testing course\\chromedriver_win32 (4)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
	}

	@When("^Sign up button is visible click on sign up button$")
	public void click_on_sign_up_button() {
		// Write code here that turns the phrase above into concrete actions
		WebElement signupButton = driver.findElement(By.linkText("Sign up!"));
		System.out.println("Is signup button visible?" + signupButton.isDisplayed());
		signupButton.click();
	}

	@Then("^Enter First name \"([^\"]*)\"$")
	public void enter_First_name_fname(String fname) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("registration_firstname")).sendKeys(fname);

	}

	@And("^Enter Last name \"([^\"]*)\"$")
	public void enter_Last_name_lname(String lname) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("registration_lastname")).sendKeys(lname);
	}

	@And("^Enter email address \"([^\"]*)\"$")
	public void enter_email_addressemail_gmail_com(String email) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("registration_email")).sendKeys(email);

	}

	@And("^Enter user name \"([^\"]*)\"$")
	public void enter_user_name_uname(String uname) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("username")).sendKeys(uname);

	}

	@And("^Enter password \"([^\"]*)\"$")
	public void enter_password_pass(String pwd) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("pass1")).sendKeys(pwd);

	}

	@And("^Enter confirm password \"([^\"]*)\"$")
	public void enter_confirm_password_pass(String cpwd) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("pass2")).sendKeys(cpwd);

	}

	@And("^Click on register button$")
	public void click_on_register_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("registration_submit")).click();

	}

	@Then("^Verify message \"([^\"]*)\"$")
	public void verify_message(String expected) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement verifyMessage = driver.findElement(By.xpath("//div[@class='row']/div/p[1]"));
		String actual = verifyMessage.getText();
		System.out.println("Message:" + actual);
		String act = actual.substring(22);
		System.out.println("Expected:" + expected);
		System.out.println("Message1:" + act);
		if (expected.contentEquals(act)) {
			System.out.println("Pass");
		} else
			System.out.println("Verification failed");
	}

	@Given("^User logged in using the login credentials \"([^\"]*)\"  and \"([^\"]*)\"$")
	public void user_logged_in_using_the_login_credentials_and(String username, String password) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Srimathi\\Documents\\SDET- Full stack testing course\\chromedriver_win32 (4)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		driver.findElement(By.id("login")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submitAuth")).click();
		//driver.findElement(By.id("form-login_submitAuth")).click();
	}

	@When("^User is on my course page$")
	public void user_is_on_my_course_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// String expected= "My courses";
		System.out.println("Driver is in:" + driver.findElement(By.xpath("//ul[@class='breadcrumb']/li")).getText());

	}

	@Then("^Click on compose button$")
	public void click_on_compose_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Compose")).click();

	}

	@Then("^enter recepient details$")
	public void enter_recepient_details() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("rew@gmail.com");
		driver.findElement(By.xpath("//div[@xpath=1]")).click();
	}

	@Then("^enter subject$")
	public void enter_subject() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("compose_message_title")).sendKeys("Subject01");

	}

	@Then("^enter message$")
	public void enter_message() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement frame=driver.findElement(By.xpath("//div[@id='cke_1_contents']/iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//html/body/p")).sendKeys("Entering message");
		

	}

	@Then("^clickon send message button$")
	public void clickon_send_message_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("compose_message_compose")).click();

	}
	
	@When("^User clicked on edit profile$")
	public void user_clicked_on_edit_profile() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.linkText("Edit profile")).click();
	}

	@Then("^Upload image$")
	public void upload_image() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(1000);
//		WebElement element = driver.findElement(By.name("picture"));
//		System.out.println("Is element vidible?"+element.isDisplayed());
//		WebElement button1=driver.findElement(By.id("file-upload-button"));
//		WebElement button2=driver.findElement(By.cssSelector("picture_form"));
// JavascriptExecutor executor = (JavascriptExecutor)driver;
// executor.executeScript("arguments[0].click();", button2);
// System.out.println("eee");
// WebElement button3=driver.findElement(By.xpath("//input[@type='button']"));
// executor.executeScript("arguments[0].click();", button3);

 
		// StringSelection ss = new StringSelection("C:\\Users\\Srimathi\\Pictures\\Capture.png");
		
		driver.findElement(By.name("picture")).sendKeys("C:\\Users\\Srimathi\\Pictures\\c1.png"); 	
	    
	}

	@And("^Enter skype details \"([^\"]*)\"$")
	public void enter_skype_details(String skypeDet)throws Throwable
	{
		driver.findElement(By.name("extra_skype")).sendKeys(skypeDet);
	}

	
	@Then("^save the changes$")
	public void save_the_changes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("apply_change")).click();
	    
	}
}
