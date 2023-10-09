package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.Utilities;
import java.io.IOException;

public class JsonTest {
    @Test
    public void get200() throws IOException, ParseException {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpGet);
        String body = EntityUtils.toString(response.getEntity());
        System.out.println(body);
        JsonObject jsonObject = new JsonParser().parse(body).getAsJsonObject();
        Assertions.assertEquals(1, jsonObject.get("userId").getAsInt());
        Assertions.assertEquals(1, jsonObject.get("id").getAsInt());
        Assertions.assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", jsonObject.get("title").getAsString());
        Assertions.assertEquals("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto", jsonObject.get("body").getAsString());

    }

}
