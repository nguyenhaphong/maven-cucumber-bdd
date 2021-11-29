package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")
public class FacebookSteps {
	WebDriver driver;

	@Given("^Open facebook application$")
	public void openFacebookApplication() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Then("^Input to Username textbox$")
	public void inputToUsernameTextbox() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("phong@gmail.com");
	
	}

	@And("^Input to Password textbox$")
	public void inputToPasswordTextbox() {
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).clear();
	}
	
	@When("^Input to Username textbox with \"([^\"]*)\"$")
    public void inputToUsernameTextboxWithSomething(String email) {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
    }
	
	 @And("^Input to Password textbox with \"([^\"]*)\"$")
	 public void inputToPasswordTextboxWithSomething(String password) {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(password);
	 }

	@And("^Click to Submit button$")
	public void clickToSubmitButton() {
		driver.findElement(By.name("login")).click();
	}

	@And("^Close application$")
	public void closeApplication() {	
	}
	
	@When("^Input to Username and Password$")
	public void inputToUsernameAndPassword(DataTable table) {
		List<Map<String, String>> customer = table.asMaps(String.class, String.class);
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(customer.get(0).get("Username"));
		
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(customer.get(0).get("Password"));
	}

}
