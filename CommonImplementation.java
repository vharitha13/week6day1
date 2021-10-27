package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonImplementation extends BaseClass {

	@Given("Open the Chrome browser")
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@And("Launch the URL as {string}")
	public void launchURL(String url) {
		driver.get(url);
	}

	@And("Enter the username as {string}")
	public void enterUsername(String username) {
		driver.findElement(By.xpath("//input[contains(@name,'USER')]")).sendKeys(username);
	}

	@And("Enter the password as {string}")
	public void enterPassWord(String password) {
		driver.findElement(By.xpath("(//input[contains(@class,'inputLogin')])[2]")).sendKeys(password);
	}

	@When("Click on login button")
	public void clickLogin() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("Homepage should be displayed")
	public void displayHomePage() {
		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
		if (link.isDisplayed() == true) {
			System.out.println("The home page is displayed");
		} else
			System.out.println("Home Page is not displayed");
	}

	@When("Click on {string} link")
	public void clickLink(String linkText) throws InterruptedException {
		WebElement link = driver.findElement(By.linkText(linkText));
		Thread.sleep(2000);
		link.click();

	}

	@Then("{string} page should be displayed")
	public void verifyPageDisplay(String pageName) {
		boolean displayed = driver.findElement(By.linkText(pageName)).isDisplayed();
		if (displayed) {
			System.out.println(pageName + "is displayed");
		} else
			System.out.println(pageName + "is not displayed");

	}

	@When("Click on Create Lead button")
	public void clickCreateLead() {
		driver.findElement(By.name("submitButton")).click();

	}

}
