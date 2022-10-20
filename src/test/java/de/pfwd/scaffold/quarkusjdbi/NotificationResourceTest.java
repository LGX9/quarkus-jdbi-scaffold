package de.pfwd.scaffold.quarkusjdbi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class NotificationResourceTest {

    @Test
    public void testNotificationsEndpoint() {
        given().when().get("/notifications").then().statusCode(200).body(is("[]"));
    }
}
