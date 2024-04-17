package apollo_PageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchDoctorsfac {
	WebDriver driver;

	//=======================XPATH,ID AND CSS FOR LOCATING THE ELEMENT======================================    
	
	@FindBy(xpath = "//a[@title=\"Covid Consultation\"]")
	WebElement covidConslt;

	@FindBy(xpath = "(//div[@class=\"InfoCardPartner_doctorAvatar__dlIkL\"])[1]")
	WebElement doctorsName;

	//=====================METHODS FOR LOCATING ELEMENT===============================================//
	
	// Constructor to initialize the driver and Page Factory
		public SearchDoctorsfac(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
	public void homepage() throws InterruptedException
    {
   	covidConslt.click();
   	Thread.sleep(2000);
   	String mainWindowHandle = driver.getWindowHandle();
    for (String windowHandle : driver.getWindowHandles()) {
        if (!windowHandle.equals(mainWindowHandle)) {
            driver.switchTo().window(windowHandle);}
           
    }
    
 }

	public void doctorsname() throws InterruptedException {
        Thread.sleep(2000);
		doctorsName.click();

	}
}
