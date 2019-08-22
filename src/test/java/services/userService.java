package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class userService {
     public RequestSpecification login(){
         // build request spec
         RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
         RequestSpecification requestSpec = requestSpecBuilder.build();
         return requestSpec;
    }
}

