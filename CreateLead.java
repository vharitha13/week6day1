package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateLead extends BaseClass {

	@And("Enter the company name as {string}")
	public void enterCompName(String compName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compName);
	}

	@And("Enter the first name as {string}")
	public void enterFirstName(String fName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);

	}

	@And("Enter the last name as {string}")
	public void enterLastName(String lName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);

	}
	
	@Then("Verify creation of the lead")
	public void verifyCreation() {
		String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("Lead:" +text+ "is created");
	}

	/*
	 * @And("Click on Create Lead button") public void clickCreateLead() {
	 * driver.findElement(By.name("submitButton")).click();
	 * 
	 * }
	 */
}
