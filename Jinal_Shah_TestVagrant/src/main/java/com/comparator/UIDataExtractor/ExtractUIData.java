package com.comparator.UIDataExtractor;

import com.comparator.SecondaryRunner;
import com.comparator.Util.GetWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtractUIData extends SecondaryRunner {

    String cityName;

    SecondaryRunner secRunner = new SecondaryRunner();

    public ExtractUIData(String cityName) {
        super();
        this.cityName = cityName;
    }

    public Float getTempValue (){
        System.out.println("cityname: " + cityName);
        WebElement tempValueElement = secRunner.driver.findElement(By.xpath("//span[contains(text()," + "Ajmer" + ")]/following::span//b[contains(text(),'Temp in Degrees:')]"));
        String tempInDegrees = tempValueElement.getText();

        String tempNumber = tempInDegrees.replaceAll("[^0-9]", "");

        Float uiTemp = Float.parseFloat(tempNumber);
        System.out.println("uITemp: " + uiTemp);
        return uiTemp;
    }

    public Float getHumidity (){
        WebElement humidityValueElement = secRunner.driver.findElement(By.xpath("//span[contains(text()," + cityName + ")]/following::span//b[contains(text(),'Humidity: ')]"));
        String uiHumidityString1 = humidityValueElement.getText();
        String uiHUmidityString2 = uiHumidityString1.replaceAll("[^0-9]", "");
        Float uiHumidity = Float.parseFloat(uiHUmidityString2);
        System.out.println("uiHumidity: " + uiHumidity);
        return uiHumidity;
    }
}
