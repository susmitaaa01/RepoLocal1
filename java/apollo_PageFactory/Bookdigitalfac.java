package apollo_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;

public class Bookdigitalfac {
	WebDriver driver;
	 
	//=======================XPATH,ID AND CSS FOR LOCATING THE ELEMENT======================================    
     
    @FindBy(xpath="//a[@title=\"Covid Consultation\"]")
    WebElement covidConslt;
    
    @FindBy(xpath="(//span[text()=\"Book Digital Consult\"])[1]")
    WebElement sortOption;
    
    @FindBy(xpath="(//p[@class=\"SlotsCalendar_dateInRed__0qY_n\"])[1]")
    WebElement date;
     
    @FindBy(xpath="(//input[@name=\"hi\"])[1]")
    WebElement slot;
    
    @FindBy(xpath="(//button[@type=\"button\"])[8]")
    WebElement payment;
    
  //=====================METHODS FOR LOCATING ELEMENT===============================================//
    
    // Constructor to initialize the driver and Page Factory
    public Bookdigitalfac(WebDriver driver) {
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
    
    public void scrollDown() throws InterruptedException {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scroll(0,300)");
	    Thread.sleep(1000);
    }
    public void clickSortOptn() throws InterruptedException {
    	Thread.sleep(1000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", sortOption);
    }
    
    public void clickDateOptn() throws InterruptedException {
    	Thread.sleep(1000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",date );
    }
    
   
    public void clickSlotOptn() throws InterruptedException {
    	Thread.sleep(1000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",slot);
    }
    
    public void clickPaymentOptn() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",payment);
    	
    }
    public void scrollDown1() throws InterruptedException {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scroll(0,700)");
	    Thread.sleep(1000);
    }
   
    
}
  
    
