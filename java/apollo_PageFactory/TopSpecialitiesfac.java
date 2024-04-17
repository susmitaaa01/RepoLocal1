package apollo_PageFactory;
 
 
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
 
public class TopSpecialitiesfac {
	WebDriver driver;
 
	//=======================XPATH,ID AND CSS FOR LOCATING THE ELEMENT======================================   
    @FindBy(xpath="//a[@title=\"Covid Consultation\"]")
    WebElement covidConslt;
    
    @FindBy(xpath="//div[contains(@class, 'Filters_sortContainer__WfbbA')]")
    WebElement sortOption;
  
    @FindBy(xpath="//ul[@class=\"Filters_sortOptionList__GUYZr\"]/li[3]")
    WebElement yearOfExp;
    
    @FindBy(xpath="(//span[@title=\"Experience\"])[1]")
    WebElement exp;
    
    @FindBy(xpath="(//span[@title=\"Experience\"])[2]")
    WebElement exp2;
  
  //=====================METHODS FOR LOCATING ELEMENT===============================================//
    // Constructor to initialize the driver and Page Factory
    public TopSpecialitiesfac(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void homepage() throws InterruptedException
    {
   	covidConslt.click();
	Thread.sleep(1000);
	String mainWindowHandle = driver.getWindowHandle();
    for (String windowHandle : driver.getWindowHandles()) {
        if (!windowHandle.equals(mainWindowHandle)) {
            driver.switchTo().window(windowHandle);
            
        }
    }
    	
    }
   public void scroll() throws InterruptedException  {

		covidConslt.click();
		Thread.sleep(1000);
 }
   
    public void SortingDropdown() throws InterruptedException, AWTException  {
    	
    	sortOption.click();
    	Thread.sleep(1000);
    	
    	Robot robot=new Robot();
    	robot.keyPress(KeyEvent.VK_DOWN);
    	robot.keyRelease(KeyEvent.VK_DOWN);
    	Thread.sleep(1000);
    	
    	robot.keyPress(KeyEvent.VK_DOWN);
    	robot.keyRelease(KeyEvent.VK_DOWN);
    	Thread.sleep(1000);
    	
    	robot.keyPress(KeyEvent.VK_DOWN);
    	robot.keyRelease(KeyEvent.VK_DOWN);
    	Thread.sleep(1000);
    	
    	robot.keyPress(KeyEvent.VK_DOWN);
    	robot.keyRelease(KeyEvent.VK_DOWN);
    	Thread.sleep(1000);
    	
    	robot.keyPress(KeyEvent.VK_ENTER);
    	robot.keyRelease(KeyEvent.VK_ENTER);
    	Thread.sleep(1000);
    	
    	robot.keyPress(KeyEvent.VK_TAB);
    	robot.keyRelease(KeyEvent.VK_TAB);
    	Thread.sleep(1000);
    	
		}
   
 
	public void yearsOfExperience() throws InterruptedException {
		
		driver.findElement(By.xpath("//ul[@class=\"Filters_sortOptionList__GUYZr\"]")).click();
		driver.findElement(By.xpath("//li[text()=\"Years of Experience\"]")).click();
		Thread.sleep(4000);
	}
	
}

