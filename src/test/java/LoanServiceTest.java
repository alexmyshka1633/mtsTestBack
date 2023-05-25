import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class LoanServiceTest {

    @Test
    public void testSubmitLoanApplication() {
        // Установка базового URL
        RestAssured.baseURI = "http://localhost:8080";

        // Параметры запроса
        long userId = 120356894755L;
        int tariffId = 1;

        // Создание тела запроса в формате JSON
        String requestBody = String.format("{\"userId\": %d, \"tariffId\": %d}", userId, tariffId);

        // Отправка запроса POST на endpoint /loan-service/order
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/loan-service/order");

        // Проверка статус-кода ответа
        Assert.assertEquals(200, response.getStatusCode());

        // Проверка тела ответа
        String orderId = response.jsonPath().getString("data.orderId");
        Assert.assertNotNull(orderId);
    }
}
