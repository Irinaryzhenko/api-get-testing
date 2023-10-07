package api;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;


public class BodyContentTest {
        @Test
        public void checkBodyContent() throws IOException, ParseException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://api.reverb.com/api/articles");
        CloseableHttpResponse response = httpClient.execute(httpGet);

        int statusCode = response.getCode();
        Assertions.assertEquals(200, statusCode);

        String responseBody = EntityUtils.toString(response.getEntity());
        Assertions.assertTrue(responseBody.contains("\"author_name\":\"Tony Bacon\""),
                "В теле ответа должен быть экземпляр с параметрами author_name = 'Tony Bacon'");
            response.close();
            httpClient.close();
    }
}


