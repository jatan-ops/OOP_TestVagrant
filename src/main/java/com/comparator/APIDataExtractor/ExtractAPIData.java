package com.comparator.APIDataExtractor;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ExtractAPIData {

    String cityName;

    public ExtractAPIData(String cityName) {
        this.cityName = cityName;
    }

    private Response queryParameter() {

        RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
        RequestSpecification request = given();

        Response response = request.queryParam("q", cityName)
                .queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").get("/weather");

        return response;
    }

    public Float getTempValue() {
        float tempKValue = queryParameter().jsonPath().getFloat("main.temp");
        float KELVIN_TO_CELSIUS = 273.15F;
        float tempValue = tempKValue - KELVIN_TO_CELSIUS;
        float tempCValue = Math.round(tempValue*100.0)/100.0F;
        System.out.println("apiTemp: " + tempCValue);
        return tempCValue;
    }

    public Float getHumidityValue() {
        float apiHumidity = queryParameter().jsonPath().getFloat("main.humidity");
        System.out.println("apiHumidity: " + apiHumidity);
        return apiHumidity;
    }
}
