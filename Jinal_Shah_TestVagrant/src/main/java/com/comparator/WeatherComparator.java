package com.comparator;

import com.comparator.APIDataExtractor_Package.ExtractAPIData;
import com.comparator.UIDataExtractor.ExtractUIData;
import com.comparator.Util.DataReader;
import org.openqa.selenium.WebDriver;

import static java.lang.Math.abs;

public class WeatherComparator {

    private final int PERCENT = 100;
    private DataReader dataReader = new DataReader();
    private String cityName;
    private WebDriver driver;
    private Float uiTemp, uiHumidity, apiTemp, apiHumidity;


    public WeatherComparator(String cityName, WebDriver driver) {
        this.cityName = cityName;
        this.driver = driver;
    }

    ExtractUIData extractUIData = new ExtractUIData(cityName);
    ExtractAPIData extractAPIData = new ExtractAPIData(cityName);

    public void compareTemperature(){
        uiTemp = extractUIData.getTempValue();
        apiTemp = extractAPIData.getTempValue();

        float tempVariance = dataReader.getTempVariance();

        if(abs(uiTemp - apiTemp) <= tempVariance)
            System.out.println("Temperature matches");
        else
            System.out.println("Temperature doesn't match");
    }

    public void compareHumidity(){

        uiHumidity = extractUIData.getHumidity();
        apiHumidity = extractAPIData.getHumidityValue();

        float humidityVariance = dataReader.getHumidityVariance();

        if ((abs(uiHumidity - apiHumidity)) / PERCENT <= humidityVariance /PERCENT)
            System.out.println("Humidity matches");
        else
            System.out.println("Humidity doesn't match");

    }
}
