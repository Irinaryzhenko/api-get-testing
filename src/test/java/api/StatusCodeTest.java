package api;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;
import org.junit.jupiter.api.Test;
import java.io.IOException;


public class StatusCodeTest {
    @Test
    public void checkStatusCode() throws IOException {

        CloseableHttpClient httpclient = null;
        try {
            httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet("https://api.reverb.com/api/articles");
            HttpResponse httpresponse = httpclient.execute(httpget);

            System.out.println(httpresponse.getCode());
        } finally {
            httpclient.close();
            httpclient.close();
        }
    }
}
