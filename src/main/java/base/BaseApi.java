package base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utils.PropertyHelper;

public class BaseApi {

    public RequestSpecification getRequestSpecification(){
        return RestAssured.given().filter(new AllureRestAssured());
    }

    public static String combineUrl(String urlPart){
        return String.format("%s%s", PropertyHelper.getBaseUrl(),urlPart);
    }
}
