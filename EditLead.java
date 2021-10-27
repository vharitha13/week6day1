package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLead extends BaseClass {

	@And("Input the first name as {string}")
	public void editFirstName(String fName) {
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(fName);
	}

	@And("Input the last name as {string}")
	public void editLastName(String lName) {
		driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys(lName);

	}

	@Then("Click on first item in the list for editing")
	public void clickFirstItemEdit() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@And("Change the company name to {string}")
	public void editEnterCompany(String comp) throws InterruptedException {
		WebElement company = driver.findElement(By.id("updateLeadForm_companyName"));
		company.clear();
		Thread.sleep(2000);
		company.sendKeys(comp);
	}

	@When("Click on Update button")
	public void clickUpdate() {
		driver.findElement(By.xpath("//input[@value='Update']")).click();
	}

	@When("Click on Find Leads button in edit")
	public void clickFindLeadsButton() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

	}

	@Then("Verify if company name is updated")
	public void verifyEditLead() {
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("TCS")) {
			System.out.println("Lead's company name is edited correctly");
		} else
			System.out.println("Lead's company name is incorrect");
	}

}
