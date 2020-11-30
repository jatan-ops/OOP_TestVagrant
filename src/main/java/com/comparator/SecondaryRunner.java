package com.comparator;

import com.comparator.APIDataExtractor.ExtractAPIData;
import com.comparator.UIDataExtractor.ExtractUIData;
import com.comparator.UIDataExtractor.ValidateCityAndTemp;
import com.comparator.Util.DataReader;
import com.comparator.Util.GetWebDriver;
import org.openqa.selenium.WebDriver;

public class SecondaryRunner {

    ValidateCityAndTemp validateCityAndTemp = new ValidateCityAndTemp();

    private String cityName;
    public WebDriver driver;

    public void init () {
        cityName = DataReader.getCityName();
        driver = GetWebDriver.getDriverDetails();
    }

    public void execute () {

        if (validateCityAndTemp.searchAndSelectCity(cityName,driver)) {
            WeatherComparator weatherComparator = new WeatherComparator(cityName, driver);

            weatherComparator.compareTemperature();
            weatherComparator.compareHumidity();
        }
        else {
            System.out.println("City not validated");
        }

        driver.quit();
    }

}
