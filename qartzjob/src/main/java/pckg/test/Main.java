package pckg.test;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.*;
import org.apache.hc.client5.http.protocol.HttpClientContext;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicResponseBuilder;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().getEntity("", "", false, null));
    }

    private String getEntity(String logPrefix, String endpoint, boolean post, Object body) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpUriRequest request = new HttpGet("https://eko-stg.lotto-hub.club/api/ping");
//            if (token != null && token.getKey() != null) {
//                if (System.currentTimeMillis() > tokenCreatedTime + ttl * 1000L) {
//                    updateToken();
//                }
                request.addHeader("X-API-Key", "fm1782aio4n1");
//            }
            return client.execute(request, new BasicHttpClientResponseHandler());
//            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            return null;
        }
    }
}
