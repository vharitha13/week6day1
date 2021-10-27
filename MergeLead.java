package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MergeLead extends BaseClass {

	@When("Click on From Lead button")
	public void enterFromLead() {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	}

	@Given("Enter the from first Name as {string}")
	public void enterFromFirstName(String fName) {
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fName);
	}

	@Then("Click on From first item in the list")
	public void clickFromFirstItem() {

		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();
		System.out.println(leadID);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		driver.switchTo().window(allhandles.get(0));
	}

	@When("Click on To Lead button")
	public void enterToLead() {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();

	}

	@And("Enter the to first Name as {string}")
	public void enterToFirstName(String fName) {
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fName);

	}

	@Then("Click on To first item in the list")
	public void clickToFirstItem() {

		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		String leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"))
				.getText();
		System.out.println(leadID);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles.get(0));
	}
	
	@When("Click on Merge button")
	public void clickMergeButton() {
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Then("Verify if the leads are merged")
	public void verifyMergeLead() {
		boolean displayed = driver.findElement(By.xpath("//input[@value='Reassign']")).isDisplayed();
		if (displayed) {
			System.out.println("Merge lead is successfull");
		} else
			System.out.println("Merge lead is not successfull");
	}
	
	@When("Click on Find Leads button for merging")
	public void clickMergeFindLead() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

	}

}
