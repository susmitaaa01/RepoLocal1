package apollo_PageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchspecialities {
	WebDriver driver;
	
	//=======================XPATH,ID AND CSS FOR LOCATING THE ELEMENT======================================   
	
	@FindBy(xpath = "//a[@title=\"Covid Consultation\"]")
	WebElement covidConslt;
	@FindBy(xpath = "(//input[@placeholder=\"Search Doctors, Specialities, Conditions etc.\"])[2]")
	WebElement doctorsName;

	@FindBy(xpath="(//a[@href=\"/doctors/dr-ekta-pandey-1f5eed2a-3f67-48cd-8d8d-e07a7fbbf02d?source=Listing_Page\"])[2]")
	WebElement specialist;
	
	@FindBy(xpath="//h1[text()=\"Dr. Ekta Pandey\"]")
	WebElement dr;
	
	
	//=====================METHODS FOR LOCATING ELEMENT===============================================//
	// Constructor to initialize the driver and Page Factory
		public Searchspecialities(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	public void homepage() throws InterruptedException {
		covidConslt.click();
		Thread.sleep(2000);
		String mainWindowHandle = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle);
			}
		}
		
	}
	public void doctorname() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", doctorsName);

	}

	
	public void specialists(String name) throws InterruptedException {
		doctorsName.sendKeys(name);
		Thread.sleep(1000);
		specialist.click();
	}
	
	public String verify()
	{
		String msg=dr.getText();
		return msg;
	}
	

	
}
