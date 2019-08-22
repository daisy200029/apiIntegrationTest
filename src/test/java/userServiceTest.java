
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;
import org.junit.Test;
import services.envConfigService;
import services.userService;

import static io.restassured.RestAssured.given;

public class userServiceTest {

    @Before
    public void before() {
        envConfigService envConfigService=new envConfigService();
        envConfigService.loadEnvProperties();
        RestAssured.baseURI = System.getProperty("protocol")+ "://"+ System.getProperty("host");

    }

    @Test
    public void  check_login_success() {
        String loginEndPoint= "/api/v1/signIn";
        // load login request
        RequestSpecification loginRequest = new userService().login();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        // verify response
        responseSpecBuilder.expectStatusCode(200);
        ResponseSpecification responseSpec = responseSpecBuilder.build();
        // send newspoint request
        given().log().all().spec(loginRequest).when().get(loginEndPoint).then().log().all().spec(responseSpec);
    }
    /*
       @Test
       public void logoutTest(){}
     */
    /*
       @Test
       public void delete(){}
     */

}
