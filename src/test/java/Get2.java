import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class Get2 {
    @Test
    public void testGetOrderStatus() {
        RestAssured.baseURI = "http://localhost:8080";

        String orderId = "37f38d66-6c55-43b5-b981-0f9fd0b448d7";

        Response response = RestAssured.get("/loan-service/getStatusOrder?orderId=" + orderId);

        Assert.assertEquals(200, response.getStatusCode());

        String orderStatus = response.jsonPath().getString("data.orderStatus");
        Assert.assertNotNull(orderStatus);
        Assert.assertEquals("IN_PROGRESS", orderStatus);
    }

}
