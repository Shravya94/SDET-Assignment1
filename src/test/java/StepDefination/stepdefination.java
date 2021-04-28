package StepDefination;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepdefination {
	WebDriver driver = hooks.driver;

	@Given("^User is at the Upsill SignUp page$")
	public void user_is_at_the_upsill_signup_page() throws Throwable {
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text() = ' Sign up! ' ]")).click();
		System.out.println("User is at the Upsill SignUp page");
	}

	@When("^User enters FirstName with (.+)$")
	public void user_enters_firstname_with(String FirstName) throws Throwable {
		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		System.out.println("User enters FirstName");
	}

	@And("^User enters LastName with (.+)$")
	public void user_enters_lastname_with(String LastName) throws Throwable {
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		System.out.println("User enters LastName");
	}

	@And("^User enters Email with (.+)$")
	public void user_enters_email_with(String Email) throws Throwable {
		driver.findElement(By.name("email")).sendKeys(Email);
		System.out.println("User enters Email");
	}

	@And("^User enters Username$")
	public void user_enters_username() throws Throwable {
		// driver.findElement(By.name("username")).sendKeys(Username);
		String Uniqueuseranme = RandomStringUtils.randomAlphanumeric(6);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Uniqueuseranme);
		System.out.println("User enters Username");
	}

	@And("^User enters Password with (.+)$")
	public void user_enters_password_with(String Password) throws Throwable {
		driver.findElement(By.name("pass1")).sendKeys(Password);
		System.out.println("User enters Password");
	}

	@And("^User confirms Password with (.+)$")
	public void user_confirms_password_with(String Password) throws Throwable {
		driver.findElement(By.name("pass2")).sendKeys(Password);
		System.out.println("User confirms Password");
	}

	@And("^User enters Phone with (.+)$")
	public void user_enters_phone_with(String Phone) throws Throwable {
		driver.findElement(By.name("phone")).sendKeys(Phone);
		System.out.println("User enters Phone");
	}

	@And("^User clicks Register button$")
	public void user_clicks_register_button() throws Throwable {
		driver.findElement(By.id("registration_submit")).click();
		System.out.println("User clicks Register button");
	}

	@And("^User Validates Message with Dear (.+),(.+)$")
	public void user_validates_message_with_dear_(String firstname, String lastname) throws Throwable {
		String wlcmTxt = "Your personal settings have been registered.";
		String ExpectedMsg = "Dear" + " " + firstname + " " + lastname + "," + "\n\n" + wlcmTxt;
		String ActualMsg = driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-12']/p[1]")).getText();
		System.out.println(ActualMsg.equals(ExpectedMsg));
		System.out.println("User Validates Message");
	}

	@And("^User Validates Email with (.+)$")
	public void user_validates_email_with(String email) throws Throwable {// *[@id="navbar"]/ul[2]/li[2]/a/span[2]
		driver.findElement(By.xpath("//a/span[@class='caret']")).click();
		driver.findElement(By.xpath("//p[@class='name']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='email-overflow']")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='email-overflow']")).isDisplayed());
		System.out.println("User Validates Email");

	}

	@Then("^User is at mail page$")
	public void user_is_at_mail_page() throws Throwable {
		driver.findElement(By.xpath("//a/span[@class='caret']")).click();
		driver.findElement(By.xpath("//a[contains(.,' Inbox')]")).click();
		System.out.println("User is at mail page");
	}

	@And("^User clicks Compose Mail$")
	public void user_clicks_compose_mail() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Homepage')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Compose')]")).click();
		System.out.println("User clicks Compose Mail");

	}

	@And("^User enters Send to field with (.+)$")
	public void user_enters_send_to_field_with(String SendTo) throws Throwable {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(SendTo);
		Thread.sleep(2000L);
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@id,'users-results')]"));
		for (WebElement option : options) {
			System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase("virat kohli (virat)")) {
				option.click();
				break;
			}
		}
		System.out.println("User enters Send to field");
	}

	@And("^User enters Subject with (.+)$")
	public void user_enters_subject_with(String Subject) throws Throwable {
		driver.findElement(By.id("compose_message_title")).sendKeys(Subject);
		System.out.println("User enters Subject");
	}

	@And("^User enters Message Body with (.+)$")
	public void user_enters_message_body_with(String Message) throws Throwable {
		Thread.sleep(9000L);
		System.out.println(driver.findElements(By.tagName("iframe")).size());

		WebElement framebody = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(framebody);

		driver.findElement(By.xpath("//body[contains(@class,'editable cke')]")).sendKeys(Message);
		driver.switchTo().defaultContent();
		System.out.println("User enters Message Body");
	}

	@And("^User send the mail$")
	public void user_send_the_mail() throws Throwable {
		driver.findElement(By.name("compose")).click();
		System.out.println("User send the mail");
	}

	@And("^User Validates the sent message$")
	public void user_validates_the_sent_message() throws Throwable {
		String ExpectedMsg = "The message has been sent to virat kohli (virat)";
		String ActualMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(ActualMsg.equals(ExpectedMsg));
		System.out.println("User Validates the sent message");
	}
}
