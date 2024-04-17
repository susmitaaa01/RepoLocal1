package apollo_PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagefac {
	WebDriver driver;
	 public LoginPagefac(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	//=======================XPATH,ID AND CSS FOR LOCATING THE ELEMENT======================================    
	
	 @FindBy(xpath="(//button[@type=\\\"button\\\"])[8]")
	WebElement payment;
	
	//=====================METHODS FOR LOCATING ELEMENT===============================================//
	public void userLogin() throws InterruptedException 
	{
	 Thread.sleep(20000);
             
	}
	
	
	public void addMember() {
//		fname.sendKeys("hello");
		
	}
}


