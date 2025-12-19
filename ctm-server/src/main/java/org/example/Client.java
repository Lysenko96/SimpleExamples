package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;

public class Client {

    private ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        Client client = new Client();
        client.executeRequest("test", null);
    }

    private Parameters executeRequest(String endpoint, Object body) {
        Parameters params = new Parameters();
        try {
            String result = getEntity(params, endpoint, body);
            if (!params.isOk()) {
                return params;
            }
            System.out.println("################# RESULT: " + result);

//            MessageDto content = mapper.readValue(result, MessageDto.class);
//            params.setMsg(content.getMsg());
//            params.setUnsupported(content.isUnsupported());
//            params.setOk(content.isOk());
//            for (Object param : content.getParameters().keySet()) {
//                params.put(param, content.getParameters().get(param));
//            }
            System.out.println("################# CONTENT: " + params);
//            if (!(boolean) params.isOk()) {
//                System.out.println(endpoint + " content failed: " + content);
//                return params.setError(false, result);
//            }
        } catch (Exception e) {
            System.out.println(endpoint + " getResponse error: " + e);
            params.setError(false, e.getMessage());
        }
        return params;
    }

    private String getEntity(Parameters params, String endpoint, Object body) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost request = getHttpRequest(endpoint, body);
            System.out.println("###REQUSET: " + request);
            String response = client.execute(request, new BasicHttpClientResponseHandler());
            System.out.println("##RESP: " + response);
            return EntityUtils.toString(new StringEntity(response));
        } catch (IOException | ParseException e) {
            System.out.println(endpoint + " getResponse error: " + e);
            return null;
        }
    }

    private HttpPost getHttpRequest(String endpoint, Object body) throws JsonProcessingException {
        String url = "http://127.0.0.1:8080/" + endpoint;
        System.out.println("################# URL CTM: " + url);
        HttpPost request = new HttpPost(url);
        if (body != null) {
            System.out.println("################# BODY CTM: " + body);
            String src = mapper.writeValueAsString(body);
            System.out.println("################# BODY SRC: " + src);
            request.setEntity(new StringEntity(src, ContentType.APPLICATION_JSON));
        }
        return request;
    }
}
