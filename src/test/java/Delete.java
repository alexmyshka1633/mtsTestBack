import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class Delete
{

    @Test
    public void testDeleteOrder() {
        RestAssured.baseURI = "http://localhost:8080";

        long userId = 120356894755L;
        String orderId = "37f38d66-6c55-43b5-b981-0f9fd0b448d7";

        String requestBody = String.format("{\"userId\": %d, \"orderId\": \"%s\"}", userId, orderId);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .delete("/loan-service/deleteOrder");

        Assert.assertEquals(403, response.getStatusCode());
    }
}