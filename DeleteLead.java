package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteLead extends BaseClass {

	@Given("Enter the first name for delete as {string}")
	public void enterFirstNameDel(String fName) {
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(fName);

	}

	@Then("Click on first item in the list for deleting")
	public void clickFirstItemDelete() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();

	}
	
	@Then("Verify if the lead is deleted")
	public void verifyDeleteLead() {
		String text = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		if(text.contains("Leads")) {
			System.out.println("Delete lead is successfull");
		}
		else
			System.out.println("Delete Lead is unsuccessfull");
	}
	
	@When("Click on Delete Find Leads button")
	public void clickDeleteFindLead() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

	}
}
