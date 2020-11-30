package com.comparator;

import com.comparator.APIDataExtractor_Package.ExtractAPIData;
import com.comparator.UIDataExtractor.ExtractUIData;
import com.comparator.Util.DataReader;
import org.openqa.selenium.WebDriver;

import static java.lang.Math.abs;

public class WeatherComparator {

    private final ExtractUIData extractUIData;
    private APIDataExtractor extractAPIData;
    DataReader dataReader = new DataReader();

    public WeatherComparator(String cityName, WebDriver driver, APIDataExtractor extractAPIData) {
        extractUIData = new ExtractUIData(cityName,driver);
        this.extractAPIData = extractAPIData;
    }

    public void compareTemperature(){
        Float uiTemp = extractUIData.getTempValue();
        Float apiTemp = extractAPIData.getTempValue();

        float tempVariance = dataReader.getTempVariance();

        if(abs(uiTemp - apiTemp) <= tempVariance)
            System.out.println("Temperature matches");
        else
            System.out.println("Temperature doesn't match");
    }

    public void compareHumidity(){

        Float uiHumidity = extractUIData.getHumidity();
        Float apiHumidity = extractAPIData.getHumidityValue();

        float humidityVariance = dataReader.getHumidityVariance();

        int PERCENT = 100;
        if ((abs(uiHumidity - apiHumidity)) / PERCENT <= humidityVariance / PERCENT)
            System.out.println("Humidity matches");
        else
            System.out.println("Humidity doesn't match");

    }
}
