package com.Vytrack.pageUI;

import com.Vytrack.utilities.ConfigurationReader;
import com.Vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MainPage extends TestBase {
    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    String username = ConfigurationReader.getProperty("username");
    String password = ConfigurationReader.getProperty("password");

    @FindBy(id = "prependedInput")
    public WebElement emailField;
    @FindBy(id = "prependedInput2")
    public WebElement passwordField;
    @FindBy(id = "_submit")
    public WebElement loginBtn;

    @FindBy(xpath = "(//span[@*='title title-level-1'])[1]")
    public WebElement fleetDropDown;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehicleOption;

    @FindBy(xpath = "//div[@class='actions-panel pull-right form-horizontal']//*[@title='Grid Settings']//a")
    public List<WebElement> buttons;

    @FindBy(xpath = "//div[@class='actions-panel pull-right form-horizontal']//*[@title='Grid Settings']")
    public WebElement settingButton;

    /**
     * login page sign in
     */
    public void loginPage() {
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
    }

    /**
     * click fleet dropdown
     */
    public void clickFleetDropDown() {
        fleetDropDown.click();
    }

    /**
     * click vehicle option
     */
    public void clickVehicleOptionBtn() {
        vehicleOption.click();
    }

    /**
     * verify if setting grid button is enabled
     */
    public boolean isSettingButtonLocatedOnRight() {
        Boolean location = true;
        String str = "//div[@class='actions-panel pull-right form-horizontal']//*[@title='Grid Settings']";
        WebElement settingButton = Driver.getDriver().findElement(By.xpath("//div[@class='actions-panel pull-right form-horizontal']//*[@title='Grid Settings']"));
        if (settingButton.isDisplayed()) {
            if (str.contains("panel pull-right")) {
                return location;
            }
        }
        return false;
    }





}