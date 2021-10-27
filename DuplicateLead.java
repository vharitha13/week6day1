package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DuplicateLead extends BaseClass {

	@And ("Enter the first name as {string} to check duplication")
	public void enterFirstNameDup(String fName) {
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(fName);

	}

	@Then("Click on first item in the list")
	public void clickFirstItemDup() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	
	@Then("Verify if duplicate lead is created")
	public void verifyDupLead() {
		String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("Duplicate Lead:" +text+ "is created");

	}
	
	@When("Click on Find Leads button")
	public void clickFindLeads() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

	}

	/*
	 * @And("Click on Create Lead button") public void clickCreateLeadDup() {
	 * driver.findElement(By.name("submitButton")).click();
	 * 
	 * }
	 */

}
