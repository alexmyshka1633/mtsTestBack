import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class Get {
    @Test
    public void testGetTariffs() {
        // Установка базового URL
        RestAssured.baseURI = "http://localhost:8080";

        // Отправка GET-запроса на endpoint /loan-service/getTariffs
        Response response = RestAssured.get("/loan-service/getTariffs");

        // Проверка статус-кода ответа
        Assert.assertEquals(200, response.getStatusCode());

        // Проверка тела ответа
        Map<String, Object> responseBody = response.jsonPath().getMap("data");
        Assert.assertNotNull(responseBody);

        List<Map<String, Object>> tariffs = (List<Map<String, Object>>) responseBody.get("tariffs");
        Assert.assertNotNull(tariffs);
        Assert.assertFalse(tariffs.isEmpty());

        // Пример проверки тарифов
        for (Map<String, Object> tariff : tariffs) {
            int id = (int) tariff.get("id");
            String type = (String) tariff.get("type");
            String interestRate = (String) tariff.get("interest_rate");

            // Дополнительные проверки, если необходимо
            // ...

            System.out.println("Tariff ID: " + id);
            System.out.println("Tariff Type: " + type);
            System.out.println("Tariff Interest Rate: " + interestRate);
        }
    }
}
