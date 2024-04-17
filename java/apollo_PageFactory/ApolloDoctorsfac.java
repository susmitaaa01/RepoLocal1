package apollo_PageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApolloDoctorsfac {
	WebDriver driver;
	 
 //=======================XPATH,ID AND CSS FOR LOCATING THE ELEMENT======================================    
    @FindBy(xpath="//a[@title=\"Covid Consultation\"]")
    WebElement covidConslt;
    
    @FindBy(xpath="(//span[@class=\"MuiButton-label\"])[1]")
    WebElement doctors;
    
    @FindBy(xpath="(//img[@src=\"https://images.apollo247.in/brandlogos/apolloDoctor.png?tr=w-200,q-80,f-webp,dpr-1.5,c-at_max\"])[4]")
    WebElement apollotag;
    
    @FindBy(xpath="(//div[@class=\"MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 MuiGrid-grid-md-6 MuiGrid-grid-lg-4\"])[4]")
    WebElement apollodr;
    
    
  //=====================METHODS FOR LOCATING ELEMENT===============================================//
 
    // Constructor to initialize the driver and Page Factory
    public ApolloDoctorsfac(WebDriver driver) {
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
    Thread.sleep(1000);

   }
    public void clickDoctors() throws InterruptedException {
    	Thread.sleep(1000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", doctors);
    }
    

    public String verifyMethod()
    {
    	String frame=apollodr.getText();
    	return frame;
    }
    
    
}




