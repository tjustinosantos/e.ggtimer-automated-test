package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page{

    // Page Elements
    private final By enterTimeInputSelector = By.cssSelector("#EggTimer-start-time-input-text");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage navigateTo(String url){
        driver.navigate().to(url);
        return new HomePage(driver);
    }

    public HomePage typeTimeInSeconds(String seconds){
        WebElement enterTimeInputBox = driver.findElement(enterTimeInputSelector);
        enterTimeInputBox.click();
        enterTimeInputBox.sendKeys(seconds);
        return new HomePage(driver);
    }

    public HomePage pressEnter(){
        WebElement enterTimeInputBox = driver.findElement(enterTimeInputSelector);
        enterTimeInputBox.sendKeys(Keys.RETURN);
        return new HomePage(driver);
    }

}
