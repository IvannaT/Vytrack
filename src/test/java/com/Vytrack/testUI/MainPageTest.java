package com.Vytrack.testUI;

import com.Vytrack.pageUI.MainPage;
import com.Vytrack.utilities.ConfigurationReader;
import com.Vytrack.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest {

    String baseUrl = ConfigurationReader.getProperty("env");
    MainPage mainPage = new MainPage();

    /**
     * verification grid setting button location
     *
     */
    @Test
    public void verifyGridSettingButtonLocation(){
        Driver.getDriver().get(baseUrl);
        mainPage.loginPage();
        mainPage.clickFleetDropDown();
        mainPage.clickVehicleOptionBtn();
        Assert.assertTrue(mainPage.settingButton.isEnabled(),"Setting button is Disabled");
        Assert.assertTrue(mainPage.settingButton.isDisplayed(),"Setting button is not present ");
        Assert.assertTrue(mainPage.isSettingButtonLocatedOnRight(),"Setting button is on a right grid panel");
    }
}
