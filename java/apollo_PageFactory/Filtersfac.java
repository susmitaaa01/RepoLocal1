package apollo_PageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Filtersfac {
	WebDriver driver;
	 
	
	//=======================XPATH,ID AND CSS FOR LOCATING THE ELEMENT======================================    
    
	@FindBy(xpath="//a[@title=\"Covid Consultation\"]")
    WebElement covidConslt;
    
    @FindBy(xpath="//button[@class=\"MuiButtonBase-root MuiButton-root AphButton_root__MUXTP MuiButton-text Filters_filterBtn__CF2RX\"]//span[@class=\"MuiButton-label\"]")
    WebElement filters;
    
    @FindBy(xpath="(//span[@class=\"MuiTab-wrapper\"])[2]")
    WebElement Availability;
    
    @FindBy(xpath="(//span[@class=\"MuiButton-label\"])[6]")
    WebElement tomorrow;
    @FindBy(xpath="(//span[@class=\"MuiButton-label\"])[8]")
    WebElement applyfil;
    
    @FindBy(xpath="//span[text()=\"Tomorrow\"]")
    WebElement tomo;

    //=====================METHODS FOR LOCATING ELEMENT===============================================//
    
     // Constructor to initialize the driver and Page Factory
    public Filtersfac(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public void homepage() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(4000);
		covidConslt.click();
		Thread.sleep(1000);
		String mainWindowHandle = driver.getWindowHandle();
	    for (String windowHandle : driver.getWindowHandles()) {
	        if (!windowHandle.equals(mainWindowHandle)) {
	            driver.switchTo().window(windowHandle);
	            
	        }
	    }
		
	}
	
	public void filtersection() throws InterruptedException {
		filters.click();
		Thread.sleep(1000);
		
	}
	
	public void fillter()
	{
		Availability.click();
	}

	public void dateselect() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

	public void applyfilters() throws InterruptedException {
		Thread.sleep(2000);
		applyfil.click();
		
	}
	public String message()
	{
		String msg=tomo.getText();
		return msg;
	}
}
