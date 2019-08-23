
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import services.envConfigService;
import services.userService;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.fail;

public class userServiceTest {

    private userService userService;
    private static String LOGIN_ENDPOINT = "/api/v1/signIn";

    /**
     * 1. load user profile
     * 2. check server connection
     * 3. set baseUrl
     */
    @Before
    public void before() {
        envConfigService envConfigService = new envConfigService();
        envConfigService.loadEnvProperties();
        if (envConfigService.checkConnection() != 200) {
            fail("server host connection failed ...");
        }
        RestAssured.baseURI = System.getProperty("protocol") + "://" + System.getProperty("host");
    }

    /**
     * 1. send user login request
     * 2. verify response 200
     */
    @Test
    public void check_login_success() {
        // load user profile from env
        userService = new userService();
        userService.loadUserProfile();

        // build login request spec
        RequestSpecification loginRequest = userService.login();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();

        // build login response spec
        responseSpecBuilder.expectStatusCode(200);
        ResponseSpecification responseSpec = responseSpecBuilder.build();

        // send login request to verify response
        given().log().all().spec(loginRequest).when().get(LOGIN_ENDPOINT).then().log().all().spec(responseSpec);
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
