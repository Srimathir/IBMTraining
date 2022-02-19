package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchStepDef {
	WebDriver driver;
	WebElement searchbox;
	
	
	@Given("^User should be on google homepage$")
	public void user_should_be_on_google_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srimathi\\Documents\\SDET- Full stack testing course\\chromedriver_win32 (4)\\chromedriver.exe");
		driver=new ChromeDriver();
//		driver.get("https://google.com/");  
	}

	@When("^the search bar is visible$")
	public void the_search_bar_is_visible() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		searchbox=driver.findElement(By.name("q"));
		System.out.println(driver.findElement(By.name("q")).isDisplayed());
	}

	@Then("^Enter text entering text$")
	public void enter_text_entering_text() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("q")).sendKeys("entering text");
	}
		
		
		
//		-------------------------------JANBASKTRAINING REGISTER NOW--------------------------------
		
		@Given("^User should be on janbasktraining register page$")
		public void user_should_be_on_janbasktraining_register_page() {
		    // Write code here that turns the phrase above into concrete actions
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srimathi\\Documents\\SDET- Full stack testing course\\chromedriver_win32 (4)\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://www.janbasktraining.com/register");	  	    
		}

		@When("^Register Now form is visible$")
		public void register_Now_form_is_visible() {
		    // Write code here that turns the phrase above into concrete actions
			String value=driver.findElement(By.tagName("h3")).getText();
			System.out.println("Value:"+value);
			System.out.println("Registration form visibility:"+driver.findElement(By.tagName("h3")).isDisplayed());    
		}

		@Then("^Enter your name$")
		public void enter_your_name() {
		    // Write code here that turns the phrase above into concrete actions
		    driver.findElement(By.name("reg_name")).sendKeys("Srimathi");
		}

		@Then("^Enter mobile number$")
		public void enter_mobile_number() {
		    // Write code here that turns the phrase above into concrete actions
		    driver.findElement(By.name("reg_mobile")).sendKeys("1234567891");
		}

		@Then("^Select course$")
		public void select_course()  {
		    // Write code here that turns the phrase above into concrete actions
			WebElement course=driver.findElement(By.name("reg_course"));
			course.click();
			Select selectCourse=new Select(course);
			selectCourse.selectByValue("5");
		}

		@Then("^Enter email$")
		public void enter_email() {
		    // Write code here that turns the phrase above into concrete actions
		   driver.findElement(By.name("reg_email")).sendKeys("abc@gmail.com");
		}

		@Then("^Retype email$")
		public void retype_email()  {
		    // Write code here that turns the phrase above into concrete actions
			driver.findElement(By.name("reg_con_email")).sendKeys("abc@gmail.com");
		   
		}

		@Then("^Enter password$")
		public void enter_password()  {
		    // Write code here that turns the phrase above into concrete actions
		    driver.findElement(By.name("reg_password")).sendKeys("P@ssword123");
		}

		@Then("^Confirm password$")
		public void confirm_password()  {
		    // Write code here that turns the phrase above into concrete actions
		    driver.findElement(By.name("reg_con_password")).sendKeys("P@ssword123");
		}

		@Then("^Check agree T&C checkbox$")
		public void check_agree_T_C_checkbox()  {
		    // Write code here that turns the phrase above into concrete actions
			WebElement checkBox=driver.findElement(By.id("reg_tandc"));
			checkBox.click();
		    
		}

		@Then("^Click on Sign Up button$")
		public void click_on_Sign_Up_button()  {
		    // Write code here that turns the phrase above into concrete actions
			driver.findElement(By.id("submitBtn")).click();
		    
		}


		
		
	    
	



}
