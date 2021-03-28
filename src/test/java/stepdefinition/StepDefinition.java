package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.CountDownPage;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class StepDefinition {
    WebDriver driver;
    int userSetSeconds;

    @Before
    public void startUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        options.setExperimentalOption("prefs", prefs);
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), caps);;
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I visit e.ggtimer website")
    public void i_visit_eggtimer_website() throws Throwable {
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo("https://e.ggtimer.com/");
    }

    @Given("the page is completely loaded")
    public void the_page_is_completely_loaded() throws Throwable {
        //TODO
        Assert.assertTrue(true);

    }
    @When("I enter {int} seconds")
    public void i_enter_seconds(int seconds) throws Throwable {
        HomePage homePage = new HomePage(driver);
        homePage.typeTimeInSeconds(String.valueOf(seconds));
        userSetSeconds = seconds;
    }

    @When("I click on Start button to initiate the countdown")
    public void i_click_on_start_button_to_initiate_the_countdown() throws Throwable {
        HomePage homePage = new HomePage(driver);
        homePage.pressEnter();
    }

    @Then("the countdown is happening")
    public void the_countdown_is_happening_every_second() throws Throwable {
        CountDownPage countDownPage = new CountDownPage(driver);
        Thread.sleep((userSetSeconds+1) * 1000);
        Assert.assertEquals("Time Expired!", countDownPage.getExpiredTimeInformation());
    }

    @Then("the remaining time decreases in {int} second increment")
    public void the_remaining_time_decreases_in_second_increment(Integer seconds) throws Throwable {
        CountDownPage countDownPage = new CountDownPage(driver);
        int previousNumber;
        do {
            previousNumber = countDownPage.getCurrentCountDownNumber();
            Thread.sleep( seconds * 1000);
            Assert.assertTrue(previousNumber>countDownPage.getCurrentCountDownNumber());
        } while (countDownPage.getCurrentCountDownNumber() >= 0);
        // Time to consider the time "0 second"
        Thread.sleep( seconds * 1000);
        Assert.assertEquals("Time Expired!", countDownPage.getExpiredTimeInformation());
    }
}
