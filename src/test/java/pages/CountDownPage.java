package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class CountDownPage extends Page {

    // Page Elements
    private final By currentCountDownNumberSelector = By.cssSelector("#root > div > main > div.EggTimer-timer-wrapper > div > div.ClassicTimer-inner > p > span");

    public CountDownPage(WebDriver driver) throws MalformedURLException {
        super(driver);
    }

    public int getCurrentCountDownNumber(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(currentCountDownNumberSelector));
            WebElement currentCountDownNumber = driver.findElement(currentCountDownNumberSelector);
            return Integer.parseInt(currentCountDownNumber.getText().replaceAll("\\D+",""));
        }
        catch(NumberFormatException e){
            // Return -1 in case the seconds is not the information shown on the screen
              return -1;
            }
    }

    public String getExpiredTimeInformation() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(currentCountDownNumberSelector));
        WebElement currentCountDownNumber = driver.findElement(currentCountDownNumberSelector);
        return currentCountDownNumber.getText();
    }
}
