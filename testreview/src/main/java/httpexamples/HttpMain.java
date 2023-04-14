package httpexamples;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpMain {


    public static void main(String[] args) {

        HttpClient client = HttpClients.createDefault();

        HttpGet get = new HttpGet("https://TrackEnsure.com");
        HttpResponse response;

        try {
            response = client.execute(get);
            String body = EntityUtils.toString(response.getEntity());
            System.out.println(body);
        } catch (IOException e) {
           e.getStackTrace();
        }

        HttpPost post = new HttpPost("https://TrackEnsure.com");
        post.setHeader("", "");
        try {
            response = client.execute(post);
            String body = EntityUtils.toString(response.getEntity());
            System.out.println(body);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
