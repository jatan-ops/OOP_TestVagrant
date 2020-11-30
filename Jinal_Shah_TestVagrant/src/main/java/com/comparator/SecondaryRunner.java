package com.comparator;

import com.comparator.APIDataExtractor.ExtractAPIData;
import com.comparator.UIDataExtractor.ExtractUIData;
import com.comparator.UIDataExtractor.ValidateCityAndTemp;
import com.comparator.Util.DataReader;
import com.comparator.Util.GetWebDriver;
import org.openqa.selenium.WebDriver;

public class SecondaryRunner {

    DataReader dataReader = new DataReader();
    ValidateCityAndTemp validateCityAndTemp = new ValidateCityAndTemp();

    private String cityName;
    public WebDriver driver;
//    private Float uiTemp, uiHumidity, apiTemp, apiHumidity;

    public void init () {
        cityName = dataReader.getCityName();
        driver = GetWebDriver.getDriverDetails();
    }

    public void execute () {

        if (validateCityAndTemp.searchAndSelectCity(cityName,driver)) {
            WeatherComparator weatherComparator = new WeatherComparator(cityName, driver);

//            ExtractUIData extractUIData = new ExtractUIData(cityName,driver);
//            ExtractAPIData extractAPIData = new ExtractAPIData(cityName);
//
//            uiTemp = extractUIData.getTempValue();
//            uiHumidity = extractUIData.getHumidity();
//
//            apiHumidity = extractAPIData.getHumidityValue();
//            apiTemp = extractAPIData.getTempValue();

            weatherComparator.compareTemperature();
            weatherComparator.compareHumidity();
        }
        else {
            System.out.println("City not validated");
        }

        driver.quit();
    }

}
