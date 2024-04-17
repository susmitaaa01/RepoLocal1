package apollo_StepDefinition;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import DriverSetup.BaseSteps;
import apollo_PageFactory.ApolloDoctorsfac;
import apollo_PageFactory.Bookdigitalfac;
import apollo_PageFactory.Filtersfac;
import apollo_PageFactory.LoginPagefac;
import apollo_PageFactory.SearchDoctorsfac;
import apollo_PageFactory.Searchspecialities;
import apollo_PageFactory.TopSpecialitiesfac;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class apolloStepDefinition {

	static WebDriver driver;
	TopSpecialitiesfac tp;
	SearchDoctorsfac search;
	Filtersfac filter;
	Bookdigitalfac book;
	LoginPagefac log;
	Searchspecialities sp;
	ApolloDoctorsfac ap;

	@Given("User is on homepage")
	public void user_is_on_homepage() {
		driver = BaseSteps.chromeDriver();
		tp = new TopSpecialitiesfac(driver);
	}

	@When("user navigate Covid Consultation option")
	public void user_navigate_covid_consultation_option() throws InterruptedException {
		tp.homepage();
	}

	@When("user click on the sorting option")
	public void user_click_on_the_sorting_option() throws InterruptedException, AWTException {
		tp.SortingDropdown();
	}

	@When("select the Years of Experience option from dropdown")
	public void select_the_years_of_experience_option_from_dropdown() throws InterruptedException {
		Thread.sleep(3000);
		tp.yearsOfExperience();
	}

	@Then("the list of doctors should be displayed according to the Years of Experience")
	public void the_list_of_doctors_should_be_displayed_according_to_the_years_of_experience() {
	  String text="https://www.apollo247.com/specialties/covid-consultation?sortby=experience&consultMode=BOTH&doctorCategory=APOLLO";
	  Assert.assertEquals(driver.getCurrentUrl(), text);

	}

//====================Scenario2==============================================================/

	@When("user navigates Covid Consultation option")
	public void user_navigates_covid_consultation_option() throws InterruptedException {
		search = new SearchDoctorsfac(driver);
		search.homepage();
	}

	@When("user clicks on doctor")
	public void user_clicks_on_doctor() throws InterruptedException {
		search.doctorsname();

	}

	@Then("it  should show the detailed information about the selected doctor")
	public void it_should_show_the_detailed_information_about_the_selected_doctor() {
	    String display="https://www.apollo247.com/doctors/dr-sitaram-v-chowti-017906f8-9c6e-43a0-9305-11c0588837ab?source=Listing_Page";
		Assert.assertEquals(driver.getCurrentUrl(), display );
	}

//======================Scenario3===================================================================//////////////////

	@When("user navigate Covid Consultation page")
	public void user_navigate_covid_consultation_page() throws InterruptedException {
		filter = new Filtersfac(driver);
		filter.homepage();

	}

	@And("user click on Filter option")
	public void user_click_on_filter_option() throws InterruptedException, AWTException {
		filter.filtersection();

	}

	@And("user select the Availability section")
	public void user_select_the_availability_section() throws InterruptedException, AWTException {
		filter.fillter();
		filter.dateselect();
	}

	@And("user click the apply filters")
	public void user_click_the_apply_filters() throws InterruptedException {

		filter.applyfilters();
		
	}

	@Then("user should see the list of doctors matching the search criteria")
	public void user_should_see_the_list_of_doctors_matching_the_search_criteria() {
		String act=filter.message();
		String exp="Tomorrow";
		Assert.assertEquals(act, exp);
	}

//============Scenario4=======================================================================//

	@When("user on the COVID consultation page")
	public void user_on_the_covid_consultation_page() throws InterruptedException {
		book = new Bookdigitalfac(driver);
		book.homepage();
	}

	@And("scroll down to digital cosultaion")
	public void scroll_down_to_digital_cosultaion() throws InterruptedException {
		book.scrollDown();
	}

	@And("click on book digital consultation")
	public void click_on_book_digital_consultation() throws InterruptedException {
		book.clickSortOptn();
	}

	@And("select a date for the appointment")
	public void select_a_date_for_the_appointment() throws InterruptedException {
		book.clickDateOptn();
	}

	@And("choose a slot for the appointment")
	public void choose_a_slot_for_the_appointment() throws InterruptedException {
		book.clickSlotOptn();
	}

	@Then("proceed to payment")
	public void proceed_to_payment() throws InterruptedException {
		book.clickPaymentOptn();
		log = new LoginPagefac(driver);
		log.userLogin();
		book.scrollDown1();
		String display="https://www.apollo247.com/pay-online-consult";
		Assert.assertEquals(driver.getCurrentUrl(), display );
	}

	


//=====================Scenario5=====================================================

	@When("user navigates Covid Consultation button")
	public void user_navigates_covid_consultation_button() throws InterruptedException {
		sp = new Searchspecialities(driver);
		sp.homepage();
	}

	@When("user clicks on doctors")
	public void user_clicks_on_doctors() throws InterruptedException {
		sp.doctorname();
	}
	@When("user enter the name of the specialists {string}")
	public void user_enter_the_name_of_the_specialists(String name) throws InterruptedException {
		sp.specialists(name);
		
	}

	@Then("it should displays the detailed information about the selected doctor")
	public void it_should_displays_the_detailed_information_about_the_selected_doctor() {
		String act=sp.verify();
		String exp="Dr. Ekta Pandey";
		Assert.assertEquals(act, exp);
	}

//==============================Scenario6======================================================================//	

	@When("the user clicks on Covid Consultation")
	public void the_user_clicks_on_covid_consultation() throws InterruptedException {
		ap = new ApolloDoctorsfac(driver);
		ap.homepage();
	}

	@When("the user clicks on Apollo Doctors")
	public void the_user_clicks_on_apollo_doctors() throws InterruptedException {
	    ap.clickDoctors();
	}


	@Then("the user should be able to view detailed information for only the apollo doctors")
	public void the_user_should_be_able_to_view_detailed_information_for_only_the_apollo_doctors() {
		String actual=ap.verifyMethod();
	    String expected ="Apollo Doctor";
	    Assert.assertEquals(actual,expected);
	}



	@AfterStep
	public static void takeScreendown(Scenario scenerio) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenerio.attach(src, "image/png", scenerio.getName());
	}

}
